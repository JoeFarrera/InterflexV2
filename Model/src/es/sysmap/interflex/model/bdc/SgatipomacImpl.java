package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgatipomacImpl extends EntityImpl 
{
  public static final int IDTIPMAC = 0;
  public static final int DESCRIP = 1;
  public static final int NUMPOS = 2;
  public static final int CREATEDBY = 3;
  public static final int MODIFIEDBY = 4;
  public static final int CREATEDON = 5;
  public static final int MODIFIEDON = 6;
  public static final int TARA = 7;
  public static final int TIPPLC = 8;
  public static final int IDTIPALM = 9;
  public static final int SGATIPMACTIPUBI = 10;
  public static final int SGAMAC = 11;
  public static final int SGAARTICULO = 12;





































  private static EntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgatipomacImpl()
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
      mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgatipomac");
    }
    return mDefinitionObject;
  }






































  /**
   * 
   *  Gets the attribute value for Idtipmac, using the alias name Idtipmac
   */
  public String getIdtipmac()
  {
    return (String)getAttributeInternal(IDTIPMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idtipmac
   */
  public void setIdtipmac(String value)
  {
    setAttributeInternal(IDTIPMAC, value);
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
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDTIPMAC:
        return getIdtipmac();
      case DESCRIP:
        return getDescrip();
      case NUMPOS:
        return getNumpos();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case TARA:
        return getTara();
      case TIPPLC:
        return getTipplc();
      case IDTIPALM:
        return getIdtipalm();
      case SGATIPMACTIPUBI:
        return getSgatipmactipubi();
      case SGAMAC:
        return getSgamac();
      case SGAARTICULO:
        return getSgaarticulo();
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
      case IDTIPMAC:
        setIdtipmac((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      case NUMPOS:
        setNumpos((Number)value);
        return;
      case TARA:
        setTara((Number)value);
        return;
      case TIPPLC:
        setTipplc((Number)value);
        return;
      case IDTIPALM:
        setIdtipalm((String)value);
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
  public RowIterator getSgatipmactipubi()
  {
    return (RowIterator)getAttributeInternal(SGATIPMACTIPUBI);
  }

  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgamac()
  {
    return (RowIterator)getAttributeInternal(SGAMAC);
  }


  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgaarticulo()
  {
    return (RowIterator)getAttributeInternal(SGAARTICULO);
  }


  /**
   * 
   *  Gets the attribute value for Numpos, using the alias name Numpos
   */
  public Number getNumpos()
  {
    return (Number)getAttributeInternal(NUMPOS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Numpos
   */
  public void setNumpos(Number value)
  {
    setAttributeInternal(NUMPOS, value);
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
   *  Gets the attribute value for Tara, using the alias name Tara
   */
  public Number getTara()
  {
    return (Number)getAttributeInternal(TARA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tara
   */
  public void setTara(Number value)
  {
    setAttributeInternal(TARA, value);
  }


  /**
   * 
   *  Gets the attribute value for Tipplc, using the alias name Tipplc
   */
  public Number getTipplc()
  {
    return (Number)getAttributeInternal(TIPPLC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tipplc
   */
  public void setTipplc(Number value)
  {
    setAttributeInternal(TIPPLC, value);
  }


  /**
   * 
   *  Gets the attribute value for Idtipalm, using the alias name Idtipalm
   */
  public String getIdtipalm()
  {
    return (String)getAttributeInternal(IDTIPALM);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idtipalm
   */
  public void setIdtipalm(String value)
  {
    setAttributeInternal(IDTIPALM, value);
  }




  public boolean isMiniload()
  {
    return getIdtipalm().equals("MLD");
  }
  
  public boolean isManual() 
  {
    return getIdtipalm() == null || getIdtipalm().equals("MAN");
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(String idtipmac)
  {
    return new Key(new Object[] {idtipmac});
  }



























}