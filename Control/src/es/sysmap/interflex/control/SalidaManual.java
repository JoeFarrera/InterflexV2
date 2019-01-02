package es.sysmap.interflex.control;
import es.sysmap.interflex.control.ADFSalidaManual;

public class SalidaManual extends SgaProceso implements TimeOutListener
{
  private ADFSalidaManual adf;
  private TimeOutTimer timer;
  private static int TIMEOUT = 10000;
  private boolean eTimeOut = false;

  public SalidaManual()
  {
    super("SortidaManual");
    init();

  }

  public void init()
  {
    timer = new TimeOutTimer(this, TIMEOUT);
  }
  
  public synchronized void setTimeOut()
  {
    eTimeOut = true;
    notifyAll();
  }

  
  public void run()
  {
    eTimeOut = false;
    eEndProcess = false;
    adf = new ADFSalidaManual();
    adf.init();
    button.setProcessStarted();
    try
    {
    while (!eEndProcess)
    {
      synchronized (this)
      {
      try
      {
        while (!eEndProcess && !eTimeOut)
          wait();
        if (eTimeOut)
        {
          eTimeOut = false;
          while (adf.quizasReservar())
            ;
        }
      }
      catch (InterruptedException ie)
      {
        ; // nada
      }
      }
    }
      
    }
    catch (Exception e)
    {
      button.updateButton("Sortint per error: " + e);
      adf.rollback();
      LOG.fatal("Sortint del proces: " + getName() + " per error:", e);
    }
    button.setProcessStopped("Proces aturat");
    LOG.info ("Proces " + getName() + " aturat");
  }
}