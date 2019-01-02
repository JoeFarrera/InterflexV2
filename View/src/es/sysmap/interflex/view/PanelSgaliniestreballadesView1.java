package es.sysmap.interflex.view;
import inetsoft.report.PreviewView;
import inetsoft.report.Previewer;
import inetsoft.report.ReportSheet;
import inetsoft.report.XSessionManager;
import inetsoft.report.io.Builder;
import inetsoft.uql.VariableTable;
import inetsoft.uql.schema.UserVariable;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import sgalib.JCalendarField;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgaliniestreballadesView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaliniestreballadesView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();
  private JPanel mainPanel = new JPanel();
  private BorderLayout mainLayout = new BorderLayout();
  private JPanel filtroPanel = new JPanel();
  private GridBagLayout filtroLayout = new GridBagLayout();
  private FlowLayout flowLayout1 = new FlowLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaliniestreballadesView1

  private SgaJTable tableSgaliniestreballadesView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();

  private JLabel labelFecini = new JLabel();
  private JCalendarField mFecini = new JCalendarField();

// Fields for attribute:  Fecha fin

  private JLabel labelFecfin = new JLabel();
  private JCalendarField mFecfin = new JCalendarField();

//  private JButton buttonImprimir = new JButton();
  private JButton jButtonSeleccionar = new JButton();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaliniestreballadesView1()
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
    dataPanel.setMinimumSize(new Dimension(700, 600));
    dataPanel.setPreferredSize(new Dimension(700, 600));
    dataPanel.setMaximumSize(new Dimension(700, 600));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 600));
    this.setPreferredSize(new Dimension(700, 600));
    this.setMinimumSize(new Dimension(700, 600));
    this.setMaximumSize(new Dimension(700, 600));
    mainPanel.setLayout(mainLayout);
    mainPanel.setBorder(BorderFactory.createTitledBorder(""));
    filtroPanel.setLayout(filtroLayout);
    filtroPanel.setMinimumSize(new Dimension(100, 100));

    // Code support form attribute: Fecha inicio
    filtroPanel.add(labelFecini, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    filtroPanel.add(mFecini, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelFecini.setLabelFor(mFecini);
    mFecini.setFieldColumns(15);
    mFecini.setToolTipText(SgaRecursos.getInstance().getString("FiltreDates.dataIni_tooltip"));
    mFecini.setDateFormat(new SimpleDateFormat("dd/MM/yyyy 00:00"));
    mFecini.setField("");        
    labelFecini.setText(SgaRecursos.getInstance().getString("FiltreDates.dataIni_label"));
    // Code support form attribute: Fecha fin
    filtroPanel.add(labelFecfin, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    filtroPanel.add(mFecfin, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelFecfin.setLabelFor(mFecfin);
    mFecfin.setFieldColumns(15);
    mFecfin.setToolTipText(SgaRecursos.getInstance().getString("FiltreDates.dataFi_tooltip"));
    mFecfin.setDateFormat(new SimpleDateFormat("dd/MM/yyyy 00:00"));
    mFecfin.setField("");        
    labelFecfin.setText(SgaRecursos.getInstance().getString("FiltreDates.dataFi_label"));

    jButtonSeleccionar.setText(SgaRecursos.getInstance().getString("FiltreDates.seleccionar_label"));
    jButtonSeleccionar.setToolTipText(SgaRecursos.getInstance().getString("FiltreDates.seleccionar_tooltip"));
    jButtonSeleccionar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonSeleccionar_actionPerformed(e);
        }
      });    
    filtroPanel.add(jButtonSeleccionar, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));    

    // Code support for view object:  SgaliniestreballadesView1
    tableSgaliniestreballadesView1.setModel((TableModel)panelBinding.bindUIControl("SgaliniestreballadesView1", tableSgaliniestreballadesView1));
    scroller.getViewport().add(tableSgaliniestreballadesView1, null);
    dataPanel.add(scroller);

/*    buttonImprimir.setIcon(SgaRecursos.createImageIcon(getClass(),"print.gif", null));
    buttonImprimir.setToolTipText(SgaRecursos.getInstance().getString("MovsUsuari.imprimir_tooltip"));
    buttonImprimir.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirLlistat();
        }
      });*/

    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaliniestreballadesView1", null, "SgaliniestreballadesView1Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);
//    navBar.add(buttonImprimir);
    dataPanel.add(scroller);

    add(filtroPanel, BorderLayout.NORTH);
    mainPanel.add(navBar, BorderLayout.NORTH);
    mainPanel.add(dataPanel, BorderLayout.CENTER);
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

    PanelSgaliniestreballadesView1 panel = new PanelSgaliniestreballadesView1();
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

  private void registerProjectGlobalVariables(BindingContext bindCtx)
  {
    JUUtil.registerNavigationBarInterface(getPanelBinding(), bindCtx);
  }
  
  public void setBindingContext(BindingContext bindCtx)
  {
    // Afegit xavi
    createPanelBinding(bindCtx);
    // Fi afegit xavi
    if (panelBinding.getPanel() == null)
    {
      panelBinding = panelBinding.setup(bindCtx, this);
      registerProjectGlobalVariables(bindCtx);
      //Truc per que no executi la consulta nomes entrar
      panelBinding.findIterBinding("SgaliniestreballadesView1Iter").getViewObject().setMaxFetchSize(0);
      panelBinding.refreshControl();
      try
      {
        jbInit();
        panelBinding.refreshControl();
        panelBinding.findIterBinding("SgaliniestreballadesView1Iter").getViewObject().setMaxFetchSize(-1);
        //navBar.enterQueryMode();
        // Forçem l'entrada a query mode
        
      }
      catch(Exception ex)
      {
        JUMetaObjectManager.reportException(null, ex);
      }
    }
  }

  private void jButtonSeleccionar_actionPerformed(ActionEvent e)
  {
    try
    {
      if (!mFecini.getField().trim().equals("") && !mFecfin.getField().trim().equals(""))
      {
        ViewObject vo = panelBinding.findIteratorBinding("SgaliniestreballadesView1Iter").getViewObject();
        vo.setWhereClauseParam(0, mFecini.getField().trim());
        vo.setWhereClauseParam(1, mFecfin.getField().trim());
        vo.executeQuery();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
/*  private void imprimirLlistat()
  {
    try
    {
      if (!mFecini.getField().trim().equals("") && !mFecfin.getField().trim().equals(""))
      {
        InputStream inputStream = this.getClass().getResourceAsStream("/es/sysmap/interflex/informes/MovsUsuariData.srt");
        //Builder builder = Builder.getBuilder(Builder.TEMPLATE,
        //  new FileInputStream(url.getPath()));
        Builder builder = Builder.getBuilder(Builder.TEMPLATE,
          inputStream);
        
        ReportSheet report = builder.read(".");
        VariableTable varTab = new VariableTable();
        varTab.put("ParamDataIni", mFecini.getField().trim());
        varTab.put("ParamDataFi", mFecfin.getField().trim());
        XSessionManager sessionManager = XSessionManager.getSessionManager();    
        //XSessionManager.getSessionManager().execute(report, varTab);
        UserVariable[] user = sessionManager.getQueryParameters(report, true);
        sessionManager.execute(report, varTab);
        PreviewView previewer = Previewer.createPreviewer();
        previewer.setTitle("Moviments d'Usuari");
        previewer.pack();    
        previewer.setVisible(true);
        previewer.setExitOnClose(false);   
        previewer.print(report);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }*/
}