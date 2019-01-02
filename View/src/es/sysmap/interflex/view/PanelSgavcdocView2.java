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
import java.awt.Dimension;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgavcdocView2 extends SgaJUPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavcdocView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavcdocView2

  private SgaJTable tableSgavcdocView2 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavcdocView2()
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
    dataPanel.setMinimumSize(new Dimension(700, 221));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Entrades.capçalera_label")));
    dataPanel.setPreferredSize(new Dimension(700, 221));
    dataPanel.setMaximumSize(new Dimension(700, 221));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 250));
    this.setPreferredSize(new Dimension(700, 250));
    this.setMinimumSize(new Dimension(700, 250));
    this.setMaximumSize(new Dimension(700, 250));
    // Code support for view object:  SgavcdocView2
    tableSgavcdocView2.setModel((TableModel)panelBinding.bindUIControl("SgavcdocView2", tableSgavcdocView2));
    tableSgavcdocView2.setEditable(false);
    scroller.getViewport().add(tableSgavcdocView2, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavcdocView2", null, "SgavcdocView2Iter"));
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
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

    PanelSgavcdocView2 panel = new PanelSgavcdocView2();
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
   * Estableix un filtre per no deixar veure documents finalitzats o anul·lats
   */
  public void filtrarDocuments()
  {
    panelBinding.findIteratorBinding("SgavcdocView2Iter").getViewObject().setWhereClause("not estadolineas in ('A','F')");
    panelBinding.findIteratorBinding("SgavcdocView2Iter").executeQuery();
  }
  
}