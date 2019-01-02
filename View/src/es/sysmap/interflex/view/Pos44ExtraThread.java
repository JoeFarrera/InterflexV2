package es.sysmap.interflex.view;
import es.sysmap.interflex.bascula.BasculaParams;
import es.sysmap.interflex.bascula.BasculaSlo;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow;
import es.sysmap.interflex.model.dmc.common.SgamacPos44PendPesoViewRow;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import oracle.jbo.domain.Number;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import org.apache.log4j.Logger;

public class Pos44ExtraThread extends Thread implements Observer
{

  private final boolean testing = false;

   private Logger LOG = Logger.getLogger(getClass()); 
  
   private final int interval = 1000;         // Tiempo de espera (en milisegundos)
   private boolean ignore; // Set cuando ya no se necesita
   private PuestoListener listener;  // El que quiere saber la hora
   private SgamacEnPuestoViewRow macRow = null;
   private AppModule appModule = null;
   private boolean hayLecturaNueva = false;
   private BasculaSlo bascula;
   private PesadaBascula pesadaBascula = new PesadaBascula();
   private PuestoExtraInterface extraInterface;
   
   
   // TODO: Look at PesadaBascula para ver implementación
   
   

  public Pos44ExtraThread(PuestoExtraInterface extra)
  {
    extraInterface = extra;
  }
  
  private void initAppModule()
  {
    String        amDef = "es.sysmap.interflex.model.dmc.AppModule";
    String        config = "AppModuleLocal";
    appModule = (AppModule)Configuration.createRootApplicationModule(amDef,config);    
  }
  
  public synchronized void update (Observable o, Object arg)
  {
    pesadaBascula.registrarPesadaBascula((String)arg);
  }

  
   public synchronized void run () {

    try {
      
      final String  basculaSpec = "BasculaParamsSloExtra";
      ignore = false;
      initAppModule();
      ViewObject vo = appModule.findViewObject("SgamacPos44PendPesoView1");
      BasculaParams basculaParamsSlo = BasculaParams.getBasculaParams(basculaSpec);
      //TODO: Descomentar quan els ports estiguin disponibles
      if (basculaParamsSlo != null)
        bascula = new BasculaSlo(basculaParamsSlo);
      else
        {
        LOG.error("No se han trovat les dades de la báscula: " + basculaSpec);
        return;
        }
      
       bascula.addObserver(this);

       while (!isInterrupted ()) {
         // Si la pantalla de confirmación del peso está activada, no continuar
         if (PanelSgamacPos44PendPesoView1.getInstance() != null)
          if (PanelSgamacPos44PendPesoView1.getInstance().hasOperacionPendiente())
            continue;
            
         vo.clearCache();
         vo.reset();
         vo.executeQuery();
         SgamacPos44PendPesoViewRow row = (SgamacPos44PendPesoViewRow)vo.first();
         if (row != null)
         {
         
         if (row.isActiveBascula() && row.isControladaPerPes())
         {
           boolean tratado = false;
           for (int i = 0; i < 10; i++)
           {
             if (!pesadaBascula.hasRebutPes())
             {
               LOG.debug("esperando báscula...");
               wait(interval);
             }
             else
              {
                Number pesLlegit = pesadaBascula.getPesActual();
                if (row.hasCantidadDiferentSegonsPes(pesLlegit))
                 {
                    LOG.info("ordtran: " + row.getIdord() + " pes Teoric: " + row.getPesTeoric() + " pes de la báscula: " + pesLlegit);
                    extraInterface.setPanelSgamacPos44PendPesoView1();
                    PanelSgamacPos44PendPesoView1 panel = PanelSgamacPos44PendPesoView1.getInstance();
                    panel.revalidate();
                    panel.setPesTotal(pesLlegit);
                    tratado = true;
                  }
                else
                  {
                    LOG.info ("Pes llegit igual al pes teóric");
                    row.confirmarControlPes();
                    tratado = true;
                  }
                break;
              }
           }
           if (!tratado)
            {
              LOG.info("Entrada sense control de báscula per timeout");
              row.confirmarControlPes();
            }
           
         }
         else
          {
          // La báscula no está activada - enviar el palet fuera directamente...
          LOG.info("Báscula no activada: " + row.isActiveBascula() + " contenedor/existencia no conrolada por peso: " + row.isControladaPerPes());
          // para que se lo lleve
          row.confirmarControlPes();  
          }
          
         }
        wait (interval);
          
         }
 }
    catch (InterruptedException e) {
      LOG.info("This is the interrupted Exception in Timer.run() ", e);
    }
  }
  
  public synchronized void notifyThis()
  {
    notifyAll();
  }
  
  private class PesadaBascula
  {
    private Number pesLeido = new Number (0);
    private boolean leidoPeso = false;
    private static final Number zero = new Number(0);
    
    public PesadaBascula()
    {
      
    }
    
    public void registrarPesadaBascula(String pesada)
    {
      try
      {
      // Dar el peso como bueno cuando se repite
      Number pesRebut = new Number (pesada);
      // LOG.debug("Recibido pesada báscula: " + pesada);
      if (pesLeido.equals(pesRebut) && !pesRebut.equals(zero))
      {
        pesLeido = pesRebut;
        leidoPeso = true; 
        notifyThis();
      }
      else
      {
        pesLeido = pesRebut;
        leidoPeso = false;
      }
      } catch (SQLException ex)
      {
        LOG.error("registrarPesadaBascula:", ex);
      }

    }
    
    public boolean hasRebutPes()
    {
      return leidoPeso;
    }
    
    public synchronized Number getPesActual()
    {
      Number retval = null;
      if (leidoPeso)
      {
        retval = pesLeido;
        pesLeido = zero;
        leidoPeso = false;
      }
      else
        retval = zero;
      return retval;
    }
  }
  
  
  
  
  public static void main(String[] args)
  {
//    Pos44ExtraThread th = new Pos44ExtraThread();
//    th.start();
//    try 
//    {
//      Thread.sleep(1000000000);
//    } catch (Exception ex) 
//    {
//      ex.printStackTrace();
//    } finally 
//    {
//    }
//    
  }
  
  

}