package es.sysmap.interflex.model.bdc;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.jbo.Key;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaetiquetaImpl extends EntityImpl 
{
  public static final int IDDOC = 0;
  public static final int IDCABSTR = 1;
  public static final int IDCABNUM = 2;
  public static final int EXPEDICION = 3;
  public static final int CLIREDUR = 4;
  public static final int TIPOCB = 5;
  public static final int CODPOSTAL = 6;
  public static final int PAISDESTINO = 7;
  public static final int PAISORIGEN = 8;
  public static final int PLAZA = 9;
  public static final int CREATEDBY = 10;
  public static final int MODIFIEDBY = 11;
  public static final int CREATEDON = 12;
  public static final int MODIFIEDON = 13;
  public static final int SGACDOC = 14;



  private static SgaetiquetaDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaetiquetaImpl()
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
      mDefinitionObject = (SgaetiquetaDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgaetiqueta");
    }
    return mDefinitionObject;
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
  public Number getIdcabnum()
  {
    return (Number)getAttributeInternal(IDCABNUM);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idcabnum
   */
  public void setIdcabnum(Number value)
  {
    setAttributeInternal(IDCABNUM, value);
  }

  /**
   * 
   *  Gets the attribute value for Expedicion, using the alias name Expedicion
   */
  public Number getExpedicion()
  {
    return (Number)getAttributeInternal(EXPEDICION);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Expedicion
   */
  public void setExpedicion(Number value)
  {
    setAttributeInternal(EXPEDICION, value);
  }

  /**
   * 
   *  Gets the attribute value for CliRedur, using the alias name CliRedur
   */
  public Number getCliRedur()
  {
    return (Number)getAttributeInternal(CLIREDUR);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for CliRedur
   */
  public void setCliRedur(Number value)
  {
    setAttributeInternal(CLIREDUR, value);
  }

  /**
   * 
   *  Gets the attribute value for TipoCb, using the alias name TipoCb
   */
  public Number getTipoCb()
  {
    return (Number)getAttributeInternal(TIPOCB);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for TipoCb
   */
  public void setTipoCb(Number value)
  {
    setAttributeInternal(TIPOCB, value);
  }

  /**
   * 
   *  Gets the attribute value for CodPostal, using the alias name CodPostal
   */
  public String getCodPostal()
  {
    return (String)getAttributeInternal(CODPOSTAL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for CodPostal
   */
  public void setCodPostal(String value)
  {
    setAttributeInternal(CODPOSTAL, value);
  }

  /**
   * 
   *  Gets the attribute value for PaisDestino, using the alias name PaisDestino
   */
  public Number getPaisDestino()
  {
    return (Number)getAttributeInternal(PAISDESTINO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for PaisDestino
   */
  public void setPaisDestino(Number value)
  {
    setAttributeInternal(PAISDESTINO, value);
  }

  /**
   * 
   *  Gets the attribute value for PaisOrigen, using the alias name PaisOrigen
   */
  public Number getPaisOrigen()
  {
    return (Number)getAttributeInternal(PAISORIGEN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for PaisOrigen
   */
  public void setPaisOrigen(Number value)
  {
    setAttributeInternal(PAISORIGEN, value);
  }

  /**
   * 
   *  Gets the attribute value for Plaza, using the alias name Plaza
   */
  public String getPlaza()
  {
    return (String)getAttributeInternal(PLAZA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Plaza
   */
  public void setPlaza(String value)
  {
    setAttributeInternal(PLAZA, value);
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
  public Date getCreatedon()
  {
    return (Date)getAttributeInternal(CREATEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Createdon
   */
  public void setCreatedon(Date value)
  {
    setAttributeInternal(CREATEDON, value);
  }

  /**
   * 
   *  Gets the attribute value for Modifiedon, using the alias name Modifiedon
   */
  public Date getModifiedon()
  {
    return (Date)getAttributeInternal(MODIFIEDON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Modifiedon
   */
  public void setModifiedon(Date value)
  {
    setAttributeInternal(MODIFIEDON, value);
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
      case EXPEDICION:
        return getExpedicion();
      case CLIREDUR:
        return getCliRedur();
      case TIPOCB:
        return getTipoCb();
      case CODPOSTAL:
        return getCodPostal();
      case PAISDESTINO:
        return getPaisDestino();
      case PAISORIGEN:
        return getPaisOrigen();
      case PLAZA:
        return getPlaza();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
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
      case IDDOC:
        setIddoc((Number)value);
        return;
      case IDCABSTR:
        setIdcabstr((String)value);
        return;
      case IDCABNUM:
        setIdcabnum((Number)value);
        return;
      case EXPEDICION:
        setExpedicion((Number)value);
        return;
      case CLIREDUR:
        setCliRedur((Number)value);
        return;
      case TIPOCB:
        setTipoCb((Number)value);
        return;
      case CODPOSTAL:
        setCodPostal((String)value);
        return;
      case PAISDESTINO:
        setPaisDestino((Number)value);
        return;
      case PAISORIGEN:
        setPaisOrigen((Number)value);
        return;
      case PLAZA:
        setPlaza((String)value);
        return;
      case CREATEDBY:
        setCreatedby((String)value);
        return;
      case MODIFIEDBY:
        setModifiedby((String)value);
        return;
      case CREATEDON:
        setCreatedon((Date)value);
        return;
      case MODIFIEDON:
        setModifiedon((Date)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  
  public boolean insertarEtiqueta(Number iddoc, ResultSet etiqueta) 
  {
    boolean insertat = true;
    try
    {
      setIddoc(iddoc);
      setIdcabstr(etiqueta.getString("eti_tid").trim());    
      setIdcabnum(new Number(etiqueta.getBigDecimal("eti_id")));
      setExpedicion(new Number(etiqueta.getBigDecimal("eti_expedicion")));
      setCliRedur(new Number(etiqueta.getBigDecimal("eti_cli_redur")));
      setTipoCb(new Number(etiqueta.getBigDecimal("eti_tipo_cb")));
      setCodPostal(etiqueta.getString("eti_cod_postal").trim());
      setPaisDestino(new Number(etiqueta.getBigDecimal("eti_pais_destino")));
      setPaisOrigen(new Number(etiqueta.getBigDecimal("eti_pais_origen")));
      setPlaza(etiqueta.getString("eti_plaza").trim());
    }
    catch(SQLException ex)
    {
      ex.printStackTrace();
      insertat = false;
    }
    return insertat;
  }


  /**
   * 
   *  Gets the associated entity SgacdocImpl
   */
  public SgacdocImpl getSgacdoc()
  {
    return (SgacdocImpl)getAttributeInternal(SGACDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgacdocImpl
   */
  public void setSgacdoc(SgacdocImpl value)
  {
    setAttributeInternal(SGACDOC, value);
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Number iddoc)
  {
    return new Key(new Object[] {iddoc});
  }


  
}