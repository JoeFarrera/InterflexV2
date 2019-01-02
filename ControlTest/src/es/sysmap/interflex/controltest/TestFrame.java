package es.sysmap.interflex.controltest;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.Rectangle;

public class TestFrame extends JFrame 
{
  private ImageIcon imageHelp = new ImageIcon(TestFrame.class.getResource("help.gif"));
  private ImageIcon imageClose = new ImageIcon(TestFrame.class.getResource("closefile.gif"));
  private ImageIcon imageOpen = new ImageIcon(TestFrame.class.getResource("openfile.gif"));
  private JButton buttonHelp = new JButton();
  private JButton buttonClose = new JButton();
  private JButton buttonOpen = new JButton();
  private JToolBar toolBar = new JToolBar();
  private JLabel statusBar = new JLabel();
  private JMenuItem menuHelpAbout = new JMenuItem();
  private JMenu menuHelp = new JMenu();
  private JMenuItem menuFileExit = new JMenuItem();
  private JMenu menuFile = new JMenu();
  private JMenuBar menuBar = new JMenuBar();
  private JPanel panelCenter = new JPanel();
  private BorderLayout layoutMain = new BorderLayout();

  public TestFrame()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  private void jbInit() throws Exception
  {
    this.setJMenuBar(menuBar);
    this.getContentPane().setLayout(layoutMain);
    panelCenter.setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Control Tests TestFrame");
    menuFile.setText("File");
    menuFileExit.setText("Exit");
    menuFileExit.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          fileExit_ActionPerformed(ae);
        }
      });
    menuHelp.setText("Help");
    menuHelpAbout.setText("About");
    menuHelpAbout.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae)
        {
          helpAbout_ActionPerformed(ae);
        }
      });
    statusBar.setText("");
    buttonOpen.setToolTipText("Open File");
    buttonOpen.setIcon(imageOpen);
    buttonClose.setToolTipText("Close File");
    buttonClose.setIcon(imageClose);
    buttonHelp.setToolTipText("About");
    buttonHelp.setIcon(imageHelp);
    menuFile.add(menuFileExit);
    menuBar.add(menuFile);
    menuHelp.add(menuHelpAbout);
    menuBar.add(menuHelp);
    this.getContentPane().add(statusBar, BorderLayout.SOUTH);
    toolBar.add(buttonOpen);
    toolBar.add(buttonClose);
    toolBar.add(buttonHelp);
    this.getContentPane().add(toolBar, BorderLayout.NORTH);
    this.getContentPane().add(panelCenter, BorderLayout.CENTER);
  }

  void fileExit_ActionPerformed(ActionEvent e)
  {
    System.exit(0);
  }

  void helpAbout_ActionPerformed(ActionEvent e)
  {
    JOptionPane.showMessageDialog(this, new TestFrame_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
  }
}