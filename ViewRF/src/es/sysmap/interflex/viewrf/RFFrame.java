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

package es.sysmap.interflex.viewrf;



import java.awt.Dimension;

import java.awt.Event;

import java.awt.Toolkit;

import java.awt.GridLayout;

import java.awt.event.WindowAdapter;                                                               

import java.awt.event.WindowEvent;

import java.awt.event.KeyEvent;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.KeyStroke;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JMenuItem;

import javax.swing.JMenuBar;

import java.util.HashMap;

import oracle.jbo.uicli.UIMessageBundle;

import oracle.jbo.uicli.controls.JUNavigationBar;
import oracle.jbo.uicli.controls.JUPanel;
import oracle.jbo.uicli.controls.JUTestFrame;
import oracle.jbo.uicli.jui.JUPanelBinding;

import oracle.jbo.uicli.jui.JUEnvInfoProvider;

import oracle.jbo.uicli.controls.JUErrorHandlerDlg;

import oracle.jbo.uicli.controls.JClientPanel;

import oracle.jbo.uicli.binding.JUApplication;

import oracle.jbo.uicli.mom.JUMetaObjectManager;

import oracle.adf.model.BindingContext;

import oracle.adf.model.DataControlFactory;

import oracle.adf.model.binding.DCDataControl;



public class RFFrame extends JFrame

{

   private JUPanelBinding panelBinding = null;

   private DCDataControl dataControl;

   private BindingContext mCtx;



   private JMenuBar menubarFrame = new JMenuBar();



   private JMenu menuFile = new JMenu();

   private JMenuItem itemFileExit = new JMenuItem();



   private JMenu menuDatabase = new JMenu();

   private JMenuItem itemDatabaseFirst = new JMenuItem();

   private JMenuItem itemDatabasePrevious = new JMenuItem();

   private JMenuItem itemDatabaseNext = new JMenuItem();

   private JMenuItem itemDatabaseLast = new JMenuItem();

   private JMenuItem itemDatabaseInsert = new JMenuItem();

   private JMenuItem itemDatabaseDelete = new JMenuItem();

   private JMenuItem itemDatabaseCommit = new JMenuItem();

   private JMenuItem itemDatabaseRollback = new JMenuItem();

   private JMenuItem itemFindMode = new JMenuItem();

   private JMenuItem itemExecute = new JMenuItem();



   JUNavigationBar menuNavBar = new JUNavigationBar()

   {

      protected void _updateButtonStates()

      {

         super._updateButtonStates();

         menuItemsUpdate();

      }

   };



   static public BindingContext startTestFrame(String cpxName, String dcName, JPanel panel, JUPanelBinding panelBinding, Dimension size)

   {

      if (!(panel instanceof JUPanel))

      {

         System.err.println(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_ERROR_JCLIENTPANEL));

         return null;

      }



      RFFrame frame = new RFFrame(cpxName, dcName, panelBinding, panel);



      frame.adjustFrameSize(size);

      return frame.getBindingContext();

   }



   public RFFrame(JUPanelBinding designTimePanelBinding, JPanel panel)

   {

      super(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_TEST_TITLE));

      getContentPane().setLayout(new GridLayout());

      JScrollPane scPane = new JScrollPane(panel);

      getContentPane().add(scPane);



      JUMetaObjectManager.setBaseErrorHandler(new JUErrorHandlerDlg());

      

      //mom will pass properties in case it's null

      JUApplication app = JUMetaObjectManager.createApplicationObject(designTimePanelBinding.getApplicationName(), null, new JUEnvInfoProvider());



      panelBinding = new JUPanelBinding(designTimePanelBinding.getApplicationName(), panel);

      panelBinding.setApplication(app);

      ((JClientPanel)panel).setPanelBinding(panelBinding);



      menuNavBar.setModel(JUNavigationBar.createPanelBinding(panelBinding, menuNavBar));



      panelBinding.execute();

      dataControl = app;

      setupMenu();

   }



   public RFFrame(String cpxName, String dcName, JUPanelBinding panelBinding, JPanel panel)

   {

      super(panel.getName());

      getContentPane().setLayout(new GridLayout());

      JScrollPane scPane = new JScrollPane(panel);

      getContentPane().add(scPane);



      JUMetaObjectManager.setBaseErrorHandler(new JUErrorHandlerDlg());

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



      menuNavBar.setModel(JUNavigationBar.createPanelBinding(panelBinding, menuNavBar));

      setupMenu();

   }



   public DCDataControl getDataControl()

   {

      return dataControl;

   }



   public BindingContext getBindingContext()

   {

      return mCtx;

   }



   void setupMenu()

   {

      setJMenuBar(menubarFrame);



      itemFileExit.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_EXIT)));

      itemFileExit.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_EXIT)));

      itemFileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK, false));



      itemFileExit.addActionListener(new ActionListener()

                                     {

                                        public void actionPerformed(ActionEvent e)

                                        {

                                           if ( panelBinding != null )

                                               panelBinding.releaseDataControl();

                                           System.exit(0);

                                        }

                                     });

      menuFile.add(itemFileExit);

      menuFile.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_FILE)));

      menuFile.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_FILE)));



      menubarFrame.add(menuFile);



      menuDatabase.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_DATABASE)));

      menuDatabase.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_DATABASE)));



      itemDatabaseFirst.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_FIRST)));

      itemDatabaseFirst.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_FIRST)));

      itemDatabaseFirst.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, Event.ALT_MASK, false));

      itemDatabaseFirst.addActionListener(new ActionListener()

                                          {

                                             public void actionPerformed(ActionEvent e)

                                             {

                                                menuNavBar.doAction(JUNavigationBar.BUTTON_FIRST);

                                             }

                                          });



      menuDatabase.add(itemDatabaseFirst);



      itemDatabasePrevious.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_PREVIOUS)));

      itemDatabasePrevious.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_PREVIOUS)));

      itemDatabasePrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, Event.ALT_MASK, false));

      itemDatabasePrevious.addActionListener(new ActionListener()

                                             {

                                                public void actionPerformed(ActionEvent e)

                                                {

                                                   menuNavBar.doAction(JUNavigationBar.BUTTON_PREV);

                                                }

                                             });



      menuDatabase.add(itemDatabasePrevious);



      itemDatabaseNext.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_NEXT)));

      itemDatabaseNext.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_NEXT)));

      itemDatabaseNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, Event.ALT_MASK, false));

      itemDatabaseNext.addActionListener(new ActionListener()

                                         {

                                            public void actionPerformed(ActionEvent e)

                                            {

                                               menuNavBar.doAction(JUNavigationBar.BUTTON_NEXT);

                                            }

                                         });



      menuDatabase.add(itemDatabaseNext);



      itemDatabaseLast.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_LAST)));

      itemDatabaseLast.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_LAST)));

      itemDatabaseLast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_END, Event.ALT_MASK, false));

      itemDatabaseLast.addActionListener(new ActionListener()

                                         {

                                            public void actionPerformed(ActionEvent e)

                                            {

                                               menuNavBar.doAction(JUNavigationBar.BUTTON_LAST);

                                            }

                                         });



      menuDatabase.add(itemDatabaseLast);



      itemDatabaseInsert.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_INSERT)));

      itemDatabaseInsert.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_INSERT)));

      itemDatabaseInsert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0, false));

      itemDatabaseInsert.addActionListener(new ActionListener()

                                           {

                                              public void actionPerformed(ActionEvent e)

                                              {

                                                 menuNavBar.doAction(JUNavigationBar.BUTTON_INSERT);

                                              }

                                           });



      menuDatabase.add(itemDatabaseInsert);



      itemDatabaseDelete.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_DELETE)));

      itemDatabaseDelete.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_DELETE)));

      itemDatabaseDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, false));

      itemDatabaseDelete.addActionListener(new ActionListener()

                                           {

                                              public void actionPerformed(ActionEvent e)

                                              {

                                                 menuNavBar.doAction(JUNavigationBar.BUTTON_DELETE);

                                              }

                                           });



      menuDatabase.add(itemDatabaseDelete);



      itemDatabaseCommit.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_COMMIT)));

      itemDatabaseCommit.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_COMMIT)));

      itemDatabaseCommit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.ALT_MASK, false));

      itemDatabaseCommit.addActionListener(new ActionListener()

                                           {

                                              public void actionPerformed(ActionEvent e)

                                              {

                                                 menuNavBar.doAction(JUNavigationBar.BUTTON_COMMIT);

                                              }

                                           });



      menuDatabase.add(itemDatabaseCommit);



      itemDatabaseRollback.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_ROLLBACK)));

      itemDatabaseRollback.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_ROLLBACK)));

      itemDatabaseRollback.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.ALT_MASK, false));

      itemDatabaseRollback.addActionListener(new ActionListener()

                                             {

                                                public void actionPerformed(ActionEvent e)

                                                {

                                                   menuNavBar.doAction(JUNavigationBar.BUTTON_ROLLBACK);

                                                }

                                             });



      menuDatabase.add(itemDatabaseRollback);



      itemFindMode.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_QUERYMODE)));

      itemFindMode.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_QUERYMODE)));

      itemFindMode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.ALT_MASK, false));

      itemFindMode.addActionListener(new ActionListener()

                                     {

                                        public void actionPerformed(ActionEvent e)

                                        {

                                           menuNavBar.doAction(JUNavigationBar.BUTTON_FIND);

                                        }

                                     });



      menuDatabase.add(itemFindMode);

      itemExecute.setText(stripMnemonic(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_QUERYEXECUTE)));

      itemExecute.setMnemonic(getMnemonicKeyCode(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_MENU_QUERYEXECUTE)));

      itemExecute.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.ALT_MASK, false));

      itemExecute.addActionListener(new ActionListener()

                                    {

                                       public void actionPerformed(ActionEvent e)

                                       {

                                          menuNavBar.doAction(JUNavigationBar.BUTTON_EXECUTE);

                                       }

                                    });



      menuDatabase.add(itemExecute);



      menubarFrame.add(menuDatabase);



      addWindowListener(new WindowAdapter()

                        {

                           public void windowClosing(WindowEvent e)

                           {

                              if ( panelBinding != null )

                                  panelBinding.releaseDataControl();

                              System.exit(0);

                           }

                        });



      menuItemsUpdate();

   }



   private void menuItemsUpdate()

   {



     itemDatabaseFirst.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_FIRST));

     itemDatabasePrevious.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_PREV));

     itemDatabaseLast.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_LAST));

     itemDatabaseNext.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_NEXT));

     itemDatabaseInsert.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_INSERT));

     itemDatabaseDelete.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_DELETE));

     itemDatabaseCommit.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_COMMIT));

     itemDatabaseRollback.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_ROLLBACK));

     itemFindMode.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_FIND));

     itemExecute.setEnabled(menuNavBar.isButtonActive(JUNavigationBar.BUTTON_EXECUTE));

   }



   static public void testJClientPanel(JPanel panel, JUPanelBinding designTimePanelBinding, Dimension size)

   {

      if (!(panel instanceof JClientPanel))

      {

         System.err.println(UIMessageBundle.getResString(UIMessageBundle.STR_TUI_ERROR_JCLIENTPANEL));

         return;

      }



      RFFrame frame = new RFFrame(designTimePanelBinding, panel);



      frame.adjustFrameSize(size);



   }



   void adjustFrameSize(Dimension size)

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

  * Returns the key code for the mnemonic in the string.  Returns

  * VK_UNDEFINED if the string does not contain a mnemonic.

  */

   public int getMnemonicKeyCode(String string)

   {

      if (string == null)

         return KeyEvent.VK_UNDEFINED;



      // Minus one, because a trailing ampersand doesn't count

      int lengthMinusOne = string.length() - 1;

      int i = 0;       // Index in the source sting



      while (i < lengthMinusOne)

      {

         int index = string.indexOf(_MNEMONIC_INDICATOR, i);

         // Are we at the end of the string?

         if ((index == -1) || (index >= lengthMinusOne))

            break;



         char ch = string.charAt(index + 1);



         // if this isn't a double ampersand, return

         if (ch != _MNEMONIC_INDICATOR)

         {

            // VK_* constants are all for upper case characters

            return(int) Character.toUpperCase(ch);

         }



         // Skip over the double ampersand

         i = index + 2;

      }



      return KeyEvent.VK_UNDEFINED;

   }



   /**

    * Removes non-displayable inline mnemonic characters.

    * <p>

    * In order to specify a mnemonic character in a translatable string

    * (eg. in a resource file), a special character is used to indicate which 

    * character in the string should be treated as the mnemonic.  This method

    * assumes that an ampersand ('&') character is used as the mnemonic

    * indicator, and removes (single) ampersands from the input string.  A

    * double ampersand sequence is used to indicate that an ampersand should

    * actually appear in the output stream, in which case one of the ampersands

    * is removed.

    * <p>

    * Clients should call this method after calling 

    * StringUtils.getMnemonicIndex() and before displaying the string.  The

    * returned string should be used in place of the input string when 

    * displaying the string to the end user.  The returned string may be the

    * same as the input string if no mnemonic indicator characters are found,

    * but this is not guaranteed.

    * <p>

    * @see #getMnemonicIndex

    */

   public String stripMnemonic(String string)

   {

      if (string == null)

      {

         return null;

      }



      int length = string.length();



      // Single character (or empty) strings can't have a mnemonic

      if (length <= 1)

         return string;



      StringBuffer buffer = null;

      int i = 0;



      while (i < length)

      {

         int index = string.indexOf(_MNEMONIC_INDICATOR, i);



         // We've reached the append.  Append the rest of the

         // string to the buffer, if one exists, then exit

         if ((index < 0) || (index >= length - 1))

         {

            if (buffer != null)

               buffer.append(string.substring(i));



            break;

         }



         if (buffer == null)

         {

            // If the string starts with an ampersand, but not a double

            // ampersand, then we just want to return

            // stripMnemonic(string.substring(1)).  This is basically

            // what we do here, only I've optimized the tail recursion away.

            if ((index == 0) && (string.charAt(1) != _MNEMONIC_INDICATOR))

            {

               string = string.substring(1);

               length--;

               continue;

            }

            else

            {

               // Allocate the buffer.  We can reserve only space

               // (length - 1), because, by now, we know there's at least

               // 1 ampersand

               buffer = new StringBuffer(length - 1);

            }

         }



         // Append the bits of the string before the ampersand

         buffer.append(string.substring(i, index));



         // And append the character after the ampersand

         buffer.append(string.charAt(index + 1));



         // And skip to after that character

         i = index + 2;

      }



      // If we never allocated a buffer, then there's no mnemonic

      // at all, and we can just return the whole string

      if (buffer == null)

         return string;



      return new String(buffer);

   }



}