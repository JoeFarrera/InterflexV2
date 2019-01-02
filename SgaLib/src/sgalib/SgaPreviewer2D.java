package sgalib;

import inetsoft.report.PDFPrinter;
import inetsoft.report.ReportElement;
import inetsoft.report.ReportEnv;
import inetsoft.report.ReportSheet;
import inetsoft.report.StyleConstants;
import inetsoft.report.TableElement;
import inetsoft.report.XSessionManager;
import inetsoft.report.design.StyleViewer;
import inetsoft.report.event.ProgressEvent;
import inetsoft.report.event.ProgressListener;
import inetsoft.report.io.Builder;
import inetsoft.report.io.ExcelGenerator;
import inetsoft.report.j2d.Previewer2D;
import inetsoft.report.style.TableStyle;

import inetsoft.uql.VariableTable;
import inetsoft.uql.schema.UserVariable;

import inetsoft.widget.DateCombo;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JWindow;
import javax.swing.ProgressMonitor;
import javax.swing.SwingConstants;


/**
 * TODO: Tratar exceptions, enseñar al usuario
 * Guardar preferencias directorios excel / pdf en propiedades del PC
 * Enseñar último directorio en guardar excel / pdf
 * Opciones excel / pdf
 * Dejar al usuario elegir un informe a ejecutar
 * Mover textos al fichero de recursos
 * 
 */
public class SgaPreviewer2D extends Previewer2D
{ 

  private static final String SGATABLA = "SgaTabla";
  private static final String TABLE1 = "Table1";
  private static final String TITOL = "SGA - visualizador de informes";
//  private ImageIcon imageExcel = new ImageIcon(getClass().getResource("/resources/images/24x24/plain/excel_logo.png"));
//  private ImageIcon imagePdf = new ImageIcon(getClass().getResource("/resources/images/24x24/plain/pdf_logo.png"));
//  private ImageIcon imagePalette = new ImageIcon(getClass().getResource("/resources/images/24x24/plain/palette2.png"));
//  private ImageIcon imageRefresh = new ImageIcon(getClass().getResource("/resources/images/24x24/plain/gear_refresh.png"));
  
  private ImageIcon imageOpen = SgaRecursos.createImageIcon(getClass(), "16x16/plain/folder.png", null);
  private ImageIcon imageExcel = SgaRecursos.createImageIcon(getClass(), "16x16/plain/excel_logo.png", null);
  private ImageIcon imagePdf = SgaRecursos.createImageIcon(getClass(), "16x16/plain/pdf_logo.png", null);
  private ImageIcon imagePalette = SgaRecursos.createImageIcon(getClass(), "16x16/plain/palette2.png", null);
  private ImageIcon imageRefresh = SgaRecursos.createImageIcon(getClass(), "16x16/plain/gear_refresh.png", null);
  private ImageIcon imageConfig = SgaRecursos.createImageIcon(getClass(), "16x16/plain/form_blue.png", null);
  private ImageIcon imageJDBC = SgaRecursos.createImageIcon(getClass(), "vtw.gif", null);

  private ReportSheet report;
  private XSessionManager sessionManager;
  private UserVariable[] params;
  private VariableTable vars = new VariableTable();  
  
   private JButton buttonOpen = new JButton("Abrir..", imageOpen); // Obrir un informe
   private JButton buttonExcel = new JButton("Excel..", imageExcel); // Exportar a excel
   private JButton buttonPdf = new JButton("PDF..", imagePdf); // Exportar a PDF
   private JButton buttonRefresh = new JButton("Ejecutar..", imageRefresh); // Refrescar les dades
   private JButton tableStyleButton = new JButton("Estilo...", imagePalette); // Estil
//   private JComboBox tableStyle = new JComboBox(stylist);
   private JCheckBox landscape = new JCheckBox("Apaisado");
   private JButton buttonConfig = new JButton("Configurar..", imageConfig); // Obrir un informe
   private JButton buttonJDBC = new JButton("JDBC..", imageJDBC); // Obrir un informe
//   private DateCombo date = new DateCombo ();

  private Thread generateThread = null;
   

  public SgaPreviewer2D()
  {
    this(null);
  }
   
  public SgaPreviewer2D(ReportSheet report)
  {
    super(TITOL);
    this.report = report;
    try
    {
      jbInit();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      SgaRecursos.reportException(this, ex);
    }
    
  }

  private void jbInit()
  {
    
    
    buttonOpen.setToolTipText("Abrir un informe nuevo");
    buttonOpen.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          abrirReport();
        }
      });

    buttonExcel.setToolTipText("Guardar el informe en formato compatible con Excel");
    buttonExcel.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) 
       {
        generateExcel();
       }
    });
    
    buttonPdf.setToolTipText("Guardar el informe en formato PDF");
    buttonPdf.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) 
       {
        generatePdf();
       }
    });
        
//    tableStyle.setMaximumSize(new Dimension (15, 25));
//    tableStyle.setToolTipText("Seleccionar un estilo específico para el informe");
//    tableStyle.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent e)
//        {
//          modificarTableStyle();
//        }
//      });

    landscape.setToolTipText("Tildar para imprimir / grabar el informe en apaisado");
    landscape.setVerticalTextPosition(SwingConstants.BOTTOM);
    landscape.setHorizontalTextPosition(SwingConstants.CENTER);
    landscape.addItemListener(new ItemListener()
      {
        public void itemStateChanged(ItemEvent e)
        {
          modificarLandscape(e);
        }
      });
        
    buttonRefresh.setToolTipText("Volver a executar el report, especificando los parámetros de nuevo");
    buttonRefresh.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          refreshReport();
        }
      });

    tableStyleButton.setToolTipText("Seleccionar un estilo específico para el informe");
    tableStyleButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          modificarEstil();
        }
      });

    buttonConfig.setToolTipText("Configurar las propiedades de la aplicación");
    buttonConfig.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          configurar();
        }
      });

    buttonJDBC.setToolTipText("Ejecutar consulta por JDBC");
    buttonJDBC.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          consultaJDBC();
        }
      });
    
    Dimension dim = new Dimension(5,30);      
    JToolBar.Separator s1 = new JToolBar.Separator(dim);    
    s1.setOrientation(JSeparator.VERTICAL);
    addToolbarComponent(s1);
    addToolbarComponent(buttonOpen);
    addToolbarComponent(buttonJDBC);
    addToolbarComponent(buttonRefresh);
    JToolBar.Separator s2 = new JToolBar.Separator(dim);    
    s2.setOrientation(JSeparator.VERTICAL);
    addToolbarComponent(s2);
    addToolbarComponent(tableStyleButton);
    addToolbarComponent(landscape);        
    JToolBar.Separator s3 = new JToolBar.Separator(dim);    
    s3.setOrientation(JSeparator.VERTICAL);
    addToolbarComponent(s3);
    addToolbarComponent(buttonExcel);
    addToolbarComponent(buttonPdf);
    JToolBar.Separator s4 = new JToolBar.Separator(dim);    
    s4.setOrientation(JSeparator.VERTICAL);
    addToolbarComponent(s4);
    addToolbarComponent(buttonConfig);
    
    //setExitOnClose(true);   
    setTitle(getTitle(report));
  }
  

  private void abrirReport()
  {
    try
    {
      File fichero = SgaRecursos.seleccionarFitxer(SgaUtilPuesto.getInstance().getProperty("DirectoriReports"), 
                    "srt", "Fichero informe", true, this);
      if (fichero != null)
      {
        //Posem el cursor en wait
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        SgaUtilPuesto.getInstance().storeNewProperty("DirectoriReports", fichero.getParent());
        System.out.println(System.getProperty("uql.home"));
        InputStream inputStream = new FileInputStream (fichero);
        
        
        Builder builder = Builder.getBuilder(Builder.TEMPLATE,
          inputStream);

        report = builder.read(".");
        
        getParams();
        showAllProperties();
  
        initTableStyleAndLandscape();
        
        execute();

        pack();
  
        printReport();        
        //Restaurem el cursor per defecte
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      SgaRecursos.reportException(this, ex);
      //Restaurem el cursor per defecte
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
 }

  
  private void generateExcel()
  {

		generateThread = new Thread(new ExportExcel());
		generateThread.start();

/*    ExcelGenerator gen = null;
    try 
    {
      report = (getReport()!= null ? getReport() : report);
      if (report != null)
      {
         File file = SgaRecursos.seleccionarFitxer(SgaUtilPuesto.getInstance().getProperty("DirectoriExcel"), "xls", "Archivos EXCEL", false, this);
         if(file != null) 
         {
            SgaUtilPuesto.getInstance().storeNewProperty("DirectoriExcel", file.getParent());
            // EXCEL_DATA es optimizar por datos - normalmente deseable
            gen = ExcelGenerator.createExcelGenerator( new FileOutputStream(file), ExcelGenerator.EXCEL_DATA);
         }
         if (gen != null)
         {
           gen.generate(report);                              
           JOptionPane.showMessageDialog(null, "<html><p>Fichero: </p><p><strong><em>" + file.getAbsoluteFile() + "</p></strong></em><p>generado</p></html>", "Fichero Excel",
            JOptionPane.INFORMATION_MESSAGE, imageExcel);
         }
      }
    } 
    catch(Exception ex) 
    {
       ex.printStackTrace();
       SgaRecursos.reportException(this, ex);
    }*/
 }
 

 
 private void modificarTableStyle(TableStyle style)
 {
    try
    {
      report = (getReport()!= null ? getReport() : report);
      if (report != null)
      {
        report.setTableStyle(getTableId(), style);
        //Guardem l'estil al fitxer de propietats
        SgaUtilPuesto.getInstance().storeNewProperty("TableStyle", style.getName());
        print(report);
      }
    } 
    catch (Exception e)
    {
      e.printStackTrace();
      SgaRecursos.reportException(this, e);
    }
    
 }

 private void modificarLandscape(ItemEvent e)
 {
    try
    {
      report = (getReport()!= null ? getReport() : report);
      if (report != null)
      {
        if (e.getStateChange() == ItemEvent.SELECTED) 
        {
            report.setOrientation(report.LANDSCAPE);
        }
        else
        {
            report.setOrientation(report.PORTRAIT);
        }
        if (isVisible())
          print(report);
      }
    } 
    catch (Exception apaisat)
    {
      apaisat.printStackTrace();
      SgaRecursos.reportException(this, apaisat);
    }
 }
 
 
 private void generatePdf()
 {
		Thread t = new Thread(new ExportPdf());
		t.start();

/*    try 
    {
      report = (getReport()!= null ? getReport() : report);
      if(report != null)
      {
         PDFPrinter pdf = null;
         File file = SgaRecursos.seleccionarFitxer(SgaUtilPuesto.getInstance().getProperty("DirectoriPdf"),
                    "pdf", "Archivos PDF", false, this);
         if(file != null) 
         {
            SgaUtilPuesto.getInstance().storeNewProperty("DirectoriPdf", file.getParent());
            pdf = new PDFPrinter(new FileOutputStream(file));
         }
          
          if (pdf != null)
          {
           if(landscape.isSelected()) 
           {
              pdf.setPageSize(StyleConstants.PAPER_A4.rotate());
           }
           report.print(pdf.getPrintJob());
           pdf.close();
           JOptionPane.showMessageDialog(null, "<html><p>Fichero: </p><p><strong><em>" + file.getAbsoluteFile() + "</p></strong></em><p>generado</p></html>", "Fichero PDF",
            JOptionPane.INFORMATION_MESSAGE, imagePdf);
          }
      }
    } 
    catch(Exception ex) 
    {
       ex.printStackTrace();
       SgaRecursos.reportException(this, ex);
    }*/
 }
  
  private String getTitle(ReportSheet report)
  {
    if (report != null)
    {
      Properties props = report.getProperties();
      return props.getProperty("report.title");
    }
    return TITOL;
  }
  
  public void showAllProperties()
  {
    if (report != null)
    {
      Properties props = report.getProperties();
      Enumeration propNames = props.propertyNames();
      for (int i = 0; i < props.size(); i++)
      {
        String propName = (String)propNames.nextElement();
        System.out.println("Property: " + propName + " value = " + props.getProperty(propName));
      }
    }
  }

  public void initTableStyleAndLandscape ()
  {
    String currentStyle = null;
    try
    {
      currentStyle = getCurrentStyle().getName();    
    }
    catch (NoSuchElementException e)
    {
      e.printStackTrace();
//      return;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      SgaRecursos.reportException(this, e);
    }    
   landscape.setSelected(report.isLandscape());
  }

/*  
  public void showReport()
  {
        try 
        {
        
        File fichero = SgaRecursos.seleccionarFitxerDesti("srt", "Fichero informe", null);
        if (fichero == null)
          System.exit(0);
          
        // InputStream inputStream = new FileInputStream ("W:/users/projects/Balay/Balay10g/Reports/Historico movimiento existencias de un articulo.srt");
      InputStream inputStream = new FileInputStream (fichero);
        Builder builder = Builder.getBuilder(Builder.TEMPLATE,
          inputStream);
        report = builder.read(".");
        
      showAllProperties(report);
       
        sessionManager = XSessionManager.getSessionManager();    


       params = sessionManager.getQueryParameters(report, true);
       VariableTable vars = new VariableTable();
    
       // if there are any parameters, prompts using the custom prompt dialog
       if(params != null && params.length > 0) {
          vars = ParamDialog.show(params, null);
          // if user cancels, exit from the program
          if(vars == null) {
             System.exit(0);
          }
       }

        jbInit();

        setVisible(false);
        initTableStyleAndLandscape(report);
        sessionManager.execute(report, vars);

        pack();

        setVisible(true);

        print(report);
        
        } catch (Exception ex) 
        {
          ex.printStackTrace();
        } 
 
  }
*/
  
  public void refreshReport()
  {
    try 
    {
      report = (getReport()!= null ? getReport() : report);
      if (report != null)
      {
        if (params != null)
        {
          ParamDialog dialog = ParamDialog.getInstance();
          if (dialog != null)
          {
          VariableTable vars = dialog.showThisInstance();
           if (vars != null)
           {
             XSessionManager.getSessionManager().execute(report, vars);
           }
          }
          // :TODO - y si no tiene parámetros el informe
          print(report);
        }
      }
    } 
    catch (Exception ex) 
    {
      ex.printStackTrace();
      SgaRecursos.reportException(this, ex);
    } 
  }
  
  private void modificarEstil()
  {
    report = (getReport()!= null ? getReport() : report);
    if (report != null)
    {
      StyleViewer viewer = new StyleViewer(new Window(JOptionPane.getRootFrame()));
      // viewer.setVisible(true);
      TableStyle style = viewer.show(JOptionPane.getRootFrame(), (TableStyle)getCurrentStyle().clone());
      
      // TableStyle style = viewer.getSelectedStyle();
      if (style != null)
        modificarTableStyle(style);
    }
  }
  
  public void printReport()
  {
    print(report);
  }
  
  public void getParams()
  {
    try
    {
      sessionManager = XSessionManager.getSessionManager();
      params = sessionManager.getQueryParameters(report, true);
    
      // if there are any parameters, prompts using the custom prompt dialog
      if(params != null && params.length > 0) {
         vars = ParamDialog.show(params, this);
         // if user cancels, exit from the program
         if(vars == null) {
            System.exit(0);
         }
      }
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      SgaRecursos.reportException(this, ex);
    }
  }


  public void configurar()
  {
    try
    {    
       ConfigDialog.show(this);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      SgaRecursos.reportException(this, ex);
    }
  }

  public void consultaJDBC()
  {
    try
    {
      ReportEnv.setProperty("StyleReport.useCustomDriver", "true");
      JDBCReport.show(this);
      
      ReportEnv.setProperty("StyleReport.useCustomDriver", "false");
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      ReportEnv.setProperty("StyleReport.useCustomDriver", "false");
    }
  }
  
  public void execute()
  {
    try
    {
      sessionManager.execute(report, vars);
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      SgaRecursos.reportException(this, ex);
    }
    
  }

  private String getTableId()
  {
    ReportElement re = report.getElement(TABLE1);
    return (report.getElement(SGATABLA) != null ? SGATABLA : TABLE1 );
  }
  
  private TableStyle getCurrentStyle () throws NoSuchElementException
  {
      return report.getTableStyle(getTableId());    
  }
 
  /**
   * Exporta el resultat d'un informe a Excel
   */
  class ExportExcel implements Runnable
  {
    
    public void run()
    {
      WaitSplash waitSplash = null;
      ExcelGenerator gen = null;
      try 
      {
        report = (getReport()!= null ? getReport() : report);
        if (report != null)
        {
           File file = SgaRecursos.seleccionarFitxer(SgaUtilPuesto.getInstance().getProperty("DirectoriExcel"), "xls", "Archivos EXCEL", false, SgaPreviewer2D.this);
           if(file != null) 
           {
              SgaUtilPuesto.getInstance().storeNewProperty("DirectoriExcel", file.getParent());
              // EXCEL_DATA es optimizar por datos - normalmente deseable
              //gen = ExcelGenerator.createExcelGenerator( new FileOutputStream(file), ExcelGenerator.EXCEL_DATA);
              gen = ExcelGenerator.createExcelGenerator( new FileOutputStream(file), ExcelGenerator.EXCEL2000);
               if (gen != null)
               {
                 //Posem el cursor en wait
                 setCursor(new Cursor(Cursor.WAIT_CURSOR));
                 waitSplash = new WaitSplash(SgaPreviewer2D.this, -1, -1);
/*                 gen.addProgressListener(new ProgressListener()
                 {
                    public void valueChanged(ProgressEvent event)
                    {
                      System.out.println("Event: " + event.getCurrent());
                      //progressMonitor.setProgress(event.getCurrent());
                    }
                 }
                 );*/
                 gen.generate(report);   
                  //Posem el cursor per defecte
                  setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                  waitSplash.hideSplash();
                 JOptionPane.showMessageDialog(SgaPreviewer2D.this, "<html><p>Fichero: </p><p><strong><em>" + file.getAbsoluteFile() + "</p></strong></em><p>generado</p></html>", "Fichero Excel",
                  JOptionPane.INFORMATION_MESSAGE, imageExcel);
               }
           }
        }
      } 
      catch(Exception ex) 
      {
         ex.printStackTrace();
          //Posem el cursor per defecte
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          waitSplash.hideSplash();
         SgaRecursos.reportException(SgaPreviewer2D.this, ex);
      }
      
    }
    
  }
  
  /**
   * Exporta el resultat d'un informe a PDF
   */
  class ExportPdf implements Runnable
  {
    public void run()
    {
      WaitSplash waitSplash = null;
      try 
      {
        report = (getReport()!= null ? getReport() : report);
        if(report != null)
        {
           PDFPrinter pdf = null;
           File file = SgaRecursos.seleccionarFitxer(SgaUtilPuesto.getInstance().getProperty("DirectoriPdf"),
                      "pdf", "Archivos PDF", false, SgaPreviewer2D.this);
           if(file != null) 
           {
             //Posem el cursor en wait
             setCursor(new Cursor(Cursor.WAIT_CURSOR));
             waitSplash = new WaitSplash(SgaPreviewer2D.this, -1, -1);
             SgaUtilPuesto.getInstance().storeNewProperty("DirectoriPdf", file.getParent());
              pdf = new PDFPrinter(new FileOutputStream(file));
              if (pdf != null)
              {
               if(landscape.isSelected()) 
               {
                  pdf.setPageSize(StyleConstants.PAPER_A4.rotate());
               }
               report.print(pdf.getPrintJob());
               pdf.close();
              //Posem el cursor per defecte
              setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
              waitSplash.hideSplash();
               JOptionPane.showMessageDialog(SgaPreviewer2D.this, "<html><p>Fichero: </p><p><strong><em>" + file.getAbsoluteFile() + "</p></strong></em><p>generado</p></html>", "Fichero PDF",
                JOptionPane.INFORMATION_MESSAGE, imagePdf);
              }
           }
        }
      } 
      catch(Exception ex) 
      {
         ex.printStackTrace();
          //Posem el cursor per defecte
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          waitSplash.hideSplash();
         SgaRecursos.reportException(SgaPreviewer2D.this, ex);
      }
    }
  }
  
  
  class WaitSplash extends JWindow
  {
    Frame f = null;
    public WaitSplash(Frame f, int w, int h)
    {
      super(f);
      this.f = f;
      JPanel p = new JPanel();
      p.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createRaisedBevelBorder(),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
      ));
      JLabel l = new JLabel("Exportando fichero. Espere por favor...");
//      JButton buttonCancel = new JButton("Cancelar");
//      buttonCancel.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent e)
//        {
//          SgaPreviewer2D.this.generateThread.stop();
//          hideSplash();
//        }
//      });

      p.add(l);
      //De moment, no es pot aturar el proces d'una manera neta
//      p.add(buttonCancel);
      
      getContentPane().add(p);
      pack();
      // set the splash screen size
      if(w > 0 && h > 0) 
      {
        setSize(w, h);
      } 
      else 
      {
        setSize(p.getPreferredSize().width, p.getPreferredSize().height);
      }

			Dimension d = f.getSize();
			setLocation(
				Math.max(0, (d.getSize().width/2)  - (p.getSize().width/2)), 
				Math.max(0, (d.getSize().height/2) - (p.getSize().height/2))
			);

      show();
    }

    /**
     * Disposes the splash window.  
     * 
     * @see  #showSplash(Component, int, int)
     * @see  #showSplash(Component)
     */
    public void hideSplash() 
    {
      f.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      dispose();
    }
    
  }
}