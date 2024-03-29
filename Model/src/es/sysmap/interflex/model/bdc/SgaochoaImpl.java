package es.sysmap.interflex.model.bdc;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.Key;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaochoaImpl extends EntityImpl 
{
  public static final int CODPAIS = 0;
  public static final int CODPOSTAL = 1;
  public static final int ZONAREP = 2;
  public static final int H24 = 3;
  public static final int COURIER = 4;
  public static final int PLAZADESTINO = 5;
  public static final int CODPLAZADEST3 = 6;
  public static final int CODPLAZADEST2 = 7;

  private static EntityDefImpl mDefinitionObject;

  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaochoaImpl()
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
      mDefinitionObject = (EntityDefImpl)EntityDefImpl.findDefObject("es.sysmap.interflex.model.bdc.Sgaochoa");
    }
    return mDefinitionObject;
  }


  /**
   * 
   *  Gets the attribute value for CodPais, using the alias name CodPais
   */
  public String getCodPais()
  {
    return (String)getAttributeInternal(CODPAIS);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for CodPais
   */
  public void setCodPais(String value)
  {
    setAttributeInternal(CODPAIS, value);
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
   *  Gets the attribute value for ZonaRep, using the alias name ZonaRep
   */
  public String getZonaRep()
  {
    return (String)getAttributeInternal(ZONAREP);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for ZonaRep
   */
  public void setZonaRep(String value)
  {
    setAttributeInternal(ZONAREP, value);
  }

  /**
   * 
   *  Gets the attribute value for H24, using the alias name H24
   */
  public String getH24()
  {
    return (String)getAttributeInternal(H24);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for H24
   */
  public void setH24(String value)
  {
    setAttributeInternal(H24, value);
  }

  /**
   * 
   *  Gets the attribute value for Courier, using the alias name Courier
   */
  public String getCourier()
  {
    return (String)getAttributeInternal(COURIER);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for Courier
   */
  public void setCourier(String value)
  {
    setAttributeInternal(COURIER, value);
  }

  /**
   * 
   *  Gets the attribute value for PlazaDestino, using the alias name PlazaDestino
   */
  public String getPlazaDestino()
  {
    return (String)getAttributeInternal(PLAZADESTINO);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for PlazaDestino
   */
  public void setPlazaDestino(String value)
  {
    setAttributeInternal(PLAZADESTINO, value);
  }

  /**
   * 
   *  Gets the attribute value for CodPlazaDest3, using the alias name CodPlazaDest3
   */
  public String getCodPlazaDest3()
  {
    return (String)getAttributeInternal(CODPLAZADEST3);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for CodPlazaDest3
   */
  public void setCodPlazaDest3(String value)
  {
    setAttributeInternal(CODPLAZADEST3, value);
  }

  /**
   * 
   *  Gets the attribute value for CodPlazaDest2, using the alias name CodPlazaDest2
   */
  public String getCodPlazaDest2()
  {
    return (String)getAttributeInternal(CODPLAZADEST2);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for CodPlazaDest2
   */
  public void setCodPlazaDest2(String value)
  {
    setAttributeInternal(CODPLAZADEST2, value);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case CODPAIS:
        return getCodPais();
      case CODPOSTAL:
        return getCodPostal();
      case ZONAREP:
        return getZonaRep();
      case H24:
        return getH24();
      case COURIER:
        return getCourier();
      case PLAZADESTINO:
        return getPlazaDestino();
      case CODPLAZADEST3:
        return getCodPlazaDest3();
      case CODPLAZADEST2:
        return getCodPlazaDest2();
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
      case CODPAIS:
        setCodPais((String)value);
        return;
      case CODPOSTAL:
        setCodPostal((String)value);
        return;
      case ZONAREP:
        setZonaRep((String)value);
        return;
      case H24:
        setH24((String)value);
        return;
      case COURIER:
        setCourier((String)value);
        return;
      case PLAZADESTINO:
        setPlazaDestino((String)value);
        return;
      case CODPLAZADEST3:
        setCodPlazaDest3((String)value);
        return;
      case CODPLAZADEST2:
        setCodPlazaDest2((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }

  /**
   * 
   *  Creates a Key object based on given key constituents
   */
  public static Key createPrimaryKey(String codPais, String codPostal)
  {
    return new Key(new Object[] {codPais, codPostal});
  }


}