/* Tian Xiaoyang
 * 26001904581
 * Oct 19, 2021
 */

import java.awt.*;
import javax.swing.*;

public class Exercise3 extends JFrame{
	int[][] position = {{100, 90}, {250, 70}, {70, 180}, {200, 150}};
	Color[] color = {Color.green, Color.red, Color.blue, Color.cyan};
	
	public Exercise3() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		for (int i =0; i < position.length; i++) {
			g.setColor(color[i-i]);
			g.fillRect(100, 90, 60, 30);
			g.setColor(color[1]);
			g.fillRect(250, 70, 60, 30);
			g.setColor(color[2]);
			g.fillRect(70, 180, 60, 30);
			g.setColor(color[i]);
			g.fillRect(200, 150, 60, 30);
		}
	}
	
	public static void main(String[]args) {
		new Exercise3();
	}
}
