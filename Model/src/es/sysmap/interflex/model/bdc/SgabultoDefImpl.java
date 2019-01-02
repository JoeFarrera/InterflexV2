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
import org.apache.log4j.Logger;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgabultoDefImpl extends EntityDefImpl 
{
  private Logger LOG = Logger.getLogger(getClass());
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgabultoDefImpl()
  {
  }
  
  public boolean insertarBulto(DBTransaction txn, 
                                   Number iddoc, ResultSet bultoRs) 
  {
    try
    {
      /*Object [] obj = {iddoc, new Number(bultoRs.getBigDecimal("bul_id"))};
      Key key = new Key(obj); 
      SgabultoImpl bulto = (SgabultoImpl)findByPrimaryKey(txn, key);*/
      
      if (bultoExist(txn, iddoc, new Number(bultoRs.getBigDecimal("bul_id"))))
      {
        LOG.debug("Bulto " + bultoRs.getBigDecimal("bul_id").toString() + " pel document " + iddoc.toString() + " ja existeix");
        return true;
      }
      else
      {
        LOG.debug("Creant bulto " + bultoRs.getBigDecimal("bul_id").toString() + " pel document " + iddoc.toString());
        SgabultoImpl bulto = (SgabultoImpl)super.createInstance(txn, null);
        // Xavi, 10/11/05
        //return bulto.insertarBulto(iddoc, bultoRs);
        return bulto.insertarBulto(iddoc, new Number(bultoRs.getBigDecimal("bul_id")));
      }
    }
    catch(SQLException ex)
    {
      return false;
    }
  }  
  
  private boolean bultoExist(DBTransaction txn, Number iddoc, Number idbulto)
  {
    boolean trobat = false;
    ViewObject vo = getBultoExistView(txn);
    if (vo != null)
    {
      // Xavi, 10/11/05: Netejar la cache abans d'executar la consulta
      vo.clearCache();
      vo.setWhereClauseParam(0, iddoc);
      vo.setWhereClauseParam(1, idbulto);
      vo.setForwardOnly(true);
      vo.executeQuery();
      return (vo.first() != null);
    }
    return trobat;
  }


  private ViewObject getBultoExistView(DBTransaction txn)
  {
    ApplicationModule root = txn.getRootApplicationModule();
    return(root.findViewObject("SgabultoExistView1"));
  }
  
  
}