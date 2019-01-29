package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaEntradaManualRFRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgaEntradaManualRFRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaEntradaManualRFRowClient()
  {
  }

  public void validateNivell(String nivell)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "validateNivell", new String[] {"java.lang.String"}, new Object[] {nivell});
    return;
  }

  public String toStringEtiqueta()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "toStringEtiqueta", null, null);
    return (String)_ret;
  }

  public String toStringUbicació()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "toStringUbicació", null, null);
    return (String)_ret;
  }

  public void confirmarEntrada2()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "confirmarEntrada2", null, null);
    return;
  }

  public void confirmarEntrada(String nivell, String posicio)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "confirmarEntrada", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {nivell, posicio});
    return;
  }

  public void validateEtiqueta()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "validateEtiqueta", null, null);
    return;
  }



























































































































}