package es.sysmap.interflex.view;

import es.sysmap.interflex.model.dmc.common.AppModule;

import java.awt.*;
import java.awt.Dimension;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import org.apache.log4j.Logger;

import sgalib.RowSelectResult;
import sgalib.SgaClosePanel;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaRunPanel;
import sgalib.SgaUtilPuesto;

public class MDPanelEntradesManuals extends JPanel implements JUPanel, SgaClosePanel //No interessa que extengui de SgaJUPanel
{
  private Logger LOG = Logger.getLogger(getClass());
  
  public static final String CARGA_MANUAL="MAN";

  private static MDPanelEntradesManuals _instance;
  private AppModule appModule = null;

// Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("MDPanelEntradesManualsUIModel");

// Panel layout
  private BorderLayout panelLayout = new BorderLayout();
  
  private JPanel panel = new JPanel();
  
  // Panels 'Esperant Carga...'
  private PanelEsperantCarga panelEsperantCarga = new PanelEsperantCarga(CARGA_MANUAL);

  // Panels entrades manuals amb contenidor
  private PanelSgaldocEntradesView5 panelSgaldocEntradesView5 = null;
  
  // Panels sortides manuals
  private PanelSgaresmatmanView2 panelSortides = null;

  private JScrollPane scroller = new JScrollPane();
  
  private Key key = null;
  
  private String puesto = null;
  
  /**
   * 
   *  The default constructor for panel
   */
  public MDPanelEntradesManuals()
  {
    _instance = this;
  }

  
  public static MDPanelEntradesManuals getInstance()
  {
    return _instance;
  }
  
  
  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    BindingContext _bctxSilo = panelBinding.getBindingContext();
    panelEsperantCarga.setBindingContext(_bctxSilo);

    this.setLayout(panelLayout);
    this.setSize(new Dimension(700, 600));
    this.setPreferredSize(new Dimension(700, 600));
    this.setMinimumSize(new Dimension(700, 600));
    this.setMaximumSize(new Dimension(700, 600));
    //Verifiquem les posisicions del puesto de manipulació
    AppModule appModule  = (AppModule)getPanelBinding().getApplication().getApplicationModule();   
    if (puesto == null)
      puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");

    panel.setLayout(new BorderLayout());
    panel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("OperacionsManuals.manual_label")));

    scroller.getViewport().add(panelEsperantCarga, null);
    panel.add(scroller, BorderLayout.NORTH);    

    add(panel, BorderLayout.NORTH);

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

    MDPanelEntradesManuals panel = new MDPanelEntradesManuals();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "null", panel, panel.getPanelBinding(), new Dimension(400, 300))); 
    panel.revalidate();
    
  }

  /**
   * 
   *  JUPanel implementation
   */
  public JUPanelBinding getPanelBinding()
  {
    return panelBinding;
  }


  private void unRegisterProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.unRegisterNavigationBarInterface(panelBinding, bindCtx);
  }

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(panelBinding, bindCtx);
  }

  public void setBindingContext(BindingContext bindCtx)
  {
      if (panelBinding.getPanel() == null)
      {
        panelBinding = panelBinding.setup(bindCtx, this);
        registerProjectGlobalVariables(bindCtx);
        panelBinding.refreshControl();
        try
        {
          jbInit();
          panelBinding.refreshControl();
        }
        catch(Exception ex)
        {
          panelBinding.reportException(ex);
        }
      }
  }
  

 /**
   * Un cop seleccionada l'ordre d'entrada, aquest panel permet introduir el
   * contenidor amb carga al magatzem
   */
  public void cargaNova()
  {
    try
    {
      // Seleccionem una linea d'ordre d'entrada
      RowSelectResult result = seleccionarOrdreEntrada();
      switch(result.getResult())
      {
       case 0: // Acceptar
            // Eliminem el panel actual del silo
            removeCurrentPanel();
            System.out.println("MDPanelEntradesManuals: " + System.currentTimeMillis());
            panelSgaldocEntradesView5 = new PanelSgaldocEntradesView5(result.getKeys());
            panelSgaldocEntradesView5.setBindingContext(getPanelBinding().getBindingContext());
            panelSgaldocEntradesView5.setCurrentRow(result.getKeys()[0]);
            scroller.getViewport().add(panelSgaldocEntradesView5, null);
            System.out.println("MDPanelEntradesManuals: " + System.currentTimeMillis());
            panelSgaldocEntradesView5.setFocusInicial();
            
            // refresquem la pantalla    
            revalidate();
         break;
       case 1: // Afegir detall al bulto
       case 2: // Ordre nova per entrada sense document
            
            PanelSgaTestEntradaView1 panelSgaTestEntradaView1 = new PanelSgaTestEntradaView1();
            panelSgaTestEntradaView1.setBindingContext(getPanelBinding().getBindingContext());
            panelSgaTestEntradaView1.crearTestEntrada();
            // Options
            String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };
                                
            // Informació complementaria pel titol                    
            String title = null;
            Key key = null;
            // TODO - Michael 18.11.2011 probar
            if (result.getResult() == 0 || result.getResult() == 1)
            {
              key = result.getKeys()[0];
              
              title = "Document: "  + key.getAttribute(1) + ", Embalum: " + key.getAttribute(0) +
                ", Linia: " + key.getAttribute(2);
            }
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
                    // Michael 27.05.2014. Si es puesto 0, entrarlo como puesto null
                    String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
                    if (puesto == null || puesto.equals("0"))
                      puesto = null;
                      
                    // Eliminem el panel actual del silo
                    removeCurrentPanel();
                    if (result.getResult() == 1)
                       key = ((AppModule)getPanelBinding().getApplication().getApplicationModule()).crearLiniaDetall(key, 
                                puesto, idart, cantot);
                    else 
                       key = ((AppModule)getPanelBinding().getApplication().getApplicationModule()).crearDocumentEntrada(
                                puesto, idart, cantot);
                    Key [] keys = new Key [] {key}; 
                    panelSgaldocEntradesView5 = new PanelSgaldocEntradesView5(keys);
                    panelSgaldocEntradesView5.setBindingContext(getPanelBinding().getBindingContext());
                    panelSgaldocEntradesView5.setCurrentRow(key);
                    scroller.getViewport().add(panelSgaldocEntradesView5, null);
                    panelSgaldocEntradesView5.setFocusInicial();
                    
                    // refresquem la pantalla    
                    revalidate();
                 }
                 else
                 {
                   JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Documents.errorQuantitat_label"));          
                   rollback();
                   MDPanelEntradesManuals.getInstance().esperarCarga();
                 }
                 break;
               case 1: // cancelar
               default:
                  rollback();
                  MDPanelEntradesManuals.getInstance().esperarCarga();
                break;
            }
        break;
       case 3: // cancelar
       default:
          rollback();
          MDPanelEntradesManuals.getInstance().esperarCarga();
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
   */
  public void esperarCarga()
  {
    try
    {
      // Eliminem el panel actual del silo
      removeCurrentPanel();
      panelEsperantCarga = new PanelEsperantCarga("MAN");
      panelEsperantCarga.setBindingContext(getPanelBinding().getBindingContext());
      scroller.getViewport().add(panelEsperantCarga, null);  
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
   * Mostra una pantalla per fer una sortida manual del magatzem
   */
  public void sortidesManuals()
  {
    try
    {
      // Eliminem el panel actual del silo
      removeCurrentPanel();
      panelSortides = new PanelSgaresmatmanView2();
      panelSortides.setBindingContext(getPanelBinding().getBindingContext());
      scroller.getViewport().add(panelSortides, null);  
      panelSortides.createLocatorRow(null, null);
      panelSortides.setFocusInicial();
      
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
   * @return 
   */
  private RowSelectResult seleccionarOrdreEntrada()
  {
    // createDetailBinding 
    MDPanelSgavcdocView2SgavbultoView2 panelSgavcdocView1 = new MDPanelSgavcdocView2SgavbultoView2();
    panelSgavcdocView1.setBindingContext(getPanelBinding().getBindingContext());
    panelSgavcdocView1.filtrarDocuments();
    RowSelectResult result = new RowSelectResult();
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
    result.setResult(dialogResult);
    if (dialogResult == 0 || dialogResult == 1)
    {
      // Si no s'ha seleccionat cap document i era necessari, abortem
      result.setKeys(panelSgavcdocView1.getDocumentsSeleccionat());
      if (result.getKeys() == null )
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Documents.errorSeleccio_label"));          
        result.setResult(3); // Cancelar
      }
      //TODO: No deixar seleccionar documents que estiguin finalitzats
    }
    
    panelSgavcdocView1.releasePanelBinding();
    panelSgavcdocView1 = null;
    return result;
  }


  /**
   * Elimina de la pantalla i de memoria el panel que s'esta mostrant actualment
   */
  private void removeCurrentPanel()
  {
    SgaJUPanel panelActual = (SgaJUPanel)scroller.getViewport().getComponent(0);
    panelActual.releasePanelBinding();
    scroller.getViewport().remove(0);
    panelActual = null;
  }
  
 
  private void commit()
  {
    getPanelBinding().getApplication().getApplicationModule().getTransaction().commit();
  }
  
  private void rollback()
  {
    getPanelBinding().getApplication().getApplicationModule().getTransaction().rollback();
  }
 



  

  
  //Metodes de la interfase SgaClosePanel
  
  /**
   * Tanca les bascules i els ports associats quan es tanca el panel
   */
  public void beforeClosePanel()
  {
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
        MDPanelEntradesManuals panel = new MDPanelEntradesManuals();
        _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));
        panel.setBindingContext(_runPanel.getBindingContext());
        panel.revalidate();
      }
      else
        JUMetaObjectManager.reportException(null, new Exception(SgaRecursos.getInstance().getString("Error.llocTreballNoDefinit")));
      
      return _runPanel;
      
  }
  
}