package sgalib;
import java.awt.Cursor;
import javax.swing.JFrame;

public interface SgaMainFrameInterface 
{
  public void showHelpWindow(String topicID);
  public void setCursor(Cursor cursor);
  public JFrame getFrame();
}