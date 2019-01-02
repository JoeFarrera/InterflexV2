package sgalib;

import javax.swing.JPanel;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCBindingContainerDef;
import oracle.adf.model.binding.DCDataControl;

import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.JUPanel;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

public abstract class SgaJUPanel extends JPanel implements JUPanel
{
  
  //public abstract void setBindingContext(BindingContext bindCtx);

  public void setBindingContext(BindingContext bindCtx)
  {
    // Afegit xavi
    createPanelBinding(bindCtx);
    JUPanelBinding panelBinding = getPanelBinding();
    // Fi afegit xavi
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      panelBinding.refreshControl();
      try
      {
        //Afegit xavi
        setPanelBinding(panelBinding);
        // Fi afegit xavi
        jbInit();
        panelBinding.refreshControl();
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }
    }
  }
  
  /**
   * Si no existeix el binding per detailBCName, el crea
   * @param detailBCName
   * @param panel
   */
  public void createPanelBinding(BindingContext bindCtx)
  {
    String BCName = getPanelBinding().getName();
    
    if (bindCtx.get(BCName) == null)
    {
      DCBindingContainerDef bcdef = (DCBindingContainerDef)JUMetaObjectManager.getJUMom().findLoadedObject("es.sysmap.interflex.view."+BCName);
      DCBindingContainer bc = bcdef.createBindingContainer(bindCtx);
      bc.setName(BCName);
      bindCtx.put(BCName, bc);
    }
  }

  /**
   * Allibera els bindings per un panel
   * @param panel
   */
  public void releasePanelBinding()
  {
    getPanelBinding().release(DCDataControl.REL_VIEW_REFS);
    getPanelBinding().getBindingContext().remove(getPanelBinding().getName());
  }

  private void unRegisterProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.unRegisterNavigationBarInterface(getPanelBinding(), bindCtx);
  }

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(getPanelBinding(), bindCtx);
  }

  public abstract void jbInit() throws Exception;
  
  public abstract void setPanelBinding(JUPanelBinding panelBinding);
}