/*Tian Xiaoyang
 * 26001904581
 * colored ball and mouse action notification
 *  Nov 24, 2021
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Exercise17 extends JFrame implements MouseListener{
		boolean flag1  = false;
		boolean flag2 = false;
		Color color;
		int xCenter, yCenter;
		int size = 100;
		
		
		public Exercise17() {
			setTitle("painter");
			setSize(500, 500);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			addMouseListener(this);
			setVisible(true);
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.clearRect(0, 0, 500, 500);
			if(flag1) {
				Font font1 = new Font("Dialogue", Font.PLAIN, 20);
				g.setFont(font1);
				g.setColor(Color.red);
				g.drawString("enter", 440, 50);
			}
			if(flag2) {
				g.setColor(color);
				g.fillOval(xCenter - size/2, yCenter - size/2, size, size);
			}
		}
		
		public void mouseClicked(MouseEvent e) {
			flag2 = true;
			color = Color.green;
			repaint();
			
		}
		
		public void mouseEntered(MouseEvent e) {
			flag1 = true;
			repaint();
		}
		
		public void mouseExited(MouseEvent e) {
			flag1 = false;
			repaint();
		}
		
		public void mousePressed(MouseEvent e) {
			flag1 = true;
			xCenter = e.getX();
			yCenter = e.getY();
			color = Color.green;
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			flag1 = false;
			repaint();
		}


	public static void main(String[] args) {
		new Exercise17();
	}
}

