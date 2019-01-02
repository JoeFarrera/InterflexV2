package es.sysmap.interflex.view;
import java.awt.*;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJUPanel;

public class MDPanelSgavsumexistenciaView1SgavexistenciaView2 extends SgaJUPanel 

{
// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();
  private JScrollPane detailScroller = new JScrollPane();

// Panel binding definition used by design time

  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgavsumexistenciaView1SgavexistenciaView2UIModel");

// The master panel definition

  private PanelSgavsumexistenciaView1 masterViewPanel = new PanelSgavsumexistenciaView1();
// The detail panel definition
  private PanelSgavexistenciaView2 detailViewPanel = new PanelSgavexistenciaView2();
  
  



  /**
   * 
   *  The default constructor for master-detail panel
   */
  public MDPanelSgavsumexistenciaView1SgavexistenciaView2()
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
    
    // Michael ReservaManual 09.10.2014
   



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

    MDPanelSgavsumexistenciaView1SgavexistenciaView2 panel = new MDPanelSgavsumexistenciaView1SgavexistenciaView2();
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
  
  public void setWhereClause(String whereClause)
  {
    masterViewPanel.setWhereClause(whereClause);    
  }
  
  public void setIddoc (oracle.jbo.domain.Number iddoc, oracle.jbo.domain.Number idlin, String idcabnum) 
  {
    detailViewPanel.setIddoc(iddoc, idlin, idcabnum);
  }
  
  public void setIddocTL (oracle.jbo.domain.Number iddoc) 
  {
    detailViewPanel.setIddocTL (iddoc);
  }

  
}