package es.sysmap.interflex.model.bdc;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.ViewObject;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
import oracle.jbo.AttributeList;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaldocImpl extends EntityImpl 
{
  public static final int IDLIN = 0;
  public static final int CANPEN = 1;
  public static final int ESTADO = 2;
  public static final int MOTIVO = 3;
  public static final int CANTOT = 4;
  public static final int IDDOC = 5;
  public static final int PESO = 6;
  public static final int CANRES = 7;
  public static final int IDART = 8;
  public static final int FECCRE = 9;
  public static final int IDPUESTO = 10;
  public static final int CREATEDBY = 11;
  public static final int MODIFIEDBY = 12;
  public static final int CREATEDON = 13;
  public static final int MODIFIEDON = 14;
  public static final int IDARTIF = 15;
  public static final int DESCRIP = 16;
  public static final int CANDIS = 17;
  public static final int FECASIG = 18;
  public static final int ASIGMLD = 19;
  public static final int ASIGSLO = 20;
  public static final int SINFORMATO = 21;
  public static final int SGAARTICULO = 22;
  public static final int SGACDOC = 23;
  public static final int SGAPUESTOMANIP = 24;
  public static final int SGALBULTO = 25;
  public static final int SGARESMAT = 26;
  public static final int SGAEXPEDLBULTO = 27;













































































































  private static SgaldocDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaldocImpl()
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
      mDefinitionObject = (SgaldocDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgaldoc");
    }
    return mDefinitionObject;
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
   *  Gets the attribute value for Canpen, using the alias name Canpen
   */
  public Number getCanpen()
  {
    return (Number)getAttributeInternal(CANPEN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Canpen
   */
  public void setCanpen(Number value)
  {
    setAttributeInternal(CANPEN, value);
    Number zero = new Number(0);
    
    if (value.compareTo(zero) <= 0 && getCanres().equals(zero))
      setEstado("F");
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
   *  Gets the attribute value for Peso, using the alias name Peso
   */
  public Number getPeso()
  {
    return (Number)getAttributeInternal(PESO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Peso
   */
  public void setPeso(Number value)
  {
    setAttributeInternal(PESO, value);
  }

  /**
   * 
   *  Gets the attribute value for Canres, using the alias name Canres
   */
  public Number getCanres()
  {
    return (Number)getAttributeInternal(CANRES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Canres
   */
  public void setCanres(Number value)
  {
    setAttributeInternal(CANRES, value);
    Number zero = new Number(0);
    
    if (value.equals(zero) && getCanpen().compareTo(zero) <= 0)
      setEstado("F");
    
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
   *  Gets the attribute value for Feccre, using the alias name Feccre
   */
  public FlexiDate getFeccre()
  {
    return (FlexiDate)getAttributeInternal(FECCRE);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Feccre
   */
  public void setFeccre(FlexiDate value)
  {
    setAttributeInternal(FECCRE, value);
  }





  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDLIN:
        return getIdlin();
      case CANPEN:
        return getCanpen();
      case ESTADO:
        return getEstado();
      case MOTIVO:
        return getMotivo();
      case CANTOT:
        return getCantot();
      case IDDOC:
        return getIddoc();
      case PESO:
        return getPeso();
      case CANRES:
        return getCanres();
      case IDART:
        return getIdart();
      case FECCRE:
        return getFeccre();
      case IDPUESTO:
        return getIdpuesto();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case IDARTIF:
        return getIdartif();
      case DESCRIP:
        return getDescrip();
      case CANDIS:
        return getCandis();
      case FECASIG:
        return getFecasig();
      case ASIGMLD:
        return getAsigmld();
      case ASIGSLO:
        return getAsigslo();
      case SINFORMATO:
        return getSinformato();
      case SGALBULTO:
        return getSgalbulto();
      case SGARESMAT:
        return getSgaresmat();
      case SGAEXPEDLBULTO:
        return getSgaexpedlbulto();
      case SGAARTICULO:
        return getSgaarticulo();
      case SGACDOC:
        return getSgacdoc();
      case SGAPUESTOMANIP:
        return getSgapuestomanip();
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
      case IDLIN:
        setIdlin((Number)value);
        return;
      case CANPEN:
        setCanpen((Number)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case MOTIVO:
        setMotivo((String)value);
        return;
      case CANTOT:
        setCantot((Number)value);
        return;
      case IDDOC:
        setIddoc((Number)value);
        return;
      case PESO:
        setPeso((Number)value);
        return;
      case CANRES:
        setCanres((Number)value);
        return;
      case IDART:
        setIdart((String)value);
        return;
      case FECCRE:
        setFeccre((FlexiDate)value);
        return;
      case IDPUESTO:
        setIdpuesto((String)value);
        return;
      case IDARTIF:
        setIdartif((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      case CANDIS:
        setCandis((Number)value);
        return;
      case FECASIG:
        setFecasig((FlexiDate)value);
        return;
      case ASIGMLD:
        setAsigmld((String)value);
        return;
      case ASIGSLO:
        setAsigslo((String)value);
        return;
      case SINFORMATO:
        setSinformato((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }



  /**
   * 
   *  Gets the associated entity SgaarticuloImpl
   */
  public SgaarticuloImpl getSgaarticulo()
  {
    return (SgaarticuloImpl)getAttributeInternal(SGAARTICULO);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgaarticuloImpl
   */
  public void setSgaarticulo(SgaarticuloImpl value)
  {
    setAttributeInternal(SGAARTICULO, value);
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
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgalbulto()
  {
    return (RowIterator)getAttributeInternal(SGALBULTO);
  }


  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgaresmat()
  {
    return (RowIterator)getAttributeInternal(SGARESMAT);
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
   *  Gets the attribute value for Idartif, using the alias name Idartif
   */
  public String getIdartif()
  {
    return (String)getAttributeInternal(IDARTIF);
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
   *  Gets the attribute value for Idpuesto, using the alias name Idpuesto
   */
  public String getIdpuesto()
  {
    return (String)getAttributeInternal(IDPUESTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idpuesto
   *  Michael 12.04.2005 Si se asigna a un puesto, actualiza el fecasig
   */
  public void setIdpuesto(String value)
  {
    setAttributeInternal(IDPUESTO, value);
    if (value != null)
      setFecasig(FlexiDate.currentDate());
    
  }


  /**
   * 
   *  Gets the associated entity SgapuestomanipImpl
   */
  public SgapuestomanipImpl getSgapuestomanip()
  {
    return (SgapuestomanipImpl)getAttributeInternal(SGAPUESTOMANIP);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgapuestomanipImpl
   */
  public void setSgapuestomanip(SgapuestomanipImpl value)
  {
    setAttributeInternal(SGAPUESTOMANIP, value);
  }



  /**
   * 
   *  Gets the attribute value for Estado, using the alias name Estado
   */
  public String getEstado()
  {
    return (String)getAttributeInternal(ESTADO);
  }
  
  public void setSequenciaExped()
  {
    getSgacdoc().setSequenciaExped();
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Estado
   */
  public void setEstado(String value)
  {
    if (getEstado() == null)
      setAttributeInternal(ESTADO, value);
    else
    {
      // Si ja esta anulada o finalitzada, no deixem actualitzar l'estat
      if (!(getEstado().equals(SgacdocImpl.ANULADA) 
          || getEstado().equals(SgacdocImpl.FINALIZADA)))
        {
          setAttributeInternal(ESTADO, value);
          SgacdocImpl cdoc = getSgacdoc();
          // Michael 02.10.2009
          // Si se abre una l�nea, mira a ver si hay s inicializar el numero de exped. para Ochoa
          // Michael 20.12.2017 Could be a line assigned before the document is opened
          if (value.equals(SgacdocImpl.EN_PROCESO) || value.equals(SgacdocImpl.NUEVA) || value.equals(SgacdocImpl.SUSPENDIDA))
          {
            // No comprobamos que sea una salida???
            // TODO - not doing this when assigned directly...           
            cdoc.setSequenciaExped();
          }
          
          if (value.equals("F") || value.equals("A"))
          {
            // Mirem si la resta de linies estan acabades
            RowIterator ldocs = cdoc.getSgaldoc();
            ldocs.reset();
            boolean bFinalitzarOrdre = true;
            while (ldocs.hasNext() && bFinalitzarOrdre)
            {
              SgaldocImpl ldoc = (SgaldocImpl)ldocs.next();
              bFinalitzarOrdre = (ldoc.getEstado().equals(SgacdocImpl.ANULADA) 
// Michael 19.05.2010                          || ldoc.getEstado().equals(SgacdocImpl.FINALIZADA));
                                || ldoc.getEstado().equals(SgacdocImpl.FINALIZADA)
                                || ldoc.getEstado().equals(SgacdocImpl.COMUNICADA));
            }
            if (bFinalitzarOrdre)
            {
              cdoc.setEstado(SgacdocImpl.FINALIZADA);
              // Xavi, 11/05/05: Afegim a la cap�alera el puesto desde el qual
              // s'ha tancat el document
              cdoc.setIdpuestofin(getIdpuesto());
            }
  
            // Si finalitzem la linia, treiem l'assignaci� del puesto
            if (value.equals("F"))
            {
              this.setIdpuesto(null);
              // Michael 28.12.2016 Si es un trasllat, moure la font del trasllat aqu�.
                if (isTrasllat())
                {
              
                  // TODO add the movement to the historico de movimientos and delete resmat, existencia, mac ... ldoc.confirmarSortida();
                }
            }

          }
      }
    }

    // Si hem anulat la l�nia, anulem les reserves que hi hagin pendents
    if (value.equals("A"))
      anularReserves();
      
  }


  /**
   * 
   *  Add attribute defaulting logic in this method.
   */
  protected void create(AttributeList attributeList)
  {
    super.create(attributeList);
    
    if (getIdlin() == null)
    {
      //Calculem el seguent numero de linia, segons el total de linies del document
      Number i = new Number(0);
      if (getSgacdoc() != null)
      {
        RowIterator linies = getSgacdoc().getSgaldoc();
        SgaldocImpl linia = (SgaldocImpl)linies.first();
        for (;linia != null;)
        {
          if(i.compareTo(linia.getIdlin()) < 0)
            i = linia.getIdlin();
            linia = (SgaldocImpl)linies.next ();
        }
      }
      setIdlin(i.add(1));
        
    }  
    
    setAttributeInternal("Estado", "N");
  }




  public void confirmarSortida(Number cancon, Number canres)
  {
    // La cantidad pendiente s�lo se actualiza si ha habido una diferencia en lo que sacan
    // sobre lo que piden sacar
    Number difResCon = canres.subtract(cancon);
    if (!difResCon.equals(new Number (0)))
      setCanpen(getCanpen().add(difResCon));
    setCanres(getCanres().subtract(canres));
  }
 

  public void anularSortida(Number canres)
  {
    setCanpen(getCanpen().add(canres));
    setCanres(getCanres().subtract(canres));
  }
 
   /**
   * Reservar una cantidad para la salida de material
   * Se crea la reserva correspondiente en resmat
   * @param canres  La cantidad a reservar
   * @param idmac El mac donde realizar la reserva
   * @see SgamacImpl#reservarSalidaMaterial
   */
  public void reservarSalida(String idmac, Number canres, Number idBulto, String trasllat)
  {
    setCanres(getCanres().add(canres));
    setCanpen(getCanpen().subtract(canres));
    SgaresmatDefImpl resmat = (SgaresmatDefImpl)SgaresmatImpl.getDefinitionObject();
    resmat.crearResmat(getDBTransaction(), idmac, getIdart(), getIddoc(), getIdlin(), idBulto, canres, trasllat);
  }
  
  public void reservarSalida(String idmac, Number canres, Number idBulto)
  {
    reservarSalida (idmac, canres, idBulto, null);
  }
  


  
  public void anularReserves()
  {
    RowIterator reserves = getSgaresmat();
    reserves.reset();
    while (reserves.hasNext())
    {
      SgaresmatImpl resmat = (SgaresmatImpl)reserves.next();
      //No s'anul.la el pendent
      resmat.anularReserva(false);
    }
    
    // Michael 20.12.2016 
    // Needs to remove the bulto and lbulto if this is a "trasllat"
    if (isTrasllat())
    {
    RowIterator lbulto = getSgalbulto();
    lbulto.reset();
    
    while (lbulto.hasNext())
    {
      SgalbultoImpl lbultoRow = (SgalbultoImpl)lbulto.next();
      lbultoRow.remove();
    }
    }
 
    
    
  }
  
   public void confirmarTrasllat()
  {
    Sgamovexist movexist = new Sgamovexist();
    movexist.setTipmov(SgatipdocImpl.TIPDOCSALIDA); // TODO: Should be 'T' de trasllat?
    movexist.setCancon(getCantot());
    movexist.setCanres(getCanres());
    movexist.setIdart(getIdart());
    movexist.setIdbulto(null);
    movexist.setIdcabnum(getIdcabnum());
    movexist.setIdcabstr(null);
    movexist.setIddoc(getIddoc());
    movexist.setIdlin(getIdlin());
    movexist.setIdmac(null);
    movexist.setIdtipdoc(getSgacdoc().getIdtipdoc());
    movexist.setObserv(null);
    movexist.setPesfin(null);
    movexist.setPesini(null);
    movexist.setUbipos(null);
    movexist.setIntegra(null);
    movexist.setTalbaran(null);
    movexist.setNalbaran(null);
    
    RowIterator reserves = getSgaresmat();
    reserves.reset();
    
    while (reserves.hasNext())
    {
      SgaresmatImpl resmat = (SgaresmatImpl)reserves.next();
      if (resmat.isResmatTrasllat())
        resmat.confirmarTrasllat(movexist);
    }
    
  }
  
    public boolean isTrasllat()
  {
    return getSgacdoc().isTrasllat();
  }
  
  public boolean isHost()
  {
    return getSgacdoc().isHost();
  }




  /**
   * 
   *  Gets the attribute value for Candis, using the alias name Candis
   */
  public Number getCandis()
  {
    return (Number)getAttributeInternal(CANDIS);
  }




  /**
   * Retorna cert si s'ha insertat la linia, fals en cas contrari
   * @return 
   * @param detalle
   */
  public boolean insertarDetalle(Number iddoc, ResultSet detalle) 
  {
    boolean insertat = true;
    try
    {
      String idart = idartifToIdart(detalle.getString("det_referencia").trim());
      if (idart != null)
      {
        setIdlin(new Number(detalle.getBigDecimal("det_id")));
        setIddoc(iddoc);
        setIdart(idart);
        setCantot(new Number(detalle.getBigDecimal("det_unidades")));
        setCanpen(new Number(detalle.getBigDecimal("det_unidades")));
        setCanres(new Number(0));
        setEstado("N");
        setFeccre(FlexiDate.currentDate());
      }
      else 
        insertat = false;
      
    }
    catch(SQLException ex)
    {
      System.out.println("LDOC Error inesperat: " + ex);
      insertat = false;
    }
    return insertat;
  }


  private String idartifToIdart(String idartif)
  {
    String idart = null;
    ViewObject vo = getArticuloExistView();
    if (vo != null)
    {
      vo.setWhereClauseParam(0, idartif);
      vo.setForwardOnly(true);
      vo.executeQuery();
      if (vo.first() != null)
        idart =  (String)vo.first().getAttribute("Idart");
    }
    return idart;
  }


  private ViewObject getArticuloExistView()
  {
    ApplicationModule root = this.getDBTransaction().getRootApplicationModule();
    return(root.findViewObject("SgaarticuloExistView1"));
  }

  /**
   * 
   *  Gets the attribute value for Fecasig, using the alias name Fecasig
   */
  public FlexiDate getFecasig()
  {
    return (FlexiDate)getAttributeInternal(FECASIG);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Fecasig
   */
  public void setFecasig(FlexiDate value)
  {
    setAttributeInternal(FECASIG, value);
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
   *  Sets <code>value</code> as the attribute value for Descrip
   */
  public void setDescrip(String value)
  {
    setAttributeInternal(DESCRIP, value);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Candis
   */
  public void setCandis(Number value)
  {
    setAttributeInternal(CANDIS, value);
  }








  /**
   * 
   *  Gets the attribute value for Asigmld, using the alias name Asigmld
   */
  public String getAsigmld()
  {
    return (String)getAttributeInternal(ASIGMLD);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Asigmld
   */
  public void setAsigmld(String value)
  {
    setAttributeInternal(ASIGMLD, value);
  }

  /**
   * 
   *  Gets the attribute value for Asigslo, using the alias name Asigslo
   */
  public String getAsigslo()
  {
    return (String)getAttributeInternal(ASIGSLO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Asigslo
   */
  public void setAsigslo(String value)
  {
    setAttributeInternal(ASIGSLO, value);
  }


  /**
   * 
   *  Gets the attribute value for Sinformato, using the alias name Sinformato
   */
  public String getSinformato()
  {
    return (String)getAttributeInternal(SINFORMATO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Sinformato
   */
  public void setSinformato(String value)
  {
    setAttributeInternal(SINFORMATO, value);
  }


  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgaexpedlbulto()
  {
    return (RowIterator)getAttributeInternal(SGAEXPEDLBULTO);
  }



  public String getIdcabnum() 
  {
    return getSgacdoc().getIdcabnum();
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Number idlin, Number iddoc)
  {
    return new Key(new Object[] {idlin, iddoc});
  }
  

  



























}