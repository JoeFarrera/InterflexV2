package sgalib;

/**
 * constantes pertenentes al layout
 */
public class Layout 
{
 /**
 * Identificadores de scanners
 */
  public static final int SCANNER_1a = 1;
  public static final int SCANNER_2a = 2;
  /**
   * el valor mín de tobogan alcanzable desde el scanner 2
   */
  public static final int MIN_TOBOGAN_SCANNER_2a = 6;
  public static final int MAX_BALIZAS_2a  = 17;
  public static final int MAX_BALIZAS_1a  = 5;  // Número de balizas en 1a clasificación
  public static final int FIRST_ITEM_BALIZA = 5;  // Primera palabra de balizas
  public static final int FIRST_ITEM_BALIZA_CONTROL = 30; // Para controlar balizas
  public static final int MAX_BALIZAS = MAX_BALIZAS_2a + MAX_BALIZAS_1a;
  // What about the 2 balizas for injection

  public Layout()
  {
  }
}