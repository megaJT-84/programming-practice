/*Tian Xiaoyang
 * 26001904581
 * scale and rotate image
 * Dec 14, 2021
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.swing.*;
import javax.imageio.*;
import java.awt.geom.*;

public class Exercise26 extends JFrame {
	
	BufferedImage bimage1, bimage2;
	String filename="image3.jpg";
	int xCenter = 240, yCenter = 180;
	double scale = 0.7;
	double rotate = Math.toRadians(11);
	
	public Exercise26() {
		setSize(500, 810);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		initialization();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int hposition = 440;
		int size = 5;
		
		if (bimage1 != null) {
			g.drawImage(bimage1, 10, 70, this);
		}
		if (bimage2 != null) {
			g.drawImage(bimage2, 10, hposition, this);
		}
		if(xCenter != 0) {
			g.setColor(Color.red);
			g.fillRect(10, 440, size, size);
		}
	}
	
	void initialization() {
		try {
			bimage1 = ImageIO.read(new File(filename));
		}catch(Exception e) {
			System.out.println("error " + e);
		}
	}
	
	void transform() {
		bimage2 = new BufferedImage(bimage1.getWidth(), bimage1.getHeight(), bimage1.getType());
		AffineTransform affine = new AffineTransform();
		affine.translate(xCenter, yCenter);
		affine.scale(scale, scale);
		affine.rotate(rotate);
		affine.translate(-xCenter, -yCenter);
		AffineTransformOp operator = new AffineTransformOp(affine, AffineTransformOp.TYPE_BICUBIC);
		operator.filter(bimage1, bimage2);
	}
	

	public static void main(String[] args) {
		new Exercise26();
	}
	
	class MyListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			System.out.print(xCenter + " , " + yCenter);
			transform();
			repaint();
		}
	}

}
