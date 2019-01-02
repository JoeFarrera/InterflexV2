package es.sysmap.interflex.gestortelegrama;

import es.sysmap.interflex.gestortelegrama.MapMonitor;
import es.sysmap.interflex.plcdriver.Movi;
import es.sysmap.interflex.plcdriver.PlcDriver;
import es.sysmap.interflex.plcdriver.Posicion;
import es.sysmap.interflex.plcdriver.Telegrama;
import es.sysmap.xml.XMLHelper;
import es.sysmap.xml.XMLParser;
import es.sysmap.xml.XMLTelegrama;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLNode;
import oracle.xml.parser.v2.XMLParseException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import sgalib.MapObservable;
import sgalib.SgaUtilPuesto;


/**
 *Formatear y enviar telegramas al PLC.
 *Los telegramas tienen formato XML según DTD (TODO)
 *El gestor convierte cada telegrama en su representación en bytes y lo envía al PLC
 *
 *Identifica y formatea los telegramas entrantes, enviandolos a los listeners
 */
public class GestorDatos extends MapObservable implements Observer {
  
  private Logger LOG = Logger.getLogger(getClass());
  
  private static GestorDatos _instance = null;
 
  PlcDriver driver;
  private static final int MAX_LEN_TELEGRAMA = Telegrama.MAX_HEADER + Telegrama.MAX_DATOS;
	private int estado;
  private boolean pruebas;
  
  /**
   * Array de bytes que almacena un telegrama entrante
   */
  
  private byte [] bytes = new byte [MAX_LEN_TELEGRAMA];
  
  /**
   * El buffer que almacena los mensajes entrantes
   */
  private byte [] receiveStr;
  
  /**
   * El puntero al tamaño actual del buffer de entrada
   */
  private int lenReceived;  
 
  public GestorDatos()
  {
    // Instanciar la conexión con el PLC
    SgaUtilPuesto util = SgaUtilPuesto.getInstance();
    String servidorPlc = util.getProperty("PlcServidor", PlcDriver.DEFAULT_HOST);
    String sPort = util.getProperty("PlcPortServidor", String.valueOf(PlcDriver.DEFAULT_PORT));
    int port = Integer.parseInt(sPort);
    
    pruebas = SgaUtilPuesto.isTesting();
    if (!pruebas)
    {
      driver = new PlcDriver(servidorPlc, port, this);
    }
    lenReceived = 0;
    _instance = this;
  }
  
  
  public static GestorDatos getInstance()
  {
    return _instance;
  }
 
  
  /**
   * Para cada nodo de tipo elemento, poner el valor que se extrae de getValorAttribute
   * @param nodes
   */
  private void setNodeListValues(NodeList nodes)
  {
    for (int i = 0; i < nodes.getLength(); i++)
    {
      Node node = nodes.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE)
      {
        String name = node.getNodeName();
        // Actualizar el valor
        node.getFirstChild().setNodeValue(getValorAttribute(node));
        NodeList nens = node.getChildNodes();
        if (nens.getLength() > 0)
          setNodeListValues(nens);
      }
    }
  }
  
  /**
   * Para la estructura de documento del telegrama, recoge los valores del array de bytes
   * bytes ==>> xml
   * Los datos se almacenan en el nodo <em>Detalles</em>
   * @return documento inicializado con la estructura del telegrama
   * @param xmldoc el documento XML que corresponde con el telegrama
   * El telegrama es contenido en el array <code>bytes</code>
   * @see #bytes
   * 
   */
  private XMLDocument parseTelegrama (XMLDocument xmldoc)
  {
  
   try 
    {
     Node nodeDetalles = xmldoc.selectSingleNode("Telegrama/Detalles");
     setNodeListValues(nodeDetalles.getChildNodes());    
    } catch (Exception ex) 
    {
      LOG.error("-",ex);
      assert false;
    } 

    return xmldoc;

   }
  
  

  private boolean validateCurrentReceiveStr()
  {
    boolean retVal = true;
    
    if (lenReceived == 0 || receiveStr [0] == 'T')
      return (true);
    else
    {
        LOG.error("Recibido datos no esperados en telegrama. Desechando " + lenReceived + " caracteres");
        lenReceived = 0;
        return (false);
    }
  }

  private void addIncomingBytes (byte [] inBytes)
  {
    if (receiveStr != null) 
    {
      if ((inBytes.length + lenReceived) > receiveStr.length)
      {
        // Hay que hacer el array más grande
        byte [] tempBytes = new byte [inBytes.length + (lenReceived - receiveStr.length)];
        receiveStr = ByteHelper.concatenate(receiveStr, tempBytes);
      }
    }
    else
      receiveStr = new byte [MAX_LEN_TELEGRAMA * 2];
    System.arraycopy(inBytes, 0, receiveStr, lenReceived, inBytes.length);
    lenReceived = lenReceived + inBytes.length;
  }
  
  private void removeTelegrama (int len)
  {
    lenReceived = lenReceived - len;
    if (lenReceived > 0)
    {
      receiveStr = ByteHelper.getSubBytes(receiveStr, len, lenReceived);    
    }
    
    

    
  }
    

  /**
   * Recepción e interpretación de datos del PLC
   * Intentar formar un telegrama de lo que entra.
   * Una vez recibido suficiente para ver el tipo del telegrama, recupera el patron del telegrama
   * Intenta recibir hasta el tamaño del telegrama
   * Informar a los observadores del telegrama recibido
   * @param arg
   * @param o
   */
	public synchronized void update(Observable o, Object arg)
  {
     byte [] inBytes = (byte [])arg;
     if (inBytes.length >255)  // Michael 05.05.2005 was 220
      LOG.warn("Rebut: " + inBytes.length + " del PLC");
     addIncomingBytes (inBytes);
     LOG.trace("rebut " + lenReceived + " caracters");
     if (validateCurrentReceiveStr())
     {
       while (lenReceived > 7)  // Se ha recibido suficiente para ver que tamaño tiene
       {
       String tipoTel = new String(ByteHelper.getSubBytes(receiveStr, 1, 4));
       XMLDocument xmldoc = XMLTelegrama.parseXML(tipoTel);
       if (xmldoc != null)
       {
         int lenTelegrama = XMLTelegrama.getLenTelegrama(xmldoc);
         if (lenReceived >= lenTelegrama)
         {
          bytes = ByteHelper.getSubBytes(receiveStr, 0, lenTelegrama);
          removeTelegrama(lenTelegrama);
          validateCurrentReceiveStr();
          parseTelegrama(xmldoc);
          LOG.debug("rebut: " + XMLHelper.toString(xmldoc));
          notifyObservers(xmldoc);
       }
       else
         // Else continua hasta recibirlo todo TODO Timeout ???
         break;
       }
       }
     }
     else
     {
        LOG.error("Recibido telegrama desconocido");
     }
   }
   
   
  
   
	/**
	 *Enviar un telegrama al PlcDriver
	 *El telegrama tiene un formato XML
	 *Se convierte a byte para enviar
	 *Se envía al PLC (en el acto)
	 *Se devuelve el exito de la operación
	 */
	public synchronized boolean sendTelegrama(String telegramaXML) {
    
    
    try 
    {
      XMLDocument xmldoc = XMLHelper.parse(telegramaXML, null);    
      return sendTelegrama(xmldoc);
    } catch (Exception ex) 
    {
      LOG.error("SendTelegrama:", ex);
      return false;
    } 
      
	}


	/**
	 *Enviar un telegrama en formato documento XML al PlcDriver
	 *Se convierte a byte para enviar
	 *Se envía al PLC (en el acto)
	 *Se devuelve el exito de la operación
	 */
	public synchronized boolean sendTelegrama(XMLDocument xmldoc) {
    
    if (pruebas)
    {
      LOG.debug("PRUEBAS: enviat: " + XMLHelper.toString(xmldoc));
      return true;
    }
      
    if (!driver.isConnected())
    { 
      return false;
    }
    
    try
    {
      int len = XMLTelegrama.getLenTelegrama(xmldoc);
      byte [] outBytes = new byte [len];
      outBytes = getBytes(xmldoc, outBytes);
      if (driver.sendMessage(outBytes))
      {
        LOG.debug("enviat: " + XMLHelper.toString(xmldoc));
        return true;      
      }
    } catch (Throwable t)
    {
      LOG.error("e", t);
    }
    return false;
      
	}
  
  /**
   * Enviar señal de parar al driver
   */
  public void stopProcess()
  {
    driver.endThread();
  }
  
  /**
   * Enviar señal para que el driver vuelva a empezar
   */
  public void startProcess()
  {
    driver.startProces();
  }
  
	 
   
   public static byte [] getBytesForNodeList (NodeList nodes, byte [] bytes)
   {
   for (int i = 0; i < nodes.getLength(); i++)
    {
      Node node = nodes.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE)
      {
        String name = node.getNodeName();
          insertAttribute(name, bytes, node);
        NodeList nens = node.getChildNodes();
        if (nens != null)
          bytes = getBytesForNodeList (nens, bytes);
      }
    }
    return bytes;
   }
   
	 
  /**
   * Convertir un node xml en un array de bytes
   * xml ==>> bytes
   * @throws java.lang.Throwable
   * @return array de bytes que representa el telegrama
   * @param telegramaXml Cadena XML a convertir
   */
  public static byte [] getBytes (String telegramaXML, byte [] bytes) throws Throwable
  {
      XMLDocument xmldoc = XMLHelper.parse(telegramaXML, null);
      return getBytes(xmldoc, bytes);
  }
 
  /**
   * Convertir un node xml en un array de bytes
   * xml ==>> bytes
   * @return array de bytes que representa el telegrama
   * @param xmldoc documento xml en formato estandar a convertir
   * @param bytes array de bytes para almacenar el resultado y devolver
   * Solo se tratan nodos hijos con el formato:
   *    value: el valor a almacenar
   *    attributes:
   *      index: Posicion de inicio del campo en el array de bytees
   *      len: número de bytes que ocupa el campo
   *      tipo: str | byte | int

   * <p><em>NOTE: Solo se busca hasta nivel de nietos en el arbol del documento</em></p>
   */
 
  public static byte [] getBytes (XMLDocument xmldoc, byte [] bytes)
  {
  try 
  {
    Node nodeDetalles = xmldoc.selectSingleNode("Telegrama/Detalles");    
    bytes = getBytesForNodeList(nodeDetalles.getChildNodes(), bytes);
    bytes = initTelegramStandardData(xmldoc, bytes);
    return (bytes);
  } catch (Exception ex) 
  {
    ex.printStackTrace(); // TODO - ver donde poner esto...
    assert false;
  } 
   return null;
  }
  
  private static byte [] getTime()
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
   * inicializar los bytes correspondiente a la cabecera del documento
   * xml ==>> bytes
   * @return array de bytes inicializado
   * @param bytes
   * @param xmldoc
   */
  public static byte [] initTelegramStandardData(XMLDocument xmldoc, byte [] bytes)
  {
    bytes [0] = 'T';  // Always
    // Insertar la hora a partir de la posición 9
    byte [] tempBytes = getTime(); 
    System.arraycopy(tempBytes, 0, bytes, 9, tempBytes.length);

  try
    {
    // Hay que poner el tamaño del telegrama
    int len = Integer.parseInt(XMLParser.getAttributeValue(xmldoc, "Telegrama", "lenTelegrama"));
    bytes = ByteHelper.getSubBytes(bytes, 0, len);
    tempBytes = ByteHelper.int2bytes(len - Telegrama.MAX_HEADER); // TODO Limpiar
    System.arraycopy(tempBytes, 0, bytes, 5, 2);
    // Y el id del telegrama
    String tipoTel = XMLParser.getAttributeValue(xmldoc, "Telegrama", "tipoTel");
    System.arraycopy(tipoTel.getBytes(), 0, bytes, 1, 4);
    return bytes;    
    } catch (Exception e)
    {
      assert false;
    }
    return null;
  }

 
  /**
   * Extraer el valor de un atributo expresado por el nodo de la cadena de <code>bytes</code>
   * El nodo indica la posición, el tipo, y el tamaño de lo que hay que extraer
   * @return String que representa el valor extraido
   * @param elementNode
   * @see #bytes
   */
  private String getValorAttribute(Node elementNode)
  {
    NamedNodeMap  map = elementNode.getAttributes();
    String valor = elementNode.getFirstChild().getNodeValue();
    int index = Integer.parseInt(map.getNamedItem("index").getNodeValue());
    index = index + Telegrama.MAX_HEADER; // Algo feo esto aquí
    String tipo = map.getNamedItem("tipo").getNodeValue();
    int len = Integer.parseInt(map.getNamedItem("len").getNodeValue());

    byte [] byteVal = ByteHelper.getSubBytes(bytes, index, len);
    
    if (tipo.equals("int"))
    {
      int intValor = ByteHelper.bytes2int(byteVal);
      valor = Integer.toString(intValor);
    } 
    else if ((tipo.equals("byte")))
    {
      valor = Byte.toString(byteVal[0]);
    }
    else if (tipo.equals("str"))
    {
      valor = new String (byteVal);
    }
    else assert false;
    
    return valor;
    
  }
 /**
   * insertar el valor de un nodo xml en un array de bytes
   * xml ==>> bytes
   * @return array de bytes que contiene los valores insertados
   * @param elementNode
   * @param bytes
   * @param nodeName
   * @see GestorDatos#getBytes
   */
   private static byte [] insertAttribute(String nodeName, byte [] bytes, Node elementNode)
  {
  
    NamedNodeMap  map = elementNode.getAttributes();

    String valor = elementNode.getFirstChild().getNodeValue();
    int index = Integer.parseInt(map.getNamedItem("index").getNodeValue());
    index = index + Telegrama.MAX_HEADER; // El index es a partir del header
    String tipo = map.getNamedItem("tipo").getNodeValue();
    int len = Integer.parseInt(map.getNamedItem("len").getNodeValue());
    
    
    byte [] attBytes = null;
    if (tipo.equals("int"))
    {
      if (len == 2)
        attBytes = ByteHelper.int2bytes(Integer.parseInt(valor));
      else
        attBytes = ByteHelper.int4bytes(Integer.parseInt(valor));
    } 
    else if ((tipo.equals("byte")))
    {
      attBytes = new byte [1];
      attBytes[0]  = (byte)Integer.parseInt(valor);
    }
    else if (tipo.equals("str"))
    {
      attBytes = valor.getBytes();
      // Ajustar el largo a enviar
      len = attBytes.length < len ? attBytes.length : len;
    }
    else assert false;
    
    System.arraycopy(attBytes, 0, bytes, index, len);
    return bytes;
    }
  
	 
   
   public static void main(String[] args)
   {
   /* On receive test
    Gestor g = new Gestor();
    Movi mov = new Movi(1234, new Posicion (11, (byte)12, (byte)13, (byte)1, (byte)2), 
      new Posicion (55, (byte)1, (byte)2, (byte)1, (byte)3), 
      (byte)1, (byte)1, 123, 456, (byte)1, (byte)1, "1000000123");
      
    String here = new String (mov.getBytes());
    here = here.replaceAll("MOVI", "AMOV");  
    g.onReceive(here);
   }
   */
   GestorDatos g = new GestorDatos();
   while (true)
   {
     try 
     {
      Thread.sleep(1000000);
     } catch (Exception ex) 
     {
      ex.printStackTrace();
     } finally 
     {
     }
   }
   }
   
}
 
