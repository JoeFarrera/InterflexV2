package es.sysmap.interflex.controltest;
import es.sysmap.interflex.model.dmc.common.SgalbultoViewRow;
import es.sysmap.interflex.model.dmc.common.SgaldocViewRow;
import es.sysmap.interflex.model.dmc.common.SgamacViewRow;
import es.sysmap.interflex.model.tst.common.SgavexistenciadisponiblemldViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.domain.Number;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import sgalib.SgaPopupListener;

public class PanelSgavexistenciadisponiblemldView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexistenciadisponiblemldView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavexistenciadisponiblemldView1

  private JTable tableSgavexistenciadisponiblemldView1 = new LocalJTable();
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexistenciadisponiblemldView1()
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
    // Code support for view object:  SgavexistenciadisponiblemldView1
    tableSgavexistenciadisponiblemldView1.setModel((TableModel)panelBinding.bindUIControl("SgavexistenciadisponiblemldView1", tableSgavexistenciadisponiblemldView1));
    scroller.getViewport().add(tableSgavexistenciadisponiblemldView1, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavexistenciadisponiblemldView1", null, "SgavexistenciadisponiblemldView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);


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

    PanelSgavexistenciadisponiblemldView1 panel = new PanelSgavexistenciadisponiblemldView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "TestAppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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
  
 public class LocalJTable extends JTable implements ActionListener
  {
   private JPopupMenu popup = new JPopupMenu();
   
  public LocalJTable()
   {
      createPopupMenu();
   }

   
   public void createPopupMenu() {
      JMenuItem menuItem;

      //Create the menu item.
      menuItem = new JMenuItem("Reservar la salida");
      menuItem.addActionListener(this);      
      popup.add(menuItem);

      //Add listener to the text area so the popup menu can come up.
      MouseListener popupListener = new SgaPopupListener(popup);
      addMouseListener(popupListener);


  }
   public void actionPerformed(ActionEvent e) {
    try
    {
   SgavexistenciadisponiblemldViewRow row = (SgavexistenciadisponiblemldViewRow)panelBinding.findIteratorBinding("SgavexistenciadisponiblemldView1Iter").getCurrentRow();
      
    ApplicationModule am = getPanelBinding().getApplication().getApplicationModule();
  
    ViewObject voMac = am.findViewObject("SgamacView1");
    ViewObject voLdoc        = am.findViewObject("SgaldocView1");

    voMac.setWhereClause(null);
    voMac.setWhereClause("idmac = '" + row.getIdmac() + "'");
    SgamacViewRow macRow = (SgamacViewRow)voMac.first();
    
    boolean silo = !macRow.getIdtipmac().equals("CUB");


    Object []      message = new Object[9];
    message [0] = "Triar desti del contenidor: (Sólo test...) ";
    message [1] = " ";  // Para que haya un hueco
    JComboBox cb = new JComboBox();
    if (!silo)
    {
      cb.addItem("PK1MLD");
      cb.addItem("PK2MLD");
    }
    else
    {
      cb.addItem("PK1SLO");
      cb.addItem("PK2SLO");
    }

    JTextField jTextTraslo = new JTextField("1");

    JTextField jTextCanPend = new JTextField(row.getCantot().toString());
    
    
    message [2] = cb;
    if (silo)
    {
      message [3] = "Traslo (1..2)";
      message [4] = jTextTraslo;
    }
    else
    {
      message [3] = " ";
      message [4] = " ";
    }
    message [6] = "Cantidad a reservar";
    message [7] = jTextCanPend;
    message [8] = " ";

    // Options
    String[] options = {"Acceptar", "Cancel.lar" };
    int eleccion = JOptionPane.showOptionDialog(
          null,                                       // the parent that the dialog blocks
          message,                                    // the dialog message array
          "Triar el desti de l'extacció",            // the title of the dialog window
          JOptionPane.DEFAULT_OPTION,                 // option type
          JOptionPane.INFORMATION_MESSAGE,            // message type
          null,                                       // optional icon, use null to use the default icon
          options,                                    // options string array, will be made into buttons
          options[0]                                  // option that should be made into a default button
          );

    if (eleccion == 0)
    {
      // Ha aceptado algo
      String desti = (String)cb.getSelectedItem();
      Number canres = new Number(jTextCanPend.getText());

    int idTraslo = silo ? Integer.parseInt(jTextTraslo.getText()) : 0;
    voLdoc.setWhereClause(null);
    voLdoc.setWhereClause("iddoc = " + row.getIddoc() + " and idlin = " + row.getIdlin());
    voLdoc.executeQuery();
    if (voLdoc.hasNext())
    {
      SgaldocViewRow ldocRow = (SgaldocViewRow)voLdoc.first();
      System.out.println("Reservando iddoc = " + row.getIddoc() + " and idlin = " + row.getIdlin());
      ldocRow.reservarSalida(row.getIdmac(), canres);
      System.out.println("Reservando mac :" + row.getIdmac());
      macRow.reservarSalidaMaterial(desti /* :TODO */, row.getIdart(), canres, idTraslo);
      int confirmar = JOptionPane.showConfirmDialog(null, "<html>Reserva de mac " + row.getIdmac() + 
              " para iddoc = " + row.getIddoc() + " and idlin = " + row.getIdlin() + " and canres: " + canres
              + " Reservado (pero sin commit) <p><em> Realizar commit?</em></p></html>",
                "Confirmar transacción...",
                JOptionPane.YES_NO_OPTION);
      if (confirmar == 0)
        am.getTransaction().commit();
      else
        am.getTransaction().rollback();
      return;
    }

      
   }
   JOptionPane.showMessageDialog(null, "Reserva no realizada");
    }
    catch (Exception ex)
    {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex.getMessage());
    }
  }
  }
}