package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgavexpeddocViewRow;
import es.sysmap.interflex.view.Interflex;
import es.sysmap.interflex.view.MDPanelSgacdocSortidesView2SgaldocView5;
import es.sysmap.interflex.view.PanelSgacdocSortidesView2;
import java.awt.*;
import java.awt.event.*;
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
import sgalib.SgaJTable;
import sgalib.SgaRecursos;

public class PanelSgavexpeddocView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexpeddocView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavexpeddocView1

  private SgaJTable tableSgavexpeddocView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  



  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexpeddocView1()
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
    dataPanel.setBorder(BorderFactory.createTitledBorder("Documents de l'expedició"));

    this.setLayout(borderLayout);
    
    
    this.setSize(new Dimension(448, 200));
    this.setMaximumSize(new Dimension(700, 200));
    this.setPreferredSize(new Dimension(448, 200));

    // Code support for view object:  SgavexpeddocView1
    tableSgavexpeddocView1.setModel((TableModel)panelBinding.bindUIControl("SgavexpeddocView1", tableSgavexpeddocView1));
    scroller.getViewport().add(tableSgavexpeddocView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavexpeddocView1", null, "SgavexpeddocView1Iter"));
    // Layout the datapanel and the navigation bar
    
    add(dataPanel, BorderLayout.CENTER);
    
     
    add(navBar, BorderLayout.NORTH);
    
    addPopup();
    
    
    JButton buttonDelete = navBar.getButton(JUNavigationBar.BUTTON_DELETE);
    ActionListener [] listeners = buttonDelete.getActionListeners();
    for (int i = 0; i < listeners.length; i++)
    {
      buttonDelete.removeActionListener(listeners[i]);
    }
    buttonDelete.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          
          esborrarDocExped();
        }
      });
      
    JButton buttonAdd = navBar.getButton(JUNavigationBar.BUTTON_INSERT);
    ActionListener [] addlisteners = buttonAdd.getActionListeners();
    for (int i = 0; i < addlisteners.length; i++)
    {
      buttonAdd.removeActionListener(addlisteners[i]);
    }
    buttonAdd.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          JOptionPane.showMessageDialog(null, "Feu servir el botó de l'expedició per afegir un document adicional");
          
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

    PanelSgavexpeddocView1 panel = new PanelSgavexpeddocView1();
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
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
    
      
      tableSgavexpeddocView1.addPopupSeparator();
      
      
      menuItem = new JMenuItem("Treure de l'expedició");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/undo.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          esborrarDocExped();
        }
      });      
      tableSgavexpeddocView1.addPopupMenuItem(menuItem);
  }
  
  
  

    private void esborrarDocExped()
  {
    try
    {
        SgavexpeddocViewRow row = (SgavexpeddocViewRow)panelBinding.findIteratorBinding("SgavexpeddocView1Iter").getCurrentRow();

  
  
        String [] options;
          
        // Si el usuari no té drets per modificar el transportista, simplement li ensenyem els resultats..
        // TODO: Veure drets - aquests no son!!
        if (false) // TODO appModule.isUserModTransportista())
        {
          options = new String [] { "Aceptar" };
        }
        else
        {
  
          options = new String [] { "Aceptar selecció", "Cancel·lar"};
        }
        
        
        int result = JOptionPane.showConfirmDialog(null, 
          "Treure document :" + row.getIdcabnum() + " de l'expedició", "Confirmar treure d'expedició", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION)
          {
              row.esborrarDocSortida();
              panelBinding.getApplication().getApplicationModule().getTransaction().commit();
              navBar.getModel().getViewObject().executeQuery();
              JOptionPane.showMessageDialog(null, row.getIdcabnum() + " Tret de l'expedició", 
                "Confirmació", 
                JOptionPane.INFORMATION_MESSAGE );
          }
      }
      
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  

 
}