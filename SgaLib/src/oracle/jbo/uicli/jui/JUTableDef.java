/*
 * @(#)JUTableDef.java
 *
 * Copyright 2001-2002 by Oracle Corporation,
 * 500 Oracle Parkway, Redwood Shores, California, 94065, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Oracle Corporation.
 */

package oracle.jbo.uicli.jui;

import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCControlBinding;

import oracle.jbo.mom.xml.DefElementImpl;
import oracle.jbo.uicli.binding.JUCtrlRangeDef;
import oracle.jbo.uicli.binding.JUFormBinding;
import oracle.jbo.uicli.binding.JUUtil;

public class JUTableDef extends JUCtrlRangeDef
{
   private String mScrollPaneClassName;
   private boolean mColumnSort = true;

   public static final String PNAME_ScrollPaneClass = "ScrollPaneClass";
   public static final String PNAME_ColumnSort = "ColumnSort";


   public JUTableDef()
   {
      setControlBindingClassName(JUTableBinding.class.getName());
   }


   public JUTableDef(String name, String controlClassName,
                     String controlBindingClassName, String iterBindingName,
                     String[] attrNames, String scrollPaneClassName)
   {
      super(name, controlClassName,
            (controlBindingClassName != null) ? controlBindingClassName : JUTableBinding.class.getName(),
            iterBindingName, attrNames);

      mScrollPaneClassName = scrollPaneClassName;
   }


   public JUTableDef(String name, String iterBindingName, String[] attrNames,
                     String scrollPaneClassName)
   {
      this(name, JTable.class.getName(), null, iterBindingName, attrNames, scrollPaneClassName);
   }


   protected void initSubType()
   {
      setSubType(PNAME_Table);
   }

   public void init(HashMap initValues)
   {
      super.init(initValues);

      Object val;

      if ((val = initValues.get(PNAME_ColumnSort)) != null)
      {
         mColumnSort = convertToBoolean(val);
      }

      if ((val = initValues.get(PNAME_ScrollPaneClass)) != null)
      {
         mScrollPaneClassName = val.toString();
      }
   }


   public String getScrollPaneClassName()
   {
      return mScrollPaneClassName;
   }


   protected DCControlBinding createControlBindingInstance(Object control, DCBindingContainer formBnd)
   {
      JTable jTable = (JTable) control;

      JUTableBinding jTabBnd = new JUTableBinding((JTable) control,
                                                  getIterBinding((JUFormBinding)formBnd),
                                                  getAttrNames());
      jTabBnd.mColumnSort = mColumnSort;
      jTabBnd.setName(getName());

      if (mScrollPaneClassName != null)
      {
         JScrollPane jScrollPane = (JScrollPane) JUUtil.createNewInstance(mScrollPaneClassName);

         jScrollPane.setViewportView(jTable);
         jTabBnd.setLayoutObject(jScrollPane);
      }

      return jTabBnd;
   }


   protected void retrieveFromXML(DefElementImpl xmlElement, HashMap valueTab)
   {
      super.retrieveFromXML(xmlElement, valueTab);

      readXMLString(xmlElement, PNAME_ScrollPaneClass, valueTab);
      // Substituim aquesta linea per desactivar l'opció d'ordenació en les taules
      readXMLBoolean(xmlElement, PNAME_ColumnSort, valueTab);
      //valueTab.put(PNAME_ColumnSort, new Boolean("false"));
   }



}
