package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgavubicacionInspeccionViewRow;
import es.sysmap.interflex.model.dmc.common.SgavubicacionViewRowImplMsgBundle;
import inetsoft.report.PreviewView;
import inetsoft.report.Previewer;
import inetsoft.report.ReportSheet;
import inetsoft.report.XSessionManager;
import inetsoft.report.io.Builder;
import java.awt.*;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgavubicacionInspeccionView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavubicacionInspeccionView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavubicacionView1

  private SgaJTable tableSgavubicacionView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  
  private JButton buttonInspeccionar = new JButton();
  private JButton buttonAlliberar = new JButton();
  
  private JButton buttonImprimir = new JButton();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavubicacionInspeccionView1()
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
    dataPanel.setMinimumSize(new Dimension(800, 250));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(800, 250));
    dataPanel.setMaximumSize(new Dimension(800, 250));
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(800, 37));
    buttonsPanel.setMinimumSize(new Dimension(800, 37));
    buttonsPanel.setMaximumSize(new Dimension(800, 37));
    buttonsPanel.setSize(new Dimension(800, 40));
    navBar.setPreferredSize(new Dimension(800, 29));
    navBar.setMinimumSize(new Dimension(800, 29));
    navBar.setMaximumSize(new Dimension(800, 29));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(800, 300));
    this.setPreferredSize(new Dimension(800, 300));
    this.setMinimumSize(new Dimension(800, 300));
    this.setMaximumSize(new Dimension(800, 300));
    // Code support for view object:  SgavubicacionView1
    tableSgavubicacionView1.setModel((TableModel)panelBinding.bindUIControl("SgavubicacionInspeccionView1", tableSgavubicacionView1));
    tableSgavubicacionView1.setEditable(false);
    scroller.getViewport().add(tableSgavubicacionView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavubicacionInspeccionView1", null, "SgavubicacionInspeccionView1Iter"));
    navBar.add(buttonImprimir);
    
    buttonsPanel.add(buttonInspeccionar);
    buttonsPanel.add(buttonAlliberar);

    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);

    buttonInspeccionar.setText(SgaRecursos.getInstance().getString("Ubicacions.inspeccionar_label"));
    buttonInspeccionar.setToolTipText(SgaRecursos.getInstance().getString("Ubicacions.inspeccionar_tooltip"));
    buttonInspeccionar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          inspeccionarUbicacio();
        }
      });
    buttonAlliberar.setText(SgaRecursos.getInstance().getString("Ubicacions.alliberar_label"));
    buttonAlliberar.setToolTipText(SgaRecursos.getInstance().getString("Ubicacions.alliberar_tooltip"));
    buttonAlliberar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          alliberarUbicacio();
        }
      });
   
   addPopup(); 

  buttonImprimir.setIcon(SgaRecursos.createImageIcon(getClass(),"print.gif", null));
  buttonImprimir.setToolTipText(SgaRecursos.getInstance().getString("Ubicacions.imprimir_tooltip"));
  buttonImprimir.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        imprimirLlistat();
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

    PanelSgavubicacionView1 panel = new PanelSgavubicacionView1();
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


  /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      
      tableSgavubicacionView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Ubicacions.inspeccionar_label"));
      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          inspeccionarUbicacio();
        }
      });      
      tableSgavubicacionView1.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Ubicacions.alliberar_label"));
      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          alliberarUbicacio();
        }
      });      
      tableSgavubicacionView1.addPopupMenuItem(menuItem);

  }


  private void inspeccionarUbicacio()
  {
    try
    {
      boolean bInspeccionada = false;
      SgavubicacionInspeccionViewRow currentRow = (SgavubicacionInspeccionViewRow)panelBinding.findIterBinding("SgavubicacionInspeccionView1Iter").getCurrentRow();  
      if (currentRow != null)
      {
        boolean isSilo = currentRow.getIdtipalm().equals("SLO");
        String desti = getDestiInspeccio(isSilo);
        String idtipmac = null;
        if (currentRow.getIdmac() == null)
          idtipmac = getTipmacInspeccio(isSilo);
        else
          idtipmac = currentRow.getIdtipmac();

        bInspeccionada = currentRow.inspeccionarUbicacio(desti, idtipmac);
        if (bInspeccionada)
        {
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          panelBinding.execute();
          JOptionPane.showMessageDialog(Interflex.getInstance(), 
              SgaRecursos.getInstance().getString("Ubicacions.OKInspeccio_label"));
        }
        else
        {
          panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
          JOptionPane.showMessageDialog(Interflex.getInstance(), 
              SgaRecursos.getInstance().getString("Ubicacions.errorInspeccio_label"));
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  private void alliberarUbicacio()
  {
    try
    {
      int action = 0;
      boolean bAlliberada = false;
      SgavubicacionInspeccionViewRow currentRow = (SgavubicacionInspeccionViewRow)panelBinding.findIterBinding("SgavubicacionInspeccionView1Iter").getCurrentRow();  
      if (currentRow != null)
      {
        if (currentRow.hasMacAmbExistencies())
        {
          // Options
          String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                              SgaRecursos.getInstance().getString("Options.cancelar_label") };
        
          action = JOptionPane.showOptionDialog(Interflex.getInstance().getFrame(), 
              SgaRecursos.getInstance().getString("Ubicacions.ubicacioOcupada_label") + currentRow.getIdmac(),              
              SgaRecursos.getInstance().getString("Ubicacions.alliberar_tooltip") , 
              JOptionPane.YES_NO_OPTION, 
              JOptionPane.QUESTION_MESSAGE, null, options, options[(1)]);
        }
        if (action == 0)
        {
          bAlliberada = currentRow.alliberarUbicacio();
          if (bAlliberada)
          {
            panelBinding.getApplication().getApplicationModule().getTransaction().commit();
            panelBinding.execute();
            JOptionPane.showMessageDialog(Interflex.getInstance(), 
                SgaRecursos.getInstance().getString("Ubicacions.OKAlliberada_label"));
          }
          else
          {
            panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
            JOptionPane.showMessageDialog(Interflex.getInstance(), 
                SgaRecursos.getInstance().getString("Ubicacions.errorAlliberada_label"));
          }
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  
  private String getDestiInspeccio(boolean silo)
  {
    String desti = null;
    int eleccion = 0;
    AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
    
    String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    
    // Si no es un puesto de manipulació, demanem les dades del desti
    if (!(puesto != null && appModule.esPuestoManipulacion(puesto)))
    {
      Object []      message = new Object[3];
      message [0] = SgaRecursos.getInstance().getString("Contenidors.triarDestiContenidor_label");
      message [1] = " ";  // Para que haya un hueco
      
      JComboBox cb = new JComboBox();
      if (!silo)
      {
        cb.addItem("PK1MLD"); 
        cb.addItem("PK2MLD");
      }
      else
      {
        cb.addItem("PK1SLO");
        cb.addItem("PK2SLO");
        cb.addItem("PKEXTR");
      }
  
      message [2] = cb;
      
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                          SgaRecursos.getInstance().getString("Options.cancelar_label") };

      eleccion = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            message,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Contenidors.triarDestiContenidor_label"),            // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.INFORMATION_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            options[0]                                  // option that should be made into a default button
            );
      if (eleccion == 0)
        // Ha aceptado algo
        desti = (String)cb.getSelectedItem();
    }
    else
      desti = appModule.getUbicacionPuesto(puesto, (silo ? "SLO" : "MLD"));
    return desti;
  }


  private String getTipmacInspeccio(boolean silo)
  {
    String idtipmac = null;
    int eleccion = 0;
    
    String puesto = SgaUtilPuesto.getInstance().getProperty("LlocTreball");
    
    // Si no es un puesto de manipulació, demanem les dades del desti
    if (silo)
    {
      Object []      message = new Object[3];
      message [0] = SgaRecursos.getInstance().getString("Contenidors.triarTipoContenidor_label");
      message [1] = " ";  // Para que haya un hueco
      
      JComboBox cb = new JComboBox();
      cb.addItem("EP");
      cb.addItem("EPC");
      cb.addItem("CON");
      cb.addItem("JLA");

      message [2] = cb;
      
      // Options
      String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                          SgaRecursos.getInstance().getString("Options.cancelar_label") };

      eleccion = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            message,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Contenidors.triarTipoContenidor_label"),            // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.INFORMATION_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            options[0]                                  // option that should be made into a default button
            );
      if (eleccion == 0)
        // Ha aceptado algo
        idtipmac = (String)cb.getSelectedItem();
    }
    else
      idtipmac = "CUB";
    return idtipmac;
  }



  private void imprimirLlistat()
  {
    try
    {
      InputStream inputStream = this.getClass().getResourceAsStream("/es/sysmap/interflex/informes/UbicInsp.srt");
      //Builder builder = Builder.getBuilder(Builder.TEMPLATE,
      //  new FileInputStream(url.getPath()));
      Builder builder = Builder.getBuilder(Builder.TEMPLATE,
        inputStream);
      
      ReportSheet report = builder.read(".");
/*      VariableTable varTab = new VariableTable();
      varTab.put("ParamDataIni", mFecini.getField().trim());
      varTab.put("ParamDataFi", mFecfin.getField().trim());*/
      XSessionManager sessionManager = XSessionManager.getSessionManager();    
      //XSessionManager.getSessionManager().execute(report, varTab);
//      UserVariable[] user = sessionManager.getQueryParameters(report, true);
      sessionManager.execute(report);
      PreviewView previewer = Previewer.createPreviewer();
      previewer.setTitle("Ubicacions en Inspecció");
      previewer.pack();    
      previewer.setVisible(true);
      previewer.setExitOnClose(false);   
      previewer.print(report);
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
}