package es.sysmap.interflex.plcserver;
import es.sysmap.interflex.plcdriver.PlcDriver;
import es.sysmap.interflex.plcdriver.SocketReader;
import es.sysmap.interflex.plcdriver.Telegrama;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import java.net.ServerSocket;

public class PlcSuperServer extends PlcDriver
{

  public PlcSuperServer(int port)
  {
    super(PlcDriver.DEFAULT_HOST, port);
  }
  
  /**
   * esperar conexión de cliente (este es el servidor)
   * @return 
   */
  private boolean connectSocket()
  {
    try
    {
     ServerSocket s = new ServerSocket(port);
     LOG.info("waiting for accept...");
     sock = s.accept( );  // Sock is the client socket
     LOG.info("got accept");
     
     is = new DataInputStream(sock.getInputStream());
     os = new BufferedOutputStream(sock.getOutputStream());

     sendMessage(new String("bout ye").getBytes());
     return true;
    } 
    catch (IOException ioe)
    {
     LOG.error("Server error:" , ioe);
     return false;
    }
  }
  
  public static void main(String[] args)
  {
    PlcSuperServer ss = new PlcSuperServer(PlcDriver.DEFAULT_PORT);
    
  }
  
  public void run ()
  {
    while (!endThread)
    {
    try
    {
      if (!isConnected())
        connectSocket();
      while (!endThread && isConnected())
        listen();
    } catch (Exception e)
    {
      LOG.error("Thread interruped:", e);
    }
    }
    LOG.info ("Saliendo por recibir señal de terminar el thread");
  }
  
  private void listen()
  {
     boolean done = false;
     SocketReader sockReader = new SocketReader(is);

    try
    {
     while (!done)
     {  
        byte [] line = sockReader.readBlock(MAX_MENSAJE);
        if (line == null) 
        {
          LOG.error("Null recibido en el inBuffer");
          done = true;
        }
        else
        { 
          String inString = Telegrama.toString(line);
          LOG.info("in: " + inString);
          setChanged();
          notifyObservers(line);
        }
     }
    } catch (Exception e)
    {
      LOG.error("listen:" , e);
      disconnect();
    }

  }
  


  
}