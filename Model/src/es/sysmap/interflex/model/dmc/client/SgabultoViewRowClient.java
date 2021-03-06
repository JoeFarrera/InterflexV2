package es.sysmap.interflex.model.dmc.client;
import oracle.jbo.client.remote.RowImpl;
import es.sysmap.interflex.etiquetes.EtiquetaPicking;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgabultoViewRowClient extends RowImpl implements es.sysmap.interflex.model.dmc.common.SgabultoViewRow 
{
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgabultoViewRowClient()
  {
  }














































































































































































































































































































































  public void actualitzarBulto(String estat, String puesto)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "actualitzarBulto", new String[] {"java.lang.String", "java.lang.String"}, new Object[] {estat, puesto});
    return;
  }

  public String getEstadoCabecera()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "getEstadoCabecera", null, null);
    return (String)_ret;
  }

  public void treureDeBultoSortida(oracle.jbo.domain.Number idlin)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "treureDeBultoSortida", new String[] {"oracle.jbo.domain.Number"}, new Object[] {idlin});
    return;
  }

  public javax.swing.DefaultListModel getLlistaBulto()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "getLlistaBulto", null, null);
    return (javax.swing.DefaultListModel)_ret;
  }

  public EtiquetaPicking getDadesEtiqueta()
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "getDadesEtiqueta", null, null);
    return (EtiquetaPicking)_ret;
  }

  public void modCantLineaBultoSortida(oracle.jbo.domain.Number idlin, int cantTreta)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "modCantLineaBultoSortida", new String[] {"oracle.jbo.domain.Number", "int"}, new Object[] {idlin, new Integer(cantTreta)});
    return;
  }

  public void afegirABultoSortida(oracle.jbo.domain.Number idlin, String idart, oracle.jbo.domain.Number cantot, oracle.jbo.domain.Number pes, boolean absolut)
  {
    Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this, "afegirABultoSortida", new String[] {"oracle.jbo.domain.Number", "java.lang.String", "oracle.jbo.domain.Number", "oracle.jbo.domain.Number", "boolean"}, new Object[] {idlin, idart, cantot, pes, new Boolean(absolut)});
    return;
  }

  public String getIdpuesto()
  {
    return (String)getAttribute("Idpuesto");
  }

  public String getEstado()
  {
    return (String)getAttribute("Estado");
  }

  public oracle.jbo.domain.Number getIdbulto()
  {
    return (oracle.jbo.domain.Number)getAttribute("Idbulto");
  }

  public void setImprimir(String value)
  {
    setAttribute("Imprimir", value);
  }



}