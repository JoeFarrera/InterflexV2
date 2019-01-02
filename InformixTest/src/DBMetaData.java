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
 *  Title:         DBMetaData.java
 *
 *  Description:    Demo a databasemetata operation 
 *		
 *  An example of running the program: 
 *		
 *   java DBMetaData
 *      'jdbc:informix-sqli://myhost:1533:informixserver=myserver;user=<username>;password=<password>'
 *   Expected result:
 *
 * >>>Simple databasemetadata operation test.
 * URL = "jdbc:informix-sqli://myhost:1533/testDB:informixserver=myserver;user=<username>;password=<password>"
 * number of columns 8
 * procedure_cat,
 * procedure_schema,
 * procedure_name,
 * reserved1,
 * reserved2,
 * reserved3,
 * remarks,
 * procedure_type 
 * 
 * testDB,
 * <user name>,
 * proc3,
 * ,
 * ,
 * ,
 * ,
 * 0 
 * 
 * >>>End of Simple databasemetadata operation test.
 *		
 ***************************************************************************
 */

 

import java.sql.*;
import java.util.*;
import java.math.BigDecimal ;
import java.io.*;
import java.lang.*;

public class DBMetaData {

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

        newUrl += "/ent0001";

        while (st.hasMoreTokens())
	    { 
            newUrl += ":" + st.nextToken();
            }

	Connection conn = null;
        int 	   rc;
	String     cmd=null;
	Statement  stmt = null;

        String testName = "Simple databasemetadata operation";

	System.out.println(">>>" + testName + " test.");
	System.out.println("URL = \"" + newUrl + "\"");

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

	try
	    {
            ResultSet            rs ;
            DatabaseMetaData     dmd ;

	    stmt = conn.createStatement();
            dmd = conn.getMetaData();
            stmt.executeUpdate(
            "create procedure proc3( i integer ) " +
            "returning integer ; " +
            "  define j integer ; " +
            "  for j in ( 1 to 5 ) " +
            "    let i = i + 1 ; " +
            "    return i with resume ; " +
            "  end for " +
            "end procedure"
             ) ;
             rs = dmd.getProcedures( null, null, "proc3" ) ;
             dispResult( rs ) ;
	    }
	catch (SQLException e)
	    {
	    System.out.println("FAILED: execution failed - statement: " + cmd);
	    System.out.println("FAILED: " + e.getMessage());
	    }

	try
	    {
	    stmt = conn.createStatement();
	    cmd = "drop procedure proc3";
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

  public static void dispResult( ResultSet rs ) 
  throws SQLException 
    {
    int               i ;
    int               ncols ;
    ResultSetMetaData rsmd ;
    String            comma = null ;
    byte []           blob ;
    int               typ ;
    int               blen ;
    String            s = new String();

    rsmd = rs.getMetaData() ;
    ncols = rsmd.getColumnCount() ;

    System.out.println( "number of columns " + ncols ) ;
    // verify no of columns
    if (ncols != 8)
        System.out.println("FAILED: Expected # of cols = 8. Returned # of cols = "+ncols);

    for( i=1; i<=ncols; ++i ) 
      {
      if( i > 1 || i == 1 )  
         {
         if (i < ncols) 
            comma = "," ;
         else 
            comma = " ";
         }

       // verify result
       s = rsmd.getColumnLabel( i ).trim();
       switch(i)
           {
           case 1:
               if (!s.trim().equals("procedure_cat"))
                   System.out.println("FAILED. Expected = procedure_cat. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 2:
               if (!s.trim().equals("procedure_schem"))
                   System.out.println("FAILED. Expected = procedure_schem. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 3:
               if (!s.trim().equals("procedure_name"))
                   System.out.println("FAILED. Expected = procedure_name. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 4:
               if (!s.trim().equals("reserved1"))
                   System.out.println("FAILED. Expected = reserved1. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 5:
               if (!s.trim().equals("reserved2"))
                   System.out.println("FAILED. Expected = reserved2. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 6:
               if (!s.trim().equals("reserved3"))
                   System.out.println("FAILED. Expected = reserved3. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 7:
               if (!s.trim().equals("remarks"))
                   System.out.println("FAILED. Expected = remarks. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 8:
               if (!s.trim().equals("procedure_type"))
                   System.out.println("FAILED. Expected = procedure_type. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           default:
               break;
           }
       }
    System.out.println( "" ) ;

    while( rs.next() ) {
      for( i=1; i<=ncols; ++i ) {
       // if( i > 1 ) System.out.println(", " ) ;

        typ = rsmd.getColumnType( i ) ;
        //System.out.print( "typ " + typ + " " ) ;

        switch( typ ) {
          case Types.CHAR:  
          case Types.VARCHAR:
          case Types.LONGVARCHAR:
            s = rs.getString( i ) ;
            break ;

          case Types.SMALLINT:   
            short v = rs.getShort( i ) ;
            if( !rs.wasNull() ) s = "" + v ;
            break ;
            
          case Types.INTEGER:   
            int vi = rs.getInt( i ) ;
            if( !rs.wasNull() ) s = "" + vi ;
            break ;

          case Types.DOUBLE: 
            double vd = rs.getDouble( i ) ;
            if( !rs.wasNull() ) s = "" + vd ;
            break ;

          case Types.FLOAT: 
            float vf = rs.getFloat( i ) ;
            if( !rs.wasNull() ) s = "" + vf ;
            break ;

          case Types.DECIMAL: 
          case Types.NUMERIC: 
            BigDecimal vb = rs.getBigDecimal( i ) ;
            if( !rs.wasNull() ) s = vb.toString() ;
            break ;

          case Types.DATE: 
            java.sql.Date vt = rs.getDate( i ) ;
            if( !rs.wasNull() ) s = vt.toString() ;
            break ;

          case Types.TIMESTAMP: 
            Timestamp vs = rs.getTimestamp( i ) ;
            if( !rs.wasNull() ) s = vs.toString() ;
            break ;

          case Types.LONGVARBINARY:
            //blen = ((VtiResultSet)rs).getBytesLength( i ) ;
            //System.out.print( blen + " " ) ;
            blob = rs.getBytes( i ) ;
            if( !rs.wasNull() ) 
              s = "[blob length " + blob.length + "]" ;
            break ;

          default:
            s = "" ;

        }
      if( i > 1 || i == 1 )  
         {
         if (i < ncols) 
            comma = "," ;
         else 
            comma = " ";
         }
       switch(i)
           {
           case 1:
               if (!s.trim().equals("testDB"))
                   System.out.println("FAILED. Expected = testDB. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 2:
                   System.out.println(s + comma ) ;
               break;
           case 3:
               if (!s.trim().equals("proc3"))
                   System.out.println("FAILED. Expected = proc3. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 4:
               if (!s.trim().equals(""))
                   System.out.println("FAILED. Expected = reserved1. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 5:
               if (!s.trim().equals(""))
                   System.out.println("FAILED. Expected = reserved2. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 6:
               if (!s.trim().equals(""))
                   System.out.println("FAILED. Expected = reserved3. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 7:
               if (!s.trim().equals(""))
                   System.out.println("FAILED. Expected = remarks. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           case 8:
               if (!s.trim().equals("0"))
                   System.out.println("FAILED. Expected = 0. Returned = "+s);
               else
                   System.out.println(s + comma ) ;
               break;
           default:
               break;
           }
      }
      System.out.println( "" ) ;
    }
  }
}
