package es.sysmap.interflex.model.bdc;

import oracle.jbo.domain.Number;

public class Sgamovexist 
{
  private String tipmov = null;
  public String idmac = null;
  public String idart = null;
  public Number cancon = new Number(0);
  public Number canres = new Number(0);
  public Number canini = new Number(0);
  public Number canfin = new Number(0);
  public Number idbulto = new Number(0);
  public Number iddoc = new Number(0);
  public Number idlin = new Number(0);
  public String idtipdoc = null;
  public String idcabstr = null;
  public String idcabnum = null;
  public Number pesini = new Number(0);
  public Number pesfin = new Number(0);
  public String ubipos = null;
  public String observ = null;
  public String integra = null;
  public String talbaran = null;
  public String nalbaran = null;
  private String bloqueoExist = null;
  private String motivoBloqueo;
  private String existenciaEspecial = null;
  


  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public Sgamovexist()
  {
  }



  /**
   * 
   *  Gets the attribute value for existenciaEspecial, using the alias name existenciaEspecial
   */
  public String getExistenciaEspecial()
  {
    return existenciaEspecial;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for existenciaEspecial
   */
  public void setExistenciaEspecial(String value)
  {
    existenciaEspecial = value;
  }
  
  
  /**
   * 
   *  Gets the attribute value for Tipmov, using the alias name Tipmov
   */
  public String getTipmov()
  {
    return tipmov;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tipmov
   */
  public void setTipmov(String value)
  {
    tipmov = value;
  }

  /**
   * 
   *  Gets the attribute value for Idmac, using the alias name Idmac
   */
  public String getIdmac()
  {
    return idmac;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idmac
   */
  public void setIdmac(String value)
  {
    idmac = value;
  }

  /**
   * 
   *  Gets the attribute value for Idart, using the alias name Idart
   */
  public String getIdart()
  {
    return idart;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idart
   */
  public void setIdart(String value)
  {
    idart = value;
  }


  /**
   * 
   *  Gets the attribute value for Cancon, using the alias name Cancon
   */
  public Number getCancon()
  {
    return cancon;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Cancon
   */
  public void setCancon(Number value)
  {
    cancon = value;
  }


  /**
   * 
   *  Gets the attribute value for Canres, using the alias name Canres
   */
  public Number getCanres()
  {
    return canres;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Canres
   */
  public void setCanres(Number value)
  {
    canres = value;
  }


  /**
   * 
   *  Gets the attribute value for Cancon, using the alias name Cancon
   */
  public Number getCanini()
  {
    return canini;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Cancon
   */
  public void setCanini(Number value)
  {
    canini = value;
  }


  /**
   * 
   *  Gets the attribute value for Canres, using the alias name Canres
   */
  public Number getCanfin()
  {
    return canfin;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Canres
   */
  public void setCanfin(Number value)
  {
    canfin = value;
  }


  /**
   * 
   *  Gets the attribute value for Idbulto, using the alias name Idbulto
   */
  public Number getIdbulto()
  {
    return idbulto;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idbulto
   */
  public void setIdbulto(Number value)
  {
    idbulto = value;
  }

  /**
   * 
   *  Gets the attribute value for Iddoc, using the alias name Iddoc
   */
  public Number getIddoc()
  {
    return iddoc;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Iddoc
   */
  public void setIddoc(Number value)
  {
    iddoc = value;
  }

  /**
   * 
   *  Gets the attribute value for Idlin, using the alias name Idlin
   */
  public Number getIdlin()
  {
    return idlin;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idlin
   */
  public void setIdlin(Number value)
  {
    idlin = value;
  }

  /**
   * 
   *  Gets the attribute value for Idtipdoc, using the alias name Idtipdoc
   */
  public String getIdtipdoc()
  {
    return idtipdoc;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idtipdoc
   */
  public void setIdtipdoc(String value)
  {
    idtipdoc = value;
  }

  /**
   * 
   *  Gets the attribute value for Idcabstr, using the alias name Idcabstr
   */
  public String getIdcabstr()
  {
    return idcabstr;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabstr
   */
  public void setIdcabstr(String value)
  {
    idcabstr = value;
  }

  /**
   * 
   *  Gets the attribute value for Idcabnum, using the alias name Idcabnum
   */
  public String getIdcabnum()
  {
    return idcabnum;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabnum
   */
  public void setIdcabnum(String value)
  {
    idcabnum = value;
  }

  /**
   * 
   *  Gets the attribute value for Pesini, using the alias name Pesini
   */
  public Number getPesini()
  {
    return pesini;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Pesini
   */
  public void setPesini(Number value)
  {
    pesini = value;
  }

  /**
   * 
   *  Gets the attribute value for Pesfin, using the alias name Pesfin
   */
  public Number getPesfin()
  {
    return pesfin;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Pesfin
   */
  public void setPesfin(Number value)
  {
    pesfin = value;
  }

  /**
   * 
   *  Gets the attribute value for Ubipos, using the alias name Ubipos
   */
  public String getUbipos()
  {
    return ubipos;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ubipos
   */
  public void setUbipos(String value)
  {
    ubipos = value;
  }


  /**
   * 
   *  Gets the attribute value for Observ, using the alias name Observ
   */
  public String getObserv()
  {
    return observ;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Observ
   */
  public void setObserv(String value)
  {
    observ = value;
  }

  /**
   * 
   *  Gets the attribute value for Observ, using the alias name Observ
   */
  public String getIntegra()
  {
    return integra;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Observ
   */
  public void setIntegra(String value)
  {
    integra = value;
  }
 
  /**
   * 
   *  Gets the attribute value for Talbaran, using the alias name Talbaran
   */
  public String getTalbaran()
  {
    return talbaran;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Talbaran
   */
  public void setTalbaran(String value)
  {
    talbaran = value;
  }

  /**
   * 
   *  Gets the attribute value for Nalbaran, using the alias name Nalbaran
   */
  public String getNalbaran()
  {
    return nalbaran;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Nalbaran
   */
  public void setNalbaran(String value)
  {
    nalbaran = value;
  }


  /**
   * Retorna una estructura movimiento a partir del moviment d'existència
   * @return 
   */
  public Sgamovimiento getMovimiento()
  {
    Sgamovimiento movimiento = new Sgamovimiento();
    movimiento.setCantot(getCanfin().subtract(getCanini()));
    movimiento.setIdcabstr(getIdcabstr());
    movimiento.setIdcabnum(getIdcabnum());
    movimiento.setIdlin(getIdlin());
    movimiento.setIdart(getIdart());
    movimiento.setMotivo(getObserv());
    return movimiento;
  }

  public String getBloqueoExist()
  {
    return bloqueoExist;
  }

  public void setBloqueoExist(String bloqueoExist)
  {
    this.bloqueoExist = bloqueoExist;
  }

  public String getMotivoBloqueo()
  {
    return motivoBloqueo;
  }

  public void setMotivoBloqueo(String motivoBloqueo)
  {
    this.motivoBloqueo = motivoBloqueo;
  }



}