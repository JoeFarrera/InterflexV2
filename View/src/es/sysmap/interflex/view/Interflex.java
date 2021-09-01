package es.sysmap.interflex.view;

import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow;
import es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import java.util.Properties;
import java.util.Set;

import javax.swing.*;

import oracle.jbo.ConnectionMetadata;
import oracle.jbo.RowInconsistentException;
import oracle.jbo.client.Configuration;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jbo.domain.Number;


import org.apache.log4j.Logger;

import sgalib.*;
//import es.sysmap.interflex.model.dmc.common.AppModule1;

// Aquests imports depenen de cada instal.laciï¿½

public class Interflex extends SgaMainFrame implements PuestoListener, PuestoExtraInterface
// public class Interflex extends JFrame implements PuestoListener, PuestoExtraInterface
{
  private Logger LOG = Logger.getLogger(getClass());
  
  // Application module principal
  private static AppModule appModule = null;
  // Application module de test
//  private static AppModule1 appModule1 = null;
  
  private static Interflex interflex = null;

  // Thread pel puesto
  private PuestoThread puestoThread = null;
  private Pos44ExtraThread pos44extraThread;
  
  // Lloc de treball associat al puesto
  private String puesto = null;
  
  JTextField numLiniesSortida = null;

  //Constructor per defecte
  
  public Interflex (String [] args)
  {
    super(args);
    interflex = this;
  }
  

   public static Interflex getInterflexInstance()
   {
      return interflex;
   }
  
  public void jbInit() throws Exception
  {
    super.jbInit();
    // Si es vol modificar l'aspecte de l'aplicaciï¿½ generica, aquï¿½ seria
    // el lloc adequat

    // Si es un puesto de treball, arranquem el thread del puesto
    quizasArrancarPuestoThread();

    setTitle();        
    
        
    
  }
  
  public void setTitle() 
  {
    super.setTitle(SgaRecursos.getInstance().getString("Frame.subtitle_puesto") +  getPuesto() + " - " + this.getTitle());
  }
  
// Si volguessim afegir menï¿½s a la barra de menus, ho fariem aquï¿½
  public void createUserMenu()
  {
    //JMenu menuTest = new JMenu();
    //createMenu(menuTest, "MenuHelp.help_label", "MenuHelp.help_mnemonic");
    
    //createMenuItem(menuTest, "MenuHelp.contents_label", "MenuHelp.contents_mnemonic", null);
  }


  // Modifiquem l'acciï¿½ de sortida perque es pari el thread que busca feina si
  // es tracta d'un puesto de manipulaciï¿½
  
  public void user_file_exit_action()
  {
    quizasPararPuestoThread(false);
    
  }
  
  
  public static void main(String [] args)
  {
    try
    { 
//    UIManager.LookAndFeelInfo info[] = UIManager.getInstalledLookAndFeels();
//      for( int i = 0; i < info.length; i++ ) {
//         UIManager.LookAndFeelInfo lookAndFeelInfo = info[i];
//         System.out.println( lookAndFeelInfo );
//      }
      // 2018.12.17: Windows LookAndFeel has some defects on servidorsga
      Properties properties = System.getProperties();
      String lookAndFeel = SgaUtilPuesto.getInstance().getProperty("LookAndFeel");
      if (lookAndFeel != null)
        UIManager.setLookAndFeel(lookAndFeel);
        else
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      // 2021 for testing from jdev use:
      // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
      // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
      // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows");
      // Augmenta el tamany de totes les fonts utilitzades
      Interflex.setUIFont(2);
      //Intentem fixar algunes java options necessaries per stylereportpro
      
      String value = SgaUtilPuesto.getInstance().getProperty("uql.home");
      if (value != null)
        properties.setProperty("uql.home", value);
      value = SgaUtilPuesto.getInstance().getProperty("query.registry.path");
      if (value != null)
        properties.setProperty("query.registry.path", value);
      value = SgaUtilPuesto.getInstance().getProperty("datasource.registry.path");
      if (value != null)
        properties.setProperty("datasource.registry.path", value);
   }
    catch(Exception exemp)
    {
      System.out.println("Interflex main Exception: " + exemp.toString());
      exemp.printStackTrace();
    }
    
    try
    {
      //Instanciem la classe SgaMainFrame
      interflex = new Interflex(args);
      
      // Establim development = true
      // TODO: Treure-ho abans de fer el deployment definitiu
      interflex.setDevelopment(true);

      // Establim el nostre propi tractament d'errors
      JUMetaObjectManager.setErrorHandler(new SgaJUErrorHandler());

      //Instanciem el application module de l'aplicaciï¿½
      String        amDef = "es.sysmap.interflex.model.dmc.AppModule";
      String        config = "AppModuleLocal";
      appModule = (AppModule)Configuration.createRootApplicationModule(amDef,config);
      // TODO: Establim el tractament de les excepcions de l'appModule
      //appModule.setExceptionHandler();
      interflex.setAppModule(appModule);
      ConnectionMetadata data = appModule.getTransaction().getConnectionMetadata();
      
      interflex.setDatabaseUser(data.getUserName());
      
      // Verifiquem l'usuari
      SgaJCLoginDialog loginDialog = new SgaJCLoginDialog("SGA (" + data.getJdbcURL() + " -> " + interflex.getDatabaseUser() + ")");
      
      if (!loginDialog.popupDialog())
        System.exit(1);
      if (!interflex.checkUser(loginDialog.getUsuari(), loginDialog.getPassword()))
        {
        JOptionPane.showMessageDialog(null, SgaRecursos.getInstance().getString("Login.error_message"), 
              SgaRecursos.getInstance().getString("Login.error_title"), JOptionPane.WARNING_MESSAGE);
        System.exit(1);
        }
      else
      {
        // Si tot es correcte, inicialitzem l'aplicaciï¿½ i mostrem el frame
        interflex.jbInit();
        interflex.setVisible(true);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
      System.exit(1);
    }

  }
  
  
 
  
  
  /**
   * Cercar el puesto en el fitxer de propietats.
   * Si hi ha una definició de puesto de proves: fem servir aquest. 
   * Si no, fem servir la definitiva 
   */
  public String getPuesto () 
  {
    if (puesto == null)
    {
      if (getDatabaseUser().equals("ifdbatest"))
      {  
        puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreballPruebas");
        if (puesto == null)
          puesto = "0";
      }
      else
        if (puesto == null)
          puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      }
    
    return puesto;

  }
  
  /**
   * Si el puesto actual es un puesto de manipulaciï¿½, arranca el thread
   * PuestoThread
   */
  private void quizasArrancarPuestoThread()
  {
    
    if (getPuesto() != null && appModule.esPuestoManipulacion(getPuesto()))
    {
      Set ubics = appModule.getUbicsPuestoManipulacion(getPuesto());
      if (!ubics.isEmpty())
      {
        // Obrim el puesto
        // Xavi, 28/04/05: No activem automaticament el puesto
        //appModule.setEstatPuesto(puesto, "A");
        
        //puestoThread = new PuestoThread(this, ubics, appModule, 10000);
        puestoThread = new PuestoThread(this, ubics, appModule, 5000, getPuesto());
        // Afegim els botons corresponents a manipulaciï¿½ a la barra de botons
        afegirBoto(new EvacuarMacAction());
        afegirBoto(new SortidesAutoAction());
        afegirBoto(new ActivitatPuestoAction());
        // S'haurien de treure al acabar de fer probes
        afegirBoto(new BasculaMldAction());
        afegirBoto(new BasculaSloAction());
        // Botons per regular la capacitat dels pulmons del silo i miniload
        afegirBoto(new CapacitatAction(false));
        afegirBoto(new CapacitatAction(true));
        
        /* Michael 11.02.1014 afegir total línies obertes MAXI en el puesto */
        JPanel pane = new JPanel(new GridLayout());
        JPanel outerPane = new JPanel(new BorderLayout());
        outerPane.add(pane, BorderLayout.EAST);
        outerPane.add(new JPanel(), BorderLayout.CENTER);
        
        JLabel label = new JLabel("Línies Sortides obertes MAXI: ");
        numLiniesSortida = new JTextField ();
        
        pane.add(label);
        pane.add(numLiniesSortida);
        numLiniesSortida.setEnabled(false);
       

        numLiniesSortida.setMaximumSize(new Dimension(30, 26));
        addComponent(outerPane);
        // Michael TODO 11.02.2014 finish above!!!
        
        
        
        
      }
    // Michael 10.10.2006 Si es el EXTRA, arrancar
    // TODO Comentado antes de acabar pruebas
    if (appModule.esPuestoExtraPicking(getPuesto()))
      {
        pos44extraThread = new Pos44ExtraThread(this);
        pos44extraThread.start();
        
      }
    }
    
  }


  /**
   * Si el puesto actual es un puesto de manipulaciï¿½, para el thread
   * PuestoThread
   */
  private void quizasPararPuestoThread(boolean terminarEnCurso)
  {
    if (getPuesto() != null)
    {
        // Michael 02.12.2005 TODO estaba duplicado ?? appModule.setEstatPuesto(puesto, "C");
        while (true)
        {
          try
          {
            // Xavi, 25/04/05: Forcem la deshabilitaciï¿½ de les sortides automatiques quan es tanca el puesto,
            // de manera que al tornar-lo a obrir, caldra activar-lo de nou.
            appModule.setAutoSortides(getPuesto(), "N");
            // Xavi, 28/04/05: Forcem la deshabilitaciï¿½ del puesto quan es tanca el puesto,
            // de manera que al tornar-lo a obrir, caldra activar-lo de nou.
            appModule.setEstatPuesto(getPuesto(), "C");
            
            if (puestoThread != null)
              puestoThread.interrupt();
              
            // Michael 10.10.2006
            if (pos44extraThread != null)
              pos44extraThread.interrupt();
  
            break;
          }
          catch (RowInconsistentException rex)
          {
            continue;
          }
        }
    }
  }  



  /**
   * Activa o desactiva la evacuaciï¿½ automï¿½tica de macs
   */

  class EvacuarMacAction extends AbstractAction
  {

    private String tooltipEvacuar = SgaRecursos.getInstance().getString("EvacuarMac.evacuar_tooltip");
    private String tooltipNoEvacuar = SgaRecursos.getInstance().getString("EvacuarMac.noEvacuar_tooltip");
    private Icon iconEvacuar = SgaRecursos.createImageIcon(getClass(),"evacuarmac.gif", null);
    private Icon iconNoEvacuar = SgaRecursos.createImageIcon(getClass(),"noevacuarmac.gif", null);

    /**
     * Constructor
     */

    protected EvacuarMacAction()
    {
      super();
      
      String retirarMac = appModule.getRetirarMac(getPuesto());
      if (retirarMac != null && retirarMac.equals("S"))
      {
        putValue(Action.SMALL_ICON, iconEvacuar );
        putValue(Action.SHORT_DESCRIPTION, tooltipEvacuar);
      }
      else
      {
        putValue(Action.SMALL_ICON, iconNoEvacuar );
        putValue(Action.SHORT_DESCRIPTION, tooltipNoEvacuar);
      }
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      if (appModule.getRetirarMac(getPuesto()).equals("S"))
      {
        appModule.setRetirarMac(getPuesto(), "N");
        putValue(Action.SMALL_ICON, iconNoEvacuar );
        putValue(Action.SHORT_DESCRIPTION, tooltipNoEvacuar);
      }
      else
      {
        appModule.setRetirarMac(getPuesto(), "S");
        putValue(Action.SMALL_ICON, iconEvacuar );
        putValue(Action.SHORT_DESCRIPTION, tooltipEvacuar);
      }
    }
  }


  /**
   * Activa o desactiva la reserva automï¿½tica d'ordres de sortida
   */

  class SortidesAutoAction extends AbstractAction
  {

    private String tooltipAutoSortides = SgaRecursos.getInstance().getString("SortidesAuto.reservar_tooltip");
    private String tooltipNoAutoSortides = SgaRecursos.getInstance().getString("SortidesAuto.noReservar_tooltip");
    private Icon iconAutoSortides = SgaRecursos.createImageIcon(getClass(),"sortidesauto.gif", null);
    private Icon iconNoAutoSortides = SgaRecursos.createImageIcon(getClass(),"nosortidesauto.gif", null);

    /**
     * Constructor
     */

    protected SortidesAutoAction()
    {
      super();
      String autoSortides = appModule.getAutoSortides(getPuesto());
      if (autoSortides != null && autoSortides.equals("S"))
      {
        putValue(Action.SMALL_ICON, iconAutoSortides );
        putValue(Action.SHORT_DESCRIPTION, tooltipAutoSortides);
      }
      else
      {
        putValue(Action.SMALL_ICON, iconNoAutoSortides );
        putValue(Action.SHORT_DESCRIPTION, tooltipNoAutoSortides);
      }
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      if ((getPuesto() != null && !getPuesto().equals("3")))
      {
        if (appModule.getAutoSortides(getPuesto()).equals("S"))
        {
          appModule.setAutoSortides(getPuesto(), "N");
          putValue(Action.SMALL_ICON, iconNoAutoSortides );
          putValue(Action.SHORT_DESCRIPTION, tooltipNoAutoSortides);
        }
        else
        {
          appModule.setAutoSortides(getPuesto(), "S");
          putValue(Action.SMALL_ICON, iconAutoSortides );
          putValue(Action.SHORT_DESCRIPTION, tooltipAutoSortides);
        }
      }
      else
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("SortidesAuto.noSortidesExtra_label"));
    }

  }

  /**
   * Activa o desactiva l'activitat en el puesto
   */

  class ActivitatPuestoAction extends AbstractAction
  {

    private String tooltipActiu = SgaRecursos.getInstance().getString("ActivitatPuesto.actiu_tooltip");
    private String tooltipNoActiu = SgaRecursos.getInstance().getString("ActivitatPuesto.noActiu_tooltip");
    private Icon iconActiu = SgaRecursos.createImageIcon(getClass(),"run.gif", null);
    private Icon iconNoActiu = SgaRecursos.createImageIcon(getClass(),"stop.gif", null);

    /**
     * Constructor
     */

    protected ActivitatPuestoAction()
    {
      super();
      String estat = appModule.getEstatPuesto(getPuesto());
      if (estat != null && estat.equals("A"))
      {
        putValue(Action.SMALL_ICON, iconActiu );
        putValue(Action.SHORT_DESCRIPTION, tooltipActiu);
      }
      else
      { 
        appModule.setEstatPuesto(getPuesto(), "P");
        putValue(Action.SMALL_ICON, iconNoActiu );
        putValue(Action.SHORT_DESCRIPTION, tooltipNoActiu);
      }
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      if (appModule.getEstatPuesto(getPuesto()).equals("A"))
      {
        appModule.setEstatPuesto(getPuesto(), "P");
        putValue(Action.SMALL_ICON, iconNoActiu );
        putValue(Action.SHORT_DESCRIPTION, tooltipNoActiu);
      }
      else
      {
        appModule.setEstatPuesto(getPuesto(), "A");
        putValue(Action.SMALL_ICON, iconActiu );
        putValue(Action.SHORT_DESCRIPTION, tooltipActiu);
      }
    }

  }

  /**
   * Recull pes bascula Mld
   */

  class BasculaMldAction extends AbstractAction
  {

    private String tooltipActiu = SgaRecursos.getInstance().getString("BasculaMld.basculaMld_tooltip");
    private Icon iconActiu = SgaRecursos.createImageIcon(getClass(),"16x16/plain/weight2.png", null);

    /**
     * Constructor
     */

    protected BasculaMldAction()
    {
      super();
      putValue(Action.SMALL_ICON, iconActiu );
      putValue(Action.SHORT_DESCRIPTION, tooltipActiu);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      String result = (String)JOptionPane.showInputDialog(Interflex.getInstance(), 
                      SgaRecursos.getInstance().getString("BasculaMld.pes_label"), 
                      SgaRecursos.getInstance().getString("BasculaMld.pes_label"), 
                      JOptionPane.PLAIN_MESSAGE, 
                      null,
                      //options, 
                      null,
                      "0");
      if (result != null)
      {
        try
        {
          for (int i = 0; i < PesadaBascula.MINPESADESMLD ; i++)
            MDPanelOperacionsManuals.getInstance().setPesMld(result);
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("SortidaReservada.errorQuantitatPerEmbalum_label") + ": " + result);          
        }
      }
    }
  }



  /**
   * Recull pes bascula Slo
   */

  class BasculaSloAction extends AbstractAction
  {

    private String tooltipActiu = SgaRecursos.getInstance().getString("BasculaSlo.basculaSlo_tooltip");
    private Icon iconActiu = SgaRecursos.createImageIcon(getClass(),"16x16/plain/weight2.png", null);

    /**
     * Constructor
     */

    protected BasculaSloAction()
    {
      super();
      putValue(Action.SMALL_ICON, iconActiu );
      putValue(Action.SHORT_DESCRIPTION, tooltipActiu);
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      String result = (String)JOptionPane.showInputDialog(Interflex.getInstance(), 
                      SgaRecursos.getInstance().getString("BasculaSlo.pes_label"), 
                      SgaRecursos.getInstance().getString("BasculaSlo.pes_label"), 
                      JOptionPane.PLAIN_MESSAGE, 
                      null,
                      //options, 
                      null,
                      "0");
      if (result != null)
      {
        try
        {
          MDPanelOperacionsManuals.getInstance().setPesSlo(result);
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("SortidaReservada.errorQuantitatPerEmbalum_label") + ": " + result);          
        }
      }
    }
  }


  /**
   * Permet modificar la capacitat del pulmï¿½ del miniload
   */

  class CapacitatAction extends AbstractAction
  {
    private boolean isSilo = false;
    private String tooltipMldActiu = SgaRecursos.getInstance().getString("CapacitatMld.actiu_tooltip");
    private Icon iconMldActiu = SgaRecursos.createImageIcon(getClass(),"16x16/plain/cube_yellow.png", null);
    private String tooltipSloActiu = SgaRecursos.getInstance().getString("CapacitatSlo.actiu_tooltip");
    private Icon iconSloActiu = SgaRecursos.createImageIcon(getClass(),"16x16/plain/cube_yellow.png", null);


    /**
     * Constructor
     */

    protected CapacitatAction(boolean isSilo)
    {
      super();
      this.isSilo = isSilo;

      if (isSilo)
      {
        putValue(Action.SMALL_ICON, iconSloActiu );
        putValue(Action.SHORT_DESCRIPTION, tooltipSloActiu);
      }
      else
      {
        putValue(Action.SMALL_ICON, iconMldActiu );
        putValue(Action.SHORT_DESCRIPTION, tooltipMldActiu);
      }
      
    }

    /**
     * Gestor de l'event
     */

    public void actionPerformed(ActionEvent e)
    {
      Number novaCapacitat = null;
      try
      {
        String capacitat = appModule.getCapacitatPulmoPuesto(getPuesto(), isSilo);
    
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                            SgaRecursos.getInstance().getString("Options.cancelar_label") };
      
        String result = (String)JOptionPane.showInputDialog(Interflex.getInstance(), 
                        SgaRecursos.getInstance().getString("CapacitatPulmo.capacitatPulmo_label") + (isSilo ? "MaxiLoad" : "MiniLoad"),
                        SgaRecursos.getInstance().getString("CapacitatPulmo.capacitatPulmo_label") + (isSilo ? "MaxiLoad" : "MiniLoad"), 
                        JOptionPane.PLAIN_MESSAGE, 
                        null,
                        //options, 
                        null,
                        capacitat);
        if (result != null)
        {
          try
          {
            novaCapacitat = new Number(result);
            if (novaCapacitat.compareTo(new Number(0)) >= 0)
            {
              if (appModule.setCapacitatPulmoPuesto(getPuesto(), novaCapacitat, isSilo))
                JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("CapacitatPulmo.capacitatActualitzada_label"));
              else
                JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("CapacitatPulmo.errorActualitzaciï¿½_label"));
            }
            else
              JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("CapacitatPulmo.capacitatNegativa_label"));
            
          }
          catch(Exception ex)
          {
            JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("CapacitatPulmo.capacitatErronia_label") + ": " + result);          
          }
        }
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }

    }

  }



  // ------------------------------------------------------------------------
  //Implementaciï¿½ dels metodes abstractes de la interfase SgaSecurityInterface
  // ------------------------------------------------------------------------
  
  public boolean checkUser(String user, String password)
  {
    if (appModule.checkUser(user, password))
    {
      setCurrentUser(user);
      setCurrentPassword(password);
      return true;
    }
    return false;
  };

/**
   * Michael 15.12.2005 comprobar acceso
   * @return 
   * @param acceso 
   */
 public boolean hasAcceso(String acceso)
  {
    if (appModule.hasRole(acceso))
      return true;
    return false;
  }

  // ------------------------------------------------------------------------  
  //Fi mï¿½todes de la interfase SgaSecurityInterface
  // ------------------------------------------------------------------------
  
  
  
  // ------------------------------------------------------------------------  
  //Implementaciï¿½ dels mï¿½todes de la interfase PuestoListener
  // ------------------------------------------------------------------------  
  
  
  public void  setSalidasMaxiObertes(int nSalides)
  {
    numLiniesSortida.setText(Integer.toString(nSalides));
  }
  public void setMacEnPuesto(SgamacEnPuestoViewRow macEnPuesto)
  {
    try
    {
      boolean identificarOperacioEnPuesto = true;
      SgaresmatOpManViewRow resmat = null;
      if (appModule != null)
      {
        // Nomes intentarem identificar el mac en puesto desde aquï¿½ si ja hi ha 
        // una instancia de MDPanelOperacionsManuals en marxa.
        // En cas contrari, a l'inicialitzar el panel, ja identificarï¿½ el mac en 
        // puesto
        
        if (MDPanelOperacionsManuals.getInstance() == null)
          identificarOperacioEnPuesto = false;
        //Posem el mac al puesto
        macEnPuesto.setMacEnPuesto();
        appModule.getTransaction().commit();
  
        // Mostrem la pantalla de operacions en puesto
        runPanel(new SgaMenuInfo
                  ("Operacions Puesto", "es.sysmap.interflex.view.MDPanelOperacionsManuals", "operacions.gif", 
                    "Operacions en el puesto de treball", "operacions"));
        if (identificarOperacioEnPuesto)
          MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto.getIdmac(), macEnPuesto.getTipocarga(), true);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
      System.out.println("Exception Interflex.setMacEnPuesto(): " + ex.toString());
    }
  }

  public void setPanelSgamacPos44PendPesoView1()
  {
    runPanel(new SgaMenuInfo
                ("Comprobació pes Extra", "es.sysmap.interflex.view.PanelSgamacPos44PendPesoView1", "operacions.gif", 
                  "Comprobar el pes en la Entrada Extra", "operacions"));
    
    
  
  }

  // ------------------------------------------------------------------------  
  //Fi mï¿½todes de la interfase PuestoListener
  // ------------------------------------------------------------------------  


  
}