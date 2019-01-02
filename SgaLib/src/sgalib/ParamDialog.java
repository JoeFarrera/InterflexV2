package sgalib;

import inetsoft.uql.VariableTable;
import inetsoft.uql.builder.VariableEntry;
import inetsoft.uql.schema.UserVariable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Custom parameter prompting dialog.
 */
class ParamDialog extends JDialog {

   
   private VariableEntry pane;
   private UserVariable[] vars;
   private static ParamDialog _instance ;
  

   public ParamDialog(UserVariable[] vars, Component comp) {
    super(JOptionPane.getFrameForComponent(comp));
    _instance = this;
    this.vars = vars;
    
    jbInit();
   }
   
   
   public VariableTable showThisInstance()
   {
      setModal(true);
      pack();
      setVisible(true);
      return pane.getVariableTable();
   }

   public static ParamDialog getInstance()
   {
     return _instance;
   }
   
   
   private void jbInit()
   {
      // add a title to the dialog.
      JLabel title = new JLabel("Entrada de parámetros");
      this.setTitle("Parámetros [informe SGA]");
      title.setFont(new Font("Tahoma", 1, 14));
      title.setForeground(Color.darkGray);
      getContentPane().add(title, "North");
	 
      pane = new VariableEntry(vars);
      
      getContentPane().add(pane, "Center");
	 
      JButton okB = new JButton("OK");
      JButton cancelB = new JButton("Cancel");
      
      JPanel cmdPnl = new JPanel();
    title.setText("Parámetros del informe");
      cmdPnl.add(okB);
      cmdPnl.add(cancelB);
      getContentPane().add(cmdPnl, "South");

      okB.addActionListener(okListener);
   
      cancelB.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
          dispose();
       }
      });     
     
     setLocationRelativeTo(getParent());
     
   }
      
   public static VariableTable show(UserVariable[] vars, Component comp) {
      ParamDialog win = new ParamDialog(vars, comp);
      return win.showThisInstance();
   }
   
   ActionListener okListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       pane.createVariableTable();
       dispose();
      }
   };



}
