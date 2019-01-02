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

public class PanelSgaarticuloView3 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaarticuloView3UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Article


// Fields for attribute:  Article

  private JLabel labelIdart = new JLabel();
  private JTextField mIdart = new JTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Pes unitari (gms)

  private JLabel labelPesunit = new JLabel();
  private JTextField mPesunit = new JTextField();

// Fields for attribute:  Controlar Pes

  private JLabel labelControlpes = new JLabel();
  private JTextField mControlpes = new JTextField();

// Fields for attribute:  Unitats per embalatge

  private JLabel labelUniemb = new JLabel();
  private JTextField mUniemb = new JTextField();

// Fields for attribute:  Uniembesp

  private JLabel labelUniembesp = new JLabel();
  private JTextField mUniembesp = new JTextField();

// Fields for attribute:  Tipus contenidor

  private JLabel labelIdtipmac = new JLabel();
  private JTextField mIdtipmac = new JTextField();

// Fields for attribute:  Unitats per contenidor

  private JLabel labelUnimac = new JLabel();
  private JTextField mUnimac = new JTextField();

// Fields for attribute:  Pes per unitat (de picking)

  private JLabel labelPesuniven = new JLabel();
  private JTextField mPesuniven = new JTextField();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaarticuloView3()
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
    mIdart.setDocument((Document)panelBinding.bindUIControl("Idart", mIdart));
    dataPanel.add(labelIdart, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdart, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdart.setLabelFor(mIdart);
    mIdart.setColumns(15);
    labelIdart.setText(panelBinding.findCtrlValueBinding("Idart").getLabel());
    mIdart.setToolTipText(panelBinding.findCtrlValueBinding("Idart").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 2, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
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
    mControlpes.setDocument((Document)panelBinding.bindUIControl("Controlpes", mControlpes));
    dataPanel.add(labelControlpes, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mControlpes, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelControlpes.setLabelFor(mControlpes);
    mControlpes.setColumns(15);
    labelControlpes.setText(panelBinding.findCtrlValueBinding("Controlpes").getLabel());
    mControlpes.setToolTipText(panelBinding.findCtrlValueBinding("Controlpes").getTooltip());
    mUniemb.setDocument((Document)panelBinding.bindUIControl("Uniemb", mUniemb));
    dataPanel.add(labelUniemb, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUniemb, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelUniemb.setLabelFor(mUniemb);
    mUniemb.setColumns(15);
    labelUniemb.setText(panelBinding.findCtrlValueBinding("Uniemb").getLabel());
    mUniemb.setToolTipText(panelBinding.findCtrlValueBinding("Uniemb").getTooltip());
    mUniembesp.setDocument((Document)panelBinding.bindUIControl("Uniembesp", mUniembesp));
    dataPanel.add(labelUniembesp, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUniembesp, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelUniembesp.setLabelFor(mUniembesp);
    mUniembesp.setColumns(15);
    labelUniembesp.setText(panelBinding.findCtrlValueBinding("Uniembesp").getLabel());
    mUniembesp.setToolTipText(panelBinding.findCtrlValueBinding("Uniembesp").getTooltip());
    mIdtipmac.setDocument((Document)panelBinding.bindUIControl("Idtipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setColumns(15);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    mUnimac.setDocument((Document)panelBinding.bindUIControl("Unimac", mUnimac));
    dataPanel.add(labelUnimac, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUnimac, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelUnimac.setLabelFor(mUnimac);
    mUnimac.setColumns(15);
    labelUnimac.setText(panelBinding.findCtrlValueBinding("Unimac").getLabel());
    mUnimac.setToolTipText(panelBinding.findCtrlValueBinding("Unimac").getTooltip());
    mPesuniven.setDocument((Document)panelBinding.bindUIControl("Pesuniven", mPesuniven));
    dataPanel.add(labelPesuniven, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesuniven, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPesuniven.setLabelFor(mPesuniven);
    mPesuniven.setColumns(15);
    labelPesuniven.setText(panelBinding.findCtrlValueBinding("Pesuniven").getLabel());

    // Bind the navigation bar
    mPesuniven.setToolTipText(panelBinding.findCtrlValueBinding("Pesuniven").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaarticuloView3", null, "SgaarticuloView3Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    navBar.setHasTransactionButtons(false);


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

    PanelSgaarticuloView3 panel = new PanelSgaarticuloView3();
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