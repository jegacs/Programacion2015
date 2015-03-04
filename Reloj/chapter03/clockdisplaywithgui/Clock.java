package chapter03.clockdisplaywithgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.util.Date;
/**
 * A very simple GUI (graphical user interface) for the clock display.
 * In this implementation, time runs at about 3 minutes per second, so that
 * testing the display is a little quicker.
 * 
 * @author Michael K\"olling and David J. Barnes
 * @version 2011.07.31
 */
public class Clock
{
    private JFrame frame;
    private JLabel label;
    private ClockDisplay clock;
    private boolean clockRunning = false;
    private TimerThread timerThread;
    private boolean isCrono = true;
    private boolean isClock = false;
    //private ActionListener timeListener;
    private Date date;
    /**
     * Constructor for objects of class Clock
     */
    public Clock()
    {
        makeFrame();
        clock = new ClockDisplay();
	date = new Date();
    }
    
    /**
     * 
     */
    private void start()
    {
        clockRunning = true;
        timerThread = new TimerThread();
        timerThread.start();
    }
    
    /**
     * 
     */
    private void stop()
    {
        clockRunning = false;
    }
    
    /**
     * 
     */
    private void step()
    {
	clock.timeTick();
	if(isCrono) {
	    label.setText(clock.getTime());
	}
	
    }
    
    /**
     * 'About' function: show the 'about' box.
     */
    private void showAbout()
    {
        JOptionPane.showMessageDialog (frame, 
                    "Cronometro Version 1.0\n" +
                    "El proyecto para el equipo 1 del curso de programacion\n"
                + "Los integrantes del equipo 1 deberan reprogramar la clase Clock\n"
                + "de tal manera que el programa completo funcione como les sera\n"
                + "indicado por el instructor del curso.\n"
                + "Febrero de 2015. \n Gabo was here ;D ",
                    "About Cronometro", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
    
    
    private void cambiarEstado() { 
	if(isCrono) {
	    isCrono = false;
	    isClock = true;
	} else {
	    if(isClock) {
		isCrono = true;
		isClock = false;
		label.setText(clock.getTime());
	    }
	}
    }
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Cronometro");
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    quit(); // Agregado por mi, para cerrar cuando se presione el boton de cerrar.
		}
	    });
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        makeMenuBar(frame);
        
        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(12, 12));
        
        // Create the image pane in the center
        label = new JLabel("00:00:00", SwingConstants.CENTER);
        Font displayFont = label.getFont().deriveFont(96.0f);
        label.setFont(displayFont);
        //imagePanel.setBorder(new EtchedBorder());
        contentPane.add(label, BorderLayout.CENTER);
	
        // Create the toolbar with the buttons
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1, 0));
        
        JButton startButton = new JButton("Start");
	ActionListener timeListener = new ActionListener() { 
		public void actionPerformed(ActionEvent ae) {
		    if(isClock) {
			label.setText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
		    }
		}
	    };
	new Timer(100, timeListener).start();
        startButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { start(); }
                           });
        toolbar.add(startButton);
        
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { stop(); }
                           });
        toolbar.add(stopButton);

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { step(); }
                           });
        toolbar.add(stepButton);

        // Add toolbar into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(toolbar);
        
        contentPane.add(flow, BorderLayout.SOUTH);
        
        // building is done - arrange the components      
        frame.pack();
        
        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     * 
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        JMenuItem itemReloj;
        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);
        
        item = new JMenuItem("About Clock...");
	item.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { showAbout(); }
	    });
	itemReloj = new JMenuItem("Reloj/Cronometro");
	itemReloj.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    cambiarEstado();
		}
	    });
	
	menu.add(item);
	menu.add(itemReloj);
        menu.addSeparator();
        
        item = new JMenuItem("Quit");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { quit(); }
                           });
        menu.add(item);
    }
    
    class TimerThread extends Thread
    {
        public void run()
        {
            while (clockRunning) {
                step();
                pause();
            }
        }
        
        private void pause()
        {
            try {
//                Thread.sleep(300);   // pause for 300 milliseconds
                Thread.sleep(10);   // pause for 1000 milliseconds = 1 second
		// Gabo: Un centesimo de segundo.
            }
            catch (InterruptedException exc) {
            }
        }
    }
}
