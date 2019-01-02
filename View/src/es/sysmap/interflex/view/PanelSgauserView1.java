package es.sysmap.interflex.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.JLabel;

public class PanelSgauserView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgauserView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Usuario

  private JLabel labelIduser = new JLabel();
  private JTextField mIduser = new JTextField();

// Fields for attribute:  Password

  private JLabel labelIdpassword = new JLabel();
  private JPasswordField mIdpassword = new JPasswordField();

// Fields for attribute:  Nombre

  private JLabel labelDescrip = new JLabel();
  private JTextField mDescrip = new JTextField();
  private JTextField mOperario = new JTextField();
  private JLabel labelOperario = new JLabel();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgauserView1()
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
    dataPanel.setMinimumSize(new Dimension(100, 100));
    this.setLayout(borderLayout);
    mIduser.setDocument((Document)panelBinding.bindUIControl("Iduser", mIduser));
    mIduser.setBounds(new Rectangle(97, 105, 140, 20));
    mOperario.setText("jTextField1");
    labelOperario.setLabelFor(mIdpassword);
    labelOperario.setText("Operari");
    dataPanel.add(labelIduser, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIduser, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 61), -72, 1));
    dataPanel.add(labelIdpassword, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIduser.setLabelFor(mIduser);
    mIduser.setColumns(10);
    labelIduser.setText(panelBinding.findCtrlValueBinding("Iduser").getLabel());
    mIduser.setToolTipText(panelBinding.findCtrlValueBinding("Iduser").getTooltip());
    mIdpassword.setDocument((Document)panelBinding.bindUIControl("Idpassword", mIdpassword));
    dataPanel.add(mIdpassword, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 117), 58, 1));
    labelIdpassword.setLabelFor(mIdpassword);
    mIdpassword.setColumns(10);
    labelIdpassword.setText("Palaura de pas");
    mIdpassword.setToolTipText(panelBinding.findCtrlValueBinding("Idpassword").getTooltip());
    mDescrip.setDocument((Document)panelBinding.bindUIControl("Descrip", mDescrip));
    dataPanel.add(labelDescrip, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mDescrip, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mOperario, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 47, 0));
    dataPanel.add(labelOperario, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    labelDescrip.setLabelFor(mDescrip);
    mDescrip.setColumns(30);
    labelDescrip.setText("Descripció");

    // Bind the navigation bar
    mDescrip.setToolTipText(panelBinding.findCtrlValueBinding("Descrip").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgauserView1", null, "SgauserView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    mOperario.setDocument((Document)panelBinding.bindUIControl("Operario", mOperario));


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

    PanelSgauserView1 panel = new PanelSgauserView1();
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
}