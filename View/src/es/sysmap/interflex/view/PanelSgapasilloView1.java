package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
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
import sgalib.SgaJComboEditor;
import sgalib.SgaJComboRenderer;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;

// public class PanelSgapasilloView1 extends JPanel implements JUPanel 

public class PanelSgapasilloView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgapasilloView1UIModel");

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgapasilloView1

  private SgaJTable tableSgapasilloView1 = new SgaJTable()
  {
    public void tableChanged(TableModelEvent e)    
    {
      super.tableChanged(e);

      try
      {
      //Modifiquem els renderers dels combobox i checkboxs
      setCellEditor(panelBinding.getLabel("SgapasilloView1", "estado", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgaestatpassadisView1", "Value", "Abbreviation", mEstat));
      setCellRenderer(panelBinding.getLabel("SgapasilloView1", "estado", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgaestatpassadisView1", "Value", "Abbreviation"));
      }
      catch(Exception ex){}
    }
  };
  
  private JScrollPane scroller = new JScrollPane();

  private JComboBox mEstat = new JComboBox();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgapasilloView1()
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
    // Code support for view object:  SgapasilloView1
    mEstat.setModel((ComboBoxModel)panelBinding.bindUIControl("Descestat", mEstat));
    tableSgapasilloView1.setModel((TableModel)panelBinding.bindUIControl("SgapasilloView1", tableSgapasilloView1));
    scroller.getViewport().add(tableSgapasilloView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgapasilloView1", null, "SgapasilloView1Iter"));
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

    PanelSgapasilloView1 panel = new PanelSgapasilloView1();
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