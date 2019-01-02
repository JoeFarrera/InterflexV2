package es.sysmap.interflex.model.dmc;
import java.util.Vector;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavexistenciaViewRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgavexistenciaViewRow 
{


  public static final int IDART = 0;
  public static final int IDARTIF = 1;
  public static final int DESCARTICULO = 2;
  public static final int CANTOT = 3;
  public static final int CANRES = 4;
  public static final int CREATEDON = 5;
  public static final int MODIFIEDON = 6;
  public static final int DESCESTEXIST = 7;
  public static final int IDMAC = 8;
  public static final int DESCTIPMAC = 9;
  public static final int MULTIREF = 10;
  public static final int UBIPOS = 11;
  public static final int POSUBIPOS = 12;
  public static final int UBIDES = 13;
  public static final int POSUBIDES = 14;
  public static final int DESCVISUALPOS = 15;
  public static final int DESCVISUALDES = 16;
  public static final int IDTIPMAC = 17;
  public static final int INTEGRA = 18;
  public static final int BLOQUEO = 19;
  public static final int ESTADO = 20;
  public static final int MOTIVOBLOQUEO = 21;
  public static final int IDFORMATO = 22;
  public static final int REFFORMATO = 23;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavexistenciaViewRowImpl()
  {
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idart
   */
  public String getIdart()
  {
    return (String)getAttributeInternal(IDART);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idart
   */
  public void setIdart(String value)
  {
    setAttributeInternal(IDART, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idartif
   */
  public String getIdartif()
  {
    return (String)getAttributeInternal(IDARTIF);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idartif
   */
  public void setIdartif(String value)
  {
    setAttributeInternal(IDARTIF, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descarticulo
   */
  public String getDescarticulo()
  {
    return (String)getAttributeInternal(DESCARTICULO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descarticulo
   */
  public void setDescarticulo(String value)
  {
    setAttributeInternal(DESCARTICULO, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Cantot
   */
  public Number getCantot()
  {
    return (Number)getAttributeInternal(CANTOT);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Cantot
   */
  public void setCantot(Number value)
  {
    setAttributeInternal(CANTOT, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Canres
   */
  public Number getCanres()
  {
    return (Number)getAttributeInternal(CANRES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Canres
   */
  public void setCanres(Number value)
  {
    setAttributeInternal(CANRES, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Createdon
   */
  public FlexiDate getCreatedon()
  {
    return (FlexiDate)getAttributeInternal(CREATEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Createdon
   */
  public void setCreatedon(FlexiDate value)
  {
    setAttributeInternal(CREATEDON, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Modifiedon
   */
  public FlexiDate getModifiedon()
  {
    return (FlexiDate)getAttributeInternal(MODIFIEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Modifiedon
   */
  public void setModifiedon(FlexiDate value)
  {
    setAttributeInternal(MODIFIEDON, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descestexist
   */
  public String getDescestexist()
  {
    return (String)getAttributeInternal(DESCESTEXIST);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descestexist
   */
  public void setDescestexist(String value)
  {
    setAttributeInternal(DESCESTEXIST, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idmac
   */
  public String getIdmac()
  {
    return (String)getAttributeInternal(IDMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idmac
   */
  public void setIdmac(String value)
  {
    setAttributeInternal(IDMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Desctipmac
   */
  public String getDesctipmac()
  {
    return (String)getAttributeInternal(DESCTIPMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Desctipmac
   */
  public void setDesctipmac(String value)
  {
    setAttributeInternal(DESCTIPMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Multiref
   */
  public String getMultiref()
  {
    return (String)getAttributeInternal(MULTIREF);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Multiref
   */
  public void setMultiref(String value)
  {
    setAttributeInternal(MULTIREF, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Ubipos
   */
  public String getUbipos()
  {
    return (String)getAttributeInternal(UBIPOS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Ubipos
   */
  public void setUbipos(String value)
  {
    setAttributeInternal(UBIPOS, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Posubipos
   */
  public Number getPosubipos()
  {
    return (Number)getAttributeInternal(POSUBIPOS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Posubipos
   */
  public void setPosubipos(Number value)
  {
    setAttributeInternal(POSUBIPOS, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Ubides
   */
  public String getUbides()
  {
    return (String)getAttributeInternal(UBIDES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Ubides
   */
  public void setUbides(String value)
  {
    setAttributeInternal(UBIDES, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Posubides
   */
  public Number getPosubides()
  {
    return (Number)getAttributeInternal(POSUBIDES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Posubides
   */
  public void setPosubides(Number value)
  {
    setAttributeInternal(POSUBIDES, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descvisualpos
   */
  public String getDescvisualpos()
  {
    return (String)getAttributeInternal(DESCVISUALPOS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descvisualpos
   */
  public void setDescvisualpos(String value)
  {
    setAttributeInternal(DESCVISUALPOS, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descvisualdes
   */
  public String getDescvisualdes()
  {
    return (String)getAttributeInternal(DESCVISUALDES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descvisualdes
   */
  public void setDescvisualdes(String value)
  {
    setAttributeInternal(DESCVISUALDES, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDART:
        return getIdart();
      case IDARTIF:
        return getIdartif();
      case DESCARTICULO:
        return getDescarticulo();
      case CANTOT:
        return getCantot();
      case CANRES:
        return getCanres();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case DESCESTEXIST:
        return getDescestexist();
      case IDMAC:
        return getIdmac();
      case DESCTIPMAC:
        return getDesctipmac();
      case MULTIREF:
        return getMultiref();
      case UBIPOS:
        return getUbipos();
      case POSUBIPOS:
        return getPosubipos();
      case UBIDES:
        return getUbides();
      case POSUBIDES:
        return getPosubides();
      case DESCVISUALPOS:
        return getDescvisualpos();
      case DESCVISUALDES:
        return getDescvisualdes();
      case IDTIPMAC:
        return getIdtipmac();
      case INTEGRA:
        return getIntegra();
      case BLOQUEO:
        return getBloqueo();
      case ESTADO:
        return getEstado();
      case MOTIVOBLOQUEO:
        return getMotivoBloqueo();
      case IDFORMATO:
        return getIdformato();
      case REFFORMATO:
        return getRefformato();
      default:
        return super.getAttrInvokeAccessor(index, attrDef);
      }
  }

  /**
   * 
   *  setAttrInvokeAccessor: generated method. Do not modify.
   */
  protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDART:
        setIdart((String)value);
        return;
      case IDARTIF:
        setIdartif((String)value);
        return;
      case DESCARTICULO:
        setDescarticulo((String)value);
        return;
      case CANTOT:
        setCantot((Number)value);
        return;
      case CANRES:
        setCanres((Number)value);
        return;
      case CREATEDON:
        setCreatedon((FlexiDate)value);
        return;
      case MODIFIEDON:
        setModifiedon((FlexiDate)value);
        return;
      case DESCESTEXIST:
        setDescestexist((String)value);
        return;
      case IDMAC:
        setIdmac((String)value);
        return;
      case DESCTIPMAC:
        setDesctipmac((String)value);
        return;
      case MULTIREF:
        setMultiref((String)value);
        return;
      case UBIPOS:
        setUbipos((String)value);
        return;
      case POSUBIPOS:
        setPosubipos((Number)value);
        return;
      case UBIDES:
        setUbides((String)value);
        return;
      case POSUBIDES:
        setPosubides((Number)value);
        return;
      case DESCVISUALPOS:
        setDescvisualpos((String)value);
        return;
      case DESCVISUALDES:
        setDescvisualdes((String)value);
        return;
      case IDTIPMAC:
        setIdtipmac((String)value);
        return;
      case INTEGRA:
        setIntegra((String)value);
        return;
      case BLOQUEO:
        setBloqueo((String)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case MOTIVOBLOQUEO:
        setMotivoBloqueo((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idtipmac
   */
  public String getIdtipmac()
  {
    return (String)getAttributeInternal(IDTIPMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idtipmac
   */
  public void setIdtipmac(String value)
  {
    setAttributeInternal(IDTIPMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Integra
   */
  public String getIntegra()
  {
    return (String)getAttributeInternal(INTEGRA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Integra
   */
  public void setIntegra(String value)
  {
    setAttributeInternal(INTEGRA, value);
  }
  
  public void setSortidaIntegra(boolean bIntegra)
  {
    SgaexistenciaViewRowImpl exist = getExistencia();
    if (exist != null)
      exist.setIntegra((bIntegra ? "S" : "N"));
  }
  
  public void treureReservaNegativa()
  {
    SgaexistenciaViewRowImpl exist = getExistencia();
    exist.treureReservaNegativa();
    
  }
  
  public boolean isReservaNegativa()
  {
    return getExistencia().isReservaNegativa();
  }
  
  public void setBloqueoFromUser(boolean bloqueo, String motivo)
  {
    SgaexistenciaViewRowImpl exist = getExistencia();
    // Si se est� quitando el bloqueo, borra el valor del campo motivo bloqueo
    motivo = (bloqueo) ? motivo : null;
    if (exist != null)
      exist.setBloqueo((bloqueo ? "S" : "N"), motivo);
    
  }

  private SgaexistenciaViewRowImpl getExistencia()
  {
    SgaexistenciaViewRowImpl exist = null;
    ViewObject voexist = this.getApplicationModule().findViewObject("SgaexistenciaView1");
    Object [] obj = {getIdmac(), getIdart()};
    Key key = new Key(obj);
    Row rows [] = voexist.findByKey(key, 1);
    if (rows != null && rows.length > 0)
      exist = (SgaexistenciaViewRowImpl)rows[0];
    return exist;
  }
  
  public boolean isUbicacionManual() 
  {
    return getExistencia().isUbicacionManual();
  }

  public void regularitzarExistencia(Number cancon, String observ)
  {
    SgaexistenciaViewRowImpl exist = getExistencia();
    if (exist != null)
      exist.regularitzarExistencia(cancon, observ);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Bloqueo
   */
  public String getBloqueo()
  {
    return (String)getAttributeInternal(BLOQUEO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Bloqueo
   */
  public void setBloqueo(String value)
  {
    setAttributeInternal(BLOQUEO, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Estado
   */
  public String getEstado()
  {
    return (String)getAttributeInternal(ESTADO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Estado
   */
  public void setEstado(String value)
  {
    setAttributeInternal(ESTADO, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute MotivoBloqueo
   */
  public String getMotivoBloqueo()
  {
    return (String)getAttributeInternal(MOTIVOBLOQUEO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute MotivoBloqueo
   */
  public void setMotivoBloqueo(String value)
  {
    setAttributeInternal(MOTIVOBLOQUEO, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idformato
   */
  public Number getIdformato()
  {
    return (Number)getAttributeInternal(IDFORMATO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idformato
   */
  public void setIdformato(Number value)
  {
    setAttributeInternal(IDFORMATO, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Refformato
   */
  public String getRefformato()
  {
    return (String)getAttributeInternal(REFFORMATO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Refformato
   */
  public void setRefformato(String value)
  {
    setAttributeInternal(REFFORMATO, value);
  }

  public boolean isOKReservarTrasllat()
  {
    return getEstado().equals("L");
  }
}