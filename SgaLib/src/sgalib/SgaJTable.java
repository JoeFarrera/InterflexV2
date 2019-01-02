package sgalib;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ProgressMonitor;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.jui.JUTableBinding;
import oracle.jbo.uicli.jui.JUTableSortModel;
import java.awt.datatransfer.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

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
public class SgaJTable extends JTable implements ActionListener
{
  Object valueInEdit; //cache the value given to the cell-editor
  JUTableSortModel tableSortModel = null;
  protected JPopupMenu popup = new JPopupMenu();
  
  private boolean editable = true;
  private String sReportTitle = "Listado";
  private boolean bLandscape = false;
  
  public SgaJTable()
  {
    createPopupMenu();
  }
  
  

  public SgaJTable(String sReportTitle, boolean bLandscape)
  {
    this();
    this.sReportTitle = sReportTitle;
    this.bLandscape = bLandscape;
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
    super.setModel(dataModel);
    try
    {
      if (dataModel != null)
      {
        tableSortModel = (JUTableSortModel)dataModel;
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        AttributeDef[] attrs = tableSortModel.getTableBinding().getAttributeDefs();
        for (int i = 0; i < attrs.length; i++)
        {
//          int width = attrs[i].getUIHelper().getDisplayWidth(null)*5;
//          if (width == 0)
//          int width = (attrs[i].getPrecision() > 0 ? attrs[i].getPrecision()*5 : 20*5);
          // getDisplayWidth() ja te en compte que si no s'ha definit una amplada pel camp,
          // agafa la precissio
          int width = attrs[i].getUIHelper().getDisplayWidth(null)*5;
          if (width < attrs[i].getUIHelper().getLabel(null).length()*5)
            width = attrs[i].getUIHelper().getLabel(null).length()*5;
          this.getColumnModel().getColumn(i).setMinWidth(width);
          
        }
      }      
    }
    catch(Exception ex)
    {}
    //setColumns();
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
  
  
  /**
   * Estableix el format per defecte del llistat
   */
  public void setLandscape(boolean bLandscape)
  {
    this.bLandscape = bLandscape;
  }
  
  public boolean getLandscape()
  {
    return this.bLandscape;
  }

  /**
   * Estableix el titol per defecte del llistat
   */
  public void setReportTitle(String sReportTitle)
  {
    this.sReportTitle = sReportTitle;
  }
  
  public String getReportTitle()
  {
    return this.sReportTitle;
  }
  
  private void createPopupMenu() {
      JMenuItem menuItem;

      //Create the menu item.
      menuItem = new JMenuItem("Imprimir Informe");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/printer.png", null));
      menuItem.addActionListener(this);      
      addPopupMenuItem(menuItem);

      menuItem = new JMenuItem("Transferir al Portapapeles");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/copy.png", null));
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
          report();
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

  private void report() 
  {
    try
    {
      String sWhereClause = ((ViewObjectImpl)tableSortModel.getTableBinding().getViewObject()).getViewCriteriaClause();
      
      //JDialog jframe = new JDialog(SgaMainFrame.getInstance().getFrame(), "Datos Informe", false);
      JDialog jframe = ReportDialog.getInstance(SgaMainFrame.getInstance().getFrame(), "Datos Informe", false);
      JTableReport tableReport = new JTableReport(new JTable(this.getModel()), sReportTitle, bLandscape, sWhereClause);
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setLayout(null);
      jframe.getContentPane().add(tableReport);
      jframe.setSize(new Dimension(600,250));
      jframe.setVisible(true);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);    
    }
  }

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
    scrollToCenter(row, 0);
    /*Rectangle cellRect = getCellRect(row, 0, true);
    if(cellRect != null) 
    {
      scrollRectToVisible(cellRect);
    }*/
  }


  public void makeSelectedRowVisible() 
  {
    makeRowVisible(getSelectedRow());
    
  }

  // Assumes table is contained in a JScrollPane. Scrolls the
  // cell (rowIndex, vColIndex) so that it is visible at the center of viewport.
  protected void scrollToCenter(int rowIndex, int vColIndex) {
      if (!(getParent() instanceof JViewport)) {
          return;
      }
      JViewport viewport = (JViewport)getParent();
  
      // This rectangle is relative to the table where the
      // northwest corner of cell (0,0) is always (0,0).
      Rectangle rect = getCellRect(rowIndex, vColIndex, true);
  
      // The location of the view relative to the table
      Rectangle viewRect = viewport.getViewRect();
  
      // Translate the cell location so that it is relative
      // to the view, assuming the northwest corner of the
      // view is (0,0).
      rect.setLocation(rect.x-viewRect.x, rect.y-viewRect.y);
  
      // Calculate location of rect if it were at the center of view
      int centerX = (viewRect.width-rect.width)/2;
      int centerY = (viewRect.height-rect.height)/2;
  
      // Fake the location of the cell so that scrollRectToVisible
      // will move the cell to the center
      if (rect.x < centerX) {
          centerX = -centerX;
      }
      if (rect.y < centerY) {
          centerY = -centerY;
      }
      rect.translate(centerX, centerY);
  
      // Scroll the area into view.
      viewport.scrollRectToVisible(rect);
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
     SgaJTable table;
  
    public TransferRunnable(int numrows, int numcols, ProgressMonitor pm, SgaJTable table)
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

  public int getColumnIndex(String columnName){
    	int noCols = tableSortModel.getColumnCount();
    	int colIndex = -1;
    	for (int j = 0; j < noCols && colIndex == -1; j++)
    		if(tableSortModel.getColumnName(j).equals(columnName))
    			colIndex = j;
    	return colIndex;
    }

}