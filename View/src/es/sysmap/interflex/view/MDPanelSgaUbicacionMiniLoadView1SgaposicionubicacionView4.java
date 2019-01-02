package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJUPanel;

public class MDPanelSgaUbicacionMiniLoadView1SgaposicionubicacionView4 extends SgaJUPanel 
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgaUbicacionMiniLoadView1SgaposicionubicacionView4UIModel");

// The master panel definition

  private PanelSgaUbicacionMiniLoadView1 masterViewPanel = new PanelSgaUbicacionMiniLoadView1();
// The detail panel definition
  private PanelSgaposicionubicacionView4 detailViewPanel = new PanelSgaposicionubicacionView4();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgaUbicacionMiniLoadView1SgaposicionubicacionView4()
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
    detailViewPanel.setPreferredSize(new Dimension(404, 161));
    detailViewPanel.setMinimumSize(new Dimension(404, 161));
    detailViewPanel.setMaximumSize(new Dimension(404, 161));
    this.setLayout(panelLayout);
    this.setSize(new Dimension(404, 465));
    this.setPreferredSize(new Dimension(404, 465));
    this.setMinimumSize(new Dimension(404, 465));
    this.setMaximumSize(new Dimension(404, 465));
    masterScroller.setMinimumSize(new Dimension(404, 304));
    masterScroller.setMaximumSize(new Dimension(404, 304));
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

    MDPanelSgaUbicacionMiniLoadView1SgaposicionubicacionView4 panel = new MDPanelSgaUbicacionMiniLoadView1SgaposicionubicacionView4();
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