package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaexpedlbultoViewRowImpl extends ViewRowImpl 
{


  public static final int IDEXPED = 0;
  public static final int IDBULTO = 1;
  public static final int IDDOC = 2;
  public static final int IDLIN = 3;
  public static final int CANTOT = 4;
  public static final int PESO = 5;
  public static final int SGALDOCVIEW = 6;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaexpedlbultoViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Sgaexpedlbulto entity object.
   */
  public es.sysmap.interflex.model.bdc.SgaexpedlbultoImpl getSgaexpedlbulto()
  {
    return (es.sysmap.interflex.model.bdc.SgaexpedlbultoImpl)getEntity(0);
  }

  /**
   * 
   *  Gets the attribute value for IDEXPED using the alias name Idexped
   */
  public Number getIdexped()
  {
    return (Number)getAttributeInternal(IDEXPED);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDEXPED using the alias name Idexped
   */
  public void setIdexped(Number value)
  {
    setAttributeInternal(IDEXPED, value);
  }

  /**
   * 
   *  Gets the attribute value for IDBULTO using the alias name Idbulto
   */
  public Number getIdbulto()
  {
    return (Number)getAttributeInternal(IDBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDBULTO using the alias name Idbulto
   */
  public void setIdbulto(Number value)
  {
    setAttributeInternal(IDBULTO, value);
  }

  /**
   * 
   *  Gets the attribute value for IDDOC using the alias name Iddoc
   */
  public Number getIddoc()
  {
    return (Number)getAttributeInternal(IDDOC);
  }
  
  

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDDOC using the alias name Iddoc
   */
  public void setIddoc(Number value)
  {
    setAttributeInternal(IDDOC, value);
  }

  /**
   * 
   *  Gets the attribute value for IDLIN using the alias name Idlin
   */
  public Number getIdlin()
  {
    return (Number)getAttributeInternal(IDLIN);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDLIN using the alias name Idlin
   */
  public void setIdlin(Number value)
  {
    setAttributeInternal(IDLIN, value);
  }


  public SgacdocViewRowImpl getSgacdoc () 
  {
    SgaldocViewRowImpl row = (SgaldocViewRowImpl)getSgaldocView();
    return (SgacdocViewRowImpl)row.getSgacdocView1();
  }
  /**
   * 
   *  Gets the attribute value for CANTOT using the alias name Cantot
   */
  public Number getCantot()
  {
    return (Number)getAttributeInternal(CANTOT);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANTOT using the alias name Cantot
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
      case IDEXPED:
        return getIdexped();
      case IDBULTO:
        return getIdbulto();
      case IDDOC:
        return getIddoc();
      case IDLIN:
        return getIdlin();
      case CANTOT:
        return getCantot();
      case PESO:
        return getPeso();
      case SGALDOCVIEW:
        return getSgaldocView();
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
      case IDBULTO:
        setIdbulto((Number)value);
        return;
      case IDDOC:
        setIddoc((Number)value);
        return;
      case IDLIN:
        setIdlin((Number)value);
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
   *  Gets the attribute value for PESO using the alias name Peso
   */
  public Number getPeso()
  {
    return (Number)getAttributeInternal(PESO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for PESO using the alias name Peso
   */
  public void setPeso(Number value)
  {
    setAttributeInternal(PESO, value);
  }

  /**
   * 
   *  Gets the associated <code>Row</code> using master-detail link SgaldocView
   */
  public oracle.jbo.Row getSgaldocView()
  {
    return (oracle.jbo.Row)getAttributeInternal(SGALDOCVIEW);
  }
}