package sgalib;

import javax.swing.*;

import oracle.jbo.*;
import oracle.jbo.uicli.binding.JUFormBinding;
import oracle.jbo.uicli.controls.JUErrorHandlerDlg;

/**
 * Implementa una variant del tractament d'errors standard d'Oracle, per tal que
 * els missatges apareguin en un format més breu i entenedor, dins d'un quadre 
 * de dialeg.
 * 
 * @version 1.00
 * @author Xavier Marfull
 */
public class SgaJUErrorHandler extends JUErrorHandlerDlg 
{
  public synchronized void reportException(JUFormBinding formBnd, java.lang.Exception ex) 
  {
    String msg = null;
    if (SgaMainFrame.getInstance().isDevelopment())
    {
      ex.printStackTrace();
    }
    if (ex instanceof JboException) // filter out the "ORA" message
    {
      JboException jboEx = (JboException)ex;
      msg = jboEx.getMessage() + "\n\n" + ex.getStackTrace()[0].toString();  ;
      int pos = msg.indexOf("ORA-");
      int pos2 = msg.indexOf("\n", pos);
      if (pos > -1 && pos2 > -1)
        msg = msg.substring(pos, pos2).trim();       
      JOptionPane.showMessageDialog(SgaMainFrame.getInstance().getFrame(), msg, "Error", JOptionPane.WARNING_MESSAGE);
    }
    else
    {
      msg = ex.getMessage() + "\n" + ex.getStackTrace()[0].toString();
      //msg = ex.getMessage();      
      //if (msg == null || msg.trim().length() == 0)
      //  msg = ex.getClass().getName() + "\n" + ex.getStackTrace()[0].toString();
      JOptionPane.showMessageDialog(SgaMainFrame.getInstance().getFrame(), msg, "Error", JOptionPane.WARNING_MESSAGE);
    }
  }

  
 
}
