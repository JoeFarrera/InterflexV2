package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgavposicionplcViewRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgavposicionplcViewRow 
{


  public static final int IDUBI = 0;
  public static final int DESCRIP = 1;
  public static final int POSPLC = 2;
  public static final int IDTIPALM = 3;
  public static final int IDMAC = 4;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgavposicionplcViewRowImpl()
  {
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idubi
   */
  public String getIdubi()
  {
    return (String)getAttributeInternal(IDUBI);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idubi
   */
  public void setIdubi(String value)
  {
    setAttributeInternal(IDUBI, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descrip
   */
  public String getDescrip()
  {
    return (String)getAttributeInternal(DESCRIP);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descrip
   */
  public void setDescrip(String value)
  {
    setAttributeInternal(DESCRIP, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Posplc
   */
  public Number getPosplc()
  {
    return (Number)getAttributeInternal(POSPLC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Posplc
   */
  public void setPosplc(Number value)
  {
    setAttributeInternal(POSPLC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idtipalm
   */
  public String getIdtipalm()
  {
    return (String)getAttributeInternal(IDTIPALM);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idtipalm
   */
  public void setIdtipalm(String value)
  {
    setAttributeInternal(IDTIPALM, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idmac
   */
  public String getIdmac()
  {
    return (String)getAttributeInternal(IDMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idmac
   */
  public void setIdmac(String value)
  {
    setAttributeInternal(IDMAC, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDUBI:
        return getIdubi();
      case DESCRIP:
        return getDescrip();
      case POSPLC:
        return getPosplc();
      case IDTIPALM:
        return getIdtipalm();
      case IDMAC:
        return getIdmac();
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
      case IDUBI:
        setIdubi((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      case POSPLC:
        setPosplc((Number)value);
        return;
      case IDTIPALM:
        setIdtipalm((String)value);
        return;
      case IDMAC:
        setIdmac((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
}