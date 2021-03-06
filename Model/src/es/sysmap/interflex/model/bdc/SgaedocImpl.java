package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaedocImpl extends EntityImpl 
{
  public static final int IDDOC = 0;
  public static final int IDEMBALAJE = 1;
  public static final int CANTOT = 2;
  public static final int PESO = 3;
  public static final int CREATEDBY = 4;
  public static final int MODIFIEDBY = 5;
  public static final int CREATEDON = 6;
  public static final int MODIFIEDON = 7;
  public static final int SGACDOC = 8;










  private static EntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaedocImpl()
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
      mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgaedoc");
    }
    return mDefinitionObject;
  }











  /**
   * 
   *  Gets the attribute value for Iddoc, using the alias name Iddoc
   */
  public Number getIddoc()
  {
    return (Number)getAttributeInternal(IDDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Iddoc
   */
  public void setIddoc(Number value)
  {
    setAttributeInternal(IDDOC, value);
  }

  /**
   * 
   *  Gets the attribute value for Idembalaje, using the alias name Idembalaje
   */
  public String getIdembalaje()
  {
    return (String)getAttributeInternal(IDEMBALAJE);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idembalaje
   */
  public void setIdembalaje(String value)
  {
    setAttributeInternal(IDEMBALAJE, value);
  }

  /**
   * 
   *  Gets the attribute value for Cantot, using the alias name Cantot
   */
  public Number getCantot()
  {
    return (Number)getAttributeInternal(CANTOT);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Cantot
   */
  public void setCantot(Number value)
  {
    setAttributeInternal(CANTOT, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDDOC:
        return getIddoc();
      case IDEMBALAJE:
        return getIdembalaje();
      case CANTOT:
        return getCantot();
      case PESO:
        return getPeso();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case SGACDOC:
        return getSgacdoc();
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
      case IDDOC:
        setIddoc((Number)value);
        return;
      case IDEMBALAJE:
        setIdembalaje((String)value);
        return;
      case CANTOT:
        setCantot((Number)value);
        return;
      case PESO:
        setPeso((Number)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }



  /**
   * 
   *  Gets the associated entity SgacdocImpl
   */
  public SgacdocImpl getSgacdoc()
  {
    return (SgacdocImpl)getAttributeInternal(SGACDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgacdocImpl
   */
  public void setSgacdoc(SgacdocImpl value)
  {
    setAttributeInternal(SGACDOC, value);
  }


  /**
   * 
   *  Gets the attribute value for Peso, using the alias name Peso
   */
  public Number getPeso()
  {
    return (Number)getAttributeInternal(PESO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Peso
   */
  public void setPeso(Number value)
  {
    setAttributeInternal(PESO, value);
  }


  /**
   * 
   *  Gets the attribute value for Createdby, using the alias name Createdby
   */
  public String getCreatedby()
  {
    return (String)getAttributeInternal(CREATEDBY);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Createdby
   */
  public void setCreatedby(String value)
  {
    setAttributeInternal(CREATEDBY, value);
  }

  /**
   * 
   *  Gets the attribute value for Modifiedby, using the alias name Modifiedby
   */
  public String getModifiedby()
  {
    return (String)getAttributeInternal(MODIFIEDBY);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Modifiedby
   */
  public void setModifiedby(String value)
  {
    setAttributeInternal(MODIFIEDBY, value);
  }

  /**
   * 
   *  Gets the attribute value for Createdon, using the alias name Createdon
   */
  public FlexiDate getCreatedon()
  {
    return (FlexiDate)getAttributeInternal(CREATEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Createdon
   */
  public void setCreatedon(FlexiDate value)
  {
    setAttributeInternal(CREATEDON, value);
  }

  /**
   * 
   *  Gets the attribute value for Modifiedon, using the alias name Modifiedon
   */
  public FlexiDate getModifiedon()
  {
    return (FlexiDate)getAttributeInternal(MODIFIEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Modifiedon
   */
  public void setModifiedon(FlexiDate value)
  {
    setAttributeInternal(MODIFIEDON, value);
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Number iddoc, String idembalaje)
  {
    return new Key(new Object[] {iddoc, idembalaje});
  }








}