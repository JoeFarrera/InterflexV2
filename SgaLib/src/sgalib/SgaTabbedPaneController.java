package sgalib;

/*
 * TabbedPaneController.java is used by the 1.4 
 * DragFileDemo.java example.
 */
import java.awt.*;
import java.awt.event.*;

import java.lang.reflect.Method;

import java.net.URL;
import java.util.Hashtable;

import javax.swing.*;
import oracle.jbo.uicli.controls.JUPanel;
import org.apache.log4j.Logger;

/**
 * Classe que monitoritza l'area on es mostren els tabs corresponents a cada 
 * panel de l'usuari. Quan no hi ha tabs, es mostra una imatge de logo 
 * corporatiu. Tant aviat com s'arranca un panel, un JTabbedPane s'afegeix a la
 * finestra i cada panel s'afegeix sota un tab diferent.
 * Quan no queden panels a la pantalla, s'elimina el JTabbedPane i es torna a 
 * mostra la imatge corporativa.
 * 
 * @author Xavier Marfull
 * @version 1.00
 */

public class SgaTabbedPaneController implements ActionListener 
{
    static Logger LOG = Logger.getLogger("SgaTabbedPaneController"); 
    //Hash associat a les finestres obertes
    private final Hashtable mWins = new Hashtable(20);
    private String selectedTabName;
    
    SgaMainFrameInterface mainFrameInterface = null;
    JDesktopPane tabbedPanel = null;
    JTabbedPane tabbedPane;
    JPanel emptyFilePanel = null;
    JTextArea emptyFileArea = null;
    // Label que conté l'imatge de fondo de pantalla
    private JLabel fondoLabel = null;

    //FileAndTextTransferHandler transferHandler;
    boolean noTabs = true;
    String fileSeparator;

    public SgaTabbedPaneController()
    {
      
    }
    public SgaTabbedPaneController(SgaMainFrameInterface mainFrameIf, JTabbedPane tb, JDesktopPane tp) {
        mainFrameInterface = mainFrameIf;
        tabbedPane = tb;
        tabbedPanel = tp;
        jbInit();
    }

    public void createPopupMenu() {
        JMenuItem menuItem;

        //Create the popup menu.
        JPopupMenu popup = new JPopupMenu();
        menuItem = new JMenuItem(SgaRecursos.getInstance().getString("SgaTabbedPaneController.mostrarFinestra_label"));
        menuItem.addActionListener(this);
        popup.add(menuItem);
        
        popup.addSeparator();

        menuItem = new JMenuItem(SgaRecursos.getInstance().getString("SgaTabbedPaneController.tancar_label"));
        menuItem.addActionListener(this);
        popup.add(menuItem);

        menuItem = new JMenuItem(SgaRecursos.getInstance().getString("SgaTabbedPaneController.tancarTotes_label"));
        menuItem.addActionListener(this);
        popup.add(menuItem);
        
        popup.addSeparator();

        menuItem = new JMenuItem(SgaRecursos.getInstance().getString("SgaTabbedPaneController.ajuda_label"));
        menuItem.addActionListener(this);
        popup.add(menuItem);

        menuItem = new JMenuItem(SgaRecursos.getInstance().getString("SgaTabbedPaneController.info_label"));
        menuItem.addActionListener(this);
        popup.add(menuItem);

        //Add listener to the text area so the popup menu can come up.
        MouseListener popupListener = new SgaPopupListener(popup);
        tabbedPane.addMouseListener(popupListener);
    }
    
    public void actionPerformed(ActionEvent e) {
    
        JMenuItem source = (JMenuItem)(e.getSource());        
        if (source.getText().equals(SgaRecursos.getInstance().getString("SgaTabbedPaneController.tancar_label")))
          removeTab(tabbedPane.getSelectedIndex());
        else if (source.getText().equals(SgaRecursos.getInstance().getString("SgaTabbedPaneController.tancarTotes_label")))
        {
          int tabCount = tabbedPane.getTabCount();
          for (int i = tabCount-1; i >= 0; i--)
            removeTab(i);
        }
        else if (source.getText().equals(SgaRecursos.getInstance().getString("SgaTabbedPaneController.ajuda_label")))
        {
          SgaJScrollPane scrollPane = (SgaJScrollPane)tabbedPane.getSelectedComponent();
          String topicId = scrollPane.getTopicId();
          mainFrameInterface.showHelpWindow(topicId);
          
        }
        else if (source.getText().equals(SgaRecursos.getInstance().getString("SgaTabbedPaneController.info_label")))
        {
          showPanelName();
        }
        else
          displayInWindow((SgaJScrollPane)tabbedPane.getSelectedComponent());
    }
    
  /**
   * Mostrar el nombre del panel asociado con el tab
   * Va desde: SgaJScrollPane->JViewport->JPanel
   */
  private void showPanelName()
  {
      SgaJScrollPane scrollPane = (SgaJScrollPane)tabbedPane.getSelectedComponent();
      String panelName = null;
      for (int i = 0; i < scrollPane.getComponentCount(); i++)
      {
        Component comp = scrollPane.getComponent(i);
        if (comp instanceof JViewport)
        {
          JViewport vp = (JViewport)comp;
          for (int j = 0; j < vp.getComponentCount(); j++) 
          {
            Component compvp = vp.getComponent(i);
            if (compvp instanceof JPanel)
            {
              panelName = compvp.toString();
            }
          }
          break;
        }
      }
      JTextField panelText = new JTextField(SgaRecursos.getInstance().getString("InfoPanel.missatge") + " " + panelName);
      panelText.setEnabled(true);
      panelText.setEditable(false);
      JOptionPane.showMessageDialog(mainFrameInterface.getFrame(), 
      // SgaRecursos.getInstance().getString("InfoPanel.missatge") + " " + panelName, 
      panelText,
      SgaRecursos.getInstance().getString("InfoPanel.title"), JOptionPane.INFORMATION_MESSAGE);
  }

   
    /**
     * Afegeix una pestanya nova al tabbedPane, partint de la informació que 
     * rep com a parametre
     * 
     * @param menu Conte el nom de la pestanya, el nom del panel, la icona i el 
     *              tooltip a mostrar.
     */
     
    public void addMenuTab(SgaMenuInfo menu) 
    {
      boolean tabExist = false;

        if (noTabs) 
        {
            tabbedPanel.remove(emptyFilePanel);
            tabbedPanel.add(tabbedPane, BorderLayout.CENTER);
            noTabs = false;
        }
        
        if (getTab(menu.nomMenu) == null)          
        {
            try
            {
              //Possem el cursor en mode d'espera              
              Cursor normalCursor = new Cursor(Cursor.WAIT_CURSOR);
              mainFrameInterface.setCursor(normalCursor);              
              Method runPanel = null;
              //URL url = ClassLoader.getSystemResource(menu.panel);
              // Primer, mirem si existeix un mètode amb el nom runPanel a la classe
              // Això es així per que hi ha cops en que interessa executar un runPanel
              // especific per una classe concreta, que fa coses diferents
              Method method[] = Class.forName(menu.panel).getDeclaredMethods();
              JPanel panel = null;
              for(int i= 0; i< method.length; i++)
              {
                if (method[i].getName().equals("runPanel"))
                  runPanel = method[i];
              }
              // Si l'ha trobat, l'invoquem
              if (runPanel != null)
              {
                runPanel.setAccessible(true);
                // JPanel panel = (JPanel)runPanel.invoke(null, null);
                panel = (JPanel)runPanel.invoke(null, null);
              }
              else // Si no l'ha trobat, instanciem
              {
                // Michael 04.04.2005 :TODO - instantiate here from panel constructor...
                Class panelClass = Class.forName(menu.panel);
                Object ob = panelClass.newInstance();
                SgaJUPanel sgaJUPanel = null;
                if (ob instanceof SgaJUPanel)
                {
                  sgaJUPanel = (SgaJUPanel)ob;
                  SgaRunPanel _runPanel = null;
                  _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", (JPanel)sgaJUPanel, sgaJUPanel.getPanelBinding(), new Dimension(400, 300));
                  sgaJUPanel.setBindingContext(_runPanel.getBindingContext());
                  sgaJUPanel.revalidate();
                  //panel = (JPanel)sgaJUPanel;
                  panel = (JPanel)_runPanel;
                }
              }
              
/*              // Michael 04.04.2005 :TODO - instantiate here from panel constructor...
              Class panelClass = Class.forName(menu.panel);
              Object ob = panelClass.newInstance();
              SgaJUPanel sgaJUPanel = null;
              JPanel panel = null;
              if (ob instanceof SgaJUPanel)
              {
                System.out.println("its a SgaPanel");
                sgaJUPanel = (SgaJUPanel)ob;
                SgaRunPanel _runPanel = null;
                _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", (JPanel)sgaJUPanel, sgaJUPanel.getPanelBinding(), new Dimension(400, 300));
                sgaJUPanel.setBindingContext(_runPanel.getBindingContext());
                sgaJUPanel.revalidate();
                panel = (JPanel)sgaJUPanel;
              }
              else
              {
                //String str = url.toString();
                //Method method[] = Class.forName(str).getDeclaredMethods();
                for(int i= 0; i< method.length; i++)
                {
                  if (method[i].getName().equals("runPanel"))
                    runPanel = method[i];
                }
                if (runPanel != null)
                {
                  runPanel.setAccessible(true);
                  // JPanel panel = (JPanel)runPanel.invoke(null, null);
                  panel = (JPanel)runPanel.invoke(null, null);
                }
              }*/
               if (panel != null)
                {
                  SgaJScrollPane scrollPane = new SgaJScrollPane(panel, menu.topicId);
                  addTab(scrollPane, menu.nomMenu, menu.menuIcon, menu.tooltip);
                }
                else
                {
                  if (noTabs == false && tabbedPane.getTabCount() == 0)
                  {
                    tabbedPanel.remove(tabbedPane);
                    jbInit();
                  }
                }
            // Michael  }
              
            }
            catch(Exception ex)
            {
              LOG.error("Error al crear " + menu.panel, ex);
              JOptionPane.showMessageDialog(mainFrameInterface.getFrame(), 
              SgaRecursos.getInstance().getString("ErrorPanel.missatge") + " " + menu.panel, 
              SgaRecursos.getInstance().getString("ErrorPanel.title"), JOptionPane.ERROR_MESSAGE);
              if (noTabs == false && tabbedPane.getTabCount() == 0)
              {
                tabbedPanel.remove(tabbedPane);
                jbInit();
              }
            }
            finally
            {
              //Possem el cursor en mode d'espera
              Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
              mainFrameInterface.setCursor(normalCursor);
            }
        }
        else        
          showTab(menu.nomMenu);
    }
    

    /**
     * Indica si existeix un tab o un frame corresponent a l'opció de menú
     * @param name Nom del menu
     */
     
     public SgaJScrollPane getTab(String name)
     {
        SgaJScrollPane scrollPane = null;
        if (name == null)
         return null;
  
        int index = tabbedPane.indexOfTab(name);
        if (index == -1)
        {
           MenuFrame frame = (MenuFrame)mWins.get(name);
           if (frame != null)
           {
              scrollPane =  frame.mScrollPane;
           }
        }
        else
        {
           scrollPane = (SgaJScrollPane)tabbedPane.getComponentAt(index);
        }
  
        return scrollPane;
     }


  /**
   * Afegeix un scroll panel a una pestanya
   * @param scrollPane panel a afegir
   * @param name Nom del panel
   */
   
   public void addTab(SgaJScrollPane scrollPane, String tabName, ImageIcon tabIcon, String tabTooltip)
   {
      tabbedPane.addTab(tabName, tabIcon, (Component)scrollPane, tabTooltip);
      showTab(tabName);
      //tabbedPane.setSelectedComponent((Component)scrollPane);
     
   }
   
  /**
   * Mostra el tab o el frame corresponent al menú
   * @param name Nom del menú
   */

   public void showTab(String name)
   {
      int index = tabbedPane.indexOfTab(name);
      if (index != -1)
      {
         tabbedPane.setSelectedIndex(index);
      }
      else
      {
         JDialog dispFrame = (JDialog) mWins.get(name);
         if (dispFrame != null)
         {
            dispFrame.toFront();
         }
      }
   }

  /**
   * Elimina el tab seleccionat i en mostra el contingut dins d'una finestra
   * @param scrollPane a mostrar en la finestra
   */

   public void displayInWindow(SgaJScrollPane scrollPane)
   {
      int index = tabbedPane.indexOfComponent(scrollPane);

      if (index == -1)
      {
         return;
      }

      String title = tabbedPane.getTitleAt(index);
      ImageIcon icon = (ImageIcon)tabbedPane.getIconAt(index);
      String tooltip = tabbedPane.getToolTipTextAt(index);
      removeTab(index, false);

      MenuFrame frame = new MenuFrame(this, scrollPane, title, icon, tooltip);
      mWins.put(title, frame);

      //frame.getContentPane().add(scrollPane.getComponent(0), BorderLayout.NORTH);
      //frame.getContentPane().add(scrollPane.getComponent(0), BorderLayout.CENTER);      
      frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
      
      try
      {
        frame.setLocationRelativeTo(mainFrameInterface.getFrame());
        frame.pack();
        frame.setVisible(true);
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
   }

  /**
   * Reemplaça un frame amb un tab
   * @param frame
   */
  
   public void replaceTab(MenuFrame frame)
   {
      boolean tabExist = false;
        if (noTabs) {
            tabbedPanel.remove(emptyFilePanel);
            tabbedPanel.add(tabbedPane, BorderLayout.CENTER);
            noTabs = false;
        }

      SgaJScrollPane scrollPane = frame.mScrollPane;

      //scrollPane.add(frame.getContentPane().getComponent(0), BorderLayout.NORTH);
      //scrollPane.add(frame.getContentPane().getComponent(0), BorderLayout.CENTER);

      addTab(scrollPane, frame.getTitle(), frame.mIcon, frame.mTooltip );
      //addTab((JScrollPane)frame.getContentPane().getComponent(0), frame.getTitle(), frame.mIcon, frame.mTooltip );
      mWins.remove(frame.getTitle());
   }


   void tabIsSelected(String tabName)
   {
      selectedTabName = tabName;
      //fireStateChange();
   }
     
    //Remove all tabs and their components, then put the default
    //file area back.
    public void clearAll() {
        if (noTabs == false) {
            tabbedPane.removeAll();
            tabbedPanel.remove(tabbedPane);
        }
        jbInit();
    }

    /**
     * Elimina una pestanya del TabbedPane
     */
    public void removeTab(int index, boolean closePanel) {
        if (noTabs == false) 
          {
            SgaJScrollPane scrollPane = (SgaJScrollPane)tabbedPane.getComponentAt(index);
            SgaRunPanel runPanel = (SgaRunPanel)scrollPane.getViewport().getComponent(0);
            // Elimina les referencies a la variable estatica runPanel
            if (closePanel)
              runPanel.closePanel();
            
            tabbedPane.removeTabAt(index);
            if (tabbedPane.getTabCount() == 0)
            {
              tabbedPanel.remove(tabbedPane);
              jbInit();
            }
          }
    }

    /**
     * Elimina una pestanya del TabbedPane
     */
    public void removeTab(int index) {
      removeTab(index, true);
    }

    private void jbInit() {
        noTabs = true;
        if (emptyFilePanel == null) {
            // Assignnem la imatge del fondo del desktop
            fondoLabel = new JLabel(SgaRecursos.createImageIcon(getClass(),"fondo.jpg", null));
            
            JScrollPane fileScrollPane = new JScrollPane(fondoLabel);
            emptyFilePanel = new JPanel(new BorderLayout(), false);
            emptyFilePanel.add(fileScrollPane, BorderLayout.CENTER);
            fileScrollPane.setBackground(Color.PINK);
        }
        createPopupMenu();
        tabbedPanel.add(emptyFilePanel, BorderLayout.CENTER);
        tabbedPanel.repaint();
        //emptyFileArea.setText(defaultText);
        //emptyFileArea.add(fondoLabel);
    }

   
    

// TODO: Veure si es possible incloure la icona
final class MenuFrame extends JDialog
{
   SgaTabbedPaneController mTpc = null;
   SgaJScrollPane       mScrollPane = null;
   ImageIcon mIcon = null;
   String mTooltip = null;

   MenuFrame(SgaTabbedPaneController tpc, SgaJScrollPane scrollPane, 
              String title, ImageIcon icon, String tooltip)
   {
      super(mainFrameInterface.getFrame(), title);

      mTpc = tpc;
      mScrollPane = scrollPane;
      mIcon = icon;
      mTooltip = tooltip;
      

      addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            mTpc.replaceTab(MenuFrame.this);
         }

         public void windowActivated(WindowEvent e)
         {
            mTpc.tabIsSelected(getTitle());
         }
      });
   }
}    
}
