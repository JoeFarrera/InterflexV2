package es.sysmap.interflex.bascula;

import es.sysmap.interflex.gestortelegrama.ByteHelper;
import java.util.Observable;
import java.util.Observer;

import javax.comm.SerialPort;

import org.apache.log4j.Logger;
import sgalib.MapObservable;

public class BasculaMld extends MapObservable implements Observer
{
  private Logger LOG = Logger.getLogger(getClass());
  
  private final String MLD = "MLD";
  
  private static final int MAX_LEN_MLD = 19;

  SerialPortDriver basculaMld = null;
  
  private boolean bFiPesada = false;

  /**
   * Buffers que enmagatzemen els missatges entrants
   */
  private byte [] receiveStrMld;
  
  /**
   * Punters al tamany dels buffer d'entrada
   */
  private int lenReceivedMld;  
  
  private String pesMld = "0";
  
  public BasculaMld(BasculaParams paramsMld)
  {
  
    lenReceivedMld = 0;
    //MLD
    if (paramsMld != null)
      basculaMld = new SerialPortDriver(this, paramsMld.getPortId(), 
                        paramsMld.getBaudrate(), paramsMld.getDatabits(), 
                        paramsMld.getStopbits(), paramsMld.getParidad());
      //basculaMld = new SerialPortDriver(this, "COM1", 9600, 8, 1, SerialPort.PARITY_NONE);
  }

    public synchronized void deleteObserver(Observer o) 
    {
        super.deleteObserver(o);
        // Finalitzem la pesada de la bascula
        bFiPesada = true;
        //Xavi, 10/11/05: Inicialitzem el pes de la bascula
        pesMld = "0";
    }

  public synchronized void update (Observable o, Object arg)
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
     //else
     //{
     //   LOG.error("Recibido telegrama desconocido en Mld");
     //}
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
    System.arraycopy(inBytes, 0, receiveStrMld, lenReceivedMld, inBytes.length > MAX_LEN_MLD ? MAX_LEN_MLD : inBytes.length );
    lenReceivedMld = lenReceivedMld + inBytes.length;
  }
  

  private boolean validateCurrentReceiveStrMld()
  {
    boolean retVal = true;
    
    // Si la longitud es superior a l'esperada, descartem el missatge
    if (lenReceivedMld > MAX_LEN_MLD)
    {  
      boolean trobat = false;
      for (int i = 0; (i < receiveStrMld.length && !trobat); i ++)
      {
        if (((char)receiveStrMld [i] == 'S'))
        {
          if ( (i + MAX_LEN_MLD < lenReceivedMld) )
          // Michael 2016.09.16 On occasion gives len error
          if (i < (receiveStrMld.length + 2))
          {
            if ((char)receiveStrMld [i + 2] == 'S' || (char)receiveStrMld [i + 2] == 'D')
            {
              trobat = true;
              // Michael 12.04.2017 Gives error
              // java.lang.ArrayIndexOutOfBoundsException
              // at java.lang.System.arraycopy(Native Method)
              // at es.sysmap.interflex.bascula.BasculaMld.validateCurrentReceiveStrMld(B
              // asculaMld.java:113)
              // BasculoaMld.validateCurrentReceiveStrMld i: 1 receiveStrMld: [B@385715 lenReceiv
              // edMld: 39 receiveStrMld.length: 19
              System.out.println("BasculoaMld.validateCurrentReceiveStrMld i: " 
                + i + " receiveStrMld: " + receiveStrMld 
                + " lenReceivedMld: " + lenReceivedMld 
                + " receiveStrMld.length: " + receiveStrMld.length);  
              System.arraycopy(receiveStrMld, i, receiveStrMld, 0, MAX_LEN_MLD);
              lenReceivedMld = MAX_LEN_MLD;
            }
          }
          else
            System.out.println("BasculaMld.java 118 por error len receiveStrMld");
            // Michael 2016.09.16 On occasion gives len error
            
        }
      }
      retVal = trobat;
    } 
    // Si ja tenim els tres primers bytes, mirem que el 1 i el 3 siguin 'S'
    if (lenReceivedMld > 2 && !((char)receiveStrMld [0] == 'S' && ((char)receiveStrMld [2] == 'S') || (char)receiveStrMld [2] == 'D'))
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

 
  
  public void setPesMld(String pesMld)
  {
    // Si s'ha acabat la pesada, esperem a agafar un pes diferent per notificar
    // els observers
    if (bFiPesada && !this.pesMld.equals(pesMld.trim()))
      bFiPesada = false;
    if (!bFiPesada)
    {
      this.pesMld = pesMld.trim();
      //Notifiquem el pes al panels registrats
      notifyObservers(this.pesMld);
    }
  }


  
  public String getPesMld()
  {
    return this.pesMld;
  }

  public void closePort()
  {
    basculaMld.closePort();
  }

  /**
   * 
   * @param args
   */

  public static void main(String[] args)
  {
    BasculaParams paramsMld = new BasculaParams("COM1", 9600, 8, 1, 0);
    
    BasculaMld basculaMld = new BasculaMld(paramsMld);
  }
  
}