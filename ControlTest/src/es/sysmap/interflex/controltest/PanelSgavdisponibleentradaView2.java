package es.sysmap.interflex.controltest;
import es.sysmap.interflex.model.dmc.common.SgalbultoViewRow;
import es.sysmap.interflex.model.dmc.common.SgamacViewRow;
import es.sysmap.interflex.model.tst.common.SgavdisponibleentradaViewRow;
import es.sysmap.interflex.model.tst.common.SgaventradaspendienteViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.domain.Number;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import sgalib.SgaJTable;
import sgalib.SgaPopupListener;
import sgalib.SgaRecursos;

public class PanelSgavdisponibleentradaView2 extends JPanel implements JUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavdisponibleentradaView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavdisponibleentradaView2

  private LocalJTable tableSgavdisponibleentradaView2 = new LocalJTable();
  private JScrollPane scroller = new JScrollPane();



  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavdisponibleentradaView2()
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
    // Code support for view object:  SgavdisponibleentradaView2
    tableSgavdisponibleentradaView2.setModel((TableModel)panelBinding.bindUIControl("SgavdisponibleentradaView2", tableSgavdisponibleentradaView2));
    scroller.getViewport().add(tableSgavdisponibleentradaView2, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavdisponibleentradaView2", null, "SgavdisponibleentradaView2Iter"));
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

    PanelSgavdisponibleentradaView2 panel = new PanelSgavdisponibleentradaView2();
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
      menuItem = new JMenuItem("Reservar la entrada");
      menuItem.addActionListener(this);      
      popup.add(menuItem);

      //Add listener to the text area so the popup menu can come up.
      MouseListener popupListener = new SgaPopupListener(popup);
      addMouseListener(popupListener);


  }
   public void actionPerformed(ActionEvent e) {
    try
    {
    SgavdisponibleentradaViewRow row = (SgavdisponibleentradaViewRow)panelBinding.findIteratorBinding("SgavdisponibleentradaView2Iter").getCurrentRow();
      
    ApplicationModule am = getPanelBinding().getApplication().getApplicationModule();
  
    ViewObject volBulto       = am.findViewObject("SgalbultoView1");
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

    JTextField jTextCanPend = new JTextField(row.getCantot().toString());
    JTextField jTextTraslo = new JTextField("1");
    
    
    
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
      
    message [5] = " ";
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
   
    volBulto.setWhereClause(null);
    volBulto.setWhereClause("idbulto = " + row.getIdbulto() + " and iddoc = " + row.getIddoc() + " and idlin = " + row.getIdlin());
    volBulto.executeQuery();
    if (volBulto.hasNext())
    {
      SgalbultoViewRow lbultoRow = (SgalbultoViewRow)volBulto.first();
      System.out.println("Reservando bulto: " + row.getIdbulto() + " and iddoc = " + row.getIddoc() + " and idlin = " + row.getIdlin());
      lbultoRow.reservarEntrada(row.getIdmac(), canres);
      System.out.println("Reservando mac :" + row.getIdmac());
      macRow.reservarEntradaMaterial(desti /* :TODO */, row.getIdart(), canres, 1 /* :TODO */);
      JOptionPane.showMessageDialog(null, "Reserva de mac " + row.getIdmac() + 
              " para bulto: " + row.getIdbulto() + " and iddoc = " + row.getIddoc() + " and idlin = " + row.getIdlin() + " and canres: " + canres
              + " Reservado (pero sin commit)");
       int confirmar = JOptionPane.showConfirmDialog(null, "<html>Reserva de mac " + row.getIdmac() + 
               " para bulto: " + row.getIdbulto() + " and iddoc = " + row.getIddoc() + " and idlin = " + row.getIdlin() + " and canres: " + canres
              + " Reservado (pero sin commit) "
              + "<p><em> Realizar commit?</em></p></html>",
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