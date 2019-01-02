package es.sysmap.interflex.controltest;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.UIManager;
import java.awt.Dimension;
import oracle.jbo.domain.Number;

public class TestControl 
{
  public TestControl()
  {
    Frame frame = new TestFrame();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
    {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width)
    {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          System.exit(0);
        }
      });
    frame.setVisible(true);
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
  
  
  
  // Testing
            Number taraStandard = new Number(200);
          Number taraActual = new Number(290);
          Number toBeSet = new Number(0);
            // Michael 14.05.2008 Sólo hacer si tenemos tara actual
          if (taraActual != null)
          {
            if (taraStandard != null  && taraStandard.compareTo(0) > 0)
            {
            if (!(taraStandard.subtract(taraActual).abs().compareTo(taraStandard.divide(2)) > 0))
              if (taraActual != null)
                toBeSet = taraActual;
            }
            else
//Michael 19.01.2009
//              if (taraActual != null)
//                setTara(taraActual);
                if (taraActual == null)
                  toBeSet = taraStandard;
// Michael 19.01.2009 fin
            
            // Michael 12.01.2007 Fin          
          } // Michael 14.05.2008

  
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    new TestControl();
  }
}