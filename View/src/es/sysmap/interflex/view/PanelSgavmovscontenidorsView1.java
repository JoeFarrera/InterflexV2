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
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;

public class PanelSgavmovscontenidorsView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavmovscontenidorsView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavmovscontenidorsView1

  private SgaJTable tableSgavmovscontenidorsView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavmovscontenidorsView1()
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
    dataPanel.setMinimumSize(new Dimension(700, 600));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(700, 600));
    dataPanel.setMaximumSize(new Dimension(700, 600));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 600));
    this.setPreferredSize(new Dimension(700, 600));
    this.setMinimumSize(new Dimension(700, 600));
    this.setMaximumSize(new Dimension(700, 600));
    // Code support for view object:  SgavmovscontenidorsView1
    tableSgavmovscontenidorsView1.setModel((TableModel)panelBinding.bindUIControl("SgavmovscontenidorsView1", tableSgavmovscontenidorsView1));
    scroller.getViewport().add(tableSgavmovscontenidorsView1, null);
    // Layout the datapanel and the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavmovsusuariView1", null, "SgavmovsusuariView1Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);

    dataPanel.add(scroller);
    add(navBar, BorderLayout.NORTH);
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

    PanelSgavmovscontenidorsView1 panel = new PanelSgavmovscontenidorsView1();
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