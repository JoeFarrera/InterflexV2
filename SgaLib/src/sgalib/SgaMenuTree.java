package sgalib;

import es.sysmap.xml.XMLHelper;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import org.apache.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sgalib.SgaRecursos;


/**
 * Aquesta classe implementa l'acces al fitxer XML amb la descripci� del men�
 * aix� com la construcci� de l'arbre de menus.
 */
public class SgaMenuTree extends JScrollPane 
{
  private SgaSecurityInterface security;

  static Logger LOG = Logger.getLogger("SgaMenuTree");
  
  static String MENUTREE_FILE = "MenuTree.xml";
  // Panel binding definition used by design time
  private JTree jTree = null;
  private SgaTabbedPaneController tpc = null;
  

  public SgaMenuTree(SgaTabbedPaneController tpc, SgaSecurityInterface security)
  {
    this.tpc = tpc;
    this.security = security;
    
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      LOG.error("Error a l'instanciar SgaMenuTree", e);
    }

  }


  public SgaMenuTree(SgaTabbedPaneController tpc)
  {
    this.tpc = tpc;
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      LOG.error("Error a l'instanciar SgaMenuTree", e);
    }

  }

  private void jbInit() throws Exception
  {
    //Create the nodes.
    DefaultMutableTreeNode top = new DefaultMutableTreeNode("Men� d' Usuari");
    String xmlUserPath = null;
    URL url = null;
    try
    {
      try
      {
        //Primer busquem al directori de l'usuari
        xmlUserPath = SgaUtilPuesto.getXMLRoot();
        if(xmlUserPath != null)
        { 
          xmlUserPath = "file:/"+ xmlUserPath + "\\" + MENUTREE_FILE;
          url = new URL(xmlUserPath);
          //Nomes per comprobar que existeix el fitxer
          url.openStream();
          LOG.debug("Utilitzant MenuTree del client");
        }
      }
      catch(IOException ex)
      {
          LOG.debug("Utilitzant MenuTree generic");
          // Si no el troba, busquem el menutree gen�ric
          xmlUserPath = "resources/XML/" + MENUTREE_FILE;
          url = ClassLoader.getSystemResource(xmlUserPath);          
      }
    
      Document xmldoc = XMLHelper.parse(url);
      Element root = xmldoc.getDocumentElement();
      String topText = root.getAttribute("nomMenu");
      if (topText != null)
      {
        top.setUserObject(topText);
      }
      NodeList nodes = root.getChildNodes();

      assert (nodes.getLength() > 0);
        
      createNodes(nodes, top);
    }
    catch(Exception ex)
    {
      LOG.error("Error al construir menu", ex); 
    }
    jTree = new JTree(top);
    jTree.setToggleClickCount(5);

    this.getViewport().add(jTree, null);
    jTree.getSelectionModel().setSelectionMode
            (TreeSelectionModel.SINGLE_TREE_SELECTION);
    jTree.addMouseListener(new TreeMouseListener());    
    jTree.setCellRenderer(new MyRenderer());
    //Enable tool tips.
    ToolTipManager.sharedInstance().registerComponent(jTree);


  }

   private void processTreeMouseClicked(MouseEvent e)
   {
      // Double click only
      if (e.getClickCount() == 1)
      {
         return;
      }
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           jTree.getLastSelectedPathComponent();
                           
        if (node == null) return;
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf() && nodeInfo instanceof SgaMenuInfo) 
        {
            SgaMenuInfo menu = (SgaMenuInfo)nodeInfo;
            tpc.addMenuTab(menu);
        }
   }

    /**
     * Crea els nodes corresponents a l'arbre de men� d'usuari
     * 
     * TODO: Fer que sigui din�mic, agafant els men�s que te cada usuari
     * d'una taula
     */
    private void createNodes(NodeList nodes, DefaultMutableTreeNode top) 
    {
        for (int i = 0; i < nodes.getLength(); i++)
        {
          Node node = nodes.item(i);
          switch (node.getNodeType())
          {
            case Node.ELEMENT_NODE:
              // Michael 16.09.2005 S�lo si tiene acceso al nodo el usuario
              NamedNodeMap nodeMap = node.getAttributes();
              if (hasAcceso(nodeMap))
              {

              String name = node.getNodeName();
              if (name.equals("Seccio"))
              {
                //Obrim una nova branca
                DefaultMutableTreeNode branca = crearBranca(node.getAttributes());
                top.add(branca);
                NodeList children = node.getChildNodes();
                assert(children.getLength() > 0);
                createNodes(children, branca);
                
                //insertAttribute(bytes, node);
              }
              else if(name.equals("Item"))
              {
                //Insertem una nova fulla
                DefaultMutableTreeNode fulla = crearFulla(node.getAttributes());
                top.add(fulla);
              }
              }
              break;
          }
        }
   }
    
  /**
   * <code>true</code> si el usuario tiene acceso al role
   * @return 
   * @param nodeMap el nodo del men�
   */
   private boolean hasAcceso(NamedNodeMap nodeMap)
   {
     if (security != null)
     {
       
       Node accesNode = nodeMap.getNamedItem("acces");
       if (accesNode != null)
       {
        String acces = accesNode.getNodeValue();
        return security.hasAcceso(acces);
       }
      else
      {
        // :TODO Si el nodo no tiene nada. tambi�n petar�
        LOG.warn("Acces de usuario no encontrado en el mapa del nodo: " + nodeMap.item(0).getNodeValue());
        return false;
      }
     }
     else
      return true;
   }


  private DefaultMutableTreeNode crearBranca(NamedNodeMap nodeMap)
  {
    String nomMenu;
    String nomIcona;
    String tooltip;
    
    nomMenu = nodeMap.getNamedItem("nomMenu").getNodeValue();
    tooltip = nodeMap.getNamedItem("tooltip").getNodeValue();
    nomIcona = nodeMap.getNamedItem("icona").getNodeValue(); 
    
    DefaultMutableTreeNode branca = new DefaultMutableTreeNode(new SgaMenuInfo
        (nomMenu, nomMenu, nomIcona, 
          tooltip));

    return branca;
  }

  private DefaultMutableTreeNode crearFulla(NamedNodeMap nodeMap)
  {
    String nomMenu;
    String panel;
    String nomIcona;
    String tooltip;
    String topicId;
    
    nomMenu = nodeMap.getNamedItem("nomMenu").getNodeValue();
    tooltip = nodeMap.getNamedItem("tooltip").getNodeValue();
    nomIcona = nodeMap.getNamedItem("icona").getNodeValue(); 
    panel = nodeMap.getNamedItem("panel").getNodeValue(); 
    topicId = nodeMap.getNamedItem("topicId").getNodeValue(); 
    
    
    //Insertem una nova fulla
    DefaultMutableTreeNode fulla = new DefaultMutableTreeNode(new SgaMenuInfo
        (nomMenu, panel, nomIcona, 
          tooltip, topicId));
              
    return fulla;
  }
   
  
  /**
   * Implementa el tractament dels diferents events fets amb el ratol� sobre l'
   * arbre de men�s
   * 
   * TODO: Men�s desplegables sobre l'arbre per afegir a 'Favoritos'
   */
   private final class TreeMouseListener implements MouseListener
   {
      public void mouseClicked(MouseEvent e)
      {
         processTreeMouseClicked(e);
      }

      public void mousePressed(MouseEvent e)
      {
         //checkIsPopupTrigger(e);
      }

      public void mouseReleased(MouseEvent e)
      {
         //checkIsPopupTrigger(e);
      }

      public void mouseEntered(MouseEvent e)
      {
      }

      public void mouseExited(MouseEvent e)
      {
      }
      
      private void checkIsPopupTrigger(MouseEvent e)
      {
      /*
         if (e.isPopupTrigger())
         {
            ObjTreeNode loc = hitTest(e);
            if (loc != null)
            {
               JPopupMenu menu = loc.getMenu();
               if (menu != null)
               {
                  Point p = e.getPoint();
                  TreePath path = tree.getPathForLocation(p.x, p.y);
                  tree.setSelectionPath(path);
                  MenuUtils.showPopupMenu(menu, tree, p.x, p.y);
               }
            }
         }*/
      }
   }
   
   
 

    /**
     * Renderer pels items de l'arbre 
     */
    private class MyRenderer extends DefaultTreeCellRenderer {
        Icon tutorialIcon;

        public MyRenderer() {
        }

        public Component getTreeCellRendererComponent(
                            JTree tree,
                            Object value,
                            boolean sel,
                            boolean expanded,
                            boolean leaf,
                            int row,
                            boolean hasFocus) {

            super.getTreeCellRendererComponent(
                            tree, value, sel,
                            expanded, leaf, row,
                            hasFocus);
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode)value;
            if(node.getUserObject() instanceof SgaMenuInfo)
            {
              SgaMenuInfo nodeInfo = 
                      (SgaMenuInfo)(node.getUserObject());
              if (nodeInfo.menuIcon != null)               
                setIcon(nodeInfo.menuIcon);
              setToolTipText(nodeInfo.tooltip);
            }
            else if (node.isRoot())
            {
              setIcon(SgaRecursos.createImageIcon(getClass(), "mypc.gif", null));
            }
            

            return this;
        }
    }
  
}
