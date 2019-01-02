package es.sysmap.interflex.gestortelegrama.test;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.xml.XMLHelper;
import es.sysmap.xml.XMLTelegrama;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import es.sysmap.interflex.gestortelegrama.ByteHelper;
import oracle.xml.parser.v2.XMLDocument;
import org.w3c.dom.NodeList;

public class ByteHelperTester1 extends TestCase 
{
  public ByteHelperTester1(String sTestName)
  {
    super(sTestName);
  }

  /**
   * byte[] int2bytes(int)
   */
  public void testint2bytes()
  {
  }

  /**
   * byte[] int4bytes(int)
   */
  public void testint4bytes()
  {
    GestorDatos gd = new GestorDatos();
    
    byte [] bytes = ByteHelper.int4bytes(5000);
    String hexval = Integer.toHexString(5000);
   
    XMLDocument xmldoc = XMLTelegrama.parseXML("MOVI"); 
    assertNotNull(xmldoc);
    int numMovimiento = XMLTelegrama.getNumMovimiento(xmldoc);
    assertEquals(5000, numMovimiento);
    
  }

  /**
   * int bytes2int(byte[])
   */
  public void testbytes2int()
  {
    
  }
}