package es.sysmap.interflex.viewrf;
import es.sysmap.interflex.model.bdc.InterflexMessageBundle;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.JboException;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jdeveloper.layout.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import oracle.jbo.uicli.controls.JUNavigationBar;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import sgalib.JUpperCaseTextField;

public class PanelSgavubicacionRF1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavubicacionRF1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel


// Fields for attribute:  SgavubicacionRF1

  private JTable tableSgavubicacionRF1 = new JTable();
  private JScrollPane scroller = new JScrollPane();
  private JPanel filterPanel = new JPanel();
  private JUpperCaseTextField articulo = new JUpperCaseTextField();
  private JLabel articuloLabel = new JLabel();
  private GridLayout gridLayout1 = new GridLayout();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JComboBox pasilloCombo = new JComboBox();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JUNavigationBar navBar = new JUNavigationBar();
  
  private static boolean _firstTimePasillo = true;
  private static boolean _firstTimeArticle = true;
  private JLabel jLabel1 = new JLabel();
  private JRadioButton buitRadio = new JRadioButton();
  private JButton esborrarReferencia = new JButton();
 


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavubicacionRF1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    this.setBounds(new Rectangle(0, 0, 629, 464));
    this.setPreferredSize(new Dimension(628, 409));
    dataPanel.setLayout(borderLayout1);
    dataPanel.setMinimumSize(new Dimension(100, 100));
    tableSgavubicacionRF1.setFont(new Font("Calibri", 0, 18));

    filterPanel.setLayout(gridLayout1);
    articulo.setFont(new Font("Calibri", 0, 18));
    articulo.addFocusListener(new FocusAdapter()
      {
        public void focusLost(FocusEvent e)
        {
          articulo_focusLost(e);
        }
      });
    articulo.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          articulo_actionPerformed(e);
        }
      });
    articuloLabel.setText("Referencia");
    articuloLabel.setLabelFor(articulo);
    articuloLabel.setToolTipText("Llegeix una etiqueta");
    articuloLabel.setFont(new Font("Calibri", 0, 18));
    articuloLabel.setMaximumSize(new Dimension(50, 23));
    articuloLabel.setPreferredSize(new Dimension(50, 23));
    articuloLabel.setSize(new Dimension(50, 31));
    articuloLabel.setMinimumSize(new Dimension(50, 23));
    articuloLabel.setAlignmentY((float)0.0);
    articuloLabel.setHorizontalAlignment(SwingConstants.CENTER);
    pasilloCombo.setFont(new Font("Calibri", 0, 18));
    pasilloCombo.addItemListener(new ItemListener()
      {
        public void itemStateChanged(ItemEvent e)
        {
          pasilloCombo_itemStateChanged(e);
        }
      });
      
    buitRadio.addItemListener(new ItemListener()
      {
        public void itemStateChanged(ItemEvent e)
        {
          buitRadio_itemStateChanged(e);
        }
      });


    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavubicacionRF1", null, "SgavubicacionRF1Iterator"));
    navBar.setHasTransactionButtons(false);
    
    jLabel1.setText("Passadis");
    jLabel1.setToolTipText("Cercar per passadis (0: Tots)");
    jLabel1.setLabelFor(pasilloCombo);
    jLabel1.setFont(new Font("Calibri", 0, 18));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setHorizontalTextPosition(SwingConstants.LEADING);
    buitRadio.setText("Buit");
    buitRadio.setToolTipText("Seleccionar per veure ubicacions buits");
    buitRadio.setFont(new Font("Calibri", 0, 18));
    buitRadio.setHorizontalAlignment(SwingConstants.CENTER);
    esborrarReferencia.setText("C");
    esborrarReferencia.setToolTipText("Esborrar camp de la referencia");
    esborrarReferencia.setFont(new Font("Calibri", 1, 18));
    esborrarReferencia.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          esborrarReferencia_actionPerformed(e);
        }
      });
    filterPanel.add(jLabel1, null);
    filterPanel.add(pasilloCombo, null);
    filterPanel.add(articuloLabel, null);
    filterPanel.add(articulo, null);
    filterPanel.add(esborrarReferencia, null);
    filterPanel.add(buitRadio, null);
    
    this.setLayout(borderLayout);
    // Code support for view object:  SgavubicacionRF1
    tableSgavubicacionRF1.setModel((TableModel)panelBinding.bindUIControl("SgavubicacionRF1", tableSgavubicacionRF1));
    scroller.getViewport().add(tableSgavubicacionRF1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(filterPanel, BorderLayout.NORTH);
    dataPanel.add(scroller, BorderLayout.CENTER);
    dataPanel.add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);
    this.add(jScrollPane1, BorderLayout.SOUTH);
    pasilloCombo.setModel((ComboBoxModel)panelBinding.bindUIControl("Pasillo", pasilloCombo));


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

    PanelSgavubicacionRF1 panel = new PanelSgavubicacionRF1();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "AppModuleDataControl1", panel, panel.getPanelBinding(), new Dimension(400, 300)));
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

  private void articulo_actionPerformed(ActionEvent e)
  {
    filtrar();
  }

  
    
    

  


  
  private void buitRadio_itemStateChanged(ItemEvent e)
  {
      filtrar();
  }
  
  private void pasilloCombo_itemStateChanged(ItemEvent e)
  {
     if (e.getStateChange() == ItemEvent.SELECTED)
     {
     if (!_firstTimePasillo)
     {
     
        filtrar();
     }
     else
      _firstTimePasillo = false;
     }
  }
  
  private void filtrar()
  {
    boolean hasWhereClause = false;
    ViewObject vo = navBar.getModel().getViewObject();

    String pasillo = pasilloCombo.getSelectedItem().toString();
    if (!pasillo.equals("0"))
    {
        vo.setWhereClause("passadis = '" + pasilloCombo.getSelectedItem() + "'");
        hasWhereClause = true;
    }
    if (buitRadio.isSelected())
    {
      if (hasWhereClause)
      {
        vo.setWhereClause(vo.getWhereClause() + " AND ocupació = 0");
      }
      else
      {
        vo.setWhereClause("ocupació = 0");
        hasWhereClause = true;
      }
    }
    else
    {
      if (!hasWhereClause)
      {
        vo.setWhereClause("");
      }
    }
      String art = validateEtiqueta();
      if (art != null && art.length() > 0)
      {
        if (hasWhereClause)
        {
          vo.setWhereClause(vo.getWhereClause() + " AND article = '" + art + "'");
        }
        else
          vo.setWhereClause("article = '" + art + "'");
      }
      else 
      {
        if (!hasWhereClause)
          vo.setWhereClause("");
      }
      
     vo.executeQuery();


  }

  /**
   * Michael: See SgaEntradaManualRFRowImpl.validateEtiqueta for full version (copied!!)
   * El campo contempla la referencia, o bien la referencia, con la cantidad (en 5 digitos) 
   * que es el formato de las etiquetas
   * return <referencia> la referencia, o null
   */
  public String validateEtiqueta () 
  {
    String referencia = articulo.getText();
    if (referencia != null && referencia.length() > 0)
    {
    
      if (referencia.length() < 8) // Article (min 3) + cantidad (5)
      {
        // sólo referencia
      }
      else
        referencia = referencia.substring(0, referencia.length() - 5);
    }
    return referencia;
  }

  private void articulo_focusLost(FocusEvent e)
  {
    filtrar();
  }

  private void esborrarReferencia_actionPerformed(ActionEvent e)
  {
    articulo.setText("");
    filtrar();
  }
}