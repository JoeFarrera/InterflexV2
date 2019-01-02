/*@lineinfo:filename=Maputil*//*@lineinfo:user-code*//*@lineinfo:1^1*/package es.sysmap.interflex.plcserver;

import java.sql.SQLException;
import sqlj.runtime.ref.DefaultContext;
import sqlj.runtime.ConnectionContext;
import java.sql.Connection;

public class Maputil
{

  /* connection management */
  protected DefaultContext __tx = null;
  protected Connection __onn = null;
  public void setConnectionContext(DefaultContext ctx) throws SQLException
  { release(); __tx = ctx; }
  public DefaultContext getConnectionContext() throws SQLException
  { if (__tx==null)
    { __tx = (__onn==null) ? DefaultContext.getDefaultContext() : new DefaultContext(__onn); }
    return __tx;
  };
  public Connection getConnection() throws SQLException
  { return (__onn==null) ? ((__tx==null) ? null : __tx.getConnection()) : __onn; }
  public void release() throws SQLException
  { if (__tx!=null && __onn!=null) __tx.close(ConnectionContext.KEEP_CONNECTION);
    __onn = null; __tx = null;
  }


  /* constructors */
  public Maputil() throws SQLException
  { __tx = DefaultContext.getDefaultContext();
 }
  public Maputil(DefaultContext c) throws SQLException
  { __tx = c; }
  public Maputil(Connection c) throws SQLException
  {__onn = c; __tx = new DefaultContext(c);  }

  public String isfisicamentedisponible (
    String pidmac)
  throws SQLException
  {
    String __jPt_result;
    /*@lineinfo:generated-code*//*@lineinfo:43^5*/

//  ************************************************************
//  #sql [getConnectionContext()] __jPt_result = { VALUES(IFDBA.MAPUTIL.ISFISICAMENTEDISPONIBLE(
//        :pidmac))  };
//  ************************************************************

{
  // declare temps
  oracle.jdbc.OracleCallableStatement __sJT_st = null;
  sqlj.runtime.ref.DefaultContext __sJT_cc = getConnectionContext(); if (__sJT_cc==null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_CONN_CTX();
  sqlj.runtime.ExecutionContext.OracleContext __sJT_ec = ((__sJT_cc.getExecutionContext()==null) ? sqlj.runtime.ExecutionContext.raiseNullExecCtx() : __sJT_cc.getExecutionContext().getOracleContext());
  try {
   String theSqlTS = "BEGIN :1 := IFDBA.MAPUTIL.ISFISICAMENTEDISPONIBLE(\n       :2 )  \n; END;";
   __sJT_st = __sJT_ec.prepareOracleCall(__sJT_cc,"0es.sysmap.interflex.plcserver.Maputil",theSqlTS);
   if (__sJT_ec.isNew())
   {
      __sJT_st.registerOutParameter(1,oracle.jdbc.OracleTypes.VARCHAR);
   }
   // set IN parameters
   __sJT_st.setString(2,pidmac);
 // execute statement
   __sJT_ec.oracleExecuteUpdate();
   // retrieve OUT parameters
   __jPt_result = __sJT_st.getString(1);
  } finally { __sJT_ec.oracleClose(); }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:44^17*/
    return __jPt_result;
  }
}/*@lineinfo:generated-code*/