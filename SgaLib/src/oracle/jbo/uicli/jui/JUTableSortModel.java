/*
 * @(#)JUTableSortModel.java
 *
 * Copyright 2002 by Oracle Corporation,
 * 500 Oracle Parkway, Redwood Shores, California, 94065, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Oracle Corporation.
 */

package oracle.jbo.uicli.jui;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.common.Diagnostic;
//import oracle.jbo.common.JBOClass;

/**
 * Implements a sorting filter over JUTableBinding's TableModel such that when 
 * a user clicks (or Shift_click) on a column header of the Table, the display
 * of rows from the JUTableBinding (and hence BC4J), is sorted by that column.
 * <p>
 * This class is a customization of TableSorter in Sun's JFC example that
 * can also be found at (JDEVELOPER_HOME)/jdk/demo/jfc/TableExample. For details
 * on how the basic TableSorter works, please see this JFC example.
 * <p>
 * This class implements the following enhancements over the base Sun's TableSorter:
 * <li> preserves sort-column. So when in a master detail scenario, if the master
 * changes, the next detail set is still sorted by the desired column.
 * <li> provides additional compare logic for oracle.jbo.domain.Number and 
 * oracle.jbo.domain.Date objects.
 * <li> provides reset feature. Resets the sorted display to the default
 * order on a click on the sorted column header.
 */
public class JUTableSortModel extends AbstractTableModel implements TableModelListener 
{
   final byte DOMAIN_NUMBER = 0;
   final byte DOMAIN_DATE   = 1;
   final byte TYPE_STRING   = 2;
   final byte TYPE_DATE     = 4;
   final byte TYPE_NUMBER   = 8;
   final byte TYPE_BOOLEAN  = 16;
   final byte TYPE_OBJECT   = 32;


   boolean    mAscending = true;
   byte       mSortColType = TYPE_OBJECT;
   int        mRangeStart = 0 ; //for Sort stuff to get this fast.

   JUTableBinding mModel;

   /**
   * Default Constructor just coz, base class has it.
   */
   public JUTableSortModel()
   {
   }

   /**
   * Constructor that sets up this sorting model on top of the existing Table model.
   */
   public JUTableSortModel(JUTableBinding model)
   {
      setTableBinding(model);
   }

   /**
   * Sets the TableModel on top of which this sorter works.
   */
   protected void setTableBinding(JUTableBinding mdl) 
   {
      mModel = mdl;
      mdl.addTableModelListener(this); 
   }


   public void tableChanged(TableModelEvent e)
   {
      int rangeStart = mModel.getIteratorBinding().getNavigatableRowIterator().getRangeStart();
      mRangeStart = (rangeStart > -1) ? rangeStart : 0;

      fireTableChanged(e);
   }

   public Object getValueAt(int aRow, int aColumn)
   {
      return mModel.getValueAt(aRow, aColumn);
   }

   public void setValueAt(Object aValue, int aRow, int aColumn)
   {
      mModel.setValueAt(aValue, aRow, aColumn);
   }

   public int getRowCount() 
   {
      return (mModel == null) ? 0 : mModel.getRowCount(); 
   }

   public int getColumnCount() 
   {
      return (mModel == null) ? 0 : mModel.getColumnCount(); 
   }
  
   public String getColumnName(int aColumn) 
   {
      return (mModel == null) ? null : mModel.getColumnName(aColumn); 
   }
                               
   public Class getColumnClass(int aColumn) 
   {
      return (mModel == null) ? null : mModel.getColumnClass(aColumn); 
   }
  
   public boolean isCellEditable(int aRow, int aColumn) 
   { 
      return mModel.isCellEditable(aRow, aColumn);
   }

   /**
   * Stores the mSortColIndex if it has changed. Also resets the
   * sorted indices if mSortColIndex is changed.
   */
   public void sortByColumn(String columnName, boolean ascending) 
   {
      JTable jTable = (JTable)mModel.getControl();
      String orderByClause = columnName + " " + (ascending ? "asc" : "desc");
      mModel.getIteratorBinding().getViewObject().setOrderByClause(orderByClause);
      mModel.getIteratorBinding().getViewObject().executeQuery();

      // Fem que sempre se seleccioni la primera fila despres d'ordenar
      jTable.setRowSelectionInterval(0, 0);
      
      fireTableChanged(new TableModelEvent(this)); 
      
      // Fi comentat per xavi
      
   }


   /**
   *  Override to add an action by which to reset the sorting order to the fetch order
   *  If one clicks on the same column again (or the Shift+click if the current sorting order
   *  is descending), then the Table resorts to the default row order as returned by BC4J.
   */
   public void addMouseListenerToHeaderInTable(JTable table) 
   { 
      final JUTableSortModel sorter = this; 
      final JTable tableView = table; 
      tableView.setColumnSelectionAllowed(false); 

      MouseAdapter listMouseListener = new MouseAdapter() 
      {
         public void mouseClicked(MouseEvent e) 
         {
            TableColumnModel columnModel = tableView.getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX());
            int column = columnModel.getColumn(viewColumn).getModelIndex();
            
            String columnName = sorter.getTableBinding().getAttributeDef(column).getName();
            if(e.getClickCount() == 1 && column != -1) 
            {
               int shiftPressed = e.getModifiers()&InputEvent.SHIFT_MASK; 
               boolean ascending = (shiftPressed == 0); 
               sorter.sortByColumn(columnName, ascending); 
            }
/*            TableColumnModel columnModel = tableView.getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX()); 
            int column = tableView.convertColumnIndexToModel(viewColumn); 
            String columnName = sorter.getTableBinding().getAttributeDef(viewColumn).getName();
            if(e.getClickCount() == 1 && column != -1) 
            {
               int shiftPressed = e.getModifiers()&InputEvent.SHIFT_MASK; 
               boolean ascending = (shiftPressed == 0); 
               sorter.sortByColumn(columnName, ascending); 
            }*/
         }
      };
      JTableHeader th = tableView.getTableHeader(); 
      th.addMouseListener(listMouseListener); 
   }

   /**
   * Returns the TableModel that this class is sorting.
   */
   public JUTableBinding getTableBinding() 
   {
      return mModel;
   }


   /**
   * JClient method to attach column-sorting model over a Table that's bound
   * to a JUTableBinding. 
   * @param table to be bound to a sortable model
   * @param tableBinding JClient table binding for the above table
   * @param sorter the JUTableSortModel instance providing custom sorting capabilities.
   */
   public static TableModel enableColumnSorting(JTable table, JUTableBinding tableBinding, JUTableSortModel sorter)
   {
      if (sorter == null)
      {
         sorter = new JUTableSortModel(tableBinding);
      }
      else
      {
         try
         {
            sorter.setTableBinding(tableBinding);
         }
         catch (Exception ex)
         {
            tableBinding.reportException(ex);
            if (sorter == null) 
            {
               Diagnostic.println("Failed to create custom SortModel for JTable. Using default implementation");
               sorter = new JUTableSortModel(tableBinding);
            }
         }
      }
      sorter.addMouseListenerToHeaderInTable(table);
      table.setModel(sorter);
      //table.setSelectionModel(new SortedListSelectionModel(sorter, table.getSelectionModel()));
      return sorter;
   }
}





