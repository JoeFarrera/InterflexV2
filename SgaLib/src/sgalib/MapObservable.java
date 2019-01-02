package sgalib;
import java.util.Observable;
import java.util.Observer;

/**
 * Notificar observers siempre (setChanged() antes de cualquier notificación
 */
public class MapObservable extends Observable 
{
  /**
   * Indicar cuando un nuevo observador ha sido añadido
   */
  private boolean newObservers = false;  
  public MapObservable()
  {
  }
  
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    newObservers = true;
  }
  
  /**
   * Notificar observers siempre
   * @param arg
   */
  public void notifyObservers(Object arg)
  {
    setChanged();
    super.notifyObservers(arg);
    newObservers = false;
  }
  
  public boolean hasNewObservers()
  {
    return newObservers;
  }
  
  
}