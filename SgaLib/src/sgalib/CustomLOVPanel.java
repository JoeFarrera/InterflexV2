package sgalib;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import oracle.jbo.uicli.controls.JULovDialog;
import oracle.jbo.uicli.controls.JUNavigationBar;
import oracle.jbo.uicli.jui.JULovDialogInterface;
import oracle.jbo.uicli.jui.JULovPanelInterface;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.jui.JUTableBinding;

/**
 * Custom LOV panel that provides similar functionality as the default implementation 
 * contained in the oracle.jbo.uicli.jui.JULovButtonBinding. Because the default 
 * implementation is as an inner class in JULovButtonBinding, no public methods of 
 * the LOV panel are exposed to JClient applications. A limited set of custom 
 * attributes can be provided with the constructor, configuring the UIModel.xml file.
 * 
 * All LOV panels that need to provide more methods to ADF JClient applications must
 * implement the JULovPanelInterface and replace the default setting by the following
 * entry added to the UIModel.xml file
 * 
 * CustomPanel="<package>.LovPanelName"
 * 
 * for example 
 * 
 * CustomPanel="oracle.sample.jbo.uicli.jui.custom.utility.CustomLOVPanel
 * 
 * CustomLOVPanel, this class adds extra functionality to the LOV window, compared
 * to the default:
 * 
 * - Ability to show/hide search toolbar at runtime
 * - Ability to set LOV dialog title at runtime
 * - ability to set the LOV window size and location
 * - default message string for LOV help action
 * 
 * @author Frank Nimphius, December 2004
 */

public class CustomLOVPanel extends JPanel implements JULovPanelInterface 
{

  private String             mTitleString   = null;
  private Point              mLocation      = null;
  private int []             dialogSize     = new int[] {400,300};
  private boolean            mAddSearch     = false;
  private boolean            mDoInit        = true;
  private JUNavigationBar    mNavBar        = new JUNavigationBar(true, false, false, true);;
  private String             iterName       ="";
  private JUIteratorBinding  mIterBinding = null;
  private DCIteratorBinding  mDcIterbind    = null;
  
  /***************************************
   * read only table that is write enabled
   * if the search toolbar is shown
   * ************************************/
   
  private JTable mLovTable = new JTable()
  {
      //make the table readonly.
      public boolean isCellEditable(int row, int column) 
      {
        return (mNavBar != null) ? mNavBar.getHasFindButton() : false;
      }
  };
  
  public CustomLOVPanel()
  {
    super();
    

  }

  /***************************************
   * Method called by the framework to bind
   * the LOV to the accessor defined in the 
   * UIModel.xml file for the list binding 
   * ************************************/
   
  public void bindRowSetIterator(DCDataControl dc, RowSetIterator rsi, String[] lovVODisplayedAttrNames)
  {  
    mIterBinding = new JUIteratorBinding(dc,rsi);
    // initialize the dialog only once
    if (mDoInit)
    {
      mDoInit = false;
      this.setLayout(new BorderLayout());
      this.add(new JScrollPane(mLovTable), BorderLayout.CENTER);
      // Fem que no sigui autoresize
      mLovTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

      if (mAddSearch) 
      {
        this.add(mNavBar, BorderLayout.NORTH);
      }
    }
    
    AttributeDef[] displayAttrs = mIterBinding.getAttributeDefs(lovVODisplayedAttrNames);
    
    int size = displayAttrs.length;
    String names[] = new String[size];
    
    for (int i=0; i < size; i++)
    {
       names[i] = displayAttrs[i].getName();
    }
    iterName = mIterBinding.getName();
    
    JUPanelBinding lovPanelBinding = new JUPanelBinding()
    {
       public void setFindMode(boolean mode, boolean applyCriteria)
       {
          super.setFindMode(mode, applyCriteria);
        }
    };
    
    mIterBinding.setFormBinding(lovPanelBinding);
    lovPanelBinding.addIterBinding(null, mIterBinding) ;
    
    if (rsi != null && rsi.getRowSet() != null)
       {
         lovPanelBinding.setApplicationModule(rsi.getRowSet().getApplicationModule()) ;
       }

         lovPanelBinding.addBindingWithCellEditor(new JUTableBinding(mLovTable, mIterBinding, names));

      if (mNavBar != null) 
         {
           mNavBar.setModel(mIterBinding);
           lovPanelBinding.addNavigationBar(mNavBar);
          }
            
          mIterBinding.rangeRefreshed(null);
          mDcIterbind = mIterBinding;

    // Establim l'amplada inicial de les columnes
    for (int i = 0; i < displayAttrs.length; i++)
    {
      int width = (displayAttrs[i].getPrecision() > 0 ? displayAttrs[i].getPrecision()*7 : 20*7);
      if (width < displayAttrs[i].getUIHelper().getLabel(null).length()*7)
        width = displayAttrs[i].getUIHelper().getLabel(null).length()*7;
      
      mLovTable.getColumnModel().getColumn(i).setMinWidth(width);
    }
    // Fi Establim l'amplada inicial de les columnes
          
  }

  public DCIteratorBinding getLovIteratorBinding()
  {
    return mDcIterbind;
  }

  public JPanel getPanel()
  {
    return this;
  }

  public void helpAction(ActionEvent ev)
  {
    String message = "To provide application specific help, edit or override the helpAction\n method in  "+
                     "the CustomLOVPanel source file.";
   JOptionPane.showMessageDialog(null,message,"Lov Help",JOptionPane.INFORMATION_MESSAGE);

  }

  /***************************************
   * Method called to define the LOV dialog.
   * Change this method to change the default
   * appearance of the LOV window.
   * ************************************/
  public JULovDialogInterface createLovDialog(JComponent control)
  {
      Frame frame = null;
      if (control != null) 
      {
         Container parent = control.getParent();
         while (parent != null && !(parent instanceof Frame)) 
          {
            parent = parent.getParent();
          }
            frame = (Frame)parent; 
        }
   
         JULovDialog lovDlg = new JULovDialog(frame, getPanelTitle(), true);
         
         if (mLocation == null) 
         {
            lovDlg.setLocationRelativeTo(control);
          }
          else
          {  
              lovDlg.setLocation(mLocation);
          }
          
          if (dialogSize!= null)
          {
            lovDlg.setSize(dialogSize[0],dialogSize[1]);
          }

      return lovDlg;
    }

  public String getPanelTitle()
  {
    if (mTitleString!= null)
    {
      return mTitleString;
    }
    return "Oracle ADF JClient";
  }

  public Row getSelectedRow()
  {
    return mIterBinding.getCurrentRow();
  }

 /**
   * Sets display using data from this RowSet Iterator.
   * Note that on LOV action, this RowSet Iterator's current Row will
   * be used to set the target Row's attributes.
   * <p>
   * @deprecated since 9.0.5.1 
  */
  public void bindRowSetIterator(RowSetIterator rsi, String[] lovVODisplayedAttrNames)
  {
  }


  public void setTitleString(String mTitleString)
  {
    this.mTitleString = mTitleString;
  }


  public String getTitleString()
  {
    return mTitleString;
  }


  public void setLocation(Point mLocation)
  {
    this.mLocation = mLocation;
  }


  public Point getLocation()
  {
    return mLocation;
  }


  public void setDialogSize(int width, int height)
  {
    
    this.dialogSize[0] = width;
    this.dialogSize[1] = height;
  }


  public int[] getDialogSize()
  {
    return dialogSize;
  }


  public void setAddSearch(boolean mAddSearch)
  {
    // toggle searchbar visibility
    if (mAddSearch)
    {
      this.add(mNavBar, BorderLayout.NORTH);
    }
    else {
      this.remove(mNavBar);
    }
    this.mAddSearch = mAddSearch;
  }


  public boolean isAddSearch()
  {
    return mAddSearch;
  }

  public JUNavigationBar getLovNavBar()
  {
    return mNavBar;
  }
  
  public JTable getLovTable ()
  {
    return mLovTable;
  }
}