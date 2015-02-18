import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RawTestShape extends JPanel {
    public void paintComponent(Graphics g) {
	// int x[] = {100, 100, 200, 200};
	// int y[] = {100, 200, 200, 100};
	int x[] = {100, 200, 300, 200};
	int y[] = {100, 200, 100, 0};
	int n = 4;
	super.paintComponent(g);
	Polygon p = new Polygon(x, y, n);
	
	g.drawPolygon(p);
    }
    
    public static void main(String args[]) {
	JFrame frame = new JFrame();
	JPanel jpanel = new JPanel();
	JLabel label = new JLabel("Area:");
	jpanel.add(label);
	frame.setLayout(new GridLayout(2,1));
	frame.setTitle("RawTestShape");
	frame.setSize(400, 500);
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) { 
		    System.exit(0);
		}
	    });
	frame.add(new RawTestShape());
	frame.add(jpanel);
	// frame.pack();
	frame.setVisible(true);
    }
}
