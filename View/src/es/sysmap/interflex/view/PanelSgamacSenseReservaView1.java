package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacSenseReservaViewRow;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.text.*;

import oracle.adf.model.BindingContext;
import oracle.jbo.Key;
import oracle.jbo.RowInconsistentException;
import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.*;

import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSgamacSenseReservaView1 extends SgaJUPanel implements Observer
// public class PanelSgamacSenseReservaView1 extends JUPanel
{

  // Para la modificación del peso
  PanelSgavarticulomodpesView panelModPes = null;
  
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgamacSenseReservaView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonRegularitzar = new JButton();
  private JButton buttonCancelar = new JButton();
  private JButton buttonEvacuar = new JButton();
  private JButton buttonNovaCarga = new JButton();
  
  private String tipoCarga = null;
  private String macEnPuesto = null;

  private JPanel macPanel = new JPanel();
  private GridBagLayout macPanelLayout = new GridBagLayout();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Contenidor

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Multireferencia

  private JLabel labelMultiref = new JLabel();
  private JTextField mMultiref = new JTextField();

// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Idart

  private JLabel labelIdart = new JLabel();
  private JTextField mIdart = new JTextField();

// Fields for attribute:  Descripció

  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Nova Quantitat

  private JLabel labelCancon = new JLabel();
  private JTextField mCancon = new JTextField();

// Fields for attribute:  Observacions

  private JLabel labelObserv = new JLabel();
  private JTextField mObserv = new JTextField();

// Fields for attribute:  Pes Inicial

  private JLabel labelPesini = new JLabel();
  private JTextField mPesini = new JTextField();

// Fields for attribute:  Pes Final

  private JLabel labelPesfin = new JLabel();
  private JTextField mPesfin = new JTextField();

// Fields for attribute:  Afegit/Tret/Pes

  private JLabel labelDifpes = new JLabel();
  private JTextField mDifpes = new JTextField();

// Fields for attribute:  Cantot

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();

// Fields for attribute:  Tipus Contenidor

  private JTextField mDesctipmac = new JTextField();

  private PesadaBascula pesadaBascula = null;
  private JButton buttonPesUnit = new JButton();
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgamacSenseReservaView1(String tipoCarga)
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
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("ContenidorSenseReserva.sortidaSilo")));
    else
      dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("ContenidorSenseReserva.sortidaMiniLoad")));

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
    macPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("ContenidorSenseReserva.macPanel")));

    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    buttonPesUnit.setText("Pes Unitari");
    buttonPesUnit.setToolTipText("Establir el pes unitari del article");
    buttonPesUnit.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          buttonPesUnit_actionPerformed(e);
        }
      });
    
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(10);
    mIdartif.setEditable(false);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());

    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(mDescrip, new GridBagConstraints(0, 1, 8, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 1, 1));
    mDescrip.setColumns(40);
    mDescrip.setEditable(false);
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());

    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    macPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mIdmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(8);
    mIdmac.setEditable(false);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());

/*    mMultiref.setDocument((Document)panelBinding.bindUIControl("Multiref", mMultiref));
    macPanel.add(labelMultiref, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mMultiref, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    mMultiref.setColumns(15);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());*/

    mDesctipmac.setDocument((Document)panelBinding.bindUIControl("Desctipmac", mDesctipmac));
    macPanel.add(mDesctipmac, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    mDesctipmac.setColumns(15);
    mDesctipmac.setEditable(false);
    mDesctipmac.setToolTipText(panelBinding.findCtrlValueBinding("Desctipmac").getTooltip());

    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    macPanel.add(labelCantot, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mCantot, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(6);
    mCantot.setEditable(false);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());

    mCancon.setDocument((Document)panelBinding.bindUIControl("Cancon", mCancon));
//    macPanel.add(labelCancon, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
//    macPanel.add(mCancon, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelCancon.setLabelFor(mCancon);
    mCancon.setColumns(6);
    labelCancon.setText(panelBinding.findCtrlValueBinding("Cancon").getLabel());
    mCancon.setToolTipText(panelBinding.findCtrlValueBinding("Cancon").getTooltip());
//    mCancon.addFocusListener(new FocusAdapter()
//      {
//        public void focusGained(FocusEvent e)
//        {
//          mCancon_focusGained(e);
//        }
//      });

    mObserv.setDocument((Document)panelBinding.bindUIControl("Observ", mObserv));
    labelObserv.setLabelFor(mObserv);
    mObserv.setColumns(30);
    labelObserv.setText(panelBinding.findCtrlValueBinding("Observ").getLabel());
    mObserv.setToolTipText(panelBinding.findCtrlValueBinding("Observ").getTooltip());

    mDifpes.setDocument((Document)panelBinding.bindUIControl("Difpes", mDifpes));
    macPanel.add(labelDifpes, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mDifpes, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelDifpes.setLabelFor(mDifpes);
    mDifpes.setColumns(6);
    mDifpes.setEditable(false);
    labelDifpes.setText(panelBinding.findCtrlValueBinding("Difpes").getLabel());
    mDifpes.setToolTipText(panelBinding.findCtrlValueBinding("Difpes").getTooltip());

    mPesini.setDocument((Document)panelBinding.bindUIControl("Pesini", mPesini));
    macPanel.add(labelPesini, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mPesini, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPesini.setLabelFor(mPesini);
    mPesini.setColumns(6);
    mPesini.setEditable(false);
    labelPesini.setText(panelBinding.findCtrlValueBinding("Pesini").getLabel());
    mPesini.setToolTipText(panelBinding.findCtrlValueBinding("Pesini").getTooltip());

    mPesfin.setDocument((Document)panelBinding.bindUIControl("Pesfin", mPesfin));
    macPanel.add(labelPesfin, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    macPanel.add(mPesfin, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPesfin.setLabelFor(mPesfin);
    mPesfin.setColumns(6);
    mPesfin.setEditable(false);
    labelPesfin.setText(panelBinding.findCtrlValueBinding("Pesfin").getLabel());
    mPesfin.setToolTipText(panelBinding.findCtrlValueBinding("Pesfin").getTooltip());

    dataPanel.add(macPanel, new GridBagConstraints(0, 2, 6, 5, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));        

    buttonRegularitzar.setText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.regularitzar_label"));
    buttonRegularitzar.setToolTipText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.regularitzar_tooltip"));
    buttonRegularitzar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          confirmarRegularitzacio();
        }
      });

    buttonCancelar.setText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.cancelar_label"));
    buttonCancelar.setToolTipText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.cancelar_tooltip"));
    buttonCancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cancelarRegularitzacio();
        }
      });

    buttonEvacuar.setText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.evacuar_label"));
    buttonEvacuar.setToolTipText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.evacuar_tooltip"));
    buttonEvacuar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          confirmarEvacuacio();
        }
      });

    buttonNovaCarga.setText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.cargaNova_label"));
    buttonNovaCarga.setToolTipText(SgaRecursos.getInstance().getString("ContenidorSenseReserva.cargaNova_tooltip"));
    buttonNovaCarga.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cargaNova();
        }
      });
    
    buttonsPanel.add(buttonRegularitzar);
    buttonsPanel.add(buttonCancelar);
    buttonsPanel.add(buttonNovaCarga);
    buttonsPanel.add(buttonEvacuar);
    if (isUserModPes())
      buttonsPanel.add(buttonPesUnit, null);

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

    PanelSgamacSenseReservaView1 panel = new PanelSgamacSenseReservaView1(MDPanelOperacionsManuals.CARGA_SILO);
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
    return (this.buttonEvacuar.requestFocusInWindow());
  }

/*  private void mCancon_focusGained(FocusEvent e)
  {
    // Inicialitzem cancon
    if (mCancon.getText() == null || mCancon.getText().equals(""))
    {
      mCancon.setText(mCantot.getText());
      mCancon.postActionEvent();
    }
    mCancon.selectAll();
  }*/

  public void setCurrentRow(String idmac)
  {
    //Comentat per proves de velocitat
    //panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").executeQuery();
    //panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").setCurrentRowWithKey(key.toStringFormat(true));
    
    panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getViewObject().setWhereClause("sgamac.idmac = '" + idmac + "'");
    panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").executeQuery();

    // Si trobem el registre, guardem l'identificador del mac sobre el que estem treballant
    SgamacSenseReservaViewRow mac = (SgamacSenseReservaViewRow)panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getCurrentRow();
    if (mac != null)
      macEnPuesto = mac.getIdmac();
    else;
      //TODO: Seria un error que no hauria de passar mai
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
      //TODO: No hauria d'arribar mai aquí
    }
  }

  /**
   * Confirma la operació sobre el contenidor
   */
  private void confirmarRegularitzacio()
  {
    JPanel regulPanel = new JPanel();
    GridBagLayout regulPanelLayout = new GridBagLayout();
    try
    {
      SgamacSenseReservaViewRow mac = (SgamacSenseReservaViewRow)panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getCurrentRow();
      if (mac != null)
      {
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                            SgaRecursos.getInstance().getString("Options.cancelar_label") };
        regulPanel.setLayout(regulPanelLayout);                            
 
        regulPanel.add(labelCancon, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        regulPanel.add(mCancon, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        regulPanel.add(labelObserv, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        regulPanel.add(mObserv, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        //Inicialitzem la quantitat confirmada amb la quantitat total del mac
        mCancon.setText(mCantot.getText());        
        mCancon.postActionEvent();
        
        
         
        
       int result = 0; 
       do 
       {
        // loop until user cancels or provides value for mObserv field
        result = JOptionPane.showOptionDialog(
              null,                                       // the parent that the dialog blocks
              regulPanel,                                    // the dialog message array
              panelBinding.findCtrlValueBinding("Cancon").getLabel(),            // the title of the dialog window
              JOptionPane.DEFAULT_OPTION,                 // option type
              JOptionPane.INFORMATION_MESSAGE,            // message type
              null,                                       // optional icon, use null to use the default icon
              options,                                    // options string array, will be made into buttons
              options[0]                                  // option that should be made into a default button
              );
          mObserv.setBackground(Color.RED);
         } while (result == 0 && ! (mObserv.getText() != null && mObserv.getText().length() > 0));
         
        switch(result)
        {
          case 0:                        
          {
            int action = 0;
            if (mac.verificarPes())
            {
              String [] options2 = {SgaRecursos.getInstance().getString("ControlPes.botoContinuarPes_label"), 
                  SgaRecursos.getInstance().getString("ControlPes.botoCancelarPes_label")};
              action = JOptionPane.showOptionDialog(Interflex.getInstance().getFrame(), 
                  SgaRecursos.getInstance().getString("ControlPes.verificarPes1_label") + this.mDifpes.getText() + " " +
                  SgaRecursos.getInstance().getString("ControlPes.verificarPes2_label") + this.mCancon.getText(), 
                  SgaRecursos.getInstance().getString("ControlPes.verificarPes_title"), 
                  JOptionPane.YES_NO_OPTION, 
                  JOptionPane.QUESTION_MESSAGE, null, options2, options2[(1)]);
            }
            if (action == 0)
            {
              mac.actualitzarMac();
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
/*          boolean bCommit = false;
          int numIntents = 0;
          while (!bCommit && numIntents < 10)
          {
            try
            {
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              bCommit = true;
            }
            catch(RowInconsistentException ex)
            {
              // Intenta fer el commit fins a numIntents
              numIntents++;
            }
          }
          if (!bCommit)
          {
            JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("SortidaReservada.errorOperacio"));
            cancelarRegularitzacio();            
          }*/
              // Fem que manipular sigui true perque es torni a mostrar el mateix panel         
              //MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, false);
              MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, true);
            }
            else
              cancelarRegularitzacio();
          break;
          }
          default:
            cancelarRegularitzacio();
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
   * Cancel·la la operació sobre el contenidor
   */
  private void cancelarRegularitzacio()
  {
    try
    {
      panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
      // Fem que manipular sigui true perque es torni a mostrar el mateix panel
      //MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, false);
      MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, true);
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
      // fem un rollback
      panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
      // tornem a establir el registre actual
      setCurrentRow(macEnPuesto);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  /**
   * Ver si el usuario tiene derecho de modificar el peso
   * @return 
   */
  private boolean isUserModPes()
  {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      return appModule.isUserModPes();
    
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
  
  
  private void registerProjectGlobalVariables(BindingContext bindCtx)
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
      panelBinding.findIterBinding("SgamacSenseReservaView1Iter").getViewObject().setMaxFetchSize(0);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
        panelBinding.findIterBinding("SgamacSenseReservaView1Iter").getViewObject().setMaxFetchSize(-1);
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }
    }
  }

  private void buttonPesUnit_actionPerformed(ActionEvent e)
  {
    if (panelModPes == null)
      panelModPes = PanelSgavarticulomodpesView.getInstance(panelBinding.getBindingContext());
    
    panelModPes.modPesUnitari(mPesini.getText(), mPesfin.getText(), macEnPuesto);
    }
  
}