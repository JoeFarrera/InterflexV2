package es.sysmap.interflex.viewtest;
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

  private JTable tableSgavexpeddocView1 = new JTable();
  private JScrollPane scroller = new JScrollPane();
  
  private JPanel buttonsPanel = new JPanel(new FlowLayout());
  private JButton buttonAfegirDoc = new JButton("(+) Afegir Doc.");


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
    
     
    buttonAfegirDoc.setToolTipText("Afegir un document a la expedició actual");
    buttonAfegirDoc.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          afegirDocExped();
        }
      });
      
    buttonsPanel.add(navBar);
    buttonsPanel.add(buttonAfegirDoc);
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

    PanelSgavexpeddocView1 panel = new PanelSgavexpeddocView1();
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
  



  private void afegirDocExped()
  {
    try
    {
       PanelSgacdocSortidesView2 panelSortides = new PanelSgacdocSortidesView2();
        panelSortides.setBindingContext(panelBinding.getBindingContext());
        // String sWhereClause = "idart = '" + currentRow.getIdart() + "'";
        // panelSortides.setWhereClause(sWhereClause);
        // Michael ReservaManual 09.10.2014       
        // panelExistencies.setIddoc (currentRow.getIddoc(), currentRow.getIdlin(), currentRow.getIdcabnum());
        
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label")};
        int result = JOptionPane.showOptionDialog(
            Interflex.getInstance(),                                       // the parent that the dialog blocks
            panelSortides,                                    // the dialog message array
            SgaRecursos.getInstance().getString("Documents a incloure en l'expedició"), // the title of the dialog window
            JOptionPane.DEFAULT_OPTION,                 // option type
            JOptionPane.PLAIN_MESSAGE,            // message type
            null,                                       // optional icon, use null to use the default icon
            options,                                    // options string array, will be made into buttons
            null                                        // option that should be made into a default button
        );
        panelSortides.releasePanelBinding();
        panelSortides = null;
      }
      
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
}