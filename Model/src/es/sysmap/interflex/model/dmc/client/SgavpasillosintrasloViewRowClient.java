package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavpasillosintrasloViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgavpasillosintrasloViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavpasillosintrasloViewRowClient()
  {
  }










  public boolean isDisponiblePasillo()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "isDisponiblePasillo", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public oracle.jbo.domain.Number getIdpasillo()
  {
    return (oracle.jbo.domain.Number)getAttribute("Idpasillo");
  }
}