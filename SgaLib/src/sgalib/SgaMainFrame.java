package sgalib;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import java.util.Hashtable;
import javax.swing.*;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.plaf.FontUIResource;
import oracle.jbo.ApplicationModule;
import oracle.jbo.JboContext;
import org.apache.log4j.Logger;

public abstract class SgaMainFrame extends JFrame implements SgaMainFrameInterface, SgaSecurityInterface 
{
  static Logger LOG = Logger.getLogger("SgaMainFrame");
  private static SgaMainFrame frame;
  private String [] args;
  
  // Application Module 
  private ApplicationModule appModule = null;
  // form layout
  private BorderLayout borderLayoutContentPane = new BorderLayout();
  
  // Subpanels de l'splitpane
  private JSplitPane jSplitPane = new JSplitPane();
  private SgaMenuTree jScrollPane = null;
  private JDesktopPane jDesktopPane = new JDesktopPane();
  private BorderLayout borderLayoutDesktopPane = new BorderLayout();

  // Controlador pel tabbedpane del desktopPane
  private SgaTabbedPaneController tpc = null;
  private JTabbedPane tabbedPane = new JTabbedPane();    

  // Finestra splash
  public SplashScreen splashScreen = null;

// menu definitions

  private JMenuBar menubarFrame = new JMenuBar();
  private JMenu menuFile = new JMenu();
  private JMenu menuBloqueig = new JMenu();
  private JMenu menuHelp = new JMenu();


  private String aboutMessage = SgaRecursos.getInstance().getString("AboutBox.message");
  private String aboutTitle = SgaRecursos.getInstance().getString("AboutBox.title");

  // Classe utilitzada per l'ajuda 
  private SgaHelp sgaHelp = null;
  
  // Determina si l'aplicaci� esta en desenvolupament o no
  private boolean bIsDevelopment = false;

  // Estat de l'aplicaci� per l'usuari
  boolean bloquejat = false;
  
  // Barra d'eines
  private ToggleButtonToolBar toolbar = new ToggleButtonToolBar();
  private ToolBarPanel toolbarPanel = new ToolBarPanel();
  

  /**
   * 
   *  The default constructor for form
   */
  public SgaMainFrame(String [] args)
  {
    this.args = args;
    
    // Creem i llencem la pantalla splash. Donat que aix� posara bits a la
    // pantalla, necessitem fer-ho al GUI thread utilitzant invokeLater.
    splashScreen = new SplashScreen(this, 
      SgaRecursos.createImageIcon(getClass(),SgaRecursos.getInstance().getString("Splash.file"), null));

    // insertem el m�tode showSplashScreen al thread gui
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        splashScreen.showSplashScreen();
      }
    }
    );
    
    addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          SgaMainFrame.this.file_exit_action();
        }

        public void windowDeiconified(WindowEvent e)
        {
          //SgabalayModule sgabalayModule = (SgabalayModule)panelBinding.getDataControl().getApplicationModule();
          if (isCurrentUserBloquejat())
          {
            SgaJCLoginDialog loginDialog = new SgaJCLoginDialog("SGA");
            if (!loginDialog.popupDialogDesbloquejar() || 
                !desbloquejar(loginDialog.getUsuari(), loginDialog.getPassword()))
              {
                JOptionPane.showMessageDialog(SgaMainFrame.this, SgaRecursos.getInstance().getString("LoginDialog.desbloqueigCancelat"), "Error", JOptionPane.WARNING_MESSAGE);
                setExtendedState(JFrame.ICONIFIED);                  
              }
          }
        }
      });
    //Inicialitzem l'ajuda  
    sgaHelp = new SgaHelp(this.getClass(), this);
    //Inicialitzem la instancia
    frame = this;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    setSize(new Dimension(1024, 768));
    getContentPane().setLayout(borderLayoutContentPane);
    
    jDesktopPane.setLayout(borderLayoutDesktopPane);
    jDesktopPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    jDesktopPane.setOpaque(false);
    jDesktopPane.setPreferredSize(new Dimension(700, 671));
    jDesktopPane.setSize(new Dimension(700, 671));

    // Assignem el nou controlador al desktoppane
    tpc = new SgaTabbedPaneController(this, tabbedPane, jDesktopPane);    

    // Assignem el men� de l'aplicaci�
    // Michael 15.12.2005 Implementar acceso a elementos del menu
    jScrollPane = new SgaMenuTree(tpc, this);
    jScrollPane.setPreferredSize(new Dimension(300, 324));
    jScrollPane.setSize(new Dimension(300, 671));
    
    // Caracteristiques de l'splitpane
    jSplitPane.setOneTouchExpandable(true);
    jSplitPane.setContinuousLayout(true);
    jSplitPane.setDividerLocation(160);
    jSplitPane.setRightComponent(jDesktopPane);
    jSplitPane.setLeftComponent(jScrollPane);
    
    this.setTitle("[" + getCurrentUser () + "] - " + SgaRecursos.getInstance().getString("Frame.title"));

    
    jSplitPane.add(jScrollPane, JSplitPane.LEFT);
    jSplitPane.add(jDesktopPane, JSplitPane.RIGHT);
    
    getContentPane().add(jSplitPane, BorderLayout.CENTER);
    
    // Creem la barra de men� de l'aplicaci�
    createMenuBar();
    
    // Afegim una barra de botons
    toolbarPanel.setLayout(new BorderLayout());
    toolbarPanel.add(toolbar, BorderLayout.CENTER);
    // Afegim la barra d'eines al panell principal
    getContentPane().add(toolbarPanel, BorderLayout.PAGE_START);
    toolbarPanel.addContainerListener(toolbarPanel);
    
    // Si s'arranca la consolal, iniciem la comunicaci� i la classificaci�
    if (args.length > 0 && args[0].equals("-Consola"))
    {
      tpc.addMenuTab(new SgaMenuInfo
                ("Clasificaci�n", "jclient.PanelClasificacion", "clasificacion.gif", 
                  "Consulta de Estado de la Clasificacion", "clasif"));
      tpc.addMenuTab(new SgaMenuInfo
                ("Comunicaci�n Sorter", "jclient.PanelPlcView", "clasificacion.gif", 
                  "Comunicaci�n Sorter", "comsorter"));            
    }
    
    // Mostrem l'aplicaci� i ocultem l'splash.
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = getSize();

    // run this form

    if (frameSize.height > screenSize.height)
    {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width)
    {
      frameSize.width = screenSize.width;
    }
    setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    splashScreen.hideSplash();
    
  }
  

  /**
   * Crea la barra de men�s de l'aplicaci�
   */
   
  private void createMenuBar()
  {
    setJMenuBar(menubarFrame);
    createMenu(menuFile, "MenuFile.file_label", "MenuFile.file_mnemonic");
    createMenuItem(menuFile, "MenuFile.exit_label", "MenuFile.exit_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          file_exit_action();
        }
      });
    
    //Menus propis de cada aplicaci�
    createUserMenu();
    
    // creem el menu de bloqueig
    createMenu(menuBloqueig, "MenuBloqueig.bloqueig_label", "MenuBloqueig.bloqueig_mnemonic");
    createMenuItem(menuBloqueig, "MenuBloqueig.bloqueig_label", "MenuBloqueig.bloqueig_mnemonic",
             new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          bloqueig_action();
        }
      });
    
    createMenu(menuHelp, "MenuHelp.help_label", "MenuHelp.help_mnemonic");
    
    createMenuItem(menuHelp, "MenuHelp.contents_label", "MenuHelp.contents_mnemonic", new HelpAction(0));
    createMenuItem(menuHelp, "MenuHelp.index_label", "MenuHelp.index_mnemonic", new HelpAction(1));
    createMenuItem(menuHelp, "MenuHelp.search_label", "MenuHelp.search_mnemonic", new HelpAction(2));
    menuHelp.addSeparator();
    createMenuItem(menuHelp, "MenuHelp.about_label", "MenuHelp.about_mnemonic", new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          help_about_action(e);
        }
      });
    
  }

  /**
   * Crea un men� gen�ric
   */

  public void createMenu(JMenu menu, String label, String mnemonic)
  {
    menu.setText(SgaRecursos.getInstance().getString(label));
    menu.setMnemonic(SgaRecursos.getInstance().getMnemonic(mnemonic));
    menubarFrame.add(menu);
  }

  /**
   * Crea un item de men� gen�ric
   */

  public void createMenuItem(JMenu menu, String label, String mnemonic,
           ActionListener action)
  {
    JMenuItem mi = (JMenuItem) menu.add(new JMenuItem(SgaRecursos.getInstance().getString(label)));
    mi.setMnemonic(SgaRecursos.getInstance().getMnemonic(mnemonic));
    mi.addActionListener(action);
    if(action == null)
    {
      mi.setEnabled(false);
    }
  }
  
  /**
   * Afegeix men�s als men�s standard entre el primer i ultim men�
   */
   
  public abstract void createUserMenu();
  
  /**
   * Afegeix un boto a la barra de botons
   * @param tooltip
   * @param action
   */
  public void afegirBoto(Action action)
  {
    toolbar.afegirToolbarApp(action);
  }
  
  public void addComponent (Component c) 
  {
    toolbar.addComponent(c);
  }
  
  /**
   * Permet realitzar processos de tancament addicionals depenents de cada 
   * aplicaci�, un cop l'usuari ha pres la decissio de sortir de l'aplicaci�
   */
   
  public abstract void user_file_exit_action();
  
  private void file_exit_action()
  {
    Object [] options = {SgaRecursos.getInstance().getString("Sortir.botoTancar_label"), 
        SgaRecursos.getInstance().getString("Sortir.botoCancelar_label")};
    int action = JOptionPane.showOptionDialog(SgaMainFrame.this, 
        SgaRecursos.getInstance().getString("Sortir.missatge"), 
        SgaRecursos.getInstance().getString("Sortir.title") , 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE, null, options, options[(1)]);

    switch (action)
      {
      case JOptionPane.NO_OPTION:
        break;
      case JOptionPane.CLOSED_OPTION:
        break;
      case JOptionPane.YES_OPTION:
      default:
          //TODO: Veure com controlem si hi ha alguna transacci� pendent
          // en algun dels panels que hi pot haver oberts
          //panelBinding.releaseDataControl();
          // Processos adicionals de tancament propis de cada aplicaci�          
          user_file_exit_action();
          
          System.exit(0);
        break;
      }
  }


  private void bloqueig_action()
  {
    setCurrentUserBloquejat(true);
    SgaMainFrame.this.setExtendedState(JFrame.ICONIFIED);
  }

   /**
    sets the default font for all Swing components.
    ex. 
    setUIFont (new javax.swing.plaf.FontUIResource("Serif",Font.ITALIC,12));
   */

  public static void setUIFont (int addSize)
  {
      java.util.Enumeration keys = UIManager.getDefaults().keys();
      while (keys.hasMoreElements()) 
      {
        Object key = keys.nextElement();
        Object value = UIManager.get (key);
        if (value instanceof FontUIResource)
        {
          FontUIResource f = (FontUIResource)value;          
          UIManager.put (key, new FontUIResource(f.getFontName(), f.getStyle(), f.getSize() + addSize));
        } 
      }
  }    

  
  public void setDevelopment(boolean isDevelopment)
  {
    this.bIsDevelopment = isDevelopment;
  }

  public boolean isDevelopment()
  {
    return (bIsDevelopment == true);
  }

  // TODO: Veure si utilitzem la llibreria d'utilitats o esborro aquest
  // m�tode
  private void help_about_action(ActionEvent e)
  {
    JOptionPane.showMessageDialog(this, aboutMessage, aboutTitle, JOptionPane.INFORMATION_MESSAGE);
    /*if (about == null)
    {
      ProjectInfo projectInfo = new ProjectInfo();    
      Vector contrib = new Vector();
      contrib.add("Xavier");
      contrib.add("Michael");
      //projectInfo.setContributors((List)contrib);
      projectInfo.setVersion("1.00");
      projectInfo.setCopyright("Software & Sistemas MAP");
      projectInfo.setInfo("Informacion");
      projectInfo.setLicenceName("Nom llicencia");
      projectInfo.setLicenceText("Texte de la llicencia");
      projectInfo.setName("SCM X-Dock");
      projectInfo.setLogo(SgaRecursos.createImageIcon(getClass(),"logo.jpg", null).getImage());
      about = new AboutFrame(aboutTitle, projectInfo);
    }
      about.pack();
      RefineryUtilities.centerFrameOnScreen(about);
      about.show();*/
  }



   public static SgaMainFrame getInstance()
   {
      return frame;
   }

  public String[] getArgs()
  {
    return this.args;
  }


   /**
   * Engega l'ajuda des de el menu Ajuda
   */
  
   class HelpAction extends AbstractAction
   {
    private int nav = 0;
     /**
     * Constructor
     */
  
    protected HelpAction(int nav)
    {        
      this(null, null);
      this.nav = nav;
    }
  
    /**
     * Constructor
     */
  
    protected HelpAction(String string, Icon icon)
    {
      super(string,icon);
    }
  
    /**
     * Gestor de l'event
     */
  
    public void actionPerformed(ActionEvent e)
    {
      sgaHelp.showNavigatorWindow(nav);
    }
  
   }

  /**
   * Permet arrancar un panel autom�ticament sobre el tabbedPane, sense que 
   * l'usuari hagi de seleccionar una opci� de men�
   * @param menuInfo
   */
  public void runPanel(SgaMenuInfo menuInfo)
  {
      tpc.addMenuTab(menuInfo);
  }
  /**
   * Retorna el application module
   * @return 
   */
  public ApplicationModule getAppModule()
  {
    return appModule;
  }
  
  /**
   * Estableix el application module
   * @return 
   */
  public void setAppModule(ApplicationModule appModule)
  {
    this.appModule = appModule;
  }

  // M�todes de la interfase SgaMainFrameInterface

  /**
   * Mostrar la finestra d'Ajuda
   */

  public void showHelpWindow(String topicID)
  {
    sgaHelp.showHelpWindow(topicID);
  }
  
  public void setCursor(Cursor cursor)
  {
    super.setCursor(cursor);
  }
  
  public JFrame getFrame()
  {
    return this;
  }
  // Fi m�todes de la interfase SgaMainFrameInterface
  
  //Metodes de la interfase SgaSecurityInterface

  /**
   * Retorna l'usuari actual de l'aplicaci�
   * @return 
   */
  public String getCurrentUser()
  {
      return (String)appModule.getSession().getEnvironment().get(JboContext.SECURITY_PRINCIPAL);
  }
  /**
   * Estableix l'usuari actual de l'aplicaci�
   * @param user
   */
  public void setCurrentUser (String user)
  {
    Hashtable h = appModule.getSession().getEnvironment();
    h.put(JboContext.SECURITY_PRINCIPAL, user);
  }

  /**
   * Retorna el password de l'usuari
   * @return 
   */
  public String getCurrentPassword()
  {
    return (String)appModule.getSession().getEnvironment().get(JboContext.SECURITY_CREDENTIALS);
  }
  /**
   * Estableix el password actual de l'usuari
   * @param user
   */
  public void setCurrentPassword (String password)
  {
    Hashtable h = appModule.getSession().getEnvironment();
    h.put(JboContext.SECURITY_CREDENTIALS, password);
  }

  public abstract boolean checkUser(String user, String password);
  public abstract boolean hasAcceso(String acceso);
  
  /**
   * 
   * Retorna l'estat actual de l'aplicaci� per l'usuari
   */

  public boolean isCurrentUserBloquejat ()
  {
    return (bloquejat == true);
  }

  /**
   * 
   * Estableix l'estat actual de l'aplicaci� per l'usuari
   */

  public void setCurrentUserBloquejat (boolean estat)
  {
    bloquejat = estat;
  }

  public boolean desbloquejar(String usuari, String password)
  {
    boolean correctUser = false;  
    
    if ((usuari.trim()).equals(getCurrentUser()))
    {
        if ((password.trim()).equals(getCurrentPassword()))
          correctUser = true;
    }
    setCurrentUserBloquejat(!correctUser);
    return correctUser;
  }
  
  //Fi m�todes de la interfase SgaMainFrameInterface
}