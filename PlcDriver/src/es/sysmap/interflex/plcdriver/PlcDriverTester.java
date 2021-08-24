package es.sysmap.interflex.plcdriver;
import es.sysmap.interflex.gestortelegrama.ByteHelper;
// import es.sysmap.interflex.gestortelegrama.GeneralMessageListener;
import java.awt.Frame;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PlcDriverTester extends JDialog implements Observer
{
  private PlcDriver driver;
  
  private JTextField jTextFieldOut = new JTextField();
  private JButton jButtonSend = new JButton();
  private JTextField jTextFieldHost = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextFieldPort = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTable jInTable;
  private Object[] headers = new Object[] {"Index", "Mensaje"};
  private DefaultTableModel dataModel = new DefaultTableModel(headers, 0);
  private JTableHeader jTableHeader1 = new JTableHeader();
  private JButton jButtonConectar = new JButton();
  

  public PlcDriverTester()
  {
    this(null, "", false);
  }

  /**
   * 
   * @param modal
   * @param title
   * @param parent
   */
  public PlcDriverTester(Frame parent, String title, boolean modal)
  {
    super(parent, title, modal);
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  private void jbInit() throws Exception
  {
    driver = null;
    this.setSize(new Dimension(766, 559));
    this.getContentPane().setLayout(null);
    this.setTitle("PlcDriverTester");
    this.addWindowListener(new java.awt.event.WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          this_windowClosing(e);
        }
      });
    jTextFieldOut.setBounds(new Rectangle(130, 82, 130, 20));
    jTextFieldOut.setToolTipText("Texto a enviar");
    jButtonSend.setText("Enviar");
    jButtonSend.setBounds(new Rectangle(270, 81, 73, 23));
    jButtonSend.setToolTipText("Enviar Texto al PLC");
    jButtonSend.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonSend_actionPerformed(e);
        }
      });
    jTextFieldHost.setText(PlcDriver.DEFAULT_HOST);
    jTextFieldHost.setBounds(new Rectangle(130, 30, 80, 20));
    jLabel1.setText("Host");
    jLabel1.setBounds(new Rectangle(90, 35, 35, 15));
    jLabel1.setLabelFor(jTextFieldHost);
    jTextFieldPort.setText(Integer.toString(PlcDriver.DEFAULT_PORT));
    jTextFieldPort.setBounds(new Rectangle(130, 55, 64, 19));
    jLabel2.setText("Port");
    jLabel2.setBounds(new Rectangle(91, 60, 35, 14));
    jLabel2.setLabelFor(jTextFieldPort);
    jLabel3.setText("Texto");
    jLabel3.setBounds(new Rectangle(91, 85, 35, 14));
    jLabel3.setLabelFor(jTextFieldOut);
    jScrollPane1.setBounds(new Rectangle(120, 160, 615, 340));
    this.getContentPane().add(jButtonConectar, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jTextFieldPort, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jTextFieldHost, null);
    this.getContentPane().add(jButtonSend, null);
    this.getContentPane().add(jTextFieldOut, null);
    jInTable = new JTable(dataModel);
    jButtonConectar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonConectar_actionPerformed(e);
        }
      });
    jButtonConectar.setToolTipText("Conectar como socket cliente");
    jButtonConectar.setBounds(new Rectangle(270, 55, 80, 25));
    jButtonConectar.setText("Conectar");
    jScrollPane1.getViewport().add(jInTable, null);
  }
  
  
  public static void main(String[] args)
  {
    try {
      UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
    }
    catch (Exception e) {}
    PlcDriverTester tester = new PlcDriverTester();
    tester.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    tester.show();
  }

  private void jButtonSend_actionPerformed(ActionEvent e)
  {
    String mensaje = jTextFieldOut.getText();
    if (driver != null && driver.sendMessage(mensaje.getBytes()))
    {
      JOptionPane.showMessageDialog(null, "Mensaje enviado");
    }
    else
      JOptionPane.showMessageDialog(null, "Imposible enviar mensaje");

  }

  private void this_windowClosing(WindowEvent e)
  {
    if (driver != null)
      driver.endThread();
    System.exit(0);
  }
  
  /**
   * recibir notificación de cambio
   * @param arg
   * @param o
   */
  // Recibir mensajes del SGA
  public void update(Observable o, Object arg)
  {
    byte [] bytes = (byte [])arg;
    
    
    int rowsToRemove = dataModel.getRowCount();
    for (int i = 0; i < rowsToRemove; i++)
      dataModel.removeRow(0);
    
    for (int i = 0; i < bytes.length; i++)
    {
      Object [] ob = { new Integer (i), ByteHelper.getPrintableChar((char)(bytes [i] & 0xFF))};
      dataModel.addRow(ob);
    }
  }

  private void jButtonConectar_actionPerformed(ActionEvent e)
  {
    if (driver != null)
      driver.endThread();
    // Instanciar el driver del PLC, registrando éste como observer del mismo
    driver = new PlcDriver(jTextFieldHost.getText(), Integer.parseInt(jTextFieldPort.getText()),this);
    jButtonConectar.setEnabled(false);
      
  }
}
