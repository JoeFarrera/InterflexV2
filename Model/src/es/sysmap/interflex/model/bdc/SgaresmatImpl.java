package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import es.sysmap.interflex.model.bdc.common.FlexiDate;
import oracle.jbo.RowIterator;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaresmatImpl extends EntityImpl 
{
  public static final int IDDOC = 0;
  public static final int IDLIN = 1;
  public static final int IDMAC = 2;
  public static final int CANRES = 3;
  public static final int IDBULTO = 4;
  public static final int CREATEDBY = 5;
  public static final int MODIFIEDBY = 6;
  public static final int CREATEDON = 7;
  public static final int MODIFIEDON = 8;
  public static final int IDART = 9;
  public static final int IDARTIF = 10;
  public static final int DESCRIP = 11;
  public static final int IDBULTOPK = 12;
  public static final int TRASLLAT = 13;
  public static final int SGALBULTO = 14;
  public static final int SGAEXISTENCIA = 15;
  public static final int SGALDOC = 16;
  public static final int SGAMAC1 = 17;
  public static final int SGAEXISTENCIA1 = 18;
  public static final int SGAMAC = 19;



















































































  private static SgaresmatDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaresmatImpl()
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
      mDefinitionObject = (SgaresmatDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgaresmat");
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
   *  Copiar valor sobre idbultopk, que forma parte de la PK
   */
  public void setIdbulto(Number value)
  {
    setAttributeInternal(IDBULTO, value);
    if (value != null)
      setIdbultopk(value);
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
      case IDLIN:
        return getIdlin();
      case IDMAC:
        return getIdmac();
      case CANRES:
        return getCanres();
      case IDBULTO:
        return getIdbulto();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case IDART:
        return getIdart();
      case IDARTIF:
        return getIdartif();
      case DESCRIP:
        return getDescrip();
      case IDBULTOPK:
        return getIdbultopk();
      case TRASLLAT:
        return getTrasllat();
      case SGAMAC:
        return getSgamac();
      case SGALBULTO:
        return getSgalbulto();
      case SGAEXISTENCIA:
        return getSgaexistencia();
      case SGALDOC:
        return getSgaldoc();
      case SGAMAC1:
        return getSgamac1();
      case SGAEXISTENCIA1:
        return getSgaexistencia1();
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
      case IDLIN:
        setIdlin((Number)value);
        return;
      case IDMAC:
        setIdmac((String)value);
        return;
      case CANRES:
        setCanres((Number)value);
        return;
      case IDBULTO:
        setIdbulto((Number)value);
        return;
      case IDART:
        setIdart((String)value);
        return;
      case IDARTIF:
        setIdartif((String)value);
        return;
      case DESCRIP:
        setDescrip((String)value);
        return;
      case IDBULTOPK:
        setIdbultopk((Number)value);
        return;
      case TRASLLAT:
        setTrasllat((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }



  /**
   * 
   *  Gets the associated entity SgalbultoImpl
   */
  public SgalbultoImpl getSgalbulto()
  {
    return (SgalbultoImpl)getAttributeInternal(SGALBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgalbultoImpl
   */
  public void setSgalbulto(SgalbultoImpl value)
  {
    setAttributeInternal(SGALBULTO, value);
  }

  /**
   * 
   *  Gets the associated entity SgaexistenciaImpl
   */
  public SgaexistenciaImpl getSgaexistencia()
  {
    return (SgaexistenciaImpl)getAttributeInternal(SGAEXISTENCIA);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgaexistenciaImpl
   */
  public void setSgaexistencia(SgaexistenciaImpl value)
  {
    setAttributeInternal(SGAEXISTENCIA, value);
  }

  /**
   * 
   *  Gets the associated entity SgaldocImpl
   */
  public SgaldocImpl getSgaldoc()
  {
    return (SgaldocImpl)getAttributeInternal(SGALDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgaldocImpl
   */
  public void setSgaldoc(SgaldocImpl value)
  {
    setAttributeInternal(SGALDOC, value);
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
   *  Gets the associated entity SgamacImpl
   */
  public SgamacImpl getSgamac()
  {
    return (SgamacImpl)getAttributeInternal(SGAMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgamacImpl
   */
  public void setSgamac(SgamacImpl value)
  {
    setAttributeInternal(SGAMAC, value);
  }


  /**
   * Confirma l'entrada corresponent a la reserva per la quantitat cantot
   * @param cancon Quantitat confirmada
   */
  private void confirmarEntrada(Sgamovexist movexist)
  {
    // Actualitzem l'existencia
    getSgamac().afegirMaterial(movexist);
    
    // Actualitzem lbulto
    SgalbultoImpl lbulto = getSgalbulto();
    lbulto.confirmarEntrada(movexist.getCancon(), movexist.getCanres());
    
    // Eliminem la reserva    
    remove();
    
  }

  /**
   * Anula l'entrada corresponent a la reserva
   * :TODO Michael 06.04.2005 Porqu� no va directamente a la existencia por getSgaexistencia() ??
   */
  private void anularEntrada(boolean bAnularPendent)
  {
    
    // Actualitzem lbulto
    SgalbultoImpl lbulto = getSgalbulto();
    // Michael 20.12.2016 The resmat may reference the "salida"
    if (lbulto != null)
    {
      // Actualitzem l'existencia
      getSgamac().anularAfegirMaterial(getIdart(), getCanres());
      lbulto.anularEntrada(getCanres(), bAnularPendent);
    
      // Eliminem la reserva    
      remove();
    }
  }
  
  /**
   * Anular el trasllat de material
   * Un traslllat t� el document (CDoc-LDoc-Bulto-LBulto) i tamb� la reserva del mac original..
   */
   public void anularTrasllat()
   {
     anularSortida();
   }
  
  
  /**
   * Confirmem la sortida de material per un trasllat
   * Un traslllat t� el document (CDoc-LDoc-Bulto-LBulto) i tamb� la reserva del mac original..
   */
  public void confirmarTrasllat(Sgamovexist movexist)
  {
    movexist.setIdmac(getIdmac());
    getSgamac().treureMaterial(movexist);
    
    
    SgaldocImpl ldoc = getSgaldoc();
    ldoc.confirmarSortida(movexist.getCancon(), getCanres());

    remove();
  }

  /**
   * Confirma la sortida corresponent a la reserva per la quantitat cantot
   * @param cantot
   */
  private void confirmarSortida(Sgamovexist movexist)
  {
    // Actualitzem l'existencia
    getSgamac().treureMaterial(movexist);
    
    // Actualitzem ldoc
    SgaldocImpl ldoc = getSgaldoc();
    ldoc.confirmarSortida(movexist.getCancon(), getCanres());
    
    // Eliminem la reserva    
    remove();
    
  }

  /**
   * Anula la sortida corresponent a la reserva
   */
  private void anularSortida()
  {
    // Actualitzem l'existencia
    getSgamac().anularTreureMaterial(getIdart(), getCanres());
    
    // Actualitzem ldoc
    SgaldocImpl ldoc = getSgaldoc();
    ldoc.anularSortida(getCanres());
    
    // Eliminem la reserva    
    remove();
    
  }

  /**
   * Anula el moviment corresponent a la reserva
   */
  public void confirmarReserva(Sgamovexist movexist)
  {
    if (esEntrada())
    {
      movexist.setTipmov("E");
      confirmarEntrada(movexist);
    }
    else
    {
      movexist.setTipmov("S");
      confirmarSortida(movexist);  
    }
  }


  private boolean isTrasllat()
  {

    return getSgaldoc().isTrasllat();
  }
  
  public boolean isResmatTrasllat()
  {
    if (getTrasllat() != null && getTrasllat().equals("S"))
      return true;
      
    return (false);
  }
  
  /**
   * Anula el moviment corresponent a la reserva
   */
  public void anularReserva(boolean bAnularPendent)
  {
    if (esEntrada())
    {
      anularEntrada(bAnularPendent);
      if (isTrasllat())
      {
        anularSortida();
      }
    }
    else
      anularSortida(); 
      
    
  }





  /**
   * 
   *  Gets the associated entity SgamacImpl
   */
  public SgamacImpl getSgamac1()
  {
    return (SgamacImpl)getAttributeInternal(SGAMAC1);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgamacImpl
   */
  public void setSgamac1(SgamacImpl value)
  {
    setAttributeInternal(SGAMAC1, value);
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
   *  Gets the attribute value for Idbultopk, using the alias name Idbultopk
   */
  public Number getIdbultopk()
  {
    return (Number)getAttributeInternal(IDBULTOPK);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idbultopk
   */
  public void setIdbultopk(Number value)
  {
    setAttributeInternal(IDBULTOPK, value);
  }


  public void setBultoSalida(String tipoCarga, Number idbulto)
  {
    if (tipoCarga.equals("SLO"))
      getSgaldoc().getSgacdoc().setBultoslo(idbulto);
    else if (tipoCarga.equals("MLD"))
      getSgaldoc().getSgacdoc().setBultomld(idbulto);
    else if (tipoCarga.equals("MAN"))
      getSgaldoc().getSgacdoc().setBultoman(idbulto);

  }

  public Number getPesTeoric(Number cancon)
  {
    // Michael 17.01.2007 a veces es null??
    if (getSgaexistencia() == null)
        return (new Number (0));
    else
      return getSgaexistencia().getPesTeoric(cancon);
  }
  
  private boolean esEntrada()
  {
    return (getSgaldoc().getSgacdoc().getSgatipdoc().getTipmov().equals("E"));
  }

 
  /**
   * 
   *  Gets the associated entity SgaexistenciaImpl
   */
  public SgaexistenciaImpl getSgaexistencia1()
  {
    return (SgaexistenciaImpl)getAttributeInternal(SGAEXISTENCIA1);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgaexistenciaImpl
   */
  public void setSgaexistencia1(SgaexistenciaImpl value)
  {
    setAttributeInternal(SGAEXISTENCIA1, value);
  }


  /**
   * 
   *  Gets the attribute value for Trasllat, using the alias name Trasllat
   */
  public String getTrasllat()
  {
    return (String)getAttributeInternal(TRASLLAT);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Trasllat
   */
  public void setTrasllat(String value)
  {
    setAttributeInternal(TRASLLAT, value);
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(Number iddoc, Number idlin, String idmac, String idart, Number idbultopk)
  {
    return new Key(new Object[] {iddoc, idlin, idmac, idart, idbultopk});
  }









































































}