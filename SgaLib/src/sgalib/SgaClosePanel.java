package sgalib;
/**
 * Com que els panels que activem a traves de la clase RunPanel, no realitzen
 * cap acció concreta quan es finalitza el runPanel al que pertanyen, els que
 * implementin aquesta interfase, podran realitzar una acció concreta quan es
 * tanquin
 */
public interface SgaClosePanel 
{
  public void beforeClosePanel();
}