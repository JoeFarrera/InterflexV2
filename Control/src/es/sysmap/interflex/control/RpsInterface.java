package es.sysmap.interflex.control;
import es.sysmap.interflex.rpsinterface.ADFGestorRps;

public class RpsInterface extends SgaProceso implements TimeOutListener
{
  private boolean eTimeOut = true;  // Para que se ejecuti al entrar
  private boolean ePing = false;
  private TimeOutTimer timer;
  
  private static final int TIMEOUT = 360000;  // Tiempo se timeout para el ciclo (1 hora)
  
  ADFGestorRps rps;
  

  public RpsInterface() throws Exception
  {
  super ("Rps Interface");
  }
  
   public void init()
  {
    timer = new TimeOutTimer(this, TIMEOUT);
    ePing = false;
    eTimeOut = true;  // Para que se ejecute al arrancar!!
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
      rps.updateRps();
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
    rps = new ADFGestorRps();
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

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    try 
    {
      RpsInterface rpsInterface = new RpsInterface();
      
    }
    catch (Exception ex) 
    {
      ; // TODO
    }
  }
}