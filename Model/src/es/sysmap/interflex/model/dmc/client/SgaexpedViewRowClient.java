package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaexpedViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgaexpedViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaexpedViewRowClient()
  {
  }






















































































































































  public void afegirDocSortida(es.sysmap.interflex.model.dmc.common.SgacdocViewRow cdocRow)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "afegirDocSortida", new String[] {"es.sysmap.interflex.model.dmc.common.SgacdocViewRow"}, new Object[] {cdocRow});
    return;
  }

  public void esborrarDocSortida(es.sysmap.interflex.model.dmc.common.SgacdocViewRow cdocRow)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "esborrarDocSortida", new String[] {"es.sysmap.interflex.model.dmc.common.SgacdocViewRow"}, new Object[] {cdocRow});
    return;
  }

  public oracle.jbo.domain.Number getIdexped()
  {
    return (oracle.jbo.domain.Number)getAttribute("Idexped");
  }

  public void setIdexped(oracle.jbo.domain.Number value)
  {
    setAttribute("Idexped", value);
  }
}