package sgalib;

/*
 * Copyright(c) 1996-2001, InetSoft Technology Corp, All Rights Reserved.
 *
 * The software and information contained herein are copyrighted and 
 * proprietary to InetSoft Technology Corp. This software is furnished 
 * pursuant to a written license agreement and may be used, copied, 
 * transmitted, and stored only in accordance with the terms of such 
 * license and with the inclusion of the above copyright notice. Please 
 * refer to the file "COPYRIGHT" for further copyright and licensing 
 * information. This software and information or any other copies 
 * thereof may not be provided or otherwise made available to any other 
 * person. 
 */
import inetsoft.report.*;
import inetsoft.report.lens.*;
import inetsoft.report.style.*;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import java.text.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * This examples shows print the output of a SQL query as a table on
 * a report. (A JDBC ready database needs to be setup to run)
 *
 * @version 3.0, 5/10/2000
 * @author InetSoft Technology Corp
 */
public class JDBCReport extends JDialog 
{
  
   private static JDBCReport _instance ;
   private SgaPreviewer2D previewer;

   private JPanel dataPanel = new JPanel();
   private GridBagLayout panelLayout = new GridBagLayout();

   private JPanel cmdPnl = new JPanel();
   private JButton okB = new JButton();
   private JButton cancelB = new JButton();
   
   private JLabel labelUserID = new JLabel();
   private JTextField mUserId = new JTextField();

   private JLabel labelPassword = new JLabel();
   private JPasswordField mPassword = new JPasswordField();

   private JLabel labelUrl = new JLabel();
   private JTextField mUrl = new JTextField();

   private JLabel labelSql = new JLabel();
   private JTextArea mSql = new JTextArea();
   private JScrollPane scrollerSql = new JScrollPane();
  
   
   public JDBCReport(SgaPreviewer2D previewer) 
   {
      super(JOptionPane.getFrameForComponent(previewer));
      _instance = this;
      this.previewer = previewer;
      
      jbInit();
   }
   
   public void showThisInstance()
   {
      setModal(true);
      pack();
      setVisible(true);
   }

   public static JDBCReport getInstance()
   {
     return _instance;
   }
   
   private void jbInit()
   {
      dataPanel.setLayout(panelLayout);
      mUserId.setText(SgaUtilPuesto.getInstance().getProperty("Usuari"));
      dataPanel.add(labelUserID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(mUserId, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      labelUserID.setLabelFor(mUserId);
      mUserId.setColumns(10);
      labelUserID.setText("Usuario");
      mUserId.setToolTipText("Usuario de conexion JDBC");
      
      mPassword.setText(SgaUtilPuesto.getInstance().getProperty("Password"));
      dataPanel.add(labelPassword, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(mPassword, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      labelPassword.setLabelFor(mPassword);
      mPassword.setColumns(10);
      labelPassword.setText("Password");
      mPassword.setToolTipText("Password del usuario");

      mUrl.setText(SgaUtilPuesto.getInstance().getProperty("URL"));
      dataPanel.add(labelUrl, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(mUrl, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      labelUrl.setLabelFor(mUrl);
      mUrl.setColumns(50);
      labelUrl.setText("URL");
      mUrl.setToolTipText("URL de la conexión JDBC");

      dataPanel.add(labelSql, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      dataPanel.add(scrollerSql, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
      labelSql.setLabelFor(scrollerSql);
      scrollerSql.getViewport().add(mSql);
      mSql.setColumns(60);
      mSql.setRows(4);
      mSql.setLineWrap(false);
      
      labelSql.setText("SQL");
      mSql.setToolTipText("Sentencia SQL");
      
      getContentPane().add(dataPanel, "Center");

      okB.setText("Ejecutar");
      okB.setToolTipText("Ejecuta la sentencia SQL");
      okB.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            executarConsulta();
          }
        });

      cancelB.setText("Cancelar");
      cancelB.setToolTipText("Cancela la sentencia SQL");
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
   
   public void executarConsulta() {
      //Guardem els paràmetres de connexió actuals
     SgaUtilPuesto.getInstance().storeNewProperty("Usuari", mUserId.getText());
     SgaUtilPuesto.getInstance().storeNewProperty("Password", new String(mPassword.getPassword()));
     SgaUtilPuesto.getInstance().storeNewProperty("URL", mUrl.getText());
      
	    // preview report
	    StyleSheet report = createReport(true);
      previewer.pack();
	    previewer.print(report);
      dispose();
	    //JDBCReport.this.previewer.pack();
	    //JDBCReport.this.previewer.setVisible(true);
	 }
   
   public StyleSheet createReport(boolean render) {
      StyleSheet report = new StyleSheet();
      // set orientation
      report.setOrientation(StyleSheet.LANDSCAPE);
      // set header and footer
      report.setCurrentAlignment(StyleSheet.H_CENTER);
      report.addHeaderText("INFORME JDBC, Pagina {P} de {N}");
      report.addFooterText("{D,MM/dd/yyyy} {T}");

      // add format to format the date/time field
      report.addFormat(Timestamp.class, new SimpleDateFormat("MM/dd/yyyy"));
      report.setCurrentTableLayout(StyleSheet.TABLE_FIT_CONTENT);

      try {
	 // perform the query
	 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection conn = DriverManager.getConnection(mUrl.getText(), 
						       mUserId.getText(), 
						       new String(mPassword.getPassword()));

	 Statement stmt = conn.createStatement();
	 ResultSet data = stmt.executeQuery(mSql.getText());
	 
	 // create a table lens from the query result
	 JDBCTableLens lens = new JDBCTableLens(data);
	 lens.setColAutoSize(true);
      try {
         // Agafem l'estil del fitxer de propietats
         String defaultStyle = SgaUtilPuesto.getInstance().getProperty("TableStyle", "Grid8");
         TableStyle style =
         (TableStyle) Class.forName("inetsoft.report.style." + defaultStyle).newInstance();
         style.setTable(lens);
         
         //report.addTable(style);
         report.addTable(lens);
         report.setTableStyle("Table1", style);

//          report.getElement("Table1").setID("SgaTabla");
//          report.setTableStyle("Table1", style);
      } catch(Exception e) {
         e.printStackTrace();
         SgaRecursos.reportException(this, e);
      }
   
//	 report.addTable(new Classic4(lens));

	 data.close();
	 stmt.close();
	 conn.close();
      } catch(Exception e) 
      {
        report.addText(e.toString());
        SgaRecursos.reportException(this, e);
      }
      
      return report;
   }

   public static void show(SgaPreviewer2D previewer) 
   {
    if (_instance == null)
      new JDBCReport(previewer);
    _instance.showThisInstance();
   }
   
   
}
