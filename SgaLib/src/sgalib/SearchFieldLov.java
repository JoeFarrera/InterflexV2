package sgalib;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import oracle.jbo.uicli.controls.JUNavigationBar;
import java.awt.Dimension;


/**
 * Specialized LOV that displays a searchfield for the application user to
 * type in a search criteria to reduce the number of values shown in the LOV.
 * The SearchFieldLov class extends CustomLOVPanel and inherits the default 
 * implementation and public methods. This LOV is similar to LOVs in Oracle
 * Forms and is an example of how JClient LOVs can be customized. Configure the
 * UIModel.xml file to use this custom LOV instead of the default LOV
 * 
 * CustomPanel="<package>.LovPanelName"
 * 
 * for example 
 * 
 * CustomPanel="oracle.sample.jbo.uicli.jui.custom.utility.SearchFieldLov
 *
 * @author Frank Nimphius, December 2004
 */

public class SearchFieldLov extends CustomLOVPanel 
{ 
  private JTextField searchField = new JTextField();
  private JLabel searchLabel = new JLabel(SgaRecursos.getInstance().getString("SearchFieldLov.search_label"));
  private JUNavigationBar navBar;
  private JTable  lovTable;
  // column - row
  private int[] tableCell = {0,0};
  
  public SearchFieldLov()
  {
    super();
        
    navBar = super.getLovNavBar();    
    navBar.add(searchLabel);
    navBar.add(searchField);
    
    // remove default buttons from Navigation Bar
    
    navBar.setHasFindButton(false);
    navBar.setHasExecuteButton(false);
    navBar.setHasNavigationButtons(false);
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    
    lovTable = super.getLovTable();
    

    
    searchField.addFocusListener(new FocusListener()
      {
        public void focusGained(FocusEvent e) {

        }
        public void focusLost(FocusEvent e) {
          searchField.setText("");
        }
      });
      
      searchField.addKeyListener(new KeyListener()
        {
          public void keyPressed(KeyEvent e) {
          
          // exetute query on enter
           if (e.getKeyCode() == 10)
           {
            if (!navBar.getModel().isFindMode())
            {
                 navBar.getButton(JUNavigationBar.BUTTON_FIND).doClick();
            }
             
              // define the LOV column that the search field should write
              // the user entry to.
              
              lovTable.getModel().setValueAt(searchField.getText(),tableCell[1],tableCell[0]);
              navBar.getButton(JUNavigationBar.BUTTON_EXECUTE).doClick();
           }
           
           // cancel query with ESC
           if (e.getKeyCode() == 27)
           {
            if (!navBar.getModel().isFindMode())
            {
              navBar.getButton(JUNavigationBar.BUTTON_FIND).doClick();
            }
              lovTable.getModel().setValueAt("%",0,1);  
              navBar.getButton(JUNavigationBar.BUTTON_EXECUTE).doClick();
           }
          }
  
          public void keyReleased(KeyEvent e) {}
          public void keyTyped(KeyEvent e) {}
        });
  }
  
  public void helpAction(ActionEvent ev)
  {
    String message = "To provide application specific help, edit or override the helpAction\n"+
                     "method in in your custom LOV panel source file.\n\n"+ 
                     "For this demo, press 'Enter' to query the LOV table and 'Esc' to cancel\n"+
                     "editing the search field";
   JOptionPane.showMessageDialog(null,message,"Lov Help",JOptionPane.INFORMATION_MESSAGE);
  }
  
  public void setSearchColumn(int col)
  {
    tableCell[0] = col;
    // always use first row
    tableCell[1] = 0;
  }

}