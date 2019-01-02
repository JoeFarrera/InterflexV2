package es.sysmap.interflex.model.bdc;

import oracle.jbo.domain.Number;

public class Sgaaveria 
{
  private Number idtraslo = new Number(0);
  private Number temps = new Number(0);
  private String estado = null;
  private String ubiori = null;
  private Number posubiori = new Number(0);
  private String ubides = null;
  private Number posubides = new Number(0);
  private Number idord = new Number(0);
  private Number pasilloactual = new Number(0);
  private Number pasillodestino = new Number(0);
  
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public Sgaaveria()
  {
  }


  /**
   * 
   *  Gets the attribute value for Idtraslo, using the alias name Idtraslo
   */
  public Number getIdtraslo()
  {
    return idtraslo;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idtraslo
   */
  public void setIdtraslo(Number value)
  {
    idtraslo = value;
  }


  /**
   * 
   *  Gets the attribute value for Temps, using the alias name Idtraslo
   */
  public Number getTemps()
  {
    return temps;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Temps
   */
  public void setTemps(Number value)
  {
    temps = value;
  }


  /**
   * 
   *  Gets the attribute value for Estado, using the alias name Estado
   */
  public String getEstado()
  {
    return estado;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Estado
   */
  public void setEstado(String value)
  {
    estado = value;
  }

  /**
   * 
   *  Gets the attribute value for Ubiori, using the alias name Ubiori
   */
  public String getUbiori()
  {
    return ubiori;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ubiori
   */
  public void setUbiori(String value)
  {
    ubiori = value;
  }

  /**
   * 
   *  Gets the attribute value for PosUbiOri, using the alias name PosUbiOri
   */
  public Number getPosUbiOri()
  {
    return posubiori;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for PosUbiOri
   */
  public void setPosUbiOri(Number value)
  {
    posubiori = value;
  }


  /**
   * 
   *  Gets the attribute value for Ubides, using the alias name Ubides
   */
  public String getUbides()
  {
    return ubides;
  }


  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ubides
   */
  public void setUbides(String value)
  {
    ubides = value;
  }


  /**
   * 
   *  Gets the attribute value for PosUbiDes, using the alias name PosUbiDes
   */
  public Number getPosUbiDes()
  {
    return posubides;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for PosUbiOri
   */
  public void setPosUbiDes(Number value)
  {
    posubides = value;
  }


  /**
   * 
   *  Gets the attribute value for Idord, using the alias name Idord
   */
  public Number getIdord()
  {
    return idord;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idord
   */
  public void setIdord(Number value)
  {
    idord = value;
  }


  /**
   * 
   *  Gets the attribute value for PasilloActual, using the alias name PasilloActual
   */
  public Number getPasilloActual()
  {
    return pasilloactual;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for PasilloActual
   */
  public void setPasilloActual(Number value)
  {
    pasilloactual = value;
  }


  /**
   * 
   *  Gets the attribute value for PasilloDestino, using the alias name PasilloDestino
   */
  public Number getPasilloDestino()
  {
    return pasillodestino;
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for PasilloDestino
   */
  public void setPasilloDestino(Number value)
  {
    pasillodestino = value;
  }



}