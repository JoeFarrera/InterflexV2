package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaRefCodesViewRowClient extends RowImpl 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaRefCodesViewRowClient()
  {
  }

  public String getAbbreviation()
  {
    return (String)getAttribute("Abbreviation");
  }

  public String getValue()
  {
    return (String)getAttribute("Value");
  }



}