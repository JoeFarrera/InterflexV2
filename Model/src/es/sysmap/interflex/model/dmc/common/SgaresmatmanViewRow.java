package es.sysmap.interflex.model.dmc.common;
import oracle.jbo.Row;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public interface SgaresmatmanViewRow extends Row 
{
  void confirmarReserva();

  void crearBultos_(String tipoCarga, oracle.jbo.domain.Number canbulto, boolean bFraccionar, boolean tancarBulto);

  oracle.jbo.domain.Number getIddoc();

  void anularReserva(boolean bAnularPendent);

  oracle.jbo.domain.Number getIdlin();


  String getIdcabstr();

  oracle.jbo.domain.Number nouBulto(String tipoCarga);

  String getIdcabnum();

  void setIdcabnum(String value);

  oracle.jbo.domain.Number getBultoman();

  oracle.jbo.domain.Number getBultomld();

  oracle.jbo.domain.Number getBultoslo();


  void tancarBulto(String tipoCarga);

  void setNalbaran(String value);

  String getNalbaran();

  void crearBultos_(String tipoCarga, oracle.jbo.domain.Number[] canbulto, boolean bFraccionar, boolean tancarBulto);


}