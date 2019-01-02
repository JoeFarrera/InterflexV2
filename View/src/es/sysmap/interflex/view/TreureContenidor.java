package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oracle.jbo.Row;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class TreureContenidor extends JTextField 
{
  public TreureContenidor()
  {
  }

  /**
   * Treu el contenidor del magatzem
   * @param e
   * //TODO: Provisional. No demanar dades del puesto si es un puesto de treball
   */
  
  public static void treureContenidor(AppModule am, String idMac, boolean silo)
  {
    if (idMac == null || idMac.equals(""))
    {
      JOptionPane.showMessageDialog(null, "S'ha de triar un contenidor...", "Aviso..", JOptionPane.WARNING_MESSAGE);
      return;
    }
    
    String desti = null;
    int eleccion = 0;
    
    String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    
    // Si no es un puesto de manipulació, demanem les dades del desti
    if (!(puesto != null && am.esPuestoManipulacion(puesto)))
    {
      Object []      message = new Object[3];
      message [0] = SgaRecursos.getInstance().getString("Contenidors.triarDestiContenidor_label") + idMac;
      message [1] = " ";  // Para que haya un hueco
      
      JComboBox cb = new JComboBox();
      if (!silo)
      {
        cb.addItem("PK1MLD"); 
        cb.addItem("PK2MLD");
      }
      else
      {
        cb.addItem("PK1SLO");
        cb.addItem("PK2SLO");
        cb.addItem("PKEXTR");
      }
  
      message [2] = cb;
      
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                          SgaRecursos.getInstance().getString("Options.cancelar_label") };

      eleccion = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            message,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Contenidors.triarDestiContenidor_label"),            // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.INFORMATION_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            options[0]                                  // option that should be made into a default button
            );
      if (eleccion == 0)
        // Ha aceptado algo
        desti = (String)cb.getSelectedItem();
    
    }
    

    if (eleccion == 0)
    {
      boolean tret = am.treureContenidorMagatzem(idMac, desti, puesto);
      if (tret)
      {
        am.getTransaction().commit();
        JOptionPane.showMessageDialog(Interflex.getInstance(), 
            SgaRecursos.getInstance().getString("Contenidors.OKExtraccioContenidor_label"));
      }
      else
      {
        am.getTransaction().rollback();
        JOptionPane.showMessageDialog(Interflex.getInstance(), 
            SgaRecursos.getInstance().getString("Contenidors.errorExtraccioContenidor_label"));
      }
    }
  }
}