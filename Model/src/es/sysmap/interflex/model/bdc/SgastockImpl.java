package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------
/*
 * Michael 07.02.2006 Tabla de stocks
 * Estado:
 *  estado  'N': Nuevo
 *          'A': Alta ??
 *          'B': Baja
 *          'H': Enviar al Host
 *          'Z': Error en el env�o
 */
public class SgastockImpl extends EntityImpl 
{
  public static final int IDART = 0;
  public static final int STOCK = 1;
  public static final int CREATEDON = 2;
  public static final int MODIFIEDON = 3;
  public static final int CREATEDBY = 4;
  public static final int MODIFIEDBY = 5;
  public static final int ESTADO = 6;
  public static final int IDARTIF = 7;
  public static final int DESCRIP = 8;
  public static final int PESUNIT = 9;
  public static final int CODEAN = 10;
  public static final int UNIEMB = 11;
  public static final int IDARTANT = 12;
  public static final int IDARTIFB = 13;
  public static final int SGAMOVIMIENTO = 14;
















  private static SgastockDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgastockImpl()
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
      mDefinitionObject = (SgastockDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgastock");
    }
    return mDefinitionObject;
  }



















  /**
   * 
   *  Gets the attribute value for Idart, using the alias name Idart
   */
  public String getIdart()
  {
    return (String)getAttributeInternal(IDART);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idart
   */
  public void setIdart(String value)
  {
    setAttributeInternal(IDART, value);
  }

  /**
   * 
   *  Gets the attribute value for Stock, using the alias name Stock
   */
  public Number getStock()
  {
    return (Number)getAttributeInternal(STOCK);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Stock
   */
  public void setStock(Number value)
  {
    setAttributeInternal(STOCK, value);
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
   *  Gets the attribute value for Modifiedon, using the alias name Modifiedon
   */
  public FlexiDate getModifiedon()
  {
    return (FlexiDate)getAttributeInternal(MODIFIEDON);
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
   *  Gets the attribute value for Modifiedby, using the alias name Modifiedby
   */
  public String getModifiedby()
  {
    return (String)getAttributeInternal(MODIFIEDBY);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDART:
        return getIdart();
      case STOCK:
        return getStock();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case ESTADO:
        return getEstado();
      case IDARTIF:
        return getIdartif();
      case DESCRIP:
        return getDescrip();
      case PESUNIT:
        return getPesunit();
      case CODEAN:
        return getCodean();
      case UNIEMB:
        return getUniemb();
      case IDARTANT:
        return getIdartant();
      case IDARTIFB:
        return getIdartifb();
      case SGAMOVIMIENTO:
        return getSgamovimiento();
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
      case IDART:
        setIdart((String)value);
        return;
      case STOCK:
        setStock((Number)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case IDARTIF:
        setIdartif((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      case PESUNIT:
        setPesunit((Number)value);
        return;
      case CODEAN:
        setCodean((String)value);
        return;
      case UNIEMB:
        setUniemb((Number)value);
        return;
      case IDARTANT:
        setIdartant((String)value);
        return;
      case IDARTIFB:
        setIdartifb((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }


  /**
   * Afegeix un registre amb quantitat 0 per la referencia
   * @param idart
   */
  public void afegirStockInicial(String idart)
  {
    setIdart(idart);
    setStock(new Number(0));
    // Michael 07.02.2006 - Si el estado es nuevo, ser� enviado al host
    setEstado("N");
  }

  /**
   * 
   *  Gets the attribute value for Estado, using the alias name Estado
   */
  public String getEstado()
  {
    return (String)getAttributeInternal(ESTADO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Estado
   */
  public void setEstado(String value)
  {
    setAttributeInternal(ESTADO, value);
  }


  /**
   * 
   *  Gets the associated entity SgamovimientoImpl
   */
  public SgamovimientoImpl getSgamovimiento()
  {
    return (SgamovimientoImpl)getAttributeInternal(SGAMOVIMIENTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgamovimientoImpl
   */
  public void setSgamovimiento(SgamovimientoImpl value)
  {
    setAttributeInternal(SGAMOVIMIENTO, value);
  }







  /**
   * 
   *  Gets the attribute value for Idartif, using the alias name Idartif
   */
  public String getIdartif()
  {
    return (String)getAttributeInternal(IDARTIF);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idartif
   */
  public void setIdartif(String value)
  {
    setAttributeInternal(IDARTIF, value);
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
   *  Gets the attribute value for Pesunit, using the alias name Pesunit
   */
  public Number getPesunit()
  {
    return (Number)getAttributeInternal(PESUNIT);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Pesunit
   */
  public void setPesunit(Number value)
  {
    setAttributeInternal(PESUNIT, value);
  }


  /**
   * 
   *  Gets the attribute value for Codean, using the alias name Codean
   */
  public String getCodean()
  {
    return (String)getAttributeInternal(CODEAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Codean
   */
  public void setCodean(String value)
  {
    setAttributeInternal(CODEAN, value);
  }

  /**
   * 
   *  Gets the attribute value for Uniemb, using the alias name Uniemb
   */
  public Number getUniemb()
  {
    return (Number)getAttributeInternal(UNIEMB);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Uniemb
   */
  public void setUniemb(Number value)
  {
    setAttributeInternal(UNIEMB, value);
  }


  /**
   * 
   *  Gets the attribute value for Idartant, using the alias name Idartant
   */
  public String getIdartant()
  {
    return (String)getAttributeInternal(IDARTANT);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idartant
   */
  public void setIdartant(String value)
  {
    setAttributeInternal(IDARTANT, value);
  }


  /**
   * 
   *  Gets the attribute value for Idartifb, using the alias name Idartifb
   */
  public String getIdartifb()
  {
    return (String)getAttributeInternal(IDARTIFB);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idartifb
   */
  public void setIdartifb(String value)
  {
    setAttributeInternal(IDARTIFB, value);
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(String idart)
  {
    return new Key(new Object[] {idart});
  }








}