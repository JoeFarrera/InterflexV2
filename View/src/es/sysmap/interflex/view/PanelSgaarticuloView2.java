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
import java.awt.Dimension;
import oracle.jbo.uicli.controls.JUStatusBar;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.JCheckBox;
import javax.swing.ButtonModel;

public class PanelSgaarticuloView2 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaarticuloView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Article

  private JLabel labelIdart = new JLabel();
  private JTextField mIdart = new JTextField();

// Fields for attribute:  Idartant

  private JLabel labelIdartant = new JLabel();
  private JTextField mIdartant = new JTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Pes unitari (gms)

  private JLabel labelPesunit = new JLabel();
  private JTextField mPesunit = new JTextField();

// Fields for attribute:  Controlar Pes

  private JLabel labelControlpes = new JLabel();

// Fields for attribute:  Últim moviment

  private JLabel labelFecultmov = new JLabel();
  private JTextField mFecultmov = new JTextField();

// Fields for attribute:  Codi EAN

  private JLabel labelCodean = new JLabel();
  private JTextField mCodean = new JTextField();

// Fields for attribute:  Unitats per embalatge

  private JLabel labelUniemb = new JLabel();
  private JTextField mUniemb = new JTextField();

// Fields for attribute:  Tipus contenidor

  private JLabel labelIdtipmac = new JLabel();
  private JTextField mIdtipmac = new JTextField();

// Fields for attribute:  Unitats per contenidor

  private JLabel labelUnimac = new JLabel();
  private JTextField mUnimac = new JTextField();

// Fields for attribute:  Reomplir

  private JLabel labelRelleno = new JLabel();

// Fields for attribute:  Multireferència

  private JLabel labelMultiref = new JLabel();
  private JTextField mMultiref = new JTextField();

// Fields for attribute:  Zona Rotació

  private JLabel labelRotacion = new JLabel();
  private JTextField mRotacion = new JTextField();

// Fields for attribute:  Picking

  private JLabel labelPicking1 = new JLabel();
  private JTextField mPicking1 = new JTextField();

// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Tolerancia FIFO

  private JLabel labelTolfifo = new JLabel();
  private JTextField mTolfifo = new JTextField();

// Fields for attribute:  Creat

  private JLabel labelCreatedon = new JLabel();
  private JTextField mCreatedon = new JTextField();

// Fields for attribute:  Modificat

  private JLabel labelModifiedon = new JLabel();
  private JTextField mModifiedon = new JTextField();

// Fields for attribute:  Data mod. pes

  private JLabel labelFecultmodpes = new JLabel();
  private JTextField mFecultmodpes = new JTextField();

// Fields for attribute:  Usuari mod. pes

  private JLabel labelModpesby = new JLabel();
  private JTextField mModpesby = new JTextField();

// Fields for attribute:  Pes per unitat (de picking)

  private JLabel labelPesuniven = new JLabel();
  private JTextField mPesuniven = new JTextField();
  private JUStatusBar jUStatusBar1 = new JUStatusBar();
  private ComboBoxModel comboBoxModel2 = new DefaultComboBoxModel();
  private JComboBox jComboBox1 = new JComboBox();
  private JCheckBox jCheckBox1 = new JCheckBox();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaarticuloView2()
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
    this.setSize(new Dimension(512, 483));
    mIdart.setDocument((Document)panelBinding.bindUIControl("Idart", mIdart));
    jCheckBox1.setToolTipText("Reomplir existencies parcials");
    dataPanel.add(labelIdart, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdart, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdart.setLabelFor(mIdart);
    mIdart.setColumns(15);
    labelIdart.setText(panelBinding.findCtrlValueBinding("Idart").getLabel());
    mIdart.setToolTipText(panelBinding.findCtrlValueBinding("Idart").getTooltip());
    mIdartant.setDocument((Document)panelBinding.bindUIControl("Idartant", mIdartant));
    dataPanel.add(labelIdartant, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartant, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartant.setLabelFor(mIdartant);
    mIdartant.setColumns(15);
    labelIdartant.setText(panelBinding.findCtrlValueBinding("Idartant").getLabel());
    mIdartant.setToolTipText(panelBinding.findCtrlValueBinding("Idartant").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(15);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mPesunit.setDocument((Document)panelBinding.bindUIControl("Pesunit", mPesunit));
    dataPanel.add(labelPesunit, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesunit, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPesunit.setLabelFor(mPesunit);
    mPesunit.setColumns(15);
    labelPesunit.setText(panelBinding.findCtrlValueBinding("Pesunit").getLabel());
    mPesunit.setToolTipText(panelBinding.findCtrlValueBinding("Pesunit").getTooltip());
    dataPanel.add(labelControlpes, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelControlpes.setText(panelBinding.findCtrlValueBinding("Controlpes").getLabel());
    mFecultmov.setDocument((Document)panelBinding.bindUIControl("Fecultmov", mFecultmov));
    dataPanel.add(labelFecultmov, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mFecultmov, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelFecultmov.setLabelFor(mFecultmov);
    mFecultmov.setColumns(15);
    labelFecultmov.setText(panelBinding.findCtrlValueBinding("Fecultmov").getLabel());
    mFecultmov.setToolTipText(panelBinding.findCtrlValueBinding("Fecultmov").getTooltip());
    mCodean.setDocument((Document)panelBinding.bindUIControl("Codean", mCodean));
    dataPanel.add(labelCodean, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCodean, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelCodean.setLabelFor(mCodean);
    mCodean.setColumns(15);
    labelCodean.setText(panelBinding.findCtrlValueBinding("Codean").getLabel());
    mCodean.setToolTipText(panelBinding.findCtrlValueBinding("Codean").getTooltip());
    mUniemb.setDocument((Document)panelBinding.bindUIControl("Uniemb", mUniemb));
    dataPanel.add(labelUniemb, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUniemb, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelUniemb.setLabelFor(mUniemb);
    mUniemb.setColumns(15);
    labelUniemb.setText(panelBinding.findCtrlValueBinding("Uniemb").getLabel());
    mUniemb.setToolTipText(panelBinding.findCtrlValueBinding("Uniemb").getTooltip());
    mIdtipmac.setDocument((Document)panelBinding.bindUIControl("Idtipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setColumns(15);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    mUnimac.setDocument((Document)panelBinding.bindUIControl("Unimac", mUnimac));
    dataPanel.add(labelUnimac, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUnimac, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelUnimac.setLabelFor(mUnimac);
    mUnimac.setColumns(15);
    labelUnimac.setText(panelBinding.findCtrlValueBinding("Unimac").getLabel());
    mUnimac.setToolTipText(panelBinding.findCtrlValueBinding("Unimac").getTooltip());
    dataPanel.add(labelRelleno, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    //labelRelleno.setText(panelBinding.findCtrlValueBinding("Relleno").getLabel());
    mMultiref.setDocument((Document)panelBinding.bindUIControl("Multiref", mMultiref));
    dataPanel.add(labelMultiref, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mMultiref, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    mMultiref.setColumns(15);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());
    mRotacion.setDocument((Document)panelBinding.bindUIControl("Rotacion", mRotacion));
    dataPanel.add(labelRotacion, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mRotacion, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelRotacion.setLabelFor(mRotacion);
    mRotacion.setColumns(15);
    labelRotacion.setText(panelBinding.findCtrlValueBinding("Rotacion").getLabel());
    mRotacion.setToolTipText(panelBinding.findCtrlValueBinding("Rotacion").getTooltip());
    mPicking1.setDocument((Document)panelBinding.bindUIControl("Picking1", mPicking1));
    dataPanel.add(labelPicking1, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPicking1, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPicking1.setLabelFor(mPicking1);
    mPicking1.setColumns(15);
    labelPicking1.setText(panelBinding.findCtrlValueBinding("Picking1").getLabel());
    mPicking1.setToolTipText(panelBinding.findCtrlValueBinding("Picking1").getTooltip());
    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(15);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mTolfifo.setDocument((Document)panelBinding.bindUIControl("Tolfifo", mTolfifo));
    dataPanel.add(labelTolfifo, new GridBagConstraints(0, 16, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTolfifo, new GridBagConstraints(1, 16, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelTolfifo.setLabelFor(mTolfifo);
    mTolfifo.setColumns(15);
    labelTolfifo.setText(panelBinding.findCtrlValueBinding("Tolfifo").getLabel());
    mTolfifo.setToolTipText(panelBinding.findCtrlValueBinding("Tolfifo").getTooltip());
    mCreatedon.setDocument((Document)panelBinding.bindUIControl("Createdon", mCreatedon));
    dataPanel.add(labelCreatedon, new GridBagConstraints(0, 17, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCreatedon, new GridBagConstraints(1, 17, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelCreatedon.setLabelFor(mCreatedon);
    mCreatedon.setColumns(15);
    labelCreatedon.setText(panelBinding.findCtrlValueBinding("Createdon").getLabel());
    mCreatedon.setToolTipText(panelBinding.findCtrlValueBinding("Createdon").getTooltip());
    mModifiedon.setDocument((Document)panelBinding.bindUIControl("Modifiedon", mModifiedon));
    dataPanel.add(labelModifiedon, new GridBagConstraints(0, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mModifiedon, new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelModifiedon.setLabelFor(mModifiedon);
    mModifiedon.setColumns(15);
    labelModifiedon.setText(panelBinding.findCtrlValueBinding("Modifiedon").getLabel());
    mModifiedon.setToolTipText(panelBinding.findCtrlValueBinding("Modifiedon").getTooltip());
    mFecultmodpes.setDocument((Document)panelBinding.bindUIControl("Fecultmodpes", mFecultmodpes));
    dataPanel.add(labelFecultmodpes, new GridBagConstraints(0, 19, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mFecultmodpes, new GridBagConstraints(1, 19, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelFecultmodpes.setLabelFor(mFecultmodpes);
    mFecultmodpes.setColumns(15);
    labelFecultmodpes.setText(panelBinding.findCtrlValueBinding("Fecultmodpes").getLabel());
    mFecultmodpes.setToolTipText(panelBinding.findCtrlValueBinding("Fecultmodpes").getTooltip());
    mModpesby.setDocument((Document)panelBinding.bindUIControl("Modpesby", mModpesby));
    dataPanel.add(labelModpesby, new GridBagConstraints(0, 20, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mModpesby, new GridBagConstraints(1, 20, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelModpesby.setLabelFor(mModpesby);
    mModpesby.setColumns(15);
    labelModpesby.setText(panelBinding.findCtrlValueBinding("Modpesby").getLabel());
    mModpesby.setToolTipText(panelBinding.findCtrlValueBinding("Modpesby").getTooltip());
    mPesuniven.setDocument((Document)panelBinding.bindUIControl("Pesuniven", mPesuniven));
    dataPanel.add(labelPesuniven, new GridBagConstraints(0, 21, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesuniven, new GridBagConstraints(1, 21, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(jComboBox1, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(jCheckBox1, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelPesuniven.setLabelFor(mPesuniven);
    mPesuniven.setColumns(15);
    labelPesuniven.setText(panelBinding.findCtrlValueBinding("Pesuniven").getLabel());

    // Layout the datapanel and the navigation bar
    mPesuniven.setToolTipText(panelBinding.findCtrlValueBinding("Pesuniven").getTooltip());
    add(dataPanel, BorderLayout.CENTER);
    jUStatusBar1.setModel(JUStatusBar.createPanelBinding(panelBinding, jUStatusBar1));
    this.add(jUStatusBar1, BorderLayout.SOUTH);
    jComboBox1.setModel((ComboBoxModel)panelBinding.bindUIControl("Controlpes", jComboBox1));
    // jCheckBox1.setModel((ButtonModel)panelBinding.bindUIControl("DCButton", jCheckBox1));
    


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

    PanelSgaarticuloView2 panel = new PanelSgaarticuloView2();
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
}