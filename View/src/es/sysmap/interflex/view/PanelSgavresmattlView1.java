package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgavresmattlViewRow;
import java.awt.*;
import java.awt.event.*;
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

import sgalib.SgaJTable;
import sgalib.SgaRecursos;
import java.awt.Dimension;

public class PanelSgavresmattlView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavresmattlView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavresmattlView1

  private SgaJTable tableSgavresmattlView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavresmattlView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    // Code support for view object:  SgavresmattlView1
    tableSgavresmattlView1.setModel((TableModel)panelBinding.bindUIControl("SgavresmattlView1", tableSgavresmattlView1));
    // Bind the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavresmattlView1", null, "SgavresmattlView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    scroller.getViewport().add(tableSgavresmattlView1, null);
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.CENTER);
    
    
    JButton buttonInsert = navBar.getButton(JUNavigationBar.BUTTON_INSERT);
    ActionListener [] listeners = buttonInsert.getActionListeners();
    this.setPreferredSize(new Dimension(454, 180));
    this.setSize(new Dimension(400, 174));
    scroller.setSize(new Dimension(400, 200));
    scroller.setPreferredSize(new Dimension(454, 200));
    for (int i = 0; i < listeners.length; i++)
    {
      buttonInsert.removeActionListener(listeners[i]);
    }
    buttonInsert.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
           veureExistencies(false);         
//          Container container = getParent();
//          while (container != null && !(container instanceof JFrame))
//            container = container.getParent();
//          
//
//          JOptionPane.showConfirmDialog(container, "Per afegir una nova expedició, tria primer el document de sortides, i l'opció "
//            + "contextual <Afegir a expedició> [del menú del botó dret]",
//            "Afegir una nova expedició",
//            JOptionPane.CANCEL_OPTION,
//            JOptionPane.INFORMATION_MESSAGE);
//          
        }
      });
      
      addPopup();
  }

/**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      
      tableSgavresmattlView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.veureExistencies_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/undo.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
           veureExistencies(true);
        }
      });      
      tableSgavresmattlView1.addPopupMenuItem(menuItem);
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

    PanelSgavresmattlView1 panel = new PanelSgavresmattlView1();
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
  
  
  
  private void esborrarReservaTrasllat()
  {
    
  }
  
  private void veureExistencies(boolean referencia)
  {
    try
    {
    SgavresmattlViewRow currentRow = (SgavresmattlViewRow)panelBinding.findIterBinding("SgavresmattlView1Iter").getCurrentRow();
    if (currentRow == null)
    {
      navBar.doAction(navBar.BUTTON_INSERT);
      currentRow = (SgavresmattlViewRow)panelBinding.findIterBinding("SgavresmattlView1Iter").getCurrentRow();
    }
    MDPanelSgavsumexistenciaView1SgavexistenciaView2 panelExistencies = new MDPanelSgavsumexistenciaView1SgavexistenciaView2();
    panelExistencies.setIddocTL(currentRow.getIddoc());
    
    panelExistencies.setBindingContext(panelBinding.getBindingContext()); 
    
    if (referencia)
    {
        String sWhereClause = "idart = '" + currentRow.getIdart() + "'";
        panelExistencies.setWhereClause(sWhereClause);

    }
    

    
    // Options
    String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
    int result = JOptionPane.showOptionDialog(
        Interflex.getInstance(),                                       // the parent that the dialog blocks
        panelExistencies,                                    // the dialog message array
        SgaRecursos.getInstance().getString("Sortides.llistaExistencies_label"), // the title of the dialog window
        JOptionPane.DEFAULT_OPTION,                 // option type
        JOptionPane.PLAIN_MESSAGE,            // message type
        null,                                       // optional icon, use null to use the default icon
        options,                                    // options string array, will be made into buttons
        null                                        // option that should be made into a default button
    );
    
    // Commit?
    panelExistencies.releasePanelBinding();
    panelExistencies = null;
    navBar.getModel().getViewObject().executeQuery();
      
      
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

}