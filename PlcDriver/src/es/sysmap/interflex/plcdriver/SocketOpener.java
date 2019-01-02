package es.sysmap.interflex.plcdriver;
import java.io.IOException;
import java.net.Socket;
import org.apache.log4j.Logger;;

/**
 * Abrir un socket, esperando un timeout
 * Evita que se quede bloqueado en la apertura del socket
 */
class SocketOpener implements Runnable
{  

  public static Socket openSocket(String aHost, int aPort,
      int timeout)
   {  
      SocketOpener opener = new SocketOpener(aHost, aPort);
      Thread t = new Thread(opener);
      t.start();
      try
      {  t.join(timeout);
      }
      catch (InterruptedException exception)
      {
      }
      return opener.getSocket();
   }

   public SocketOpener(String aHost, int aPort)
   {  socket = null;
      host = aHost;
      port = aPort;
   }

   public void run()
   {  try
      {  socket = new Socket(host, port);
        System.out.println("sendBuffer: " + socket.getSendBufferSize());
        // socket.setTcpNoDelay(false);
      }
      catch (IOException exception)
      {
         LOG.error("IOException:", exception);
     }
   }

   public Socket getSocket()
   {  return socket;
   }

   private String host;
   private int port;
   private Socket socket;
   private Logger LOG = Logger.getLogger(this.getClass());
   
};
