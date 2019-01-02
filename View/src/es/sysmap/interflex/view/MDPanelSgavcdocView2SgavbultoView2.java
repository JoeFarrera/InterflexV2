package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import sgalib.SgaJUPanel;

// public class MDPanelSgavcdocView2SgavbultoView2 extends JPanel implements JUPanel
public class MDPanelSgavcdocView2SgavbultoView2 extends SgaJUPanel
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout(2, 1);

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgavcdocView2SgavbultoView2UIModel");

// The master panel definition

  private PanelSgavcdocView2 vcdocEntradesPanel = new PanelSgavcdocView2();
// The detail panel definition
  private PanelSgavbultoView2 vbultoPanel = new PanelSgavbultoView2();
// The detail panel definition
  private PanelSgavldocEntradesView1 vldocEntradesPanel = new PanelSgavldocEntradesView1();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgavcdocView2SgavbultoView2()
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
    vcdocEntradesPanel.setBindingContext(_bctx);
    vcdocEntradesPanel.setPreferredSize(new Dimension(791, 270));
    vcdocEntradesPanel.setMinimumSize(new Dimension(791, 270));
    vcdocEntradesPanel.setMaximumSize(new Dimension(791, 270));
    vbultoPanel.setBindingContext(_bctx);
    vbultoPanel.setPreferredSize(new Dimension(250, 347));
    vbultoPanel.setMinimumSize(new Dimension(250, 347));
    vbultoPanel.setMaximumSize(new Dimension(250, 347));
    vbultoPanel.setSize(new Dimension(250, 329));
    vldocEntradesPanel.setBindingContext(_bctx);
    this.setLayout(panelLayout);
    this.setSize(new Dimension(700, 600));
    this.setPreferredSize(new Dimension(700, 600));
    this.setMinimumSize(new Dimension(700, 600));
    this.setMaximumSize(new Dimension(700, 600));
    add(vcdocEntradesPanel, BorderLayout.NORTH);
    add(vbultoPanel, BorderLayout.WEST);
    add(vldocEntradesPanel, BorderLayout.CENTER);


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

    MDPanelSgavcdocView2SgavbultoView2 panel = new MDPanelSgavcdocView2SgavbultoView2();
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
    // Forcem el releaseBinding dels subpanels
    vldocEntradesPanel.releasePanelBinding();
    vbultoPanel.releasePanelBinding();
    vcdocEntradesPanel.releasePanelBinding();

    super.releasePanelBinding();
    
  }

  /**
   * Retorna la clau del detall seleccionat
   * @return 
   */
  public Key [] getDocumentsSeleccionat()
  {
    //Row ldocEntrades = vldocEntradesPanel.getPanelBinding().findIteratorBinding("SgavldocEntradesView1Iter").getCurrentRow();
    return vldocEntradesPanel.getSelectedRows();
    
   
  }
  
  /**
   * Estableix un filtre per no deixar veure documents finalitzats o anul·lats
   */
  public void filtrarDocuments()
  {
    vcdocEntradesPanel.filtrarDocuments();
  }

  
}