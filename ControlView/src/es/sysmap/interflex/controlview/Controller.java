package es.sysmap.interflex.controlview;

import es.sysmap.interflex.model.dmc.common.AppModule;
//import es.sysmap.interflex.model.dmc.common.AppModule1;

import es.sysmap.interflex.model.dmc.common.SgamacEnPuestoViewRow;
import es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow;
import es.sysmap.interflex.model.dmc.common.SgaresmatViewRow;
import java.awt.*;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.util.Hashtable;
import java.util.Set;
import javax.swing.*;

import javax.swing.plaf.FontUIResource;
import oracle.jbo.ConnectionMetadata;
import oracle.jbo.JboContext;
import oracle.jbo.client.Configuration;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import org.apache.log4j.Logger;
import sgalib.*;
// Aquests imports depenen de cada instal.lació

public class Controller extends SgaMainFrame
{
  private Logger LOG = Logger.getLogger(getClass());
  
  // Application module principal
  private static AppModule appModule = null;
  
  private static Controller interflex = null;

  
  // Lloc de treball associat al puesto
  private String puesto = null;

  //Constructor per defecte
  
  public Controller (String [] args)
  {
    super(args);
  }
  
  // TODO: Michael 01.12.2005 Ver que implementación dar a esto...
  public  boolean hasAcceso(String acceso)
  {
    return true;
  }

  
  public void jbInit() throws Exception
  {
    super.jbInit();
    // Si es vol modificar l'aspecte de l'aplicació generica, aquí seria
    // el lloc adequat
    // Afegim el puesto a la barra de titol
    if (puesto == null)
      puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    if (puesto != null)
      this.setTitle(SgaRecursos.getInstance().getString("Frame.subtitle_puesto") +  puesto + " - " + this.getTitle());    
    // Si es un puesto de treball, arranquem el thread del puesto
  }
  
// Si volguessim afegir menús a la barra de menus, ho fariem aquí
  public void createUserMenu()
  {
    //JMenu menuTest = new JMenu();
    //createMenu(menuTest, "MenuHelp.help_label", "MenuHelp.help_mnemonic");
    
    //createMenuItem(menuTest, "MenuHelp.contents_label", "MenuHelp.contents_mnemonic", null);
  }


  // Modifiquem l'acció de sortida perque es pari el thread que busca feina si
  // es tracta d'un puesto de manipulació
  
  public void user_file_exit_action()
  {
    
  }
  
  
  public static void main(String [] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      // Augmenta el tamany de totes les fonts utilitzades
      es.sysmap.interflex.controlview.Controller.setUIFont(2);
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
    }
    
    try
    {
      //Instanciem la classe SgaMainFrame
      interflex = new Controller(args);
      
      // Establim development = true
      // TODO: Treure-ho abans de fer el deployment definitiu
      interflex.setDevelopment(true);

      // Establim el nostre propi tractament d'errors
      JUMetaObjectManager.setErrorHandler(new SgaJUErrorHandler());

      //Instanciem el application module de l'aplicació
      String        amDef = "es.sysmap.interflex.model.dmc.AppModule";
      String        config = "AppModuleLocal";
      appModule = (AppModule)Configuration.createRootApplicationModule(amDef,config);
      // TODO: Establim el tractament de les excepcions de l'appModule
      //appModule.setExceptionHandler();
      interflex.setAppModule(appModule);
      
      

      // Verifiquem l'usuari
      
       ConnectionMetadata data = appModule.getTransaction().getConnectionMetadata();
 
      // Verifiquem l'usuari
      SgaJCLoginDialog loginDialog = new SgaJCLoginDialog("SGA (" + data.getJdbcURL() + " -> " + data.getUserName() + ")");
      if (!loginDialog.popupDialog() || 
          !interflex.checkUser(loginDialog.getUsuari(), loginDialog.getPassword()))
        {
        JOptionPane.showMessageDialog(null, SgaRecursos.getInstance().getString("Login.error_message"), 
              SgaRecursos.getInstance().getString("Login.error_title"), JOptionPane.WARNING_MESSAGE);
        System.exit(1);
        }
      else
      {
        // Si tot es correcte, inicialitzem l'aplicació i mostrem el frame
    
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
  




  // ------------------------------------------------------------------------
  //Implementació dels metodes abstractes de la interfase SgaSecurityInterface
  // ------------------------------------------------------------------------
  
  public boolean checkUser(String user, String password)
  {
    boolean correctUser = false; 
    correctUser = true;
    if (correctUser)
    {
      setCurrentUser(user);
      setCurrentPassword(password);
    }
    return true;
  };


  public boolean hasAcceso(String usuario, String acceso){return true;};
  
  // ------------------------------------------------------------------------  
  //Fi mètodes de la interfase SgaSecurityInterface
  // ------------------------------------------------------------------------
  
  
}