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

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJComboEditor;
import sgalib.SgaJComboRenderer;
import sgalib.SgaJTable;
import java.awt.Dimension;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgaposicionubicacionView3 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaposicionubicacionView3UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaposicionubicacionView3

  private SgaJTable tableSgaposicionubicacionView3 = new SgaJTable()
  {
    public void tableChanged(TableModelEvent e)    
    {
      super.tableChanged(e);

      try
      {
      //Modifiquem els renderers dels combobox i checkboxs
      setCellEditor(panelBinding.getLabel("SgaposicionubicacionView3", "Estado", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgaestadoubiView1", "Estado", "Abbreviation", mEstado));
      setCellRenderer(panelBinding.getLabel("SgaposicionubicacionView3", "Estado", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgaestadoubiView1", "Estado", "Abbreviation"));
      setCellEditor(panelBinding.getLabel("SgaposicionubicacionView3", "Acceso", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgaaccesoubiView1", "Acceso", "Abbreviation", mAcceso));
      setCellRenderer(panelBinding.getLabel("SgaposicionubicacionView3", "Acceso", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgaaccesoubiView1", "Acceso", "Abbreviation"));
      }
      catch(Exception ex){}
    }

    public boolean isCellEditable(int row, int column)    
    {
      // Nomes deixem modificar certes columnes
      if (getColumnName(column).equals(panelBinding.getLabel("SgaposicionubicacionView3", "Estado", null)) ||
          getColumnName(column).equals(panelBinding.getLabel("SgaposicionubicacionView3", "Acceso", null)))
        return true;
      else
        return panelBinding.isFindMode();
    }
};
  
  private JScrollPane scroller = new JScrollPane();

  private JComboBox mEstado = new JComboBox();
  private JComboBox mAcceso = new JComboBox();
  
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaposicionubicacionView3()
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
    dataPanel.setMinimumSize(new Dimension(400, 149));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(400, 149));
    dataPanel.setMaximumSize(new Dimension(400, 149));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(400, 175));
    this.setPreferredSize(new Dimension(400, 175));
    this.setMinimumSize(new Dimension(400, 175));
    this.setMaximumSize(new Dimension(400, 175));
    // Code support for view object:  SgaposicionubicacionView3
    mEstado.setModel((ComboBoxModel)panelBinding.bindUIControl("Descestado", mEstado));
    mAcceso.setModel((ComboBoxModel)panelBinding.bindUIControl("Descacceso", mAcceso));
    tableSgaposicionubicacionView3.setModel((TableModel)panelBinding.bindUIControl("SgaposicionubicacionView3", tableSgaposicionubicacionView3));
    scroller.getViewport().add(tableSgaposicionubicacionView3, null);
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

    PanelSgaposicionubicacionView3 panel = new PanelSgaposicionubicacionView3();
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