package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaTestMacViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgaTestMacViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaTestMacViewRowClient()
  {
  }

  public void insertarMac(String idubi)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "insertarMac", new String[] {"java.lang.String"}, new Object[] {idubi});
    return;
  }

  public void insertarMac(String idubi, boolean evacuar)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "insertarMac", new String[] {"java.lang.String", "boolean"}, new Object[] {idubi, new Boolean(evacuar)});
    return;
  }

  public String getIdmac()
  {
    return (String)getAttribute("Idmac");
  }






}