package es.sysmap.interflex.model.bdc;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import oracle.jbo.JboContext;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.SequenceImpl;
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

public class SgacdocImpl extends EntityImpl 
{
  public static final int IDDOC = 0;
  public static final int IDCABSTR = 1;
  public static final int IDCABNUM = 2;
  public static final int NUMLINEAS = 3;
  public static final int NUMBULTOS = 4;
  public static final int ESTADO = 5;
  public static final int OPERARIO = 6;
  public static final int PESTOTAL = 7;
  public static final int MOTIVO = 8;
  public static final int NOMBRE = 9;
  public static final int DIRECCION = 10;
  public static final int CODPOSTAL = 11;
  public static final int POBLACION = 12;
  public static final int PROVINCIA = 13;
  public static final int TELEFONO = 14;
  public static final int PORTES = 15;
  public static final int FALBARAN = 16;
  public static final int SPEDIDO = 17;
  public static final int PAIS = 18;
  public static final int TRANSPORTE = 19;
  public static final int REEMBOLSO = 20;
  public static final int TALBARAN = 21;
  public static final int NALBARAN = 22;
  public static final int CODEMPRESA = 23;
  public static final int TRANSP = 24;
  public static final int TPORTES = 25;
  public static final int CCLIENTE = 26;
  public static final int FECCRE = 27;
  public static final int IDULTBULTO = 28;
  public static final int IDTIPDOC = 29;
  public static final int CREATEDBY = 30;
  public static final int MODIFIEDBY = 31;
  public static final int CREATEDON = 32;
  public static final int MODIFIEDON = 33;
  public static final int PRIORIDAD = 34;
  public static final int ESTADOLINEAS = 35;
  public static final int BULTOSLO = 36;
  public static final int BULTOMLD = 37;
  public static final int IMPRIMIR = 38;
  public static final int ESTCOM = 39;
  public static final int FPEDIDO = 40;
  public static final int IDPUESTOFIN = 41;
  public static final int BULTOMAN = 42;
  public static final int TIPDOCSGA = 43;
  public static final int SGATIPDOC = 44;
  public static final int SGALDOC = 45;
  public static final int SGAEDOC = 46;
  public static final int SGABULTO = 47;
  public static final int SGABULTOSLO = 48;
  public static final int SGABULTOMLD = 49;
  public static final int SGAETIQUETA = 50;
  public static final int SGABULTOMAN = 51;




























  public static final String NUEVA = "N";
  public static final String DISPONIBLE = "D";
  public static final String EN_PROCESO = "P";
  public static final String SUSPENDIDA = "S";
  public static final String ANULADA = "A";
  public static final String FINALIZADA = "F";
  public static final String COMUNICADA = "C";
  public static final String COMUNICADA_CON_ERROR = "Z";

  
  












































































  private static SgacdocDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgacdocImpl()
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
      mDefinitionObject = (SgacdocDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgacdoc");
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
   *  Gets the attribute value for Numlineas, using the alias name Numlineas
   */
  public Number getNumlineas()
  {
    return (Number)getAttributeInternal(NUMLINEAS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Numlineas
   */
  public void setNumlineas(Number value)
  {
    setAttributeInternal(NUMLINEAS, value);
  }

  /**
   * 
   *  Gets the attribute value for Numbultos, using the alias name Numbultos
   */
  public Number getNumbultos()
  {
    return (Number)getAttributeInternal(NUMBULTOS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Numbultos
   */
  public void setNumbultos(Number value)
  {
    setAttributeInternal(NUMBULTOS, value);
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
    // Si hem anulat l'ordre, anulem les reserves que hi hagin pendents
    if (value.equals("A") || value.equals("F"))
    {
      if(value.equals("A"))   
        anularReserves();

      // Michael 25.11.2010 this sets the bulto to print if necessary
      setBultomld(null);
      setBultoslo(null);
      setBultoman(null);
      
      if (getSgatipdoc().getTipmov().equals("E"))
      {
        // Activem directament el flag per comunicar al host, si es una entrada
        // Si es una sortida, haurem d'esperar a que s'imprimeixi el Packing List
        
        // Michael 19.12.2016 si no va al host..
        if (isHost())
        {
          setEstcom("H");
        }
        // TODO - si no lo es??
        
        // En cas d'anul�laci�, Anul�lem els possibles lbultos que hi hagi en proc�s
        RowIterator bultos = getSgabulto();
        bultos.reset();
        //Xavi, 15/06/2005: Modificat els bucles per que enlloc de hasnext utilitzin != null
        SgabultoImpl bulto = (SgabultoImpl)bultos.first();
      
        while (bulto != null)
        {
          RowIterator lbultos = bulto.getSgalbulto();
          lbultos.reset();
          SgalbultoImpl lbulto = (SgalbultoImpl)lbultos.first();
          while (lbulto != null)
          {
            if (lbulto.getEstado().equals("P") || lbulto.getEstado().equals("N"))
              lbulto.setEstado("A");
            lbulto = (SgalbultoImpl)lbultos.next();
          }
          bulto = (SgabultoImpl)bultos.next();
        }
        //Xavi, fi modificat el 15/06/05
      }
    }
      
    // Si es finalitza l'ordre, tanquem els possibles bultos de sortida que encara
    // estiguin oberts, i marquem l'ordre per imprimir el packing list
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
   *  Gets the attribute value for Pestotal, using the alias name Pestotal
   */
  public Number getPestotal()
  {
    return (Number)getAttributeInternal(PESTOTAL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Pestotal
   */
  public void setPestotal(Number value)
  {
    setAttributeInternal(PESTOTAL, value);
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
   *  Gets the attribute value for Nombre, using the alias name Nombre
   */
  public String getNombre()
  {
    return (String)getAttributeInternal(NOMBRE);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Nombre
   */
  public void setNombre(String value)
  {
    setAttributeInternal(NOMBRE, value);
  }

  /**
   * 
   *  Gets the attribute value for Direccion, using the alias name Direccion
   */
  public String getDireccion()
  {
    return (String)getAttributeInternal(DIRECCION);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Direccion
   */
  public void setDireccion(String value)
  {
    setAttributeInternal(DIRECCION, value);
  }

  /**
   * 
   *  Gets the attribute value for Codpostal, using the alias name Codpostal
   */
  public String getCodpostal()
  {
    return (String)getAttributeInternal(CODPOSTAL);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Codpostal
   */
  public void setCodpostal(String value)
  {
    setAttributeInternal(CODPOSTAL, value);
  }

  /**
   * 
   *  Gets the attribute value for Poblacion, using the alias name Poblacion
   */
  public String getPoblacion()
  {
    return (String)getAttributeInternal(POBLACION);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Poblacion
   */
  public void setPoblacion(String value)
  {
    setAttributeInternal(POBLACION, value);
  }

  /**
   * 
   *  Gets the attribute value for Provincia, using the alias name Provincia
   */
  public String getProvincia()
  {
    return (String)getAttributeInternal(PROVINCIA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Provincia
   */
  public void setProvincia(String value)
  {
    setAttributeInternal(PROVINCIA, value);
  }

  /**
   * 
   *  Gets the attribute value for Telefono, using the alias name Telefono
   */
  public String getTelefono()
  {
    return (String)getAttributeInternal(TELEFONO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Telefono
   */
  public void setTelefono(String value)
  {
    setAttributeInternal(TELEFONO, value);
  }

  /**
   * 
   *  Gets the attribute value for Portes, using the alias name Portes
   */
  public String getPortes()
  {
    return (String)getAttributeInternal(PORTES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Portes
   */
  public void setPortes(String value)
  {
    setAttributeInternal(PORTES, value);
  }

  /**
   * 
   *  Gets the attribute value for Falbaran, using the alias name Falbaran
   */
  public String getFalbaran()
  {
    return (String)getAttributeInternal(FALBARAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Falbaran
   */
  public void setFalbaran(String value)
  {
    setAttributeInternal(FALBARAN, value);
  }

  /**
   * 
   *  Gets the attribute value for Spedido, using the alias name Spedido
   */
  public String getSpedido()
  {
    return (String)getAttributeInternal(SPEDIDO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Spedido
   */
  public void setSpedido(String value)
  {
    setAttributeInternal(SPEDIDO, value);
  }

  /**
   * 
   *  Gets the attribute value for Pais, using the alias name Pais
   */
  public String getPais()
  {
    return (String)getAttributeInternal(PAIS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Pais
   */
  public void setPais(String value)
  {
    setAttributeInternal(PAIS, value);
  }

  /**
   * 
   *  Gets the attribute value for Transporte, using the alias name Transporte
   */
  public String getTransporte()
  {
    return (String)getAttributeInternal(TRANSPORTE);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Transporte
   */
  public void setTransporte(String value)
  {
    setAttributeInternal(TRANSPORTE, value);
  }

  /**
   * 
   *  Gets the attribute value for Reembolso, using the alias name Reembolso
   */
  public Number getReembolso()
  {
    return (Number)getAttributeInternal(REEMBOLSO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Reembolso
   */
  public void setReembolso(Number value)
  {
    setAttributeInternal(REEMBOLSO, value);
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
   *  Gets the attribute value for Codempresa, using the alias name Codempresa
   */
  public Number getCodempresa()
  {
    return (Number)getAttributeInternal(CODEMPRESA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Codempresa
   */
  public void setCodempresa(Number value)
  {
    setAttributeInternal(CODEMPRESA, value);
  }

  /**
   * 
   *  Gets the attribute value for Transp, using the alias name Transp
   */
  public Number getTransp()
  {
    return (Number)getAttributeInternal(TRANSP);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Transp
   */
  public void setTransp(Number value)
  {
    setAttributeInternal(TRANSP, value);
  }

  /**
   * 
   *  Gets the attribute value for Tportes, using the alias name Tportes
   */
  public String getTportes()
  {
    return (String)getAttributeInternal(TPORTES);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tportes
   */
  public void setTportes(String value)
  {
    setAttributeInternal(TPORTES, value);
  }

  /**
   * 
   *  Gets the attribute value for Ccliente, using the alias name Ccliente
   */
  public Number getCcliente()
  {
    return (Number)getAttributeInternal(CCLIENTE);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Ccliente
   */
  public void setCcliente(Number value)
  {
    setAttributeInternal(CCLIENTE, value);
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
   *  Gets the attribute value for Idultbulto, using the alias name Idultbulto
   */
  public Number getIdultbulto()
  {
    return (Number)getAttributeInternal(IDULTBULTO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idultbulto
   */
  public void setIdultbulto(Number value)
  {
    setAttributeInternal(IDULTBULTO, value);
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
      case NUMLINEAS:
        return getNumlineas();
      case NUMBULTOS:
        return getNumbultos();
      case ESTADO:
        return getEstado();
      case OPERARIO:
        return getOperario();
      case PESTOTAL:
        return getPestotal();
      case MOTIVO:
        return getMotivo();
      case NOMBRE:
        return getNombre();
      case DIRECCION:
        return getDireccion();
      case CODPOSTAL:
        return getCodpostal();
      case POBLACION:
        return getPoblacion();
      case PROVINCIA:
        return getProvincia();
      case TELEFONO:
        return getTelefono();
      case PORTES:
        return getPortes();
      case FALBARAN:
        return getFalbaran();
      case SPEDIDO:
        return getSpedido();
      case PAIS:
        return getPais();
      case TRANSPORTE:
        return getTransporte();
      case REEMBOLSO:
        return getReembolso();
      case TALBARAN:
        return getTalbaran();
      case NALBARAN:
        return getNalbaran();
      case CODEMPRESA:
        return getCodempresa();
      case TRANSP:
        return getTransp();
      case TPORTES:
        return getTportes();
      case CCLIENTE:
        return getCcliente();
      case FECCRE:
        return getFeccre();
      case IDULTBULTO:
        return getIdultbulto();
      case IDTIPDOC:
        return getIdtipdoc();
      case CREATEDBY:
        return getCreatedby();
      case MODIFIEDBY:
        return getModifiedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDON:
        return getModifiedon();
      case PRIORIDAD:
        return getPrioridad();
      case ESTADOLINEAS:
        return getEstadolineas();
      case BULTOSLO:
        return getBultoslo();
      case BULTOMLD:
        return getBultomld();
      case IMPRIMIR:
        return getImprimir();
      case ESTCOM:
        return getEstcom();
      case FPEDIDO:
        return getFpedido();
      case IDPUESTOFIN:
        return getIdpuestofin();
      case BULTOMAN:
        return getBultoman();
      case TIPDOCSGA:
        return getTipdocsga();
      case SGALDOC:
        return getSgaldoc();
      case SGAEDOC:
        return getSgaedoc();
      case SGABULTO:
        return getSgabulto();
      case SGABULTOSLO:
        return getSgabultoSlo();
      case SGABULTOMLD:
        return getSgabultoMld();
      case SGAETIQUETA:
        return getSgaetiqueta();
      case SGABULTOMAN:
        return getSgabultoMan();
      case SGATIPDOC:
        return getSgatipdoc();
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
        setIdcabnum((String)value);
        return;
      case NUMLINEAS:
        setNumlineas((Number)value);
        return;
      case NUMBULTOS:
        setNumbultos((Number)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case OPERARIO:
        setOperario((Number)value);
        return;
      case PESTOTAL:
        setPestotal((Number)value);
        return;
      case MOTIVO:
        setMotivo((String)value);
        return;
      case NOMBRE:
        setNombre((String)value);
        return;
      case DIRECCION:
        setDireccion((String)value);
        return;
      case CODPOSTAL:
        setCodpostal((String)value);
        return;
      case POBLACION:
        setPoblacion((String)value);
        return;
      case PROVINCIA:
        setProvincia((String)value);
        return;
      case TELEFONO:
        setTelefono((String)value);
        return;
      case PORTES:
        setPortes((String)value);
        return;
      case FALBARAN:
        setFalbaran((String)value);
        return;
      case SPEDIDO:
        setSpedido((String)value);
        return;
      case PAIS:
        setPais((String)value);
        return;
      case TRANSPORTE:
        setTransporte((String)value);
        return;
      case REEMBOLSO:
        setReembolso((Number)value);
        return;
      case TALBARAN:
        setTalbaran((String)value);
        return;
      case NALBARAN:
        setNalbaran((String)value);
        return;
      case CODEMPRESA:
        setCodempresa((Number)value);
        return;
      case TRANSP:
        setTransp((Number)value);
        return;
      case TPORTES:
        setTportes((String)value);
        return;
      case CCLIENTE:
        setCcliente((Number)value);
        return;
      case FECCRE:
        setFeccre((FlexiDate)value);
        return;
      case IDULTBULTO:
        setIdultbulto((Number)value);
        return;
      case IDTIPDOC:
        setIdtipdoc((String)value);
        return;
      case PRIORIDAD:
        setPrioridad((Number)value);
        return;
      case BULTOSLO:
        setBultoslo((Number)value);
        return;
      case BULTOMLD:
        setBultomld((Number)value);
        return;
      case IMPRIMIR:
        setImprimir((String)value);
        return;
      case ESTCOM:
        setEstcom((String)value);
        return;
      case FPEDIDO:
        setFpedido((FlexiDate)value);
        return;
      case IDPUESTOFIN:
        setIdpuestofin((String)value);
        return;
      case BULTOMAN:
        setBultoman((Number)value);
        return;
      case TIPDOCSGA:
        setTipdocsga((String)value);
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
  public RowIterator getSgaldoc()
  {
    return (RowIterator)getAttributeInternal(SGALDOC);
  }


  /**
   * 
   *  Gets the associated entity SgatipdocImpl
   */
  public SgatipdocImpl getSgatipdoc()
  {
    return (SgatipdocImpl)getAttributeInternal(SGATIPDOC);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgatipdocImpl
   */
  public void setSgatipdoc(SgatipdocImpl value)
  {
    setAttributeInternal(SGATIPDOC, value);
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
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgaedoc()
  {
    return (RowIterator)getAttributeInternal(SGAEDOC);
  }


  /**
   * 
   *  Gets the attribute value for Prioridad, using the alias name Prioridad
   */
  public Number getPrioridad()
  {
    return (Number)getAttributeInternal(PRIORIDAD);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Prioridad
   */
  public void setPrioridad(Number value)
  {
    setAttributeInternal(PRIORIDAD, value);
  }





  /**
   * 
   *  Gets the attribute value for Estadolineas, using the alias name Estadolineas
   */
  public String getEstadolineas()
  {
    return (String)getAttributeInternal(ESTADOLINEAS);
  }


  /**
   * 
   *  Gets the associated entity oracle.jbo.RowIterator
   */
  public RowIterator getSgabulto()
  {
    return (RowIterator)getAttributeInternal(SGABULTO);
  }


  /**
   * 
   *  Add attribute defaulting logic in this method.
   */
  protected void create(AttributeList attributeList)
  {
    super.create(attributeList);

    // Xavi - Afegim la clau provinent de la sequencia seq_iddocman
    SequenceImpl cdocSeq = new SequenceImpl("SEQ_IDDOC", getDBTransaction());
    setIddoc(cdocSeq.getSequenceNumber());
  }


  /**
   * 
   *  Gets the attribute value for Bultoslo, using the alias name Bultoslo
   */
  public Number getBultoslo()
  {
    return (Number)getAttributeInternal(BULTOSLO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Bultoslo
   */
  public void setBultoslo(Number value)
  {
    // Si ja hi havia un bulto assignat, el marquem per imprimir
    // Xavi, 22/07/05: Pot ser que en algun cas SgabultoSlo() sigui null
    //if (getBultoslo() != null)
    if (getBultoslo() != null && getSgabultoSlo() != null)
    {
      getSgabultoSlo().setImprimir("S");
    }
    setAttributeInternal(BULTOSLO, value);
  }

  /**
   * 
   *  Gets the attribute value for Bultomld, using the alias name Bultomld
   */
  public Number getBultomld()
  {
    return (Number)getAttributeInternal(BULTOMLD);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Bultomld
   */
  public void setBultomld(Number value)
  {
    // Si ja hi havia un bulto assignat, el marquem per imprimir
    // Xavi, 22/07/05: Pot ser que en algun cas SgabultoMld() sigui null
    //if (getBultomld() != null)
    if (getBultomld() != null && getSgabultoMld() != null)
    {
      getSgabultoMld().setImprimir("S");      
    }
    setAttributeInternal(BULTOMLD, value);
  }


  
  public void anularReserves()
  {
    RowIterator linies = getSgaldoc();
    linies.reset();
    while (linies.hasNext())
    {
      SgaldocImpl ldoc = (SgaldocImpl)linies.next();
      ldoc.anularReserves();
    }
    
    
  }


  /**
   * 
   *  Gets the associated entity SgabultoImpl
   */
  public SgabultoImpl getSgabultoSlo()
  {
    return (SgabultoImpl)getAttributeInternal(SGABULTOSLO);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgabultoImpl
   */
  public void setSgabultoSlo(SgabultoImpl value)
  {
    setAttributeInternal(SGABULTOSLO, value);
  }


  /**
   * 
   *  Gets the associated entity SgabultoImpl
   */
  public SgabultoImpl getSgabultoMld()
  {
    return (SgabultoImpl)getAttributeInternal(SGABULTOMLD);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgabultoImpl
   */
  public void setSgabultoMld(SgabultoImpl value)
  {
    setAttributeInternal(SGABULTOMLD, value);
  }


  /**
   * 
   *  Gets the attribute value for Imprimir, using the alias name Imprimir
   */
  public String getImprimir()
  {
    return (String)getAttributeInternal(IMPRIMIR);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Imprimir
   */
  public void setImprimir(String value)
  {
    setAttributeInternal(IMPRIMIR, value);
    // Si s'ha acabat el document, el posem a estat H
    if (value.equals("N"))
      if (getEstado().equals("F") || getEstado().equals("A"))
        setEstado("H");
  }


  public boolean isHost ()
  {
    return getSgatipdoc().isHost();
  }

  public boolean isOchoa()
  {
    return (getTransp() != null && getTransp().equals(new Number(331)));
  }
  
  public boolean isRedur()
  {
    return (getTransp() != null && getTransp().equals(new Number(176)));
  }
  
  public boolean isRamoneda()
  {
    return (getTransp() != null && getTransp().equals(new Number(351)));
  }
  
  
  public boolean isExport() 
  {
    boolean result;
    String cabnum = getIdcabnum();
    result = cabnum.startsWith("VX");
    return result;
  }


  public boolean isTrasllat()
  {
    return getIdtipdoc().equals("TL");
  }

  public void insertarTL ()
  {
      setIdtipdoc("TL");
      setNombre ("Trasllat..");
      setIdcabstr("TL");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
      
      Timestamp ts = new Timestamp(System.currentTimeMillis());
      
      setIdcabnum(sdf.format(ts));
      setEstado("D");
      //setTipdocsga("EM");
      setNumlineas(new Number(0));

  }

  /**
   * Retorna cert si s'ha insertat la cap�alera, fals en cas contrari
   * @return 
   * @param cabecera
   */
  public boolean insertarCabecera(ResultSet cabecera) 
  {
    boolean insertat = true;
    try
    {
      setIdcabstr(cabecera.getString("cab_tid").trim());    
      // TODO Michael Ibermatica setIdcabnum(new Number(cabecera.getBigDecimal("cab_id")));
      BigDecimal tipoOrden = cabecera.getBigDecimal("cab_tipo_orden");
      if (tipoOrden.equals(new BigDecimal(10)))      
        setIdtipdoc("EN");
      else
        setIdtipdoc("SO");
      setNumlineas(new Number(cabecera.getBigDecimal("cab_num_lineas")));
      setNumbultos(new Number(cabecera.getBigDecimal("cab_num_bultos")));
      setFeccre(new FlexiDate(cabecera.getString("cab_fcreacion")));
      
      // Michael 23.01.2014 Si prioridad 0, insertar a prioridad 5
      BigDecimal cab_prioridad = cabecera.getBigDecimal("cab_prioridad");
      // if (cab_prioridad.equals(new BigDecimal(0)))
        cab_prioridad = new BigDecimal(5);
      setPrioridad(new Number (cab_prioridad));
      
      setNombre(getTrim(cabecera.getString("cab_nombre")));
      setDireccion(getTrim(cabecera.getString("cab_direccion")));
      setCodpostal(getTrim(cabecera.getString("cab_cos_postal")));
      setPoblacion(getTrim(cabecera.getString("cab_poblacion")));
      setProvincia(getTrim(cabecera.getString("cab_provincia")));
      setTelefono(getTrim(cabecera.getString("cab_telefono")));
      setPortes(getTrim(cabecera.getString("cab_portes")));
      setFalbaran(getTrim(cabecera.getString("cab_f_albaran")));
      setSpedido(getTrim(cabecera.getString("cab_s_pedido")));
      setPais(getTrim(cabecera.getString("cab_pais")));
      setTransporte(getTrim(cabecera.getString("cab_transporte")));
      setReembolso(new Number(cabecera.getBigDecimal("cab_reembolso")));
      setTalbaran(getTrim(cabecera.getString("cab_t_albaran")));
      // Michael TODO Iberm�tica 25.11.2009 setNalbaran(new Number(cabecera.getBigDecimal("cab_n_albaran")));
      setCodempresa(new Number(cabecera.getBigDecimal("cab_cod_empresa")));
      setTransp(new Number(cabecera.getBigDecimal("cab_c_transp")));
      setCcliente(new Number(cabecera.getBigDecimal("cab_c_cliente")));
      setFpedido(new FlexiDate(cabecera.getDate("cab_f_pedido")));
      //Xavi, 27/06/05: Afegit per mostrar un texte a l'usuari quan obre un doc. sortida
      setMotivo(getTrim(cabecera.getString("cab_motivo")));
      
      // Michael 01.10.2009 Usar el campo reembolso para nr. exped Ochoa. 
      // Se pone el numero de secuencia de expedicion en el momento de activar la orden.
      // Este n�mero de secuencia se devuelve a Joan Pros
      setReembolso(null);
      
      
    }
    catch(SQLException ex)
    {
      System.out.println("Error inesperat: " + ex);
      insertat = false;
    }
    return insertat;
  }
  
  
  public String getNalbaranNumeric ()
  {
    if (getNalbaran() != null && getNalbaran().length() > 3) 
    {
      // assuming nalbaran is xx/999999
      return (getNalbaran().substring(3));
    }
    return null;
  }
  
  /**
   * Es torna el n�mero d'expedici� del transportista en el camp REEMBOLSO
   * Si es Ochoa, un n�mero secuencial
   * Si es REDUR, la part num�rica del nro. albar�n
   * 13.09.2017 Ramoneda - numero de secuencia
   */
  public void setSequenciaExped()
  {
      // Michael 23.09.2009 Si el transportista es Ochoa, genera n�mero de expedici�n
      if (isOchoa())
      {
        // S�lo si no tiene un valor ya
        if (getReembolso() == null || getReembolso().intValue() == 0)
        {
          SequenceImpl expedSeq = new SequenceImpl("SEQ_EXPEDOCHOA", getDBTransaction());
          setReembolso(expedSeq.getSequenceNumber()); // Se guarda aqu� para devolver al Joan Pros
        }
      }
      // Michael 23.09.2009 fin
      
      else if (isRedur())
      {
        if (getReembolso() == null || getReembolso().intValue() == 0)
        {
          // Redur value is the numeric part of the nr. Albar�n
          try 
          {
            Number reembolso = new Number (getNalbaranNumeric());
            setReembolso(reembolso); // Se guarda aqu� para devolver al Joan Pros
          } catch (SQLException ex) 
          {
            ex.printStackTrace();
          } 
          
        }

      }
      else if (isRamoneda())
      {
        // Michael 13.09.2017 Si es Ramoneda, marcar secuencia del bulto
        if (getReembolso() == null || getReembolso().intValue() == 0)
          {
              SequenceImpl expedSeq = new SequenceImpl("SEQ_EXPEDRAMONEDA", getDBTransaction());
              setReembolso(expedSeq.getSequenceNumber()); // Se guarda aqu� para devolver al Joan Pros
          }

      }

  }
  
  public String getExpedRamoneda()
  {
     if (getReembolso() == null || getReembolso().intValue() == 0)
      return "000000";
      
    DecimalFormat df = new DecimalFormat("000000");
    String expedRamoneda = df.format(getReembolso().intValue());
    return (expedRamoneda);
  }
  
  public String getExpedOchoa()
  {
    if (getReembolso() == null || getReembolso().intValue() == 0)
      return "00000000";
    else
      return (getReembolso().toString());  
  }
 

  private String getTrim(String str)
  {
    return (str != null ? str.trim() : "");
  }
  /**
   * 
   *  Gets the attribute value for Estcom, using the alias name Estcom
   */
  public String getEstcom()
  {
    return (String)getAttributeInternal(ESTCOM);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Estcom
   */
  public void setEstcom(String value)
  {
    setAttributeInternal(ESTCOM, value);
  }


  /**
   * 
   *  Gets the attribute value for Fpedido, using the alias name Fpedido
   */
  public FlexiDate getFpedido()
  {
    return (FlexiDate)getAttributeInternal(FPEDIDO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Fpedido
   */
  public void setFpedido(FlexiDate value)
  {
    setAttributeInternal(FPEDIDO, value);
  }

  /**
   * 
   *  Gets the attribute value for Idpuestofin, using the alias name Idpuestofin
   */
  public String getIdpuestofin()
  {
    return (String)getAttributeInternal(IDPUESTOFIN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Idpuestofin
   */
  public void setIdpuestofin(String value)
  {
    setAttributeInternal(IDPUESTOFIN, value);
  }


  /**
   * 
   *  Gets the associated entity SgaetiquetaImpl
   */
  public SgaetiquetaImpl getSgaetiqueta()
  {
    return (SgaetiquetaImpl)getAttributeInternal(SGAETIQUETA);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgaetiquetaImpl
   */
  public void setSgaetiqueta(SgaetiquetaImpl value)
  {
    setAttributeInternal(SGAETIQUETA, value);
  }


  /**
   * 
   *  Gets the attribute value for Bultoman, using the alias name Bultoman
   */
  public Number getBultoman()
  {
    return (Number)getAttributeInternal(BULTOMAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Bultoman
   */
  public void setBultoman(Number value)
  {
    // Si ja hi havia un bulto assignat, el marquem per imprimir
    if (getBultoman() != null && getSgabultoMan() != null)
    {
      getSgabultoMan().setImprimir("S");
    }
   
    setAttributeInternal(BULTOMAN, value);
  }




  /**
   * 
   *  Gets the associated entity SgabultoImpl
   */
  public SgabultoImpl getSgabultoMan()
  {
    return (SgabultoImpl)getAttributeInternal(SGABULTOMAN);
  }

  /**
   * 
   *  Sets <code>value</code> as the associated entity SgabultoImpl
   */
  public void setSgabultoMan(SgabultoImpl value)
  {
    setAttributeInternal(SGABULTOMAN, value);
  }


  /**
   * 
   *  Gets the attribute value for Tipdocsga, using the alias name Tipdocsga
   */
  public String getTipdocsga()
  {
    return (String)getAttributeInternal(TIPDOCSGA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Tipdocsga
   */
  public void setTipdocsga(String value)
  {
    setAttributeInternal(TIPDOCSGA, value);
  }



/**
 * Esborrar reserves si es que hi ha encara, en el cas de trasllat
 */
  public void remove ()
  {
  
    if (isTrasllat())
    {
      anularReserves();
 
      RowIterator bulto = getSgabulto();
      bulto.reset();
      while (bulto.hasNext())
    {
      SgabultoImpl bultoRow = (SgabultoImpl)bulto.next();
      bultoRow.remove();
    }
    
    RowIterator ldoc = getSgaldoc();
    ldoc.reset();
    while (ldoc.hasNext())
    {
      SgaldocImpl ldocRow = (SgaldocImpl)ldoc.next();
      ldocRow.remove();
    }
 
    
 
    getDBTransaction().postChanges();

    }
        super.remove();
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

