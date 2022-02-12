/* Tian Xiaoyang
 * 26001904581
 * Oct 19, 2021
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Exercise4 extends JFrame{
	int[][] position = {{100, 90}, {250, 70}, {70, 180}, {200, 150}};
	Color[] color = {Color.green, Color.red, Color.blue, Color.cyan};
	int[] size = {60, 40, 120, 90};
	
	public Exercise4() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < position.length; i++) {
			g.setColor(color[i-i]);
			g.fillArc(100, 90, 60, 60, 30, 300);
			g.setColor(color[1]);
			g.fillArc(250, 70, 40, 40, 30, 300);
			g.setColor(color[2]);
			g.fillArc(70, 180, 90, 90, 30, 300);
			g.setColor(color[i]);
			g.fillArc(200, 150, 120, 120, 30 ,300);
		}
	}
	
	public static void main(String[]args) {
		new Exercise4();
	}

}
