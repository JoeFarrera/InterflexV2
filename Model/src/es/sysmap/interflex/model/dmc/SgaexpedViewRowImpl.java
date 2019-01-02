package es.sysmap.interflex.model.dmc;
import es.sysmap.interflex.model.dmc.SgaexpedbultoViewRowImpl;
import es.sysmap.interflex.model.dmc.common.SgacdocViewRow;
import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgaexpedViewRowImpl extends ViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgaexpedViewRow 
{


  public static final int IDEXPED = 0;
  public static final int CREATEDBY = 1;
  public static final int CREATEDON = 2;
  public static final int MODIFIEDBY = 3;
  public static final int MODIFIEDON = 4;
  public static final int CLIENT1ERCOMANDA = 5;
  public static final int SGAEXPEDBULTOVIEW = 6;
  public static final int SGAEXPEDDOCVIEW = 7;
  public static final int SGAVEXPEDCDOCVIEW = 8;
  public static final int SGAVEXPEDBULTOVIEW = 9;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgaexpedViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Sgaexped entity object.
   */
  public es.sysmap.interflex.model.bdc.SgaexpedImpl getSgaexped()
  {
    return (es.sysmap.interflex.model.bdc.SgaexpedImpl)getEntity(0);
  }

  /**
   * 
   *  Gets the attribute value for IDEXPED using the alias name Idexped
   */
  public Number getIdexped()
  {
    return (Number)getAttributeInternal(IDEXPED);
  }

  /**
   * 
   *  Sets <code>value</code> as attribute value for IDEXPED using the alias name Idexped
   */
  public void setIdexped(Number value)
  {
    setAttributeInternal(IDEXPED, value);
  }






  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    switch (index)
      {
      case IDEXPED:
        return getIdexped();
      case CREATEDBY:
        return getCreatedby();
      case CREATEDON:
        return getCreatedon();
      case MODIFIEDBY:
        return getModifiedby();
      case MODIFIEDON:
        return getModifiedon();
      case CLIENT1ERCOMANDA:
        return getClient1erComanda();
      case SGAEXPEDBULTOVIEW:
        return getSgaexpedbultoView();
      case SGAEXPEDDOCVIEW:
        return getSgaexpeddocView();
      case SGAVEXPEDCDOCVIEW:
        return getSgavexpedcdocView();
      case SGAVEXPEDBULTOVIEW:
        return getSgavexpedbultoView();
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
      case IDEXPED:
        setIdexped((Number)value);
        return;
      case CLIENT1ERCOMANDA:
        setClient1erComanda((String)value);
        return;
      default:
        super.setAttrInvokeAccessor(index, value, attrDef);
        return;
      }
  }
  
  int getMaxBulto() 
  {
    RowIterator rows = getSgaexpedbultoView();
    int maxBulto = 0;
    // Veure si existeix aquest, i determinar el max n�mero de bulto fins ara
    while (rows.hasNext()) 
    {
      SgaexpedbultoViewRowImpl bulto = (SgaexpedbultoViewRowImpl)rows.next();
      if (bulto.getIdbulto().intValue() > maxBulto)
        {        
          maxBulto = bulto.getIdbulto().intValue();
        }
      
    }
    return maxBulto;

    
  }
  
  public void afegirDocSortida (SgacdocViewRow cdocRow)
  {
    // Has the document already been inserted in this exped
    boolean exists = false;
    
    SgaexpeddocViewRowImpl expedDocViewRow =  (SgaexpeddocViewRowImpl)getSgaexpeddocView().createRow();
    expedDocViewRow.setIddoc(cdocRow.getIddoc());
    expedDocViewRow.setIdexped(getIdexped()); // TODO - necesario??
    getSgaexpeddocView().insertRow(expedDocViewRow);
    
    // RowIterator rows = getSgaexpedbultoView();
    int maxBulto = getMaxBulto();
    cdocRow.getSgabultoView().reset();
    RowIterator bultoRows = cdocRow.getSgabultoView();
    while (bultoRows.hasNext())
    {
      SgabultoViewRowImpl bulto = (SgabultoViewRowImpl)bultoRows.next();
      SgaexpedbultoViewRowImpl exbultoRow = (SgaexpedbultoViewRowImpl)getSgaexpedbultoView().createRow();
      exbultoRow.setIdexped(getIdexped());
      exbultoRow.setIdbulto(new Number(++maxBulto));
      exbultoRow.setIdbultoOri(bulto.getIdbulto());
      exbultoRow.setIdtipobulto(bulto.getIdtipobulto());
      exbultoRow.setAlto(bulto.getAlto());
      exbultoRow.setAncho(bulto.getAncho());
      exbultoRow.setLargo(bulto.getLargo());
      exbultoRow.setPesocont(bulto.getPesocont());
      getSgaexpedbultoView().insertRow(exbultoRow); 
      
      bulto.getSgalbultoView().reset();
      exbultoRow.insertlbulto(bulto);
      
    }
  }
  
  public void esborrarDocSortida (SgacdocViewRow cdocRow)
  {
    RowIterator rowsBulto = getSgaexpedbultoView();
    while (rowsBulto.hasNext()) 
    {
      SgaexpedbultoViewRowImpl bultoRow = (SgaexpedbultoViewRowImpl)rowsBulto.next();
      RowIterator rowslBulto = bultoRow.getSgaexpedlbultoView();
      boolean altresLinies = false;
      while (rowslBulto.hasNext()) 
      {
        SgaexpedlbultoViewRowImpl rowlBulto = (SgaexpedlbultoViewRowImpl)rowslBulto.next();
        if (rowlBulto.getIddoc().equals(cdocRow.getIddoc())) 
          rowlBulto.remove();
        else
          // hi ha l�nies d'altres documents
          altresLinies = true;
      }
      if (!altresLinies) 
      {
        bultoRow.remove();
      }
    }
    
    
    
    
    RowIterator rows = getSgaexpeddocView();
    while (rows.hasNext()) 
    {
      SgaexpeddocViewRowImpl docRow = (SgaexpeddocViewRowImpl)rows.next();
      if (docRow.getIddoc().equals(cdocRow.getIddoc()))
      {
        docRow.remove();
        break;
      }
    }
  }
  
  public SgaexpedbultoViewRowImpl afegirBulto(SgaexpedbultoViewRowImpl oldRow)
  {
    int maxBulto = getMaxBulto();
    SgaexpedbultoViewRowImpl exbultoRow = (SgaexpedbultoViewRowImpl)getSgaexpedbultoView().createRow();
    exbultoRow.setIdexped(getIdexped());
    exbultoRow.setIdbulto(new Number(++maxBulto));
    exbultoRow.setIdbultoOri(oldRow.getIdbulto());
    getSgaexpedbultoView().insertRow(exbultoRow); 
    return exbultoRow;
  }

















  /**
   * 
   *  Gets the attribute value for CREATEDON using the alias name Createdon
   */
  public Date getCreatedon()
  {
    return (Date)getAttributeInternal(CREATEDON);
  }

  /**
   * 
   *  Gets the attribute value for CREATEDBY using the alias name Createdby
   */
  public String getCreatedby()
  {
    return (String)getAttributeInternal(CREATEDBY);
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
   *  Gets the attribute value for MODIFIEDON using the alias name Modifiedon
   */
  public Date getModifiedon()
  {
    return (Date)getAttributeInternal(MODIFIEDON);
  }

  /**
   * 
   *  Gets the attribute value for the calculated attribute Client1erComanda
   */
  public String getClient1erComanda()
  {
    return (String)getAttributeInternal(CLIENT1ERCOMANDA);
  }

  /**
   * 
   *  Sets <code>value</code> as the attribute value for the calculated attribute Client1erComanda
   */
  public void setClient1erComanda(String value)
  {
    setAttributeInternal(CLIENT1ERCOMANDA, value);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgavexpedcdocView
   */
  public RowIterator getSgavexpedcdocView()
  {
    return (RowIterator)getAttributeInternal(SGAVEXPEDCDOCVIEW);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgavexpedbultoView
   */
  public RowIterator getSgavexpedbultoView()
  {
    return (RowIterator)getAttributeInternal(SGAVEXPEDBULTOVIEW);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgaexpedbultoView
   */
  public RowIterator getSgaexpedbultoView()
  {
    return (RowIterator)getAttributeInternal(SGAEXPEDBULTOVIEW);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgaexpeddocView
   */
  public RowIterator getSgaexpeddocView()
  {
    return (RowIterator)getAttributeInternal(SGAEXPEDDOCVIEW);
  }
  
  
  public SgacdocViewRowImpl getFirstCdocRow () 
  {
    SgacdocViewRowImpl cdocRow = null;
    RowIterator rows = getSgaexpeddocView();
    SgaexpeddocViewRowImpl expeddocRow = (SgaexpeddocViewRowImpl)rows.first();
    if (expeddocRow != null)
    {
      cdocRow = (SgacdocViewRowImpl)expeddocRow.getSgacdocView();
    }
    return cdocRow;
  }












 
}