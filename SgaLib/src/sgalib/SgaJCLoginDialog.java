package sgalib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oracle.jbo.JboContext;
import oracle.jbo.common.PropertyConstants;
import oracle.jbo.common.PropertyMetadata;
import oracle.jbo.common.ampool.DefaultConnectionStrategy;
import oracle.jbo.common.ampool.EnvInfoProvider;

/**
 * ATENCIO: Falta revisió d'aquesta documentació!!!
 * Implementa un cuadre de dialeg que identifica l'usuari i estableix les 
 * propietats SECURITY_PRINCIPAL i SECURITY_CREDENTIALS , corresponents a l'
 * usuari i al password de l'ApplicationModule desde el qual es crida, tot i 
 * que no verifica que aquestes siguin correctes. La comprovació es fara en les 
 * funcions habilitades a tal efecte dins aquest ApplicationModule, a instancia 
 * de la sol.licitud feta des de el main() de l'aplicació principal abans d'
 * instanciar el formulari principal.
 * 
 * Per a que funcioni correctament, cal haver establert la propietat 
 * 'jbo.security.enforce' de l'ApplicationModule amb el valor 'Test', per tal 
 * que es mostri automàticament el cuadre de dialeg. El valor 'Test' fa que es 
 * mostri aquest cuadre de dialeg per a que s'identifiqui l'usuari però no el 
 * valida contra JAAS, ja que la validació de l'usuari la fem posteriorment 
 * nosaltres contra les nostres taula d'usuaris.
 *
 * @version 1.00 05/05/2004
 * @author Xavier Marfull
 */

public class SgaJCLoginDialog extends JPanel //implements EnvInfoProvider 
{
  // Layout used by the outer panel
  private BorderLayout outerLayout = new BorderLayout();

  // Layout used by the input panel

  private JPanel inputPanel = new JPanel();
  private GridBagLayout panelLayout = new GridBagLayout();

  // Fields for the user name

  private JLabel labelUserName = new JLabel();
  private JTextField mUserName = new JTextField();

  // Fields for the password

  private JLabel labelPassword = new JLabel();
  private JPasswordField mPassword = new JPasswordField();

  // Error message

  private JLabel mErrorMessage = new JLabel();

  // Parent form

  private JFrame parent;

  // Dialog buttons

  private String [] options = {SgaRecursos.getInstance().getString("Options.aceptar_label"), 
                               SgaRecursos.getInstance().getString("Options.cancelar_label")};

  private String titol = null;

  private Icon keyIcon = SgaRecursos.createImageIcon(getClass(), "48x48/plain/Keys.png", null);
  private JLabel jLabelIcon = new JLabel();

  /**
   * 
   *  The default constructor 
   */
  public SgaJCLoginDialog(String titol)
  {
    this(null, titol);
  }

  /**
   * 
   *  Constructor taking a parent Form as parameter
   */
  public SgaJCLoginDialog(JFrame parent, String titol)
  {
    super();
    this.parent = parent;
    this.titol = titol;
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit()
  {
    // Panel layout

    setLayout(outerLayout);
    this.setPreferredSize(new Dimension(400, 200));
    this.setMinimumSize(new Dimension(400, 200));
    // User name

    inputPanel.setLayout(panelLayout);
    inputPanel.setPreferredSize(new Dimension(300, 200));
    inputPanel.setMinimumSize(new Dimension(300, 200));
    inputPanel.add(labelUserName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    inputPanel.add(mUserName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 165, 1));
    labelUserName.setLabelFor(mUserName);
    mUserName.setToolTipText(SgaRecursos.getInstance().getString("LoginDialog.usuari_tooltip"));
    // Password
    labelUserName.setText(SgaRecursos.getInstance().getString("LoginDialog.usuari_label"));
    inputPanel.add(labelPassword, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 1, 1));
    inputPanel.add(mPassword, new GridBagConstraints(1, 1, 500, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 5), 165, 1));
    labelPassword.setLabelFor(mPassword);
    mPassword.setToolTipText(SgaRecursos.getInstance().getString("LoginDialog.password_tooltip"));
    // Provide initial connection components here (if required)

    labelPassword.setText(SgaRecursos.getInstance().getString("LoginDialog.password_label"));

    inputPanel.add(jLabelIcon, new GridBagConstraints(501, 0, 2, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));

    jLabelIcon.setToolTipText(SgaRecursos.getInstance().getString("LoginDialog.usuari_tooltip"));
    jLabelIcon.setIcon(keyIcon);

    this.add(inputPanel, BorderLayout.CENTER);
    this.add(mErrorMessage, BorderLayout.SOUTH);


  }

  public boolean popupDialog()
  {
    int result = JOptionPane.showOptionDialog(parent, this, SgaRecursos.getInstance().getString("LoginDialog.titol") + titol, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

    switch (result)
      {
      case 0:
        return true;
      default:
        return false;
      }
  }


  /**
   * 
   * Mostra el cuadre de dialeg per desbloquejar l'aplicació
   */
  public boolean popupDialogDesbloquejar()
  {
    int result = JOptionPane.showOptionDialog(parent, this, 
                  SgaRecursos.getInstance().getString("LoginDialog.desbloquejar") + " " + 
                  titol, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

    switch (result)
      {
      case 0:
        return true;
      default:
        return false;
      }
  }
  
  public String getUsuari()
  {
    return mUserName.getText();
  }

  public String getPassword()
  {
    return new String(mPassword.getPassword());
    //return mPassword.getText();Deprecated
  }
  
}