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

public class PanelSgatipoalmacenView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgatipoalmacenView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Tipus Magatzem

  private JLabel labelIdtipalm = new JLabel();
  private JTextField mIdtipalm = new JTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgatipoalmacenView1()
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
    dataPanel.setMinimumSize(new Dimension(494, 253));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(494, 253));
    dataPanel.setMaximumSize(new Dimension(494, 253));

    navBar.setSize(new Dimension(400, 26));
    navBar.setPreferredSize(new Dimension(494, 26));
    navBar.setMaximumSize(new Dimension(494, 26));
    navBar.setMinimumSize(new Dimension(494, 26));

    this.setLayout(borderLayout);
    this.setSize(new Dimension(494, 300));
    this.setPreferredSize(new Dimension(494, 300));
    this.setMinimumSize(new Dimension(494, 300));
    this.setMaximumSize(new Dimension(494, 300));

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

    mIdtipalm.setDocument((Document)panelBinding.bindUIControl("Idtipalm", mIdtipalm));
    dataPanel.add(labelIdtipalm, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipalm, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipalm.setLabelFor(mIdtipalm);
    mIdtipalm.setColumns(5);
    labelIdtipalm.setText(panelBinding.findCtrlValueBinding("Idtipalm").getLabel());
    mIdtipalm.setToolTipText(panelBinding.findCtrlValueBinding("Idtipalm").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(25);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgatipoalmacenView1", null, "SgatipoalmacenView1Iter"));
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

    PanelSgatipoalmacenView1 panel = new PanelSgatipoalmacenView1();
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
    if (iter.getName().equals("SgatipoalmacenView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgatipoalmacenView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
    mIdtipalm.setEditable(isFindMode);
    navBar.setHasInsertButton(isFindMode);
    navBar.setHasDeleteButton(isFindMode);
  }
  
}