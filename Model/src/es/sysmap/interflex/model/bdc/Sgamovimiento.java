package es.sysmap.interflex.model.bdc;

import oracle.jbo.domain.Number;

public class Sgamovimiento 
{
  public Number cantot = new Number(0);
  public String idcabstr = null;
  public String idcabnum = null;
  public Number idlin = new Number(0);
  public Number tipord = new Number(0);
  private Number objeto = null;
  private String tipalbaran = null;
  public Number numalbaran = new Number(0);
  private String idart = null;
  private String iduser = null;
  private String motivo = null;
  
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public Sgamovimiento()
  {
  }


  /**
   * 
   *  Gets the attribute value for Cancon, using the alias name Cancon
   */
  public Number getCantot()
  {
    return cantot;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Cancon
   */
  public void setCantot(Number value)
  {
    cantot = value;
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
   *  Gets the attribute value for Idlin, using the alias name Idlin
   */
  public Number getTipord()
  {
    return tipord;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idlin
   */
  public void setTipord(Number value)
  {
    tipord = value;
  }


  /**
   * 
   *  Gets the attribute value for Idcabstr, using the alias name Idcabstr
   */
  public Number getObjeto()
  {
    return objeto;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabstr
   */
  public void setObjeto(Number value)
  {
    objeto = value;
  }


  /**
   * 
   *  Gets the attribute value for Idcabstr, using the alias name Idcabstr
   */
  public String getTipalbaran()
  {
    return tipalbaran;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabstr
   */
  public void setTipalbaran(String value)
  {
    tipalbaran = value;
  }


  /**
   * 
   *  Gets the attribute value for Cancon, using the alias name Cancon
   */
  public Number getNumalbaran()
  {
    return numalbaran;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Cancon
   */
  public void setNumalbaran(Number value)
  {
    numalbaran = value;
  }

  /**
   * 
   *  Gets the attribute value for Idcabstr, using the alias name Idcabstr
   */
  public String getIdart()
  {
    return idart;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabstr
   */
  public void setIdart(String value)
  {
    idart = value;
  }

  /**
   * 
   *  Gets the attribute value for Idcabstr, using the alias name Idcabstr
   */
  public String getIduser()
  {
    return iduser;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabstr
   */
  public void setIduser(String value)
  {
    iduser = value;
  }


 /**
   * 
   *  Gets the attribute value for Motivo, using the alias name
   */
  public String getMotivo()
  {
    return motivo;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabstr
   */
  public void setMotivo(String value)
  {
    motivo = value;
  }


}