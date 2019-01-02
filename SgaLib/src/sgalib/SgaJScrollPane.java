package sgalib;
import java.awt.Component;
import javax.swing.JScrollPane;

public class SgaJScrollPane extends JScrollPane
{
  String topicId = null;
  
  public SgaJScrollPane(Component view, String topicId) 
  {  
    super(view);
    this.topicId = topicId;
  }

  public void setTopicId(String topicId)
  {
    this.topicId = topicId;
  }

  public String getTopicId()
  {
    return this.topicId;
  }
}