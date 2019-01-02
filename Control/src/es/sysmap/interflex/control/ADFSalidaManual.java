package es.sysmap.interflex.control;
import es.sysmap.interflex.model.dmc.common.SgavsalidascandidatemanualViewRow;
import oracle.jbo.SQLStmtException;
import oracle.jbo.ViewObject;
import sgalib.MapOraError;

public class ADFSalidaManual extends ADFGestor 
{
  private ViewObject salidaCandidateManual;

  public ADFSalidaManual()
  {
  }

  public void init()
  {
    connectApplicationModule();
    salidaCandidateManual = am.findViewObject("SgavsalidascandidatemanualView1");
  }


  public boolean quizasReservar()
  {
    boolean reservado = false;
    SgavsalidascandidatemanualViewRow row = null;
    try
    {
    salidaCandidateManual.clearCache();
    salidaCandidateManual.executeQuery();
    salidaCandidateManual.reset();
    // Michael 05.05.2005 por problema de repetir la reserva ???
    am.getTransaction().clearEntityCache(null);
    row = (SgavsalidascandidatemanualViewRow)salidaCandidateManual.first();
    if (row != null)
    {
      row.reservarSalida();
      commit();
      reservado = true;
    }
    }    
    catch (SQLStmtException esqlstmt)
    {
      if (MapOraError.isOra54(esqlstmt))
      {
        LOG.debug(getClass() + " - Recurs adquerit per un altre reservant una sortida manual");
        rollback();
      }
      else
      {
        LOG.error ("Exception en sortida manual: " + row == null ? " ?? " : row.toString(), esqlstmt);
        throw esqlstmt;
      }
    }
 

    
    return reservado;
  }

}