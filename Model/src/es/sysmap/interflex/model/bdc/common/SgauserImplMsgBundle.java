package es.sysmap.interflex.model.bdc.common;
import oracle.jbo.common.JboResourceBundle;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgauserImplMsgBundle extends JboResourceBundle 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgauserImplMsgBundle()
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
    {"Idpassword_LABEL", "Paraula de pas"},
    {"Iduser_TOOLTIP", "Identificador de l'usuari"},
    {"Iduser_LABEL", "Id. Usuari"},
    {"Descrip_TOOLTIP", "Breu descripció de l'usuari"},
    {"Descrip_LABEL", "Descripció"},
    {"Idpassword_TOOLTIP", "Paraula de pas per a l'usuari"}};



}