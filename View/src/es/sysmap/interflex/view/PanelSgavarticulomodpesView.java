package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgavarticulomodpesViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import sgalib.SgaJUPanel;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Font;
import sgalib.SgaRecursos;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSgavarticulomodpesView extends SgaJUPanel
// public class PanelSgavarticulomodpesView extends JPanel implements JUPanel 
{

 private Icon iconWeight = SgaRecursos.createImageIcon(getClass(),"48x48/plain/weight2.png", null);

  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavarticulomodpesViewUIModel");
  
  private static final String iterBinding = "SgavarticulomodpesView1Iter";

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel


// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Controlar Pes


// Fields for attribute:  Pes unitari

  private JLabel labelPesunit = new JLabel();
  private JTextField mPesunit = new JTextField();

// Fields for attribute:  Data mod. pes

  private JLabel labelFecultmodpes = new JLabel();
  private JTextField mFecultmodpes = new JTextField();

// Fields for attribute:  Usuari mod. pes

  private JLabel labelModpesby = new JLabel();
  private JTextField mModpesby = new JTextField();

// Fields for attribute:  Quantitat

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();

// Fields for attribute:  Unitats per embalatge

  private JLabel labelUniemb = new JLabel();
  private JTextField mUniemb = new JTextField();

// Fields for attribute:  Multireferencia


// Fields for attribute:  Contenidor

  private JLabel labelIdmac1 = new JLabel();
  private JTextField mIdmac1 = new JTextField();

// Fields for attribute:  Tara Teóric

  private JLabel labelTaraTeoric = new JLabel();
  private JTextField mTaraTeoric = new JTextField();

// Fields for attribute:  Tara Real

  private JLabel labelTaraReal = new JLabel();
  private JTextField mTaraReal = new JTextField();

// Fields for attribute:  Tipo Contenedor

  private JLabel labelDescrip1 = new JLabel();
  private JTextField mDescrip1 = new JTextField();

// Fields for attribute:  Pes Actual

  private JLabel labelPesActual = new JLabel();
  private JTextField mPesActual = new JTextField();

// Fields for attribute:  Pes Unitari Real

  private JLabel labelPesUnitariReal = new JLabel();
  private JTextField mPesUnitariReal = new JTextField();
  private JLabel jLabelIconWeight = new JLabel();

  private static PanelSgavarticulomodpesView _instance = null;

  /**
   * 
   *  The default constructor for panel
   */
  private PanelSgavarticulomodpesView()
  {
  }
  
  public static PanelSgavarticulomodpesView getInstance(BindingContext bc)
  {
    if (_instance == null)
    {
    _instance = new PanelSgavarticulomodpesView();
    _instance.setBindingContext(bc);
    }
    return _instance;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(null);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    labelIdartif.setBounds(new Rectangle(35, 5, 65, 15));
    mPesUnitariReal.setBackground(Color.yellow);
    this.setLayout(borderLayout);
    this.setSize(new Dimension(721, 478));
    this.setMinimumSize(new Dimension(721, 478));
    this.setPreferredSize(new Dimension(721, 478));
    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    mIdartif.setBounds(new Rectangle(35, 20, 130, 30));
    mIdartif.setFont(new Font("Tahoma", 1, 15));
    labelDescrip.setBounds(new Rectangle(40, 50, 90, 15));
    mDescrip.setBounds(new Rectangle(35, 65, 665, 30));
    mDescrip.setFont(new Font("Tahoma", 1, 15));
    labelPesunit.setBounds(new Rectangle(165, 300, 180, 15));
    labelPesunit.setToolTipText("Pes unitari del mestre d\'artícles");
    mPesunit.setBounds(new Rectangle(165, 315, 130, 20));
    mPesunit.setFont(new Font("Tahoma", 1, 13));
    labelFecultmodpes.setBounds(new Rectangle(465, 300, 100, 15));
    mFecultmodpes.setBounds(new Rectangle(465, 315, 130, 20));
    labelModpesby.setBounds(new Rectangle(465, 345, 100, 15));
    mModpesby.setBounds(new Rectangle(465, 360, 130, 20));
    labelCantot.setBounds(new Rectangle(165, 210, 90, 15));
    mCantot.setBounds(new Rectangle(165, 225, 130, 20));
    mCantot.setFont(new Font("Tahoma", 1, 14));
    labelUniemb.setBounds(new Rectangle(165, 115, 125, 15));
    mUniemb.setBounds(new Rectangle(165, 130, 130, 20));
    labelIdmac1.setBounds(new Rectangle(165, 165, 75, 15));
    mIdmac1.setBounds(new Rectangle(165, 180, 130, 20));
    labelTaraTeoric.setBounds(new Rectangle(465, 165, 85, 15));
    mTaraTeoric.setBounds(new Rectangle(465, 180, 130, 20));
    labelTaraReal.setBounds(new Rectangle(465, 210, 65, 15));
    mTaraReal.setBounds(new Rectangle(465, 225, 130, 20));
    labelDescrip1.setBounds(new Rectangle(305, 165, 80, 15));
    mDescrip1.setBounds(new Rectangle(305, 180, 130, 20));
    labelPesActual.setBounds(new Rectangle(165, 255, 75, 15));
    mPesActual.setBounds(new Rectangle(165, 270, 130, 20));
    labelPesUnitariReal.setBounds(new Rectangle(165, 345, 130, 15));
    labelPesUnitariReal.setMaximumSize(new Dimension(130, 15));
    mPesUnitariReal.setBounds(new Rectangle(165, 360, 130, 35));
    mPesUnitariReal.setFont(new Font("Tahoma", 1, 18));
    jLabelIconWeight.setBounds(new Rectangle(190, 10, 505, 45));
    jLabelIconWeight.setIcon(iconWeight);
    jLabelIconWeight.setText("Modificar el pes unitari del artícle segons la quantitat pesada per " + "la báscula");
    jLabelIconWeight.setFont(new Font("Tahoma", 2, 11));
    jLabelIconWeight.setForeground(Color.gray);
    dataPanel.add(jLabelIconWeight, null);
    dataPanel.add(labelIdartif, null);
    dataPanel.add(mIdartif, null);
    dataPanel.add(labelDescrip, null);
    dataPanel.add(mDescrip, null);
    dataPanel.add(labelPesunit, null);
    dataPanel.add(mPesunit, null);
    dataPanel.add(labelFecultmodpes, null);
    dataPanel.add(mFecultmodpes, null);
    dataPanel.add(labelModpesby, null);
    dataPanel.add(mModpesby, null);
    dataPanel.add(labelCantot, null);
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(15);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(15);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mPesunit.setDocument((Document)panelBinding.bindUIControl("Pesunit", mPesunit));
    labelPesunit.setLabelFor(mPesunit);
    mPesunit.setColumns(15);
    labelPesunit.setText("Pes unitari mestre d\'artícles");
    mPesunit.setToolTipText(panelBinding.findCtrlValueBinding("Pesunit").getTooltip());
    mFecultmodpes.setDocument((Document)panelBinding.bindUIControl("Fecultmodpes", mFecultmodpes));
    dataPanel.add(mCantot, null);
    dataPanel.add(labelUniemb, null);
    dataPanel.add(mUniemb, null);
    dataPanel.add(labelIdmac1, null);
    dataPanel.add(mIdmac1, null);
    dataPanel.add(labelTaraTeoric, null);
    labelFecultmodpes.setLabelFor(mFecultmodpes);
    mFecultmodpes.setColumns(15);
    labelFecultmodpes.setText(panelBinding.findCtrlValueBinding("Fecultmodpes").getLabel());
    mFecultmodpes.setToolTipText(panelBinding.findCtrlValueBinding("Fecultmodpes").getTooltip());
    mModpesby.setDocument((Document)panelBinding.bindUIControl("Modpesby", mModpesby));
    labelModpesby.setLabelFor(mModpesby);
    mModpesby.setColumns(15);
    labelModpesby.setText(panelBinding.findCtrlValueBinding("Modpesby").getLabel());
    mModpesby.setToolTipText(panelBinding.findCtrlValueBinding("Modpesby").getTooltip());
    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(15);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());
    mUniemb.setDocument((Document)panelBinding.bindUIControl("Uniemb", mUniemb));
    labelUniemb.setLabelFor(mUniemb);
    mUniemb.setColumns(15);
    labelUniemb.setText(panelBinding.findCtrlValueBinding("Uniemb").getLabel());
    mUniemb.setToolTipText(panelBinding.findCtrlValueBinding("Uniemb").getTooltip());
    dataPanel.add(mTaraTeoric, null);
    dataPanel.add(labelTaraReal, null);
    dataPanel.add(mTaraReal, null);
    dataPanel.add(labelDescrip1, null);
    dataPanel.add(mDescrip1, null);
    dataPanel.add(labelPesActual, null);
    mIdmac1.setDocument((Document)panelBinding.bindUIControl("Idmac1", mIdmac1));
    labelIdmac1.setLabelFor(mIdmac1);
    mIdmac1.setColumns(15);
    labelIdmac1.setText(panelBinding.findCtrlValueBinding("Idmac1").getLabel());
    mIdmac1.setToolTipText(panelBinding.findCtrlValueBinding("Idmac1").getTooltip());
    mTaraTeoric.setDocument((Document)panelBinding.bindUIControl("TaraTeoric", mTaraTeoric));
    labelTaraTeoric.setLabelFor(mTaraTeoric);
    mTaraTeoric.setColumns(15);
    labelTaraTeoric.setText(panelBinding.findCtrlValueBinding("TaraTeoric").getLabel());
    mTaraTeoric.setToolTipText(panelBinding.findCtrlValueBinding("TaraTeoric").getTooltip());
    mTaraReal.setDocument((Document)panelBinding.bindUIControl("TaraReal", mTaraReal));
    dataPanel.add(mPesActual, null);
    dataPanel.add(labelPesUnitariReal, null);
    dataPanel.add(mPesUnitariReal, null);
    labelTaraReal.setLabelFor(mTaraReal);
    mTaraReal.setColumns(15);
    labelTaraReal.setText(panelBinding.findCtrlValueBinding("TaraReal").getLabel());
    mTaraReal.setToolTipText(panelBinding.findCtrlValueBinding("TaraReal").getTooltip());
    mDescrip1.setDocument((Document)panelBinding.bindUIControl("Descrip1", mDescrip1));
    labelDescrip1.setLabelFor(mDescrip1);
    mDescrip1.setColumns(15);
    labelDescrip1.setText(panelBinding.findCtrlValueBinding("Descrip1").getLabel());
    mDescrip1.setToolTipText(panelBinding.findCtrlValueBinding("Descrip1").getTooltip());
    mPesActual.setDocument((Document)panelBinding.bindUIControl("PesActual", mPesActual));
    labelPesActual.setLabelFor(mPesActual);
    mPesActual.setColumns(9);
    labelPesActual.setText(panelBinding.findCtrlValueBinding("PesActual").getLabel());
    mPesActual.setToolTipText(panelBinding.findCtrlValueBinding("PesActual").getTooltip());
    mPesUnitariReal.setDocument((Document)panelBinding.bindUIControl("PesUnitariReal", mPesUnitariReal));
    labelPesUnitariReal.setLabelFor(mPesUnitariReal);
    mPesUnitariReal.setColumns(15);
    labelPesUnitariReal.setText(panelBinding.findCtrlValueBinding("PesUnitariReal").getLabel());

    // Layout the datapanel and the navigation bar
    mPesUnitariReal.setToolTipText(panelBinding.findCtrlValueBinding("PesUnitariReal").getTooltip());
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

    PanelSgavarticulomodpesView panel = new PanelSgavarticulomodpesView();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(600, 400)));
    panel.setWhereClauseMac("100000010273");
    panel.revalidate();
    panel.setPesActual("10000");
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
      // Michael - para que no ejecute el query
      DCIteratorBinding ib = getIteratorBinding();
      if (ib != null)
        ib.setFindMode(true);
        
      panelBinding.refreshControl();
      try
      {
        //Afegit xavi / Michael 30.11.2005
        setPanelBinding(panelBinding);
        // Fi afegit xavi
        jbInit();
        panelBinding.refreshControl();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }

  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

  private void jButtonAcceptar_actionPerformed(ActionEvent e)
  {
  try 
  {
    SgavarticulomodpesViewRow artRow = (SgavarticulomodpesViewRow)panelBinding.findIteratorBinding(iterBinding).getCurrentRow();
    artRow.setPesunit(artRow.getPesUnitariReal());
    panelBinding.getApplication().getApplicationModule().getTransaction().commit();
    // TODO Close this panel here    
  } catch (Exception ex) 
  {
      JUMetaObjectManager.reportException(null, ex);   
      panelBinding.getApplication().getApplicationModule().getTransaction().rollback();    
  } 
  }
  
  private DCIteratorBinding getIteratorBinding()
  {
    return panelBinding.findIteratorBinding(iterBinding);
  }
  
  private void setWhereClauseMac(String idMac)
  {
    try
    {
      DCIteratorBinding ib = getIteratorBinding();
      ib.setFindMode(false);
      ViewObject vo = ib.getViewObject();
      vo.setWhereClause(null);
      vo.clearCache();
      vo.setWhereClause("Sgamac.idMac = '" + idMac + "'");
      vo.reset();
      vo.executeQuery();
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  private void setPesActual(String pesActual)
  {
    mPesActual.setText(pesActual);
    mPesActual.postActionEvent();
    mPesActual.setEditable(false);
    mPesUnitariReal.setEditable(false);
    mPesunit.setEditable(false);
  }

  private void setPesUnitari()
  {
    ViewObject vo = getIteratorBinding().getViewObject();
    SgavarticulomodpesViewRow row = (SgavarticulomodpesViewRow)vo.getCurrentRow();
    row.setPesunit(row.getPesUnitariReal());
    vo.getApplicationModule().getTransaction().commit();
  }
  

  
  private String isOkSetPesUnitari()
  {
    ViewObject vo = getIteratorBinding().getViewObject();
    SgavarticulomodpesViewRow row = (SgavarticulomodpesViewRow)vo.getCurrentRow();
    return row.isOkSetPesUnitari();
  }
  
  public void rollback()
  {
    try
    {
    getPanelBinding().getApplication().getApplicationModule().getTransaction().rollback();      
    }
    catch (Exception e)
    {
      // dont care
    }
  }
  
  /**
   * Enseñar el panel de modificar el peso y actuar sobre la elección del usuario
   * Se hace un commit si todo va bien
   * @param pesini
   * @param pesfin
   * @param mac
   * @return true si se ha realizado una modificación de peso, false si no
   */
  public boolean modPesUnitari(String pesini, String pesfin, String mac)
  {
    boolean exito = false;
    try
    {
    String pesActual = (pesfin == null || pesfin.length() == 0) ? pesini : pesfin;
    if (pesActual == null || pesActual.length() == 0)
    {
      JOptionPane.showMessageDialog(Interflex.getInstance(),
        SgaRecursos.getInstance().getString("ControlPes.noRegistrat"),
        SgaRecursos.getInstance().getString("ControlPes.registrarPesTitol"),
        JOptionPane.WARNING_MESSAGE);
        return false;
    }

    setWhereClauseMac(mac);
    revalidate();
    setPesActual(pesActual);
      
    
    String errorMsg = isOkSetPesUnitari();
    if (errorMsg != null)
    {
      JOptionPane.showMessageDialog(Interflex.getInstance(),
        errorMsg,
        SgaRecursos.getInstance().getString("ControlPes.registrarPesTitol"),
        JOptionPane.WARNING_MESSAGE);
    }
    else
    {
  
      SgaRecursos r = SgaRecursos.getInstance();
      String[] options = {r.getString("Options.aceptar_label"), r.getString("Options.cancelar_label")};
      int result = JOptionPane.showOptionDialog(
          Interflex.getInstance(),                                       // the parent that the dialog blocks
          this,                                         // Panel to show
          SgaRecursos.getInstance().getString("ControlPes.registrarPesMestre"), // the title of the dialog window
          JOptionPane.DEFAULT_OPTION,                 // option type
          JOptionPane.PLAIN_MESSAGE,            // message type
          null,                                       // optional icon, use null to use the default icon
          options,                                    // options string array, will be made into buttons
          null                                        // option that should be made into a default button
      );
      System.out.println("Result: " + result);    
      if (result == 0)
      {
        // Aceptado
        setPesUnitari();
        exito = true;
      }
    }
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
      rollback();
    }
    return exito;
    }


  /**
   * Enseñar diálogo para <i>continuar / modificar el peso / cancelar la operación</i> al usuario y devolver el resultado
   * @return <l>
   *  <li>0: Continuar sin modificar el peso</li>
   *  <li>1: Modificar el peso</li>
   *  <li>2: Cancelar</li>
   *  </l>
   * @param canCon
   * @param difPes
   */
  public static int getUserActionModPes(AppModule am, String difPes, String canCon)
  {
      boolean canModPes = am.isUserModPes();
      Object [] options;
      if (canModPes)
      {
        // Añadir boton de modificar el peso unitario si el usuario tiene privilegio
        Object [] optionsPes = {SgaRecursos.getInstance().getString("ControlPes.botoContinuarPes_label"), 
          SgaRecursos.getInstance().getString("ControlPes.botoModPesUnit_label"),
          SgaRecursos.getInstance().getString("ControlPes.botoCancelarPes_label"),
          };
        options = optionsPes;
      }
      else
      {
        Object [] optionsSinPes = {SgaRecursos.getInstance().getString("ControlPes.botoContinuarPes_label"), 
          SgaRecursos.getInstance().getString("ControlPes.botoCancelarPes_label"),
          };
        options = optionsSinPes;
      }
      int action = JOptionPane.showOptionDialog(Interflex.getInstance().getFrame(), 
          "<html><p>"
          + SgaRecursos.getInstance().getString("ControlPes.verificarPes1_label") + "<em><b>" + difPes + " " + "</em></b></p><p>" +
          SgaRecursos.getInstance().getString("ControlPes.verificarPes2_label") + "<em><b>" + canCon + "</em></b></p></html>", 
          SgaRecursos.getInstance().getString("ControlPes.verificarPes_title") , 
          JOptionPane.YES_NO_OPTION, 
          JOptionPane.QUESTION_MESSAGE, null, options, options[(1)]);
          
       // Chapuza por no confundir <cancelar> con <modpes> más abajo
       if (!canModPes && action == 1)
        action = 2;
       
       return action;
  }
 

}