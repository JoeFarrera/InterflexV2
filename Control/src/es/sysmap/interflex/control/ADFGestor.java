package es.sysmap.interflex.control;
import es.sysmap.interflex.model.dmc.common.AppModule;
import oracle.jbo.client.Configuration;
import org.apache.log4j.Logger;

public class ADFGestor
{
  private static final String amDef = "es.sysmap.interflex.model.dmc.AppModule";
  private static final String config = "AppModuleLocal";
  protected AppModule am;
  protected Logger LOG = Logger.getLogger(getClass());

  public ADFGestor()
  {
  
  }
  
  protected void connectApplicationModule()
  {
    LOG.debug("Conectant al appModule: " + amDef + " amb el config: " + config);
    am = (AppModule)Configuration.createRootApplicationModule(amDef,config);
    am.getTransaction().setClearCacheOnCommit(true);

  }
  
  
  public void commit()
  {
    am.getTransaction().commit();
  }
  
  public void rollback()
  {
    am.getTransaction().rollback();
  }
}