package es.sysmap.interflex.plcdriver;
// import es.sysmap.interflex.gestortelegrama.GeneralMessageListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import org.apache.log4j.Logger;
import sgalib.MapObservable;

/**
 * Conecta al socket y port del PLC
 * <p>Envia mensajes al PLC de forma síncrona</p>
 * <p>Recibe mensajes del PLC una vez conectado.</p>
 * <p>Los mensajes recibidos son devueltos a los <em>Observers</em> que se han registrado</p>
 * <p>Bajo petición del cliente, cierra la conexión</p>
 * <img src="doc-files/plcdriver.png" width="1534" height="1346"/>
 */
public class PlcDriver extends MapObservable implements Runnable 
{
  /**
   * Socket para la conexión con el PLC
   */
  protected Socket sock;
  private String host;
  protected int port;
  protected DataInputStream is; 
  protected BufferedOutputStream os;

  protected Logger LOG = Logger.getLogger(getClass());  
  protected boolean endThread;

  protected PlcListener listener;
  
  private static PlcDriver _instance;
  
  private static int MAX_TIMEOUT_OPEN = 5000;
  public static String DEFAULT_HOST = "plcmcf";
  public static int DEFAULT_PORT = 2000;
  public static int SO_TIMEOUT = 500;  // Timeout in millis - TODO get from properties
  public static int MAX_MENSAJE = 255;  // Max tamaño de mensaje por el socket


  /**
   * Obtener instancia del PlcDriver (singleton)
   * Si no está instanciada, lo será contra el host y port por defecto
   * @return instancia de PlcDriver
   */
  public static PlcDriver getInstance()
  {
    if (_instance == null)
      _instance = new PlcDriver(DEFAULT_HOST, DEFAULT_PORT);

    return _instance;
    
  }
  
  
  public PlcDriver(String host, int port, Observer o)
  {
    this(host, port);
    addObserver(o);
  }
  

  public PlcDriver(String host, int port)
  {
    _instance = this;
    endThread = false;
    sock = null;
    this.host = host;
    this.port = port;
 }

  public void startProces()
  {
    Thread thread = new Thread (this);
    thread.setDaemon(true);
    thread.start();
  }

  public synchronized void endThread()
  {
    endThread = true;
    notifyAll();
  }
 
  /**
   * Intentar conectar el socket de forma asíncrona
   * @return 
   */
  private boolean connectSocket()
  {
    disconnect();
    LOG.info("Abriendo socket al host: " + host + " port:" + port);
    sock = SocketOpener.openSocket(host, port, MAX_TIMEOUT_OPEN);
    if (sock != null)
    {
      try
      {
      LOG.info("Socket al host: " + host + " port:" + port + " abierto");
      is = new DataInputStream(sock.getInputStream());
      os = new BufferedOutputStream(sock.getOutputStream());
      listener = new PlcListener(is);
      } catch (IOException ie)
      {
        LOG.error("Imposible conectar por socket al host " + host + "@port: " + port, ie);
      }
    }
    return (sock != null);
  }

  public boolean isConnected()
  {
    return sock != null;
  }
  

  /**
   * Enviar un mensaje al Plc conectado.
   * @return true si ha tenido éxito el envio, false si no (no está conectado, ha fallado el envio)
   * @param mensaje array de bytes a enviar
   */
  public boolean sendMessage(byte [] mensaje)
  {
   // TODO 2018  servidordsga
  //LOG.warn("would have written - out len: " + mensaje.length + " ok:" + Telegrama.toString(mensaje));
  //if (true)
  //  return true;
   
    if (!isConnected())
    {
      return false;
    }
    else
    {
      try
      {
      int len = mensaje.length;
        	for (int i = 0 ; i < len ; i++) {
            os.write(mensaje[i]);
          }

        // os.writeBytes(outString);
        os.flush(); 
        LOG.trace("out len: " + mensaje.length + " ok:" + Telegrama.toString(mensaje));
        return true;
      } catch (IOException ioe)
      {
        LOG.error("out *error*: " + Telegrama.toString(mensaje));
        disconnect();
        return false;
     }
    }
  }


private String getName()
{
  return "PlcDriver";
}
 protected synchronized void disconnect()
  {
    LOG.info("Desconectant el socket del plc");
    if (isConnected())
    {
      try
      {
        is.close();
        os.close();
        sock.close();
      } catch (IOException e) 
      {
        LOG.error("Socket disconnect:", e);
      }
      finally
      {
        sock = null;
        notify();        
      }
    }
  }
  
  
  
  public synchronized void run ()
  {
  
    // Esperar a que los observers etc se conectan...
    endThread = false;
    try
      {
        Thread.sleep(5000);  
      } catch (InterruptedException ie){} // ignore
     
    while (!endThread)
    {
    try
    {
      if (!isConnected())
        connectSocket();
      while (!endThread && isConnected())
        wait();
    } catch (InterruptedException e)
    {
      LOG.error("Thread interruped:", e);
    }
    }
    if (listener != null)
      listener.stopProceso();
    LOG.info ("Sortint per haber rebut la senyal de tancar el thread " + getName());
  }
  
   /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
      Logger LOG = Logger.getLogger("main");  
  
      String myHost;
      if (args.length > 0) myHost = args[0];
        else myHost = "localhost";

      int myPort;
      if (args.length > 1) myPort = Integer.parseInt(args[1]);
        else myPort = 8189;

    PlcDriver driver = new PlcDriver(myHost, myPort);
    try 
    {

      LOG.info("Driver connected?: " + driver.isConnected());
      Thread.sleep(6000);
      LOG.info("Driver connected after sleep?: " + driver.isConnected());
      driver.disconnect();

    } catch (Exception ex) 
    {
      ex.printStackTrace();
    } finally 
    {
    }
    
    
  }

  /**
   * Thread arrancado una vez establecida la conexión para recibir los mensajes del socket
   * Los mensajes recibidos se envian a cada cliente registrado.
   * <p><em> NOTA: Los mensajes pueden ser recibidos parcialmente, y serán enviados a los clientes parcialmente.
   * Es tema del cliente reconstruir el mensaje llegado </em></p>
   */
protected class PlcListener implements Runnable
{
  private Logger LOG = Logger.getLogger(getClass());
    
  private DataInputStream inputStream;
  Thread processThread;
  boolean endListenerProcess;
  public PlcListener(DataInputStream inputStream)
  {
    this.inputStream = inputStream;
    processThread = new Thread (this);
    processThread.setDaemon(true);
    processThread.start();
  }
  
  public void stopProceso()
  {
    if (processThread != null)
      processThread.interrupt();
    endListenerProcess = true;
  }
  
  public void run ()
  {
    endListenerProcess = false;
    SocketReader sockReader = new SocketReader(inputStream);

    try
    {
     while (!endListenerProcess)
     {  
        byte [] line = sockReader.readBlock(MAX_MENSAJE);
        if (line == null) 
        {
          LOG.error("Se ha rebut 'null' en el buffer de entrada del plc");
          endListenerProcess = true;
        }
        else
        { 
          String inString = toString(line);
          LOG.trace("in : " + inString);
          // Pasar lo recibido a la lista de observers
          notifyObservers(line);  
        }
     }
    } catch (Exception e)
    {
      LOG.error("PlcDriver.PlcListener:" , e);
      // endThread();
    }
    disconnect();

  }

  private String toString(byte [] mensaje)
  {
   return (Telegrama.toString(mensaje));
  }

  }
}