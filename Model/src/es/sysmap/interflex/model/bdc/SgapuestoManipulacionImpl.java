package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.Key;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgapuestoManipulacionImpl extends SgaubicacionImpl 
{
  public static final int MAXATTRCONST = EntityDefImpl.getMaxAttrConst("es.sysmap.interflex.model.bdc.Sgaubicacion");
  public static final int CAPPUL = MAXATTRCONST;
  public static final int OCUPUL = MAXATTRCONST + 1;




  private static CustomEntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgapuestoManipulacionImpl()
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
      mDefinitionObject = (CustomEntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.SgapuestoManipulacion");
    }
    return mDefinitionObject;
  }





  /**
   * 
   *  Gets the attribute value for Idtipubi, using the alias name Idtipubi
   */
  public String getIdtipubi()
  {
    return super.getIdtipubi();
  }

  /**
   * 
   *  Gets the attribute value for Cappul, using the alias name Cappul
   */
  public Number getCappul()
  {
    return (Number)getAttributeInternal(CAPPUL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Cappul
   */
  public void setCappul(Number value)
  {
    setAttributeInternal(CAPPUL, value);
  }

  /**
   * 
   *  Gets the attribute value for Ocupul, using the alias name Ocupul
   */
  public Number getOcupul()
  {
    return (Number)getAttributeInternal(OCUPUL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ocupul
   */
  public void setOcupul(Number value)
  {
    setAttributeInternal(OCUPUL, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    if (index == CAPPUL)
    {
      return getCappul();
    }
    if (index == OCUPUL)
    {
      return getOcupul();
    }
    if (index == IDTIPUBI)
    {
      return getIdtipubi();
    }
    return super.getAttrInvokeAccessor(index, attrDef);
  }

  /**
   * 
   *  setAttrInvokeAccessor: generated method. Do not modify.
   */
  protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception
  {
    if (index == CAPPUL)
    {
      setCappul((Number)value);
      return;
    }
    if (index == OCUPUL)
    {
      setOcupul((Number)value);
      return;
    }
    super.setAttrInvokeAccessor(index, value, attrDef);
    return;
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(String idubi)
  {
    return new Key(new Object[] {idubi});
  }





}