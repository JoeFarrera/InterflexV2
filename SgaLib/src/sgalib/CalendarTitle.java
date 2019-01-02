package sgalib;
/*
===================================================================

    CalendarTitle.java

    Creaded by Claude Duguay
    Copyright (c) 1999

===================================================================
*/

import javax.swing.*;

public class CalendarTitle extends JLabel
{
    public CalendarTitle(String text)
	{
		super(text);
		setHorizontalAlignment(JLabel.CENTER);
		setBorder(new ThinBorder(ThinBorder.RAISED));
	}
}
