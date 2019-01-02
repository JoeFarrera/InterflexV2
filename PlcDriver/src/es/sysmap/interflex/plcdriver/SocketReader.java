package es.sysmap.interflex.plcdriver;
import java.io.DataInputStream;
import java.io.IOException;
import org.apache.log4j.Logger;

public class SocketReader 
{
  private DataInputStream is;
  private boolean done;
  
  public SocketReader(DataInputStream is)
  {
    done = false;
    this.is = is;
    
  }
  
  public void setDone () { done = true;}
  
  /**
   * Leer del dataInputStream.
   * Mientras no hay nada, irá saliendo por IOException según el timeout que tenía definido
   * Si ha llegado algo, lo va almacenando hasta el siguiente timeout
   * Si se ha llegado al final del stream, el read devuelve -1 y devuelve <code>null</code>
   * <p><em>NOTE: Si el socket no tiene timeout especificado, no sale hasta recibir algo</em></p>
   * @return 
   * @param maxBytes
   */
  public byte [] readBlock(int maxBytes) throws IOException
  {
    byte [] in = new byte [maxBytes];
    int i;
    int byteRead;
    while (!done)
     {
      for (i = 0; i < maxBytes && !done; )
      {
          byteRead = is.read();
          if (byteRead == -1)
          {
            done = true;
            break;
          }
          else
          {
            in[i++] = (byte)byteRead; 
          }
          // Intentar dejar acumular el mensaje
          try 
          {
            if (is.available() < 10)
              Thread.sleep(10);
          } catch (Exception ex) 
          {
           ;  // Nada
          }
          // Si después de esperar, no hay byte disponible, es que ya no hay más
          if (is.available() == 0)
            break;  
      }
      if (i > 0)
      {
        byte [] fin = new byte [i];
        System.arraycopy(in, 0, fin, 0, i);
        return (fin);
      }
     }
     return (null);
  }
}