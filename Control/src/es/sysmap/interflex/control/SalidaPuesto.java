package es.sysmap.interflex.control;
import org.apache.log4j.Logger;
  

public class SalidaPuesto extends SgaProceso implements TimeOutListener
{
  private Logger LOG = Logger.getLogger(getClass());

  private static final int TIMEOUT = 1000;  // Tiempo se timeout para el ciclo
  public static final int PUESTO_MINILOAD = 1;
  public static final int PUESTO_MAXILOAD = 2;
  
 
  private boolean eTimeOut = false;
  private boolean ePing = false;
  

  
  private TimeOutTimer timer;
  private ADFSalidaPuestoInterface adfPuesto;

  public SalidaPuesto(int tipPuesto)
  {
    super("Sortida Lloc " + (tipPuesto == PUESTO_MINILOAD ? "Mini Load" : "Maxi Load"));
    if (tipPuesto == PUESTO_MINILOAD)
    {
      adfPuesto = new ADFSalidaPuestoMLD();
    }
    else
    {
      adfPuesto = new ADFSalidaPuestoSLO();
    }
    init();    
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


  private synchronized void updateEstadoProceso() throws InterruptedException
  {
    while (!ePing && !eEndProcess && !eTimeOut)
    {
      wait();
    }
    if (eTimeOut)
      {
        eTimeOut = false;
        adfPuesto.maybeSacarMacPuesto();
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
    button.setProcessStarted();
    
    try
    {
      while (!eEndProcess)
      {
        try
        {
          updateEstadoProceso();        
        } 
        catch (oracle.jbo.AlreadyLockedException e)
        {
          // Hacer otro intento
          adfPuesto.rollback();
          LOG.error(getName(), e);
        }
      }
    } catch (Exception e)
    {
      LOG.fatal("Proces sortida lloc aturant per excepció:", e);
      button.setProcessStopped(e);
      adfPuesto.rollback();
    }
    String motivo = "Aturant el proces: " + getName();
    LOG.warn(motivo);
    button.setProcessStopped(motivo);
    
  }


  public static void main(String[] args)
  {
    SalidaPuesto puesto = new SalidaPuesto(SalidaPuesto.PUESTO_MINILOAD);
    Logger LOG = Logger.getLogger("puesto main test");
    
    puesto.start(null);
    try 
    {
      while (true)
      {
        Thread.sleep(10000);
        // puesto.pingProcess();
      }
        
    } catch (Exception ex) 
    {
      LOG.error("",ex);
    } 
    
  }
  
}