package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;


public class PanelSgavcdocView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavcdocView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

  private JPanel buttonsPanel = new JPanel();
  private FlowLayout buttonsLayout = new FlowLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavcdocView1

  private SgaJTable tableSgavcdocView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();

  private JButton buttonEmbalatge = new JButton();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavcdocView1()
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
    dataPanel.setMinimumSize(new Dimension(700, 271));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Sortides.capçalera_label")));
    dataPanel.setPreferredSize(new Dimension(700, 271));
    dataPanel.setMaximumSize(new Dimension(700, 271));
    buttonsPanel.setLayout(buttonsLayout);
    buttonsPanel.setPreferredSize(new Dimension(700, 37));
    buttonsPanel.setMinimumSize(new Dimension(700, 37));
    buttonsPanel.setMaximumSize(new Dimension(700, 37));
    buttonsPanel.setSize(new Dimension(700, 40));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 300));
    this.setPreferredSize(new Dimension(700, 300));
    this.setMinimumSize(new Dimension(700, 300));
    this.setMaximumSize(new Dimension(700, 300));

    buttonEmbalatge.setText(SgaRecursos.getInstance().getString("Sortides.obrirEmbalatges_label"));
    buttonEmbalatge.setToolTipText(SgaRecursos.getInstance().getString("Sortides.obrirEmbalatges_label"));
    buttonEmbalatge.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          obrirEmbalatges();
        }
      });
    
    // Code support for view object:  SgavcdocView1
    tableSgavcdocView1.setModel((TableModel)panelBinding.bindUIControl("SgavcdocView1", tableSgavcdocView1));
    tableSgavcdocView1.setEditable(false);
    scroller.getViewport().add(tableSgavcdocView1, null);
    // Layout the datapanel and the navigation bar
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavcdocView1", null, "SgavcdocView1Iter"));
    navBar.setPreferredSize(new Dimension(700, 29));
    navBar.setMaximumSize(new Dimension(700, 29));
    navBar.setMinimumSize(new Dimension(700, 29));
    navBar.setHasTransactionButtons(false);
    dataPanel.add(scroller);
    buttonsPanel.add(buttonEmbalatge);
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

    PanelSgavcdocView1 panel = new PanelSgavcdocView1();
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

  
  private void obrirEmbalatges()
  {
    Row currentrada = panelBinding.findIteratorBinding("SgavcdocView1Iter").getCurrentRow();
    if (currentrada != null)
    {
      PanelSgavedocView1 panelSgavedocView1 = new PanelSgavedocView1();
      panelSgavedocView1.setBindingContext(panelBinding.getBindingContext());
      // Options
     String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                        SgaRecursos.getInstance().getString("Options.cancelar_label") };
 
      int result = JOptionPane.showOptionDialog(
          Interflex.getInstance(),                                       // the parent that the dialog blocks
          panelSgavedocView1,                                    // the dialog message array
          SgaRecursos.getInstance().getString("Sortides.embalatges_label"), // the title of the dialog window
          JOptionPane.DEFAULT_OPTION,                 // option type
          JOptionPane.PLAIN_MESSAGE,            // message type
          null,                                       // optional icon, use null to use the default icon
          options,                                    // options string array, will be made into buttons
          null                                        // option that should be made into a default button
      );
    switch(result) {
       case 0: // Acceptar
          // Activem els detalls del bulto i gravem
          // TODO: Veure com desactivar el setClearCacheOnCommit desde el appModule
          // per evitar que se'n vagi al primer registre després de fer el commit
          try
          {
            panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          }
          catch(Exception ex)
          {
            JUMetaObjectManager.reportException(null, ex);
          }
         break;
       case 2: // cancelar
          panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
       default:
         break;
      }
      panelSgavedocView1.releasePanelBinding();
      panelSgavedocView1 = null;
    }
  }


  public void setWhereClause(String whereClause)
  {
    try
    {
      panelBinding.findIteratorBinding("SgavcdocView1Iter").setFindMode(false);
      ViewObject vocdoc = panelBinding.findIteratorBinding("SgavcdocView1Iter").getViewObject();
      vocdoc.setWhereClause(whereClause);
      vocdoc.executeQuery();
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
}