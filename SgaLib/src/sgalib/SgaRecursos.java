package sgalib;

import java.awt.Component;
import java.io.File;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Classe genèrica amb metodes per accedir al fitxer de recursos.
 *
 * @author Xavier Marfull
 */

public class SgaRecursos 
{

  private static SgaRecursos _instance = null;
  private ResourceBundle bundle = null;
  
  public static SgaRecursos getInstance ()
  {
    if (_instance != null)
      return (_instance);
    else
      {
        _instance = new SgaRecursos ();
        return (_instance);
      }
  }

   public static SgaRecursos getInstance (ResourceBundle newBundle)
  {
    SgaRecursos instance = getInstance ();
    instance.setResourceBundle (newBundle);
    return (instance);
  }


  public void setResourceBundle (ResourceBundle newBundle)
  {
    bundle = newBundle;
  }
    /**
     * Retorna una cadena desde el fitxer de recursos.
     */

    public String getString(String key) 
    {
      // Si encara no s'ha especificat el fitxer de recursos,
      // n'especifiquem un per defecte
      if (bundle == null)
      {
        bundle = ResourceBundle.getBundle("resources.sga");
      }
      
      String value = "nada";
      // El primer cop, intenta obtenir el fitxer de recursos desde la propia
      // aplicació on s'ha instanciat el mòdul.
      if(bundle == null) 
      {
        return value;
      }
      try 
      {
        value = bundle.getString(key);
      } 
      catch (MissingResourceException e) 
      {
        System.out.println("java.util.MissingResourceException: Ha sido imposible determinar un valor para: " + key);
      }
      return value;
    }


    /**
     * Retorna un mnemònic desde el fitxer de recursos
     */

    public char getMnemonic(String key) 
    {
    	return (getString(key)).charAt(0);
    }


    /**
     * Retorna una icona desde el directori de recursos 
     */

    public static Icon getIcon(Class clase, String iconPath, String resource) 
    {
    	return createImageIcon(clase, iconPath, resource + ".nom");
    }


    /**
     * Crea la imatge de l'icona desde el directori de recursos
     */

    public static ImageIcon createImageIcon(Class clase, String filename, String resourceName) 
    {
        String path = "/resources/images/" + filename;
        
        java.net.URL imgURL = clase.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Imposible cargar imagen: " + path);
            return null;
        }
        
    }

  /**
   * Create an image icon from a jar (NOTE: .jar file must be in classpath)
   */
   public static ImageIcon createImageIconJar (Class clase, String fileName)
   {
     Image img = Toolkit.getDefaultToolkit().getImage(clase.getResource(fileName));
     return new ImageIcon (img);

   }

    /**
     * Retorna el nom d'un recurs
     */

    public String getName(String resource) 
    {
    	return getString(resource + ".nom");
    }


    /**
     * Retorna el tooltip d'un recurs
     */

    public String getToolTip(String resource) 
    {
    	return getString(resource + ".tooltip");
    }


    /**
     * Retorna el titol d'un frame 
     */

    public  String getFrameTitol(String resource, boolean minimized) 
    {
      if (minimized)
      	return getString(resource + ".frame_titol_minimitzat");
      else
      	return getString(resource + ".frame_titol");
    }



    /**
     * Retorna el titol de l'about
     */

    public  String getAboutTitol(String resource) 
    {
      	return getString(resource + ".about_titol");
    }


    /**
     * Retorna el texte de l'about
     */

    public  String getAboutTexte(String resource) 
    {
      	return getString(resource + ".about_texte");
    }


    /**
     * Retorna el topic de l'ajuda
     */

    public  String getTopicId(String resource) 
    {
      	return getString(resource + ".topicid");
    }

   /**
   * Mostra un cuadre de dialeg que permet escollir un fitxer, depenent de l'
   * extensió indicada
   * @return el fitxer seleccionat
   * @param parent
   * @param description
   * @param extension
   */
    public static File seleccionarFitxer(String extension, String description, boolean bOpen, Component parent)
    {
      return seleccionarFitxer(null, extension, description, bOpen, parent);
    }

   /**
   * Mostra un cuadre de dialeg que permet escollir un fitxer, depenent de l'
   * extensió indicada
   * @return el fitxer seleccionat
   * @param parent
   * @param description
   * @param extension
   */
    public static File seleccionarFitxer(String path, String extension, String description, boolean bOpen, Component parent)
    {
      ExampleFileFilter fileFilter = new ExampleFileFilter(extension, description);
      JFileChooser fc = new JFileChooser(path);
      if (fc != null)
      {
        fc.addChoosableFileFilter(fileFilter);
        fc.setFileFilter(fileFilter);
        // Michael 21.10.2022: The next line doesn't set the directory if the file doesn't exist
//        fc.setSelectedFile(new File(path + "." + extension));
        int returnVal = (bOpen ? fc.showOpenDialog(parent) : fc.showSaveDialog(parent));
        if (returnVal == JFileChooser.APPROVE_OPTION)
          return(fc.getSelectedFile());
      }
      return null;
    }


   /**
   * Mostra un cuadre de dialeg que permet escollir un fitxer, depenent de l'
   * extensió indicada
   * @return el fitxer seleccionat
   * @param parent
   * @param description
   * @param extension
   */
    public static File seleccionarDirectori(boolean bOpen, Component parent)
    {
      return seleccionarDirectori(null, bOpen, parent);
    }

   /**
   * Mostra un cuadre de dialeg que permet escollir un fitxer, depenent de l'
   * extensió indicada
   * @return el fitxer seleccionat
   * @param parent
   * @param description
   * @param extension
   */
    public static File seleccionarDirectori(String path, boolean bOpen, Component parent)
    {
      JFileChooser fc = new JFileChooser(path);
      if (fc != null)
      {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = (bOpen ? fc.showOpenDialog(parent) : fc.showSaveDialog(parent));
        if (returnVal == JFileChooser.APPROVE_OPTION)
          return(fc.getSelectedFile());
      }
      return null;
    }

  public static synchronized void reportException(Component comp, java.lang.Exception ex) 
  {
    String msg = ex.getMessage() + "\n" + ex.getStackTrace()[0].toString();
    //msg = ex.getMessage();      
    //if (msg == null || msg.trim().length() == 0)
    //  msg = ex.getClass().getName() + "\n" + ex.getStackTrace()[0].toString();
    JOptionPane.showMessageDialog(comp, msg, "Error", JOptionPane.WARNING_MESSAGE);
  }

}