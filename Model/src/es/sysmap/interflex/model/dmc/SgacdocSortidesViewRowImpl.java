package es.sysmap.interflex.model.dmc;
import es.sysmap.interflex.model.dmc.SgaldocViewImpl;
import java.util.Vector;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.java.util.Iterator;
//  ---------------------------------------------------------------------
//  ---    File generated by Oracle ADF Business Components Design Time.
//  ---    Custom code may be added to this class.
//  ---    Warning: Do not modify method signatures of generated methods.
//  ---------------------------------------------------------------------

public class SgacdocSortidesViewRowImpl extends SgacdocViewRowImpl implements es.sysmap.interflex.model.dmc.common.SgacdocSortidesViewRow  
{

;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
;
  public static final int MAXATTRCONST = oracle.jbo.server.ViewDefImpl.getMaxAttrConst("es.sysmap.interflex.model.dmc.SgacdocView");;
  public static final int SGALDOCVIEW1 = MAXATTRCONST;
  public static final int SGARESMATVIEW1 = MAXATTRCONST + 1;
  public static final int SGABULTOVIEW11 = MAXATTRCONST + 2;
  public static final int SGARESMATMANVIEW = MAXATTRCONST + 3;
  public static final int SGAVAGENCIATIPOENVIO = MAXATTRCONST + 4;
  /**
   * 
   *  This is the default constructor (do not remove)
   */
  public SgacdocSortidesViewRowImpl()
  {
  }

  /**
   * 
   *  Gets Sgacdoc entity object.
   */
  public es.sysmap.interflex.model.bdc.SgacdocImpl getSgacdoc()
  {
    return (es.sysmap.interflex.model.bdc.SgacdocImpl)getEntity(0);
  }

  /**
   * 
   *  getAttrInvokeAccessor: generated method. Do not modify.
   */
  protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception
  {
    if (index == SGALDOCVIEW1)
    {
      return getSgaldocView1();
    }
    if (index == SGARESMATVIEW1)
    {
      return getSgaresmatView1();
    }
    if (index == SGABULTOVIEW11)
    {
      return getSgabultoView11();
    }
    if (index == SGARESMATMANVIEW)
    {
      return getSgaresmatmanView();
    }
    if (index == SGAVAGENCIATIPOENVIO)
    {
      return getSgavAgenciaTipoEnvio();
    }
    return super.getAttrInvokeAccessor(index, attrDef);
  }

  /**
   * 
   *  setAttrInvokeAccessor: generated method. Do not modify.
   */
  protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception
  {
    super.setAttrInvokeAccessor(index, value, attrDef);
    return;
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgaldocView1
   */
  public oracle.jbo.RowIterator getSgaldocView1()
  {
    return (oracle.jbo.RowIterator)getAttributeInternal(SGALDOCVIEW1);
  }
  
  public boolean isExport() 
  {
    return (getSgacdoc().isExport());
  }
  
  
  /**
   * Actualitza els estats de les linies
   * segons el tipus d'estat passat com a parametre
   */
  public void actualitzarOrdre(String estat, String puesto)
  {
    // Si posem l'ordre en proc�s,s'actulitza l'estat de l'ordre a 'D' (per si 
    // de cas abans era suspesa) i tamb� el de les linies
    if (estat.equals("P"))
    {
      RowIterator linies = getSgaldocView1();
      linies.reset(); 
      while (linies.hasNext())
      {
        SgaldocViewRowImpl linia = (SgaldocViewRowImpl)linies.next();
        linia.actualitzarLinia(estat, puesto);
      }
      // Posem l'estat a disponible (per si de cas)
      setEstado("D");
      
      // Michael 01.10.2009 Etiquetas Ochoa
      getSgacdoc().setSequenciaExped();
        
    }
    else // En qualsevol altre cas, unicament actualitzem l'estat de l'ordre 
    {
      
      
      // Michael 12.11.2008 Si te reserves no deixar anular
      if (estat.equals("A"))
      {
      // Michael 21.07.2009 Refrescar para ver si ha cambiado
      SgacdocViewImpl vo = (SgacdocViewImpl)getViewObject();
      vo.refreshQueryKeepingCurrentRow();
        
        if (getSgaresmatView1().hasNext() || getSgaresmatmanView().hasNext())
          throw new RuntimeException ("La comande: " + getIdcabstr() + " " + getIdcabnum() + " No es permet anular per tenir reserves..");
      }
      else
      {
        // Michael 22.01.2018 - En algun cas, s'est� completant la comanda sense initialitzar la secuencia
        getSgacdoc().setSequenciaExped();
      }
      // Michael 12.11.2008 fin
      setEstado(estat);
    }
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgaresmatView1
   */
  public oracle.jbo.RowIterator getSgaresmatView1()
  {
    return (oracle.jbo.RowIterator)getAttributeInternal(SGARESMATVIEW1);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgabultoView11
   */
  public RowIterator getSgabultoView11()
  {
    return (RowIterator)getAttributeInternal(SGABULTOVIEW11);
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgaresmatmanView
   */
  public RowIterator getSgaresmatmanView()
  {
    return (RowIterator)getAttributeInternal(SGARESMATMANVIEW);
  }
  
  public boolean  isBloqueijat()
  {
    return getEstado().equals("B");
  }

  /**
   * 
   * @return Un vector que cont� les claus (Key) de cada l�nia
   * @param simular
   * @param idPuesto
   */
  public Vector getLiniesMaxiload()
  {
      RowIterator linies = getSgaldocView1();
      linies.reset(); 
      boolean activadaLinia = false;
      Vector liniesVector = new Vector();
      while (linies.hasNext())
      {
        SgaldocViewRowImpl linia = (SgaldocViewRowImpl)linies.next();        
        if (linia.isPreparacionSLO())
        {
          liniesVector.addElement(linia.getKey());
        }
      }
 
    return liniesVector;
  }
  
  
   /**
   * 
   * @return Un vector que cont� les claus (Key) de cada l�nia
   * @param simular
   * @param idPuesto
   */
  public void activarLiniesMaxiload(Vector keys, String puesto)
  {
      java.util.Iterator iter = keys.iterator();
      boolean activadaLinia = false;
      while (iter.hasNext())
        {
          Key lKey = (Key)iter.next();
          oracle.jbo.RowIterator rowIter = getSgaldocView1();
          rowIter.reset();
          while (rowIter.hasNext())
          {
            System.out.println("Key: " + rowIter.next().getKey());
          }

          SgaldocViewRowImpl linia = (SgaldocViewRowImpl)rowIter.getRow(lKey);
          linia.activar(puesto, true, true);
          activadaLinia = true;
        }
        
      if (activadaLinia)
      {
        // Posem l'estat a disponible (per si de cas)
        setEstado("D");
        
        // Michael 01.10.2009 Etiquetas Ochoa
        getSgacdoc().setSequenciaExped();
      }
  }
  
  /**
   * 
   * @return Un vector que cont� les claus (Key) de cada l�nia
   * @param simular
   * @param idPuesto
   */
  public Vector getStringLiniesMaxiload(Vector keys)
  {
      Vector liniesVector = new Vector();
      java.util.Iterator iter = keys.iterator();
      while (iter.hasNext())
        {
          Key lKey = (Key)iter.next();
          oracle.jbo.RowIterator rowIter = getSgaldocView1();
          rowIter.reset();
          while (rowIter.hasNext())
          {
            System.out.println("Key: " + rowIter.next().getKey());
          }
          SgaldocViewRowImpl linia = (SgaldocViewRowImpl)rowIter.getRow(lKey);
          liniesVector.addElement(linia.toString());
        }
        
    return liniesVector;
  }
  

  public boolean hasReserva() 
  {
    RowIterator reservas = getSgaresmatView1();
    RowIterator reservasMan = getSgaresmatmanView();
    if (reservas != null || reservasMan != null)
    {
      return true;
    }
    return false;
  }

  /**
   * 
   *  Gets the associated <code>RowIterator</code> using master-detail link SgavAgenciaTipoEnvio
   */
  public RowIterator getSgavAgenciaTipoEnvio()
  {
    return (RowIterator)getAttributeInternal(SGAVAGENCIATIPOENVIO);
  }
  
}