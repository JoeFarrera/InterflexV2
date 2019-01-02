package sgalib;
import java.awt.Color;
import javax.swing.JTextField;

public class SgaJTextField extends JTextField 
{
  public SgaJTextField()
  {
    super();
  }
  
  // Si el textfield esta deshabilitat, el color de fons continua sent blanc, tot 
  // i que el text apareixera en gris
  // Això millora la visibilitat
  public Color getBackground() 
  {
    if(isEditable())
      return super.getBackground();
    else
      return (Color.WHITE);
  }
  
}