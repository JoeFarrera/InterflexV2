package es.sysmap.interflex.control;
import org.apache.log4j.Logger;
import sgalib.MapObservable;
import sgalib.MapProcessButtonInterface;

public abstract class SgaProceso extends MapObservable implements Runnable
{
  Thread processThread;
  protected Logger LOG = Logger.getLogger(getClass());
  private final String processName;
  protected boolean eEndProcess = true;
  protected MapProcessButtonInterface button;
  
  
  public SgaProceso(String processName)
  {
    this.processName = processName;
  }
  
  
  protected String getName()
  {
    return processName;
  }
  
  public abstract void init();
  
  public void start(MapProcessButtonInterface button)
  {
    this.button = button;
    if (processThread != null && processThread.isAlive())
    {
      LOG.error("Intento de arrancar el proceso " + getName() + " ya en marcha");
      return;
    }
    processThread = new Thread (this);
    processThread.setDaemon(true);    
    processThread.start();    
  }

  public synchronized void stopProcess () 
  {
    eEndProcess = true;
    notifyAll ();
  }
  
  public boolean isAlive()  
  {
    return (processThread != null && processThread.isAlive()); 
  }
  
  abstract public void run();

}