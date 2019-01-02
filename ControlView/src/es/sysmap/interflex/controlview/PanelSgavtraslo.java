package es.sysmap.interflex.controlview;
import es.sysmap.interflex.control.Traslo;
import es.sysmap.interflex.control.ADFTraslo;

import es.sysmap.interflex.model.dmc.SgavestadoentradaslomacViewImpl;
import es.sysmap.interflex.model.dmc.SgavestadoentradaslomacViewRowImpl;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.AppModuleImpl;
import es.sysmap.interflex.model.dmc.common.SgavtrasloEntSalRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import java.awt.Dimension;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.ButtonModel;
import oracle.jbo.uicli.controls.JUArrayComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

// public class PanelSgavtraslo extends JPanel implements JUPanel 
public class PanelSgavtraslo extends SgaJUPanel
{

  protected Traslo traslo;

  Icon trafficRed = SgaRecursos.createImageIcon(getClass(), "48x48/plain/trafficlight_red.png", null);
  Icon trafficGreen = SgaRecursos.createImageIcon(getClass(), "48x48/plain/trafficlight_green.png", null);
  private final String STARTTEXT = "Engegar traslo";
  private final String STOPTEXT = "Aturar traslo";
  private final String STARTTEXTTTP = "Engegar el proces del traslo";
  private final String STOPTEXTTTP = "Aturar el proces del traslo";
  

  protected ProcessButton buttonArrancar = new ProcessButton(
    "48x48/plain/trafficlight_red.png",
    STARTTEXT, STARTTEXTTTP, 
    "48x48/plain/trafficlight_green.png",
    STOPTEXT, STOPTEXTTTP);
  
  

  // Panel binding definition used by design time
  protected JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavtrasloUIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idtraslo

  private JLabel labelIdtraslo = new JLabel();
  private JTextField mIdtraslo = new JTextField();

// Fields for attribute:  Descrip

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Estat traslo

  private JLabel labelEstadotraslotxt = new JLabel();
  private JTextField mEstadotraslotxt = new JTextField();

// Fields for attribute:  Estat pasadis

  private JLabel labelEstadopasillotxt = new JLabel();
  private JTextField mEstadopasillotxt = new JTextField();

// Fields for attribute:  Estat proces

  private JLabel labelEstadoprocesotraslotxt = new JLabel();
  private JTextField mEstadoprocesotraslotxt = new JTextField();

// Fields for attribute:  DescripvisualEntrada

  private JLabel labelDescripvisualEntrada = new JLabel();
  private JTextField mDescripvisualEntrada = new JTextField();

// Fields for attribute:  DescripvisualSalida

  private JLabel labelDescripvisualSalida = new JLabel();
  private JTextField mDescripvisualSalida = new JTextField();

// Fields for attribute:  Pasilloactual

  private JLabel labelPasilloactual = new JLabel();
  private JTextField mPasilloactual = new JTextField();

// Fields for attribute:  Pasillodestino

  private JLabel labelPasillodestino = new JLabel();
  private JTextField mPasillodestino = new JTextField();

// Fields for attribute:  Posició PLC

  private JLabel labelPosplc = new JLabel();
  private JTextField mPosplc = new JTextField();

// The navigation bar
  private JUNavigationBar navBar = new JUNavigationBar();
// The status bar
  private JUStatusBar statusBar = new JUStatusBar();
  private ComboBoxModel comboBoxModel1 = new DefaultComboBoxModel();
  private JCheckBox jCheckBoxTrasbordoEntrada = new JCheckBox();



  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavtraslo()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(panelLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(862, 514));
    this.setPreferredSize(new Dimension(479, 306));
    this.setMinimumSize(new Dimension(479, 306));
    this.setMaximumSize(new Dimension(479, 306));
    mIdtraslo.setDocument((Document)panelBinding.bindUIControl("Idtraslo", mIdtraslo));
    mIdtraslo.setEditable(false);
    mDescrip.setFocusable(false);
    mDescrip.setEditable(false);
    mEstadotraslotxt.setFocusable(false);
    mEstadopasillotxt.setFocusable(false);
    mEstadoprocesotraslotxt.setFocusable(false);
    mDescripvisualEntrada.setFocusable(false);
    mDescripvisualSalida.setFocusable(false);
    mPasilloactual.setFocusable(false);
    mPasillodestino.setFocusable(true);
    mPosplc.setFocusable(false);
    jCheckBoxTrasbordoEntrada.setText("Trasbord Entradas");
    jCheckBoxTrasbordoEntrada.setToolTipText("Realitzar trasbord per ubicar containers en entrada de passadis");
    dataPanel.add(labelIdtraslo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtraslo, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtraslo.setLabelFor(mIdtraslo);
    mIdtraslo.setColumns(5);
    labelIdtraslo.setText(panelBinding.findCtrlValueBinding("Idtraslo").getLabel());
    mIdtraslo.setToolTipText(panelBinding.findCtrlValueBinding("Idtraslo").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(15);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mEstadotraslotxt.setDocument((Document)panelBinding.bindUIControl("Estadotraslotxt", mEstadotraslotxt));
    dataPanel.add(labelEstadotraslotxt, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstadotraslotxt, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelEstadotraslotxt.setLabelFor(mEstadotraslotxt);
    mEstadotraslotxt.setColumns(20);
    labelEstadotraslotxt.setText(panelBinding.findCtrlValueBinding("Estadotraslotxt").getLabel());
    mEstadotraslotxt.setToolTipText(panelBinding.findCtrlValueBinding("Estadotraslotxt").getTooltip());
    mEstadopasillotxt.setDocument((Document)panelBinding.bindUIControl("Estadopasillotxt", mEstadopasillotxt));
    dataPanel.add(labelEstadopasillotxt, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstadopasillotxt, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelEstadopasillotxt.setLabelFor(mEstadopasillotxt);
    mEstadopasillotxt.setColumns(20);
    labelEstadopasillotxt.setText(panelBinding.findCtrlValueBinding("Estadopasillotxt").getLabel());
    mEstadopasillotxt.setToolTipText(panelBinding.findCtrlValueBinding("Estadopasillotxt").getTooltip());
    mEstadoprocesotraslotxt.setDocument((Document)panelBinding.bindUIControl("Estadoprocesotraslotxt", mEstadoprocesotraslotxt));
    dataPanel.add(labelEstadoprocesotraslotxt, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstadoprocesotraslotxt, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelEstadoprocesotraslotxt.setLabelFor(mEstadoprocesotraslotxt);
    mEstadoprocesotraslotxt.setColumns(20);
    labelEstadoprocesotraslotxt.setText(panelBinding.findCtrlValueBinding("Estadoprocesotraslotxt").getLabel());
    mEstadoprocesotraslotxt.setToolTipText(panelBinding.findCtrlValueBinding("Estadoprocesotraslotxt").getTooltip());
    mDescripvisualEntrada.setDocument((Document)panelBinding.bindUIControl("DescripvisualEntrada", mDescripvisualEntrada));
    dataPanel.add(labelDescripvisualEntrada, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescripvisualEntrada, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescripvisualEntrada.setLabelFor(mDescripvisualEntrada);
    mDescripvisualEntrada.setColumns(20);
    labelDescripvisualEntrada.setText(panelBinding.findCtrlValueBinding("DescripvisualEntrada").getLabel());
    mDescripvisualEntrada.setToolTipText(panelBinding.findCtrlValueBinding("DescripvisualEntrada").getTooltip());
    mDescripvisualSalida.setDocument((Document)panelBinding.bindUIControl("DescripvisualSalida", mDescripvisualSalida));
    dataPanel.add(labelDescripvisualSalida, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescripvisualSalida, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescripvisualSalida.setLabelFor(mDescripvisualSalida);
    mDescripvisualSalida.setColumns(20);
    labelDescripvisualSalida.setText(panelBinding.findCtrlValueBinding("DescripvisualSalida").getLabel());
    mDescripvisualSalida.setToolTipText(panelBinding.findCtrlValueBinding("DescripvisualSalida").getTooltip());
    mPasilloactual.setDocument((Document)panelBinding.bindUIControl("Pasilloactual", mPasilloactual));
    dataPanel.add(labelPasilloactual, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPasilloactual, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelPasilloactual.setLabelFor(mPasilloactual);
    mPasilloactual.setColumns(3);
    labelPasilloactual.setText(panelBinding.findCtrlValueBinding("Pasilloactual").getLabel());
    mPasilloactual.setToolTipText(panelBinding.findCtrlValueBinding("Pasilloactual").getTooltip());
    mPasillodestino.setDocument((Document)panelBinding.bindUIControl("Pasillodestino", mPasillodestino));
    dataPanel.add(labelPasillodestino, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPasillodestino, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelPasillodestino.setLabelFor(mPasillodestino);
    mPasillodestino.setColumns(3);
    labelPasillodestino.setText(panelBinding.findCtrlValueBinding("Pasillodestino").getLabel());
    mPasillodestino.setToolTipText(panelBinding.findCtrlValueBinding("Pasillodestino").getTooltip());
    mPosplc.setDocument((Document)panelBinding.bindUIControl("Posplc", mPosplc));
    dataPanel.add(labelPosplc, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPosplc, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    // dataPanel.add(buttonArrancar, new GridBagConstraints(0, 10, 3, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2, 0, 22, 63), -98, -13));
    dataPanel.add(buttonArrancar, new GridBagConstraints(0, 10, 3, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
    // dataPanel.add(jCheckBoxTrasbordoEntrada, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelPosplc.setLabelFor(mPosplc);
    mPosplc.setColumns(5);
    labelPosplc.setText(panelBinding.findCtrlValueBinding("Posplc").getLabel());

    // Layout the datapanel and the navigation bar
    mPosplc.setToolTipText(panelBinding.findCtrlValueBinding("Posplc").getTooltip());
    add(dataPanel, BorderLayout.CENTER);

    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavtrasloEntSalView1", null, "SgavtrasloEntSal1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(statusBar, BorderLayout.SOUTH);
    
    // Quitar botones de add / remove
    navBar.remove( navBar.getButton(JUNavigationBar.BUTTON_DELETE));
    navBar.remove( navBar.getButton(JUNavigationBar.BUTTON_INSERT));
    jCheckBoxTrasbordoEntrada.setModel((ButtonModel)panelBinding.bindUIControl("Trasbordoentrada", jCheckBoxTrasbordoEntrada));
    if (getIdTraslo() == 0)
      jCheckBoxTrasbordoEntrada.setEnabled(false);

  
    
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

    PanelSgavtraslo panel = new PanelSgavtraslo();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl1", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
    
    ViewObject voTraslo = panel.panelBinding.findIteratorBinding("SgavtrasloEntSal1Iter").getViewObject();

    System.out.println("whereClause: " + voTraslo.getWhereClause());
    
    // Michael 19.12.2007 pruebas
  AppModuleImpl am = (AppModuleImpl)panel.panelBinding.getApplication().getApplicationModule();
  SgavestadoentradaslomacViewImpl vo = am.getSgavestadoentradaslomacView1();
  vo.setWhereClauseParam(0, "300000008212");
  vo.executeQuery();
  SgavestadoentradaslomacViewRowImpl vr = (SgavestadoentradaslomacViewRowImpl)vo.first();
  oracle.jbo.domain.Number num = new oracle.jbo.domain.Number (1);
  
  vr.setUbicacionDestinoMac(num);
  
  
  
//  Traslo traslo = new Traslo(1, "SLO", am);
//  traslo.test();
  // TODO 19.12.2007
    

  }

  /**
   * 
   *  JClientPanel implementation
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



  private int getIdTraslo()
  {
    SgavtrasloEntSalRow row = (SgavtrasloEntSalRow)panelBinding.findIteratorBinding("SgavtrasloEntSal1Iter").getCurrentRow();
    assert row != null;
    return row.getIdtraslo().intValue();

  }

}