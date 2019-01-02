package es.sysmap.interflex.control;
import java.lang.InterruptedException;

public class GestorDocSalida extends SgaProceso implements TimeOutListener
{
  /**
   * Timeout para buscar nuevos documentos para cada puesto
   * Se vuelca un documento cuando ya se ha reservado la totalidad del documento anterior
   */
  private static final int TIMEOUT = 20000; 
  private TimeOutTimer timer;
  private boolean eTimeOut = false;
  ADFGestorDocSalida adfGestor;
  

  public GestorDocSalida()
  {
    super("GestorDocSortida");
    init();
  }
  
  public synchronized void setTimeOut()
  {
    eTimeOut = true;
    notifyAll();
  }
  
  public void init()
  {
    timer = new TimeOutTimer(this, TIMEOUT);
  }

  
  public synchronized void run()
  {
    try
    {
      eTimeOut = false;
      eEndProcess = false;
      adfGestor = new ADFGestorDocSalida();
      button.setProcessStarted();
      while (!eEndProcess)
      {
        while (!eEndProcess && !eTimeOut)
        {
          wait();
        }
        if (eTimeOut)
        {
          eTimeOut = false;
          adfGestor.quizasAsignarDocumento();
          adfGestor.commit();
        }
      }
    } 
    catch (InterruptedException e)
    {
      LOG.error("proces " + getName() + " interrumput");
    }
    catch (Exception ex)
    {
      LOG.error("proces: " + getName(), ex);
      button.updateButton(ex.toString());
    }
    button.setProcessStopped("Proces sortint");
    LOG.warn("Proces " + getName() + " sortint");
    
  }


}