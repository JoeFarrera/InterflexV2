package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgacdocViewRow;
import es.sysmap.interflex.model.dmc.common.SgaexpedViewRow;
import es.sysmap.interflex.view.PackingList;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import java.awt.Dimension;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgaexpedView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaexpedView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaexpedView1

  private SgaJTable tableSgaexpedView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JButton buttonPackingList = new JButton();
  private JButton buttonAfegirExped = new JButton();
  private JPanel buttonsPanel = new JPanel(new FlowLayout());
  
  private PanelSgacdocSortidesView3 panelSortides = null;



  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaexpedView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
  
    
    JButton buttonInsert = navBar.getButton(JUNavigationBar.BUTTON_INSERT);
      ActionListener [] listeners = buttonInsert.getActionListeners();
    for (int i = 0; i < listeners.length; i++)
    {
      buttonInsert.removeActionListener(listeners[i]);
    }
    buttonInsert.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          
          Container container = getParent();
          while (container != null && !(container instanceof JFrame))
            container = container.getParent();
 
          JOptionPane.showConfirmDialog(container, "Per afegir una nova expedició, tria primer el document de sortides, i l'opció "
            + "contextual <Afegir a expedició> [del menú del botó dret]",
            "Afegir una nova expedició",
            JOptionPane.CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE);
          
        }
      });

  
  
  buttonPackingList.setText("Packing List [EXPEDICIÓ]");
    buttonPackingList.setToolTipText("Imprimir Packing List");
    buttonPackingList.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirPackingList();
        }
      });
    
      buttonAfegirExped.setText("(+) Afegir Doc.");
    buttonAfegirExped.setToolTipText("Afegir un document a l'expedició");
    buttonAfegirExped.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          afegirDocExped();
        }
      });
      
   
      
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    dataPanel.setBorder(BorderFactory.createTitledBorder(" [Expedició] "));
    
    this.setLayout(borderLayout);
    this.setSize(new Dimension(448, 200));
    this.setMaximumSize(new Dimension(700, 200));
    this.setPreferredSize(new Dimension(448, 200));
    
    
    // Code support for view object:  SgaexpedView1
    tableSgaexpedView1.setModel((TableModel)panelBinding.bindUIControl("SgaexpedView1", tableSgaexpedView1));
    scroller.getViewport().add(tableSgaexpedView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaexpedView1", null, "SgaexpedView1Iter"));
    // Layout the datapanel and the navigation bar
    // buttonsPanel.add(navBar);
    add (navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    buttonsPanel.add(buttonPackingList);
    buttonsPanel.add(buttonAfegirExped);
    add(buttonsPanel, BorderLayout.SOUTH);
    
  
    
    
    addPopup();


  }
  
   /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
    
      
      tableSgaexpedView1.addPopupSeparator();
      
      
      menuItem = new JMenuItem("Packing List Expedició");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/printer.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirPackingList();
        }
      });      
      tableSgaexpedView1.addPopupMenuItem(menuItem);
  }
  

  public static void main(String [] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
    }

    PanelSgaexpedView1 panel = new PanelSgaexpedView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }

  /**
   * 
   *  JClientPanel implementation
   */
  public JUPanelBinding getPanelBinding()
  {
    return panelBinding;
  }

  private void unRegisterProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.unRegisterNavigationBarInterface(panelBinding, bindCtx);
  }

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(panelBinding, bindCtx);
  }

  public void setBindingContext(BindingContext bindCtx)
  {
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }
  
  private SgaexpedViewRow getCurrentRow () 
  {
    SgaexpedViewRow row = (SgaexpedViewRow)panelBinding.findIteratorBinding("SgaexpedView1Iter").getCurrentRow();
    return row;
  }
  private void imprimirPackingList()    {
    try
    {
      // TODO Michael 21.01.2015 get properties provisionally
           Properties properties = System.getProperties();
      String value = SgaUtilPuesto.getInstance().getProperty("uql.home");
      if (value != null)
        properties.setProperty("uql.home", value);
      value = SgaUtilPuesto.getInstance().getProperty("query.registry.path");
      if (value != null)
        properties.setProperty("query.registry.path", value);
      value = SgaUtilPuesto.getInstance().getProperty("datasource.registry.path");
      if (value != null)
        properties.setProperty("datasource.registry.path", value);
 
      
        SgaexpedViewRow row = getCurrentRow();
        if (row != null)
        {
          AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
          String idexped = row.getIdexped().toString();
          PackingList.imprimirPackingListExped(this.getClass(), appModule, idexped, true);
        }
        
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }

  
    private void afegirDocExped()
  {
    try
    {
        if (panelSortides == null)
        {
           panelSortides = new PanelSgacdocSortidesView3();
          panelSortides.setBindingContext(panelBinding.getBindingContext());
          
        }
        
  
        // TODO Michael: Set where clause: Only finished documents which are not already 
        // String sWhereClause = "idart = '" + currentRow.getIdart() + "'";
        // panelSortides.setWhereClause(sWhereClause);
   
  
          String [] options;
  
        AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
        
        // Si el usuari no té drets per modificar el transportista, simplement li ensenyem els resultats..
        // TODO: Veure drets - aquests no son!!
        if (false) // TODO appModule.isUserModTransportista())
        {
          options = new String [] { "Aceptar" };
        }
        else
        {
  
          options = new String [] { "Aceptar selecció", "Cancel·lar"};
        }
        
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSortides,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.exposicio_titol"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
          switch (result)
          {
            case 0: // Afegir
              SgacdocViewRow cdocRow = panelSortides.getSgacdocRow();
              if (cdocRow != null)
              {
                  SgaexpedViewRow currentRow = getCurrentRow();
                  currentRow.afegirDocSortida(cdocRow);
                  panelBinding.getApplication().getApplicationModule().getTransaction().commit();
                  navBar.getModel().getViewObject().executeQuery();
                  JOptionPane.showMessageDialog(null, "Afegit a expedició: " + cdocRow.getIdcabnum(), "Confirmació", JOptionPane.INFORMATION_MESSAGE );
              }
              else 
              {
                JOptionPane.showMessageDialog(null, "No s'ha seleccionat cap document");
              }
             break;
            case 1: // Cancel·lar
              break;
            
          }

   
   
        
        // panelSortides.releasePanelBinding();
        // panelSortides = null;
      }
      
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  

  
  

  
}