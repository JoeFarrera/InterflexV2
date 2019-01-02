package es.sysmap.interflex.control;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaordtranViewRow;
import es.sysmap.interflex.model.dmc.common.SgaubicacionPlcViewRow;
import es.sysmap.interflex.model.dmc.common.SgavordtranMLDAgrup;
import es.sysmap.xml.XMLTelegrama;
import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.xml.parser.v2.XMLDocument;
import org.apache.log4j.Logger;

public class ADFOrdTran extends ADFGestor
{
  private ViewObject ordTranView;
  private ViewObject ubicacionPlcView;
  private SgavordtranMLDAgrup agrupMLDView;
  private boolean pruebas;
  
  private static int ERRORESATOLERAR = 5;

  /**
   * Contar los avisos del PLC con error y parar si hay más de 2 seguidos
   */
  private int errorCounter;
  
  public ADFOrdTran(boolean pruebas)
  {
    this.pruebas = pruebas;
    connectApplicationModule();
    ordTranView = am.findViewObject("SgaordtranView1");
    ubicacionPlcView = am.findViewObject("SgaubicacionPlcView1");
    // Michael 01.12.2006 doble cubeta
    agrupMLDView = (SgavordtranMLDAgrup)am.findViewObject("SgavordtranMLDAgrup1");
    
    
  }
  
  public void resetErrorCounter()
  {
    errorCounter = 0;
  }
  
  /**
   * Devolver el siguiente orden de transporte, ordenado por los criterios de la vista
   * Actualiza la orden a pendiente de aceptación del PLC
   * Si no se encuentra orden, devuelve null
   * @return el documento xml correspondiente a la orden
   */
  public XMLDocument getNextOrdTran()
  {
  
    // Michael 01.12.2006 doble cubeta
//
//    Michael 11.01.2007 Movido a Traslo/ADFTraslo
//    agrupMLDView.agrupOrdtranMLD();
//    commit();
//    Michael 11.01.2007 fin
    // Michael 01.12.2006 fin
    
    XMLDocument xmldoc = null;
    SgaordtranViewRow row = setWhereClauseAndQuery("estado in ('N', '2')");
    if (row != null)
    {
      // Parse un documento de tipo MOVI :TODO - get this from memory
      xmldoc = XMLTelegrama.parseXML("movi");
      xmldoc = row.getXMLMovi(xmldoc);

      if (pruebas)
        row.setAceptadoPlc();
      else
        row.setPendienteAceptacionPlc();
        // NOTE: No commit deliberately
    }
    return xmldoc;
  }
  
  
  /**
   * Resetea órdenes pendiente de aceptación del PLC
   * TODO: Que pasará si es la segunda parte de la orden que se resetea
   */
  public void resetOrdenPendienteAceptacionPlc()
  {
    SgaordtranViewRow row = setWhereClauseAndQuery("estado = 'P'");
    if (row != null)
    {
      row.resetPendientePlc();
      LOG.warn("Resetejant ordre de transport: " + row.toString() + " per no haber rebut la confirmació");
    }
    
  }
  
  public XMLDocument getNextOrdTranABorrar()
  {
    XMLDocument xmldoc = null;
    SgaordtranViewRow row = setWhereClauseAndQuery("estado = 'B'");
    if (row != null)
    {
      // Parse un documento de tipo BMOV :TODO - get this from memory
      xmldoc = XMLTelegrama.parseXML("bmov");
      // el único que le importa es el número de la orden
      XMLTelegrama.setNumMovimiento(xmldoc, row.getIdord().intValue());
      if (pruebas)
      {
        // Borrar directamente
        row.remove();
        // El commit se hace después
      }
      else
        row.setPendienteBorrarPlc();
        // NOTE: No commit deliberately
    }
    return xmldoc;
  }
  
  public void borrarOrdTran(XMLDocument xmldoc)
  {
    int idOrdTran = XMLTelegrama.getNumMovimiento(xmldoc);
    SgaordtranViewRow row = queryOrdTran(idOrdTran);
    if (row != null)
     {
        if (row.isPendienteBorrarPlc())
        {
          row.remove();
          commit();
        }
     }
     else
          LOG.error("Borrado de ordtran: " + idOrdTran + " - orden no encontrado");
      
     
  }
  
  /**
   * Buscar la id. de la ubicación del PLC correspondiente a la posición del plc
   * @return 
   * @param posPlc
   */
  private String getIdUbiPlcPos(int posPlc)
  {
    ubicacionPlcView.setWhereClause(null);
    ubicacionPlcView.clearCache();
    ubicacionPlcView.setWhereClause("posplc = " + posPlc);
    ubicacionPlcView.executeQuery();
    SgaubicacionPlcViewRow  row = (SgaubicacionPlcViewRow)ubicacionPlcView.first();
    assert (row != null);
    return row.getIdubi();
  }
  
  /**
   * Pone el where clause y ejecuta el query, devolviendo el first row o null si no hay
   * @return 
   * @param clause
   */
  private SgaordtranViewRow setWhereClauseAndQuery(String clause)
  {
     ordTranView.setWhereClause(null); // Borrar previo
     ordTranView.clearCache();
     am.getTransaction().clearEntityCache(null);
     ordTranView.setWhereClause(clause);
     ordTranView.executeQuery();
     SgaordtranViewRow row = (SgaordtranViewRow)ordTranView.first();  
     return row;
  }
  
  
  /**
   * buscar el row del idOrdTran
   * @return el row encontrado, o null si no existe
   * @param idOrdTran
   */
  private SgaordtranViewRow queryOrdTran (int idOrdTran)
  {
    return setWhereClauseAndQuery("idord = " + idOrdTran);
  }
  /**
   * Comprobar que una orden este pendiente de aceptación
   * El documento ya va de eso
   * Marcarla como aceptada (en curso), si es que se encuentra
   * @return <code>true</code> si ha sido localizada y aceptada la orden...
   * @param xmldoc
   */
  public boolean setAmov(XMLDocument xmldoc)
  {
    boolean retVal = false;
    int idOrdTran = XMLTelegrama.getNumMovimiento(xmldoc);
    int codigoError = XMLTelegrama.getCodigoError(xmldoc);

    if (idOrdTran != 0)
    {
     SgaordtranViewRow row = queryOrdTran(idOrdTran);
     if (row != null)
     {
        if (row.isPendienteAceptacionPlc())
        {
          if (codigoError == 0)
            row.setAceptadoPlc();
          else
            // Ver que tratamientos se pueden dar. Los códigos se registran en el SgaordtranImpl.java
            row.setCoderrorInt (codigoError);
          commit();
          retVal = true;
          if (codigoError != 0)
            LOG.warn ("Ordtran: " + idOrdTran + " con código de error: " + codigoError);
          else
            LOG.info ("Ordtran: " + idOrdTran + " aceptada");
        }
        else
          LOG.warn("Aceptación de ordtran: " + idOrdTran + " sin estar pendiente");
     }
     else
          LOG.error("Aceptación de ordtran: " + idOrdTran + " - orden no encontrado");
      
     
    }
    else
      LOG.error("Aceptación de ordtran con número de orden 0");
    return retVal;
  }
  
  /**
   * Comprobar si se ha recibido un error, incrementando el contador de error si es que sí
   * Si se reciben X, throw exception
   * TODO - los errores sólo vienen en PETI o en FMOV as well !!!
   * @param codigoError
   */
  private void checkErrores(int codigoError)
  {
    if (codigoError != 0)
    {
      if (errorCounter++ > ERRORESATOLERAR)
        throw new RuntimeException("Aturant el proces de gestió d'ordres del PLC per rebre" + ERRORESATOLERAR + " error seguits");
    }
    else
      errorCounter = 0;
  }
  
  /**
   * Tratar llegada de un telegrama AVIS o PETI o FMOV
   * Si es un avis al superar el gálibo, se espera el destino
   * Si es un avis al salir del pasillo, actualiza el mac como salido del pasillo
   * <em>(En este caso, la petición de destino vendrá con el PETI)</em>
   * @return 
   * @param xmldoc
   */
  public boolean setAvisPetiFmov(String tipo, XMLDocument xmldoc)
  {
    int idOrdTran = XMLTelegrama.getNumMovimiento(xmldoc);
    int codigoError = XMLTelegrama.getCodigoError(xmldoc);
    int posAct = XMLTelegrama.getPosAct(xmldoc);
    SgaordtranViewRow row = queryOrdTran(idOrdTran);
    
    // Michael 16.04.2005 look at: Throwable oracle.jbo.AlreadyLockedException
    if (row != null)
    {
      LOG.info ("Telegrama: " + tipo + " Cod. Error: " + codigoError + " Posició: " + posAct + " " + row.toString());

      if (tipo.equals("AVIS"))
      {
        row.setAvis(codigoError, getIdUbiPlcPos(posAct));
      }
      else if (tipo.equals("PETI"))
      {
        checkErrores (codigoError);
        row.setPeti(codigoError, getIdUbiPlcPos(posAct));
      }
      else if (tipo.equals("FMOV"))
      {
        checkErrores (codigoError);
        // Michael 12.07.2006
        String matricula = XMLTelegrama.getMatricula(xmldoc);
        row.setFmov(codigoError, posAct, matricula);
      }
      commit();
      return true;
    }
    else
    {
     LOG.error("Telegrama: " + tipo + " idOrd: " + idOrdTran + "- no s'han trobat dades");
     // Michael 20.04.2005 Aun que no se encuentra, se debe aceptar
     return true;
    }
  }
  
  
  
}