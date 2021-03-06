package es.sysmap.interflex.erpsproduccion.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import java.math.BigDecimal;
import oracle.jbo.Key;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class Prod_EmbalajesImpl extends EntityImpl 
{
  public static final int IDFORMATO = 0;
  public static final int REFFORMATO = 1;
  public static final int DESCRIPCION = 2;
  public static final int EP = 3;
  public static final int ALTO = 4;
  public static final int ANCHO = 5;
  public static final int LARGO = 6;
  private static EntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public Prod_EmbalajesImpl()
  {
  }

  /**
   * 
   *  Retrieves the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    if (mDefinitionObject == null)
    {
      mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.erpsproduccion.model.bdc.Prod_Embalajes");
    }
    return mDefinitionObject;
  }

  /**
   * 
   *  Gets the attribute value for Idformato, using the alias name Idformato
   */
  public Integer getIdformato()
  {
    return (Integer)getAttributeInternal(IDFORMATO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idformato
   */
  public void setIdformato(Integer value)
  {
    setAttributeInternal(IDFORMATO, value);
  }

  /**
   * 
   *  Gets the attribute value for Refformato, using the alias name Refformato
   */
  public String getRefformato()
  {
    return (String)getAttributeInternal(REFFORMATO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Refformato
   */
  public void setRefformato(String value)
  {
    setAttributeInternal(REFFORMATO, value);
  }

  /**
   * 
   *  Gets the attribute value for Descripcion, using the alias name Descripcion
   */
  public String getDescripcion()
  {
    return (String)getAttributeInternal(DESCRIPCION);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Descripcion
   */
  public void setDescripcion(String value)
  {
    setAttributeInternal(DESCRIPCION, value);
  }

  /**
   * 
   *  Gets the attribute value for Ep, using the alias name Ep
   */
  public BigDecimal getEp()
  {
    return (BigDecimal)getAttributeInternal(EP);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ep
   */
  public void setEp(BigDecimal value)
  {
    setAttributeInternal(EP, value);
  }

  /**
   * 
   *  Gets the attribute value for Alto, using the alias name Alto
   */
  public BigDecimal getAlto()
  {
    return (BigDecimal)getAttributeInternal(ALTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Alto
   */
  public void setAlto(BigDecimal value)
  {
    setAttributeInternal(ALTO, value);
  }

  /**
   * 
   *  Gets the attribute value for Ancho, using the alias name Ancho
   */
  public BigDecimal getAncho()
  {
    return (BigDecimal)getAttributeInternal(ANCHO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ancho
   */
  public void setAncho(BigDecimal value)
  {
    setAttributeInternal(ANCHO, value);
  }

  /**
   * 
   *  Gets the attribute value for Largo, using the alias name Largo
   */
  public BigDecimal getLargo()
  {
    return (BigDecimal)getAttributeInternal(LARGO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Largo
   */
  public void setLargo(BigDecimal value)
  {
    setAttributeInternal(LARGO, value);
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
        setIdformato((Integer)value);
        return;
      case REFFORMATO:
        setRefformato((String)value);
        return;
      case DESCRIPCION:
        setDescripcion((String)value);
        return;
      case EP:
        setEp((BigDecimal)value);
        return;
      case ALTO:
        setAlto((BigDecimal)value);
        return;
      case ANCHO:
        setAncho((BigDecimal)value);
        return;
      case LARGO:
        setLargo((BigDecimal)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Integer idformato)
  {
    return new Key(new Object[] {idformato});
  }
}