package es.sysmap.interflex.view;

import es.sysmap.interflex.etiquetes.EtiquetaPicking;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgabultoViewRow;
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
import oracle.jbo.RowIterator;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import org.apache.log4j.Logger;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class Etiqueta 
{
  public Etiqueta()
  {
  }
  
  /**
   * Torna una llista amb les etiquetes a imprimir en un moment donat per un document
   * @param idlin
   * @param iddoc
   * @param appModule
   */
  public static void imprimirEtiqueta(AppModule appModule, String iddoc, String idlin) throws Exception
  {
     
      RowIterator rowset = appModule.llistaBultosPendentsImprimir(iddoc, idlin);
      rowset.reset();
      while (rowset.hasNext())
      {
        SgabultoViewRow bulto = (SgabultoViewRow)rowset.next();
        String pickingPort = SgaUtilPuesto.getInstance().getProperty("PickingPort");
        String printerModel = SgaUtilPuesto.getInstance().getProperty("PrinterModel");
        if (pickingPort != null)
        {
          EtiquetaPicking etiqueta = bulto.getDadesEtiqueta();
          if (etiqueta != null)
            etiqueta.printEtiqueta(pickingPort, printerModel);
        }
        else
          // Michael: See what happens if Exception thrown 20.10.2022
          throw new Exception("No hay puerto de impresión definido para el puesto");
          
          
        // Actualitzem l'estat d'impressiï¿½ del bulto
        bulto.setImprimir("I");
      }
      appModule.getTransaction().commit();

  }
}