package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgacdocViewRow;
import es.sysmap.interflex.model.dmc.common.SgavexpedRow;
import es.sysmap.interflex.model.dmc.common.SgavexpedViewRow;
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
import oracle.jbo.uicli.controls.JUNavigationBar;
import java.awt.BorderLayout;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import sgalib.SgaJUPanel;

// public class PanelSgavexpedView1 extends JPanel implements JUPanel 
public class PanelSgavexpedView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexpedView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavexpedView1

  private JTable tableSgavexpedView1 = new JTable();
  private JScrollPane scroller = new JScrollPane();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexpedView1()
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
    // Code support for view object:  SgavexpedView1
    tableSgavexpedView1.setModel((TableModel)panelBinding.bindUIControl("SgavexpedView1", tableSgavexpedView1));
    scroller.getViewport().add(tableSgavexpedView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.CENTER);
    this.add(jUNavigationBar1, BorderLayout.NORTH);
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgavexpedView1", null, "SgavexpedView1Iterator"));


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

    PanelSgavexpedView1 panel = new PanelSgavexpedView1();
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

  /**
   * Michael
   */
  public void releasePanelBinding()
  {
    super.releasePanelBinding();
  }
  
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

  public void setBindingContext(BindingContext bindCtx)
  {
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
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
  
  
   private SgavexpedViewRow getCurrentRow () {
    SgavexpedViewRow expedRow = (SgavexpedViewRow)panelBinding.findIterBinding("SgavexpedView1Iter").getCurrentRow();
    return expedRow;
  }
  
  
  public String afegirDocExped(SgacdocViewRow cdocRow, boolean novaExped) 
  {
      String idExped = null;
      if (novaExped)
      {
        jUNavigationBar1.doAction(JUNavigationBar.BUTTON_INSERT);
        SgavexpedViewRow currentRow = getCurrentRow();
        currentRow.afegirDocSortida(cdocRow);
        idExped = currentRow.getIdexped().toString();     
      }
      else 
      {
        SgavexpedViewRow currentRow = getCurrentRow();
        currentRow.afegirDocSortida(cdocRow);
        idExped = currentRow.getIdexped().toString();
        
        
        
      }
      
      return (idExped);
      
      
  }
  
}