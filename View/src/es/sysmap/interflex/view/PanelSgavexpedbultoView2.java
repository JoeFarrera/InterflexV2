package es.sysmap.interflex.view;
import es.sysmap.interflex.etiquetes.EtiquetaPicking;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaexpedbultoViewRow;
import es.sysmap.interflex.model.dmc.common.SgavexpedbultoViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import oracle.jbo.domain.Number;

import sgalib.SgaJComboEditor;
import sgalib.SgaJComboRenderer;
import sgalib.SgaJSelector;
import sgalib.SgaJTable;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JButton;
import javax.swing.ButtonModel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class PanelSgavexpedbultoView2 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexpedbultoView2UIModel");
  
  private JComboBox mTipoBulto = new JComboBox();


// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();



  
  private JScrollPane scroller = new JScrollPane();
  private JPanel buttonsPanel = new JPanel(new GridLayout(2, 2));
  
   private JButton buttonRepartirBulto = new JButton();
  private JButton buttonReagraparLinia = new JButton();
  private JButton buttonReagruparBultos = new JButton();
  private JButton buttonImprimirEtiqueta = new JButton();
  private SgaJTable tableSgavexpedbultoView2 = new SgaJTable()
    {
    public void tableChanged(TableModelEvent e)    
    {
      super.tableChanged(e);

      try
      {
      //Modifiquem els renderers dels combobox i checkboxs
      setCellEditor(panelBinding.getLabel("SgavexpedbultoView1", "Idtipobulto", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgatipobultoView1", "Idtip", "Idtip", mTipoBulto));
      setCellRenderer(panelBinding.getLabel("SgavexpedbultoView1", "Idtipobulto", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgatipobultoView1", "Idtip", "Idtip"));
  

      }
      catch(Exception ex){}
    }
  };
  


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexpedbultoView2()
  {
  }
  
  
    /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
    
      
      tableSgavexpedbultoView2.addPopupSeparator();
      
      
      menuItem = new JMenuItem("Repartir Embalum");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cube_green_new.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          repartirBulto();
        }
      });      
      tableSgavexpedbultoView2.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem("Reagrupar Embalums");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cubes_green.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          reagruparBultos();
        }
      });    
      
      tableSgavexpedbultoView2.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem("Dividir línia Embalum");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/cube_green_add.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          dividirLinia();
        }
      });     
      
      menuItem = new JMenuItem("Etiqueta embalam");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/printer.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirEtiqueta();
        }
      }); 
      
      
      tableSgavexpedbultoView2.addPopupMenuItem(menuItem);
  }
  

  private void initButtons() 
  {
    buttonReagraparLinia.setText("Dividar línia");
    buttonReagraparLinia.setToolTipText(SgaRecursos.getInstance().getString("Sortides.reagruparLinia_tooltip"));
    buttonReagraparLinia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          dividirLinia();  
        }
      });


    buttonRepartirBulto.setText("Repartir");
    buttonRepartirBulto.setToolTipText(SgaRecursos.getInstance().getString("Sortides.repartirBulto_tooltip"));
    buttonRepartirBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          repartirBulto();
        }
      });
    buttonReagruparBultos.setText("Reagrupar");
    buttonReagruparBultos.setToolTipText(SgaRecursos.getInstance().getString("Sortides.reagruparBultos_tooltip"));
    buttonReagruparBultos.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          reagruparBultos();
        }
      });

    buttonImprimirEtiqueta.setText(SgaRecursos.getInstance().getString("Sortides.imprimirEtiquetaBulto_label"));
    buttonImprimirEtiqueta.setToolTipText(SgaRecursos.getInstance().getString("Sortides.imprimirEtiquetaBulto_tooltip"));
    buttonImprimirEtiqueta.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          imprimirEtiqueta();
        }
      });

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
    dataPanel.setBorder(BorderFactory.createTitledBorder(" [Embalum] "));
    this.setLayout(borderLayout);
    // Code support for view object:  SgavexpedbultoView2
    // Bind the navigation bar
    scroller.getViewport().add(tableSgavexpedbultoView2, null);
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavexpedbultoView1", null, "SgavexpedbultoView1Iterator"));
    // Layout the datapanel and the navigation bar
    // add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);
    initButtons();
    
    JPanel firstButtons = new JPanel (new FlowLayout());
    firstButtons.add(navBar);
    firstButtons.add(buttonRepartirBulto);
    buttonsPanel.add(firstButtons);
    
    JPanel moreButtons2 = new JPanel(new FlowLayout());
 
    
    moreButtons2.add(buttonImprimirEtiqueta);
    moreButtons2.add(buttonReagraparLinia);
    moreButtons2.add(buttonReagruparBultos);
   
    buttonsPanel.add(moreButtons2);
    add(buttonsPanel, BorderLayout.SOUTH);
    
    
    addPopup();
    tableSgavexpedbultoView2.setModel((TableModel)panelBinding.bindUIControl("SgavexpedbultoView1", tableSgavexpedbultoView2));
    mTipoBulto.setModel((ComboBoxModel)panelBinding.bindUIControl("DCComboBox", mTipoBulto));
    
    tableSgavexpedbultoView2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
 
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

    PanelSgavexpedbultoView2 panel = new PanelSgavexpedbultoView2();
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
  
    /**
   * Reparteix un bulto en varios bultos
   */
   
  private void repartirBulto()
  {
    try
    {
      if (tableSgavexpedbultoView2.getSelectedRowCount() == 0)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoSenseBulto_label"));        
      }
      else if (tableSgavexpedbultoView2.getSelectedRowCount() > 1)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoMassaBultos_label"));        
      }
      else
      {
        SgavexpedbultoViewRow currbulto = (SgavexpedbultoViewRow)panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getCurrentRow();
        if (currbulto != null)
        {
          DefaultListModel llistaFrom =  currbulto.getLlistaBulto();
          DefaultListModel llistaTo =  new DefaultListModel();
          SgaJSelector llistesCamps = new SgaJSelector(llistaFrom, llistaTo,
              SgaRecursos.getInstance().getString("Sortides.embalum_label") + " " + currbulto.getIdbulto(),
              SgaRecursos.getInstance().getString("Sortides.embalumNou_label"), SgaJSelector.REPARTIR);
          String[] options = {"Aceptar", "Cancelar" };
          int eleccion = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                llistesCamps,                                    // the dialog message array
                SgaRecursos.getInstance().getString("Sortides.repartirBulto_label"),               // the title of the dialog window
                JOptionPane.DEFAULT_OPTION,                 // option type
                JOptionPane.PLAIN_MESSAGE,            // message type
                null,                                       // optional icon, use null to use the default icon
                options,                                    // options string array, will be made into buttons
                options[0]                                  // option that should be made into a default button
                );
                
          switch(eleccion)
          {
            case 0: // Es crea un bulto nou amb els lbultos de listTo
              if (llistaTo.size() > 0) // Vol dir que almenys un lbulto canvia de bulto
              {
                // Creem un bulto pel document
                
                ViewObject vobulto = panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getViewObject();
                if (vobulto != null)
                {
                AppModule am = (AppModule)panelBinding.getApplication().getApplicationModule();
                SgaexpedbultoViewRow currRealBulto = (SgaexpedbultoViewRow)currbulto.getSgaexpedbultoView();
                
                SgaexpedbultoViewRow nouBulto = currRealBulto.afegirBulto();
                  for (int i = 0; i < llistaTo.size(); i++)
                  {
                    String [] strlBulto = ((String)llistaTo.get(i)).split(":");
                    nouBulto.afegirABultoSortida(new Number(strlBulto[4]), new Number(strlBulto[5]), strlBulto[1], new Number(strlBulto[2]), new Number(strlBulto[3]), true);
                    currRealBulto.treureDeBultoSortida(new Number(strlBulto[4]), new Number(strlBulto[5]));
                  }
                  panelBinding.getApplication().getApplicationModule().getTransaction().commit();
                  panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getViewObject().executeQuery();
                  // TODO panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").setCurrentRowWithKey(currbulto.getKey().toStringFormat(true));
                }
              }
            break;
            
            case 1:
              break;
          }
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

   
  /**
   * Permet reagrupar varios bultos
   */
   
  private void dividirLinia()
   {
    try
    {
      if (tableSgavexpedbultoView2.getSelectedRowCount() == 0)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoSenseBulto_label"));        
      }
      else if (tableSgavexpedbultoView2.getSelectedRowCount() > 1)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoMassaBultos_label"));        
      }
      else
      {
        SgavexpedbultoViewRow currbulto = (SgavexpedbultoViewRow)panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getCurrentRow();
        if (currbulto != null)
        {
          DefaultListModel llistaFrom =  currbulto.getLlistaBulto();
          DefaultListModel llistaTo =  new DefaultListModel();
          SgaJSelector llistesCamps = new SgaJSelector(llistaFrom, llistaTo,
              SgaRecursos.getInstance().getString("Sortides.embalum_label") + " " + currbulto.getIdbulto(),
              SgaRecursos.getInstance().getString("Sortides.embalumNou_label"), SgaJSelector.DIVIDIR);
          String[] options = {"Aceptar", "Cancelar" };
          int eleccion = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                llistesCamps,                                    // the dialog message array
                SgaRecursos.getInstance().getString("Sortides.repartirBulto_label"),               // the title of the dialog window
                JOptionPane.DEFAULT_OPTION,                 // option type
                JOptionPane.PLAIN_MESSAGE,            // message type
                null,                                       // optional icon, use null to use the default icon
                options,                                    // options string array, will be made into buttons
                options[0]                                  // option that should be made into a default button
                );
                
          switch(eleccion)
          {
            case 0: // Es crea un bulto nou amb els lbultos de listTo
              if (llistaTo.size() > 0) // Vol dir que almenys un lbulto canvia de bulto
              {
                // Creem un bulto pel document
                
                ViewObject vobulto = panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getViewObject();
                if (vobulto != null)
                {
                AppModule am = (AppModule)panelBinding.getApplication().getApplicationModule();
                SgaexpedbultoViewRow currRealBulto = (SgaexpedbultoViewRow)currbulto.getSgaexpedbultoView();
                
                SgaexpedbultoViewRow nouBulto = currRealBulto.afegirBulto();
                  for (int i = 0; i < llistaTo.size(); i++)
                  {
                    String [] strlBulto = ((String)llistaTo.get(i)).split(":");
                    nouBulto.afegirABultoSortida(new Number(strlBulto[4]), 
                      new Number(strlBulto[5]), 
                      strlBulto[1], 
                      new Number(strlBulto[2]), 
                      new Number(strlBulto[3]), true);
                      currRealBulto.modCantLineaBultoSortida(new Number(strlBulto[4]), new Number(strlBulto[5]), Integer.parseInt(strlBulto[2]), new Number(strlBulto[3]));
                  }
                  panelBinding.getApplication().getApplicationModule().getTransaction().commit();
                  panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getViewObject().executeQuery();
                  // TODO panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").setCurrentRowWithKey(currbulto.getKey().toStringFormat(true));
                }
              }
            break;
            
            case 1:
              break;
          }
        }

      }
      
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
 }
     
  private void imprimirEtiqueta()
  {
    try
    {
        SgavexpedbultoViewRow currbulto = (SgavexpedbultoViewRow)panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getCurrentRow();
        if (currbulto != null)
          {
          String pickingPort = SgaUtilPuesto.getInstance().getProperty("PickingPort");
          if (pickingPort != null)
          {
            EtiquetaPicking etiqueta = currbulto.getDadesEtiqueta();
            etiqueta.printEtiqueta(pickingPort);
          }
       }
    }
  catch (Exception ex)
  {
   JUMetaObjectManager.reportException(null, ex);
  }
  }
  
  

  
    /**
   * Permet reagrupar varios bultos
   */
   
  private void reagruparBultos()
  {
    try
    {
      if (tableSgavexpedbultoView2.getSelectedRowCount() <= 1)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.reagruparSenseBultos_label"));         
      }
      else if (tableSgavexpedbultoView2.getSelectedRowCount() > 2)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.reagrupasMassaBultos_label"));        
      }
      else
      {
        int [] selectedRows = tableSgavexpedbultoView2.getSelectedRows();
        JUTableBinding tb = (JUTableBinding)panelBinding.findControlBinding("SgavexpedbultoView1");
        SgavexpedbultoViewRow bultoFrom = (SgavexpedbultoViewRow)tb.getRowAtRangeIndex(selectedRows[0]);
        SgavexpedbultoViewRow bultoTo = (SgavexpedbultoViewRow)tb.getRowAtRangeIndex(selectedRows[1]);

        DefaultListModel llistaFrom =  bultoFrom.getLlistaBulto();
        DefaultListModel llistaTo =  bultoTo.getLlistaBulto();
        // Michael 23.01.2015 Deshabilitar divisió de línia en reagrupar
//        SgaJSelector llistesCamps = new SgaJSelector(llistaFrom, llistaTo, 
//              SgaRecursos.getInstance().getString("Sortides.embalum_label") + " " + bultoFrom.getIdbulto(),
//              SgaRecursos.getInstance().getString("Sortides.embalum_label") + " " + bultoTo.getIdbulto(), true);
        SgaJSelector llistesCamps = new SgaJSelector(llistaFrom, llistaTo, 
              SgaRecursos.getInstance().getString("Sortides.embalum_label") + " " + bultoFrom.getIdbulto(),
              SgaRecursos.getInstance().getString("Sortides.embalum_label") + " " + bultoTo.getIdbulto(), 
              SgaJSelector.REAGRUPAR);  // TODO SAME!!

        String[] options = {"Aceptar", "Cancelar" };
        int eleccion = JOptionPane.showOptionDialog(
              Interflex.getInstance(),                                       // the parent that the dialog blocks
              llistesCamps,                                    // the dialog message array
              SgaRecursos.getInstance().getString("Sortides.reagruparBultos_label"),               // the title of the dialog window
              JOptionPane.DEFAULT_OPTION,                 // option type
              JOptionPane.PLAIN_MESSAGE,            // message type
              null,                                       // optional icon, use null to use the default icon
              options,                                    // options string array, will be made into buttons
              options[0]                                  // option that should be made into a default button
              );
                
        switch(eleccion)
        {
          case 0: // Es crea un bulto nou amb els lbultos de listTo
             DefaultListModel llistaFromOriginal =  bultoFrom.getLlistaBulto();
             DefaultListModel llistaToOriginal =  bultoTo.getLlistaBulto();
             // Primer afegim els nous lbulto a bultoFrom
             for (int i = 0; i < llistaFrom.size(); i++)
              {
                if (!llistaFromOriginal.contains(llistaFrom.get(i)))
                {
                  String [] strlBulto = ((String)llistaFrom.get(i)).split(":");
                  int todo = 1;
                  bultoFrom.afegirABultoSortida(new Number(strlBulto[4]),  new Number(strlBulto[5]), strlBulto[1], new Number(strlBulto[2]), new Number(strlBulto[3]), true);
                  bultoTo.treureDeBultoSortida(new Number(strlBulto[4]), new Number(strlBulto[5]));
                }
              }
             // Despres afegim els nous lbulto a bultoTo             
             for (int i = 0; i < llistaTo.size(); i++)
              {
                if (!llistaToOriginal.contains(llistaTo.get(i)))
                {
                  String [] strlBulto = ((String)llistaTo.get(i)).split(":");
                 // bultoTo.afegirABultoSortida(new Number(strlBulto[0]), strlBulto[1], new Number(strlBulto[2]), new Number(strlBulto[3]), true);
                 // bultoFrom.treureDeBultoSortida(new Number(strlBulto[0]));
                }
              }
              
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              // Fem un executeQuery per refrescar els canvis
              panelBinding.findIteratorBinding("SgavexpedbultoView1Iterator").getViewObject().executeQuery();
              //panelBinding.findIteratorBinding("SgabultoView4Iter").setCurrentRowWithKey(bultoFrom.getKey().toStringFormat(true));
              // Fi del bloc executeQuery
          break;
          
          case 1:
            break;
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
    
  
  
  
}