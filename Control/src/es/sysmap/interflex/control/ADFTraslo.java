package es.sysmap.interflex.control;
import es.sysmap.interflex.model.bdc.Sgaaveria;
import es.sysmap.interflex.model.bdc.SgahistaveriaDefImpl;
import es.sysmap.interflex.model.bdc.SgahistaveriaImpl;
import es.sysmap.interflex.model.dmc.SgavordtranpendtraslosloViewRowImpl;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaventradasCandidateViewRow;
import es.sysmap.interflex.model.dmc.common.SgaventradaspendienteViewRow;
import es.sysmap.interflex.model.dmc.common.SgavestadoentradaslomacViewRow;
import es.sysmap.interflex.model.dmc.common.SgavmacViewRow;
import es.sysmap.interflex.model.dmc.common.SgavordtranpasillotrasloViewRow;
import es.sysmap.interflex.model.dmc.common.SgavordtranpendtrasloextraViewRow;
import es.sysmap.interflex.model.dmc.common.SgavordtranpendtraslosalextraViewRow;
import es.sysmap.interflex.model.dmc.common.SgavordtranpendtraslosloViewRow;
import es.sysmap.interflex.model.dmc.common.SgavordtransalidacursoRow;
import es.sysmap.interflex.model.dmc.common.SgavpuestomanipViewRow;
import es.sysmap.interflex.model.dmc.common.SgavsalidascandidateViewRow;
import es.sysmap.interflex.model.dmc.common.SgavtrasloEntSalRow;
import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.SQLStmtException;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;
import org.apache.log4j.Logger;
import sgalib.MapOraError;

public abstract class ADFTraslo extends SgaProceso
{

  // :TODO - ver de extender de ADFGestor
  private static final String amDef = "es.sysmap.interflex.model.dmc.AppModule";
  private static final String config = "AppModuleLocal";
  private AppModule am;
  private ViewObject trasloEntSal;
  private ViewObject ordtranPasilloTraslo;  
  private ViewObject ordtranSalidaCurso;
  private ViewObject puestoManip;
  private ViewObject entradasCandidate;
  private ViewObject salidasCandidate;
  private ViewObject entradaPendienteSlo;
  private ViewObject entradaPendienteExtra;
  private ViewObject pasillosPosibles;
  private ViewObject entradaPendiente;
  private ViewObject salidaExtra;
  private ViewObject mac;
  private SgavtrasloEntSalRow trasloRow = null;
  private SgavordtranpasillotrasloViewRow ordtranPasilloRow = null;
  private SgavordtransalidacursoRow ordtranSalidaCursoRow = null;
  private SgavpuestomanipViewRow puestoManipRow = null;
  private SgaventradasCandidateViewRow entradasCandidateRow = null;
  private SgavsalidascandidateViewRow salidasCandidateRow = null;
  private SgavordtranpendtraslosloViewRowImpl entradaPendienteSloRow = null;
  private SgavestadoentradaslomacViewRow pasRow;
  private SgavordtranpendtrasloextraViewRow entradaPendienteExtraRow = null;
  private SgaventradaspendienteViewRow entradaPendienteRow = null;
  private SgavmacViewRow macViewRow = null;
  private Timestamp temps = null;
  
  private static final String ORDERBYMLD = "(cappulmld - respulmld)/decode(cappulmld, 0, 1, cappulmld) desc";
  private static final String ORDERBYSLO = "(cappulslo - respulslo)/decode(cappulslo, 0, 1, cappulslo) desc";
  
  private static final String PUESTOMANIPORDERBYSLO = "cappulslo - respulslo desc";
  private static final String PUESTOMANIPORDERBYMLD = "cappulmld - respulmld desc";
  
  
  protected Logger LOG = Logger.getLogger(getClass());
  
  
  protected final int idTraslo;
  protected final String tipTraslo; // Para identificar si es MLD o SLO el traslo
  protected int estadoTraslo;
  
  private ADFGestorCambioPasillo cambioPasillo;

  public ADFTraslo(int idTraslo, String tipTraslo, AppModule am)
  {
  
    super("Traslo " + idTraslo);
    this.idTraslo = idTraslo;
    this.tipTraslo = tipTraslo;
    this.am = am;
    
    LOG.info("instanciant app. mod y vistes del traslo " + idTraslo);
    if (this.am == null)
      this.am = (AppModule)Configuration.createRootApplicationModule(amDef,config);
      
    trasloEntSal = am.findViewObject("SgavtrasloEntSal1");
    trasloEntSal.setWhereClause("idtraslo = " + idTraslo);
    ordtranPasilloTraslo = am.findViewObject("SgavordtranpasillotrasloView1");
    ordtranPasilloTraslo.setWhereClause("Sgatraslo.idTraslo = " + idTraslo);
    // 
    ordtranSalidaCurso = am.findViewObject("Sgavordtransalidacurso1");
    ordtranSalidaCurso.setWhereClause("idTraslo = " + idTraslo);
    puestoManip = am.findViewObject("SgavpuestomanipView1");
    
    // Poner el order by clause según sea para sacar al puesto del mini o maxi load
    if (isMiniload())
      puestoManip.setOrderByClause(ORDERBYMLD);
    else
      puestoManip.setOrderByClause(ORDERBYSLO);
    
    entradasCandidate = am.findViewObject("SgaventradasCandidateView1");
    salidasCandidate = am.findViewObject("SgavsalidascandidateView1");
    
    entradaPendienteSlo = am.findViewObject("SgavordtranpendtraslosloView1");

    entradaPendienteExtra = am.findViewObject("SgavordtranpendtrasloextraView1");
  
    pasillosPosibles = am.findViewObject("SgavestadoentradaslomacView1");
    
    entradaPendiente = am.findViewObject("SgaventradaspendienteView1");

    salidaExtra = am.findViewObject("SgavordtranpendtraslosalextraView1");

    mac = am.findViewObject("SgavmacView1");
    mac.setWhereClause("idmac = :1");
    
    temps = new Timestamp(System.currentTimeMillis());

    LOG.info("instanciat app. mod y vistes del traslo " + idTraslo);
    
    
    
    cambioPasillo = ADFGestorCambioPasillo.getInstance();
    
  }
  
 
  private Row queryAndGetFirstRow(ViewObject view)
  {
    view.clearCache();
    view.executeQuery();
    return view.first();
  }
  
  
  protected void queryTraslo()
  {
    trasloRow = (SgavtrasloEntSalRow)queryAndGetFirstRow(trasloEntSal);
    assert trasloRow != null;
  }
  
  protected boolean isMesaSalidaOcupada()
  {
    return trasloRow.getIdmac() != null;
  }
  
  /**
   * Buscar órdenes de transporte pendiente de traslo / ubicación para el pasillo destino 
   * @return 
   * @param idPasillo != 0 si se quiere buscar en un pasillo determinado deferente del pasillo destino del traslo
   */
  protected SgavordtranpendtraslosloViewRow getEntradaPendiente(Number idPasillo)
  {
    if (idPasillo == null)
      entradaPendienteSlo.setWhereClauseParam(0, trasloRow.getPasillodestino());
    else
      entradaPendienteSlo.setWhereClauseParam(0, idPasillo);
    return (SgavordtranpendtraslosloViewRow)queryAndGetFirstRow(entradaPendienteSlo);
  }

  protected void setEstadoProceso(int estadoProceso)
  {
    queryTraslo();
    String estado = estadoProceso == Traslo.WAITNOINICIALIZADO ? "N" : "F";
    trasloRow.setEstadoproceso(estado);
    commit();
  }
  
  /**
   * actualizar el pasillo del traslo
   * No se puede actualizar el pasillo al mismo que el otro traslo, lo que provoca una excepción de la base de datos
   * 
   * @return true si se ha podido actualizar
   * @param pasillo
   */
  protected boolean setPasilloTraslo(int pasillo)
  {
    queryTraslo();
    boolean actualizado = false;
    try
    {
      if (trasloRow.getPasilloactual().intValue() != pasillo)
      {
        Number numPasillo = new Number (pasillo);
        trasloRow.setPasilloactual(numPasillo);
        // Michael 13.05.2005 Si el pasillo destino es diferente, ponlo como el actual
        // Nota: Si ha aceptado órdenes para el pasillo destino actual, como irán ?
        if (trasloRow.getPasillodestino().intValue() != pasillo)
        {
          LOG.warn("Traslo " + idTraslo + " ha fet un cambi de passadis al " + pasillo + " quan el passadis desti era: " + trasloRow.getPasillodestino().intValue());
          // Michael 13.05.2005 tarde not yet trasloRow.setPasillodestino(numPasillo);
        }
        // Michael 13.05.2005
        commit(); 
      }
      actualizado = true;
    } catch (Exception ex)
    {
      LOG.error("Impossible actualitzar el passadis del traslo: " + idTraslo + " al passadis: " + pasillo, ex);
      rollback();
    }
    return actualizado;
  }
  /**
   * Actualizar el estado del traslo, si es diferente
   * @param estado
   */
  protected void setEstadoTraslo(int estado)
  {
    // Michael 13.05.2005 Esto ya se ha hecho en setPasilloTraslo 
    // trasloRow = (SgavtrasloEntSalRow)queryAndGetFirstRow(trasloEntSal);
    assert trasloRow != null;
    estadoTraslo = (estado & 0x1) == 1 ? Plc.AVERIADO : Plc.LIBRE;  // :TODO - ocupado ?
    
    String estadoStr = (estadoTraslo == Plc.LIBRE) ? "F" : "A"; // en funcionamiento o averiado
    // Bit 2 is auto o no
    // TODO gets decimal 18 (00010010) when the traslo has an order - represent the order the traslo is doing ???
    // The traslo order is in 
    if (!trasloRow.getEstadotraslo().equals(estadoStr))
    {
      //Insertem un registre a l'històric d'averies
      insertarHistoricoEstado();
      trasloRow.setEstadotraslo(estadoStr);
      commit();
    }
    
  }
  
    /**
   * Buscar una salida para el puesto
   * Si encuentra, reserva la salida
   * Devuelve true si lo ha reservado
   * NOTA: Se ha llegado comprobando que hay espacio en el puesto según el tipo de traslo (MLD o SLO)
   *  Ahora se busca por el pasillo (posplc) del traslo
   * La vista hace un select for update. Si está reservado por otro, sale del método
   * :TODO - Sólo se reserva un mac a la vez
   * @param numOrden :TODO - ver si reservar más de una a la vez
   * @param simular Si es true, sólo buscar para ver si hay para el puesto en el pasillo
   * @return 
   */
  private boolean buscarSalidas(boolean simular)
  {
    boolean reservado = false;
    salidasCandidate.clearCache();
    try
    {
      salidasCandidate.setWhereClauseParam(0, puestoManipRow.getIdpuesto());
      salidasCandidate.setWhereClauseParam(1, trasloRow.getPosplc());
      salidasCandidate.executeQuery();
    }
    catch (SQLStmtException esqlstmt)
    {
      if (MapOraError.isOra54(esqlstmt))
      {
        LOG.debug("Traslo " + idTraslo + " - Recurs adquerit per un altre buscant sortidas");
        return false;
      }
      else
      {
        throw esqlstmt;
      }
    }
    salidasCandidate.reset();
    while (salidasCandidate.hasNext() && !reservado)
    {
      // Localizar y reservar el MAC...
      salidasCandidateRow = (SgavsalidascandidateViewRow)salidasCandidate.next();
      if (simular)
      {
        // Tiene material pendiente - si estamos simulando, ya vale
        reservado = true;
        rollback();
        break;
      }
      if (salidasCandidateRow.reservarSalida(idTraslo))
      {
        LOG.info("Reserva: " + salidasCandidateRow.toString());
        // TODO Error here 31.01.2018 Primary_Key Violation on SGARESMAT
        commit();
        reservado = true;
        break;
      }
      else
      {
        LOG.warn("Imposible reservar salida: " + salidasCandidateRow.toString());
        rollback(); // Ya que hace un select for update
      }
    }
    return reservado;
   
  }
  
  public boolean testBuscarEntradas(boolean simular)
  {
    return buscarEntradas(simular);
  }

  
  /**
   * Buscar una entrada para el puesto
   * Si encuentra, reserva la entrada
   * Devuelve true si lo ha reservado
   * NOTA: Se ha llegado comprobando que hay espacio en el puesto según el tipo de traslo (MLD o SLO)
   *  Ahora se busca por el pasillo (posplc) del traslo
   * @return 
   * @param simular Si es true, sólo buscar para ver si hay para el puesto en el pasillo
   */
  private boolean buscarEntradas(boolean simular)
  {
    boolean reservado = false;
    entradaPendiente.clearCache();
    entradaPendiente.setWhereClauseParam(0, puestoManipRow.getIdpuesto());
    // Este query es for update
    try
    {
    entradaPendiente.executeQuery();
    entradaPendiente.reset();
    while (!reservado && entradaPendiente.hasNext())
    {
      entradaPendienteRow = (SgaventradaspendienteViewRow)entradaPendiente.next();
      
      entradasCandidate.clearCache();
      entradasCandidate.setWhereClauseParam(0, entradaPendienteRow.getIddoc());
      entradasCandidate.setWhereClauseParam(1, entradaPendienteRow.getIdlin());
      entradasCandidate.setWhereClauseParam(2, entradaPendienteRow.getIdbulto());
// Michael 02.05.2005      entradasCandidate.setWhereClauseParam(3, trasloRow.getPosplc());
      entradasCandidate.setWhereClauseParam(3, trasloRow.getPasillodestino());
      entradasCandidate.executeQuery();
      entradasCandidate.reset();
      while (entradasCandidate.hasNext() && !reservado)
      {
        if (simular)
        {
          // Tiene material pendiente - si estamos simulando, ya vale
          reservado = true;
          rollback();
          break;
        }
      
        // Localizar y reservar el MAC...
        entradasCandidateRow = (SgaventradasCandidateViewRow)entradasCandidate.next();
        if (entradasCandidateRow.reservarEntrada(idTraslo))
        {
          LOG.info("Reserva: " + entradasCandidateRow.toString());
          commit();
          reservado = true;
          break;
        }
        else
        {
          LOG.warn("Imposible reservar entrada: " + entradasCandidateRow.toString());
        }
      }
    }
    }    
    catch (SQLStmtException esqlstmt)
    {
      if (MapOraError.isOra54(esqlstmt))
      {
        LOG.debug("Traslo " + idTraslo + " - Recurs adquerit per un altre buscant entradas");
        rollback();
      }
      else
      {
        throw esqlstmt;
      }
    }

  if (!reservado)
    rollback();
  return reservado;
   
  }
  
  /**
   * Ver si el puesto extra está abierto
   * @return 
   */
  protected boolean isExtraAbierto()
  {
    puestoManip.clearCache();
    puestoManip.executeQuery();
    puestoManip.reset();
    while (puestoManip.hasNext())
    {
      puestoManipRow = (SgavpuestomanipViewRow)puestoManip.next();
      if (puestoManipRow.isExtraAbierto())
        return true;
    }
    return false;
 
  }
  
  protected boolean buscarOrdenNuevo()
  {
    boolean reservado = false;
    puestoManip.setRangeSize(-1);
    puestoManip.clearCache();
    puestoManip.executeQuery();
    puestoManip.setOrderByClause(isMiniload() ? PUESTOMANIPORDERBYMLD : PUESTOMANIPORDERBYSLO);
    puestoManip.reset();
    // Recuper todos los rows porque dentro puede haber commit/rollback
    Row [] rows = puestoManip.getAllRowsInRange();
    for (int i = 0; i < rows.length && !reservado; i++)
    {
      puestoManipRow = (SgavpuestomanipViewRow)rows [i];
      int numMacs = puestoManipRow.getNumMacsQueCaben(tipTraslo);
      if (numMacs > 0 && puestoManipRow.isAbiertoPuesto())
      {
        reservado = buscarSalidas(false);
        if (!reservado)
          // Ver si hay entradas
          reservado = buscarEntradas(false);
      }
    }
    return reservado;
    
  }
  
  protected boolean hasEntradasCurso()
  {
    entradaPendienteSlo.setWhereClauseParam(0, trasloRow.getPasilloactual());
    entradaPendienteSlo.setWhereClauseParam(1, new Number(idTraslo)); // Ya asignados a este traslo
    entradaPendienteSlo.clearCache();
    entradaPendienteSlo.executeQuery();
    entradaPendienteSlo.reset();
    return entradaPendienteSlo.hasNext();

  }
   
  /**
   * Buscar órdenes de entrada al silo que no tienen traslo asignado (ya tienen hueco)
   * @return true si se ha encontrado algo
   * @param doCommit
   * @param idPasillo donde buscar si es diferente del pasillo destino del traslo
   */
  public boolean buscarEntradaContainer(Number idPasillo, boolean doCommit)
  {
    if (idPasillo == null)
      idPasillo = trasloRow.getPasillodestino();
    entradaPendienteSlo.setWhereClauseParam(0, idPasillo);
    entradaPendienteSlo.setWhereClauseParam(1, new Number(0)); // Los que no tienen traslo 
    entradaPendienteSlo.clearCache();
    entradaPendienteSlo.executeQuery();
    entradaPendienteSlo.reset();
    boolean asignadoTraslo = false;
    
    while (entradaPendienteSlo.hasNext())
    {
      SgavordtranpendtraslosloViewRow row = (SgavordtranpendtraslosloViewRow)entradaPendienteSlo.next();
      row.setTraslo(idTraslo);
      asignadoTraslo = true;
    }
    
    if (asignadoTraslo && doCommit)
        commit();
    
    return asignadoTraslo;
  }
  
  /**
   * Buscar ordenes de transporte de salida por la extra desde otro pasillo que no tiene traslo
   * Sólo si el traslo está en el pasillo 1
   * @return true si se reserva el traslo
   */
  public boolean buscarSalidaExtraSinTraslo()
  {
    boolean retval = false;
    if (!isPasillo1())
      return false;
    
    salidaExtra.clearCache();
    salidaExtra.executeQuery();
    salidaExtra.reset();
    while (salidaExtra.hasNext())
    {
      SgavordtranpendtraslosalextraViewRow row = (SgavordtranpendtraslosalextraViewRow)salidaExtra.next();
      row.asignarOrdenTraslo(idTraslo);
      retval = true;
    }
    if (retval)
      commit();
    
    return retval;
  }
  
  
  protected boolean isPasillo1()
  {
    if (trasloRow.getPasillodestino().intValue() == 1)
      return true;
    else
      return false;
    
  }
  
  protected int getPasillo()
  {
    return trasloRow.getPasilloactual().intValue();
  }
  
  /**
   * Si hay un mac pendiente en la entrada extra, buscale un pasillo destino
   * Si el pasillo destino es el 1, dadle ya sus coordenadas
   * Si no, envia el mac a la entrada pasillo correspondiente
   * TODO: Se puede enviar a un pasillo que después no tendrá huecos libres ??
   * Preconditions: Hay traslo en el pasillo 1
   * 
   * @return 
   */
  protected boolean buscarEntradaContenidorExtra()
  {
    boolean gotPasillo = false;
    
    if (!isPasillo1())
      return false;

    // Michael 09.05.2005
    am.getTransaction().clearEntityCache(null);
    // Michael 09.05.2005 fin
    entradaPendienteExtraRow = (SgavordtranpendtrasloextraViewRow)queryAndGetFirstRow(entradaPendienteExtra);
    if (entradaPendienteExtraRow != null)
    {
      // Hay un mac esperando
      // TODO - código más o menos repitido de ADFSalidaPuestoSLO
      pasillosPosibles.clearCache();
      pasillosPosibles.setWhereClauseParam(0, entradaPendienteExtraRow.getIdmac());
      pasillosPosibles.executeQuery();
      pasillosPosibles.reset();
      // Los pasillos vienen ordenadas de min existencias para este mac
      while (pasillosPosibles.hasNext() && !gotPasillo)
      {
        SgavestadoentradaslomacViewRow pasilloEntradaRow = (SgavestadoentradaslomacViewRow)pasillosPosibles.next();
        boolean isThisPasillo = pasilloEntradaRow.getIdpasillo().equals(trasloRow.getPasillodestino());
        if ((isThisPasillo || pasilloEntradaRow.hasEspacioPulmon())
            && pasilloEntradaRow.hasHuecosLibres() 
            && pasilloEntradaRow.isWorkingPasillo() 
            && pasilloEntradaRow.isWorkingTraslo())
            {
/* Michael 07.05.2005 En todos los casos, registrar la ubicación final del mac para que quede reservada
 * La primera parte se hace con este traslo
              if (isThisPasillo)
              {
                // Es el pasillo del traslo - reserva un hueco directamente
                gotPasillo = pasilloEntradaRow.setUbicacionDestinoMac(trasloRow.getIdtraslo());
                if (!gotPasillo)
                  LOG.error("No s'ha pogut encaminar l'ordre d'entrada desde la extra del contenidor: " + entradaPendienteExtraRow.getIdmac());
                else
                  commit();
              }
              else
              {
                pasilloEntradaRow.setUbicacionPasilloEntradaMac(trasloRow.getIdtraslo());
                commit();
                gotPasillo = true;
              }
*/
             gotPasillo = pasilloEntradaRow.setUbicacionDestinoMac(trasloRow.getIdtraslo());

            }
      }
      if (!gotPasillo)
        LOG.error("No s'ha pogut encaminar l'ordre d'entrada desde la extra del contenidor: " + entradaPendienteExtraRow.getIdmac());
      else
        commit();
      }

  return gotPasillo; 
  }
  
  private void asignarTraslo(SgavordtranpasillotrasloViewRow row)
  {
      ordtranPasilloRow.asignarOrdenTraslo(idTraslo);
      commit();
      LOG.info ("Ordre: " + ordtranPasilloRow.getIdord() + " asignat al traslo: " + idTraslo);
  }
  
  /**
   * TODO - 11.01.2007 Refactor to remove duplicates...
   * @return 
   */
  protected boolean asignarNextOrdenPendienteMLD()
  {
    boolean asignado = false;
    ordtranPasilloTraslo.clearCache();
    ordtranPasilloTraslo.executeQuery();
    ordtranPasilloTraslo.reset();
    if (ordtranPasilloTraslo.getRowCount() > 1)
    {
    
      // Michael 12.01.2007 Si hay una orden de reubicación, activala primero
      // sin agrupar con otros..
      for (int i = 0; i < 2; i++) 
      {
        ordtranPasilloRow = (SgavordtranpasillotrasloViewRow)ordtranPasilloTraslo.next();
        if (ordtranPasilloRow.isOrdenReubicacion())
        {
          ordtranPasilloRow.asignarOrdenTraslo(idTraslo);
          ordtranPasilloRow.setSeqmld(new Number (0));
          asignado = true;
          LOG.info ("Ordre (reubicació): " + ordtranPasilloRow.getIdord() + " asignat al traslo: " + idTraslo);
          commit();
          break;
        }
      }
    
      if (!asignado)
      {
        ordtranPasilloRow = (SgavordtranpasillotrasloViewRow)ordtranPasilloTraslo.first();
        ordtranPasilloRow.asignarOrdenTraslo(idTraslo);
        ordtranPasilloRow.setSeqmld(new Number (1));
        LOG.info ("Ordre: " + ordtranPasilloRow.getIdord() + " asignat al traslo: " + idTraslo);
        
        ordtranPasilloRow = (SgavordtranpasillotrasloViewRow)ordtranPasilloTraslo.next();
        ordtranPasilloRow.asignarOrdenTraslo(idTraslo);
        ordtranPasilloRow.setSeqmld(new Number (2));
        asignado = true;
        LOG.info ("Ordre: " + ordtranPasilloRow.getIdord() + " asignat al traslo: " + idTraslo);
        commit();
      }
      
    }
    else
    {
      ordtranPasilloRow = (SgavordtranpasillotrasloViewRow)ordtranPasilloTraslo.first();
      if (ordtranPasilloRow != null)
      {
        ordtranPasilloRow.asignarOrdenTraslo(idTraslo);
        ordtranPasilloRow.setSeqmld(new Number (0));
        asignado = true;
        LOG.info ("Ordre: " + ordtranPasilloRow.getIdord() + " asignat al traslo: " + idTraslo);
        commit();
      }
    }
    
    return (asignado);
  }
    

  protected boolean asignarNextOrdenPendiente()
  {
    // TODO: Se estan ordenando las órdenes ???
    ordtranPasilloRow = (SgavordtranpasillotrasloViewRow)queryAndGetFirstRow(ordtranPasilloTraslo);
    if (ordtranPasilloRow != null)
    {
      asignarTraslo(ordtranPasilloRow);
      return true;
    }
    else
      return false;
  }
  
  
  protected boolean isCambioPasilloEnCurso()
  {
    if (!trasloRow.getPasilloactual().equals(trasloRow.getPasillodestino()))
      return true;
    else
      return false;
  }
 
 
  /**
   * <code>true</code> si el pasillo (destino) está en funcionamiento
   * @return 
   */
  protected boolean isWorkingPasillo()
  {
    if (trasloRow.getestadoPasillo().equals("1"))
      return true;
    else
      return false;
  }
   
  
  public void commit()
  {
    am.getTransaction().commit();
  }
  
  public void rollback()
  {
    am.getTransaction().rollback();
  }
  
  public boolean isTrasloBloqueadoEnPasillo()
  {
    return (am.IsTrasloBloqueadoEnPasillo(idTraslo));
  }
  
  /**
   * Ver si el traslo tiene una orden de salida en curso en este momento
   * Si es el miniload y sólo tiene una, devuelve false
   * @return <code>true</code> si tiene una orden en curso, <code>false</code> si no
   */
  public boolean hasSalidaCurso()
  {
    ordtranSalidaCursoRow = (SgavordtransalidacursoRow)queryAndGetFirstRow(ordtranSalidaCurso);
    if (ordtranSalidaCursoRow != null)
    {
      // En el miniload, se permiten hasta 2 - 05.05.2005 Desactivado por error 14 en el envío de las órdenes
//      if (isMiniload() && (ordtranSalidaCurso.getRowCount() < 2))
//        return false;
      return true;
    }
    else
      return false;
    
  }

 
  /**
   * Buscar el siguiente pasillo para el traslo en el caso que no tenga trabajo
   * Si todavia puede hacer algo en el pasillo actual, no cambia
   * TODO: Puede dejar un puesto sin suministro porque otro todavia tiene trabajo pendiente
   * NOTA: Se actualiza pasillo destino del traslo para que se reserve una operación en el pasillo
   * :TODO 18.05.2005 Si llega aquí no puede hacer nada en el puesto actual
   * Se debería mirar otro pasillo donde pueda hacer una entrada o salida (automático o manual)
   * @return true si ha marcado el traslo para un cambio de pasillo
   */
 protected boolean getNextPasillo(Traslo traslo, boolean mesaSalidaOcupada)
 {
  // 20.03.2019 Query traslo ya que puede haber sido cambiado por el usuario
  queryTraslo();
  
  if (cambioPasillo.getNextPasillo(traslo, trasloRow, am, mesaSalidaOcupada, hasPendientePasillo()))
   {
     queryTraslo();
     return true;
   }
   else
    return false;
 }
 

 
 /**
   * Sólo salir del pasillo actual si, para los puestos abiertos:
   * No se puede sacar más (salidas o entradas) del pasillo actual
   * @return true si se puede hacer algo en el pasillo (aunque los puestos no tengan sitio)
   */
  protected boolean hasPendientePasillo()
  {
    boolean reservado = false;
    puestoManip.setRangeSize(-1);
    puestoManip.clearCache();
    puestoManip.executeQuery();
    puestoManip.reset();
    // Recuper todos los rows porque dentro puede haber commit/rollback
    Row [] rows = puestoManip.getAllRowsInRange();
    for (int i = 0; i < rows.length && !reservado; i++)
    {
      puestoManipRow = (SgavpuestomanipViewRow)rows [i];
      int numMacs = puestoManipRow.getNumMacsQueCaben(tipTraslo);
      if (puestoManipRow.isAbiertoPuesto()) // Aunque no tenga espacio
      {
        reservado = buscarSalidas(true); // simulando
        if (!reservado)
          // Ver si hay entradas
          buscarEntradas(true); // simulando
      }
    }
    return reservado;
   
  }
  
  protected boolean isMiniload()
  {
    return idTraslo == 0;
  }
  
  private void insertarHistoricoEstado()
  {
    Sgaaveria averia = new Sgaaveria();
    averia.setIdtraslo(new Number(idTraslo));
    averia.setTemps(secondsBetween(new Timestamp(System.currentTimeMillis()), temps));
    temps = new Timestamp(System.currentTimeMillis()); //Inicialitzem el temporitzador
    averia.setEstado(trasloRow.getEstadotraslo());
    averia.setPasilloActual(trasloRow.getPasilloactual());
    averia.setPasilloDestino(trasloRow.getPasillodestino());
    if (hasSalidaCurso())
    {
      averia.setIdord(ordtranSalidaCursoRow.getIdord());
      mac.setWhereClauseParam(0, ordtranSalidaCursoRow.getIdmac());
      macViewRow = (SgavmacViewRow)queryAndGetFirstRow(mac);
      if (macViewRow != null)
      {
        averia.setUbiori(macViewRow.getUbipos());
        averia.setPosUbiOri(macViewRow.getPosubipos());
        averia.setUbides(macViewRow.getUbides());
        averia.setPosUbiDes(macViewRow.getPosubides());
      }
    }
    // Insertem el registre corresponent a l'històric    
    SgahistaveriaDefImpl histaveria = (SgahistaveriaDefImpl)SgahistaveriaImpl.getDefinitionObject();
    histaveria.crearHistoric((DBTransaction)am.getTransaction(), averia);
  }
  
  private Number secondsBetween(final Timestamp first, final Timestamp second) {
   
    long deltaMillis = first.getTime() - second.getTime();
    return new Number(deltaMillis / (1000));  
  }
  

}