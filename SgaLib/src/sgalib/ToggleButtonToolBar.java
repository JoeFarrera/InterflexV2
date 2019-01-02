package sgalib;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Afegeix un boto a la barra d'eines
 */

public class ToggleButtonToolBar extends JToolBar
{
  private static Insets zeroInsets = new Insets(1,1,1,1);
  //private ButtonGroup toolbarGroup = new ButtonGroup();

  //Darrer boto sobre el qual s'ha desplegat un popup menú
  private JToggleButton tbPopup = null;
  
  private JPopupMenu popupMenu = new JPopupMenu();

  /**
   * Constructor
   */

  public ToggleButtonToolBar()
  {
    super();
  }


  /**
   * Afegeix el boto a la barra d'eines
   */

  private JToggleButton addToggleButton(Action a)
  {
    JToggleButton tb = new JToggleButton(
      (String)a.getValue(Action.NAME),
      (Icon)a.getValue(Action.SMALL_ICON)
        );
    tb.setMargin(zeroInsets);
    tb.setText(null);
    tb.setEnabled(a.isEnabled());
    tb.setToolTipText((String)a.getValue(Action.SHORT_DESCRIPTION));
    tb.setAction(a);
    add(tb);
    return tb;
  }

  /**
   * Afegeix el boto a la barra d'eines
   */

  private JButton addButton(Action a)
  {
    JButton tb = new JButton(
      (String)a.getValue(Action.NAME),
      (Icon)a.getValue(Action.SMALL_ICON)
        );
    tb.setMargin(zeroInsets);
    tb.setText(null);
    tb.setEnabled(a.isEnabled());
    tb.setToolTipText((String)a.getValue(Action.SHORT_DESCRIPTION));
    tb.setAction(a);
    add(tb);
    return tb;
  }
  
  public void addComponent (Component c) 
  {
    add (c);
  }
  
  
  /**
   * Afegeix una aplicació a la barra d'eines
   */

  public void afegirToolbarApp(Action action)
  {
    if (action != null)
    {
      //if (botonsLlista.get(new Integer(aplicacio)) == null)
      {
        //JToggleButton tb = addToggleButton(action);
        JButton tb = addButton(action);
//        toolbarGroup.add(tb);
        tb.setText(null);
       // tb.setToolTipText(tooltip);
        tb.addMouseListener(new MouseListener()
          {
            public void mouseReleased(MouseEvent e)
            {
              if (e.isPopupTrigger())
              {
                tbPopup = (JToggleButton)e.getComponent();
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
              }
            }
            public void mouseExited(MouseEvent e)
            {
            }
            public void mouseEntered(MouseEvent e)
            {
            }
            public void mouseClicked(MouseEvent e)
            {
            }
            public void mousePressed(MouseEvent e)
            {
            }

          }
          );
        // Registrem el boto a la llista de botons
        //botonsLlista.put(new Integer(aplicacio), tb);
      }
    }
  }


    /**
     * Elimina una aplicació de la barra d'eines
     */

    public void eliminarToolbarApp()
    {
      // Eliminen el boto de la llista de botons
      //if (botonsLlista.containsValue(tbPopup))
      //{
      //  for(int i=0;i<botonsLlista.size();i++)
      //  {
      //    if (botonsLlista.get(new Integer(i)) == tbPopup)
      //      botonsLlista.remove(new Integer(i));
      //  }
      //}
      // Eliminem el botó
//      toolbarGroup.remove(tbPopup);
      remove(tbPopup);
      // Repintem la barra d'eines
      validate();
      repaint();
    }


  /**
   * Crea un item de menú popup
   */
  private JMenuItem createPopupMenuItem(JPopupMenu menu, String label, char mnemonic,
           String accessibleDescription, Action action)
  {
    JMenuItem mi = (JMenuItem) menu.add(new JMenuItem(label));
    mi.setMnemonic(mnemonic);
    mi.getAccessibleContext().setAccessibleDescription(accessibleDescription);
    mi.addActionListener(action);
    if(action == null)
    {
      mi.setEnabled(false);
    }
    return mi;
  
  }
  
}
