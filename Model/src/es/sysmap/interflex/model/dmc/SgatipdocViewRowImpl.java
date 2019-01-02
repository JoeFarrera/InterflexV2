package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgatipdocViewRowImpl extends ViewRowImpl 
{


  public static final int IDTIPDOC = 0;
  public static final int DESCRIP = 1;
  public static final int TIPMOV = 2;
  public static final int HOST = 3;
  public static final int SGACDOCVIEW = 4;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgatipdocViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Sgatipdoc entity object.
   */
  public es.sysmap.interflex.model.bdc.SgatipdocImpl getSgatipdoc()
  {
    return (es.sysmap.interflex.model.bdc.SgatipdocImpl)getEntity(0);
  }

  /**
   * 
   *  Gets the attribute value for IDTIPDOC using the alias name Idtipdoc
   */
  public String getIdtipdoc()
  {
    return (String)getAttributeInternal(IDTIPDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDTIPDOC using the alias name Idtipdoc
   */
  public void setIdtipdoc(String value)
  {
    setAttributeInternal(IDTIPDOC, value);
  }

  /**
   * 
   *  Gets the attribute value for DESCRIP using the alias name Descrip
   */
  public String getDescrip()
  {
    return (String)getAttributeInternal(DESCRIP);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for DESCRIP using the alias name Descrip
   */
  public void setDescrip(String value)
  {
    setAttributeInternal(DESCRIP, value);
  }

  /**
   * 
   *  Gets the attribute value for TIPMOV using the alias name Tipmov
   */
  public String getTipmov()
  {
    return (String)getAttributeInternal(TIPMOV);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for TIPMOV using the alias name Tipmov
   */
  public void setTipmov(String value)
  {
    setAttributeInternal(TIPMOV, value);
  }

  /**
   * 
   *  Gets the attribute value for HOST using the alias name Host
   */
  public String getHost()
  {
    return (String)getAttributeInternal(HOST);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for HOST using the alias name Host
   */
  public void setHost(String value)
  {
    setAttributeInternal(HOST, value);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgacdocView
   */
  public oracle.jbo.RowIterator getSgacdocView()
  {
    return (oracle.jbo.RowIterator)getAttributeInternal(SGACDOCVIEW);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDTIPDOC:
        return getIdtipdoc();
      case DESCRIP:
        return getDescrip();
      case TIPMOV:
        return getTipmov();
      case HOST:
        return getHost();
      case SGACDOCVIEW:
        return getSgacdocView();
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
      case IDTIPDOC:
        setIdtipdoc((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      case TIPMOV:
        setTipmov((String)value);
        return;
      case HOST:
        setHost((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
}