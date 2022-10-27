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
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import sgalib.SgaUtilPuesto;

public class PanelSgavhistexistusuari1 extends SgaJUPanel
//public class PanelSgavhistexistusuari1 extends JPanel implements JUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavhistexistusuari1UIModel");
  private JUStatusBar statusBar = new JUStatusBar();

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  Sgavhistexistusuari1


   private SgaJTable tableSgavhistexistusuari1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  
  
  
  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavhistexistusuari1()
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
    this.setLayout(borderLayout);
        dataPanel.setPreferredSize(new Dimension(800, 250));
    dataPanel.setMaximumSize(new Dimension(800, 250));
    navBar.setPreferredSize(new Dimension(800, 29));
    navBar.setMinimumSize(new Dimension(800, 29));
    navBar.setMaximumSize(new Dimension(800, 29));
    this.setSize(new Dimension(800, 300));
    this.setPreferredSize(new Dimension(800, 300));
    this.setMinimumSize(new Dimension(800, 300));
    this.setMaximumSize(new Dimension(1200, 300));

    // Code support for view object:  Sgavhistexistusuari1
    tableSgavhistexistusuari1.setModel((TableModel)panelBinding.bindUIControl("Sgavhistexistusuari1", tableSgavhistexistusuari1));
      navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "Sgavhistexistusuari1", null, "Sgavhistexistusuari1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    navBar.setMinimumSize(new Dimension(800, 29));
    navBar.setMaximumSize(new Dimension(800, 29));
    add(statusBar, BorderLayout.SOUTH);
    scroller.getViewport().add(tableSgavhistexistusuari1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.CENTER);


  }

  public static void main(String [] args)
  {
    try
    {
        String lookAndFeel = SgaUtilPuesto.getInstance().getProperty("LookAndFeel");
      if (lookAndFeel != null)
        UIManager.setLookAndFeel(lookAndFeel);
        else
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
    }

    PanelSgavhistexistusuari1 panel = new PanelSgavhistexistusuari1();
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
            //Truc per que no executi la consulta nomes entrar
      panelBinding.findIterBinding("Sgavhistexistusuari1Iter").getViewObject().setMaxFetchSize(0);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
        panelBinding.findIterBinding("Sgavhistexistusuari1Iter").getViewObject().setMaxFetchSize(-1);
        navBar.enterQueryMode();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
}