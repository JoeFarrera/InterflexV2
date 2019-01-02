package es.sysmap.interflex.plcserver;

/**
 * @version 1.10 1997-06-27
 * @author Cay Horstmann
 */

import es.sysmap.interflex.plcdriver.Movi;
import es.sysmap.interflex.plcdriver.PlcDriver;
import es.sysmap.interflex.plcdriver.Posicion;
import es.sysmap.interflex.plcdriver.SocketReader;
import es.sysmap.interflex.plcdriver.Telegrama;
import java.io.*;
import java.net.*;
import org.apache.log4j.Logger;;

public class PlcServer
{  



public static void main(String[] args )
{  
Logger LOG = Logger.getLogger("main");

try
  { 

    ServerSocket s = new ServerSocket(8189);
    LOG.info("waiting for accept...");
     Socket incoming = s.accept( );
     // incoming.setSoTimeout(PlcDriver.SO_TIMEOUT);
     LOG.info("got accept");
     
     DataInputStream is = new DataInputStream(incoming.getInputStream());
     DataOutputStream os = new DataOutputStream(incoming.getOutputStream());


     os.writeBytes("bout ye");
     os.flush();

     boolean done = false;
     byte [] in = new byte [PlcDriver.MAX_MENSAJE];
     int i = 0;
     SocketReader reader = new SocketReader(is);
     
     while (!done)
     {
      try
      {
        String inStr = reader.readBlock(PlcDriver.MAX_MENSAJE);
        os.writeBytes(inStr);
        os.flush();
        LOG.info("PlcServer in: " + Telegrama.toString(inStr));
        
        
      Movi mov = new Movi (1234, 
        new Posicion (12, (byte)1, (byte)2, (byte)3, (byte)1), 
        new Posicion(55, (byte)1, (byte)2, (byte)3, (byte)2), 
        (byte)1, (byte)2, 444, 555, (byte)1, (byte)2, "100000000123");
        
        byte [] movi = mov.getBytes();
        
        os.writeBytes(new String(movi));
        os.flush();
   
    }
      catch (IOException ioe)
      {
        LOG.fatal("PlcServer: ", ioe);
        done = true;
      }
     }
     incoming.close();
  }
  catch (Exception e)
  {  
    LOG.fatal("PlcServer: ", e);
  }
}
}
