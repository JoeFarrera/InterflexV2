package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.ButtonModel;
import sgalib.CustomLOVPanel;
import sgalib.SearchFieldLov;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;
import sgalib.JUpperCaseTextField;


public class PanelSgaTestEntradaView1 extends SgaJUPanel implements JUPanel 
// public class PanelSgaTestEntradaView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaTestEntradaView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();
  
  private JPanel lovPanel = new JPanel();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JUpperCaseTextField mIdartif = new JUpperCaseTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();

// Fields for attribute:  Quantitat

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();
  private JButton buttonLov = new JButton();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaTestEntradaView1()
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
    dataPanel.setMinimumSize(new Dimension(500, 170));
    dataPanel.setPreferredSize(new Dimension(500, 170));
    dataPanel.setMaximumSize(new Dimension(500, 170));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(500, 170));
    this.setPreferredSize(new Dimension(500, 170));
    this.setMinimumSize(new Dimension(500, 170));
    this.setMaximumSize(new Dimension(500, 170));
    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    mCantot.addFocusListener(new FocusAdapter()
      {
        public void focusGained(FocusEvent e)
        {
          mCantot_focusGained(e);
        }
      });
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    lovPanel.add(mIdartif);
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(10);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());

    buttonLov.setModel((ButtonModel)panelBinding.bindUIControl("Idartif1", buttonLov));
    buttonLov.setText(SgaRecursos.getInstance().getString("ArticlesLov.boto_label"));
    buttonLov.setToolTipText(SgaRecursos.getInstance().getString("ArticlesLov.boto_tooltip"));
    lovPanel.add(buttonLov);
      
    dataPanel.add(lovPanel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));    
    
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(30);
    labelDescrip.setText(panelBinding.findCtrlValueBinding("Descrip").getLabel());
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    mDescrip.setEditable(false);
    mDescrip.setFocusable(false);

    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    dataPanel.add(labelCantot, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantot, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(6);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());

    // Layout the datapanel and the navigation bar
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());
    add(dataPanel, BorderLayout.CENTER);
    
    // Afegeix el quadre de texte de busqueda
    ((CustomLOVPanel)((JULovButtonBinding) panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setAddSearch(true);
    
    // Indica que ha de realitzar la busqueda per la segona columna (per defecte es la primera, la 0) 
    ((SearchFieldLov)((JULovButtonBinding)panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setSearchColumn(1);
    
    // Estableix el titol de la llista de valors
    ((CustomLOVPanel)((JULovButtonBinding) panelBinding.getControlBinding(buttonLov)).getLovPanelInterface()).setTitleString(SgaRecursos.getInstance().getString("ArticlesLov.boto_title"));
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

    PanelSgaTestEntradaView1 panel = new PanelSgaTestEntradaView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
    panel.crearTestEntrada();
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


  private void mCantot_focusGained(FocusEvent e)
  {
    mCantot.selectAll();
  }
  
  public void crearTestEntrada()
  {
    RowSetIterator rsi = panelBinding.findIteratorBinding("SgaTestEntradaView1Iter").getRowSetIterator();
    rsi.insertRow(rsi.createRow());
  }
  
  public String getIdart()
  {
    return (String)panelBinding.findIteratorBinding("SgaTestEntradaView1Iter").getCurrentRow().getAttribute("Idart");
  }

  public Number getCantot()
  {
    return (Number)panelBinding.findIteratorBinding("SgaTestEntradaView1Iter").getCurrentRow().getAttribute("Cantot");
  }
  
}