package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavordtranpendtraslosloViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgavordtranpendtraslosloViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavordtranpendtraslosloViewRowClient()
  {
  }

  public void setDestinoTraslo(int idTraslo)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "setDestinoTraslo", new String[] {"int"}, new Object[] {new Integer(idTraslo)});
    return;
  }

  public String toString()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "toString", null, null);
    return (String)_ret;
  }

  public void setTraslo(int idTraslo)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "setTraslo", new String[] {"int"}, new Object[] {new Integer(idTraslo)});
    return;
  }





























}