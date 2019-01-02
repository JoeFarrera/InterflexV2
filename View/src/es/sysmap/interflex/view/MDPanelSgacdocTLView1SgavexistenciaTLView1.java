package es.sysmap.interflex.view;
import java.awt.*;
import javax.swing.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.binding.JUApplication;
import oracle.jbo.uicli.controls.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import oracle.jbo.uicli.binding.JUUtil;
import java.util.ArrayList;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaRunPanel;
import sgalib.SgaUtilPuesto;

public class MDPanelSgacdocTLView1SgavexistenciaTLView1 extends SgaJUPanel 
{
// Panel layout
  private GridLayout panelLayout = new GridLayout(2, 1);
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgacdocTLView1SgavexistenciaTLView1UIModel");

// The master panel definition

  private PanelSgacdocTLView1 masterViewPanel = new PanelSgacdocTLView1();
// The detail panel definition
  private PanelSgavexistenciaTLView1 detailViewPanel = new PanelSgavexistenciaTLView1();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgacdocTLView1SgavexistenciaTLView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Panel layout
    BindingContext _bctx = panelBinding.getBindingContext();
    masterViewPanel.setBindingContext(_bctx);
    detailViewPanel.setBindingContext(_bctx);
    this.setLayout(panelLayout);
    add(masterViewPanel);
    add(detailViewPanel);



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

    MDPanelSgacdocTLView1SgavexistenciaTLView1 panel = new MDPanelSgacdocTLView1SgavexistenciaTLView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }

  /**
   * 
   *  JUPanel implementation
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
  
   // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
  
  static SgaRunPanel runPanel()
  {
      SgaRunPanel _runPanel = null;

         MDPanelSgacdocTLView1SgavexistenciaTLView1 panel = new MDPanelSgacdocTLView1SgavexistenciaTLView1();
        _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));
        panel.setBindingContext(_runPanel.getBindingContext());
        panel.revalidate();
      
      return _runPanel;
      
  }
}