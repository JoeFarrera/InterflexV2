package sgalib;
import java.awt.Component;
import javax.swing.JPanel;
import oracle.javatools.dialogs.progress.DeterminateProgressMonitor;
import oracle.javatools.dialogs.progress.ProgressPanel;

public class SgaProgressMonitor extends DeterminateProgressMonitor
{
  private static SgaProgressMonitor _instance;
  
 
  public SgaProgressMonitor (Component parent,
    String title,
    Object message,
    String note)
    {
     super(parent, title, message, note, 1, 10);
    }
    
  
  
  public static SgaProgressMonitor getInstance(Component parent,
        String title,
        Object message,
        String note)
    {
      if (_instance == null)
      {
        _instance = new SgaProgressMonitor (parent, title, message, note);
      }
      else
      {
        SgaProgressMonitor pm = _instance;
        ProgressPanel pan = pm.getPanel();
        pan.setMessage((String)message);
        pan.setNote(note);
        // TODO - y el title ???
        pm.setProgress(1);
        pm.display();
                
      }
      return _instance;
    }
    
  
  public static void maybeDisplay(String message, String note)
  {
    if (_instance != null)
    {
      SgaProgressMonitor pm = _instance;
      ProgressPanel pan = pm.getPanel();
      pan.setMessage((String)message);
      pan.setNote(note);
      pm.setProgress(1);
      pm.display();
    }
  }
  
  public static void maybeSetMaximum (int maximum)
  {
    if (_instance != null)
      _instance.setMaximum(maximum);
  }

  public static void maybeSetCancellable (boolean cancellable)
  {
    if (_instance != null)
      _instance.setCancellable(cancellable);
  }
  
  public static void incProgress(String note)
  {
    if (_instance != null)
    {
      _instance.incProgress(1);
      _instance.getPanel().setNote(note);
    }
  }
  
  public void close()
  {
    super.close();
    _instance = null;
  }
  
  
  
}