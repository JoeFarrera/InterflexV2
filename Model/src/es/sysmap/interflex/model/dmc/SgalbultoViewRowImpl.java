package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgalbultoViewRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgalbultoViewRow 
{


  public static final int IDBULTO = 0;
  public static final int IDDOC = 1;
  public static final int IDLIN = 2;
  public static final int CANTOT = 3;
  public static final int PESO = 4;
  public static final int IDTIPMAC = 5;
  public static final int RELLENO = 6;
  public static final int CANRES = 7;
  public static final int CANPEN = 8;
  public static final int CANENT = 9;
  public static final int ESTADO = 10;
  public static final int IDARTIF = 11;
  public static final int DESCRIP = 12;
  public static final int SGABULTOVIEW1 = 13;
  public static final int SGARESMATVIEW = 14;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgalbultoViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Sgalbulto entity object.
   */
  public es.sysmap.interflex.model.bdc.SgalbultoImpl getSgalbulto()
  {
    return (es.sysmap.interflex.model.bdc.SgalbultoImpl)getEntity(0);
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
   *  Gets the attribute value for IDTIPMAC using the alias name Idtipmac
   */
  public String getIdtipmac()
  {
    return (String)getAttributeInternal(IDTIPMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDTIPMAC using the alias name Idtipmac
   */
  public void setIdtipmac(String value)
  {
    setAttributeInternal(IDTIPMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for RELLENO using the alias name Relleno
   */
  public String getRelleno()
  {
    return (String)getAttributeInternal(RELLENO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for RELLENO using the alias name Relleno
   */
  public void setRelleno(String value)
  {
    setAttributeInternal(RELLENO, value);
  }




  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
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
      case IDTIPMAC:
        return getIdtipmac();
      case RELLENO:
        return getRelleno();
      case CANRES:
        return getCanres();
      case CANPEN:
        return getCanpen();
      case CANENT:
        return getCanent();
      case ESTADO:
        return getEstado();
      case IDARTIF:
        return getIdartif();
      case DESCRIP:
        return getDescrip();
      case SGARESMATVIEW:
        return getSgaresmatView();
      case SGABULTOVIEW1:
        return getSgabultoView1();
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
      case IDTIPMAC:
        setIdtipmac((String)value);
        return;
      case RELLENO:
        setRelleno((String)value);
        return;
      case CANRES:
        setCanres((Number)value);
        return;
      case CANPEN:
        setCanpen((Number)value);
        return;
      case CANENT:
        setCanent((Number)value);
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
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   *  Gets the attribute value for CANRES using the alias name Canres
   */
  public Number getCanres()
  {
    return (Number)getAttributeInternal(CANRES);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANRES using the alias name Canres
   */
  public void setCanres(Number value)
  {
    setAttributeInternal(CANRES, value);
  }

  /**
   * 
   *  Gets the attribute value for CANPEN using the alias name Canpen
   */
  public Number getCanpen()
  {
    return (Number)getAttributeInternal(CANPEN);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANPEN using the alias name Canpen
   */
  public void setCanpen(Number value)
  {
    setAttributeInternal(CANPEN, value);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgaresmatView
   */
  public oracle.jbo.RowIterator getSgaresmatView()
  {
    return (oracle.jbo.RowIterator)getAttributeInternal(SGARESMATVIEW);
  }

  /**
   * 
   *  Gets the associated <code>Row</code> using master-detail link SgabultoView1
   */
  public oracle.jbo.Row getSgabultoView1()
  {
    return (oracle.jbo.Row)getAttributeInternal(SGABULTOVIEW1);
  }
  
  public void reservarEntrada(String idmac, Number canres)
  {
    getSgalbulto().reservarEntrada(idmac, canres);
  }

  /**
   * 
   *  Gets the attribute value for CANENT using the alias name Canent
   */
  public Number getCanent()
  {
    return (Number)getAttributeInternal(CANENT);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANENT using the alias name Canent
   */
  public void setCanent(Number value)
  {
    setAttributeInternal(CANENT, value);
  }

  /**
   * 
   *  Gets the attribute value for ESTADO using the alias name Estado
   */
  public String getEstado()
  {
    return (String)getAttributeInternal(ESTADO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for ESTADO using the alias name Estado
   */
  public void setEstado(String value)
  {
    setAttributeInternal(ESTADO, value);
  }

  /**
   * 
   *  Gets the attribute value for IDARTIF using the alias name Idartif
   */
  public String getIdartif()
  {
    return (String)getAttributeInternal(IDARTIF);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDARTIF using the alias name Idartif
   */
  public void setIdartif(String value)
  {
    setAttributeInternal(IDARTIF, value);
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

}
