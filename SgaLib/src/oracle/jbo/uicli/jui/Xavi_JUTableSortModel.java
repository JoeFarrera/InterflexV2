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
   int        mSortColIndex = -1;
   byte       mSortColType = TYPE_OBJECT;
   int        mRangeStart = 0 ; //for Sort stuff to get this fast.

   int        mIndices[];
   JUTableBinding mModel;

   /**
   * Default Constructor just coz, base class has it.
   */
   public JUTableSortModel()
   {
      // For consistency.        
      mIndices = new int[0]; // For consistency.        
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
      reallocateIndexes(); 
   }

   /**
   * If no sorting is to be done or when the base model has different
   * row count, resets the indices map so that sorting is done again.
   */
   protected void checkModel()
   {
      if (mIndices != null && (mIndices.length != getRangeSize()))
      {
         resetIndices();
      }
   }

   /**
   * Compares the sort-column values in two rows.
   * @return <li>a positive number when column value in row1 is greater than row1, 
   *         <li>0 when the two values match
   *         <li>a negative number when column value in row1 is less than row2.
   */
   protected int compareRows(int row1, int row2)
   {
      int result = compareRowsByColumn(row1, row2, mSortColIndex);
      return mAscending ? result : -result;
   }
   
   final int getRangeSize()
   {
      return mModel.getIteratorBinding().getNavigatableRowIterator().getRowCountInRange();
   }

   /**
   * Initializes the mapping between indices of this model versus the base model.
   */
   protected void resetIndices()
   {
      if (mModel != null) 
      {
         oracle.jbo.uicli.binding.JUIteratorBinding iter = mModel.getIteratorBinding();
         if (iter.isIteratorMadeVisible())
         {
            oracle.jbo.RowSetIterator rsi = iter.getRowSetIterator();
            //if (iter.isFindMode() || ((rsi != null) && (rsi.getRowSet().isExecuted())))
            if (iter.isFindMode() || ((rsi != null)))
            {
               int rowCount = getRangeSize();

               // Set up a new array of indexes with the right number of elements
               // for the new data model.
               mIndices = new int[rowCount];

               // Initialise with the identity mapping.
               for(int row = 0; row < rowCount; row++)
               {
                  mIndices[row] = row;
               }
            }
         }
      }

   }

   /**
   * If sort-column is greater than -1 (when no sorting should be done),
   * sorts the data from the base model for display. Otherwise, simply
   * resets this class' index map.
   */
   protected void  reallocateIndexes()
   {
      if (mSortColIndex > -1)
      {
         sortByColumn(mSortColIndex, mAscending);
      }
      else
      {
         resetIndices();
      }
   }
   
   public void tableChanged(TableModelEvent e)
   {
      int rangeStart = mModel.getIteratorBinding().getNavigatableRowIterator().getRangeStart();
      mRangeStart = (rangeStart > -1) ? rangeStart : 0;

      reallocateIndexes();
      fireTableChanged(e);
   }

   /**
   * Initializes the java type that this class is sorting on.
   * This implementation special cases the following types:
   * <li> oracle.jbo.domain.Number
   * <li> oracle.jbo.domain.Date
   * <li> java.lang.Number
   * <li> java.lang.Date
   * <li> java.lang.Boolean
   */
   protected void initType()
   {
      JUTableBinding model = mModel;
      Class type = model.getColumnClass(mSortColIndex);
      if (oracle.jbo.domain.Number.class.isAssignableFrom(type))
      {
         mSortColType = DOMAIN_NUMBER;
      }
      else if (oracle.jbo.domain.Date.class.isAssignableFrom(type))
      {
         mSortColType = DOMAIN_DATE;
      }
      else if (java.lang.Number.class.isAssignableFrom(type))
      {
         mSortColType = TYPE_NUMBER;
      }
      else if (java.util.Date.class.isAssignableFrom(type))
      {
         mSortColType = TYPE_DATE;
      }
      else if (java.lang.Boolean.class.isAssignableFrom(type))
      {
         mSortColType = TYPE_BOOLEAN;
      }
      else if (java.lang.String.class.isAssignableFrom(type))
      {
         mSortColType = TYPE_STRING;
      }
      else
      {
         mSortColType = TYPE_OBJECT;
      }
   }

   /**
   * Stores the mSortColIndex if it has changed. Also resets the
   * sorted indices if mSortColIndex is changed.
   */
   public void sortByColumn(int column, boolean ascending) 
   {
      JTable jTable = (JTable)mModel.getControl();
      
      int rowIndex = jTable.getSelectedRow();
      
      if (mSortColIndex != column)
      {
         resetIndices();
         mSortColType = TYPE_OBJECT;
         mSortColIndex = column;
      }
      
      
      if (mSortColIndex > -1)
      {
         this.mAscending = ascending;
       
         checkModel();
      
         initType();
      
         shuttlesort((int[])mIndices.clone(), mIndices, 0, mIndices.length);
         
     
      }
      
      fireTableChanged(new TableModelEvent(this)); 
      
      //mSelRowInProg = true;
      
      //try
      //Inici comentat per xavi
      /*if (rowIndex > -1) 
      {
         RowIterator ri = mModel.getIteratorBinding().getNavigatableRowIterator();
         Row row = ri.getCurrentRow();
         rowIndex = -1;
         if (row != null) 
         {
            rowIndex = getSortedIndex(ri.getRangeIndexOf(row));
         }
         if (rowIndex > -1) 
         {
            jTable.setRowSelectionInterval(rowIndex, rowIndex);
         }
      }
      //finally
      {
         //mSelRowInProg = false;
      }
      */
      // Fi comentat per xavi
      // Fem que sempre se seleccioni la primera fila despres d'ordenar
      jTable.setRowSelectionInterval(0, 0);
      
   }

   final int getModelIndex(int curRowIndex)
   {
      int rowIndex = -1;
      if (mSortColIndex > -1) 
      {
         int rs = curRowIndex - mRangeStart;
         if (rs >= 0 && rs < getRangeSize()) 
         {
            rowIndex = mIndices[rs];
         }
      }
      else
      {
         rowIndex = curRowIndex;
      }
      return rowIndex;
   }
   
   final int getSortedIndex(int curRowIndex)
   {
      int rowIndex = -1;
      if (mSortColIndex > -1) 
      {
         int rowCount = mIndices.length;
         for(--rowCount; rowCount >= 0; rowCount--)
         {
            if (mIndices[rowCount] == curRowIndex)
            {
               rowIndex = rowCount;
               break;
            }
         }
      }
      else
      {
         rowIndex = curRowIndex;
      }
      return rowIndex;
   }

   // This is a home-grown implementation which we have not had time
   // to research - it may perform poorly in some circumstances. It
   // requires twice the space of an in-place algorithm and makes
   // NlogN assigments shuttling the values between the two
   // arrays. The number of compares appears to vary between N-1 and
   // NlogN depending on the initial order but the main reason for
   // using it here is that, unlike qsort, it is stable.
   protected void shuttlesort(int from[], int to[], int low, int high) 
   {
      if (high - low < 2) 
      {
         return;
      }
      int middle = (low + high)/2;
      shuttlesort(to, from, low, middle);
      shuttlesort(to, from, middle, high);
      
      int p = low;
      int q = middle;
      
      /* This is an optional short-cut; at each recursive call,
      check to see if the elements in this subset are already
      ordered.  If so, no further comparisons are needed; the
      sub-array can just be copied.  The array must be copied rather
      than assigned otherwise sister calls in the recursion might
      get out of sinc.  When the number of elements is three they
      are partitioned so that the first set, [low, mid), has one
      element and and the second, [mid, high), has two. We skip the
      optimisation when the number of elements is three or less as
      the first compare in the normal merge will produce the same
      sequence of steps. This optimisation seems to be worthwhile
      for partially ordered lists but some analysis is needed to
      find out how the performance drops to Nlog(N) as the initial
      order diminishes - it may drop very quickly.  */
      
      if (high - low >= 4 && compareRows(from[middle-1], from[middle]) <= 0) 
      {
         for (int i = low; i < high; i++) 
         {
            to[i] = from[i];
         }
         return;
      }
      
      // A normal merge. 
      
      for(int i = low; i < high; i++) 
      {
         if (q >= high || (p < middle && compareRows(from[p], from[q]) <= 0))
         {
            to[i] = from[p++];
         }
         else 
         {
            to[i] = from[q++];
         }
      }
   }

   /**
   * Swaps the index map between two given indices.
   */
   protected void swap(int i, int j) 
   {
      int tmp = mIndices[i];
      mIndices[i] = mIndices[j];
      mIndices[j] = tmp;
   }

   /**
   * Compares the values in two rows at the given column. For types other
   * than listed for method initType(), this implementation calls 
   * compareObjectTypes() method where appliacations can handle custom
   * or other types.
   */
   protected final int compareRowsByColumn(int row1, int row2, int column)
   {
      JUTableBinding data = mModel;
      
      // Check for nulls
      Object o1 = data.getValueAt(row1 + mRangeStart, column);
      Object o2 = data.getValueAt(row2 + mRangeStart, column); 
      
      // If both values are null return 0
      if (o1 == null && o2 == null) 
      {
         return 0; 
      }
      else if (o1 == null) 
      { // Define null less than everything. 
         return -1; 
      } 
      else if (o2 == null) 
      { 
         return 1; 
      }
      
      switch (mSortColType) 
      {
      case DOMAIN_NUMBER:
         {
            oracle.jbo.domain.Number n1 = (oracle.jbo.domain.Number)o1;
            oracle.jbo.domain.Number n2 = (oracle.jbo.domain.Number)o2;
            return n1.compareTo(n2);
         }
      case DOMAIN_DATE:
         {
            oracle.jbo.domain.Date n1 = (oracle.jbo.domain.Date)o1;
            oracle.jbo.domain.Date n2 = (oracle.jbo.domain.Date)o2;
            return n1.compareTo(n2);
         }
      case TYPE_NUMBER:
         {
            Number n1 = (Number)o1;
            double v1 = n1.doubleValue();
            Number n2 = (Number)o2;
            double v2 = n2.doubleValue();
            return ((v1 < v2) ? -1 : ((v1 > v2) ? 1 : 0));
         }
      case TYPE_DATE:
         {
            java.util.Date d1 = (java.util.Date)o1;
            long v1 = d1.getTime();
            java.util.Date d2 = (java.util.Date)o2;
            long v2 = d2.getTime();
            return ((v1 < v2) ? -1 : ((v1 > v2) ? 1 : 0));
         }
      case TYPE_BOOLEAN:
         {
            Boolean bool1 = (Boolean)o1;
            boolean b1 = bool1.booleanValue();
            Boolean bool2 = (Boolean)o2;
            boolean b2 = bool2.booleanValue();
            return ((b1 == b2) ? 0 : (b1) ? 1 : -1);  //false is less than true.
         }
      case TYPE_STRING:
         {
            String s1 = (String)o1;
            String s2    = (String)o2;
            int result = s1.compareTo(s2);
            return ((result < 0) ? -1 : ((result > 0) ? 1 : 0));
         }
      default:
         {
            return compareObjectTypes(o1, o2);
         }
      }
   }

   /**
   * Converts unknown Object types to String and compares the Strings.
   * Applications should override this method to provide custom comparisions
   * of specific types that are not handled by this Sorter by default. 
   */
   protected int compareObjectTypes(Object obj1, Object obj2)
   {
      String s1 = obj1.toString();
      String s2 = obj2.toString();
      int result = s1.compareTo(s2);
      return ((result < 0) ? -1 : ((result > 0) ? 1 : 0));
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
            int column = tableView.convertColumnIndexToModel(viewColumn); 
            if(e.getClickCount() == 1 && column != -1) 
            {
               int shiftPressed = e.getModifiers()&InputEvent.SHIFT_MASK; 
               boolean ascending = (shiftPressed == 0); 
               if (ascending == sorter.mAscending && column == sorter.mSortColIndex)
               {
                  column = -1;
               }
               sorter.sortByColumn(column, ascending); 
            }
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


   // By default, Implement TableModel by forwarding all messages 
   // to the model. 

   public Object getValueAt(int aRow, int aColumn)
   {
      checkModel();

      if (mSortColIndex > -1) 
      {
         int rs = aRow - mRangeStart;
         if (rs >= 0 && rs < getRangeSize()) 
         {
            return mModel.getValueAt(mRangeStart+mIndices[rs], aColumn);
         }
      }
      return mModel.getValueAt(aRow, aColumn);
   }

   public void setValueAt(Object aValue, int aRow, int aColumn)
   {
      checkModel();

      if (mSortColIndex > -1) 
      {
         int rs = aRow - mRangeStart;
         if (rs >= 0 && rs < getRangeSize()) 
         {
            mModel.setValueAt(aValue, mRangeStart+mIndices[rs], aColumn);
            return;
         }
      }
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
   //Inici comentat per xavi
      /*if (mSortColIndex > -1) 
      {
         int rs = aRow - mRangeStart;
         if (rs >= 0 && rs < getRangeSize()) 
         {
            RowIterator ri = mModel.getIteratorBinding().getNavigatableRowIterator();
            Row cr = ri.getCurrentRow();
            Row r = ri.getRowAtRangeIndex(mIndices[rs]);
            if (cr != r) 
            {
               ri.setCurrentRow(r);
            }

            return mModel.isCellEditable(mRangeStart+mIndices[rs], aColumn);
         }
      }*/
      //Fi comentat per xavi
      return mModel.isCellEditable(aRow, aColumn);
   }


   final boolean isUnsortedDisplay()
   {
      // Xavi: Modificat per que retorni sempre cert 
      //return (mSortColIndex < 0);
      return true;
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
      table.setSelectionModel(new SortedListSelectionModel(sorter, table.getSelectionModel()));
      return sorter;
   }
}


   //no selection allowed in sorted mode.
   //the problem is that there is no inner/outer api difference
   //both table and model can call the same apis and in sorted case,
   //we need to map the sorted to unsorted indices and vice-versa based on 
   //where the call is coming from. We could keep a status on the model before
   //calling this from our own classes if that helps?
   //but for now, lets just say no selection in sorted mode.
   class SortedListSelectionModel  implements ListSelectionModel
   {
      ListSelectionModel mList;
      JUTableSortModel   mSorter;

      SortedListSelectionModel(JUTableSortModel sorter, ListSelectionModel model)
      {
         mList = model;
         mSorter = sorter;
      }

      public void setSelectionInterval(int index0, int index1)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            mList.setSelectionInterval(index0, index1);
         }
      }
      
      public void addSelectionInterval(int index0, int index1)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            mList.addSelectionInterval(index0, index1);
         }
      }
      
      public void removeSelectionInterval(int index0, int index1)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            mList.removeSelectionInterval(index0, index1);
         }
      }
      
      public int getMinSelectionIndex()
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            return mList.getMinSelectionIndex();
         }
         return -1;
      }
      
      public int getMaxSelectionIndex()
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            return mList.getMaxSelectionIndex();
         }
         return -1;
      }
      
      public boolean isSelectedIndex(int index)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            return mList.isSelectedIndex(index);
         }
         return false;
      }
      
      public int getAnchorSelectionIndex()
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            return mList.getAnchorSelectionIndex();
         }
         return -1;
      }
      
      public void setAnchorSelectionIndex(int index)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            mList.setAnchorSelectionIndex(index);
         }
      }
      
      public int getLeadSelectionIndex()
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            return mList.getLeadSelectionIndex();
         }
         return -1;
      }
      
      public void setLeadSelectionIndex(int index)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            mList.setLeadSelectionIndex(index);
         }
      }
      
      public void clearSelection()
      {
         mList.clearSelection();
      }
      
      public boolean isSelectionEmpty()
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            return mList.isSelectionEmpty();
         }
         return true;
      }
      
      public void insertIndexInterval(int index, int length, boolean before)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            mList.insertIndexInterval(index, length, before);
         }
      }
      
      public void removeIndexInterval(int index0, int index1)
      {
         if (mSorter.isUnsortedDisplay()) 
         {
            mList.removeIndexInterval(index0, index1);
         }
      }
      
      public void setValueIsAdjusting(boolean valueIsAdjusting)
      {
         mList.setValueIsAdjusting(valueIsAdjusting);
      }
      
      public boolean getValueIsAdjusting()
      {
         return mList.getValueIsAdjusting();
      }
      
      public void setSelectionMode(int selectionMode)
      {
         mList.setSelectionMode(selectionMode);
      }
      
      public int getSelectionMode()
      {
         return mList.getSelectionMode();
      }
      
      public void addListSelectionListener(ListSelectionListener x)
      {
         mList.addListSelectionListener(x);
      }
      
      public void removeListSelectionListener(ListSelectionListener x)
      {
         mList.removeListSelectionListener(x);
      }
   }



