/* Tian Xiaoyang 
 * 26001904581
 * image segmentation with mouse, and mosaic 
 * Dec 9, 2021
 */

import java.awt.*; 
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Exercise30 extends JFrame{
	BufferedImage bimage, bimage1, bimage2;
	Mat src, part, mosaic;
	String filename = "imageL2.jpg";
	int rect[][] = {{0,0}, {0,0}};
	double ratio = 0.5;
	
	public Exercise30() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		setTitle("Exercise30");
		setSize(560, 760);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		takeImage();
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		if (bimage != null) {
			g.drawImage(bimage, 10, 30, (int)(bimage.getWidth() * ratio), 
					(int)(bimage.getHeight() * ratio), this);
		}
		if(bimage1 != null) {
			g.drawImage(bimage1, 10, 400, (int)(bimage1.getWidth() * ratio), 
					(int)(bimage1.getHeight() * ratio), this);
		}
		if(bimage2 != null) {
			g.drawImage(bimage2, 280, 400, (int)(bimage2.getWidth() * ratio), 
					(int)(bimage2.getHeight() * ratio), this);
		}
		g.setColor(Color.red);
		g.drawRect(rect[0][0], rect[0][1], rect[1][0] - rect[0][0], rect[1][1] - rect[0][1]);
	}
	
	public void takeImage() {
		src = new Mat();
		src = Imgcodecs.imread(filename);
		bimage = matToBufferedImage(src);
		repaint();
	}
	
	public void partImage() {
		Rect roi = new Rect( rect[0][0]+65, rect[0][1]+18, (rect[1][0] - rect[0][0])*2, (rect[1][1] - rect[0][1])*2);
		part = new Mat(src, roi);
		bimage1 = matToBufferedImage(part);
		mosaic = new Mat(src, roi);
		Imgproc.resize(mosaic, mosaic, new Size(), 0.1, 0.1, Imgproc.INTER_NEAREST);
		Imgproc.resize(mosaic, mosaic, new Size(), 10.0, 10.0, Imgproc.INTER_NEAREST);
		bimage2 = matToBufferedImage(mosaic);
		repaint();
	}
	
	public static void main(String[] args) {
		new Exercise30();
	}
	
	public static BufferedImage matToBufferedImage(Mat matrix) {
		int cols = matrix.cols();
		int rows = matrix.rows();
		int elemSize =(int)matrix.elemSize();
		byte[]data = new byte[cols*rows*elemSize];
		int type;
		matrix.get(0, 0, data);
		switch (matrix.channels()) {
		case 1:
			type = BufferedImage.TYPE_BYTE_GRAY;
			break;
		case 3:
			type = BufferedImage.TYPE_3BYTE_BGR;
			byte b;
			for(int i = 0; i<data.length; i = i+3) {
				b = data[i];
				data[i] = data[i+2];
				data[i+2] = b;
			}
			break;
			default:
				return null;
		}
		BufferedImage image2 = new BufferedImage(cols, rows, type);
		image2.getRaster().setDataElements(0, 0, cols, rows, data);
		return image2;
	}
	
	class MyListener extends MouseAdapter{

		public void mousePressed(MouseEvent e) {
			rect[0][0] = e.getX();
			rect[0][1] = e.getY();
		}
		
		public void mouseReleased(MouseEvent e) {
			partImage();
			repaint();
		}
		
		public void mouseDragged(MouseEvent e) {
			rect[1][0] = e.getX();
			rect[1][1] = e.getY();
			repaint();
		}
	}
}
