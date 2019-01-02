package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.Key;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;


// public class PanelSgamacSenseExistenciesView3 extends JUPanel
public class PanelSgamacSenseExistenciesView3 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgamacSenseExistenciesView3UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonEvacuar = new JButton();
  private JButton buttonNovaCarga = new JButton();
  private JButton buttonRetirar = new JButton();
  
  private String tipoCarga = null;
  private String macEnPuesto = null;
  
// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Contenidor

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Tipus Contenidor

  private JLabel labelIdtipmac = new JLabel();
  private JTextField mIdtipmac = new JTextField();
  
// Fields for attribute:  Tipus Contenidor

  private JTextField mDesctipmac = new JTextField();
  
// Fields for attribute:  Multireferencia

  private JLabel labelMultiref = new JLabel();
  private JTextField mMultiref = new JTextField();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgamacSenseExistenciesView3(String tipoCarga)
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
    dataPanel.setMinimumSize(new Dimension(561, 275));
    dataPanel.setPreferredSize(new Dimension(561, 275));
    dataPanel.setMaximumSize(new Dimension(561, 275));

    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.sortidaSilo")));
    else
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.sortidaMiniLoad")));

    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(139, 275));
    buttonsPanel.setMinimumSize(new Dimension(139, 275));
    buttonsPanel.setMaximumSize(new Dimension(139, 275));

    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 275));
    this.setPreferredSize(new Dimension(700, 275));
    this.setMinimumSize(new Dimension(700, 275));
    this.setMaximumSize(new Dimension(700, 275));

    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(8);
    mIdmac.setEditable(false);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());
    
    mIdtipmac.setDocument((Document)panelBinding.bindUIControl("Idtipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setColumns(15);
    mIdtipmac.setEditable(false);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    
    /*mMultiref.setDocument((Document)panelBinding.bindUIControl("Multiref", mMultiref));
    dataPanel.add(labelMultiref, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mMultiref, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    mMultiref.setColumns(15);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());*/

    /*mDesctipmac.setDocument((Document)panelBinding.bindUIControl("Idtipmac", mDesctipmac));
    dataPanel.add(mDesctipmac, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    mDesctipmac.setColumns(15);
    mDesctipmac.setEditable(false);
    mDesctipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());*/

    buttonEvacuar.setText(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.evacuar_label"));
    buttonEvacuar.setToolTipText(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.evacuar_tooltip"));
    buttonEvacuar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          confirmarEvacuacio();
        }
      });

    buttonNovaCarga.setText(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.cargaNova_label"));
    buttonNovaCarga.setToolTipText(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.cargaNova_tooltip"));
    buttonNovaCarga.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cargaNova();
        }
      });

    buttonRetirar.setText(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.retirar_label"));
    buttonRetirar.setToolTipText(SgaRecursos.getInstance().getString("ContenidorSenseExistencies.retirar_tooltip"));
    buttonRetirar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          retirarContenidor();
        }
      });
    
    buttonsPanel.add(buttonNovaCarga);
    buttonsPanel.add(buttonEvacuar);
    buttonsPanel.add(buttonRetirar);

    // Layout the datapanel and the navigation bar
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

    PanelSgamacSenseExistenciesView3 panel = new PanelSgamacSenseExistenciesView3(MDPanelOperacionsManuals.CARGA_SILO);
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

  public boolean setFocusInicial()
  {
    return (buttonEvacuar.requestFocusInWindow());
  }
  
  public void setCurrentRow(Key key)
  {
    // Comentat per que triga molt
    //panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").executeQuery();
    panelBinding.findIteratorBinding("SgamacView1Iter").setCurrentRowWithKey(key.toStringFormat(true));

    // Si trobem el registre, guardem l'identificador del mac sobre el que estem treballant
    SgamacViewRow mac = (SgamacViewRow)panelBinding.findIteratorBinding("SgamacView1Iter").getCurrentRow();
    if (mac != null)
      macEnPuesto = mac.getIdmac();
  }


  /**
   * Cancel·la qualsevol operació pendent sobre el contenidor i dona l'ordre
   * d'evacuar-lo
   */
  private void confirmarEvacuacio()
  {
    try
    {
      panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      if (puesto != null)
      {
        String retirarMac = appModule.getRetirarMac(puesto);
        appModule.setRetirarMac(puesto, "S");
        MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, false);
        appModule.setRetirarMac(puesto, retirarMac);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Cancel·la qualsevol operació pendent sobre el contenidor i el retira del sistema
   */
  private void retirarContenidor()
  {
    try
    {
      //panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
      SgamacViewRow mac = (SgamacViewRow)panelBinding.findIteratorBinding("SgamacView1Iter").getCurrentRow();
      if (mac != null)
      {
        mac.remove();
        panelBinding.getApplication().getApplicationModule().getTransaction().commit();
        MDPanelOperacionsManuals.getInstance().esperarCarga(tipoCarga);       
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  
  /**
   * Introdueix una carga nova al magatzem
   */
  private void cargaNova()
  {
    try
    {
      MDPanelOperacionsManuals.getInstance().cargaNova(tipoCarga, mIdmac.getText()); 
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


}