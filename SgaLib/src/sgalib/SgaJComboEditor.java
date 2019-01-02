package sgalib;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public final class SgaJComboEditor
    extends DefaultCellEditor
    implements TableCellEditor
{

  protected final ApplicationModule am;
  protected final String sourceViewObjectDef;
  protected final String descriptiveColumn;
  protected final String sourceKey;
 
  public SgaJComboEditor(ApplicationModule am, String sourceViewObjectDef, String sourceKey, String descriptiveColumn, JComboBox cb)
  {
    super(cb);
    if (am == null)
      throw new NullPointerException("null am");
    if (sourceViewObjectDef == null)
      throw new NullPointerException("null sourceViewObjectDef");
    if (sourceKey == null)
      throw new NullPointerException("null sourceKey");
    if (descriptiveColumn == null)
      throw new NullPointerException("null descriptiveColumn");
 
    this.am = am;
    this.sourceKey = sourceKey;
    this.sourceViewObjectDef = sourceViewObjectDef;
    this.descriptiveColumn = descriptiveColumn;
  }
 
 
  public Component getTableCellEditorComponent( JTable table,
                                                Object value,
                                                boolean isSelected,
                                                int row,
                                                int column
                                              )
  {
    table.setRowSelectionInterval(row, row);  
    JComboBox c = (JComboBox)super.getTableCellEditorComponent(
                    table,
                    value,
                    isSelected,
                    row,
                    column
              );    
    c.setEnabled(table.isCellEditable(row, column)); 
    c.setEditable(false); 
    
    if (value != null) 
    { 
      ViewObject vo = am.findViewObject(sourceViewObjectDef); 
      Key findKey = new Key(new Object[] { value });
      Row findRow = vo.getRow(findKey);
      if (findRow != null)
        value = findRow.getAttribute(descriptiveColumn);
    } 
    System.out.println("Value = " + value);  
    c.setSelectedItem(value); 
    
    return c;
  }
}
