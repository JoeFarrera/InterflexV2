package es.sysmap.interflex.report;
import inetsoft.report.PDFPrinter;
import inetsoft.report.PagedPreviewPane;
import inetsoft.report.PreviewPane;
import inetsoft.report.ReportSheet;
import inetsoft.report.StyleConstants;
import inetsoft.report.StyleSheet;
import inetsoft.report.XSessionManager;
import inetsoft.report.io.Builder;
import inetsoft.report.io.ExcelGenerator;

import inetsoft.report.j2d.JPreviewPane;
import inetsoft.report.j2d.PreviewPane2D;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import sgalib.ExampleFileFilter;
import sgalib.SgaPreviewer2D;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;
import sgalib.ToggleButtonToolBar;
import sgalib.ToolBarPanel;

public class ReportFrame extends JFrame
{

  private ToggleButtonToolBar toolBar = new ToggleButtonToolBar();
  private JLabel statusBar = new JLabel();
  private JMenu menuHelp = new JMenu();
  private JMenu menuFile = new JMenu();
  private JMenuBar menuBar = new JMenuBar();
  private JPanel panelCenter = new JPanel();
  private BorderLayout layoutMain = new BorderLayout();
  //private PreviewPane previewer = new PreviewPane();
  private PreviewPane2D previewer = new PreviewPane2D();
  private BorderLayout borderLayout1 = new BorderLayout();
  private ReportSheet report;

  private ToolBarPanel toolbarPanel = new ToolBarPanel();

  public ReportFrame()
  {
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

    this.getContentPane().setLayout(layoutMain);

    panelCenter.setLayout(borderLayout1);
    panelCenter.setPreferredSize(new Dimension(933, 555));
    panelCenter.setMinimumSize(new Dimension(933, 555));
    panelCenter.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    previewer.setSize(new Dimension(607, 432));

    setSize(new Dimension(943, 634));
    setTitle(SgaRecursos.getInstance().getString("Frame.title"));

    // Creem la barra de menú de l'aplicació
    createMenuBar();

    // Afegim una barra de botons
    toolbarPanel.setLayout(new BorderLayout());
    toolbarPanel.add(toolBar, BorderLayout.CENTER);
    // Afegim la barra d'eines al panell principal
    getContentPane().add(toolbarPanel, BorderLayout.NORTH);
    afegirBoto(new ObrirFitxerAction());
    afegirBoto(new TancarFitxerAction());
    afegirBoto(new AjudaAction());
    toolBar.addSeparator();
    afegirBoto(new GenerarAction());
    afegirBoto(new ZoomInAction());
    afegirBoto(new ZoomOutAction());
    afegirBoto(new ExportExcelAction());
    afegirBoto(new ExportPdfAction());
    toolbarPanel.addContainerListener(toolbarPanel);

    getContentPane().add(panelCenter, BorderLayout.CENTER);
    panelCenter.add(previewer, BorderLayout.CENTER);

    statusBar.setText("");
    getContentPane().add(statusBar, BorderLayout.SOUTH);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = getSize();
    if (frameSize.height > screenSize.height)
    {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width)
    {
      frameSize.width = screenSize.width;
    }
    setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          fileExitAction();
        }
      });

    setVisible(true);

  }

  private void fileExitAction()
  {
    System.exit(0);
  }

  private void obrirFitxerAction()
  {
    doReport();
  }

  private void tancarFitxerAction()
  {
    System.out.println("Tancar fitxer") ;
    Toolkit.getDefaultToolkit().getPrintJob(this, null, null);
    //previewer.printAction(Toolkit.getDefaultToolkit().getPrintJob(this, null, null));
  }


  private void helpAboutAction()
  {
    JOptionPane.showMessageDialog(this, new AboutBoxPanel(), "About", JOptionPane.PLAIN_MESSAGE);
  }


  public void doReport()
  {
    try
    {
      File fichero = SgaRecursos.seleccionarFitxer(SgaUtilPuesto.getInstance().getProperty("DirectoriReports"),
                    "srt", "Fichero informe", true, null);
      if (fichero != null)
      {
        SgaUtilPuesto.getInstance().storeNewProperty("DirectoriReports", fichero.getParent());
        //InputStream inputStream = new FileInputStream ("W:/users/projects/Balay/Balay10g/Reports/Historico movimiento existencias de un articulo.srt");
        InputStream inputStream = new FileInputStream (fichero);
        Builder builder = Builder.getBuilder(Builder.TEMPLATE,
          inputStream);

        report = builder.read(".");
  //        VariableTable varTab = new VariableTable();
        // varTab.put("paramIdArt", "9000046086");
        XSessionManager sessionManager = XSessionManager.getSessionManager();
        //XSessionManager.getSessionManager().execute(report, varTab);
  //        UserVariable[] user = sessionManager.getQueryParameters(report, true);
        sessionManager.execute(report); //, varTab);
        // PreviewView previewer = Previewer.createPreviewer();
  //        previewer.setVisible(true);
        previewer.print(report);
        //doTest();

  //        panelCenter.revalidate();
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  private void doTest()
  {

    SgaPreviewer2D previewer_ = new SgaPreviewer2D(report);
    previewer_.setVisible(false);
    previewer_.initTableStyleAndLandscape();


    previewer_.printReport();

            //Afegit test

        int result = JOptionPane.showOptionDialog(
            null,                                       // the parent that the dialog blocks
            previewer_.getContentPane(),                                    // the dialog message array
            "test", // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            null,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );

            //Fi afegit test

  }
  private void generarAction()
  {
      doReport();
  }

  private void zoomInAction()
  {
    previewer.zoom(previewer.getZoom() * 1.2);
  }

  private void zoomOutAction()
  {
    previewer.zoom(previewer.getZoom() / 1.2);
  }

  private void exportExcelAction()
  {

    ExcelGenerator gen = null;
    try
    {
       File file = SgaRecursos.seleccionarFitxer("xls", "Archivos EXCEL", false, this);
       if(file != null) {
          // EXCEL_DATA es optimizar por datos - normalmente deseable
          gen = ExcelGenerator.createExcelGenerator( new FileOutputStream(file), ExcelGenerator.EXCEL_DATA);
       }
       if (gen != null)
       {
         gen.generate(report);
         JOptionPane.showMessageDialog(null, "<html><p>Fichero: </p><p><strong><em>" + file.getAbsoluteFile() + "</p></strong></em><p>generado</p></html>", "Fichero Excel",
          JOptionPane.INFORMATION_MESSAGE, SgaRecursos.createImageIcon(getClass(), "32x32/plain/excel_logo.png", null));
       }
    }
    catch(Exception ex)
    {
       ex.printStackTrace();
    }
  }


  private void exportPdfAction()
  {
    try
    {
       PDFPrinter pdf = null;
       File file = SgaRecursos.seleccionarFitxer("pdf", "Archivos PDF", false, this);
       if(file != null)
       {
          pdf = new PDFPrinter(new FileOutputStream(file));
       }

        if (pdf != null)
        {
         if(report.getOrientation() ==  ReportSheet.LANDSCAPE)
         {
            pdf.setPageSize(StyleConstants.PAPER_A4.rotate());
         }
         report.print(pdf.getPrintJob());
         pdf.close();
         JOptionPane.showMessageDialog(null, "<html><p>Fichero: </p><p><strong><em>" + file.getAbsoluteFile() + "</p></strong></em><p>generado</p></html>", "Fichero PDF",
          JOptionPane.INFORMATION_MESSAGE, SgaRecursos.createImageIcon(getClass(), "32x32/plain/pdf_logo.png", null));
        }
    }
    catch(Exception ex)
    {
       ex.printStackTrace();
    }

  }

  private void createMenuBar()
  {
    setJMenuBar(menuBar);

    createMenuItem(menuFile, "MenuFile.open_label", "MenuFile.open_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          obrirFitxerAction();
        }
      });

    createMenuItem(menuFile, "MenuFile.close_label", "MenuFile.close_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          tancarFitxerAction();
        }
      });

    menuFile.addSeparator();

    createMenuItem(menuFile, "MenuFile.generar_label", "MenuFile.generar_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          generarAction();
        }
      });

    createMenuItem(menuFile, "MenuFile.zoomin_label", "MenuFile.zoomin_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          zoomInAction();
        }
      });

    createMenuItem(menuFile, "MenuFile.zoomout_label", "MenuFile.zoomout_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          zoomOutAction();
        }
      });

    menuFile.addSeparator();

    createMenuItem(menuFile, "MenuFile.exportExcel_label", "MenuFile.exportExcel_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          exportExcelAction();
        }
      });

    createMenuItem(menuFile, "MenuFile.exportPdf_label", "MenuFile.exportPdf_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          exportPdfAction();
        }
      });

    menuFile.addSeparator();

    createMenu(menuFile, "MenuFile.file_label", "MenuFile.file_mnemonic");
    createMenuItem(menuFile, "MenuFile.exit_label", "MenuFile.exit_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          fileExitAction();
        }
      });

    createMenu(menuHelp, "MenuHelp.help_label", "MenuHelp.help_mnemonic");

    createMenuItem(menuHelp, "MenuHelp.about_label", "MenuHelp.about_mnemonic", new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          helpAboutAction();
        }
      });
  }

  /**
   * Crea un menú genèric
   */

  public void createMenu(JMenu menu, String label, String mnemonic)
  {
    menu.setText(SgaRecursos.getInstance().getString(label));
    menu.setMnemonic(SgaRecursos.getInstance().getMnemonic(mnemonic));
    menuBar.add(menu);
  }

  /**
   * Crea un item de menú genèric
   */

  public void createMenuItem(JMenu menu, String label, String mnemonic,
           ActionListener action)
  {
    JMenuItem mi = (JMenuItem) menu.add(new JMenuItem(SgaRecursos.getInstance().getString(label)));
    mi.setMnemonic(SgaRecursos.getInstance().getMnemonic(mnemonic));
    mi.addActionListener(action);
    if(action == null)
    {
      mi.setEnabled(false);
    }
  }

  /**
   * Afegeix un boto a la barra de botons
   * @param tooltip
   * @param action
   */
  public void afegirBoto(Action action)
  {
    toolBar.afegirToolbarApp(action);
  }


  /**
   * Obrir un report
   */

  class ObrirFitxerAction extends AbstractAction
  {

    private String tooltipObrir = SgaRecursos.getInstance().getString("MenuFile.open_tooltip");
    private Icon iconObrir = SgaRecursos.createImageIcon(getClass(), "openfile.gif", null);

    /**
     * Constructor
     */

    protected ObrirFitxerAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconObrir );
      putValue(Action.SHORT_DESCRIPTION, tooltipObrir);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      obrirFitxerAction();
    }
  }

  /**
   * Tancar un report
   */

  class TancarFitxerAction extends AbstractAction
  {

    private String tooltipTancar = SgaRecursos.getInstance().getString("MenuFile.close_tooltip");
    private Icon iconTancar = SgaRecursos.createImageIcon(getClass(), "print.gif", null);

    /**
     * Constructor
     */

    protected TancarFitxerAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconTancar );
      putValue(Action.SHORT_DESCRIPTION, tooltipTancar);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      tancarFitxerAction();
    }
  }


  /**
   * Tancar un report
   */

  class AjudaAction extends AbstractAction
  {

    private String tooltipTancar = SgaRecursos.getInstance().getString("MenuHelp.help_tooltip");
    private Icon iconTancar = SgaRecursos.createImageIcon(getClass(), "help.gif", null);

    /**
     * Constructor
     */

    protected AjudaAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconTancar );
      putValue(Action.SHORT_DESCRIPTION, tooltipTancar);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      helpAboutAction();
    }
  }


  /**
   * Generar un report
   */

  class GenerarAction extends AbstractAction
  {

    private String tooltipGenerar = SgaRecursos.getInstance().getString("MenuFile.generar_tooltip");
    private Icon iconGenerar = SgaRecursos.createImageIcon(getClass(), "32x32/plain/document_new.png", null);

    /**
     * Constructor
     */

    protected GenerarAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconGenerar );
      putValue(Action.SHORT_DESCRIPTION, tooltipGenerar);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      generarAction();
    }
  }


  /**
   * Zoom in un report
   */

  class ZoomInAction extends AbstractAction
  {

    private String tooltipZoomin = SgaRecursos.getInstance().getString("MenuFile.zoomin_tooltip");
    private Icon iconZoomin = SgaRecursos.createImageIcon(getClass(), "32x32/plain/zoom_in.png", null);

    /**
     * Constructor
     */

    protected ZoomInAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconZoomin );
      putValue(Action.SHORT_DESCRIPTION, tooltipZoomin);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      zoomInAction();
    }
  }


  /**
   * Zoom in un report
   */

  class ZoomOutAction extends AbstractAction
  {

    private String tooltipZoomout = SgaRecursos.getInstance().getString("MenuFile.zoomout_tooltip");
    private Icon iconZoomout = SgaRecursos.createImageIcon(getClass(), "32x32/plain/zoom_out.png", null);

    /**
     * Constructor
     */

    protected ZoomOutAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconZoomout );
      putValue(Action.SHORT_DESCRIPTION, tooltipZoomout);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      zoomOutAction();
    }
  }


  /**
   * Exportar a Excel
   */

  class ExportExcelAction extends AbstractAction
  {

    private String tooltipExportExcel = SgaRecursos.getInstance().getString("MenuFile.exportExcel_tooltip");
    private Icon iconExportExcel = SgaRecursos.createImageIcon(getClass(), "32x32/plain/excel_logo.png", null);

    /**
     * Constructor
     */

    protected ExportExcelAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconExportExcel );
      putValue(Action.SHORT_DESCRIPTION, tooltipExportExcel);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      exportExcelAction();
    }
  }


  /**
   * Exportar a PDF
   */

  class ExportPdfAction extends AbstractAction
  {

    private String tooltipExportPdf = SgaRecursos.getInstance().getString("MenuFile.exportPdf_tooltip");
    private Icon iconExportPdf = SgaRecursos.createImageIcon(getClass(), "32x32/plain/pdf_logo.png", null);

    /**
     * Constructor
     */

    protected ExportPdfAction()
    {
      super();

      putValue(Action.SMALL_ICON, iconExportPdf );
      putValue(Action.SHORT_DESCRIPTION, tooltipExportPdf);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      exportPdfAction();
    }
  }


  private class AboutBoxPanel extends JPanel
  {
    private Border border = BorderFactory.createEtchedBorder();
    private GridBagLayout layoutMain = new GridBagLayout();
    private JLabel labelCompany = new JLabel();
    private JLabel labelCopyright = new JLabel();
    private JLabel labelAuthor = new JLabel();
    private JLabel labelTitle = new JLabel();

    public AboutBoxPanel()
    {
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
      this.setLayout(layoutMain);
      this.setBorder(border);
      labelTitle.setText("Title");
      labelAuthor.setText("Author");
      labelCopyright.setText("Copyright");
      labelCompany.setText("Company");
      this.add(labelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 15, 0, 15), 0, 0));
      this.add(labelAuthor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0));
      this.add(labelCopyright, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0));
      this.add(labelCompany, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 5, 15), 0, 0));
    }
}

}