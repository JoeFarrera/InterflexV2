package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgaexpeddocViewRow;
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

public class PanelSgaexpeddocView2 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaexpeddocView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgaexpeddocView2

  private SgaJTable tableSgaexpeddocView2 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaexpeddocView2()
  {
  }

   /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
    
      
      tableSgaexpeddocView2.addPopupSeparator();
      
      
      menuItem = new JMenuItem("Treure de l'expedició");
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/undo.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          esborrarDocExped();
        }
      });      
      tableSgaexpeddocView2.addPopupMenuItem(menuItem);
  }
  
  
  

    private void esborrarDocExped()
  {
    try
    {
        SgaexpeddocViewRow row = (SgaexpeddocViewRow)panelBinding.findIteratorBinding("SgaexpeddocView2Iter").getCurrentRow();

  
  
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
        
        if (result != JOptionPane.YES_OPTION)
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
    // Code support for view object:  SgaexpeddocView2
    tableSgaexpeddocView2.setModel((TableModel)panelBinding.bindUIControl("SgaexpeddocView2", tableSgaexpeddocView2));
    scroller.getViewport().add(tableSgaexpeddocView2, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaexpeddocView2", null, "SgaexpeddocView2Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);
    
    addPopup();


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

    PanelSgaexpeddocView2 panel = new PanelSgaexpeddocView2();
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
}