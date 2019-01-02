package sgalib;
import java.sql.SQLException;
import oracle.jbo.SQLStmtException;

public class MapOraError 
{
  public MapOraError()
  {
  }
  
/**
 * Determina si el exception corresponde con ORA-00054
 * @return boolean true si es ORA-00054
 * @param e el exception
 */
 public static boolean isOra54(SQLStmtException e)
 {
  boolean retVal = false;
  Object [] obs = e.getDetails();
  if (obs [0] instanceof SQLException)
  {
    SQLException esql = (SQLException)obs[0];
    int errorCode = esql.getErrorCode();
    if (errorCode == 54)  // ORA-00054: resource busy and acquire with NOWAIT specified
      retVal = true;
    else
      retVal = false;
  }
  return retVal;

 }

}