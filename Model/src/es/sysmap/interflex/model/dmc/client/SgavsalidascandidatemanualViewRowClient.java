package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavsalidascandidatemanualViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgavsalidascandidatemanualViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavsalidascandidatemanualViewRowClient()
  {
  }

  public void reservarSalida()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "reservarSalida", null, null);
    return;
  }

  public String toString()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "toString", null, null);
    return (String)_ret;
  }















}