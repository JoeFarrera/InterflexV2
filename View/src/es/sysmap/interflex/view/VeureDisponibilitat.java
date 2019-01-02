package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import java.lang.reflect.Array;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oracle.jbo.Row;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class VeureDisponibilitat  
{
  public VeureDisponibilitat()
  {
  }

  /**
   * Treu el contenidor del magatzem
   * @param e
   * //TODO: Provisional. No demanar dades del puesto si es un puesto de treball
   */
  
  public static void veureDisponibilitat(AppModule am, String idmac, String idart)
  {
    Vector disponibilitat = am.getDisponibilitat(idmac, idart);
    Object [] message = null;
    if (disponibilitat != null)
    {
      if (disponibilitat.size() == 0)
      {
        message = new Object[1];
        message[0] = "Disponible";
      }
      else
        message = disponibilitat.toArray();
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};

      JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            message,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Existencies.veureDisponibilitat_label"),            // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.INFORMATION_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            options[0]                                  // option that should be made into a default button
            );
    }
  }
  
}