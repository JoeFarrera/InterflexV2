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
import oracle.jbo.domain.Number;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;

import oracle.jbo.uicli.mom.JUMetaObjectManager;
import oracle.jdeveloper.layout.*;
import oracle.sqlj.runtime.Oracle;
import sgalib.SgaJTable;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaJUPanel;
import sgalib.SgaRecursos;

// public class PanelSgavexistenciaView2 extends JPanel implements JUPanel
public class PanelSgavexistenciaView2 extends SgaJUPanel
{
  // Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("PanelSgavexistenciaView2UIModel");

// Panel containing the data entry fields

  private JPanel dataPanel = new JPanel();
  private BorderLayout borderLayout = new BorderLayout();

// The navigation bar

  private SgaJUNavigationBar navBar = new SgaJUNavigationBar();

// Layout used by panel

  private GridLayout gridLayout = new GridLayout();

// Fields for attribute:  SgavexistenciaView2

  private SgaJTable tableSgavexistenciaView2 = new SgaJTable();
  
  private Color defaultTableBackground = tableSgavexistenciaView2.getBackground();
  private Color defaultTableForeground = tableSgavexistenciaView2.getForeground();
  
  // Michael ReservaManual 09.10.2014
  private oracle.jbo.domain.Number idDoc;
  private oracle.jbo.domain.Number idLin;
  String idCabnum;
  // Michael Trasllat manual 06.12.2016
  private oracle.jbo.domain.Number idDocTL;
  
  private JScrollPane scroller = new JScrollPane();

  /**
   * 
   *  The default constructor for panel
   */
  public PanelSgavexistenciaView2()
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
    
    // Code support for view object:  SgavexistenciaView2
    tableSgavexistenciaView2.setModel((TableModel)panelBinding.bindUIControl("SgavexistenciaView2", tableSgavexistenciaView2));
    tableSgavexistenciaView2.setEditable(false);
    scroller.getViewport().add(tableSgavexistenciaView2, null);
    // Bind the navigation bar
    dataPanel.add(scroller);
    navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "SgavexistenciaView2", null, "SgavexistenciaView2Iter"));

    // Layout the datapanel and the navigation bar
    add(navBar, BorderLayout.SOUTH);
    add(dataPanel, BorderLayout.CENTER);

    // Afegim opcions al popup de la taula
    addPopup();
    
    setCustomCellRenderer(tableSgavexistenciaView2);
    if (idDocTL != null)  
      tableSgavexistenciaView2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


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

    PanelSgavexistenciaView2 panel = new PanelSgavexistenciaView2();
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
      
      tableSgavexistenciaView2.addPopupSeparator();
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.treureContenidor_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/undo.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          treureContenidor();
        }
      });      
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.regularitzar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/up_down_question.png", null));

      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          regularitzarExistencia();
        }
      });      
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);

      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.establirSortidaIntegra_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/zoom_out.png", null));

      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setSortidaIntegra(true);
        }
      });      
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);

      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.anularSortidaIntegra_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/zoom_in.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setSortidaIntegra(false);
        }
      });      
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);

      tableSgavexistenciaView2.addPopupSeparator();
    // Michael 29.01.2009 Añadir posibilidad de bloquear/desbloquear existencia
    if (Interflex.getInstance() != null && Interflex.getInstance().hasAcceso("SGABLOQEXIST"))
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
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);
      
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.desbloquejar_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/bullet_ball_blue.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setBloqueo(false);
        }
      });      
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);
      
      tableSgavexistenciaView2.addPopupSeparator();
      menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencias.anular_negativa"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/undo.png", null));
      menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          treureReservaNegativa();
        }
      });      

      tableSgavexistenciaView2.addPopupMenuItem(menuItem);
      
     menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.assignarEspecial_label"));
      menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/bookmark.png", null));
     menuItem.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          setEspecial();
        }
      });      
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);
 

      
      tableSgavexistenciaView2.addPopupSeparator();
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
      tableSgavexistenciaView2.addPopupMenuItem(menuItem);
      
      if (idDoc != null)
      {
        // menuItem = new JMenuItem(SgaRecursos.getInstance().getString("Existencies.assignar_manual"));
        menuItem = new JMenuItem("Assignar existencia a comanda " + idCabnum + " línia " + idLin);
        menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/document_into.png", null));
        menuItem.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            assignarManual();
          }
        });      
        tableSgavexistenciaView2.addPopupMenuItem(menuItem);
      }
      
       menuItem = new JMenuItem("Assignar existencia a trasllat");
        menuItem.setIcon(SgaRecursos.createImageIcon(getClass(), "16x16/plain/document_into.png", null));
        menuItem.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            assignarTrasllat();
          }
        });      
        tableSgavexistenciaView2.addPopupMenuItem(menuItem);
  }
  
  
  /**
   * Solicita la extracció del contenidor de l'existencia
   */
  
  private void treureContenidor()
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
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
  
  
  
  
  private void treureReservaNegativa()
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
      if (existrow != null)
      {
        if (existrow.isReservaNegativa())
        {
          existrow.treureReservaNegativa();
          panelBinding.getApplication().getApplicationModule().getTransaction().commit();
          panelBinding.findIteratorBinding("SgavexistenciaView2Iter").executeQuery();
          JOptionPane.showMessageDialog(null, "Reserva negativa posada a 0", "Reserva negativa", JOptionPane.OK_OPTION);        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "La existència no té reserva negativa", "Reserva negativa", JOptionPane.OK_OPTION);        
        }
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  
  }


  private void setBloqueo (boolean bloqueo)
  {
    String motiu = null;
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
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
        panelBinding.findIteratorBinding("SgavexistenciaView2Iter").executeQuery();
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }
    
  }

  /**
   * Anula la sortida integra de l'existència
   */
  private void setSortidaIntegra(boolean bIntegra)
  {
    try
    {
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
      if (existrow != null)
      {
        existrow.setSortidaIntegra(bIntegra);
        panelBinding.getApplication().getApplicationModule().getTransaction().commit();
        panelBinding.findIteratorBinding("SgavexistenciaView2Iter").executeQuery();
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
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
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
  
   private class StrictInputVerifier extends InputVerifier {
       

        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            String text = textField.getText();
            if (textField.getText() != null && textField.getText().length() > 0)
                return true;
            else {
                // JOptionPane.showConfirmDialog(null, "S'ha d'entrar un motiu de la regularizació", "Motiu", JOptionPane.WARNING_MESSAGE);
                textField.setBackground(Color.RED);
                return false;
            }
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
      SgavexistenciaViewRow existrow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
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
        mObserv.setInputVerifier(new StrictInputVerifier());
        
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
  
  
  public void assignarTrasllat() 
  {
  

    try
    {
// TODO    if (!Interflex.getInstance().hasAcceso("ASSIGMAN")) 
//     {
//        JOptionPane.showMessageDialog(null, "No té privilegis per aquesta operació", "Trasllat manual", JOptionPane.WARNING_MESSAGE);
//        return;
//
//     }


      
        int [] selectedRows = tableSgavexistenciaView2.getSelectedRows();
        JUTableBinding tb = (JUTableBinding)panelBinding.findControlBinding("SgavexistenciaView2");
        for (int i = 0; i < tableSgavexistenciaView2.getSelectedRowCount(); i++)
        {
          SgavexistenciaViewRow existRow = (SgavexistenciaViewRow)tb.getRowAtRangeIndex(selectedRows[i]);
      if (existRow != null)
      {
        if (!existRow.isUbicacionManual())
        {
          JOptionPane.showMessageDialog(null, "Només es poden traslladar existencies del manual", "Trasllat manual", JOptionPane.WARNING_MESSAGE);
          return;
        }
        if (!existRow.isOKReservarTrasllat())
        {
          JOptionPane.showMessageDialog(null, "Només es poden traslladar existencies en estat lliure i sense reserves", "Trasllat manual", JOptionPane.WARNING_MESSAGE);
          return;
        }

          String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };

//          int res = JOptionPane.showOptionDialog(
//                Interflex.getInstance(),                                     
//                "Assignar existencia a trasllat  #: " + idDocTL,  
//                "Confirmar assignació", // the title of the dialog window
//                JOptionPane.DEFAULT_OPTION,                 // option type
//                JOptionPane.QUESTION_MESSAGE,            // message type
//                null,
//                options2,
//                null);
// 
//          if (res != 0)
//          return;


        AppModule app = (AppModule)getPanelBinding().getApplication().getApplicationModule();
        boolean result = app.assignarTrasllatManual(existRow.getIdart(), existRow.getIdmac());
        
        if (result)
        {
          app.getTransaction().commit();
          
          JOptionPane.showMessageDialog(null, "Assignació trasllat mac: " + existRow.getIdmac() + " realitzada");
        }
        else
          JOptionPane.showMessageDialog(null, "No s'ha pogut realitzar l'assignació de trasllat del mac: " + existRow.getIdmac());
      }
        
      }
    }
    catch(Exception ex)
    {
      JUMetaObjectManager.reportException(null, ex);
    }

  }

  
  public void assignarManual() 
  {
  

    try
    {
     if (!Interflex.getInstance().hasAcceso("ASSIGMAN")) 
     {
        JOptionPane.showMessageDialog(null, "No té privilegis per aquesta operació", "Assignació manual", JOptionPane.WARNING_MESSAGE);
        return;

     }
      SgavexistenciaViewRow existRow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
      if (existRow != null)
      {
        if (!existRow.isUbicacionManual())
        {
          JOptionPane.showMessageDialog(null, "Només es poden reservar existencies del manual", "Assignació manual", JOptionPane.WARNING_MESSAGE);
          return;
        }

          String[] options2 = {SgaRecursos.getInstance().getString("Options.aceptar_label"),
                                SgaRecursos.getInstance().getString("Options.cancelar_label") };

          int res = JOptionPane.showOptionDialog(
                Interflex.getInstance(),                                       // the parent that the dialog blocks
                "Assignar existencia a comanda " + idCabnum + " línia " + idLin,                                    // the dialog message array
                "Confirmar assignació", // the title of the dialog window
                JOptionPane.DEFAULT_OPTION,                 // option type
                JOptionPane.QUESTION_MESSAGE,            // message type
                null,
                options2,
                null);
 
          if (res != 0)
          return;


        AppModule app = (AppModule)getPanelBinding().getApplication().getApplicationModule();
        boolean result = app.assignarReservaManual(idDoc, idLin, existRow.getIdart(), existRow.getIdmac(), existRow.getCantot());
        if (result)
        {
          app.getTransaction().commit();
          JOptionPane.showMessageDialog(null, "Assignació manual realitzada");
        }
        else
          JOptionPane.showMessageDialog(null, "No s'ha pogut realitzar l'assignació manual");
        
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

     int colIndex = tableSgavexistenciaView2.getColumnIndex("Bloqueo");
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

 // Michael ReservaManual 09.10.2014
 public void setIddoc (oracle.jbo.domain.Number iddoc, oracle.jbo.domain.Number idlin, String idcabnum)
 {
   idDoc = iddoc;
   idLin = idlin;
   idCabnum = idcabnum;
 }
 
 public void setIddocTL (oracle.jbo.domain.Number iddoc)
 {
   idDocTL = iddoc;
 }
 
   private void setEspecial()
  {
      SgavexistenciaViewRow existRow = (SgavexistenciaViewRow)panelBinding.findIteratorBinding("SgavexistenciaView2Iter").getCurrentRow(); 
      AppModule appModule = (AppModule)panelBinding.getApplication().getApplicationModule();
      if (ExistenciaEspecialSetter.set(appModule, existRow))
     
     {
       
        appModule.getTransaction().commit();
        panelBinding.findIteratorBinding("SgavexistenciaView2Iter").executeQuery();

     }

  }
 

}