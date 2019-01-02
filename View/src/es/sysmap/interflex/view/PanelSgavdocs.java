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

public class PanelSgavdocs extends SgaJUPanel 
{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaubicacionView1UIModel");

// TabbedPane on hi ha cada tipus d'ubicació  
  private JTabbedPane tabbedPane = new JTabbedPane();

  private MDPanelSgavcdocView1SgavldocView1 sortidesPanel = new MDPanelSgavcdocView1SgavldocView1();
  private MDPanelSgavcdocView2SgavbultoView2 entradesPanel = new MDPanelSgavcdocView2SgavbultoView2();




  /**
   * 
   *  The default constructor for master-detail panel
   */
  public PanelSgavdocs()
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
    entradesPanel.setBindingContext(_bctx);
    sortidesPanel.setBindingContext(_bctx);
    this.setLayout(panelLayout);
    tabbedPane.addTab(SgaRecursos.getInstance().getString("Documents.entrades_label"), entradesPanel);
    tabbedPane.addTab(SgaRecursos.getInstance().getString("Documents.sortides_label"), sortidesPanel);
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

    PanelSgavdocs panel = new PanelSgavdocs();
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