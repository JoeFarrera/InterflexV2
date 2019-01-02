package es.sysmap.interflex.controlview;

import es.sysmap.interflex.control.RpsInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import sgalib.SgaJUPanel;

// public class PanelArranque extends JPanel
public class PanelRpsInterface extends SgaJUPanel
{
// Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelNetejarBDUIModel");

  private ProcessButton buttonArranqueRpsInteface = 
    new ProcessButton("48x48/plain/trafficlight_red.png", 
      "Engegar proces d'Actuatzació taules RPS (SKU)", 
      "Engegar el proces d'Actuatzació taules RPS (SKU)", 
      "48x48/plain/trafficlight_green.png", 
      "Aturar proces d'Actuatzació taules RPS (SKU)", 
      "Aturar el proces d'Actuatzació taules RPS (SKU)");
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
 
  /**
   * 
   *  The default constructor for panel
   */
  public PanelRpsInterface()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    this.setLayout(gridBagLayout1);
    this.setSize(new Dimension(829, 709));
    buttonArranqueRpsInteface.setProcess(new RpsInterface());
    this.add(buttonArranqueRpsInteface, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(5, 0, 5, 0), 0, 25));
  }

  public static void main(String [] args)
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception exemp)
    {
      exemp.printStackTrace();
    }

    PanelNetejarBD panel = new PanelNetejarBD();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "null", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }

  /**
   * 
   *  JUPanel implementation
   */
  public JUPanelBinding getPanelBinding()
  {
    return panelBinding;
  }

  // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }


}