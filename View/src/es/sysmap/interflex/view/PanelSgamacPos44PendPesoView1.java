package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.SgamacPos44PendPesoViewRow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.domain.Number;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import org.apache.log4j.Logger;
import sgalib.SgaJUPanel;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import sgalib.SgaRecursos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSgamacPos44PendPesoView1 extends SgaJUPanel 
// public class PanelSgamacPos44PendPesoView1 extends JPanel implements JUPanel 
{

  private boolean operacionPendiente = false;
  private Logger LOG = Logger.getLogger(getClass()); 

  private static PanelSgamacPos44PendPesoView1 _instance = null;
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgamacPos44PendPesoView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Contenidor

  private JLabel labelIdmac = new JLabel();
  private JTextField mIdmac = new JTextField();

// Fields for attribute:  Tipus Contenidor

  private JLabel labelDescriptipomac = new JLabel();
  private JTextField mDescriptipomac = new JTextField();

// Fields for attribute:  Tara

  private JLabel labelTara = new JLabel();
  private JTextField mTara = new JTextField();

// Fields for attribute:  Article

  private JLabel labelIdartif = new JLabel();
  private JTextField mIdartif = new JTextField();

// Fields for attribute:  Descripció

  private JLabel labelDescripart = new JLabel();
  private JTextArea mDescripart = new JTextArea();
  private JScrollPane scrollerDescripart = new JScrollPane();

// Fields for attribute:  Idord

  private JLabel labelIdord = new JLabel();
  private JTextField mIdord = new JTextField();

// Fields for attribute:  Unitats per embalatge

  private JLabel labelUniemb = new JLabel();
  private JTextField mUniemb = new JTextField();

// Fields for attribute:  Cant. Teóric

  private JLabel labelCantot = new JLabel();
  private JTextField mCantot = new JTextField();

// Fields for attribute:  Pes Real

  private JLabel labelPesReal = new JLabel();
  private JTextField mPesReal = new JTextField();

// Fields for attribute:  Cant. per pes real

  private JLabel labelCanPesReal = new JLabel();
  private JTextField mCanPesReal = new JTextField();

// Fields for attribute:  Cant total final

  private JLabel labelCantotUsuari = new JLabel();
  private JTextField mCantotUsuari = new JTextField();
  private JPanel buttonPanel = new JPanel();
  private JButton buttonAcceptar = new JButton();
  private JButton buttonCancelar = new JButton();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgamacPos44PendPesoView1()
  {
    _instance = this;
  }
  
  public static PanelSgamacPos44PendPesoView1 getInstance()
  {
    return _instance;
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(panelLayout);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(400, 326));
    mIdmac.setDocument((Document)panelBinding.bindUIControl("Idmac", mIdmac));
    mCantot.setFont(new Font("Tahoma", 1, 11));
    mCanPesReal.setFont(new Font("Tahoma", 1, 11));
    labelCantotUsuari.setFont(new Font("Tahoma", 1, 16));
    labelCantotUsuari.setBackground(Color.yellow);
    mCantotUsuari.setFont(new Font("Tahoma", 1, 16));
    mCantotUsuari.setBackground(Color.yellow);
    buttonAcceptar.setText(SgaRecursos.getInstance().getString("Extra.aceptar_label"));
    buttonAcceptar.setToolTipText(SgaRecursos.getInstance().getString("Extra.aceptar_tooltip"));
    buttonAcceptar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          buttonAcceptar_actionPerformed(e);
        }
      });
    buttonCancelar.setText(SgaRecursos.getInstance().getString("Extra.cancelar_label"));
    buttonCancelar.setToolTipText(SgaRecursos.getInstance().getString("Extra.cancelar_tooltip"));
    buttonCancelar.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          buttonCancelar_actionPerformed(e);
        }
      });
    dataPanel.add(labelIdmac, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdmac, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdmac.setLabelFor(mIdmac);
    mIdmac.setColumns(15);
    labelIdmac.setText(panelBinding.findCtrlValueBinding("Idmac").getLabel());
    mIdmac.setToolTipText(panelBinding.findCtrlValueBinding("Idmac").getTooltip());
    mDescriptipomac.setDocument((Document)panelBinding.bindUIControl("Descriptipomac", mDescriptipomac));
    dataPanel.add(labelDescriptipomac, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescriptipomac, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelDescriptipomac.setLabelFor(mDescriptipomac);
    mDescriptipomac.setColumns(12);
    labelDescriptipomac.setText(panelBinding.findCtrlValueBinding("Descriptipomac").getLabel());
    mDescriptipomac.setToolTipText(panelBinding.findCtrlValueBinding("Descriptipomac").getTooltip());
    mTara.setDocument((Document)panelBinding.bindUIControl("Tara", mTara));
    dataPanel.add(labelTara, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mTara, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelTara.setLabelFor(mTara);
    mTara.setColumns(15);
    labelTara.setText(panelBinding.findCtrlValueBinding("Tara").getLabel());
    mTara.setToolTipText(panelBinding.findCtrlValueBinding("Tara").getTooltip());
    mIdartif.setDocument((Document)panelBinding.bindUIControl("Idartif", mIdartif));
    dataPanel.add(labelIdartif, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdartif, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdartif.setLabelFor(mIdartif);
    mIdartif.setColumns(14);
    labelIdartif.setText(panelBinding.findCtrlValueBinding("Idartif").getLabel());
    mIdartif.setToolTipText(panelBinding.findCtrlValueBinding("Idartif").getTooltip());
    mDescripart.setDocument((Document)panelBinding.bindUIControl("Descripart", mDescripart));
    dataPanel.add(labelDescripart, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(scrollerDescripart, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    labelDescripart.setLabelFor(scrollerDescripart);
    scrollerDescripart.getViewport().add(mDescripart);
    mDescripart.setColumns(30);
    mDescripart.setRows(2);
    labelDescripart.setText(panelBinding.findCtrlValueBinding("Descripart").getLabel());
    mDescripart.setToolTipText(panelBinding.findCtrlValueBinding("Descripart").getTooltip());
    mIdord.setDocument((Document)panelBinding.bindUIControl("Idord", mIdord));
    dataPanel.add(labelIdord, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdord, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdord.setLabelFor(mIdord);
    mIdord.setColumns(15);
    labelIdord.setText(panelBinding.findCtrlValueBinding("Idord").getLabel());
    mIdord.setToolTipText(panelBinding.findCtrlValueBinding("Idord").getTooltip());
    mUniemb.setDocument((Document)panelBinding.bindUIControl("Uniemb", mUniemb));
    dataPanel.add(labelUniemb, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mUniemb, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelUniemb.setLabelFor(mUniemb);
    mUniemb.setColumns(10);
    labelUniemb.setText(panelBinding.findCtrlValueBinding("Uniemb").getLabel());
    mUniemb.setToolTipText(panelBinding.findCtrlValueBinding("Uniemb").getTooltip());
    mCantot.setDocument((Document)panelBinding.bindUIControl("Cantot", mCantot));
    dataPanel.add(labelCantot, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantot, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelCantot.setLabelFor(mCantot);
    mCantot.setColumns(10);
    labelCantot.setText(panelBinding.findCtrlValueBinding("Cantot").getLabel());
    mCantot.setToolTipText(panelBinding.findCtrlValueBinding("Cantot").getTooltip());
    mPesReal.setDocument((Document)panelBinding.bindUIControl("PesReal", mPesReal));
    dataPanel.add(labelPesReal, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPesReal, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelPesReal.setLabelFor(mPesReal);
    mPesReal.setColumns(15);
    labelPesReal.setText(panelBinding.findCtrlValueBinding("PesReal").getLabel());
    mPesReal.setToolTipText(panelBinding.findCtrlValueBinding("PesReal").getTooltip());
    mCanPesReal.setDocument((Document)panelBinding.bindUIControl("CanPesReal", mCanPesReal));
    dataPanel.add(labelCanPesReal, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCanPesReal, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelCanPesReal.setLabelFor(mCanPesReal);
    mCanPesReal.setColumns(15);
    labelCanPesReal.setText(panelBinding.findCtrlValueBinding("CanPesReal").getLabel());
    mCanPesReal.setToolTipText(panelBinding.findCtrlValueBinding("CanPesReal").getTooltip());
    mCantotUsuari.setDocument((Document)panelBinding.bindUIControl("CantotUsuari", mCantotUsuari));
    dataPanel.add(labelCantotUsuari, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mCantotUsuari, new GridBagConstraints(3, 10, 1, 1, 0.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    buttonPanel.add(buttonAcceptar, null);
    buttonPanel.add(buttonCancelar, null);
    dataPanel.add(buttonPanel, new GridBagConstraints(3, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelCantotUsuari.setLabelFor(mCantotUsuari);
    mCantotUsuari.setColumns(15);
    labelCantotUsuari.setText(panelBinding.findCtrlValueBinding("CantotUsuari").getLabel());

    // Layout the datapanel and the navigation bar
    mCantotUsuari.setToolTipText(panelBinding.findCtrlValueBinding("CantotUsuari").getTooltip());
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

    PanelSgamacPos44PendPesoView1 panel = new PanelSgamacPos44PendPesoView1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
    panel.setPesTotal(new Number (20000));
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
  
  
  public SgamacPos44PendPesoViewRow getCurrentRow(boolean executeQuery)
  {
    ViewObject vo = panelBinding.findIteratorBinding("SgamacPos44PendPesoView1Iter").getViewObject();
    
    if (executeQuery)
      vo.executeQuery();
    
    vo.reset();
    return (SgamacPos44PendPesoViewRow)vo.first();
  }
  
  public void setPesTotal(Number pesTotal)
  {
    SgamacPos44PendPesoViewRow macRow = getCurrentRow(true);
    
    LOG.debug("Actualizando peso real del mac: " + macRow.getIdmac() + " pes real: " + pesTotal);
    if (macRow != null)
    {
      macRow.setPesReal(pesTotal);
      operacionPendiente = true;
      setButtonsEnabled(true);
      
//      mCanPesReal.setEnabled(false);
        mCantot.setEnabled(false);
        mTara.setEnabled(false);
        mUniemb.setEnabled(false);
//      mPesReal.setEnabled(false);
        setVisible(true);

    }
    else
      LOG.debug("Imposible actualizar valor de peso real");

    

  }
  
  private void setButtonsEnabled (boolean enabled)
  {
    buttonAcceptar.setEnabled(enabled);
    buttonCancelar.setEnabled(enabled);
  }
  
  public boolean hasOperacionPendiente ()
  {
    return (operacionPendiente);
  }
  
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }

  private void buttonAcceptar_actionPerformed(ActionEvent e)
  {
    try
    {
      SgamacPos44PendPesoViewRow macRow = getCurrentRow(false);
      macRow.regularizarExistencia();
      operacionPendiente = false;
      setButtonsEnabled(false);
      setVisible(false);
      
      
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);    
    }
    
  }

  private void buttonCancelar_actionPerformed(ActionEvent e)
  {
    try
    {
      SgamacPos44PendPesoViewRow macRow = getCurrentRow(false);
      macRow.confirmarControlPes();
      operacionPendiente = false;
      setButtonsEnabled(false);
      setVisible(false);
      
    }
    catch (Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);    
    }
  }

}