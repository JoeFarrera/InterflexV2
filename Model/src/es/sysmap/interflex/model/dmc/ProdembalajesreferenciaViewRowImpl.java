package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class ProdembalajesreferenciaViewRowImpl extends ViewRowImpl 
{
  public static final int CODART = 0;


  public static final int IDFORMATO = 1;
  public static final int CANTIDAD = 2;
  public static final int PREDET = 3;
  public static final int UNIDADMEDIDA = 4;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public ProdembalajesreferenciaViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Prodembalajesreferencia entity object.
   */
  public es.sysmap.interflex.model.bdc.ProdembalajesreferenciaImpl getProdembalajesreferencia()
  {
    return (es.sysmap.interflex.model.bdc.ProdembalajesreferenciaImpl)getEntity(0);
  }

  /**
   * 
   *  Gets the attribute value for CODART using the alias name Codart
   */
  public String getCodart()
  {
    return (String)getAttributeInternal(CODART);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CODART using the alias name Codart
   */
  public void setCodart(String value)
  {
    setAttributeInternal(CODART, value);
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
   *  Gets the attribute value for CANTIDAD using the alias name Cantidad
   */
  public Number getCantidad()
  {
    return (Number)getAttributeInternal(CANTIDAD);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANTIDAD using the alias name Cantidad
   */
  public void setCantidad(Number value)
  {
    setAttributeInternal(CANTIDAD, value);
  }

  /**
   * 
   *  Gets the attribute value for PREDET using the alias name Predet
   */
  public Number getPredet()
  {
    return (Number)getAttributeInternal(PREDET);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for PREDET using the alias name Predet
   */
  public void setPredet(Number value)
  {
    setAttributeInternal(PREDET, value);
  }

  /**
   * 
   *  Gets the attribute value for UNIDADMEDIDA using the alias name Unidadmedida
   */
  public String getUnidadmedida()
  {
    return (String)getAttributeInternal(UNIDADMEDIDA);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for UNIDADMEDIDA using the alias name Unidadmedida
   */
  public void setUnidadmedida(String value)
  {
    setAttributeInternal(UNIDADMEDIDA, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case CODART:
        return getCodart();
      case IDFORMATO:
        return getIdformato();
      case CANTIDAD:
        return getCantidad();
      case PREDET:
        return getPredet();
      case UNIDADMEDIDA:
        return getUnidadmedida();
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
      case CODART:
        setCodart((String)value);
        return;
      case IDFORMATO:
        setIdformato((Number)value);
        return;
      case CANTIDAD:
        setCantidad((Number)value);
        return;
      case PREDET:
        setPredet((Number)value);
        return;
      case UNIDADMEDIDA:
        setUnidadmedida((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
}