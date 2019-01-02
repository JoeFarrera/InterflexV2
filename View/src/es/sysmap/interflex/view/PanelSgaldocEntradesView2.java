package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import sgalib.SgaJCheckCellEditor;
import sgalib.SgaJCheckCellRenderer;
import sgalib.SgaJComboEditor;
import sgalib.SgaJComboRenderer;
import sgalib.SgaJTable;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import sgalib.SgaJUPanel;

public class PanelSgaldocEntradesView2 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaldocEntradesView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaldocEntradesView1

  private SgaJTable tableSgaldocEntradesView1 = new SgaJTable()
  {
    public void tableChanged(TableModelEvent e)    
    {
      super.tableChanged(e);

      try
      {
      //Modifiquem els renderers dels combobox i checkboxs
      setCellEditor(panelBinding.getLabel("SgaldocEntradesView1", "Idtipmac", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgatipomacView1", "Idtipmac", "Descrip", mTipmac));
      setCellRenderer(panelBinding.getLabel("SgaldocEntradesView1", "Idtipmac", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgatipomacView1", "Idtipmac", "Descrip"));
      setCellEditor(panelBinding.getLabel("SgaldocEntradesView1", "Relleno", null), new SgaJCheckCellEditor(new JCheckBox()));
      setCellRenderer(panelBinding.getLabel("SgaldocEntradesView1", "Relleno", null), new SgaJCheckCellRenderer());
      }
      catch(Exception ex){}
    }

    public boolean isCellEditable(int row, int column)    
    {
      boolean isEditable = false;
      if (estat != null)
      {
        switch(estat.charAt(0)                          )
        {
          case 'P':
            // Nomes deixem modificar certes columnes
            if (getColumnName(column).equals(panelBinding.getLabel("SgaldocEntradesView1", "Canpenbulto", null)) ||
                getColumnName(column).equals(panelBinding.getLabel("SgaldocEntradesView1", "Idtipmac", null)) ||
                getColumnName(column).equals(panelBinding.getLabel("SgaldocEntradesView1", "Unimac", null)) ||
                getColumnName(column).equals(panelBinding.getLabel("SgaldocEntradesView1", "Relleno", null)))
              isEditable = true;
            else
              isEditable = panelBinding.isFindMode();  
            break;
          case 'S':
          case 'A':
            isEditable = panelBinding.isFindMode();
            break;
        }
      }
      return isEditable;
    }
  };
  private JScrollPane scroller = new JScrollPane();
  private JComboBox mTipmac = new JComboBox();
  //Estat per al qual es mostra la pantalla
  private String estat = null;


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaldocEntradesView2(String estat)
  {
    this.estat = estat;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(725, 216));
    dataPanel.setPreferredSize(new Dimension(725, 216));
    dataPanel.setMaximumSize(new Dimension(725, 216));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(725, 216));
    this.setPreferredSize(new Dimension(725, 216));
    this.setMinimumSize(new Dimension(725, 216));
    this.setMaximumSize(new Dimension(725, 216));
    // Code support for view object:  SgaldocEntradesView1
    mTipmac.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipmac", mTipmac));
    tableSgaldocEntradesView1.setModel((TableModel)panelBinding.bindUIControl("SgaldocEntradesView1", tableSgaldocEntradesView1));
    scroller.setPreferredSize(new Dimension(650, 216));
    scroller.setMinimumSize(new Dimension(650, 216));
    scroller.setMaximumSize(new Dimension(650, 216));
    scroller.getViewport().add(tableSgaldocEntradesView1, null);
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

    PanelSgaldocEntradesView2 panel = new PanelSgaldocEntradesView2(null);
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
  
  public void setWhereClause(String condition)
  {
    ViewObject vo = panelBinding.findIteratorBinding("SgaldocEntradesView1Iter").getViewObject();
    vo.setWhereClause(condition);
    vo.executeQuery();
    
  }

  

}