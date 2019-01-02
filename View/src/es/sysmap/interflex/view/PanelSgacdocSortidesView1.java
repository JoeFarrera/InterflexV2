package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgacdocSortidesView;
import es.sysmap.interflex.model.dmc.common.SgacdocSortidesViewRow;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;

import oracle.jbo.Key;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgacdocSortidesView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgacdocSortidesView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgacdocSortidesView1

  private SgaJTable tableSgacdocSortidesView1 = new SgaJTable();

  private JScrollPane scroller = new JScrollPane();

  private JButton buttonTancarOrdre = new JButton();

  private String puesto = null;
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgacdocSortidesView1()
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
    buttonsPanel.setMaximumSize(new Dimension(700, 37));
    buttonsPanel.setSize(new Dimension(700, 40));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 250));
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

    buttonTancarOrdre.setText(SgaRecursos.getInstance().getString("Sortides.tancarOrdre_label"));
    buttonTancarOrdre.setToolTipText(SgaRecursos.getInstance().getString("Sortides.tancarOrdre_tooltip"));
    buttonTancarOrdre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarOrdre("A");
        }
      });

    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgacdocSortidesView1", null, "SgacdocSortidesView1Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    navBar.setHasTransactionButtons(false);
    
    
    // Filtratge per tenir nomes els documents nous
    ViewObject vo = panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getViewObject();
    vo.setWhereClause("(sgacdoc.estado ='D' and (select decode (sgacdoc.estado, 'D', decode ((select sum(numlineas) from sgavcdocldoclbultoenproceso v where v.iddoc = sgacdoc.iddoc), 0, sgacdoc.estado, 'P'), sgacdoc.estado) estadoLineas from dual) = 'D')");
    vo.executeQuery();
    
    // Layout the datapanel and the navigation bar
    buttonsPanel.add(buttonTancarOrdre);
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);


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

    PanelSgacdocSortidesView1 panel = new PanelSgacdocSortidesView1();
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
      SgacdocSortidesViewRow currordre = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      
      if (currordre == null)
        return;
      
      SgacdocSortidesView vo = (SgacdocSortidesView)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getViewObject();
      vo.refreshQueryKeepingCurrentRow();
      SgacdocSortidesViewRow currordreRefreshed = (SgacdocSortidesViewRow)panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").getCurrentRow();
      
      if (currordreRefreshed != null && currordreRefreshed.getIddoc().equals(currordre.getIddoc()))
      {
        // Activem els detalls del bulto i gravem
        // TODO: Veure com desactivar el setClearCacheOnCommit desde el appModule
        // per evitar que se'n vagi al primer registre després de fer el commit
          if (puesto == null)
            puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");

          // Michael 21.07.2008 Si quiere anular la orden, pide confirmación 
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
          
          currordre.actualitzarOrdre(estat, puesto);
          // Activa l'enviament del document al host (Fa un commit implicit)
          AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
          appModule.setEnviarSortidaHost(currordre.getIddoc().toString());
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          ///-------------Esta en test 
          Key key = currordre.getKey();
          panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").executeQuery();
          try
          {
            panelBinding.findIteratorBinding("SgacdocSortidesView1Iter").setCurrentRowWithKey(key.toStringFormat(true));
          }
          catch(Exception ex)
          {
            //Pot ser que en algun cas no trobi el registre per que ja s'ha enviat al host
          }
          ///-------------FI Esta en test 
          
          updateButtons();
        //Fem visible el registre seleccionat
        tableSgacdocSortidesView1.makeSelectedRowVisible();
      }
      else 
      {
        JOptionPane.showConfirmDialog (Interflex.getInstance(), "L'ordre no s'ha seleccionat o ja no està disponible com ordre nova", "Ordre no disponible", JOptionPane.WARNING_MESSAGE);
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
    buttonTancarOrdre.setEnabled(false);
    SgacdocSortidesViewRow currentRow = (SgacdocSortidesViewRow)panelBinding.findIterBinding("SgacdocSortidesView1Iter").getCurrentRow();  
    if (currentRow != null)
    {
      String lestado = currentRow.getEstadolineas();
      if (lestado.equals("D") || lestado.equals("S") || lestado.equals("P"))
      {
        buttonTancarOrdre.setEnabled(true);
      }
    }
    
    
  }
  

  
}