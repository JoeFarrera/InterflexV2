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
import oracle.jbo.uicli.controls.JUNavigationBar;
import java.awt.BorderLayout;
import oracle.jbo.uicli.controls.JUStatusBar;
import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;
import java.awt.Dimension;

// public class PanelSgatipobultoView1 extends JPanel implements JUPanel 
public class PanelSgatipobultoView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgatipobultoView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgatipobultoView1

  private SgaJTable tableSgatipobultoView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar();
  private JUStatusBar jUStatusBar1 = new JUStatusBar();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgatipobultoView1()
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
    this.setBounds(new Rectangle(10, 10, 400, 150));
    this.setPreferredSize(new Dimension(400, 150));
    this.setSize(new Dimension(466, 150));
    // Code support for view object:  SgatipobultoView1
    tableSgatipobultoView1.setModel((TableModel)panelBinding.bindUIControl("SgatipobultoView1", tableSgatipobultoView1));
    tableSgatipobultoView1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    // Layout the datapanel and the navigation bar
    add(dataPanel, BorderLayout.CENTER);
    this.add(jUNavigationBar1, BorderLayout.NORTH);
    this.add(jUStatusBar1, BorderLayout.SOUTH);
    scroller.getViewport().add(tableSgatipobultoView1, null);
    this.add(scroller, BorderLayout.WEST);
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgatipobultoView1", null, "SgatipobultoView1Iter"));
    jUStatusBar1.setModel(JUStatusBar.createPanelBinding(panelBinding, jUStatusBar1));


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

    PanelSgatipobultoView1 panel = new PanelSgatipobultoView1();
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
  
  // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
}