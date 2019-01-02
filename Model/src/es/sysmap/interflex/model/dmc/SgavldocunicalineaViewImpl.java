package es.sysmap.interflex.model.dmc;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavldocunicalineaViewImpl extends ViewObjectImpl    
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavldocunicalineaViewImpl()
  {
  }
  
  
  /**
   * El documento de salida es de una l�nea. 
   * Mirar a ver si hay otros documentos tambi�n de una l�nea
   * y el mismo art�culo. Asigna los documentos al puesto en este caso.
   * @param idPuesto
   * @param iddoc el documento a mirar si es de una s�la l�nea
   * @param idArt
   * @return n�mero de documentos asignados o 0 si ninguno
   */
  public int asignarDocsUnicaLineaMismoArticulo(String idPuesto, Number iddoc, String idArt)
  {
    int rowsAsignados = 0;
    // Crea otra instancia del view
    DBTransaction txn = getDBTransaction();
    ViewObject vo = txn.createViewObject("es.sysmap.interflex.model.dmc.SgavldocunicalineaView");
    vo.setWhereClause(null);
    vo.setWhereClause("idart = '" + idArt + "'");
    vo.executeQuery();
    vo.reset();
    while (vo.hasNext())
    {
      SgavldocunicalineaViewRowImpl otroRow = (SgavldocunicalineaViewRowImpl)vo.next();
      if (!otroRow.getIddoc().equals(iddoc))
      {
        otroRow.activarLinia(idPuesto);
        rowsAsignados++;
      }
    }
  return rowsAsignados;
  }
}