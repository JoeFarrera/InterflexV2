package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgatipdocImpl extends EntityImpl 
{
  public static final int DESCRIP = 0;
  public static final int TIPMOV = 1;
  public static final int CREATEDBY = 2;
  public static final int MODIFIEDBY = 3;
  public static final int CREATEDON = 4;
  public static final int MODIFIEDON = 5;
  public static final int IDTIPDOC = 6;
  public static final int HOST = 7;
  public static final int SGACDOC = 8;



  public static String TIPDOCENTRADA = "E";
  public static String TIPDOCSALIDA = "S";
  public static String TIPDOCREGULARIZACION = "R";


 public static boolean isRegularizacion(String tipmov)
 {
   return tipmov.equals(TIPDOCREGULARIZACION);
 }
 
 public boolean isHost()
 {
   return getHost().equals("S");
 }








  private static EntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgatipdocImpl()
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
      mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgatipdoc");
    }
    return mDefinitionObject;
  }






























  /**
   * 
   *  Gets the attribute value for Descrip, using the alias name Descrip
   */
  public String getDescrip()
  {
    return (String)getAttributeInternal(DESCRIP);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Descrip
   */
  public void setDescrip(String value)
  {
    setAttributeInternal(DESCRIP, value);
  }

  /**
   * 
   *  Gets the attribute value for Tipmov, using the alias name Tipmov
   */
  public String getTipmov()
  {
    return (String)getAttributeInternal(TIPMOV);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tipmov
   */
  public void setTipmov(String value)
  {
    setAttributeInternal(TIPMOV, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case DESCRIP:
        return getDescrip();
      case TIPMOV:
        return getTipmov();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case IDTIPDOC:
        return getIdtipdoc();
      case HOST:
        return getHost();
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
      case DESCRIP:
        setDescrip((String)value);
        return;
      case TIPMOV:
        setTipmov((String)value);
        return;
      case IDTIPDOC:
        setIdtipdoc((String)value);
        return;
      case HOST:
        setHost((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }



  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgacdoc()
  {
    return (RowIterator)getAttributeInternal(SGACDOC);
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
   *  Gets the attribute value for Idtipdoc, using the alias name Idtipdoc
   */
  public String getIdtipdoc()
  {
    return (String)getAttributeInternal(IDTIPDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idtipdoc
   */
  public void setIdtipdoc(String value)
  {
    setAttributeInternal(IDTIPDOC, value);
  }


  /**
   * 
   *  Gets the attribute value for Host, using the alias name Host
   */
  public String getHost()
  {
    return (String)getAttributeInternal(HOST);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Host
   */
  public void setHost(String value)
  {
    setAttributeInternal(HOST, value);
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(String idtipdoc)
  {
    return new Key(new Object[] {idtipdoc});
  }























}