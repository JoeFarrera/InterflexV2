package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavestadoentradaslomacViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgavestadoentradaslomacViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavestadoentradaslomacViewRowClient()
  {
  }































































































































































































































































  public boolean hasEspacioPulmon()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "hasEspacioPulmon", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean isWorkingPasillo()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "isWorkingPasillo", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean isWorkingTraslo()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "isWorkingTraslo", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean hasHuecosLibres()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "hasHuecosLibres", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public String getDescripvisual()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "getDescripvisual", null, null);
    return (String)_ret;
  }

  public boolean setUbicacionDestinoMac(oracle.jbo.domain.Number idTraslo)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "setUbicacionDestinoMac", new String[] {"oracle.jbo.domain.Number"}, new Object[] {idTraslo});
    return ((Boolean)_ret).booleanValue();
  }

  public void setUbicacionPasilloEntradaMac(oracle.jbo.domain.Number idTraslo)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "setUbicacionPasilloEntradaMac", new String[] {"oracle.jbo.domain.Number"}, new Object[] {idTraslo});
    return;
  }

  public oracle.jbo.domain.Number getIdpasillo()
  {
    return (oracle.jbo.domain.Number)getAttribute("Idpasillo");
  }

  public oracle.jbo.domain.Number getIdtraslo()
  {
    return (oracle.jbo.domain.Number)getAttribute("Idtraslo");
  }

  public String getIdubientrada()
  {
    return (String)getAttribute("Idubientrada");
  }
}