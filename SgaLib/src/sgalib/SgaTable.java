package sgalib;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;
import java.sql.Timestamp;
import java.text.*;
//import oracle.jbo.uicli.jui.JUTableModel;
import oracle.jbo.*;
import oracle.jbo.uicli.jui.*;

public class SgaTable extends JTable
{
  Object valueInEdit; //cache the value given to the cell-editor
  
  public SgaTable ()
  { 
    // Fixem l'amplada minima de la fila
    setRowHeight(17);
  }
  
  public void editingStopped(javax.swing.event.ChangeEvent e) 
  {
    // Take in the new value
    TableCellEditor editor = getCellEditor();
    if (editor instanceof DefaultCellEditor ) 
    {
      Component cellEditor = ((DefaultCellEditor)editor).getComponent();
      if (cellEditor instanceof JComboBox)
        //  || cellEditor instanceof JCheckBox)
        removeEditor();
      else
      {
        Object value = editor.getCellEditorValue(); 
        //compare if the value given to the cell editor is same as when the edit 
        //started. If so, do not call setValueAt(). 
//        if ((valueInEdit != null && value != null && !value.equals(valueInEdit))) 
        try
        {
          if (!value.equals(valueInEdit)) 
          { 
            setValueAt(value, editingRow, editingColumn); 
          } 
        }
        catch(Exception ex){}
        removeEditor(); 
        //super.editingStopped(e);
      }
    }   
  }

    //Swing JTable calls this method to get the editor for a cell.
    //If the editor is the installed combobox, set selected item in the
    //combobox to the value shown in that cell and return the combobox.
    //Fem que només es puguin escriure maiuscules
    public Component prepareEditor(TableCellEditor editor, int row, int column) 
    {
      valueInEdit = getValueAt(row, column);
      //test();
        //if (editor instanceof DefaultCellEditor ) 
        {
            // Xavi, 30/06/03: De moment, deixem escriure maiuscules i minuscules
            // als camps de la taula
            //Component cellEditor = ((DefaultCellEditor)editor).getComponent();
            //if (cellEditor instanceof JTextField)
            //{
            //   ((JTextField)cellEditor).setDocument(new UpperCaseDocument());
            //}
            /*else
            {
              if (cellEditor instanceof JComboBox
                  || cellEditor instanceof JCheckBox)
              {
                this.setRowSelectionInterval(row, row);
//                jComboBox.setSelectedItem(getValueAt(row, column));                
                return cellEditor;
              }              
            }*/
        }        
        return super.prepareEditor(editor, row, column);
    }
    
    public void test()
    {
      JUTableSortModel model = (JUTableSortModel)getModel();
      getColumn("Franja Horaria").setCellRenderer(new MyRenderer());
      System.out.println(model.getTableBinding().getViewObject().getName());
      //tableSgaexistenciaView1.getColumn(panelBinding.getLabel("SgaexistenciaView1", "Idexist", null)).setPreferredWidth(150);
      //binding
    }

private class MyRenderer extends JLabel implements TableCellRenderer {
    public Component getTableCellRendererComponent(
                            JTable table, Object color,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
        JUTableBinding panelBinding = (JUTableBinding)(((JUTableSortModel)table.getModel()).getTableBinding());
        //table.getColumn(panelBinding.getTooltip("SgaexistenciaView1", "Idexist"));
        String str = panelBinding.getViewObject().getName();
        AttributeDef attr [] = panelBinding.getViewObject().getAttributeDefs();
        for (int i = 0; i < attr.length; i++)
          System.out.println(attr[i].getName() + " " + attr[i].getColumnName());
        try{
        setToolTipText(panelBinding.getTooltip(panelBinding.getViewObject().getName(), "FECHA"));
        }
        catch(Exception ex){}
        return this;
                            }
    }
}

