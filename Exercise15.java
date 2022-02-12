
/* Tian Xiaoyang  
 *  26001904581
 *  draw pacman and pacman with eye by polymorphism
 *  Nov 16, 2021
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Exercise15 extends JFrame{
	int flag = 0;
	Face face = new PacMan(0,0,0,60);
	int count = -1;
	JButton button;
	JTextField text_box;
	
	public Exercise15(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("draw PacMan");
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
		button = new JButton("PacMan");
		button.addMouseListener(new Buttonlistener1());
		text_box = new JTextField("", 16);
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(text_box);
		getContentPane().add(panel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.clearRect(0,0, 500, 450);
		if(count >= 0) {
			if (count > 9) {
				count = 9;
			}
			for (int i = 0; i < count+1; i++) {
				face.make(g);
			}
		}
	}
	
	public static void main(String[] args) {
		new Exercise15();

	}
	
	
	class MyListener extends MouseAdapter{
		int distance, xCenter, yCenter;;
		
		public void mousePressed(MouseEvent e) {
				if(++count <20 ) {
					if(flag == 0) {
						face = new PacMan(0, e.getX(), e.getY(), 60);
					}else if(flag==1) {
						face = new PacManWithEye(0, e.getX(), e.getY(), 60);
					}
					repaint();
					text_box.setText("the center is (" + e.getX() + "," + e.getY() + ")");
				}else {
					text_box.setText("no more Pacman");
			}
		}
		
		public void mouseDragged(MouseEvent e) {
			if(count < 10) {
				distance = (int)Math.hypot(e.getX() - face.getXCenter(), e.getY() - face.getYCenter());
				face.setSize(distance*2);
				text_box.setText(Integer.toString(distance*2));
				repaint();
			}
		}
	}
	
	class Buttonlistener1 extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			if(++flag > 1) {
				flag = 0;
			}
			if(flag == 0) {
				button.setText("PacMan");
			}else if(flag == 1) {
				button.setText("PacManWithEye");
			}
		}
	}
}
	

