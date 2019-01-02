package es.sysmap.interflex.control;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.xml.XMLHelper;
import es.sysmap.xml.XMLParser;
import es.sysmap.xml.XMLTelegrama;
import java.io.OutputStream;
import java.util.Observable;
import java.util.Observer;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLNode;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import sgalib.MapObservable;
import sgalib.SgaUtilPuesto;

public class PlcStatus extends SgaProceso implements Observer
{
  private GestorDatos gestor;
  private static PlcStatus _instance = new PlcStatus();
  private XMLDocument xmldoc;
  private XMLDocument lastStatDoc;  // último estado recibido
  private boolean eMensajeNuevo = false;
  private boolean pruebas;
  

  private PlcStatus()
  {
    super("PlcStatus");
    pruebas = SgaUtilPuesto.isTesting();

    gestor = new GestorDatos();
    gestor.addObserver(this);
  }
  
  public void init()
  {
    
  }
  
  public static synchronized PlcStatus getInstance()
  {
    return (_instance);
  }
  
  public GestorDatos getGestorDatos()
  {
    return gestor;
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
        XMLDocument outDoc = XMLTelegrama.parseXML(respuesta);
        if (outDoc != null)
        {
          if (gestor.sendTelegrama(outDoc))
            LOG.trace("Telegrama " + respuesta + " enviado");
          else
            LOG.error("Telegrama " + respuesta + " NO enviado");
        }
        else
          LOG.error("Documento de respuesta : " + respuesta + " no encontrado. No se acusa el documento al PLC");
    } catch (Exception ex) 
    {
      LOG.error("Exception:", ex);
    }
 }
  
  
  /**
   * Mientras no hay mensaje ni señal de acabar el proceso, espera
   * Al recibir un mensaje nuevo, realiza la accion y resetea el flag
   */
  public /* synchronized */ void run()
  {
    eEndProcess = false;
    LOG.info("Engegant el proces " + getName());
    if (!pruebas)
      gestor.startProcess();
    button.setProcessStarted();
    try 
    {
      while (!eEndProcess)
      {
        while (!eEndProcess && !eMensajeNuevo)
        {
          synchronized (this)
          {
            wait(); 
          }
        }
        if (eMensajeNuevo)
        {
          accionMensajeNuevo();
          signalMensajeNuevo(false);
        }
      }
    } catch (InterruptedException ex) 
    {
      LOG.info("Proceso interrumpido");
    } catch (Exception exgen)
    {
      LOG.error("Proces " + getName() + ":", exgen);
      button.setProcessStopped(exgen);
    }
    gestor.stopProcess();
    LOG.warn("Proces " + getName() + " sortint...");
    button.setProcessStopped("Aturat");
  }
  
  
  /**
   * Recibir mensajes del PLC y señalar el evento eMensajeNuevo para que se trate
   * Si el evento eMensajeNuevo está activado, el método finaliza sin tratar el mensaje
   * @param arg
   * @param o
   */
  public synchronized void update(Observable o, Object arg)
  {
    assert (arg instanceof XMLDocument);
    
    if (eMensajeNuevo)
    {
      LOG.warn("El missatge anterior no s'ha tractat encara. Es pert el actual");
      return;
    }
    
    xmldoc = (XMLDocument) arg;
    signalMensajeNuevo (true);
    
  }
  
  private synchronized void signalMensajeNuevo(boolean flag)
  {
    eMensajeNuevo = flag;
    notifyAll();
  }
  
  
    private void accionMensajeNuevo()
  {
    String tipoTel = null;

    tipoTel = XMLTelegrama.getTipoTelegrama(xmldoc);
    
    if (tipoTel != null)
    {
      if (tipoTel.equals("STAT"))
      {
        sendRespuestaTele(xmldoc);
        if (!hasNewObservers() && lastStatDoc != null && XMLTelegrama.isEqualDetalle(lastStatDoc, xmldoc))
        {
          return; // mismo
        }
        else
        {
          lastStatDoc = xmldoc;
          notifyObservers(xmldoc);
        }
      }
    }
    else
    {
      LOG.error("Recibido mensaje no entendido del PLC: " + XMLHelper.toString(xmldoc));
    }
  }
  
  public static void main(String[] args)
  {
    PlcStatus status = new PlcStatus();
    status.run();
    
  }
  
}