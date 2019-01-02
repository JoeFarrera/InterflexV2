package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow;

public interface PuestoListener 
{
  public void setMacEnPuesto(SgamacEnPuestoViewRow idmac);
  public void setSalidasMaxiObertes(int nSalides);
}