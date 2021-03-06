package es.sysmap.interflex.informix;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import java.math.BigDecimal;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class ReferenciasImpl extends EntityImpl 
{
  public static final int ROWID = 0;
  public static final int REFACCION = 1;
  public static final int REFCBARRA = 2;
  public static final int REFCONTROLPESO = 3;
  public static final int REFDESCREF = 4;
  public static final int REFESTADO = 5;
  public static final int REFFCREACION = 6;
  public static final int REFFULTACT = 7;
  public static final int REFID = 8;
  public static final int REFIDANTERIOR = 9;
  public static final int REFMOTIVO = 10;
  public static final int REFPESOUNITARIO = 11;
  public static final int REFUEMB = 12;

  private static EntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public ReferenciasImpl()
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
      mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.informix.Referencias");
    }
    return mDefinitionObject;
  }


  /**
   * 
   *  Gets the attribute value for RowID, using the alias name RowID
   */
  public String getRowID()
  {
    return (String)getAttributeInternal(ROWID);
  }

  /**
   * 
   *  Gets the attribute value for RefAccion, using the alias name RefAccion
   */
  public BigDecimal getRefAccion()
  {
    return (BigDecimal)getAttributeInternal(REFACCION);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefAccion
   */
  public void setRefAccion(BigDecimal value)
  {
    setAttributeInternal(REFACCION, value);
  }

  /**
   * 
   *  Gets the attribute value for RefCBarra, using the alias name RefCBarra
   */
  public BigDecimal getRefCBarra()
  {
    return (BigDecimal)getAttributeInternal(REFCBARRA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefCBarra
   */
  public void setRefCBarra(BigDecimal value)
  {
    setAttributeInternal(REFCBARRA, value);
  }

  /**
   * 
   *  Gets the attribute value for RefControlPeso, using the alias name RefControlPeso
   */
  public BigDecimal getRefControlPeso()
  {
    return (BigDecimal)getAttributeInternal(REFCONTROLPESO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefControlPeso
   */
  public void setRefControlPeso(BigDecimal value)
  {
    setAttributeInternal(REFCONTROLPESO, value);
  }

  /**
   * 
   *  Gets the attribute value for RefDescRef, using the alias name RefDescRef
   */
  public String getRefDescRef()
  {
    return (String)getAttributeInternal(REFDESCREF);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefDescRef
   */
  public void setRefDescRef(String value)
  {
    setAttributeInternal(REFDESCREF, value);
  }

  /**
   * 
   *  Gets the attribute value for RefEstado, using the alias name RefEstado
   */
  public BigDecimal getRefEstado()
  {
    return (BigDecimal)getAttributeInternal(REFESTADO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefEstado
   */
  public void setRefEstado(BigDecimal value)
  {
    setAttributeInternal(REFESTADO, value);
  }

  /**
   * 
   *  Gets the attribute value for RefFcreacion, using the alias name RefFcreacion
   */
  public String getRefFcreacion()
  {
    return (String)getAttributeInternal(REFFCREACION);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefFcreacion
   */
  public void setRefFcreacion(String value)
  {
    setAttributeInternal(REFFCREACION, value);
  }

  /**
   * 
   *  Gets the attribute value for RefFultAct, using the alias name RefFultAct
   */
  public String getRefFultAct()
  {
    return (String)getAttributeInternal(REFFULTACT);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefFultAct
   */
  public void setRefFultAct(String value)
  {
    setAttributeInternal(REFFULTACT, value);
  }

  /**
   * 
   *  Gets the attribute value for RefId, using the alias name RefId
   */
  public String getRefId()
  {
    return (String)getAttributeInternal(REFID);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefId
   */
  public void setRefId(String value)
  {
    setAttributeInternal(REFID, value);
  }

  /**
   * 
   *  Gets the attribute value for RefIdAnterior, using the alias name RefIdAnterior
   */
  public String getRefIdAnterior()
  {
    return (String)getAttributeInternal(REFIDANTERIOR);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefIdAnterior
   */
  public void setRefIdAnterior(String value)
  {
    setAttributeInternal(REFIDANTERIOR, value);
  }

  /**
   * 
   *  Gets the attribute value for RefMotivo, using the alias name RefMotivo
   */
  public String getRefMotivo()
  {
    return (String)getAttributeInternal(REFMOTIVO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefMotivo
   */
  public void setRefMotivo(String value)
  {
    setAttributeInternal(REFMOTIVO, value);
  }

  /**
   * 
   *  Gets the attribute value for RefPesoUnitario, using the alias name RefPesoUnitario
   */
  public BigDecimal getRefPesoUnitario()
  {
    return (BigDecimal)getAttributeInternal(REFPESOUNITARIO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefPesoUnitario
   */
  public void setRefPesoUnitario(BigDecimal value)
  {
    setAttributeInternal(REFPESOUNITARIO, value);
  }

  /**
   * 
   *  Gets the attribute value for RefUEmb, using the alias name RefUEmb
   */
  public BigDecimal getRefUEmb()
  {
    return (BigDecimal)getAttributeInternal(REFUEMB);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for RefUEmb
   */
  public void setRefUEmb(BigDecimal value)
  {
    setAttributeInternal(REFUEMB, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case ROWID:
        return getRowID();
      case REFACCION:
        return getRefAccion();
      case REFCBARRA:
        return getRefCBarra();
      case REFCONTROLPESO:
        return getRefControlPeso();
      case REFDESCREF:
        return getRefDescRef();
      case REFESTADO:
        return getRefEstado();
      case REFFCREACION:
        return getRefFcreacion();
      case REFFULTACT:
        return getRefFultAct();
      case REFID:
        return getRefId();
      case REFIDANTERIOR:
        return getRefIdAnterior();
      case REFMOTIVO:
        return getRefMotivo();
      case REFPESOUNITARIO:
        return getRefPesoUnitario();
      case REFUEMB:
        return getRefUEmb();
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
      case REFACCION:
        setRefAccion((BigDecimal)value);
        return;
      case REFCBARRA:
        setRefCBarra((BigDecimal)value);
        return;
      case REFCONTROLPESO:
        setRefControlPeso((BigDecimal)value);
        return;
      case REFDESCREF:
        setRefDescRef((String)value);
        return;
      case REFESTADO:
        setRefEstado((BigDecimal)value);
        return;
      case REFFCREACION:
        setRefFcreacion((String)value);
        return;
      case REFFULTACT:
        setRefFultAct((String)value);
        return;
      case REFID:
        setRefId((String)value);
        return;
      case REFIDANTERIOR:
        setRefIdAnterior((String)value);
        return;
      case REFMOTIVO:
        setRefMotivo((String)value);
        return;
      case REFPESOUNITARIO:
        setRefPesoUnitario((BigDecimal)value);
        return;
      case REFUEMB:
        setRefUEmb((BigDecimal)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
}