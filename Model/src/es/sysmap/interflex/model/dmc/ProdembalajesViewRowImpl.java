package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class ProdembalajesViewRowImpl extends ViewRowImpl 
{


  public static final int IDFORMATO = 0;
  public static final int REFFORMATO = 1;
  public static final int DESCRIPCION = 2;
  public static final int EP = 3;
  public static final int ALTO = 4;
  public static final int ANCHO = 5;
  public static final int LARGO = 6;
  public static final int PRODEMBALAJESREFERENCIAVIEW = 7;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public ProdembalajesViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Prodembalajes entity object.
   */
  public es.sysmap.interflex.model.bdc.ProdembalajesImpl getProdembalajes()
  {
    return (es.sysmap.interflex.model.bdc.ProdembalajesImpl)getEntity(0);
  }

  /**
   * 
   *  Gets the attribute value for IDFORMATO using the alias name Idformato
   */
  public Number getIdformato()
  {
    return (Number)getAttributeInternal(IDFORMATO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDFORMATO using the alias name Idformato
   */
  public void setIdformato(Number value)
  {
    setAttributeInternal(IDFORMATO, value);
  }

  /**
   * 
   *  Gets the attribute value for REFFORMATO using the alias name Refformato
   */
  public String getRefformato()
  {
    return (String)getAttributeInternal(REFFORMATO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for REFFORMATO using the alias name Refformato
   */
  public void setRefformato(String value)
  {
    setAttributeInternal(REFFORMATO, value);
  }

  /**
   * 
   *  Gets the attribute value for DESCRIPCION using the alias name Descripcion
   */
  public String getDescripcion()
  {
    return (String)getAttributeInternal(DESCRIPCION);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for DESCRIPCION using the alias name Descripcion
   */
  public void setDescripcion(String value)
  {
    setAttributeInternal(DESCRIPCION, value);
  }

  /**
   * 
   *  Gets the attribute value for EP using the alias name Ep
   */
  public Number getEp()
  {
    return (Number)getAttributeInternal(EP);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for EP using the alias name Ep
   */
  public void setEp(Number value)
  {
    setAttributeInternal(EP, value);
  }

  /**
   * 
   *  Gets the attribute value for ALTO using the alias name Alto
   */
  public Number getAlto()
  {
    return (Number)getAttributeInternal(ALTO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for ALTO using the alias name Alto
   */
  public void setAlto(Number value)
  {
    setAttributeInternal(ALTO, value);
  }

  /**
   * 
   *  Gets the attribute value for ANCHO using the alias name Ancho
   */
  public Number getAncho()
  {
    return (Number)getAttributeInternal(ANCHO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for ANCHO using the alias name Ancho
   */
  public void setAncho(Number value)
  {
    setAttributeInternal(ANCHO, value);
  }

  /**
   * 
   *  Gets the attribute value for LARGO using the alias name Largo
   */
  public Number getLargo()
  {
    return (Number)getAttributeInternal(LARGO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for LARGO using the alias name Largo
   */
  public void setLargo(Number value)
  {
    setAttributeInternal(LARGO, value);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link ProdembalajesreferenciaView
   */
  public oracle.jbo.RowIterator getProdembalajesreferenciaView()
  {
    return (oracle.jbo.RowIterator)getAttributeInternal(PRODEMBALAJESREFERENCIAVIEW);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDFORMATO:
        return getIdformato();
      case REFFORMATO:
        return getRefformato();
      case DESCRIPCION:
        return getDescripcion();
      case EP:
        return getEp();
      case ALTO:
        return getAlto();
      case ANCHO:
        return getAncho();
      case LARGO:
        return getLargo();
      case PRODEMBALAJESREFERENCIAVIEW:
        return getProdembalajesreferenciaView();
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
      case IDFORMATO:
        setIdformato((Number)value);
        return;
      case REFFORMATO:
        setRefformato((String)value);
        return;
      case DESCRIPCION:
        setDescripcion((String)value);
        return;
      case EP:
        setEp((Number)value);
        return;
      case ALTO:
        setAlto((Number)value);
        return;
      case ANCHO:
        setAncho((Number)value);
        return;
      case LARGO:
        setLargo((Number)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
}