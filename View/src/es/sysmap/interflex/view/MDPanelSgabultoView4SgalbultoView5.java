package es.sysmap.interflex.view;
import java.awt.*;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJUPanel;


public class MDPanelSgabultoView4SgalbultoView5 extends SgaJUPanel
{
// Panel layout
  private GridLayout panelLayout = new GridLayout(2, 1);
// The scrollers
  private JScrollPane masterScroller = new JScrollPane();

// Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelSgabultoView4SgalbultoView5UIModel");

// The master panel definition
  private PanelSgabultoView4 masterViewPanel = new PanelSgabultoView4();
// The detail panel definition
  private PanelSgalbultoView5 detailViewPanel = new PanelSgalbultoView5();

  /**
   * 
   *  The default constructor for panel
   */
  public MDPanelSgabultoView4SgalbultoView5()
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

    MDPanelSgabultoView4SgalbultoView5 panel = new MDPanelSgabultoView4SgalbultoView5();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "null", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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
  
}