package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.ViewUsageImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaRoleNotGrantedViewClient extends ViewUsageImpl implements es.sysmap.interflex.model.dmc.common.SgaRoleNotGrantedView 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaRoleNotGrantedViewClient()
  {
  }

  public javax.swing.DefaultListModel getListModel(String idUser)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "getListModel", new String[] {"java.lang.String"}, new Object[] {idUser});
    return (javax.swing.DefaultListModel)_ret;
  }


}