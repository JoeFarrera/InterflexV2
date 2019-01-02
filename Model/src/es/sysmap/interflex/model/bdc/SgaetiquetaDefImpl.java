package es.sysmap.interflex.model.bdc;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaetiquetaDefImpl extends EntityDefImpl 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaetiquetaDefImpl()
  {
  }
  
  /**
   * Si la etiqueta ya existe, devolverlo. Si no, crea un registro
   * @return true si se ha podido crear o recuperar el registro
   * @param etiqueta
   * @param iddoc
   * @param txn
   */
  public boolean insertarEtiqueta(DBTransaction txn, 
                                   Number iddoc, ResultSet etiqueta) 
  {
    try
    {
      String cabstr = etiqueta.getString("eti_tid").trim();
      Number cabnum = new Number(etiqueta.getBigDecimal("eti_id"));
      Row row = etiquetaExist(txn, iddoc);
      if (row != null)
      {
        return true;
      }
 
    // La entidad ya crea la clave primaria a partir de una secuencia
    SgaetiquetaImpl etiquetaImpl = (SgaetiquetaImpl)super.createInstance(txn, null);
    return etiquetaImpl.insertarEtiqueta(iddoc, etiqueta);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }  
  
  private Row etiquetaExist(DBTransaction txn, Number iddoc)
  {
    Row row = null;
    ViewObject vo = getetiquetaExistView(txn);
    if (vo != null)
    {
      vo.setWhereClauseParam(0, iddoc);
      vo.setForwardOnly(true);
      vo.executeQuery();
      row = vo.first();
    }
    return row;
  }

  private ViewObject getetiquetaExistView(DBTransaction txn)
  {
    ApplicationModule root = txn.getRootApplicationModule();
    return(root.findViewObject("SgaetiquetaExist1"));
  }

 
}