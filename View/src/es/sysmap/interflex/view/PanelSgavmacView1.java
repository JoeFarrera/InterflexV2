package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgavmacViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import java.awt.Dimension;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgavmacView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavmacView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idmac

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Multiref

  private JLabel labelMultiref = new JLabel();
  private JCheckBox mMultiref = new JCheckBox();

// Fields for attribute:  Idtipmac

  private JLabel labelIdtipmac = new JLabel();
  private JComboBox mIdtipmac = new JComboBox();

// Fields for attribute:  Estado

  private JLabel labelEstado = new JLabel();
  private JComboBox mEstado = new JComboBox();

// Fields for attribute:  Ubipos

  private JLabel labelUbipos = new JLabel();
  private JTextField mUbipos = new JTextField();

// Fields for attribute:  Descvisualpos

  private JTextField mDescvisualpos = new JTextField();

// Fields for attribute:  Posubipos

  private JLabel labelPosubipos = new JLabel();
  private JTextField mPosubipos = new JTextField();

// Fields for attribute:  Ubides

  private JLabel labelUbides = new JLabel();
  private JTextField mUbides = new JTextField();

// Fields for attribute:  Descvisualdes

  private JTextField mDescvisualdes = new JTextField();

// Fields for attribute:  Posubides

  private JLabel labelPosubides = new JLabel();
  private JTextField mPosubides = new JTextField();
  
  private JButton jButtonTreureMac = new JButton();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavmacView1()
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
    dataPanel.setMinimumSize(new Dimension(700, 271));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(700, 271));
    dataPanel.setMaximumSize(new Dimension(700, 271));

    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 300));
    this.setPreferredSize(new Dimension(700, 300));
    this.setMinimumSize(new Dimension(700, 300));
    this.setMaximumSize(new Dimension(700, 300));

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
    
    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(jButtonTreureMac, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(12);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());
    
    mMultiref.setModel((ButtonModel)panelBinding.bindUIControl("Multiref1", mMultiref));
    dataPanel.add(labelMultiref, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mMultiref, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());
    
    mIdtipmac.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setEditable(false);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    
    mEstado.setModel((ComboBoxModel)panelBinding.bindUIControl("Descestado", mEstado));
    dataPanel.add(labelEstado, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstado, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelEstado.setLabelFor(mEstado);
    mEstado.setEditable(false);
    labelEstado.setText(panelBinding.findCtrlValueBinding("Estado").getLabel());
    mEstado.setToolTipText(panelBinding.findCtrlValueBinding("Estado").getTooltip());
    
    mUbipos.setDocument((Document)panelBinding.bindUIControl("Ubipos", mUbipos));
    dataPanel.add(labelUbipos, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUbipos, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelUbipos.setLabelFor(mUbipos);
    mUbipos.setColumns(8);
    labelUbipos.setText(panelBinding.findCtrlValueBinding("Ubipos").getLabel());
    mUbipos.setToolTipText(panelBinding.findCtrlValueBinding("Ubipos").getTooltip());
    
    mDescvisualpos.setDocument((Document)panelBinding.bindUIControl("Descvisualpos", mDescvisualpos));
    dataPanel.add(mDescvisualpos, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mDescvisualpos.setColumns(40);
    mDescvisualpos.setToolTipText(panelBinding.findCtrlValueBinding("Descvisualpos").getTooltip());
    //mDescvisualpos.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    //mDescvisualpos.setBackground(new Color(212, 208, 200));
    
    mPosubipos.setDocument((Document)panelBinding.bindUIControl("Posubipos", mPosubipos));
    dataPanel.add(labelPosubipos, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPosubipos, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPosubipos.setLabelFor(mPosubipos);
    mPosubipos.setColumns(3);
    labelPosubipos.setText(panelBinding.findCtrlValueBinding("Posubipos").getLabel());
    mPosubipos.setToolTipText(panelBinding.findCtrlValueBinding("Posubipos").getTooltip());
    
    mUbides.setDocument((Document)panelBinding.bindUIControl("Ubides", mUbides));
    dataPanel.add(labelUbides, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUbides, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelUbides.setLabelFor(mUbides);
    mUbides.setColumns(8);
    labelUbides.setText(panelBinding.findCtrlValueBinding("Ubides").getLabel());
    mUbides.setToolTipText(panelBinding.findCtrlValueBinding("Ubides").getTooltip());
    
    mDescvisualdes.setDocument((Document)panelBinding.bindUIControl("Descvisualdes", mDescvisualdes));
    dataPanel.add(mDescvisualdes, new GridBagConstraints(0, 8, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mDescvisualdes.setColumns(40);
    mDescvisualdes.setToolTipText(panelBinding.findCtrlValueBinding("Descvisualdes").getTooltip());
    //mDescvisualdes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    //mDescvisualdes.setBackground(new Color(212, 208, 200));
    
    mPosubides.setDocument((Document)panelBinding.bindUIControl("Posubides", mPosubides));
    dataPanel.add(labelPosubides, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPosubides, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPosubides.setLabelFor(mPosubides);
    mPosubides.setColumns(3);
    labelPosubides.setText(panelBinding.findCtrlValueBinding("Posubides").getLabel());

    // Bind the navigation bar
    mPosubides.setToolTipText(panelBinding.findCtrlValueBinding("Posubides").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavmacView1", null, "SgavmacView1Iter"));

    jButtonTreureMac.setText(SgaRecursos.getInstance().getString("Contenidors.treureContenidor_label"));
    jButtonTreureMac.setToolTipText(SgaRecursos.getInstance().getString("Contenidors.treureContenidor_tooltip"));
    jButtonTreureMac.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonTreureMac_actionPerformed(e);
        }
      });

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

    PanelSgavmacView1 panel = new PanelSgavmacView1();
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
    if (iter.getName().equals("SgavmacView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgavmacView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
      mIdmac.setEditable(isFindMode); // Actualitzant el mac, actualitza també la relació
      mUbipos.setEditable(isFindMode);
      mPosubipos.setEditable(isFindMode);
      mUbides.setEditable(isFindMode);
      mPosubides.setEditable(isFindMode);    
      mDescvisualpos.setEditable(isFindMode);
      mDescvisualdes.setEditable(isFindMode);
  }


  /**
   * Treu el contenidor del magatzem
   * @param e
   * //TODO: Provisional. No demanar dades del puesto si es un puesto de treball
   */
  private void jButtonTreureMac_actionPerformed(ActionEvent e)
  {
    try
    {
      SgavmacViewRow macrow = (SgavmacViewRow)panelBinding.findIteratorBinding("SgavmacView1Iter").getCurrentRow(); 
      if (macrow != null)
      {
        boolean silo = !macrow.getIdtipmac().equals("CUB");
        TreureContenidor.treureContenidor((AppModule)getPanelBinding().getApplication().getApplicationModule(), macrow.getIdmac(), silo);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
}