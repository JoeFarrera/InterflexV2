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
import java.awt.Dimension;
import sgalib.SgaJUPanel;

public class PanelSgaresmatView5 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaresmatView5UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaresmatView5

  private SgaJTable tableSgaresmatView5 = new SgaJTable();
  
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaresmatView5()
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
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setMinimumSize(new Dimension(600, 300));
    dataPanel.setPreferredSize(new Dimension(600, 300));
    dataPanel.setMaximumSize(new Dimension(600, 300));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(600, 300));
    this.setPreferredSize(new Dimension(600, 300));
    this.setMinimumSize(new Dimension(600, 300));
    this.setMaximumSize(new Dimension(600, 300));
    // Code support for view object:  SgaresmatView5
    tableSgaresmatView5.setModel((TableModel)panelBinding.bindUIControl("SgaresmatView5", tableSgaresmatView5));
    tableSgaresmatView5.setEditable(false);
    scroller.getViewport().add(tableSgaresmatView5, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
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

    PanelSgaresmatView5 panel = new PanelSgaresmatView5();
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