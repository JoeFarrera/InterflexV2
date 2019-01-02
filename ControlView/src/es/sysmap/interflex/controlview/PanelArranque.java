package es.sysmap.interflex.controlview;
import es.sysmap.interflex.control.ComHost;
import es.sysmap.interflex.control.GestorDocSalida;
import es.sysmap.interflex.control.GestorOrdTran;
import es.sysmap.interflex.control.PlcStatus;
import es.sysmap.interflex.control.ReservaPuesto;
import es.sysmap.interflex.control.SalidaManual;
import es.sysmap.interflex.control.SalidaPuesto;

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
public class PanelArranque extends SgaJUPanel
{
// Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelArranqueUIModel");

  private ProcessButton buttonArranqueGestorOrdTran = new ProcessButton(
    "48x48/plain/trafficlight_red.png",
    "Engegar Gestor Ord. Tran", "Engegar el proces del gestor d'ordres de transport", 
    "48x48/plain/trafficlight_green.png",
    "Aturar Gestor Ord. Tran", "Aturar el proces del gestor d'ordres de transport");
  private ProcessButton buttonArranqueSalidaPuestoMLD = new 
    ProcessButton("48x48/plain/trafficlight_red.png", 
    "Mini: Engegar proces sortida lloc", 
    "Engegar el proces sortida lloc MLD", 
    "48x48/plain/trafficlight_green.png", 
    "Mini: Aturar proces de sortida lloc", 
    "Aturar el proces del sortida lloc MLD");
 
   private ProcessButton buttonArranqueSalidaPuestoSLO = new 
    ProcessButton("48x48/plain/trafficlight_red.png", 
    "Maxi: Engegar proces sortida lloc", 
    "Engegar el proces sortida lloc maxiload", 
    "48x48/plain/trafficlight_green.png", 
    "Maxi: Aturar proces de sortida lloc", 
    "Aturar el proces del sortida lloc maxiload");
  private ProcessButton buttonArranquePlcStatus = 
    new ProcessButton("48x48/plain/trafficlight_red.png", 
      "Engegar proces gestió PLC", 
      "Engegar el proces de comunicació amb el PLC Siemens", 
      "48x48/plain/trafficlight_green.png", 
      "Aturar proces gestió PLC", 
      "Aturar el proces de comunicació amb el PLC Siemens");
      
  private ProcessButton buttonGestorDocSalida = 
    new ProcessButton("48x48/plain/trafficlight_red.png", 
      "Engegar proces Doc. Sortida", 
      "Engegar el proces de volcat automátic de documents de sortida", 
      "48x48/plain/trafficlight_green.png", 
      "Aturar proces Doc. Sortida", 
      "Aturar el proces de volcat automátic de documents de sortida");

  private ProcessButton buttonReservaPuesto = 
    new ProcessButton("48x48/plain/trafficlight_red.png", 
      "Engegar proces Reserva lloc treball", 
      "Engegar el proces de reserva lloc trebal", 
      "48x48/plain/trafficlight_green.png", 
      "Aturar proces reserva lloc treball", 
      "Aturar el proces de reserva lloc treball");

  private ProcessButton buttonSalidaManual = 
    new ProcessButton("48x48/plain/trafficlight_red.png", 
      "Engegar proces sortida manual", 
      "Engegar el proces de sortida de material de ubicacions manuals", 
      "48x48/plain/trafficlight_green.png", 
      "Aturar proces sortida manual", 
      "Aturar el proces de sortida de material de ubicacions manuals");

  private GridBagLayout gridBagLayout1 = new GridBagLayout();
 
  /**
   * 
   *  The default constructor for panel
   */
  public PanelArranque()
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
    buttonArranqueGestorOrdTran.setProcess(new GestorOrdTran());  
    buttonArranquePlcStatus.setProcess(PlcStatus.getInstance());
    buttonGestorDocSalida.setProcess(new GestorDocSalida());
    this.add(buttonArranquePlcStatus, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 0, 5, 0), 0, 5));
    this.add(buttonArranqueGestorOrdTran, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 0, 5, 0), 0, 5));
    this.add(buttonArranqueSalidaPuestoMLD, new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 0, 5, 0), 0, 5));
    this.add(buttonArranqueSalidaPuestoSLO, new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 0, 5, 0), 0, 5));
    this.add(buttonGestorDocSalida, new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 0, 5, 0), 0, 5));
    this.add(buttonReservaPuesto, new GridBagConstraints(0, 5, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 0, 5, 0), 0, 5));
    this.add(buttonSalidaManual, new GridBagConstraints(0, 6, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(10, 0, 5, 0), 0, 5));
    buttonArranqueSalidaPuestoMLD.setProcess(new SalidaPuesto(SalidaPuesto.PUESTO_MINILOAD));
    buttonArranqueSalidaPuestoSLO.setProcess(new SalidaPuesto(SalidaPuesto.PUESTO_MAXILOAD));
    buttonReservaPuesto.setProcess(new ReservaPuesto());
    buttonSalidaManual.setProcess(new SalidaManual());
    
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

    PanelArranque panel = new PanelArranque();
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