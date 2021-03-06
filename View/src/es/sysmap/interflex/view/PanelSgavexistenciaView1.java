package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgaRefCodesViewRow;
import es.sysmap.interflex.model.dmc.common.SgavexistenciaViewRow;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;


import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

import oracle.adf.model.*;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.jbo.RangeRefreshEvent;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jbo.domain.Number;

import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgavexistenciaView1 extends SgaJUPanel 
// public class PanelSgavexistenciaView1 extends JPanel implements JUPanel 
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexistenciaView1UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// The status bar

  private JUStatusBar statusBar = new JUStatusBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavexistenciaView1

  private SgaJTable tableSgavexistenciaView1 = new SgaJTable();

  private Color defaultTableBackground = tableSgavexistenciaView1.getBackground();
  private Color defaultTableForeground = tableSgavexistenciaView1.getForeground();
  
  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexistenciaView1()
  {
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    // Layout definition for this panel
    dataPanel.setLayout(gridLayout);
    dataPanel.setMinimumSize(new Dimension(800, 250));
    dataPanel.setBorder(BorderFactory.createTitledBorder(""));
    dataPanel.setPreferredSize(new Dimension(800, 250));
    dataPanel.setMaximumSize(new Dimension(800, 250));
    navBar.setPreferredSize(new Dimension(800, 29));
    navBar.setMinimumSize(new Dimension(800, 29));
    navBar.setMaximumSize(new Dimension(800, 29));
    this.setLayout(borderLayout);
    this.setSize(new Dimension(800, 300));
    this.setPreferredSize(new Dimension(800, 300));
    this.setMinimumSize(new Dimension(800, 300));
    this.setMaximumSize(new Dimension(800, 300));
    // Code support for view object:  SgavexistenciaView1
    tableSgavexistenciaView1.setModel((TableModel)panelBinding.bindUIControl("SgavexistenciaView1", tableSgavexistenciaView1));
    tableSgavexistenciaView1.setEditable(false);
    scroller.getViewport().add(tableSgavexistenciaView1, null);
    // Layout the datapanel and the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavexistenciaView1", null, "SgavexistenciaView1Iter"));
    statusBar.setModel(JUStatusBar.createPanelBinding(panelBinding, statusBar));
    add(navBar, BorderLayout.NORTH);
    add(dataPanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);

    // Afegim opcions al popup de la taula
    addPopup();
    
    setCustomCellRenderer(tableSgavexistenciaView1);


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

    PanelSgavexistenciaView1 panel = new PanelSgavexistenciaView1();
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


  /**
   * Afegeix opcions al menu popup de la taula
   */
  private void addPopup() {
  
        JMenuItem menuItem;
      
      tableSgavexistenciaView1.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.treureContenidor_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/undo.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          treureContenidor();
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.regularitzar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/up_down_question.png", null));

      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          regularitzarExistencia();
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);

      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.establirSortidaIntegra_label"));
            menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/zoom_out.png", null));

      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setSortidaIntegra(true);
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);

      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.anularSortidaIntegra_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/zoom_in.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setSortidaIntegra(false);
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);

      tableSgavexistenciaView1.addPopupSeparator();
    // Michael 29.01.2009 A�adir posibilidad de bloquear/desbloquear existencia
    if (Interflex.getInstance().hasAcceso("SGABLOQEXIST"))
    {
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.bloquejar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/forbidden.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setBloqueo(true);
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.desbloquejar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/bullet_ball_blue.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setBloqueo(false);
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
      
      
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setEspecial();
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
 
       menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.assignarEspecial_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/bookmark.png", null));
     menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setEspecial();
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
      
      tableSgavexistenciaView1.addPopupSeparator();
    }

      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.veureDisponibilitat_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/unknown.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          veureDisponibilitat();
        }
      });      
      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
      



      
//
// 
//  
//      JMenuItem menuItem;
//      
//      tableSgavexistenciaView1.addPopupSeparator();
//      
//      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.treureContenidor_label"));
//      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
//      menuItem.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent e)
//        {
//          treureContenidor();
//        }
//      });      
//      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
//      
//      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.regularitzar_label"));
//      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
//      menuItem.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent e)
//        {
//          regularitzarExistencia();
//        }
//      });      
//      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
//
//      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.establirSortidaIntegra_label"));
//      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
//      menuItem.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent e)
//        {
//          setSortidaIntegra(true);
//        }
//      });      
//      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
//
//      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.anularSortidaIntegra_label"));
//      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
//      menuItem.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent e)
//        {
//          setSortidaIntegra(false);
//        }
//      });      
//      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
//      
//      tableSgavexistenciaView1.addPopupSeparator();
//      
//      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.veureDisponibilitat_label"));
//      //menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "consultes.gif", null));
//      menuItem.addActionListener(new ActionListener()
//      {
//        public void actionPerformed(ActionEvent e)
//        {
//          veureDisponibilitat();
//        }
//      });      
//      tableSgavexistenciaView1.addPopupMenuItem(menuItem);
      
  }
  
  /*
   * Michael 24.05.2013. Asociar un texto con el bloqueo
   */
   private void setBloqueo (boolean bloqueo)
  {
    String motiu = null;
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView1Iter").getCurrentRow(); 
      if (existrow != null)
      {
        
        if (bloqueo)
        {
          motiu =  JOptionPane.showInputDialog(this, "Especificar el motiu del bloqueig:");
          if (motiu == null)
            return;
            
        }
        else 
        {
          motiu = existrow.getMotivoBloqueo();
          if (motiu != null)
          {
            int result = JOptionPane.showConfirmDialog(null, "Motiu bloqueig: " + motiu + " - Treure?", "Confirmar treure Bloqueig", JOptionPane.YES_NO_OPTION);
            if (result != JOptionPane.YES_OPTION)
              return;
          }
            
        }
        existrow.setBloqueoFromUser(bloqueo, motiu);
        panelBinding.getApplication().getApplicationModule().getTransaction().commit();
        panelBinding.findIteratorBinding("SgavexistenciaView1Iter").executeQuery();
        
      }
      
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }

  
  /**
   * Solicita la extracci� del contenidor de l'existencia
   */
  private void treureContenidor()
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView1Iter").getCurrentRow(); 
      if (existrow != null)
      {
        boolean silo = !existrow.getIdtipmac().equals("CUB");
        TreureContenidor.treureContenidor((AppModule)getPanelBinding().getApplication().getApplicationModule(), existrow.getIdmac(), silo);
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Anula la sortida integra de l'exist�ncia
   */
  private void setSortidaIntegra(boolean bIntegra)
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView1Iter").getCurrentRow(); 
      if (existrow != null)
      {
        existrow.setSortidaIntegra(bIntegra);
        panelBinding.getApplication().getApplicationModule().getTransaction().commit();
        panelBinding.findIteratorBinding("SgavexistenciaView1Iter").executeQuery();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }


  /**
   * Analitza la disponibilitat de l'exist�ncia
   */
  private void veureDisponibilitat()
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView1Iter").getCurrentRow(); 
      if (existrow != null)
      {
        VeureDisponibilitat.veureDisponibilitat((AppModule)panelBinding.getApplication().getApplicationModule(), existrow.getIdmac(), existrow.getIdart());
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }
  
  private void setEspecial()
  {
      SgavexistenciaViewRow existRow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView1Iter").getCurrentRow(); 
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      if (ExistenciaEspecialSetter.set(appModule, existRow))
     
     {
       
        appModule.getTransaction().commit();
        panelBinding.findIteratorBinding("SgavexistenciaView1Iter").executeQuery();

     }

  }
  
  
  /**
   * Regularitza la quantitat de l'exist�ncia
   */
  private void regularitzarExistencia()
  {
    JPanel regulPanel = new JPanel();
    GridBagLayout regulPanelLayout = new GridBagLayout();
    JLabel labelCancon = new JLabel();
    JTextField mCancon = new JTextField();
    JLabel labelObserv = new JLabel();
    JTextField mObserv = new JTextField();
    
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView1Iter").getCurrentRow(); 
      if (existrow != null)
      {
        // Options
        String[] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                            SgaRecursos.getInstance().getString("Options.cancelar_label") };
        regulPanel.setLayout(regulPanelLayout);                            
        labelCancon.setText(SgaRecursos.getInstance().getString("Existencies.novaQuantitat_label"));
        mCancon.setColumns(6);
        labelObserv.setText(SgaRecursos.getInstance().getString("Existencies.observacions_label"));
        mObserv.setColumns(25);
        regulPanel.add(labelCancon, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        regulPanel.add(mCancon, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        regulPanel.add(labelObserv, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        regulPanel.add(mObserv, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.RELATIVE, new Insets(0, 0, 0, 5), 1, 1));
        //Inicialitzem la quantitat confirmada amb la quantitat total del mac
        mCancon.setText(existrow.getCantot().toString());        
        mCancon.postActionEvent();
       
       int result = 0; 
       do 
       {
        // loop until user cancels or provides value for mObserv field
        result = JOptionPane.showOptionDialog(
              null,                                       // the parent that the dialog blocks
              regulPanel,                                    // the dialog message array
              SgaRecursos.getInstance().getString("Existencies.regularitzar_label"),            // the title of the dialog window
              JOptionPane.DEFAULT_OPTION,                 // option type
              JOptionPane.INFORMATION_MESSAGE,            // message type
              null,                                       // optional icon, use null to use the default icon
              options,                                    // options string array, will be made into buttons
              options[0]                                  // option that should be made into a default button
              );
             mObserv.setBackground(Color.RED);
        } while (result == 0 && ! (mObserv.getText() != null && mObserv.getText().length() > 0));
        
        
        switch(result)
        {
          case 0:                        
          {
            existrow.regularitzarExistencia(new Number(mCancon.getText()), mObserv.getText());
            panelBinding.getApplication().getApplicationModule().getTransaction().commit();
            panelBinding.findIteratorBinding("SgavexistenciaView1Iter").executeQuery();
            break;
          }
          default:
          {
            panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
            panelBinding.findIteratorBinding("SgavexistenciaView1Iter").executeQuery();
          }
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  private void setCustomCellRenderer (JTable table)
  {
    
    for (int i = 0; i < table.getColumnCount() ; i++) 
    {
      TableColumn tcol = table.getColumnModel().getColumn(i);
      tcol.setCellRenderer(new CustomTableCellRenderer());      
    }
    
  }

 	private class CustomTableCellRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
			Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);


      if (panelBinding.isFindMode())
        return cell;


     int colIndex = tableSgavexistenciaView1.getColumnIndex("Bloqueo");

     String bloqueo = (String)table.getValueAt(row, colIndex);
     
      
			if (isSelected) {
				cell.setBackground(table.getSelectionBackground());
        if (bloqueo.equals("S")) 
          cell.setForeground(Color.RED);
        else
          cell.setForeground(table.getSelectionForeground());
 			} 
			else {
         cell.setForeground(defaultTableForeground);
         if (bloqueo.equals("S")) 
         {
            cell.setBackground(Color.RED);
         }
         else
         {
					cell.setBackground(defaultTableBackground);
          }
        }
			return cell;
		}
    
    
    
	}

}