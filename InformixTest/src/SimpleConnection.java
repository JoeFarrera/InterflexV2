/****************************************************************************
 *                                                                          *
 * Licensed Materials - Property of IBM                                     *
 *                                                                          *
 * "Restricted Materials of IBM"                                            *
 *                                                                          *
 * IBM Informix JDBC Driver                                                 *
 * (c) Copyright IBM Corporation 1998, 2002 All rights reserved.            *
 *                                                                          *
 ****************************************************************************/
/***************************************************************************
 *
 *  Title:         SimpleConnection.java
 *
 *  Description:    Demo a connection to a server (no database specified)
 *		
 *  An example of running the program: 
 *		
 *   java SimpleConnection 
 *      'jdbc:informix-sqli://myhost:1533:informixserver=myserver;user=<username>;password=<password>'
 *		
 *   Expected result:
 * 
 * >>>Simple Connection test.
 * URL = "jdbc:informix-sqli://myhost:1533:informixserver=myserver;user=<username>;password=<password>"
 * >>>End of Simple Connection test.
 * 
 ***************************************************************************
 */

 

import java.sql.*;
import java.util.*;

public class SimpleConnection {

    public static void main(String[] args)
    {
        if (args.length == 0)
	    {
	    System.out.println("FAILED: connection URL must be provided in order to run the demo!");
	    return;
	    }

        String url = args[0];

        String testName = "Simple Connection";

	Connection conn = null;

	System.out.println(">>>" + testName + " test.");
	System.out.println("URL = \"" + url + "\"");

	try 
	    {
	    Class.forName("com.informix.jdbc.IfxDriver");
	    } 
	catch (Exception e)
	    {
	    System.out.println("FAILED: failed to load Informix JDBC driver.");
	    }

	try 
	    {
	    conn = DriverManager.getConnection(url);
      DatabaseMetaData metaData = conn.getMetaData();
      System.out.println("Database name: " + metaData.getDatabaseProductName());
      ResultSet results = metaData.getSchemas();
      while (results.next())
      {
        System.out.println("Results: " + results.toString());
      }
      System.out.println();
	    } 
	catch (SQLException e) 
	    {
	    System.out.println("FAILED: failed to connect!");
	    }

    String cmd = null;
    int rc;
  
  	try
	    {
	    Statement stmt = conn.createStatement();
	    cmd = "database emp0001;";
	    rc = stmt.executeUpdate(cmd);
	    stmt.close();
	    }
	catch (SQLException e)
	    {
	    System.out.println("FAILED: execution failed - statement: " + cmd);
	    System.out.println("FAILED: " + e.getMessage());
	    }


	try 
	    {
            conn.close();
	    } 
	catch (SQLException e) 
	    {
	    System.out.println("FAILED: failed to close the connection!");
	    }

	System.out.println(">>>End of " + testName + " test.");
    }
}
