package es.sysmap.interflex.gestortelegrama;

/**
 * Ayuda en la manipulación de bytes
 */
public class ByteHelper 
{
  public ByteHelper()
  {
  }
  
    /**
     * Combine two byte arrays
     * @param l first byte array
     * @param r second byte array
     * @return byte[] combined byte array
     */
  public static byte[] concatenate(byte[] l, byte[] r) {
        byte[] b = new byte[l.length + r.length];
        System.arraycopy(l, 0, b, 0, l.length);
        System.arraycopy(r, 0, b, l.length, r.length);
        return b;
    }

  /**
   * Convertir un entero a su representación en 2 bytes
   * Si el entero no cabe, será truncado
   * @return array de byte [2]
   * @param value
   */
  public static byte [] int2bytes (int value)
  {
    byte [] bytes = new byte [2];
    bytes [0] = (byte)((value & 0xFF00) >>> 8);
    bytes [1] = (byte)(value & 0xFF);
    return bytes;
  }
  
    /**
   * Convertir un entero a su representación en 4 bytes
   * @return array de byte
   * @param value a convertir
   */
  public static byte [] int4bytes (int value)
  {
    byte [] bytes = new byte [4];
    bytes [0] = (byte)((value & 0xFF000000) >>> 24);
    bytes [1] = (byte)((value & 0x00FF0000) >>> 16);
    bytes [2] = (byte)((value & 0xFF00) >>> 8);
    bytes [3] = (byte)(value & 0xFF);
    return bytes;
    
  }
  
    /**
   * convertir 2 o 4 bytes a su valor entero
   * Preconditions: El array de bytes tiene longitud 2 o 4
   * @return entero valor del array de bytes
   * @param bytes
   */
  public static int bytes2int (byte [] bytes)
  {
    int len = bytes.length;
 
    assert (len == 2 || len == 4) : len;
  
    
    int a0, a1, a2, a3, ret;

    a3 = 0;
    a2 = 0;
    
    a0 = bytes[0]; a1 = bytes[1]; 
    if (len > 2)
    {
      a2 = bytes[2]; 
      a3 = bytes[3];
      // we have to 'positivise' intermediate negative bytes to deceive
      // Java implicit conversion behavior
      if (a3 < 0)
      {
        a3 = a3 << 24;
        a3 = a3 >>> 24;
      }
      if (a2 < 0){
        a2 = a2 << 24;
        a2 = a2 >>> 24;
      }
    }

    if (a1 < 0){
      a1 = a1 << 24;
      a1 = a1 >>> 24;
    }
    if (len > 2)
      ret = (a0 << 24 | a1 << 16 | a2 << 8 | a3);
    else
      ret =  a0 << 8 | a1;
    return ret;    
   
  }
 
 
   /**
   * 
   * @return array de bytes solicitado del src
   * @param len número de bytes a devolver
   * @param srcPos index (0 based) del primer byte a devolver
   * @param src array original
   */
  public static byte [] getSubBytes (byte [] src, int srcPos, int len)
  {
    byte [] bytes = new byte [len];
    System.arraycopy(src, srcPos, bytes, 0, len);
    return bytes;
  }

  public static String getPrintableChar(char byteVal)
  {
    String str;
    
    if (Character.isLetterOrDigit(byteVal))
    {
      str = new Character((char)byteVal).toString();
    }
    else
      str = new Integer(byteVal).toString();
    
      return (str);
  }
 

}