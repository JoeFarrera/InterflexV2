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
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import oracle.jbo.uicli.jui.JUPanelRowSetListener;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;

import sgalib.JUpperCaseTextField;
import sgalib.SgaJUPanel;

public class PanelSgavsumexistenciaView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavsumexistenciaView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JUpperCaseTextField mIdartif = new JUpperCaseTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescarticulo = new JLabel();
  private JUpperCaseTextField mDescarticulo = new JUpperCaseTextField();

// Fields for attribute:  Quantitat Total

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();

// Fields for attribute:  Quantitat Reservada

  private JLabel labelCanres = new JLabel();
  private JTextField mCanres = new JTextField();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavsumexistenciaView1()
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
    dataPanel.setMinimumSize(new Dimension(700, 171));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(700, 171));
    dataPanel.setMaximumSize(new Dimension(700, 171));

    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 200));
    this.setPreferredSize(new Dimension(700, 200));
    this.setMinimumSize(new Dimension(700, 200));
    this.setMaximumSize(new Dimension(700, 200));

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
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(14);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mDescarticulo.setDocument((Document)panelBinding.bindUIControl("Descarticulo", mDescarticulo));
    dataPanel.add(labelDescarticulo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescarticulo, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescarticulo.setLabelFor(mDescarticulo);
    mDescarticulo.setColumns(50);
    labelDescarticulo.setText(panelBinding.findCtrlValueBinding("Descarticulo").getLabel());
    mDescarticulo.setToolTipText(panelBinding.findCtrlValueBinding("Descarticulo").getTooltip());
    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    dataPanel.add(labelCantot, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantot, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(5);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());
    mCanres.setDocument((Document)panelBinding.bindUIControl("Canres", mCanres));
    dataPanel.add(labelCanres, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanres, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanres.setLabelFor(mCanres);
    mCanres.setColumns(5);
    labelCanres.setText(panelBinding.findCtrlValueBinding("Canres").getLabel());

    // Bind the navigation bar
    mCanres.setToolTipText(panelBinding.findCtrlValueBinding("Canres").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavsumexistenciaView1", null, "SgavsumexistenciaView1Iter"));
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

    PanelSgavsumexistenciaView1 panel = new PanelSgavsumexistenciaView1();
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
    if (iter.getName().equals("SgavsumexistenciaView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgavsumexistenciaView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
      //mIdartif.setEditable(isFindMode); // Actualitzant l'article, actualitza la relació
      mDescarticulo.setEditable(isFindMode);
      mCantot.setEditable(isFindMode);
      mCanres.setEditable(isFindMode);      
      navBar.setHasInsertButton(isFindMode);
      navBar.setHasDeleteButton(isFindMode);
  }


  public void setWhereClause(String whereClause)
  {
    try
    {
      panelBinding.findIteratorBinding("SgavsumexistenciaView1Iter").setFindMode(false);
      ViewObject voexist = panelBinding.findIteratorBinding("SgavsumexistenciaView1Iter").getViewObject();
      voexist.setWhereClause(whereClause);
      voexist.executeQuery();
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
}