package es.sysmap.interflex.view;

import java.awt.*;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgaubicacionView1 extends SgaJUPanel 
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaubicacionView1UIModel");

// TabbedPane on hi ha cada tipus d'ubicació  
  private JTabbedPane tabbedPane = new JTabbedPane();

  private PanelSgaubicacionManualView1 ubicacionManualPanel = new PanelSgaubicacionManualView1();
  private MDPanelSgaUbicacionMiniLoadView1SgaposicionubicacionView4 ubicacionMiniLoadPanel = new MDPanelSgaUbicacionMiniLoadView1SgaposicionubicacionView4();
  private MDPanelSgaubicacionSiloView1SgaposicionubicacionView3 ubicacionSiloPanel = new MDPanelSgaubicacionSiloView1SgaposicionubicacionView3();


  /**
   * 
   *  The default constructor for master-detail panel
   */
  public PanelSgaubicacionView1()
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
    ubicacionManualPanel.setBindingContext(_bctx);
    ubicacionMiniLoadPanel.setBindingContext(_bctx);
    ubicacionSiloPanel.setBindingContext(_bctx);
    this.setLayout(panelLayout);
    tabbedPane.addTab(SgaRecursos.getInstance().getString("Ubicacions.miniLoad_label"), ubicacionMiniLoadPanel);
    tabbedPane.addTab(SgaRecursos.getInstance().getString("Ubicacions.silo_label"), ubicacionSiloPanel);
    tabbedPane.addTab(SgaRecursos.getInstance().getString("Ubicacions.manual_label"), ubicacionManualPanel);
    add(tabbedPane, BorderLayout.CENTER);

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

    PanelSgaubicacionView1 panel = new PanelSgaubicacionView1();
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

  
}