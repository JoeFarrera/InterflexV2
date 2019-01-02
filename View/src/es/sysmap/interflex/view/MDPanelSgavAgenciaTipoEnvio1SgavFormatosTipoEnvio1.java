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
import java.awt.Dimension;

// public class MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1 extends JPanel implements JUPanel 
public class MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1 extends SgaJUPanel
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1UIModel");

// The master panel definition

  private PanelSgavAgenciaTipoEnvio1 masterViewPanel = new PanelSgavAgenciaTipoEnvio1();
// The detail panel definition
  private PanelSgavFormatosTipoEnvio1 detailViewPanel = new PanelSgavFormatosTipoEnvio1();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1()
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
    this.setSize(new Dimension(390, 157));
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

    MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1 panel = new MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1();
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
/* Michael 14.03.2014 Parece que ya esta SgaJUPanel
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
  */
    public void setWhereClause(String whereClause)
  {
    masterViewPanel.setWhereClause(whereClause);    
  }
  
    public void releasePanelBinding()
  {
    masterViewPanel.releasePanelBinding();
    detailViewPanel.releasePanelBinding();
    
    super.releasePanelBinding();
  }
  
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
}