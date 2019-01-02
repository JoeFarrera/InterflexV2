package sgascanner;

import java.io.*;
import java.util.*;
import javax.comm.*;
import sgaalarm.*;
import oracle.jbo.*;
import oracle.jbo.client.*;
import oracle.jbo.domain.Number;
import sgamytabc4j.*;
import sgamytabc4j.common.SgapieViewRow;
import sgamytabc4j.common.SgaControlModule;
import java.sql.*;
import javax.swing.JOptionPane;
import sgacomlib.*;

public class Scanner implements  Runnable, SerialPortEventListener
{
  public static final short  MAX_MATRICULA = 17;
  public static final short  NOBANDEJA = MAX_MATRICULA + 1;
  public static final short  ERRORSCANNER = MAX_MATRICULA + 2;
 
  public static final byte S_UNKNOWN                = 0;//Arrancando
  public static final byte S_IDLE                   = 1;//Esperado un acontecimiento

 // Definición de constantes de acontecimientos reconocidos
  public static final byte E_NOTHING      = 0;//Acontecimiento sin acción concreto
  public static final byte E_READ_DATA    = 1;//Aviso de que hay datos esperando a ser leidos en el puerto
  public static final byte E_FREE         = 2;//Indicación de disponibilidad

  //Definiciones de caracteres de control empleado en el Protocolo MS400
  public static final byte STX = 2;
  public static final byte ETX = 3;
  public static final byte DLE = 16;
  public static final byte NAK = 21;
  public static final byte CAN = 24;
  public static final byte BEL = 7;
  public static final byte CR = 13;

  
  InputStream inputStream;  //Canal de RECEPCION de datos procedente del puerto serie
  OutputStream outputStream;//Canal de TRANSMISION de datos al puerto serie
  SerialComm canal;
  AlarmManager alarm;  // Monitor de alarmas para probar lectura scanner

  Thread classThread; //Singleton Thread que gestiona eventos y acontecimientos
  private ViewObject voPie;
  private SgaControlModule am;

 
 
  public Scanner(AlarmManager alarm) // Monitor de alarmas
  {
  
    // Inialize the port etc ..this.canal = canal;     // Serial comm objeto empleado por el Scanner
    //Asignar configuración del puerto para el scanner
    canal = new SerialComm("COM3", 4800, 7, 1, "EVEN");
    this.alarm = alarm;  
    am = (SgaControlModule)Configuration.createRootApplicationModule("sgamytabc4j.SgaControlModule", "SgaControlModuleLocal");    
    voPie = am.findViewObject("SgapieView1");
    alarm.trace("SgapieView1 instanciada");

    setState (S_IDLE);
    setEvent (E_NOTHING);

    if (conectaPuerto())
      start();
  }

  /**
   *
   * conecta los Streams de entrada y salida al canal elegido
   * para transmisión y recepción de datos
   */
  private void clearInBuffer() {

    canal.clearInBuffer(inputStream);
  }

  public boolean isThreadAlive()
  {
    return (classThread != null && classThread.isAlive());
  }

  public void stop ()
  {
    eEndProcess = true;
  }

  public void start ()
  {
    classThread = new Thread(this);
    classThread.start(); 
  }
  
  /**
   *
   * conecta los Streams de entrada y salida al canal elegido
   * para transmisión y recepción de datos
   */
  private boolean conectaPuerto() {


    if (!canal.isAvailable())
    {
      JOptionPane.showMessageDialog(null,
        "No ha sido posible arrancar el puerto del scanner", "Error en el puerto de comunicaciones", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    try {
      inputStream = canal.getPuerto().getInputStream();
    }
    catch (IOException e) {
    }

    try {
      outputStream = canal.getPuerto().getOutputStream();
    }
    catch (IOException e) {
    }

    // Conectar Listener al puerto serie
    try {
      canal.getPuerto().addEventListener(this);
    }
    catch (TooManyListenersException e) {
    }
    // Configurar puerto listener para avisar
    // solo cuando hay datos disponibles
    canal.getPuerto().notifyOnDataAvailable(true);
    return true;
  }

  /**
   *
   * arranca el hilo para gestionar el protocolo del Scanner
   *
   */
   public void run() 
   {
    try
    {     
      alarm.aviso("Scanner arrancado y esperando... ");
      eEndProcess = false;

      while(!eEndProcess) 
      {
          updateState ();
      }     
    }
    catch (Exception e)
    {
      alarm.error ("Exception in Scanner.run() " + e);
      e.printStackTrace();
      alarm.error ("Hay que arrancar el proceso Scanner de nuevo");
    }    
  }


  private void setResultado (boolean goodRead, String idart, String ordPro, String numSer)
  {
  // Intentar 2 veces por si está bloqueado
  for (int i = 0; i < 2; i++)
  {
  try
  {
    voPie.executeQuery();
    SgapieViewRow row = (SgapieViewRow)voPie.getRowSet().first();
    if (row != null)
    {
      row.setEstado(goodRead ? "L" : "E");
      row.setIdart(idart);
      row.setOrdpro(ordPro);
      
      if (numSer != null)
      {
        try {
        row.setNumser(new Number (numSer));
        } catch (SQLException eSql)
        {
          alarm.warning(eSql.toString());
        }
      }
      else
        row.setNumser (null);
      am.getTransaction().commit();
      break;
    }
    else
    {
      alarm.warning("Fila de la tabla SgaPie no encontrada");
      break;      
    }
  }
  catch (oracle.jbo.AlreadyLockedException e)
  {
    alarm.warning("Fila ya bloqueada.. reintentando");
    am.getTransaction().rollback();
  }
  }
  
  }

  public synchronized void updateState() {

    setEvent (E_NOTHING);

    try {

    while (event == E_NOTHING) 
    {
        //alarm.trace("Esperando matriculas de palets ....");
        wait();
    }

      switch (event) {

        case E_FREE:
          break;

        case E_READ_DATA:
          short lenIn;
         
          lenIn = readScanner();
          //alarm.trace("Lectura de mátricula con tamaño "+ lenIn);
          
          if (( 3 < lenIn)&& (lenIn <= MAX_MATRICULA)) 
          {
           
           setLength(lenIn);
           setEvent (E_NOTHING);

           //TODO Data Extraction and insertion here 

           String ordPro = new String( getMatricula(),0,6);
           String numSer = new String ( getMatricula(),6,3);
           String idArt = new String ( getMatricula(),9,8);

           alarm.trace ("Palet leído con Ord. Pro.: " + ordPro +
                                         " Num. Serie: " + numSer +
                                         " Ref: " + idArt); 
           setResultado (true, idArt, ordPro, numSer);
          } 
          else if (lenIn == NOBANDEJA)
          {
            alarm.warning ("Etiqueta no leida en el PIE");
            setResultado (false, null, null, null);
          }
          else if (lenIn == ERRORSCANNER)
          {
            alarm.error ("Scanner tiene un error de hardware");
            setResultado (false, null, null, null);
          }
          break;
       case E_NOTHING:
          break;
        default:
          break;
       }
    }catch (InterruptedException e) {
      alarm.error ("This is the interrupted exception in Scanner.updateState() "+e);
    }
  }




  /**
   * leer input desde el puerto del scanner
   * 
   */

   protected short readScanner()
   {
    short lengthRead = 0;
    short blockPtr = 0;
    short matriculaPtr = 0;
    byte caracter = 0;
    byte[] dataBlock = new byte[2*MAX_MATRICULA];

    int lenIn = canal.recibeBloque(inputStream, dataBlock);

    alarm.trace("Tamaño recibido "+lenIn);

    //Pedir más datos si falatan
    //Mensaje de error de Scanner tiene tamaño 3
    while((lenIn > 4)&&(lenIn < (MAX_MATRICULA + 2)))//Incluir caracteres de enmarcación
    {
      lenIn =lenIn + canal.recibeRestoBloque(inputStream, dataBlock, lenIn-1, (MAX_MATRICULA+2-lenIn));    
      alarm.trace("Mas datos recibidos de tamaño "+lenIn);
    }
      

    while ((blockPtr < lenIn) && (caracter != ETX)) {

      caracter = dataBlock[blockPtr]; 
      
    	switch (caracter) {
      
          case STX:
            lengthRead = 0;
            blockPtr++;
            //alarm.trace("STX leido");
            break;
            
          case CAN:
            lengthRead = NOBANDEJA;
            alarm.aviso("Ninguna matrícula leido en el scanner ");
            blockPtr++;
            break;
            
          case BEL:
            lengthRead = ERRORSCANNER;
            alarm.aviso("Error físico de scanner ");
            blockPtr++;
            break;
            
          case ETX:
            if (( lengthRead == NOBANDEJA )||( lengthRead == ERRORSCANNER))
              ; // Devolver esto..
            else  
              lengthRead = matriculaPtr;          
            break;
            
          default:
            matricula[matriculaPtr++] = caracter;
            blockPtr++;
    	} /*switch*/
    } /*while*/
  
    return lengthRead;
   }



  /**
   *
   *trata los eventos llegados al canal por el puerto serie
   *
   * @param  event - un evento procedente de un puerto serie
   */
  public void serialEvent(SerialPortEvent event)  {

    switch(event.getEventType()) {
    /* Michael 12.06.2003 Only interested in DATA_AVAILABLE
      case SerialPortEvent.BI:
      case SerialPortEvent.OE:
      case SerialPortEvent.FE:
      case SerialPortEvent.PE:
      case SerialPortEvent.CD:
      case SerialPortEvent.CTS:
      case SerialPortEvent.DSR:
      case SerialPortEvent.RI:
        //Fall Through
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
        break; */
      case SerialPortEvent.DATA_AVAILABLE:
        setEvent (E_READ_DATA);
        break;
    }
  }



/**
   *
   * informa del estado vigente del ciclo
   *
   * @param state - estado del ciclo a ser comunicado
   *
   */
  private void setState (byte state) {

      this.state = state;

      String mensaje = "Estado Scanner";

      switch(state) {

        case(S_IDLE):
          mensaje= "Estado Scanner "+ scannerName+ " es S_IDLE ";
          break;
          
        default:
          break;
        
      }
     //monitor.trace (mensaje);
    }


    /**
     * @return - matricula leido
     */
    public byte[] getMatricula(){return matricula;}

    /**
     * @return - nombre de scanner
     */
    public String getName(){ return scannerName;}
    
  /**
   *
   * informar sober el acontecimiento occurido
   *
   * @param event - acontencimiento a ser comunicado
   *
   */
  public synchronized void setEvent (byte event) {

    this.event = event;
    String mensaje;

    switch(event) {

      case(E_NOTHING):
        mensaje="Acontecimiento es E_NOTHING para Scanner " + scannerName;
        break;

      case(E_READ_DATA):
        mensaje="Acontecimiento es E_READ_DATA para Scanner " + scannerName;
        break;

      case(E_FREE):
        mensaje="Acontecimiento es E_LIBRE " + scannerName;
        break;
    }
    /*monitor.trace (mensaje); for testing scanners*/
    notifyAll ();
  }

  public short getLength(){return length;}
  
  protected void setLength(short length)
  {
    this.length = length;
  }

  //protected abstract void macScanner (int len); 
  //protected abstract void treatErrorDeposito();
  //protected abstract void updateState ();


  private static CommPortIdentifier portId;
  private static Enumeration portList;
  private String scannerName;
  
  protected boolean eEndProcess;
  private boolean errorFlag;    // Indicador de bloque recibido con error

  private byte state; //Estado del Scanner
  protected byte event; //Acontecimiento a tratar

  private byte[] matricula = new byte[2*MAX_MATRICULA];//Contenedor para bytes recibidos
  private short length = 0;
}

