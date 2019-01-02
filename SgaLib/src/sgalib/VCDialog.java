package sgalib;

/*
 * @(#)VCDialog.java
 *
 * Copyright 1999-2002 by Oracle Corporation,
 * 500 Oracle Parkway, Redwood Shores, California, 94065, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Oracle Corporation.
 */

import com.sun.java.util.collections.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Enumeration;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import oracle.jbo.AttributeDef;
import oracle.jbo.StructureDef;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import oracle.jbo.uicli.jui.JUTableBinding;

public class VCDialog extends JDialog
{
   JUIteratorBinding iteratorBinding = null;
   ViewObject     mViewObject = null;
   AttributeDef[] attribsVisibles = null; 
   JFrame      parent;
   public AttributeDef[] attribs = null;

   private ViewCriteria    mViewCriteria = null;
   private ViewCriteria    mOriginalVC = null;
   private ArrayList       mColumnNames = null;
   private ArrayList       mFields = null;

   private JPanel buttonPanel     = new JPanel();
   private JButton createButt     = new JButton(SgaRecursos.getInstance().getString("VCDialog.buscar_label"));
   private JButton cancelButt     = new JButton(SgaRecursos.getInstance().getString("VCDialog.cancelar_label"));
   private JButton helpButt       = new JButton(SgaRecursos.getInstance().getString("VCDialog.ajuda_label"));

   private JButton addButt        = new JButton(SgaRecursos.getInstance().getString("VCDialog.or_label"));
   private JButton removeButt     = new JButton(SgaRecursos.getInstance().getString("VCDialog.borrar_label"));
   private JButton removeAllButt  = new JButton(SgaRecursos.getInstance().getString("VCDialog.borrarTot_label"));
   private JTabbedPane tabPane    = new JTabbedPane();
   private int vcRowCounter       = 0;
   private boolean isVCExecuted   = true;
   private boolean isRegisteredToHelp;
   

   public VCDialog(JFrame frame, JUIteratorBinding iteratorBinding)
   {
      super(frame, SgaRecursos.getInstance().getString("VCDialog.indicarCriteris_label"), true);

      parent = frame;
      this.iteratorBinding = iteratorBinding;
      mViewObject = this.iteratorBinding.getViewObject();
      //Xavi, 19/05/05: Establim un viewCriteriaAdapter propi, que millora les 
      // condicions de busqueda
      ((ViewObjectImpl)mViewObject).setViewCriteriaAdapter(new SgaViewCriteriaAdapter());
      
      java.util.ArrayList arrayList = this.iteratorBinding.getValueBindingList();
      boolean bTrobat = false;
      
      for (int i = 0; i < arrayList.size() && !bTrobat; i++)
      {
        if (arrayList.get(i) instanceof JUTableBinding)
        {
          JUTableBinding tableBinding = (JUTableBinding)arrayList.get(i);
          attribsVisibles = tableBinding.getAttributeDefs();
          bTrobat = true;
        }
      }
      this.addWindowListener(new WindowListener()
      {
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e)
        {
          cancelDialog();
        }
    
        public void windowClosed(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}    
        public void windowActivated(WindowEvent e){}    
        public void windowDeactivated(WindowEvent e){}

      });
      
      try
      {
         jbInit();
      }
      catch(Exception e)
      {
         e.printStackTrace();
         //ErrorHandler.displayError(parent, e);
      }
   }
   private void jbInit() throws Exception
   {
      buttonPanel.add(createButt);
      createButt.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            createViewCriteria();
         }
      });

      buttonPanel.add(addButt);
      addButt.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            createViewCriteriaRow(false);
         }
      });

      buttonPanel.add(removeButt);
      removeButt.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            removeCurrentVCRow();
         }
      });

      buttonPanel.add(removeAllButt);
      removeAllButt.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            createViewCriteriaRow(true);
         }
      });

      buttonPanel.add(cancelButt);
      cancelButt.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            cancelDialog();
         }
      });

      helpButt.addActionListener( new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if (!isRegisteredToHelp)
            {
               isRegisteredToHelp = true;
               //oracle.bali.ewt.util.WindowUtils.registerWindow(VCDialog.this);
            }
            //parent.helpMe("f1_bcbctviewcriteria_html");
         }
      });
      buttonPanel.add(helpButt);
      
      getContentPane().add(tabPane, BorderLayout.CENTER);
      getContentPane().add(buttonPanel, BorderLayout.SOUTH);

      initViewCriteria();
   }

   private void initViewCriteria()
   {
      mViewCriteria = mViewObject.getViewCriteria();
      

      // Save the Criteria in case of problem with the new one.

      if (mViewCriteria != null)
      {
         mOriginalVC = (ViewCriteria)mViewCriteria.clone();
      }
      else
      {
         mOriginalVC = (ViewCriteria)mViewObject.createViewCriteria().clone();
      }

      // Initialize Attribute Defs
      StructureDef rsinfo = mViewObject.getViewObject();
      AttributeDef[] attrs = rsinfo.getAttributeDefs();
      ArrayList v = new ArrayList();
/*      for ( int i=0; i < attrs.length; i++ )
      {
         if (attrs[i].isQueriable())
         {
            v.add(attrs[i]);
         }
      }*/
      for ( int i=0; i < attribsVisibles.length; i++ )
      {
         if (attribsVisibles[i].isQueriable())
         {
            v.add(attribsVisibles[i]);
         }
      }
      
      attribs = (AttributeDef[]) v.toArray(new AttributeDef[v.size()]);

      if ( (mViewCriteria == null) || (mViewCriteria.size() == 0) )
      {
         // No existing View Criteria
         createViewCriteriaRow(true);
         mViewCriteria = mViewObject.createViewCriteria();
         return;
      }

      ViewCriteriaRow vr = null;
      Enumeration en = mViewCriteria.elements();
      boolean first = true;
      int count = 0;
      ArrayList fields = null;
      ArrayList columnNames = null;
      int index;
      while ( en.hasMoreElements() )
      {
         createViewCriteriaRow(first);
         if ( first )
         {
            first = false;
         }
         index = tabPane.getSelectedIndex();
         columnNames = (ArrayList) mColumnNames.get(index);
         fields = (ArrayList) mFields.get(index);
         vr = (ViewCriteriaRow)en.nextElement();
         count = vr.getAttributeCount();
         for ( int i=0; i < columnNames.size(); i++)
         {
            ((JTextField)fields.get(i)).setText((String)
                                vr.getAttribute((String)columnNames.get(i)));

         }
      }
      // Just Reset the Criteria, so that we don't accidentally add the VC rows
      // twice
      mViewCriteria = mViewObject.createViewCriteria();
   }

   private void cancelDialog()
   {
      if ( !isVCExecuted )
      {
         try
         {
            mViewObject.applyViewCriteria(mOriginalVC);
            mViewObject.executeQuery();
         }
         catch ( Exception ex )
         {
            // Just Ignore
         }
      }
      close();
   }


   private void addViewCriteriaRows()
   {
      // Browse All Tabs and add View Criteria Rows
      String str;
      ViewCriteriaRow vr = null;
      ArrayList columnNames;
      ArrayList fields;

      mViewCriteria.removeAllElements();
      int count = tabPane.getTabCount();
      for (int j=0; j < count; j++)
      {
         columnNames = (ArrayList) mColumnNames.get(j);
         fields = (ArrayList) mFields.get(j);
         for (int i=0; i < fields.size(); i++ )
         {
            str = ((JTextField)fields.get(i)).getText();
            if ( (str == null) || (str.length() <= 0) )
            {
               continue;
            }
            if (vr == null)
            {
               vr = mViewCriteria.createViewCriteriaRow();
            }
            vr.setAttribute((String)columnNames.get(i), str);
         }
         if (vr != null)
         {
            mViewCriteria.addElement(vr);
            vr = null;
         }
      }
   }

   private void removeCurrentVCRow()
   {
      // If this is the last row, recreate the first one.
      if (tabPane.getTabCount() <= 1 )
      {
         createViewCriteriaRow(true);
      }
      else
      {
         int index = tabPane.getSelectedIndex();
         tabPane.removeTabAt(index);
         if (mColumnNames != null)
         {
            mColumnNames.remove(index);
         }
         if (mFields != null)
         {
            mFields.remove(index);
         }
      }
   }

   private void createViewCriteriaRow(boolean cleanup)
   {
      if (cleanup)
      {
         tabPane.removeAll();
         mColumnNames = new ArrayList();
         mFields      = new ArrayList();
         vcRowCounter = 0;
      }

      String title;
      if (vcRowCounter++ == 0)
      {
         title = SgaRecursos.getInstance().getString("VCDialog.criteri_label");
      }
      else
      {
         title = SgaRecursos.getInstance().getString("VCDialog.criteriOr_label");
      }

      GridBagLayout gbl      = new GridBagLayout();
      JPanel mPanel          = new JPanel(gbl);
      GridBagConstraints gbc = new GridBagConstraints();

      mPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
      int ypos=0;

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(5, 5, 10, 5);

      ArrayList columnNames = new ArrayList();
      ArrayList fields = new ArrayList();
      mColumnNames.add(columnNames);
      mFields.add(fields);

      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 0;
      gbc.gridy = ypos++;
      gbc.weightx = 1.0;
      gbc.gridwidth = 2;

      JLabel label =  new JLabel(SgaRecursos.getInstance().getString("VCDialog.operador_label"));

      gbl.setConstraints(label, gbc);
      mPanel.add(label);

      gbc.insets = new Insets(5, 5, 0, 5);

      for (int i = 0 ; i < attribs.length ; i++)
      {
         //label = new JLabel(attribs[i].getName() + ":");
         label = new JLabel(attribs[i].getUIHelper().getLabel(null) + ":");
         JTextField textField = new JTextField();
         columnNames.add(attribs[i].getName());
         textField.setToolTipText(attribs[i].getUIHelper().getTooltip(null));
         fields.add(textField);

         gbc.anchor = GridBagConstraints.WEST;
         gbc.gridx = 0;
         gbc.gridy = ypos;
         gbc.weightx = 0.0;
         gbc.gridwidth = 1;

         gbl.setConstraints(label, gbc);
         mPanel.add(label);

         gbc.anchor = GridBagConstraints.EAST;
         gbc.gridx = 1;
         gbc.gridy = ypos++;
         gbc.weightx = 1.0;
         gbc.gridwidth = GridBagConstraints.REMAINDER;
         gbl.setConstraints(textField, gbc);
         mPanel.add(textField);
      }

      JScrollPane scroller   = new JScrollPane(mPanel);
      tabPane.add(title, scroller);
      tabPane.setSelectedComponent(scroller);
   }

   private void createViewCriteria()
   {
      try
      {
         addViewCriteriaRows();
         mViewObject.applyViewCriteria(mViewCriteria);
         mViewObject.executeQuery();
         close();
      }
      catch(Exception e)
      {
      
        //e.printStackTrace();
         //ErrorHandler.displayError(parent, e);
      javax.swing.JOptionPane.showConfirmDialog (null, 
        SgaRecursos.getInstance().getString("VCDialog.errorFiltre_label"),
        "Error", 
        javax.swing.JOptionPane.CANCEL_OPTION,
        javax.swing.JOptionPane.ERROR_MESSAGE);
         
         isVCExecuted = false;
      }
   }

   public void close()
   {
      if (isRegisteredToHelp)
      {
         //oracle.bali.ewt.util.WindowUtils.unregisterWindow(this);
         isRegisteredToHelp = false;
      }
      this.setVisible(false);
      this.dispose();
   }
   
   public void show()
   {
      this.pack();
      // Tamany maxim de la pantalla      
      this.setSize(new Dimension(550, 600));
      
//      this.setSize(this.getSize().width, this.getSize().height + 10);
      this.setLocationRelativeTo(parent);
      super.show();
   }
   
   /**
   * Permet efectuar una busqueda sobre una instancia de VCDialog sense mostrar el
   * quadre de dialeg
   * @param mViewCriteria
   */
   public void silentMode(ViewCriteria mViewCriteria)
   {
      try
      {
         mViewObject.applyViewCriteria(mViewCriteria);
         mViewObject.executeQuery();
         close();
      }
      catch(Exception e)
      {
      
        //e.printStackTrace();
         //ErrorHandler.displayError(parent, e);
      javax.swing.JOptionPane.showConfirmDialog (null, 
        SgaRecursos.getInstance().getString("VCDialog.errorFiltre_label"),
        "Error", 
        javax.swing.JOptionPane.CANCEL_OPTION,
        javax.swing.JOptionPane.ERROR_MESSAGE);
         
         isVCExecuted = false;
      }
     
   }
}
