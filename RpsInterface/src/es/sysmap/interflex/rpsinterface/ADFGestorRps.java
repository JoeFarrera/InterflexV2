package es.sysmap.interflex.rpsinterface;
import es.sysmap.interflex.modelrps.dmc.common.AppModule;
import oracle.jbo.common.Configuration;
import org.apache.log4j.Logger;

public class ADFGestorRps 
{
   private static final String amDef = "es.sysmap.interflex.modelrps.dmc.AppModule";
   private static final String config = "AppModuleLocal";
   protected es.sysmap.interflex.modelrps.dmc.common.AppModule am;
   protected es.sysmap.interflex.modelrpsprod.dmc.common.AppModule amProd;
   protected Logger LOG = Logger.getLogger(getClass());

   private static final String amDefProd = "es.sysmap.interflex.modelrpsprod.dmc.AppModule";


  public ADFGestorRps()
  {
  
    LOG.debug("Conectant al appModule: " + amDef + " amb el config: " + config);
    am = (AppModule)Configuration.createRootApplicationModule(amDef,config);
    am.getTransaction().setClearCacheOnCommit(true);
    
    LOG.debug("Conectant al appModule: " + amDef + " amb el config: " + config);
    amProd = (es.sysmap.interflex.modelrpsprod.dmc.common.AppModule)Configuration.createRootApplicationModule(amDefProd, config);
    amProd.getTransaction().setClearCacheOnCommit(true);

  }
  
  private void updateZTipoenvio () 
  {
   am.updateZTipoenvio();
  }
  
  private void updateZAgenciatipoenvio () 
  {
    am.updateZAgenciatipoenvio();
  }
  
  private void updateEmbalajes () 
  {
  
    amProd.updateEmbalajes();
    
  }
  
  private void updateEmbalajesReferencia() 
  {
    amProd.updateEmbalajesReferencia();
  }
  
  public void updateRps () 
  {
    updateZAgenciatipoenvio();
    updateZTipoenvio();
    updateEmbalajes();
    updateEmbalajesReferencia();
    
  }
  
  public static void main(String[] args)
  {
    ADFGestorRps rps = new ADFGestorRps();
    
    rps.updateRps();
  }
}