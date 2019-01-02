package es.sysmap.interflex.view;
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
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaRunPanel;
import sgalib.SgaUtilPuesto;

public class PanelSgavdocsObertsView1 extends SgaJUPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavdocsObertsView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

/// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavdocsObertsView1

  private SgaJTable tableSgavdocsObertsView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavdocsObertsView1()
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
    dataPanel.setMinimumSize(new Dimension(400, 250));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(400, 250));
    dataPanel.setMaximumSize(new Dimension(400, 250));
    this.setLayout(borderLayout);
    this.setPreferredSize(new Dimension(400, 300));
    this.setMinimumSize(new Dimension(400, 300));
    this.setMaximumSize(new Dimension(400, 300));
    // Code support for view object:  SgavdocsObertsView1
    tableSgavdocsObertsView1.setModel((TableModel)panelBinding.bindUIControl("SgavdocsObertsView1", tableSgavdocsObertsView1));
    tableSgavdocsObertsView1.setEditable(false);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavdocsObertsView1", null, "SgavdocsObertsView1Iter"));
    navBar.setPreferredSize(new Dimension(400, 29));
    navBar.setMinimumSize(new Dimension(400, 29));
    navBar.setMaximumSize(new Dimension(400, 29));
    scroller.getViewport().add(tableSgavdocsObertsView1, null);
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);


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

    PanelSgavdocsObertsView1 panel = new PanelSgavdocsObertsView1();
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

  // Definit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

 
  static SgaRunPanel runPanel()
  {
      SgaRunPanel _runPanel = null;
      
      // Verifiquem que existeixi la propietat 'LlocTreball' definida en el fitxer
      // de propietats del pc. Si no, no deixem instanciar el panel
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      if (puesto != null)
      {
        PanelSgavdocsObertsView1 panel = new PanelSgavdocsObertsView1();
        _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));
        // Restringim els documents als assignats al puesto
        _runPanel.getBindingContext().findBindingContainer("PanelSgavdocsObertsView1UIModel")
          .findIteratorBinding("SgavdocsObertsView1Iter").getViewObject().setWhereClauseParam(0, puesto);
        panel.setBindingContext(_runPanel.getBindingContext());
        panel.revalidate();
      }
      else
        JUMetaObjectManager.reportException(null, new Exception(SgaRecursos.getInstance().getString("Error.llocTreballNoDefinit")));
      
      return _runPanel;      
  }
  
}