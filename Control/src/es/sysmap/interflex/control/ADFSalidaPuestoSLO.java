package es.sysmap.interflex.control;
import es.sysmap.interflex.control.ADFSalidaPuestoInterface;
import es.sysmap.interflex.model.dmc.SgavmacpendpuestosloViewRowImpl;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaubicacionPlcView;
import es.sysmap.interflex.model.dmc.common.SgavestadoentradaslomacViewRow;
import es.sysmap.interflex.model.dmc.common.SgavmacpendpuestosloViewRow;
import es.sysmap.interflex.model.dmc.common.SgavordtranpendtraslosloViewRow;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;

public class ADFSalidaPuestoSLO extends ADFGestor implements ADFSalidaPuestoInterface
{
  private ViewObject macPendPuesto;
  private ViewObject pasillosPosibles;
  private SgaubicacionPlcView ubicacionPlcView;
  private SgavestadoentradaslomacViewRow pasRow;
  private SgavmacpendpuestosloViewRow macRow;
  


  public ADFSalidaPuestoSLO()
  {
    connectApplicationModule();
    pasillosPosibles = am.findViewObject("SgavestadoentradaslomacView1");
    assert pasillosPosibles != null;
    macPendPuesto = am.findViewObject("SgavmacpendpuestosloView1");
    assert macPendPuesto != null;
    ubicacionPlcView = (SgaubicacionPlcView)am.findViewObject ("SgaubicacionPlcView1");
    assert ubicacionPlcView != null;
  }
  

  /*
   * Michael 31.05.2005 Buscar todos los rows y no sólo 1
   */
  public boolean getMacPend()
  {
    am.getTransaction().clearEntityCache(null);
    am.clearVOCaches(null, true);
    macPendPuesto.setRangeSize(-1);
    macPendPuesto.executeQuery();
    macPendPuesto.reset();
    return macPendPuesto.hasNext();
  }
  
  /**
   * Buscar el pasillo destino del MAC
   * Si el mac está en la 45, debe ir a la 44
   * Si no, busca una entrada pasillo con espacio, traslo... etc.
   * @return 
   * @param macRow
   */


  public boolean getDestinoMac(SgavmacpendpuestosloViewRow macRow)
  {
    boolean gotPasillo = false;
    if (macRow.is45())
    {
      String ubi44 = ubicacionPlcView.getUbicacion44();
      macRow.reservarMovimientoEntrada(ubi44, null); // La ubicación de entrada no tiene posición
      LOG.info("Evacuació de contenidor: " + macRow.getIdmac() + " cap a la taula 44 de la extra");
      return true;
    }
    if (!macRow.is6())
    {
      // El mac está en el puesto, lo enviamos al 6 sólo
      macRow.reservarMovimientoEntrada(ubicacionPlcView.getUbicacion6(), null); // La ubicación de entrada no tiene posición
      LOG.info("Evacuació de contenidor: " + macRow.getIdmac() + " cap al gálibo");
      return true;
    }


    // El mac esta en el gálibo, le enviamos al pasillo de entrada que convenga
    // La orden de transporte debe existir

    pasillosPosibles.clearCache();
    pasillosPosibles.setWhereClauseParam(0, macRow.getIdmac());
    pasillosPosibles.executeQuery();
    pasillosPosibles.reset();
    // Los pasillos vienen ordenadas de min existencias para este mac
    while (pasillosPosibles.hasNext() && !gotPasillo)
    {
      pasRow = (SgavestadoentradaslomacViewRow)pasillosPosibles.next();
      if (pasRow.hasEspacioPulmon() 
          && pasRow.hasHuecosLibres() 
          && pasRow.isWorkingPasillo() 
          && pasRow.isWorkingTraslo())
          {
            // Michael 07.05.2005 Actualizar el mac a la ubicación definitiva pero sin traslo para que quede reservada
            // macRow.actualizarMovimientoEntrada(pasRow.getIdubientrada()); // La ubicación de entrada no tiene posición
            // gotPasillo = true;
            gotPasillo = pasRow.setUbicacionDestinoMac(new Number(0));
            // Michael 07.05.2005
            if (gotPasillo)
              LOG.info("Evacuació de contenidor: " + macRow.getIdmac() + " cap al desti: " + pasRow.getDescripvisual());
          }
    }
    return gotPasillo;
    
  }


  /**
   * Si hay un mac en un puesto de miniload listo para salir, sacalo
   * Si no, nada
   * Si hay mac, y no se encuentra ubicación, devuelve false 
   * Michael 31.05.2005 Buscar todos los posibles y no sólo el primero
   * @return <code>true</code> si no hay mac, o se ha podido reservar la ubicación del mac en el puesto. <code>false</code> si no ubicaciones libres
   */
  public boolean maybeSacarMacPuesto()
  {
    boolean retVal = false;
    if (getMacPend())
    {
      // Recuper todos los rows porque dentro puede haber commit/rollback
      Row [] rows = macPendPuesto.getAllRowsInRange();
      for (int i = 0; i < rows.length; i++)
      {
        macRow = (SgavmacpendpuestosloViewRow)rows[i];
        if (getDestinoMac(macRow))
        {
          commit();
          retVal = true;
        }
        else
        {
          LOG.warn("No s'ha trovat cap ubicació lluire del maxi load pel contenidor: " + macRow.getIdmac());
          rollback(); // Michael 31.05.2005
       }
      }
      
    }
    
    return retVal;
  }
  
}