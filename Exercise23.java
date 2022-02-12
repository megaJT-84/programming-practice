/*Tian Xiaoyang  
 * 26001904581
 * image scaling to the display window
 * Dec 8, 2021
 */

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;


public class Exercise23 extends JFrame{
		BufferedImage bimage;
		String filename = "imageL1.jpg";
		double wid_rate = 0.444;
		double ht_rate = 0.55;
	
	public Exercise23() {
		setTitle("imageL1");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		takeImage();
	}
	
	public void paint(Graphics g) {
		if(bimage != null) {
			g.drawImage(bimage, 10, 70, (int)(bimage.getWidth() * wid_rate), 
					(int)(bimage.getHeight() * ht_rate), this);
			System.out.println("width = " + (int)(bimage.getWidth() * wid_rate));
			System.out.println("height = " + (int)(bimage.getHeight() * ht_rate));
					
		}
}
	
	public void takeImage() {
		try {
			File file = new File(filename);
			bimage = ImageIO.read(file);
			System.out.println("type: " + bimage.getType() + "field: " + BufferedImage.TYPE_3BYTE_BGR);
		}catch (IOException e) {
			System.out.println("error! " + e);
		}
		repaint();
	}

	public static void main(String[] args) {
		new Exercise23();

	}

}
