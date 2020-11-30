package es.sysmap.interflex.model.dmc;
import es.sysmap.interflex.model.bdc.InterflexMessageBundle;
import es.sysmap.interflex.model.bdc.SgamacImpl;
import es.sysmap.interflex.model.bdc.Sgamovexist;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;

import org.apache.log4j.Logger;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaldocEntradesViewRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgaldocEntradesViewRow 
{


  public static final int IDBULTO = 0;
  public static final int IDDOC = 1;
  public static final int IDLIN = 2;
  public static final int CANTOTBULTO = 3;
  public static final int CANRESBULTO = 4;
  public static final int CANPENBULTO = 5;
  public static final int ESTADOBULTO = 6;
  public static final int IDTIPMAC = 7;
  public static final int UNIMAC = 8;
  public static final int RELLENO = 9;
  public static final int CANTOT = 10;
  public static final int CANRES = 11;
  public static final int CANPEN = 12;
  public static final int IDLIN1 = 13;
  public static final int IDDOC1 = 14;
  public static final int IDARTIF = 15;
  public static final int DESCRIP = 16;
  public static final int CANCON = 17;
  public static final int IDMAC = 18;
  public static final int IDART = 19;
  public static final int IDCABNUM = 20;
  public static final int IDCABSTR = 21;
  public static final int OBSERV = 22;
  public static final int DESCESTADO = 23;
  public static final int DESCESTADOBULTO = 24;
  public static final int DESCTIPMAC = 25;
  public static final int PESINI = 26;
  public static final int PESFIN = 27;
  public static final int DIFPES = 28;
  public static final int CANENTBULTO = 29;
  public static final int PESO = 30;
  public static final int ESTADO = 31;
  public static final int INTEGRA = 32;
  public static final int MODIFIEDBY = 33;
  public static final int IDUBI = 34;
  public static final int DESCUBI = 35;
  public static final int ESPECIAL = 36;
  public static final int SGACDOCENTRADESVIEW = 37;
  public static final int SGABULTOVIEW1 = 38;
  public static final int SGAMACVIEW = 39;
  
  protected Logger LOG = Logger.getLogger(getClass());
  
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaldocEntradesViewRowImpl()
  {
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
   *  Gets the attribute value for CANTOT using the alias name Cantotbulto
   */
  public Number getCantotbulto()
  {
    return (Number)getAttributeInternal(CANTOTBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANTOT using the alias name Cantotbulto
   */
  public void setCantotbulto(Number value)
  {
    setAttributeInternal(CANTOTBULTO, value);
  }

  /**
   * 
   *  Gets the attribute value for CANRES using the alias name Canresbulto
   */
  public Number getCanresbulto()
  {
    return (Number)getAttributeInternal(CANRESBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANRES using the alias name Canresbulto
   */
  public void setCanresbulto(Number value)
  {
    setAttributeInternal(CANRESBULTO, value);
  }

  /**
   * 
   *  Gets the attribute value for CANPEN using the alias name Canpenbulto
   */
  public Number getCanpenbulto()
  {
    return (Number)getAttributeInternal(CANPENBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANPEN using the alias name Canpenbulto
   */
  public void setCanpenbulto(Number value)
  {
    setAttributeInternal(CANPENBULTO, value);
  }

  /**
   * 
   *  Gets the attribute value for ESTADO using the alias name Estadobulto
   */
  public String getEstadobulto()
  {
    return (String)getAttributeInternal(ESTADOBULTO);
  }
  
  /**
   * devuelve true si el puesto del bulto no est� asignado o est� asignado al puesto del caller
   * @return 
   * @param idPuesto
   */
  private boolean isOKPuesto (String idPuesto)
  {
    SgabultoViewRowImpl bRow = (SgabultoViewRowImpl)getSgabultoView1();
    return (bRow.getIdpuesto() == null || bRow.getIdpuesto().length() == 0 || bRow.getIdpuesto().equals(idPuesto));
    
  }
  
  /**
   * ver si se puede abrir la l�nea del bulto:
   * - que no est� finalizado ni anulado
   * - que no est� asignado a otro puesto
   * @return 
   * @param idPuesto
   */
  public boolean isOKObrir (String idPuesto)
  {
    if (isOKPuesto (idPuesto))
    {
      return (!getEstadobulto().equals("F") && !getEstadobulto().equals("A"));
    }
    else
      return false;
    
  }
  
  public boolean isOKSuspender (String idPuesto)
  {
    if (isOKPuesto(idPuesto))
    {
      return (getEstadobulto().equals("P"));
    }
    return false;
  }
  
  public boolean isOKAnular (String idPuesto)
  {
    if (isOKPuesto(idPuesto))
    { 
      // Michael 01.06.2012 add new state to allow cancelling unopened line
      return (getEstadobulto().equals("N") || getEstadobulto().equals("P") || getEstadobulto().equals("S"));
    }
    return false;
  }
  
  
  public void suspenderLiniaBulto()
  {
    if (getEstadobulto().equals("P"))
    {
      setEstadobulto("S");
    }
  }
  
  public void tancarLiniaBulto()
  {
    if (getEstadobulto().equals("N") || getEstadobulto().equals("P") || getEstadobulto().equals("S"))
    {
      setEstadobulto("A");
      
    }
  }
  public void obrirLiniaBulto(String idPuesto)
  {
    if (!getEstadobulto().equals("P"))
    {
      SgabultoViewRowImpl bRow = (SgabultoViewRowImpl)getSgabultoView1();
      // actualizar el puesto del bulto - si no estuviera asignado
      bRow.setIdpuesto(idPuesto);
  
      setEstadobulto("P");
    }
  }
  

  /**
   * 
   *  Sets <code>value</code> as attribute value for ESTADO using the alias name Estadobulto
   */
  public void setEstadobulto(String value)
  {
    setAttributeInternal(ESTADOBULTO, value);
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
   *  Gets the attribute value for IDLIN using the alias name Idlin1
   */
  public Number getIdlin1()
  {
    return (Number)getAttributeInternal(IDLIN1);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDLIN using the alias name Idlin1
   */
  public void setIdlin1(Number value)
  {
    setAttributeInternal(IDLIN1, value);
  }

  /**
   * 
   *  Gets the attribute value for IDDOC using the alias name Iddoc1
   */
  public Number getIddoc1()
  {
    return (Number)getAttributeInternal(IDDOC1);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDDOC using the alias name Iddoc1
   */
  public void setIddoc1(Number value)
  {
    setAttributeInternal(IDDOC1, value);
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
   *  Gets the attribute value for DESCRIP using the alias name Descrip
   */
  public String getDescrip()
  {
    return (String)getAttributeInternal(DESCRIP);
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
      case CANTOTBULTO:
        return getCantotbulto();
      case CANRESBULTO:
        return getCanresbulto();
      case CANPENBULTO:
        return getCanpenbulto();
      case ESTADOBULTO:
        return getEstadobulto();
      case IDTIPMAC:
        return getIdtipmac();
      case UNIMAC:
        return getUnimac();
      case RELLENO:
        return getRelleno();
      case CANTOT:
        return getCantot();
      case CANRES:
        return getCanres();
      case CANPEN:
        return getCanpen();
      case IDLIN1:
        return getIdlin1();
      case IDDOC1:
        return getIddoc1();
      case IDARTIF:
        return getIdartif();
      case DESCRIP:
        return getDescrip();
      case CANCON:
        return getCancon();
      case IDMAC:
        return getIdmac();
      case IDART:
        return getIdart();
      case IDCABNUM:
        return getIdcabnum();
      case IDCABSTR:
        return getIdcabstr();
      case OBSERV:
        return getObserv();
      case DESCESTADO:
        return getDescestado();
      case DESCESTADOBULTO:
        return getDescestadobulto();
      case DESCTIPMAC:
        return getDesctipmac();
      case PESINI:
        return getPesini();
      case PESFIN:
        return getPesfin();
      case DIFPES:
        return getDifpes();
      case CANENTBULTO:
        return getCanentbulto();
      case PESO:
        return getPeso();
      case ESTADO:
        return getEstado();
      case INTEGRA:
        return getIntegra();
      case MODIFIEDBY:
        return getModifiedby();
      case IDUBI:
        return getIdubi();
      case DESCUBI:
        return getDescubi();
      case ESPECIAL:
        return getEspecial();
      case SGAMACVIEW:
        return getSgamacView();
      case SGACDOCENTRADESVIEW:
        return getSgacdocEntradesView();
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
      case CANTOTBULTO:
        setCantotbulto((Number)value);
        return;
      case CANRESBULTO:
        setCanresbulto((Number)value);
        return;
      case CANPENBULTO:
        setCanpenbulto((Number)value);
        return;
      case ESTADOBULTO:
        setEstadobulto((String)value);
        return;
      case IDTIPMAC:
        setIdtipmac((String)value);
        return;
      case UNIMAC:
        setUnimac((Number)value);
        return;
      case RELLENO:
        setRelleno((String)value);
        return;
      case CANTOT:
        setCantot((Number)value);
        return;
      case CANRES:
        setCanres((Number)value);
        return;
      case CANPEN:
        setCanpen((Number)value);
        return;
      case IDLIN1:
        setIdlin1((Number)value);
        return;
      case IDDOC1:
        setIddoc1((Number)value);
        return;
      case IDARTIF:
        setIdartif((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      case CANCON:
        setCancon((Number)value);
        return;
      case IDMAC:
        setIdmac((String)value);
        return;
      case IDART:
        setIdart((String)value);
        return;
      case IDCABNUM:
        setIdcabnum((String)value);
        return;
      case IDCABSTR:
        setIdcabstr((String)value);
        return;
      case OBSERV:
        setObserv((String)value);
        return;
      case DESCESTADO:
        setDescestado((String)value);
        return;
      case DESCESTADOBULTO:
        setDescestadobulto((String)value);
        return;
      case DESCTIPMAC:
        setDesctipmac((String)value);
        return;
      case PESINI:
        setPesini((Number)value);
        return;
      case PESFIN:
        setPesfin((Number)value);
        return;
      case DIFPES:
        setDifpes((Number)value);
        return;
      case CANENTBULTO:
        setCanentbulto((Number)value);
        return;
      case PESO:
        setPeso((Number)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case INTEGRA:
        setIntegra((String)value);
        return;
      case IDUBI:
        setIdubi((String)value);
        return;
      case DESCUBI:
        setDescubi((String)value);
        return;
      case ESPECIAL:
        setEspecial((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
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
   *  Gets the attribute value for the calculated attribute Cancon
   */
  public Number getCancon()
  {
    return (Number)getAttributeInternal(CANCON);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Cancon
   */
  public void setCancon(Number value)
  {
      //No deixem que la quantitat confirmada sigui negativa
      if (value != null && value.compareTo(new Number(0)) >= 0 )
      {
      // Nomes deixem posar un quantitat confirmada inferior a la prevista si es
      // tracta d'una entrada amb document
      if (getSgaldoc().isHost() || getSgaldoc().isTrasllat())
        setAttributeInternal(CANCON, value);
      else
      {
        if (value != null && value.compareTo(getCantot()) >= 0)
          setAttributeInternal(CANCON, value);
        else
          throw new JboException(InterflexMessageBundle.class,
                                 InterflexMessageBundle.QUANTITAT_INCORRECTA,
                                 new Object[] {value, getCantot()});
      }
    }
    else
      throw new JboException(InterflexMessageBundle.class,
                             InterflexMessageBundle.QUANTITAT_NEGATIVA,
                             null);
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
      // Verifiquem que el mac no existeixi
      ViewObject vmac = getApplicationModule().findViewObject("SgamacExistentView1");
      vmac.setWhereClauseParam(0, value);
      vmac.executeQuery();
      // Xavi, 06/04/05: Comentat per que ara es poden afegir exist�ncies a un mac existent
      // desde la pantalla de contenidors sense reserva
      // Si el mac no existeix, el creem ...
//      if (vmac.hasNext())
//        throw new JboException(InterflexMessageBundle.class,
//                               InterflexMessageBundle.MAC_EXISTENT,
//                               new Object[] {value});
      if (!vmac.hasNext())
      {
        SgamacViewRowImpl mac = null;
        mac = (SgamacViewRowImpl)getSgamacView().createRow();
        mac.setIdmac(value);
        getSgamacView().insertRow(mac);
        LOG.debug("Creat mac " + value + " per introducci� de carga nova");
      }
      // Posem la quantitat pendent de confirmar igual a canpen
      setCancon(getCanpenbulto());
      // Xavi, 16/04/05: Simulem que s'esta fent la reserva per la totalitat de 
      // la quantitat pendent del bulto
      setCanresbulto(getCanresbulto().add(getCanpenbulto()));
      setCanpenbulto(new Number(0));
      
      setAttributeInternal(IDMAC, value);
  }
    
  /**
   * Inserta una nova linea de detall pel bulto
   */
  public Key crearLineaDetall(String idpuesto, String idart, Number cantot)
  {
    SgabultoViewRowImpl bulto = (SgabultoViewRowImpl)getSgabultoView1();
    return (bulto.getSgabulto().crearLineaDetall(idpuesto, idart, cantot));
  }


  public void introduirCargaNova(String idubi, String tipoCarga)
  {
    introduirCargaNova(idubi, tipoCarga, "N", null);
  }
  /**
   * Introdueix la carga nova al magatzem, posicionant-la a la ubicaci� d'entrada
   * corresponent
   */
  public void introduirCargaNova(String idubi, String tipoCarga, String bloqueo, String motivoBloqueo)
  {
    // Posem tota la informaci� a l'estructura que necessitem per crear l'hist�ric
    Sgamovexist movexist = new Sgamovexist();
    movexist.setCancon(getCancon());
    movexist.setCanres(new Number(0));
    movexist.setIdart(getIdart());
    movexist.setIdbulto(getIdbulto());
    movexist.setIdcabnum(getIdcabnum());
    movexist.setIdcabstr(getIdcabstr());
    movexist.setIddoc(getIddoc());
    movexist.setIdlin(getIdlin());
    movexist.setIdmac(getIdmac());
    movexist.setIdtipdoc(getSgaldoc().getSgacdoc().getIdtipdoc());
    movexist.setObserv(getObserv());
    movexist.setPesfin(getPesfin());
    movexist.setPesini(getPesini());
    movexist.setUbipos(idubi);
    movexist.setTipmov("E");
    movexist.setIntegra(getIntegra());
    movexist.setTalbaran(getSgaldoc().getSgacdoc().getTalbaran());
    movexist.setNalbaran(getSgaldoc().getSgacdoc().getNalbaran());
    
    movexist.setBloqueoExist(bloqueo);
    movexist.setMotivoBloqueo(motivoBloqueo);
    
    movexist.setExistenciaEspecial(getEspecial());
    
    

    RowIterator macs = getSgamacView();
    if (macs != null && macs.getRowCount() > 0)
    {
      SgamacViewRowImpl mac = (SgamacViewRowImpl)macs.first();
      // Si es un mac del miniload, posem el tipus de mac 'CUB'
      if (tipoCarga.equals("MLD"))
        mac.setIdtipmac("CUB");
      else
        if (tipoCarga.equals("MAN"))
          mac.setIdtipmac("PAK"); // TODO: Make sure ok for all entrada manual
        else
           // Michael 04.02.2014 ya lo tiene mac.setIdtipmac(tipoCarga);
           // Michael 31.01.2019 parece que no esta...
           {
             String smac = mac.getIdtipmac();
             if (mac.getIdtipmac() == null)
             {
               mac.setIdtipmac(getIdtipmac());
             }
            }
          
      mac.setUbipos(idubi);
      mac.setPosubipos(null);
      mac.setUbides(idubi);
      mac.setPosubides(null);
      
      mac.getSgamac().afegirMaterial(movexist);
      // Xavi, deixem el mac al puesto, excepte quan es una ubicaci� manual
      if (!tipoCarga.equals("MAN"))
        mac.getSgamac().setEnPuesto();
      else
        mac.getSgamac().setEnUbicacion();
      //mac.getSgamac().setPendienteEvacuacion();
      LOG.debug("Introduida carga nova al mac " + getIdmac() + 
        " amb article " + getIdart() + 
        " i quantitat " + getCancon());
        
      // Xavi: 16/04/05: Cridem el metode estandar per confirmar l'entrada 
      // Michael 27.12.2016 Trasllat de material!!
      getSgalbulto().confirmarEntrada(getCancon(), getCanresbulto());

    }
    
  }
  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgamacView
   */
  public oracle.jbo.RowIterator getSgamacView()
  {
    return (oracle.jbo.RowIterator)getAttributeInternal(SGAMACVIEW);
  }

  /**
   * 
   *  Gets the attribute value for IDART using the alias name Idart
   */
  public String getIdart()
  {
    return (String)getAttributeInternal(IDART);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDART using the alias name Idart
   */
  public void setIdart(String value)
  {
    setAttributeInternal(IDART, value);
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
   *  Gets Sgaldoc entity object.
   */
  public es.sysmap.interflex.model.bdc.SgaldocImpl getSgaldoc()
  {
    return (es.sysmap.interflex.model.bdc.SgaldocImpl)getEntity(1);
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
   *  Gets the attribute value for the calculated attribute Idcabstr
   */
  public String getIdcabstr()
  {
    return (String)getAttributeInternal(IDCABSTR);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idcabstr
   */
  public void setIdcabstr(String value)
  {
    setAttributeInternal(IDCABSTR, value);
  }



  /**
   * 
   *  Gets the associated <code>Row</code> using master-detail link SgabultoView1
   */
  public oracle.jbo.Row getSgabultoView1()
  {
    return (oracle.jbo.Row)getAttributeInternal(SGABULTOVIEW1);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Observ
   */
  public String getObserv()
  {
    return (String)getAttributeInternal(OBSERV);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Observ
   */
  public void setObserv(String value)
  {
    setAttributeInternal(OBSERV, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descestado
   */
  public String getDescestado()
  {
    return (String)getAttributeInternal(DESCESTADO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descestado
   */
  public void setDescestado(String value)
  {
    setAttributeInternal(DESCESTADO, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Descestadobulto
   */
  public String getDescestadobulto()
  {
    return (String)getAttributeInternal(DESCESTADOBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descestadobulto
   */
  public void setDescestadobulto(String value)
  {
    setAttributeInternal(DESCESTADOBULTO, value);
  }

  /**
   * 
   *  Gets the attribute value for UNIMAC using the alias name Unimac
   */
  public Number getUnimac()
  {
    return (Number)getAttributeInternal(UNIMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for UNIMAC using the alias name Unimac
   */
  public void setUnimac(Number value)
  {
    setAttributeInternal(UNIMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Idcabnum
   */
  public String getIdcabnum()
  {
    return (String)getAttributeInternal(IDCABNUM);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Idcabnum
   */
  public void setIdcabnum(String value)
  {
    setAttributeInternal(IDCABNUM, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Desctipmac
   */
  public String getDesctipmac()
  {
    return (String)getAttributeInternal(DESCTIPMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Desctipmac
   */
  public void setDesctipmac(String value)
  {
    setAttributeInternal(DESCTIPMAC, value);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Pesini
   */
  public Number getPesini()
  {
    return (Number)getAttributeInternal(PESINI);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Pesini
   */
  public void setPesini(Number value)
  {
    setAttributeInternal(PESINI, value);
    // Si l'article va per pes, intentem calcular les unitats
    quizasCalcularDifpes();
    
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Pesfin
   */
  public Number getPesfin()
  {
    return (Number)getAttributeInternal(PESFIN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Pesfin
   */
  public void setPesfin(Number value)
  {
    setAttributeInternal(PESFIN, value);
    // Si l'article va per pes, intentem calcular les unitats
    quizasCalcularDifpes();
    
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Difpes
   */
  public Number getDifpes()
  {
    return (Number)getAttributeInternal(DIFPES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Difpes
   */
  public void setDifpes(Number value)
  {
    setAttributeInternal(DIFPES, value);
  }
  
  /**
   * Si l'article es controla per pes, actualitzem difpes
   */
  public void quizasCalcularDifpes()
  {
    if (getPesini() != null && getPesfin() != null)
      setDifpes(getSgaldoc().getSgaarticulo().calcularDifpes(getPesfin().subtract(getPesini())));
  }


  
  /**
   * Retorna cert si s'ha de mostrar una advertencia per la diferencia de pes
   * en l'operaci�
   * @return 
   */
  public boolean verificarPes()
  {
    boolean verificar = false;
    // Cal controlar el pes?
    if (getSgaldoc().getSgaarticulo().controlarPes())
    {
      if (getDifpes() != null)
      {
        // TODO: Caldra aplicar un marge de tolerancia...
        if (!(getDifpes().compareTo(getCancon()) == 0))
          verificar = true;
      }
      else
        verificar = true;
    }
    return verificar;
  }

  /**
   * 
   *  Gets the attribute value for CANENT using the alias name Canentbulto
   */
  public Number getCanentbulto()
  {
    return (Number)getAttributeInternal(CANENTBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for CANENT using the alias name Canentbulto
   */
  public void setCanentbulto(Number value)
  {
    setAttributeInternal(CANENTBULTO, value);
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
   *  Gets the associated <code>Row</code> using master-detail link SgacdocEntradesView
   */
  public oracle.jbo.Row getSgacdocEntradesView()
  {
    return (oracle.jbo.Row)getAttributeInternal(SGACDOCENTRADESVIEW);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Integra
   */
  public String getIntegra()
  {
    return (String)getAttributeInternal(INTEGRA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Integra
   */
  public void setIntegra(String value)
  {
    setAttributeInternal(INTEGRA, value);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for DESCRIP using the alias name Descrip
   */
  public void setDescrip(String value)
  {
    setAttributeInternal(DESCRIP, value);
  }





  /**
   * 
   *  Gets the attribute value for MODIFIEDBY using the alias name Modifiedby
   */
  public String getModifiedby()
  {
    return (String)getAttributeInternal(MODIFIEDBY);
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
   *  Gets the attribute value for the calculated attribute Descubi
   */
  public String getDescubi()
  {
    return (String)getAttributeInternal(DESCUBI);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Descubi
   */
  public void setDescubi(String value)
  {
    setAttributeInternal(DESCUBI, value);
  }
  
  //Xavi, 18/10/05: Si el contenidor esta buit, mirem d'assignar-li directament
  //un pes inicial

  public void quizasEstablirPesini()
  {
    SgamacViewRowImpl mac = (SgamacViewRowImpl)this.getSgamacView().first();
    if (mac != null && !mac.hasExistencies())
    {
      if (mac.getTara() != null)
      {
        setPesini(mac.getTara());
      }
      else
      {
        if (mac.getSgamac().getSgatipomac() != null && mac.getSgamac().getSgatipomac().getTara() != null)
        {
            setPesini(mac.getSgamac().getSgatipomac().getTara());
        }
        else
          // El pes per defecte d'una cubeta
          setPesini(new Number(4));
      }
    }
  }  

  /**
   * 
   *  Gets the attribute value for the calculated attribute Especial
   */
  public String getEspecial()
  {
    return (String)getAttributeInternal(ESPECIAL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Especial
   */
  public void setEspecial(String value)
  {
    setAttributeInternal(ESPECIAL, value);
  }







}