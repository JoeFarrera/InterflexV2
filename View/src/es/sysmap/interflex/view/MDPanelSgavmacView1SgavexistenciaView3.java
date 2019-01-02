package es.sysmap.interflex.view;
import java.awt.*;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJUPanel;

public class MDPanelSgavmacView1SgavexistenciaView3 extends SgaJUPanel 
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgavmacView1SgavexistenciaView3UIModel");

// The master panel definition

  private PanelSgavmacView1 masterViewPanel = new PanelSgavmacView1();
// The detail panel definition
  private PanelSgavexistenciaView3 detailViewPanel = new PanelSgavexistenciaView3();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgavmacView1SgavexistenciaView3()
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

    MDPanelSgavmacView1SgavexistenciaView3 panel = new MDPanelSgavmacView1SgavexistenciaView3();
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