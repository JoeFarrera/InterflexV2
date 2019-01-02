package es.sysmap.interflex.control;
import es.sysmap.interflex.model.dmc.common.SgavsalidascandidatemacpuestoViewRow;
import oracle.jbo.SQLStmtException;
import oracle.jbo.ViewObject;
import sgalib.MapOraError;

public class ADFReservaPuesto extends ADFGestor 
{

  private ViewObject salidaCandidate;
  
  public ADFReservaPuesto()
  {
  }
  
  public void init()
  {
    connectApplicationModule();
    salidaCandidate = am.findViewObject("SgavsalidascandidatemacpuestoView1");
  }
  
  public boolean quizasReservar()
  {
    boolean reservado = false;
    SgavsalidascandidatemacpuestoViewRow row = null;
    try
    {
    // Michael 05.05.2005 por problema de repetir la reserva ???
    am.getTransaction().clearEntityCache(null);
    // Michael 11.05.2005
    am.clearVOCaches(null, true);
    // salidaCandidate.clearCache();
    salidaCandidate.executeQuery();
    salidaCandidate.reset();
    row = (SgavsalidascandidatemacpuestoViewRow)salidaCandidate.first();
    if (row != null)
    {
      LOG.info("ReservaPuesto: " + row.toString());
      if (row.reservarSalida())
      {
      commit();
      reservado = true;
      }
      else
        rollback();
    }
    }    
    catch (SQLStmtException esqlstmt)
    {
      if (MapOraError.isOra54(esqlstmt))
      {
        LOG.debug(getClass() + " - Recurs adquerit per un altre reservant en el lloc de treball");
        rollback();
      }
      else
      {
        LOG.error ("Exception in reserva trabajo para: " + row == null ? " ?? " : row.toString(), esqlstmt);
        throw esqlstmt;
      }
    }
 

    
    return reservado;
  }
  
  public static void main(String[] args)
  {
    ADFReservaPuesto r = new ADFReservaPuesto();
    r.init();
    System.out.println("Buscando reservas");
    while (r.quizasReservar())
      System.out.println("Reservado algo");
    System.out.println("Finished getting reservas");
  }
  
}