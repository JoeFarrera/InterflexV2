package es.sysmap.interflex.view;
import java.awt.*;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import sgalib.SgaJUPanel;

public class MDPanelSgavcdocView1SgavldocView1 extends SgaJUPanel
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgavcdocView1SgavldocView1UIModel");

// The master panel definition

  private PanelSgavcdocView1 masterViewPanel = new PanelSgavcdocView1();
// The detail panel definition
  private PanelSgavldocView1 detailViewPanel = new PanelSgavldocView1();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgavcdocView1SgavldocView1()
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

    MDPanelSgavcdocView1SgavldocView1 panel = new MDPanelSgavcdocView1SgavldocView1();
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
    detailViewPanel.releasePanelBinding();
    masterViewPanel.releasePanelBinding();

    super.releasePanelBinding();
  }

  public void setWhereClause(String whereClause)
  {
    masterViewPanel.setWhereClause(whereClause);    
  }
  
}