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
import oracle.jdeveloper.layout.*;
import sgalib.SgaJUPanel;

public class MDPanelSgauserView1SgagrantuserView1 extends SgaJUPanel
// public class MDPanelSgauserView1SgagrantuserView1 extends JPanel implements JUPanel
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgauserView1SgagrantuserView1UIModel");

// The master panel definition

  private PanelSgauserView1 masterViewPanel = new PanelSgauserView1();
// The detail panel definition
  private PanelSgagrantuserView1 detailViewPanel = new PanelSgagrantuserView1();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgauserView1SgagrantuserView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Michael 20.09.2005 No interesa que se haga un clear cache por aqu�
    // TODO - como afecta el resto de panels ????
    System.out.println("Desactivando clear cache on commit");
    panelBinding.getApplication().getApplicationModule().getTransaction().setClearCacheOnCommit(false);


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

    MDPanelSgauserView1SgagrantuserView1 panel = new MDPanelSgauserView1SgagrantuserView1();
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

}