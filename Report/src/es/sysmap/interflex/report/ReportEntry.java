package es.sysmap.interflex.report;
/*
 * Copyright(c) 1996-2001, InetSoft Technology Corp, All Rights Reserved.
 *
 * The software and information contained herein are copyrighted and
 * proprietary to InetSoft Technology Corp. This software is furnished
 * pursuant to a written license agreement and may be used, copied,
 * transmitted, and stored only in accordance with the terms of such
 * license and with the inclusion of the above copyright notice. Please
 * refer to the file "COPYRIGHT" for further copyright and licensing
 * information. This software and information or any other copies
 * thereof may not be provided or otherwise made available to any other
 * person.
 */
import java.io.*;
import inetsoft.report.*;
import inetsoft.report.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import inetsoft.uql.*;
import inetsoft.uql.builder.*;
import inetsoft.uql.schema.*;
import javax.swing.border.EtchedBorder;

public class ReportEntry {
   public static void main(String[] args) {
   try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }



      try {
	 if(args.length == 0) {
	    System.err.println("Usage: java Report template-file");
	    System.exit(1);
	 }

	 FileInputStream input = new FileInputStream(args[0]);
	 Builder builder = Builder.getBuilder(Builder.TEMPLATE, input);
	 ReportSheet report = builder.read(".");

	 XSessionManager mgr = XSessionManager.getSessionManager();
	 UserVariable[] params = mgr.getQueryParameters(report, true);
	 VariableTable vars = new VariableTable();

	 // if there are any parameters, prompts using the custom prompt
	 // dialog
	 if(params != null && params.length > 0) {
//	    vars = ParamDialog.show(params, null);
	    // if user cancels, exit from the program
	    if(vars == null) {
	       System.exit(0);
	    }
	 }

	 mgr.execute(report, vars);

	 PreviewView previewer = Previewer.createPreviewer();
	 previewer.setExitOnClose(true);

	 previewer.pack();
	 previewer.setVisible(true);

	 previewer.print(report);
      } catch(Exception e) {
	 e.printStackTrace();
      }
   }
}
