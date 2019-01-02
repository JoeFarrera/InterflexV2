package es.sysmap.interflex.view;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import oracle.jbo.uicli.jui.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.binding.*;
import oracle.jdeveloper.layout.*;
import oracle.adf.model.*;
import oracle.adf.model.binding.*;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class TestJTable extends JPanel implements JUPanel 
{
// Panel binding definition used by design time
  private JUPanelBinding panelBinding = new JUPanelBinding("TestJTableUIModel");
  private JTable table = null;
  private Object[][] cellData = 
  {
    {"1-1", "1-2"},
    {"2-1", "2-2"}
  };
  private String[] columnNames = {"col1", "col2"};
  private BorderLayout borderLayout1 = new BorderLayout();

  /**
   * 
   *  The default constructor for panel
   */
  public TestJTable()
  {
    System.out.println("this is: " + getClass().toString());
  }

  /**
   * 
   *  the JbInit method
   */
  public void jbInit() throws Exception
  {
    this.setLayout(borderLayout1);
    // Create a table with empty cells
    int rows = 10;
    int cols = 2;
    table = new JTable(rows, cols);
    
    // Create a table with initial data
    Vector rowData = new Vector();
    for (int i=0; i<cellData.length; i++) {
        Vector colData = new Vector(Arrays.asList(cellData[i]));
        rowData.add(colData);
    }
    Vector columnNamesV = new Vector(Arrays.asList(columnNames));
    
    table = new JTable(rowData, columnNamesV);
    this.add(table, BorderLayout.CENTER);
    
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

    TestJTable panel = new TestJTable();
    panel.setBindingContext(JUTestFrame.startTestFrame("DataBindings.cpx", "null", panel, panel.getPanelBinding(), new Dimension(400, 300)));
    panel.revalidate();
  }

  /**
   * 
   *  JUPanel implementation
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