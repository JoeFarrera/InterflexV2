package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaexpeddocViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgaexpeddocViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaexpeddocViewRowClient()
  {
  }

  public void esborrarDocSortida()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "esborrarDocSortida", null, null);
    return;
  }

  public String getIdcabnum()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "getIdcabnum", null, null);
    return (String)_ret;
  }




}