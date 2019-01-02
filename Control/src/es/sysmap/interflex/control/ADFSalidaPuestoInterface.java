package es.sysmap.interflex.control;

public interface ADFSalidaPuestoInterface 
{
  public boolean maybeSacarMacPuesto();
  public void commit();
  public void rollback();
}