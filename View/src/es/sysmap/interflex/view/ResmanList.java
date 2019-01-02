package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import inetsoft.report.PreviewView;
import inetsoft.report.Previewer;
import inetsoft.report.ReportSheet;
import inetsoft.report.XSessionManager;
import inetsoft.report.io.Builder;
import inetsoft.uql.VariableTable;
import inetsoft.uql.schema.UserVariable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JOptionPane;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import sgalib.SgaRecursos;

public class ResmanList 
{
  public ResmanList()
  {
  }
  
  public static void imprimirResmanList(Class clase, AppModule appModule, String iddoc, boolean missatge)
  {
    try
    {
      // Xavi, 27/05/05: No deixaria imprimir mai desde l'avis que dona al puesto
      // de picking quan arriba un mac per despatxar
      //if (!appModule.hasMoreSortidesAuto(iddoc))
      {
        //URL url = ClassLoader.getSystemResource("/es/sysmap/interflex/informes/PackingList.srt");
        //URL url = clase.getResource("/es/sysmap/interflex/informes/PackingList.srt");
        InputStream inputStream = clase.getResourceAsStream("/es/sysmap/interflex/informes/ResmanList.srt");
        //Builder builder = Builder.getBuilder(Builder.TEMPLATE,
        //  new FileInputStream(url.getPath()));
        Builder builder = Builder.getBuilder(Builder.TEMPLATE,
          inputStream);
        
        ReportSheet report = builder.read(".");
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
        previewer.print(report);
        
        // Marca cdoc com que s'ha impres el report resmantlist
        appModule.setResmanListImpres(iddoc);
        
      }
      //else
      //  if (missatge)
      //    JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("ResmanList.pendentAuto_label"));
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }

    
  }
}