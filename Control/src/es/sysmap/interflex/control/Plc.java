package es.sysmap.interflex.control;
/**
 * Constantes para la manipulación de elementos
 */
public class Plc 
{
  public static final int LIBRE = 0;
  public static final int OCUPADO = 1;
  public static final int AVERIADO = 2;
  public static final int DESCONOCIDO = 3;

  private Plc()
  {
  }
  
    /**
   * the string representation of an element state
   * @param <code>state<\code>
   * @returns string representation
   */
   public static String getStringElementState (int state)
   {
     switch (state)
     {
      case Plc.LIBRE:
        return "Libre";
      case Plc.OCUPADO:
        return "Ocupado";
      case Plc.AVERIADO:
        return "Averiado";
      default:
        return "Desconocido";
     }
   }
   
     /**
   * the string representation of a pasillo state
   * @param <code>state<\code>
   * @returns string representation
   */
   public static String getStringPasilloState (int state)
   {
     switch (state)
     {
      case 0:
        return "F. Servicio";
      case 1:
        return "En Servicio";
     default:
        return "Desconocido";
     }
   }


}