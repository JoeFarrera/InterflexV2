package es.sysmap.interflex.model.dmc.common;
import oracle.jbo.Row;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public interface SgaldocViewRow extends Row 
{
  String getEstado();

  String getIdpuesto();

  void actualitzarLinia(String estat, String puesto);

  void reservarSalida(String idmac, oracle.jbo.domain.Number canres);

  String getEstadoCabecera();

  String getIdart();

  oracle.jbo.RowIterator getSgalbultoView();

  oracle.jbo.domain.Number getIdlin();

  void setEstado(String value);

  String getIdartif();



  String getModifiedby();

  void activarLinia(String idPuesto, boolean mld, boolean slo);

  oracle.jbo.domain.Number getIddoc();

  String getNalbaran();

  String getSinformato();

  void setSinformato(String value);

  String getIdcabnum();


}