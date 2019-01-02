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

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaPopupListener;
import java.awt.Dimension;

public class PanelSgavhistordtranView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavhistordtranView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavhistordtranView1

  private SgaJTable tableSgavhistordtranView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();

  // The navigation bar
  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

  // The status bar
  private JUStatusBar statusBar = new JUStatusBar();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavhistordtranView1()
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
//    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(466, 306));
    this.setMinimumSize(new Dimension(466, 306));
    this.setMaximumSize(new Dimension(466, 306));
    this.setPreferredSize(new Dimension(466, 306));
    // Code support for view object:  SgavhistordtranView1
    tableSgavhistordtranView1.setModel((TableModel)panelBinding.bindUIControl("SgavhistordtranView1", tableSgavhistordtranView1));
    scroller.getViewport().add(tableSgavhistordtranView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.CENTER);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavhistordtranView1", null, "SgavhistordtranView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
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

    PanelSgavhistordtranView1 panel = new PanelSgavhistordtranView1();
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

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(getPanelBinding(), bindCtx);
  }
  
  public void setBindingContext(BindingContext bindCtx)
  {
    // Afegit xavi
    createPanelBinding(bindCtx);
    // Fi afegit xavi
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      //Truc per que no executi la consulta nomes entrar
      panelBinding.findIterBinding("SgavhistordtranView1Iter").getViewObject().setMaxFetchSize(0);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
        panelBinding.findIterBinding("SgavhistordtranView1Iter").getViewObject().setMaxFetchSize(-1);
        navBar.enterQueryMode();
        // Forçem l'entrada a query mode
        
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }
    }
  }


  

}