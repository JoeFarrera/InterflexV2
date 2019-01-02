package es.sysmap.interflex.controlview;
import es.sysmap.interflex.control.SgaProceso;
import es.sysmap.interflex.control.SgaRunnable;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import sgalib.MapProcessButtonInterface;
import sgalib.SgaRecursos;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ProcessButton extends JPanel implements MapProcessButtonInterface
{
  private static final java.text.SimpleDateFormat timestampFormat = new java.text.SimpleDateFormat("HH:mm:ss");

  private ImageIcon imageArrancar;
  private String textArrancar;
  private String textTooltipArrancar;
  private ImageIcon imageRun;
  private String textRun;
  private String textTooltipRun;
  private SgaProceso proceso;
  private JButton button = new JButton();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTable messageTable = new JTable();
  private Object[] headers = new Object[] {"Hora", "Missatge proces"};
  private int[] sizeHeaders = new int[] {20, 300};
  private DefaultTableModel dataModel = new DefaultTableModel(headers, 0);
  private GridBagLayout gridBagLayout1 = new GridBagLayout();


  public ProcessButton(String imageArrancarFile, 
    String textArrancar, String textTooltipArrancar,
    String imageRunFile,
    String textRun, String textTooltipRun)
    {
     imageArrancar = SgaRecursos.createImageIcon(getClass(), imageArrancarFile, null);
     this.textArrancar = textArrancar;
     this.textTooltipArrancar = textTooltipArrancar;
     imageRun = SgaRecursos.createImageIcon(getClass(), imageRunFile, null);
     this.textRun = textRun;
     this.textTooltipRun = textTooltipRun;
     
     
     button.setIcon(imageArrancar);
     button.setText(textArrancar);
     button.setToolTipText(textTooltipArrancar);

     button.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          toggleProceso();
        }
      });
    try 
    {
      jbInit();
    } catch (Exception ex) 
    {
      ex.printStackTrace();
    }   
    }


  public void jbInit() throws Exception
  {
    this.setLayout(gridBagLayout1);
    this.setSize(new Dimension(595, 99));
    jScrollPane1.getViewport().add(messageTable, null);
    this.add(jScrollPane1, new GridBagConstraints(1, 0, 2, 1, 2.0, 2.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(3, 15, 0, 0), 1, 1));
    this.add(button, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 1, 1));
    messageTable = new JTable(dataModel);
    this.setPreferredSize(new Dimension(600, 60));
    this.setMinimumSize(new Dimension(1, 1));
    this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    jScrollPane1.getViewport().add(messageTable, null);
    // Ancho campos de la tabla de mensajes
    for (int i = 0; i < messageTable.getColumnCount(); i++)
    {
      messageTable.getColumn(headers[i]).setPreferredWidth(sizeHeaders[i]);
    }

  }

    
    public void setProcess(SgaProceso proceso)
    {
      this.proceso = proceso;
    }
    
    private void toggleProceso()
    {
    assert proceso != null;
    
    if (proceso.isAlive())
      {
        proceso.stopProcess();
        return;
      }
    else
    {
      proceso.start(this);
    }

   }
   
   public void setProcessStarted()
   {
      button.setText(textRun);
      button.setIcon(imageRun);
      button.setToolTipText(textTooltipRun);
      displayMessage("Proces engegat");
   }
   
   private Object [] getArgString(Object arg)
   {
   String mensaje = new String();
    if (arg instanceof Exception)
      {
        Exception e = (Exception)arg;
        mensaje = e.toString();
      }
    else if (arg instanceof String)
      {
        mensaje = (String)arg;
      }
    Object [] str = {timestampFormat.format(new Date()), mensaje };
    return str;
   }
   
   public void setProcessStopped(Object arg)
   {
      // :TODO ver que hacer con el arg - String o exception
      button.setText(textArrancar);
      button.setIcon(imageArrancar);
      button.setToolTipText(textTooltipArrancar);
      displayMessage(arg);
  }
   
   public void updateButton(Object arg)
   {
      displayMessage(arg);
   }
   
  public void displayMessage(Object arg)
  {
    if (dataModel.getRowCount() > 30)
    { 
      for (int i = 0; i < dataModel.getRowCount(); i++) 
      {
        dataModel.removeRow(i);
      }
    }
    dataModel.insertRow(0, getArgString(arg));
    
    }
}