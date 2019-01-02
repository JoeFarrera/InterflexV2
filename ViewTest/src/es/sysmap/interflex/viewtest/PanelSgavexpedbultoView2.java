package es.sysmap.interflex.viewtest;
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

public class PanelSgavexpedbultoView2 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexpedbultoView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavexpedbultoView2

  private SgaJTable tableSgavexpedbultoView2 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexpedbultoView2()
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
    dataPanel.setBorder(BorderFactory.createTitledBorder(" [Embalum] "));
    this.setLayout(borderLayout);
    // Code support for view object:  SgavexpedbultoView2
    tableSgavexpedbultoView2.setModel((TableModel)panelBinding.bindUIControl("SgavexpedbultoView2", tableSgavexpedbultoView2));
    scroller.getViewport().add(tableSgavexpedbultoView2, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavexpedbultoView2", null, "SgavexpedbultoView2Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);


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

    PanelSgavexpedbultoView2 panel = new PanelSgavexpedbultoView2();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl11", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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
}