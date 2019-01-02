package es.sysmap.interflex.controltest;
import java.awt.*;
import javax.swing.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.binding.JUApplication;
import oracle.jbo.uicli.controls.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import oracle.jbo.uicli.binding.JUUtil;
import java.util.ArrayList;
import oracle.jdeveloper.layout.*;

public class MDPanelSgaventradaspendienteView1SgavdisponibleentradaView2 extends JPanel implements JUPanel 
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgaventradaspendienteView1SgavdisponibleentradaView2UIModel");

// The master panel definition

  private PanelSgaventradaspendienteView1 masterViewPanel = new PanelSgaventradaspendienteView1();
// The detail panel definition
  private PanelSgavdisponibleentradaView2 detailViewPanel = new PanelSgavdisponibleentradaView2();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgaventradaspendienteView1SgavdisponibleentradaView2()
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
    masterScroller.getViewport().add(masterViewPanel);
    add(masterScroller, BorderLayout.NORTH);
    add(detailViewPanel, BorderLayout.CENTER);



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

    MDPanelSgaventradaspendienteView1SgavdisponibleentradaView2 panel = new MDPanelSgaventradaspendienteView1SgavdisponibleentradaView2();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "TestAppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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
}