package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacViewRow;

import java.awt.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.*;

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
import sgalib.SgaRecursos;

public class PanelSgamacView1 extends SgaJUPanel 
// public class PanelSgamacView1 extends JPanel implements JUPanel 

{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgamacView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel subpanel = new JPanel();
  private BorderLayout subpanelLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Contenidor

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Multireferencia

  private JLabel labelMultiref = new JLabel();
  private JCheckBox mMultiref = new JCheckBox();

// Fields for attribute:  Tipus Contenidor

  private JLabel labelIdtipmac = new JLabel();
  private JComboBox mIdtipmac = new JComboBox();

// Fields for attribute:  Estat

  private JLabel labelEstado = new JLabel();
  private JComboBox mEstado = new JComboBox();

// Fields for attribute:  Ubicació actual

  private JLabel labelUbipos = new JLabel();
  private JTextField mUbipos = new JTextField();

// Fields for attribute:  Posició actual

  private JLabel labelPosubipos = new JLabel();
  private JTextField mPosubipos = new JTextField();

// Fields for attribute:  Ubicació desti

  private JLabel labelUbides = new JLabel();
  private JTextField mUbides = new JTextField();

// Fields for attribute:  Posició destí

  private JLabel labelPosubides = new JLabel();
  private JTextField mPosubides = new JTextField();

// Fields for attribute:  Descripvisual
  private JTextField mDescripvisualpos = new JTextField();

// Fields for attribute:  Descripvisual
  private JTextField mDescripvisualdes = new JTextField();
  
  private JButton jButtonTreureMac = new JButton();
  private JButton jButtonEliminarMac = new JButton();
  private JButton jButtonSituarEnPuestoMac = new JButton();

// Fields for attribute:  Tara
  private JLabel labelTara = new JLabel();
  private JTextField mTara = new JTextField();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgamacView1()
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
    
    subpanel.setLayout(subpanelLayout);
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(400, 37));
    buttonsPanel.setMinimumSize(new Dimension(400, 37));
    buttonsPanel.setMaximumSize(new Dimension(400, 37));
    buttonsPanel.setSize(new Dimension(400, 37));

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

    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(jButtonTreureMac, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(10);
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
    mUbipos.setColumns(10);
    labelUbipos.setText(panelBinding.findCtrlValueBinding("Ubipos").getLabel());
    mUbipos.setToolTipText(panelBinding.findCtrlValueBinding("Ubipos").getTooltip());

    mDescripvisualpos.setDocument((Document)panelBinding.bindUIControl("Descripvisualpos", mDescripvisualpos));
    dataPanel.add(mDescripvisualpos, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mDescripvisualpos.setColumns(40);
    mDescripvisualpos.setToolTipText(panelBinding.findCtrlValueBinding("Descripvisualpos").getTooltip());
    //mDescripvisualpos.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    mDescripvisualpos.setBackground(new Color(212, 208, 200));

    mPosubipos.setDocument((Document)panelBinding.bindUIControl("Posubipos", mPosubipos));
    dataPanel.add(labelPosubipos, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPosubipos, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPosubipos.setLabelFor(mPosubipos);
    mPosubipos.setColumns(5);
    labelPosubipos.setText(panelBinding.findCtrlValueBinding("Posubipos").getLabel());
    mPosubipos.setToolTipText(panelBinding.findCtrlValueBinding("Posubipos").getTooltip());

    mUbides.setDocument((Document)panelBinding.bindUIControl("Ubides", mUbides));
    dataPanel.add(labelUbides, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUbides, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelUbides.setLabelFor(mUbides);
    mUbides.setColumns(10);
    labelUbides.setText(panelBinding.findCtrlValueBinding("Ubides").getLabel());
    mUbides.setToolTipText(panelBinding.findCtrlValueBinding("Ubides").getTooltip());

    mDescripvisualdes.setDocument((Document)panelBinding.bindUIControl("Descripvisualdes", mDescripvisualdes));
    dataPanel.add(mDescripvisualdes, new GridBagConstraints(0, 8, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mDescripvisualdes.setColumns(40);
    mDescripvisualdes.setToolTipText(panelBinding.findCtrlValueBinding("Descripvisualdes").getTooltip());
    //mDescripvisualdes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    mDescripvisualdes.setBackground(new Color(212, 208, 200));

    mPosubides.setDocument((Document)panelBinding.bindUIControl("Posubides", mPosubides));
    dataPanel.add(labelPosubides, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPosubides, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPosubides.setLabelFor(mPosubides);
    mPosubides.setColumns(5);
    labelPosubides.setText(panelBinding.findCtrlValueBinding("Posubides").getLabel());
    mPosubides.setToolTipText(panelBinding.findCtrlValueBinding("Posubides").getTooltip());

    mTara.setDocument((Document)panelBinding.bindUIControl("Tara", mTara));
    dataPanel.add(labelTara, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTara, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelTara.setLabelFor(mTara);
    mTara.setColumns(6);
    labelTara.setText(panelBinding.findCtrlValueBinding("Tara").getLabel());
    mTara.setToolTipText(panelBinding.findCtrlValueBinding("Tara").getTooltip());

    jButtonTreureMac.setText(SgaRecursos.getInstance().getString("Contenidors.treureContenidor_label"));
    jButtonTreureMac.setToolTipText(SgaRecursos.getInstance().getString("Contenidors.treureContenidor_tooltip"));
    jButtonTreureMac.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonTreureMac_actionPerformed(e);
        }
      });

    jButtonEliminarMac.setText(SgaRecursos.getInstance().getString("Contenidors.eliminarContenidor_label"));
    jButtonEliminarMac.setToolTipText(SgaRecursos.getInstance().getString("Contenidors.eliminarContenidor_tooltip"));
    jButtonEliminarMac.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonEliminarMac_actionPerformed(e);
        }
      });

    jButtonSituarEnPuestoMac.setText(SgaRecursos.getInstance().getString("Contenidors.situarEnPuestoContenidor_label"));
    jButtonSituarEnPuestoMac.setToolTipText(SgaRecursos.getInstance().getString("Contenidors.situarEnPuestoContenidor_tooltip"));
    jButtonSituarEnPuestoMac.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonSituarEnPuestoMac_actionPerformed(e);
        }
      });
    
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgamacView1", null, "SgamacView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    
    buttonsPanel.add(jButtonTreureMac);
    buttonsPanel.add(jButtonEliminarMac);
    buttonsPanel.add(jButtonSituarEnPuestoMac);
    add(navBar, BorderLayout.NORTH);
    subpanel.add(dataPanel, BorderLayout.CENTER);
    subpanel.add(buttonsPanel, BorderLayout.SOUTH);
    add(subpanel, BorderLayout.CENTER);
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

    PanelSgamacView1 panel = new PanelSgamacView1();
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


  /**
   * Treu el contenidor del magatzem
   * @param e
   */
  private void jButtonTreureMac_actionPerformed(ActionEvent e)
  {
    try
    {
      SgamacViewRow macrow = (SgamacViewRow)panelBinding.findIteratorBinding("SgamacView1Iter").getCurrentRow(); 
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

  /**
   * Treu el contenidor del magatzem
   * @param e
   */
  private void jButtonSituarEnPuestoMac_actionPerformed(ActionEvent e)
  {
    try
    {
      SgamacViewRow macrow = (SgamacViewRow)panelBinding.findIteratorBinding("SgamacView1Iter").getCurrentRow(); 
      if (macrow != null)
      {
        Object []     message = new Object[3];
        message [0] = SgaRecursos.getInstance().getString("Contenidors.situarEnPuestoContenidor_tooltip") +  " " + macrow.getIdmac();
        message [1] = " ";  // Para que haya un hueco
        
        JComboBox cb = new JComboBox();
        if (macrow.isMiniload())
        {
          cb.addItem("PK1MLD"); 
          cb.addItem("PK2MLD");
        }
        else
        {
          cb.addItem("PK1SLO");
          cb.addItem("PK2SLO");
          cb.addItem("PKEXTR");
        }
    
        message [2] = cb;
      
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                            SgaRecursos.getInstance().getString("Options.cancelar_label") };

        int eleccion = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            message,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Contenidors.triarDestiContenidor_label"),            // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.INFORMATION_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            options[0]                                  // option that should be made into a default button
            );
      if (eleccion == 0)
      {
        // Ha aceptado algo
        String puesto = (String)cb.getSelectedItem();
        macrow.situarEnPuesto(puesto);
        AppModule am = (AppModule)getPanelBinding().getApplication().getApplicationModule();
        am.getTransaction().commit();;
      }
      }
      }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  /**
   * Elimina el contenidor del magatzem
   * //TODO: 
   * @param e
   */
  private void jButtonEliminarMac_actionPerformed(ActionEvent e)
  {
    try
    {
      SgamacViewRow macrow = (SgamacViewRow)panelBinding.findIteratorBinding("SgamacView1Iter").getCurrentRow(); 
      if (macrow != null)
      {
        int action = 0;
        if (macrow.hasExistencies())
        {
          // Options
          String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                              SgaRecursos.getInstance().getString("Options.cancelar_label") };
        
          action = JOptionPane.showOptionDialog(Interflex.getInstance().getFrame(), 
              SgaRecursos.getInstance().getString("Contenidors.eliminarExistecies") + macrow.getIdmac(),              
              SgaRecursos.getInstance().getString("Contenidors.eliminarContenidor_label") , 
              JOptionPane.YES_NO_OPTION, 
              JOptionPane.QUESTION_MESSAGE, null, options, options[(1)]);
        }
        if (action == 0)
        {
          macrow.remove();
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          panelBinding.execute();
        }
        
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  

 
  
  private void panelBinding_navigated(JUIteratorBinding iter, NavigationEvent event)
  {
    if (iter.getName().equals("SgamacView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgamacView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }

  private void refresh(boolean isFindMode)
  {
    //mIdmac.setEditable(isFindMode);
    mDescripvisualpos.setEditable(isFindMode);
    mDescripvisualdes.setEditable(isFindMode);
    //navBar.setHasInsertButton(isFindMode);
    navBar.setHasDeleteButton(isFindMode);
  }
  
  
}