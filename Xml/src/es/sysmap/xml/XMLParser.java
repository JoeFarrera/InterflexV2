package es.sysmap.xml;

import org.apache.log4j.Logger;
import oracle.xml.parser.v2.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;

public class XMLParser 
{
  static Logger LOG = Logger.getLogger("XMLParser");

  public XMLParser()
  {
  }
  /**
   * Devolver el attribute de un documento (o nodo)
   * Devuelve null si no se encuentra
   * 
   * @throws java.lang.Exception
   * @return el valor del attribute
   * @param attName Nombre del atributo
   * @param XPath Path en el documento para localizarlo
   * @param xmldoc  Documento o nodo a explorar
   */
  public static String getAttributeValue (XMLDocument xmldoc, String XPath, String attName) throws Exception
  {
    Node sNode = null;
    if (XPath.equals("/")) {
      // If the path is the root, print the entire document
      xmldoc.print(System.out); // TODO - surely not
    }
    else {
      // Otherwise handle the matching nodes
      try {
        // Select nodes matching XPath
        sNode = xmldoc.selectSingleNode(XPath);
      }
      catch (XSLException err) {
        LOG.error("XMLParser Error:", err);
        throw err;
      }
      if (sNode != null) {
        // Loop over matches
        XMLNode curNode = (XMLNode)sNode;
        if (curNode.hasAttributes())
        {
          Node requestedNode = curNode.getAttributes().getNamedItem(attName);
          if (requestedNode != null)
            return (requestedNode.getNodeValue());
          else
            return (null);
        }
      }
      else 
        { 
          LOG.debug("XMLParser: No encontrado: " + XPath + " atributo:" + attName); 
        }
    }
    return (null);

  }
  
  /**
   * devolver el valor asociado con un nodo
   * @throws java.lang.Exception
   * @return el valor del nodo o <code>null</code> si no lo encuentra
   * @param XPath
   * @param xmldoc
   * TODO NOTA Michael 11.03.2005 Parece que no funciona esto.
   */
  public static String getNodeValue (XMLDocument xmldoc, String XPath) throws Exception
  {
    
    Node sNode = null;
    if (XPath.equals("/")) {
      // If the path is the root, print the entire document Michael TODO - surely not
      xmldoc.print(System.out);
    }
    else {
      // Otherwise handle the matching nodes
      try {
        // Select nodes matching XPath
        sNode = xmldoc.selectSingleNode(XPath);
      }
      catch (XSLException err) {
        LOG.error("XMLParser Error:", err);
        throw err;
      }
      if (sNode != null) {
        // Loop over matches
        XMLNode curNode = (XMLNode)sNode;
        String val = curNode.valueOf(XPath);
        return (val);
      }
      else 
        { 
          LOG.debug("XMLParser: No encontrado: " + XPath ); 
        }
    }
    return (null);

  }
  
  


}