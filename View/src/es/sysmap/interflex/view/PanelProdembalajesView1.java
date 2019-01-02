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
import sgalib.SgaJUPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class PanelProdembalajesView1 extends SgaJUPanel 
// public class PanelProdembalajesView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelProdembalajesView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idformato

  private JLabel labelIdformato = new JLabel();
  private JTextField mIdformato = new JTextField();

// Fields for attribute:  Refformato

  private JLabel labelRefformato = new JLabel();
  private JTextField mRefformato = new JTextField();

// Fields for attribute:  Descripcion

  private JLabel labelDescripcion = new JLabel();
  private JTextField mDescripcion = new JTextField();

// Fields for attribute:  Ep

  private JLabel labelEp = new JLabel();
  private JTextField mEp = new JTextField();

// Fields for attribute:  Alto

  private JLabel labelAlto = new JLabel();
  private JTextField mAlto = new JTextField();

// Fields for attribute:  Ancho

  private JLabel labelAncho = new JLabel();
  private JTextField mAncho = new JTextField();

// Fields for attribute:  Largo

  private JLabel labelLargo = new JLabel();
  private JTextField mLargo = new JTextField();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelProdembalajesView1()
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
    mIdformato.setDocument((Document)panelBinding.bindUIControl("Idformato", mIdformato));
    dataPanel.add(labelIdformato, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdformato, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdformato.setLabelFor(mIdformato);
    mIdformato.setColumns(15);
    labelIdformato.setText(panelBinding.findCtrlValueBinding("Idformato").getLabel());
    mIdformato.setToolTipText(panelBinding.findCtrlValueBinding("Idformato").getTooltip());
    mRefformato.setDocument((Document)panelBinding.bindUIControl("Refformato", mRefformato));
    dataPanel.add(labelRefformato, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mRefformato, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelRefformato.setLabelFor(mRefformato);
    mRefformato.setColumns(12);
    labelRefformato.setText(panelBinding.findCtrlValueBinding("Refformato").getLabel());
    mRefformato.setToolTipText(panelBinding.findCtrlValueBinding("Refformato").getTooltip());
    mDescripcion.setDocument((Document)panelBinding.bindUIControl("Descripcion", mDescripcion));
    dataPanel.add(labelDescripcion, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescripcion, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescripcion.setLabelFor(mDescripcion);
    mDescripcion.setColumns(30);
    labelDescripcion.setText(panelBinding.findCtrlValueBinding("Descripcion").getLabel());
    mDescripcion.setToolTipText(panelBinding.findCtrlValueBinding("Descripcion").getTooltip());
    mEp.setDocument((Document)panelBinding.bindUIControl("Ep", mEp));
    dataPanel.add(labelEp, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEp, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelEp.setLabelFor(mEp);
    mEp.setColumns(15);
    labelEp.setText(panelBinding.findCtrlValueBinding("Ep").getLabel());
    mEp.setToolTipText(panelBinding.findCtrlValueBinding("Ep").getTooltip());
    mAlto.setDocument((Document)panelBinding.bindUIControl("Alto", mAlto));
    dataPanel.add(labelAlto, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mAlto, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelAlto.setLabelFor(mAlto);
    mAlto.setColumns(15);
    labelAlto.setText(panelBinding.findCtrlValueBinding("Alto").getLabel());
    mAlto.setToolTipText(panelBinding.findCtrlValueBinding("Alto").getTooltip());
    mAncho.setDocument((Document)panelBinding.bindUIControl("Ancho", mAncho));
    dataPanel.add(labelAncho, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mAncho, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelAncho.setLabelFor(mAncho);
    mAncho.setColumns(15);
    labelAncho.setText(panelBinding.findCtrlValueBinding("Ancho").getLabel());
    mAncho.setToolTipText(panelBinding.findCtrlValueBinding("Ancho").getTooltip());
    mLargo.setDocument((Document)panelBinding.bindUIControl("Largo", mLargo));
    dataPanel.add(labelLargo, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mLargo, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelLargo.setLabelFor(mLargo);
    mLargo.setColumns(15);
    labelLargo.setText(panelBinding.findCtrlValueBinding("Largo").getLabel());

    // Bind the navigation bar
    mLargo.setToolTipText(panelBinding.findCtrlValueBinding("Largo").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "ProdembalajesView1", null, "ProdembalajesView1Iter"));
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

    PanelProdembalajesView1 panel = new PanelProdembalajesView1();
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