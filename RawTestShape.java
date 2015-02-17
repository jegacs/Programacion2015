import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RawTestShape extends JPanel {
    public void paintComponent(Graphics g) {
	int x[] = {100, 100, 200, 200};
	int y[] = {100, 200, 200, 100};
	int n = 4;
	super.paintComponent(g);
	Polygon p = new Polygon(x, y, n);
	
	g.drawPolygon(p);
    }
    
    public static void main(String args[]) {
	JFrame frame = new JFrame();
	frame.setTitle("RawTestShape");
	frame.setSize(300, 400);
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) { 
		    System.exit(0);
		}
	    });
	frame.add(new RawTestShape());
	frame.setVisible(true);
    }
}
