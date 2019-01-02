package es.sysmap.interflex.report;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 
/**
 * <CODE>AppFrame</CODE> is a <CODE>javax.swing.JFrame</CODE> subclass that 
 * provides some convenient methods for applications.  This class implements 
 * all the same constructors as <CODE>JFrame</CODE>, plus a few others.  
 * Methods exist to show the frame centered on the screen, display a splash 
 * screen, run an initializer thread and set the frame as "busy" to block  
 * user input.  
 */
public class AppFrame extends JFrame implements KeyListener, MouseListener {
	/**
	 * The splash screen window.  
	 */
	private JWindow splash = null;
 
	/**
	 * The busy state of the frame.  
	 */
	private boolean busy = false;
 
	/**
	 * The glass pane used when busy.  
	 */
	private Component glassPane = null;
 
	/**
	 * The original glass pane, which is reset when not busy.  
	 */
	private Component defaultGlassPane = null;
 
	/**
	 * Creates a new <CODE>AppFrame</CODE>.  
	 */
	public AppFrame() {
		super();
		init();
	}
 
	/**
	 * Creates a new <CODE>AppFrame</CODE> with the specified 
	 * <CODE>GraphicsConfiguration</CODE>.  
	 * 
	 * @param  gc  the GraphicsConfiguration of a screen device
	 */
	public AppFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}
 
	/**
	 * Creates a new <CODE>AppFrame</CODE> with the specified title.  
	 * 
	 * @param  title  the title
	 */
	public AppFrame(String title) {
		super(title);
		init();
	}
 
	/**
	 * Creates a new <CODE>AppFrame</CODE> with the specified title and 
	 * <CODE>GraphicsConfiguration</CODE>.  
	 * 
	 * @param  title  the title
	 * @param  gc     the GraphicsConfiguration of a screen device
	 */
	public AppFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}
 
	/**
	 * Creates a new <CODE>AppFrame</CODE> with the specified title and 
	 * icon image.  
	 * 
	 * @param  title  the title
	 * @param  icon   the image icon
	 */
	public AppFrame(String title, Image icon) {
		super(title);
		setIconImage(icon);
		init();
	}
 
	/**
	 * Creates a new <CODE>AppFrame</CODE> with the specified title and 
	 * icon image.  
	 * 
	 * @param  title  the title
	 * @param  icon  the image icon
	 */
	public AppFrame(String title, ImageIcon icon) {
		this(title, icon.getImage());
	}
 
	/**
	 * Initializes internal frame settings.  
	 */
	protected void init() {
		// set default close operation (which will likely be changed later)
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// set up the glass pane
		glassPane = new JPanel();
		((JPanel)glassPane).setOpaque(false);
		glassPane.addKeyListener(this);
		glassPane.addMouseListener(this);
	}
 
	/**
	 * Displays a new <CODE>JWindow</CODE> as a splash screen using the 
	 * specified component as the content.  The default size of the 
	 * component will be used to size the splash screen.  See the 
	 * <CODE>showSplash(Component, int, int)</CODE> method description for 
	 * more details.  
	 * 
	 * @param  c  the splash screen contents
	 * @return  the window object
	 * @see  #showSplash(Component, int, int)
	 * @see  #hideSplash()
	 */
	public JWindow showSplash(Component c) {
		return showSplash(c, -1, -1);
	}
 
	/**
	 * Displays a new <CODE>JWindow</CODE> as a splash screen using the 
	 * specified component as the content.  The component should have all 
	 * the content it needs to display, like borders, images, text, etc.  
	 * The splash screen is centered on monitor.  If width and height are 
	 * <CODE><= 0</CODE>, the default size of the component will be used 
	 * to size the splash screen.  
	 * 
	 * The window object is returned to allow the application to manipulate 
	 * it, (such as move it or resize it, etc.).  However, <B>do not</B> 
	 * dispose the window directly.  Instead, use <CODE>hideSplash()</CODE> 
	 * to allow internal cleanup.  
	 * 
	 * If the component is <CODE>null</CODE>, a default component with the 
	 * frame title and icon will be created.  
	 * 
	 * The splash screen window will be passed the same 
	 * <CODE>GraphicsConfiguration</CODE> as this frame uses.  
	 * 
	 * @param  c  the splash screen contents
	 * @param  w  the splash screen width
	 * @param  h  the splash screen height
	 * @return  the window object
	 * @see  #showSplash(Component)
	 * @see  #hideSplash()
	 */
	public JWindow showSplash(Component c, int w, int h) {
		// if a splash window was already created...
		if(splash != null) {
			// if it's showing, leave it; else null it
			if(splash.isShowing()) {
				return splash;
			} else {
				splash = null;
			}
		}
		// if the component is null, then create a generic splash screen 
		// based on the frame title and icon
		if(c == null) {
			JPanel p = new JPanel();
			p.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
			));
			JLabel l = new JLabel("Loading application...");
			if(getTitle() != null) {
				l.setText("Loading " + getTitle() + "...");
			}
			if(getIconImage() != null) {
				l.setIcon(new ImageIcon(getIconImage()));
			}
			p.add(l);
			c = p;
		}
		splash = new JWindow(this, getGraphicsConfiguration());
		splash.getContentPane().add(c);
		splash.pack();
		// set the splash screen size
		if(w > 0 && h > 0) {
			splash.setSize(w, h);
		} else {
			splash.setSize(c.getPreferredSize().width, c.getPreferredSize().height);
		}
		centerComponent(splash);
		splash.show();
		return splash;
	}
 
	/**
	 * Disposes the splash window.  
	 * 
	 * @see  #showSplash(Component, int, int)
	 * @see  #showSplash(Component)
	 */
	public void hideSplash() {
		if(splash != null) {
			splash.dispose();
			splash = null;
		}
	}
 
	/**
	 * Runs an initializer <CODE>Runnable</CODE> object in a new thread.  
	 * The initializer object should handle application initialization 
	 * steps.  A typical use would be:
	 * <OL>
	 *   <LI>Create the frame.
	 *   <LI>Create the splash screen component.
	 *   <LI>Call <CODE>showSplash()</CODE> to display splash screen.
	 *   <LI>Run the initializer, in which:  
	 *   <UL>
	 *     <LI>Build the UI contents of the frame.
	 *     <LI>Perform other initialization (load settings, data, etc.).
	 *     <LI>Pack and show the frame.
	 *     <LI>Call <CODE>hideSplash()</CODE>.
	 *   </UL>
	 * </OL>
	 * 
	 * <B>NOTE:</B>  Since this will be done in a new thread that is 
	 * external to the event thread, any updates to the splash screen that 
	 * might be done should be triggered through with 
	 * <CODE>SwingUtilities.invokeAndWait(Runnable)</CODE>.  
	 * 
	 * @param  r  the <CODE>Runnable</CODE> initializer
	 */
	public void runInitializer(Runnable r) {
		Thread t = new Thread(r);
		t.start();
	}
 
	/**
	 * Shows the frame centered on the screen.  
	 */
	public void showCentered() {
		centerComponent(this);
		this.show();
	}
 
	/**
	 * Checks the busy state.
	 * 
	 * @return  <CODE>true</CODE> if the frame is disabled; 
	 *          <CODE>false</CODE> if the frame is enabled
	 * @see  #setBusy(boolean)
	 */
	public boolean isBusy() {
		return this.busy;
	}
 
	/**
	 * Sets the busy state.  When busy, the glasspane is shown which will 
	 * consume all mouse and keyboard events, and a wait cursor is 
	 * set for the frame.  
	 * 
	 * @param  busy  if <CODE>true</CODE>, disables frame; 
	 *               if <CODE>false</CODE>, enables frame
	 * @see  #getBusy()
	 */
	public void setBusy(boolean busy) {
		// only set if changing
		if(this.busy != busy) {
			this.busy = busy;
			// If busy, keep current glass pane to put back when not 
			// busy.  This is done in case the application is using 
			// it's own glass pane for something special.  
			if(busy) {
				defaultGlassPane = getGlassPane();
				setGlassPane(glassPane);
			} else {
				setGlassPane(defaultGlassPane);
				defaultGlassPane = null;
			}
			glassPane.setVisible(busy);
			glassPane.setCursor(busy ? 
				Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) : 
				Cursor.getDefaultCursor()
			);
			setCursor(glassPane.getCursor());
		}
	}
 
	/**
	 * Handle key typed events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  ke  the key event
	 */
	public void keyTyped(KeyEvent ke) {
		ke.consume();
	}
 
	/**
	 * Handle key released events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  ke  the key event
	 */
	public void keyReleased(KeyEvent ke) {
		ke.consume();
	}
 
	/**
	 * Handle key pressed events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  ke  the key event
	 */
	public void keyPressed(KeyEvent ke) {
		ke.consume();
	}
 
	/**
	 * Handle mouse clicked events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  me  the mouse event
	 */
	public void mouseClicked(MouseEvent me) {
		me.consume();
	}
 
	/**
	 * Handle mouse entered events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  me  the mouse event
	 */
	public void mouseEntered(MouseEvent me) {
		me.consume();
	}
 
	/**
	 * Handle mouse exited events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  me  the mouse event
	 */
	public void mouseExited(MouseEvent me) {
		me.consume();
	}
 
	/**
	 * Handle mouse pressed events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  me  the mouse event
	 */
	public void mousePressed(MouseEvent me) {
		me.consume();
	}
 
	/**
	 * Handle mouse released events.  Consumes the event for the glasspane 
	 * when the frame is busy.  
	 * 
	 * @param  me  the mouse event
	 */
	public void mouseReleased(MouseEvent me) {
		me.consume();
	}
 
	/**
	 * Centers the component <CODE>c</CODE> on the screen.  
	 * 
	 * @param  c  the component to center
	 * @see  #centerComponent(Component, Component)
	 */
	public static void centerComponent(Component c) {
		centerComponent(c, null);
	}
 
	/**
	 * Centers the component <CODE>c</CODE> on component <CODE>p</CODE>.  
	 * If <CODE>p</CODE> is null, the component <CODE>c</CODE> will be 
	 * centered on the screen.  
	 * 
	 * @param  c  the component to center
	 * @param  p  the parent component to center on or null for screen
	 * @see  #centerComponent(Component)
	 */
	public static void centerComponent(Component c, Component p) {
		if(c != null) {
			Dimension d = (p != null ? p.getSize() : 
				Toolkit.getDefaultToolkit().getScreenSize()
			);
			c.setLocation(
				Math.max(0, (d.getSize().width/2)  - (c.getSize().width/2)), 
				Math.max(0, (d.getSize().height/2) - (c.getSize().height/2))
			);
		}
	}
 
	/**
	 * Main method.  Used for testing.
	 * 
	 * @param  args  the arguments
	 */
	public static void main(String[] args) {
		final AppFrame f = new AppFrame("Test Application", 
			new ImageIcon("center.gif"));
		f.showSplash(null);
		f.runInitializer(new Runnable() {
			public void run() {
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.getContentPane().add(new JButton("this is a frame"));
				f.pack();
				f.setSize(300, 400);
				try {
					Thread.currentThread().sleep(3000);
				} catch(Exception e) {}
				f.showCentered();
				f.setBusy(true);
				try {
					Thread.currentThread().sleep(100);
				} catch(Exception e) {}
				f.hideSplash();
				try {
					Thread.currentThread().sleep(3000);
				} catch(Exception e) {}
				f.setBusy(false);
			}
		});
	}
}