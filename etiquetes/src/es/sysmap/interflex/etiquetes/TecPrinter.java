package es.sysmap.interflex.etiquetes;

import java.io.*;

import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.ParallelPort;
import javax.comm.PortInUseException;

import javax.comm.SerialPort;
import javax.print.PrintService;
import org.apache.log4j.Logger;
public class TecPrinter
{
  private Logger LOG = Logger.getLogger(getClass());
  private Enumeration portList;
  private CommPortIdentifier portId;
  private SerialPort serialPort;
  private ParallelPort parallelPort;
  private OutputStream outputStream;
  
  private int portType;
  
  /**
   * Obté una instancia a la impresora TEC de codis de barres
   * @return 
   */
   
   
  public TecPrinter(String port)
  {
    // Michael 19.07.2018 PC with parallel port printer using USB figures as USB00x
    if (port.startsWith("LPT"))
      portType = CommPortIdentifier.PORT_PARALLEL;
    else if (port.startsWith("COM"))
      portType = CommPortIdentifier.PORT_SERIAL;
 
    if (portType == CommPortIdentifier.PORT_PARALLEL || portType == CommPortIdentifier.PORT_SERIAL)
      openPort(port);
  }

  private void openPort(String port)
  {
    portList = CommPortIdentifier.getPortIdentifiers();
    System.out.println("Port: " + port + " PortList hasMoreElements :" + portList.hasMoreElements());
    boolean sameType;
    
    while (portList.hasMoreElements()) 
    {
      portId = (CommPortIdentifier) portList.nextElement();
      
      // Michael 24.11.2016 if (portId.getPortType() == CommPortIdentifier.PORT_PARALLEL) 
      if (portType == CommPortIdentifier.PORT_SERIAL)
        sameType = (portId.getPortType() == CommPortIdentifier.PORT_SERIAL);
      else if (portType == CommPortIdentifier.PORT_PARALLEL)
        sameType = (portId.getPortType() == CommPortIdentifier.PORT_PARALLEL);
      else
        sameType = false;
        
      if (sameType) 
      {
          if (portId.getName().equals(port)) 
          {
            try 
            {
              if (portType == CommPortIdentifier.PORT_SERIAL)
                serialPort = (SerialPort)portId.open("TecPrinterApp", 2000); 
              else 
                parallelPort = (ParallelPort)portId.open("TecPrinterApp", 2000); 
              try 
              {
              if (portType == CommPortIdentifier.PORT_SERIAL)
                outputStream = serialPort.getOutputStream();
              else
                outputStream = parallelPort.getOutputStream();
              } 
              catch (IOException e) 
              {
                LOG.error ("Error obteniendo outputStream para puerto " + port, e);
              }    
            }
            catch (PortInUseException e) 
            {
              LOG.error ("Error abriendo puerto " + port, e);
            }
   
          }
        }
    }
    
  }
  
  
  public void closePort()
  {
    if (portType == CommPortIdentifier.PORT_SERIAL)
    {
      if (serialPort != null)
        serialPort.close();
    }
    else 
      if (parallelPort != null)
        parallelPort.close();
    
  }
  
  public boolean isConnected()
  {
  /*  Testing 01.03.2021
  if (true)
  {
  try{
    outputStream = new FileOutputStream("cabstream.txt");
    return true;
  }
  catch (Exception ex)
  {
    ;
  }
  }
  */
    
  
    if (portType == CommPortIdentifier.PORT_SERIAL)
      return serialPort != null;
    else
      return parallelPort != null;
  }
  
  
  public void etiquetaPicking()
  {
    
  }
  
  public void writeData(String data)
  {
    try 
    {
      outputStream.write(data.getBytes());
    } 
    catch (IOException e) 
    {
      LOG.error("Error al enviar datos a puerto LPT1", e);      
    }
  }


}