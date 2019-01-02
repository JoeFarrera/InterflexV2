package sgalib;

import java.awt.*;
import javax.swing.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import sgalib.SgaJUPanel;
import sgalib.SgaRunPanel;

public class PanelEnConstruccio extends SgaJUPanel 
{
// Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding();
  private JTextArea jTextArea1 = new JTextArea();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelEnConstruccio()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    this.setLayout(null);
    jTextArea1.setText("Opció de menú en construcció");
    jTextArea1.setBounds(new Rectangle(20, 100, 355, 100));
    jTextArea1.setFont(new Font("Monospaced", 1, 20));
    jTextArea1.setForeground(Color.orange);
    this.add(jTextArea1, null);
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

    PanelEnConstruccio panel = new PanelEnConstruccio();
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


  public void setBindingContext(BindingContext bindCtx)
  {
      try
      {
        jbInit();
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }
  }
 
}