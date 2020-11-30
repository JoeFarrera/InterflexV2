package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaresmatmanViewRow;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.*;

import sgalib.JUpperCaseTextField;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgaresmatmanView2 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaresmatmanView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel mainPanel = new JPanel();
  private BorderLayout mainLayout = new BorderLayout();

  private JPanel locatorPanel = new JPanel();
  private GridBagLayout panelLayout = new GridBagLayout();

  private JPanel mainButtonsPanel = new JPanel();
  private FlowLayout mainButtonsLayout = new FlowLayout();

  private JPanel buttonsPanel = new JPanel();
  private VerticalFlowLayout buttonsLayout = new VerticalFlowLayout();

  private JButton buttonAcceptarTot = new JButton();
  private JButton buttonCancelarTot = new JButton();

  private JButton buttonAcceptar = new JButton();
  private JButton buttonCancelar = new JButton();
  private JButton buttonNouBulto = new JButton();
  private JButton buttonMultiBulto = new JButton();
  private JButton buttonTancarBulto = new JButton();
  private JButton buttonVeureOrdre = new JButton();
  private JButton buttonMultiBulto_ = new JButton();

// Fields for locator:

  private JLabel labelIdcabstr = new JLabel();
  private JUpperCaseTextField mIdcabstr = new JUpperCaseTextField();

  private JLabel labelIdcabnum = new JLabel();
  private JTextField mIdcabnum = new JTextField();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();
// Fields for attribute:  SgaresmatmanView2

  private SgaJTable tableSgaresmatmanView2 = new SgaJTable()
  {
    public boolean isCellEditable(int row, int column)    
    {
      boolean isEditable = false;
      // Nomes deixem la columna cancon
      if (getColumnName(column).equals(panelBinding.getLabel("SgaresmatmanView2", "Cancon", null)))
        isEditable = true;
      else
        isEditable = panelBinding.isFindMode();
      return isEditable;
    }
  };

  private JScrollPane scroller = new JScrollPane();

  private Number[] cantBulto = {new Number(0)};
  private boolean bFraccionar = false;

  //Indica si s'ha de tancar el bulto despres de fer la sortida
  private boolean tancarBulto = false;

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaresmatmanView2()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    mainPanel.setLayout(mainLayout);
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    dataPanel.setMinimumSize(new Dimension(561, 250));
    dataPanel.setPreferredSize(new Dimension(561, 250));
    dataPanel.setMaximumSize(new Dimension(561, 250));

    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(139, 275));
    buttonsPanel.setMinimumSize(new Dimension(139, 275));
    buttonsPanel.setMaximumSize(new Dimension(139, 275));
    
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 275));
    this.setPreferredSize(new Dimension(700, 275));
    this.setMinimumSize(new Dimension(700, 275));
    this.setMaximumSize(new Dimension(700, 275));
    this.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("SortidaManual.sortida_label")));
    
    locatorPanel.setLayout(panelLayout);
    locatorPanel.setMinimumSize(new Dimension(100, 100));
    locatorPanel.setMinimumSize(new Dimension(561, 25));
    locatorPanel.setPreferredSize(new Dimension(561, 25));
    locatorPanel.setMaximumSize(new Dimension(561, 25));
    
    this.setLayout(borderLayout);

    mIdcabstr.setDocument((Document)panelBinding.bindUIControl("Idcabstr", mIdcabstr));
    locatorPanel.add(labelIdcabstr, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    locatorPanel.add(mIdcabstr, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdcabstr.setLabelFor(mIdcabstr);
    mIdcabstr.setColumns(3);
    labelIdcabstr.setText(panelBinding.findCtrlValueBinding("Idcabstr").getLabel());
    mIdcabstr.setToolTipText(panelBinding.findCtrlValueBinding("Idcabstr").getTooltip());

    mIdcabnum.setDocument((Document)panelBinding.bindUIControl("Idcabnum", mIdcabnum));
    locatorPanel.add(labelIdcabnum, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    locatorPanel.add(mIdcabnum, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdcabnum.setLabelFor(mIdcabnum);
    mIdcabnum.setColumns(10);
    labelIdcabnum.setText(panelBinding.findCtrlValueBinding("Idcabnum").getLabel());
    mIdcabnum.setToolTipText(panelBinding.findCtrlValueBinding("Idcabnum").getTooltip());
    
    // Code support for view object:  SgaresmatmanView2
    tableSgaresmatmanView2.setModel((TableModel)panelBinding.bindUIControl("SgaresmatmanView2", tableSgaresmatmanView2));
    scroller.getViewport().add(tableSgaresmatmanView2, null);
    
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaresmatmanView2", null, "SgaresmatmanView2Iter"));
    navBar.setHasTransactionButtons(false);
    navBar.setHasFindButton(false);
    navBar.setHasExecuteButton(false);
    navBar.setHasDeleteButton(false);
    navBar.setHasInsertButton(false);
    
    buttonAcceptarTot.setText(SgaRecursos.getInstance().getString("SortidaManual.acceptarTot_label"));
    buttonAcceptarTot.setToolTipText(SgaRecursos.getInstance().getString("SortidaManual.acceptarTot_tooltip"));
    buttonAcceptarTot.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        confirmarSortidaTot();
      }
    });

    buttonCancelarTot.setText(SgaRecursos.getInstance().getString("SortidaManual.cancelarTot_label"));
    buttonCancelarTot.setToolTipText(SgaRecursos.getInstance().getString("SortidaManual.cancelarTot_tooltip"));
    buttonCancelarTot.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        cancelarSortidaTot();
      }
    });

    // Layout the datapanel and the navigation bar
    buttonAcceptar.setText(SgaRecursos.getInstance().getString("SortidaReservada.aceptar_label"));
    buttonAcceptar.setToolTipText(SgaRecursos.getInstance().getString("SortidaReservada.aceptar_tooltip"));
    buttonAcceptar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        cantBulto [0] = new Number(0);
        confirmarSortida(cantBulto, null);
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
      
    mainButtonsPanel.add(buttonAcceptarTot);
    mainButtonsPanel.add(buttonCancelarTot);
    mainButtonsPanel.add(buttonVeureOrdre, null);    

    buttonsPanel.add(buttonAcceptar, null);
    buttonsPanel.add(buttonCancelar, null);
    buttonsPanel.add(buttonNouBulto, null);
    buttonsPanel.add(buttonMultiBulto, null);
    buttonsPanel.add(buttonTancarBulto, null);
    
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(locatorPanel, BorderLayout.NORTH);
    mainPanel.add(navBar, BorderLayout.NORTH);
    mainPanel.add(dataPanel, BorderLayout.CENTER);
    mainPanel.add(buttonsPanel, BorderLayout.EAST);
    mainPanel.add(mainButtonsPanel, BorderLayout.SOUTH);
    add(mainPanel, BorderLayout.CENTER);
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

    PanelSgaresmatmanView2 panel = new PanelSgaresmatmanView2();
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
  
  public void createLocatorRow(String idcabstr, String idcabnum)
  {
      RowSetIterator rsi = panelBinding.findIteratorBinding("SgacdocSortidesresmanLocator").getRowSetIterator();
    Row row = rsi.createRow();
    if (idcabstr != null)
      row.setAttribute("Idcabstr", idcabstr);
    if (idcabnum != null)
      row.setAttribute("Idcabnum", idcabnum);
    rsi.insertRow(row);
  }
  
  public boolean setFocusInicial()
  {
    return (mIdcabstr.requestFocusInWindow());
  }
  
  private void confirmarSortidaTot()
  {
    String currIddoc = null;
    try
    {
      RowSetIterator rsi = panelBinding.findIteratorBinding("SgaresmatmanView2Iter").getRowSetIterator();
      
      SgaresmatmanViewRow resmat = (SgaresmatmanViewRow)rsi.first();
      while (resmat != null)
      {
        //Agafem el número del document que s'esta processant
        if (currIddoc == null)
          currIddoc = resmat.getIddoc().toString();
        // Primer creem els bultos necessaris, segons hagi especificat l'usuari
        resmat.crearBultos_("MAN", new Number(0), false, true);
        // Despres confirmem la reserva
        resmat.confirmarReserva();
        
        resmat = (SgaresmatmanViewRow)rsi.next();
      }
      panelBinding.getApplication().getApplicationModule().getTransaction().commit();        
      
      //Mirem si hi ha etiquetes pendents d'imprimir
      quizasImprimirEtiquetes(currIddoc, null);            
      //Mirem si cal imprimir el packing list

      quizasImprimirPackingList(currIddoc, resmat.getNalbaran());
  
      MDPanelEntradesManuals.getInstance().esperarCarga();
      
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }
  
  private void cancelarSortidaTot()
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
  
  private void quizasImprimirEtiquetes(String iddoc, String idlin)
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      Etiqueta.imprimirEtiqueta(appModule, iddoc, idlin);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  private void quizasImprimirPackingList(String iddoc, String nAlbaran)
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      
      PackingList.imprimirPackingList(this.getClass(), appModule, iddoc, false, appModule.isExport(iddoc) ? PackingList.EXPORT : PackingList.NACIONAL, nAlbaran);
    }
    catch (Exception ex)
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
      SgaresmatmanViewRow resmat = (SgaresmatmanViewRow)panelBinding.findIteratorBinding("SgaresmatmanView2Iter").getCurrentRow();
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


  private void multiBulto_()
  {
    try
    {
      if (cantBulto[0].equals(new Number(0)))
      {
        cantBulto[0] = (Number)panelBinding.findIteratorBinding("SgaresmatmanView2Iter").getCurrentRow().getAttribute("Uniemb");
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
          
          bFraccionar = cb.isSelected();
          String [] bultos = mCantBulto.getText().split(",");
          cantBulto = new Number[bultos.length];
          for (int i=0; i < bultos.length;i++)
            cantBulto[i] = new Number(bultos[i]);
            
          // Activem el flag per tancar bulto, de manera que quan es faci la sortida
          // es tancaran tots els bultos que es crein
          tancarBulto = true;
          
          // Xavi, 05/05/05: Fem que a l'acceptar la quantitat del multiembalum, 
          // es confirmi la sortida
          confirmarSortida(cantBulto, null);
          // Fi afegit Xavi
          tancarBulto = false;
          cantBulto[0] = new Number(0);
        }
        catch(Exception ex)
        {
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
   * Confirma la sortida. Si el flag tancarBulto esta actiu, despres de fer la 
   * sortida tanca el bulto amb el que s'ha fet.
   * Si es multibulto, cant array es distribució
   */
  private void confirmarSortida(Number[] cantBultoSortida, String tipoCarga)
  {
    //Guardem iddoc i idlin per saber els bultos que s'han d'imprimir
    String iddoc = null, idlin = null, idcabstr = null;
    String idcabnum = null;
    AppModule appModule = null;
    boolean bConfirmat = false;
    SgaresmatmanViewRow resmat = null;
    String nAlbaran = null;
    try
    {
      appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      resmat = (SgaresmatmanViewRow)panelBinding.findIteratorBinding("SgaresmatmanView2Iter").getCurrentRow();
      if (resmat != null)
      {
        iddoc = resmat.getIddoc().toString();
        idlin = resmat.getIdlin().toString();
        idcabstr = resmat.getIdcabstr();
        idcabnum = resmat.getIdcabnum();
        
        nAlbaran = resmat.getNalbaran();
        // Primer creem els bultos necessaris, segons hagi especificat l'usuari
        tipoCarga = (tipoCarga != null ? tipoCarga : triarDesti());
        if (tipoCarga != null)
        {
          resmat.crearBultos_(tipoCarga, cantBultoSortida, bFraccionar, tancarBulto);
          // Despres confirmem la reserva
          resmat.confirmarReserva();
          
          appModule.getTransaction().commit();
          bConfirmat = true;
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
    try
    {
      if (bConfirmat)
      {
      // Per acabar imprimim les etiquetes pendents d'imprimir i el packinglist
        quizasImprimirEtiquetes(iddoc, idlin);
        quizasImprimirPackingList(iddoc, nAlbaran);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
    createLocatorRow(idcabstr, idcabnum);
    
  }
  

  /**
   * Cancelar l'operació de sortida (permet anul.lar reserva) 
   */
  private void cancelarSortida()
  {
    String idcabstr = null;
    String idcabnum = null;
    try
    {
      SgaresmatmanViewRow resmat = (SgaresmatmanViewRow)panelBinding.findIteratorBinding("SgaresmatmanView2Iter").getCurrentRow();
      if (resmat != null)
      {
        idcabstr = resmat.getIdcabstr();
        idcabnum = resmat.getIdcabnum();
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
            resmat.anularReserva(false);
            appModule.getTransaction().commit();
            break;
          case 1:
          case JOptionPane.CLOSED_OPTION:      
          default:      
            appModule.getTransaction().rollback();
            break;
          }
      }
      createLocatorRow(idcabstr, idcabnum);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  private void nouBulto()
  {
    try
    {
      SgaresmatmanViewRow resmat = (SgaresmatmanViewRow)panelBinding.findIteratorBinding("SgaresmatmanView2Iter").getCurrentRow();
      if (resmat != null)
      {
        // String tipoCarga = triarDesti();
        String tipoCarga = "MAN";
        if (tipoCarga != null)
        {
          resmat.nouBulto(tipoCarga);
          // Xavi, 02/05/2005: Afegit per assegurar que continua sobre el mateix registre
          panelBinding.findIteratorBinding("SgaresmatmanView2Iter").setCurrentRowWithKey(resmat.getKey().toStringFormat(true));
          //FI afegit xavi
          // Confirmem la sortida directament desde aqui
          // confirmarSortida(tipoCarga);
        }
      }
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
      // Activem el flag per tancar bulto i fem la sortida
      tancarBulto = true;
      cantBulto[0] = new Number(0);
      confirmarSortida(cantBulto, null);
      tancarBulto = false;
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }

  
  private String triarDesti()
  {
    int eleccion = 0;
    Object []      message = new Object[3];
    message [0] = SgaRecursos.getInstance().getString("SortidaManual.triarDesti_label");
    message [1] = " ";  // Para que haya un hueco
    
    JComboBox cb = new JComboBox();
    cb.addItem("MAN");
    cb.addItem("SLO");
    cb.addItem("MLD");
   

    message [2] = cb;
    
    // Options
    String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                        SgaRecursos.getInstance().getString("Options.cancelar_label") };

    eleccion = JOptionPane.showOptionDialog(
          Interflex.getInstance(),                                       // the parent that the dialog blocks
          message,                                    // the dialog message array
          SgaRecursos.getInstance().getString("SortidaManual.triarDesti_label"),            // the title of the dialog window
          JOptionPane.DEFAULT_OPTION,                 // option type
          JOptionPane.INFORMATION_MESSAGE,            // message type
          null,                                       // optional icon, use null to use the default icon
          options,                                    // options string array, will be made into buttons
          options[0]                                  // option that should be made into a default button
          );
    if (eleccion == 0)
      // Ha aceptado algo
      return ((String)cb.getSelectedItem());
      
    return null;
  }
  
  
}
