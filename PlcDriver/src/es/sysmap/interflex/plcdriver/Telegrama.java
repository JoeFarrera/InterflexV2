package es.sysmap.interflex.plcdriver;
import es.sysmap.interflex.gestortelegrama.ByteHelper;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.xml.XMLParser;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.Calendar;

import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLNode;

import org.apache.log4j.Logger;

import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Telegrama para el interface Siemens - SGA
 *
 */
public abstract class Telegrama 
{
  private Logger LOG = Logger.getLogger(getClass());

  public static int MAX_DATOS = 200;  // Michael 17.03.2005 Era 48
  public static int MAX_HEADER = 20;
  
  int idTelegrama;
  int numBytesDatos;
  byte segundo;
  byte hora;
  byte minuto;
  byte dia;
  byte mes;
  byte any;
  byte reserva1;
  byte reserva2;
  byte reserva3;
  byte [] datos;
  
  int lenDatos;
 
  public Telegrama(int idTelegrama)
  {
    this.idTelegrama = idTelegrama;
    datos = new byte[MAX_DATOS];
  }
  
  

  
  /**
   * Construir array de bytes para la clase
   * @return array de bytes representando la clase
   * @deprecated
   */
  public byte [] getBytes()
  {
    byte [] bytes = new byte [MAX_HEADER];  // Tamaño de la cabecera
    
    for (int i = 0; i < MAX_HEADER; i++)
      bytes [i] = 0;
      
    int i = 0;
    int j = 0;
    
    byte [] tempBytes;
    
    bytes [i++] = 'T';  // 0
    
    byte [] tipoTel = getTipoTel().getBytes(); // 1
    for (j = 0; j < tipoTel.length; j++)
      bytes [i++] = tipoTel [j];
      
    tempBytes = ByteHelper.int2bytes(MAX_HEADER + getLenDatos()); // 4
    for (j = 0; j < 2; j++)
      bytes [i++] = tempBytes [j];
    
    bytes [i++] = 0;  // reserva  6 + 1
    bytes [i++] = 0;  // reserva  7 + 1
    
    tempBytes = getTime();  // 8 + 6
    System.arraycopy(tempBytes, 0, bytes, i, tempBytes.length);
    i = i + tempBytes.length;

    bytes [i++] = 0;  // reserva 14 + 1
    bytes [i++] = 0;  // reserva 15 + 1
    bytes [i++] = 0;  // reserva 16 + 1
    
    return bytes;
  }
  
  abstract int getLenDatos();
  abstract String getTipoTel();
  abstract String getAckTel();



 
  private byte [] getTime ()
  {
    byte [] time = new byte [6];
    Calendar actual = Calendar.getInstance();
    time [0] = (byte)actual.get(Calendar.HOUR_OF_DAY);
    time [1] = (byte)actual.get(Calendar.MINUTE);
    time [2] = (byte)actual.get(Calendar.SECOND);
    time [3] = (byte)actual.get(Calendar.DAY_OF_MONTH);
    time [4] = (byte)actual.get(Calendar.MONTH);
    time [5] = (byte)actual.get(Calendar.YEAR);
    
    return time;
    
 }
 
  /**
   * 
   * @return el número de bytes (tamaño) almacenada en la posición 5 y 6 del array
   * @param bytes el array de bytes del telegrama
   */
 public static int getLenTeleRecibido (byte [] bytes)
 {
  assert bytes.length > 7 : bytes.length;
  
  return (ByteHelper.bytes2int(ByteHelper.getSubBytes(bytes, 5, 2)));
   
 }
 
  /**
   * Convertir un array de bytes en su representación en String
   * Si el byte es equivalente a un dígito o una letra, imprime esto
   * Si no, imprime su valor decimal
   * @return String del array de bytes, separados por espacio
   * @param bytes array de bytes a convertir
   */
 public static String toString(byte [] byteString)
 {
    String charString = new String("[");
    
    for (int i = 0; i < byteString.length; i++)
    {
      char car = (char)(0xFF & byteString[i]);
      if (Character.isLetterOrDigit(car))
      {
        charString = charString.concat(car + " ");
      }
      else
        charString = charString.concat((int)car + " ");
    }
    // Quitar último espacio
    charString = charString.substring(0, charString.length() - 1).concat("]");
    
    return charString;
 }
 
  protected Element createXMLAttribute(XMLDocument doc, String nombre, String valor, int index, int len, String tipo)
  {
    Element el = doc.createElement("valor");
    el.setAttribute("id", nombre);
    el.setAttribute("index", Integer.toString(index));
    el.setAttribute("len", Integer.toString(len));
    el.setAttribute("tipo", tipo);
    Text tipoText = doc.createTextNode(valor);
    el.appendChild(tipoText);
    return el;
  }
 
  public XMLDocument writeXML()
  {
    XMLDocument xmldoc = new XMLDocument();
    Element root = xmldoc.createElement("Telegrama");

    // Id del telegrama
    root.setAttribute("idTelegrama", Integer.toString(idTelegrama));
    root.setAttribute("lenTelegrama", Integer.toString(getLenDatos() + MAX_HEADER));
    
    
    // Tipo telegrama
    root.appendChild(createXMLAttribute(xmldoc, "tipoTel", new String(getTipoTel()), 1, 4, "str"));
    // Tamaño del telegrama
    root.appendChild(createXMLAttribute(xmldoc, "lenDatos", Integer.toString(getLenDatos()), 5, 2, "int"));

    xmldoc.appendChild(root);
    
    return (xmldoc);
  }
  


  public static void main(String[] args)
  {
    int num, res;
    long counter;
    byte[] b;
    
    Movi mov = new Movi(1234, new Posicion (11, (byte)12, (byte)13, (byte)1, (byte)2), 
      new Posicion (55, (byte)1, (byte)2, (byte)1, (byte)3), 
      (byte)1, (byte)1, (byte)123, (byte)456, (byte)1, (byte)1, "1000000345");
    
    XMLNode node = mov.writeXML();

    
    try
    {
     StringWriter myStringWriter = new StringWriter();
    
     node.print(new PrintWriter(myStringWriter));
     System.out.println(myStringWriter.toString());
     node.print(System.out);
     
     int lenTelegrama = Integer.parseInt(XMLParser.getAttributeValue((XMLDocument)node, "Telegrama", "lenTelegrama"));

     byte [] bytes = new byte [lenTelegrama];

     bytes = es.sysmap.interflex.gestortelegrama.GestorDatos.getBytes(myStringWriter.toString(), bytes);
     
     
    } catch (Exception ex)
    {
      ex.printStackTrace();
    } catch (Throwable t)
    {
      t.printStackTrace();
    }
    
    
   

/*
    // Probar gestión de un tamaño no esperado
    byte[] badLen = new byte [3];
    badLen [0] = 3;
    badLen [1] = 4;
    badLen [2] = 5;
    res = bytes2int (badLen);
    System.exit(0);
    
    
    // Probar conversiones
    counter = 0;
    for (int i = 0; i <= Integer.MAX_VALUE; ++i){
      num = i;
      b = int4bytes(i);
      if ((res = bytes2int(b)) != num){
        System.out.println(counter + " Weird! : " + num + " -> " + res);
        System.out.println(b[0] + " " + b[1] + " " + b[2] + " " + b[3]);
        System.exit(1);
      }
      else{
        System.out.println(counter + " OK : " + num + " -> " + res);
      }
      ++counter;
    }
    counter = -1;
    for (int i = -1; i >= Integer.MIN_VALUE; --i){
      num = i;
      b = int4bytes(i);
      if ((res = bytes2int(b)) != num){
        System.out.println(counter + " Weird! : " + num + " -> " + res);
        System.exit(1);
      }
      else{
        System.out.println(counter + " OK : " + num + " -> " + res);
      }
      --counter;
    }
    */
  }
  
}