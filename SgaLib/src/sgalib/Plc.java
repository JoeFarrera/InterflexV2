package sgalib;

public class Plc 
{
  /**
   * Utilidades para manipulaci�n de datos de los PLCs
   */
  public Plc()
  {
  }
  
  /**
   * ver si un bit determinado de una palabra est� activo o no
   * @param value a analizar
   * @param bit dentro de la palabra (0 es la posici�n m�s baja)
   * @return true si el bit est� a 1
   */
  public static boolean isSetBit (int value, int bit)
  {
    return ((value >> bit) & 0x1) > 0;
  }
  
  /**
   * comparar el mismo bit de dos palabras.
   * @param newValue
   * @param oldValue
   * @param bit
   * @return true si el bit comparado es diferente
   */
  public static boolean isDifferentBit (int newValue, int oldValue, int bit)
  {
    return (isSetBit(oldValue, bit) != isSetBit(newValue, bit));
  }

}