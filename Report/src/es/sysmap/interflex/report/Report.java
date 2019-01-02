package es.sysmap.interflex.report;
import inetsoft.report.PreviewView;
import inetsoft.report.Previewer;
import inetsoft.report.StyleSheet;
import inetsoft.report.XSessionManager;
import inetsoft.report.io.Builder;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.UIManager;
import sgalib.SgaUtilPuesto;

public class Report
{
  public Report()
  {
    ReportFrame frame = new ReportFrame();
  }

  /**
   *
   * @param args
   */
/*  public static void main(String[] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

      //Intentem fixar algunes java options necessaries per stylereportpro
      Properties properties = System.getProperties();
      String value = SgaUtilPuesto.getInstance().getProperty("uql.home");
      if (value != null)
        properties.setProperty("uql.home", value);
//      value = SgaUtilPuesto.getInstance().getProperty("query.registry.path");
//      if (value != null)
//        properties.setProperty("query.registry.path", value);
//      value = SgaUtilPuesto.getInstance().getProperty("datasource.registry.path");
//      if (value != null)
//        properties.setProperty("datasource.registry.path", value);

    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    new Report();
  }
  */

   public static void main(String[] args) {
      try {
	 if(args.length == 0) {
	    System.err.println("Usage: java Report template-file");
	    System.exit(1);
	 }
      //Intentem fixar algunes java options necessaries per stylereportpro
      Properties properties = System.getProperties();
      String value = SgaUtilPuesto.getInstance().getProperty("uql.home");
      if (value != null)
        properties.setProperty("uql.home", value);

	 FileInputStream input = new FileInputStream(args[0]);
	 Builder builder = Builder.getBuilder(Builder.TEMPLATE, input);
	 StyleSheet report = (StyleSheet) builder.read(".");

	 XSessionManager mgr = XSessionManager.getSessionManager();
	 mgr.execute(report);

	 PreviewView previewer = Previewer.createPreviewer();
	 previewer.setExitOnClose(true);

	 previewer.pack();
	 previewer.setVisible(true);

	 previewer.print(report);
      } catch(Exception e) {
	 e.printStackTrace();
      }
   }

}