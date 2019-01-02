package es.sysmap.interflex.model.bdc;
import es.sysmap.interflex.model.dmc.SgacdocViewImpl;
import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.AttributeList;
import oracle.jbo.domain.Number;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
import oracle.jbo.Key;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.domain.Date;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgamovimientoImpl extends EntityImpl 
{
  public static final int IDMOV = 0;
  public static final int CANTOT = 1;
  public static final int IDCABSTR = 2;
  public static final int IDCABNUM = 3;
  public static final int IDLIN = 4;
  public static final int TIPORD = 5;
  public static final int OPERARIO = 6;
  public static final int OBJETO = 7;
  public static final int TIPALBARAN = 8;
  public static final int NUMALBARAN = 9;
  public static final int CREATEDBY = 10;
  public static final int CREATEDON = 11;
  public static final int ESTADO = 12;
  public static final int MODIFIEDBY = 13;
  public static final int MODIFIEDON = 14;
  public static final int IDART = 15;
  public static final int IDARTIF = 16;
  public static final int IDUSER = 17;
  public static final int MOTIVO = 18;
  public static final int SGASTOCK = 19;







































  private static SgamovimientoDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgamovimientoImpl()
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
      mDefinitionObject = (SgamovimientoDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgamovimiento");
    }
    return mDefinitionObject;
  }








































  /**
   * 
   *  Add attribute defaulting logic in this method.
   */
  protected void create(AttributeList attributeList)
  {
    super.create(attributeList);

    // Xavi - Afegim la clau provinent de la sequencia 
    SequenceImpl idMovSeq = new SequenceImpl("SEQ_IDMOV", getDBTransaction());
    setIdmov(idMovSeq.getSequenceNumber());
    
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
   *  Gets the attribute value for Cantot, using the alias name Cantot
   */
  public Number getCantot()
  {
    return (Number)getAttributeInternal(CANTOT);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Cantot
   */
  public void setCantot(Number value)
  {
    setAttributeInternal(CANTOT, value);
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
   *  Gets the attribute value for Tipord, using the alias name Tipord
   */
  public Number getTipord()
  {
    return (Number)getAttributeInternal(TIPORD);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tipord
   */
  public void setTipord(Number value)
  {
    setAttributeInternal(TIPORD, value);
  }

  /**
   * 
   *  Gets the attribute value for Operario, using the alias name Operario
   */
  public Number getOperario()
  {
    return (Number)getAttributeInternal(OPERARIO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Operario
   */
  public void setOperario(Number value)
  {
    setAttributeInternal(OPERARIO, value);
  }

  /**
   * 
   *  Gets the attribute value for Objeto, using the alias name Objeto
   */
  public Number getObjeto()
  {
    return (Number)getAttributeInternal(OBJETO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Objeto
   */
  public void setObjeto(Number value)
  {
    setAttributeInternal(OBJETO, value);
  }

  /**
   * 
   *  Gets the attribute value for Tipalbaran, using the alias name Tipalbaran
   */
  public String getTipalbaran()
  {
    return (String)getAttributeInternal(TIPALBARAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tipalbaran
   */
  public void setTipalbaran(String value)
  {
    setAttributeInternal(TIPALBARAN, value);
  }

  /**
   * 
   *  Gets the attribute value for Numalbaran, using the alias name Numalbaran
   */
  public Number getNumalbaran()
  {
    return (Number)getAttributeInternal(NUMALBARAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Numalbaran
   */
  public void setNumalbaran(Number value)
  {
    setAttributeInternal(NUMALBARAN, value);
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
      case CANTOT:
        return getCantot();
      case IDCABSTR:
        return getIdcabstr();
      case IDCABNUM:
        return getIdcabnum();
      case IDLIN:
        return getIdlin();
      case TIPORD:
        return getTipord();
      case OPERARIO:
        return getOperario();
      case OBJETO:
        return getObjeto();
      case TIPALBARAN:
        return getTipalbaran();
      case NUMALBARAN:
        return getNumalbaran();
      case CREATEDBY:
        return getCreatedby();
      case CREATEDON:
        return getCreatedon();
      case ESTADO:
        return getEstado();
      case MODIFIEDBY:
        return getModifiedby();
      case MODIFIEDON:
        return getModifiedon();
      case IDART:
        return getIdart();
      case IDARTIF:
        return getIdartif();
      case IDUSER:
        return getIduser();
      case MOTIVO:
        return getMotivo();
      case SGASTOCK:
        return getSgastock();
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
      case CANTOT:
        setCantot((Number)value);
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
      case TIPORD:
        setTipord((Number)value);
        return;
      case OPERARIO:
        setOperario((Number)value);
        return;
      case OBJETO:
        setObjeto((Number)value);
        return;
      case TIPALBARAN:
        setTipalbaran((String)value);
        return;
      case NUMALBARAN:
        setNumalbaran((Number)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case IDART:
        setIdart((String)value);
        return;
      case IDARTIF:
        setIdartif((String)value);
        return;
      case IDUSER:
        setIduser((String)value);
        return;
      case MOTIVO:
        setMotivo((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }


  /**
   * Afegeix un moviment a la taula
   * @param movexist
   */
  public void afegirMoviment(Sgamovimiento movimiento)
  {
    setCantot(movimiento.getCantot());
    setIdcabnum(movimiento.getIdcabnum());
    setIdcabstr(movimiento.getIdcabstr());
    setIdlin(movimiento.getIdlin());    
    setIduser(movimiento.getIduser());
    setTipord(movimiento.getTipord());
    setObjeto(movimiento.getObjeto());
    setTipalbaran(movimiento.getTipalbaran());
    setNumalbaran(movimiento.getNumalbaran());
    setIdart(movimiento.getIdart());
    setMotivo(movimiento.getMotivo());
    
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
   *  Gets the associated entity SgastockImpl
   */
  public SgastockImpl getSgastock()
  {
    return (SgastockImpl)getAttributeInternal(SGASTOCK);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgastockImpl
   */
  public void setSgastock(SgastockImpl value)
  {
    setAttributeInternal(SGASTOCK, value);
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
   *  Gets the attribute value for Iduser, using the alias name Iduser
   */
  public String getIduser()
  {
    return (String)getAttributeInternal(IDUSER);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Iduser
   */
  public void setIduser(String value)
  {
    setAttributeInternal(IDUSER, value);
  }


  /**
   * 
   *  Gets the attribute value for Motivo, using the alias name Motivo
   */
  public String getMotivo()
  {
    return (String)getAttributeInternal(MOTIVO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Motivo
   */
  public void setMotivo(String value)
  {
    setAttributeInternal(MOTIVO, value);
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