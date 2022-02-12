/*TIAN XIAOYANG
 * 26001904581
 * Exercise11
 */

import java.awt.*;
import java.awt.event.*;

public class Exercise11 extends Frame implements MouseMotionListener{
	int x, y;
	Exercise11(){
		addMouseMotionListener(this);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseDragged(MouseEvent e) {
		Graphics g = getGraphics();
		g.setColor(Color.YELLOW);
		x = (500 - e.getX())/2;
		y = (500 - e.getY())/2;
		g.fillArc(e.getX(), e.getY(), x, y, 30, 300);
	}
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	
	
	public void mouseReleased(MouseEvent e) {}

	public static void main(String[] args) {
		new Exercise11();

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
