package sgalib;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import oracle.jbo.AttributeDef;
import oracle.jbo.StructureDef;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.jui.JUTableBinding;
import oracle.jbo.uicli.jui.JUTableSortModel;
import org.jfree.report.Boot;
import org.jfree.report.ElementAlignment;
import org.jfree.report.ItemBand;
import org.jfree.report.JFreeReport;
import org.jfree.report.PageFooter;
import org.jfree.report.PageHeader;
import org.jfree.report.ReportFooter;
import org.jfree.report.ReportHeader;
import org.jfree.report.TextElement;
import org.jfree.report.elementfactory.ImageFieldElementFactory;
import org.jfree.report.elementfactory.LabelElementFactory;
import org.jfree.report.elementfactory.NumberFieldElementFactory;
import org.jfree.report.elementfactory.StaticShapeElementFactory;
import org.jfree.report.elementfactory.ShapeElementFactory;
import org.jfree.report.elementfactory.DateFieldElementFactory;
import org.jfree.report.elementfactory.TextFieldElementFactory;
import org.jfree.report.function.ElementVisibilitySwitchFunction;
import org.jfree.report.function.ExpressionCollection;
import org.jfree.report.function.FunctionInitializeException;
import org.jfree.report.function.PageFunction;
import org.jfree.report.function.PageTotalFunction;
import org.jfree.report.function.TextFormatExpression;
import org.jfree.report.modules.gui.base.PreviewDialog;
import org.jfree.report.style.ElementStyleSheet;
import org.jfree.report.style.FontDefinition;
import org.jfree.report.util.WaitingImageObserver;
import org.jfree.ui.FloatDimension;


public class Report 
{
  JUTableSortModel tableSortModel;
  String titol;
  int orientacio;
  ViewObject vo;
  public Report(JUTableSortModel tableSortModel)
  {
    this.tableSortModel = tableSortModel;
    vo = tableSortModel.getTableBinding().getViewObject();
    //Busquem el titol com a propietat de la taula  
    titol = (String)vo.getProperty("ReportTitle");
    if (titol == null)
      titol = "Título no especificado";
    String orientacio = (String)vo.getProperty("ReportOrientation");
    if (orientacio != null && orientacio.equals("PageFormat.LANDSCAPE"))
      this.orientacio = PageFormat.LANDSCAPE;
    else
      this.orientacio = PageFormat.PORTRAIT;
  }
  
  /**
   * Creates the report.
   *
   * @return the constructed report.
   *
   * @throws FunctionInitializeException if there was a problem initialising any of the functions.
   */
  public JFreeReport createReport() throws FunctionInitializeException
  {
    final JFreeReport report = new JFreeReport();
    report.setName(titol); 
    report.getDefaultPageFormat().setOrientation(orientacio);    
    Image image = SgaRecursos.createImageIcon(getClass(), "logo.jpg", null).getImage();
    WaitingImageObserver obs = new WaitingImageObserver(image);
    obs.waitImageLoaded();
    report.setProperty("logo", image);
    report.setPropertyMarked("logo", true);    
    //report.setReportFooter(createReportFooter());
    report.setReportHeader(createReportHeader());
    report.setPageFooter(createPageFooter());
    report.setPageHeader(createPageHeader());
    //report.setGroups(createGroups());
    report.setItemBand(createItemBand());
    report.setFunctions(createFunctions());
    report.setExpressions(createExpressions());
    report.setPropertyMarked("report.date", true);
    return report;
  }

  /**
   * Creates the report footer.
   *
   * @return the report footer.
   */
  private ReportFooter createReportFooter()
  {
    final ReportFooter footer = new ReportFooter();
    footer.getStyle().setStyleProperty
        (ElementStyleSheet.MINIMUMSIZE, new FloatDimension(0, 48));
    footer.getBandDefaults().setFontDefinitionProperty
        (new FontDefinition("Serif", 16, true, false, false, false));
    
    
    final LabelElementFactory factory = new LabelElementFactory();
    factory.setName("Label 2");
    factory.setAbsolutePosition(new Point2D.Float(0, 0));
    factory.setMinimumSize(new FloatDimension(-100, 24));
    factory.setHorizontalAlignment(ElementAlignment.CENTER);
    factory.setVerticalAlignment(ElementAlignment.MIDDLE);
    factory.setText("*** END OF REPORT ***");
    footer.addElement(factory.createElement());
    return footer;
  }
  
  /**
   * Creates the report header.
   *
   * @return the report header.
   */
  private ReportHeader createReportHeader()
  {
    final ReportHeader header = new ReportHeader();
    header.getStyle().setStyleProperty
        (ElementStyleSheet.MINIMUMSIZE, new FloatDimension(0, 48));
    header.getBandDefaults().setFontDefinitionProperty
        (new FontDefinition("Serif", 20, true, false, false, false));
    //logo de l'empresa
    header.addElement(ImageFieldElementFactory.createImageDataRowElement("logo",
            new Rectangle2D.Float(0, 0, 86, 33),
            "logo"));
    //fi logo de l'empresa
    final LabelElementFactory factory = new LabelElementFactory();
    factory.setName("Label 1");
    factory.setAbsolutePosition(new Point2D.Float(0, 0));
    factory.setMinimumSize(new FloatDimension(-100, 24));
    factory.setHorizontalAlignment(ElementAlignment.CENTER);
    factory.setVerticalAlignment(ElementAlignment.MIDDLE);    
    factory.setText(titol);
    header.addElement(factory.createElement());
    
    //filtre de la consulta
   // filtre de la consulta
    int begin = vo.getQuery().indexOf("WHERE") + 6;
    int end = vo.getQuery().indexOf("ORDER");
    String filtro = null;
    if (begin != -1 && end != -1)
      filtro = vo.getQuery().substring(begin, end);
    else
    {
      if (begin != -1)
        filtro = vo.getQuery().substring(begin);
      else
        filtro = "";      
    }
    // filtre
    final LabelElementFactory fieldFiltre = new LabelElementFactory();
    fieldFiltre.setName("Label 1");
    fieldFiltre.setAbsolutePosition(new Point2D.Float(0, 0));
    fieldFiltre.setMinimumSize(new FloatDimension(-100, -100));
    fieldFiltre.setHorizontalAlignment(ElementAlignment.LEFT);
    fieldFiltre.setVerticalAlignment(ElementAlignment.TOP);    
    fieldFiltre.setText("Filtro aplicado: " + filtro);
    fieldFiltre.setFontName("Serif");
    fieldFiltre.setFontSize(new Integer(10));
    //header.addElement(fieldFiltre.createElement());

    header.addElement(
        StaticShapeElementFactory.createRectangleShapeElement(
            "anonymous", Color.decode("#AFAFAF"), new BasicStroke(0),
            new Rectangle2D.Float(0, 84, -100, -100),
            false, true)
    );

    header.addElement(
        StaticShapeElementFactory.createLineShapeElement(
            "line1", Color.decode("#CFCFCF"), new BasicStroke(2),
            new Line2D.Float(0, 96, 0, 60))
    );

    AttributeDef[] attrs = tableSortModel.getTableBinding().getAttributeDefs();
    
    //for (int i = 0; i < tableSortModel.getColumnCount(); i++)
    int x = 0;
    for (int i = 0; i < attrs.length; i++)
    {
      int width = (attrs[i].getPrecision() > 0 ? attrs[i].getPrecision()*4 : 20*4);
      if (width < attrs[i].getUIHelper().getLabel(null).length()*4)
        width = attrs[i].getUIHelper().getLabel(null).length()*4;
      final LabelElementFactory field = new LabelElementFactory();
      field.setName("Label" + attrs[i].getColumnName());
      field.setAbsolutePosition(new Point2D.Float(x, 84));
      
      field.setMinimumSize(new FloatDimension(width, 8));
      field.setHorizontalAlignment(ElementAlignment.LEFT);
      field.setVerticalAlignment(ElementAlignment.TOP);    
      field.setText(attrs[i].getUIHelper().getLabel(null));
      field.setFontName("Serif");
      field.setFontSize(new Integer(8));
      header.addElement(field.createElement());
      //System.out.println(attrs[i].getUIHelper().getLabel(null));
      x = x + (width + 5);
    }
    
    return header;
    
  }


  /**
   * Creates a page footer.
   *
   * @return The page footer.
   */
  private PageFooter createPageFooter()
  {
    final PageFooter pageFooter = new PageFooter();
    pageFooter.getStyle().setStyleProperty
        (ElementStyleSheet.MINIMUMSIZE, new FloatDimension(0, 30));
    pageFooter.getBandDefaults().setFontDefinitionProperty(new FontDefinition("Dialog", 10));

    pageFooter.addElement(StaticShapeElementFactory.createRectangleShapeElement
        (null, Color.black, null, new Rectangle2D.Float(0, 0, -100, -100), true, false));

    final DateFieldElementFactory date = new DateFieldElementFactory();
    date.setName("date1");
    date.setAbsolutePosition(new Point2D.Float(0, 0));
    date.setMinimumSize(new FloatDimension(-100, -100));
    date.setHorizontalAlignment(ElementAlignment.LEFT);
    date.setVerticalAlignment(ElementAlignment.MIDDLE);
    date.setFormatString("dd/MM/yyyy HH:mm:ss");
    date.setNullString("<null>");
    date.setFieldname("report.date");
    //factory.setText("Some Text for the page footer");
    date.setDynamicHeight(Boolean.TRUE);
    pageFooter.addElement(date.createElement());


    final TextElement paginaField = TextFieldElementFactory.createStringElement(
            "Pagina",
            new Rectangle2D.Float(0, 0, -100, -100),
            Color.black,
            ElementAlignment.CENTER,
            ElementAlignment.MIDDLE,
            null,
            "Page 0",
            "pagina"
    );

    paginaField.getStyle().setFontDefinitionProperty(new FontDefinition("SansSerif",
        10, true, false, false, false));
    pageFooter.addElement(paginaField);

    return pageFooter;
    
/*  TextElement userField = ItemFactory.createStringElement(
    "user",
    new Rectangle2D.Float(0, 0, -100, -100),
    null,
    ElementAlignment.RIGHT.getOldAlignment(),
    ElementAlignment.MIDDLE.getOldAlignment(),
    null, // font
    "-", // null string
    "user.name"
    );
    userField.getStyle().setFontDefinitionProperty(new FontDefinition("SansSerif",
        10, true, false, false, false));
    pageFooter.addElement(userField);

  */
  }



  private PageHeader createPageHeader()
  {
    final PageHeader header = new PageHeader();
    header.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE, new FloatDimension(0, 18));
    header.getBandDefaults().setFontDefinitionProperty(new FontDefinition("Serif", 8, true, false, false, false));
    header.setDisplayOnFirstPage(false);
    header.setDisplayOnLastPage(true);


    header.addElement(
        StaticShapeElementFactory.createRectangleShapeElement(
            "anonymous", Color.decode("#AFAFAF"), new BasicStroke(0),
            new Rectangle2D.Float(0, 0, -100, -100),
            false, true)
    );

    header.addElement(
        StaticShapeElementFactory.createLineShapeElement(
            "line1", Color.decode("#CFCFCF"), new BasicStroke(2),
            new Line2D.Float(0, 16, 0, 16))
    );

    AttributeDef[] attrs = tableSortModel.getTableBinding().getAttributeDefs();
    
    //for (int i = 0; i < tableSortModel.getColumnCount(); i++)
    int x = 0;
    for (int i = 0; i < attrs.length; i++)
    {
      int width = (attrs[i].getPrecision() > 0 ? attrs[i].getPrecision()*4 : 20*4);
      if (width < attrs[i].getUIHelper().getLabel(null).length()*4)
        width = attrs[i].getUIHelper().getLabel(null).length()*4;
      final LabelElementFactory field = new LabelElementFactory();
      field.setName("Label" + attrs[i].getColumnName());
      field.setAbsolutePosition(new Point2D.Float(x, 0));
      field.setMinimumSize(new FloatDimension(width, 8));
      field.setHorizontalAlignment(ElementAlignment.LEFT);
      field.setVerticalAlignment(ElementAlignment.TOP);    
      field.setText(attrs[i].getUIHelper().getLabel(null));
      header.addElement(field.createElement());
      //System.out.println(attrs[i].getUIHelper().getLabel(null));
      x = x + (width + 5);
    }
    return header;  
  }
  


  /**
   * The itemBand as in the xml definition:
   *
   <pre>
   <items height="10" fontname="Monospaced" fontstyle="plain" fontsize="8">
   <rectangle name="background" x="0" y="0" width="100%" height="100%" color="#DFDFDF" weight="0"/>
   <line name="top" x1="0" y1="0" x2="0" y2="0" color="#DFDFDF" weight="0.1"/>
   <line name="bottom" x1="0" y1="10" x2="0" y2="10" color="#DFDFDF" weight="0.1"/>
   <string-field name="Country Element" x="0" y="0" width="176" height="8" alignment="left"
   fieldname="Country" />
   <string-field name="Code Element" x="180" y="0" width="76" height="8" alignment="left"
   fieldname="ISO Code"/>
   <number-field name="Population Element" x="260" y="0" width="76" height="8" alignment="right"
   format="#,##0" fieldname="Population"/>
   </items>
   </pre>
   *
   * @return the item band.
   */
  private ItemBand createItemBand()
  {
    final ItemBand items = new ItemBand();
    items.getStyle().setStyleProperty
        (ElementStyleSheet.MINIMUMSIZE, new FloatDimension(0, 10));
    items.getBandDefaults().setFontDefinitionProperty
        (new FontDefinition("Serif", 8));
    items.addElement(StaticShapeElementFactory.createRectangleShapeElement
        ("background", Color.decode("#DFDFDF"),new BasicStroke(0),
            new Rectangle2D.Float(0, 0, -100, -100), false, true));
    items.addElement(StaticShapeElementFactory.createLineShapeElement
        ("top", Color.decode("#DFDFDF"), new BasicStroke(0.1f),
            new Line2D.Float(0, 0, 0, 0)));
    items.addElement(StaticShapeElementFactory.createLineShapeElement
        ("bottom", Color.decode("#DFDFDF"), new BasicStroke(0.1f),
            new Line2D.Float(0, 10, 0, 10)));

    AttributeDef[] attrs = tableSortModel.getTableBinding().getAttributeDefs();
    
    //for (int i = 0; i < tableSortModel.getColumnCount(); i++)
    int x = 0;
    for (int i = 0; i < attrs.length; i++)
    {
      int width = (attrs[i].getPrecision() > 0 ? attrs[i].getPrecision()*4 : 20*4);
      if (width < attrs[i].getUIHelper().getLabel(null).length()*4)
        width = attrs[i].getUIHelper().getLabel(null).length()*4;
      TextFieldElementFactory field = new TextFieldElementFactory();
      field.setName("Field" + attrs[i].getColumnName());
      field.setAbsolutePosition(new Point2D.Float(x, 0));
      field.setMinimumSize(new FloatDimension(width, 8));
      field.setHorizontalAlignment(ElementAlignment.LEFT);
      field.setVerticalAlignment(ElementAlignment.TOP);  
      field.setNullString("<null>");
      field.setFieldname(attrs[i].getUIHelper().getLabel(null));
      items.addElement(field.createElement());
      x = x + (width + 5);
    }

    return items;
  }

  
  /**
   * Creates the function collection. The xml definition for this construct:
   *
   <pre>
   <functions>
   <function name="sum" class="com.jrefinery.report.function.ItemSumFunction">
   <properties>
   <property name="field">Population</property>
   <property name="group">Continent Group</property>
   </properties>
   </function>
   <function name="backgroundTrigger"
   class="com.jrefinery.report.function.ElementVisibilitySwitchFunction">
   <properties>
   <property name="element">background</property>
   </properties>
   </function>
   </functions>
   </pre>
   *
   * @return the functions.
   *
   * @throws FunctionInitializeException if there is a problem initialising the functions.
   */
  private ExpressionCollection createFunctions() throws FunctionInitializeException
  {
    final ExpressionCollection functions = new ExpressionCollection();

    /*final ItemSumFunction sum = new ItemSumFunction();
    sum.setName("sum");
    sum.setProperty("field", "Population");
    sum.setProperty("group", "Continent Group");
    functions.add(sum);*/
    
    final PageFunction pageNumber = new PageFunction();
    pageNumber.setName("PageNumber");
    functions.add(pageNumber);

    final PageTotalFunction pageTotal = new PageTotalFunction();
    pageTotal.setName("PageTotal");
    functions.add(pageTotal);
       
    final ElementVisibilitySwitchFunction backgroundTrigger = new ElementVisibilitySwitchFunction();
    backgroundTrigger.setName("backgroundTrigger");
    backgroundTrigger.setProperty("element", "background");
    functions.add(backgroundTrigger);
    return functions;
  }


  /**
   * Creates the expressions collection. The xml definition for this construct:
   *
   <pre>
   <functions>
   <function name="sum" class="com.jrefinery.report.function.ItemSumFunction">
   <properties>
   <property name="field">Population</property>
   <property name="group">Continent Group</property>
   </properties>
   </function>
   <function name="backgroundTrigger"
   class="com.jrefinery.report.function.ElementVisibilitySwitchFunction">
   <properties>
   <property name="element">background</property>
   </properties>
   </function>
   </functions>
   </pre>
   *
   * @return the expressions.
   *
   * @throws FunctionInitializeException if there is a problem initialising the functions.
   */
  private ExpressionCollection createExpressions() throws FunctionInitializeException
  {
    final ExpressionCollection expressions = new ExpressionCollection();
      
    final TextFormatExpression pagina = new TextFormatExpression();
    pagina.setName("pagina");
    pagina.setProperty("pattern","Página {0,number,integer} de {1,number,integer}");
    pagina.setProperty("0", "PageNumber");
    pagina.setProperty("1","PageTotal");    
    expressions.add(pagina);

    return expressions;
  }

  
  public void test()
  {
    AttributeDef[] attrs = tableSortModel.getTableBinding().getAttributeDefs();
    
    //for (int i = 0; i < tableSortModel.getColumnCount(); i++)
    for (int i = 0; i < attrs.length; i++)
    {
      //System.out.println(attrs[i].getColumnName());
      System.out.println(attrs[i].getUIHelper().getLabel(null));
    }

  }
  
  /**
   * Runs this report and shows a preview dialog.
   *
   * @param args the arguments (ignored).
   * @throws Exception if an error occurs (default: print a stack trace)
   */
  public static void main(final String[] args) throws Exception
  {
    // initialize JFreeReport
    Boot.start();
    JTable table = new JTable();
    JUTableSortModel tableSortModel = (JUTableSortModel)table.getModel();
    //Report report = new Report(tableModel);
    final JFreeReport report = new Report(tableSortModel).createReport();
    report.setData(tableSortModel);

    final PreviewDialog dialog = new PreviewDialog(report);
    dialog.setModal(true);
    dialog.pack();
    dialog.setVisible(true);
  }
}
  
