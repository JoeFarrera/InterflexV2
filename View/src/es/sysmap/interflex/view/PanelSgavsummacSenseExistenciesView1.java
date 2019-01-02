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

public class PanelSgavsummacSenseExistenciesView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavsummacSenseExistenciesView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavsummacSenseExistenciesView1

  private SgaJTable tableSgavsummacSenseExistenciesView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavsummacSenseExistenciesView1()
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
    dataPanel.setMinimumSize(new Dimension(800, 120));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(800, 120));
    dataPanel.setMaximumSize(new Dimension(800, 120));

    navBar.setPreferredSize(new Dimension(800, 30));
    navBar.setMinimumSize(new Dimension(800, 30));
    navBar.setMaximumSize(new Dimension(800, 30));

    this.setLayout(borderLayout);
    this.setSize(new Dimension(800, 150));
    this.setPreferredSize(new Dimension(800, 150));
    this.setMinimumSize(new Dimension(800, 150));
    this.setMaximumSize(new Dimension(800, 150));

    // Code support for view object:  SgavsummacSenseExistenciesView1
    tableSgavsummacSenseExistenciesView1.setModel((TableModel)panelBinding.bindUIControl("SgavsummacSenseExistenciesView1", tableSgavsummacSenseExistenciesView1));
    tableSgavsummacSenseExistenciesView1.setEditable(false);
    scroller.getViewport().add(tableSgavsummacSenseExistenciesView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavsummacSenseExistenciesView1", null, "SgavsummacSenseExistenciesView1Iter"));
    // Layout the datapanel and the navigation bar
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

    PanelSgavsummacSenseExistenciesView1 panel = new PanelSgavsummacSenseExistenciesView1();
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

  //Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
}