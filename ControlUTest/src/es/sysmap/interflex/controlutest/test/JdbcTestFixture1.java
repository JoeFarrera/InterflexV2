package es.sysmap.interflex.controlutest.test;
import java.sql.DriverManager;
import java.sql.Connection;

public class JdbcTestFixture1 
{
  String _connectionURL = "jdbc:oracle:thin:@covil:1521:PROD";
  Connection _connection;
  String _password = "ifdba";
  String _userName = "ifdba";

  public JdbcTestFixture1()
  {
  }

  public void setUp() throws Exception
  {
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    _connection = DriverManager.getConnection(getConnectionURL(), getUserName(), getPassword());
  }

  public void tearDown() throws Exception
  {
    _connection.close();
  }

  public Connection getConnection()
  {
    return _connection;
  }

  String getUserName()
  {
    return _userName;
  }

  String getPassword()
  {
    return _password;
  }

  public String getConnectionURL()
  {
    return _connectionURL;
  }
}