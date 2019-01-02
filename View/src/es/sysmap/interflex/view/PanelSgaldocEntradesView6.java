package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgaldocEntradesViewRow;
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
import sgalib.SgaJUPanel;
import oracle.jbo.uicli.controls.JUNavigationBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;


// public class PanelSgaldocEntradesView6 extends JPanel implements JUPanel
public class PanelSgaldocEntradesView6  extends SgaJUPanel
{

  private String puesto;

  private JMenuItem mObrir;
  private JMenuItem mSuspendre;
  private JMenuItem mTancar;

  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaldocEntradesView6UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaldocEntradesView2

  private SgaJTable tableSgaldocEntradesView2 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaldocEntradesView6()
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
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    // Code support for view object:  SgaldocEntradesView2
    tableSgaldocEntradesView2.setModel((TableModel)panelBinding.bindUIControl("SgaldocEntradesView2", tableSgaldocEntradesView2));
    scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    jUNavigationBar1.setHasDeleteButton(false);
    jUNavigationBar1.setHasInsertButton(false);
    jUNavigationBar1.setHasTransactionButtons(false);
    scroller.getViewport().add(tableSgaldocEntradesView2, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.CENTER);
    this.add(jUNavigationBar1, BorderLayout.NORTH);
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgaldocEntradesView2", null, "SgaldocEntradesView2Iterator"));
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
  
    private void updatePopupOptions()
  {
      mObrir.setEnabled(isOKObrir(false));
      mTancar.setEnabled(isOKTancar(false));
      mSuspendre.setEnabled(isOKSuspendre(false));
    
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

    PanelSgaldocEntradesView6 panel = new PanelSgaldocEntradesView6();
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

  private void unRegisterProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.unRegisterNavigationBarInterface(panelBinding, bindCtx);
  }

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(panelBinding, bindCtx);
  }

  public void setBindingContext(BindingContext bindCtx)
  {
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }
  
  
  // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }
  
  
   /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      
      tableSgaldocEntradesView2.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.veureExistencies_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureExistencies();
        }
      });      
      tableSgaldocEntradesView2.addPopupMenuItem(menuItem);

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
      tableSgaldocEntradesView2.addPopupMenuItem(mObrir);

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
      tableSgaldocEntradesView2.addPopupMenuItem(mSuspendre);

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
      tableSgaldocEntradesView2.addPopupMenuItem(mTancar);



  }
  
    private SgaldocEntradesViewRow getCurrentRow()
  {
    return (SgaldocEntradesViewRow)panelBinding.findIterBinding("SgaldocEntradesView2Iter").getCurrentRow();  
  }
  
    
  private String getPuesto()
  {
    if (puesto == null)
      puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    return puesto;

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
    //    DCIteratorBinding iteratorBindingDoc = panelBinding.getBindingContext().findBindingContainer("PanelSgacdocEntradesView1UIModel").findIteratorBinding("SgacdocEntradesView1Iter");
    //    Key keyDoc = iteratorBindingDoc.getCurrentRow().getKey();
      
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
  
        title = title + "." + SgaRecursos.getInstance().getString("Entrades.llistaDetalls_label");
        
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSgaldocEntradesView2,                                    // the dialog message array
            title, // the title of the dialog window
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
  
}