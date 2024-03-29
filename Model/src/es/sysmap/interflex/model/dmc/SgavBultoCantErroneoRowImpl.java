package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavBultoCantErroneoRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgavBultoCantErroneoRow 
{


  public static final int IDDOC = 0;
  public static final int IDCABSTR = 1;
  public static final int IDCABNUM = 2;
  public static final int IDLIN = 3;
  public static final int IDART = 4;
  public static final int CANTOT = 5;
  public static final int CANBULTO = 6;
  public static final int FECMOD = 7;
  public static final int MODIFIEDBY = 8;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavBultoCantErroneoRowImpl()
  {
  }
  
  
  public String toString () 
  {
    return "Documento: " + getIdcabnum() + " Id. L�nia:" + getIdlin() + " Cant. bulto: " +  getCanbulto() + " Cant. L�nia: " + getCantot();
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Iddoc
   */
  public Number getIddoc()
  {
    return (Number)getAttributeInternal(IDDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Iddoc
   */
  public void setIddoc(Number value)
  {
    setAttributeInternal(IDDOC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idcabstr
   */
  public String getIdcabstr()
  {
    return (String)getAttributeInternal(IDCABSTR);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idcabstr
   */
  public void setIdcabstr(String value)
  {
    setAttributeInternal(IDCABSTR, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idcabnum
   */
  public String getIdcabnum()
  {
    return (String)getAttributeInternal(IDCABNUM);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idcabnum
   */
  public void setIdcabnum(String value)
  {
    setAttributeInternal(IDCABNUM, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idlin
   */
  public Number getIdlin()
  {
    return (Number)getAttributeInternal(IDLIN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idlin
   */
  public void setIdlin(Number value)
  {
    setAttributeInternal(IDLIN, value);
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
   *  Gets the attribute value for the calculated attribute Canbulto
   */
  public Number getCanbulto()
  {
    return (Number)getAttributeInternal(CANBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Canbulto
   */
  public void setCanbulto(Number value)
  {
    setAttributeInternal(CANBULTO, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Fecmod
   */
  public String getFecmod()
  {
    return (String)getAttributeInternal(FECMOD);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Fecmod
   */
  public void setFecmod(String value)
  {
    setAttributeInternal(FECMOD, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Modifiedby
   */
  public String getModifiedby()
  {
    return (String)getAttributeInternal(MODIFIEDBY);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Modifiedby
   */
  public void setModifiedby(String value)
  {
    setAttributeInternal(MODIFIEDBY, value);
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
      case IDCABSTR:
        return getIdcabstr();
      case IDCABNUM:
        return getIdcabnum();
      case IDLIN:
        return getIdlin();
      case IDART:
        return getIdart();
      case CANTOT:
        return getCantot();
      case CANBULTO:
        return getCanbulto();
      case FECMOD:
        return getFecmod();
      case MODIFIEDBY:
        return getModifiedby();
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
      case IDCABSTR:
        setIdcabstr((String)value);
        return;
      case IDCABNUM:
        setIdcabnum((String)value);
        return;
      case IDLIN:
        setIdlin((Number)value);
        return;
      case IDART:
        setIdart((String)value);
        return;
      case CANTOT:
        setCantot((Number)value);
        return;
      case CANBULTO:
        setCanbulto((Number)value);
        return;
      case FECMOD:
        setFecmod((String)value);
        return;
      case MODIFIEDBY:
        setModifiedby((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
}