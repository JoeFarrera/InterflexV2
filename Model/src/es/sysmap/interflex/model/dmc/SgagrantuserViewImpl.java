package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewObjectImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgagrantuserViewImpl extends ViewObjectImpl implements es.sysmap.interflex.model.dmc.common.SgagrantuserView 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgagrantuserViewImpl()
  {
  }

  /**
   * Ver si el usuario tiene el role definido
   * @return true si tiene el role especificado, <em> o si es un administrador </em>
   * @param idRole
   * @param idUser
   */
  public boolean hasRole(String idUser, String idRole)
  {
    setWhereClause(null);
    setWhereClause("iduser = '" + idUser + "'" + " and (idRoleGranted = '" + idRole + "' or idRoleGranted = 'SGAADMINISTRADOR')");
    reset();
    // Not needed ??? executeQuery();
    clearCache();
    int rowCount = getRowCount();
    return rowCount > 0;
  }

  public Object[] getRowFilterValues()
  {
    // TODO:  Override this oracle.jbo.server.ViewObjectImpl method
    return super.getRowFilterValues();
  }

}