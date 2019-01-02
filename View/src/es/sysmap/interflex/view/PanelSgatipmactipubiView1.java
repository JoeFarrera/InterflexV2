package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJComboEditor;
import sgalib.SgaJComboRenderer;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;

public class PanelSgatipmactipubiView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgatipmactipubiView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();
// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgatipmactipubiView1

  private SgaJTable tableSgatipmactipubiView1 = new SgaJTable()
  {
    public void tableChanged(TableModelEvent e)    
    {
      super.tableChanged(e);

      try
      {
      //Modifiquem els renderers dels combobox i checkboxs
      setCellEditor(panelBinding.getLabel("SgatipmactipubiView1", "Idtipubi", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgatipoubicacionView1", "Idtipubi", "Descrip", mTipubi));
      setCellRenderer(panelBinding.getLabel("SgatipmactipubiView1", "Idtipubi", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgatipoubicacionView1", "Idtipubi", "Descrip"));
      setCellEditor(panelBinding.getLabel("SgatipmactipubiView1", "Idtipmac", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgatipomacView1", "Idtipmac", "Descrip", mTipmac));
      setCellRenderer(panelBinding.getLabel("SgatipmactipubiView1", "Idtipmac", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgatipomacView1", "Idtipmac", "Descrip"));
      }
      catch(Exception ex){}
    }
  };
  private JScrollPane scroller = new JScrollPane();
  private JComboBox mTipubi = new JComboBox();
  private JComboBox mTipmac = new JComboBox();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgatipmactipubiView1()
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
    dataPanel.setMinimumSize(new Dimension(400, 253));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(400, 253));
    dataPanel.setMaximumSize(new Dimension(400, 253));

    navBar.setPreferredSize(new Dimension(400, 26));
    navBar.setMinimumSize(new Dimension(400, 26));
    navBar.setMaximumSize(new Dimension(400, 26));

    this.setLayout(borderLayout);
    this.setPreferredSize(new Dimension(400, 300));
    this.setMinimumSize(new Dimension(400, 300));
    this.setMaximumSize(new Dimension(400, 300));
    // Code support for view object:  SgatipmactipubiView1
    mTipubi.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipubi", mTipubi));
    mTipmac.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipmac", mTipmac));
    tableSgatipmactipubiView1.setModel((TableModel)panelBinding.bindUIControl("SgatipmactipubiView1", tableSgatipmactipubiView1));
    scroller.getViewport().add(tableSgatipmactipubiView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    // Layout the datapanel and the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgatipmactipubiView1", null, "SgatipmactipubiView1Iter"));
    navBar.setHasDeleteButton(false);
    navBar.setHasInsertButton(false);
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

    PanelSgatipmactipubiView1 panel = new PanelSgatipmactipubiView1();
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