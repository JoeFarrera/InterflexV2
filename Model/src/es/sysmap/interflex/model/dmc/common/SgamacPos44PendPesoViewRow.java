package es.sysmap.interflex.model.dmc.common;
import oracle.jbo.Row;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public interface SgamacPos44PendPesoViewRow extends Row 
{
  boolean isActiveBascula();

  oracle.jbo.domain.Number getPesTeoric();

  String getIdmac();

  oracle.jbo.domain.Number getIdord();

  void setPesReal(oracle.jbo.domain.Number value);

  void regularizarExistencia();

  void confirmarControlPes();

  boolean hasCantidadDiferentSegonsPes(oracle.jbo.domain.Number value);

  boolean isControladaPerPes();
}