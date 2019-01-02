package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgavldocViewRow;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;

import sgalib.SgaJTable;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgavldocView1 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavldocView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavldocView1

  private SgaJTable tableSgavldocView1 = new SgaJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavldocView1()
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
    dataPanel.setMinimumSize(new Dimension(700, 300));
    dataPanel.setBorder(BorderFactory.createTitledBorder(SgaRecursos.getInstance().getString("Sortides.detallOrdres_label")));
    dataPanel.setPreferredSize(new Dimension(700, 300));
    dataPanel.setMaximumSize(new Dimension(700, 300));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(700, 300));
    this.setPreferredSize(new Dimension(700, 300));
    this.setMinimumSize(new Dimension(700, 300));
    this.setMaximumSize(new Dimension(700, 300));
    // Code support for view object:  SgavldocView1
    tableSgavldocView1.setModel((TableModel)panelBinding.bindUIControl("SgavldocView1", tableSgavldocView1));
    tableSgavldocView1.setEditable(false);
    scroller.getViewport().add(tableSgavldocView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    // Layout the datapanel and the navigation bar
    add(dataPanel, BorderLayout.CENTER);
    //Afegim opcions al menu popup de la taula
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

    PanelSgavldocView1 panel = new PanelSgavldocView1();
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
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
      JMenuItem menuItem;
      
      tableSgavldocView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Sortides.veureExistencies_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureExistencies();
        }
      });      
      tableSgavldocView1.addPopupMenuItem(menuItem);
  }

  private void veureExistencies()
  {
    try
    {
      SgavldocViewRow currentRow = (SgavldocViewRow)panelBinding.findIterBinding("SgavldocView1Iter").getCurrentRow();  
      if (currentRow != null)
      {
        MDPanelSgavsumexistenciaView1SgavexistenciaView2 panelExistencies = new MDPanelSgavsumexistenciaView1SgavexistenciaView2();
        panelExistencies.setBindingContext(panelBinding.getBindingContext());
        String sWhereClause = "idart = '" + currentRow.getIdart() + "'";
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