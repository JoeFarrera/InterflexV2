package es.sysmap.interflex.view;
import es.sysmap.interflex.model.dmc.common.AppModule;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import oracle.jbo.ViewObject;
import sgalib.SgaJUNavigationBar;
import sgalib.SgaRecursos;



public class CDocSgaJUNavigationBar extends SgaJUNavigationBar
{
  public static final  int ENTRADA = 1;
  public static final int SALIDA = 2;
  private JButton filtrar = new JButton();
  private JButton filtrarResman = new JButton(SgaRecursos.getInstance().getString("CDocSgaJUNavigationBar.veureResman_label"));
  private  String sWhereNomesAcabats = "(sgacdoc.estado in ('F','A'))";
  private final String sWhereNomesDisponibles = "(not sgacdoc.estado in ('F','A') or (sgacdoc.estcom = 'N' and exists (select * from sgatipdoc where sgatipdoc.idtipdoc = sgacdoc.idtipdoc and host = 'S')))";
  private final String sWhereNomesAmbResman = "((not sgacdoc.estado in ('F','A') or (sgacdoc.estcom = 'N' and exists (select * from sgatipdoc where sgatipdoc.idtipdoc = sgacdoc.idtipdoc and host = 'S'))) and sgacdoc.iddoc in (SELECT c.iddoc " +
                                                  "FROM SGARESMAT r, SGAMAC m, SGAUBICACION u, SGACDOC c " +
                                                  "where r.idmac = m.idmac " +
                                                  "and m.ubipos = u.idubi " +
                                                  "and m.ubides = u.idubi " +
                                                  "and u.idtipalm = 'MAN' " +
                                                  "and c.iddoc = r.iddoc " +
                                                  "and c.imprimir = 'S'))";
  // private final String sWhereMiniLoad = "(sgacdoc.magatzem = 'MLD' or sgacdoc.magatzem is null)";
  // private final String sWhereSilo = "(sgacdoc.magatzem = 'SLO' or sgacdoc.magatzem is null)"; 
  // private final String sWhereBoth = "(sgacdoc.magatzem = 'SLO/MLD' or sgacdoc.magatzem is null)"; 
 //  private final String sWhereGrupatge = "(sgacdoc.tipordsga = 'G')";
 //  private final String sWherePaqueteria = "(sgacdoc.tipordsga = 'P')";
 
 
  private String whereMagatzem = "";
  private String whereGrupatge = "";
  private String whereDisponibles = "(not sgacdoc.estado in ('F','A') or (sgacdoc.estcom = 'N' and exists (select * from sgatipdoc where sgatipdoc.idtipdoc = sgacdoc.idtipdoc and host = 'S')))";
  
  boolean bNomesDisponibles = true;
  private String currFiltroGrupatge = "P";
  private ResmanThread resmanThread = null;
  
  private JPanel buttonPanel = new JPanel (new GridLayout());
  
  private JPanel extraButtonPanel = new JPanel (new FlowLayout());
  private JComboBox filtreMag;
  

  /**
   * Afegeix un boto a la barra de navegació per filtrar els documents
   * segons el seu estat
   */

  public CDocSgaJUNavigationBar()
  {
      super();
   
      filtrar.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            if (bNomesDisponibles)
            {
              setDisponibleAcabat(false, true);
              bNomesDisponibles = false;
              filtrar.setText(SgaRecursos.getInstance().getString("CDocSgaJUNavigationBar.veureDisponibles_label"));
            }
            else
            {
              setDisponibleAcabat(true, true);
              bNomesDisponibles = true;
              // Reset combox filtre magatzem
              if (filtreMag != null)
              
                filtreMag.setSelectedIndex(0);
                
              filtrar.setText(SgaRecursos.getInstance().getString("CDocSgaJUNavigationBar.veureAcabats_label"));
            }
          }
        });
        
      JPanel filtrarPanel = new JPanel(new BorderLayout());


      
      
      
      // Let the client do this buttonPanel.add(filtrar);
      
      filtrarPanel.add(extraButtonPanel, BorderLayout.CENTER);
      filtrarPanel.add(buttonPanel, BorderLayout.EAST);
      
      add (filtrarPanel);

      filtrarResman.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            ViewObject vo= CDocSgaJUNavigationBar.this.getModel().getViewObject();
            vo.setWhereClause(sWhereNomesAmbResman);
            vo.clearCache();
            vo.executeQuery();
            bNomesDisponibles = false;
            filtrar.setText(SgaRecursos.getInstance().getString("CDocSgaJUNavigationBar.veureDisponibles_label"));
          }
        });
      
      // Arranquem el thread que mira si hi ha reserves manuals pendents d'imprimir
      resmanThread = new ResmanThread(this, 10000);
  }

  public void filtrar()
  {
    
    ViewObject vo= CDocSgaJUNavigationBar.this.getModel().getViewObject();
    vo.setWhereClause(getWhereClause());
    vo.clearCache();
    vo.executeQuery();
 
  }
  
  

    
  
  public void setDisponibleAcabat (boolean disponible, boolean filtrar) 
  {
    if (disponible)
    {
      whereDisponibles = "(not sgacdoc.estado in ('F','A') or (sgacdoc.estcom = 'N' and exists (select * from sgatipdoc where sgatipdoc.idtipdoc = sgacdoc.idtipdoc and host = 'S')))";
      this.filtrar.setText(SgaRecursos.getInstance().getString("CDocSgaJUNavigationBar.veureAcabats_label"));
    }
    else
      whereDisponibles = "(sgacdoc.estado in ('F','A'))";
    
    if (filtrar)
      filtrar();
    
      
  }
  
  public void setMagatzem  (String where, boolean filtrar) 
  {
    whereMagatzem = where;
    if (filtrar)
      filtrar();
  }
  
  public void setGrupatge (String where, boolean filtrar)
  {
    whereGrupatge = where;
    if (filtrar)
      filtrar();
  }
  
  private String getWhereClause ()
  {
    String where = whereDisponibles;
    String and = (where != "" && whereMagatzem != "" ) ? " and " : "";
    where = where + and + whereMagatzem;
    and = (where != "" & whereGrupatge != "") ? " and " : "";
    where = where + and + whereGrupatge;
    
    return where;
  }
  
  public void afegirBoto (JButton button) 
  {
    buttonPanel.add (button);
  }
  
  public void afegirBotoFiltrarLegacy ()
  {
    buttonPanel.add (filtrar);
    // set the default to disponible
    setDisponibleAcabat(true, false);
    
  }
  
  public void afegirFiltreMagatzem (JComboBox filtreMag, String label)
  {
    extraButtonPanel.add (new JLabel (label));
    extraButtonPanel.add(filtreMag);
    this.filtreMag = filtreMag;
  }
  
  public void setWhereClause (String whereClause)
  {
        ViewObject vo= CDocSgaJUNavigationBar.this.getModel().getViewObject();
        if (whereClause.length() == 0)
          vo.setWhereClause(sWhereNomesDisponibles);
        else
          vo.setWhereClause(whereClause);
        vo.clearCache();
        vo.executeQuery();
  }
  
  public String getCurrentWhereClause ()
  {
     if (bNomesDisponibles)
      return sWhereNomesDisponibles;
    else
      return sWhereNomesAcabats;
     
  }

  
  
  public void afegirBotoResman()
  {
    add(filtrarResman);
    this.repaint();
  }

  public void treureBotoResman()
  {
    remove(filtrarResman);
    this.repaint();
  }

  class ResmanThread extends Thread
  {
   /**
     *
     * crea el temporizador
     *
     *@param interval - intervalo en milisegundos
     *@param t - fuente del tratamiento al transurrir el intervalo
     *
     */
  
     private int interval;         // Tiempo de espera (en milisegundos)
     private boolean ignore; // Set cuando ya no se necesita
     CDocSgaJUNavigationBar navBar = null;
     private AppModule appModule = null;
     
    public ResmanThread (CDocSgaJUNavigationBar navBar, int timeOutMillis) 
    {
      this.navBar = navBar;
      interval = timeOutMillis;
      ignore = false;
      setDaemon (true);
      
      start();
    }
  
  
    /**
     *
     * arranca el timer
     *
     */
    public void run () {
  
      try {
         ignore = false;
        
         while (!isInterrupted ()) {
          sleep (interval);
          if (! ignore)
          {
            //Intentem recuperar el appModule desde navBar
            if (appModule == null && navBar.getModel() != null)
              appModule = (AppModule)navBar.getModel().getApplication().getApplicationModule();
            if (appModule != null && appModule.hasResmanPendentsImprimir())
              navBar.afegirBotoResman();
            else
              navBar.treureBotoResman();
          }
          else
          {
            ; // alarm.trace("Ignoring eTimeOut");
          }
        }
      }
      catch (InterruptedException e) {
      }
    }
  
    /**
     *
     * fija el intervalo del temporizador
     *
     * @param  interval  - intervalo en milisegundos
     *
     */
    public void setInterval (int interval) {
      this.interval = interval;
    }
  
    /**
     * Set ignore flag
     **/
  
     public void ignore () 
     {
       ignore = true;
     }
  
     public void activate ()
     {
       ignore = false;
     }
    
  }
}