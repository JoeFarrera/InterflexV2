package es.sysmap.interflex.control;

public class TimeOutTimer extends Thread
{
 /**
   *
   * crea el temporizador
   *
   *@param interval - intervalo en milisegundos
   *@param t - fuente del tratamiento al transurrir el intervalo
   *
   */

   private int interval;         // Tiempo de espera (en milisegundos)
   private boolean ignore; // Set cuando ya no se necesita
   private TimeOutListener listener;  // El que quiere saber la hora
   
  public TimeOutTimer (TimeOutListener listener, int timeOutMillis) 
  {
    this.listener = listener;
    interval = timeOutMillis;
    ignore = false;
    setDaemon (true);
    start();
  }


  /**
   *
   * arranca el timer
   *
   */
  public void run () {

    try {
       ignore = false;
       while (!isInterrupted ()) {
        sleep (interval);
        if (! ignore)
        {
          listener.setTimeOut();
        }
        else
        {
          ; // alarm.trace("Ignoring eTimeOut");
        }
      }
    }
    catch (InterruptedException e) {
      System.out.print ("This is the interrupted Exception in Timer.run() "+ e);
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