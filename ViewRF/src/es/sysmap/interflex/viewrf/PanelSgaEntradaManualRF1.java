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
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonModel;

public class PanelSgaEntradaManualRF1 extends JPanel implements JUPanel
{
  private static final java.text.SimpleDateFormat timestampFormat = new java.text.SimpleDateFormat("HH:mm:ss");

  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaEntradaManualRF1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();
  
  private Icon confirmIcon = SgaRecursos.createImageIcon(getClass(), "48x48/plain/check.png", null);
  private Icon cancelIcon = SgaRecursos.createImageIcon(getClass(), "48x48/plain/delete.png", null);
// Layout used by panel

// Fields for attribute:  Etiqueta

  private JLabel labelEtiqueta = new JLabel();
  private JUpperCaseTextField mEtiqueta = new JUpperCaseTextField();

// Fields for attribute:  PasCol

  private JLabel labelPasCol = new JLabel();
  private JTextField mPasCol = new JTextField();

// Fields for attribute:  Nivell

  private JLabel labelNivell = new JLabel();
  private JTextField mNivell = new JTextField();

// Jaume 02/04/2016 >>>
  private JTextField mPosicio = new JTextField();
  private JLabel labelPosicio = new JLabel();
// <<< Jaume 02/04/2016

// Fields for attribute:  Cantot

// Fields for attribute:  Descripció

  private JTextArea mDescrip = new JTextArea();
  private JScrollPane scrollerDescrip = new JScrollPane();

// Fields for attribute:  Idcabnum

  private JLabel labelIdcabnum = new JLabel();
  private JTextField mIdcabnum = new JTextField();

// Fields for attribute:  Idcabstr

  private JTextField mIdcabstr = new JTextField();

// Fields for attribute:  Idlin

  private JTextField mIdlin = new JTextField();

// Fields for attribute:  Canpen

  private JLabel labelCanpen = new JLabel();
  private JTextField mCanpen = new JTextField();

// Fields for attribute:  Idbulto

  private JLabel labelIdbulto = new JLabel();
  private JTextField mIdbulto = new JTextField();

  private JButton confirmar = new JButton("Desar", confirmIcon);
  private JButton cancelar = new JButton("Cancel", cancelIcon);
  
  private JCheckBox trasllat = new JCheckBox("Trasllat");
  


  private XYLayout xYLayout1 = new XYLayout();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTable messageTable = new JTable();
  private Object[] headers = new Object[] {"Hora", "Missatje proces"};
  private int[] sizeHeaders = new int[] {20, 300};
  private DefaultTableModel dataModel = new DefaultTableModel(headers, 0);
  private JTabbedPane jTabbedPane1 = new JTabbedPane();

  // private JTabbedPane jTabbedPane2 = new JTabbedPane();

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
    // Layout definition for this panel
    dataPanel.setLayout(xYLayout1);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(628, 409));

    
    mEtiqueta.setDocument((Document)panelBinding.bindUIControl("Etiqueta", mEtiqueta));
    mEtiqueta.setFont(new Font("Calibri", 0, 18));
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
            row.validateEtiqueta();
            displayMessage(row.toStringEtiqueta());
          }
          catch (oracle.jbo.JboException ex) 
          {
            panelBinding.reportException(ex);
            displayMessage(row.toStringEtiqueta() + " no válida");
            initPanel();
          }
        }
      }
//    public void displayMessage(String message, FocusEvent e) {
//       System.out.println (message + e);
//  }
    }
    );
 

    mPasCol.setFont(new Font("Calibri", 0, 18));
    mNivell.setFont(new Font("Calibri", 0, 18));
// Jaume 02/04/2016 >>>
    mPosicio.setFont(new Font("Calibri", 0, 18));
// <<< Jaume 02/04/2016

    mDescrip.setEditable(false);
    mDescrip.setEnabled(false);
    confirmar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          confirmar_actionPerformed(e);
        }
      });
    cancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          cancelar_actionPerformed(e);
        }
      });

    dataPanel.add(trasllat, new XYConstraints(205, 5, 115, 15));
 
    dataPanel.add(labelEtiqueta, new XYConstraints(20, 35, 155, 15));
    dataPanel.add(mEtiqueta, new XYConstraints(205, 30, 135, 30));
    
    
    dataPanel.add(labelPasCol, new XYConstraints(35, 70, 140, 15));
    dataPanel.add(mPasCol, new XYConstraints(205, 70, 75, 30));
    dataPanel.add(labelNivell, new XYConstraints(135, 110, 40, 15));
    dataPanel.add(mNivell, new XYConstraints(205, 110, 40, 30));
// Jaume 02/04/2016 >>>
    dataPanel.add(mPosicio, new XYConstraints(300, 110, 40, 30));
    dataPanel.add(labelPosicio, new XYConstraints(370, 110, 50, 15));
// <<< Jaume 02/04/2016
    dataPanel.add(cancelar, new XYConstraints(20, 150, 155, 50));
    dataPanel.add(confirmar, new XYConstraints(205, 150, 175, 50));

    scrollerDescrip.getViewport().add(mDescrip, null);
    dataPanel.add(scrollerDescrip, new XYConstraints(20, 215, 515, 40));
    jScrollPane1.getViewport().add(messageTable, null);
    dataPanel.add(jScrollPane1, new XYConstraints(20, 270, 515, 90));


    jTabbedPane1.add("Entrades", dataPanel);
    this.add(jTabbedPane1, BorderLayout.CENTER);

    labelEtiqueta.setLabelFor(mEtiqueta);
    mEtiqueta.setColumns(12);
    labelEtiqueta.setText(panelBinding.findCtrlValueBinding("Etiqueta").getLabel());
    mEtiqueta.setToolTipText(panelBinding.findCtrlValueBinding("Etiqueta").getTooltip());

    mPasCol.setDocument((Document)panelBinding.bindUIControl("PasCol", mPasCol));
    labelPasCol.setLabelFor(mPasCol);
    mPasCol.setColumns(15);
    labelPasCol.setText(panelBinding.findCtrlValueBinding("PasCol").getLabel());
    mPasCol.setToolTipText(panelBinding.findCtrlValueBinding("PasCol").getTooltip());

    mNivell.setDocument((Document)panelBinding.bindUIControl("Nivell", mNivell));
    labelNivell.setLabelFor(mNivell);
    mNivell.setColumns(15);
    labelNivell.setText(panelBinding.findCtrlValueBinding("Nivell").getLabel());
    mNivell.setToolTipText(panelBinding.findCtrlValueBinding("Nivell").getTooltip());

// Jaume 02/04/2016 >>>
    mPosicio.setDocument((Document)panelBinding.bindUIControl("Posicio", mPosicio));
    labelPosicio.setLabelFor(mPosicio);
    mPosicio.setColumns(15);
    labelPosicio.setText(panelBinding.findCtrlValueBinding("Posicio").getLabel());
    mPosicio.setToolTipText(panelBinding.findCtrlValueBinding("Posicio").getTooltip());
// <<< Jaume 02/04/2016

    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    mDescrip.setColumns(30);
    mDescrip.setRows(2);
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());

    mIdcabnum.setDocument((Document)panelBinding.bindUIControl("Idcabnum", mIdcabnum));
    labelIdcabnum.setLabelFor(mIdcabnum);
    mIdcabnum.setColumns(15);
    labelIdcabnum.setText(panelBinding.findCtrlValueBinding("Idcabnum").getLabel());
    mIdcabnum.setToolTipText(panelBinding.findCtrlValueBinding("Idcabnum").getTooltip());

    mIdcabstr.setDocument((Document)panelBinding.bindUIControl("Idcabstr", mIdcabstr));
    mIdcabstr.setColumns(15);
    mIdcabstr.setToolTipText(panelBinding.findCtrlValueBinding("Idcabstr").getTooltip());

    mIdlin.setDocument((Document)panelBinding.bindUIControl("Idlin", mIdlin));
    mIdlin.setColumns(15);
    mIdlin.setToolTipText(panelBinding.findCtrlValueBinding("Idlin").getTooltip());

    mCanpen.setDocument((Document)panelBinding.bindUIControl("Canpen", mCanpen));
    labelCanpen.setLabelFor(mCanpen);
    mCanpen.setColumns(15);
    labelCanpen.setText(panelBinding.findCtrlValueBinding("Canpen").getLabel());
    mCanpen.setToolTipText(panelBinding.findCtrlValueBinding("Canpen").getTooltip());

    mIdbulto.setDocument((Document)panelBinding.bindUIControl("Idbulto", mIdbulto));
    labelIdbulto.setLabelFor(mIdbulto);
    mIdbulto.setColumns(15);
    labelIdbulto.setText(panelBinding.findCtrlValueBinding("Idbulto").getLabel());

    // Layout the datapanel and the navigation bar
    mIdbulto.setToolTipText(panelBinding.findCtrlValueBinding("Idbulto").getTooltip());
    
    messageTable = new JTable(dataModel);
    trasllat.setToolTipText("Seleccionar per confirmar un trasllat de material");
 
    trasllat.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    trasllat.setFont(new Font("Tahoma", 0, 16));
    xYLayout1.setHeight(300);
    xYLayout1.setWidth(473);
    this.setBounds(new Rectangle(0, 0, 628, 409));
    jTabbedPane1.setPreferredSize(new Dimension(540, 409));
    jTabbedPane1.setBounds(new Rectangle(10, 10, 628, 409));
    jTabbedPane1.setFont(new Font("Calibri", 0, 18));

    labelEtiqueta.setFont(new Font("Tahoma", 0, 16));
    labelPasCol.setFont(new Font("Tahoma", 0, 16));
    labelNivell.setFont(new Font("Tahoma", 0, 16));
// Jaume 02/04/2016 >>>
    labelPosicio.setFont(new Font("Tahoma", 0, 16));
// <<< Jaume 02/04/2016
    confirmar.setFont(new Font("Tahoma", 1, 20));
    cancelar.setFont(new Font("Tahoma", 1, 20));

    jScrollPane1.getViewport().add(messageTable, null);
    // Ancho campos de la tabla de mensajes
    for (int i = 0; i < messageTable.getColumnCount(); i++)
    {
      messageTable.getColumn(headers[i]).setPreferredWidth(sizeHeaders[i]);
    }
    
    
      trasllat.setModel((ButtonModel)panelBinding.bindUIControl("Trasllat", trasllat));
 
  }
  

  
  public void addPanelSgavubicacionRF ()
  {
       // Michael 28.11.2017 Add Ubicación panel
    PanelSgavubicacionRF1 panel = new PanelSgavubicacionRF1();
    BindingContext bc = getPanelBinding().getBindingContext();
    System.out.println("got binding context: " + bc.toString());
    
    panel.setBindingContext(bc);
    panel.revalidate();
    jTabbedPane1.add("Consulta ubicacions", panel);

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
  if (username.equals("rf"))
      username = "root";
// <<< Jaume 18/05/2016

    PanelSgaEntradaManualRF1 panel = new PanelSgaEntradaManualRF1();
    panel.setName("SGA - Ràdio Freqüència - Entrada Magatzem");
    panel.setBindingContext(RFFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl1", panel, panel.getPanelBinding(), new Dimension(640, 480)));

 /*

// >>> Jaume 18/05/2016
    if (!panel.checkUsername(username))
    {
      JOptionPane.showMessageDialog(null, SgaRecursos.getInstance().getString("Login.error_message"), 
        SgaRecursos.getInstance().getString("Login.error_title"), JOptionPane.WARNING_MESSAGE);
        System.exit(1);
    }
// <<< Jaume 11/05/2016

    panel.revalidate();
    
    // TODO Michael: See where to put security
    Hashtable h = panel.getPanelBinding().getApplication().getApplicationModule().getSession().getEnvironment();

// >>> Jaume 11/05/2016
    h.put(JboContext.SECURITY_PRINCIPAL, username); 
// <<< Jaume 11/05/2016
    */
    panel.initPanel();

    panel.addPanelSgavubicacionRF();

    // panel.setUIFont (new javax.swing.plaf.FontUIResource(new Font("Tahoma",Font.PLAIN, 18)));
    
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
  
  
  private void disableFields () 
  {
    mDescrip.setEnabled(false);
    mDescrip.setEditable(false);
    mIdcabstr.setEnabled(false);
    mIdcabnum.setEnabled(false);
    mIdbulto.setEnabled(false);
    mIdlin.setEnabled(false);
    mCanpen.setEnabled(false);
  }

  private void initPanel () 
  {
    RowSetIterator rsi = panelBinding.findIteratorBinding("SgaEntradaManualRF1Iter").getRowSetIterator();
    if (rsi.getCurrentRow() != null)
      rsi.removeCurrentRow();
    rsi.insertRow(rsi.createRow());
    
    mEtiqueta.requestFocusInWindow();
    disableFields();
  }

  private void confirmar_actionPerformed(ActionEvent e)
  {
    SgaEntradaManualRFRow row = (SgaEntradaManualRFRow)panelBinding.findIteratorBinding("SgaEntradaManualRF1Iter").getRowSetIterator().getCurrentRow();    
    try 
    {
//    row.validateNivell(mNivell.getText());
      row.confirmarEntrada(mNivell.getText(), mPosicio.getText());
      displayMessage(row.toStringUbicació());
    }
    catch (oracle.jbo.JboException ex) 
    {
      panelBinding.reportException(ex);
      initPanel();
    }
    // TODO: Message panel with entries made
    initPanel();
  }

  private void cancelar_actionPerformed(ActionEvent e)
  {
    initPanel();
  }
  
  private Object [] getArgString(Object arg)
   {
   String mensaje = new String();
    if (arg instanceof Exception)
      {
        Exception e = (Exception)arg;
        mensaje = e.toString();
      }
    else if (arg instanceof String)
      {
        mensaje = (String)arg;
      }
    Object [] str = {timestampFormat.format(new Date()), mensaje };
    return str;
   }
 
  private void displayMessage(Object arg)
  {
    if (dataModel.getRowCount() > 30)
    { 
      for (int i = 0; i < dataModel.getRowCount(); i++) 
      {
        dataModel.removeRow(i);
      }
    }
    dataModel.insertRow(0, getArgString(arg));
  }
  
// >>> Jaume 18/05/2016
  public boolean checkUsername(String user)
  {
    AppModule appModule = (AppModule)getPanelBinding().getApplication().getApplicationModule();
    if (appModule.checkUsername(user))
    {
      return true;
    }
    return false;
  };
// <<< Jaume 18/05/2016

}