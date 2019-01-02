package es.sysmap.interflex.plcdriver;
import es.sysmap.interflex.gestortelegrama.ByteHelper;
import es.sysmap.interflex.gestortelegrama.GeneralMessageListener;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.xml.XMLParser;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Observable;
import java.util.Observer;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLNode;
import org.apache.log4j.Logger;

public class MoviTest implements Observer
{

  private Logger LOG = Logger.getLogger(getClass());
  private String receiveStr;
  public MoviTest()
  {
    Movi mov = new Movi(1234, new Posicion (11, (byte)12, (byte)13, (byte)1, (byte)2), 
      new Posicion (55, (byte)1, (byte)2, (byte)1, (byte)3), 
      (byte)1, (byte)1, 123, 456, (byte)1, (byte)1, "1000000123");
    
    
    
    // PlcDriver driver = PlcDriver.getInstance();
    PlcDriver driver = new PlcDriver(PlcDriver.DEFAULT_HOST, PlcDriver.DEFAULT_PORT);
    receiveStr = new String();
    receiveStr = "";
    
    driver.addObserver(this);
    
    try 
    {
      Thread.sleep(5000);
    } catch (Exception ex) 
    {
      ex.printStackTrace();
    } 

    XMLNode node = mov.writeXML();

    try
    {
     StringWriter myStringWriter = new StringWriter();
    
     node.print(new PrintWriter(myStringWriter));
     node.print(System.out);

     int lenTelegrama = Integer.parseInt(XMLParser.getAttributeValue((XMLDocument)node, "Telegrama", "lenTelegrama"));
     
     byte [] movi = new byte [lenTelegrama];

     movi = es.sysmap.interflex.gestortelegrama.GestorDatos.getBytes(myStringWriter.toString(), movi);
     
     LOG.debug("mov from      bytes: " + Telegrama.toString(mov.getBytes()));
     LOG.debug("mov from xmlToBytes: " + Telegrama.toString(movi));
     
     // Prueba de leer lo que se ha generado
     Movi watchMovi = new Movi();
     byte [] justMovi = new byte [Telegrama.MAX_DATOS];
     System.arraycopy(movi, Telegrama.MAX_HEADER, justMovi, 0, movi.length - (Telegrama.MAX_HEADER));
     watchMovi.read(justMovi);
     LOG.debug("mov: " + mov.toString());
     LOG.debug("watchMovi: " + watchMovi.toString());
     // Fin prueba

     assert movi.length == Telegrama.getLenTeleRecibido(movi) + Telegrama.MAX_HEADER : movi.length;
   
    boolean done = false;
    while (!done)
    {
      if (driver.sendMessage(movi))
      {
        LOG.info("Mensaje enviado");
        done = true;
      }
      else
      {
        LOG.error("No ha sido posible enviar el mensaje");
        try 
        {
          Thread.sleep(5000);
        } catch (Exception ex) 
        {
          ex.printStackTrace();
        } 
    }
    }


    } catch (Exception ex)
    {
      ex.printStackTrace();
    } catch (Throwable t)
    {
      t.printStackTrace();
    }
    
  }


   public synchronized void update(Observable o, Object arg)
   {
     receiveStr = receiveStr.concat((String)arg);
     if (receiveStr.startsWith("T"))
     {
       if (receiveStr.length() > 7)  // Se ha recibido suficiente para ver que tamaño tiene
       {
       if (receiveStr.startsWith("MOVI", 1))
       {
         byte [] bytesRecd = receiveStr.getBytes();
         int tamanoTele = Telegrama.getLenTeleRecibido(bytesRecd);
         if (bytesRecd.length >= tamanoTele)
         {
           Movi movi = new Movi();
           LOG.debug("Recibido telegrama de tamaño: " + receiveStr.length());
           movi.read(ByteHelper.getSubBytes(receiveStr.getBytes(), Telegrama.MAX_HEADER, (receiveStr.length() - Telegrama.MAX_HEADER)));
           LOG.info("Recibido movi del Plc: " + movi.toString());
           receiveStr = "";
         }
         else
          LOG.debug("Recibido:" + bytesRecd.length + " de " + tamanoTele);
        }
       else
       {
        LOG.info("Recibido telegrama desconocido: " + receiveStr);
        receiveStr = "";
       }
     }
     }
     else
      receiveStr = "";
   }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    MoviTest moviTest = new MoviTest();
  }
}