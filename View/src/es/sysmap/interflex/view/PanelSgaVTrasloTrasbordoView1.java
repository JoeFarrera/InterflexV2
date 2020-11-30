package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import oracle.jbo.NavigatableRowIterator;
import oracle.jbo.NavigationEvent;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;
import oracle.jdeveloper.layout.*;
import javax.swing.border.*;
import java.awt.GridBagConstraints;
import oracle.jbo.uicli.controls.JUNavigationBar;
import java.awt.Insets;
import oracle.jbo.uicli.binding.JUIteratorBinding;
import javax.swing.JCheckBox;
import javax.swing.ButtonModel;
import java.awt.Dimension;
import java.awt.Font;
import sgalib.SgaJUPanel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSgaVTrasloTrasbordoView1 extends SgaJUPanel 
// public class PanelSgaVTrasloTrasbordoView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgaVTrasloTrasbordoView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// Layout used by panel

  private GridBagLayout panelLayout = new GridBagLayout();

// Fields for attribute:  Idtraslo

  private JPanel panelIdtraslo = new JPanel();
  private GridLayout layoutIdtraslo = new GridLayout();
  private JTextField mIdtraslo = new JTextField();

// Fields for attribute:  Trasbord Entrades

  private JPanel panelTrasbordoentrada = new JPanel();
  private GridLayout layoutTrasbordoentrada = new GridLayout();

  private JPanel panelPermitTrasbordo = new JPanel();
  private GridLayout layoutpermitTrasbordo = new GridLayout();


// Fields for attribute:  Trasbord Sortides

  private JPanel panelTrasbordosalida = new JPanel();
  private GridLayout layoutTrasbordosalida = new GridLayout();
  private JUNavigationBar jUNavigationBar1 = new JUNavigationBar();
  private JCheckBox jCheckBoxTEntrada = new JCheckBox();
  private JCheckBox jCheckBoxTSalida = new JCheckBox();
  private JCheckBox jCheckBoxPermisTrasbordo = new JCheckBox();

  


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgaVTrasloTrasbordoView1()
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
    dataPanel.setToolTipText("Permetre els traslos del SILO realitzar canvi de passadis por motiu " + "d entrada / sortida de contenidors. ");
    this.setLayout(borderLayout);
    mIdtraslo.setDocument((Document)panelBinding.bindUIControl("Idtraslo", mIdtraslo));
    mIdtraslo.setMinimumSize(new Dimension(6, 6));
    mIdtraslo.setFont(new Font("Tahoma", 0, 15));
    jUNavigationBar1.setHasInsertButton(false);
    jUNavigationBar1.setHasDeleteButton(false);
    jCheckBoxTEntrada.setText("Trasbordo Entrades");
    jCheckBoxTEntrada.setToolTipText("Permetre trasbord del passadis actual per fer entrades");
    jCheckBoxTSalida.setText("Trasbordo Sortides");
    jCheckBoxTSalida.setToolTipText("Permetre trasbord del passadis actual per fer sortides");
    jCheckBoxPermisTrasbordo.setText("Permis Trasbordo");
    jCheckBoxPermisTrasbordo.setToolTipText("Permetre el traslo canviar de passadis (del actual a un altre)");

    dataPanel.add(panelIdtraslo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    panelIdtraslo.setLayout(layoutIdtraslo);
    panelIdtraslo.setBorder(new TitledBorder(panelBinding.getLabel("SgaVTrasloTrasbordoView1", "Idtraslo", null)));
    panelIdtraslo.add(mIdtraslo);
    mIdtraslo.setColumns(1);
    mIdtraslo.setToolTipText(panelBinding.findCtrlValueBinding("Idtraslo").getTooltip());
    dataPanel.add(panelTrasbordoentrada, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    panelTrasbordoentrada.setLayout(layoutTrasbordoentrada);
    panelTrasbordoentrada.setBorder(BorderFactory.createTitledBorder("Entrada"));
    panelTrasbordoentrada.add(jCheckBoxTEntrada, null);
    dataPanel.add(panelTrasbordosalida, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    panelTrasbordosalida.setLayout(layoutTrasbordosalida);
    panelTrasbordosalida.setBorder(BorderFactory.createTitledBorder("Sortida"));
    panelTrasbordosalida.add(jCheckBoxTSalida, null);

    panelPermitTrasbordo.add(jCheckBoxPermisTrasbordo, null);
    dataPanel.add(panelPermitTrasbordo, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5), 1, 1));
    panelPermitTrasbordo.setLayout(layoutpermitTrasbordo);
    panelPermitTrasbordo.setBorder(BorderFactory.createTitledBorder("Permís Trasbordo"));
   // panelPermitTrasbordo.add(jCheckBoxTEntrada, null);



    // Layout the datapanel and the navigation bar
    dataPanel.add(jUNavigationBar1, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    add(dataPanel, BorderLayout.NORTH);
    jUNavigationBar1.setModel(JUNavigationBar.createViewBinding(panelBinding, jUNavigationBar1, "SgaVTrasloTrasbordoView1", null, "SgaVTrasloTrasbordoView1Iterator"));
    jCheckBoxTEntrada.setModel((ButtonModel)panelBinding.bindUIControl("Trasbordoentrada1", jCheckBoxTEntrada));
    jCheckBoxTSalida.setModel((ButtonModel)panelBinding.bindUIControl("Trasbordosalida1", jCheckBoxTSalida));
    jCheckBoxPermisTrasbordo.setModel((ButtonModel)panelBinding.bindUIControl("PermisTrasbordo", jCheckBoxPermisTrasbordo));
    
    panelBinding.addIteratorChangedListener( new JUIteratorChangedListener()
    {
      public void iteratorChanged(String string, NavigatableRowIterator it)
      {
        setUpdatePermissions();
      }
    });
    
    panelBinding.addRowSetListener(new JUPanelRowSetAdapter()
      {
        public void navigated(JUIteratorBinding iter, NavigationEvent event)
        {
          setUpdatePermissions();
        }

        public void rangeRefreshed(JUIteratorBinding iter, RangeRefreshEvent event)
        {
          setUpdatePermissions();
        }
        
      });

    



  }
  
  private void setUpdatePermissions()
  {
  
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
             AppModule am = (AppModule)panelBinding.getApplication().getApplicationModule();
    boolean enabled = am.isUserModPermisTraslo();
    {
      jCheckBoxPermisTrasbordo.setEnabled(enabled);
      // 24.03.2019 For all jCheckBoxTEntrada.setEnabled(enabled);
      // 24.03.2019 For all jCheckBoxTSalida.setEnabled(enabled);
    }   
            }
        });

    
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

    PanelSgaVTrasloTrasbordoView1 panel = new PanelSgaVTrasloTrasbordoView1();
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
//      setUpdatePermissions();
      try
      {
        jbInit();
        panelBinding.refreshControl();
        setUpdatePermissions();
      }
      catch(Exception ex)
      {
        panelBinding.reportException(ex);
      }

    }
  }
    // Afegit xavi
  public void setPanelBinding(JUPanelBinding panelBinding)
  {
    this.panelBinding = panelBinding;
  }


}