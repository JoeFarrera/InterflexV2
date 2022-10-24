package sgalib;

import inetsoft.uql.VariableTable;
import inetsoft.uql.builder.VariableEntry;
import inetsoft.uql.schema.UserVariable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Mostra un dialeg que permet modificar els paràmetres de configuració
 * de l'aplicació d'informes
 */

class ConfigDialog extends JDialog {

   private static ConfigDialog _instance ;
   
   private JPanel dataPanel = new JPanel();
   private GridBagLayout panelLayout = new GridBagLayout();
   
   private JPanel cmdPnl = new JPanel();
   private JButton okB = new JButton();
   private JButton cancelB = new JButton();

   private JLabel labelDatasource = new JLabel();
   private JTextField mDatasource = new JTextField();
   private JButton bDatasource = new JButton();

   private JLabel labelDirReport = new JLabel();
   private JTextField mDirReport = new JTextField();
   private JButton bDirReport = new JButton();
  
   public ConfigDialog(Component comp) {
    super(JOptionPane.getFrameForComponent(comp));
    _instance = this;
    
    jbInit();
   }
   
   public void showThisInstance()
   {
      setModal(true);
//      pack();
      setVisible(true);
   }

   public static ConfigDialog getInstance()
   {
     return _instance;
   }
   
   
   private void jbInit()
   {
      // add a title to the dialog.
      this.setTitle("Configuración de SGA Informes");
      this.setSize(new Dimension(500, 200));
      
      dataPanel.setLayout(panelLayout);
      
      mDatasource.setText(SgaUtilPuesto.getInstance().getProperty("uql.home"));
      dataPanel.add(labelDatasource, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(mDatasource, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(bDatasource, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      labelDatasource.setLabelFor(mDirReport);
      mDatasource.setColumns(40);
      labelDatasource.setText("Origen Datos");
      mDatasource.setToolTipText("Directorio de origen de datos");
      bDatasource.setText("...");
      bDatasource.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            getDirectoriDatasource();
          }
        });
      
      mDirReport.setText(SgaUtilPuesto.getInstance().getProperty("DirectoriReports"));
      dataPanel.add(labelDirReport, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(mDirReport, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(bDirReport, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      labelDirReport.setLabelFor(mDirReport);
      mDirReport.setColumns(40);
      labelDirReport.setText("Directorio Informes");
      mDirReport.setToolTipText("Directorio de origen de los informes");
      bDirReport.setText("...");
      bDirReport.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            getDirectoriReport();
          }
        });
	 
//      pane = new VariableEntry(vars);
      
      getContentPane().add(dataPanel, "Center");

      okB.setText("Aceptar");
      okB.setToolTipText("Guarda los cambios en la configuración");
      okB.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            setConfiguracio();
          }
        });

      cancelB.setText("Cancelar");
      cancelB.setToolTipText("Cancela los cambios en la configuración");
      cancelB.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            dispose();
          }
        });
      
      cmdPnl.add(okB);
      cmdPnl.add(cancelB);
      getContentPane().add(cmdPnl, "South");
     
     setLocationRelativeTo(getParent());
     
   }
      
   public static void show(Component comp) {
      ConfigDialog win = new ConfigDialog(comp);
      win.showThisInstance();
   }
   
   private void setConfiguracio()
   {
     String dsnew = mDatasource.getText();
     String dsori = SgaUtilPuesto.getInstance().getProperty("uql.home");
     
     if (dsnew != null && (dsori == null || dsori != null && !dsnew.equals(dsori)) )
     {
      SgaUtilPuesto.getInstance().storeNewProperty("uql.home", mDatasource.getText());
      JOptionPane.showMessageDialog(null, "<html><p>La nueva configuración no tendra efecto hasta reiniciar la aplicación.", "Configuración",
        JOptionPane.INFORMATION_MESSAGE);
     }
     
     SgaUtilPuesto.getInstance().storeNewProperty("DirectoriReports", mDirReport.getText());
     
     dispose();
   }

   private void getDirectoriDatasource()
   {
      File fichero = SgaRecursos.seleccionarDirectori(mDatasource.getText(), 
                    true, this);
      if (fichero != null)
      {
        mDatasource.setText(fichero.getAbsolutePath());
      }
   }
   
   private void getDirectoriReport()
   {
      File fichero = SgaRecursos.seleccionarDirectori(mDirReport.getText(), 
                    true, this);
      if (fichero != null)
      {
        mDirReport.setText(fichero.getAbsolutePath());
      }
   }

}
