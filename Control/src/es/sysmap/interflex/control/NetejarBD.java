package es.sysmap.interflex.control;

import es.sysmap.interflex.model.dmc.common.AppModule;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;
import oracle.jbo.client.Configuration;
import org.apache.log4j.Logger;
import sgalib.MapProcessButtonInterface;
  
/**
 * Thread que neteja la base de dades
 */
public class NetejarBD extends SgaProceso implements TimeOutListener
{
  private Logger LOG = Logger.getLogger(getClass());

  private static final int TIMEOUT = 360000;  // Tiempo se timeout para el ciclo (1 hora)
  
 
  private boolean eTimeOut = false;
  private boolean ePing = false;
  

  
  private TimeOutTimer timer;

  private Connection conn = null;
  private AppModule appModule = null;
  
  public NetejarBD() throws Exception 
  {
    super("Netejar BD");

    try
    {
      //Instanciem el application module de l'aplicació
      String        amDef = "es.sysmap.interflex.model.dmc.AppModule";
      String        config = "AppModuleLocal";
      appModule = (AppModule)Configuration.createRootApplicationModule(amDef,config);
      init();
    }
    catch(Exception ex)
    {
      conn.close();
      throw ex;
    }
  }
  
  
  public void init()
  {
    timer = new TimeOutTimer(this, TIMEOUT);
    ePing = false;
    eTimeOut = false;
    eEndProcess = false;
  }
  

  
  public synchronized void setTimeOut()
  {
    eTimeOut = true;
    notifyAll();
  }


  private synchronized void updateEstadoProceso() throws InterruptedException, Exception
  {
    while (!ePing && !eEndProcess && !eTimeOut)
    {
      wait();
    }
    if (eTimeOut)
    {
      eTimeOut = false;
      appModule.netejarBD();
    }
    if (ePing)
    {
      ePing = false;
      LOG.debug("Ping del proceso " + toString());
      
    }
   }
  
   public void run()
  {
    LOG.info("engegant el proces" + getName());
    eEndProcess = false;
    if (button != null)
    {
      button.setProcessStarted();
    }
    
    try
    {
      while (!eEndProcess)
      {
        updateEstadoProceso();
      }
    } catch (Exception e)
    {
      LOG.fatal("Proces " + getName() + " aturant per excepció:", e);
      button.setProcessStopped(e);
    }
    String motivo = "Aturant el proces: " + getName();
    LOG.warn(motivo);
    button.setProcessStopped(motivo);
    
  }


  public static void main(String[] args) throws Exception
  {
    NetejarBD netejarBD = new NetejarBD();
    Logger LOG = Logger.getLogger("puesto main test");
      
    netejarBD.start(null);
    try 
    {
      while (true)
      {
        
        Thread.sleep(10);
        
      }
        
    } catch (Exception ex) 
    {
      LOG.error("",ex);
    } 
    
  }
  
}