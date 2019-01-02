package es.sysmap.interflex.control;
import sgalib.SgaUtilPuesto;

public class ReservaPuesto extends SgaProceso implements TimeOutListener
{
  private ADFReservaPuesto adf;
  private TimeOutTimer timer;
  private static int TIMEOUT = 10000;
  private boolean eTimeOut = false;

  public ReservaPuesto()
  {
    super("ReservaLlocTreball");
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
    adf = new ADFReservaPuesto();
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
      // 20.05.2005
      catch (oracle.jbo.DMLConstraintException conE)
      {
        // Se intenta reservar más de una reserva que ya hay ?
        // TODO: Ver de acotar el error exacto / eliminarlo ?
        LOG.error(getName() + "DMLConstraintError:", conE);
        adf.rollback();
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