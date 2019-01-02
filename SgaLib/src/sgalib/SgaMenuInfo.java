package sgalib;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;
import sgalib.SgaRecursos;

/**
 * Implementa la classe que conte tota la informació sobre una opció de menú
 * concreta: acció a realitzar, icona a mostrar, texte a mostrar, tooltip a 
 * mostrar...
 * 
 * @author Xavier Marfull
 * @version 1.00
 */
 
public class SgaMenuInfo 
{
    static Logger LOG = Logger.getLogger("SgaMenuInfo");  
    public String nomMenu;
    public String panel;
    public String nomIcona;
    public String tooltip;
    public ImageIcon menuIcon;
    public String topicId;

    public SgaMenuInfo()
    {
      
    }
    public SgaMenuInfo(String nomMenu, String panel, String nomIcona, String tooltip) {
        this.nomMenu = nomMenu;
        this.panel = panel;
        this.nomIcona = nomIcona;
        this.tooltip = tooltip;

        //Assignem la icona del menu
        menuIcon = SgaRecursos.createImageIcon(getClass(), nomIcona, null);
        //menuIcon = createImageIcon(nomIcona);
        if (menuIcon == null) 
          LOG.error("No s'ha pogut carregar la icona " + nomIcona);
    }

    public SgaMenuInfo(String nomMenu, String panel, String nomIcona, String tooltip, String topicId) {
        this.nomMenu = nomMenu;
        this.panel = panel;
        this.nomIcona = nomIcona;
        this.tooltip = tooltip;
        this.topicId = topicId;

        //Assignem la icona del menu
        menuIcon = SgaRecursos.createImageIcon(getClass(), nomIcona, null);
        //menuIcon = createImageIcon(nomIcona);
        if (menuIcon == null) 
          LOG.error("No s'ha pogut carregar la icona " + nomIcona);
    }

    public String toString() {
        return nomMenu;
    }
}
