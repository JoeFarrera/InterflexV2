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
import java.awt.Dimension;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgavocupaciominiloaddetallView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavocupaciominiloaddetallView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();
// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavocupaciominiloaddetallView1

  private SgaJTable tableSgavocupaciominiloaddetallView1 = new SgaJTable();  
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavocupaciominiloaddetallView1()
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
    dataPanel.setMinimumSize(new Dimension(700, 91));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Ocupacio.ocupacioMld_title")));
    dataPanel.setPreferredSize(new Dimension(700, 91));
    dataPanel.setMaximumSize(new Dimension(700, 91));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 120));
    this.setPreferredSize(new Dimension(700, 120));
    this.setMinimumSize(new Dimension(700, 120));
    this.setMaximumSize(new Dimension(700, 120));
    // Code support for view object:  SgavocupaciominiloaddetallView1
    tableSgavocupaciominiloaddetallView1.setModel((TableModel)panelBinding.bindUIControl("SgavocupaciominiloaddetallView1", tableSgavocupaciominiloaddetallView1));
    tableSgavocupaciominiloaddetallView1.setEditable(false);
    scroller.getViewport().add(tableSgavocupaciominiloaddetallView1, null);
    dataPanel.add(scroller);
    navBar.setHasDeleteButton(false);
    navBar.setHasInsertButton(false);
    navBar.setHasNavigationButtons(false);
    navBar.setHasTransactionButtons(false);
    // Layout the datapanel and the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavocupaciominiloaddetallView1", null, "SgavocupaciominiloaddetallView1Iter"));
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

    PanelSgavocupaciominiloaddetallView1 panel = new PanelSgavocupaciominiloaddetallView1();
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