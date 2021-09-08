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
import sgalib.SgaRunPanel;
import sgalib.SgaUtilPuesto;

public class MDPanelSgacdocSortidesView3SgaldocView6 extends SgaJUPanel
{
// Panel layout
  private GridLayout panelLayout = new GridLayout(2, 1);
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgacdocSortidesView3SgaldocView6UIModel");

// The master panel definition

  private PanelSgacdocSortidesView2 masterViewPanel = new PanelSgacdocSortidesView2(true);
// The detail panel definition
  private PanelSgaldocView5 detailViewPanel = new PanelSgaldocView5();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgacdocSortidesView3SgaldocView6()
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

    MDPanelSgacdocSortidesView3SgaldocView6 panel = new MDPanelSgacdocSortidesView3SgaldocView6();
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

  
  static SgaRunPanel runPanel()
  {
      SgaRunPanel _runPanel = null;
      
      // Verifiquem que existeixi la propietat 'LlocTreball' definida en el fitxer
      // de propietats del pc. Si no, no deixem instanciar el panel
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      if (puesto != null)
      {
        MDPanelSgacdocSortidesView3SgaldocView6 panel = new MDPanelSgacdocSortidesView3SgaldocView6();
        _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));
        panel.setBindingContext(_runPanel.getBindingContext());
        panel.revalidate();
      }
      else
        JUMetaObjectManager.reportException(null, new Exception(SgaRecursos.getInstance().getString("Error.llocTreballNoDefinit")));
      
      return _runPanel;      
  }
  
}