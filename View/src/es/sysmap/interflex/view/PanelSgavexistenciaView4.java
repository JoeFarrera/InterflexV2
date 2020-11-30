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

import oracle.jdeveloper.layout.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import sgalib.SgaJUPanel;


public class PanelSgavexistenciaView4 extends SgaJUPanel 
// public class PanelSgavexistenciaView4 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexistenciaView4UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Descripcio

  private JLabel labelDescarticulo = new JLabel();
  private JTextArea mDescarticulo = new JTextArea();
  private JScrollPane scrollerDescarticulo = new JScrollPane();

// Fields for attribute:  Quant. Total

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();

// Fields for attribute:  Contenidor

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Descip. Posició

  private JLabel labelDescvisualpos = new JLabel();
  private JTextArea mDescvisualpos = new JTextArea();
  private JScrollPane scrollerDescvisualpos = new JScrollPane();

// Fields for attribute:  Especial

  private JLabel labelEspecial = new JLabel();

  private JComboBox mEspecialCombo = new JComboBox();



  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexistenciaView4()
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
    dataPanel.setBounds(new Rectangle(0, 0, 600, 300));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(568, 302));
    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    mIdartif.setEditable(false);
    mDescarticulo.setEditable(false);
    scrollerDescarticulo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    mCantot.setEditable(false);
    mIdmac.setEditable(false);
    mDescvisualpos.setEditable(false);
    scrollerDescvisualpos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 1), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(15);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mDescarticulo.setDocument((Document)panelBinding.bindUIControl("Descarticulo", mDescarticulo));
    dataPanel.add(labelDescarticulo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(scrollerDescarticulo, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelDescarticulo.setLabelFor(scrollerDescarticulo);
    scrollerDescarticulo.getViewport().add(mDescarticulo);
    mDescarticulo.setColumns(30);
    mDescarticulo.setRows(2);
    labelDescarticulo.setText(panelBinding.findCtrlValueBinding("Descarticulo").getLabel());
    mDescarticulo.setToolTipText(panelBinding.findCtrlValueBinding("Descarticulo").getTooltip());
    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    dataPanel.add(labelCantot, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantot, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(14);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());
    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 6), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(12);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());
    mDescvisualpos.setDocument((Document)panelBinding.bindUIControl("Descvisualpos", mDescvisualpos));
    dataPanel.add(labelDescvisualpos, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(scrollerDescvisualpos, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelDescvisualpos.setLabelFor(scrollerDescvisualpos);
    scrollerDescvisualpos.getViewport().add(mDescvisualpos);
    mDescvisualpos.setColumns(30);
    mDescvisualpos.setRows(2);
    labelDescvisualpos.setText(panelBinding.findCtrlValueBinding("Descvisualpos").getLabel());
    mDescvisualpos.setToolTipText(panelBinding.findCtrlValueBinding("Descvisualpos").getTooltip());
    dataPanel.add(labelEspecial, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEspecialCombo, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 70, 0));
    labelEspecial.setLabelFor(mEspecialCombo);
    labelEspecial.setText(panelBinding.findCtrlValueBinding("Especial").getLabel());

    // Layout the datapanel and the navigation bar
    mEspecialCombo.setToolTipText(panelBinding.findCtrlValueBinding("Especial").getTooltip());
    add(dataPanel, BorderLayout.CENTER);
    mEspecialCombo.setModel((ComboBoxModel)panelBinding.bindUIControl("Especial2", mEspecialCombo));
 

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

    PanelSgavexistenciaView4 panel = new PanelSgavexistenciaView4();
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

  private void unRegisterProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.unRegisterNavigationBarInterface(panelBinding, bindCtx);
  }

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(panelBinding, bindCtx);
  }

  public void setBindingContext(BindingContext bindCtx)
  {
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }
  
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
}