package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;

// public class PanelSgavubicacionView1 extends JPanel implements JUPanel
public class PanelSgavubicacionView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavubicacionView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavubicacionView1

  private SgaJTable tableSgavubicacionView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavubicacionView1()
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
    // Code support for view object:  SgavubicacionView1
    tableSgavubicacionView1.setModel((TableModel)panelBinding.bindUIControl("SgavubicacionView1", tableSgavubicacionView1));
    tableSgavubicacionView1.setEditable(false);
    scroller.getViewport().add(tableSgavubicacionView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavubicacionView1", null, "SgavubicacionView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
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

    PanelSgavubicacionView1 panel = new PanelSgavubicacionView1();
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