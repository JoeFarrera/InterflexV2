package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgavexistenciaViewRow;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import sgalib.SgaRecursos;

public class ExistenciaEspecialSetter 
{
  public ExistenciaEspecialSetter()
  {
  }  
  
  public static boolean set(AppModule am, SgavexistenciaViewRow existRow)
  {
        try
      {
        if (existRow != null)
        {
          JComboBox cb = new JComboBox();
          Set setSpecial = am.getEspecialExistencia();
          if (!setSpecial.isEmpty())
          {
            Iterator iter = setSpecial.iterator();
            while (iter.hasNext())
            {
              cb.addItem(iter.next());
            }
          
            
   
          Object []      message = new Object[3];
          message [0] = "Afegir indicador especial a l'existència";
          message [1] = " ";  // Para que haya un hueco
          message [2] = cb;
        
          // Options
          String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                            SgaRecursos.getInstance().getString("Options.cancelar_label") };
  
          int eleccion = JOptionPane.showOptionDialog(
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
        {
          // Ha aceptado algo
          String special = (String)cb.getSelectedItem();
          String value = null;
          if (special != null && special.length() > 0)
          {
            value = am.getEspecialValue(special);
          }
          existRow.setUserEspecial(value);
          return true;       
        }
        
      }
        else
        {
          JOptionPane.showConfirmDialog(Interflex.getInstance(), "No s'han trobat valors a la base de dades", "Sense valors", JOptionPane.WARNING_MESSAGE);
        }
      }
      return false;
      }
       catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
        return false;
      }
  }
  
}