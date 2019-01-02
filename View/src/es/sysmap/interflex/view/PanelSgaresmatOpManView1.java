package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.text.*;

import oracle.jbo.Key;
import oracle.jbo.RowInconsistentException;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jbo.domain.Number;

import oracle.jdeveloper.layout.*;

import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgaresmatOpManView1 extends SgaJUPanel implements Observer
// public class PanelSgaresmatOpManView1 extends JUPanel implements Observer

{

  // Para la modificación del peso
  PanelSgavarticulomodpesView panelModPes = null;

  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaresmatOpManView1UIModel");

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

// Fields for attribute:  Idlin

  private JLabel labelIdlin = new JLabel();
  private JTextField mIdlin = new JTextField();

// Fields for attribute:  Idmac

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Canres

  private JLabel labelCanres = new JLabel();
  private JTextField mCanres = new JTextField();

// Fields for attribute:  Idbulto

  private JLabel labelIdbulto = new JLabel();
  private JTextField mIdbulto = new JTextField();

// Fields for attribute:  Idcabstr

  private JTextField mIdcabstr = new JTextField();

// Fields for attribute:  Idcabnum

  private JTextField mIdcabnum = new JTextField();

// Fields for attribute:  Cantotbulto

  private JLabel labelCantotbulto = new JLabel();
  private JTextField mCantotbulto = new JTextField();

// Fields for attribute:  Canpenbulto

  private JLabel labelCanpenbulto = new JLabel();
  private JTextField mCanpenbulto = new JTextField();

// Fields for attribute:  Idartif

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Descart

  private JTextField mDescart = new JTextField();

// Fields for attribute:  Codean

  private JLabel labelCodean = new JLabel();
  private JTextField mCodean = new JTextField();

// Fields for attribute:  Descrip

  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Cantot

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();

// Fields for attribute:  Cancon

  private JLabel labelCancon = new JLabel();
  private JTextField mCancon = new JTextField();

// Fields for attribute:  Pesini

  private JLabel labelPesini = new JLabel();
  private JTextField mPesini = new JTextField();

// Fields for attribute:  Pesfin

  private JLabel labelPesfin = new JLabel();
  private JTextField mPesfin = new JTextField();

// Fields for attribute:  Canfin

  private JLabel labelCanfin = new JLabel();
  private JTextField mCanfin = new JTextField();

// Fields for attribute:  Difpes

  private JLabel labelDifpes = new JLabel();
  private JTextField mDifpes = new JTextField();

  private String tipoCarga = null;
  private String macEnPuesto = null;
  
  private JTextArea jTextArea1 = new JTextArea();

  private JLabel labelIntegra = new JLabel();
  private JCheckBox mIntegra = new JCheckBox();

  private PesadaBascula pesadaBascula = null;

  private Key key = null;
  private String cancon = null;
  private String pesini = null;
  private String pesfin = null;
  
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaresmatOpManView1(String tipoCarga)
  {
    this.tipoCarga = tipoCarga;
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
    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("EntradaReservada.entradaSilo")));
    else
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("EntradaReservada.entradaMiniLoad")));
    
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
    macPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("EntradaReservada.macPanel")));

    mIdcabstr.setDocument((Document)panelBinding.bindUIControl("Idcabstr", mIdcabstr));
    dataPanel.add(mIdcabstr, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mIdcabstr.setColumns(3);
    mIdcabstr.setEditable(false);
    mIdcabstr.setToolTipText(panelBinding.findCtrlValueBinding("Idcabstr").getTooltip());

    mIdcabnum.setDocument((Document)panelBinding.bindUIControl("Idcabnum", mIdcabnum));
    dataPanel.add(mIdcabnum, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mIdcabnum.setColumns(6);
    mIdcabnum.setEditable(false);
    mIdcabnum.setToolTipText(panelBinding.findCtrlValueBinding("Idcabnum").getTooltip());

    mIdlin.setDocument((Document)panelBinding.bindUIControl("Idlin", mIdlin));
    dataPanel.add(labelIdlin, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdlin, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdlin.setLabelFor(mIdlin);
    mIdlin.setColumns(2);
    mIdlin.setEditable(false);
    labelIdlin.setText(panelBinding.findCtrlValueBinding("Idlin").getLabel());
    mIdlin.setToolTipText(panelBinding.findCtrlValueBinding("Idlin").getTooltip());

    mIdbulto.setDocument((Document)panelBinding.bindUIControl("Idbulto", mIdbulto));
    dataPanel.add(labelIdbulto, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdbulto, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdbulto.setLabelFor(mIdbulto);
    mIdbulto.setColumns(2);
    mIdbulto.setEditable(false);
    labelIdbulto.setText(panelBinding.findCtrlValueBinding("Idbulto").getLabel());
    mIdbulto.setToolTipText(panelBinding.findCtrlValueBinding("Idbulto").getTooltip());

    mCantotbulto.setDocument((Document)panelBinding.bindUIControl("Cantotbulto", mCantotbulto));
    dataPanel.add(labelCantotbulto, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantotbulto, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantotbulto.setLabelFor(mCantotbulto);
    mCantotbulto.setColumns(6);
    mCantotbulto.setEditable(false);
    labelCantotbulto.setText(panelBinding.findCtrlValueBinding("Cantotbulto").getLabel());
    mCantotbulto.setToolTipText(panelBinding.findCtrlValueBinding("Cantotbulto").getTooltip());

    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    labelIdartif.setFont(new Font("Tahoma", 1, 14));
    mIdartif.setColumns(6);
    mIdartif.setEditable(false);
    mIdartif.setFont(new Font("Tahoma", 1, 14));
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());

    mCodean.setDocument((Document)panelBinding.bindUIControl("Codean", mCodean));
    dataPanel.add(labelCodean, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCodean, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCodean.setLabelFor(mCodean);
    mCodean.setColumns(10);
    mCodean.setEditable(false);
    labelCodean.setText(panelBinding.findCtrlValueBinding("Codean").getLabel());
    mCodean.setToolTipText(panelBinding.findCtrlValueBinding("Codean").getTooltip());

    mCanpenbulto.setDocument((Document)panelBinding.bindUIControl("Canpenbulto", mCanpenbulto));
    dataPanel.add(labelCanpenbulto, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanpenbulto, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanpenbulto.setLabelFor(mCanpenbulto);
    mCanpenbulto.setColumns(6);
    mCanpenbulto.setEditable(false);
    labelCanpenbulto.setText(panelBinding.findCtrlValueBinding("Canpenbulto").getLabel());
    mCanpenbulto.setToolTipText(panelBinding.findCtrlValueBinding("Canpenbulto").getTooltip());

    mDescart.setDocument((Document)panelBinding.bindUIControl("Descart", mDescart));
    dataPanel.add(mDescart, new GridBagConstraints(0, 2, 8, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));
    mDescart.setColumns(40);
    mDescart.setEditable(false);
    mDescart.setFont(new Font("Tahoma", 1, 14));
    mDescart.setToolTipText(panelBinding.findCtrlValueBinding("Descart").getTooltip());

    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    macPanel.add(labelIdmac, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIdmac, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(8);
    mIdmac.setEditable(false);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());

    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    macPanel.add(mDescrip, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mDescrip.setColumns(10);
    mDescrip.setEditable(false);
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());

    mIntegra.setModel((ButtonModel)panelBinding.bindUIControl("Integra", mIntegra));
    macPanel.add(labelIntegra, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIntegra, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIntegra.setLabelFor(mIntegra);
    labelIntegra.setText(panelBinding.findCtrlValueBinding("Integra").getLabel());
    mIntegra.setToolTipText(panelBinding.findCtrlValueBinding("Integra").getTooltip());

    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    macPanel.add(labelCantot, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCantot, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(6);
    mCantot.setEditable(false);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());

    mCanres.setDocument((Document)panelBinding.bindUIControl("Canres", mCanres));
    macPanel.add(labelCanres, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCanres, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanres.setLabelFor(mCanres);
    labelCanres.setFont(new Font("Tahoma", 1, 14));
    mCanres.setColumns(6);
    mCanres.setEditable(false);
    mCanres.setFont(new Font("Tahoma", 1, 14));
    labelCanres.setText(SgaRecursos.getInstance().getString("EntradaReservada.canres_label"));
    mCanres.setToolTipText(SgaRecursos.getInstance().getString("EntradaReservada.canres_tooltip"));

    mCancon.setDocument((Document)panelBinding.bindUIControl("Cancon", mCancon));
    macPanel.add(labelCancon, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCancon, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCancon.setLabelFor(mCancon);
    labelCancon.setFont(new Font("Tahoma", 1, 14));
    mCancon.setColumns(6);
    mCancon.setFont(new Font("Tahoma", 1, 14));
    labelCancon.setText(SgaRecursos.getInstance().getString("EntradaReservada.cancon_label"));
    mCancon.setToolTipText(SgaRecursos.getInstance().getString("EntradaReservada.cancon_tooltip"));

    mCanfin.setDocument((Document)panelBinding.bindUIControl("Canfin", mCanfin));
    macPanel.add(labelCanfin, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCanfin, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanfin.setLabelFor(mCanfin);
    mCanfin.setColumns(6);
    mCanfin.setEditable(false);
    labelCanfin.setText(SgaRecursos.getInstance().getString("EntradaReservada.canfin_label"));
    mCanfin.setToolTipText(SgaRecursos.getInstance().getString("EntradaReservada.canfin_tooltip"));

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

    mDifpes.setDocument((Document)panelBinding.bindUIControl("Difpes", mDifpes));
    macPanel.add(labelDifpes, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mDifpes, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelDifpes.setLabelFor(mDifpes);
    mDifpes.setColumns(6);
    mDifpes.setEditable(false);
    labelDifpes.setText(SgaRecursos.getInstance().getString("EntradaReservada.difpes_label"));
    mDifpes.setToolTipText(SgaRecursos.getInstance().getString("EntradaReservada.difpes_tooltip"));

    dataPanel.add(macPanel, new GridBagConstraints(0, 4, 6, 5, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));        

    jTextArea1.setText(SgaRecursos.getInstance().getString("EntradaReservada.descrip_label"));
    jTextArea1.setFont(new Font("Tahoma", 1, 18));
    jTextArea1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    jTextArea1.setBackground(SystemColor.control);
    jTextArea1.setEditable(false);
    dataPanel.add(jTextArea1, new GridBagConstraints(0, 9, 6, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));
    
    // Layout the datapanel and the navigation bar
    buttonAcceptar.setText(SgaRecursos.getInstance().getString("EntradaReservada.aceptar_label"));
    buttonAcceptar.setToolTipText(SgaRecursos.getInstance().getString("EntradaReservada.aceptar_tooltip"));
    buttonAcceptar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          confirmarEntrada();
        }
      });

    buttonCancelar.setText(SgaRecursos.getInstance().getString("EntradaReservada.cancelar_label"));
    buttonCancelar.setToolTipText(SgaRecursos.getInstance().getString("EntradaReservada.cancelar_tooltip"));
    buttonCancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cancelarEntrada();
        }
      });

    buttonsPanel.add(buttonAcceptar);
    buttonsPanel.add(buttonCancelar);
    
    add(dataPanel, BorderLayout.CENTER);

    add(buttonsPanel, BorderLayout.EAST);


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

    PanelSgaresmatOpManView1 panel = new PanelSgaresmatOpManView1(MDPanelOperacionsManuals.CARGA_SILO);
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
   */
  private void confirmarEntrada()
  {
    AppModule appModule = null;
    try
    {
      SgaresmatOpManViewRow resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
      if (resmat != null)
      {
        // 09/06/05:No deixem que faci una entrada amb quantitat 0
        if (!resmat.getCancon().equals(new Number(0)))
        {
          int action = 0;
          appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
          if (resmat.verificarPes(tipoCarga))
          {
              // Michael 16.12.2005 dar option a actualizar el peso
              action = PanelSgavarticulomodpesView.getUserActionModPes(appModule, mDifpes.getText(), mCancon.getText());
              // Michael 04.05.2006 Guardar el resultado para hacerlo después
          }
          // Guardar valores que se pierden con el commit
          String pesIni = mPesini.getText();
          String pesFin = mPesfin.getText();
          String macPuesto = macEnPuesto;
          
          switch (action)
          {
          case 1: // Modificar Peso unitario
          case 0: // Continuar sin modificar el peso
          {
            appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
            resmat.confirmarReserva();
            appModule.getTransaction().commit();
            
            // Michael 04.05.2006 modificar el peso unitario después de haber realizado el commit
            if (action == 1)
            {
              modPesUnitari(pesIni, pesFin, macPuesto);
            }

            String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
            MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, appModule.quizasManipular(puesto));
          }
          break;
        default:
          JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("EntradaReservada.entradaQuantitatZero"));
      }
    }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
      onConfirmarError();
    }
  }
  
  
  /**
   * Invocar el proceso de modificación del pes
   */
  private boolean modPesUnitari(String pesIni, String pesFin, String macPuesto)
  {
    if (panelModPes == null)
    {
      panelModPes = PanelSgavarticulomodpesView.getInstance(panelBinding.getBindingContext());
    }
    
    setVisible(false);
    boolean retVal = panelModPes.modPesUnitari (pesIni, pesFin, macPuesto);
    setVisible(true);
    return retVal;
  }


  /**
   * Cancel·la la introducció d'una carga nova al magatzem
   */
  private void cancelarEntrada()
  {
    try
    {
      // Guardem els valors originals
      cancon = mCancon.getText();
      pesini = mPesini.getText();
      pesfin = mPesfin.getText();

      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      Object [] options = {SgaRecursos.getInstance().getString("EliminarReserva.botoEliminar_label"), 
          SgaRecursos.getInstance().getString("EliminarReserva.botoAnularPendent_label"),
          SgaRecursos.getInstance().getString("EliminarReserva.botoCancelar_label")};
      int action = JOptionPane.showOptionDialog(Interflex.getInstance().getFrame(), 
          SgaRecursos.getInstance().getString("EliminarReserva.missatge"), 
          SgaRecursos.getInstance().getString("EliminarReserva.title") , 
          JOptionPane.YES_NO_OPTION, 
          JOptionPane.QUESTION_MESSAGE, null, options, options[(1)]);
  
      switch (action)
        {
        case 0:
        case 1:
          SgaresmatOpManViewRow resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
          if (resmat != null)
          {
            resmat.anularReserva(action == 1);
            appModule.getTransaction().commit();
          }
          break;
        case 2:
        case JOptionPane.CLOSED_OPTION:      
        default:      
          appModule.getTransaction().rollback();
          break;
        }
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, appModule.quizasManipular(puesto));
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Tractament d'un error al confirmar
   * Fem un rollback i restablim les dades entrades fins ara per l'usuari
   */
  private void onConfirmarError()
  {
    try
    {
      JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("EntradaReservada.errorOperacio"));    
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      // fem un rollback
      appModule.getTransaction().rollback();
      // tornem a establir el registre actual
      setCurrentRow(key);
      // restablim els valors entrats per l'usuari fins ara
      mCancon.setText(cancon);
      mCancon.postActionEvent();
      mPesini.setText(pesini);
      mPesini.postActionEvent();
      mPesfin.setText(pesfin);
      mPesfin.postActionEvent();
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
 
  public boolean setFocusInicial()
  {
    return (buttonAcceptar.requestFocusInWindow());
    //return (mCancon.requestFocusInWindow());
  }
  
  public void setCurrentRow(Key key)
  {
    this.key = key;
    panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").executeQuery();
    panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").setCurrentRowWithKey(key.toStringFormat(true));
    
    // Si trobem el registre, guardem l'identificador del mac sobre el que estem treballant
    SgaresmatOpManViewRow resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
    if (resmat != null)
      macEnPuesto = resmat.getIdmac();
    
  }

  private void mCancon_focusGained(FocusEvent e)
  {
    mCancon.selectAll();
  }


  public synchronized void update (Observable o, Object arg)
  {
    try
    {
      if (pesadaBascula == null)
        pesadaBascula = new PesadaBascula (mPesini, mPesfin, tipoCarga.equals(MDPanelOperacionsManuals.CARGA_MINILOAD));
      pesadaBascula.novaPesada((String) arg);
    }
    catch(Exception ex)
    {
      //TODO : No hauria d'arribar mai aquí
    }
  }
  
}