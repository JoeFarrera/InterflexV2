package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaRoleNotGrantedView;
import es.sysmap.interflex.model.dmc.common.SgaRoleNotGrantedViewRow;
import es.sysmap.interflex.model.dmc.common.SgagrantuserView;
import es.sysmap.interflex.model.dmc.common.SgagrantuserViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import sgalib.SgaJSelector;
import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgagrantuserView1 extends SgaJUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgagrantuserView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgagrantuserView1

  private SgaJTable tableSgagrantuserView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JLabel jLabelText = new JLabel();

  private Icon userIcon = SgaRecursos.createImageIcon(getClass(), "48x48/plain/id_card_preferences.png", null);


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgagrantuserView1()
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
    // Code support for view object:  SgagrantuserView1
    tableSgagrantuserView1.setModel((TableModel)panelBinding.bindUIControl("SgagrantuserView1", tableSgagrantuserView1));
    scroller.getViewport().add(tableSgagrantuserView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgagrantuserView1", null, "SgagrantuserView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);

   // Modificar el boton de aï¿½adir
    
    tableSgagrantuserView1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    JButton insertButton = navBar.getButton(navBar.BUTTON_INSERT);
    ActionListener [] listeners = insertButton.getActionListeners();
    for (int i = 0; i < listeners.length; i++)
    {
      insertButton.removeActionListener(listeners[i]);
    }
    
    insertButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          grantRole();
        }
      });
      
    dataPanel.add(jLabelText, null);
    jLabelText.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
    jLabelText.setIconTextGap(12);
    jLabelText.setIcon(userIcon);
    jLabelText.setFont(new Font("Tahoma", 0, 14));
    jLabelText.setToolTipText("null");
    jLabelText.setText("<html>"
      + "<P>Afegir o treure <i>roles (perfils) al usuari</i></P>" 
      + "<P>Mitjancant els botons <em>inserir</em> o <em>esborrar</em></P>"
      + "<P>Registrar o desfer els cambis una vegada comprobades</P>"
      + "</html>");


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

    PanelSgagrantuserView1 panel = new PanelSgagrantuserView1();
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
   * Determinar el filtro aplicado por ser de maestro detalle
   * NOTA: Assumption: role-acceso relationship only applies
   * @return 
   */
  private String getFilterString()
  {
    SgagrantuserView view = (SgagrantuserView)panelBinding.findIteratorBinding("SgagrantuserView1Iter").getViewObject();
    Object [] rowFilters = view.getRowFilterValues();
    if (rowFilters.length > 0)
    {
      return (String)rowFilters[0];
    }
    return null;
  }

  private void grantRole()
  {
    AppModule app = (AppModule)panelBinding.getApplication().getApplicationModule();
    
    SgaRoleNotGrantedView roleView = (SgaRoleNotGrantedView)app.findViewObject("SgaRoleNotGrantedView1");
    DefaultListModel llistaFrom =  roleView.getListModel(getFilterString());
    DefaultListModel llistaTo =  new DefaultListModel();
    SgaJSelector llistesCamps = new SgaJSelector(llistaFrom, llistaTo,
        "Roles disponibles" + " " + "",
        "Añadir al usuario...", SgaJSelector.REPARTIR);
    String[] options = {"Aceptar", "Cancelar" };
    int eleccion = JOptionPane.showOptionDialog(
          Interflex.getInstance(),                                       // TODO - find the parent that the dialog blocks
          llistesCamps,                                    // the dialog message array
          "Asignar perfiles",               // the title of the dialog window
          JOptionPane.DEFAULT_OPTION,                 // option type
          JOptionPane.PLAIN_MESSAGE,            // message type
          null,                                       // optional icon, use null to use the default icon
          options,                                    // options string array, will be made into buttons
          options[0]                                  // option that should be made into a default button
          );
          
          
      switch(eleccion)
      {
        case 0: // Aceptado algo
          if (llistaTo.size() > 0) // hay cosas
          {
            RowSetIterator rows = panelBinding.findIteratorBinding("SgagrantuserView1Iter").getRowSetIterator();
            for (int i = 0; i < llistaTo.size(); i++)
              {
                SgaRoleNotGrantedViewRow newRow = (SgaRoleNotGrantedViewRow)llistaTo.get(i);
                SgagrantuserViewRow row = (SgagrantuserViewRow)rows.createRow();
                row.setIdrolegranted(newRow.getIdrole());
                rows.insertRow(row);
              }
              panelBinding.getApplication().getApplicationModule().getTransaction().postChanges();
             // Fem un executeQuery per refrescar els canvis
              panelBinding.findIteratorBinding("SgagrantuserView1Iter").getViewObject().executeQuery();
          }
      }


  }
  
      // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

}