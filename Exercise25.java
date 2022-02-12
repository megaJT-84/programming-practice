/* Tian Xiaoyang 
 * 26001904581
 * image segmentation with mouse, and save the selected segment 
 * Dec 9, 2021
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Exercise25 extends JFrame{
	BufferedImage bimage, getImage;
	JButton button;
	String filename = "image2.jpg";
	int rect[][] = {{0,0}, {0,0}};
	
	public Exercise25() {
		setTitle("image 2 segmentation");
		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		button = new JButton(" save image");
		button.addActionListener(new Buttonlistener());
		JPanel panel = new JPanel();
		panel.add(button);
		getContentPane().add(panel, BorderLayout.NORTH);
		takeImage();
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		int hposition = 440;
		g.clearRect(0, 0, 500, 800);
		if(bimage != null) {
			g.drawImage(bimage, 10, 70, this);
		}
		if (getImage != null) {
			g.drawImage(getImage, 10, hposition, this);
		}
		g.setColor(Color.red);
		g.drawRect(rect[0][0], rect[0][1], rect[1][0] - rect[0][0], rect[1][1] - rect[0][1]);
	}
	
	public void takeImage() {
		try {
			File file = new File(filename);
			bimage = ImageIO.read(file);
			
		}catch (IOException e) {
		}
		repaint();
	}
	
	public static void main(String[] args) {
		new Exercise25();
	}
	
	class MyListener extends MouseAdapter{
		int cx, cy;
		String str;
		
		public void mousePressed(MouseEvent e) {
			rect[0][0] = e.getX();
			rect[0][1] = e.getY();
		}
		
		public void mouseReleased(MouseEvent e) {
			getImage = bimage.getSubimage(rect[0][0] - 10, rect[0][1] - 70,
					rect[1][0] - rect[0][0], rect[1][1] - rect[0][1]);
			repaint();
		}
		
		public void mouseDragged(MouseEvent e) {
			rect[1][0] = e.getX();
			rect[1][1] = e.getY();
			repaint();
		}
	}
	
	class Buttonlistener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) {
				try {
					File file = new File(filename);
					bimage = ImageIO.read(file);
					BufferedImage simage = bimage.getSubimage(rect[0][0] - 10, rect[0][1] - 70,
					rect[1][0] - rect[0][0], rect[1][1] - rect[0][1]);
					File output  = new File("/Users/wcwe/desktop/saved_img.jpg");
					ImageIO.write(simage, "jpg", output);
					
				}catch(IOException ex) {
				}
				System.out.println("image is saved");
			}
		}
	}
}
