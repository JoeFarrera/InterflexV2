package sgalib;
import java.awt.Rectangle;
import javax.swing.*;

public class SplashScreen extends JWindow 
{

  // Label que conté l'imatge splash
  private JLabel splashLabel = null;

  public SplashScreen(JFrame frame, ImageIcon imageIcon)
  {
    super(frame);
  	splashLabel = new JLabel(imageIcon);

    getContentPane().add(splashLabel);
    // Adaptem el tamany de la finestra al seu contingut
    pack();
    Rectangle screenRect = frame.getGraphicsConfiguration().getBounds();
    // Centrem la finestra splash
    setLocation(
       screenRect.x + screenRect.width/2 - getSize().width/2,
       screenRect.y + screenRect.height/2 - getSize().height/2);
  }
  
    /**
     * Mostra la pantalla splash mentre la resta de l'aplicació s'esta carregant
     */

    public void showSplashScreen()
    {
      show();
    }


    /**
     * Oculta la pantalla splash mentre la resta de l'aplicació s'esta carregant
     */

    public void hideSplash()
    {
      setVisible(false);
      splashLabel = null;
      this.dispose();
    }
  
}