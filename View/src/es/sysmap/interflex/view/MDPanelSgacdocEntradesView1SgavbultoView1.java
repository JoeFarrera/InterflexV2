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
import sgalib.SgaRecursos;
import sgalib.SgaRunPanel;
import sgalib.SgaUtilPuesto;


public class MDPanelSgacdocEntradesView1SgavbultoView1 extends SgaJUPanel
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgacdocEntradesView1SgavbultoView1UIModel");

// The master panel definition

  private PanelSgacdocEntradesView1 cdocEntradesPanel = new PanelSgacdocEntradesView1();
// The detail panel definition
  private PanelSgabultoView1 bultoPanel = new PanelSgabultoView1();

// The detail panel definition
  private PanelSgaldocEntradesView1 ldocEntradesPanel = new PanelSgaldocEntradesView1();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgacdocEntradesView1SgavbultoView1()
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
    cdocEntradesPanel.setBindingContext(_bctx);
//    cdocEntradesPanel.setPreferredSize(new Dimension(791, 270));
//    cdocEntradesPanel.setMinimumSize(new Dimension(791, 270));
//    cdocEntradesPanel.setMaximumSize(new Dimension(791, 270));
    bultoPanel.setBindingContext(_bctx);
    bultoPanel.setPreferredSize(new Dimension(250, 347));
    bultoPanel.setMinimumSize(new Dimension(250, 347));
    bultoPanel.setMaximumSize(new Dimension(250, 347));
    bultoPanel.setSize(new Dimension(250, 351));
    ldocEntradesPanel.setBindingContext(_bctx);
    ldocEntradesPanel.setPreferredSize(new Dimension(553, 351));
    ldocEntradesPanel.setMinimumSize(new Dimension(553, 351));
    this.setLayout(panelLayout);
//    this.setSize(new Dimension(700, 600));
//    this.setPreferredSize(new Dimension(700, 600));
//    this.setMinimumSize(new Dimension(700, 600));
//    this.setMaximumSize(new Dimension(700, 600));
    add(cdocEntradesPanel, BorderLayout.NORTH);
    add(bultoPanel, BorderLayout.WEST);
    add(ldocEntradesPanel, BorderLayout.CENTER);



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

    MDPanelSgacdocEntradesView1SgavbultoView1 panel = new MDPanelSgacdocEntradesView1SgavbultoView1();
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
    ldocEntradesPanel.releasePanelBinding();
    bultoPanel.releasePanelBinding();
    cdocEntradesPanel.releasePanelBinding();
    
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
        MDPanelSgacdocEntradesView1SgavbultoView1 panel = new MDPanelSgacdocEntradesView1SgavbultoView1();
        _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));
        panel.setBindingContext(_runPanel.getBindingContext());
        panel.revalidate();
      }
      else
        JUMetaObjectManager.reportException(null, new Exception(SgaRecursos.getInstance().getString("Error.llocTreballNoDefinit")));
      
      return _runPanel;      
  }
  
}