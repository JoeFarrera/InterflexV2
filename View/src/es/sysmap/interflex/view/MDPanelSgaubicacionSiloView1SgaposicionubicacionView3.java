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
import java.awt.Dimension;
import sgalib.SgaJUPanel;


public class MDPanelSgaubicacionSiloView1SgaposicionubicacionView3 extends SgaJUPanel
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgaubicacionSiloView1SgaposicionubicacionView3UIModel");

// The master panel definition

  private PanelSgaubicacionSiloView1 masterViewPanel = new PanelSgaubicacionSiloView1();
// The detail panel definition
  private PanelSgaposicionubicacionView3 detailViewPanel = new PanelSgaposicionubicacionView3();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgaubicacionSiloView1SgaposicionubicacionView3()
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
    detailViewPanel.setSize(new Dimension(400, 175));
    this.setLayout(panelLayout);
    this.setSize(new Dimension(440, 455));
    this.setPreferredSize(new Dimension(440, 455));
    this.setMinimumSize(new Dimension(440, 455));
    this.setMaximumSize(new Dimension(440, 455));
    masterScroller.setMinimumSize(new Dimension(424, 324));
    masterScroller.setMaximumSize(new Dimension(424, 324));
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

    MDPanelSgaubicacionSiloView1SgaposicionubicacionView3 panel = new MDPanelSgaubicacionSiloView1SgaposicionubicacionView3();
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

  // Afegit xavi
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