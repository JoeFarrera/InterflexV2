package es.sysmap.interflex.bascula;
import sgalib.SgaUtilPuesto;

public class BasculaParams 
{

  private String portId = null;
  private int baudrate = 0;
  private int databits = 0;
  private int stopbits = 0;
  private int paridad = 0; 
  

  public BasculaParams(String portId, int baudrate, int databits, int stopbits, int paridad)
  {
    this.portId = portId;
    this.baudrate = baudrate;
    this.databits = databits;
    this.stopbits = stopbits;
    this.paridad = paridad;
  }
  

  public String getPortId()
  {
    return portId;
  }


  public int getBaudrate()
  {
    return baudrate;
  }


  public int getDatabits()
  {
    return databits;
  }


  public int getStopbits()
  {
    return stopbits;
  }

  public int getParidad()
  {
    return paridad;
  }
  
  /**
   * Obté les dades de connexió a la bascula del fitxer de propietats
   */
  public static BasculaParams getBasculaParams(String bascula)
  {
    BasculaParams basculaParams = null;
    String params = SgaUtilPuesto.getInstance().getProperty(bascula);
    if (params != null)
    {
      int beginIndex = 0;
      int endIndex = params.indexOf(',', 0);
      String portId = params.substring(beginIndex, endIndex);
      beginIndex = endIndex + 1;
      endIndex = params.indexOf(',', beginIndex);
      int baudrate = Integer.parseInt(params.substring(beginIndex, endIndex).trim());
      beginIndex = endIndex + 1;
      endIndex = params.indexOf(',', beginIndex);
      int databits = Integer.parseInt(params.substring(beginIndex, endIndex).trim());
      beginIndex = endIndex + 1;
      endIndex = params.indexOf(',', beginIndex);
      int stopbits = Integer.parseInt(params.substring(beginIndex, endIndex).trim());
      beginIndex = endIndex + 1;
      int paridad = Integer.parseInt(params.substring(beginIndex).trim());
      basculaParams = new BasculaParams(portId, baudrate, databits, stopbits, paridad);
    }
    return basculaParams;
  }
  
 

}