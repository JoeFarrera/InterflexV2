package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgamacSenseReservaViewRow;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgamacMultirefSenseReservaView1 extends SgaJUPanel implements Observer
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgamacMultirefSenseReservaView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel tablePanel = new JPanel();
  private BorderLayout tableLayout = new BorderLayout();
  
  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonRegularitzar = new JButton();
  private JButton buttonCancelar = new JButton();
  private JButton buttonEvacuar = new JButton();
  private JButton buttonNovaCarga = new JButton();

  private String tipoCarga = null;
  private String macEnPuesto = null;

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Contenidor

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Multireferencia

  private JLabel labelMultiref = new JLabel();
  private JTextField mMultiref = new JTextField();

// Fields for attribute:  Tipus Contenidor

  private JTextField mDesctipmac = new JTextField();

// Fields for attribute:  Pes Inicial

  private JLabel labelPesini = new JLabel();
  private JTextField mPesini = new JTextField();

// Fields for attribute:  Pes Final

  private JLabel labelPesfin = new JLabel();
  private JTextField mPesfin = new JTextField();

// Fields for attribute:  Afegit/Tret/Pes

  private JLabel labelDifpes = new JLabel();
  private JTextField mDifpes = new JTextField();

// Fields for attribute:  Nova Quantitat

  private JLabel labelCancon = new JLabel();
  private JTextField mCancon = new JTextField();

// Fields for attribute:  Observacions

  private JLabel labelObserv = new JLabel();
  private JTextField mObserv = new JTextField();

// Fields for attribute:  SgamacSenseReservaView1

  private SgaJTable tableSgamacSenseReservaView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();

  private PesadaBascula pesadaBascula = null;
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgamacMultirefSenseReservaView1(String tipoCarga)
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
    
    tablePanel.setLayout(tableLayout);
    tablePanel.setMinimumSize(new Dimension(100, 100));
    tablePanel.setMinimumSize(new Dimension(561, 275));
    tablePanel.setPreferredSize(new Dimension(561, 275));
    tablePanel.setMaximumSize(new Dimension(561, 275));

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
    
    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(10);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());
    mIdmac.setEditable(false);

    mDesctipmac.setDocument((Document)panelBinding.bindUIControl("Desctipmac", mDesctipmac));
    dataPanel.add(mDesctipmac, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    mDesctipmac.setColumns(15);
    mDesctipmac.setToolTipText(panelBinding.findCtrlValueBinding("Desctipmac").getTooltip());
    mDesctipmac.setEditable(false);

    mMultiref.setDocument((Document)panelBinding.bindUIControl("Multiref", mMultiref));
    dataPanel.add(labelMultiref, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mMultiref, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    mMultiref.setColumns(2);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());
    mMultiref.setEditable(false);

    //mPesini.setDocument((Document)panelBinding.bindUIControl("Pesini", mPesini));
    dataPanel.add(labelPesini, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesini, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPesini.setLabelFor(mPesini);
    mPesini.setColumns(6);
    labelPesini.setText(panelBinding.findCtrlValueBinding("Pesini").getLabel());
    mPesini.setToolTipText(panelBinding.findCtrlValueBinding("Pesini").getTooltip());

    //mPesfin.setDocument((Document)panelBinding.bindUIControl("Pesfin", mPesfin));
    dataPanel.add(labelPesfin, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesfin, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelPesfin.setLabelFor(mPesfin);
    mPesfin.setColumns(6);
    labelPesfin.setText(panelBinding.findCtrlValueBinding("Pesfin").getLabel());
    mPesfin.setToolTipText(panelBinding.findCtrlValueBinding("Pesfin").getTooltip());

    //mDifpes.setDocument((Document)panelBinding.bindUIControl("Difpes", mDifpes));
    dataPanel.add(labelDifpes, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDifpes, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelDifpes.setLabelFor(mDifpes);
    mDifpes.setColumns(6);
    labelDifpes.setText(panelBinding.findCtrlValueBinding("Difpes").getLabel());
    mDifpes.setToolTipText(panelBinding.findCtrlValueBinding("Difpes").getTooltip());
    
    mCancon.setDocument((Document)panelBinding.bindUIControl("Cancon", mCancon));
    labelCancon.setLabelFor(mCancon);
    mCancon.setColumns(6);
    labelCancon.setText(panelBinding.findCtrlValueBinding("Cancon").getLabel());
    mCancon.setToolTipText(panelBinding.findCtrlValueBinding("Cancon").getTooltip());

    mObserv.setDocument((Document)panelBinding.bindUIControl("Observ", mObserv));
    labelObserv.setLabelFor(mObserv);
    mObserv.setColumns(30);
    labelObserv.setText(panelBinding.findCtrlValueBinding("Observ").getLabel());
    mObserv.setToolTipText(panelBinding.findCtrlValueBinding("Observ").getTooltip());

    // Code support for view object:  SgamacSenseReservaView1
    tableSgamacSenseReservaView1.setModel((TableModel)panelBinding.bindUIControl("SgamacSenseReservaView1", tableSgamacSenseReservaView1));
    tableSgamacSenseReservaView1.setEditable(false);
    scroller.getViewport().add(tableSgamacSenseReservaView1, null);
    
    tablePanel.add(scroller);

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

    // Layout the datapanel and the navigation bar
    tablePanel.add(dataPanel, BorderLayout.NORTH);
    tablePanel.add(scroller, BorderLayout.CENTER);
    add(tablePanel, BorderLayout.CENTER);
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

    PanelSgamacMultirefSenseReservaView1 panel = new PanelSgamacMultirefSenseReservaView1(MDPanelOperacionsManuals.CARGA_SILO);
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


  /**
   * 
   *  Afegit xavi
   */
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }


  public boolean setFocusInicial()
  {
    return (buttonEvacuar.requestFocusInWindow());
  }

  public void setCurrentRow(String idmac)
  {
    // Comentat per que triga molt
    //panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").executeQuery();
    ViewObject vo = panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getViewObject();
    vo.setWhereClause("Sgamac.IDMAC = '" + idmac + "'");
    vo.executeQuery();

    // Si trobem el registre, guardem l'identificador del mac sobre el que estem treballant
    SgamacSenseReservaViewRow mac = (SgamacSenseReservaViewRow)panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getCurrentRow();
    if (mac != null)
      macEnPuesto = mac.getIdmac();
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
      // TODO: No hauria d'arribar mai aqui
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
        mCancon.setText(mac.getCantot().toString());        
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
              //Treiem la clausula where
              panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getViewObject().setWhereClauseParams(null);
              // Fem que manipular sigui true perque es torni a mostrar el mateix panel         
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
      //Treiem la clausula where
      panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getViewObject().setWhereClauseParams(null);
      panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getViewObject().executeQuery();
      // Fem que manipular sigui true perque es torni a mostrar el mateix panel
      MDPanelOperacionsManuals.getInstance().identificarOperacioMacEnPuesto(macEnPuesto, tipoCarga, true);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
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
        //Treiem la clausula where
        panelBinding.findIteratorBinding("SgamacSenseReservaView1Iter").getViewObject().setWhereClauseParams(null);
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

}