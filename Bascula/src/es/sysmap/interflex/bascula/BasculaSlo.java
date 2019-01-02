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
     addIncomingBytesSlo (inBytes);
     //LOG.debug("Recibido " + lenReceivedSlo + " caracteres");
     if (validateCurrentReceiveStrSlo())
     {
       if (lenReceivedSlo == MAX_LEN_SLO)  // S'ha rebut tot el telegrama
       {
         setPesSlo(new String(ByteHelper.getSubBytes(receiveStrSlo, 5, 8)));
         // Michael 09.10.2006 TODO pruebas extra
         // LOG.debug("Rebut pes SLO: " + pesSlo);
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
    System.arraycopy(inBytes, 0, receiveStrSlo, lenReceivedSlo, inBytes.length);
    lenReceivedSlo = lenReceivedSlo + inBytes.length;
  }
  

  private boolean validateCurrentReceiveStrSlo()
  {
    boolean retVal = true;
    
    // Si la longitud es superior a l'esperada, descartem el missatge
    if (lenReceivedSlo > MAX_LEN_SLO)
      retVal = false;
    // Si ja tenim els quatre primers bytes, mirem que siguin STX, E, , B
    if (lenReceivedSlo > 3 && !((int)receiveStrSlo [0] == 2 && (char)receiveStrSlo [1] == 'E' && (char)receiveStrSlo [2] == ' ' && (char)receiveStrSlo [3] == 'B' ))
      retVal = false;
    // Si ja hem rebut tot el missatge, mirem que acabi amb ETX
    if (lenReceivedSlo == MAX_LEN_SLO && !((int)receiveStrSlo [MAX_LEN_SLO-2] ==  2 && (int)receiveStrSlo [MAX_LEN_SLO-1] == 13))  
      retVal = false;
    
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
  
}