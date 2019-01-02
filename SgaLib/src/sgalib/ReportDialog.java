package sgalib;
import java.awt.Frame;
import javax.swing.JDialog;

public class ReportDialog extends JDialog
{
  private static ReportDialog _instance = null;
  

  public ReportDialog(Frame owner, String title, boolean modal)
  {
    super(owner, title, modal);
  }
  
  public static ReportDialog getInstance(Frame owner, String title, boolean modal)
  {
    if (_instance == null)
      _instance = new ReportDialog(owner, title, modal);
    else
    {
      _instance.setTitle(title);
      _instance.setModal(modal);
    }
    return _instance;
  }
  
  public static void close()
  {
    if (_instance != null)
      _instance.setVisible(false);
  }
}