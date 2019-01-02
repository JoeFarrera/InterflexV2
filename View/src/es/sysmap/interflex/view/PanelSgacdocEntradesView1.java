package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgacdocEntradesViewRow;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;

import oracle.jbo.Key;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;
import java.awt.BorderLayout;

// public class PanelSgacdocEntradesView1 extends JPanel implements JUPanel 
public class PanelSgacdocEntradesView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgacdocEntradesView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private CDocSgaJUNavigationBar navBar = new CDocSgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgacdocEntradesView1

  private SgaJTable tableSgacdocEntradesView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  
  private JButton buttonObrirOrdre = new JButton();
  private JButton buttonSuspendreOrdre = new JButton();
  private JButton buttonTancarOrdre = new JButton();
  private JButton buttonReserves = new JButton();

  private String puesto = null;

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgacdocEntradesView1()
  {
  }


 /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      // Michael 29.01.2009 Añadir posibilidad de bloquear/desbloquear la salida
      boolean enabled = Interflex.getInstance().hasAcceso("SGABLOQORD");
    
      
      tableSgacdocEntradesView1.addPopupSeparator();
      
      
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
      tableSgacdocEntradesView1.addPopupMenuItem(menuItem);
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
      tableSgacdocEntradesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);
    
     tableSgacdocEntradesView1.addPopupSeparator();
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
      tableSgacdocEntradesView1.addPopupMenuItem(menuItem);
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
      tableSgacdocEntradesView1.addPopupMenuItem(menuItem);
      menuItem.setEnabled(enabled);    
      
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
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Entrades.capçalera_label")));
    dataPanel.setPreferredSize(new Dimension(700, 221));
    dataPanel.setMaximumSize(new Dimension(700, 221));
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(700, 37));
    buttonsPanel.setMinimumSize(new Dimension(700, 37));
    buttonsPanel.setMaximumSize(new Dimension(700, 37));
    buttonsPanel.setSize(new Dimension(700, 40));
    this.setLayout(borderLayout);
//    this.setSize(new Dimension(700, 250));
//    this.setPreferredSize(new Dimension(700, 250));
//    this.setMinimumSize(new Dimension(700, 250));
//    this.setMaximumSize(new Dimension(700, 250));
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
    // Code support for view object:  SgacdocEntradesView1
    tableSgacdocEntradesView1.setModel((TableModel)panelBinding.bindUIControl("SgacdocEntradesView1", tableSgacdocEntradesView1));
    tableSgacdocEntradesView1.setEditable(false);
    scroller.setToolTipText("null");
    scroller.getViewport().add(tableSgacdocEntradesView1, null);

    buttonObrirOrdre.setText(SgaRecursos.getInstance().getString("Entrades.obrirOrdre_label"));
    buttonObrirOrdre.setToolTipText(SgaRecursos.getInstance().getString("Entrades.obrirOrdre_tooltip"));
    buttonObrirOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("P");
        }
      });
    buttonSuspendreOrdre.setText(SgaRecursos.getInstance().getString("Entrades.suspendreOrdre_label"));
    buttonSuspendreOrdre.setToolTipText(SgaRecursos.getInstance().getString("Entrades.suspendreOrdre_tooltip"));
    buttonSuspendreOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("S");
        }
      });
    buttonTancarOrdre.setText(SgaRecursos.getInstance().getString("Entrades.tancarOrdre_label"));
    buttonTancarOrdre.setToolTipText(SgaRecursos.getInstance().getString("Entrades.tancarOrdre_tooltip"));
    buttonTancarOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("A");
        }
      });
    buttonReserves.setText(SgaRecursos.getInstance().getString("Entrades.veureReserves_label"));
    buttonReserves.setToolTipText(SgaRecursos.getInstance().getString("Entrades.veureReserves_tooltip"));
    buttonReserves.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureReserves();
        }
      });


    
    // Layout the datapanel and the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgacdocEntradesView1", null, "SgacdocEntradesView1Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    navBar.afegirBotoFiltrarLegacy();
    navBar.filtrar();
    
    dataPanel.add(scroller);
    buttonsPanel.add(buttonObrirOrdre);
    buttonsPanel.add(buttonTancarOrdre);
    buttonsPanel.add(buttonSuspendreOrdre);
    buttonsPanel.add(buttonReserves);
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);
    
    addPopup();

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

    PanelSgacdocEntradesView1 panel = new PanelSgacdocEntradesView1();
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

  public void setBindingContext(BindingContext bindCtx)
  {
    super.setBindingContext(bindCtx);
    //Actualitzem l'estat dels botons
    updateButtons();
  }


  /**
   * Actualitza el bulto segons l'estat que se li passa com a paràmetre
   * @param estat
   */
  private void actualitzarOrdre(String estat)
  {
    try
    {
      SgacdocEntradesViewRow currordre = (SgacdocEntradesViewRow)panelBinding.findIteratorBinding("SgacdocEntradesView1Iter").getCurrentRow();
      if (currordre != null)
      {
        PanelSgaldocEntradesView3 panelSgaldocEntradesView3 = new PanelSgaldocEntradesView3(estat);
        panelSgaldocEntradesView3.setBindingContext(panelBinding.getBindingContext());
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                            SgaRecursos.getInstance().getString("Options.cancelar_label") };
  
        String title = null;
        switch(estat.charAt(0)                          )
        {
          case 'P':
            title = SgaRecursos.getInstance().getString("Entrades.obrirOrdre_label");
            break;
          case 'S':
            title = SgaRecursos.getInstance().getString("Entrades.suspendreOrdre_label");
            break;
          case 'A':
            title = SgaRecursos.getInstance().getString("Entrades.tancarOrdre_label");
            break;
        }
  
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSgaldocEntradesView3,                                    // the dialog message array
            title + ". " + SgaRecursos.getInstance().getString("Entrades.llistaDetalls_label"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
      switch(result) 
      {
         case 0: // Acceptar
            // Activem els detalls del bulto i gravem
            // TODO: Veure com desactivar el setClearCacheOnCommit desde el appModule
            // per evitar que se'n vagi al primer registre després de fer el commit
              if (puesto == null)
                puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
              currordre.actualitzarOrdre(estat, puesto);
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              ///-------------Esta en test 
              Key key = currordre.getKey();
              panelBinding.findIteratorBinding("SgacdocEntradesView1Iter").executeQuery();
              try
              {
                panelBinding.findIteratorBinding("SgacdocEntradesView1Iter").setCurrentRowWithKey(key.toStringFormat(true));
              }
              catch(Exception ex)
              {
                //Pot ser que en algun cas no trobi el registre per que ja s'ha enviat al host
              }
              ///-------------FI Esta en test 
              
              updateButtons();
           break;
         case 2: // cancelar
            panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
         default:
           break;
        }
        panelSgaldocEntradesView3.releasePanelBinding();
        panelSgaldocEntradesView3 = null;
        //Fem visible el registre seleccionat
        tableSgacdocEntradesView1.makeSelectedRowVisible();
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
   * TODO: Veure si deixem esborrar reserves des de aqui
   */
  private void veureReserves()
  {
    try
    {
      SgacdocEntradesViewRow currordre = (SgacdocEntradesViewRow)panelBinding.findIteratorBinding("SgacdocEntradesView1Iter").getCurrentRow();
      if (currordre != null)
      {
        // Fem un executeQuery abans de mostrar les reserves i tornem a deixar el 
        // cursor al mateix registre
        panelBinding.findIteratorBinding("SgacdocEntradesView1Iter").executeQuery();
        panelBinding.findIteratorBinding("SgacdocEntradesView1Iter").setCurrentRowWithKey(currordre.getKey().toStringFormat(true));
        // Fi del bloc executeQuery
        PanelSgaresmatView5 panelSgaresmatView5 = new PanelSgaresmatView5();
        panelSgaresmatView5.setBindingContext(panelBinding.getBindingContext());
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                            SgaRecursos.getInstance().getString("Options.cancelar_label") };
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSgaresmatView5,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Entrades.llistaReserves_label"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
        panelSgaresmatView5.releasePanelBinding();
        panelSgaresmatView5 = null;
        //Fem visible el registre seleccionat
        tableSgacdocEntradesView1.makeSelectedRowVisible();
      }
    }
    catch(Exception ex)
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
    buttonObrirOrdre.setEnabled(false);
    buttonTancarOrdre.setEnabled(false);
    buttonSuspendreOrdre.setEnabled(false);
    SgacdocEntradesViewRow currentRow = (SgacdocEntradesViewRow)panelBinding.findIterBinding("SgacdocEntradesView1Iter").getCurrentRow();  
    if (currentRow != null)
    {
      String lestado = currentRow.getEstadolineas();
      if (lestado.equals("D") || lestado.equals("S"))
      {
        buttonObrirOrdre.setEnabled(true);
      }
      if (lestado.equals("D") || lestado.equals("S") || lestado.equals("P"))
      {
        buttonTancarOrdre.setEnabled(true);
      }
      if (lestado.equals("P"))
      {
        buttonSuspendreOrdre.setEnabled(true);
      }
    }
  }
  
  
   /**
   * Actualitza la prioridad de la comanda
   * 03/11/2014 Michael
   * 
   */
   private void setPrioridad (int incremento) 
   {
     SgacdocEntradesViewRow currordre = (SgacdocEntradesViewRow)panelBinding.findIteratorBinding("SgacdocEntradesView1Iter").getCurrentRow();
     currordre.incrementarPrioridad(incremento);
     panelBinding.getApplication().getApplicationModule().getTransaction().commit();
     navBar.getModel().getViewObject().executeQuery();
     
   }
  
}