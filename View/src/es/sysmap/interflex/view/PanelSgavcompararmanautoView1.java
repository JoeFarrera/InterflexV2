package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgavcompararmanautoViewRow;
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
import oracle.jbo.uicli.controls.JUNavigationBar;
import java.awt.BorderLayout;
import oracle.jbo.uicli.controls.JUStatusBar;
import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

// public class PanelSgavcompararmanautoView1 extends JPanel implements JUPanel 
public class PanelSgavcompararmanautoView1 extends SgaJUPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavcompararmanautoView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavcompararmanautoView1

  private SgaJTable tableSgavcompararmanautoView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar();
  private JUStatusBar jUStatusBar1 = new JUStatusBar();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavcompararmanautoView1()
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
    // Code support for view object:  SgavcompararmanautoView1
    tableSgavcompararmanautoView1.setModel((TableModel)panelBinding.bindUIControl("SgavcompararmanautoView1", tableSgavcompararmanautoView1));
    jUNavigationBar1.setHasTransactionButtons(false);
    scroller.getViewport().add(tableSgavcompararmanautoView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    add(dataPanel, BorderLayout.CENTER);
    this.add(jUNavigationBar1, BorderLayout.NORTH);
    // this.add(jUStatusBar1, BorderLayout.SOUTH);
    // jUStatusBar1.setModel(JUStatusBar.createPanelBinding(panelBinding, jUStatusBar1));
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgavcompararmanautoView1", null, "SgavcompararmanautoView1Iter"));
    
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

    PanelSgavcompararmanautoView1 panel = new PanelSgavcompararmanautoView1();
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
      
      
      tableSgavcompararmanautoView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.veureExistencies_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureExistencies();
        }
      });      
      tableSgavcompararmanautoView1.addPopupMenuItem(menuItem);

  }
  
    private SgavcompararmanautoViewRow getCurrentRow()
  {
    return (SgavcompararmanautoViewRow)panelBinding.findIterBinding("SgavcompararmanautoView1Iter").getCurrentRow();  
  }
  
  private void veureExistencies()
  {
    try
    {
      SgavcompararmanautoViewRow currentRow = getCurrentRow();
      if (currentRow != null)
      {
        MDPanelSgavsumexistenciaView1SgavexistenciaView2 panelExistencies = new MDPanelSgavsumexistenciaView1SgavexistenciaView2();
        panelExistencies.setBindingContext(panelBinding.getBindingContext());
        String sWhereClause = "idart = (select idart from sgaarticulo where idartif = '" + currentRow.getidartif() + "')";
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