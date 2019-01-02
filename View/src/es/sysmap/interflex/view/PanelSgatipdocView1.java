package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.BorderFactory;
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

import sgalib.SgaJUPanel;

public class PanelSgatipdocView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgatipdocView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idtipdoc

  private JLabel labelIdtipdoc = new JLabel();
  private JTextField mIdtipdoc = new JTextField();

// Fields for attribute:  Descrip

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Tipmov

  private JLabel labelTipmov = new JLabel();
  private JComboBox mTipmov = new JComboBox();

// Fields for attribute:  Host

  private JLabel labelHost = new JLabel();
  private JCheckBox mHost = new JCheckBox();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgatipdocView1()
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
    dataPanel.setMinimumSize(new Dimension(400, 253));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(400, 253));
    dataPanel.setMaximumSize(new Dimension(400, 253));

    navBar.setPreferredSize(new Dimension(400, 26));
    navBar.setMinimumSize(new Dimension(400, 26));
    navBar.setMaximumSize(new Dimension(400, 26));

    this.setLayout(borderLayout);
    this.setPreferredSize(new Dimension(400, 300));
    this.setMinimumSize(new Dimension(400, 300));
    this.setMaximumSize(new Dimension(400, 300));

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

    mIdtipdoc.setDocument((Document)panelBinding.bindUIControl("Idtipdoc", mIdtipdoc));
    dataPanel.add(labelIdtipdoc, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipdoc, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipdoc.setLabelFor(mIdtipdoc);
    mIdtipdoc.setColumns(3);
    labelIdtipdoc.setText(panelBinding.findCtrlValueBinding("Idtipdoc").getLabel());
    mIdtipdoc.setToolTipText(panelBinding.findCtrlValueBinding("Idtipdoc").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(15);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mTipmov.setModel((ComboBoxModel)panelBinding.bindUIControl("DescTipmov", mTipmov));
    dataPanel.add(labelTipmov, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTipmov, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelTipmov.setLabelFor(mTipmov);
    mTipmov.setEditable(false);
    labelTipmov.setText(panelBinding.findCtrlValueBinding("Tipmov").getLabel());
    mTipmov.setToolTipText(panelBinding.findCtrlValueBinding("Tipmov").getTooltip());
    mHost.setModel((ButtonModel)panelBinding.bindUIControl("Host1", mHost));
    dataPanel.add(labelHost, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mHost, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelHost.setLabelFor(mHost);
    labelHost.setText(panelBinding.findCtrlValueBinding("Host").getLabel());
    mHost.setToolTipText(panelBinding.findCtrlValueBinding("Host").getTooltip());

    // Bind the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgatipdocView1", null, "SgatipdocView1Iter"));
    // Layout the datapanel and the navigation bar
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);
 

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

    PanelSgatipdocView1 panel = new PanelSgatipdocView1();
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
    if (iter.getName().equals("SgatipdocView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgatipdocView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
    mIdtipdoc.setEditable(isFindMode);
    navBar.setHasInsertButton(isFindMode);
    navBar.setHasDeleteButton(isFindMode);
  }
  
}