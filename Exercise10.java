/*TIAN XIAOYANG
 * 26001904581
 *  Exercise_9
 *  */

import java.awt.*;
import java.awt.event.*;

	public class Exercise10 extends Frame implements MouseListener{
		Exercise10(){
			addMouseListener(this);
			setSize(500, 500);
			setLayout(null);
			setVisible(true);
			
		}
		public void mouseClicked(MouseEvent e) {
			Graphics g =getGraphics();
			g.setColor(Color.BLUE);
			g.fillOval(e.getX()-25, e.getY()-25, 50, 50);
			if(e.getButton() == MouseEvent.BUTTON3) {
				Graphics g1 =getGraphics();
				g.setColor(Color.RED);
				g.fillRect(e.getX()-25, e.getY()-25, 50, 50);
			}
			
				
		}
		public void mouseEntered(MouseEvent e) {}
		
		public void mouseExited(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}

	public static void main(String[] args) {
		new Exercise10();

	}

}
