package es.sysmap.interflex.control;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgatrasloViewRow;
import es.sysmap.interflex.model.dmc.common.SgavpasillocandidateViewRow;
import es.sysmap.interflex.model.dmc.common.SgavpasillosintrasloViewRow;
import es.sysmap.interflex.model.dmc.common.SgavtrasloEntSalRow;
import oracle.jbo.ViewObject;

public class ADFGestorCambioPasillo extends ADFGestor
{

  private ViewObject pasilloCandidate;
  private static ADFGestorCambioPasillo _instance = new ADFGestorCambioPasillo();
  private SgavpasillocandidateViewRow pasilloCandidateRow;
  private ViewObject trasloView;
  private ViewObject pasilloSinTraslo;
  private SgavpasillosintrasloViewRow pasilloSinTrasloRow;


  public ADFGestorCambioPasillo()
  {
    connectApplicationModule();
    pasilloCandidate = am.findViewObject("SgavpasillocandidateView1");
    trasloView = am.findViewObject("SgatrasloView1");
    pasilloSinTraslo = am.findViewObject("SgavpasillosintrasloView1");
  }
  
  public static ADFGestorCambioPasillo getInstance()
  {
    return _instance;
  }
  
  private boolean hayCambioEnCurso()
  {
    
    trasloView.clearCache();
    trasloView.executeQuery();
    trasloView.reset();
    while (trasloView.hasNext())
    {
      SgatrasloViewRow row = (SgatrasloViewRow)trasloView.next();
      if (!(row.getPasilloactual().equals(row.getPasillodestino())))
      {
        LOG.trace("Hi ha un canvi de passadis del traslo: " + row.getIdtraslo());
        return true;
      }
    }
    return false;
  }
  
  
  
  
  /**
   * Localizar otro pasillo sin traslo y con trabajo para el traslo
   *      Sólo se cambia el pasillo destino del traslo, para que se empiece a reservar trabajo
   *      en este pasillo
   *      Fallará la reserva si otro traslo tuviera el mismo destino
   *      
   * @param traslo
   * @param trasloRow el traslo a cambiar
   * @param am
   * @param ocupadaSalidaPasilloActual
   * @param hasPendientePasilloActual
   * @return true si se ha cambiado con exito. False si no ha cambiado o no ha ido bien
   */
  public synchronized boolean getNextPasillo(Traslo traslo, 
          SgavtrasloEntSalRow trasloRow, 
          AppModule am,
          boolean ocupadaSalidaPasilloActual,
          boolean hasPendientePasilloActual)
  {
    boolean cambiado = false;
    
    if (hayCambioEnCurso())
      return false;

    // Michael 06.01.2009 - si no se puede cambiar ni por entradas ni por salidas, no vale la pena continuar
    
    if (!trasloRow.isTrasbordoEntrada() && !trasloRow.isTrasbordoSalida())
      return false;
      
    pasilloSinTraslo.clearCache();
    pasilloSinTraslo.executeQuery();
    pasilloSinTraslo.reset();
    while (pasilloSinTraslo.hasNext() && !cambiado)
    {
      pasilloSinTrasloRow = (SgavpasillosintrasloViewRow)pasilloSinTraslo.next();
      if (pasilloSinTrasloRow.isDisponiblePasillo())
      {
          try
          {
          trasloRow.setPasillodestino(pasilloSinTrasloRow.getIdpasillo());
          am.getTransaction().postChanges();  // Para probar en este pasillo
          traslo.queryTraslo();
          // Michael 06.01.2009 if (traslo.buscarTrabajoPasillo(ocupadaSalidaPasilloActual, hasPendientePasilloActual))
          if (traslo.buscarTrabajoPasillo(ocupadaSalidaPasilloActual, hasPendientePasilloActual, trasloRow.isTrasbordoEntrada(), trasloRow.isTrasbordoSalida()))
            cambiado = true;
          }
          catch (oracle.jbo.DMLConstraintException e)
          {
            LOG.error("getNextPasillo:", e);
            am.getTransaction().rollback(); // En el appmodule que llama
            // TODO - si falla el rowset se vuelve a resetear ??
          }
      }
    }
    if (!cambiado)
      // Se habrá hecho un postchange con el pasillo destino para probar
      am.getTransaction().rollback();
    traslo.queryTraslo();
    return cambiado;
    
  }
  
 
  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    ADFGestorCambioPasillo aDFGestorCambioPasillo = new ADFGestorCambioPasillo();
    
  }
}