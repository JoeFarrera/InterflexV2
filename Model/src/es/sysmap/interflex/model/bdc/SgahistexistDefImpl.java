package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityDefImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgahistexistDefImpl extends EntityDefImpl 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgahistexistDefImpl()
  {
  }
  
  public SgahistexistImpl crearHistoric(DBTransaction txn, 
                                   Sgamovexist movexist)
  {
    // La entidad ya crea la clave primaria a partir de una secuencia
    SgahistexistImpl histexist = (SgahistexistImpl)super.createInstance(txn, null);
    histexist.afegirHistoric(movexist);
    return histexist;
  }
  
}