package es.sysmap.interflex.controltest;
import es.sysmap.interflex.gestortelegrama.GestorDatos;
import es.sysmap.interflex.model.bdc.SgamacImpl;
import es.sysmap.interflex.model.dmc.SgamacViewRowImpl;
import es.sysmap.interflex.model.dmc.SgaubicacionViewRowImpl;
import es.sysmap.interflex.model.dmc.common.SgamacViewRow;
import es.sysmap.interflex.model.dmc.common.SgaubicacionViewRow;
import es.sysmap.xml.XMLHelper;
import es.sysmap.xml.XMLTelegrama;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import oracle.xml.parser.v2.XMLDocument;
import sgalib.SgaRunPanel;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSgamacView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgamacView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Contenidor

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Multireferencia

  private JLabel labelMultiref = new JLabel();
  private JCheckBox mMultiref = new JCheckBox();

// Fields for attribute:  Tipus Contenidor

  private JLabel labelIdtipmac = new JLabel();
  private JComboBox mIdtipmac = new JComboBox();

// Fields for attribute:  Estat

  private JLabel labelEstado = new JLabel();
  private JComboBox mEstado = new JComboBox();

// Fields for attribute:  Ubicació actual

  private JLabel labelUbipos = new JLabel();
  private JTextField mUbipos = new JTextField();

// Fields for attribute:  Posició actual

  private JLabel labelPosubipos = new JLabel();
  private JTextField mPosubipos = new JTextField();

// Fields for attribute:  Ubicació desti

  private JLabel labelUbides = new JLabel();
  private JTextField mUbides = new JTextField();

// Fields for attribute:  Posició destí

  private JLabel labelPosubides = new JLabel();
  private JTextField mPosubides = new JTextField();
  private JButton jButtonSacarMac = new JButton();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgamacView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(panelLayout);
    dataPanel.setMinimumSize(new Dimension(400, 253));
    dataPanel.setPreferredSize(new Dimension(400, 253));
    dataPanel.setMaximumSize(new Dimension(400, 253));
    navBar.setPreferredSize(new Dimension(400, 26));
    navBar.setMinimumSize(new Dimension(400, 26));
    navBar.setMaximumSize(new Dimension(400, 26));
    this.setLayout(borderLayout);
    this.setPreferredSize(new Dimension(400, 300));
    this.setMinimumSize(new Dimension(400, 300));
    this.setMaximumSize(new Dimension(400, 300));
    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    jButtonSacarMac.setText("Treure Contenidor");
    jButtonSacarMac.setToolTipText("Treure el contenidor del magatzem");
    jButtonSacarMac.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonSacarMac_actionPerformed(e);
        }
      });
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(10);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());
    mMultiref.setModel((ButtonModel)panelBinding.bindUIControl("Multiref1", mMultiref));
    dataPanel.add(labelMultiref, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mMultiref, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelMultiref.setLabelFor(mMultiref);
    labelMultiref.setText(panelBinding.findCtrlValueBinding("Multiref").getLabel());
    mMultiref.setToolTipText(panelBinding.findCtrlValueBinding("Multiref").getTooltip());
    mIdtipmac.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipmac", mIdtipmac));
    dataPanel.add(labelIdtipmac, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipmac, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipmac.setLabelFor(mIdtipmac);
    mIdtipmac.setEditable(false);
    labelIdtipmac.setText(panelBinding.findCtrlValueBinding("Idtipmac").getLabel());
    mIdtipmac.setToolTipText(panelBinding.findCtrlValueBinding("Idtipmac").getTooltip());
    mEstado.setModel((ComboBoxModel)panelBinding.bindUIControl("Descestado", mEstado));
    dataPanel.add(labelEstado, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mEstado, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelEstado.setLabelFor(mEstado);
    mEstado.setEditable(false);
    labelEstado.setText(panelBinding.findCtrlValueBinding("Estado").getLabel());
    mEstado.setToolTipText(panelBinding.findCtrlValueBinding("Estado").getTooltip());
    mUbipos.setDocument((Document)panelBinding.bindUIControl("Ubipos", mUbipos));
    dataPanel.add(labelUbipos, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUbipos, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelUbipos.setLabelFor(mUbipos);
    mUbipos.setColumns(10);
    labelUbipos.setText(panelBinding.findCtrlValueBinding("Ubipos").getLabel());
    mUbipos.setToolTipText(panelBinding.findCtrlValueBinding("Ubipos").getTooltip());
    mPosubipos.setDocument((Document)panelBinding.bindUIControl("Posubipos", mPosubipos));
    dataPanel.add(labelPosubipos, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPosubipos, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelPosubipos.setLabelFor(mPosubipos);
    mPosubipos.setColumns(5);
    labelPosubipos.setText(panelBinding.findCtrlValueBinding("Posubipos").getLabel());
    mPosubipos.setToolTipText(panelBinding.findCtrlValueBinding("Posubipos").getTooltip());
    mUbides.setDocument((Document)panelBinding.bindUIControl("Ubides", mUbides));
    dataPanel.add(labelUbides, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUbides, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    labelUbides.setLabelFor(mUbides);
    mUbides.setColumns(10);
    labelUbides.setText(panelBinding.findCtrlValueBinding("Ubides").getLabel());
    mUbides.setToolTipText(panelBinding.findCtrlValueBinding("Ubides").getTooltip());
    mPosubides.setDocument((Document)panelBinding.bindUIControl("Posubides", mPosubides));
    dataPanel.add(labelPosubides, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPosubides, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(jButtonSacarMac, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelPosubides.setLabelFor(mPosubides);
    mPosubides.setColumns(5);
    labelPosubides.setText(panelBinding.findCtrlValueBinding("Posubides").getLabel());
    mPosubides.setToolTipText(panelBinding.findCtrlValueBinding("Posubides").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgamacView1", null, "SgamacView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);

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

    PanelSgamacView1 panel = new PanelSgamacView1();
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
  
  static SgaRunPanel runPanel()
  {
      SgaRunPanel _runPanel = null;

      PanelSgamacView1 panel = new PanelSgamacView1();
      _runPanel = SgaRunPanel.startRunPanel("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300));
      panel.setBindingContext(_runPanel.getBindingContext());
      panel.revalidate();
      return _runPanel;
  }

  private void jButtonSacarMac_actionPerformed(ActionEvent e)
  {
    SgamacViewRow macrow = (SgamacViewRow)panelBinding.findIteratorBinding("SgamacView1Iter").getCurrentRow(); 
    String idMac = macrow.getIdmac();
    if (idMac.equals(""))
      {
        JOptionPane.showMessageDialog(null, "S'ha de triar un contenidor...", "Aviso..", JOptionPane.WARNING_MESSAGE);
        return;
      }

    boolean silo = !macrow.getIdtipmac().equals("CUB");
    
      
    Object []      message = new Object[6];
    message [0] = "Triar desti del contenidor: " + idMac;
    message [1] = " ";  // Para que haya un hueco
    JComboBox cb = new JComboBox();
    JTextField jTextTraslo = new JTextField("1");
  
    if (!silo)
    {
      cb.addItem("PK1MLD"); 
      cb.addItem("PK2MLD");
    }
    else
    {
    cb.addItem("PK1SLO");
    cb.addItem("PK2SLO");
    cb.addItem("PKEXTR");
    }

    message [2] = cb;
    if (silo)
    {
      message [3] = "Traslo";
      message [4] = jTextTraslo;
      message [5] = "";
    }
    else
    {
      
    }
    

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
      ApplicationModule am = getPanelBinding().getApplication().getApplicationModule();
      ViewObject vo = am.findViewObject("SgaubicacionView1");
      vo.setWhereClause("idUbi = '" + desti + "'");
      vo.executeQuery();
      assert !vo.hasNext();
      
      // Bad stuff this....
      SgaubicacionViewRowImpl row = (SgaubicacionViewRowImpl)vo.first();
      vo.setWhereClause(null);
      
      vo = am.findViewObject("SgamacView1");
      vo.setWhereClause("idMac = '" + mIdmac.getText() + "'");
      vo.executeQuery();
      assert !vo.hasNext();
     
      // Gets worse
      SgamacViewRowImpl macRow = (SgamacViewRowImpl)vo.first();
      vo.setWhereClause(null);
      SgamacImpl mac = macRow.getSgamac();
      
      int traslo = 0;
      if (silo)
      {
        traslo = Integer.parseInt(jTextTraslo.getText());
      }
        
      if (mac.quizasReservarMacSalida(row.getSgaubicacion().getIdubi(), traslo))
      {
        JOptionPane.showConfirmDialog(null, "Hows that");
        // Recuperar el XML del telegrama
        XMLDocument xmldoc = XMLTelegrama.parseXML("MOVI");
        xmldoc = mac.getXMLMovi(xmldoc, 0);
        JOptionPane.showMessageDialog(null,
          "XML String: " + XMLHelper.toString(xmldoc));
      }
      else
        JOptionPane.showConfirmDialog(null, "Failed again");
    }
  }
}