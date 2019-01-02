package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgavldocEntradesViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.Key;
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

//public class PanelSgavldocEntradesView1 extends JUPanel implements JPanel
public class PanelSgavldocEntradesView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavldocEntradesView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavldocEntradesView1

  private SgaJTable tableSgavldocEntradesView1 = new SgaJTable();
  
  private JScrollPane scroller = new JScrollPane();
  
  private boolean selectMultiple;
  


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavldocEntradesView1()
  {
    // TODO: Should be initialization parameter
    this.selectMultiple = true;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(500, 300));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Entrades.detallOrdres_label")));
    dataPanel.setPreferredSize(new Dimension(500, 300));
    dataPanel.setMaximumSize(new Dimension(500, 300));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(500, 300));
    this.setPreferredSize(new Dimension(500, 300));
    this.setMinimumSize(new Dimension(500, 300));
    this.setMaximumSize(new Dimension(500, 300));
    // Code support for view object:  SgavldocEntradesView1
    tableSgavldocEntradesView1.setModel((TableModel)panelBinding.bindUIControl("SgavldocEntradesView1", tableSgavldocEntradesView1));
    tableSgavldocEntradesView1.setEditable(false);
    if (selectMultiple)
      tableSgavldocEntradesView1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    scroller.getViewport().add(tableSgavldocEntradesView1, null);
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

    PanelSgavldocEntradesView1 panel = new PanelSgavldocEntradesView1();
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


  public Key[] getSelectedRows ()
  {
        int [] selectedRows = tableSgavldocEntradesView1.getSelectedRows();
        Key [] keys = new Key [tableSgavldocEntradesView1.getSelectedRowCount()];
        JUTableBinding tldoc = (JUTableBinding)panelBinding.findControlBinding("SgavldocEntradesView1");
        for (int i = 0; i < tableSgavldocEntradesView1.getSelectedRowCount(); i++)
        {
          keys [i] = tldoc.getRowAtRangeIndex(selectedRows [i]).getKey();
          
        }
        
        // Michael 20.03.2017 select the cdocentradas iterator as used in other panels which implement
        ViewObject vo = panelBinding.findIteratorBinding("SgacdocEntradasIterator").getViewObject();
        SgavldocEntradesViewRow curRow = (SgavldocEntradesViewRow)panelBinding.findIteratorBinding("SgavldocEntradesView1Iter").getCurrentRow();
        vo.setWhereClause("iddoc = '" + curRow.getIddoc() + "'");
        vo.executeQuery();
        vo.setWhereClause(null);
        
        // Michael 20.03.2017 end
 
        return (keys);
  }
  
  
}