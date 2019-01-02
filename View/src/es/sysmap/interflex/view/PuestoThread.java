package es.sysmap.interflex.view;
import com.sun.java.help.impl.SwingWorker;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow; 
import java.util.Iterator;
import java.util.Set;
import javax.swing.SwingUtilities;
import oracle.jbo.RowSet;
import org.apache.log4j.Logger;

public class PuestoThread extends Thread
{
 /**
   *
   * crea el temporizador
   *
   *@param interval - intervalo en milisegundos
   *@param t - fuente del tratamiento al transurrir el intervalo
   *
   */

   private Logger LOG = Logger.getLogger(getClass()); 
  
   private int interval;         // Tiempo de espera (en milisegundos)
   private boolean ignore; // Set cuando ya no se necesita
   private PuestoListener listener;  // El que quiere saber la hora
   private Set ubics;             // Ubicacions en que esta interessat el listener
   private AppModule appModule = null;
   
   private String ubicsWhereClause = "";
   private String idPuesto;
   

   
   
  public PuestoThread (PuestoListener listener, Set ubics, AppModule appModule, int timeOutMillis, String puesto) 
  {
    this.idPuesto = puesto;
    this.listener = listener;
    this.ubics = ubics;
    this.appModule = appModule;
    interval = timeOutMillis;
    ignore = false;
    setDaemon (true);
    
    // construim la clausula where
    Iterator iter = ubics.iterator();
    int i = 0;
    while (iter.hasNext())
    {
      if (i > 0)
        ubicsWhereClause = ubicsWhereClause.concat(",");
      ubicsWhereClause = ubicsWhereClause.concat("'").concat((String)iter.next()).concat("'");
      i++;
    }
    start();
  }

private void runInSwingThread() {
  SwingUtilities.invokeLater(new Runnable() {
    public void run() {

          
          int liniesSortidaObertes;
 
          RowSet rowSet = appModule.macsEnPuesto(ubicsWhereClause, "R");
          rowSet.reset();
          while (rowSet.hasNext())
          {
            SgamacEnPuestoViewRow macEnPuesto = (SgamacEnPuestoViewRow)rowSet.next();
            listener.setMacEnPuesto(macEnPuesto);
          }
          
          liniesSortidaObertes = appModule.getLiniesSortidaObertes(idPuesto);
          listener.setSalidasMaxiObertes(liniesSortidaObertes);

    }
  });
}

  /**
   *
   * arranca el timer
   *
   */
  public void run () {

    try {
       ignore = false;
       int liniesSortidaObertes;
      
       while (!isInterrupted ()) {
        sleep (interval);
        if (! ignore)
        {
//          RowSet rowSet = appModule.macsEnPuesto(ubicsWhereClause, "R");
//          rowSet.reset();
//          while (rowSet.hasNext())
//          {
//            SgamacEnPuestoViewRow macEnPuesto = (SgamacEnPuestoViewRow)rowSet.next();
//            listener.setMacEnPuesto(macEnPuesto);
//          }
//          
//          liniesSortidaObertes = appModule.getLiniesSortidaObertes(idPuesto);
//          listener.setSalidasMaxiObertes(liniesSortidaObertes);
          runInSwingThread();
          
        }
        else
        {
          ; // alarm.trace("Ignoring eTimeOut");
        }
      }
    }
    catch (InterruptedException e) {
      LOG.info("This is the interrupted Exception in Timer.run() ", e);
    }
  }

  /**
   *
   * fija el intervalo del temporizador
   *
   * @param  interval  - intervalo en milisegundos
   *
   */
  public void setInterval (int interval) {
    this.interval = interval;
  }

  /**
   * Set ignore flag
   **/

   public void ignore () 
   {
     ignore = true;
   }

   public void activate ()
   {
     ignore = false;
   }
}