package sgalib;
/*
===================================================================

    CalendarRenderer.java

    Creaded by Claude Duguay
    Copyright (c) 1999

===================================================================
*/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public interface CalendarRenderer
{
	public Component getCalendarRendererComponent(
		JComponent parent, Object value,
		boolean isSelected, boolean hasFocus);
	public Color getBackdrop();
}
