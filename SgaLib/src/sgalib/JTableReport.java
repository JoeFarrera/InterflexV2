package sgalib;

import inetsoft.report.PDFPrinter;
import inetsoft.report.Presenter;
import inetsoft.report.PreviewView;
import inetsoft.report.Previewer;
import inetsoft.report.ReportElement;
import inetsoft.report.StyleConstants;
import inetsoft.report.StyleSheet;
import inetsoft.report.io.ExcelGenerator;
import inetsoft.report.lens.TextTableLens;
import inetsoft.report.lens.swing.JTableLens;
import inetsoft.report.style.TableStyle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileOutputStream;

import java.sql.Timestamp;
import java.text.NumberFormat;

import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import oracle.jbo.domain.Date;
import oracle.jbo.uicli.jui.JUTableSortModel;

/**
 * @version 3.0, 5/10/2000
 * @author InetSoft Technology Corp
 */
public class JTableReport extends JPanel 
{

   String[] stylist = {"Accounting1", "Accounting2", "Accounting3",
   "Accounting4", "Effect3D1", "Effect3D2",
   "Effect3D3", "Classic1",
   "Classic2", "Classic3", "Classic4", "Colorful1",
   "Colorful2", "Colorful3", "Colorful4",
   "ColumnFillHeader", "ColumnFillTotals",
   "ColumnFillColor", "Columns1", "Columns2", "Columns3",
   "Columns4", "Columns5", "Columns6",
   "DoubleBorderHeader", "DoubleBorderMixed",
   "Elegant", "FancyFills", "FancyHeader", "FancyJustify",
   "FancyLabels", "FancyOpen", "FancyShading",
   "FancyTotals", "Grid1", "Grid2", "Grid3", "Grid4",
   "Grid5", "Grid6", "Grid7", "Grid8", "HeaderFillColumn",
   "HeaderFillSingle", "LedgerHeader", "LedgerOpen",
   "List1", "List2", "List3", "List4",
   "List5", "List6", "List7", "List8",
   "NoLinesColumns", "NoLinesHeader", "NoLinesNoBorders",
   "NoLinesSeparator", "NoLinesSingle", "NoLinesTotals",
   "Professional", "RowFillColumns", "RowFillHeader",
   "RowFillSingle", "Simple1", "Simple2", "Simple3",
   "Simple4", "SingleDoubleBorder", "SingleLines",
   "SingleNoBorder", "SingleOpen", "SingleUnderlined",
   "Subtle1", "Subtle2", "Contemporary1",
   "Contemporary2", "ButtonHeaderGrid", "Raised3DGrid",
   "Lowered3DGrid", "DoubleRaised3DGrid",
   "DoubleLowered3DGrid", "DoubleLineGrid",
   "GreenStrip"};

   JTextField title = new JTextField();
   JPanel optPnl = new JPanel();
   JComboBox tableStyle = new JComboBox(stylist);
   JCheckBox landscape = new JCheckBox("Landscape");;
   JPanel cmdPnl = new JPanel();
   JButton previewB = new JButton();
   JButton showB = new JButton();
   JButton excelB = new JButton();   
   JButton cerrarB = new JButton();   
   JTable jTable = null;
   String sWhereClause = null;
   JDialog jFrame = null;
   TextTableLens table;
   JListSelector listSelector = new JListSelector(180, 130);
   JPanel panelSelector = new JPanel(null);
   
   public JTableReport(JTable jTable, String sReportTitle, boolean bLandscape, String sWhereClause) 
   {
      this.jTable = jTable;
      this.sWhereClause = sWhereClause;
      this.jFrame = jFrame;
      
      this.setLayout(new BorderLayout(5,5));
      this.setSize(new Dimension(600, 210));
      this.setPreferredSize(new Dimension(600,210));
      
      title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      title.setBounds(0,0,501,22);
      title.setFont(new Font("Serif", Font.BOLD, 14));
      this.add(title, BorderLayout.NORTH);

      int width = listSelector.getWidth();        // Actual total width of the component
      int height = listSelector.getHeight();      // Actual total height of the component
      panelSelector.setBorder(BorderFactory.createEtchedBorder());
      panelSelector.setBounds(0,0,width+25,height+45);
      listSelector.setBounds(10,10,width, height);
      panelSelector.add(listSelector);
      this.add(panelSelector, BorderLayout.CENTER);
      
      prepararCamps();
      
      optPnl.setLayout(new GridBagLayout());
      optPnl.setFont(new Font("Dialog", Font.PLAIN, 12));
      this.add(optPnl, BorderLayout.EAST);

      tableStyle.setFont(new Font("Dialog", Font.BOLD, 12));
      optPnl.add(tableStyle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));

      landscape.setFont(new Font("Dialog", Font.BOLD, 12));
      optPnl.add(landscape, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));

      cmdPnl.setLayout(new FlowLayout(FlowLayout.CENTER,40,5));
      cmdPnl.setFont(new Font("Dialog", Font.PLAIN, 12));
      this.add(cmdPnl, BorderLayout.SOUTH);

      previewB.setText("Preview");
      previewB.setFont(new Font("Dialog", Font.BOLD, 12));
      cmdPnl.add(previewB);
      
      showB.setText("PDF");
      showB.setFont(new Font("Dialog", Font.BOLD, 12));
      // Xavi, no mostrem aquest boto (Borrar-ho definitivament??)
      //cmdPnl.add(showB);

      excelB.setText("Excel");
      excelB.setFont(new Font("Dialog", Font.BOLD, 12));
      // Xavi, no mostrem aquest boto (Borrar-ho definitivament??)
      //cmdPnl.add(excelB);

      cerrarB.setText("Cerrar");
      cerrarB.setFont(new Font("Dialog", Font.BOLD, 12));
      cmdPnl.add(cerrarB);
      
/*      previewB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            StyleSheet report = createReport();
            
            PreviewView previewer = Previewer.createPreviewer();
            
            if(landscape.isSelected()) {
               report.setOrientation(StyleConstants.LANDSCAPE);
//               previewer.setPageWidth(StyleConstants.PAPER_LETTER.height);
//               previewer.setPageHeight(StyleConstants.PAPER_LETTER.width);
            }
            
            previewer.pack();
            previewer.setVisible(true);
            previewer.print(report);
         }
      });*/
      previewB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            StyleSheet report = createReport();
            
            SgaPreviewer2D previewer = new SgaPreviewer2D(report);
            previewer.getParams();
            previewer.showAllProperties();
      
            previewer.setVisible(false);
            previewer.initTableStyleAndLandscape();
            
            previewer.execute();
      
            previewer.pack();
      
            previewer.setVisible(true);
      
            previewer.printReport();
         }
      });
      
      
      showB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
            StyleSheet report = createReport();
            
            try {
               PDFPrinter pdf = null;
               File file = JTableReport.this.seleccionarFitxerDesti("pdf", "Archivos PDF");
               if(file != null) {
                  pdf = new PDFPrinter(new FileOutputStream(file));
               }
               
               if(landscape.isSelected()) {
                  // Michael 22.09.2005 Was: StyleConstants.PAPER_LETTER.rotate()
                  pdf.setPageSize(StyleConstants.PAPER_A4.rotate());
               }
               
                report.print(pdf.getPrintJob());
                pdf.close();
               
               JOptionPane.showMessageDialog(null, "Transferencia terminada al fichero " + file.getAbsoluteFile());
            } 
            catch(Exception ex) 
            {
               ex.printStackTrace();
            }
         }
      });

      excelB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
            StyleSheet report = createReport();
            
            try {
               ExcelGenerator gen = null;
               File file = JTableReport.this.seleccionarFitxerDesti("xls", "Archivos EXCEL");
               if(file != null) {
                  // Michael 22.09.2005 mejor optimizar por datos ExcelGenerator.EXCEL_SHEET
                  gen = ExcelGenerator.createExcelGenerator( new FileOutputStream(file), ExcelGenerator.EXCEL_DATA);
               }
               
//               if(landscape.isSelected()) {
//                  gen.setPageSize(StyleConstants.PAPER_LETTER.rotate());
//               }
               
               gen.generate(report);                              
               JOptionPane.showMessageDialog(null, "Transferencia terminada al fichero " + file.getAbsoluteFile());
            } 
            catch(Exception ex) 
            {
               ex.printStackTrace();
            }
         }
      });

      cerrarB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
            try 
            {
              ReportDialog.close();
            } 
            catch(Exception ex) 
            {
               ex.printStackTrace();
            }
         }
      });
      String defaultStyle = SgaUtilPuesto.getInstance().getProperty("TableStyle", "Grid8");      
      tableStyle.setSelectedItem(defaultStyle);
      
/*      //Agafem algunes propietats de la taula
      JUTableSortModel tableSortModel = (JUTableSortModel)jTable.getModel();
      String titol = (String)tableSortModel.getTableBinding().getViewObject().getProperty("ReportTitle");
      if (titol != null)
        title.setText(titol);
      String orientacio = (String)tableSortModel.getTableBinding().getViewObject().getProperty("ReportOrientation");
      if (orientacio != null && orientacio.equals("PageFormat.LANDSCAPE"))
        landscape.setSelected(true);*/

      title.setText(sReportTitle);
      landscape.setSelected(bLandscape);
   }
   
   
   public StyleSheet createReport() {
      
      prepararConsulta();
      
      StyleSheet report = new StyleSheet();
      
      report.saveContext("default");
      
      // set header and footer
      String titlestr = title.getText();
      report.setCurrentHeader(report.FIRST_PAGE_HEADER);
      report.setCurrentAlignment(StyleSheet.H_CENTER);
      report.setCurrentFont(new Font("Serif", Font.BOLD, 16));
      report.addHeaderText(titlestr);

      report.setCurrentAlignment(StyleSheet.H_RIGHT);
      report.addHeaderImage(SgaRecursos.createImageIcon(getClass(),SgaRecursos.getInstance().getString("Logo.file"), null).getImage());

      if (sWhereClause != null)
      {
        report.addNewline(1);
        report.setCurrentAlignment(StyleSheet.H_LEFT);
        report.setCurrentFont(new Font("Serif", Font.BOLD | Font.ITALIC, 10));
        report.addText("Filtro aplicado: " + sWhereClause);
      }

      report.setCurrentAlignment(StyleSheet.H_CENTER);
      report.setCurrentFont(new Font("Serif", Font.BOLD | Font.ITALIC, 8));
      report.addFooterText("Página {P} de {N}, {D,dd/MM/yyyy} {T}");
      
      // add format to format the date/time field
      report.addFormat(Timestamp.class, new SimpleDateFormat("dd/MM/yyyy HH:mm"));
      //report.addFormat(FlexiDate.class, new SimpleDateFormat("dd/MM/yyyy HH:mm"));
      report.addFormat(Number.class, NumberFormat.getNumberInstance());
      report.setCurrentTableLayout(StyleSheet.TABLE_FIT_CONTENT);
      
      report.selectContext("default");
      
       // create a table lens
      JTableLens lens = new JTableLens(jTable);
      lens.setColAutoSize(true);
      lens.setFont(new Font("Serif", Font.PLAIN, 8));
      lens.setRowHeight(10);

      
      
      
//      lens.setRowAutoSize(true);
//      report.addTable(lens);

      try {
         TableStyle style =
         (TableStyle) Class.forName("inetsoft.report.style." +
         tableStyle.getSelectedItem()).newInstance();
         style.setTable(lens);
         
         //report.addTable(style);
         report.addTable(lens);
         report.setTableStyle("Table1", style);

//          report.getElement("Table1").setID("SgaTabla");
//          report.setTableStyle("Table1", style);
      } catch(Exception e) {
         e.printStackTrace();
      }
  
      report.setCurrentAlignment(StyleSheet.H_LEFT);

      return report;
   }




  private void prepararConsulta()
  {
    DefaultListModel fromModel = listSelector.getFromModel();
    int iSize = fromModel.getSize();
    for(int i=0; i<iSize; i++)
      try
      {
        jTable.removeColumn(jTable.getColumn((String)fromModel.get(i)));
      }
      catch(IllegalArgumentException ex)
      {
        //no fem res per que vol dir que la columna ja s'ha esborrat previament
      }
  }

  private void prepararCamps()
  {
    // Add list of items to FromList
    DefaultListModel toModel = listSelector.getToModel();
    for (int i = 0; i < jTable.getColumnCount(); i ++)
        toModel.addElement(jTable.getColumnName(i).trim());
  }

  public File seleccionarFitxerDesti(String extension, String description)
  {
    ExampleFileFilter fileFilter = new ExampleFileFilter(extension, description);
    JFileChooser fc = new JFileChooser();
    if (fc != null)
    {
      fc.addChoosableFileFilter(fileFilter);
      fc.setFileFilter(fileFilter);
      fc.setSelectedFile(new File("informe." + extension));
      int returnVal = fc.showSaveDialog(JTableReport.this);
      if (returnVal == JFileChooser.APPROVE_OPTION)
        return(fc.getSelectedFile());
    }
    return null;
  }

}
