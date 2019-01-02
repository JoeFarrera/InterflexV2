package es.sysmap.interflex.model.dmc;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgapuestomanipViewRowImpl extends ViewRowImpl 
{


  public static final int IDPUESTO = 0;
  public static final int IDUBIMLD = 1;
  public static final int IDUBISLO = 2;
  public static final int ESTADO = 3;
  public static final int AUTOSELORDSAL = 4;
  public static final int NUMORDSAL = 5;
  public static final int AUTORETIRARMAC = 6;
  public static final int BASCULAMLD = 7;
  public static final int BASCULASLO = 8;
  public static final int SGAUBICACIONPPKSILOVIEW = 9;
  public static final int SGAUBICACIONPPKMINILOADVIEW = 10;
  public static final int SGAUBICACIONMINILOADVIEW = 7;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgapuestomanipViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Sgapuestomanip entity object.
   */
  public es.sysmap.interflex.model.bdc.SgapuestomanipImpl getSgapuestomanip()
  {
    return (es.sysmap.interflex.model.bdc.SgapuestomanipImpl)getEntity(0);
  }

  /**
   * 
   *  Gets the attribute value for IDPUESTO using the alias name Idpuesto
   */
  public String getIdpuesto()
  {
    return (String)getAttributeInternal(IDPUESTO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDPUESTO using the alias name Idpuesto
   */
  public void setIdpuesto(String value)
  {
    setAttributeInternal(IDPUESTO, value);
  }

  /**
   * 
   *  Gets the attribute value for IDUBIMLD using the alias name Idubimld
   */
  public String getIdubimld()
  {
    return (String)getAttributeInternal(IDUBIMLD);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDUBIMLD using the alias name Idubimld
   */
  public void setIdubimld(String value)
  {
    setAttributeInternal(IDUBIMLD, value);
  }

  /**
   * 
   *  Gets the attribute value for IDUBISLO using the alias name Idubislo
   */
  public String getIdubislo()
  {
    return (String)getAttributeInternal(IDUBISLO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDUBISLO using the alias name Idubislo
   */
  public void setIdubislo(String value)
  {
    setAttributeInternal(IDUBISLO, value);
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
   *  Gets the attribute value for AUTOSELORDSAL using the alias name Autoselordsal
   */
  public String getAutoselordsal()
  {
    return (String)getAttributeInternal(AUTOSELORDSAL);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for AUTOSELORDSAL using the alias name Autoselordsal
   */
  public void setAutoselordsal(String value)
  {
    setAttributeInternal(AUTOSELORDSAL, value);
  }

  /**
   * 
   *  Gets the attribute value for NUMORDSAL using the alias name Numordsal
   */
  public Number getNumordsal()
  {
    return (Number)getAttributeInternal(NUMORDSAL);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for NUMORDSAL using the alias name Numordsal
   */
  public void setNumordsal(Number value)
  {
    setAttributeInternal(NUMORDSAL, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDPUESTO:
        return getIdpuesto();
      case IDUBIMLD:
        return getIdubimld();
      case IDUBISLO:
        return getIdubislo();
      case ESTADO:
        return getEstado();
      case AUTOSELORDSAL:
        return getAutoselordsal();
      case NUMORDSAL:
        return getNumordsal();
      case AUTORETIRARMAC:
        return getAutoretirarmac();
      case BASCULAMLD:
        return getBasculamld();
      case BASCULASLO:
        return getBasculaslo();
      case SGAUBICACIONPPKSILOVIEW:
        return getSgaubicacionPpkSiloView();
      case SGAUBICACIONPPKMINILOADVIEW:
        return getSgaubicacionPpkMiniLoadView();
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
      case IDPUESTO:
        setIdpuesto((String)value);
        return;
      case IDUBIMLD:
        setIdubimld((String)value);
        return;
      case IDUBISLO:
        setIdubislo((String)value);
        return;
      case ESTADO:
        setEstado((String)value);
        return;
      case AUTOSELORDSAL:
        setAutoselordsal((String)value);
        return;
      case NUMORDSAL:
        setNumordsal((Number)value);
        return;
      case AUTORETIRARMAC:
        setAutoretirarmac((String)value);
        return;
      case BASCULAMLD:
        setBasculamld((String)value);
        return;
      case BASCULASLO:
        setBasculaslo((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   *  Gets the attribute value for AUTORETIRARMAC using the alias name Autoretirarmac
   */
  public String getAutoretirarmac()
  {
    return (String)getAttributeInternal(AUTORETIRARMAC);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for AUTORETIRARMAC using the alias name Autoretirarmac
   */
  public void setAutoretirarmac(String value)
  {
    setAttributeInternal(AUTORETIRARMAC, value);
  }

  /**
   * 
   *  Gets the associated <code>Row</code> using master-detail link SgaubicacionMiniLoadView
   */
  public oracle.jbo.Row getSgaubicacionMiniLoadView()
  {
    return (oracle.jbo.Row)getAttributeInternal(SGAUBICACIONMINILOADVIEW);
  }




  /**
   * 
   *  Gets the associated <code>Row</code> using master-detail link SgaubicacionPpkMiniLoadView
   */
  public oracle.jbo.Row getSgaubicacionPpkMiniLoadView()
  {
    return (oracle.jbo.Row)getAttributeInternal(SGAUBICACIONPPKMINILOADVIEW);
  }

  /**
   * 
   *  Gets the associated <code>Row</code> using master-detail link SgaubicacionPpkSiloView
   */
  public oracle.jbo.Row getSgaubicacionPpkSiloView()
  {
    return (oracle.jbo.Row)getAttributeInternal(SGAUBICACIONPPKSILOVIEW);
  }

  /**
   * 
   *  Gets the attribute value for BASCULAMLD using the alias name Basculamld
   */
  public String getBasculamld()
  {
    return (String)getAttributeInternal(BASCULAMLD);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for BASCULAMLD using the alias name Basculamld
   */
  public void setBasculamld(String value)
  {
    setAttributeInternal(BASCULAMLD, value);
  }

  /**
   * 
   *  Gets the attribute value for BASCULASLO using the alias name Basculaslo
   */
  public String getBasculaslo()
  {
    return (String)getAttributeInternal(BASCULASLO);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for BASCULASLO using the alias name Basculaslo
   */
  public void setBasculaslo(String value)
  {
    setAttributeInternal(BASCULASLO, value);
  }







}