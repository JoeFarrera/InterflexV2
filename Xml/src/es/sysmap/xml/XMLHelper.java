package es.sysmap.xml;

import java.io.*;

import java.net.*;

import oracle.xml.parser.v2.*;

import org.apache.log4j.Logger;

import org.xml.sax.*;

// import sgalib.SgaUtilPuesto;


public class XMLHelper {

  static Logger LOG = Logger.getLogger("XMLHelper");  
  // Parse an XML document from a character Reader
  public static XMLDocument parse( Reader r, URL baseUrl )
                         throws IOException, SAXParseException, SAXException  {
    // Construct an input source from the Reader
    InputSource input = new InputSource(r);
    // Set the base URL if provided
    if (baseUrl != null) input.setSystemId(baseUrl.toString());
    // Construct a new DOM Parser
    DOMParser xp = new DOMParser();
    // Parse in Non-Validating Mode
    xp.setValidationMode(DOMParser.NONVALIDATING);
    // Preserve Whitespace
    xp.setPreserveWhitespace(true);
    // Attempt to parse XML coming in from the Reader
    xp.parse(input);
    // If the parse is successful, return the DOM Document
    return (XMLDocument) xp.getDocument();
  }
  // Parse XML from an InputStream
  public static XMLDocument parse( InputStream is, URL baseURL )
                         throws SAXParseException, SAXException, IOException {
    // Construct a Reader and call parse(Reader)
    return parse( new InputStreamReader(is), baseURL );
  }
  // Parse XML From a String
  public static XMLDocument parse( String xml, URL baseurl )
                            throws MalformedURLException, IOException,
                                   SAXParseException, SAXException {

    // Construct a reader and call parse(Reader)
    return parse(new StringReader(xml),baseurl);
  }
  // Parse XML from a URL
  public static XMLDocument parse( URL url ) throws IOException,
                                                 SAXParseException,
                                                 SAXException  {
    // Construct an InputStream and call parse(InputStream)
    // Use the url passed-in as the baseURL
    return parse( url.openStream(), url);
  }
  
  
  public static String toString (XMLDocument xmldoc)
  {
    StringWriter sw = new StringWriter();
    
    try
    {
      xmldoc.print(new PrintWriter(sw));
      return sw.toString();
      
    } catch (IOException ioe)
    {
      LOG.error("toString: ", ioe);
    }
    return null;
 
  }
}
