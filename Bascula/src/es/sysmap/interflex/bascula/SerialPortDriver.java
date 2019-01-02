package es.sysmap.interflex.bascula;
import es.sysmap.interflex.gestortelegrama.ByteHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Enumeration;
import java.util.Observer;
import java.util.TooManyListenersException;

import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

import org.apache.log4j.Logger;

import sgalib.MapObservable;

/**
 * Comunicaciones con los displays
 * NOTA: El projecto debe incluir el comm.jar de java/sun
 * El fichero "javax.comm.properties" debe estar en el lib del jre 
 *  (C:\jdev905\jdk\jre\lib)
 * El fichero win32com.dll (en entorno windows) debe estar en el path (en el jre?)
 */
public class SerialPortDriver extends MapObservable implements Runnable, SerialPortEventListener
{
  private boolean eDataAvailable;
  
  private Logger LOG = Logger.getLogger(getClass());
  private InputStream inputStream;  
  private OutputStream outputStream;
  private SerialPort port;
  private String portId;
  
  Thread tryThread = null;
  
  private byte [] bytes;
 
  public SerialPortDriver(Observer o) 
  {
    addObserver(o);
    eDataAvailable = false;
    port = null;
    bytes = new byte [100]; // Para decir algo...
    
  }
  
  public SerialPortDriver(Observer o, String portId, int baudrate, int databits, int stopbits, int paridad) 
  {
    this(o);
    openPort(portId, baudrate, databits, stopbits, paridad);
    
    tryThread = new Thread(this);
    tryThread.start();
  }

  public boolean isConnected()
  {
    return port != null;
  }
  
  private void openPort(String portId, int baudrate, int databits, int stopbits, int paridad)
  {
    LOG.debug ("openPort " + portId + " baudrate:" + baudrate + " databits:" + databits + " stopbits:" + stopbits + " paridad:" + paridad);
    Enumeration portList = CommPortIdentifier.getPortIdentifiers();

    while (portList.hasMoreElements()) {
      CommPortIdentifier commPort = (CommPortIdentifier) portList.nextElement();
      LOG.debug ("Looking at port: " + commPort.getName());

      if (commPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {

    
        if ( commPort.getName().equals(portId) ) {
        {
          try 
          {
            port = (SerialPort)commPort.open("SerialCommsApp", 2000);
            port.setSerialPortParams(baudrate,  // Baudrate
                                      databits,
                                      stopbits,
                                      paridad);
            
            port.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            
            LOG.info("serial port inicializado");
            inputStream = port.getInputStream();
            LOG.debug("input stream got");
            outputStream = port.getOutputStream();
            LOG.debug("output stream got");
          } catch (Exception ex) 
          {
            LOG.error ("error abriendo puerto serie", ex);
          } 
          break;          
          
        }
        }
      }
    }
  if (port == null)
  {
    LOG.error ("Imposible abrir el puerto de comunicaciones: " + portId);
    // TODO: Deixem continuar si el port es null
//    assert false;
  }
  // registrem el listener que notifica que hi ha dades pendents al buffer d'entrada
  registrarListener();
  }
  
  private void registrarListener()
  {
    if (port != null)
    {
      try {
        port.addEventListener(this);
      }
      catch (TooManyListenersException e) {
      }
      // Configurar puerto listener para avisar
      // solo cuando hay datos disponibles
      port.notifyOnDataAvailable(true);
    }

  }
  
    public synchronized void serialEvent(SerialPortEvent event)  {

    switch(event.getEventType()) {
    /* Michael 12.06.2003 Only interested in DATA_AVAILABLE
      case SerialPortEvent.BI:
      case SerialPortEvent.OE:
      case SerialPortEvent.FE:
      case SerialPortEvent.PE:
      case SerialPortEvent.CD:
      case SerialPortEvent.CTS:
      case SerialPortEvent.DSR:
      case SerialPortEvent.RI:
        //Fall Through
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
        break; */
      case SerialPortEvent.DATA_AVAILABLE:  
          eDataAvailable = true;
          notifyAll();
        break;
    }
  }


  public void readPort()
  {
    try 
    {
      eDataAvailable = false;
      int bytesRead = inputStream.read(bytes);
      if (bytesRead > 0)
      {
        byte [] lectura  = ByteHelper.getSubBytes(bytes, 0, bytesRead);
        notifyObservers(lectura);
      }
    } catch (IOException e) 
    {
      LOG.error("",e);
    } 
  }
  
  public synchronized void run()
  {
    try 
    {
    boolean primerCop = true;
    while ((!eDataAvailable && ! tryThread.isInterrupted()) || primerCop)
    {
       primerCop = false;
       wait();
       if (eDataAvailable)
       {
         readPort();
       }
    }
    } catch (InterruptedException e)
    {
      System.out.print ("This is the interrupted Exception in Timer.run() "+ e);
    } 
    
    LOG.info("Saliendo del proceso");
  }
  
  public void closePort()
  {
    tryThread.interrupt();
    if (port != null)
      port.close();
    
  }
  
}