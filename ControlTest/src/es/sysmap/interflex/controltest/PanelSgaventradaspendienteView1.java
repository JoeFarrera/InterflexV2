package es.sysmap.interflex.controltest;
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

public class PanelSgaventradaspendienteView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaventradaspendienteView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Iddoc

  private JLabel labelIddoc = new JLabel();
  private JTextField mIddoc = new JTextField();

// Fields for attribute:  Prioridad

  private JLabel labelPrioridad = new JLabel();
  private JTextField mPrioridad = new JTextField();

// Fields for attribute:  Estadocab

  private JLabel labelEstadocab = new JLabel();
  private JTextField mEstadocab = new JTextField();

// Fields for attribute:  Idlin

  private JLabel labelIdlin = new JLabel();
  private JTextField mIdlin = new JTextField();

// Fields for attribute:  Idbulto

  private JLabel labelIdbulto = new JLabel();
  private JTextField mIdbulto = new JTextField();

// Fields for attribute:  Cantot

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();

// Fields for attribute:  Canpen

  private JLabel labelCanpen = new JLabel();
  private JTextField mCanpen = new JTextField();

// Fields for attribute:  Canres

  private JLabel labelCanres = new JLabel();
  private JTextField mCanres = new JTextField();

// Fields for attribute:  Estadolinea

  private JLabel labelEstadolinea = new JLabel();
  private JTextField mEstadolinea = new JTextField();

// Fields for attribute:  Idpuesto

  private JLabel labelIdpuesto = new JLabel();
  private JTextField mIdpuesto = new JTextField();

// Fields for attribute:  Idart

  private JLabel labelIdart = new JLabel();
  private JTextField mIdart = new JTextField();

// Fields for attribute:  Idartif

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Idtipmac

  private JLabel labelIdtipmac = new JLabel();
  private JTextField mIdtipmac = new JTextField();

// Fields for attribute:  Relleno

  private JLabel labelRelleno = new JLabel();
  private JTextField mRelleno = new JTextField();

// Fields for attribute:  Tolfifo

  private JLabel labelTolfifo = new JLabel();
  private JTextField mTolfifo = new JTextField();

// Fields for attribute:  Controlpes

  private JLabel labelControlpes = new JLabel();
  private JTextField mControlpes = new JTextField();

// Fields for attribute:  Pesunit

  private JLabel labelPesunit = new JLabel();
  private JTextField mPesunit = new JTextField();

// Fields for attribute:  Unimac

  private JLabel labelUnimac = new JLabel();
  private JTextField mUnimac = new JTextField();

// Fields for attribute:  Rotacion

  private JLabel labelRotacion = new JLabel();
  private JTextField mRotacion = new JTextField();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaventradaspendienteView1()
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
    mIddoc.setDocument((Document)panelBinding.bindUIControl("Iddoc", mIddoc));
    dataPanel.add(labelIddoc, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIddoc, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIddoc.setLabelFor(mIddoc);
    mIddoc.setColumns(22);
    labelIddoc.setText(panelBinding.findCtrlValueBinding("Iddoc").getLabel());
    mIddoc.setToolTipText(panelBinding.findCtrlValueBinding("Iddoc").getTooltip());
    mPrioridad.setDocument((Document)panelBinding.bindUIControl("Prioridad", mPrioridad));
    dataPanel.add(labelPrioridad, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPrioridad, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPrioridad.setLabelFor(mPrioridad);
    mPrioridad.setColumns(22);
    labelPrioridad.setText(panelBinding.findCtrlValueBinding("Prioridad").getLabel());
    mPrioridad.setToolTipText(panelBinding.findCtrlValueBinding("Prioridad").getTooltip());
    mEstadocab.setDocument((Document)panelBinding.bindUIControl("Estadocab", mEstadocab));
    dataPanel.add(labelEstadocab, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstadocab, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelEstadocab.setLabelFor(mEstadocab);
    mEstadocab.setColumns(1);
    labelEstadocab.setText(panelBinding.findCtrlValueBinding("Estadocab").getLabel());
    mEstadocab.setToolTipText(panelBinding.findCtrlValueBinding("Estadocab").getTooltip());
    mIdlin.setDocument((Document)panelBinding.bindUIControl("Idlin", mIdlin));
    dataPanel.add(labelIdlin, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdlin, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdlin.setLabelFor(mIdlin);
    mIdlin.setColumns(22);
    labelIdlin.setText(panelBinding.findCtrlValueBinding("Idlin").getLabel());
    mIdlin.setToolTipText(panelBinding.findCtrlValueBinding("Idlin").getTooltip());
    mIdbulto.setDocument((Document)panelBinding.bindUIControl("Idbulto", mIdbulto));
    dataPanel.add(labelIdbulto, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdbulto, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdbulto.setLabelFor(mIdbulto);
    mIdbulto.setColumns(22);
    labelIdbulto.setText(panelBinding.findCtrlValueBinding("Idbulto").getLabel());
    mIdbulto.setToolTipText(panelBinding.findCtrlValueBinding("Idbulto").getTooltip());
    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    dataPanel.add(labelCantot, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantot, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(22);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());
    mCanpen.setDocument((Document)panelBinding.bindUIControl("Canpen", mCanpen));
    dataPanel.add(labelCanpen, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanpen, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelCanpen.setLabelFor(mCanpen);
    mCanpen.setColumns(22);
    labelCanpen.setText(panelBinding.findCtrlValueBinding("Canpen").getLabel());
    mCanpen.setToolTipText(panelBinding.findCtrlValueBinding("Canpen").getTooltip());
    mCanres.setDocument((Document)panelBinding.bindUIControl("Canres", mCanres));
    dataPanel.add(labelCanres, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanres, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelCanres.setLabelFor(mCanres);
    mCanres.setColumns(22);
    labelCanres.setText(panelBinding.findCtrlValueBinding("Canres").getLabel());
    mCanres.setToolTipText(panelBinding.findCtrlValueBinding("Canres").getTooltip());
    mEstadolinea.setDocument((Document)panelBinding.bindUIControl("Estadolinea", mEstadolinea));
    dataPanel.add(labelEstadolinea, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstadolinea, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelEstadolinea.setLabelFor(mEstadolinea);
    mEstadolinea.setColumns(1);
    labelEstadolinea.setText(panelBinding.findCtrlValueBinding("Estadolinea").getLabel());
    mEstadolinea.setToolTipText(panelBinding.findCtrlValueBinding("Estadolinea").getTooltip());
    mIdpuesto.setDocument((Document)panelBinding.bindUIControl("Idpuesto", mIdpuesto));
    dataPanel.add(labelIdpuesto, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdpuesto, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdpuesto.setLabelFor(mIdpuesto);
    mIdpuesto.setColumns(2);
    labelIdpuesto.setText(panelBinding.findCtrlValueBinding("Idpuesto").getLabel());
    mIdpuesto.setToolTipText(panelBinding.findCtrlValueBinding("Idpuesto").getTooltip());
    mIdart.setDocument((Document)panelBinding.bindUIControl("Idart", mIdart));
    dataPanel.add(labelIdart, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdart, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdart.setLabelFor(mIdart);
    mIdart.setColumns(14);
    labelIdart.setText(panelBinding.findCtrlValueBinding("Idart").getLabel());
    mIdart.setToolTipText(panelBinding.findCtrlValueBinding("Idart").getTooltip());
    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(14);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mIdtipmac.setDocument((Document)panelBinding.bindUIControl("Idtipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setColumns(3);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    mRelleno.setDocument((Document)panelBinding.bindUIControl("Relleno", mRelleno));
    dataPanel.add(labelRelleno, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mRelleno, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelRelleno.setLabelFor(mRelleno);
    mRelleno.setColumns(1);
    labelRelleno.setText(panelBinding.findCtrlValueBinding("Relleno").getLabel());
    mRelleno.setToolTipText(panelBinding.findCtrlValueBinding("Relleno").getTooltip());
    mTolfifo.setDocument((Document)panelBinding.bindUIControl("Tolfifo", mTolfifo));
    dataPanel.add(labelTolfifo, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTolfifo, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelTolfifo.setLabelFor(mTolfifo);
    mTolfifo.setColumns(22);
    labelTolfifo.setText(panelBinding.findCtrlValueBinding("Tolfifo").getLabel());
    mTolfifo.setToolTipText(panelBinding.findCtrlValueBinding("Tolfifo").getTooltip());
    mControlpes.setDocument((Document)panelBinding.bindUIControl("Controlpes", mControlpes));
    dataPanel.add(labelControlpes, new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mControlpes, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelControlpes.setLabelFor(mControlpes);
    mControlpes.setColumns(1);
    labelControlpes.setText(panelBinding.findCtrlValueBinding("Controlpes").getLabel());
    mControlpes.setToolTipText(panelBinding.findCtrlValueBinding("Controlpes").getTooltip());
    mPesunit.setDocument((Document)panelBinding.bindUIControl("Pesunit", mPesunit));
    dataPanel.add(labelPesunit, new GridBagConstraints(0, 16, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesunit, new GridBagConstraints(1, 16, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPesunit.setLabelFor(mPesunit);
    mPesunit.setColumns(22);
    labelPesunit.setText(panelBinding.findCtrlValueBinding("Pesunit").getLabel());
    mPesunit.setToolTipText(panelBinding.findCtrlValueBinding("Pesunit").getTooltip());
    mUnimac.setDocument((Document)panelBinding.bindUIControl("Unimac", mUnimac));
    dataPanel.add(labelUnimac, new GridBagConstraints(0, 17, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUnimac, new GridBagConstraints(1, 17, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelUnimac.setLabelFor(mUnimac);
    mUnimac.setColumns(22);
    labelUnimac.setText(panelBinding.findCtrlValueBinding("Unimac").getLabel());
    mUnimac.setToolTipText(panelBinding.findCtrlValueBinding("Unimac").getTooltip());
    mRotacion.setDocument((Document)panelBinding.bindUIControl("Rotacion", mRotacion));
    dataPanel.add(labelRotacion, new GridBagConstraints(0, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mRotacion, new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelRotacion.setLabelFor(mRotacion);
    mRotacion.setColumns(1);
    labelRotacion.setText(panelBinding.findCtrlValueBinding("Rotacion").getLabel());

    // Bind the navigation bar
    mRotacion.setToolTipText(panelBinding.findCtrlValueBinding("Rotacion").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaventradaspendienteView1", null, "SgaventradaspendienteView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);


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

    PanelSgaventradaspendienteView1 panel = new PanelSgaventradaspendienteView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "TestAppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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