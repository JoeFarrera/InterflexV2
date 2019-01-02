package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaRoleNotGrantedViewRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgaRoleNotGrantedViewRow 
{


  public static final int IDROLE = 0;
  public static final int DESCRIP = 1;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaRoleNotGrantedViewRowImpl()
  {
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idrole
   */
  public String getIdrole()
  {
    return (String)getAttributeInternal(IDROLE);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idrole
   */
  public void setIdrole(String value)
  {
    setAttributeInternal(IDROLE, value);
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
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDROLE:
        return getIdrole();
      case DESCRIP:
        return getDescrip();
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
      case IDROLE:
        setIdrole((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  public String toString()
  {
    return getDescrip();
  }
  
  
}