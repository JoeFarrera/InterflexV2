package es.sysmap.interflex.view;

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
import oracle.jbo.Key;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.JUNavigationBar;
import oracle.jbo.uicli.controls.JUPanel;
import oracle.jbo.uicli.controls.JUStatusBar;
import oracle.jbo.uicli.controls.JUTestFrame;
import oracle.jbo.uicli.jui.JULovButtonBinding;
import oracle.jbo.uicli.jui.JULovPanelInterface;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.VerticalFlowLayout;



import sgalib.CustomLOVPanel;
import sgalib.SearchFieldLov;
import sgalib.SgaJUErrorHandler;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;
import javax.swing.BorderFactory;
public class PanelSgabultoView5 extends SgaJUPanel
// public class PanelSgabultoView5 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgabultoView5UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Id.Embalum

  private JLabel labelIdbulto = new JLabel();
  private JTextField mIdbulto = new JTextField();

// Fields for attribute:  Pes Total

  private JLabel labelPeso = new JLabel();
  private JTextField mPeso = new JTextField();

// Fields for attribute:  Detalls

  private JLabel labelDetalles = new JLabel();
  private JTextField mDetalles = new JTextField();

// Fields for attribute:  Tipus Emb.

  private JLabel labelIdtipobulto = new JLabel();
  private JTextField mIdtipobulto = new JTextField();

// Fields for attribute:  Alçada

  private JLabel labelAlto = new JLabel();
  private JTextField mAlto = new JTextField();

// Fields for attribute:  Amplada

  private JLabel labelAncho = new JLabel();
  private JTextField mAncho = new JTextField();

// Fields for attribute:  Llarg

  private JLabel labelLargo = new JLabel();
  private JTextField mLargo = new JTextField();

// Fields for attribute:  Pes palet/caixa

  private JLabel labelPesocont = new JLabel();
  private JTextField mPesocont = new JTextField();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar() { 
    public void doAction(int action) 
    {
    if (action == BUTTON_COMMIT)
    {
      int i = action;
    }
    try
    {
    super.doAction(action);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    
    
    }
  };
  private JUStatusBar jUStatusBar1 = new JUStatusBar();
  private JButton buttonLov = new JButton();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgabultoView5()
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
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    this.setBorder(BorderFactory.createTitledBorder("Embalums"));
    mIdbulto.setDocument((Document)panelBinding.bindUIControl("Idbulto", mIdbulto));
    mIdbulto.setSize(new Dimension(90, 21));
    mPeso.setSize(new Dimension(90, 21));
    mDetalles.setSize(new Dimension(90, 21));
    mIdtipobulto.setSize(new Dimension(90, 21));
    mAlto.setSize(new Dimension(90, 21));
    mAncho.setSize(new Dimension(90, 21));
    mLargo.setSize(new Dimension(90, 21));
    mPesocont.setSize(new Dimension(90, 21));
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgabultoView4", null, "SgabultoView4Iter"));
    buttonLov.setText("buttonLov");
    dataPanel.add(labelIdbulto, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdbulto, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdbulto.setLabelFor(mIdbulto);
    mIdbulto.setColumns(15);
    labelIdbulto.setText(panelBinding.findCtrlValueBinding("Idbulto").getLabel());
    mIdbulto.setToolTipText(panelBinding.findCtrlValueBinding("Idbulto").getTooltip());
    mPeso.setDocument((Document)panelBinding.bindUIControl("Peso", mPeso));
    dataPanel.add(labelPeso, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPeso, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPeso.setLabelFor(mPeso);
    mPeso.setColumns(15);
    labelPeso.setText(panelBinding.findCtrlValueBinding("Peso").getLabel());
    mPeso.setToolTipText(panelBinding.findCtrlValueBinding("Peso").getTooltip());
    mDetalles.setDocument((Document)panelBinding.bindUIControl("Detalles", mDetalles));
    dataPanel.add(labelDetalles, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDetalles, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelDetalles.setLabelFor(mDetalles);
    mDetalles.setColumns(15);
    labelDetalles.setText(panelBinding.findCtrlValueBinding("Detalles").getLabel());
    mDetalles.setToolTipText(panelBinding.findCtrlValueBinding("Detalles").getTooltip());
    mIdtipobulto.setDocument((Document)panelBinding.bindUIControl("Idtipobulto", mIdtipobulto));
    dataPanel.add(labelIdtipobulto, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipobulto, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipobulto.setLabelFor(mIdtipobulto);
    mIdtipobulto.setColumns(15);
    labelIdtipobulto.setText(panelBinding.findCtrlValueBinding("Idtipobulto").getLabel());
    mIdtipobulto.setToolTipText(panelBinding.findCtrlValueBinding("Idtipobulto").getTooltip());
    mAlto.setDocument((Document)panelBinding.bindUIControl("Alto", mAlto));
    dataPanel.add(labelAlto, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mAlto, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelAlto.setLabelFor(mAlto);
    mAlto.setColumns(15);
    labelAlto.setText(panelBinding.findCtrlValueBinding("Alto").getLabel());
    mAlto.setToolTipText(panelBinding.findCtrlValueBinding("Alto").getTooltip());
    mAncho.setDocument((Document)panelBinding.bindUIControl("Ancho", mAncho));
    dataPanel.add(labelAncho, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mAncho, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelAncho.setLabelFor(mAncho);
    mAncho.setColumns(15);
    labelAncho.setText(panelBinding.findCtrlValueBinding("Ancho").getLabel());
    mAncho.setToolTipText(panelBinding.findCtrlValueBinding("Ancho").getTooltip());
    mLargo.setDocument((Document)panelBinding.bindUIControl("Largo", mLargo));
    dataPanel.add(labelLargo, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mLargo, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelLargo.setLabelFor(mLargo);
    mLargo.setColumns(15);
    labelLargo.setText(panelBinding.findCtrlValueBinding("Largo").getLabel());
    mLargo.setToolTipText(panelBinding.findCtrlValueBinding("Largo").getTooltip());
    mPesocont.setDocument((Document)panelBinding.bindUIControl("Pesocont", mPesocont));
    dataPanel.add(labelPesocont, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesocont, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(buttonLov, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelPesocont.setLabelFor(mPesocont);
    mPesocont.setColumns(15);
    labelPesocont.setText(panelBinding.findCtrlValueBinding("Pesocont").getLabel());
    
    buttonLov.setModel((ButtonModel)panelBinding.bindUIControl("DCLovButton", buttonLov));
    buttonLov.setText ("Seleccionar");
    buttonLov.setToolTipText("Seleccionar un tipus d'embalum");
    
       // Afegeix el quadre de texte de busqueda
       // Michael 19.05.2015 Class cast exception thrown as CustomLOVPanel not suitable (Implements JPanel??)
       
 //   JULovButtonBinding b = (JULovButtonBinding) panelBinding.getControlBinding(buttonLov);
 //   JULovPanelInterface iLov = b.getLovPanelInterface();
//    CustomLOVPanel lovPanel = (CustomLOVPanel)iLov;
//    lovPanel.setAddSearch(true);
    
    // ((CustomLOVPanel)((JULovButtonBinding) panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setAddSearch(true);
    
    // Indica que ha de realitzar la busqueda per la segona columna (per defecte es la primera, la 0) 
    // Primera ja esta be ((SearchFieldLov)((JULovButtonBinding)panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setSearchColumn(1);
    
    // Estableix el titol de la llista de valors
//    b = (JULovButtonBinding) panelBinding.getControlBinding(buttonLov);

//    lovPanel = (CustomLOVPanel)((JULovButtonBinding) panelBinding.getControlBinding(buttonLov)).getLovPanelInterface();
 //   lovPanel.setTitleString("Tipus d'embalum");



    // Layout the datapanel and the navigation bar
    mPesocont.setToolTipText(panelBinding.findCtrlValueBinding("Pesocont").getTooltip());
    add(dataPanel, BorderLayout.CENTER);
    this.add(jUNavigationBar1, BorderLayout.NORTH);
    
    jUStatusBar1.setModel(JUStatusBar.createPanelBinding(panelBinding, jUStatusBar1));
    this.add(jUStatusBar1, BorderLayout.SOUTH);
    jUNavigationBar1.setHasDeleteButton(false);
    jUNavigationBar1.setHasInsertButton(false);
    


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

    PanelSgabultoView5 panel = new PanelSgabultoView5();
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
}