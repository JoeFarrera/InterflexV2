package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavexistenciaViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgavexistenciaViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavexistenciaViewRowClient()
  {
  }































































































































































































































































































































  public boolean isOKReservarTrasllat()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "isOKReservarTrasllat", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean isReservaNegativa()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "isReservaNegativa", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean isUbicacionManual()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "isUbicacionManual", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public void regularitzarExistencia(oracle.jbo.domain.Number cancon, String observ)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "regularitzarExistencia", new String[] {"oracle.jbo.domain.Number", "java.lang.String"}, new Object[] {cancon, observ});
    return;
  }

  public void setBloqueoFromUser(boolean bloqueo, String motivo)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "setBloqueoFromUser", new String[] {"boolean", "java.lang.String"}, new Object[] {new Boolean(bloqueo), motivo});
    return;
  }

  public void setSortidaIntegra(boolean bIntegra)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "setSortidaIntegra", new String[] {"boolean"}, new Object[] {new Boolean(bIntegra)});
    return;
  }

  public void setUserEspecial(String value)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "setUserEspecial", new String[] {"java.lang.String"}, new Object[] {value});
    return;
  }

  public void treureReservaNegativa()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "treureReservaNegativa", null, null);
    return;
  }

  public oracle.jbo.domain.Number getCantot()
  {
    return (oracle.jbo.domain.Number)getAttribute("Cantot");
  }

  public String getIdart()
  {
    return (String)getAttribute("Idart");
  }

  public String getIdmac()
  {
    return (String)getAttribute("Idmac");
  }

  public String getIdtipmac()
  {
    return (String)getAttribute("Idtipmac");
  }

  public String getMotivoBloqueo()
  {
    return (String)getAttribute("MotivoBloqueo");
  }







}