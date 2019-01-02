package es.sysmap.interflex.view;
import es.sysmap.interflex.bascula.BasculaMld;
import es.sysmap.interflex.bascula.BasculaParams;
import es.sysmap.interflex.bascula.BasculaSlo;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow;
import es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Observer;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFactory;
import oracle.adf.model.binding.DCDataControl;

import oracle.jbo.JboContext;
import oracle.jbo.Key;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.JUPanel;
import oracle.jbo.uicli.controls.JUTestFrame;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import org.apache.log4j.Logger;

import sgalib.MapObservable;
import sgalib.RowSelectResult;
import sgalib.SgaClosePanel;
import sgalib.SgaJUPanel;
import sgalib.SgaMainFrame;
import sgalib.SgaRecursos;
import sgalib.SgaRunPanel;
import sgalib.SgaUtilPuesto;

public class MDPanelOperacionsManuals extends JPanel implements JUPanel, SgaClosePanel //No interessa que extengui de SgaJUPanel
{
  private Logger LOG = Logger.getLogger(getClass());
  
  public static final String CARGA_SILO="SLO";
  public static final String CARGA_MINILOAD="MLD";

  private static MDPanelOperacionsManuals _instance;
  private AppModule appModule = null;

  // Thread per a la bascula Mld
  private BasculaMld basculaMld = null;
  // Thread per a la bascula Slo
  private BasculaSlo basculaSlo = null;

// Panel binding definition used by design time
  private JUPanelBinding panelBindingSilo = new JUPanelBinding("MDPanelOperacionsManualsUIModel");
  private JUPanelBinding panelBindingMiniLoad = new JUPanelBinding("MDPanelOperacionsManualsUIModel");

// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
  
  private JPanel panelSilo = new JPanel();
  private JPanel panelMiniLoad = new JPanel();
  
  // Panels 'Esperant Carga...'
  private PanelEsperantCarga panelEsperantCargaSilo = new PanelEsperantCarga(CARGA_SILO);
  private PanelEsperantCarga panelEsperantCargaMiniLoad = new PanelEsperantCarga(CARGA_MINILOAD);
  // Panels entrades manuals amb contenidor
  private PanelSgaldocEntradesView4 panelSgaldocEntradesView4Silo = null;
  private PanelSgaldocEntradesView4 panelSgaldocEntradesView4MiniLoad = null;
  // Panels entrades contenidors buits
  private PanelSgaTestMacView1 panelSgaTestMacView1Silo = null;
  private PanelSgaTestMacView1 panelSgaTestMacView1MiniLoad = null;
  // Panels entrades amb reserva
  private PanelSgaresmatOpManView1 panelSgaresmatOpManView1Silo = null;
  private PanelSgaresmatOpManView1 panelSgaresmatOpManView1MiniLoad = null;
  // Panels sortides amb reserva
  private PanelSgaresmatOpManView2 panelSgaresmatOpManView2Silo = null;
  private PanelSgaresmatOpManView2 panelSgaresmatOpManView2MiniLoad = null;
  // Panels contenidors sense existencies
  private PanelSgamacSenseExistenciesView3 panelSgamacSenseExistenciesView3Silo = null;
  private PanelSgamacSenseExistenciesView3 panelSgamacSenseExistenciesView3MiniLoad = null;
  // Panels contenidors sense reserva
  private PanelSgamacSenseReservaView1 panelSgamacSenseReservaView1Silo = null;
  private PanelSgamacSenseReservaView1 panelSgamacSenseReservaView1MiniLoad = null;
  // Panels contenidors multireferencia sense reserva
  private PanelSgamacMultirefSenseReservaView1 panelSgamacMultirefSenseReservaView1Silo = null;
  private PanelSgamacMultirefSenseReservaView1 panelSgamacMultirefSenseReservaView1MiniLoad = null;
  
  private JScrollPane scrollerSilo = new JScrollPane();
  private JScrollPane scrollerMiniLoad = new JScrollPane();
  
  private Key key = null;
  
  private String puesto = null;
  
  /**
   * 
   *  The default constructor for panel
   */
  public MDPanelOperacionsManuals()
  {
    _instance = this;
  }

  
  public static MDPanelOperacionsManuals getInstance()
  {
    return _instance;
  }
  
  
  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    BindingContext _bctxSilo = panelBindingSilo.getBindingContext();
    panelEsperantCargaSilo.setBindingContext(_bctxSilo);
//    BindingContext _b = panelEsperantCargaSilo.getPanelBinding().getBindingContext();
    BindingContext _bctxMiniLoad = panelBindingMiniLoad.getBindingContext();
    panelEsperantCargaMiniLoad.setBindingContext(_bctxMiniLoad);

    this.setLayout(panelLayout);
    this.setSize(new Dimension(700, 600));
    this.setPreferredSize(new Dimension(700, 600));
    this.setMinimumSize(new Dimension(700, 600));
    this.setMaximumSize(new Dimension(700, 600));
    //Verifiquem les posisicions del puesto de manipulació
    AppModule appModule  = (AppModule)getPanelBinding().getApplication().getApplicationModule();   
    if (puesto == null)
      puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    if (puesto != null && appModule.esPuestoManipulacion(puesto))
    {
      Set ubics = appModule.getUbicsPuestoManipulacion(puesto);
      if (!ubics.isEmpty())
      {
        if (ubics.size() > 0)
        {
          panelSilo.setLayout(new BorderLayout());
          panelSilo.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("OperacionsManuals.silo_label")));
  
          scrollerSilo.getViewport().add(panelEsperantCargaSilo, null);
          panelSilo.add(scrollerSilo, BorderLayout.NORTH);    
  
          add(panelSilo, BorderLayout.NORTH);
        }
        
        if (ubics.size() > 1)
        {
          panelMiniLoad.setLayout(new BorderLayout());
          panelMiniLoad.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("OperacionsManuals.miniload_label")));
      
          scrollerMiniLoad.getViewport().add(panelEsperantCargaMiniLoad, null);
          panelMiniLoad.add(scrollerMiniLoad, BorderLayout.NORTH);
          
          add(panelMiniLoad, BorderLayout.SOUTH);
        }        
        // Intentem arrancar les bascules
        quizasArrancarBasculas();
        
        // Intentem recuperar els macs que ja estan en el puesto
        buscarMacsEnPuesto();
      }
    }
  }

 
  
  public static void main(String [] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
    }

    MDPanelOperacionsManuals panel = new MDPanelOperacionsManuals();
    BindingContext mCtxSilo = JUTestFrame.startTestFrame("DataBindings.cpx", "null", panel, panel.getPanelBinding(), new Dimension(400, 300)); 

    // Com que necessitem dues transaccions independents dins del mateix panel,
    // creem un bindingcontext per aquesta segona transacció
    BindingContext mCtxMiniLoad = new BindingContext();
    HashMap map = new HashMap(4);
    map.put(DataControlFactory.APP_PARAMS_BINDING_CONTEXT, mCtxMiniLoad);
    JUMetaObjectManager.loadCpx("DataBindings.cpx", map);

    DCDataControl app = (DCDataControl)mCtxMiniLoad.get("AppModuleDataControl");
    if (app != null)
    {
       //dataControl = app;
       app.setClientApp(DCDataControl.JCLIENT);
    }
    else
    {
       mCtxMiniLoad.setClientAppType(DCDataControl.JCLIENT);
    }
    
    panel.setBindingContext(mCtxSilo, mCtxMiniLoad);    
    panel.revalidate();
    
  }

  /**
   * 
   *  JUPanel implementation
   */
  public JUPanelBinding getPanelBinding()
  {
    return panelBindingSilo;
  }

  public JUPanelBinding getPanelBinding(String tipoCarga)
  {
    if (isCargaSilo(tipoCarga))
      return panelBindingSilo;
    else
      return panelBindingMiniLoad;
  }

  private void unRegisterProjectGlobalVariables(BindingContext bindCtxSilo, BindingContext bindCtxMiniLoad)
  {
    JUUtil.unRegisterNavigationBarInterface(panelBindingSilo, bindCtxSilo);
    JUUtil.unRegisterNavigationBarInterface(panelBindingMiniLoad, bindCtxMiniLoad);
  }

  private void registerProjectGlobalVariables(BindingContext bindCtxSilo, BindingContext bindCtxMiniLoad)
  {
    JUUtil.registerNavigationBarInterface(panelBindingSilo, bindCtxSilo);
    JUUtil.registerNavigationBarInterface(panelBindingMiniLoad, bindCtxMiniLoad);
  }

  public void setBindingContext(BindingContext bindCtxSilo, BindingContext bindCtxMiniLoad)
  {
      if (panelBindingSilo.getPanel() == null || panelBindingMiniLoad.getPanel() == null)
      {
        panelBindingSilo = panelBindingSilo.setup(bindCtxSilo, this);
        panelBindingMiniLoad = panelBindingMiniLoad.setup(bindCtxMiniLoad, this);
        registerProjectGlobalVariables(bindCtxSilo, bindCtxMiniLoad);
        panelBindingSilo.refreshControl();
        panelBindingMiniLoad.refreshControl();
        try
        {
          jbInit();
          panelBindingSilo.refreshControl();
          panelBindingMiniLoad.refreshControl();
        }
        catch(Exception ex)
        {
          panelBindingSilo.reportException(ex);
        }
      }
  }
  

 /**
   * Un cop seleccionada l'ordre d'entrada, aquest panel permet introduir el
   * contenidor amb carga al magatzem
   * @param tipoCarga
   */
  public void cargaNova(String tipoCarga, String idmacEnPuesto)
  {
    try
    {
      PanelSgaldocEntradesView4 panelSgaldocEntradesView4 = null;
      // Seleccionem una linea d'ordre d'entrada
      RowSelectResult result = seleccionarOrdreEntrada(tipoCarga);
      switch(result.getResult())
      {
      // TODO Michael 18.11.2011: Should be looping here for each entrada seleccionat por lo anterior...
       case 0: // Acceptar
            // Eliminem el panel actual del silo
            removeCurrentPanel(tipoCarga);
            panelSgaldocEntradesView4 = new PanelSgaldocEntradesView4(tipoCarga, idmacEnPuesto, result.getKeys());
            // 27.12.2016 Problem is in SgaJUPanel.java panelBinding.refreshControl()
            panelSgaldocEntradesView4.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
            panelSgaldocEntradesView4.setCurrentRow(result.getKeys()[0]);
            if (isCargaSilo(tipoCarga))
            { 
              panelSgaldocEntradesView4Silo = panelSgaldocEntradesView4;
              scrollerSilo.getViewport().add(panelSgaldocEntradesView4Silo, null);
              // Michael 09.10.2006 puede ser null
              if (basculaSlo != null)
                basculaSlo.addObserver(panelSgaldocEntradesView4Silo);
            }
            else
            {
              panelSgaldocEntradesView4MiniLoad = panelSgaldocEntradesView4;
              scrollerMiniLoad.getViewport().add(panelSgaldocEntradesView4MiniLoad, null);
              basculaMld.addObserver(panelSgaldocEntradesView4MiniLoad);
            }
            panelSgaldocEntradesView4.setFocusInicial();
            
            // refresquem la pantalla    
            revalidate();
         break;
       case 1: // Afegir detall al bulto
       case 2: // Ordre nova per entrada sense document
            PanelSgaTestEntradaView1 panelSgaTestEntradaView1 = new PanelSgaTestEntradaView1();
            panelSgaTestEntradaView1.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
            panelSgaTestEntradaView1.crearTestEntrada();
            // Options
            String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };
                                
            // Informació complementaria pel titol                    
            String title = null;
            if (result.getResult() == 1)
              title = "Document: "  + result.getKeys()[0].getAttribute(1) + ", Embalum: " + result.getKeys()[0].getAttribute(0) +
                ", Linia: " + result.getKeys()[0].getAttribute(2);
            else 
              title = SgaRecursos.getInstance().getString("Documents.sensedoc_label");
            // Fi informació complementaria titol
            
            int result2 = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                panelSgaTestEntradaView1,                                    // the dialog message array
                title, // the title of the dialog window
                JOptionPane.DEFAULT_OPTION,                 // option type
                JOptionPane.PLAIN_MESSAGE,            // message type
                null,                                       // optional icon, use null to use the default icon
                options2,                                    // options string array, will be made into buttons
                null                                        // option that should be made into a default button
            );
            String idart = panelSgaTestEntradaView1.getIdart();
            Number cantot = panelSgaTestEntradaView1.getCantot();
           
            panelSgaTestEntradaView1.releasePanelBinding();
            panelSgaTestEntradaView1 = null;
  
            switch(result2) {
               case 0: // Acceptar
                 
                 if (idart != null && cantot.compareTo(0) > 0)
                 {
                    // Eliminem el panel actual del silo
                    removeCurrentPanel(tipoCarga);
                    if (result.getResult() == 1)
                       key = ((AppModule)getPanelBinding(tipoCarga).getApplication().getApplicationModule()).crearLiniaDetall(result.getKeys()[0], 
                                SgaUtilPuesto.getInstance().getProperty("LlocTreball"), idart, cantot);
                    else 
                       key = ((AppModule)getPanelBinding(tipoCarga).getApplication().getApplicationModule()).crearDocumentEntrada(
                                SgaUtilPuesto.getInstance().getProperty("LlocTreball"), idart, cantot);
                    
                    // TODO Michael 21.11.2011            
                    Key [] keys = new Key [] {key};
                    
                    panelSgaldocEntradesView4 = new PanelSgaldocEntradesView4(tipoCarga, idmacEnPuesto, keys);
                    panelSgaldocEntradesView4.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
                    panelSgaldocEntradesView4.setCurrentRow(keys [0]);

                    if (isCargaSilo(tipoCarga))
                    { 
                      panelSgaldocEntradesView4Silo = panelSgaldocEntradesView4;
                      scrollerSilo.getViewport().add(panelSgaldocEntradesView4Silo, null);
                      // Michael 09.10.2006 puede ser null
                      if (basculaSlo != null)
                        basculaSlo.addObserver(panelSgaldocEntradesView4Silo);
                    }
                    else
                    {
                      panelSgaldocEntradesView4MiniLoad = panelSgaldocEntradesView4;
                      scrollerMiniLoad.getViewport().add(panelSgaldocEntradesView4MiniLoad, null);
                      basculaMld.addObserver(panelSgaldocEntradesView4MiniLoad);
                    }
                    panelSgaldocEntradesView4.setFocusInicial();
                    
                    // refresquem la pantalla    
                    revalidate();
                 }
                 else
                 {
                   JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Documents.errorQuantitat_label"));          
                   rollback(tipoCarga);
                   MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(idmacEnPuesto, tipoCarga, true);
                 }
                 break;
               case 1: // cancelar
               default:
                  rollback(tipoCarga);
                  // Michael 19.12.2005 TODO Comprobar
                  // era: MDPanelOperacionsManuals.getInstance().esperarCarga(tipoCarga);
                  if (idmacEnPuesto != null)
                    MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(idmacEnPuesto, tipoCarga, true);
                  else
                    MDPanelOperacionsManuals.getInstance().esperarCarga(tipoCarga);
                break;
            }
        break;
       case 3: // cancelar
       default:
          rollback(tipoCarga);
          // Michael 19.12.2005 TODO Comprobar
          // era: MDPanelOperacionsManuals.getInstance().esperarCarga(tipoCarga);
          if (idmacEnPuesto != null)
            MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(idmacEnPuesto, tipoCarga, true);
          else
            MDPanelOperacionsManuals.getInstance().esperarCarga(tipoCarga);
         break;
      }
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Mostra una pantalla que no fa res i que esta activa sempre que no hi ha feina
   * al puesto
   * @param tipoCarga
   */
  public void esperarCarga(String tipoCarga)
  {
    try
    {
      // Eliminem el panel actual del silo
      removeCurrentPanel(tipoCarga);
      PanelEsperantCarga panelEsperantCarga = new PanelEsperantCarga(tipoCarga);
      panelEsperantCarga.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
      if (isCargaSilo(tipoCarga))
      {
        panelEsperantCargaSilo = panelEsperantCarga;
        scrollerSilo.getViewport().add(panelEsperantCarga, null);  
      }
      else
      {
        panelEsperantCargaMiniLoad = panelEsperantCarga;
        scrollerMiniLoad.getViewport().add(panelEsperantCargaMiniLoad, null);  
      }
      panelEsperantCarga.setFocusInicial();
      
      // refresquem la pantalla    
      revalidate();
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }

  }
  
  
  /**
   * Mostra un panel que permet fer una entrada de contenidor buit al magatzem
   */
  public void contenidorBuit(String tipoCarga)
  {
    try
    {
      PanelSgaTestMacView1 panelSgaTestMacView1 = null;
      // Eliminem el panel actual del silo
      removeCurrentPanel(tipoCarga);
      panelSgaTestMacView1 = new PanelSgaTestMacView1(tipoCarga);      
      panelSgaTestMacView1.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
      panelSgaTestMacView1.crearTestMac();
      //panelSgaldocEntradesView4.setCurrentRow(key);
      if (isCargaSilo(tipoCarga))
      { 
        panelSgaTestMacView1Silo = panelSgaTestMacView1;
        scrollerSilo.getViewport().add(panelSgaTestMacView1Silo, null);
      }
      else
      {
        panelSgaTestMacView1MiniLoad = panelSgaTestMacView1;
        scrollerMiniLoad.getViewport().add(panelSgaTestMacView1MiniLoad, null);
      }
      panelSgaTestMacView1.setFocusInicial();
     
      // refresquem la pantalla    
      revalidate();
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Mostra un panel que permet fer una entrada amb reserva al magatzem
   */
  public void entradaReservada(Key key, String tipoCarga)
  {
    try
    {
     PanelSgaresmatOpManView1 panelSgaresmatOpManView1 = null;
      // Eliminem el panel actual del silo
      removeCurrentPanel(tipoCarga);
      panelSgaresmatOpManView1 = new PanelSgaresmatOpManView1(tipoCarga);      
      panelSgaresmatOpManView1.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
      panelSgaresmatOpManView1.setCurrentRow(key);
      if (isCargaSilo(tipoCarga))
      { 
        panelSgaresmatOpManView1Silo = panelSgaresmatOpManView1;
        scrollerSilo.getViewport().add(panelSgaresmatOpManView1Silo, null);
        // Michael 09.10.2006 puede ser null
        if (basculaSlo != null)
          basculaSlo.addObserver(panelSgaresmatOpManView1Silo);
      }
      else
      {
        panelSgaresmatOpManView1MiniLoad = panelSgaresmatOpManView1;
        scrollerMiniLoad.getViewport().add(panelSgaresmatOpManView1MiniLoad, null);
        basculaMld.addObserver(panelSgaresmatOpManView1MiniLoad);
      }
      panelSgaresmatOpManView1.setFocusInicial();
     
      // refresquem la pantalla    
      revalidate();
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }
  }



  /**
   * Mostra un panel que permet fer una sortida amb reserva al magatzem
   */
  public void sortidaReservada(Key key, String tipoCarga)
  {
    try
    {
     PanelSgaresmatOpManView2 panelSgaresmatOpManView2 = null;
      // Eliminem el panel actual del silo
      removeCurrentPanel(tipoCarga);
      panelSgaresmatOpManView2 = new PanelSgaresmatOpManView2(tipoCarga);      
      panelSgaresmatOpManView2.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
      panelSgaresmatOpManView2.setCurrentRow(key);
      if (isCargaSilo(tipoCarga))
      { 
        panelSgaresmatOpManView2Silo = panelSgaresmatOpManView2;
        scrollerSilo.getViewport().add(panelSgaresmatOpManView2Silo, null);
        // Michael 09.10.2006 puede ser null
        if (basculaSlo != null)
          basculaSlo.addObserver(panelSgaresmatOpManView2Silo);
      } 
      else
      {
        panelSgaresmatOpManView2MiniLoad = panelSgaresmatOpManView2;
        scrollerMiniLoad.getViewport().add(panelSgaresmatOpManView2MiniLoad, null);
        basculaMld.addObserver(panelSgaresmatOpManView2MiniLoad);
      }
      panelSgaresmatOpManView2.setFocusInicial();
     
      // refresquem la pantalla    
      revalidate();
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }
  }

  //Xavi, 30/08/05: Afegit synchronized
  //public void identificarOperacioMacEnPuesto(String macEnPuesto, String tipoCarga, boolean manipular)
  public synchronized void identificarOperacioMacEnPuesto(String macEnPuesto, String tipoCarga, boolean manipular)
  {
    try
    {
      AppModule appModule  = (AppModule)getPanelBinding(tipoCarga).getApplication().getApplicationModule();
      SgaresmatOpManViewRow resmat = appModule.identificarOperacioMacEnPuesto(macEnPuesto);
      if (resmat != null)
      {
        if (resmat.isEntrada())
        {
          // Activem pantalla d'entrades
          entradaReservada(resmat.getKey(), tipoCarga);
        }
        else
        {
          // Activem pantalla de sortides
          sortidaReservada(resmat.getKey(), tipoCarga);
        }
      }
      else // No hi ha cap reserva associada, per tant, es una manipulació del contenidor
      {
        // Si es permet manipular el mac, obrim la pantalla de manipulacions
        if (manipular)
        {
          Object [] obj = {macEnPuesto};
          int numExistencies = appModule.contenidorAmbExistencies(macEnPuesto);
          switch(numExistencies)
          {
            case 0: // Contenidor sense existències
              contenidorSenseExistencies(new Key(obj), tipoCarga);
              break;
            case 1: // Contenidor amb una existencia
              contenidorSenseReserva(macEnPuesto, tipoCarga);
              break;
            default: // Contenidor multireferencia
              contenidorSenseReservaMultireferencia(macEnPuesto, tipoCarga);
          }
        }
        else
        {
          if (puesto == null)
            puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
          // Intentem retirar el contenidor
          appModule.quizasRetirarMac(puesto, macEnPuesto);
          esperarCarga(tipoCarga); 
        }
      }
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }

  }


  /**
   * Mostra un panel que permet actualitzar un contenidor amb una sola existencia sense reserva
   */
  public void contenidorSenseReserva(String idmac, String tipoCarga)
  {
    try
    {
      PanelSgamacSenseReservaView1 panelSgamacSenseReservaView1 = null;
      // Eliminem el panel actual del silo
      removeCurrentPanel(tipoCarga);
      panelSgamacSenseReservaView1 = new PanelSgamacSenseReservaView1(tipoCarga);      
      panelSgamacSenseReservaView1.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
      panelSgamacSenseReservaView1.setCurrentRow(idmac);
      if (isCargaSilo(tipoCarga))
      { 
        panelSgamacSenseReservaView1Silo = panelSgamacSenseReservaView1;
        scrollerSilo.getViewport().add(panelSgamacSenseReservaView1Silo, null);
        // Michael 09.10.2006 puede ser null
        if (basculaSlo != null)
          basculaSlo.addObserver(panelSgamacSenseReservaView1Silo);
      }
      else
      {
        panelSgamacSenseReservaView1MiniLoad = panelSgamacSenseReservaView1;
        scrollerMiniLoad.getViewport().add(panelSgamacSenseReservaView1MiniLoad, null);
        basculaMld.addObserver(panelSgamacSenseReservaView1MiniLoad);
      }
      panelSgamacSenseReservaView1.setFocusInicial();
     
      // refresquem la pantalla    
      revalidate();
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Mostra un panel que permet actualitzar un contenidor sense existències
   */
  public void contenidorSenseExistencies(Key key, String tipoCarga)
  {
    try
    {
      PanelSgamacSenseExistenciesView3 panelSgamacSenseExistenciesView3 = null;
      // Eliminem el panel actual del silo
      removeCurrentPanel(tipoCarga);
      panelSgamacSenseExistenciesView3 = new PanelSgamacSenseExistenciesView3(tipoCarga);   
      // TODO 16.06.2017 Michael - this is what takes time. #SLOW
      panelSgamacSenseExistenciesView3.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
      panelSgamacSenseExistenciesView3.setCurrentRow(key);
      if (isCargaSilo(tipoCarga))
      { 
        panelSgamacSenseExistenciesView3Silo = panelSgamacSenseExistenciesView3;
        scrollerSilo.getViewport().add(panelSgamacSenseExistenciesView3Silo, null);
        //basculaSlo.addObserver(panelSgamacSenseExistenciesView3Silo);
      }
      else
      {
        panelSgamacSenseExistenciesView3MiniLoad = panelSgamacSenseExistenciesView3;
        scrollerMiniLoad.getViewport().add(panelSgamacSenseExistenciesView3MiniLoad, null);
        //basculaMld.addObserver(panelSgamacSenseExistenciesView3MiniLoad);
      }
      panelSgamacSenseExistenciesView3.setFocusInicial();
     
      // refresquem la pantalla    
      revalidate();
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }
  }

  /**
   * Mostra un panel que permet actualitzar un contenidor multireferencia sense reserva
   */
   //TODO: Falta implementar-ho; ara porta al mateix panel que una referencia
  public void contenidorSenseReservaMultireferencia(String macEnPuesto, String tipoCarga)
  {
    try
    {
      PanelSgamacMultirefSenseReservaView1 panelSgamacMultirefSenseReservaView1 = null;
      // Eliminem el panel actual del silo
      removeCurrentPanel(tipoCarga);
      panelSgamacMultirefSenseReservaView1 = new PanelSgamacMultirefSenseReservaView1(tipoCarga);      
      panelSgamacMultirefSenseReservaView1.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
      panelSgamacMultirefSenseReservaView1.setCurrentRow(macEnPuesto);
      if (isCargaSilo(tipoCarga))
      { 
        panelSgamacMultirefSenseReservaView1Silo = panelSgamacMultirefSenseReservaView1;
        scrollerSilo.getViewport().add(panelSgamacMultirefSenseReservaView1Silo, null);
        // Michael 09.10.2006 puede ser null
        if (basculaSlo != null)
          basculaSlo.addObserver(panelSgamacMultirefSenseReservaView1Silo);
      }
      else
      {
        panelSgamacMultirefSenseReservaView1MiniLoad = panelSgamacMultirefSenseReservaView1;
        scrollerMiniLoad.getViewport().add(panelSgamacMultirefSenseReservaView1MiniLoad, null);
        basculaMld.addObserver(panelSgamacMultirefSenseReservaView1MiniLoad);
      }
      panelSgamacMultirefSenseReservaView1.setFocusInicial();
     
      // refresquem la pantalla    
      revalidate();
    }
    catch(Exception ex)
    {
       JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  /**
   * Permet seleccionar una ordre d'entrada per introduir un contenedor de forma
   * manual
   * @return keys: Array de les linies seleccionades (keys)
   * @param tipoCarga
   */
  private RowSelectResult seleccionarOrdreEntrada(String tipoCarga)
  {
     
    RowSelectResult result = new RowSelectResult();
    // createDetailBinding
    MDPanelSgavcdocView2SgavbultoView2 panelSgavcdocView1 = new MDPanelSgavcdocView2SgavbultoView2();
    panelSgavcdocView1.setBindingContext(getPanelBinding(tipoCarga).getBindingContext());
    panelSgavcdocView1.filtrarDocuments();
    // Options
    String[] options = {SgaRecursos.getInstance().getString("Documents.seleccionar_label"),
                        SgaRecursos.getInstance().getString("Documents.afegir_label"),
                        SgaRecursos.getInstance().getString("Documents.sensedoc_label"),
                        SgaRecursos.getInstance().getString("Documents.cancelar_label") };
    int dialogResult = JOptionPane.showOptionDialog(
        Interflex.getInstance(),                                       // the parent that the dialog blocks
        panelSgavcdocView1,                                    // the dialog message array
        SgaRecursos.getInstance().getString("Documents.entrades_label"), // the title of the dialog window
        JOptionPane.DEFAULT_OPTION,                 // option type
        JOptionPane.PLAIN_MESSAGE,            // message type
        null,                                       // optional icon, use null to use the default icon
        options,                                    // options string array, will be made into buttons
        null                                        // option that should be made into a default button
    );
    
    if (dialogResult == 0 || dialogResult == 1)
    {
      // Si no s'ha seleccionat cap document i era necessari, abortem
      Key [] keys = panelSgavcdocView1.getDocumentsSeleccionat();
      if (keys == null )
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Documents.errorSeleccio_label"));          
        dialogResult = 3; // Cancelar
      }
      else 
      {
        result.setKeys(keys);
      }
      //TODO: No deixar seleccionar documents que estiguin finalitzats
    }
    
    panelSgavcdocView1.releasePanelBinding();
    panelSgavcdocView1 = null;
    result.setResult(dialogResult);
    return result;
  }


  /**
   * Elimina de la pantalla i de memoria el panel que s'esta mostrant actualment
   * @param tipoCarga
   */
  private void removeCurrentPanel(String tipoCarga)
  {
    JScrollPane scroller = null;
    MapObservable bascula = null;
    
    if (isCargaSilo(tipoCarga))
    {
      scroller = scrollerSilo;
      bascula = basculaSlo;
    }
    else
    {
      scroller = scrollerMiniLoad;
      bascula = basculaMld;
    }
    SgaJUPanel panelActual = (SgaJUPanel)scroller.getViewport().getComponent(0);
    panelActual.releasePanelBinding();
    if (panelActual instanceof Observer)
      bascula.deleteObserver((Observer)panelActual);
    scroller.getViewport().remove(0);
    panelActual = null;
  }
  
 
  private void commit(String tipoCarga)
  {
    getPanelBinding(tipoCarga).getApplication().getApplicationModule().getTransaction().commit();
  }
  
  private void rollback(String tipoCarga)
  {
    getPanelBinding(tipoCarga).getApplication().getApplicationModule().getTransaction().rollback();
  }
 
  private boolean isCargaSilo(String tipoCarga)
  {
    if (tipoCarga.equals(CARGA_SILO))
     return true;
    return false;
  }
 

  /**
   * Si el puesto actual es un puesto de manipulació, inicia 
   * les bascules
   */
  private void quizasArrancarBasculas()
  {
    if (puesto == null)
      puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    AppModule appModule  = (AppModule)getPanelBinding().getApplication().getApplicationModule();      
    if (puesto != null  && appModule.esPuestoManipulacion(puesto))
    {
      BasculaParams basculaParamsMld = BasculaParams.getBasculaParams("BasculaParamsMld");
      //TODO: Descomentar quan els ports estiguin disponibles
      if (basculaParamsMld != null);
        basculaMld = new BasculaMld(basculaParamsMld);
        
      BasculaParams basculaParamsSlo = BasculaParams.getBasculaParams("BasculaParamsSlo");
      //TODO: Descomentar quan els ports estiguin disponibles
      if (basculaParamsSlo != null);
        basculaSlo = new BasculaSlo(basculaParamsSlo);
    }  
  }


  /**
   * Si el puesto actual es un puesto de manipulació, para les bascules
   */
  private void quizasPararBasculas()
  {
    if (basculaMld != null)
      basculaMld.closePort();
    if (basculaSlo != null)
      basculaSlo.closePort();
  }


 /**
   * Si s'arranca el panel per primer cop, verifica si ja hi ha algun mac al
   * puesto amb estat "P", i en mostra l'operació a fer
   */
   
  public void buscarMacsEnPuesto()
  {
    String ubicsWhereClause = "";
    AppModule appModule  = (AppModule)getPanelBinding().getApplication().getApplicationModule();   
    if (puesto == null)
      puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    if (puesto != null && appModule.esPuestoManipulacion(puesto))
    {
      Set ubics = appModule.getUbicsPuestoManipulacion(puesto);
      if (!ubics.isEmpty())
      {
        // contruim la clausula where
        Iterator iter = ubics.iterator();
        int i = 0;
        while (iter.hasNext())
        {
          if (i > 0)
            ubicsWhereClause = ubicsWhereClause.concat(",");
          ubicsWhereClause = ubicsWhereClause.concat("'").concat((String)iter.next()).concat("'");
          i++;
        }
      
          RowSet rowSet = appModule.macsEnPuesto(ubicsWhereClause, "P");
          rowSet.reset();
          while (rowSet.hasNext())
          {
            SgamacEnPuestoViewRow macEnPuesto = (SgamacEnPuestoViewRow)rowSet.next();
            identificarOperacioMacEnPuesto(macEnPuesto.getIdmac(), macEnPuesto.getTipocarga(), true);
          }
      }
    }  
  }

  // Aquests dos metodes permeten enviar pesos introduits de forma manual al 
  // panel corresponent
  public void setPesMld(String pesMld)
  {
    basculaMld.setPesMld(pesMld);
  }

  public void setPesSlo(String pesSlo)
  {
    basculaSlo.setPesSlo(pesSlo);
  }
  
  //Metodes de la interfase SgaClosePanel
  
  /**
   * Tanca les bascules i els ports associats quan es tanca el panel
   */
  public void beforeClosePanel()
  {
    // Intentem parar les bascules
    quizasPararBasculas();
    //
    _instance = null;
  }
  
  // Fi metodes de la interfase SgaClosePanel

  static SgaRunPanel runPanel()
  {
      SgaRunPanel _runPanel = null;

      // Verifiquem que existeixi la propietat 'LlocTreball' definida en el fitxer
      // de propietats del pc. Si no, no deixem instanciar el panel
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      if (puesto != null)
      {
        MDPanelOperacionsManuals panel = new MDPanelOperacionsManuals();
        _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));

        // Com que necessitem dues transaccions independents dins del mateix panel,
        // creem un bindingcontext per aquesta segona transacció
        BindingContext mCtxMiniLoad = new BindingContext();
        HashMap map = new HashMap(4);
        map.put(DataControlFactory.APP_PARAMS_BINDING_CONTEXT, mCtxMiniLoad);
        JUMetaObjectManager.loadCpx("DataBindings.cpx", map);
  
        DCDataControl app = (DCDataControl)mCtxMiniLoad.get("AppModuleDataControl");
        if (app != null)
        {
           //dataControl = app;
           app.setClientApp(DCDataControl.JCLIENT);
        }
        else
        {
           mCtxMiniLoad.setClientAppType(DCDataControl.JCLIENT);
        }
        panel.panelBindingMiniLoad = panel.panelBindingMiniLoad.setup(mCtxMiniLoad, null);

        // Agafem l'usuari de l'aplicació del modul principal
        Hashtable h = app.getApplicationModule().getSession().getEnvironment();
        h.put(JboContext.SECURITY_PRINCIPAL, SgaMainFrame.getInstance().getCurrentUser());
        h.put(JboContext.SECURITY_CREDENTIALS, SgaMainFrame.getInstance().getCurrentPassword());
        // Fem que per defecte la transacció tingui activat clearCacheOnCommit()
        app.getApplicationModule().getTransaction().setClearCacheOnCommit(true);
        
        // Fi de la creació del segon binding context
        
        panel.setBindingContext(_runPanel.getBindingContext(), mCtxMiniLoad);
        panel.revalidate();
      }
      else
        JUMetaObjectManager.reportException(null, new Exception(SgaRecursos.getInstance().getString("Error.llocTreballNoDefinit")));
      
      return _runPanel;
      
  }
  
}