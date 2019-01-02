package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.ComboBoxModel;
import javax.swing.BorderFactory;
import java.awt.Color;
import sgalib.SgaJUPanel;
import javax.swing.JButton;
import javax.swing.ButtonModel;
import javax.swing.JLabel;


// public class PanelSgaubicacionManualView1 extends JPanel implements JUPanel
public class PanelSgaubicacionManualView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaubicacionManualView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Id. Ubicació

  private JLabel labelIdubi = new JLabel();
  private JTextField mIdubi = new JTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Passadis

  private JLabel labelPasillo = new JLabel();
  private JTextField mPasillo = new JTextField();

// Fields for attribute:  Columna

  private JLabel labelColumna = new JLabel();
  private JTextField mColumna = new JTextField();

// Fields for attribute:  Nivell

  private JLabel labelNivel = new JLabel();
  private JTextField mNivel = new JTextField();

// Fields for attribute:  Estat

  private JLabel labelEstado = new JLabel();

// Fields for attribute:  Descripvisual
  private JTextField mDescripvisual = new JTextField();
  private ComboBoxModel comboBoxModel1 = new DefaultComboBoxModel();
  private ComboBoxModel comboBoxModel2 = new DefaultComboBoxModel();
  private JComboBox mEstado = new JComboBox();
  private JComboBox mZonaman = new JComboBox();
  private JLabel labelZonaman = new JLabel();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaubicacionManualView1()
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
    dataPanel.setMinimumSize(new Dimension(400, 274));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(400, 274));
    dataPanel.setMaximumSize(new Dimension(400, 274));
    navBar.setPreferredSize(new Dimension(400, 26));
    navBar.setMinimumSize(new Dimension(400, 26));
    navBar.setMaximumSize(new Dimension(400, 26));
    this.setLayout(borderLayout);
    this.setPreferredSize(new Dimension(400, 300));
    this.setMinimumSize(new Dimension(400, 300));
    this.setMaximumSize(new Dimension(400, 300));
    this.setSize(new Dimension(627, 300));

    mDescripvisual.setDocument((Document)panelBinding.bindUIControl("Descripvisual", mDescripvisual));
    mZonaman.setToolTipText("Prioridad de la zona manual");
    labelZonaman.setText("Prioridad");
    labelZonaman.setToolTipText("null");
    dataPanel.add(mDescripvisual, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    mDescripvisual.setColumns(40);
    mDescripvisual.setToolTipText(panelBinding.findCtrlValueBinding("Descripvisual").getTooltip());
    mDescripvisual.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    mDescripvisual.setBackground(new Color(212, 208, 200));
    mIdubi.setDocument((Document)panelBinding.bindUIControl("Idubi", mIdubi));
    dataPanel.add(labelIdubi, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdubi, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdubi.setLabelFor(mIdubi);
    mIdubi.setColumns(10);
    labelIdubi.setText(panelBinding.findCtrlValueBinding("Idubi").getLabel());
    mIdubi.setToolTipText(panelBinding.findCtrlValueBinding("Idubi").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(25);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mPasillo.setDocument((Document)panelBinding.bindUIControl("Pasillo", mPasillo));
    dataPanel.add(labelPasillo, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPasillo, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelPasillo.setLabelFor(mPasillo);
    mPasillo.setColumns(5);
    labelPasillo.setText(panelBinding.findCtrlValueBinding("Pasillo").getLabel());
    mPasillo.setToolTipText(panelBinding.findCtrlValueBinding("Pasillo").getTooltip());
    mColumna.setDocument((Document)panelBinding.bindUIControl("Columna", mColumna));
    dataPanel.add(labelColumna, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mColumna, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelColumna.setLabelFor(mColumna);
    mColumna.setColumns(5);
    labelColumna.setText(panelBinding.findCtrlValueBinding("Columna").getLabel());
    mColumna.setToolTipText(panelBinding.findCtrlValueBinding("Columna").getTooltip());
    mNivel.setDocument((Document)panelBinding.bindUIControl("Nivel", mNivel));
    dataPanel.add(labelNivel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mNivel, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelNivel.setLabelFor(mNivel);
    mNivel.setColumns(5);
    labelNivel.setText(panelBinding.findCtrlValueBinding("Nivel").getLabel());
    mNivel.setToolTipText(panelBinding.findCtrlValueBinding("Nivel").getTooltip());
    dataPanel.add(labelEstado, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstado, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(mZonaman, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 10, 0));
    dataPanel.add(labelZonaman, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelEstado.setText(panelBinding.findCtrlValueBinding("Estado").getLabel());

    // Bind the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaubicacionManualView1", null, "SgaubicacionManualView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    mEstado.setModel((ComboBoxModel)panelBinding.bindUIControl("Estado2", mEstado));
    mZonaman.setModel((ComboBoxModel)panelBinding.bindUIControl("Zonaman", mZonaman));


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

    PanelSgaubicacionManualView1 panel = new PanelSgaubicacionManualView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
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
}