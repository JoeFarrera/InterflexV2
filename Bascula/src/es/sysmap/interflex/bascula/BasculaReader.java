package es.sysmap.interflex.bascula;
import es.sysmap.interflex.gestortelegrama.ByteHelper;

import java.util.Observable;
import java.util.Observer;

import javax.comm.SerialPort;

import org.apache.log4j.Logger;

public class BasculaReader extends Thread implements Observer
{
  private Logger LOG = Logger.getLogger(getClass());
  
  private BasculaListener listener = null;
  private final String SLO = "SLO";
  private final String MLD = "MLD";
  
  private static final int MAX_LEN_MLD = 19;
  private static final int MAX_LEN_SLO = 35;

  SerialPortDriver basculaSlo = null;
  SerialPortDriver basculaMld = null;

  /**
   * Buffers que enmagatzemen els missatges entrants
   */
  private byte [] receiveStrSlo;
  private byte [] receiveStrMld;
  
  /**
   * Punters al tamany dels buffer d'entrada
   */
  private int lenReceivedSlo;  
  private int lenReceivedMld;  
  
  private String pesMld = null;
  private String pesSlo = null;
  
  public BasculaReader(BasculaListener listener, BasculaParams paramsMld, BasculaParams paramsSlo)
  {
    this.listener = listener;
    //MLD
    if (paramsMld != null)
      basculaMld = new SerialPortDriver(this, paramsMld.getPortId(), 
                        paramsMld.getBaudrate(), paramsMld.getDatabits(), 
                        paramsMld.getStopbits(), paramsMld.getParidad());
      //basculaMld = new SerialPortDriver(this, "COM1", 9600, 8, 1, SerialPort.PARITY_NONE);
    
    //SLO
    if (paramsSlo != null)
      basculaSlo = new SerialPortDriver(this, paramsSlo.getPortId(), 
                        paramsSlo.getBaudrate(), paramsSlo.getDatabits(), 
                        paramsSlo.getStopbits(), paramsSlo.getParidad());
      //basculaSlo = new SerialPortDriver(this, "COM1", 9600, 7, 1, SerialPort.PARITY_EVEN);
      
    start();
  }

  public synchronized void update (Observable o, Object arg)
  {
    
    byte [] bytes = (byte [])arg;
    
    if (o.equals(basculaMld))
      updateBasculaMld(arg);
    else if (o.equals(basculaSlo))
      updateBasculaSlo(arg);
    
  }
  
  public synchronized void updateBasculaMld(Object arg)
  {
     byte [] inBytes = (byte [])arg;
     addIncomingBytesMld (inBytes);
     //LOG.debug("Recibido " + lenReceivedMld + " caracteres");
     if (validateCurrentReceiveStrMld())
     {
       if (lenReceivedMld == MAX_LEN_MLD)  // S'ha rebut tot el telegrama
       {
         setPesMld(new String(ByteHelper.getSubBytes(receiveStrMld, 4, 11)));
         //LOG.debug("Rebut pes MLD: " + pesMld);
         lenReceivedMld = 0;
       }
     }
     else
     {
        LOG.error("Recibido telegrama desconocido en Mld");
     }
  }


  public synchronized void updateBasculaSlo(Object arg)
  {
     byte [] inBytes = (byte [])arg;
     addIncomingBytesSlo (inBytes);
     //LOG.debug("Recibido " + lenReceivedSlo + " caracteres");
     if (validateCurrentReceiveStrSlo())
     {
       if (lenReceivedSlo == MAX_LEN_SLO)  // S'ha rebut tot el telegrama
       {
         pesSlo = new String(ByteHelper.getSubBytes(receiveStrSlo, 5, 8));
         LOG.debug("Rebut pes SLO: " + pesSlo);
         lenReceivedSlo = 0;
       }
     }
     else
     {
        LOG.error("Recibido telegrama desconocido en Slo");
     }
  }


  private void addIncomingBytesMld (byte [] inBytes)
  {
    if (receiveStrMld != null) 
    {
      if ((inBytes.length + lenReceivedMld) > receiveStrMld.length)
      {
        // Hay que hacer el array más grande
        byte [] tempBytes = new byte [inBytes.length + (lenReceivedMld - receiveStrMld.length)];
        receiveStrMld = ByteHelper.concatenate(receiveStrMld, tempBytes);
      }
    }
    else
      receiveStrMld = new byte [MAX_LEN_MLD];
    System.arraycopy(inBytes, 0, receiveStrMld, lenReceivedMld, inBytes.length);
    lenReceivedMld = lenReceivedMld + inBytes.length;
  }
  

  private boolean validateCurrentReceiveStrMld()
  {
    boolean retVal = true;
    
    // Si la longitud es superior a l'esperada, descartem el missatge
    if (lenReceivedMld > MAX_LEN_MLD)
      retVal = false;
    // Si ja tenim els tres primers bytes, mirem que el 1 i el 3 siguin 'S'
    if (lenReceivedMld > 2 && !((char)receiveStrMld [0] == 'S' && (char)receiveStrMld [2] == 'S'))
      retVal = false;
    // Si ja hem rebut tot el missatge, mirem que acabi amb ETX
    if (lenReceivedMld == MAX_LEN_MLD && !((int)receiveStrMld [MAX_LEN_MLD-2] ==  13 && (int)receiveStrMld [MAX_LEN_MLD-1] == 10))  
      retVal = false;
    
    if(!retVal)
    {
        //LOG.error("Recibido datos no esperados en telegrama. Desechando " + lenReceivedMld + " caracteres");
        lenReceivedMld = 0;
    }
    return retVal;
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

  
  public synchronized void run()
  {
    try 
    {
      while (!isInterrupted ())
      {
        wait();
      }
    }     
    catch (InterruptedException e) 
    {
      System.out.print ("This is the interrupted Exception in Timer.run() "+ e);
    }
 
  }
  
  
  private void setPesMld(String pesMld)
  {
    if (!this.pesMld.equals(pesMld)) 
    {
      this.pesMld = pesMld;
      // Avisem de la nova pesada
      if (listener != null)
      
      
        listener.setPesActual("MLD", pesMld);
    }
  }


  private void setPesSlo(String pesSlo)
  {
    if (!this.pesSlo.equals(pesSlo)) 
    {
      this.pesSlo = pesSlo;
      if (listener != null)
        listener.setPesActual("SLO", pesSlo);
    }
  }
  
  public String getPesMld()
  {
    return this.pesMld;
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
    BasculaParams paramsMld = new BasculaParams("COM1", 9600, 8, 1, 0);
    BasculaParams paramsSlo = new BasculaParams("COM2", 9600, 7, 1, 2);
    
    BasculaReader basculaReader = new BasculaReader(null, paramsMld, paramsSlo);
    basculaReader.start();
  }
}