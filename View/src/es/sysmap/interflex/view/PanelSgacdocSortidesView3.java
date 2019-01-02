package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgacdocSortidesViewRow;
import es.sysmap.interflex.model.dmc.common.SgacdocViewRow;
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

import oracle.jdeveloper.layout.*;
import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import oracle.jbo.uicli.controls.JUNavigationBar;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import java.awt.BorderLayout;

// public class PanelSgacdocSortidesView3 extends JPanel implements JUPanel 
public class PanelSgacdocSortidesView3 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgacdocSortidesView3UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgacdocSortidesView1

  private SgaJTable tableSgacdocSortidesView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgacdocSortidesView3()
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
  
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    // Code support for view object:  SgacdocSortidesView1
    tableSgacdocSortidesView1.setModel((TableModel)panelBinding.bindUIControl("SgacdocSortidesView1", tableSgacdocSortidesView1));
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgacdocSortidesView1", null, "SgacdocSortidesView1Iterator"));
    scroller.getViewport().add(tableSgacdocSortidesView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.NORTH);
    this.add(jUNavigationBar1, BorderLayout.SOUTH);


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

    PanelSgacdocSortidesView3 panel = new PanelSgacdocSortidesView3();
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

  private void unRegisterProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.unRegisterNavigationBarInterface(panelBinding, bindCtx);
  }

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(panelBinding, bindCtx);
  }

  public void setBindingContext(BindingContext bindCtx)
  {
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);

      // Michael: Filtrar per documents acabats..
      setWhereClause();
 
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }
  
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
  
  public SgacdocViewRow getSgacdocRow () 
  {
      SgacdocViewRow currordre = (SgacdocViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      
      if (currordre == null)
        return null;
        
     return (currordre);

  }
  
  /**
   * Filtrar per estat = 'F' finalitzat
   */
  public void setWhereClause()
  {
    ViewObject vo = panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getViewObject();
    vo.setWhereClause("estado = 'F'");
    vo.executeQuery();
    
  }

}