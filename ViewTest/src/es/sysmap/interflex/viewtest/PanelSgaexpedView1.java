package es.sysmap.interflex.viewtest;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaexpedViewRow;
import es.sysmap.interflex.view.PackingList;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import java.awt.Dimension;
import sgalib.SgaJTable;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

public class PanelSgaexpedView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaexpedView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaexpedView1

  private SgaJTable tableSgaexpedView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JButton buttonPackingList = new JButton();
  private JPanel buttonsPanel = new JPanel(new FlowLayout());



  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaexpedView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
  
  buttonPackingList.setText("Packing List [EXPEDICIÓ]");
    buttonPackingList.setToolTipText("Imprimir Packing List");
    buttonPackingList.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirPackingList();
        }
      });
      
      
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    dataPanel.setBorder(BorderFactory.createTitledBorder(" [Expedició] "));
    
    this.setLayout(borderLayout);
    this.setSize(new Dimension(448, 200));
    this.setMaximumSize(new Dimension(700, 200));
    this.setPreferredSize(new Dimension(448, 200));
    
    
    // Code support for view object:  SgaexpedView1
    tableSgaexpedView1.setModel((TableModel)panelBinding.bindUIControl("SgaexpedView1", tableSgaexpedView1));
    scroller.getViewport().add(tableSgaexpedView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaexpedView1", null, "SgaexpedView1Iter"));
    // Layout the datapanel and the navigation bar
    buttonsPanel.add(navBar);
    add(dataPanel, BorderLayout.CENTER);
    buttonsPanel.add(buttonPackingList);
    add(buttonsPanel, BorderLayout.SOUTH);
    
    addPopup();


  }
  
   /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
    
      
      tableSgaexpedView1.addPopupSeparator();
      
      
      menuItem = new JMenuItem("Packing List Expedició");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/printer.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirPackingList();
        }
      });      
      tableSgaexpedView1.addPopupMenuItem(menuItem);
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

    PanelSgaexpedView1 panel = new PanelSgaexpedView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl11", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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
  
  private SgaexpedViewRow getCurrentRow () 
  {
    SgaexpedViewRow row = (SgaexpedViewRow)panelBinding.findIteratorBinding("SgaexpedView1Iter").getCurrentRow();
    return row;
  }
  private void imprimirPackingList()    {
    try
    {
      // TODO Michael 21.01.2015 get properties provisionally
           Properties properties = System.getProperties();
      String value = SgaUtilPuesto.getInstance().getProperty("uql.home");
      if (value != null)
        properties.setProperty("uql.home", value);
      value = SgaUtilPuesto.getInstance().getProperty("query.registry.path");
      if (value != null)
        properties.setProperty("query.registry.path", value);
      value = SgaUtilPuesto.getInstance().getProperty("datasource.registry.path");
      if (value != null)
        properties.setProperty("datasource.registry.path", value);
 
      
        SgaexpedViewRow row = getCurrentRow();
        if (row != null)
        {
          AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
          String idexped = row.getIdexped().toString();
          PackingList.imprimirPackingListExped(this.getClass(), appModule, idexped, true);
        }
        
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }
  
  

  
}