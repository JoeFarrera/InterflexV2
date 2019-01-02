package es.sysmap.interflex.informix;
import java.util.Properties;
import java.sql.*;
import java.util.*;

public class TestConnection 
{
  Driver driver;
  
  public TestConnection()
  {
    try 
    {
     driver = (Driver)Class.forName("com.informix.jdbc.IfxDriver").newInstance();
     Properties props = new Properties();
      props.put("user",         "biosca");
      props.put("password",     "5465");
      props.put("db",           "emp0009");
      props.put("server",       "interflex");
      props.put("port",         "1526");
      String url = "jdbc:informix-sqli://129.200.9.1:1526/emp0009:INFORMIXSERVER=se_interflex;user=biosca;password=5465";
      Connection conn = DriverManager.getConnection(url);
      try
      {
        PreparedStatement pstmt = conn.prepareStatement("Select * from detalle;");
        ResultSet r = pstmt.executeQuery();
  /*      while(r.next())
        {
          int index = r.findColumn("cab_motivo");
          String cab_motivo = r.getString("cab_motivo");
          int cab_id = r.getInt("cab_id");
          String i = r.getString(1);
          System.out.println("Select: column 1 = " + i + " cab_id: " + cab_id + " cab_motivo: " + cab_motivo);
        }*/
        ResultSetMetaData rsmd = r.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
        {
          System.out.print("Column name: " + rsmd.getColumnName(i));
          System.out.print(" type: " + rsmd.getColumnTypeName(i));
          System.out.println(" java type: " + rsmd.getColumnType(i));
        }
        r.close();
        pstmt.close();
      }
      catch (SQLException e)
      {
          System.out.println("ERROR: Fetch statement failed: " +
          e.getMessage());
      }
            // com.informix.asf.Connection conn = (com.informix.asf.Connection)driver.connect("jdbc:informix-sqli:INFORMIXSERVER=se_interflex", props);
    } 
    catch (Exception ex) 
    {
      ex.printStackTrace();
    } 
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    TestConnection testConnection = new TestConnection();
    
  }
}