package es.sysmap.interflex.model.bdc;
import es.sysmap.interflex.model.dmc.AppModuleImpl;
import oracle.jbo.AttributeList;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.Key;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaexpedImpl extends EntityImpl 
{
  public static final int IDEXPED = 0;
  public static final int CREATEDBY = 1;
  public static final int CREATEDON = 2;
  public static final int MODIFIEDBY = 3;
  public static final int MODIFIEDON = 4;
  public static final int SGAEXPEDBULTO = 5;
  public static final int SGAEXPEDDOC = 6;







































  private static EntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaexpedImpl()
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
      mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgaexped");
    }
    return mDefinitionObject;
  }










































  /**
   * 
   *  Gets the attribute value for Idexped, using the alias name Idexped
   */
  public Number getIdexped()
  {
    return (Number)getAttributeInternal(IDEXPED);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idexped
   */
  public void setIdexped(Number value)
  {
    setAttributeInternal(IDEXPED, value);
  }





  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDEXPED:
        return getIdexped();
      case CREATEDBY:
        return getCreatedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDBY:
        return getModifiedby();
      case MODIFIEDON:
        return getModifiedon();
      case SGAEXPEDBULTO:
        return getSgaexpedbulto();
      case SGAEXPEDDOC:
        return getSgaexpeddoc();
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
      case IDEXPED:
        setIdexped((Number)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  
    /**
   * 
   *  Add attribute defaulting logic in this method.
   */
  protected void create(AttributeList attributeList)
  {
    super.create(attributeList);
    AppModuleImpl appModule = (AppModuleImpl)getDBTransaction().getRootApplicationModule();

  try 
  {
    setIdexped(new Number(appModule.getSeqExped())); 
  }
  catch (java.sql.SQLException ex)
  {
    System.out.println(ex);
  }
  }

  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgaexpedbulto()
  {
    return (RowIterator)getAttributeInternal(SGAEXPEDBULTO);
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
   *  Gets the attribute value for Createdon, using the alias name Createdon
   */
  public Date getCreatedon()
  {
    return (Date)getAttributeInternal(CREATEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Createdon
   */
  public void setCreatedon(Date value)
  {
    setAttributeInternal(CREATEDON, value);
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
   *  Gets the attribute value for Modifiedon, using the alias name Modifiedon
   */
  public Date getModifiedon()
  {
    return (Date)getAttributeInternal(MODIFIEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Modifiedon
   */
  public void setModifiedon(Date value)
  {
    setAttributeInternal(MODIFIEDON, value);
  }


  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgaexpeddoc()
  {
    return (RowIterator)getAttributeInternal(SGAEXPEDDOC);
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Number idexped)
  {
    return new Key(new Object[] {idexped});
  }







































}