package es.sysmap.interflex.report;

import inetsoft.report.ReportSheet;
import inetsoft.report.io.Builder;

import inetsoft.uql.schema.UserVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.Properties;

import javax.swing.UIManager;

import sgalib.SgaPreviewer2D;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

/**
 * TODO: Tratar exceptions, enseñar al usuario
 * Guardar preferencias directorios excel / pdf en propiedades del PC
 * Enseñar último directorio en guardar excel / pdf
 * Opciones excel / pdf
 * Dejar al usuario elegir un informe a ejecutar
 * Mover textos al fichero de recursos
 *
 */
public class RunPreview
{

  private SgaPreviewer2D previewer;
  private ReportSheet report;
  private UserVariable[] params;





  public RunPreview()
  {
  }

  public void showReport()
  {
    try
    {
      File fichero = SgaRecursos.seleccionarFitxer("srt", "Fichero informe", true, null);
      if (fichero == null)
        System.exit(0);

      // InputStream inputStream = new FileInputStream ("W:/users/projects/Balay/Balay10g/Reports/Historico movimiento existencias de un articulo.srt");
      InputStream inputStream = new FileInputStream (fichero);
      Builder builder = Builder.getBuilder(Builder.TEMPLATE,
        inputStream);
      report = builder.read(".");

      previewer = new SgaPreviewer2D(report);
      previewer.getParams();
      previewer.showAllProperties();

      previewer.setVisible(false);
      previewer.initTableStyleAndLandscape();

      previewer.execute();

      previewer.pack();

      previewer.setVisible(true);

      previewer.printReport();

    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      SgaRecursos.reportException(null, ex);
    }
  }


  public void showPreviewer()
  {
    try
    {
      previewer = new SgaPreviewer2D(report);
//      previewer.getParams();
//      previewer.showAllProperties();

      previewer.setExitOnClose(true);
      previewer.setVisible(false);
//      previewer.initTableStyleAndLandscape();

//      previewer.execute();

      previewer.pack();

      previewer.setVisible(true);

//      previewer.printReport();

    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      SgaRecursos.reportException(null, ex);
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


      //Intentem fixar algunes java options necessaries per stylereportpro
      Properties properties = System.getProperties();
      String value = SgaUtilPuesto.getInstance().getProperty("uql.home");
      if (value != null)
        properties.setProperty("uql.home", value);
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
      SgaRecursos.reportException(null, exemp);
    }
    RunPreview testReport = new RunPreview();
    //testReport.showReport();
    testReport.showPreviewer();
  }
}