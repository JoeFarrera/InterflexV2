package es.sysmap.interflex.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.*;

import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelEsperantCarga extends SgaJUPanel
{
  private String tipoCarga = null;
// Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelEsperantCargaUIModel");
  
  
// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private BorderLayout dataPanelLayout = new BorderLayout();
  
  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonCargaNova = new JButton();
  private JButton buttonContenidorBuit = new JButton();
  private JButton buttonSortidaManual = new JButton();
  
  private JLabel jLabelEsperantCarga = new JLabel();
  
  /**
   * 
   *  The default constructor for panel
   */
  public PanelEsperantCarga(String tipoCarga)
  {
    this.tipoCarga = tipoCarga;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    dataPanel.setLayout(dataPanelLayout);
    dataPanel.setPreferredSize(new Dimension(561, 246));
    dataPanel.setMinimumSize(new Dimension(100, 100));
    dataPanel.setMaximumSize(new Dimension(561, 246));
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(139, 246));
    buttonsPanel.setMinimumSize(new Dimension(100, 100));
    buttonsPanel.setMaximumSize(new Dimension(139, 246));
    

    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 275));
    this.setPreferredSize(new Dimension(700, 275));
    this.setMinimumSize(new Dimension(100, 100));
    this.setMaximumSize(new Dimension(700, 275));
    // Exemple d'assignació de tecles de funció
    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
      buttonCargaNova.setMnemonic(KeyEvent.VK_F1);
    else if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_MINILOAD))
      buttonCargaNova.setMnemonic(KeyEvent.VK_F7);
    else
      buttonCargaNova.setMnemonic(KeyEvent.VK_F1);
    buttonCargaNova.setText(KeyEvent.getKeyText(buttonCargaNova.getMnemonic()) + "-" + SgaRecursos.getInstance().getString("EsperantCarga.cargaNova_label"));
    buttonCargaNova.setToolTipText(SgaRecursos.getInstance().getString("EsperantCarga.cargaNova_tooltip"));
    buttonCargaNova.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          // Michael TODO: See how to repeat if varios elements selected
          cargaNova();
        }
      });
    
    buttonContenidorBuit.setText(SgaRecursos.getInstance().getString("EsperantCarga.contenidorBuit_label"));
    buttonContenidorBuit.setToolTipText(SgaRecursos.getInstance().getString("EsperantCarga.contenidorBuit_tooltip"));
    buttonContenidorBuit.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          contenidorBuit();
        }
      });

    buttonSortidaManual.setText(SgaRecursos.getInstance().getString("EsperantCarga.sortidaManual_label"));
    buttonSortidaManual.setToolTipText(SgaRecursos.getInstance().getString("EsperantCarga.sortidaManual_tooltip"));
    buttonSortidaManual.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          sortidaManual();
        }
      });

    if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_SILO))
      jLabelEsperantCarga.setText(SgaRecursos.getInstance().getString("EsperantCarga.esperantCargaSilo_label"));
    else if (tipoCarga.equals(MDPanelOperacionsManuals.CARGA_MINILOAD))
      jLabelEsperantCarga.setText(SgaRecursos.getInstance().getString("EsperantCarga.esperantCargaMiniLoad_label"));
    else
      jLabelEsperantCarga.setText(SgaRecursos.getInstance().getString("EsperantCarga.esperantCargaManual_label"));
      
    jLabelEsperantCarga.setFont(new Font(jLabelEsperantCarga.getFont().getName(), 1, 20));
    jLabelEsperantCarga.setHorizontalAlignment(SwingConstants.CENTER);

    buttonsPanel.add(buttonCargaNova);
    if (!tipoCarga.equals(MDPanelEntradesManuals.CARGA_MANUAL))
      buttonsPanel.add(buttonContenidorBuit);
    else
      buttonsPanel.add(buttonSortidaManual);
    
    dataPanel.add(jLabelEsperantCarga, BorderLayout.CENTER);
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

    PanelEsperantCarga panel = new PanelEsperantCarga(MDPanelOperacionsManuals.CARGA_SILO);
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "null", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }

  /**
   * 
   *  JUPanel implementation
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
  private void cargaNova()
  {
    try
    {
      if (tipoCarga.equals(MDPanelEntradesManuals.CARGA_MANUAL))
        MDPanelEntradesManuals.getInstance().cargaNova();
      else
        MDPanelOperacionsManuals.getInstance().cargaNova(tipoCarga, null); 
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  /**
   * Introdueix una carga nova al magatzem
   */
  private void contenidorBuit()
  {
    try
    {
      MDPanelOperacionsManuals.getInstance().contenidorBuit(tipoCarga);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }

  }


  /**
   * Registra una sortida manual del magatzem
   */
  private void sortidaManual()
  {
    try
    {
      MDPanelEntradesManuals.getInstance().sortidesManuals();
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }

  }

 
  public String getTipoCarga()
  {
    return tipoCarga;
  }


  public boolean setFocusInicial()
  {
    return (buttonCargaNova.requestFocusInWindow());
  }
 
}