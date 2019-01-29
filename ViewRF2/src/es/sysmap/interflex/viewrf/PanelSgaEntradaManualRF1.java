package es.sysmap.interflex.viewrf;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaEntradaManualRFRow;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.JboContext;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import javax.swing.JButton;
import oracle.jdeveloper.layout.XYLayout;
import oracle.jdeveloper.layout.XYConstraints;
import sgalib.JUpperCaseTextField;
import sgalib.SgaRecursos;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.PlainDocument;
import javax.swing.JCheckBox;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;

public class PanelSgaEntradaManualRF1 extends JPanel implements JUPanel
{
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaEntradaManualRF1UIModel");
  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();
  private XYLayout xYLayout1 = new XYLayout();
  private JLabel labelEtiqueta = new JLabel();
  private JUpperCaseTextField mEtiqueta = new JUpperCaseTextField();
  private JLabel labelPasCol = new JLabel();
  private JTextField mPasCol = new JTextField();
  private JButton confirmar = new JButton("Acc.");
  private JButton cancelar = new JButton("Can.");
  private Icon confirmIcon = SgaRecursos.createImageIcon(getClass(), "48x48/plain/check.png", null);
  private Icon cancelIcon = SgaRecursos.createImageIcon(getClass(), "48x48/plain/delete.png", null);
  private JCheckBox bloquejada = new JCheckBox();
  private JCheckBox trasllat = new JCheckBox();
  private JLabel labelEspecial = new JLabel();
  private JComboBox jComboBox1 = new JComboBox();
  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaEntradaManualRF1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    dataPanel.setLayout(xYLayout1);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    trasllat.setFont(new Font("Tahoma", 1, 13));
    labelEspecial.setText("Especial");
    labelEspecial.setToolTipText("Especia (Galvanitzat etc.)");
    labelEspecial.setFont(new Font("Tahoma", 1, 13));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(232, 188));

    labelEtiqueta.setLabelFor(mEtiqueta);
    labelEtiqueta.setFont(new Font("Tahoma", 0, 16));
    labelEtiqueta.setText("Etiqueta");
    bloquejada.setText("Bloquejada");
    bloquejada.setToolTipText("Deixar la existència bloquejada");
    bloquejada.setActionCommand("Bloquejar");
    bloquejada.setFont(new Font("Tahoma", 1, 13));
    dataPanel.add(jComboBox1, new XYConstraints(150, 40, 60, 25));
    dataPanel.add(labelEspecial, new XYConstraints(150, 20, 75, 15));
    dataPanel.add(bloquejada, new XYConstraints(15, 15, 115, 25));
    dataPanel.add(trasllat, new XYConstraints(15, 40, 115, 25));
    trasllat.setText("Trasllat");
    trasllat.setToolTipText("Trasllat de material");
    trasllat.setActionCommand("Trasllat");
    trasllat.setFont(new Font("Tahoma", 1, 13));
    dataPanel.add(labelEtiqueta, new XYConstraints(15, 75, 155, 20));
    dataPanel.add(mEtiqueta, new XYConstraints(80, 70, 135, 30));
    dataPanel.add(labelPasCol, new XYConstraints(15, 110, 75, 20));
    dataPanel.add(mPasCol, new XYConstraints(80, 105, 75, 30));

    mEtiqueta.setFont(new Font("Calibri", 0, 18));
    mEtiqueta.setColumns(12);
    mEtiqueta.setToolTipText(panelBinding.findCtrlValueBinding("Etiqueta").getTooltip());
    mEtiqueta.setDocument((Document)panelBinding.bindUIControl("Etiqueta", mEtiqueta));

    mEtiqueta.addFocusListener(new FocusListener() 
    {
      public void focusGained(FocusEvent e) 
      {
      }

      public void focusLost(FocusEvent e) {
        if (mEtiqueta.getText() != null && mEtiqueta.getText().length() > 0)
        {
          SgaEntradaManualRFRow row = (SgaEntradaManualRFRow)panelBinding.findIteratorBinding("SgaEntradaManualRF1Iter").getRowSetIterator().getCurrentRow();
          try {
              row.validateEtiqueta();  // TODO: Trasllat??
          }
          catch (oracle.jbo.JboException ex) 
          {
            panelBinding.reportException(ex);
            initPanel();
          }
        }
      }
    }
    );

    labelPasCol.setLabelFor(mPasCol);
    labelPasCol.setFont(new Font("Tahoma", 0, 16));
    labelPasCol.setText("Ubicació");

    mPasCol.setFont(new Font("Calibri", 0, 18));
    mPasCol.setColumns(15);
    mPasCol.setToolTipText(panelBinding.findCtrlValueBinding("PasCol").getTooltip());
    mPasCol.setDocument((Document)panelBinding.bindUIControl("PasCol", mPasCol));
    dataPanel.add(confirmar, new XYConstraints(125, 145, 90, 30));
    dataPanel.add(cancelar, new XYConstraints(10, 145, 90, 30));

    mPasCol.addFocusListener(new FocusListener() 
    {
      public void focusGained(FocusEvent e) 
      {
      }

      public void focusLost(FocusEvent e) {
        if (mPasCol.getText() != null && mPasCol.getText().length() > 0)
        {
          SgaEntradaManualRFRow row = (SgaEntradaManualRFRow)panelBinding.findIteratorBinding("SgaEntradaManualRF1Iter").getRowSetIterator().getCurrentRow();
          try {
            row.confirmarEntrada2();
          }
          catch (oracle.jbo.JboException ex) 
          {
            panelBinding.reportException(ex);
            panelBinding.getApplication().getRootApplication().rollbackTransaction();
          }
          initPanel();
        }
      }
    }
    );

    confirmar.setFont(new Font("Tahoma", 0, 16));
    confirmar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          confirmar_actionPerformed(e);
        }
      });

    cancelar.setFont(new Font("Tahoma", 0, 16));
    cancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cancelar_actionPerformed(e);
        }
      });

    this.add(dataPanel, BorderLayout.CENTER);
    bloquejada.setModel((ButtonModel)panelBinding.bindUIControl("Bloqueo", bloquejada));
    trasllat.setModel((ButtonModel)panelBinding.bindUIControl("Trasllat", trasllat));
    jComboBox1.setModel((ComboBoxModel)panelBinding.bindUIControl("Especial", jComboBox1));
    
  }

  private static void setUIFont(javax.swing.plaf.FontUIResource f)
  {
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements())
    {
        Object key = keys.nextElement();
        Object value = UIManager.get(key);
        if (value instanceof javax.swing.plaf.FontUIResource)
        {
            UIManager.put(key, f);
        }
    }
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

// >>> Jaume 18/05/2016
    String username = System.getProperty("user.name");
    if (username.equals("tstj") || username.equals("jaume"))
      username = "root";
    else if (username.length() > 10)
      username = username.substring(0, 10);
      
      
// <<< Jaume 18/05/2016

    PanelSgaEntradaManualRF1 panel = new PanelSgaEntradaManualRF1();
    panel.setName("SGA - Ràdio Freqüència - Entrada Magatzem");
    panel.setBindingContext(RFFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl1", panel, panel.getPanelBinding(), new Dimension(240, 320)));

    if (!panel.checkUsername(username))
    {
      JOptionPane.showMessageDialog(null, SgaRecursos.getInstance().getString("Login.error_message"), 
        SgaRecursos.getInstance().getString("Login.error_title"), JOptionPane.WARNING_MESSAGE);
        System.exit(1);
    }

    panel.revalidate();
    
    Hashtable h = panel.getPanelBinding().getApplication().getApplicationModule().getSession().getEnvironment();
    h.put(JboContext.SECURITY_PRINCIPAL, username); 
    panel.initPanel();
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
  
  private void initPanel () 
  {
    RowSetIterator rsi = panelBinding.findIteratorBinding("SgaEntradaManualRF1Iter").getRowSetIterator();
    if (rsi.getCurrentRow() != null)
      rsi.removeCurrentRow();
    rsi.insertRow(rsi.createRow());
    mEtiqueta.requestFocusInWindow();
  }

  private void confirmar_actionPerformed(ActionEvent e)
  {
    SgaEntradaManualRFRow row = (SgaEntradaManualRFRow)panelBinding.findIteratorBinding("SgaEntradaManualRF1Iter").getRowSetIterator().getCurrentRow();    
    try 
    {
      row.confirmarEntrada2();
    }
    catch (oracle.jbo.JboException ex) 
    {
      panelBinding.reportException(ex);
      initPanel();
    }
    initPanel();
  }

  private void cancelar_actionPerformed(ActionEvent e)
  {
    initPanel();
  }

  public boolean checkUsername(String user)
  {
    AppModule appModule = (AppModule)getPanelBinding().getApplication().getApplicationModule();
    if (appModule.checkUsername(user))
    {
      return true;
    }
    return false;
  }
}