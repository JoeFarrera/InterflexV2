package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaldocViewRow;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;
import oracle.adf.model.binding.*;

import oracle.jbo.Key;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

// public class PanelSgaldocView5 extends JUPanel
public class PanelSgaldocView5 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaldocView5UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaldocView4

  private SgaJTable tableSgaldocView4 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();

  private JButton buttonObrirLinia = new JButton();
  private JButton buttonTancarLinia = new JButton();
  private JButton buttonSuspendreLinia = new JButton();
  
  private JMenuItem menuItemFormatT;
  private JMenuItem menuItemFormatN;
   private JMenuItem menuItemFormatP;
  
  private String puesto = null;

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaldocView5()
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
    dataPanel.setMinimumSize(new Dimension(700, 263));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Sortides.llistaDetalls_label")));
    dataPanel.setPreferredSize(new Dimension(700, 263));
    dataPanel.setMaximumSize(new Dimension(700, 263));
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(700, 37));
    buttonsPanel.setMinimumSize(new Dimension(700, 37));
    buttonsPanel.setMaximumSize(new Dimension(700, 37));
    buttonsPanel.setSize(new Dimension(700, 40));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 300));
    this.setPreferredSize(new Dimension(700, 300));
    this.setMinimumSize(new Dimension(700, 300));
    this.setMaximumSize(new Dimension(700, 300));
    panelBinding.addRowSetListener(new JUPanelRowSetAdapter()
      {
        public void navigated(JUIteratorBinding iter, NavigationEvent event)
        {
          updateButtons();
          updatePopupMenuItems();
        }

        public void rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
        {
          updateButtons();
          updatePopupMenuItems();
        }
      });
    // Code support for view object:  SgaldocView4
    tableSgaldocView4.setModel((TableModel)panelBinding.bindUIControl("SgaldocView4", tableSgaldocView4));
    tableSgaldocView4.setEditable(false);
    
    scroller.getViewport().add(tableSgaldocView4, null);
    buttonObrirLinia.setIcon(SgaRecursos.createImageIcon(getClass(), "obrirbulto.gif", null));
    buttonObrirLinia.setToolTipText(SgaRecursos.getInstance().getString("Sortides.obrirLinia_label"));
    buttonObrirLinia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarLinia("P");
        }
      });
    buttonTancarLinia.setIcon(SgaRecursos.createImageIcon(getClass(), "tancarbulto.gif", null)); 
    buttonTancarLinia.setToolTipText(SgaRecursos.getInstance().getString("Sortides.tancarLinia_label"));
    buttonTancarLinia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarLinia("A");
        }
      });
    buttonSuspendreLinia.setIcon(SgaRecursos.createImageIcon(getClass(), "suspendrebulto.gif", null)); 
    buttonSuspendreLinia.setToolTipText(SgaRecursos.getInstance().getString("Sortides.suspendreLinia_label"));
    buttonSuspendreLinia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarLinia("S");
        }
      });
    // Bind the navigation bar
    dataPanel.add(scroller);

    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaldocView4", null, "SgaldocView4Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    navBar.setHasNavigationButtons(false);
    navBar.setHasFindButton(false);
    
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);
    buttonsPanel.add(buttonObrirLinia);
    buttonsPanel.add(buttonTancarLinia);
    buttonsPanel.add(buttonSuspendreLinia);
    
    // Afegim opcions al popup de la taula
    addPopup();
  }
  
  /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      boolean enabled = true;
      
      
      tableSgaldocView4.addPopupSeparator();
      
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.veureExistencies_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureExistencies();
        }
      });      
      tableSgaldocView4.addPopupMenuItem(menuItem);
      

 
      tableSgaldocView4.addPopupSeparator();
      menuItemFormatN = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.formatN"));
      menuItemFormatN.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/checks.png", null));
      menuItemFormatN.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          sinFormato("N");
        }
      });      

      tableSgaldocView4.addPopupMenuItem(menuItemFormatN);


      menuItemFormatP = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.formatP"));
      menuItemFormatP.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/checks.png", null));
      menuItemFormatP.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          sinFormato("P");
        }
      });      

      tableSgaldocView4.addPopupMenuItem(menuItemFormatP);

      menuItemFormatT = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.formatT"));
      menuItemFormatT.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/checks.png", null));
      menuItemFormatT.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          sinFormato("T");
        }
      });      

      tableSgaldocView4.addPopupMenuItem(menuItemFormatT);


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

    PanelSgaldocView5 panel = new PanelSgaldocView5();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }
  
  private void updatePopupMenuItems ()
  {
    boolean hasAccess = Interflex.getInstance().hasAcceso("MNUOPERACIONS");
    boolean okEstado = isEstatOKCambioFormato();
    
    menuItemFormatT.setEnabled(hasAccess && okEstado && !isFormatoActual("T"));
    menuItemFormatP.setEnabled(hasAccess && okEstado && !isFormatoActual("P"));
    menuItemFormatN.setEnabled(hasAccess && okEstado && !isFormatoActual("N"));
    
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
    updatePopupMenuItems();
  }


  /**
   * Actualitza el bulto segons l'estat que se li passa com a paràmetre
   * @param estat
   */
  private void actualitzarLinia(String estat)
  {
    try
    {
      // Busquem la clau del document d'entrada al que pertany el bulto per poder
      // tornar-hi un cop s'hagi fet el commit
      DCIteratorBinding iteratorBindingDoc = panelBinding.getBindingContext().findBindingContainer("PanelSgacdocSortidesView2UIModel").findIteratorBinding("SgacdocSortidesView1Iter");
      Key keyDoc = iteratorBindingDoc.getCurrentRow().getKey();
      
      SgaldocViewRow currldoc = (SgaldocViewRow)panelBinding.findIteratorBinding("SgaldocView4Iter").getCurrentRow();
      if (currldoc != null)
      {
        // 01.06.2012 Demanar confirmació per tancar una línia.
        String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };

        if (estat.equals("A"))
        {
                   int result2 = JOptionPane.showOptionDialog(
                  Interflex.getInstance(),                                       // the parent that the dialog blocks
                  SgaRecursos.getInstance().getString("SortidaReservada.tancarLinia") + " " + currldoc.getIdlin() + " ?",                                    // the dialog message array
                  "Confirmar", // the title of the dialog window
                  JOptionPane.DEFAULT_OPTION,                 // option type
                  JOptionPane.QUESTION_MESSAGE,            // message type
                  null,
                  options2,
                  null);
                  if (result2 == 1)
                    return;
        }
        
        // Activem els detalls del documents i gravem
        // TODO: Veure com desactivar el setClearCacheOnCommit desde el appModule
        // per evitar que se'n vagi al primer registre després de fer el commit
          if (puesto == null)
            puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
          currldoc.actualitzarLinia(estat, puesto);
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          //Mirem si hi ha etiquetes pendents d'imprimir
          quizasImprimirEtiquetes(currldoc.getIddoc().toString());
          //Mirem si cal imprimir el packingList
          quizasImprimirPackingList(currldoc.getIddoc().toString(), currldoc.getNalbaran());
          ///-------------Esta en test 
          iteratorBindingDoc.executeQuery();
          iteratorBindingDoc.setCurrentRowWithKey(keyDoc.toStringFormat(true));
          Key key = currldoc.getKey();
          panelBinding.findIteratorBinding("SgaldocView4Iter").executeQuery();
          panelBinding.findIteratorBinding("SgaldocView4Iter").setCurrentRowWithKey(key.toStringFormat(true));
          panelBinding.refreshControl();
          ///-------------FI Esta en test 
          updateButtons();
        //Fem visible el registre seleccionat
        tableSgaldocView4.makeSelectedRowVisible();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

 private boolean isEstatOKCambioFormato ()
 {
   boolean okCambioFormato = false;
   SgaldocViewRow currentRow = (SgaldocViewRow)panelBinding.findIterBinding("SgaldocView4Iter").getCurrentRow(); 
   
    if (currentRow != null)
    {
      // Si la capçalera esta disponible, activem els botons en funció de les linies
      String estadoCabecera = currentRow.getEstadoCabecera();
      if (!(estadoCabecera.equals("F") || estadoCabecera.equals("A") || estadoCabecera.equals("B")))
      okCambioFormato = true;
    }
    return (okCambioFormato);
      
 }

  /**
   * Actualitza l'estat dels botons en funció de l'ordre
   * Les condicions són que les linies del bulto no estiguin assignades a un
   * altre puesto i que no estiguin ni anul·lades ni finalitzades
   */
  private void updateButtons()
  {
    buttonObrirLinia.setEnabled(false);
    buttonTancarLinia.setEnabled(false);
    buttonSuspendreLinia.setEnabled(false);
    SgaldocViewRow currentRow = (SgaldocViewRow)panelBinding.findIterBinding("SgaldocView4Iter").getCurrentRow();  
    if (currentRow != null)
    {
      // Si la capçalera esta disponible, activem els botons en funció de les linies
      String estadoCabecera = currentRow.getEstadoCabecera();
      // Michael 02.02.2009 - Añadido estado cabecera == "B"
      if (!(estadoCabecera.equals("F") || estadoCabecera.equals("A") || estadoCabecera.equals("B")))
      {
        String lpuesto = currentRow.getIdpuesto();
        if (puesto == null)
          puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
        if (lpuesto == null || lpuesto.equals(puesto))
        {
          String lestado = currentRow.getEstado();
          if (lestado.equals("N") || lestado.equals("S"))
          {
            buttonObrirLinia.setEnabled(true);
          }
          if (lestado.equals("N") || lestado.equals("S") || lestado.equals("P"))
          {
            buttonTancarLinia.setEnabled(true);
          }
          if (lestado.equals("P"))
          {
            buttonSuspendreLinia.setEnabled(true);
          }
        }
      }
    }
  }

  private void quizasImprimirEtiquetes(String iddoc)
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
  
  private boolean isFormatoActual (String formato) 
  {
    SgaldocViewRow currentRow = (SgaldocViewRow)panelBinding.findIterBinding("SgaldocView4Iter").getCurrentRow();  
    if (currentRow != null)
    {
      String curFormato = currentRow.getSinformato();
      if (curFormato == null)
      {
        return false;
      }
      else 
      {
         if (curFormato.equals(formato))
          return true;
         else
          return false;
      }
    }
    return false;
  }

  
  private void sinFormato (String newFormat) 
  {
    try
    {
      SgaldocViewRow currentRow = (SgaldocViewRow)panelBinding.findIterBinding("SgaldocView4Iter").getCurrentRow();  
      if (currentRow != null)
      {
        // Busquem la clau del document d'entrada al que pertany el bulto per poder
        // tornar-hi un cop s'hagi fet el commit
        DCIteratorBinding iteratorBindingDoc = panelBinding.getBindingContext().findBindingContainer("PanelSgacdocSortidesView2UIModel").findIteratorBinding("SgacdocSortidesView1Iter");
        Key keyDoc = iteratorBindingDoc.getCurrentRow().getKey();

        String curFormato = currentRow.getSinformato();
        if (curFormato == null || !curFormato.equals(newFormat))
        {
          currentRow.setSinformato(newFormat);
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          iteratorBindingDoc.executeQuery();
          iteratorBindingDoc.setCurrentRowWithKey(keyDoc.toStringFormat(true));
          Key key = currentRow.getKey();
          panelBinding.findIteratorBinding("SgaldocView4Iter").executeQuery();

          panelBinding.findIteratorBinding("SgaldocView4Iter").setCurrentRowWithKey(key.toStringFormat(true));
          panelBinding.refreshControl();
          updateButtons();
          updatePopupMenuItems();
          //Fem visible el registre seleccionat
          tableSgaldocView4.makeSelectedRowVisible();
          

        }
        
        
      }
      
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  
  
  private void veureExistencies()
  {
    try
    {
      SgaldocViewRow currentRow = (SgaldocViewRow)panelBinding.findIterBinding("SgaldocView4Iter").getCurrentRow();  
      if (currentRow != null)
      {
        MDPanelSgavsumexistenciaView1SgavexistenciaView2 panelExistencies = new MDPanelSgavsumexistenciaView1SgavexistenciaView2();
        panelExistencies.setIddoc (currentRow.getIddoc(), currentRow.getIdlin(), currentRow.getIdcabnum());
        panelExistencies.setBindingContext(panelBinding.getBindingContext());
        String sWhereClause = "idart = '" + currentRow.getIdart() + "'";
        panelExistencies.setWhereClause(sWhereClause);
        // Michael ReservaManual 09.10.2014       
        
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelExistencies,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.llistaExistencies_label"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
        panelExistencies.releasePanelBinding();
        panelExistencies = null;
      }
      
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
}
