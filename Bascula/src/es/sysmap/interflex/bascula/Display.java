package display;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import org.apache.log4j.Logger;

/**
 * Comunicaciones con los displays
 * NOTA: El projecto debe incluir el comm.jar de java/sun
 * El fichero "javax.comm.properties" debe estar en el lib del jre 
 *  (C:\jdev905\jdk\jre\lib)
 * El fichero win32com.dll (en entorno windows) debe estar en el path (en el jre?)
 */
public class Display 
{
  private static final int STX = 0x02;
  private static final int ETX = 0x03;

  private Logger LOG = Logger.getLogger(Display.class);
  
  private InputStream inputStream;  
  private OutputStream outputStream;
  private SerialPort port;
  private String portId;
  /**
   * contador de errores para resetear la comunicación
   */
  private int errorCount = 0;
 
  public Display(String portId)
  {
    this.portId = portId;
    openPort(portId);
  }
  
  private void openPort(String portId)
  {
    LOG.debug ("openPort " + portId);
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
            port.setSerialPortParams(19200,  // Baudrate
                                      SerialPort.DATABITS_8,
                                      SerialPort.STOPBITS_1,
                                      SerialPort.PARITY_NONE
                                     );
                                     
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
  }
  }
  
  public void write (byte [] mensaje)
  {
    if (port == null)
      openPort(portId);

     try  {
        LOG.debug("mensaje: " + mensaje);
        outputStream.write(mensaje);
        outputStream.flush();
        while (inputStream.available() > 0)
        {
          inputStream.skip(inputStream.available());
       }
      } catch (IOException e) {
        LOG.error ("write error ", e);
        LOG.info("Closing port " + portId);
        port.close();
        port = null;
      }
  }
  
  
  public void write (DisplayMessage message)
  {
    String smensaje = new String (message.getMensaje());
    byte [] bmensaje = new byte [smensaje.length() + 4];
    bmensaje [0] = STX;
    bmensaje [1] = '0';
    bmensaje [2] = (byte)('0' + message.getIdDisplay());  // Número del display
    for (int i = 0; i < smensaje.length(); i++) 
    {
      bmensaje [i + 3] = (byte)smensaje.charAt(i);
    }
    bmensaje [smensaje.length() + 3] = ETX;
    write (bmensaje);  
  }
  
  public void closePort()
  {
    LOG.debug("Closing port");
    if (port != null)
      port.close();
  }
  
  public static void main(String[] args)
  {
    Display d = new Display("COM5");
    int contador = 0;
    
    while (true)
    {
     for (byte i = 0; i < 4; i++) 
    {
      DisplayMessage message = new DisplayMessage(i, String.valueOf(contador));
      d.write(message);
       try
      {
        Thread.sleep(20);  
      } catch (InterruptedException ie){} // ignore
   }
   if (contador++ == 10000)
    contador = 0;
   
  }
  }
}