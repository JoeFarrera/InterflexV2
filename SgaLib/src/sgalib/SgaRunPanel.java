package sgalib;
/*
 * @(#)JUTestFrame.java
 *
 * Copyright 2001-2002 by Oracle Corporation,
 * 500 Oracle Parkway, Redwood Shores, California, 94065, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Oracle Corporation.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.HashMap;

import java.util.Hashtable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFactory;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.JboContext;
import oracle.jbo.uicli.UIMessageBundle;
import oracle.jbo.uicli.controls.JUPanel;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.mom.JUMetaObjectManager;


public class SgaRunPanel extends JPanel
{
   private JUPanelBinding panelBinding = null;
   private DCDataControl dataControl;
   private BindingContext mCtx;
   private boolean bFindMode = false;
   private JPanel panel;

/*   static public SgaRunPanel startRunPanel(String cpxName, String dcName, JPanel panel, JUPanelBinding panelBinding, Dimension size)
   {
      return startRunPanel(cpxName, dcName, panel, panelBinding, size, false);
   }
*/   
   static public SgaRunPanel startRunPanel(String cpxName, String dcName, JPanel panel, JUPanelBinding panelBinding, Dimension size)
   {
      if (!(panel instanceof JUPanel))
      {
         System.err.println(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_ERROR_JCLIENTPANEL));
         return null;
      }

      SgaRunPanel runPanel = new SgaRunPanel(cpxName, dcName, panelBinding, panel);

      runPanel.adjustPanelSize(size);
      return runPanel;
   }
   
   /*
    * Michael 07.02.2006 toString should return the panel
    */
  public String toString()
  {
    if (panel != null)
      return panel.getClass().toString();
    else
      return null;
  }

   public SgaRunPanel(String cpxName, String dcName, JUPanelBinding panelBinding, JPanel panel)
   {
      super();
      this.panel = panel;
      setLayout(new BorderLayout());
      JScrollPane scPane = new JScrollPane(panel);
      add(scPane, BorderLayout.CENTER);
      
      // Xavi, 02/03/05: no cal fer-ho aqui, si es fa des de el main de l'aplicació
      // serveix per tots els panels.
      //if (!SgaMainFrame.getInstance().isDevelopment())
      //  JUMetaObjectManager.setErrorHandler(new SgaJUErrorHandler());
      JUMetaObjectManager.getJUMom().setJClientDefFactory(null);
      
      mCtx = new BindingContext();
      HashMap map = new HashMap(4);
      map.put(DataControlFactory.APP_PARAMS_BINDING_CONTEXT, mCtx);
      JUMetaObjectManager.loadCpx(cpxName, map);

      DCDataControl app = (DCDataControl)mCtx.get(dcName);
      if (app != null)
      {
         dataControl = app;
         app.setClientApp(DCDataControl.JCLIENT);
      }
      else
      {
         mCtx.setClientAppType(DCDataControl.JCLIENT);
      }
      panelBinding = panelBinding.setup(mCtx, null);
      
      //Xavi: 16/10/04 Afegit per poder recuperar el panel binding si cal
      this.panelBinding = panelBinding;
      
      // Xavi: 21/02/05 Afegit per poder establir l'usuari per defecte
      // Agafem l'usuari de l'aplicació del modul principal
      if (app != null) // Michael 07.04.2005
      {
        Hashtable h = app.getApplicationModule().getSession().getEnvironment();
        h.put(JboContext.SECURITY_PRINCIPAL, SgaMainFrame.getInstance().getCurrentUser());
        h.put(JboContext.SECURITY_CREDENTIALS, SgaMainFrame.getInstance().getCurrentPassword());
      }
      
      // Xavi: 06/04/05: Fem que per defecte la transacció tingui activat clearCacheOnCommit()
      panelBinding.getApplication().getApplicationModule().getTransaction().setClearCacheOnCommit(true);
      
   }

   public DCDataControl getDataControl()
   {
      return dataControl;
   }

   public BindingContext getBindingContext()
   {
      return mCtx;
   }

  public void resetPanel()
  {
    if (panelBinding.isTransactionDirty())
      panelBinding.getApplication().getApplicationModule().getTransaction().rollback();
    if (panelBinding.isFindMode())
      panelBinding.setFindMode(false);   
    for (int j = 0; j < panelBinding.getIterBindingList().size(); j++)
    {
       DCIteratorBinding iterBnd = (DCIteratorBinding)panelBinding.getIterBindingList().get(j);
       if (iterBnd.isFindModeAllowed())
        {
         iterBnd.getViewObject().applyViewCriteria(null);
         iterBnd.getViewObject().setWhereClause(null);
        }
    }
    if(!bFindMode)
      panelBinding.execute();
  }
  


/*   static public void testJClientPanel(JPanel panel, JUPanelBinding designTimePanelBinding, Dimension size)
   {
      if (!(panel instanceof JClientPanel))
      {
         System.err.println(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_ERROR_JCLIENTPANEL));
         return;
      }

      SgaRunPanel runPanel = new SgaRunPanel(designTimePanelBinding, panel);

      runPanel.adjustPanelSize(size);

   }
*/
   void adjustPanelSize(Dimension size)
   {
      setSize(size);

      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

      if (size.height > screenSize.height)
      {
         size.height = screenSize.height;
      }
      if (size.width > screenSize.width)
      {
         size.width = screenSize.width;
      }
      setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
      setVisible(true);
   }

   private static final char _MNEMONIC_INDICATOR = '&';
   public static final int MNEMONIC_INDEX_NONE = -1;


  /**
   * 
   *  Retorna el panelBinding
   */
  public JUPanelBinding getPanelBinding()
  {
    return panelBinding;
  }

  public void closePanel()
  {
    try
    {
       panelBinding.releaseDataControl();
       // Xavi, 31/03/05: Si el panel implementa SgaClosePanel, executem el metode closePanel()
       JScrollPane scPane = (JScrollPane)getComponent(0);
       
       if (scPane.getViewport().getComponent(0) instanceof SgaClosePanel)
       {
         SgaClosePanel closePanel = (SgaClosePanel)scPane.getViewport().getComponent(0);
         closePanel.beforeClosePanel();
       }
    }
    catch(Throwable ex)
    {
      System.out.println(ex.getMessage());
    }
    
  }

}