package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgabultoViewRow;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;
import oracle.adf.model.binding.*;

import oracle.jbo.Key;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

// public class PanelSgabultoView1 extends JPanel implements JUPanel
public class PanelSgabultoView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgabultoView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgabultoView1

  private SgaJTable tableSgabultoView1 = new SgaJTable();
  // No deixem actualitzar el bulto fent doble click
/*  {
    public Component prepareEditor(TableCellEditor editor, int row, int column) 
    {
      PanelSgabultoView1.this.actualitzarBulto("P");
      return super.prepareEditor(editor, row, column);
    }
    
  };*/
  private JScrollPane scroller = new JScrollPane();
  
  private JButton buttonObrirBulto = new JButton();
  private JButton buttonTancarBulto = new JButton();
  private JButton buttonSuspendreBulto = new JButton();
  
  private String puesto = null;


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgabultoView1()
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
    dataPanel.setMinimumSize(new Dimension(200, 263));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Entrades.bultos_label")));
    dataPanel.setPreferredSize(new Dimension(200, 263));
    dataPanel.setMaximumSize(new Dimension(200, 263));
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(200, 37));
    buttonsPanel.setMinimumSize(new Dimension(200, 37));
    buttonsPanel.setMaximumSize(new Dimension(200, 37));
    buttonsPanel.setSize(new Dimension(175, 40));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(200, 300));
    this.setPreferredSize(new Dimension(200, 300));
    this.setMinimumSize(new Dimension(200, 300));
    this.setMaximumSize(new Dimension(200, 300));

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
//    // Code support for view object:  SgabultoView2
    tableSgabultoView1.setModel((TableModel)panelBinding.bindUIControl("SgabultoView2", tableSgabultoView1));
    tableSgabultoView1.setEditable(false);
    buttonObrirBulto.setIcon(SgaRecursos.createImageIcon(getClass(), "obrirbulto.gif", null));
    buttonObrirBulto.setToolTipText(SgaRecursos.getInstance().getString("Entrades.obrirBulto_label"));
    buttonObrirBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarBulto("P");
        }
      });
    buttonTancarBulto.setIcon(SgaRecursos.createImageIcon(getClass(), "tancarbulto.gif", null)); 
    buttonTancarBulto.setToolTipText(SgaRecursos.getInstance().getString("Entrades.tancarBulto_label"));
    buttonTancarBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarBulto("A");
        }
      });
    buttonSuspendreBulto.setIcon(SgaRecursos.createImageIcon(getClass(), "suspendrebulto.gif", null)); 
    buttonSuspendreBulto.setToolTipText(SgaRecursos.getInstance().getString("Entrades.suspendreBulto_label"));
    buttonSuspendreBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          actualitzarBulto("S");
        }
      });
    scroller.getViewport().add(tableSgabultoView1, null);
    // Bind the navigation bar
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);

    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgabultoView2", null, "SgabultoView2Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    navBar.setHasNavigationButtons(false);
    navBar.setHasFindButton(false);
    
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);
    buttonsPanel.add(buttonObrirBulto);
    buttonsPanel.add(buttonTancarBulto);
    buttonsPanel.add(buttonSuspendreBulto);
    


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

    PanelSgabultoView1 panel = new PanelSgabultoView1();
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
    //TODO updateButtons();
  }


  /**
   * Actualitza el bulto segons l'estat que se li passa com a paràmetre
   * @param estat
   */
  private void actualitzarBulto(String estat)
  {
    try
    {
      // Busquem la clau del document d'entrada al que pertany el bulto per poder
      // tornar-hi un cop s'hagi fet el commit
      DCIteratorBinding iteratorBindingDoc = panelBinding.getBindingContext().findBindingContainer("PanelSgacdocEntradesView1UIModel").findIteratorBinding("SgacdocEntradesView1Iter");
      Key keyDoc = iteratorBindingDoc.getCurrentRow().getKey();
      
      SgabultoViewRow currbulto = (SgabultoViewRow)panelBinding.findIteratorBinding("SgabultoView2Iter").getCurrentRow();
      if (currbulto != null)
      {
        PanelSgaldocEntradesView2 panelSgaldocEntradesView2 = new PanelSgaldocEntradesView2(estat);
        panelSgaldocEntradesView2.setBindingContext(panelBinding.getBindingContext());
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
            panelSgaldocEntradesView2,                                    // the dialog message array
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
              currbulto.actualitzarBulto(estat, puesto);
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              ///-------------Esta en test 
              iteratorBindingDoc.executeQuery();
              iteratorBindingDoc.setCurrentRowWithKey(keyDoc.toStringFormat(true));
              Key key = currbulto.getKey();
              panelBinding.findIteratorBinding("SgabultoView2Iter").executeQuery();
              panelBinding.findIteratorBinding("SgabultoView2Iter").setCurrentRowWithKey(key.toStringFormat(true));
              panelBinding.refreshControl();
              ///-------------FI Esta en test 
              updateButtons();
           break;
         case 2: // cancelar
            panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
         default:
           break;
        }
        panelSgaldocEntradesView2.releasePanelBinding();
        panelSgaldocEntradesView2 = null;

        //Fem visible el registre seleccionat
        tableSgabultoView1.makeSelectedRowVisible();
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
    buttonObrirBulto.setEnabled(false);
    buttonTancarBulto.setEnabled(false);
    buttonSuspendreBulto.setEnabled(false);
    SgabultoViewRow currentRow = (SgabultoViewRow)panelBinding.findIterBinding("SgabultoView2Iter").getCurrentRow();  
    if (currentRow != null)
    {
      // Si la capçalera esta disponible, activem els botons en funció de les linies
      String estadoCabecera = currentRow.getEstadoCabecera();
      if (!(estadoCabecera.equals("F") || estadoCabecera.equals("A")))
      {
        String lpuesto = currentRow.getIdpuesto();
        if (puesto == null)
          puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
        if (lpuesto == null || lpuesto.equals(puesto))
        {
          String lestado = currentRow.getEstado();
          if (lestado.equals("N") || lestado.equals("S"))
          {
            buttonObrirBulto.setEnabled(true);
          }
          if (lestado.equals("N") || lestado.equals("S") || lestado.equals("P"))
          {
            buttonTancarBulto.setEnabled(true);
          }
          if (lestado.equals("P"))
          {
            buttonSuspendreBulto.setEnabled(true);
          }
        }
      }
    }
  }
  
}