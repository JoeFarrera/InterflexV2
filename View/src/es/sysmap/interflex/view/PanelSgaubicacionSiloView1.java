package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.ComboBoxModel;
import sgalib.SgaJUPanel;

public class PanelSgaubicacionSiloView1 extends SgaJUPanel
// public class PanelSgaubicacionSiloView1 extends JPanel implements JUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaubicacionSiloView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private JUNavigationBar navBar = new JUNavigationBar();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Id. Ubicació

  private JLabel labelIdubi = new JLabel();
  private JTextField mIdubi = new JTextField();

// Fields for attribute:  Tipus Ubicació

  private JLabel labelIdtipubi = new JLabel();
  private JComboBox mIdtipubi = new JComboBox();

// Fields for attribute:  Passadís

  private JLabel labelPasillo = new JLabel();
  private JTextField mPasillo = new JTextField();

// Fields for attribute:  Columna

  private JLabel labelColumna = new JLabel();
  private JTextField mColumna = new JTextField();

// Fields for attribute:  Nivell

  private JLabel labelNivel = new JLabel();
  private JTextField mNivel = new JTextField();

// Fields for attribute:  Costat

  private JLabel labelLado = new JLabel();
  private JTextField mLado = new JTextField();

// Fields for attribute:  Rotació

  private JLabel labelRotacion = new JLabel();
  private JTextField mRotacion = new JTextField();

// Fields for attribute:  Descripvisual
  private JTextField mDescripvisual = new JTextField();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaubicacionSiloView1()
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
    dataPanel.setMinimumSize(new Dimension(400, 274));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(400, 274));
    dataPanel.setMaximumSize(new Dimension(400, 274));

    navBar.setPreferredSize(new Dimension(400, 26));
    navBar.setMinimumSize(new Dimension(400, 26));
    navBar.setMaximumSize(new Dimension(400, 26));
    mIdtipubi.setEnabled(false);

    this.setLayout(borderLayout);
    this.setPreferredSize(new Dimension(400, 300));
    this.setMinimumSize(new Dimension(400, 300));
    this.setMaximumSize(new Dimension(400, 300));

    panelBinding.addRowSetListener(new JUPanelRowSetAdapter()
      {
        public void navigated(JUIteratorBinding iter, NavigationEvent event)
        {
          System.out.println("navigated!");
          panelBinding_navigated(iter, event);
        }

        public void rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
        {
          System.out.println("refreshed");
          panelBinding_rangeRefreshed(iter, event);
        }
        
    
      });

    mDescripvisual.setDocument((Document)panelBinding.bindUIControl("Descripvisual", mDescripvisual));
    dataPanel.add(mDescripvisual, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
    mDescripvisual.setColumns(40);
    mDescripvisual.setToolTipText(panelBinding.findCtrlValueBinding("Descripvisual").getTooltip());
    mDescripvisual.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    mDescripvisual.setBackground(new Color(212, 208, 200));

    mIdubi.setDocument((Document)panelBinding.bindUIControl("Idubi", mIdubi));
    dataPanel.add(labelIdubi, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdubi, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdubi.setLabelFor(mIdubi);
    mIdubi.setColumns(10);
    labelIdubi.setText(panelBinding.findCtrlValueBinding("Idubi").getLabel());
    mIdubi.setToolTipText(panelBinding.findCtrlValueBinding("Idubi").getTooltip());

    mIdtipubi.setModel((ComboBoxModel)panelBinding.bindUIControl("Desctipubi", mIdtipubi));
    dataPanel.add(labelIdtipubi, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mIdtipubi, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelIdtipubi.setLabelFor(mIdtipubi);
    mIdtipubi.setEditable(false);
    labelIdtipubi.setText(panelBinding.findCtrlValueBinding("Idtipubi").getLabel());
    mIdtipubi.setToolTipText(panelBinding.findCtrlValueBinding("Idtipubi").getTooltip());

    mPasillo.setDocument((Document)panelBinding.bindUIControl("Pasillo", mPasillo));
    dataPanel.add(labelPasillo, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mPasillo, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelPasillo.setLabelFor(mPasillo);
    mPasillo.setColumns(5);
    labelPasillo.setText(panelBinding.findCtrlValueBinding("Pasillo").getLabel());
    mPasillo.setToolTipText(panelBinding.findCtrlValueBinding("Pasillo").getTooltip());

    mColumna.setDocument((Document)panelBinding.bindUIControl("Columna", mColumna));
    dataPanel.add(labelColumna, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mColumna, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelColumna.setLabelFor(mColumna);
    mColumna.setColumns(5);
    labelColumna.setText(panelBinding.findCtrlValueBinding("Columna").getLabel());
    mColumna.setToolTipText(panelBinding.findCtrlValueBinding("Columna").getTooltip());

    mNivel.setDocument((Document)panelBinding.bindUIControl("Nivel", mNivel));
    dataPanel.add(labelNivel, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mNivel, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelNivel.setLabelFor(mNivel);
    mNivel.setColumns(5);
    labelNivel.setText(panelBinding.findCtrlValueBinding("Nivel").getLabel());
    mNivel.setToolTipText(panelBinding.findCtrlValueBinding("Nivel").getTooltip());

    mLado.setDocument((Document)panelBinding.bindUIControl("Lado", mLado));
    dataPanel.add(labelLado, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mLado, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelLado.setLabelFor(mLado);
    mLado.setColumns(5);
    labelLado.setText(panelBinding.findCtrlValueBinding("Lado").getLabel());
    mLado.setToolTipText(panelBinding.findCtrlValueBinding("Lado").getTooltip());

    mRotacion.setDocument((Document)panelBinding.bindUIControl("Rotacion", mRotacion));
    dataPanel.add(labelRotacion, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    dataPanel.add(mRotacion, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    labelRotacion.setLabelFor(mRotacion);
    mRotacion.setColumns(15);
    labelRotacion.setText(panelBinding.findCtrlValueBinding("Rotacion").getLabel());

    // Bind the navigation bar
    mRotacion.setToolTipText(panelBinding.findCtrlValueBinding("Rotacion").getTooltip());
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgaubicacionSiloView1", null, "SgaubicacionSiloView1Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.NORTH);
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

    PanelSgaubicacionSiloView1 panel = new PanelSgaubicacionSiloView1();
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
  
  private void panelBinding_navigated(JUIteratorBinding iter, NavigationEvent event)
  {
  System.out.println("navigated iter: " + iter.getName());
   if (iter.getName().equals("SgaubicacionSiloView1Iter"))
    {
      refresh(iter.isFindMode());
    }
    
  }

  private void panelBinding_rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
  {
  System.out.println("refreshed iter: " + iter.getName());
    if (iter.getName().equals("SgaubicacionSiloView1Iter"))
    {
      refresh(iter.isFindMode());
    }
  }
  

  private void refresh(boolean isFindMode)
  {
  
    mIdubi.setEditable(isFindMode);
    navBar.setHasInsertButton(isFindMode);
    navBar.setHasDeleteButton(isFindMode);
    
    System.out.println("refresh: isFindMode: " + isFindMode);
    
    // Don't allow field modification
    if (!isFindMode)
    {
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      boolean admin = appModule.isAdministrador();
      if (!admin)
      {
        mPasillo.setEditable(false);
        mColumna.setEditable(false);
        mNivel.setEditable(false);
        mRotacion.setEditable(false);
        mLado.setEditable(false);
        mIdtipubi.setEnabled(false);
        mIdtipubi.setEditable(false);
        mIdtipubi.setFocusable(false);
        
        
        
      }
      }
    }
}