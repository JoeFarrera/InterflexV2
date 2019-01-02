package es.sysmap.interflex.plcdriver;
import es.sysmap.interflex.gestortelegrama.ByteHelper;

public class Posicion 
{
  private int posicionPlc;
  private byte columna;
  private byte nivel;
  private byte lado;
  /**
   * Posición dentro del hueco
   */
  private byte posUbicacion;
  
  public Posicion(int posicionPlc, byte columna, byte nivel, byte lado, byte posUbicacion)
  {
    this.posicionPlc = posicionPlc;
    this.columna = columna;
    this.nivel = nivel;
    this.lado = lado;
    this.posUbicacion = posUbicacion;
  }
  
  public Posicion()
  {
    
  }


  /**
   * Convertir la posición en su representación en bytes para telegramas
   * @return la representación en bytes de la posición
   */
  public byte [] toByte ()
  {
    byte bytes [] = new byte [6];
    System.arraycopy(ByteHelper.int2bytes(posicionPlc), 0, bytes, 0, 2);
    bytes [2] = lado;
    bytes [3] = columna;  // Profundidad
    bytes [4] = nivel;  // altura
    bytes [5] = posUbicacion;
    return bytes;
  }

  /**
   * Leer valores de la posición de un array de bytes
   * @param bytes array con los datos en la primera posición
   */
  public void read(byte [] bytes)
  {
    posicionPlc = ByteHelper.bytes2int(ByteHelper.getSubBytes(bytes, 0, 2));
    lado = bytes [2];
    columna = bytes [3];
    nivel = bytes [4];
    posUbicacion = bytes [5];
    
  }

  public int getPosicionPlc()
  {
    return posicionPlc;
  }
  
  
  public String toString ()
  {
    return "PosPlc: " + posicionPlc + " columna: " + columna + " nivel: " + nivel + " pos: " + posUbicacion;
  }


  public void setPosicionPlc(int posicionPlc)
  {
    this.posicionPlc = posicionPlc;
  }


  public void setColumna(byte columna)
  {
    this.columna = columna;
  }


  public byte getColumna()
  {
    return columna;
  }


  public void setNivel(byte nivel)
  {
    this.nivel = nivel;
  }


  public byte getNivel()
  {
    return nivel;
  }


  public void setLado(byte lado)
  {
    this.lado = lado;
  }


  public byte getLado()
  {
    return lado;
  }


  public void setPosUbicacion(byte posUbicacion)
  {
    this.posUbicacion = posUbicacion;
  }


  public byte getPosUbicacion()
  {
    return posUbicacion;
  }
}