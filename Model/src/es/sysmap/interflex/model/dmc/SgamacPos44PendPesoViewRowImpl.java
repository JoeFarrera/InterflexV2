package es.sysmap.interflex.model.dmc;
import es.sysmap.interflex.model.bdc.Sgamovexist;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgamacPos44PendPesoViewRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgamacPos44PendPesoViewRow 
{


  public static final int IDMAC = 0;
  public static final int MULTIREF = 1;
  public static final int IDTIPMAC = 2;
  public static final int ESTADO = 3;
  public static final int TARA = 4;
  public static final int ESTADO1 = 5;
  public static final int IDORD = 6;
  public static final int BASCULASLO = 7;
  public static final int DESCRIPTIPOMAC = 8;
  public static final int IDARTIF = 9;
  public static final int DESCRIPART = 10;
  public static final int UNIEMB = 11;
  public static final int CANTOT = 12;
  public static final int PESREAL = 13;
  public static final int CANPESREAL = 14;
  public static final int CANTOTUSUARI = 15;
  public static final int IDUBI = 16;
  public static final int IDTIPUBI = 17;
  public static final int IDTIPALM = 18;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgamacPos44PendPesoViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Sgamac entity object.
   */
  public es.sysmap.interflex.model.bdc.SgamacImpl getSgamac()
  {
    return (es.sysmap.interflex.model.bdc.SgamacImpl)getEntity(0);
  }


  /**
   * 
   *  Gets Sgaubicacion entity object.
   */
  public es.sysmap.interflex.model.bdc.SgaubicacionImpl getSgaubicacion()
  {
    return (es.sysmap.interflex.model.bdc.SgaubicacionImpl)getEntity(2);
  }


  /**
   * Ver si la b�scula est� activada
   * @return 
   */
  public boolean isActiveBascula()
  {
    return getBasculaslo().equals("S");
  }
  
  public Number getPesTeoric()
  {
    return getSgamac().getPesTeoric();
  }
  
  public void confirmarControlPes()
  {
    // set estado de la orden de transporte para que se lo lleve el traslo
    setEstado1("W");
    getApplicationModule().getTransaction().commit();
  }
  
  public void regularizarExistencia()
  {
    // NOTE 10.10.2006 Michael THIS IS DUPLICATED IN SgamacSenseReserva....
    if (!getCantotUsuari().equals(getCantot()))
    {
      // Posem tota la informaci� a l'estructura que necessitem per crear l'hist�ric
      Sgamovexist movexist = new Sgamovexist();
      movexist.setCancon(getCantotUsuari());
      movexist.setCanres(new Number(0));
      // NOTA: la existencia siempre ser� la primera, lets hope
      movexist.setIdart(getSgamac().getFirstExistencia().getIdart());
      movexist.setIdbulto(null);
      movexist.setIdcabnum(null);
      movexist.setIdcabstr(null);
      movexist.setIddoc(null);
      movexist.setIdlin(null);
      movexist.setIdmac(getIdmac());
      movexist.setIdtipdoc(null);
      movexist.setObserv("Control pes");
      movexist.setPesfin(getPesReal());
      movexist.setPesini(getPesTeoric());
      movexist.setUbipos(getSgamac().getUbipos());
      movexist.setTipmov("R");
      movexist.setNalbaran(null);
      movexist.setTalbaran(null);
      
      // Actualitzem l'existencia, deixant a cancon la quantitat a afegir o treure
      // per poder utilitzar els mateixos procediments que si fos una entrada o una
      // sortida
      Number canCon = new Number(getCantot().subtract(getCantotUsuari()).abs());
      movexist.setCancon(canCon);
      if (getCantot().compareTo(getCantotUsuari()) < 0)
      {
        getSgamac().afegirMaterial(movexist);
      }
      else
      {
        getSgamac().treureMaterial(movexist);
      }
    }
    confirmarControlPes();

  }
  
  
  /**
   * 
   *  Gets the attribute value for IDMAC using the alias name Idmac
   */
  public String getIdmac()
  {
    return (String)getAttributeInternal(IDMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDMAC using the alias name Idmac
   */
  public void setIdmac(String value)
  {
    setAttributeInternal(IDMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for MULTIREF using the alias name Multiref
   */
  public String getMultiref()
  {
    return (String)getAttributeInternal(MULTIREF);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for MULTIREF using the alias name Multiref
   */
  public void setMultiref(String value)
  {
    setAttributeInternal(MULTIREF, value);
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
   *  Gets the attribute value for TARA using the alias name Tara
   */
  public Number getTara()
  {
    return (Number)getAttributeInternal(TARA);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for TARA using the alias name Tara
   */
  public void setTara(Number value)
  {
    setAttributeInternal(TARA, value);
  }

  /**
   * 
   *  Gets the attribute value for ESTADO using the alias name Estado1
   */
  public String getEstado1()
  {
    return (String)getAttributeInternal(ESTADO1);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for ESTADO using the alias name Estado1
   */
  public void setEstado1(String value)
  {
    setAttributeInternal(ESTADO1, value);
  }

  /**
   * 
   *  Gets the attribute value for IDORD using the alias name Idord
   */
  public Number getIdord()
  {
    return (Number)getAttributeInternal(IDORD);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDORD using the alias name Idord
   */
  public void setIdord(Number value)
  {
    setAttributeInternal(IDORD, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDMAC:
        return getIdmac();
      case MULTIREF:
        return getMultiref();
      case IDTIPMAC:
        return getIdtipmac();
      case ESTADO:
        return getEstado();
      case TARA:
        return getTara();
      case ESTADO1:
        return getEstado1();
      case IDORD:
        return getIdord();
      case BASCULASLO:
        return getBasculaslo();
      case DESCRIPTIPOMAC:
        return getDescriptipomac();
      case IDARTIF:
        return getIdartif();
      case DESCRIPART:
        return getDescripart();
      case UNIEMB:
        return getUniemb();
      case CANTOT:
        return getCantot();
      case PESREAL:
        return getPesReal();
      case CANPESREAL:
        return getCanPesReal();
      case CANTOTUSUARI:
        return getCantotUsuari();
      case IDUBI:
        return getIdubi();
      case IDTIPUBI:
        return getIdtipubi();
      case IDTIPALM:
        return getIdtipalm();
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
      case IDMAC:
        setIdmac((String)value);
        return;
      case MULTIREF:
        setMultiref((String)value);
        return;
      case IDTIPMAC:
        setIdtipmac((String)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case TARA:
        setTara((Number)value);
        return;
      case ESTADO1:
        setEstado1((String)value);
        return;
      case IDORD:
        setIdord((Number)value);
        return;
      case BASCULASLO:
        setBasculaslo((String)value);
        return;
      case DESCRIPTIPOMAC:
        setDescriptipomac((String)value);
        return;
      case IDARTIF:
        setIdartif((String)value);
        return;
      case DESCRIPART:
        setDescripart((String)value);
        return;
      case UNIEMB:
        setUniemb((Number)value);
        return;
      case CANTOT:
        setCantot((Number)value);
        return;
      case PESREAL:
        setPesReal((Number)value);
        return;
      case CANPESREAL:
        setCanPesReal((Number)value);
        return;
      case CANTOTUSUARI:
        setCantotUsuari((Number)value);
        return;
      case IDUBI:
        setIdubi((String)value);
        return;
      case IDTIPUBI:
        setIdtipubi((String)value);
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
   *  Gets the attribute value for the calculated attribute Basculaslo
   */
  public String getBasculaslo()
  {
    return (String)getAttributeInternal(BASCULASLO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Basculaslo
   */
  public void setBasculaslo(String value)
  {
    setAttributeInternal(BASCULASLO, value);
  }







  /**
   * 
   *  Gets the attribute value for the calculated attribute Descriptipomac
   */
  public String getDescriptipomac()
  {
    return (String)getAttributeInternal(DESCRIPTIPOMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descriptipomac
   */
  public void setDescriptipomac(String value)
  {
    setAttributeInternal(DESCRIPTIPOMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idartif
   */
  public String getIdartif()
  {
    return (String)getAttributeInternal(IDARTIF);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idartif
   */
  public void setIdartif(String value)
  {
    setAttributeInternal(IDARTIF, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descripart
   */
  public String getDescripart()
  {
    return (String)getAttributeInternal(DESCRIPART);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descripart
   */
  public void setDescripart(String value)
  {
    setAttributeInternal(DESCRIPART, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Uniemb
   */
  public Number getUniemb()
  {
    return (Number)getAttributeInternal(UNIEMB);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Uniemb
   */
  public void setUniemb(Number value)
  {
    setAttributeInternal(UNIEMB, value);
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
   *  Gets the attribute value for the calculated attribute PesReal
   */
  public Number getPesReal()
  {
    return (Number)getAttributeInternal(PESREAL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute PesReal
   */
  public void setPesReal(Number value)
  {
    setAttributeInternal(PESREAL, value);
    Number total = getSgamac().getCantotPerPes(value);
    setCanPesReal(total);
    setCantotUsuari(total);
  }
  
  public boolean hasCantidadDiferentSegonsPes (Number value)
  {
    setPesReal(value);
    if (!getCanPesReal().equals(getCantot()))
      return true;
    else
      return false;
  }
  
  public boolean isControladaPerPes()
  {
    return getSgamac().isControladaPerPes();
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute CanPesReal
   */
  public Number getCanPesReal()
  {
    return (Number)getAttributeInternal(CANPESREAL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute CanPesReal
   */
  public void setCanPesReal(Number value)
  {
    setAttributeInternal(CANPESREAL, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute CantotUsuari
   */
  public Number getCantotUsuari()
  {
    return (Number)getAttributeInternal(CANTOTUSUARI);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute CantotUsuari
   */
  public void setCantotUsuari(Number value)
  {
    setAttributeInternal(CANTOTUSUARI, value);
  }

  /**
   * 
   *  Gets the attribute value for IDUBI using the alias name Idubi
   */
  public String getIdubi()
  {
    return (String)getAttributeInternal(IDUBI);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDUBI using the alias name Idubi
   */
  public void setIdubi(String value)
  {
    setAttributeInternal(IDUBI, value);
  }

  /**
   * 
   *  Gets the attribute value for IDTIPUBI using the alias name Idtipubi
   */
  public String getIdtipubi()
  {
    return (String)getAttributeInternal(IDTIPUBI);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDTIPUBI using the alias name Idtipubi
   */
  public void setIdtipubi(String value)
  {
    setAttributeInternal(IDTIPUBI, value);
  }

  /**
   * 
   *  Gets the attribute value for IDTIPALM using the alias name Idtipalm
   */
  public String getIdtipalm()
  {
    return (String)getAttributeInternal(IDTIPALM);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDTIPALM using the alias name Idtipalm
   */
  public void setIdtipalm(String value)
  {
    setAttributeInternal(IDTIPALM, value);
  }

  /**
   * 
   *  Gets Sgaordtran entity object.
   */
  public es.sysmap.interflex.model.bdc.SgaordtranImpl getSgaordtran()
  {
    return (es.sysmap.interflex.model.bdc.SgaordtranImpl)getEntity(1);
  }
}