package es.sysmap.interflex.control.test;
import es.sysmap.interflex.model.dmc.common.AppModule;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import es.sysmap.interflex.control.Traslo;
import oracle.jbo.client.Configuration;

public class TrasloTester1 extends TestCase 
{
  private static final String amDef = "es.sysmap.interflex.model.dmc.AppModule";
  private static final String config = "AppModuleLocal";

  public TrasloTester1(String sTestName)
  {
    super(sTestName);
  }

  /**
   * boolean buscarTrabajo()
   */
  public void testbuscarTrabajo()
  {
    AppModule am = (AppModule)Configuration.createRootApplicationModule(amDef,config);
    am.getTransaction().setClearCacheOnCommit(true);
      Traslo traslo = new Traslo(1, 1 == 0 ? "MLD" : "SLO", am);
      traslo.test();
      

  }
}