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
  public static void imprimirEtiqueta(AppModule appModule, String iddoc, String idlin)
  {
    try
    {
      RowIterator rowset = appModule.llistaBultosPendentsImprimir(iddoc, idlin);
      rowset.reset();
      while (rowset.hasNext())
      {
        SgabultoViewRow bulto = (SgabultoViewRow)rowset.next();
        String pickingPort = SgaUtilPuesto.getInstance().getProperty("PickingPort");
        if (pickingPort != null)
        {
          EtiquetaPicking etiqueta = bulto.getDadesEtiqueta();
          if (etiqueta != null)
            etiqueta.printEtiqueta(pickingPort);
        }
        // Actualitzem l'estat d'impressi� del bulto
        bulto.setImprimir("I");
      }
      appModule.getTransaction().commit();
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
}