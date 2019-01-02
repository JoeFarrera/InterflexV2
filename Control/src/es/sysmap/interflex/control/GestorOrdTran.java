package es.sysmap.interflex.control;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.xml.XMLHelper;
import es.sysmap.xml.XMLTelegrama;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import oracle.jbo.RowInconsistentException;
import oracle.xml.parser.v2.XMLDocument;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import sgalib.SgaUtilPuesto;

public class GestorOrdTran extends SgaProceso implements Observer, TimeOutListener
{

  private Logger LOG = Logger.getLogger(getClass());

  private static final int MAX_MENSAJES_PEND = 100; // Max mensajes que se pueden almacenar por el proceso
  
  private static final int TIMEOUT = 1000;  // (5000) Tiempo se timeout para el ciclo
  private static final int  WAITNOINICIALIZADO = 1;
  private static final int WAITFUNCIONAMIENTO = 2;
  private static final int WAITORDENACEPTADA = 3;
  
  

  private boolean eTimeOut = false;
  private boolean ePing = false;
  private boolean eMensajeNuevo = false;
 
  private int estadoProceso;
  private boolean inicializado; // Se ha recibido algo
  private boolean inicTeleSent;  // Se ha podido enviar el inic
  
  private State waitFuncionamiento = new WaitFuncionamiento();
  private State waitNoInicializado = new WaitNoInicializado();

  
  private TimeOutTimer timer;
  private GestorDatos gestorPlc;
  
  private ADFOrdTran ordTran;
  
  private final List mensajesPend = new ArrayList();  // Lista de mensajes pendientes de leer
  private boolean ordenPendienteConfirmar;  // Indicar que hay una orden pendiente de confirmar para no enviar más
  private int ordenPendienteCounter = 0;  // Contador para time out esperando la aceptación de una orden
  
  private boolean pruebas;

  
  public GestorOrdTran()
  {
    super ("Gestor ordres de transport");
    gestorPlc = null;
    init();
  }
  
  private boolean addMensaje(XMLDocument xmldocIn)
  {
    if (mensajesPend.size() >= MAX_MENSAJES_PEND)
      return false;
    mensajesPend.add(xmldocIn);
    eMensajeNuevo = true;
    notifyAll();
    return true;
  }
  
    protected void resetAllEvents ()
  {
    eTimeOut = false;
    eEndProcess = false;
    eMensajeNuevo = false;
    ePing = false;
  }
  



  public void init()
  {
    timer = new TimeOutTimer(this, TIMEOUT);
    resetAllEvents();
    pruebas = SgaUtilPuesto.isTesting();
    ordTran = new ADFOrdTran(pruebas);
    if (pruebas)
    {
      inicializado = true;
      inicTeleSent = true;
    }
    else 
    {
      inicializado = false;
      inicTeleSent = false;
    }
    
  }

  private /* synchronized */ void updateEstadoProceso ()
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
        }
       }
      catch (InterruptedException e) 
      { 
        eEndProcess = true;
      }
    }
  }

  public void run()
  {
    LOG.info("Arrancando proceso: " + this.getClass());

    estadoProceso = WAITNOINICIALIZADO; // TODO - really start up in operation
    resetAllEvents();
    
    ordTran.resetErrorCounter();
    
    button.setProcessStarted();
  
    try
    {
      while (!eEndProcess)
      {
        try
        {
          updateEstadoProceso();
        } 
        catch (oracle.jbo.AlreadyLockedException eAlready)
        {
          LOG.warn("Process " + getName() + " continuando..", eAlready);
          // Michael 01.06.2005
          ordTran.rollback();
        }
        // 19.05.2005
        catch (RowInconsistentException eRowInconsistent)
        {
          LOG.warn("Proces " + getName() + " continuant...", eRowInconsistent);
          ordTran.rollback();
        }
      }
    } 
    catch (Exception e)
    {
      LOG.fatal("Proces " + getName() + " aturant-se per error:", e);
      button.setProcessStopped(e);
    }
    String motivo = "Aturant el proces " + getName();
    LOG.info(motivo);
    button.setProcessStopped(motivo);
    ordTran.rollback();
  }


  /**
   * Bucle principal del autómata de gestión del traslo
   * @throws java.lang.InterruptedException
   * @param state
   * Michael 10.04.2005 sycnronized moved to wait statemente only
   */
  private void waitState (State state) throws InterruptedException
  {      
    state.onEntry();
    synchronized (this)
    {
      while (!state.isEvent() && !ePing && !eEndProcess)
      {
        wait();
      }
    }
      // Si es un ping, saca is alive message y continua
    if (!aTestPing())
    {
      state.action();
      state.onExit();
    }
  }
  
  private String getStringEstado()
  {
    return getStringEstado (estadoProceso);
  }

  private String toStringEvents()
  {
    return ("eTimeOut:" + eTimeOut
      + " eMensajeNuevo:" + eMensajeNuevo
      + " eEndProcess:" + eEndProcess
      + " ePing:" + ePing);
 
  }
  private String getStringEstado (int estado)
  {
    switch (estado)
    {
      case WAITFUNCIONAMIENTO: return "En funcionamiento";
      default: return "Estado desconocido (" + estado + ")";
    }
  }

 /**
 * Actualiza el estado
 */
  private void setEstadoProceso (int newEstado)
  {
    LOG.trace("Actualizant el estat del proces" + getStringEstado() + " -> "  + getStringEstado(newEstado));
    estadoProceso = newEstado;  
  }

  /**
   * Recibir mensajes de los objetos Observables donde este objeto se ha registrado por addObserver
   * @param arg
   * @param o
   */
  public synchronized void update(Observable o, Object arg)
  {
    assert (arg instanceof XMLDocument);
    // Si se recibe qualquier telegrama....
    inicializado = true;
    
    if (!addMensaje((XMLDocument)arg))
      LOG.error("Imposible afegir missatges entrants al gestor d'ordres de transport");
  }
  
  public synchronized void setTimeOut()
  {
    eTimeOut = true;
    notifyAll();
  }


  /**
   * Si se ha solicitado un ping, resetea la solicitud y sacar un mensaje del proceso
   * @return true si se ha activado el ping, false sino
   */
  private boolean aTestPing()
  {
    if (ePing)
    {
      ePing = false;
      LOG.debug("Ping del proceso: " + getName() + " Estado proceso: [" + getStringEstado() + "] proceso en marcha ?: " 
        + isAlive());
      return true;
    }
    return false;
  }


  /**
   * Intenta enviar una orden nueva al PLC
   * @return 
   */
  protected boolean aOrdenNueva()
  {
    XMLDocument xmldoc = ordTran.getNextOrdTran();
    boolean retVal = false;
    if (xmldoc != null)
    {
      if (gestorPlc.sendTelegrama(xmldoc))
      {
        ordTran.commit();
        ordenPendienteConfirmar = true;
        ordenPendienteCounter = 0;
        retVal = true;
      }
      else
      {
        LOG.error("Imposible enviar ordre " + XMLTelegrama.getNumMovimiento(xmldoc) + " al PLC");
        ordTran.rollback();
      }
    }
    return retVal;
  }
  
  protected boolean aBorrarOrdenAcabado()
  {
    XMLDocument xmldoc = ordTran.getNextOrdTranABorrar();
    boolean retVal = false;
    if (xmldoc != null)
    {
      if (gestorPlc.sendTelegrama(xmldoc))
      {
        ordTran.commit();
        retVal = true;
      }
      else
      {
        LOG.error("Imposible enviar ordre " + XMLTelegrama.getTipoTelegrama(xmldoc) + " " + XMLTelegrama.getNumMovimiento(xmldoc) + " al PLC");
        ordTran.rollback();
      }
    }
    return retVal;
  }
  
  private boolean hayMensajePendiente()
  {
    return (mensajesPend.size() > 0);
  }
  
  
  /**
   * Mirar los mensajes pendientes.
   * Tratar cada mensaje, comunicando al PLC si es necesario.
   * TODO Michael 10.04.2005 synchronized removed from method signature and placed in code
   */
  protected void aMensajeNuevo()
  {
    String tipoTel;
    while (hayMensajePendiente())
    {
      tipoTel = null;
      XMLDocument xmldoc;
      
      synchronized(this)
      {
      xmldoc = (XMLDocument)mensajesPend.remove(0);
      tipoTel = XMLTelegrama.getTipoTelegrama(xmldoc);
      }
      
      if (tipoTel != null)
      {
        LOG.trace("Tratando telegrama: " + tipoTel);
        if (tipoTel.equals("AVIS"))
        {
          // Deal with avis here
         sendRespuestaTele(xmldoc);
         ordTran.setAvisPetiFmov(tipoTel, xmldoc);
         
        }
        // Michael 07.03.2005 -- no hay que hacer esto - ver 
        else if (tipoTel.equals("PETI"))
        {
          if (ordTran.setAvisPetiFmov(tipoTel, xmldoc))
            sendRespuestaTele(xmldoc);
        }
        else if (tipoTel.equals("FMOV"))
        {
          if (ordTran.setAvisPetiFmov(tipoTel, xmldoc))
            sendRespuestaTele(xmldoc);
        }
        else if (tipoTel.equals("AMOV"))
        {
          if (ordTran.setAmov(xmldoc))
            ordenPendienteConfirmar = false;
          
        }
        else if (tipoTel.equals("ABMO"))
        {
         // Aceptación del borrado de un movi
          ordTran.borrarOrdTran(xmldoc); 
        }
        else if (tipoTel.equals("AINI"))
        {
          ; // Aceptación de un telegrama de inicialización  
        }
        // Otros telegramas no son tratados...
      }
      else
      {
        LOG.error("Recibido mensaje no entendido del PLC: " + XMLHelper.toString(xmldoc));
      }
     
      
      notifyObservers(xmldoc);  // :TODO who are the observers !!!
    }

  }
  
  
  private boolean sendInicTele()
  {
    // Parse un documento de tipo inic :TODO - get this from memory
    XMLDocument xmldoc =  XMLTelegrama.parseXML("inic");
    return gestorPlc.sendTelegrama(xmldoc);
  }
  
    /**
   * Enviar telegrama de respuesta al PLC
   * NOTA: Si falla el envío, no hay retorno - el telegrama será enviado de nuevo desde el PLC
   * TODO: Cada vez se carga el tipo de telegrama de fichero - ok para pruebas pero se debe optimizar - guardar en memoria.
   * @param xmldoc
   */
  private void sendRespuestaTele(XMLDocument xmldoc)
  {
    try 
    {
        Element el = xmldoc.getDocumentElement();
        String tipoTel = el.getAttribute("tipoTel");
        String respuesta = "A" + tipoTel.substring(0,3);
        XMLDocument outDoc;
        
        if (tipoTel.equals("PETI") || tipoTel.equals("AVIS"))
        {
          outDoc = xmldoc;  // mismo que lo que entra
          XMLTelegrama.setTipoTelegrama(outDoc, respuesta);
        }
        else
          outDoc = XMLTelegrama.parseXML(respuesta);
        
        if (outDoc != null)
        {
          XMLTelegrama.setNumMovimiento(outDoc, XMLTelegrama.getNumMovimiento(xmldoc));
          if (gestorPlc.sendTelegrama(outDoc))
            LOG.debug("Telegrama " + respuesta + " numMovimiento: " + XMLTelegrama.getNumMovimiento(outDoc) + " enviado");
          else
            LOG.error("Telegrama " + respuesta + " numMovimiento: " + XMLTelegrama.getNumMovimiento(outDoc)  + " no enviado");
        }
        else
          LOG.error("Documento de respuesta : " + respuesta + " no encontrado. No se acusa el documento al PLC");
    } catch (Exception ex) 
    {
      LOG.error("Exception:", ex);
    }
 }
  
  class WaitNoInicializado implements State
  {
    public WaitNoInicializado()
    {
      
    }
    
    public boolean isEvent()
    {
      return (eTimeOut || eEndProcess || ePing);
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
      
      
      if (eTimeOut)
      {
       eTimeOut = false;
       gestorPlc = GestorDatos.getInstance();
       if (gestorPlc != null)
       {
         // Registrar con el gestor del PLC para recibir mensajes
         gestorPlc.addObserver(GestorOrdTran.this);
         setEstadoProceso(WAITFUNCIONAMIENTO);
       }
       // Si no, continuamos en este estado
    }
  }
  }



  
  class WaitFuncionamiento implements State
  {
    public WaitFuncionamiento()
    {
      
    }
    
    public boolean isEvent()
    {
      return (eMensajeNuevo || eTimeOut || eEndProcess || ePing);
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
      
      
      if (eMensajeNuevo || hayMensajePendiente())
      {
        eMensajeNuevo = false;
        aMensajeNuevo();
      }
      else if (eTimeOut)
      {
       eTimeOut = false;
       if (inicializado && (!ordenPendienteConfirmar || pruebas))
       {
         aOrdenNueva();
       }
       else
        quizasResetOrdenPendiente();
      } 
      
      if (!inicializado && !inicTeleSent)
        inicTeleSent = sendInicTele();
      aBorrarOrdenAcabado();
      
      
    }
  }
  
 private void quizasResetOrdenPendiente()
 {
   if (ordenPendienteConfirmar)
   {
     ordenPendienteCounter++;
     if (ordenPendienteCounter == 10)
     {
       // Timeout esperando la confirmación de la orden
       ordTran.resetOrdenPendienteAceptacionPlc();
       ordTran.commit();
       ordenPendienteConfirmar = false;
     }
   }
 }

 public static void main(String[] args)
 {

  GestorOrdTran got = new GestorOrdTran ();
  // ...
 }
  

}