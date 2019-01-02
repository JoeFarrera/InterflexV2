package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgacdocViewRow;
import es.sysmap.interflex.model.dmc.common.SgaexpedViewRow;
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
import oracle.jbo.uicli.binding.JUIteratorBinding;
import java.awt.BorderLayout;
import sgalib.SgaJTable;
import sgalib.SgaJUPanel;

// public class PanelSgaexpedView3 extends JPanel implements JUPanel 
public class PanelSgaexpedView3 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaexpedView3UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaexpedView1

  private SgaJTable tableSgaexpedView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaexpedView3()
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
    // Code support for view object:  SgaexpedView1
    tableSgaexpedView1.setModel((TableModel)panelBinding.bindUIControl("SgaexpedView1", tableSgaexpedView1));
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgaexpedView1", null, "SgaexpedView1Iterator1"));
    scroller.getViewport().add(tableSgaexpedView1, null);
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

    PanelSgaexpedView3 panel = new PanelSgaexpedView3();
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
  
   private SgaexpedViewRow getCurrentRow () {
    SgaexpedViewRow expedRow = (SgaexpedViewRow)panelBinding.findIterBinding("SgaexpedView1Iter").getCurrentRow();
    return expedRow;
  }
  
  
  public String afegirDocExped(SgacdocViewRow cdocRow, boolean novaExped) 
  {
      String idExped = null;
      if (novaExped)
      {
        jUNavigationBar1.doAction(JUNavigationBar.BUTTON_INSERT);
        SgaexpedViewRow currentRow = getCurrentRow();
        // Seems that row is not marked as new, or existing
        currentRow.setIdexped(currentRow.getIdexped());
        getPanelBinding().getApplication().getApplicationModule().getTransaction().postChanges();
        oracle.jbo.domain.Number idExpedTempforDebug = currentRow.getIdexped();
        currentRow.afegirDocSortida(cdocRow);
        idExped = currentRow.getIdexped().toString();     
  //      jUNavigationBar1.doAction(JUNavigationBar.BUTTON_INSERT);
      }
      else 
      {
        SgaexpedViewRow currentRow = getCurrentRow();
        currentRow.afegirDocSortida(cdocRow);
        idExped = currentRow.getIdexped().toString();
      }
      
      return (idExped);
      
      
  }
  
      // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

}