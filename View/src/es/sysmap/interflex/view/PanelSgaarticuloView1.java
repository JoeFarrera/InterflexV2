package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.text.*;

import oracle.adf.model.*;

import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.JUpperCaseTextField;
import sgalib.SgaJUPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.Document;
import oracle.jbo.uicli.controls.JULabel;

public class PanelSgaarticuloView1 extends SgaJUPanel 
// public class PanelSgaarticuloView1 extends JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaarticuloView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idartif

  private JLabel labelIdartif = new JLabel();
  private JUpperCaseTextField mIdartif = new JUpperCaseTextField();

// Fields for attribute:  Descrip

  private JLabel labelDescrip = new JLabel();
  private JUpperCaseTextField mDescrip = new JUpperCaseTextField();

// Fields for attribute:  Pesunit

  private JLabel labelPesunit = new JLabel();
  private JTextField mPesunit = new JTextField();

// Fields for attribute:  Controlpes

  private JLabel labelControlpes = new JLabel();

// Fields for attribute:  Created on

  private JLabel labelCreatedon = new JLabel();
  private JTextField mCreatedon = new JTextField();

// Fields for attribute:  Modified on

  private JLabel labelModifiedon = new JLabel();
  private JTextField mModifiedon = new JTextField();

// Fields for attribute:  Fecultmov

  private JLabel labelFecultmov = new JLabel();
  private JTextField mFecultmov = new JTextField();

// Fields for attribute:  Codean

  private JLabel labelCodean = new JLabel();
  private JTextField mCodean = new JTextField();

// Fields for attribute:  Uniemb

  private JLabel labelUniemb = new JLabel();
  private JTextField mUniemb = new JTextField();

// Fields for attribute:  Idtipmac

  private JLabel labelIdtipmac = new JLabel();
  private JComboBox mIdtipmac = new JComboBox();

// Fields for attribute:  Unimac

  private JLabel labelUnimac = new JLabel();
  private JTextField mUnimac = new JTextField();

// Fields for attribute:  Relleno

  private JLabel labelRelleno = new JLabel();
  private JCheckBox mRelleno = new JCheckBox();

// Fields for attribute:  Multiref

  private JLabel labelMultiref = new JLabel();
  private JCheckBox mMultiref = new JCheckBox();

// Fields for attribute:  Rotacion

  private JLabel labelRotacion = new JLabel();
  private JComboBox mRotacion = new JComboBox();

// Fields for attribute:  Picking1

  private JLabel labelPicking1 = new JLabel();
  private JCheckBox mPicking1 = new JCheckBox();

// Fields for attribute:  Tolfifo

  private JLabel labelTolfifo = new JLabel();
  private JTextField mTolfifo = new JTextField();
  
  // Michael 11.11.2005 
  private JLabel labelUltmodPes = new JLabel();
  private JLabel jLabel1 = new JLabel();
  private JTextField mModpesby = new JTextField();
  private JTextField mFecultmodpes = new JTextField();
  private JComboBox mControlarpes = new JComboBox();
  private JTextField mPesuniven = new JTextField();
  private JULabel jULabel1 = new JULabel();
  private JTextField mUniembEsp = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField2 = new JTextField();
  private JLabel jLabel3 = new JLabel();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaarticuloView1()
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
    dataPanel.setMinimumSize(new Dimension(785, 365));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(785, 365));
    dataPanel.setMaximumSize(new Dimension(785, 365));
    dataPanel.setSize(new Dimension(499, 464));
    
    navBar.setPreferredSize(new Dimension(785, 26));
    navBar.setMinimumSize(new Dimension(785, 26));
    navBar.setMaximumSize(new Dimension(785, 26));
    
    this.setLayout(borderLayout);
    this.setSize(new Dimension(768, 412));
    this.setPreferredSize(new Dimension(768, 412));
    this.setMinimumSize(new Dimension(768, 412));
    this.setMaximumSize(new Dimension(768, 412));
    
    panelBinding.addRowSetListener(new JUPanelRowSetAdapter()
      {
        public void navigated(JUIteratorBinding iter, NavigationEvent event)
        {
          panelBinding_navigated(iter, event);
        }

        public void rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
        {
          panelBinding_rangeRefreshed(iter, event);
        }
      });

    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    jLabel1.setText("Usuari Mod. Pes");
    mModpesby.setText("mPesuniven");
    mModpesby.setPreferredSize(new Dimension(126, 20));
    mFecultmodpes.setText("jTextField1");
    mFecultmodpes.setPreferredSize(new Dimension(126, 20));
    mPesuniven.setText("mPesuniven");
    mPesuniven.setEditable(false);
    mPesuniven.setEnabled(false);
    mPesuniven.setPreferredSize(new Dimension(46, 20));
    jULabel1.setText("Pes unitat (de venda)");
    mUniembEsp.setText("mUniembEsp");
    jLabel2.setText("Unitats Emb. Especial");
    jLabel2.setToolTipText("Valor especial, prima sobre UniEmb");
    jTextField2.setText("1");
    jTextField2.setToolTipText("Tipus de Preparació (1/2) persones");
    jLabel3.setText("Tipus Preparació (1/2)");
    jLabel3.setToolTipText("null");
    dataPanel.add(labelIdartif, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(12);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());

    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(60);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());

    mPesunit.setDocument((Document)panelBinding.bindUIControl("Pesunit", mPesunit));
    dataPanel.add(labelPesunit, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesunit, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelPesunit.setLabelFor(mPesunit);
    mPesunit.setColumns(5);
    labelPesunit.setText(panelBinding.findCtrlValueBinding("Pesunit").getLabel());
    mPesunit.setToolTipText(panelBinding.findCtrlValueBinding("Pesunit").getTooltip());

    dataPanel.add(labelControlpes, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelControlpes.setText(panelBinding.findCtrlValueBinding("Controlpes").getLabel());

    mCreatedon.setDocument((Document)panelBinding.bindUIControl("Createdon", mCreatedon));
    dataPanel.add(labelCreatedon, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCreatedon, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelCreatedon.setLabelFor(mCreatedon);
    mCreatedon.setColumns(15);
    labelCreatedon.setText(panelBinding.findCtrlValueBinding("Createdon").getLabel());
    mCreatedon.setToolTipText(panelBinding.findCtrlValueBinding("Createdon").getTooltip());

    mModifiedon.setDocument((Document)panelBinding.bindUIControl("Modifiedon", mModifiedon));
    dataPanel.add(labelModifiedon, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mModifiedon, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelModifiedon.setLabelFor(mModifiedon);
    mModifiedon.setColumns(15);
    labelModifiedon.setText(panelBinding.findCtrlValueBinding("Modifiedon").getLabel());
    mModifiedon.setToolTipText(panelBinding.findCtrlValueBinding("Modifiedon").getTooltip());

    mFecultmov.setDocument((Document)panelBinding.bindUIControl("Fecultmov", mFecultmov));
    dataPanel.add(labelFecultmov, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mFecultmov, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelFecultmov.setLabelFor(mFecultmov);
    mFecultmov.setColumns(15);
    labelFecultmov.setText(panelBinding.findCtrlValueBinding("Fecultmov").getLabel());
    mFecultmov.setToolTipText(panelBinding.findCtrlValueBinding("Fecultmov").getTooltip());

    mCodean.setDocument((Document)panelBinding.bindUIControl("Codean", mCodean));
    dataPanel.add(labelCodean, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCodean, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(labelUniemb, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUniemb, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 18, 1));
    labelCodean.setLabelFor(mCodean);
    mCodean.setColumns(12);
    labelCodean.setText(panelBinding.findCtrlValueBinding("Codean").getLabel());
    mCodean.setToolTipText(panelBinding.findCtrlValueBinding("Codean").getTooltip());

    mUniemb.setDocument((Document)panelBinding.bindUIControl("Uniemb", mUniemb));
    labelUniemb.setLabelFor(mUniemb);
    mUniemb.setColumns(5);
    labelUniemb.setText(panelBinding.findCtrlValueBinding("Uniemb").getLabel());
    mUniemb.setToolTipText(panelBinding.findCtrlValueBinding("Uniemb").getTooltip());

    mIdtipmac.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(2, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setEditable(false);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());

    mUnimac.setDocument((Document)panelBinding.bindUIControl("Unimac", mUnimac));
    dataPanel.add(labelUnimac, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUnimac, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelUnimac.setLabelFor(mUnimac);
    mUnimac.setColumns(5);
    labelUnimac.setText(panelBinding.findCtrlValueBinding("Unimac").getLabel());
    mUnimac.setToolTipText(panelBinding.findCtrlValueBinding("Unimac").getTooltip());

    mRelleno.setModel((ButtonModel)panelBinding.bindUIControl("Relleno1", mRelleno));
    dataPanel.add(labelRelleno, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mRelleno, new GridBagConstraints(2, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelRelleno.setLabelFor(mRelleno);
    labelRelleno.setText(panelBinding.findCtrlValueBinding("Relleno").getLabel());
    mRelleno.setToolTipText(panelBinding.findCtrlValueBinding("Relleno").getTooltip());

    mMultiref.setModel((ButtonModel)panelBinding.bindUIControl("Multiref1", mMultiref));
    dataPanel.add(labelMultiref, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mMultiref, new GridBagConstraints(2, 14, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());

    mRotacion.setModel((ComboBoxModel)panelBinding.bindUIControl("Descrotacion", mRotacion));
    dataPanel.add(labelRotacion, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mRotacion, new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelRotacion.setLabelFor(mRotacion);
    mRotacion.setEditable(false);
    labelRotacion.setText(panelBinding.findCtrlValueBinding("Rotacion").getLabel());
    mRotacion.setToolTipText(panelBinding.findCtrlValueBinding("Rotacion").getTooltip());

    mPicking1.setModel((ButtonModel)panelBinding.bindUIControl("Picking2", mPicking1));
    dataPanel.add(labelPicking1, new GridBagConstraints(1, 16, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPicking1, new GridBagConstraints(2, 16, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelPicking1.setLabelFor(mPicking1);
    labelPicking1.setText(panelBinding.findCtrlValueBinding("Picking1").getLabel());
    mPicking1.setToolTipText(panelBinding.findCtrlValueBinding("Picking1").getTooltip());

    mTolfifo.setDocument((Document)panelBinding.bindUIControl("Tolfifo", mTolfifo));
    dataPanel.add(labelTolfifo, new GridBagConstraints(1, 17, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTolfifo, new GridBagConstraints(2, 17, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelTolfifo.setLabelFor(mTolfifo);
    mTolfifo.setColumns(5);
    labelTolfifo.setText(panelBinding.findCtrlValueBinding("Tolfifo").getLabel());
    mTolfifo.setToolTipText(panelBinding.findCtrlValueBinding("Tolfifo").getTooltip());

    labelUltmodPes.setText("Últ Modificació Pes");
    
    
    mControlarpes.setModel((ComboBoxModel)panelBinding.bindUIControl("Controlpes2", mControlarpes));
     
     
    dataPanel.add(labelUltmodPes, new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(jLabel1, new GridBagConstraints(1, 19, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(mModpesby, new GridBagConstraints(2, 19, 12, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(mFecultmodpes, new GridBagConstraints(2, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(mControlarpes, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(mPesuniven, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
    dataPanel.add(jULabel1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 11), 0, 0));
    dataPanel.add(mUniembEsp, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 18, 1));
    mUniembEsp.setColumns(5);
    dataPanel.add(jLabel2, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(jTextField2, new GridBagConstraints(2, 20, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 16, 0));
    dataPanel.add(jLabel3, new GridBagConstraints(1, 20, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
      
    // Layout the datapanel and the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaarticuloView1", null, "SgaarticuloView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);
    mModpesby.setDocument((Document)panelBinding.bindUIControl("Modpesby", mModpesby));
    mFecultmodpes.setDocument((Document)panelBinding.bindUIControl("Fecultmodpes", mFecultmodpes));
   
    mPesuniven.setDocument((Document)panelBinding.bindUIControl("Pesuniven", mPesuniven));
    mUniembEsp.setDocument((Document)panelBinding.bindUIControl("Uniembesp", mUniembEsp));
    if (!Interflex.getInstance().hasAcceso("SGAMODUNIEMBESP"))
      mUniembEsp.setEditable(false);
    jTextField2.setDocument((Document)panelBinding.bindUIControl("Tipprep", jTextField2));


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

    PanelSgaarticuloView1 panel = new PanelSgaarticuloView1();
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


  private void panelBinding_navigated(JUIteratorBinding iter, NavigationEvent event)
  {
    if (iter.getName().equals("SgaarticuloView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgaarticuloView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
    mIdartif.setEditable(isFindMode);
    mDescrip.setEditable(isFindMode);
    mPesunit.setEditable(isFindMode);
    // mControlarpes.setEnabled(isFindMode);
    mUniemb.setEditable(isFindMode);
    mCodean.setEditable(isFindMode);
    navBar.setHasInsertButton(isFindMode);
    navBar.setHasDeleteButton(isFindMode);
    mUniembEsp.setEditable(Interflex.getInstance().hasAcceso("SGAMODUNIEMBESP"));
    
    // Michael 04.10.2016
    if (!isFindMode)
    {
      mPesunit.setEditable(Interflex.getInstance().hasAcceso("SGAADMINISTRADOR"));
      mPesuniven.setEditable(Interflex.getInstance().hasAcceso("SGAADMINISTRADOR"));
    }
  }


/*  public void setBindingContext(BindingContext bindCtx)
  {
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      //Truc per que no executi la consulta nomes entrar
      //panelBinding.findIterBinding("SgaarticuloView1Iter").getViewObject().setMaxFetchSize(0);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
      //Truc per que no executi la consulta nomes entrar
      //panelBinding.findIterBinding("SgaarticuloView1Iter").getViewObject().setMaxFetchSize(-1);
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }

    }
  }*/
  
}