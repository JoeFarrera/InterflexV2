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

public class MDPanelSgavsummacSenseExistenciesView1SgavmacSenseExistenciesView2 extends SgaJUPanel
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgavsummacSenseExistenciesView1SgavmacSenseExistenciesView2UIModel");

// The master panel definition

  private PanelSgavsummacSenseExistenciesView1 masterViewPanel = new PanelSgavsummacSenseExistenciesView1();
// The detail panel definition
  private PanelSgavmacSenseExistenciesView1 detailViewPanel = new PanelSgavmacSenseExistenciesView1();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgavsummacSenseExistenciesView1SgavmacSenseExistenciesView2()
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
    masterViewPanel.setMinimumSize(new Dimension(800, 150));
    masterViewPanel.setBorder(BorderFactory.createTitledBorder(""));
    masterViewPanel.setPreferredSize(new Dimension(800, 150));
    masterViewPanel.setMaximumSize(new Dimension(800, 150));

    detailViewPanel.setBindingContext(_bctx);
    detailViewPanel.setSize(new Dimension(800, 400));
    detailViewPanel.setPreferredSize(new Dimension(800, 400));
    detailViewPanel.setMinimumSize(new Dimension(800, 400));
    detailViewPanel.setMaximumSize(new Dimension(800, 400));

    this.setLayout(panelLayout);
    this.setSize(new Dimension(800, 600));
    this.setPreferredSize(new Dimension(800, 600));
    this.setMinimumSize(new Dimension(800, 600));
    this.setMaximumSize(new Dimension(800, 600));
    add(masterViewPanel, BorderLayout.NORTH);
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

    MDPanelSgavsummacSenseExistenciesView1SgavmacSenseExistenciesView2 panel = new MDPanelSgavsummacSenseExistenciesView1SgavmacSenseExistenciesView2();
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
  
  //Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }


  public void releasePanelBinding()
  {
    masterViewPanel.releasePanelBinding();
    detailViewPanel.releasePanelBinding();
    
    super.releasePanelBinding();
  }
  
}