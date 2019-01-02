package sgalib;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.SystemColor;

public final class SgaJCheckCellRenderer extends DefaultTableCellRenderer
{
  protected final String onValue;
  protected final String offValue;
  protected final static Border emptyBorder
      = new EmptyBorder(1, 1, 1, 1);
 

  public SgaJCheckCellRenderer()
  {
    this.onValue = "S";
    this.offValue = "N";
  }  
  public SgaJCheckCellRenderer(String onValue, String offValue)
  {
    this.onValue = onValue;
    this.offValue = offValue;
  }
 
  public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column)
  {
    boolean state = false;
    
    if (String.valueOf(value).equals(onValue))
      state = true;
    else if (String.valueOf(value).equals(offValue))
      state = false;
    else if (value == null)
    {
      state = false;
      //System.out.println("ATENCION: VALOR DESCONOCIDO: null");
    }
    else
      throw new IllegalStateException("ATENCION: VALOR DESCONOCIODO: " + value);
 
    JCheckBox box = new JCheckBox();
    box.setSelected(state);
    box.setHorizontalAlignment(SwingConstants.CENTER);
    if (isSelected)
      box.setBackground(SystemColor.window);      
    else
      box.setBackground(SystemColor.window);
 
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setEnabled(table.isCellEditable(row, column));
    panel.add(box, BorderLayout.CENTER);
    if (hasFocus)
      panel.setBorder( UIManager.getBorder("Table.focusCellHighlightBorder") );
    else
      panel.setBorder( emptyBorder );
    if (isSelected)
      //panel.setBackground(SystemColor.textHighlight);
      panel.setBackground(SystemColor.desktop);
    else
      panel.setBackground(SystemColor.window);
    return panel;
  }
}

