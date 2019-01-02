package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgavmacSenseExistenciesViewRow;
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
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgavmacSenseExistenciesView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavmacSenseExistenciesView1UIModel");

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavmacSenseExistenciesView1

  private SgaJTable tableSgavmacSenseExistenciesView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavmacSenseExistenciesView1()
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
    dataPanel.setMinimumSize(new Dimension(800, 370));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(800, 370));
    dataPanel.setMaximumSize(new Dimension(800, 370));

    navBar.setPreferredSize(new Dimension(800, 30));
    navBar.setMinimumSize(new Dimension(800, 30));
    navBar.setMaximumSize(new Dimension(800, 30));

    this.setLayout(borderLayout);
    this.setSize(new Dimension(800, 400));
    this.setPreferredSize(new Dimension(800, 400));
    this.setMinimumSize(new Dimension(800, 400));
    this.setMaximumSize(new Dimension(800, 400));
    // Code support for view object:  SgavmacSenseExistenciesView1
    tableSgavmacSenseExistenciesView1.setModel((TableModel)panelBinding.bindUIControl("SgavmacSenseExistenciesView1", tableSgavmacSenseExistenciesView1));
    tableSgavmacSenseExistenciesView1.setEditable(false);
    scroller.getViewport().add(tableSgavmacSenseExistenciesView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavmacSenseExistenciesView1", null, "SgavmacSenseExistenciesView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);

    // Afegim opcions al popup de la taula
    addPopup();
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

    PanelSgavmacSenseExistenciesView1 panel = new PanelSgavmacSenseExistenciesView1();
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

  
  /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      
      tableSgavmacSenseExistenciesView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.treureContenidor_label"));
      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          treureContenidor();
        }
      });      
      tableSgavmacSenseExistenciesView1.addPopupMenuItem(menuItem);
  }
  
  
  /**
   * Solicita la extracció del contenidor de l'existencia
   */
   //TODO: Falta implementar-ho
  private void treureContenidor()
  {
    try
    {
      SgavmacSenseExistenciesViewRow macrow = (SgavmacSenseExistenciesViewRow)panelBinding.findIteratorBinding("SgavmacSenseExistenciesView1Iter").getCurrentRow(); 
      if (macrow != null)
      {
        boolean silo = !macrow.getIdtipmac().equals("CUB");
        TreureContenidor.treureContenidor((AppModule)getPanelBinding().getApplication().getApplicationModule(), macrow.getIdmac(), silo);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
}