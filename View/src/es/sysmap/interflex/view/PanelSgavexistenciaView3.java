package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import es.sysmap.interflex.model.dmc.common.SgavexistenciaViewRow;
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
import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jbo.domain.Number;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

public class PanelSgavexistenciaView3 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexistenciaView3UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavexistenciaView3

  private SgaJTable tableSgavexistenciaView3 = new SgaJTable();

  private Color defaultTableBackground = tableSgavexistenciaView3.getBackground();
  private Color defaultTableForeground = tableSgavexistenciaView3.getForeground();

  private JScrollPane scroller = new JScrollPane();


  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexistenciaView3()
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
    
    // Code support for view object:  SgavexistenciaView3
    tableSgavexistenciaView3.setModel((TableModel)panelBinding.bindUIControl("SgavexistenciaView3", tableSgavexistenciaView3));
    tableSgavexistenciaView3.setEditable(false);
    scroller.getViewport().add(tableSgavexistenciaView3, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavexistenciaView3", null, "SgavexistenciaView3Iter"));
    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);
    
    addPopup();
    
    setCustomCellRenderer(tableSgavexistenciaView3);

  }
  
  
  private void setBloqueo (boolean bloqueo)
  {
    String motiu = null;
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView3Iter").getCurrentRow(); 
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
        panelBinding.findIteratorBinding("SgavexistenciaView3Iter").executeQuery();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
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

    PanelSgavexistenciaView3 panel = new PanelSgavexistenciaView3();
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
      
      tableSgavexistenciaView3.addPopupSeparator();
      

      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.regularitzar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/up_down_question.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          regularitzarExistencia();
        }
      });      
      tableSgavexistenciaView3.addPopupMenuItem(menuItem);

      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.establirSortidaIntegra_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/zoom_out.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setSortidaIntegra(true);
        }
      });      
      tableSgavexistenciaView3.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.anularSortidaIntegra_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/zoom_in.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setSortidaIntegra(false);
        }
      });      
      tableSgavexistenciaView3.addPopupMenuItem(menuItem);

      tableSgavexistenciaView3.addPopupSeparator();

    // Michael 29.01.2009 Añadir posibilidad de bloquear/desbloquear existencia
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
      tableSgavexistenciaView3.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.desbloquejar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/bullet_ball_blue.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setBloqueo(false);
        }
      });      
      tableSgavexistenciaView3.addPopupMenuItem(menuItem);
      
      tableSgavexistenciaView3.addPopupSeparator();
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
      tableSgavexistenciaView3.addPopupMenuItem(menuItem);
      
  }


  /**
   * Anula la sortida integra de l'existència
   */
  private void setSortidaIntegra(boolean bIntegra)
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView3Iter").getCurrentRow(); 
      if (existrow != null)
      {
        existrow.setSortidaIntegra(bIntegra);
        panelBinding.getApplication().getApplicationModule().getTransaction().commit();
        panelBinding.findIteratorBinding("SgavexistenciaView3Iter").executeQuery();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
  }

  /**
   * Analitza la disponibilitat de l'existència
   */
  private void veureDisponibilitat()
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView3Iter").getCurrentRow(); 
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


  /**
   * Regularitza la quantitat de l'existència
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
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView3Iter").getCurrentRow(); 
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
            break;
          }
          default:
          {
            panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
          }
        }
        panelBinding.execute();
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

     int colIndex = tableSgavexistenciaView3.getColumnIndex("Bloqueo");
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