/*Tian Xiaoyang
 * 26001904581
 * change shape and color in the windonw
 *  Nov 24, 2021
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Exercise19 extends JFrame implements MouseListener{
	int index_no = 0;
		boolean flag1  = false;
		boolean flag2 = false;
		boolean flag3 = false;
		Color color;
		int xCenter, yCenter;
		int size = 100;
		JButton button, button1;
		Color[] colorSet = {Color.green, Color.yellow, Color.blue, Color.red};
		String[] colorLabel = {"green", "yellow", "blue", "red"};
		
		
		public Exercise19() {
			setTitle("painter");
			setSize(500, 500);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			addMouseListener(this);
			button = new JButton("green");
			button1 = new JButton("circle");
			button.addActionListener(new Buttonlistener());
			button1.addActionListener(new Buttonlistener1());
			JPanel panel = new JPanel();
			panel.add(button);
			panel.add(button1);
			getContentPane().add(panel, BorderLayout.NORTH);
			setVisible(true);
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.clearRect(0, 65, 500, 500);
			if(flag1) {
				Font font1 = new Font("Dialogue", Font.PLAIN, 20);
				g.setFont(font1);
				g.setColor(Color.red);
				g.drawString("enter", 430, 50);
			}
			if(flag2) {
				g.setColor(colorSet[0]);
				g.setColor(color);
				g.fillOval(xCenter - size/2, yCenter - size/2, size, size);
			}
			if (flag3) {
				g.setColor(color);
				g.fillRect(xCenter - size/2, yCenter - size/2, size, size);
			}
		}
		
		public void mouseClicked(MouseEvent e) {
			flag1 = false;
			flag2 = true;
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
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			flag1 = true;
			repaint();
		}
		
		class Buttonlistener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String text = (String)e.getActionCommand();
				if(text.equals(colorLabel[0])) {
					button.setText(colorLabel[1]);
					color = colorSet[1];
					repaint();
				}else if (text.equals(colorLabel[1])) {
					button.setText(colorLabel[2]);
					color = colorSet[2];
					repaint();
				}else if(text.equals(colorLabel[2])) {
					button.setText(colorLabel[3]);
					color = colorSet[3];
					repaint();
				}else if(text.equals(colorLabel[3])) {
					button.setText(colorLabel[0]);
					color = colorSet[0];
					repaint();
				}
			}
		}

		class Buttonlistener1 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String text = (String)e.getActionCommand();
				if(text.equals("circle")) {
					button1.setText("square");
					flag2 = false;
					flag3 = true;
					repaint();
				}
				if (text.equals("square")) {
					button1.setText("circle");
					flag2 = true;
					flag3 = false;
					repaint();
				}
			}
		}


	public static void main(String[] args) {
		new Exercise19();
	}
}

