package sgalib;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import oracle.jbo.ViewCriteria;
import oracle.jbo.uicli.controls.JUNavigationBar;
import oracle.jbo.uicli.jui.JUPanelBinding;

public class SgaJUNavigationBar extends JUNavigationBar 
{
/* Michael 26.04.2005   private JButton consultar = new JButton();
 */
  public SgaJUNavigationBar()
  {
/*  Michael 26.04.2005
  super(true, true, true, false, true);
 
    consultar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Container container = consultar.getParent();
          while (container != null && !(container instanceof JFrame))
            container = container.getParent();
          VCDialog vcDlg = new VCDialog((JFrame)container,             
            SgaJUNavigationBar.this.getModel().getViewObject());
          if (vcDlg.attribs == null || vcDlg.attribs.length == 0)
          {
             //ErrorHandler.displayError(parent, Res.getString(Res.CREATE_VO_ERROR));
             return;
          }
    
          vcDlg.show();
        }
      });
    consultar.setIcon(SgaRecursos.createImageIcon(getClass(), "findcancel.gif", null));      
    add(consultar);
  }
*******************************************/

    super(true,true,true,true,true);
    JButton findButton = getButton(BUTTON_FIND);
    // Quitar listeners. Quizás hay una manera más elegante para hacerlo ?
    ActionListener [] listeners = findButton.getActionListeners();
    for (int i = 0; i < listeners.length; i++)
    {
      findButton.removeActionListener(listeners[i]);
    }
    findButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Container container = getParent();
          while (container != null && !(container instanceof JFrame))
            container = container.getParent();
          VCDialog vcDlg = new VCDialog((JFrame)container,             
            getModel());
          if (vcDlg.attribs == null || vcDlg.attribs.length == 0)
          {
             //ErrorHandler.displayError(parent, Res.getString(Res.CREATE_VO_ERROR));
             return;
          }
    
          vcDlg.show();
          
        }
      });
      
  }
  
  public void enterQueryMode()
  {
    JButton findButton = getButton(BUTTON_FIND);
    findButton.getActionListeners()[0].actionPerformed(null);
  }
  
  public void silentMode(ViewCriteria mViewCriteria)
  {
      VCDialog vcDlg = new VCDialog(null,             
        getModel());
      if (vcDlg.attribs == null || vcDlg.attribs.length == 0)
      {
         //ErrorHandler.displayError(parent, Res.getString(Res.CREATE_VO_ERROR));
         return;
      }

      vcDlg.silentMode(mViewCriteria);
  }
  
}