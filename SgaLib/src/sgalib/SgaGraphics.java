package sgalib;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*; 

public class SgaGraphics 
{
  static Font font = new Font("lucida sans demibold", Font.PLAIN, 18);    
  public static final int        UP    = 0,        
                          LEFT  = 1,        
                          DOWN  = 2,        
                          RIGHT = 3;
  public SgaGraphics()
  {
  }

  public static void dibuixarRectangle(Graphics2D g, int x, int y, int width, 
                                  int height, Color color, int strokeWidth)
  {
    Stroke stroke;
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.black);      
    stroke = g2.getStroke();
    g2.setStroke(new BasicStroke(strokeWidth));      
    g2.drawRect(x, y, width, height);      
    g2.setColor(color);
    g2.fill3DRect(x + strokeWidth, y + strokeWidth, width - (2 * strokeWidth), 
                  height - (2 * strokeWidth), true);
    g2.setStroke(stroke);
  }
  
  public static void dibuixarFletxaHoritzontal(Graphics2D g2, Color color, int x, int y,
                                        int length, int strokeWidth, String id, int orientation)    
  {      
    Stroke stroke;
    stroke = g2.getStroke();
    g2.setStroke(new BasicStroke(strokeWidth));
    Color origColor = g2.getColor();        
    g2.setPaint(color);        
    g2.draw(new Line2D.Double(x, y, x + length, y));        
    if(orientation == LEFT)        
      {
        g2.draw(new Line2D.Double(x, y, x + 8, y - 8));            
        g2.draw(new Line2D.Double(x, y, x + 8, y + 8));        
      }        
    else        
      {            
        g2.draw(new Line2D.Double(x + length, y, x + length - 8, y - 8));            
        g2.draw(new Line2D.Double(x + length, y, x + length - 8, y + 8));        
      }        
    Font origFont = g2.getFont();        
    g2.setFont(font);        
    FontRenderContext frc = g2.getFontRenderContext();        
    float width = (float)font.getStringBounds(id, frc).getWidth();        
    LineMetrics lm = font.getLineMetrics(id, frc);        
    float sx = x + (length - width)/2;        
    float sy = y - lm.getDescent();        
    g2.drawString(id, sx, sy);        
    g2.setPaint(origColor);        
    g2.setFont(origFont);   
    g2.setStroke(stroke);
  }  
  
  public static void dibuixarFletxaVertical(Graphics2D g2, Color color, int x, int y,                                     
                                    int length, int strokeWidth, String id, int orientation)    
  {        
    Stroke stroke;
    stroke = g2.getStroke();
    g2.setStroke(new BasicStroke(strokeWidth));
    Color origColor = g2.getColor();        
    g2.setPaint(color);        
    g2.draw(new Line2D.Double(x, y, x, y + length));        
    if(orientation == UP)        
      {            
        g2.draw(new Line2D.Double(x, y, x - 8, y + 8));            
        g2.draw(new Line2D.Double(x, y, x + 8, y + 8));        
      }        
    else        
      {            
        g2.draw(new Line2D.Double(x, y + length, x - 8, y + length - 8));            
        g2.draw(new Line2D.Double(x, y + length, x + 8, y + length - 8));        
      }        
    Font origFont = g2.getFont();        
    g2.setFont(font);        
    FontRenderContext frc = g2.getFontRenderContext();        
    float width = (float)font.getStringBounds(id, frc).getWidth();        
    LineMetrics lm = font.getLineMetrics(id, frc);        
    float height = lm.getAscent();        
    float sx = x - (width + 4);        
    float sy = y + (length + height)/2;        
    g2.drawString(id, sx, sy);        
    g2.setPaint(origColor);        
    g2.setFont(origFont);  
    g2.setStroke(stroke);
  }  
}