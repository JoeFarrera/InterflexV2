package sgalib;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ProgressMonitor;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.uicli.jui.JUTableBinding;
import oracle.jbo.uicli.jui.JUTableSortModel;
import java.awt.datatransfer.*;

/**
 * Implementació avançada de JTable
 * Millores afegides:
 * - Permet ordenació per tots els camps
 * - Sobreecriu el comportament del doble click sobre una cel·la, de manera que
 *    si no es fa cap canvi, el registre no queda marcat com a modificat
 * - Estableix una amplada per defecte de les columnes segons la definicio dels
 *    camps de la taula
 * - Millora el comportament de les cel·les amb altres cellRenderers i cellEditors
 * - Permet definir una taula com a no modificable amb el mètode setEditable()
 * - Afegeix un popup amb l'opció d'imprimir la taula i copiar el contigut al portapapers
 * 
 */
public class SgaJTableTest extends JTable implements ActionListener
{
  Object valueInEdit; //cache the value given to the cell-editor
  JUTableSortModel tableSortModel = null;
  protected JPopupMenu popup = new JPopupMenu();
  
  private boolean editable = true;
  
  public SgaJTableTest()
  {
    createPopupMenu();
    
    //++++++++++++++++++++++++++++++++++++++++
    setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    setColumnModel(getColumnModel());
    
    //Listener per saber quan s'ha canviat una columna de posicio
    getTableHeader().addMouseListener(new MouseListener()
    {
      public void mouseClicked(MouseEvent e){};
      public void mousePressed(MouseEvent e){};
      public void mouseReleased(MouseEvent e)
      {        
        //SgaTableModel tableModel = (SgaTableModel)getModel();
        //tableModel.saveProperties(getTableHeader().getColumnModel());
      };
      public void mouseEntered(MouseEvent e){};
      public void mouseExited(MouseEvent e){};
    });
    //------------------------------------------

  }

  public void editingStopped(javax.swing.event.ChangeEvent e) 
  {
    // Take in the new value
    TableCellEditor editor = getCellEditor();
    if (editor != null)
    {
      if (editor instanceof DefaultCellEditor ) 
      {
        Component cellEditor = ((DefaultCellEditor)editor).getComponent();
        if (cellEditor instanceof JComboBox)
          ;
        else 
        {
          Object value = null;
          if (cellEditor instanceof JCheckBox)
            value = ((JCheckBox)cellEditor).isSelected() ? "N" : "S";
          else
            value = editor.getCellEditorValue(); 
          //compare if the value given to the cell editor is same as when the edit 
          //started. If so, do not call setValueAt(). 
          if ((valueInEdit != null && value != null && !value.equals(valueInEdit))
              || (valueInEdit == null && value != null)) 
            setValueAt(value, editingRow, editingColumn); 
        }
        removeEditor(); 
      }
    }   
  }


  public Component prepareEditor(TableCellEditor editor, int row, int column) 
  {
    // Agafem el valor de la cel·la abans que s'hi pugui fer cap modificació
    valueInEdit = getValueAt(row, column);
    
    if (editor instanceof DefaultCellEditor ) 
    {
        Component cellEditor = ((DefaultCellEditor)editor).getComponent();
        if (cellEditor instanceof JTextField)
        {
          // Mirem si el camp es editable o no          
          boolean isEditable = true;
          if (!editable && dataModel != null)
          {
             tableSortModel = (JUTableSortModel)dataModel;
             JUTableBinding mModel = tableSortModel.getTableBinding();
             oracle.jbo.uicli.binding.JUIteratorBinding iter = mModel.getIteratorBinding();
             if (iter.isIteratorMadeVisible())
             {
                oracle.jbo.RowSetIterator rsi = iter.getRowSetIterator();
                isEditable = iter.isFindMode();
             }
          }      
          ((JTextField)cellEditor).setEditable(isEditable); 
          ((JTextField)cellEditor).setEnabled(true);
          ((JTextField)cellEditor).setDisabledTextColor(Color.BLACK);
          ((JTextField)cellEditor).setSelectionColor(Color.CYAN);
        }           
    }        
    return super.prepareEditor(editor, row, column);
  }


  public void setModel(TableModel dataModel)
  {
/*    super.setModel(dataModel);
    try
    {
      SgaTableModel tableModel = (SgaTableModel)getModel();
      if (tableModel != null)
      {
        if (tableModel.hasPropertiesFile())
        {
          setAutoCreateColumnsFromModel(false);  
          tableModel.ajustarAmpladaColumnes(getTableHeader().getColumnModel().getColumns());
        }
        else
        {
          tableModel.getJUTableSortModel();
          setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          AttributeDef[] attrs = tableSortModel.getTableBinding().getAttributeDefs();
          for (int i = 0; i < attrs.length; i++)
          {
            // getDisplayWidth() ja te en compte que si no s'ha definit una amplada pel camp,
            // agafa la precissio
            int width = attrs[i].getUIHelper().getDisplayWidth(null)*5;
            if (width < attrs[i].getUIHelper().getLabel(null).length()*5)
              width = attrs[i].getUIHelper().getLabel(null).length()*5;
            this.getColumnModel().getColumn(i).setMinWidth(width);
          }
        }
      }
    }
    catch(Exception ex)
    {}
    //setColumns();*/
  }

  /**
   * Estableix si la taula es editable o no. En cas que no ho sigui,
   * si estem en findMode, serà l'unic cas en que es podra editar
   */
  public void setEditable(boolean editable)
  {
    this.editable = editable;
  }
  
  public boolean getEditable()
  {
    return this.editable;
  }
  
  
  private void createPopupMenu() {
      JMenuItem menuItem;

/*      //Create the menu item.
      menuItem = new JMenuItem("Imprimir Informe");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "print.gif", null));
      menuItem.addActionListener(this);      
      addPopupMenuItem(menuItem);
*/
      menuItem = new JMenuItem("Transferir al Portapapeles");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "copy.gif", null));
      menuItem.addActionListener(this);      
      addPopupMenuItem(menuItem);
      
      
      //popup.addSeparator();

      //Add listener to the text area so the popup menu can come up.
      MouseListener popupListener = new SgaPopupListener(popup);
      addMouseListener(popupListener);
  }
  

  public void actionPerformed(ActionEvent e) {
  
      JMenuItem source = (JMenuItem)(e.getSource());        
      System.out.println(source.getText());
      if (source.getText().equals("Imprimir Informe"))
        try
        {
          //report();
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
      else if (source.getText().equals("Transferir al Portapapeles"))
        try
        {
          transferirPortapapeles();
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }

  }
  
  public void addPopupMenuItem(JMenuItem menuItem)
  {
    popup.add(menuItem);
  }

  /**
   * Insertar popup menu item en la posición especificada
   * @param pos Posición donde insertar
   * @param menuItem
   */
  public void insertPopupMenuItem(JMenuItem menuItem, int pos)
  {
    popup.insert(menuItem, pos);
  }

  /**
   * Insertar un popup separator en la primera posición
   */
  public void insertPopupSeparator()
  {
    popup.insert(new JPopupMenu.Separator(), 0);
  }

  public void addPopupSeparator()
  {
    popup.addSeparator();
  }
  
  
  /*private void report() throws Exception
  {
    // initialize JFreeReport
    Boot.start();
    tableSortModel = (JUTableSortModel)this.getModel();
    //Report report = new Report(tableModel);
    final JFreeReport report = new Report(tableSortModel).createReport();
    report.setData(tableSortModel);

    final PreviewDialog dialog = new PreviewDialog(report);
    dialog.setModal(true);
    dialog.pack();
    dialog.setVisible(true);
  }*/

  public void transferirPortapapeles()
  {
     int numcols=getColumnCount();
     int numrows=getRowCount();
     Cursor normalCursor = new Cursor(Cursor.WAIT_CURSOR);
     setCursor(normalCursor);
     
     ProgressMonitor progressMonitor = new ProgressMonitor(this,
                                "Transfiriendo a Portapapeles",
                                "", 0, numrows);
      progressMonitor.setProgress(0);
      progressMonitor.setMillisToDecideToPopup(0);
      Thread test = new Thread(new TransferRunnable(numrows, numcols, progressMonitor, this));
      test.start();      
  }


  protected void makeRowVisible(int row) 
  {
    Rectangle cellRect = getCellRect(row, 0, true);
    if(cellRect != null) 
    {
      scrollRectToVisible(cellRect);
    }
  }


  public void makeSelectedRowVisible() 
  {
    makeRowVisible(getSelectedRow());
  }

  protected void setCellRenderer(String columnName, TableCellRenderer cellRenderer)
  {
    try
    {
      TableColumn tableColumn = getColumn(columnName);
      tableColumn.setCellRenderer(cellRenderer);
    }
    catch(IllegalArgumentException ex){}
  }

  protected void setCellEditor(String columnName, TableCellEditor cellEditor)
  {
    try
    {
      TableColumn tableColumn = getColumn(columnName);
      tableColumn.setCellEditor(cellEditor);
    }
    catch(IllegalArgumentException ex){}
  }

  private class TransferRunnable implements Runnable
  {
     Clipboard system;
     StringSelection stsel;  
     StringBuffer sbf=new StringBuffer();
     int numrows;
     int numcols;
     ProgressMonitor pm;
     SgaJTableTest table;
  
    public TransferRunnable(int numrows, int numcols, ProgressMonitor pm, SgaJTableTest table)
    {
     super();
     this.numrows = numrows;
     this.numcols = numcols;
     this.pm = pm;
     this.table = table;
    }

    public void run() 
    {
      //TODO : S'ha d'acabar de fer-ho be
       /*tableSortModel = (JUTableSortModel)dataModel;
       JUTableBinding mModel = tableSortModel.getTableBinding();
       
       RowIterator rows = mModel.getIteratorBinding().getNavigatableRowIterator();
       rows.reset();
       // Afegim primer la capçalera
       while (rows.hasNext())
       {
         Row row = rows.next();
         for (int j=0;j<row.gets.get;j++)
         {
           sbf.append(getTableHeader().getColumnModel().getColumn(j).getHeaderValue());
           if (j<numcols-1) sbf.append("\t");
         }
         sbf.append("\n");
        
       }*/
      for (int i=0;i<numrows && !pm.isCanceled();i++)
      {
         table.makeRowVisible(i);
         if (i == 0)
         {
           for (int j=0;j<numcols;j++)
           {
             sbf.append(getTableHeader().getColumnModel().getColumn(j).getHeaderValue());
             if (j<numcols-1) sbf.append("\t");
           }
           sbf.append("\n");
         }

         for (int j=0;j<numcols;j++)
         {
           sbf.append(getValueAt(i,j));
           if (j<numcols-1) sbf.append("\t");
         }
         sbf.append("\n");
         pm.setProgress(i);
         pm.setNote("Completados " + (i+1) + " de " + numrows);          
      }
      Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
      setCursor(normalCursor);

      if (!pm.isCanceled())
      {
        try
        {
          stsel  = new StringSelection(sbf.toString());
          system = Toolkit.getDefaultToolkit().getSystemClipboard();
          system.setContents(stsel,stsel);
          JOptionPane.showMessageDialog(null, "Transferencia Portapapeles Finalizada",
                                         "Transferencia Portapapeles",
                                         JOptionPane.PLAIN_MESSAGE);
          pm.close();                                         
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(null, "Error de transferencia al portapapeles: " + ex.getMessage(),
                                         "Transferencia Portapapeles",
                                         JOptionPane.ERROR_MESSAGE);
          
        }
      }
      else
        JOptionPane.showMessageDialog(null, "Transferencia Portapapeles Cancelada",
                                       "Transferencia Portapapeles",
                                       JOptionPane.PLAIN_MESSAGE);
      
      
    }
  } 

}