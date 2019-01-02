package es.sysmap.interflex.view;
import es.sysmap.interflex.etiquetes.EtiquetaPicking;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgabultoViewRow;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;
import javax.swing.text.*;

import oracle.adf.model.*;
import oracle.adf.model.binding.*;

import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.jdeveloper.layout.*;

import sgalib.SgaJComboEditor;
import sgalib.SgaJComboRenderer;
import sgalib.SgaJSelector;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.SgaUtilPuesto;

// public class PanelSgabultoView4 extends JPanel implements JUPanel
public class PanelSgabultoView4 extends SgaJUPanel
{
  private JComboBox mTipoBulto = new JComboBox();
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgabultoView4UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Fields for attribute:  SgabultoView4

 
  private SgaJTable tableSgabultoView4 = new SgaJTable()
  {
    public void tableChanged(TableModelEvent e)    
    {
      super.tableChanged(e);

      try
      {
      //Modifiquem els renderers dels combobox i checkboxs
      setCellEditor(panelBinding.getLabel("SgabultoView4", "Idtipobulto", null), new SgaJComboEditor(panelBinding.getApplication().getApplicationModule(), "SgatipobultoView1", "Idtip", "Idtip", mTipoBulto));
      setCellRenderer(panelBinding.getLabel("SgabultoView4", "Idtipobulto", null), new SgaJComboRenderer(panelBinding.getApplication().getApplicationModule(), "SgatipobultoView1", "Idtip", "Idtip"));
  

      }
      catch(Exception ex){}
    }
  };
  
  
  
  private JScrollPane scroller = new JScrollPane();

  private JButton buttonRepartirBulto = new JButton();
  private JButton buttonReagraparLinia = new JButton();
  private JButton buttonReagruparBultos = new JButton();
  private JButton buttonImprimirEtiqueta = new JButton();

 
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgabultoView4()
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
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Sortides.llistaBultos_label")));
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
    
    // Code support for view object:  SgabultoView4
    // Object m = panelBinding.bindUIControl("DCLOVList", mTipoBulto);
  
    mTipoBulto.setModel((ComboBoxModel)panelBinding.bindUIControl("DCComboBox", mTipoBulto));
    tableSgabultoView4.setModel((TableModel)panelBinding.bindUIControl("SgabultoView4", tableSgabultoView4));
    // TODO tableSgabultoView4.setEditable(false);
    tableSgabultoView4.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    scroller.getViewport().add(tableSgabultoView4, null);

    buttonReagraparLinia.setText(SgaRecursos.getInstance().getString("Sortides.reagruparLinia_label"));
    buttonReagraparLinia.setToolTipText(SgaRecursos.getInstance().getString("Sortides.reagruparLinia_tooltip"));
    buttonReagraparLinia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          dividirLinia();  
        }
      });


    buttonRepartirBulto.setText(SgaRecursos.getInstance().getString("Sortides.repartirBulto_label"));
    buttonRepartirBulto.setToolTipText(SgaRecursos.getInstance().getString("Sortides.repartirBulto_tooltip"));
    buttonRepartirBulto.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          repartirBulto();
        }
      });
    buttonReagruparBultos.setText(SgaRecursos.getInstance().getString("Sortides.reagruparBultos_label"));
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

    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgabultoView4", null, "SgabultoView4Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(true);
    navBar.setHasDeleteButton(false);
    navBar.setHasInsertButton(false);
    
    buttonsPanel.add(buttonRepartirBulto);
    buttonsPanel.add(buttonReagraparLinia);
    buttonsPanel.add(buttonReagruparBultos);
    buttonsPanel.add(buttonImprimirEtiqueta);
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

    PanelSgabultoView4 panel = new PanelSgabultoView4();
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
   * Reparteix un bulto en varios bultos
   */
   
  private void repartirBulto()
  {
    try
    {
      if (tableSgabultoView4.getSelectedRowCount() == 0)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoSenseBulto_label"));        
      }
      else if (tableSgabultoView4.getSelectedRowCount() > 1)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoMassaBultos_label"));        
      }
      else
      {
        SgabultoViewRow currbulto = (SgabultoViewRow)panelBinding.findIteratorBinding("SgabultoView4Iter").getCurrentRow();
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
                ViewObject vobulto = panelBinding.findIteratorBinding("SgabultoView4Iter").getViewObject();
                if (vobulto != null)
                {
                  SgabultoViewRow nouBulto = (SgabultoViewRow)vobulto.createRow();
                  vobulto.insertRow(nouBulto);
                  for (int i = 0; i < llistaTo.size(); i++)
                  {
                    String [] strlBulto = ((String)llistaTo.get(i)).split(":");
                    nouBulto.afegirABultoSortida(new Number(strlBulto[0]), strlBulto[1], new Number(strlBulto[2]), new Number(strlBulto[3]), true);
                    currbulto.treureDeBultoSortida(new Number(strlBulto[0]));
                  }
                  panelBinding.getApplication().getApplicationModule().getTransaction().commit();
                  // Fem un executeQuery per refrescar els canvis
                  panelBinding.findIteratorBinding("SgabultoView4Iter").getViewObject().executeQuery();
                  //panelBinding.findIteratorBinding("SgabultoView4Iter").setCurrentRowWithKey(currbulto.getKey().toStringFormat(true));
                  // Fi del bloc executeQuery
  
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
   
  private void reagruparBultos()
  {
    try
    {
      if (tableSgabultoView4.getSelectedRowCount() <= 1)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.reagruparSenseBultos_label"));         
      }
      else if (tableSgabultoView4.getSelectedRowCount() > 2)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.reagrupasMassaBultos_label"));        
      }
      else
      {
        int [] selectedRows = tableSgabultoView4.getSelectedRows();
        JUTableBinding tb = (JUTableBinding)panelBinding.findControlBinding("SgabultoView4");
        SgabultoViewRow bultoFrom = (SgabultoViewRow)tb.getRowAtRangeIndex(selectedRows[0]);
        SgabultoViewRow bultoTo = (SgabultoViewRow)tb.getRowAtRangeIndex(selectedRows[1]);
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
                  bultoFrom.afegirABultoSortida(new Number(strlBulto[0]), strlBulto[1], new Number(strlBulto[2]), new Number(strlBulto[3]), true);
                  bultoTo.treureDeBultoSortida(new Number(strlBulto[0]));
                }
              }
             // Despres afegim els nous lbulto a bultoTo             
             for (int i = 0; i < llistaTo.size(); i++)
              {
                if (!llistaToOriginal.contains(llistaTo.get(i)))
                {
                  String [] strlBulto = ((String)llistaTo.get(i)).split(":");
                  bultoTo.afegirABultoSortida(new Number(strlBulto[0]), strlBulto[1], new Number(strlBulto[2]), new Number(strlBulto[3]), true);
                  bultoFrom.treureDeBultoSortida(new Number(strlBulto[0]));
                }
              }
              
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              // Fem un executeQuery per refrescar els canvis
              panelBinding.findIteratorBinding("SgabultoView4Iter").getViewObject().executeQuery();
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
    
   
  /**
   * Permet reagrupar varios bultos
   */
   
  private void dividirLinia()
   {
    try
    {
      if (tableSgabultoView4.getSelectedRowCount() == 0)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoSenseBulto_label"));        
      }
      else if (tableSgabultoView4.getSelectedRowCount() > 1)
      {
        JOptionPane.showMessageDialog(Interflex.getInstance(), SgaRecursos.getInstance().getString("Sortides.repartoMassaBultos_label"));        
      }
      else
      {
        SgabultoViewRow currbulto = (SgabultoViewRow)panelBinding.findIteratorBinding("SgabultoView4Iter").getCurrentRow();
        if (currbulto != null)
        {
          DefaultListModel llistaFrom =  currbulto.getLlistaBulto();
          DefaultListModel llistaTo =  new DefaultListModel();
          SgaJSelector llistesCamps = new SgaJSelector(llistaFrom, llistaTo,
              SgaRecursos.getInstance().getString("Sortides.reagruparLinia_From") + " " + currbulto.getIdbulto(),
              SgaRecursos.getInstance().getString("Sortides.reagruparLinia_To"), SgaJSelector.DIVIDIR);
          String[] options = {"Aceptar", "Cancelar" };
          int eleccion = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                llistesCamps,                                    // the dialog message array
                SgaRecursos.getInstance().getString("Sortides.reagruparLinia_label"),               // the title of the dialog window
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
                ViewObject vobulto = panelBinding.findIteratorBinding("SgabultoView4Iter").getViewObject();
                if (vobulto != null)
                {
                  SgabultoViewRow nouBulto = (SgabultoViewRow)vobulto.createRow();
                  vobulto.insertRow(nouBulto);
                  for (int i = 0; i < llistaTo.size(); i++)
                  {
                    String [] strlBulto = ((String)llistaTo.get(i)).split(":");
                    nouBulto.afegirABultoSortida(new Number(strlBulto[0]), strlBulto[1], new Number(strlBulto[2]), new Number(strlBulto[3]), true);
                        currbulto.modCantLineaBultoSortida(new Number(strlBulto[0]), Integer.parseInt(strlBulto[2]));
                  }
                  panelBinding.getApplication().getApplicationModule().getTransaction().commit();
                  // Fem un executeQuery per refrescar els canvis
                  panelBinding.findIteratorBinding("SgabultoView4Iter").getViewObject().executeQuery();
                  // panelBinding.findIteratorBinding("SgabultoView4Iter").setCurrentRowWithKey(currbulto.getKey().toStringFormat(true));
                  // Fi del bloc executeQuery
  
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
    SgabultoViewRow bulto = (SgabultoViewRow)panelBinding.findIteratorBinding("SgabultoView4Iter").getCurrentRow();
    if (bulto != null)
    {
      String pickingPort = SgaUtilPuesto.getInstance().getProperty("PickingPort");
      if (pickingPort != null)
      {
        EtiquetaPicking etiqueta = bulto.getDadesEtiqueta();
        etiqueta.printEtiqueta(pickingPort);
      }
    }
  }
  catch (Exception ex)
  {
   JUMetaObjectManager.reportException(null, ex);
  }
  }
}