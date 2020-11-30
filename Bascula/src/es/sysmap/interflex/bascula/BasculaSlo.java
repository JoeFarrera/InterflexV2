package es.sysmap.interflex.bascula;

import es.sysmap.interflex.gestortelegrama.ByteHelper;

import java.util.Observable;
import java.util.Observer;

import javax.comm.SerialPort;

import org.apache.log4j.Logger;
import sgalib.MapObservable;

public class BasculaSlo extends MapObservable implements Observer
{
  private Logger LOG = Logger.getLogger(getClass());
  
  private final String SLO = "SLO";
  
  private static final int MAX_LEN_SLO = 35;

  SerialPortDriver basculaSlo = null;
  
  private final String endIndicator = "\0x2\0xC";

  /**
   * Buffers que enmagatzemen els missatges entrants
   */
  private byte [] receiveStrSlo;
  
  /**
   * Punters al tamany dels buffer d'entrada
   */

  private int lenReceivedSlo;  
  
  private String pesSlo = "0";
  
  public BasculaSlo(BasculaParams paramsSlo)
  {
   
    //SLO
    if (paramsSlo != null)
      basculaSlo = new SerialPortDriver(this, paramsSlo.getPortId(), 
                        paramsSlo.getBaudrate(), paramsSlo.getDatabits(), 
                        paramsSlo.getStopbits(), paramsSlo.getParidad());
      //basculaSlo = new SerialPortDriver(this, "COM1", 9600, 7, 1, SerialPort.PARITY_EVEN);
  }


  public synchronized void update (Observable o, Object arg)
  {
     byte [] inBytes = (byte [])arg;
     LOG.debug("BasculaSlo: reveived " + inBytes.length + " caracteres" + " inBytes: " + toString(inBytes));
     addIncomingBytesSlo (inBytes);
     LOG.debug("BasculaSlo lenReceivedSlo: " + lenReceivedSlo + " caracteres" + " receiveStrSlo: " + toString(receiveStrSlo));
     
     if (validateCurrentReceiveStrSlo())
     {
       if (lenReceivedSlo == MAX_LEN_SLO)  // S'ha rebut tot el telegrama
       {
         setPesSlo(new String(ByteHelper.getSubBytes(receiveStrSlo, 5, 8)));
         // Michael 09.10.2006 TODO pruebas extra
         LOG.debug("Rebut pes SLO: " + pesSlo);
         lenReceivedSlo = 0;
       }
     }
     //else
     //{
     //   LOG.error("Recibido telegrama desconocido en Slo");
     //}
  }
  

  private void addIncomingBytesSlo (byte [] inBytes)
  {
    if (receiveStrSlo != null) 
    {
      if ((inBytes.length + lenReceivedSlo) > receiveStrSlo.length)
      {
        // Hay que hacer el array más grande
        byte [] tempBytes = new byte [inBytes.length + (lenReceivedSlo - receiveStrSlo.length)];
        receiveStrSlo = ByteHelper.concatenate(receiveStrSlo, tempBytes);
      }
    }
    else
      receiveStrSlo = new byte [MAX_LEN_SLO];
      
    if (inBytes.length <= MAX_LEN_SLO)
      {
        System.arraycopy(inBytes, 0, receiveStrSlo, lenReceivedSlo, inBytes.length);
        lenReceivedSlo = lenReceivedSlo + inBytes.length;
      }
    // otherwise, throw away
  }
  

  private boolean validateCurrentReceiveStrSlo()
  {
    boolean retVal = true;
    
    
    
    // Si la longitud es superior a l'esperada, descartem el missatge
    if (lenReceivedSlo > MAX_LEN_SLO)
    {
      LOG.warn("rejecting for lenReceivedSlo: " + lenReceivedSlo);
      // TODO: 2019.09.17 Test this if lots received..
      int posOfLastString = receiveStrSlo.toString().lastIndexOf(endIndicator);
      LOG.info("posOfLastString:" + posOfLastString);

      retVal = false;
    }
    // Si ja tenim els quatre primers bytes, mirem que siguin STX, E, , B
    if (lenReceivedSlo > 3 && !((int)receiveStrSlo [0] == 2 && ((char)receiveStrSlo [1] == 'E' || (char)receiveStrSlo [1] == 'D') && (char)receiveStrSlo [2] == ' ' && (char)receiveStrSlo [3] == 'B' ))
      {
        
      LOG.warn("rejecting for not STX, E, B lenReceivedSlo: " + lenReceivedSlo);
      retVal = false;
       }
    // Si ja hem rebut tot el missatge, mirem que acabi amb ETX
    if (lenReceivedSlo == MAX_LEN_SLO && !((int)receiveStrSlo [MAX_LEN_SLO-2] ==  2 && (int)receiveStrSlo [MAX_LEN_SLO-1] == 13)) 
    {
      LOG.warn("Rejecting for not ETX 13 lenReceivedSlo: " + lenReceivedSlo);
      retVal = false;
    }
    
    if(!retVal)
    {
        //LOG.error("Recibido datos no esperados en telegrama. Desechando " + lenReceivedSlo + " caracteres");
        lenReceivedSlo = 0;
    }
    return retVal;
  }

  
  public void setPesSlo(String pesSlo)
  {
    this.pesSlo = pesSlo.trim();
	//Notifiquem el pes al panels registrats
    notifyObservers(pesSlo);
  }
  
  public String getPesSlo()
  {
    return this.pesSlo;
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    
    BasculaParams paramsSlo = new BasculaParams("COM1", 9600, 7, 1, 2);
    
    BasculaSlo basculaSlo = new BasculaSlo(paramsSlo);
  }

  public void closePort()
  {
    basculaSlo.closePort();
  }
  
  
   
  /**
   * Convertir un array de bytes en su representación en String
   * Si el byte es equivalente a un dígito o una letra, imprime esto
   * Si no, imprime su valor decimal
   * @return String del array de bytes, separados por espacio
   * @param bytes array de bytes a convertir
   */
 public static String toString(byte [] byteString)
 {
    String charString = new String("[");
    
    for (int i = 0; i < byteString.length; i++)
    {
      char car = (char)(0xFF & byteString[i]);
      if (Character.isLetterOrDigit(car))
      {
        charString = charString.concat(car + " ");
      }
      else
        charString = charString.concat((int)car + " ");
    }
    // Quitar último espacio
    charString = charString.substring(0, charString.length() - 1).concat("]");
    
    return charString;
 }
}