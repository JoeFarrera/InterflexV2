package sgalib;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public final class SgaJCheckCellEditor
    extends DefaultCellEditor
    implements TableCellEditor
{
  private static final String SI =
        new String("S");
  private static final String NO =
        new String("N");
 
  public SgaJCheckCellEditor(JCheckBox cb)
  {
    super(cb);
    cb.setHorizontalAlignment(SwingConstants.CENTER);
  }
 
  public Object getCellEditorValue()
  {
    return ((JCheckBox)getComponent()).isSelected()
              ? SI
              : NO;
  }
 
  /**
   * Quan arribem aqui, vol dir que l'usuari ha clicat sobre el checkbox i
   * Value conte el valor del checkbox abans de que hi cliqui a sobre, de manera
   * que hem de forçar el canvi d'estat en base a aquest valor.
   * Posteriorment, al metode editingStopped de la taula, actualitzem el valor 
   * del camp en base a l'actualització que hem fet del checkbox.
   * @return 
   * @param column
   * @param row
   * @param isSelected
   * @param value
   * @param table
   */
  public Component getTableCellEditorComponent( JTable table,
                                                Object value,
                                                boolean isSelected,
                                                int row,
                                                int column
                                              )
  {
    JCheckBox c = (JCheckBox)super.getTableCellEditorComponent(
                    table,
                    value,
                    isSelected,
                    row,
                    column
              );
    c.setEnabled(table.isCellEditable(row, column)); 
    
    String sino = null;
    if (value != null)
        //= (String)value;
      sino = value.toString();
    else
      sino = NO;
    c.setSelected(sino.equals(NO));
    return c;
  }
}

