package sgalib;

import java.util.*;
import java.io.*;
import org.apache.log4j.Logger;

public class SgaUtilPuesto 
{
  // Nom del fitxer de propietats
  public static final String PROPERTIES_DIR = ".map";
  public static final String PROPERTIES_FILE = "map.properties";

  private static SgaUtilPuesto _instance;
  private final String descripPropiedades = "Propiedades Puesto"; 
  private final String ficheroPropiedades = System.getProperty("user.home") + "/" + PROPERTIES_FILE;
  Properties props;
  
  private Logger LOG = Logger.getLogger(getClass());

  /**
   * Utilidades de propiedades del puesto
   * Lectura y escritura del fichero de propiedades del usuario
   * El fichero sgapuesto.properties se guarda en el directorio home del usuario
   * La clase debe ser instanciada por getInstance () - habrá solo una instancia de la misma
   * No instanciar por el constructor !
   */
  private SgaUtilPuesto()
  {
  
   _instance = this;  // Singleton

    // Si no existe el fichero, crealo y inicializa valores...
    File filePropiedades = new File (ficheroPropiedades);
    System.out.println ("Fichero propiedades: " + ficheroPropiedades);
    if (!filePropiedades.exists())
    {
      try
      {
      if (filePropiedades.createNewFile())
        {
          System.out.println ("Inicializando fichero de propiedades: " 
            + ficheroPropiedades);
          OutputStream out = new FileOutputStream (ficheroPropiedades);
          Properties props = new Properties ();
          // Añadir otras propiedades aquí
          props.store(out, "sgapuesto.properties");
          out.close();
        }
      }
      catch (IOException e) {
          LOG.error("e", e);
          assert false; // No interesa continuar si no se puede crear
       }
    }    
  }

  /**
   * Obtener la one and only instancia de la clase
   * Singleton: Si no está instanciada, lo instancia
   */
  public static SgaUtilPuesto getInstance ()
  {
    if (_instance != null)
      return (_instance);
    else 
      return (new SgaUtilPuesto ());
  }
  
  public void storeNewProperty (String property, String value) 
  {
  try
    {
      OutputStream out = new FileOutputStream (ficheroPropiedades);
      props.setProperty(property, value);
      props.store(out, descripPropiedades);
      out.close();
    }
    catch (IOException e) 
    {
        LOG.error("e", e);
    }
  }

  private void loadProperties() 
  {
    props = new Properties();
    InputStream in;
  	try {
      in = new FileInputStream(ficheroPropiedades);
      props.load(in);
      in.close();
    }
    catch (IOException e) {
      LOG.error("e", e);
      assert false; // Si no se encuentra, no interesa continuar
     }
  }


  /**
   * buscar una propiedad determinado
   **/
  public String getProperty (String property)
  {
    if (props == null)
      loadProperties ();

    return props.getProperty(property);
  }



  /**
   * buscar una propiedad determinado, creándola si no existe
   **/
  public String getProperty (String property, String defaultValue)
  {
    String propertyValue = getProperty(property);
    if (propertyValue == null)
    {
      storeNewProperty(property, defaultValue);
    }
    return (propertyValue != null ? propertyValue : defaultValue);
  }

  /**
   * Retorna totes les propietats del fitxer per mostrar-les a la finestra de 
   * propietats
   **/

  public String[][] getProperties()
  {
    String [][] propiedades = null;
    int i = 0;

    if (props == null)
      loadProperties ();
    if (props != null)
    { 
      propiedades = new String[props.size()+10][2];      
      Enumeration nomProps = props.propertyNames();
      while (nomProps.hasMoreElements())
        {
          String nom = (String)nomProps.nextElement();
          propiedades[i][0] = new String(nom);
          propiedades[i][1] = new String(props.getProperty(nom));
          i = i + 1;
        }
      //Afegim deu linies en blanc
      for (int n = i; n < i+ 10; n++)
      {
        propiedades[n][0] = new String();
        propiedades[n][1] = new String();        
      }
    }
    return propiedades;
  }
  
  /**
   * Directorio por defecto de ficheros XML del usuario
   * Si no existe, lo crea como el directorio de propiedades del usuario
   * @return path al directorio de ficheros XML
   */
  public static String getXMLRoot()
  {
    return SgaUtilPuesto.getInstance().getProperty("XMLRoot", System.getProperty("user.home") + "/" + PROPERTIES_DIR);
  }

  public static boolean isTesting()
  {
    return SgaUtilPuesto.getInstance().getProperty("enPruebas", "0").equals("1");
  }

   public static void delLogs(String logPath, String extension, int dias)
   {
     Date fechaLimite = null;
     try
     {        
     //fechaLimite = (oracle.jbo.domain.Date.getCurrentDate().addJulianDays(-dias,0)).dateValue();     
     }
     catch(Exception ex)
     {}
     File pathName = new File(logPath);
     String[] fileNames = pathName.list();

     // enumerate all files in the directory
     for (int i = 0; i < fileNames.length; i++)
     {  
        File f = new File(pathName.getPath(), 
           fileNames[i]);
        // Si el fitxer te una data anterior 
        // a la data límit, l'esborrem
        if(f.getName().toString().endsWith(extension) && f.lastModified() < fechaLimite.getTime())
          f.delete();
     }
   }

   
}
