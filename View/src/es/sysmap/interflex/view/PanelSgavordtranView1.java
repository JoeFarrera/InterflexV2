package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgavordtranViewRow;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import java.util.Vector;
import javax.swing.*;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.TableModel;

import oracle.adf.model.*;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.DefaultButtonModel;

// public class PanelSgavordtranView1 extends JPanel implements JUPanel
public class PanelSgavordtranView1 extends SgaJUPanel
 {
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavordtranView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavordtranView1

  private JScrollPane scroller = new JScrollPane();

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();
  private JUStatusBar statusBar = new JUStatusBar();

  // Para el tratamiento de operaciones sobre la tabla
   private static final int DESHACER = 0;
   private static final int FINALIZAR = 1;
   private static final int ACTUALIZARPOS = 2;
   private static final int ACTUALIZARDES = 3;   
   private static final int REENVIAR = 4;
   private static final int ACTUALIZARTRASLO = 5;
   private static final int SIMULARAVIS = 6;
   private static final int SIMULARPETI = 7;
   
   private static final String [] mensajes = { 
   "Desfer (esborrar)", 
    "Finalitzar", 
    "Actualitzar posició",
    "Actualitzar destí",
    "Tornar a enviar",
    "Actualitzar traslo"
//    , 
//    "Simular Enviar AVIS",
//    "Simular Enviar PETI"
    };
    
  private SgaJTable tableSgavordtranView1 = new SgaJTable();
  private JButton buttonUbiposLOV = new JButton();
  private JButton buttonUbidesLOV = new JButton();
  
  private String posPlc;
  private JTextField codigoError = new JTextField("0");
  
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavordtranView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    this.setMinimumSize(new Dimension(485, 291));
    this.setPreferredSize(new Dimension(485, 291));
    this.setMaximumSize(new Dimension(100, 100));
    this.setSize(new Dimension(485, 291));
    buttonUbiposLOV.setText("Llista de posicions");
    buttonUbidesLOV.setText("Llista de posicion");
    
    this.setLayout(borderLayout);
    // Code support for view object:  SgavordtranView1
    // Layout the datapanel and the navigation bar
    scroller.getViewport().add(tableSgavordtranView1, null);
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.CENTER);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavordtranView1", null, "SgavordtranView1Iterator1"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    // No enseñar el botton navBar.add(buttonLOV, null);
    add(navBar, BorderLayout.NORTH);
    add(statusBar, BorderLayout.SOUTH);
    createPopupMenu();
    tableSgavordtranView1.setModel((TableModel)panelBinding.bindUIControl("SgavordtranView1", tableSgavordtranView1));
    buttonUbiposLOV.setModel((ButtonModel)panelBinding.bindUIControl("Ubipos", buttonUbiposLOV));
    buttonUbidesLOV.setModel((ButtonModel)panelBinding.bindUIControl("Ubides", buttonUbidesLOV));
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    
    
  }

  public static void main(String [] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
    }

    PanelSgavordtranView1 panel = new PanelSgavordtranView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }

  /**
   * 
   *  JClientPanel implementation
   */
  public JUPanelBinding getPanelBinding()
  {
    return panelBinding;
  }

  // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

  
 
  private void addMenuItem (String text, ActionListener listener, String iconString)
  {
      JMenuItem menuItem = new JMenuItem(text);
      menuItem.addActionListener(listener);
      ImageIcon icon = SgaRecursos.createImageIcon(getClass(), iconString, null);
      menuItem.setIcon(icon);

      tableSgavordtranView1.insertPopupMenuItem(menuItem, 0);
  }

  /**
   * Añadir popup items asicionales a la tabla
   */
   public void createPopupMenu() {
    tableSgavordtranView1.insertPopupSeparator(); 
    addMenuItem (mensajes [DESHACER], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(DESHACER);
        }
      }, "16x16/plain/delete.png");

    addMenuItem (mensajes [REENVIAR], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(REENVIAR);
        }
      }, "16x16/plain/redo.png");
    addMenuItem (mensajes [ACTUALIZARPOS], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(ACTUALIZARPOS);
        }
      }, "16x16/plain/edit.png");
    addMenuItem (mensajes [ACTUALIZARDES], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(ACTUALIZARDES);
        }
      }, "16x16/plain/edit.png");


     addMenuItem (mensajes [ACTUALIZARTRASLO], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(ACTUALIZARTRASLO);
        }
      }, "16x16/plain/bullet_ball_blue.png");

    tableSgavordtranView1.insertPopupSeparator(); 
     
 
     addMenuItem (mensajes [FINALIZAR], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(FINALIZAR);
        }
      }, "16x16/plain/document_ok.png");
 
     
  
 /* solo pruebas
     addMenuItem (mensajes [SIMULARAVIS], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(SIMULARAVIS);
        }
      }, "16x16/plain/bullet_ball_blue.png");
     addMenuItem (mensajes [SIMULARPETI], new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actionOrden(SIMULARPETI);
        }
      }, "16x16/plain/bullet_ball_blue.png");
*/
  }
  
 

  
   private void actionOrden(int operacion)
   {
     SgavordtranViewRow row = (SgavordtranViewRow)panelBinding.findIteratorBinding("SgavordtranView1Iterator1").getCurrentRow();
     Object [] options = { "Si", "No", "Cancel.lar"};

     int result = 0;
    
      try
      {
       if (operacion == DESHACER || operacion == FINALIZAR)
       {
       result = JOptionPane.showOptionDialog(null, mensajes [operacion] + " " + row.toString(), 
                      "Actualitzar ordre de transport", 
                      JOptionPane.YES_NO_CANCEL_OPTION, 
                      JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
       }
   
      boolean inspeccionarUbicacion = false;  // :TODO ver si eso...
      if (result == 0)
      {
       switch (operacion)
       {
         case DESHACER:
          row.setBorrado(inspeccionarUbicacion);
          break;
         case FINALIZAR:
          row.setFinalizado();
          break;
         case ACTUALIZARPOS:
          buttonUbiposLOV.doClick();
          break;
         case ACTUALIZARDES:
          buttonUbidesLOV.doClick();
          break;         
         case REENVIAR:
          reenviar(row);
          break;
        case SIMULARAVIS:
        case SIMULARPETI:
          simularAvisPeti(operacion, row);
          break;
        case ACTUALIZARTRASLO:
          actualizarTraslo(row);
          break;
        
       }
       
       panelBinding.getApplication().getApplicationModule().getTransaction().commit();
      }
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

     
     // Result 0 is yes...
    }
    
    private void reenviar(SgavordtranViewRow row)
    {
      Object []      message = new Object[5];
      message [0] = "Telegrama " + row.toString();
      message [1] = " ";  // Para que haya un hueco
      JCheckBox plcCheck = new JCheckBox ("Enviar com a telegrama nou");
      message [3] = plcCheck;
      message [4] = " ";
      

      int result = JOptionPane.showOptionDialog(null, message, 
              "Tornar a enviar el telegrama al PLC", 
              JOptionPane.OK_CANCEL_OPTION, 
              JOptionPane.QUESTION_MESSAGE, null, null, null);
      plcCheck.isSelected();

      if (result == 0)
      {
          row.setReenviar(plcCheck.isSelected());       
      }

     
    }
    
    private void simularAvisPeti(int operacion, SgavordtranViewRow row)
    {
    
      Object []      message = new Object[10];
      if (operacion == SIMULARAVIS)
        message [0] = "Enviar missatje 'AVIS' " + row.toString();
      else
        message [0] = "Enviar missatje 'PETI' " + row.toString();
      message [1] = " ";  // Para que haya un hueco
      JComboBox plcPosCombo = new JComboBox (row.getDestinoPlc());
      message [2] = "Nova posició";
      message [3] = plcPosCombo;
      message [4] = " ";
      message [5] = "Códic error:";
      message [6] = codigoError;
      message [7] = " ";
      

      int result = JOptionPane.showOptionDialog(null, message, 
              (String)message[0], 
              JOptionPane.OK_CANCEL_OPTION, 
              JOptionPane.QUESTION_MESSAGE, null, null, null);
              
      if (result == 0)
      {
        String pposPlc = (String)plcPosCombo.getSelectedItem();
        posPlc = pposPlc.substring(0, 2);
        if (operacion == SIMULARAVIS)
          row.simularAvis(Integer.parseInt(codigoError.getText()), posPlc);
        else
          row.simularPeti(Integer.parseInt(codigoError.getText()), posPlc);
      }

    }
    
  private void actualizarTraslo(SgavordtranViewRow row)
  {
    Vector traslos = row.getTraslos();
    if (traslos != null) 
    {
      Object []      message = new Object[5];
      message [0] = "Modificar el traslo y tornar a enviar l'ordre";
      message [1] =  row.toString();
      message [2] = " ";
      JComboBox trasloCombo = new JComboBox (traslos);
      message [3] = trasloCombo;
      message [4] = " ";

      int result = JOptionPane.showOptionDialog(null, message, 
              (String)message[0], 
              JOptionPane.OK_CANCEL_OPTION, 
              JOptionPane.QUESTION_MESSAGE, null, null, null);
              
      if (result == 0)
      {
        int idTraslo = trasloCombo.getSelectedIndex() + 1;
        row.changeTraslo(idTraslo);
      }

    }
    else
      JOptionPane.showMessageDialog(null,
        "No es pot modificar el traslo d'una ordre del miniload", 
        "Traslo no modificable", 
        JOptionPane.INFORMATION_MESSAGE);
        
    return;
  }  
  
  
    
}

