


import java.awt.*; 
import javax.swing.*;

public class Exercise5 extends JFrame{
	int size = 200;
	int centerx = 200;
	int centery = 150;
	int eye = 50;
	
	public Exercise5() {
		setSize(650, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(centerx, centery, size, size);
		}
	public static void main(String[]args) {
		new Exercise5();
	}
}

