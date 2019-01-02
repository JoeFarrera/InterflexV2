package es.sysmap.interflex.control;
import es.sysmap.interflex.gestortelegrama.ByteHelper;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.xml.XMLHelper;

import es.sysmap.xml.XMLTelegrama;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileInputStream;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import oracle.xml.parser.v2.XMLDocument;

import sgalib.MapFileFilter;
import sgalib.SgaUtilPuesto;

public class PlsStatusTesterDialog extends JDialog implements Observer
{

  PlcStatus status;
  GestorDatos gestor;

  private JButton jButtonSend = new JButton();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTable jInTable;
  private Object[] headers = new Object[] {"Index", "Mensaje", "Hex"};
  private DefaultTableModel dataModel = new DefaultTableModel(headers, 0);
  private JTableHeader jTableHeader1 = new JTableHeader();
  private JButton jButtonCargarFichero = new JButton();
  private JScrollPane jScrollPane2 = new JScrollPane();
  private JTextArea jTextAreaOut = new JTextArea();
  
  private XMLDocument lastXML;
  private JButton jButton1 = new JButton();

  public PlsStatusTesterDialog()
  {
    this(null, "", false);
  }

  /**
   * 
   * @param modal
   * @param title
   * @param parent
   */
  public PlsStatusTesterDialog(Frame parent, String title, boolean modal)
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
    status = PlcStatus.getInstance();
    status.addObserver(this);
    gestor = status.getGestorDatos();
    
    this.setSize(new Dimension(400, 300));
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(1018, 675));
    this.getContentPane().setLayout(null);
    this.setTitle("PlcStatusTester");
    this.addWindowListener(new java.awt.event.WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          this_windowClosing(e);
        }
      });
    jButtonSend.setText("Enviar");
    jButtonSend.setBounds(new Rectangle(650, 85, 73, 23));
    jButtonSend.setToolTipText("Enviar Texto al PLC");
    jButtonSend.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonSend_actionPerformed(e);
        }
      });
    jScrollPane1.setBounds(new Rectangle(750, 85, 250, 550));
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(jButtonCargarFichero, null);
    jScrollPane2.getViewport().add(jTextAreaOut, null);
    this.getContentPane().add(jScrollPane2, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(jButtonSend, null);
    jInTable = new JTable(dataModel);
    jButton1.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButton1_actionPerformed(e);
        }
      });
    jButton1.setBounds(new Rectangle(810, 35, 160, 25));
    jButton1.setText("Ver mensaje entrante");
    jScrollPane1.getViewport().add(jInTable, null);
    jTextAreaOut.setText("xml please");
    this.setResizable(true);
    jScrollPane2.setBounds(new Rectangle(20, 85, 625, 540));
    jButtonCargarFichero.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonCargarFichero_actionPerformed(e);
        }
      });
    jButtonCargarFichero.setToolTipText("Seleccionar un fichero para enviar al SGA");
    jButtonCargarFichero.setBounds(new Rectangle(20, 35, 125, 25));
    jButtonCargarFichero.setText("Cargar Fichero");
 
  }
  
  private void this_windowClosing(WindowEvent e)
  {
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
    lastXML = (XMLDocument)arg;

    int lenTelegrama = XMLTelegrama.getLenTelegrama(lastXML);
    
    byte [] bytes = new byte [lenTelegrama];
    bytes = GestorDatos.getBytes(lastXML, bytes);
    
    
    
    int rowsToRemove = dataModel.getRowCount();
    for (int i = 0; i < rowsToRemove; i++)
      dataModel.removeRow(0);
    
    for (int i = 0; i < lenTelegrama; i++)
    {
      char car = (char)(0xFF & bytes [i]);
      Object [] ob = { new Integer (i), ByteHelper.getPrintableChar(car), Integer.toHexString((int)car).toUpperCase()};
      dataModel.addRow(ob);
    }
  }


  
   public static void main(String[] args)
  {
  try {
    // UIManager.setLookAndFeel(new oracle.bali.ewt.olaf.OracleLookAndFeel());
    UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
    }
    catch (Exception e) {}
    
    PlsStatusTesterDialog tester = new PlsStatusTesterDialog();
    tester.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    tester.show();
  }

 private void send (XMLDocument xmldoc)
  {
    if (gestor != null && gestor.sendTelegrama(xmldoc))
    {
      JOptionPane.showMessageDialog(null, "Mensaje enviado");
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

  private void jButton1_actionPerformed(ActionEvent e)
  {
    if (lastXML != null)
    {
      JScrollPane pane = new JScrollPane();
      JTextArea in = new JTextArea();
      pane.setBounds(new Rectangle(20, 85, 400, 540));
      pane.getViewport().add(in, null); 
      try 
      {
        in.setText(XMLHelper.toString(lastXML));
        JOptionPane.showMessageDialog(null, pane, "Último mensaje recibido: " , JOptionPane.INFORMATION_MESSAGE);
      } catch (Exception ex) 
      {
        JOptionPane.showMessageDialog(null, "Error al cursar el documento: " + ex, "XML Parse error", JOptionPane.ERROR_MESSAGE);
      } 
    }
    else
        JOptionPane.showMessageDialog(null, "No se han recibido mensajes", "Sin mensajes", JOptionPane.WARNING_MESSAGE);
      
  }

}