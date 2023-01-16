package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaresmatOpManViewRow;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.*;
import javax.swing.text.Document;

import oracle.jbo.Key;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.*;

import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;


public class PanelSgaresmatOpManView2 extends SgaJUPanel implements Observer
// public class PanelSgaresmatOpManView2 extends JPanel implements Observer, JUPanel

{

  // Para la modificación del peso
  PanelSgavarticulomodpesView panelModPes = null;

  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaresmatOpManView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonAcceptar = new JButton();
  private JButton buttonCancelar = new JButton();
  private JButton buttonNouBulto = new JButton();
  private JButton buttonMultiBulto = new JButton();
  private JButton buttonTancarBulto = new JButton();
  private JButton buttonVeureOrdre = new JButton();
  private JButton buttonMultiBulto_ = new JButton();
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

// Fields for attribute:  Idcabstr

  private JTextField mIdcabstr = new JTextField();

// Fields for attribute:  Idcabnum

  private JTextField mIdcabnum = new JTextField();

// Fields for attribute:  Cantotldoc

  private JLabel labelCantotldoc = new JLabel();
  private JTextField mCantotldoc = new JTextField();

// Fields for attribute:  Canpenldoc

  private JLabel labelCanpenldoc = new JLabel();
  private JTextField mCanpenldoc = new JTextField();

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

  private SgaJTable tableSgavldocView2 = new SgaJTable();

  private JScrollPane scroller = new JScrollPane();
  
  // Fields for attribute:  Idbulto
  private JLabel labelIdbulto = new JLabel();
  private JComboBox mIdbulto = new JComboBox();
  
  //private Number idbulto = null;
//  private Number cantBulto = new Number(0);
  private Number[] cantBulto = {new Number(0)};
  private boolean bFraccionar = false;
  
  private JTextArea jTextArea1 = new JTextArea();
  private JTextArea jTextMultiref = new JTextArea(); // Indica si es tracta d'una sortida multireferencia
  
  //Indica si s'ha de tancar el bulto despres de fer la sortida
  private boolean tancarBulto = false;
  
  private PesadaBascula pesadaBascula = null;
  
  private Key key = null;
  private String cancon = null;
  private String pesini = null;
  private String pesfin = null;
  
  
  
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaresmatOpManView2(String tipoCarga)
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
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("SortidaReservada.sortidaSilo")));
    else
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("SortidaReservada.sortidaMiniLoad")));
    
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

    // Layout definition for this panel
    dataPanel.setLayout(panelLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("SortidaReservada.sortidaSilo")));
    else
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("SortidaReservada.sortidaMiniLoad")));
    
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
    this.setFont(new Font("Tahoma", 1, 18));

    scroller.setSize(new Dimension(150, 100));
    scroller.setPreferredSize(new Dimension(150, 100));
    scroller.setMaximumSize(new Dimension(150, 100));
    scroller.setMinimumSize(new Dimension(150, 100));
    
    macPanel.setLayout(macPanelLayout);
    macPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("SortidaReservada.macPanel")));
    

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

    mCantotldoc.setDocument((Document)panelBinding.bindUIControl("Cantotldoc", mCantotldoc));
    dataPanel.add(labelCantotldoc, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantotldoc, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantotldoc.setLabelFor(mCantotldoc);
    mCantotldoc.setColumns(6);
    mCantotldoc.setEditable(false);
    labelCantotldoc.setText(panelBinding.findCtrlValueBinding("Cantotldoc").getLabel());
    mCantotldoc.setToolTipText(panelBinding.findCtrlValueBinding("Cantotldoc").getTooltip());

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

    mCanpenldoc.setDocument((Document)panelBinding.bindUIControl("Canpenldoc", mCanpenldoc));
    dataPanel.add(labelCanpenldoc, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanpenldoc, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanpenldoc.setLabelFor(mCanpenldoc);
    mCanpenldoc.setColumns(6);
    mCanpenldoc.setEditable(false);
    labelCanpenldoc.setText(panelBinding.findCtrlValueBinding("Canpenldoc").getLabel());
    mCanpenldoc.setToolTipText(panelBinding.findCtrlValueBinding("Canpenldoc").getTooltip());

    mDescart.setDocument((Document)panelBinding.bindUIControl("Descart", mDescart));
    dataPanel.add(mDescart, new GridBagConstraints(0, 2, 8, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));
    mDescart.setColumns(40);
    mDescart.setEditable(false);
    mDescart.setFont(new Font("Tahoma", 1, 12));
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
    labelCanres.setText(SgaRecursos.getInstance().getString("SortidaReservada.canres_label"));
    mCanres.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.canres_tooltip"));

    mCancon.setDocument((Document)panelBinding.bindUIControl("Cancon", mCancon));
    macPanel.add(labelCancon, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCancon, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCancon.setLabelFor(mCancon);
    labelCancon.setFont(new Font("Tahoma", 1, 14));
    mCancon.setColumns(6);
    mCancon.setFont(new Font("Tahoma", 1, 14));
    labelCancon.setText(SgaRecursos.getInstance().getString("SortidaReservada.cancon_label"));
    mCancon.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.cancon_tooltip"));

    mCanfin.setDocument((Document)panelBinding.bindUIControl("Canfin", mCanfin));
    macPanel.add(labelCanfin, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCanfin, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanfin.setLabelFor(mCanfin);
    mCanfin.setColumns(6);
    mCanfin.setEditable(false);
    labelCanfin.setText(SgaRecursos.getInstance().getString("SortidaReservada.canfin_label"));
    mCanfin.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.canfin_tooltip"));

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
    labelDifpes.setText(SgaRecursos.getInstance().getString("SortidaReservada.difpes_label"));
    mDifpes.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.difpes_tooltip"));
    //mIdbulto.setSize(new Dimension(1,1));
    
    // Segons el tipus de carga, fem el binding del bulto a un camp o un altre
    if (tipoCarga.equals("SLO"))
      mIdbulto.setModel((ComboBoxModel)panelBinding.bindUIControl("Bultoslo", mIdbulto));
    else
       mIdbulto.setModel((ComboBoxModel)panelBinding.bindUIControl("Bultomld", mIdbulto));

    macPanel.add(labelIdbulto, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));    
    macPanel.add(mIdbulto, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 15, 0));
    labelIdbulto.setLabelFor(mIdbulto);
    labelIdbulto.setText(SgaRecursos.getInstance().getString("Sortides.embalum_label"));
    dataPanel.add(macPanel, new GridBagConstraints(0, 4, 6, 5, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));        
    // Xavi, no afegim la taula pero no la borro per si s'ho repensen
    //dataPanel.add(scroller, new GridBagConstraints(6, 4, 2, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));   
    
    jTextArea1.setText(SgaRecursos.getInstance().getString("SortidaReservada.descrip_label"));
    jTextArea1.setFont(new Font("Tahoma", 1, 18));
    jTextArea1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    jTextArea1.setBackground(SystemColor.control);
    jTextArea1.setEditable(false);
    dataPanel.add(jTextArea1, new GridBagConstraints(0, 9, 4, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));

    jTextMultiref.setText(SgaRecursos.getInstance().getString("SortidaReservada.macMultiref"));
    jTextMultiref.setFont(new Font("Tahoma", 1, 18));
    jTextMultiref.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    jTextMultiref.setBackground(SystemColor.control);
    jTextMultiref.setForeground(Color.RED);
    jTextMultiref.setEditable(false);
    jTextMultiref.setVisible(false);
    dataPanel.add(jTextMultiref, new GridBagConstraints(4, 9, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));
    
    // Layout the datapanel and the navigation bar
    buttonAcceptar.setText(SgaRecursos.getInstance().getString("SortidaReservada.aceptar_label"));
    buttonAcceptar.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.aceptar_tooltip"));
    buttonAcceptar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          confirmarSortida();
        }
      });

    buttonCancelar.setText(SgaRecursos.getInstance().getString("SortidaReservada.cancelar_label"));
    buttonCancelar.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.cancelar_tooltip"));
    buttonCancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cancelarSortida();
        }
      });

    buttonsPanel.add(buttonAcceptar, null);
    buttonsPanel.add(buttonCancelar, null);
    buttonsPanel.add(buttonNouBulto, null);
    buttonsPanel.add(buttonMultiBulto, null);
    buttonsPanel.add(buttonTancarBulto, null);
    buttonsPanel.add(buttonVeureOrdre, null);
    //buttonsPanel.add(buttonMultiBulto_, null);

    buttonNouBulto.setText(SgaRecursos.getInstance().getString("SortidaReservada.nouBulto_label"));
    buttonNouBulto.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.nouBulto_tooltip"));
    buttonNouBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          nouBulto();
        }
      });

    buttonMultiBulto.setText(SgaRecursos.getInstance().getString("SortidaReservada.multiBulto_label"));
    buttonMultiBulto.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.multiBulto_tooltip"));
    buttonMultiBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          multiBulto_();
        }
      });

    buttonTancarBulto.setText(SgaRecursos.getInstance().getString("SortidaReservada.tancarBulto_label"));
    buttonTancarBulto.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.tancarBulto_tooltip"));
    buttonTancarBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          tancarBulto();
        }
      });

    buttonVeureOrdre.setText(SgaRecursos.getInstance().getString("SortidaReservada.veureOrdre_label"));
    buttonVeureOrdre.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.veureOrdre_tooltip"));
    buttonVeureOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureOrdre();
        }
      });

    buttonMultiBulto_.setText(SgaRecursos.getInstance().getString("SortidaReservada.multiBulto_label"));
    buttonMultiBulto_.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.multiBulto_tooltip"));
    buttonMultiBulto_.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          multiBulto();
        }
      });

    tableSgavldocView2.setModel((TableModel)panelBinding.bindUIControl("SgavldocView2", tableSgavldocView2));
    tableSgavldocView2.setEditable(false);
    scroller.getViewport().add(tableSgavldocView2, null);
    
//    add(scroller, BorderLayout.WEST);   
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

    PanelSgaresmatOpManView2 panel = new PanelSgaresmatOpManView2(MDPanelOperacionsManuals.CARGA_SILO);
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
   * Confirma la sortida. Si el flag tancarBulto esta actiu, despres de fer la 
   * sortida tanca el bulto amb el que s'ha fet.
   */
  private void confirmarSortida()
  {
    //Guardem iddoc i idlin per saber els bultos que s'han d'imprimir
    String iddoc = null, idlin = null;
    AppModule appModule = null;
    boolean bConfirmat = false;
    String nAlbaran = null;
    
    
    try
    {
      // Guardem els valors originals
      cancon = mCancon.getText();
      pesini = mPesini.getText();
      pesfin = mPesfin.getText();
      
      appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      SgaresmatOpManViewRow resmat = resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
      
      if (resmat != null)
      {
        nAlbaran = resmat.getNalbaran();
        iddoc = resmat.getIddoc().toString();
        idlin = resmat.getIdlin().toString();
        int action = 0;
        if (resmat.verificarPes(tipoCarga))
        {
            // Michael 16.12.2005 dar option a actualizar el peso
            action = PanelSgavarticulomodpesView.getUserActionModPes(appModule, mDifpes.getText(), mCancon.getText());
        }
        String pesIni = mPesini.getText();
        String pesFin = mPesfin.getText();
        String macPuesto = macEnPuesto;
        switch (action)
        {
        case 1:
        case 0:
        {
          // Primer creem els bultos necessaris, segons hagi especificat l'usuari
          resmat.crearBultos_(tipoCarga, cantBulto, bFraccionar, tancarBulto);
          // Despres confirmem la reserva
          resmat.confirmarReserva();
          
          boolean isClearCache = appModule.getTransaction().isClearCacheOnCommit();
          if (!isClearCache)
            appModule.getTransaction().setClearCacheOnCommit(true);
          // Si ha pedido modificar el peso, hacerlo ahora, haciendo post change 
          if (action == 1)
          {
            appModule.getTransaction().commit();
            modPesUnitari(pesIni, pesFin, macPuesto);
          }
          else
            appModule.getTransaction().commit();
          
          bConfirmat = true;
        }
        break;
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
      onConfirmarError();
    }
    
    try
    {
      if (bConfirmat)
      {
      // Per acabar imprimim les etiquetes pendents d'imprimir i el packinglist
        quizasImprimirEtiquetes(iddoc, idlin);
        quizasImprimirPackingList(iddoc, nAlbaran);
        String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
        MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, appModule.quizasManipular(puesto)); 
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
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
   * Cancelar l'operació de sortida (permet anul.lar reserva) 
   */
  private void cancelarSortida()
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      Object [] options = {SgaRecursos.getInstance().getString("EliminarReserva.botoEliminar_label"), 
          // Xavi, 10/05/05: Si s'anul·les el pendent, estariem tornant malament la quantitat sortida al host
          //SgaRecursos.getInstance().getString("EliminarReserva.botoAnularPendent_label"),
          SgaRecursos.getInstance().getString("EliminarReserva.botoCancelar_label")};
      int action = JOptionPane.showOptionDialog(Interflex.getInstance().getFrame(), 
          SgaRecursos.getInstance().getString("EliminarReserva.missatge"), 
          SgaRecursos.getInstance().getString("EliminarReserva.title") , 
          JOptionPane.YES_NO_OPTION, 
          JOptionPane.QUESTION_MESSAGE, null, options, options[(1)]);
  
      switch (action)
        {
        case 0:
          SgaresmatOpManViewRow resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
          if (resmat != null)
          {
            resmat.anularReserva(false);
            appModule.getTransaction().commit();
          }
          break;
        case 1:
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
      JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("SortidaReservada.errorOperacio"));    
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
    // Mirem si es tracta d'una ordre nova
    AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
    if (appModule.ordreSortidaNova(resmat.getIddoc()))
    {
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.si_label"), 
                          SgaRecursos.getInstance().getString("Options.no_label") };
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            SgaRecursos.getInstance().getString("SortidaReservada.iniciantNovaOrdre"),                                    // the dialog message array
            SgaRecursos.getInstance().getString("SortidaReservada.iniciantNovaOrdre_title"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
    
      if (result == 0)
        buttonVeureOrdre.doClick();
      /* Michael 01.06.2012 - ja no mostra aquest missatge a petició de Joan Pros */
      if (resmat.getMotivo()!= null && resmat.getMotivo().length() > 0)
      {
        // Options
        String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
        // "<html><span style='font-size:2em'>MINES AND GEOSCIENCES BUREAU - REGION XI, DAVAO CITY"
        
        Object messageFont = UIManager.get("OptionPane.messageFont");
        Object buttonFont = UIManager.get("OptionPane.buttonFont");
        
        UIManager.put("OptionPane.buttonFont",  new FontUIResource(new Font("Verdana", Font.PLAIN, 24)));
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.PLAIN, 24))); 

        JOptionPane.showOptionDialog(
              Interflex.getInstance(),                                       // the parent that the dialog blocks
              resmat.getMotivo(),                                    // the dialog message array
              SgaRecursos.getInstance().getString("SortidaReservada.missatgeNovaOrdre_title"), // the title of the dialog window
              JOptionPane.DEFAULT_OPTION,                 // option type
              JOptionPane.PLAIN_MESSAGE,            // message type
              null,                                       // optional icon, use null to use the default icon
              options2,                                    // options string array, will be made into buttons
              null                                        // option that should be made into a default button
          );
          
          
        javax.swing.UIManager.put("OptionPane.messageFont", (FontUIResource)messageFont); 
        javax.swing.UIManager.put("OptionPane.buttonFont", (FontUIResource)buttonFont); 
        
      }
      
    }
    
    // Mirem si te reserves manuals
    if (appModule.ordreAmbReservesManuals(resmat.getIddoc()))
    {
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.si_label"), 
                          SgaRecursos.getInstance().getString("Options.no_label") };
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            SgaRecursos.getInstance().getString("SortidaReservada.ordreAmbReservesManuals"),                                    // the dialog message array
            SgaRecursos.getInstance().getString("SortidaReservada.ordreAmbReservesManuals_title"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
    
      if (result == 0)
        ResmanList.imprimirResmanList(this.getClass(), appModule, resmat.getIddoc().toString(), true);
    }    
  }

  private void mCancon_focusGained(FocusEvent e)
  {
    mCancon.selectAll();
  }
  
  private void nouBulto()
  {
    try
    {
      SgaresmatOpManViewRow resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
      if (resmat != null)
      {
        String cancon = mCancon.getText();
        resmat.nouBulto(tipoCarga);
        // Xavi, 02/05/2005: Afegit per assegurar que continua sobre el mateix registre
        panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").setCurrentRowWithKey(resmat.getKey().toStringFormat(true));
        //FI afegit xavi
        mCancon.setText(cancon);
        mCancon.postActionEvent();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  private void multiBulto()
  {
    try
    {
      // Si la quantitat per bulto es 0, busquem les unitats per embalatge per 
      // defecte de l'article
      if (cantBulto[0].equals(new Number(0)))
      {
        cantBulto[0] = (Number)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow().getAttribute("Uniemb");
      }
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                          SgaRecursos.getInstance().getString("Options.cancelar_label") };
    
      String result = (String)JOptionPane.showInputDialog(Interflex.getInstance(), 
                      SgaRecursos.getInstance().getString("SortidaReservada.quantitatPerEmbalum_label"), 
                      SgaRecursos.getInstance().getString("SortidaReservada.quantitatPerEmbalum_label"), 
                      JOptionPane.PLAIN_MESSAGE, 
                      null,
                      //options, 
                      null,
                      cantBulto[0].toString());
   
      if (result != null)
      {
        try
        {
          cantBulto[0] = new Number(result);
          // Activem el flag per tancar bulto, de manera que quan es faci la sortida
          // es tancaran tots els bultos que es crein
          tancarBulto = true;
          
          // Xavi, 05/05/05: Fem que a l'acceptar la quantitat del multiembalum, 
          // es confirmi la sortida
          confirmarSortida();
          // Fi afegit Xavi
          
          // Michael 23.11.2010
          tancarBulto = false;
        }
        catch(Exception ex)
        {
          JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("SortidaReservada.errorQuantitatPerEmbalum_label") + ": " + result);  
          tancarBulto = false;
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }

  private void multiBulto_()
  {
    try
    {
      if (cantBulto[0].equals(new Number(0)))
      {
        cantBulto[0] = (Number)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow().getAttribute("Uniemb");
      }

      Object []      message = new Object[3];
      message [0] = SgaRecursos.getInstance().getString("SortidaReservada.quantitatPerEmbalum_label");
      JTextField mCantBulto = new JTextField();
      mCantBulto.setText(cantBulto[0] != null ? cantBulto[0].toString():"0");
      message [1] = mCantBulto;
      JCheckBox cb = new JCheckBox();
      cb.setText(SgaRecursos.getInstance().getString("SortidaReservada.fraccionarEmbalums_label"));
      cb.setSelected(false);
  
      message [2] = cb;
      
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                          SgaRecursos.getInstance().getString("Options.cancelar_label") };

      int eleccion = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            message,                                    // the dialog message array
            SgaRecursos.getInstance().getString("SortidaReservada.quantitatPerEmbalum_label"),            // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.INFORMATION_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            options[0]                                  // option that should be made into a default button
            );
      if (eleccion == 0)
      {
        // Ha aceptado algo
        try
        {
          String [] bultos = mCantBulto.getText().split(",");
          cantBulto = new Number[bultos.length];
          for (int i=0;i<bultos.length;i++)
            cantBulto[i] = new Number(bultos[i]);
          bFraccionar = cb.isSelected();
          // Activem el flag per tancar bulto, de manera que quan es faci la sortida
          // es tancaran tots els bultos que es crein
          tancarBulto = true;
          
          // Xavi, 05/05/05: Fem que a l'acceptar la quantitat del multiembalum, 
          // es confirmi la sortida
          confirmarSortida();
          // Fi afegit Xavi
          // Michael 23.11.2010 
          tancarBulto = false;
          cantBulto[0] = new Number(0);
        }
        catch(Exception ex)
        {
          tancarBulto = false;
          JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("SortidaReservada.errorQuantitatPerEmbalum_label") + ": " + mCantBulto.getText());          
        }
      }
      else
        cantBulto[0] = new Number(0);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }

  }
  
  
  /**
   * Confirma la sortida actual ,tancant el bulto un cop s'ha confirmat
   */
   
  private void tancarBulto()
  {
    try
    {
      // Michael 10.05.2011 reset cant_bulto
      cantBulto[0] = new Number(0);
      // Activem el flag per tancar bulto i fem la sortida
      tancarBulto = true;
      confirmarSortida();
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }

  /**
   * Mostra un panel amb l'ordre de sortida actual
   */
   
  private void veureOrdre()
  {
    try
    {
      SgaresmatOpManViewRow resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
      if (resmat != null)
      {
        MDPanelSgavcdocView1SgavldocView1 panelSgasortides = new MDPanelSgavcdocView1SgavldocView1();
        panelSgasortides.setBindingContext(panelBinding.getBindingContext());
        String sWhereClause = "iddoc = " + resmat.getIddoc().toString();
        panelSgasortides.setWhereClause(sWhereClause);
        
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSgasortides,                                    // the dialog message array
            SgaRecursos.getInstance().getString("SortidaReservada.veureOrdre_label"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
        panelSgasortides.releasePanelBinding();
        panelSgasortides = null;
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  public synchronized void update (Observable o, Object arg)
  {
    try
    {
      // Xavi, 22/07/05: Afegim la verificació de que resmat es diferent de null,
      // per evitar que es registri el pes quan ja s'ha confirmat la sortida
      SgaresmatOpManViewRow resmat = (SgaresmatOpManViewRow)panelBinding.findIteratorBinding("SgaresmatOpManView1Iter").getCurrentRow();
      if (resmat != null)
      {      
        if (pesadaBascula == null)
          pesadaBascula = new PesadaBascula (mPesini, mPesfin, tipoCarga.equals(MDPanelOperacionsManuals.CARGA_MINILOAD));
        pesadaBascula.novaPesada((String) arg);
      }
    }
    catch(Exception ex)
    {
      //TODO: No hauria d'arribar mai aqui
    }
  }
  
  private void quizasImprimirEtiquetes(String iddoc, String idlin) throws Exception
  {
    AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
    while (true)
      {
        try
        {
          
          Etiqueta.imprimirEtiqueta(appModule, iddoc, idlin);
          break;
        }
         catch (Exception ex)
        {
           
           int result = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                "Error d'impressió d'etiqueta: " + ex.getMessage(),
                "Error de impressió d'etiqueta",                                    // the dialog message array
                JOptionPane.DEFAULT_OPTION,                 // option type
                JOptionPane.WARNING_MESSAGE,            // message type
                null,                                       // optional icon, use null to use the default icon
                new String [] { "Reintentar", "Cancelar"},                                    // options string array, will be made into buttons
                null                                        // option that should be made into a default button
            );
            if (result == 0)
              continue;
            else 
              throw ex;
        }
      }
  }

  /**
   * Imprimieix el packing list actual del document
   * NOMES TEST ????
   * S'han posat java options a la linea d'execució de l'aplicació
   */

  private void quizasImprimirPackingList(String iddoc, String nAlbaran)
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      PackingList.imprimirPackingList(this.getClass(), appModule, iddoc, false, PackingList.NACIONAL, nAlbaran);
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  private void panelBinding_navigated(JUIteratorBinding iter, NavigationEvent event)
  {
    if (iter.getName().equals("SgaresmatOpManView1Iter"))
    {
      refresh();
    }
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
    if (iter.getName().equals("SgaresmatOpManView1Iter"))
    {
      refresh();
    }
  }

  private void refresh()
  {
    try
    {
      if (panelBinding.findCtrlValueBinding("Multiref").getAttributeValue().equals("S"))
        jTextMultiref.setVisible(true);
      else
        jTextMultiref.setVisible(false);
    }
    catch(Exception ex)
    {
      //No hauria d'arribar mai aqui...
    }
  }


}