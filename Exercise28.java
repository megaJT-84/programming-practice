/*Tian Xiaoyang 
 * 26001904581
 * image scaling and grayscale 
 * Dec 22, 2021
 */

import org.opencv.core.*; 
import java.awt.image.*;
import java.awt.*;
import javax.swing.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Exercise28 extends JFrame{
	BufferedImage bimage, bimage2, bimage3;
	Mat src, gray, binary;
	double ratio = 0.5;
	String filename = "imageL2.jpg";
	
	public Exercise28() {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	setTitle("Exercise28");
	setSize(560, 600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	takeImage();

	}
	
	public void paint(Graphics g) {
		if (bimage != null) {
			g.drawImage(bimage, 10, 30, (int)(bimage.getWidth() * ratio), 
					(int)(bimage.getHeight() * ratio), this);
		}
		if(bimage2 != null) {
			g.drawImage(bimage2, 10, 400, (int)(bimage.getWidth() * ratio/2), 
					(int)(bimage.getHeight() * ratio/2), this);
		}
		if(bimage3 != null) {
			g.drawImage(bimage3, 280, 400, (int)(bimage.getWidth() * ratio/2), 
					(int)(bimage.getHeight() * ratio/2), this);
		}
	}
	
	public void takeImage() {
		src = new Mat();
		gray = new Mat();
		binary = new Mat();
		src = Imgcodecs.imread(filename);
		Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
		Imgproc.threshold(gray, binary, 80, 255, Imgproc.THRESH_BINARY);
		bimage = matToBufferedImage(src);
		bimage2 = matToBufferedImage(gray);
		bimage3 = matToBufferedImage(binary);
		repaint();
		src = Imgcodecs.imread(filename);
		bimage = matToBufferedImage(src);
		System.out.println("width = "+ bimage.getWidth() + "\n" + "height = " + bimage.getHeight());
		repaint();
	}


	public static void main(String[] args) {
		new Exercise28();
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

}
