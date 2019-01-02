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

import sgalib.SgaJUPanel;
import javax.swing.SwingConstants;

public class PanelSgapuestomanipView1 extends SgaJUPanel 
// public class PanelSgapuestomanipView1 extends JPanel implements JUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgapuestomanipView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Id. Lloc treball

  private JLabel labelIdpuesto = new JLabel();
  private JTextField mIdpuesto = new JTextField();

// Fields for attribute:  Id. Ubi. MiniLoad

  private JLabel labelIdubimld = new JLabel();
  private JTextField mIdubimld = new JTextField();

// Fields for attribute:  Id. Ubi. MaxiLoad

  private JLabel labelIdubislo = new JLabel();
  private JTextField mIdubislo = new JTextField();

// Fields for attribute:  Estat

  private JLabel labelEstado = new JLabel();
  private JComboBox mEstado = new JComboBox();

// Fields for attribute:  Sortides Automàtiques

  private JLabel labelAutoselordsal = new JLabel();
  private JCheckBox mAutoselordsal = new JCheckBox();

// Fields for attribute:  Ordres Sortida

  private JLabel labelNumordsal = new JLabel();
  private JTextField mNumordsal = new JTextField();
  private JCheckBox mBasculaMld = new JCheckBox();
  private JCheckBox mBasculaSlo = new JCheckBox();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgapuestomanipView1()
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

    mIdpuesto.setDocument((Document)panelBinding.bindUIControl("Idpuesto", mIdpuesto));
    mBasculaMld.setText("Báscula Mini Load");
    mBasculaMld.setToolTipText("Controlar el pes per la báscula");
    mBasculaMld.setHorizontalTextPosition(SwingConstants.LEADING);
    mBasculaSlo.setText("Báscula Maxi Load");
    mBasculaSlo.setHorizontalTextPosition(SwingConstants.LEADING);
    mBasculaSlo.setToolTipText("Controlar el pes per la báscula");
    dataPanel.add(labelIdpuesto, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdpuesto, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdpuesto.setLabelFor(mIdpuesto);
    mIdpuesto.setColumns(3);
    labelIdpuesto.setText(panelBinding.findCtrlValueBinding("Idpuesto").getLabel());
    mIdpuesto.setToolTipText(panelBinding.findCtrlValueBinding("Idpuesto").getTooltip());

    mIdubimld.setDocument((Document)panelBinding.bindUIControl("Idubimld", mIdubimld));
    dataPanel.add(labelIdubimld, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdubimld, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdubimld.setLabelFor(mIdubimld);
    mIdubimld.setColumns(10);
    labelIdubimld.setText(panelBinding.findCtrlValueBinding("Idubimld").getLabel());
    mIdubimld.setToolTipText(panelBinding.findCtrlValueBinding("Idubimld").getTooltip());

    mIdubislo.setDocument((Document)panelBinding.bindUIControl("Idubislo", mIdubislo));
    dataPanel.add(labelIdubislo, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdubislo, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdubislo.setLabelFor(mIdubislo);
    mIdubislo.setColumns(10);
    labelIdubislo.setText(panelBinding.findCtrlValueBinding("Idubislo").getLabel());
    mIdubislo.setToolTipText(panelBinding.findCtrlValueBinding("Idubislo").getTooltip());

    mEstado.setModel((ComboBoxModel)panelBinding.bindUIControl("Descestado", mEstado));
    dataPanel.add(labelEstado, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstado, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelEstado.setLabelFor(mEstado);
    mEstado.setEditable(false);
    labelEstado.setText(panelBinding.findCtrlValueBinding("Estado").getLabel());
    mEstado.setToolTipText(panelBinding.findCtrlValueBinding("Estado").getTooltip());

    mAutoselordsal.setModel((ButtonModel)panelBinding.bindUIControl("Autoselordsal1", mAutoselordsal));
    dataPanel.add(labelAutoselordsal, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mAutoselordsal, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelAutoselordsal.setLabelFor(mAutoselordsal);
    labelAutoselordsal.setText(panelBinding.findCtrlValueBinding("Autoselordsal").getLabel());
    mAutoselordsal.setToolTipText(panelBinding.findCtrlValueBinding("Autoselordsal").getTooltip());

    mNumordsal.setDocument((Document)panelBinding.bindUIControl("Numordsal", mNumordsal));
    dataPanel.add(labelNumordsal, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mNumordsal, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mBasculaMld, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    dataPanel.add(mBasculaSlo, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelNumordsal.setLabelFor(mNumordsal);
    mNumordsal.setColumns(4);
    labelNumordsal.setText(panelBinding.findCtrlValueBinding("Numordsal").getLabel());
    mNumordsal.setToolTipText(panelBinding.findCtrlValueBinding("Numordsal").getTooltip());
    
    // Layout the datapanel and the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgapuestomanipView1", null, "SgapuestomanipView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);
    mBasculaMld.setModel((ButtonModel)panelBinding.bindUIControl("Basculamld", mBasculaMld));
    mBasculaSlo.setModel((ButtonModel)panelBinding.bindUIControl("Basculaslo", mBasculaSlo));

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

    PanelSgapuestomanipView1 panel = new PanelSgapuestomanipView1();
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
    if (iter.getName().equals("SgapuestomanipView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgapuestomanipView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
    mIdpuesto.setEditable(isFindMode);
    navBar.setHasInsertButton(isFindMode);
    navBar.setHasDeleteButton(isFindMode);
  }  
  
}