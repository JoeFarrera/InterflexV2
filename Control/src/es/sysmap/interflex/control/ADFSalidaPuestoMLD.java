package es.sysmap.interflex.control;
import es.sysmap.interflex.control.ADFSalidaPuestoInterface;
import es.sysmap.interflex.model.dmc.common.SgaubicacionPlcView;
import es.sysmap.interflex.model.dmc.common.SgaubicacionPlcViewRow;
import es.sysmap.interflex.model.dmc.common.SgavmacpendpuestomldViewRow;
import es.sysmap.interflex.model.dmc.common.SgavubicacionlibreminiloadViewRow;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;

public class ADFSalidaPuestoMLD extends ADFGestor implements ADFSalidaPuestoInterface
{
  private ViewObject macPendPuesto;
  // Michael 12.07.2006 private ViewObject ubicacionMld;
  private SgavmacpendpuestomldViewRow macRow;
  private SgaubicacionPlcView ubicacionPlcView;

  public ADFSalidaPuestoMLD()
  { 
    connectApplicationModule();
    // Michael 12.07.2006 ubicacionMld = am.findViewObject("SgavubicacionlibreminiloadView1");
    macPendPuesto = am.findViewObject("SgavmacpendpuestomldView1");
    ubicacionPlcView = (SgaubicacionPlcView)am.findViewObject ("SgaubicacionPlcView1");
    assert ubicacionPlcView != null;
  }
  
  public SgavmacpendpuestomldViewRow getMacPend()
  {
    am.getTransaction().clearEntityCache(null);
    macPendPuesto.clearCache();
    macPendPuesto.executeQuery();
    macRow = (SgavmacpendpuestomldViewRow)macPendPuesto.first();
    return macRow;
  }

/* Michael 12.07.2006 moved to AppModule  
  public SgavubicacionlibreminiloadViewRow getUbiLibre(String rotacion)
  {
    ubicacionMld.clearCache();
    ubicacionMld.setOrderByClause("abs(ascii('" + rotacion + "') - (ascii(rotacion) + (posicion - 1))) asc, udistancia asc");
    ubicacionMld.executeQuery();
    return (SgavubicacionlibreminiloadViewRow)ubicacionMld.first();
  }
*/
  /**
   * Si hay un mac en un puesto de miniload listo para salir, sacalo
   * Si no, nada
   * Si hay mac, y no se encuentra ubicación, devuelve false
   * @return <code>true</code> si no hay mac, o se ha podido reservar la ubicación del mac en el puesto. <code>false</code> si no ubicaciones libres
   */
  public boolean maybeSacarMacPuesto()
  {
    boolean retVal = true;
    SgavubicacionlibreminiloadViewRow ubiLibreRow;
    // Michael 18.12.2006 TODO - para sacar al entrada almacén SgaubicacionPlcViewRow ubiLibreRow;
    macRow = getMacPend();
    if (macRow != null)
    {
      ubiLibreRow = am.getUbiLibre(macRow.getRotacion());
      // Michael 18.12.2006  Siguiente permite enviar solo al la entrada almacén si fuera necesatrio
      // Michael 11.07.2006 enviar a entrada MLD ubiLibreRow = ubicacionPlcView.getUbicacionEntradaMLD();
      // Michael 11.07.2006 fin
      if (ubiLibreRow != null)
      {
        macRow.reservarMovimientoEntrada(ubiLibreRow.getIdubi(), ubiLibreRow.getPosicion());
        // Michael 18.12.2006 macRow.reservarMovimientoEntrada(ubiLibreRow.getIdubi(), new Number(0));
        LOG.info("Evacuació de contenidor: " + macRow.getIdmac() + " cap al desti: " + ubiLibreRow.getDescripvisual());
        commit();
      }
      else
      {
        // Michael 11.07.2006 No tiene mucho sentido el mensaje si ya no busca ubicación aquí
        LOG.warn("No s'ha trovat cap ubicació lluire del miniload per la cubeta: " + macRow.getIdmac());
        retVal = false;
      }
    }
    return retVal;
  }

}