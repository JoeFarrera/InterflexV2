package sgalib;

import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.swing.JFrame;

import oracle.help.*;
import oracle.help.library.*;
import oracle.help.library.helpset.*;
import oracle.help.navigator.*;
import oracle.help.navigator.tocNavigator.*;

import org.apache.log4j.Logger;

/**
 * Aquesta classe implementa l'acces a l'ajuda de qualsevol aplicació
 * Presuposa que l'ajuda es trobara en el directori 'help'
 * 
 */
public class SgaHelp 
{
  private Help help = null;
  private HelpSet hset = null;
  private Navigator[] nav = null;
  private CSHManager CSHMan = null;
  private JFrame frame = null;
  private Class clase = null;
  
  static Logger LOG = Logger.getLogger("SgaHelp");
  
  public SgaHelp(Class clase, JFrame frame)
  {
    this.clase = clase;
    this.frame = frame;
  }
  
  /*
   * Inicialitza la ajuda de l'aplicació
   */

  public void initHelp()
  {
  
    help = new Help(true, true, true);      
    try
    {
      hset = new HelpSet(clase.getResource("/help/helpset.hs") );        
      help.addBook(hset);
      help.registerClientWindow(frame);
      nav = help.getAllNavigators();
      CSHMan = new CSHManager(help)
  {
          private Hashtable topicName = new Hashtable();

          public void addComponent(java.awt.Component component,
                       java.lang.String topicId,
                       boolean needF1Help,
                       boolean needPopupHelp)
          {
            StringTokenizer tokens = new StringTokenizer(topicId, "_", false);
            String topicGen = tokens.nextToken();
            topicName.put(component, topicGen);
            super.addComponent(component, topicId, needF1Help, needPopupHelp);
          }
        public void showHelpForComponent(java.awt.Component param1)
        {
          String name = (String)topicName.get(param1);
          TOCNavigator toc = (TOCNavigator)nav[0];
          boolean b = toc.selectMatchingTopic(hset.mapIDToURL(name));                        
          super.showHelpForComponent(param1);                       
          
        }
      };        
      CSHMan.setDefaultBook((Book) hset);
      
    }
    catch (HelpSetParseException e)
    {
      LOG.error("Error al inicialitzar l'ajuda", e);
    }
  }


  /**
   * Mostrar la finestra d'Ajuda
   */

  public void showHelpWindow(String topicID)
  {
    help.showNavigatorWindow();
    help.showTopic(hset, topicID);
    TOCNavigator toc = (TOCNavigator)nav[0];
    boolean b = toc.selectMatchingTopic(hset.mapIDToURL(topicID));
  }

  
  public void showNavigatorWindow(int nav)
  {
      if (help != null)
      {
        if (hset != null)
        {
          Navigator[] navs = help.getAllNavigators();
          if (navs != null)
          {
            help.showNavigatorWindow(navs[nav]);
            if (nav == 0)
              help.showTopic(hset, "inici");
          }
        }
        else
          LOG.debug("hset es null");
      }
      else
        LOG.debug("help es null");
  }
  
}