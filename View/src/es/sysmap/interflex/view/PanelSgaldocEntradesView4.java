package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaldocEntradesViewRow;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.event.FocusEvent;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.text.*;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.JUPanel;
import oracle.jbo.uicli.controls.JUTestFrame;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.VerticalFlowLayout;
import sgalib.RowSelectResult;
import sgalib.SgaJUErrorHandler;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgaldocEntradesView4 extends SgaJUPanel implements Observer
// public class PanelSgaldocEntradesView4 extends JPanel implements Observer, JUPanel
{
  PanelSgavarticulomodpesView panelModPes;
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaldocEntradesView4UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonAcceptar = new JButton();
  private JButton buttonCancelar = new JButton();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

  private JPanel macPanel = new JPanel();
  private GridBagLayout macPanelLayout = new GridBagLayout();
  
// Fields for attribute:  Idbulto

  private JLabel labelIdbulto = new JLabel();
  private JTextField mIdbulto = new JTextField();

// Fields for attribute:  Idcabstr

  private JTextField mIdcabstr = new JTextField();

// Fields for attribute:  Iddoc

  private JTextField mIdcabnum = new JTextField();

// Fields for attribute:  Id. Línia

  private JLabel labelIdlin = new JLabel();
  private JTextField mIdlin = new JTextField();

// Fields for attribute:  Quantitat bulto

  private JLabel labelCantotbulto = new JLabel();
  private JTextField mCantotbulto = new JTextField();

// Fields for attribute:  Quantitat Pendent

  private JLabel labelCanpenbulto = new JLabel();
  private JTextField mCanpenbulto = new JTextField();

// Fields for attribute:  Tipus Contenidor

  private JLabel labelIdtipmac = new JLabel();
  private JComboBox mIdtipmac = new JComboBox();

// Fields for attribute:  Reomplir

  private JLabel labelRelleno = new JLabel();
  private JTextField mRelleno = new JTextField();

// Fields for attribute:  Canres

  private JLabel labelCanres = new JLabel();
  private JTextField mCanres = new JTextField();

// Fields for attribute:  Canpen

  private JLabel labelCanpen = new JLabel();
  private JTextField mCanpen = new JTextField();

// Fields for attribute:  Id. Línia

  private JLabel labelMultiref = new JLabel();
  private JCheckBox mMultiref = new JCheckBox();

// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Descripció

  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Idmac

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Cancon

  private JLabel labelCancon = new JLabel();
  private JTextField mCancon = new JTextField();

// Fields for attribute:  Pesini

  private JLabel labelPesini = new JLabel();
  private JTextField mPesini = new JTextField();

// Fields for attribute:  Pesfin

  private JLabel labelPesfin = new JLabel();
  private JTextField mPesfin = new JTextField();

// Fields for attribute:  Difpes

  private JLabel labelDifpes = new JLabel();
  private JTextField mDifpes = new JTextField();
  
  private String tipoCarga = null;
  // Codi del contenedor si ja esta en el puesto i el sabem
  private String idmacEnPuesto = null;
  
  private PesadaBascula pesadaBascula = null;
  
  private JLabel labelIntegra = new JLabel();
  private JCheckBox mIntegra = new JCheckBox();
  
  // Si ha triat mes d'una linea
  private Key [] rowsSelected;
  private int rowIndex = 0; 
  private JTextField liniesPendents = new JTextField();
  
  
  
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaldocEntradesView4(String tipoCarga, String idmacEnPuesto, Key [] rows)
  {
    this.tipoCarga = tipoCarga;
    this.idmacEnPuesto = idmacEnPuesto;
    this.rowsSelected = rows;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    
    // Layout definition for this panel
    dataPanel.setLayout(panelLayout);
    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("NovaCarga.entradaSilo")));
    else
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("NovaCarga.entradaMiniLoad")));
    dataPanel.setMinimumSize(new Dimension(561, 275));
    dataPanel.setPreferredSize(new Dimension(561, 275));
    dataPanel.setMaximumSize(new Dimension(561, 275));
    
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(139, 275));
    buttonsPanel.setMinimumSize(new Dimension(139, 275));
    buttonsPanel.setMaximumSize(new Dimension(139, 275));
    
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 275));
    this.setPreferredSize(new Dimension(700, 275));
    this.setMinimumSize(new Dimension(700, 275));
    this.setMaximumSize(new Dimension(700, 275));

    macPanel.setLayout(macPanelLayout);
    macPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("NovaCarga.macPanel")));
    
    mIdcabstr.setDocument((Document)panelBinding.bindUIControl("Idcabstr", mIdcabstr));
    mIdartif.setFont(new Font("Tahoma", 1, 14));
    dataPanel.add(mIdcabstr, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mIdcabstr.setColumns(3);
    mIdcabstr.setToolTipText(panelBinding.findCtrlValueBinding("Idcabstr").getTooltip());
    mIdcabstr.setEditable(false);
    mIdcabstr.setFocusable(false);

    mIdcabnum.setDocument((Document)panelBinding.bindUIControl("Idcabnum", mIdcabnum));
    dataPanel.add(mIdcabnum, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mIdcabnum.setColumns(6);
    mIdcabnum.setToolTipText(panelBinding.findCtrlValueBinding("Idcabnum").getTooltip());
    mIdcabnum.setEditable(false);
    mIdcabnum.setFocusable(false);

    mIdlin.setDocument((Document)panelBinding.bindUIControl("Idlin", mIdlin));
    dataPanel.add(labelIdlin, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdlin, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdlin.setLabelFor(mIdlin);
    mIdlin.setColumns(2);
    labelIdlin.setText(panelBinding.findCtrlValueBinding("Idlin").getLabel());
    mIdlin.setToolTipText(panelBinding.findCtrlValueBinding("Idlin").getTooltip());
    mIdlin.setEditable(false);
    mIdlin.setFocusable(false);

    mIdbulto.setDocument((Document)panelBinding.bindUIControl("Idbulto", mIdbulto));
    dataPanel.add(labelIdbulto, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdbulto, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdbulto.setLabelFor(mIdbulto);
    mIdbulto.setColumns(2);
    labelIdbulto.setText(panelBinding.findCtrlValueBinding("Idbulto").getLabel());
    mIdbulto.setToolTipText(panelBinding.findCtrlValueBinding("Idbulto").getTooltip());
    mIdbulto.setEditable(false);
    mIdbulto.setFocusable(false);

    mCantotbulto.setDocument((Document)panelBinding.bindUIControl("Cantotbulto", mCantotbulto));
    dataPanel.add(labelCantotbulto, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantotbulto, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantotbulto.setLabelFor(mCantotbulto);
    mCantotbulto.setColumns(6);
    labelCantotbulto.setText(panelBinding.findCtrlValueBinding("Cantotbulto").getLabel());
    mCantotbulto.setToolTipText(panelBinding.findCtrlValueBinding("Cantotbulto").getTooltip());
    mCantotbulto.setEditable(false);
    mCantotbulto.setFocusable(false);

    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    labelIdartif.setFont(new Font("Tahoma", 1, 14));
    mIdartif.setColumns(6);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mIdartif.setEditable(false);
    mIdartif.setFont(new Font("Tahoma", 1, 14));
    mIdartif.setFocusable(false);

    mCanpenbulto.setDocument((Document)panelBinding.bindUIControl("Canpenbulto", mCanpenbulto));
    dataPanel.add(labelCanpenbulto, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanpenbulto, new GridBagConstraints(8, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanpenbulto.setLabelFor(mCanpenbulto);
    mCanpenbulto.setColumns(6);
    labelCanpenbulto.setText(panelBinding.findCtrlValueBinding("Canpenbulto").getLabel());
    mCanpenbulto.setToolTipText(panelBinding.findCtrlValueBinding("Canpenbulto").getTooltip());
    mCanpenbulto.setEditable(false);
    mCanpenbulto.setFocusable(false);

    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(mDescrip, new GridBagConstraints(0, 2, 9, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));
    mDescrip.setColumns(40);
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mDescrip.setEditable(false);
    mDescrip.setFont(new Font("Tahoma", 1, 14));
    mDescrip.setFocusable(false);

    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    macPanel.add(labelIdmac, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIdmac, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    labelIdmac.setFont(new Font("Tahoma", 1, 14));
    mIdmac.setColumns(8);
    mIdmac.setFont(new Font("Tahoma", 1, 14));
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());

    mCancon.setDocument((Document)panelBinding.bindUIControl("Cancon", mCancon));
    macPanel.add(labelCancon, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCancon, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCancon.setLabelFor(mCancon);
    labelCancon.setFont(new Font("Tahoma", 1, 14));
    mCancon.setColumns(6);
    labelCancon.setText(panelBinding.findCtrlValueBinding("Cancon").getLabel());
    mCancon.setToolTipText(panelBinding.findCtrlValueBinding("Cancon").getTooltip());
    mCancon.setFont(new Font("Tahoma", 1, 14));
    mCancon.addFocusListener(new FocusAdapter()
      {
        public void focusGained(FocusEvent e)
        {
          mCancon_focusGained(e);
        }
      });

    mIdtipmac.setModel((ComboBoxModel)panelBinding.bindUIControl("Idtipmac1", mIdtipmac));
    macPanel.add(labelIdtipmac, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIdtipmac, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setEditable(false);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_MINILOAD))
    {
      labelIdtipmac.setVisible(false);
      mIdtipmac.setVisible(false);  
    }

    mMultiref.setModel((ButtonModel)panelBinding.bindUIControl("Multiref", mMultiref));
    macPanel.add(labelMultiref, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mMultiref, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());

    mIntegra.setModel((ButtonModel)panelBinding.bindUIControl("Integra", mIntegra));
    macPanel.add(labelIntegra, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIntegra, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIntegra.setLabelFor(mIntegra);
    labelIntegra.setText(panelBinding.findCtrlValueBinding("Integra").getLabel());
    mIntegra.setToolTipText(panelBinding.findCtrlValueBinding("Integra").getTooltip());
    

    mDifpes.setDocument((Document)panelBinding.bindUIControl("Difpes", mDifpes));
    macPanel.add(labelDifpes, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mDifpes, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelDifpes.setLabelFor(mDifpes);
    mDifpes.setColumns(6);
    mDifpes.setEditable(false);
    labelDifpes.setText(panelBinding.findCtrlValueBinding("Difpes").getLabel());
    mDifpes.setToolTipText(panelBinding.findCtrlValueBinding("Difpes").getTooltip());

    mPesini.setDocument((Document)panelBinding.bindUIControl("Pesini", mPesini));
    macPanel.add(labelPesini, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mPesini, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPesini.setLabelFor(mPesini);
    mPesini.setColumns(6);
    mPesini.setEditable(false);
    labelPesini.setText(panelBinding.findCtrlValueBinding("Pesini").getLabel());
    mPesini.setToolTipText(panelBinding.findCtrlValueBinding("Pesini").getTooltip());

    mPesfin.setDocument((Document)panelBinding.bindUIControl("Pesfin", mPesfin));
    macPanel.add(labelPesfin, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mPesfin, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPesfin.setLabelFor(mPesfin);
    mPesfin.setColumns(6);
    mPesfin.setEditable(false);
    labelPesfin.setText(panelBinding.findCtrlValueBinding("Pesfin").getLabel());
    mPesfin.setToolTipText(panelBinding.findCtrlValueBinding("Pesfin").getTooltip());

    dataPanel.add(macPanel, new GridBagConstraints(0, 5, 9, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));        
    
    
    buttonAcceptar.setText(SgaRecursos.getInstance().getString("NovaCarga.aceptar_label"));
    buttonAcceptar.setToolTipText(SgaRecursos.getInstance().getString("NovaCarga.aceptar_tooltip"));
    buttonAcceptar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          acceptarCarga();
        }
      });

    buttonCancelar.setText(SgaRecursos.getInstance().getString("NovaCarga.cancelar_label"));
    buttonCancelar.setToolTipText(SgaRecursos.getInstance().getString("NovaCarga.cancelar_tooltip"));
    buttonCancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cancelarCarga();
        }
      });

    buttonsPanel.add(buttonAcceptar);
    buttonsPanel.add(buttonCancelar);
    
    add(dataPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.EAST);
    
    
    
    buttonsPanel.add(liniesPendents);
    int index = rowIndex + 1;
    liniesPendents.setText("Línia : " + index + " de " + rowsSelected.length);
    liniesPendents.setEditable(false);
  
    
    // Michael 09.03.2006 Just get first row for speed
    ViewObject vo = panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").getViewObject();
    vo.setMaxFetchSize(1);
    
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

    PanelSgaldocEntradesView4 panel = new PanelSgaldocEntradesView4(MDPanelOperacionsManuals.CARGA_SILO, null, null);
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
   * Introdueix una carga nova al magatzem
   * Michael 04.05.2006 Parece que esto se hace en PanelSgaresmatOpManView1 y no aquí
   * @deprecated
   */
  private void acceptarCarga()
  {
    boolean alreadyCommited = false;
    if (idmacEnPuesto == null)
      idmacEnPuesto = mIdmac.getText();
    AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
    try
    {
      if (verificarDades())
      {
        
        String idubi = appModule.getUbicacionPuesto(SgaUtilPuesto.getInstance().getProperty("LlocTreball"), tipoCarga);
        
        if (idubi != null)
        {
          SgaldocEntradesViewRow ldocEntrades = (SgaldocEntradesViewRow)panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").getCurrentRow();
          if (ldocEntrades != null)
          {
            int action = 0;
            if (ldocEntrades.verificarPes())
            {
                // Michael 16.12.2005 dar option a actualizar el peso
                action = PanelSgavarticulomodpesView.getUserActionModPes(appModule, mDifpes.getText(), mCancon.getText());
            }
            switch (action)
            {
              case 1:
                {
                 // Michael 19.12.2005 commit first to be able to get this MAC if it's new
                ldocEntrades.introduirCargaNova(idubi, tipoCarga);
                appModule.getTransaction().commit();
                System.out.println("commit realizado antes de modPesUnitari");
                appModule.clearVOCaches(null,true);
                // Michael 04.05.2006 Parece que no se esta recibiendo los datos actualizados
                alreadyCommited = true;
                modPesUnitari();
                // TODO: Independiente del resultado de modificar el peso, continua, ya ha realizado el commit

                }
                // Si ha realizado el control de peso, continua
              case 0:
                if (!alreadyCommited)
                {
                  ldocEntrades.introduirCargaNova(idubi, tipoCarga); 
                  appModule.getTransaction().commit();
                }
              // Continuar para refrescar la pantalla
              default:
                ; // Nada
                
                // TODO String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
                // TODO MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(idmacEnPuesto, tipoCarga, appModule.quizasManipular(puesto));
                break;
            }
            }
        }
          }
          // If multiple selection, set up next
          if (rowsSelected.length > (++rowIndex)) 
        {
          setCurrentRow(rowsSelected[rowIndex]);
          setFocusInicial();
          int index = rowIndex + 1;
          liniesPendents.setText("Línia " + index + " de " + rowsSelected.length);
        
        }
        else
        {
          String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
          MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(idmacEnPuesto, tipoCarga, appModule.quizasManipular(puesto));
        }
        }
        
        
      
    catch(Exception ex)
    {
      appModule.getTransaction().rollback();
      JUMetaObjectManager.reportException(null, ex);
      
    }
  }
  
  /**
   * Invocar el proceso de modificación del pes
   */
  private boolean modPesUnitari()
  {
    if (panelModPes == null)
    {
      panelModPes = PanelSgavarticulomodpesView.getInstance(panelBinding.getBindingContext());
    }
    
    return panelModPes.modPesUnitari (mPesini.getText(), mPesfin.getText(), idmacEnPuesto);
  }

  /**
   * Cancel·la la introducció d'una carga nova al magatzem
   */
  private void cancelarCarga()
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      appModule.getTransaction().rollback();
      MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(idmacEnPuesto, tipoCarga, appModule.quizasManipular(puesto)); 
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  /**
   * Verifica que s'hagin introduit les dades necessaries
   * @return 
   */
  private boolean verificarDades()
  {
    String missatge = null;
    if (mIdmac.getText() == null || mIdmac.getText().equals(""))
       missatge =  SgaRecursos.getInstance().getString("Documents.errorIdmac_label");
    else if (mCancon.getText() == null || mCancon.getText().equals(""))
      missatge =  SgaRecursos.getInstance().getString("Documents.errorCancon_label");
    else if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
    {
      if(mIdtipmac.getSelectedIndex() < 0 || mIdtipmac.getSelectedIndex() == mIdtipmac.getItemCount()-1) //  null
        missatge =  SgaRecursos.getInstance().getString("Documents.errorTipmac_label");
    }
    if (missatge != null)
      JOptionPane.showMessageDialog(Interflex.getInstance(), missatge);              
    return (missatge==null);
  }
  
  
 
  public boolean setFocusInicial()
  {
    if (idmacEnPuesto == null)
      return (mIdmac.requestFocusInWindow());
    else
    {
      mIdmac.setText(idmacEnPuesto);
      mIdmac.postActionEvent();
      mIdmac.setEditable(false);
      return (mCancon.requestFocusInWindow());
    }
  }
  
  public void setCurrentRow(Key key)
  {
    
    // Michael 28.01.2015 
    panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").getViewObject().clearCache();
    // Michael 28.01.2015 fin
    panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").executeQuery(); // Michael 19.12.2005 TODO - esto tarda  mucho
    panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").setCurrentRowWithKey(key.toStringFormat(true));
    
  }

  private void mCancon_focusGained(FocusEvent e)
  {
    mCancon.selectAll();
  }
  
  
  public synchronized void update (Observable o, Object arg)
  {
    try
    {
      SgaldocEntradesViewRow ldocEntrades = (SgaldocEntradesViewRow)panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").getCurrentRow();
      if (ldocEntrades != null)
      {
        ldocEntrades.quizasEstablirPesini();
        
        if (pesadaBascula == null)
          pesadaBascula = new PesadaBascula (mPesini, mPesfin, tipoCarga.equals(MDPanelOperacionsManuals.CARGA_MINILOAD));
        pesadaBascula.novaPesada((String) arg);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    };
   }
   
 
/*  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(getPanelBinding(), bindCtx);
  }
  
  public void setBindingContext(BindingContext bindCtx)
  {
    // Afegit xavi
    createPanelBinding(bindCtx);
    // Fi afegit xavi
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      //Truc per que no executi la consulta nomes entrar
      ViewObject vo = panelBinding.findIterBinding("SgaldocEntradesView3Iter").getViewObject();
      vo.setMaxFetchSize(0);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
        vo.setMaxFetchSize(-1);
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }
    }
  }
*/
  
}