package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.ApplicationModuleImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class AppModuleClient extends ApplicationModuleImpl implements es.sysmap.interflex.model.dmc.common.AppModule 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public AppModuleClient()
  {
  }

  public es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow identificarOperacioMacEnPuesto(es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow macEnPuesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "identificarOperacioMacEnPuesto", new String[] {"es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow"}, new Object[] {macEnPuesto});
    return (es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow)_ret;
  }

  public boolean treureContenidorMagatzem(String idmac, String desti, boolean silo, String idTraslo)
  {
    Object _ret = this.riInvokeExportedMethod(this, "treureContenidorMagatzem", new String[] {"java.lang.String", "java.lang.String", "boolean", "java.lang.String"}, new Object[] {idmac, desti, new Boolean(silo), idTraslo});
    return ((Boolean)_ret).booleanValue();
  }

  public String actualitzarReferencia(java.sql.ResultSet referencia)
  {
    Object _ret = this.riInvokeExportedMethod(this, "actualitzarReferencia", new String[] {"java.sql.ResultSet"}, new Object[] {referencia});
    return (String)_ret;
  }

  public boolean assignarReservaManual(oracle.jbo.domain.Number idDoc, oracle.jbo.domain.Number idLin, String idArt, String idMac, oracle.jbo.domain.Number canRes)
  {
    Object _ret = this.riInvokeExportedMethod(this, "assignarReservaManual", new String[] {"oracle.jbo.domain.Number", "oracle.jbo.domain.Number", "java.lang.String", "java.lang.String", "oracle.jbo.domain.Number"}, new Object[] {idDoc, idLin, idArt, idMac, canRes});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean assignarTrasllatManual(String idArt, String idMac)
  {
    Object _ret = this.riInvokeExportedMethod(this, "assignarTrasllatManual", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {idArt, idMac});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean checkUser(String user, String password)
  {
    Object _ret = this.riInvokeExportedMethod(this, "checkUser", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {user, password});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean checkUsername(String user)
  {
    Object _ret = this.riInvokeExportedMethod(this, "checkUsername", new String[] {"java.lang.String"}, new Object[] {user});
    return ((Boolean)_ret).booleanValue();
  }

  public int contenidorAmbExistencies(String idmac)
  {
    Object _ret = this.riInvokeExportedMethod(this, "contenidorAmbExistencies", new String[] {"java.lang.String"}, new Object[] {idmac});
    return ((Integer)_ret).intValue();
  }

  public oracle.jbo.Key crearDocumentEntrada(String idpuesto, String idart, oracle.jbo.domain.Number cantot)
  {
    Object _ret = this.riInvokeExportedMethod(this, "crearDocumentEntrada", new String[] {"java.lang.String", "java.lang.String", "oracle.jbo.domain.Number"}, new Object[] {idpuesto, idart, cantot});
    return (oracle.jbo.Key)_ret;
  }

  public oracle.jbo.Key crearLiniaDetall(oracle.jbo.Key key, String idpuesto, String idart, oracle.jbo.domain.Number cantot)
  {
    Object _ret = this.riInvokeExportedMethod(this, "crearLiniaDetall", new String[] {"oracle.jbo.Key", "java.lang.String", "java.lang.String", "oracle.jbo.domain.Number"}, new Object[] {key, idpuesto, idart, cantot});
    return (oracle.jbo.Key)_ret;
  }

  public String createSgaExped(es.sysmap.interflex.model.dmc.common.SgacdocViewRow cdocRow)
  {
    Object _ret = this.riInvokeExportedMethod(this, "createSgaExped", new String[] {"es.sysmap.interflex.model.dmc.common.SgacdocViewRow"}, new Object[] {cdocRow});
    return (String)_ret;
  }

  public String eliminarReferencia(java.sql.ResultSet referencia)
  {
    Object _ret = this.riInvokeExportedMethod(this, "eliminarReferencia", new String[] {"java.sql.ResultSet"}, new Object[] {referencia});
    return (String)_ret;
  }

  public boolean esPuestoExtraPicking(String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "esPuestoExtraPicking", new String[] {"java.lang.String"}, new Object[] {puesto});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean esPuestoManipulacion(String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "esPuestoManipulacion", new String[] {"java.lang.String"}, new Object[] {puesto});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean existsMac(String idMac)
  {
    Object _ret = this.riInvokeExportedMethod(this, "existsMac", new String[] {"java.lang.String"}, new Object[] {idMac});
    return ((Boolean)_ret).booleanValue();
  }

  public String findIdUbi(oracle.jbo.Key k)
  {
    Object _ret = this.riInvokeExportedMethod(this, "findIdUbi", new String[] {"oracle.jbo.Key"}, new Object[] {k});
    return (String)_ret;
  }

  public String getAutoSortides(String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getAutoSortides", new String[] {"java.lang.String"}, new Object[] {puesto});
    return (String)_ret;
  }

  public String getCapacitatPulmoPuesto(String puesto, boolean isSlo)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getCapacitatPulmoPuesto", new String[] {"java.lang.String", "boolean"}, new Object[] {puesto, new Boolean(isSlo)});
    return (String)_ret;
  }

  public java.util.Vector getDisponibilitat(String idmac, String idart)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getDisponibilitat", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {idmac, idart});
    return (java.util.Vector)_ret;
  }

  public String getEstatPuesto(String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getEstatPuesto", new String[] {"java.lang.String"}, new Object[] {puesto});
    return (String)_ret;
  }

  public oracle.jbo.RowIterator getLiniesDocActual()
  {
    Object _ret = this.riInvokeExportedMethod(this, "getLiniesDocActual", null, null);
    return (oracle.jbo.RowIterator)_ret;
  }

  public int getLiniesSortidaObertes(String idPuesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getLiniesSortidaObertes", new String[] {"java.lang.String"}, new Object[] {idPuesto});
    return ((Integer)_ret).intValue();
  }

  public String getRetirarMac(String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getRetirarMac", new String[] {"java.lang.String"}, new Object[] {puesto});
    return (String)_ret;
  }

  public String getSeqExped()
  {
    Object _ret = this.riInvokeExportedMethod(this, "getSeqExped", null, null);
    return (String)_ret;
  }

  public es.sysmap.interflex.model.dmc.common.SgavubicacionlibreminiloadViewRow getUbiLibre(String rotacion)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getUbiLibre", new String[] {"java.lang.String"}, new Object[] {rotacion});
    return (es.sysmap.interflex.model.dmc.common.SgavubicacionlibreminiloadViewRow)_ret;
  }

  public String getUbicacionPuesto(String idpuesto, String magatzem)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getUbicacionPuesto", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {idpuesto, magatzem});
    return (String)_ret;
  }

  public java.util.Set getUbicsPuestoManipulacion(String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "getUbicsPuestoManipulacion", new String[] {"java.lang.String"}, new Object[] {puesto});
    return (java.util.Set)_ret;
  }

  public boolean hasMoreSortidesAuto(String iddoc)
  {
    Object _ret = this.riInvokeExportedMethod(this, "hasMoreSortidesAuto", new String[] {"java.lang.String"}, new Object[] {iddoc});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean hasResmanPendentsImprimir()
  {
    Object _ret = this.riInvokeExportedMethod(this, "hasResmanPendentsImprimir", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean hasRole(String role)
  {
    Object _ret = this.riInvokeExportedMethod(this, "hasRole", new String[] {"java.lang.String"}, new Object[] {role});
    return ((Boolean)_ret).booleanValue();
  }

  public es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow identificarOperacioMacEnPuesto(String idmac)
  {
    Object _ret = this.riInvokeExportedMethod(this, "identificarOperacioMacEnPuesto", new String[] {"java.lang.String"}, new Object[] {idmac});
    return (es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow)_ret;
  }

  public boolean imprimirPackingList(String iddoc)
  {
    Object _ret = this.riInvokeExportedMethod(this, "imprimirPackingList", new String[] {"java.lang.String"}, new Object[] {iddoc});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean insertarBulto(oracle.jbo.domain.Number iddoc, java.sql.ResultSet bulto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "insertarBulto", new String[] {"oracle.jbo.domain.Number", "java.sql.ResultSet"}, new Object[] {iddoc, bulto});
    return ((Boolean)_ret).booleanValue();
  }

  public oracle.jbo.domain.Number insertarCabecera(java.sql.ResultSet cabecera)
  {
    Object _ret = this.riInvokeExportedMethod(this, "insertarCabecera", new String[] {"java.sql.ResultSet"}, new Object[] {cabecera});
    return (oracle.jbo.domain.Number)_ret;
  }

  public boolean insertarDetalle(oracle.jbo.domain.Number iddoc, java.sql.ResultSet detalle)
  {
    Object _ret = this.riInvokeExportedMethod(this, "insertarDetalle", new String[] {"oracle.jbo.domain.Number", "java.sql.ResultSet"}, new Object[] {iddoc, detalle});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean insertarEtiqueta(oracle.jbo.domain.Number iddoc, java.sql.ResultSet etiqueta)
  {
    Object _ret = this.riInvokeExportedMethod(this, "insertarEtiqueta", new String[] {"oracle.jbo.domain.Number", "java.sql.ResultSet"}, new Object[] {iddoc, etiqueta});
    return ((Boolean)_ret).booleanValue();
  }

  public String insertarReferencia(java.sql.ResultSet referencia)
  {
    Object _ret = this.riInvokeExportedMethod(this, "insertarReferencia", new String[] {"java.sql.ResultSet"}, new Object[] {referencia});
    return (String)_ret;
  }

  public boolean isAdministrador()
  {
    Object _ret = this.riInvokeExportedMethod(this, "isAdministrador", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean isExport(String iddoc)
  {
    Object _ret = this.riInvokeExportedMethod(this, "isExport", new String[] {"java.lang.String"}, new Object[] {iddoc});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean isUserModPes()
  {
    Object _ret = this.riInvokeExportedMethod(this, "isUserModPes", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public boolean isUserModTransportista()
  {
    Object _ret = this.riInvokeExportedMethod(this, "isUserModTransportista", null, null);
    return ((Boolean)_ret).booleanValue();
  }

  public oracle.jbo.RowIterator llistaBultosPendentsImprimir(String iddoc, String idlin)
  {
    Object _ret = this.riInvokeExportedMethod(this, "llistaBultosPendentsImprimir", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {iddoc, idlin});
    return (oracle.jbo.RowIterator)_ret;
  }

  public oracle.jbo.RowIterator llistaEntradesPendentsComunicar()
  {
    Object _ret = this.riInvokeExportedMethod(this, "llistaEntradesPendentsComunicar", null, null);
    return (oracle.jbo.RowIterator)_ret;
  }

  public oracle.jbo.RowIterator llistaMovimentsPendentsComunicar()
  {
    Object _ret = this.riInvokeExportedMethod(this, "llistaMovimentsPendentsComunicar", null, null);
    return (oracle.jbo.RowIterator)_ret;
  }

  public oracle.jbo.RowIterator llistaSortidesPendentsComunicar()
  {
    Object _ret = this.riInvokeExportedMethod(this, "llistaSortidesPendentsComunicar", null, null);
    return (oracle.jbo.RowIterator)_ret;
  }

  public oracle.jbo.RowIterator llistaStocksPendentsComunicar()
  {
    Object _ret = this.riInvokeExportedMethod(this, "llistaStocksPendentsComunicar", null, null);
    return (oracle.jbo.RowIterator)_ret;
  }

  public oracle.jbo.RowSet macsEnPuesto(String ubics, String estado)
  {
    Object _ret = this.riInvokeExportedMethod(this, "macsEnPuesto", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {ubics, estado});
    return (oracle.jbo.RowSet)_ret;
  }

  public void netejarBD()
  {
    Object _ret = this.riInvokeExportedMethod(this, "netejarBD", null, null);
    return;
  }

  public boolean ordreAmbReservesManuals(oracle.jbo.domain.Number iddoc)
  {
    Object _ret = this.riInvokeExportedMethod(this, "ordreAmbReservesManuals", new String[] {"oracle.jbo.domain.Number"}, new Object[] {iddoc});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean ordreSortidaNova(oracle.jbo.domain.Number iddoc)
  {
    Object _ret = this.riInvokeExportedMethod(this, "ordreSortidaNova", new String[] {"oracle.jbo.domain.Number"}, new Object[] {iddoc});
    return ((Boolean)_ret).booleanValue();
  }

  public boolean quizasManipular(String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "quizasManipular", new String[] {"java.lang.String"}, new Object[] {puesto});
    return ((Boolean)_ret).booleanValue();
  }

  public void quizasRetirarMac(String puesto, String macEnPuesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "quizasRetirarMac", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {puesto, macEnPuesto});
    return;
  }

  public void regularizarTablaStock(String idArt, oracle.jbo.domain.Number cantot)
  {
    Object _ret = this.riInvokeExportedMethod(this, "regularizarTablaStock", new String[] {"java.lang.String", "oracle.jbo.domain.Number"}, new Object[] {idArt, cantot});
    return;
  }

  public String setAutoSortides(String puesto, String value)
  {
    Object _ret = this.riInvokeExportedMethod(this, "setAutoSortides", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {puesto, value});
    return (String)_ret;
  }

  public boolean setCapacitatPulmoPuesto(String puesto, oracle.jbo.domain.Number capacitat, boolean isSlo)
  {
    Object _ret = this.riInvokeExportedMethod(this, "setCapacitatPulmoPuesto", new String[] {"java.lang.String", "oracle.jbo.domain.Number", "boolean"}, new Object[] {puesto, capacitat, new Boolean(isSlo)});
    return ((Boolean)_ret).booleanValue();
  }

  public void setEnviarSortidaHost(String iddoc)
  {
    Object _ret = this.riInvokeExportedMethod(this, "setEnviarSortidaHost", new String[] {"java.lang.String"}, new Object[] {iddoc});
    return;
  }

  public String setEstatPuesto(String puesto, String value)
  {
    Object _ret = this.riInvokeExportedMethod(this, "setEstatPuesto", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {puesto, value});
    return (String)_ret;
  }

  public void setResmanListImpres(String iddoc)
  {
    Object _ret = this.riInvokeExportedMethod(this, "setResmanListImpres", new String[] {"java.lang.String"}, new Object[] {iddoc});
    return;
  }

  public String setRetirarMac(String puesto, String value)
  {
    Object _ret = this.riInvokeExportedMethod(this, "setRetirarMac", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {puesto, value});
    return (String)_ret;
  }

  public boolean treureContenidorMagatzem(String idmac, String desti, String puesto)
  {
    Object _ret = this.riInvokeExportedMethod(this, "treureContenidorMagatzem", new String[] {"java.lang.String", "java.lang.String", "java.lang.String"}, new Object[] {idmac, desti, puesto});
    return ((Boolean)_ret).booleanValue();
  }




















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































}