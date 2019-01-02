/*
 * @(#)JUCtrlAttrsBinding.java
 *
 * Copyright 2001-2002 by Oracle Corporation,
 * 500 Oracle Parkway, Redwood Shores, California, 94065, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Oracle Corporation.
 */

package oracle.jbo.uicli.binding;

import oracle.jbo.NavigationEvent;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.ScrollEvent;

import oracle.adf.model.binding.DCIteratorBinding;

/**
 * A JUControlBinding class responsible for binding controls/models
 * that are bound to a single Row object in the BC4J layer.
 * This class is responsible for:
 * <ul>
 * <li>Updating the Control Bindings with attribute values
 * from the BC4J Row object for all attributes that this Control Binding is bound to.
 * <li>Enabling/disabling the control based on whether the corresponding Row's attribute
 * is updateable.
 * </ul>
 * <p>
 * This class defines the abstract APIs for subclasses to implement, so that
 * Row's attributes can be passed to the Binding object for appropriate display/update.
 */
public class JUCtrlAttrsBinding extends JUCtrlValueBinding
{
   

   class mySetEnabledThread implements Runnable
   {
      boolean mEnabled = true;
      boolean mDone = true;
      public void run() 
      {
         synchronized(mSetEnabledThread)
         {
            // Xavi: afegit el block try/catch per evitar un excepció d'oracle
            try
            {
              mDone = true;
              ((java.awt.Component)getControl()).setEnabled(mEnabled);
            }
            catch(Exception ex){};
         }
      }
   }

   mySetEnabledThread mSetEnabledThread;
   
   /**
   * Gets the value from the control for the attribute at the given index.
   * (The index is calculated from the list of attributes this control binding is
   * bound to as passed in the constructor).
   * Framework uses this method to get the attribute value from the control
   * and pass it on to the Row object on the BC4J side.
   */
   public Object getValueAt(int attrIndex)
   {
      return getAttribute(attrIndex);
   }

   /**
   * Updates the control/control-binding with the latest value of the
   * attribute at the given index with the given value. This method is used
   * by the framework to update the control with attribute values from a BC4J row.
   */
   public void setValueAt(Object value, int attrIndex)
   {
   }

   public void addControlToPanel(Object panel, Object layoutObject, Object layoutCons)
   {
   }

   /*
   * Applications should use this method to update the value for an attribute 
   * at the given index on both a control as well as a BC4J row, where the index
   * is calculated from the list of attributes to which control is bound
   * in its constructor). For controls that are bound to one attribute,
   * pass in 0 for attrIndex.
   */
   public void setDataValueAt(Object value, int attrIndex)
   {
      setAttribute(attrIndex, value);
   }


   /**
   * *** For internal framework use only ***
   */
   protected JUCtrlAttrsBinding()
   {
   }

   /**
   * Creates a binding between the given control and attributes in the Rows returned
   * by the passed in Iterator Binding.
   */
   public JUCtrlAttrsBinding(Object control, DCIteratorBinding iterBinding, String[] attrNames)
   {
      super(control, iterBinding, attrNames);
   }


   /**
   * Updates the control-binding and hence the control with attribute values from
   * the attributes of this Row. Invokes setValueAt() with the attribute value
   * and attribute index with respect to attributes for which this binding is interested.
   * <p>
   * This method also enables/disables the Swing control based on the updateability
   * of the first (Default) attribute to which this control is bound.
   */
   public void updateValuesFromRow(Row row)
   {
      if (row != getCurrentRow())
      {
         //why should I update my display for a row that 
         return;
      }
      resetInputState();
      super.updateValuesFromRow(row);
      int ct = getAttributeCount();


      Object ctrl = getControl();
      if (ctrl != null)
      {
         //assuming that only if you have a control setup 
         //that you need setValueAt method call which 
         //will update the display
         for (int j = 0; j < ct; j++)
         {
            setValueAt(getAttributeFromRow(row, j), j);
         }
      }

      if (ct == 1) 
      {
         //setup readonly stuff for controls mapped to one target attribute
         if (ctrl instanceof java.awt.Component) 
         {
            //let swing thread run up the setEnabled call.
            //This allows multiple calls to setEnabled to be turned into one
            //and only the last one before setEnabled is actually called wins.
            setControlEnabled(isAttributeUpdateable(0));
         }
      }
   }

   protected void setControlEnabled(boolean flag) 
   {
      if (mSetEnabledThread == null)
      {
         mSetEnabledThread = new mySetEnabledThread();
      }

      synchronized (mSetEnabledThread)
      {
         //if mDone is true, then invoke the thread, so that this control's
         //enabled again. 
         if (mSetEnabledThread.mDone)
         {
            mSetEnabledThread.mDone= false;
            mSetEnabledThread.mEnabled = flag;
            javax.swing.SwingUtilities.invokeLater(mSetEnabledThread);
         }
         mSetEnabledThread.mEnabled = flag;
      }
   };

   
   
   /**
   * Passes on the first row from the given array of rows to 
   * updateValuesFromRow() method to update the bound control's display.
   */
   public void updateValuesFromRows(Row[] rows, boolean clear)
   {
      updateValuesFromRow((rows.length > 0) ? rows[0] : null);
   }

   
   /**
   * Overridden as a no-op. Since this control is bound to only one row,
   * when that row becomes current the framework uses updateValuesFromRow to
   * update the display
   */
   public void updateRangeScrolled(ScrollEvent event)
   {
   }


   /**
   * Overridden as a no-op. Since this control is bound to only one row,
   * when that row becomes current the framework uses updateValuesFromRow to
   * update the display
   */
   public void updateNavigated(NavigationEvent event)
   {
      resetInputState();
   }

   /**
   * *** For internal framework use only ***
   * <p>
   * Updates the values in a control that is bound using an Iterator already in use.
   * (a valid row iterator)
   * If you do not call this method, your control won't update unless you refresh the Iterator.
   */
   public void refreshControl()
   {   
      RowIterator ri = getRowIterator();

      if (ri == null)
      {
         return;
      }

      //if (rsi.getRowSet().isExecuted() &&
      if (getIteratorBinding().isIteratorMadeVisible() &&
          ri.getCurrentRowSlot() == RowIterator.SLOT_VALID)
      {
         updateValuesFromRow(getCurrentRow());
      }
   }
   

   protected boolean isControlQueriable()
   {
      //subclasses control this on their own.
      return (this.getClass() == oracle.jbo.uicli.binding.JUCtrlAttrsBinding.class);
   }


   /**
   * This method is used by the JDeveloper designtime wizards for binding a text component
   * with an attribute of rows of a ViewObject/RowIterator.
   * This method calls JUFormBinding.getRowIterBinding to get the iterator binding using
   * the given parameters and then registers a new JUTextFieldBinding with the iterator
   * binding object so as to display/edit the current row's attribute of the given name.
   * <p>
   * @param formBinding The containing JUPanelBinding in which the given iterator binding
   * would be found/created.
   * @param control The control instance to bind to a ViewObject's attribute.
   * @param voInstanceName Name of the instance of the ViewObject in a BC4J ApplicationModule.
   * @param voIterName Runtime instance name of the iterator in the ViewObject (optional).
   * @param voIterBindingName Instance name of the iterator binding that uniquely identifies an
   * iterator binding object used to read/write data in this given JUPanelBinding instance.
   * @param attrName The name of the attribute of this ViewObject rows that contains data
   * to display/edit in the associated text control.
   * @return Document object bound to the given text control.
   */
   public static JUCtrlAttrsBinding createAttributeBinding( JUFormBinding formBinding, 
                                                  Object control,
                                                  String        voInstanceName,
                                                  String        voIterName, /*temporarily taking nulls for this*/
                                                  String        voIterBindingName,
                                                  String        attrName)
   {
         JUCtrlAttrsBinding bind = new JUCtrlAttrsBinding(control, 
                                       formBinding.getRowIterBinding(voInstanceName, voIterName, voIterBindingName),
                                       new String[]{attrName});
         bind.refreshControl();
         return bind;
   }

   // makes the attribute value the default value for the binding object when the expression language is used
   // This takes out one level while using the binding
   public String toString()
   {
      //this should be InputValue and not AttributeValue as incase of form, 
      //if there are errors, this needs to display the error-value and not attribute value
      Object value = getInputValue();
      return (value != null) ? value.toString() : "";
   }

}
