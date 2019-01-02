package sgalib;
/*
=====================================================================

	JCalendarField.java

	Created by Claude Duguay
	Copyright (c) 199

=====================================================================
*/

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.Document;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class JCalendarField extends JPanel
	implements ActionListener
{
	protected DateFormat formatter =
		DateFormat.getDateInstance(DateFormat.FULL);    
	
	protected BasicArrowButton calendarButton;
	protected JCalendar calendar;
	protected JPopupMenu popup;
	protected JTextField field;
	protected Calendar date;
	
	public JCalendarField()
	{
		this(Calendar.getInstance());
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

	}

	public JCalendarField(Calendar date)
	{
	  setLayout(new BorderLayout());
		add(BorderLayout.CENTER, field  = new JTextField());
		field.setEditable(true);
		setBorder(field.getBorder());
		field.setBorder(null);
					
		calendarButton =
			new BasicArrowButton(BasicArrowButton.SOUTH);
		calendarButton.addActionListener(this);
		add(BorderLayout.EAST, calendarButton);

		calendar = new JCalendar(date, 1, 1,
			new DefaultListSelectionModel(),
			new SimpleCalendarRenderer(true),
			new SimpleCalendarRenderer(false));
		calendar.addActionListener(this);
		popup = new JPopupMenu();    
		popup.add(calendar);
		setField(date);
	}

	public void actionPerformed(ActionEvent event)
	{    
		if (event.getSource() == calendarButton)
		{
			//field.requestFocusInWindow();
			getRootPane().setDefaultButton(null);      
			if (!popup.isVisible())
			{
				Dimension dim = calendarButton.getSize();
				calendar.setDate(date);
				popup.show(calendarButton, dim.width -
					popup.getPreferredSize().width,
					dim.height);
			}
			else
			{
				//popup.setVisible(false);
				field.requestFocusInWindow();        
			}
		}
		if (event.getSource() == calendar)
		{
			setField(calendar.getDate());
			//popup.setVisible(false);

      field.requestFocusInWindow();
			      
		}
	}

	protected void setField(Calendar date)
	{
		this.date = date;
		field.setText(formatter.format(date.getTime()));
	}

	public String getField()
	{
    return field.getText();
	}

	public JTextField getFieldDef()
	{
    return field;
	}

	public void setField(String text)
	{
    field.setText(text);
	}

	public void setFieldColumns(int columns)
	{
    field.setColumns(columns);
	}

	public void setFieldDocument(Document doc)
	{
    field.setDocument(doc);
	}

	public void setDate(Calendar date)
	{
		calendar.setDate(date);
	}
	
	public Calendar getDate()
	{
		return calendar.getDate();
	}

	public void setCalendar(JCalendar calendar)
	{
		this.calendar = calendar;
	}
	
	public JCalendar getCalendar()
	{
		return calendar;
	}
	
	public void setDateFormat(DateFormat formatter)
	{
		this.formatter = formatter;
    setField(calendar.getDate());
	}

  private void jbInit() throws Exception
  {
    field.addFocusListener(new FocusAdapter()
      {
        public void focusGained(FocusEvent e)
        {
          field_focusGained(e);
        }

      });
  }

  private void field_focusGained(FocusEvent e)
  {
    if (e.getOppositeComponent() instanceof sgalib.CalendarMonth)
      popup.setVisible(false);
  }

}


