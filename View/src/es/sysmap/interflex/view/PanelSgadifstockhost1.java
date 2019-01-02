package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgadifstockhostRow;
import es.sysmap.interflex.model.dmc.common.SgavexistenciaViewRow;
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

import oracle.jdeveloper.layout.*;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgadifstockhost1 extends SgaJUPanel 
{


  private AppModule appModule;
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgadifstockhost1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  Sgadifstockhost1

  private SgaJTable tableSgadifstockhost1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgadifstockhost1()
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
    dataPanel.setMinimumSize(new Dimension(800, 250));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(800, 250));
    dataPanel.setMaximumSize(new Dimension(800, 250));
    navBar.setPreferredSize(new Dimension(800, 29));
    navBar.setMinimumSize(new Dimension(800, 29));
    navBar.setMaximumSize(new Dimension(800, 29));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(800, 300));
    this.setPreferredSize(new Dimension(800, 300));
    this.setMinimumSize(new Dimension(800, 300));
    this.setMaximumSize(new Dimension(800, 300));
    // Code support for view object:  Sgadifstockhost1
    tableSgadifstockhost1.setModel((TableModel)panelBinding.bindUIControl("Sgadifstockhost1", tableSgadifstockhost1));
    tableSgadifstockhost1.setEditable(false);
    scroller.getViewport().add(tableSgadifstockhost1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "Sgadifstockhost1", null, "Sgadifstockhost1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);
    
    addPopup();
    
    


  }

  /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      
      tableSgadifstockhost1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Stock.regularizar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/up_down_question.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          regularizarStock();
        }
      });      
      tableSgadifstockhost1.addPopupMenuItem(menuItem);
      
  }


  private AppModule getAppModule()
  {
    if (appModule == null && navBar.getModel() != null)
        appModule = (AppModule)navBar.getModel().getApplication().getApplicationModule();
    return appModule;

  }


  private void regularizarStock()
  {
    // TODO - preguntar
    SgadifstockhostRow dsRow = (SgadifstockhostRow)panelBinding.findIteratorBinding("Sgadifstockhost1Iter").getCurrentRow(); 
    JFrame frame = null;
    if (Interflex.getInstance() != null)
      frame = Interflex.getInstance().getFrame();
    String mensaje = SgaRecursos.getInstance().getString("Stock.regularizar_question1") + " "
      + dsRow.getIdartif() + " " + SgaRecursos.getInstance().getString("Stock.regularizar_question2")
      + " " + dsRow.getCantot();
    int result = JOptionPane.showConfirmDialog(frame,
              mensaje, SgaRecursos.getInstance().getString("Stock.regularizar_titol"), 
              JOptionPane.YES_NO_OPTION);
              
    if (result == 0)
    {
    
      getAppModule().regularizarTablaStock(dsRow.getIdart(), dsRow.getCantot());
      // getAppModule().getTransaction().commit();
      navBar.doAction(navBar.BUTTON_COMMIT);
      panelBinding.findIteratorBinding("Sgadifstockhost1Iter").executeQuery();
    }
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

    PanelSgadifstockhost1 panel = new PanelSgadifstockhost1();
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

  // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

}