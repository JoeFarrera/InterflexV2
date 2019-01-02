package sgalib;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.Row;
import oracle.jbo.Key;
 
public class SgaJComboRenderer extends DefaultTableCellRenderer
{
  protected final ApplicationModule am;
  protected final String sourceViewObjectDef;
  protected final String descriptiveColumn;
  protected final String sourceKey;
 
  public SgaJComboRenderer(ApplicationModule am, String sourceViewObjectDef, String sourceKey, String descriptiveColumn)
  {
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
 
  public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column)
  {
    if (value != null) 
    { 
      ViewObject vo = am.findViewObject(sourceViewObjectDef); 
      Key findKey = new Key(new Object[] { value });
      Row findRow = vo.getRow(findKey);
      if (findRow != null)
        value = findRow.getAttribute(descriptiveColumn);
    } 
    JComboBox cb = new JComboBox(); 
    cb.setEnabled(table.isCellEditable(row, column)); 
    cb.setEditable(false); 
    if (value != null) 
      cb.addItem(String.valueOf(value)); 
    cb.setSelectedItem(value); 
    return cb; 
  }                  
}
