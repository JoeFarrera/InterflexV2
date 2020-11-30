package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgavBultoCantErroneoRow;
import inetsoft.report.PreviewView;
import inetsoft.report.Previewer;
import inetsoft.report.ReportSheet;
import inetsoft.report.XSessionManager;
import inetsoft.report.io.Builder;
import inetsoft.report.io.ExcelGenerator;
import inetsoft.uql.VariableTable;
import inetsoft.uql.schema.UserVariable;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import sgalib.SgaRecursos;


public class PackingList 
{
  public PackingList()
  {
  }
  
  public static final int NACIONAL = 1;
  public static final int EXPORT = 2;
  
  public static String tooltipExportExcel = SgaRecursos.getInstance().getString("MenuFile.exportExcel_tooltip");
  public static Icon iconExportExcel = SgaRecursos.createImageIcon(SgaRecursos.getInstance().getClass(), "16x16/plain/excel.png", null);

  
  public static void imprimirPackingList(Class clase, 
        AppModule appModule, 
        String iddoc, 
        boolean missatge, 
        int tipo,
        final String nAlbaran)
  {
    try
    {
      if (appModule.imprimirPackingList(iddoc))
      {
        // TODO Michael 27.06.2019 Detectar órdenes con bultos erroneos
          SgavBultoCantErroneoRow row = appModule.getBultoCantErroneo(iddoc);
          if (row != null)
          {
              int result = JOptionPane.showConfirmDialog(null, "El document té una cantitat d'embalum erroni: " + row.toString() + " : <aceptar> per imprimir el PL, <cancelar> per corretjir embalums ", "Embalums erroneos en comanda", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
              switch (result) {
                case 2:
                  // cancel
                  return;
              };
          } 
        
        // TODO Fin
        //URL url = ClassLoader.getSystemResource("/es/sysmap/interflex/informes/PackingList.srt");
        //URL url = clase.getResource("/es/sysmap/interflex/informes/PackingList.srt");
        
        InputStream inputStream = (tipo == NACIONAL) ? clase.getResourceAsStream("/es/sysmap/interflex/informes/PackingList.srt") : clase.getResourceAsStream("/es/sysmap/interflex/informes/PackingListExp.srt");
        //Builder builder = Builder.getBuilder(Builder.TEMPLATE,
        //  new FileInputStream(url.getPath()));
        Builder builder = Builder.getBuilder(Builder.TEMPLATE,
          inputStream);
        
        final ReportSheet report = builder.read(".");
        VariableTable varTab = new VariableTable();
        varTab.put("ParamIddoc", iddoc);
        XSessionManager sessionManager = XSessionManager.getSessionManager();    
        //XSessionManager.getSessionManager().execute(report, varTab);
        UserVariable[] user = sessionManager.getQueryParameters(report, true);
        sessionManager.execute(report, varTab);
        PreviewView previewer = Previewer.createPreviewer();
        //previewer.setTitle("Llistat d'existències");
        previewer.pack();    
        previewer.setVisible(true);
      
        previewer.setExitOnClose(false);   
      
        // Save to excel

        JButton b = new JButton(
            " Desar en Excel ",
            iconExportExcel
        );
      b.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          exportExcelAction(report, nAlbaran);
        }
      });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add (b);
        previewer.addToolbarComponent(buttonPanel);
        
        previewer.print(report);
        
        
        // Activa l'enviament del document al host (Fa un commit implicit)
        appModule.setEnviarSortidaHost(iddoc);
      }
      else
        if (missatge)
          JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("PackingList.pendentImprimir_label"));
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }

    
  }
  
  
  public static void imprimirPackingListExped(Class clase, 
        AppModule appModule, 
        String idExped, 
        boolean missatge)
  {
    try
    {
     // if (appModule.imprimirPackingList(iddoc))
     // {
     
     
        
        InputStream inputStream = clase.getResourceAsStream("/es/sysmap/interflex/informes/PackingListExpedExp.srt");
        Builder builder = Builder.getBuilder(Builder.TEMPLATE,
          inputStream);
        
        final ReportSheet report = builder.read(".");
        VariableTable varTab = new VariableTable();
        varTab.put("ParamIdexped", idExped);
        XSessionManager sessionManager = XSessionManager.getSessionManager();    
        //XSessionManager.getSessionManager().execute(report, varTab);
        UserVariable[] user = sessionManager.getQueryParameters(report, true);
        sessionManager.execute(report, varTab);
        PreviewView previewer = Previewer.createPreviewer();
        //previewer.setTitle("Llistat d'existències");
        previewer.pack();    
        previewer.setVisible(true);
      
        previewer.setExitOnClose(false);   
      
        // Save to excel

        JButton b = new JButton(
            " Desar en Excel ",
            iconExportExcel
        );
        final String idExpedStr = idExped;
      b.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          exportExcelAction(report, idExpedStr);
        }
      });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add (b);
        previewer.addToolbarComponent(buttonPanel);
        
        previewer.print(report);
        
        
        // Activa l'enviament del document al host (Fa un commit implicit)
        // appModule.setEnviarSortidaHost(iddoc);
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }

    
  }
  
  private static void exportExcelAction(ReportSheet rep, String nAlbaran)
  {

    ExcelGenerator gen = null;
    try
    {
        
       String fileName = nAlbaran != null ? nAlbaran.replaceAll("[^a-zA-Z0-9.-]", "_") : "Packing_List";
       File file = SgaRecursos.seleccionarFitxer("C:\\Packing Lists\\" + fileName, "xls", "Archivos EXCEL", false, null);
       if(file != null) {
          // EXCEL_DATA es optimizar por datos - normalmente deseable
          gen = ExcelGenerator.createExcelGenerator( new FileOutputStream(file), ExcelGenerator.EXCEL_DATA);
       }
       if (gen != null)
       {
         gen.generate(rep);
         JOptionPane.showMessageDialog(null, "<html><p>Fichero: </p><p><strong><em>" + file.getAbsoluteFile() + "</p></strong></em><p>generado</p></html>", "Fichero Excel",
          JOptionPane.INFORMATION_MESSAGE, SgaRecursos.createImageIcon(SgaRecursos.getInstance().getClass(), "32x32/plain/excel_logo.png", null));
       }
    }
    catch(Exception ex)
    {
       ex.printStackTrace();
    }
  }

}