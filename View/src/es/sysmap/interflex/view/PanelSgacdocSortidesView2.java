package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
// import es.sysmap.interflex.model.dmc.common.SgacdocSortidesView;
import es.sysmap.interflex.model.dmc.common.SgacdocSortidesViewRow;

import es.sysmap.interflex.model.dmc.common.SgacdocViewRow;
import es.sysmap.interflex.model.dmc.common.SgavBultoCantErroneoRow;
import java.awt.*;
import java.awt.event.*;

import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.java.util.Iterator;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

// public class PanelSgacdocSortidesView2 extends JPanel implements JUPanel
public class PanelSgacdocSortidesView2 extends SgaJUPanel
{
  private static int EXPORT = 1;
  private static int NOEXPORT = 0;
 
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgacdocSortidesView2UIModel");
  
  private PanelSgaexpedView3 panelExped = null;

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private CDocSgaJUNavigationBar navBar = new CDocSgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgacdocSortidesView1

  private SgaJTable tableSgacdocSortidesView1 = new SgaJTable();

  private JScrollPane scroller = new JScrollPane();

  private JButton buttonObrirOrdre = new JButton();
  private JButton buttonSuspendreOrdre = new JButton();
  private JButton buttonTancarOrdre = new JButton();
  private JButton buttonReserves = new JButton();
  private JButton buttonResman = new JButton();
  private JButton buttonBultos = new JButton();
  private JButton buttonPackingList = new JButton();
  
  
  private Color defaultTableBackground = tableSgacdocSortidesView1.getBackground();
  private Color defaultTableForeground = tableSgacdocSortidesView1.getForeground();

 
  private String puesto = null;
  private JButton buttonPackingListExp = new JButton();
  private JButton buttonBultosX = new JButton();
  
  
  JComboBox filtroMagatzem = new JComboBox(new Object[] {"TOT", "SLO/MLD", "MLD", "SLO", "MAN"});   
  
  JButton filtroGrupatgeButton = new JButton("Grupatge");
  JButton bultosCantErroneo = new JButton("(Provisional) Bultos erroneos ");
  
  String currFiltroGrupatge = "P";  
  
 
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgacdocSortidesView2()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(700, 221));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Sortides.capçalera_label")));
    dataPanel.setPreferredSize(new Dimension(700, 221));
    dataPanel.setMaximumSize(new Dimension(700, 221));
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(700, 37));
    buttonsPanel.setMinimumSize(new Dimension(700, 37));
    buttonsPanel.setMaximumSize(new Dimension(750, 37));
    buttonsPanel.setSize(new Dimension(700, 40));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(801, 246));
    this.setPreferredSize(new Dimension(700, 250));
    this.setMinimumSize(new Dimension(700, 250));
    this.setMaximumSize(new Dimension(700, 250));
    panelBinding.addRowSetListener(new JUPanelRowSetAdapter()
      {
        public void navigated(JUIteratorBinding iter, NavigationEvent event)
        {
          updateButtons();
        }

        public void rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
        {
          updateButtons();
        }

      });
    // Code support for view object:  SgacdocSortidesView1
    tableSgacdocSortidesView1.setModel((TableModel)panelBinding.bindUIControl("SgacdocSortidesView1", tableSgacdocSortidesView1));
    tableSgacdocSortidesView1.setEditable(false);
    scroller.getViewport().add(tableSgacdocSortidesView1, null);

    buttonObrirOrdre.setText("Obrir");
    buttonObrirOrdre.setToolTipText(SgaRecursos.getInstance().getString("Sortides.obrirOrdre_tooltip"));
    buttonObrirOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("P");
        }
      });
    buttonSuspendreOrdre.setText("Suspendre");
    buttonSuspendreOrdre.setToolTipText(SgaRecursos.getInstance().getString("Sortides.suspendreOrdre_tooltip"));
    buttonSuspendreOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("S");
        }
      });
    buttonTancarOrdre.setText("Tancar");
    buttonTancarOrdre.setToolTipText(SgaRecursos.getInstance().getString("Sortides.tancarOrdre_tooltip"));
    buttonTancarOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("A");
        }
      });
    buttonReserves.setText(SgaRecursos.getInstance().getString("Sortides.veureReserves_label"));
    buttonReserves.setToolTipText(SgaRecursos.getInstance().getString("Sortides.veureReserves_tooltip"));
    buttonReserves.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureReserves();
        }
      });

    buttonResman.setText(SgaRecursos.getInstance().getString("Sortides.veureResman_label"));
    buttonResman.setToolTipText(SgaRecursos.getInstance().getString("Sortides.veureResman_tooltip"));
    buttonResman.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureResman();
        }
      });

    buttonBultos.setText(SgaRecursos.getInstance().getString("Sortides.veureBultos_label"));
    buttonBultos.setToolTipText(SgaRecursos.getInstance().getString("Sortides.veureBultos_tooltip"));
    buttonBultos.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureBultos(NOEXPORT);
        }
      });

    buttonPackingList.setText("PL-N");
    buttonPackingList.setToolTipText("Imprimir Packing List \"Nacional\"");
    buttonPackingList.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirPackingList(PackingList.NACIONAL);
        }
      });
    buttonPackingListExp.setText("PL-X");
    buttonPackingListExp.setToolTipText("Imprimir Packing List d\'Exportació");
    buttonPackingListExp.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirPackingList(PackingList.EXPORT);
        }
      });
    buttonBultosX.setText("Embalum-X");
    buttonBultosX.setToolTipText("Pes / Volum del embalums per export");
    buttonBultosX.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureBultos(EXPORT);
        }
      });

    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgacdocSortidesView1", null, "SgacdocSortidesView1Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    
    
    // Layout the datapanel and the navigation bar
    buttonsPanel.add(buttonObrirOrdre);
    buttonsPanel.add(buttonTancarOrdre);
    buttonsPanel.add(buttonSuspendreOrdre);
    buttonsPanel.add(buttonReserves);
    buttonsPanel.add(buttonResman);
    buttonsPanel.add(buttonBultos);
    buttonsPanel.add(buttonBultosX, null);
    buttonsPanel.add(buttonPackingList);
    buttonsPanel.add(buttonPackingListExp, null);
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);
    

      addPopup();
    
    
    
    setCustomCellRenderer(tableSgacdocSortidesView1);
    
      
    navBar.afegirFiltreMagatzem(filtroMagatzem, "Filtrar per magatzem");
    
    navBar.afegirBoto(bultosCantErroneo);    
    navBar.addSeparator();
   
    navBar.afegirBoto(filtroGrupatgeButton);

    
    navBar.afegirBotoFiltrarLegacy(); // Just to get right position!!
    
    
    
    
    filtroMagatzem.addItemListener(new FiltroMagatzemComboChangeListener()); 
    
 
    bultosCantErroneo.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        showBultosErroneos();
      }
    });
    
    filtroGrupatgeButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          if (currFiltroGrupatge.equals("P"))
          {
            filtroGrupatgeButton.setText("Paqueteria");
            currFiltroGrupatge = "G";
          }
          else
          {
            filtroGrupatgeButton.setText("Grupatge");
            currFiltroGrupatge = "P";
          }
          
          setFiltroPreparacion(currFiltroGrupatge); 
        }
      });
      
      
  
    setFiltroPreparacion(currFiltroGrupatge);

  }
  
  private void setCustomCellRenderer (JTable table)
  {
    
    for (int i = 0; i < table.getColumnCount() ; i++) 
    {
      TableColumn tcol = table.getColumnModel().getColumn(i);
      tcol.setCellRenderer(new CustomTableCellRenderer());      
    }
    
  }
  
  /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      // Michael 29.01.2009 Añadir posibilidad de bloquear/desbloquear la salida
      boolean enabled = Interflex.getInstance().hasAcceso("SGABLOQORD");
    
      
      tableSgacdocSortidesView1.addPopupSeparator();
      
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.bloqueijar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/forbidden.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("B");
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.desbloqueijar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/bullet_ball_blue.png", null));
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("U");
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);

    
    AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
    enabled = appModule.isAdministrador();
    menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.set_grupatge_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/forklifter.png", null));
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          setOrdreTipDocSGA("G");
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);
      
     menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.set_paqueteria_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cube_green_new.png", null));
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          setOrdreTipDocSGA("P");
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);
      
      
      tableSgacdocSortidesView1.addPopupSeparator();
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("MenuSortides.sortides_pujar_prioridad_5"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/selection_up.png", null));
      // 0: Máxima prioridad 9: Mínima !!
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          setPrioridad(-5);
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);
      
     menuItem = new JMenuItem(SgaRecursos.getInstance().getString("MenuSortides.sortides_pujar_prioridad_1"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/selection_up.png", null));
      // 0: Máxima prioridad 9: Mínima !!
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          setPrioridad(-1);
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);
    
     tableSgacdocSortidesView1.addPopupSeparator();
     menuItem = new JMenuItem(SgaRecursos.getInstance().getString("MenuSortides.sortides_baixar_prioridad_5"));
     // 0: Máxima prioridad 9: Mínima !!
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/selection_down.png", null));
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          setPrioridad(5);
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);

     menuItem = new JMenuItem(SgaRecursos.getInstance().getString("MenuSortides.sortides_baixar_prioridad_1"));
     // 0: Máxima prioridad 9: Mínima !!
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/selection_down.png", null));
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          setPrioridad(1);
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);    
      
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.activarLiniesMaxi"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/transform.png", null));
      menuItem.addActionListener(new ActionListener()
      {
      public void actionPerformed(ActionEvent e)
        {
          ObrirLiniesMaxi();
        }
      });      
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);

      tableSgacdocSortidesView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.formatosDoc_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cube_yellow.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureFormatEnviament();
        }
      });   
      tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      
      tableSgacdocSortidesView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.expedicio_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/package_new.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          insertarExpedicio();
        }
      });   
     tableSgacdocSortidesView1.addPopupMenuItem(menuItem);
      
  }
  
  
  private void bloqueijarOrdre ()
  {
    
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

    PanelSgacdocSortidesView2 panel = new PanelSgacdocSortidesView2();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
    
    // panel.quizasImprimirEtiquetes("204322");
    panel.quizasImprimirPackingList("204322", null);
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

  public void setBindingContext(BindingContext bindCtx)
  {
    super.setBindingContext(bindCtx);
    //Actualitzem l'estat dels botons
    updateButtons();
  }
  
  
  
  /**
   * Actualitza la comanda com de Paqueteria o Grupatge
   * Segons especificacions octubre 2013: SGA Tipologia Comandes
   * 
   */
   private void setOrdreTipDocSGA (String tipdoc) 
   {
     SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
     currordre.setTipdocsga(tipdoc);
     panelBinding.getApplication().getApplicationModule().getTransaction().commit();
     navBar.getModel().getViewObject().executeQuery();
     
   }
  
  /**
   * Actualitza la comanda com de Paqueteria o Grupatge
   * Segons especificacions octubre 2013: SGA Tipologia Comandes
   * 
   */
   private void setPrioridad (int incremento) 
   {
     SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
     currordre.incrementarPrioridad(incremento);
     panelBinding.getApplication().getApplicationModule().getTransaction().commit();
     navBar.getModel().getViewObject().executeQuery();
     
   }
   
   
  private boolean veureLiniesMaxi(Vector vectorLinies, String puesto, SgacdocSortidesViewRow currordre)
  {
  
   
    Object display = null;
    if (vectorLinies != null)
    {
      if (vectorLinies.size() == 0)
      {
        display = "No hi ha línies per activar";
      }
      else
      {
        JList textMessage = new JList(currordre.getStringLiniesMaxiload(vectorLinies).toArray());
        JPanel pane = new JPanel(new BorderLayout(10, 10));
        pane.setBorder(BorderFactory.createLineBorder(
                                    Color.DARK_GRAY.darker(), 1));
        
        pane.add(textMessage, BorderLayout.CENTER);
        display = pane;
        
      }
      // Options
      String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };

      int option = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            display,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.liniesMaxi") + " " + puesto,            // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.QUESTION_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options2,                                    // options string array, will be made into buttons
            options2[0]                                  // option that should be made into a default button
            );
      return (option == 0 ? true:false);    
    }
    return false;
  }



 
  private void ObrirLiniesMaxi()
  {
  
    Key key = null;
      if (puesto == null)
        puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");

    Cursor curCursor = getCursor();
  
    try 
    {
      SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      if (currordre != null) 
      {
      key = currordre.getKey();
      // No deja activar líneas de un pedido bloquedo
      String curEstado = currordre.getEstadolineas();
      if (curEstado.equals("D") || curEstado.equals("P"))
      {
 
          String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };
 
          int result = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                "Activar les línies Maxiload de la comanda " + currordre.getIdcabnum() + " en el puesto",                                    // the dialog message array
                "Confirmar activació", // the title of the dialog window
                JOptionPane.DEFAULT_OPTION,                 // option type
                JOptionPane.QUESTION_MESSAGE,            // message type
                null,
                options2,
                null);
                
         if (result != 0)
          return;
          
        Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
        setCursor(waitCursor);
        revalidate();

        Vector vectorLinies = currordre.getLiniesMaxiload();  
        setCursor(curCursor);

        if (vectorLinies != null && vectorLinies.size() > 0) {
           currordre.activarLiniesMaxiload(vectorLinies, puesto);
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              

          // Try to get on the same row

          try
          {
            panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").setCurrentRowWithKey(key.toStringFormat(true));
          }
          // Michael 15.06.2009
          catch (oracle.jbo.RowNotFoundException exNotFound)
          {
            ; // Nada - que ya se ha enviado al host 
          }
          JOptionPane.showMessageDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                vectorLinies.size() + " línies Maxiload activades " + " ("  + currordre.getIdcabstr() + " " + currordre.getIdcabnum() + ")",                                    // the dialog message array
                "Activar línies en el Maxiload", // the title of the dialog window
                JOptionPane.INFORMATION_MESSAGE)  ;               // option type

          return;
 

      }
      else 
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(),
          "No s'han trobat línies per obrir de la comanda " + currordre.getIdcabstr() + " " + currordre.getIdcabnum(),
           "Activar línies en el Maxiload", // the title of the dialog window
                JOptionPane.WARNING_MESSAGE);               // option type
                
        return;
      }
      }
      else 
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), "El estat de la comanda no permet l'operació");
          
      }
    }
    }
    catch (Exception ex) 
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
   
   
 /**
   * Actualitza el bulto segons l'estat que se li passa com a paràmetre
   * Michael 29.01.2009 - Tratar caso de una orden bloqueado "B" y poner Disponible
   * @param estat
   */
  private void actualitzarOrdre(String estat)
  {
    try
    {
      SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      if (currordre != null)
      {
        
        // Activem els detalls del bulto i gravem
        // TODO: Veure com desactivar el setClearCacheOnCommit desde el f
        // per evitar que se'n vagi al primer registre després de fer el commit
          if (puesto == null)
            puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
          
          // Michael 12.11.2008 Si quiere anular la orden, pide confirmación 
          if (estat.equals("A"))
          {
          String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };
 
          int result = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                SgaRecursos.getInstance().getString("Sortides.confirmar_tancar") + " " + currordre.getIdcabstr() + " " + currordre.getIdcabnum(),                                    // the dialog message array
                "Confirmar", // the title of the dialog window
                JOptionPane.DEFAULT_OPTION,                 // option type
                JOptionPane.QUESTION_MESSAGE,            // message type
                null,
                options2,
                null);
          
                
          if (result != 0)
            return;
          }
          
          
          String currEstado = currordre.getEstado();
          
          if (estat.equals("B"))
          {
            if (!currEstado.equals("D"))
            {
           JOptionPane.showMessageDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                SgaRecursos.getInstance().getString("Sortides.no_es_pot_bloquejar") + " ("  + currordre.getIdcabstr() + " " + currordre.getIdcabnum() + ")",                                    // the dialog message array
                SgaRecursos.getInstance().getString("Sortides.obrirOrdre_label"), // the title of the dialog window
                JOptionPane.WARNING_MESSAGE)  ;               // option type
                return;
              
            }

           String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };
 
            int result = JOptionPane.showOptionDialog(
                  Interflex.getInstance(),                                       // the parent that the dialog blocks
                  SgaRecursos.getInstance().getString("Sortides.confirmar_bloqueijar") + " " + currordre.getIdcabstr() + " " + currordre.getIdcabnum(),                                    // the dialog message array
                  "Confirmar", // the title of the dialog window
                  JOptionPane.DEFAULT_OPTION,                 // option type
                  JOptionPane.QUESTION_MESSAGE,            // message type
                  null,
                  options2,
                  null);
            
                  
            if (result != 0)
              return;
            }

          if (estat.equals("U"))
          {
            // unblock an order - must be blocked...
            if (!currEstado.equals("B"))
            {
           JOptionPane.showMessageDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                SgaRecursos.getInstance().getString("Sortides.desbloqueijar_no_bloqueijar_label") 
                + " ("  + currordre.getIdcabstr() + " " + currordre.getIdcabnum() + ")",                                    // the dialog message array
                SgaRecursos.getInstance().getString("Sortides.obrirOrdre_label"), // the title of the dialog window
                JOptionPane.WARNING_MESSAGE)  ;               // option type
                return;
              
            }
            else
              estat = "D";  // Poner Disponible
           
          }
          
          // Michael 29.01.2009 If the order is blocked
          if (currEstado.equals("B") && (!estat.equals("D")))
          {
          JOptionPane.showMessageDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                SgaRecursos.getInstance().getString("Sortides.ordre_no_es_pot_preparar") + " " + currordre.getIdcabstr() + " " + currordre.getIdcabnum(),                                    // the dialog message array
                SgaRecursos.getInstance().getString("Sortides.obrirOrdre_label"), // the title of the dialog window
                JOptionPane.WARNING_MESSAGE)  ;               // option type
                return;
              
          }
          
 
          String estLineas = currordre.getEstadolineas();
          currordre.actualitzarOrdre(estat, puesto);
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          //Mirem si hi ha etiquetes pendents d'imprimir
          quizasImprimirEtiquetes(currordre.getIddoc().toString());            
          //Mirem si cal imprimir el packing list
          quizasImprimirPackingList(currordre.getIddoc().toString(), currordre.getNalbaran().toString()); // TODO 2.06.2010 Ver de imprimir automaticamente si es export
          ///-------------Esta en test 
          Key key = currordre.getKey();
          panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").executeQuery();
          try
          {
            panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").setCurrentRowWithKey(key.toStringFormat(true));
          }
          // Michael 15.06.2009
          catch (oracle.jbo.RowNotFoundException exNotFound)
          {
            ; // Nada - que ya se ha enviado al host 
          }
          catch(Exception ex)
          {
            //Pot ser que en algun cas no trobi el registre per que ja s'ha enviat al host
            JUMetaObjectManager.reportException(null, ex);
          }
          ///-------------FI Esta en test 
          
          updateButtons();
        //Fem visible el registre seleccionat
        tableSgacdocSortidesView1.makeSelectedRowVisible();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Mostra les reserves pel document
   * @param estat
   */
  private void veureReserves()
  {
    try
    {
      SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      if (currordre != null)
      {
        // Fem un executeQuery abans de mostrar les reserves i tornem a deixar el 
        // cursor al mateix registre
        
        panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").executeQuery();
        panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").setCurrentRowWithKey(currordre.getKey().toStringFormat(true));
        //scroller.getViewport().scrollRectToVisible(tableSgacdocSortidesView1.getCellRect(tableSgacdocSortidesView1.getSelectedRow(), 0, true));
        tableSgacdocSortidesView1.grabFocus();
        // Fi del bloc executeQuery
        PanelSgaresmatView6 panelSgaresmatView6 = new PanelSgaresmatView6();
        panelSgaresmatView6.setBindingContext(panelBinding.getBindingContext());
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSgaresmatView6,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.llistaReserves_label"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
        panelSgaresmatView6.releasePanelBinding();
        panelSgaresmatView6 = null;
        //Fem visible el registre seleccionat
        tableSgacdocSortidesView1.makeSelectedRowVisible();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Mostra les reserves manuals pel document i permet imprimir un report amb aquestes
   * @param estat
   */
  private void veureResman()
  {
    try
    {
      SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      if (currordre != null)
      {
        // Fem un executeQuery abans de mostrar les reserves i tornem a deixar el 
        // cursor al mateix registre
        panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").executeQuery();
        panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").setCurrentRowWithKey(currordre.getKey().toStringFormat(true));
        //scroller.getViewport().scrollRectToVisible(tableSgacdocSortidesView1.getCellRect(tableSgacdocSortidesView1.getSelectedRow(), 0, true));
        tableSgacdocSortidesView1.grabFocus();
        // Fi del bloc executeQuery
        PanelSgaresmatmanView1 panelSgaresmatmanView1 = new PanelSgaresmatmanView1();
        panelSgaresmatmanView1.setBindingContext(panelBinding.getBindingContext());
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.imprimir_label"),
                            SgaRecursos.getInstance().getString("Options.aceptar_label")};
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSgaresmatmanView1,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.llistaResman_label"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
        panelSgaresmatmanView1.releasePanelBinding();
        panelSgaresmatmanView1 = null;
        //Fem visible el registre seleccionat
        tableSgacdocSortidesView1.makeSelectedRowVisible();
        if (result == 0) //Imprimir llistat
        {
          AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
          String iddoc = currordre.getIddoc().toString();
          ResmanList.imprimirResmanList(this.getClass(), appModule, iddoc, true);
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

 


  /**
   * Mostra els bultos pel document
   * @param estat
   */
  private void veureBultos(int export)
  {
    try
    {
      SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      if (currordre != null)
      {
        // Fem un executeQuery abans de mostrar les reserves i tornem a deixar el 
        // cursor al mateix registre
        panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").executeQuery();
        panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").setCurrentRowWithKey(currordre.getKey().toStringFormat(true));
        // Fi del bloc executeQuery
        if (export == NOEXPORT)
        {
          MDPanelSgabultoView4SgalbultoView5 panelBultos = new MDPanelSgabultoView4SgalbultoView5();
          panelBultos.setBindingContext(panelBinding.getBindingContext());
          // Options
          String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
          int result = JOptionPane.showOptionDialog(
              Interflex.getInstance(),                                       // the parent that the dialog blocks
              panelBultos,                                    // the dialog message array
              SgaRecursos.getInstance().getString("Sortides.llistaBultos_label"), // the title of the dialog window
              JOptionPane.DEFAULT_OPTION,                 // option type
              JOptionPane.PLAIN_MESSAGE,            // message type
              null,                                       // optional icon, use null to use the default icon
              options,                                    // options string array, will be made into buttons
              null                                        // option that should be made into a default button
          );
          panelBultos.releasePanelBinding();
          panelBultos = null;
        }
        else
        {
          MDPanelSgabultoView5SgalbultoView5 panelBultos = new MDPanelSgabultoView5SgalbultoView5();
          panelBultos.setBindingContext(panelBinding.getBindingContext());
          // Options
          String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
          
          ApplicationModule am = panelBinding.getApplication().getApplicationModule();
          boolean isClearCache = am.getTransaction().isClearCacheOnCommit();
          if (isClearCache)
            am.getTransaction().setClearCacheOnCommit(false);          
          int result = JOptionPane.showOptionDialog(
              Interflex.getInstance(),                                       // the parent that the dialog blocks
              panelBultos,                                    // the dialog message array
              SgaRecursos.getInstance().getString("Sortides.llistaBultos_label"), // the title of the dialog window
              JOptionPane.DEFAULT_OPTION,                 // option type
              JOptionPane.PLAIN_MESSAGE,            // message type
              null,                                       // optional icon, use null to use the default icon
              options,                                    // options string array, will be made into buttons
              null                                        // option that should be made into a default button
          );
          panelBultos.releasePanelBinding();
          panelBultos = null;      
          
          am.getTransaction().setClearCacheOnCommit(isClearCache);

        }
        //Fem visible el registre seleccionat
        // tableSgacdocSortidesView1.makeSelectedRowVisible();
        panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").setCurrentRowWithKey(currordre.getKey().toStringFormat(true));
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  
  /**
   * Imprimieix el packing list actual del document
   * NOMES TEST ????
   * S'han posat java options a la linea d'execució de l'aplicació
   */
  private void imprimirPackingList(int tipo)
  {
    try
    {
      SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      if (currordre != null)
      {
        AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
        String iddoc = currordre.getIddoc().toString();
        PackingList.imprimirPackingList(this.getClass(), appModule, iddoc, true, tipo, currordre.getNalbaran().toString());
      }
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }
  

  
  /**
   * Actualitza l'estat dels botons en funció de l'ordre
   * Les condicions són que les linies del bulto no estiguin assignades a un
   * altre puesto i que no estiguin ni anul·lades ni finalitzades
   */
  private void updateButtons()
  {
  try 
  {
    buttonObrirOrdre.setEnabled(false);
    buttonTancarOrdre.setEnabled(false);
    buttonSuspendreOrdre.setEnabled(false);
    SgacdocSortidesViewRow currentRow = (SgacdocSortidesViewRow)panelBinding.findIterBinding("SgacdocSortidesView1Iter").getCurrentRow();  
    if (currentRow != null)
    {
      String lestado = currentRow.getEstadolineas();
      // Michael 29.01.2009 Añadido Orden bloqueado
      if (lestado.equals("D") || lestado.equals("S") || lestado.equals("B"))
      {
        buttonObrirOrdre.setEnabled(true);
      }
      if (lestado.equals("D") || lestado.equals("S") || lestado.equals("P") || lestado.equals("B"))
      {
        buttonTancarOrdre.setEnabled(true);
      }
      if (lestado.equals("P"))
      {
        buttonSuspendreOrdre.setEnabled(true);
      }
    }
   
  } catch (Exception ex) 
  {
    ex.printStackTrace();
  } finally 
  {
  }
  
   
    
  }
  

  public void quizasImprimirEtiquetes(String iddoc)
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      Etiqueta.imprimirEtiqueta(appModule, iddoc, null);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  private void quizasImprimirPackingList(String iddoc, String nalbaran)
  {
    try
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      PackingList.imprimirPackingList(this.getClass(), appModule, iddoc, false, PackingList.NACIONAL, nalbaran);
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
 
 
 	public class CustomTableCellRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
			Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
       int colIndex = tableSgacdocSortidesView1.getColumnIndex("Estado");
       int idExpedIndex = tableSgacdocSortidesView1.getColumnIndex("idExped");
       String estado = (String)table.getValueAt(row, colIndex);
       Object idExped = table.getValueAt(row, idExpedIndex);
			if (isSelected) {
				cell.setBackground(table.getSelectionBackground());
        if (estado.equals("B"))
         cell.setForeground(Color.LIGHT_GRAY);
        }
			else {
         cell.setForeground(defaultTableForeground);
         if (idExped != null)
         {
          // Si el document pertany a una expedició, marca en VERT
           cell.setBackground(Color.GREEN);
         }
         else
         {
         if (estado.equals("B")) 
         {
            cell.setBackground(Color.LIGHT_GRAY);
         }
         else
         {
					cell.setBackground(defaultTableBackground);
          }
         }
        }
			return cell;
		}
    
    
	}
  
  private void setFiltroPreparacion (String tipoPreparacion)
  {
    
    String whereClause = "tipdocsga = '" + tipoPreparacion + "'";
    navBar.setGrupatge(whereClause, true);
  }
  
  private class FiltroMagatzemComboChangeListener implements ItemListener{
    public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
          Object item = event.getItem();
          String whereClause = "";
          if (!item.equals("TOT"))
// TODO Jaume            
//           whereClause = "iddoc in (select iddoc from sgavscdocpendalm where idtipalm in ('" + (String)item + "','MAN'))";
             whereClause = "iddoc in (select iddoc from sgavscdocpendalm where idtipalm in ('" + (String)item + "'))";
   
          navBar.setMagatzem(whereClause, true);
        }
    }       
}

  private String getCombinedWhereClause (String strSgatipdoc, String strMagatzem)
  {
  String whereClause = "";
  if (strMagatzem.equals("TOT"))
    whereClause = navBar.getCurrentWhereClause();
  else
    whereClause = navBar.getCurrentWhereClause() + " and iddoc in (select iddoc from sgavscdocpendalm where idtipalm in ('" + strMagatzem + "','MAN'))";
  

  
  
  whereClause = whereClause + " and tipdocsga = '" + strSgatipdoc + "'";
  return (whereClause);
  
  }
  
  private void veureFormatEnviament () 
  {
 
    try
    {
      SgacdocViewRow currentRow = (SgacdocViewRow)panelBinding.findIterBinding("SgacdocSortidesView1Iter").getCurrentRow();  
      if (currentRow != null)
      {
        MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1 panelFormatos = new MDPanelSgavAgenciaTipoEnvio1SgavFormatosTipoEnvio1();
        panelFormatos.setBindingContext(panelBinding.getBindingContext());
        String sWhereClause = "iddoc = '" + currentRow.getIddoc() + "'";
        panelFormatos.setWhereClause(sWhereClause);
        
        String [] options;
        boolean hasTransportista = false;
  
        AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
        
        // Si el usuari no té drets per modificar el transportista, simplement li ensenyem els resultats..
        if (!appModule.isUserModTransportista())
        {
          options = new String [] { "Aceptar" };
        }
        else
        {
  
        // Options      
        if (currentRow.getTransp() == null || (currentRow.getTransp().intValue() == 0))
        {
          options = new String [] { "(+) Enviament Camió", "(+) Enviament Conteneidor",  "Aceptar" };
          hasTransportista = false;
        }
        
        else
        {
          options = new String [] { "(-) Tipus Enviament", "Aceptar"};
          hasTransportista = true;
        }
        }
        
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelFormatos,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.formatosDoc_label"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
        if (appModule.isUserModTransportista())
        {
        if (!hasTransportista)
          {
          switch (result)
          {
            case 1:
              // Enviament conteneidor
              currentRow.setTranspInt(9998);  // Ha d'existir en z_agenciatipoenvio
              break;
            case 0:
              // Enviament camío
               currentRow.setTranspInt(9999); // Ha d'existir en z_agenciatipoenvio
              break;
              
          }
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          navBar.getModel().getViewObject().executeQuery();

          
        }
        else
        {
          switch (result)
          {
            case 0:
              // Borrar transportista
              currentRow.setTranspInt(0);
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              navBar.getModel().getViewObject().executeQuery();
             break;
          }
        }
        }
        
        panelFormatos.releasePanelBinding();
        panelFormatos = null;
      }
      
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  private void insertarExpedicio () 
  {
 
    try
    {
      SgacdocViewRow currentRow = (SgacdocViewRow)panelBinding.findIterBinding("SgacdocSortidesView1Iter").getCurrentRow();  
      if (currentRow != null)
      {
        if (currentRow.getidExped() != null) 
        {
          JOptionPane.showMessageDialog(null, 
            "El document ja pertany a l'expedició: " 
            + currentRow.getidExped());
            
          return;
        }
        
        if (!currentRow.isOKExped()) 
        {
          JOptionPane.showMessageDialog(null, 
            "El estat del document no permet afegir-ho a una expedició");
          return;
          
        }

        
        if (panelExped == null)
        {
          panelExped = new PanelSgaexpedView3();
          panelExped.setBindingContext(panelBinding.getBindingContext());
        }
        

        String [] options;
  
        AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
        
        // Si el usuari no té drets per modificar el transportista, simplement li ensenyem els resultats..
        // TODO: Veure drets - aquests no son!!
        if (!appModule.isUserModTransportista())
        {
          options = new String [] { "Aceptar" };
        }
        else
        {
  
          options = new String [] { "Aceptar selecció", "(+) Expedició nova", "Cancel·lar"};
        }
        
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelExped,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.exposicio_titol"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
          String idExped = null;
          switch (result)
          {
            case 0: // Afegir
              idExped = panelExped.afegirDocExped(currentRow, false);
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              navBar.getModel().getViewObject().executeQuery();
              JOptionPane.showMessageDialog(null, "Afegit a expedició: " + idExped );
             break;
            case 1: // Crear i afegir
              idExped = panelExped.afegirDocExped(currentRow, true);
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              navBar.getModel().getViewObject().executeQuery();
              JOptionPane.showMessageDialog(null, "Creat i afegit a expedició: " + idExped );
              break;
            
          }
          
          
        
        
        // panelExped.releasePanelBinding();
        // panelExped = null;
      }
      }
      
    
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  public void showBultosErroneos()
  {
   AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
   SgavBultoCantErroneoRow row = appModule.getBultoCantErroneo(null);
   if (row != null)
    JOptionPane.showMessageDialog(null, "1er Bulto amb error: " + row.toString(), "Bultos erroneos", JOptionPane.WARNING_MESSAGE);
  else
    JOptionPane.showMessageDialog(null, "No hi ha bultos en error", "Bultos erroneos", JOptionPane.INFORMATION_MESSAGE);
    
  }
  
  }
  
  

  
