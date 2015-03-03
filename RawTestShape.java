import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class RawTestShape extends JPanel {
    int diagMenor;
    int diagMayor;
    public RawTestShape(int diagMenor, int diagMayor) {
	this.diagMayor = diagMayor;
	this.diagMenor = diagMenor;
    } 
    public void paintComponent(Graphics g) {
	// int x[] = {100, 100, 200, 200};
	// int y[] = {100, 200, 200, 100};
	
	// int x[] = {100, 200, 300, 200};
  	// int y[] = {100, 200, 100, 0};
	
	int x[] = {
	    200 - diagMenor,
	    200,
	    200 + diagMenor,
	    200 
	};
  	int y[] = {
	    100,
	    100 + diagMayor,
	    100,
	    100 - diagMayor
	};
	
	//int n = 4;
	super.paintComponent(g);
	//	Polygon p = new Polygon(x, y, 4);
	
	g.drawPolygon(new Polygon(x, y, 4));
    }
    
    public static void main(String args[]) {
	Scanner scanner = new Scanner(System.in);
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
	System.out.print("Inserte diagonal mayor: ");
	int a = scanner.nextInt();
	System.out.print("Inserte diagonal menor: ");
	int b = scanner.nextInt();
	frame.add(new RawTestShape(a, b));
	frame.add(jpanel);
	frame.setVisible(true);
    }
}
