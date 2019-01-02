package es.sysmap.interflex.viewtest;
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

public class MDPanelSgavexpedbultoView2SgavexpedlbultoView2 extends JPanel implements JUPanel 
{
// Panel layout
  private GridLayout panelLayout = new GridLayout(2, 1);
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgavexpedbultoView2SgavexpedlbultoView2UIModel");

// The master panel definition

  private PanelSgavexpedbultoView2 masterViewPanel = new PanelSgavexpedbultoView2();
// The detail panel definition
  private PanelSgavexpedlbultoView2 detailViewPanel = new PanelSgavexpedlbultoView2();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgavexpedbultoView2SgavexpedlbultoView2()
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

    MDPanelSgavexpedbultoView2SgavexpedlbultoView2 panel = new MDPanelSgavexpedbultoView2SgavexpedlbultoView2();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl11", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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