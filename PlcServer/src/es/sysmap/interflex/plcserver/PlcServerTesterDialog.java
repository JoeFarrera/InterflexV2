package es.sysmap.interflex.plcserver;
import es.sysmap.interflex.gestortelegrama.ByteHelper;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.interflex.plcdriver.Telegrama;
import es.sysmap.xml.XMLHelper;
import es.sysmap.xml.XMLParser;
import es.sysmap.xml.XMLTelegrama;
import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextArea;
import oracle.xml.parser.v2.XMLDocument;
import sgalib.MapFileFilter;
import sgalib.SgaUtilPuesto;


public class PlcServerTesterDialog extends JDialog implements Observer
{

  private PlcSuperServer server;
  private JButton jButtonSend = new JButton();
  private JTextField jTextFieldPort = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTable jInTable;
  private Object[] headers = new Object[] {"Index", "Valor (car)", "Hex"};
  private DefaultTableModel dataModel = new DefaultTableModel(headers, 0);
  private JTableHeader jTableHeader1 = new JTableHeader();
  private JButton jButtonEscuchar = new JButton();
  private JButton jButtonCargarFichero = new JButton();
  private JScrollPane jScrollPane2 = new JScrollPane();
  private JTextArea jTextAreaOut = new JTextArea();
  private JScrollPane jScrollPane3 = new JScrollPane();
  private JButton jButtonSendTokenized = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JTextArea jTextAreaTokenized = new JTextArea();
  
  private Thread vueltaThread = null;

  public PlcServerTesterDialog()
  {
    this(null, "", false);
  }

  /**
   * 
   * @param modal
   * @param title
   * @param parent
   */
  public PlcServerTesterDialog(Frame parent, String title, boolean modal)
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
    server = null;
    this.setSize(new Dimension(400, 300));
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(1067, 783));
    this.getContentPane().setLayout(null);
    this.setTitle("PlcServerTester");
    this.addWindowListener(new java.awt.event.WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          this_windowClosing(e);
        }
      });
    jButtonSend.setText("Enviar");
    jButtonSend.setBounds(new Rectangle(865, 70, 125, 25));
    jButtonSend.setToolTipText("Enviar Texto al PLC");
    jButtonSend.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonSend_actionPerformed(e);
        }
      });
    jTextFieldPort.setText("8189");
    jTextFieldPort.setBounds(new Rectangle(130, 55, 64, 19));
    jLabel2.setText("Port");
    jLabel2.setBounds(new Rectangle(91, 60, 35, 14));
    jLabel2.setLabelFor(jTextFieldPort);
    jLabel3.setText("Texto");
    jLabel3.setBounds(new Rectangle(85, 95, 35, 14));
    jScrollPane1.setBounds(new Rectangle(130, 455, 435, 270));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jButtonSendTokenized, null);
    jScrollPane3.getViewport().add(jTextAreaTokenized, null);
    this.getContentPane().add(jScrollPane3, null);
    this.getContentPane().add(jButtonCargarFichero, null);
    jScrollPane2.getViewport().add(jTextAreaOut, null);
    this.getContentPane().add(jScrollPane2, null);
    this.getContentPane().add(jButtonEscuchar, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jTextFieldPort, null);
    this.getContentPane().add(jButtonSend, null);
    jInTable = new JTable(dataModel);
    jScrollPane1.getViewport().add(jInTable, null);
    jTextAreaTokenized.setText("hex string");
    jLabel1.setBounds(new Rectangle(595, 445, 80, 15));
    jLabel1.setText("Texto en Hex");
    jButtonSendTokenized.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonSendTokenized_actionPerformed(e);
        }
      });
    jButtonSendTokenized.setBounds(new Rectangle(905, 655, 135, 25));
    jButtonSendTokenized.setText("Enviar");
    jScrollPane3.setBounds(new Rectangle(595, 470, 445, 175));
    jTextAreaOut.setText("xml please");
    jScrollPane2.setBounds(new Rectangle(130, 95, 860, 340));
    jButtonCargarFichero.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonCargarFichero_actionPerformed(e);
        }
      });
    jButtonCargarFichero.setToolTipText("Seleccionar un fichero para enviar al SGA");
    jButtonCargarFichero.setBounds(new Rectangle(720, 70, 125, 25));
    jButtonCargarFichero.setText("Cargar Fichero");
    jButtonEscuchar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonEscuchar_actionPerformed(e);
        }
      });
    jButtonEscuchar.setBounds(new Rectangle(210, 49, 100, 25));
    jButtonEscuchar.setText("Escuchar");
    jTextFieldPort.setToolTipText("Puerto del socket");
 
  }
  
  private void this_windowClosing(WindowEvent e)
  {
    if (server != null)
      server.endThread();
    System.exit(0);
  }
  
  private void jButtonSend_actionPerformed(ActionEvent e)
  {
    String mensaje = jTextAreaOut.getText();
    try
    {
      XMLDocument xmldoc = XMLHelper.parse(mensaje, null);
      send(xmldoc);
    } catch (Exception ex)
    {
      JOptionPane.showMessageDialog(null, "Error al procesar el mensaje: " + ex);
    }
  }


  // Recibir mensajes del SGA
  public void update(Observable o, Object arg)
  {
    byte [] bytes = (byte [])arg;
    
    
    int rowsToRemove = dataModel.getRowCount();
    for (int i = 0; i < rowsToRemove; i++)
      dataModel.removeRow(0);
    
    for (int i = 0; i < bytes.length; i++)
    {
      char car = (char)(0xFF & bytes [i]);
      Object [] ob = { new Integer (i), ByteHelper.getPrintableChar(car), Integer.toHexString((int)car).toUpperCase()};
      dataModel.addRow(ob);
    }
    
    // Arrancar el que envia de vuelta, si no está en marcha
    if (vueltaThread == null)
    {
      vueltaThread = new Thread (new PlcServerStat());
      vueltaThread.start();
    }
  }


  
   public static void main(String[] args)
  {
  try {
    // UIManager.setLookAndFeel(new oracle.bali.ewt.olaf.OracleLookAndFeel());
    UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
    }
    catch (Exception e) {}
    
    PlcServerTesterDialog tester = new PlcServerTesterDialog();
    tester.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    tester.show();
  }

  private void jButtonEscuchar_actionPerformed(ActionEvent e)
  {
   if (server == null)
    {
      // Instanciar el driver del PLC, registrando éste como observer del mismo
      server = new PlcSuperServer(Integer.parseInt(jTextFieldPort.getText()));
      server.addObserver(this);
      jTextFieldPort.setEnabled(false);
      jButtonEscuchar.setEnabled(false);
      
    }
  else
    JOptionPane.showMessageDialog(null, "El servidor ya ha sido instanciado");
    
   
  }
  
  private void send (XMLDocument xmldoc)
  {
    byte [] bytes = new byte [500];
    bytes = GestorDatos.getBytes(xmldoc, bytes);
    if (server != null && server.sendMessage(bytes))
    {
      ; // Nada JOptionPane.showMessageDialog(null, "Mensaje enviado");
    }
    else
      JOptionPane.showMessageDialog(null, "Imposible enviar mensaje");
  }

  private void jButtonCargarFichero_actionPerformed(ActionEvent e)
  {
    JFileChooser chooser = new JFileChooser();
    MapFileFilter filter = new MapFileFilter(new String [] {"xml"});
    chooser.setFileFilter(filter);
    chooser.setCurrentDirectory(new File(SgaUtilPuesto.getXMLRoot()));
    int returnVal = chooser.showOpenDialog(null);
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      try
      {
        XMLDocument xmldoc = XMLHelper.parse(new FileInputStream(chooser.getSelectedFile()), null);
        String xmlString = XMLHelper.toString(xmldoc);
        jTextAreaOut.setText(xmlString);
      } catch (Exception ex)
      {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al abrir / cursar el fichero:" + ex);
      } 
    }
   
    
    
  }

  /**
   * Convertir cadena de valores hex en un byte string y enviar
   * @param e
   */
  private void jButtonSendTokenized_actionPerformed(ActionEvent e)
  {
    StringTokenizer st = new StringTokenizer(jTextAreaTokenized.getText()," -\n");
    byte [] bytes = new byte [st.countTokens()];
    for (int i = 0; st.hasMoreTokens(); i++)
    {
      String token = st.nextToken();
      bytes [i] = (byte)Integer.parseInt(token, 16);
      System.out.println("token: " + token + " byte: " + bytes[i]);
      
    }
    
  if (server != null && server.sendMessage(bytes))
    {
      
    }
    else
      JOptionPane.showMessageDialog(null, "Imposible enviar mensaje");
 
  }

  private class PlcServerStat implements Runnable
  {
      PlcServerStat()
      {
        
      }
      
      public synchronized void run()
      {
        while (true)
        {
          try
          {
            wait (1000);
            XMLDocument xmldoc = XMLTelegrama.parseXML("stat");
            send(xmldoc);
           
            
          }
          catch (InterruptedException ex)
          {
            break;
          }
        }
         

      }
  }

}