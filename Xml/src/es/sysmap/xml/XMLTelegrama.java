package es.sysmap.xml;
import java.io.FileInputStream;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLNode;
import oracle.xml.parser.v2.XSLException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import sgalib.SgaUtilPuesto;
import org.apache.log4j.Logger;;

public class XMLTelegrama
{
  private static Logger LOG = Logger.getLogger(XMLTelegrama.class);

  public XMLTelegrama()
  {
  }
  /**
   * El identificado del telegrama.
   * Si no existe el identificador - asserts
   * @return el identificador del telegrama
   * @param node del documento que tiene el identificador
   */
  public static int getIdTelegrama (XMLNode node)
  {
    try 
    {
      int idTelegrama = Integer.parseInt(XMLParser.getAttributeValue((XMLDocument)node, "Telegrama", "idTelegrama"));
      return idTelegrama;
    } catch (Exception ex) 
    {
      assert false;
      return 0;
    } 
  }
  
  /**
   * Devuelve el tipo del telegrama
   * Preconditions: Si el nodo no es de tipo Telegrama, asserts
   * @return 
   * @param documento XML, de tipo telegrama
   */
  public static String getTipoTelegrama(XMLDocument xmldoc)
  {
    try 
    {
      return XMLParser.getAttributeValue(xmldoc, "Telegrama", "tipoTel");
    } catch (Exception ex) 
    {
      assert false;
      return null;
    } 
  }
  
  public static int getCodigoError(XMLDocument xmldoc)
  {
    return Integer.parseInt(getDetailNodeValue(xmldoc, "codError"));
  }
  
  public static int getPasilloTraslo(XMLDocument xmldoc, int idTraslo)
  {
    if (idTraslo == 0)
      return 0; // El miniload no se cambia de pasillo
    String trasloPas = idTraslo == 1 ? "Pasillo61" : "Pasillo62";
    return Integer.parseInt(getDetailNodeValue(xmldoc, trasloPas));
  }
  
  public static String getMatricula(XMLDocument xmldoc)
  {
    return getDetailNodeValue(xmldoc, "matricula");
  }
  
  public static int getEstadoPuente(XMLDocument xmldoc)
  {
    return Integer.parseInt(getDetailNodeValue(xmldoc, "Transbordo"));
  }
  
  public static int getEstadoTraslo(XMLDocument xmldoc, int idTraslo)
  {
    String traslo = null;
    switch (idTraslo)
    {
      case 0:
        traslo = "P50";
        break;
      case 1:
        traslo = "P61";
        break;
      case 2:
        traslo = "P62";
        break;
      default:
        assert false;
    }
    return Integer.parseInt(getDetailNodeValue(xmldoc, traslo));
  }
  
  private static String getDetailNodeValue(XMLDocument xmldoc, String path)
  {
    try 
    {
      XMLNode detailNode = getNodoDetalles(xmldoc);
      return detailNode.valueOf(path);
    } catch (Exception ex) 
    {
      LOG.error("getNumMovimiento:", ex);
      assert false;
      return null;
    } 
   }
  
  public static int getNumMovimiento(XMLDocument xmldoc)
  {
      return Integer.parseInt(getDetailNodeValue(xmldoc, "numMovimiento"));
  }
  /**
   * @param numMovimiento
   * @param xmldoc
   */
  public static void setNumMovimiento(XMLDocument xmldoc, int numMovimiento)
  {
    try 
    {
      XMLNode detailNode = getNodoDetalles(xmldoc);
      setValorNodo(detailNode, "numMovimiento", Integer.toString(numMovimiento));
    } catch (Exception ex) 
    {
      LOG.error("setNumMovimiento:", ex);
    } 
    
  }
  
  public static void setTipoTelegrama(XMLDocument xmldoc, String tipoTel)
  {
    Element el = xmldoc.getDocumentElement();
    el.setAttribute("tipoTel", tipoTel);
  }

  /**
   * El tamaño del telegrama, expresado como atributo del telegrama
   * @return 
   * @param node del documento que tiene el telegrama
   */
  public static int getLenTelegrama (XMLNode node)
  {
    try 
    {
      int lenTelegrama = Integer.parseInt(XMLParser.getAttributeValue((XMLDocument)node, "Telegrama", "lenTelegrama"));
      return lenTelegrama;
    } catch (Exception ex) 
    {
      assert false;
      return 0;
    } 
  }
  
  /**
   * Devuelve true si los nodos de detalle de los documentos first y second son iguales
   * @return 
   * @param second
   * @param first
   */
  public static boolean isEqualDetalle(XMLDocument first, XMLDocument second)
  {
    XMLNode firstNode = getNodoDetalles(first);
    XMLNode secondNode = getNodoDetalles(second);
    return (firstNode.getText().equals(secondNode.getText()));
  }
  
    /**
   * Abrir un fichero XML correspondiente al identificador del telegrama
   * @return 
   * @param idTele
   */
  public static XMLDocument parseXML (String idTele)
  {
    // TODO - ir a buscar esto cada vez o qué ??
    String fileName = SgaUtilPuesto.getXMLRoot() + "/" + idTele + ".xml";
    FileInputStream is = null;
    try 
    {
      is = new FileInputStream(fileName);
      XMLDocument xmldoc = XMLHelper.parse(is, null);
      is.close();
      return (xmldoc);
    } catch (Exception ex) 
    {
      LOG.error("Fichero: " + fileName + " parseXML exception: ", ex);
      try 
      {
        if (is != null)
          is.close();
      } catch (Exception ex1) 
      {}  // Nadal
      
    }
    
    return null;
  }
 
  /**
   * Poner el valor a un nodo
   * Asserts si el child node on se encuentra
   * Asserts si genera una exception XSLException
   * @param valor
   * @param nodeName
   * @param node
   */
  public static void setValorNodo (XMLNode node, String nodeName, String valor)
  {
    try
    {
      Node childNode = node.selectSingleNode(nodeName);   
      assert childNode != null;
      childNode.getFirstChild().setNodeValue(valor);
    } catch (XSLException e)
    {
      LOG.fatal("Error al intentar poner un valor al nodo: " + node + " valor: " + valor);
      assert false;
    }
  }
  
  public static XMLNode getNodoDetalles (XMLDocument xmldoc)
  {
    try 
    {
      return (XMLNode)xmldoc.selectSingleNode("Telegrama/Detalles");
    } catch (Exception ex) 
    {
      LOG.error("getNodoDetalles: ",ex);
      return null;
    } 
  }
  
  public static int getPosAct (XMLDocument xmldoc)
  {
    return Integer.parseInt(getDetailNodeValue(xmldoc, "posAct"));
  }

}