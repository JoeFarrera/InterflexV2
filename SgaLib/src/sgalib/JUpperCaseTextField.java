package sgalib;

import java.awt.Color;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Implementar JTextField en mayisculas con control de columnas
 * Autor: Xavi Marfull
 * Modificado: Michael 09.06.2004 inner class UpperCaseDocument referencia getColumns()
 *             del JTextField para determinar columnas permitidas
 */
public class JUpperCaseTextField extends JTextField {

  public JUpperCaseTextField() 
  {
    super();
  }

  public JUpperCaseTextField(int columns) 
  {
    super(columns);
  }

  protected Document createDefaultModel() 
  {
    return new UpperCaseDocument(getColumns());
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
  

  /**
   * Mayusculas y control de columnas
   */
  private class UpperCaseDocument extends PlainDocument 
  {

    public UpperCaseDocument(int columns)
    {
      super();
    }
    
    public void insertString(int offs, String str, AttributeSet a) 
      throws BadLocationException 
    {      
      if (str == null) 
      {
        return;
      }
      
      char[] upper = str.toCharArray();
      for (int i = 0; i < upper.length; i++) 
      {
        upper[i] = Character.toUpperCase(upper[i]);
      }
      // Xavi, 02/04/05: Desactivo la funcionalitat de limitar el nombre de caracters
//      if (upper.length + offs <= getColumns())
//      {
        super.insertString(offs, new String(upper), a);      
//      }
//      else
//      {
//        Toolkit.getDefaultToolkit().beep();
//      }
    }    
  }
}
