package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgalbultoViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgalbultoViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgalbultoViewRowClient()
  {
  }























































  public void reservarEntrada(String idmac, oracle.jbo.domain.Number canres)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "reservarEntrada", new String[] {"java.lang.String", "oracle.jbo.domain.Number"}, new Object[] {idmac, canres});
    return;
  }

  public oracle.jbo.domain.Number getCanent()
  {
    return (oracle.jbo.domain.Number)getAttribute("Canent");
  }

  public oracle.jbo.domain.Number getPeso()
  {
    return (oracle.jbo.domain.Number)getAttribute("Peso");
  }

  public void setEstado(String value)
  {
    setAttribute("Estado", value);
  }

  public oracle.jbo.domain.Number getIdbulto()
  {
    return (oracle.jbo.domain.Number)getAttribute("Idbulto");
  }

  public oracle.jbo.domain.Number getCantot()
  {
    return (oracle.jbo.domain.Number)getAttribute("Cantot");
  }

  public String getEstado()
  {
    return (String)getAttribute("Estado");
  }








}