package es.sysmap.interflex.model.bdc.common;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaubicacionPlcImplMsgBundle extends SgaubicacionImplMsgBundle 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaubicacionPlcImplMsgBundle()
  {
  }

  /**
   * 
   * @return an array of key-value pairs.
   */
  public Object[][] getContents()
  {
    return super.getMergedArray(sMessageStrings, super.getContents());
  }

  static final Object[][] sMessageStrings = {
    {"Posplc_TOOLTIP", "Posici� (c�di) del PLC"},
    {"Cappul_TOOLTIP", "Capacitat de la posici�"},
    {"Cappul_LABEL", "Capacitat"},
    {"Posplc_LABEL", "Posici� PLC"}};
}