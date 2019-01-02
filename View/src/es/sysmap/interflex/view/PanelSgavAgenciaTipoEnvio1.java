package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJUPanel;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;

// public class PanelSgavAgenciaTipoEnvio1 extends JPanel implements JUPanel 
public class PanelSgavAgenciaTipoEnvio1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavAgenciaTipoEnvio1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Iddoc


// Fields for attribute:  Idcabnum

  private JLabel labelIdcabnum = new JLabel();
  private JTextField mIdcabnum = new JTextField();

// Fields for attribute:  Codtra

  private JLabel labelCodtra = new JLabel();
  private JTextField mCodtra = new JTextField();

// Fields for attribute:  Tipoenvio

  private JLabel labelTipoenvio = new JLabel();
  private JTextArea mTipoenvio = new JTextArea();
  private JScrollPane scrollerTipoenvio = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavAgenciaTipoEnvio1()
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
    this.setSize(new Dimension(319, 183));
    mIdcabnum.setDocument((Document)panelBinding.bindUIControl("Idcabnum", mIdcabnum));
    dataPanel.add(labelIdcabnum, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdcabnum, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 99), -103, 1));
    labelIdcabnum.setLabelFor(mIdcabnum);
    mIdcabnum.setColumns(12);
    labelIdcabnum.setText(panelBinding.findCtrlValueBinding("Idcabnum").getLabel());
    mIdcabnum.setToolTipText(panelBinding.findCtrlValueBinding("Idcabnum").getTooltip());
    mCodtra.setDocument((Document)panelBinding.bindUIControl("Codtra", mCodtra));
    dataPanel.add(labelCodtra, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCodtra, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 130), 1, 1));
    labelCodtra.setLabelFor(mCodtra);
    mCodtra.setColumns(12);
    labelCodtra.setText(panelBinding.findCtrlValueBinding("Codtra").getLabel());
    mCodtra.setToolTipText(panelBinding.findCtrlValueBinding("Codtra").getTooltip());
    mTipoenvio.setDocument((Document)panelBinding.bindUIControl("Tipoenvio", mTipoenvio));
    dataPanel.add(labelTipoenvio, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(scrollerTipoenvio, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelTipoenvio.setLabelFor(scrollerTipoenvio);
    scrollerTipoenvio.getViewport().add(mTipoenvio);
    mTipoenvio.setColumns(30);
    mTipoenvio.setRows(2);
    labelTipoenvio.setText(panelBinding.findCtrlValueBinding("Tipoenvio").getLabel());

    // Bind the navigation bar
    mTipoenvio.setToolTipText(panelBinding.findCtrlValueBinding("Tipoenvio").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavAgenciaTipoEnvio1", null, "SgavAgenciaTipoEnvio1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    navBar.setHasTransactionButtons(false);
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);


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

    PanelSgavAgenciaTipoEnvio1 panel = new PanelSgavAgenciaTipoEnvio1();
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
/*
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
  */
  
   public void setWhereClause(String whereClause)
  {
    try
    {
      panelBinding.findIteratorBinding("SgavAgenciaTipoEnvio1Iter").setFindMode(false);
      ViewObject voexist = panelBinding.findIteratorBinding("SgavAgenciaTipoEnvio1Iter").getViewObject();
      voexist.setWhereClause(whereClause);
      voexist.executeQuery();
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
}