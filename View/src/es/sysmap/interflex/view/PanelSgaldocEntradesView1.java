package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgabultoViewRow;
import es.sysmap.interflex.model.dmc.common.SgaldocEntradesViewRow;
import es.sysmap.interflex.model.dmc.common.SgaldocViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import java.awt.Dimension;
import sgalib.SgaUtilPuesto;

// public class PanelSgaldocEntradesView1 extends JPanel implements JUPanel
public class PanelSgaldocEntradesView1 extends SgaJUPanel
{

  private JMenuItem mObrir;
  private JMenuItem mSuspendre;
  private JMenuItem mTancar;
  /**
   * puesto de trabajo
   */
  private String puesto;
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaldocEntradesView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();
// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaldocEntradesView1

  private SgaJTable tableSgaldocEntradesView1 = new SgaJTable()
  {
    // Xavi, 14/07/2005: Afegit per poder canviar la quantitat pendent del bulto directament a la linia
    public boolean isCellEditable(int row, int column)    
    {
      boolean isEditable = false;
      // Nomes deixem modificar certes columnes
      if (getColumnName(column).equals(panelBinding.getLabel("SgaldocEntradesView1", "Canpenbulto", null)) ||
          getColumnName(column).equals(panelBinding.getLabel("SgaldocEntradesView1", "Canresbulto", null)))
        isEditable = true;
      else
        isEditable = panelBinding.isFindMode();  
      return isEditable;
    }
  };
  
  private JScrollPane scroller = new JScrollPane();
  
  private String getPuesto()
  {
    if (puesto == null)
      puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    return puesto;

  }
  
  /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      
      tableSgaldocEntradesView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.veureExistencies_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureExistencies();
        }
      });      
      tableSgaldocEntradesView1.addPopupMenuItem(menuItem);

      mObrir = new JMenuItem(SgaRecursos.getInstance().getString("Entrades.obrirDetallBulto_label"));
      mObrir.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cube_green_add.png", null));
      mObrir.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          if (isOKObrir(true))
            actualitzarBulto("P");
        }
      });      
      tableSgaldocEntradesView1.addPopupMenuItem(mObrir);

      mSuspendre = new JMenuItem(SgaRecursos.getInstance().getString("Entrades.suspendreDetallBulto_label"));
      mSuspendre.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cube_green_new.png", null));
      mSuspendre.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          if (isOKSuspendre(true))
            actualitzarBulto("S");
        }
      });      
      tableSgaldocEntradesView1.addPopupMenuItem(mSuspendre);

      mTancar = new JMenuItem(SgaRecursos.getInstance().getString("Entrades.tancarDetallBulto_label"));
      mTancar.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cube_green_delete.png", null));
      mTancar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          if (isOKTancar(true))
            actualitzarBulto("A");  // TODO This should be actualizar linea bulto...
        }
      });      
      tableSgaldocEntradesView1.addPopupMenuItem(mTancar);



  }
  
  private void updatePopupOptions()
  {
      mObrir.setEnabled(isOKObrir(false));
      mTancar.setEnabled(isOKTancar(false));
      mSuspendre.setEnabled(isOKSuspendre(false));
    
  }


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaldocEntradesView1()
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
    dataPanel.setMinimumSize(new Dimension(450, 300));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Entrades.detallOrdres_label")));
    dataPanel.setPreferredSize(new Dimension(450, 300));
    dataPanel.setMaximumSize(new Dimension(450, 300));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(450, 300));
    this.setPreferredSize(new Dimension(450, 300));
    this.setMinimumSize(new Dimension(450, 300));
    this.setMaximumSize(new Dimension(450, 300));
    // Code support for view object:  SgaldocEntradesView1
    tableSgaldocEntradesView1.setModel((TableModel)panelBinding.bindUIControl("SgaldocEntradesView1", tableSgaldocEntradesView1));
    //tableSgaldocEntradesView1.setEditable(false);
    scroller.getViewport().add(tableSgaldocEntradesView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);

    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaldocEntradesView1", null, "SgaldocEntradesView1Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    //navBar.setHasTransactionButtons(false);
    navBar.setHasInsertButton(false);
    navBar.setHasDeleteButton(false);
    navBar.setHasNavigationButtons(false);
    navBar.setHasFindButton(false);
    
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    
    addPopup();
    panelBinding.addRowSetListener(new JUPanelRowSetAdapter()
      {
        public void navigated(JUIteratorBinding iter, NavigationEvent event)
        {
          updatePopupOptions();
        }

        public void rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
        {
          updatePopupOptions();
        }
      });


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

    PanelSgaldocEntradesView1 panel = new PanelSgaldocEntradesView1();
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
  
  private SgaldocEntradesViewRow getCurrentRow()
  {
    return (SgaldocEntradesViewRow)panelBinding.findIterBinding("SgaldocEntradesView1Iter").getCurrentRow();  
  }
  
  private boolean isOKObrir(boolean showMessage)
  {
     SgaldocEntradesViewRow currentRow = getCurrentRow();
      if (currentRow != null)
        if (currentRow.isOKObrir(getPuesto()))
          return true;
     if (showMessage)
       JOptionPane.showMessageDialog(Interflex.getInstance(),
            SgaRecursos.getInstance().getString("Entrades.obrirDetallBulto_noespot"),
            SgaRecursos.getInstance().getString("Sortides.obrirLinia_label"),
            JOptionPane.WARNING_MESSAGE);            // message type
    return false;
  }
 
  private boolean isOKSuspendre(boolean showMessage)
  {
     SgaldocEntradesViewRow currentRow = getCurrentRow();
      if (currentRow != null)
        if (currentRow.isOKSuspender(getPuesto()))
          return true;
     if (showMessage)
       JOptionPane.showMessageDialog(Interflex.getInstance(),
            SgaRecursos.getInstance().getString("Entrades.suspendreDetallBulto_noespot"),
            SgaRecursos.getInstance().getString("Sortides.suspendreDetallBulto_label"),
            JOptionPane.WARNING_MESSAGE);            // message type
    return false;
    
  }

  private boolean isOKTancar(boolean showMessage)
  {
     SgaldocEntradesViewRow currentRow = getCurrentRow();
      if (currentRow != null)
        if (currentRow.isOKAnular(getPuesto()))
          return true;
          
     if (showMessage)
      JOptionPane.showMessageDialog(Interflex.getInstance(),
            SgaRecursos.getInstance().getString("Entrades.tancarDetallBulto_noespot"),
            SgaRecursos.getInstance().getString("Sortides.tancarDetallBulto_label"),
            JOptionPane.WARNING_MESSAGE);            // message type
            
    return false;
    
  }
  

  
  /**
   * @deprecated 12.01.2007
   */
  private void obrirLiniaBulto()
  {
    try
    {
      SgaldocEntradesViewRow currentRow = getCurrentRow();
      if (currentRow != null)
      {
        if (currentRow.isOKObrir(getPuesto()))
        {
        int result = JOptionPane.showConfirmDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            SgaRecursos.getInstance().getString("Entrades.obrirDetallBulto_tooltip") + currentRow.getIdartif(),                                    // the dialog message array
            SgaRecursos.getInstance().getString("Sortides.obrirLinia_label"), // the title of the dialog window
            JOptionPane.YES_NO_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE            // message type
        );
          if (result == 0)
            {
              currentRow.obrirLiniaBulto(getPuesto());
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
            }
        }
        else
          JOptionPane.showConfirmDialog(Interflex.getInstance(),
            SgaRecursos.getInstance().getString("Entrades.obrirDetallBulto_noespot"),
            SgaRecursos.getInstance().getString("Sortides.obrirLinia_label"),
            JOptionPane.OK_OPTION,                 // option type
            JOptionPane.WARNING_MESSAGE            // message type
        );
          
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }
  
  
  
  
    /**
   * Actualitza el bulto segons l'estat que se li passa com a paràmetre
   * @param estat
   */
  private void actualitzarBulto(String estat)
  {
    try
    {
      SgaldocEntradesViewRow currentRow = getCurrentRow();
      if (currentRow != null)
      {
        // Busquem la clau del document d'entrada al que pertany el bulto per poder
        // tornar-hi un cop s'hagi fet el commit
        DCIteratorBinding iteratorBindingDoc = panelBinding.getBindingContext().findBindingContainer("PanelSgacdocEntradesView1UIModel").findIteratorBinding("SgacdocEntradesView1Iter");
        Key keyDoc = iteratorBindingDoc.getCurrentRow().getKey();
      
        PanelSgaldocEntradesView2 panelSgaldocEntradesView2 = new PanelSgaldocEntradesView2(estat);
        panelSgaldocEntradesView2.setBindingContext(panelBinding.getBindingContext());
        panelSgaldocEntradesView2.setWhereClause("idlin = " + getCurrentRow().getIdlin());
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
            switch(estat.charAt(0)                          )
            {
              case 'P':
                  currentRow.obrirLiniaBulto(getPuesto());
                break;
              case 'S':
                  currentRow.suspenderLiniaBulto();
                break;
              case 'A':
                currentRow.tancarLiniaBulto();
                break;
            }
              // Realizar el commit sin el clear cache
              ApplicationModule am = panelBinding.getApplication().getApplicationModule();
              boolean isClearCache = am.getTransaction().isClearCacheOnCommit();
              if (isClearCache)
                am.getTransaction().setClearCacheOnCommit(false);
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              am.getTransaction().setClearCacheOnCommit(isClearCache);
           break;
         case 2: // cancelar
            panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
         default:
           break;
        }

        panelSgaldocEntradesView2.setWhereClause(null);
        
        panelSgaldocEntradesView2.releasePanelBinding();
        panelSgaldocEntradesView2 = null;

      } // Current row
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
      SgaldocEntradesViewRow currentRow = getCurrentRow();
      if (currentRow != null)
      {
        MDPanelSgavsumexistenciaView1SgavexistenciaView2 panelExistencies = new MDPanelSgavsumexistenciaView1SgavexistenciaView2();
        panelExistencies.setBindingContext(panelBinding.getBindingContext());
        String sWhereClause = "idart = '" + currentRow.getIdart() + "'";
        panelExistencies.setWhereClause(sWhereClause);
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