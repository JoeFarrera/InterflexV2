package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavexpeddocViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgavexpeddocViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavexpeddocViewRowClient()
  {
  }


  public void esborrarDocSortida()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "esborrarDocSortida", null, null);
    return;
  }

  public String getIdcabnum()
  {
    return (String)getAttribute("Idcabnum");
  }


}