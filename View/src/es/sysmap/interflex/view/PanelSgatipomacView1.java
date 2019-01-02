package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.*;
import javax.swing.text.*;

import oracle.adf.model.*;

import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJUPanel;

public class PanelSgatipomacView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgatipomacView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idtipmac

  private JLabel labelIdtipmac = new JLabel();
  private JTextField mIdtipmac = new JTextField();

// Fields for attribute:  Descrip

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Numpos

  private JLabel labelNumpos = new JLabel();
  private JTextField mNumpos = new JTextField();

// Fields for attribute:  Numpos

  private JLabel labelTara = new JLabel();
  private JTextField mTara = new JTextField();

// Fields for attribute:  Numpos

  private JLabel labelTipplc = new JLabel();
  private JTextField mTipplc = new JTextField();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgatipomacView1()
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
    navBar.setMaximumSize(new Dimension(400, 26));
    navBar.setMinimumSize(new Dimension(400, 26));

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

    mIdtipmac.setDocument((Document)panelBinding.bindUIControl("Idtipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setColumns(10);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(20);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mNumpos.setDocument((Document)panelBinding.bindUIControl("Numpos", mNumpos));
    dataPanel.add(labelNumpos, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mNumpos, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelNumpos.setLabelFor(mNumpos);
    mNumpos.setColumns(5);
    labelNumpos.setText(panelBinding.findCtrlValueBinding("Numpos").getLabel());
    mNumpos.setToolTipText(panelBinding.findCtrlValueBinding("Numpos").getTooltip());
    mTara.setDocument((Document)panelBinding.bindUIControl("Tara", mTara));
    dataPanel.add(labelTara, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTara, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelTara.setLabelFor(mTara);
    mTara.setColumns(5);
    labelTara.setText(panelBinding.findCtrlValueBinding("Tara").getLabel());
    mTara.setToolTipText(panelBinding.findCtrlValueBinding("Tara").getTooltip());
    mTipplc.setDocument((Document)panelBinding.bindUIControl("Tipplc", mTipplc));
    labelTipplc.setText(panelBinding.findCtrlValueBinding("Tipplc").getLabel());
    dataPanel.add(labelTipplc, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTipplc, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelTipplc.setLabelFor(mTipplc);
    labelTipplc.setText(panelBinding.findCtrlValueBinding("Tipplc").getLabel());

    mTipplc.setColumns(5);
    mTipplc.setToolTipText(panelBinding.findCtrlValueBinding("Tipplc").getTooltip());

    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgatipomacView1", null, "SgatipomacView1Iter"));
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

    PanelSgatipomacView1 panel = new PanelSgatipomacView1();
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
    if (iter.getName().equals("SgatipomacView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgatipomacView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
    this.mIdtipmac.setEditable(isFindMode);
    navBar.setHasInsertButton(isFindMode);
    navBar.setHasDeleteButton(isFindMode);
  }
  

}