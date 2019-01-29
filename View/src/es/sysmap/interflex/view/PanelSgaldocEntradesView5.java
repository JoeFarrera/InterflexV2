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

import oracle.jbo.Key;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.controls.JUPanel;
import oracle.jbo.uicli.controls.JUTestFrame;
import oracle.jbo.uicli.jui.JULovButtonBinding;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.VerticalFlowLayout;
import sgalib.CustomLOVPanel;
import sgalib.SearchFieldLov;
import sgalib.SgaJUErrorHandler;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgaldocEntradesView5 extends SgaJUPanel
// public class PanelSgaldocEntradesView5 extends JPanel implements JUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaldocEntradesView5UIModel");

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

  private JLabel labelIntegra = new JLabel();
  private JCheckBox mIntegra = new JCheckBox();
 
  
// Fields for attribute:  Article

  private JLabel labelIdubi = new JLabel();
  private JTextField mIdubi = new JTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescubi = new JLabel();
  private JTextField mDescubi = new JTextField();
  
  private JButton buttonLov = new JButton();
  
  // Multiple selections
  private Key [] rowsSelected;
  private int rowIndex = 0;
  
  private JTextField liniesPendents = new JTextField();
  
    private JLabel labelEspecial = new JLabel();
  private JComboBox mIdEspecial = new JComboBox();
  
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaldocEntradesView5(Key [] rowsSelected)
  {
    this.rowsSelected = rowsSelected;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(panelLayout);
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("NovaCarga.entradaManual")));
    dataPanel.setMinimumSize(new Dimension(561, 300));
    dataPanel.setPreferredSize(new Dimension(561, 300));
    dataPanel.setMaximumSize(new Dimension(561, 300));
    
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(139, 300));
    buttonsPanel.setMinimumSize(new Dimension(139, 300));
    buttonsPanel.setMaximumSize(new Dimension(139, 300));
    
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 300));
    this.setPreferredSize(new Dimension(700, 300));
    this.setMinimumSize(new Dimension(700, 300));
    this.setMaximumSize(new Dimension(700, 300));

    macPanel.setLayout(macPanelLayout);
    macPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("NovaCarga.macPanel")));
    
    mIdcabstr.setDocument((Document)panelBinding.bindUIControl("Idcabstr", mIdcabstr));
    mIdartif.setFont(new Font("Tahoma", 1, 14));
    mIdcabstr.setColumns(3);
    mIdcabstr.setToolTipText(panelBinding.findCtrlValueBinding("Idcabstr").getTooltip());
    mIdcabstr.setEditable(false);
    mIdcabstr.setFocusable(false);

    mIdcabnum.setDocument((Document)panelBinding.bindUIControl("Idcabnum", mIdcabnum));
    dataPanel.add(mIdcabstr, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdcabnum, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(labelIdlin, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdlin, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(labelIdbulto, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdbulto, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(labelCantotbulto, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantotbulto, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(labelCanpenbulto, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanpenbulto, new GridBagConstraints(8, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(0, 2, 9, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(macPanel, new GridBagConstraints(0, 5, 9, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    mIdcabnum.setColumns(6);
    mIdcabnum.setToolTipText(panelBinding.findCtrlValueBinding("Idcabnum").getTooltip());
    mIdcabnum.setEditable(false);
    mIdcabnum.setFocusable(false);

    mIdlin.setDocument((Document)panelBinding.bindUIControl("Idlin", mIdlin));
    labelIdlin.setLabelFor(mIdlin);
    mIdlin.setColumns(2);
    labelIdlin.setText(panelBinding.findCtrlValueBinding("Idlin").getLabel());
    mIdlin.setToolTipText(panelBinding.findCtrlValueBinding("Idlin").getTooltip());
    mIdlin.setEditable(false);
    mIdlin.setFocusable(false);

    mIdbulto.setDocument((Document)panelBinding.bindUIControl("Idbulto", mIdbulto));
    labelIdbulto.setLabelFor(mIdbulto);
    mIdbulto.setColumns(2);
    labelIdbulto.setText(panelBinding.findCtrlValueBinding("Idbulto").getLabel());
    mIdbulto.setToolTipText(panelBinding.findCtrlValueBinding("Idbulto").getTooltip());
    mIdbulto.setEditable(false);
    mIdbulto.setFocusable(false);

    mCantotbulto.setDocument((Document)panelBinding.bindUIControl("Cantotbulto", mCantotbulto));
    labelCantotbulto.setLabelFor(mCantotbulto);
    mCantotbulto.setColumns(6);
    labelCantotbulto.setText(panelBinding.findCtrlValueBinding("Cantotbulto").getLabel());
    mCantotbulto.setToolTipText(panelBinding.findCtrlValueBinding("Cantotbulto").getTooltip());
    mCantotbulto.setEditable(false);
    mCantotbulto.setFocusable(false);

    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    labelIdartif.setLabelFor(mIdartif);
    labelIdartif.setFont(new Font("Tahoma", 1, 14));
    mIdartif.setColumns(6);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mIdartif.setEditable(false);
    mIdartif.setFont(new Font("Tahoma", 1, 14));
    mIdartif.setFocusable(false);

    mCanpenbulto.setDocument((Document)panelBinding.bindUIControl("Canpenbulto", mCanpenbulto));
    labelCanpenbulto.setLabelFor(mCanpenbulto);
    mCanpenbulto.setColumns(6);
    labelCanpenbulto.setText(panelBinding.findCtrlValueBinding("Canpenbulto").getLabel());
    mCanpenbulto.setToolTipText(panelBinding.findCtrlValueBinding("Canpenbulto").getTooltip());
    mCanpenbulto.setEditable(false);
    mCanpenbulto.setFocusable(false);

    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    mDescrip.setColumns(40);
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mDescrip.setEditable(false);
    mDescrip.setFont(new Font("Tahoma", 1, 14));
    mDescrip.setFocusable(false);

    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    macPanel.add(labelIdmac, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIdmac, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(labelCancon, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCancon, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(labelIdtipmac, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIdtipmac, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(labelMultiref, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mMultiref, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(labelIntegra, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIntegra, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(labelIdubi, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIdubi, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(buttonLov, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
     macPanel.add(labelEspecial, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    macPanel.add(mIdEspecial, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

    labelIdmac.setLabelFor(mIdmac);
    labelIdmac.setFont(new Font("Tahoma", 1, 14));
    mIdmac.setColumns(8);
    mIdmac.setFont(new Font("Tahoma", 1, 14));
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());

    mCancon.setDocument((Document)panelBinding.bindUIControl("Cancon", mCancon));
    labelCancon.setLabelFor(mCancon);
    labelCancon.setFont(new Font("Tahoma", 1, 14));
    mCancon.setColumns(4);
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
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setEditable(false);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
   

    mMultiref.setModel((ButtonModel)panelBinding.bindUIControl("Multiref", mMultiref));
    labelMultiref.setLabelFor(mMultiref);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());

    mIntegra.setModel((ButtonModel)panelBinding.bindUIControl("Integra", mIntegra));
    labelIntegra.setLabelFor(mIntegra);
    labelIntegra.setText(panelBinding.findCtrlValueBinding("Integra").getLabel());
    mIntegra.setToolTipText(panelBinding.findCtrlValueBinding("Integra").getTooltip());
    
    mIdubi.setDocument((Document)panelBinding.bindUIControl("Idubi", mIdubi));
    labelIdubi.setLabelFor(mIdubi);
    mIdubi.setColumns(6);
    labelIdubi.setText(panelBinding.findCtrlValueBinding("Idubi").getLabel());
    mIdubi.setToolTipText(panelBinding.findCtrlValueBinding("Idubi").getTooltip());

/*    mDescubi.setDocument((Document)panelBinding.bindUIControl("Descubi", mDescubi));
    macPanel.add(mDescubi, new GridBagConstraints(2, 5, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    mDescubi.setColumns(30);
    mDescubi.setToolTipText(panelBinding.findCtrlValueBinding("Descubi").getTooltip());
    mDescubi.setEditable(false);
    mDescubi.setFocusable(false);
*/
    buttonLov.setModel((ButtonModel)panelBinding.bindUIControl("Idubi1", buttonLov));
    buttonLov.setText(SgaRecursos.getInstance().getString("UbicacionsLov.boto_label"));
    buttonLov.setToolTipText(SgaRecursos.getInstance().getString("UbicacionsLov.boto_tooltip"));

    // Afegeix el quadre de texte de busqueda
    ((CustomLOVPanel)((JULovButtonBinding) panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setAddSearch(true);
    
    // Indica que ha de realitzar la busqueda per la segona columna (per defecte es la primera, la 0) 
    ((SearchFieldLov)((JULovButtonBinding)panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setSearchColumn(1);
    
    // Estableix el titol de la llista de valors
    ((CustomLOVPanel)((JULovButtonBinding) panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setTitleString(SgaRecursos.getInstance().getString("UbicacionsLov.boto_title"));

    
    
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
    

    this.add(dataPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.EAST);

    // Michael 09.03.2006 Just get first row for speed
    ViewObject vo = panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").getViewObject();
    mIdEspecial.setToolTipText("Material especial (P.Ex: Galvanitzat)");
    labelEspecial.setToolTipText("Material especial (P.Ej.: Galvanitzat)");
    labelEspecial.setText("Especial");
    vo.setMaxFetchSize(1);
 
  mIdEspecial.setModel((ComboBoxModel)panelBinding.bindUIControl("DCComboBox", mIdEspecial));
 
    if (rowsSelected != null)
    {
      buttonsPanel.add(liniesPendents);
      int index = rowIndex + 1;
      liniesPendents.setText("Línia : " + index + " de " + rowsSelected.length);
      liniesPendents.setEditable(false);
    }
 
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

    PanelSgaldocEntradesView5 panel = new PanelSgaldocEntradesView5(null); // TODO - #fail
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
  private void acceptarCarga()
  {
    try
    {
      if (verificarDades())
      {
        AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
        //String idubi = appModule.getUbicacionPuesto(SgaUtilPuesto.getInstance().getProperty("LlocTreball"), tipoCarga);
        String idubi = mIdubi.getText();
        
        if (idubi != null)
        {
          SgaldocEntradesViewRow ldocEntrades = (SgaldocEntradesViewRow)panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").getCurrentRow();
          if (ldocEntrades != null)
          {
            ldocEntrades.introduirCargaNova(idubi, "MAN");
            panelBinding.getApplication().getApplicationModule().getTransaction().commit();
            if (rowsSelected.length > (++rowIndex)) 
            {
              setCurrentRow(rowsSelected[rowIndex]);
              setFocusInicial();
              int index = rowIndex + 1;
              liniesPendents.setText("Línia " + index + " de " + rowsSelected.length);
        
            }
            else
              MDPanelEntradesManuals.getInstance().esperarCarga();
          }
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  

  /**
   * Cancel·la la introducció d'una carga nova al magatzem
   */
  private void cancelarCarga()
  {
    try
    {
      panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
      MDPanelEntradesManuals.getInstance().esperarCarga(); 
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
    else if(mIdtipmac.getSelectedIndex() < 0 || mIdtipmac.getSelectedIndex() == mIdtipmac.getItemCount()-1) //  null
        missatge =  SgaRecursos.getInstance().getString("Documents.errorTipmac_label");
    if (mIdubi.getText() == null || mIdubi.getText().equals(""))
       missatge =  SgaRecursos.getInstance().getString("Documents.errorIdubi_label");
    if (missatge != null)
      JOptionPane.showMessageDialog(Interflex.getInstance(), missatge);              
    return (missatge==null);
  }
  
  
 
  public boolean setFocusInicial()
  {
    return (mIdmac.requestFocusInWindow());
  }
  /**
   * Set the current row according to first key in array
   * @param keys array of selected row keys
   */
  public void setCurrentRow(Key key)
  {
     
    panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").executeQuery();
    panelBinding.findIteratorBinding("SgaldocEntradesView3Iter").setCurrentRowWithKey(key.toStringFormat(true));

    // Fem que integra sigui 'S' per defecte
    mIntegra.setSelected(true);
    
  }

  private void mCancon_focusGained(FocusEvent e)
  {
    mCancon.selectAll();
  }

  
}