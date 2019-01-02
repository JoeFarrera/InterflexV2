package es.sysmap.interflex.view;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.binding.JUApplication;
import oracle.jbo.uicli.controls.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import oracle.jbo.uicli.binding.JUUtil;
import java.util.ArrayList;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import java.awt.Dimension;
import sgalib.SgaRecursos;
import sgalib.SgaRunPanel;
import sgalib.SgaUtilPuesto;

public class MDPanelSgaexpedView1SgavexpeddocView1 extends JPanel implements JUPanel 
{
// Panel layout
 // Originalprivate GridLayout panelLayout = new GridLayout(3, 1);
 private GridLayout panelLayout = new GridLayout(2, 1);
  
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgaexpedView1SgavexpeddocView1UIModel");

// The master panel definition

  private PanelSgaexpedView1 masterViewPanel = new PanelSgaexpedView1();
// The detail panel definition
  private PanelSgavexpeddocView1 detailViewPanel = new PanelSgavexpeddocView1();

// The master panel definition

  private PanelSgavexpedbultoView2 bultoMasterViewPanel = new PanelSgavexpedbultoView2();
// The detail panel definition
  private PanelSgavexpedlbultoView2 bultoDetailViewPanel = new PanelSgavexpedlbultoView2();
  
  private JPanel expedPanel = new JPanel(new BorderLayout());



  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgaexpedView1SgavexpeddocView1()
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
    // Michael
    bultoMasterViewPanel.setBindingContext(_bctx);
    bultoDetailViewPanel.setBindingContext(_bctx);
    
    // this.setLayout(panelLayout);
    this.setLayout(new BorderLayout());
 
 
 
//    this.setSize(new Dimension(700, 300));
//    this.setPreferredSize(new Dimension(700, 300));
//    this.setMinimumSize(new Dimension(700, 300));
//    this.setMaximumSize(new Dimension(700, 300));
  
    expedPanel.add(masterViewPanel, BorderLayout.WEST);
    expedPanel.add(detailViewPanel, BorderLayout.CENTER);
    
    // add(expedPanel, BorderLayout.NORTH);
    expedPanel.setMaximumSize(new Dimension(700, 150));
    
    JPanel bultoPanel = new JPanel(new BorderLayout());
   // masterViewPanel.setPreferredSize(new Dimension(100, 347));
   // masterViewPanel.setMinimumSize(new Dimension(100, 347));
   // masterViewPanel.setMaximumSize(new Dimension(100, 347));
   //  masterViewPanel.setSize(new Dimension(100, 351));
    
    detailViewPanel.setPreferredSize(new Dimension(600, 100));
    detailViewPanel.setMaximumSize(new Dimension(600, 100));

    bultoDetailViewPanel.setPreferredSize(new Dimension(250, 200));
    bultoDetailViewPanel.setMinimumSize(new Dimension(250, 200));
    bultoDetailViewPanel.setMaximumSize(new Dimension(250, 200));
    bultoDetailViewPanel.setSize(new Dimension(250, 200));


    bultoPanel.add(bultoMasterViewPanel, BorderLayout.WEST);
    bultoPanel.add(bultoDetailViewPanel, BorderLayout.CENTER);
    // add(bultoPanel, BorderLayout.CENTER);
    
    JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
      expedPanel, bultoPanel);
      
    split.setDividerLocation(300);
  

    BasicSplitPaneDivider dividerContainer = (BasicSplitPaneDivider) split.getComponent(2);
    dividerContainer.setDividerSize(10);
    dividerContainer.setBackground(Color.GRAY);
 
   
    
    add(split, BorderLayout.CENTER);
    



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

    MDPanelSgaexpedView1SgavexpeddocView1 panel = new MDPanelSgaexpedView1SgavexpeddocView1();
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
      
      // Verifiquem que existeixi la propietat 'LlocTreball' definida en el fitxer
      // de propietats del pc. Si no, no deixem instanciar el panel
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      if (puesto != null)
      {
        MDPanelSgaexpedView1SgavexpeddocView1 panel = new MDPanelSgaexpedView1SgavexpeddocView1();
        _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));
        panel.setBindingContext(_runPanel.getBindingContext());
        panel.revalidate();
      }
      else
        JUMetaObjectManager.reportException(null, new Exception(SgaRecursos.getInstance().getString("Error.llocTreballNoDefinit")));
      
      return _runPanel;      
  }
  
 
}