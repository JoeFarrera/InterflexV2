package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
import oracle.jbo.Key;
import oracle.jbo.AttributeList;
import oracle.jbo.server.SequenceImpl;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgahistexistImpl extends EntityImpl 
{
  public static final int IDMOV = 0;
  public static final int TIPMOV = 1;
  public static final int IDMAC = 2;
  public static final int IDART = 3;
  public static final int CANINI = 4;
  public static final int CANFIN = 5;
  public static final int IDBULTO = 6;
  public static final int IDDOC = 7;
  public static final int IDLIN = 8;
  public static final int IDTIPDOC = 9;
  public static final int IDCABSTR = 10;
  public static final int IDCABNUM = 11;
  public static final int PESINI = 12;
  public static final int PESFIN = 13;
  public static final int UBIPOS = 14;
  public static final int OBSERV = 15;
  public static final int CREATEDBY = 16;
  public static final int MODIFIEDBY = 17;
  public static final int CREATEDON = 18;
  public static final int MODIFIEDON = 19;
  public static final int INTEGRA = 20;
  public static final int TALBARAN = 21;
  public static final int NALBARAN = 22;

























  private static SgahistexistDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgahistexistImpl()
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
      mDefinitionObject = (SgahistexistDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgahistexist");
    }
    return mDefinitionObject;
  }


























  /**
   * 
   *  Gets the attribute value for Idmov, using the alias name Idmov
   */
  public Number getIdmov()
  {
    return (Number)getAttributeInternal(IDMOV);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idmov
   */
  public void setIdmov(Number value)
  {
    setAttributeInternal(IDMOV, value);
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
   *  Gets the attribute value for Idmac, using the alias name Idmac
   */
  public String getIdmac()
  {
    return (String)getAttributeInternal(IDMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idmac
   */
  public void setIdmac(String value)
  {
    setAttributeInternal(IDMAC, value);
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
   *  Gets the attribute value for Canini, using the alias name Canini
   */
  public Number getCanini()
  {
    return (Number)getAttributeInternal(CANINI);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Canini
   */
  public void setCanini(Number value)
  {
    setAttributeInternal(CANINI, value);
  }

  /**
   * 
   *  Gets the attribute value for Canfin, using the alias name Canfin
   */
  public Number getCanfin()
  {
    return (Number)getAttributeInternal(CANFIN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Canfin
   */
  public void setCanfin(Number value)
  {
    setAttributeInternal(CANFIN, value);
  }

  /**
   * 
   *  Gets the attribute value for Idbulto, using the alias name Idbulto
   */
  public Number getIdbulto()
  {
    return (Number)getAttributeInternal(IDBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idbulto
   */
  public void setIdbulto(Number value)
  {
    setAttributeInternal(IDBULTO, value);
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
   *  Gets the attribute value for Idlin, using the alias name Idlin
   */
  public Number getIdlin()
  {
    return (Number)getAttributeInternal(IDLIN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idlin
   */
  public void setIdlin(Number value)
  {
    setAttributeInternal(IDLIN, value);
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
   *  Gets the attribute value for Idcabstr, using the alias name Idcabstr
   */
  public String getIdcabstr()
  {
    return (String)getAttributeInternal(IDCABSTR);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabstr
   */
  public void setIdcabstr(String value)
  {
    setAttributeInternal(IDCABSTR, value);
  }

  /**
   * 
   *  Gets the attribute value for Idcabnum, using the alias name Idcabnum
   */
  public String getIdcabnum()
  {
    return (String)getAttributeInternal(IDCABNUM);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabnum
   */
  public void setIdcabnum(String value)
  {
    setAttributeInternal(IDCABNUM, value);
  }

  /**
   * 
   *  Gets the attribute value for Pesini, using the alias name Pesini
   */
  public Number getPesini()
  {
    return (Number)getAttributeInternal(PESINI);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Pesini
   */
  public void setPesini(Number value)
  {
    setAttributeInternal(PESINI, value);
  }

  /**
   * 
   *  Gets the attribute value for Pesfin, using the alias name Pesfin
   */
  public Number getPesfin()
  {
    return (Number)getAttributeInternal(PESFIN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Pesfin
   */
  public void setPesfin(Number value)
  {
    setAttributeInternal(PESFIN, value);
  }

  /**
   * 
   *  Gets the attribute value for Ubipos, using the alias name Ubipos
   */
  public String getUbipos()
  {
    return (String)getAttributeInternal(UBIPOS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ubipos
   */
  public void setUbipos(String value)
  {
    setAttributeInternal(UBIPOS, value);
  }







  /**
   * 
   *  Gets the attribute value for Observ, using the alias name Observ
   */
  public String getObserv()
  {
    return (String)getAttributeInternal(OBSERV);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Observ
   */
  public void setObserv(String value)
  {
    setAttributeInternal(OBSERV, value);
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
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDMOV:
        return getIdmov();
      case TIPMOV:
        return getTipmov();
      case IDMAC:
        return getIdmac();
      case IDART:
        return getIdart();
      case CANINI:
        return getCanini();
      case CANFIN:
        return getCanfin();
      case IDBULTO:
        return getIdbulto();
      case IDDOC:
        return getIddoc();
      case IDLIN:
        return getIdlin();
      case IDTIPDOC:
        return getIdtipdoc();
      case IDCABSTR:
        return getIdcabstr();
      case IDCABNUM:
        return getIdcabnum();
      case PESINI:
        return getPesini();
      case PESFIN:
        return getPesfin();
      case UBIPOS:
        return getUbipos();
      case OBSERV:
        return getObserv();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case INTEGRA:
        return getIntegra();
      case TALBARAN:
        return getTalbaran();
      case NALBARAN:
        return getNalbaran();
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
      case IDMOV:
        setIdmov((Number)value);
        return;
      case TIPMOV:
        setTipmov((String)value);
        return;
      case IDMAC:
        setIdmac((String)value);
        return;
      case IDART:
        setIdart((String)value);
        return;
      case CANINI:
        setCanini((Number)value);
        return;
      case CANFIN:
        setCanfin((Number)value);
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
      case IDTIPDOC:
        setIdtipdoc((String)value);
        return;
      case IDCABSTR:
        setIdcabstr((String)value);
        return;
      case IDCABNUM:
        setIdcabnum((String)value);
        return;
      case PESINI:
        setPesini((Number)value);
        return;
      case PESFIN:
        setPesfin((Number)value);
        return;
      case UBIPOS:
        setUbipos((String)value);
        return;
      case OBSERV:
        setObserv((String)value);
        return;
      case INTEGRA:
        setIntegra((String)value);
        return;
      case TALBARAN:
        setTalbaran((String)value);
        return;
      case NALBARAN:
        setNalbaran((String)value);
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

    // Xavi - Afegim la clau provinent de la sequencia seq_iddocman
    SequenceImpl idMovExistSeq = new SequenceImpl("SEQ_IDMOVEXIST", getDBTransaction());
    setIdmov(idMovExistSeq.getSequenceNumber());
  }


  
    public void afegirHistoric(Sgamovexist movexist)
  {
    setCanfin(movexist.getCanfin());
    setCanini(movexist.getCanini());
    setIdart(movexist.getIdart());
    setIdbulto(movexist.getIdbulto());
    setIdcabnum(movexist.getIdcabnum());
    setIdcabstr(movexist.getIdcabstr());
    setIddoc(movexist.getIddoc());
    setIdlin(movexist.getIdlin());
    setIdmac(movexist.getIdmac());
    setIdtipdoc(movexist.getIdtipdoc());
    setObserv(movexist.getObserv());
    setPesfin(movexist.getPesfin());
    setPesini(movexist.getPesini());
    setTipmov(movexist.getTipmov());
    setUbipos(movexist.getUbipos());
    setIntegra(movexist.getIntegra());
    setTalbaran(movexist.getTalbaran());
    setNalbaran(movexist.getNalbaran());    
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
   *  Gets the attribute value for Integra, using the alias name Integra
   */
  public String getIntegra()
  {
    return (String)getAttributeInternal(INTEGRA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Integra
   */
  public void setIntegra(String value)
  {
    setAttributeInternal(INTEGRA, value);
  }


  /**
   * 
   *  Gets the attribute value for Talbaran, using the alias name Talbaran
   */
  public String getTalbaran()
  {
    return (String)getAttributeInternal(TALBARAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Talbaran
   */
  public void setTalbaran(String value)
  {
    setAttributeInternal(TALBARAN, value);
  }

  /**
   * 
   *  Gets the attribute value for Nalbaran, using the alias name Nalbaran
   */
  public String getNalbaran()
  {
    return (String)getAttributeInternal(NALBARAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Nalbaran
   */
  public void setNalbaran(String value)
  {
    setAttributeInternal(NALBARAN, value);
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Number idmov)
  {
    return new Key(new Object[] {idmov});
  }






















}