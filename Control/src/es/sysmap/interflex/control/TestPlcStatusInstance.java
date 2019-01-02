package es.sysmap.interflex.control;
import es.sysmap.xml.XMLHelper;

public class TestPlcStatusInstance 
{
  public TestPlcStatusInstance()
  {
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    System.out.println("Before PlcStatus..");
    PlcStatus status = PlcStatus.getInstance();
    System.out.println("status is: " + status.toString());
    try 
    {
      Thread.sleep(5000);    
    } catch (Exception ex) 
    {
      ex.printStackTrace();
    } finally 
    {
    }
    System.out.println("[bye]");
    
    
  }
}