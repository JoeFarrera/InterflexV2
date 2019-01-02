package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgavbultoViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJTable;
import java.awt.Dimension;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgavbultoView2 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavbultoView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavbultoView2

  private SgaJTable tableSgavbultoView2 = new SgaJTable();

  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavbultoView2()
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
    dataPanel.setMinimumSize(new Dimension(200, 300));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Entrades.bultos_label")));
    dataPanel.setMaximumSize(new Dimension(200, 300));
    dataPanel.setPreferredSize(new Dimension(200, 300));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(200, 300));
    this.setPreferredSize(new Dimension(200, 300));
    this.setMinimumSize(new Dimension(200, 300));
    this.setMaximumSize(new Dimension(200, 300));
    // Code support for view object:  SgavbultoView2
    tableSgavbultoView2.setModel((TableModel)panelBinding.bindUIControl("SgavbultoView2", tableSgavbultoView2));
    tableSgavbultoView2.setEditable(false);
    scroller.getViewport().add(tableSgavbultoView2, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    // Layout the datapanel and the navigation bar
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

    PanelSgavbultoView2 panel = new PanelSgavbultoView2();
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