package es.sysmap.interflex.control;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.xml.XMLTelegrama;
import java.util.Observable;
import java.util.Observer;
import oracle.jbo.AlreadyLockedException;
import oracle.jbo.ApplicationModule;
import oracle.jbo.DMLConstraintException;
import oracle.jbo.common.Configuration;
import oracle.xml.parser.v2.XMLDocument;
import org.apache.log4j.Logger;
import sgalib.SgaUtilPuesto;

public class Traslo extends ADFTraslo implements Observer, TimeOutListener
{


  public static final int  WAITNOINICIALIZADO = 1;
  public static final int WAITFUNCIONAMIENTO = 2;
  public static final int WAITORDENACEPTADA = 3;
  
  

  private boolean eTimeOut = false;
  private boolean eConfirmarOrden = false;
  private boolean eFinalOrden = false;
  private boolean eUpdateEstado = false;
  private boolean ePing = false;
 
  private int estadoProceso;
  
  private State waitNoInicializado = new WaitNoInicializado();
  private State waitOrdenAceptada = new WaitOrdenAceptada();
  private State waitFuncionamiento = new WaitFuncionamiento();

  private boolean buscarTrabajo;
  
  private TimeOutTimer timer;

  
  /**
   * Contar a n antes de mirar si se debe hacer un cambio de pasillo
   */
  private int cambioCounterPasillo;
  
  /**
   * Contar a n antes de hacer un cambio de pasillo para guardar palets en cabecera pasillo
   */
  private int cambioCounterEntradas;  
  /**
   * El estado del puente de trasbordo
   */
  private int estadoPuente;

  
  public Traslo(int idTraslo, String tipTraslo, AppModule am)
  {
    super(idTraslo, tipTraslo, am);
    init();
  }
  
  
 
  protected void resetAllEvents ()
  {
    eTimeOut = false;
    eConfirmarOrden = false;
    eFinalOrden = false;
    eEndProcess = false;
    eUpdateEstado = false;
    ePing = false;
  }
 
  

  public void init()
  {
    // Si es miniload, buscar feina cada segundo
    int timeOut = isMiniload() ? 1000 : 5000;
    
    timer = new TimeOutTimer(this, timeOut);
    if (SgaUtilPuesto.isTesting())
    {
      LOG.warn("Engegant proces del traslo " + idTraslo + " en pruebas");
      estadoProceso = WAITFUNCIONAMIENTO;
      estadoTraslo = Plc.LIBRE;
      estadoPuente = 2;
    }
    else
    {
      setEstadoProceso(WAITNOINICIALIZADO);
      estadoTraslo = Plc.DESCONOCIDO;
      estadoPuente = -1;
    }
    buscarTrabajo = true;
    cambioCounterPasillo = 0;
    cambioCounterEntradas = 0;
    
  }
  
  private boolean isAvailablePuente()
  {
    LOG.trace("Estat pont de trasbord: " + estadoPuente + " per el traslo: " + getName());
    return estadoPuente == 2;
  }
  
  private synchronized void updateEstadoProceso ()
  {
    if (!eEndProcess)
    {
      try
      {
        switch (estadoProceso)
        {
          case WAITNOINICIALIZADO:
            waitState (waitNoInicializado);
            break;
          case WAITFUNCIONAMIENTO:
            waitState (waitFuncionamiento);
            break;
          case WAITORDENACEPTADA:
            waitState (waitOrdenAceptada);
            break;
        }
       }
      catch (InterruptedException e) 
      { 
        eEndProcess = true;
      }
    }
  }


  /**
   * Buscar trabajo para el miniload
   * Separado de buscarTrabajo el 18.05.2005
   * @return 
   */
  private boolean buscarTrabajoMiniload()
  {
      if (estadoTraslo != Plc.LIBRE)
        return false;
      if (!isWorkingPasillo())
        return false;
      
      if (hasSalidaCurso())
        return false;

      if (asignarNextOrdenPendienteMLD())
        return true;
  
      // Si es el miniload, buscar 2 órdenes
      if (buscarOrdenNuevo())
      {
        // Michael 05.05.2005 Si es el miniload, buscar una segunda orden
        // 05.05.2005 Desactivado ya que se producen errores 14 en en envío de la orden al plc
        // TODO 01.12.2006 Activar para doble cubeta
        buscarOrdenNuevo();
        return true;
      }
      
      return false;
  }
  
  // Michael 19.12.2007
  public void test()
  {
    estadoTraslo = Plc.LIBRE;
    buscarTrabajo();
    // boolean reservado = testBuscarEntradas(false);
  }
  
  
  private boolean buscarTrabajo()
  {
    boolean asignado = false;
    if (estadoTraslo != Plc.LIBRE)
      return false;
    if (!isWorkingPasillo())
      return false;
    // TODO: Debe alternar entradas y salidas
    
    // Asignar entradas de contenedores que están sin traslo
    boolean retval = buscarEntradaContainer(null, true);
    // Asignar entrada desde la extra si el traslo está en el pasillo 1
    asignado = buscarEntradaContenidorExtra();
    asignado = asignado || retval;
    // Asignar salidas por la extra si el traslo está en el pasillo 1
    retval = buscarSalidaExtraSinTraslo();
    asignado = asignado || retval;

    if (hasSalidaCurso())
      return asignado;

    // 18.05.2005
    boolean mesaSalidaOcupada = isMesaSalidaOcupada();
    if (! mesaSalidaOcupada)
    {
      if (asignarNextOrdenPendiente())
        return true;

      // Si es el miniload, buscar 2 órdenes
      if (buscarOrdenNuevo())
      {
        return true;
      }
    }
    
    // Si ha asignado en el pasillo actual, no buscar de cambiar de pasillo
    if (asignado)
      return true;
    
    // Michael 20.05.2005 Si estamos en el pasillo 1, no cambiar si el puesto extra está en marcha
    

    // Si ha llegado aquí es que no tiene nada que hacer en este pasillo
    if (cambioCounterPasillo++ < 10)
      return false;
      
    if (isTrasloBloqueadoEnPasillo())
    {
      LOG.warn("El traslo: " + idTraslo + " no surt del passadis: " + getPasillo() + " per bloqueig manual");
      return false;
    }
      
    cambioCounterPasillo = 0;
 
    if (isCambioPasilloEnCurso())
      return false;
 
    if (!isAvailablePuente())
      return false;
    
    // Michael 08.05.2005 No cambiar hasta que haya ubicado lo que hay en curso
    if (hasEntradasCurso())
      return false;

    // 20.05.2005 Si estamos en el pasillo 1 y la extra está abierta, no cambiar de pasillo
    if (isPasillo1() && isExtraAbierto())
    {
      LOG.info ("El traslo " + idTraslo + " no surt del passadis 1 per ser activa la entrada extra");
      return false;
    }
    
    return getNextPasillo(this, mesaSalidaOcupada);
  }

  /**
   * buscar trabajo en un pasillo
   * El traslo tendrá el pasillo destino asignado (con un postChange)
   * Se intenta asignarle algún trabajo en el pasillo destino
   * Se da por supuesto que el traslo no tiene salidas en curso
   * Se hará el commit cuando se asigna la orden al traslo
   * Michael 06.01.2009 Añadir tratamiento de no cambiar por entradas o por salidas
   * @param ocupadaSalidaPasilloActual para que no se haga el cambio simplemente porque no puede realizar una salida
   * @param hasPendientePasillo si hay trabajo pendiente en el pasillo actual (previo)
   * @return true si se ha asignado algo
   */
  public boolean buscarTrabajoPasillo(boolean ocupadaSalidaPasilloActual, boolean hasPendientePasillo, boolean okTrasbordoEntrada, boolean okTrasbordoSalida)
  {
    boolean retval = false;
    boolean asignado = false;
    
    
    
    if (okTrasbordoEntrada)
    {
      retval = buscarEntradaContainer(null, true);
      asignado = retval;
      retval = buscarEntradaContenidorExtra();
      asignado = asignado || retval;
      
    }
    else
          LOG.info ("El traslo " + idTraslo + " no surt del passadis actual per ser bloquejat de trasbordo de entrades (mirant sortides)");

    // Michael 06.01.2009 Was continuing here even if asignado
    if (asignado)
      return true;
      
    if (okTrasbordoSalida)
    {
    retval = buscarSalidaExtraSinTraslo();
    asignado = asignado || retval;
    if (!isMesaSalidaOcupada())
    {
      if (asignarNextOrdenPendiente())
      {
        return true;
      }
      if (!ocupadaSalidaPasilloActual || !hasPendientePasillo)
        // Sólo buscar una orden nueva si el pasillo actual (anterior) del traslo no tiene trabajo
        if (buscarOrdenNuevo())
        {
          return true;
        }
    }
    }
    else
          LOG.info ("El traslo " + idTraslo + " no surt del passadis actual per ser bloquejat de trasbordo de sortides");

   return asignado;
  }

  public void run()
  {
    LOG.info("Arrancando proceso del traslo: " + idTraslo);
    resetAllEvents();
    init();

    try
    {
      PlcStatus plcInstance = PlcStatus.getInstance();
      if (plcInstance == null)
      {
        LOG.fatal("La instancia de plcStatus no está arrancadado");
          throw new RuntimeException ("No se ha trobat la instancia del proces plcStatus");
      }
      PlcStatus.getInstance().addObserver(this);
      
      button.setProcessStarted();

      while (!eEndProcess)
      {
        try
        {
          updateEstadoProceso();
        }
        catch (AlreadyLockedException alreadyE)
        {
          LOG.error("Registre bloquejat per el traslo " + idTraslo, alreadyE);
          rollback();
        }
        // 19.05.2005
        catch (DMLConstraintException constraintE)
        {
          // Cuando intenta insertar una nueva orden antes que el anterior haya sido borrado
          LOG.error("Error DML pel traslo " + idTraslo, constraintE);
          rollback();
        }
      }

    } catch (Exception e)
    {
      LOG.fatal("Proceso traslo parando por error:", e);
      button.setProcessStopped(e);
      // Michael 11.05.2005
      rollback();
    }
    String motivo = "Aturant el proces del traslo " + idTraslo;
    LOG.warn(motivo);
    button.setProcessStopped(motivo);
    setEstadoProceso(WAITNOINICIALIZADO);

  }

  /**
   * Bucle principal del autómata de gestión del traslo
   * @throws java.lang.InterruptedException
   * @param state
   */
  private synchronized void waitState (State state) throws InterruptedException
  {      
    state.onEntry();
    while (!state.isEvent() && !ePing && !eEndProcess)
    {
      wait();
      // Si es un ping, saca is alive message y continua
    }
    testPing();
    
    queryTraslo();
    
    state.action();
    state.onExit();
  }

  private String getStringEstado()
  {
    return getStringEstado (estadoProceso);
  }

  private String getStringEstado (int estado)
  {
    switch (estado)
    {
      case WAITNOINICIALIZADO: return "Sin inicializar";
      case WAITFUNCIONAMIENTO: return "En funcionamiento";
      case WAITORDENACEPTADA: return "Esperando aceptación orden";
      default: return "Estado desconocido (" + estado + ")";
    }
  }
  
    /**
   * Actualiza el estado
   * Si el estado tiene definido entry actions, se realizan aquí
   * Si el estado tiene definido exit actions, se realizan aquí
   */
  protected void setEstadoProceso (int newEstado)
  {
    LOG.info("Actualizando estado proceso  " + getName() + " " + getStringEstado() + " -> "  + getStringEstado(newEstado));
    estadoProceso = newEstado; 
    super.setEstadoProceso(estadoProceso);
  }



  /**
   * Recibir mensajes del gestor del estado del PLC (Telegramas)
   * Si no está inicializado el traslo, inicializalo si se ha podido actualizar el pasillo
   * Michael 13.05.2005 synchronized added to prevent nummPointerError when called from PlcStatus
   * @param arg
   * @param o
   */
  public synchronized void update(Observable o, Object arg)
  {
    assert (arg instanceof XMLDocument);
    XMLDocument xmldoc = (XMLDocument)arg;
    boolean setOk = false;
    
    if (idTraslo != 0)
    {
      // Sólo actualiza si se ha podido actualizar el pasillo del traslo
      setOk = setPasilloTraslo(XMLTelegrama.getPasilloTraslo(xmldoc, idTraslo));
      // Aprovecha para el estado del puente
      estadoPuente = XMLTelegrama.getEstadoPuente(xmldoc);
      
    }
    else
      // Es el miniload
      setOk = true;
    
    // Michael 20.05.2005 Raras veces se da un NullPointerException en esto
      //    ERROR 2005-05-20 07:02:22,234 [Thread-8] run {PlcStatus.java:116} - Proces PlcStatus:
      //java.lang.NullPointerException
      //	at oracle.jbo.server.ViewRowSetImpl.initQueryCollection(ViewRowSetImpl.java:473)
      //	at oracle.jbo.server.ViewRowSetImpl.execute(ViewRowSetImpl.java:652)
      //	at oracle.jbo.server.ViewRowSetImpl.executeQueryForMasters(ViewRowSetImpl.java:769)
      //	at oracle.jbo.server.ViewRowSetImpl.executeQuery(ViewRowSetImpl.java:706)
      //	at oracle.jbo.server.ViewObjectImpl.executeQuery(ViewObjectImpl.java:3363)
      //	at es.sysmap.interflex.control.ADFTraslo.queryAndGetFirstRow(ADFTraslo.java:123)
      //	at es.sysmap.interflex.control.ADFTraslo.setPasilloTraslo(ADFTraslo.java:164)
      //	at es.sysmap.interflex.control.Traslo.update(Traslo.java:317)
      //	at java.util.Observable.notifyObservers(Unknown Source)
      //	at sgalib.MapObservable.notifyObservers(MapObservable.java:31)
      //	at es.sysmap.interflex.control.PlcStatus.accionMensajeNuevo(PlcStatus.java:171)
      //	at es.sysmap.interflex.control.PlcStatus.run(PlcStatus.java:107)
      //	at java.lang.Thread.run(Unknown Source)
      
    // Entonces un BIG try and catch

    try 
    {
    setEstadoTraslo(XMLTelegrama.getEstadoTraslo(xmldoc, idTraslo));
    if (setOk)
      setUpdateEstado();
      
    }
    catch (Exception e)
    {
      LOG.error("Exception en Traslo#update:", e);
    }

  }
  
  public synchronized void setUpdateEstado()
  {
    eUpdateEstado = true;
    notifyAll();
  }
  
  public synchronized void setTimeOut()
  {
    eTimeOut = true;
    notifyAll();
  }
  
  /**
   * Realizar un ping al proceso
   * TODO: Si el proceso está bloqueado, se quedará bloqueado aquí también
   */
  public synchronized void pingProcess()
  {
    ePing = true;
    if (!isAlive())
        LOG.debug("Ping del traslo: " + idTraslo + " Estado: [" + getStringEstado() + "] PROCESO PARADO");
    notifyAll();
  }
  
  public synchronized void stopProcess () 
  {
    eEndProcess = true;
    notifyAll ();
  }

  public void setBuscarTrabajo (boolean activar) { buscarTrabajo = activar;}
  
  
  /**
   * Si se ha solicitado un ping, resetea la solicitud y sacar un mensaje del proceso
   * @return true si se ha activado el ping, false sino
   */
  private boolean testPing()
  {
    if (ePing)
    {
      ePing = false;
      LOG.debug("Ping del traslo: " + idTraslo + " Estado proceso: [" + getStringEstado() + "] proceso en marcha ?: " 
        + isAlive() + " Estado traslo: " + Plc.getStringElementState(estadoTraslo));
      return true;
    }
    return false;
  }
  
    class WaitOrdenAceptada implements State
    {
      public WaitOrdenAceptada()
      {
        
      }
      
      public boolean isEvent()
      {
        return (eTimeOut || eUpdateEstado);
      }
      
      public void onEntry()
      {
        
      }
      
      public void onExit()
      {
        
      }
      
      public void action()
      {
        
      }
    }
  
    class WaitNoInicializado implements State
    {
      public WaitNoInicializado ()
      {
        
      }
      
      public boolean isEvent()
      {
        return (eTimeOut || eUpdateEstado);
      }
      
      public void onEntry()
      {
        
      }
      
      public void onExit()
      {
        
      }
      
      public void action()
      {
        if (eEndProcess) return;
        if (eUpdateEstado)
        { 
          eUpdateEstado = false;
          setEstadoProceso(WAITFUNCIONAMIENTO);
        }
        if (eTimeOut) eTimeOut = false;
      }
    }
  
  
  class WaitFuncionamiento implements State
  {
    public WaitFuncionamiento()
    {
      
    }
    
    public boolean isEvent()
    {
      return (eTimeOut || eUpdateEstado);
    }
    
    public void onEntry()
    {
      
    }
    
    public void onExit()
    {
      
    }
    
    public void action()
    {
      if (eTimeOut || eUpdateEstado)
      {
        eTimeOut = false;
        eUpdateEstado = false;
        // 19.05.2005
        if (isMiniload())
          buscarTrabajoMiniload();
        else
        {
          if (buscarTrabajo())
            {
            // Si encontramos algo, resetear el cambio counter
            cambioCounterPasillo = 0;
            cambioCounterEntradas = 0;
            }
        }
      }
      
    }
  }
  
 public static void main(String[] args)
 {
 
 String        amDef = "es.sysmap.interflex.model.dmc.AppModule";
      String        config = "AppModuleLocal";
      AppModule appModule = (AppModule)Configuration.createRootApplicationModule(amDef,config);
  Traslo testTraslo = new Traslo (2, "SLO", appModule);
  testTraslo.test();
  // ...
 }
  
  
}