package es.sysmap.interflex.control;
import es.sysmap.interflex.model.dmc.common.SgavpuestomanipViewRow;
import es.sysmap.interflex.model.dmc.common.SgavsalidasinasignarpuestoViewRow;
import oracle.jbo.ViewObject;

public class ADFGestorDocSalida extends ADFGestor
{
  private ViewObject puestoManip;
  private ViewObject salidaSinAsignar;
  private ViewObject salidaCandidateNoUpdate;
  private ViewObject ldocUnicaLinea;

  
  public ADFGestorDocSalida()
  {
    connectApplicationModule();
    puestoManip = am.findViewObject("SgavpuestomanipView1");
    salidaSinAsignar = am.findViewObject("SgavsalidasinasignarpuestoView1");
    salidaCandidateNoUpdate = am.findViewObject("SgavsalidascandidateNoUpdateView1");
    ldocUnicaLinea = am.findViewObject("SgavldocunicalineaView1");
    
    
  }
  /**
   * Buscar el siguiente documento de salida.
   * @return 
   * @param respetarPicking1 si se debe buscar los que se preparan en el picking 1 o no
   * @param idPuesto
   */
  private SgavsalidasinasignarpuestoViewRow getNextDocSalida(String idPuesto, boolean respetarPicking1)
  {
    salidaSinAsignar.setWhereClause(null);
    if (respetarPicking1)
    {
      if (idPuesto.equals ("1"))
        salidaSinAsignar.setWhereClause("picking1 = 'S'");
      else
        salidaSinAsignar.setWhereClause("picking1 = 'N'");
    }
    salidaSinAsignar.executeQuery();
    salidaSinAsignar.reset();
    return (SgavsalidasinasignarpuestoViewRow)salidaSinAsignar.first();
  }
  
  private SgavsalidasinasignarpuestoViewRow getNextDocSalida(String idPuesto)
  {
    SgavsalidasinasignarpuestoViewRow row = getNextDocSalida(idPuesto, true);
    if (row == null)
      row = getNextDocSalida(idPuesto, false);
    return row;
  }
  
  
  private boolean hasSalidasPendientes(String idPuesto, String idTipalm)
  {
    salidaCandidateNoUpdate.setWhereClauseParam(0, idPuesto);
    salidaCandidateNoUpdate.setWhereClauseParam(1, idTipalm);
    salidaCandidateNoUpdate.executeQuery();
    salidaCandidateNoUpdate.reset();
    return salidaCandidateNoUpdate.hasNext();
    
  }
  
  
  private void quizasAsignarDocumentoPorAlmacen(SgavpuestomanipViewRow row, String idAlmacen)
  {
        
    if (!hasSalidasPendientes(row.getIdpuesto(), idAlmacen))
    {
      // Activar documento en el puesto pero no activado para este tipo de almacén
      if (row.quizasAsignarSalidaAlmacen(idAlmacen))
        ;// Si ha asignado la parte correspondiente al tipo de almacén
      else
      {
        // Asignar siguiente documento al puesto según prioridad (que puede no tener trabajo del miniload)
        SgavsalidasinasignarpuestoViewRow docRow = getNextDocSalida(row.getIdpuesto());
        if (docRow != null)
        {
          // Asignar al puesto para el miniload y para el silo
          boolean miniload = idAlmacen.equals("MLD");
          boolean silo = idAlmacen.equals("SLO");
          docRow.asignarPuesto(row.getIdpuesto(), miniload, silo);
          LOG.info("Document: " + docRow.getIddoc() + " asignat al puesto: " + row.getIdpuesto() + " mld:" + miniload + " slo:" + silo);

        }
      }
    }
  }
  
  
  public void quizasAsignarDocumento()
  {
    am.getTransaction().clearEntityCache(null);
    puestoManip.clearCache();
    puestoManip.executeQuery();
    puestoManip.reset();
    while (puestoManip.hasNext())
    {
      SgavpuestomanipViewRow row = (SgavpuestomanipViewRow)puestoManip.next();
      if (row.isAbiertoPuesto() && row.isAutoselordsal())
      {
        int numDocs = row.getNumdocsPermitido();
        if (numDocs > 0)
        {
          // Simplemente asignar siguiente documento, si es que no tiene la cuota asignada
          SgavsalidasinasignarpuestoViewRow docRow = getNextDocSalida(row.getIdpuesto());

          if (docRow != null)
          {
            // Asignar al puesto para el miniload y para el silo
            docRow.asignarPuesto(row.getIdpuesto(), true, true);
            LOG.info("Document: " + docRow.getIddoc() + " asignat al puesto: " + row.getIdpuesto() + " mld:" + true + " slo:" + true);
          }
          
        }
        else
        {
          // El puesto tiene su cupo de documentos. Pero si se ha acabado para uno o el otro, hay que activar otro
          quizasAsignarDocumentoPorAlmacen(row, "MLD");
          quizasAsignarDocumentoPorAlmacen(row, "SLO");
        }
      }
    }
  }
  
  
  public static void main(String[] args)
  {
    ADFGestorDocSalida docSalida = new ADFGestorDocSalida();
    docSalida.quizasAsignarDocumento();
    docSalida.commit();
    
  }
  
}