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
 *  Title:         DBConnection.java
 *
 *  Description:    Demo a connection to a database of a particular server
 *		
 *  An example of running the program: 
 *		
 *   java DBConnection 
 *      'jdbc:informix-sqli://myhost:1533:informixserver=myserver;user=<username>;password=<password>'
 *		
 *   Expected result:
 * 
 * >>>Database Connection Direct test.
 * URL = "jdbc:informix-sqli://myhost:1533/testDB:informixserver=myserver;user=<username>;password=<password>"
 * >>>End of Database Connection Direct test.
 * >>>Database Connection Indirect test.
 * URL = "jdbc:informix-sqli://myhost:1533:informixserver=myserver;user=<username>;password=<password>"
 * >>>End of Database Connection Indirect test.
 * 
 ***************************************************************************
 */

 

import java.sql.*;
import java.util.*;

public class DBConnection {

    public static void main(String[] args)
    {
        if (args.length == 0)
	    {
	    System.out.println("FAILED: connection URL must be provided in order to run the demo!");
	    return;
	    }

        String url = args[0];
        StringTokenizer st = new StringTokenizer(url, ":");
        String token;
        String newUrl = "";

        for (int i = 0; i < 4; ++i)
	    { 
            if (!st.hasMoreTokens())
   	        {
	        System.out.println("FAILED: incorrect URL format!");
	        return;
	        }
            token = st.nextToken();
            if (newUrl != "")
	        newUrl += ":";
            newUrl += token;
            }

        newUrl += "emp0001";

        while (st.hasMoreTokens())
	    { 
            newUrl += ":" + st.nextToken();
            }
			
//INFORMIX_EXTEXT_BEGIN DBConn1.jav
	String cmd = null;
	int rc;
//INFORMIX_EXTEXT_END DBConn1.jav

        String testName = "Database Connection Direct";

//INFORMIX_EXTEXT_BEGIN DBConn2.jav
	Connection conn = null;
//INFORMIX_EXTEXT_END DBConn2.jav

	System.out.println(">>>" + testName + " test.");
	System.out.println("URL = \"" + newUrl + "\"");

//INFORMIX_EXTEXT_BEGIN DBConn3.jav
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
	    conn = DriverManager.getConnection(newUrl);
	    } 
	catch (SQLException e) 
	    {
	    System.out.println("FAILED: failed to connect!");
	    }
//INFORMIX_EXTEXT_END DBConn3.jav

	try 
	    {
            conn.close();
	    } 
	catch (SQLException e) 
	    {
	    System.out.println("FAILED: failed to close the connection!");
	    }

	System.out.println(">>>End of " + testName + " test.");

        url = args[0];

        testName = "Database Connection Indirect";

        conn = null;

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
	    } 
	catch (SQLException e) 
	    {
	    System.out.println("FAILED: failed to connect!");
	    }

//INFORMIX_EXTEXT_BEGIN DBConn4.jav
	try
	    {
	    Statement stmt = conn.createStatement();
	    cmd = "database testDB;";
	    rc = stmt.executeUpdate(cmd);
	    stmt.close();
	    }
	catch (SQLException e)
	    {
	    System.out.println("FAILED: execution failed - statement: " + cmd);
	    System.out.println("FAILED: " + e.getMessage());
	    }
//INFORMIX_EXTEXT_END DBConn4.jav

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
