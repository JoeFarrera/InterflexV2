package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaTestMacViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.ComboBoxModel;

public class PanelSgaTestMacView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaTestMacView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonAcceptar = new JButton();
  private JButton buttonCancelar = new JButton();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idmac

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Idtipmac

  private JLabel labelIdtipmac = new JLabel();
  private JComboBox mIdtipmac = new JComboBox();

  private String tipoCarga = null;

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaTestMacView1(String tipoCarga)
  {
    this.tipoCarga = tipoCarga;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    dataPanel.setLayout(panelLayout);
    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("ContenidorBuit.entradaSilo")));
    else
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("ContenidorBuit.entradaMiniLoad")));
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

    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(15);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());
    mIdmac.setFont(new Font("Tahoma", 1, 14));
    labelIdmac.setFont(new Font("Tahoma", 1, 14));

    mIdtipmac.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setEditable(false);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    mIdtipmac.setFont(new Font("Tahoma", 1, 14));
    labelIdtipmac.setFont(new Font("Tahoma", 1, 14));

    buttonAcceptar.setText(SgaRecursos.getInstance().getString("ContenidorBuit.aceptar_label"));
    buttonAcceptar.setToolTipText(SgaRecursos.getInstance().getString("ContenidorBuit.aceptar_tooltip"));
    buttonAcceptar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          acceptarContenidor();
        }
      });

    buttonCancelar.setText(SgaRecursos.getInstance().getString("ContenidorBuit.cancelar_label"));
    buttonCancelar.setToolTipText(SgaRecursos.getInstance().getString("ContenidorBuit.cancelar_tooltip"));
    buttonCancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cancelarContenidor();
        }
      });

    buttonsPanel.add(buttonAcceptar);
    buttonsPanel.add(buttonCancelar);

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

    PanelSgaTestMacView1 panel = new PanelSgaTestMacView1(MDPanelOperacionsManuals.CARGA_SILO);
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
   * Michael 09.03.2006 Sólo enviar fuera cuando retirarPuesto está activado
   */
  private void acceptarContenidor()
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
      String idubi = appModule.getUbicacionPuesto(puesto, tipoCarga);
      if (idubi != null)
      {
        SgaTestMacViewRow lmac = (SgaTestMacViewRow)panelBinding.findIteratorBinding("SgaTestMacView1Iter").getCurrentRow();
        // Michael 09.03.2006 Saber si enviar el mac fuera o no
        boolean retirarMac = appModule.getRetirarMac(puesto).equals("S");
        if (lmac != null)
        {
          // lmac.insertarMac(idubi);
          lmac.insertarMac(idubi, retirarMac);
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          // Michael: Si no se ha enviado el mac fuera...
          if (!retirarMac)
            MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(lmac.getIdmac(), tipoCarga, true);
          else
            MDPanelOperacionsManuals.getInstance().esperarCarga(tipoCarga); 
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
  private void cancelarContenidor()
  {
    try
    {
      panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
      MDPanelOperacionsManuals.getInstance().esperarCarga(tipoCarga); 
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  
  public boolean setFocusInicial()
  {
     return (mIdmac.requestFocusInWindow());
  }
  
  public void crearTestMac()
  {
    RowSetIterator rsi = panelBinding.findIteratorBinding("SgaTestMacView1Iter").getRowSetIterator();
    Row row = rsi.createRow();
    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_MINILOAD))
    {
      row.setAttribute("Idtipmac", "CUB");
      labelIdtipmac.setVisible(false);
      mIdtipmac.setVisible(false);
    }
    rsi.insertRow(row);
  }
  
}