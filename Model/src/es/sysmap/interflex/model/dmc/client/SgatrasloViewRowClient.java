package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgatrasloViewRowClient extends RowImpl 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgatrasloViewRowClient()
  {
  }

  public oracle.jbo.domain.Number getPasilloactual()
  {
    return (oracle.jbo.domain.Number)getAttribute("Pasilloactual");
  }

  public oracle.jbo.domain.Number getPasillodestino()
  {
    return (oracle.jbo.domain.Number)getAttribute("Pasillodestino");
  }

  public oracle.jbo.domain.Number getIdtraslo()
  {
    return (oracle.jbo.domain.Number)getAttribute("Idtraslo");
  }








}