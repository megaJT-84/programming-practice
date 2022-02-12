/*Tian Xiaoyang
 * 26001904581
 * draw rectangle for entry and number the entries
 * Nov 30, 2021
 */
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Exercise22 extends JFrame{
	int record[] = new int[200];
	int unit;
	int max;
	
	public Exercise22() {
		setTitle("Exercise 22");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		count_item();
		setVisible(true);
	}
		
	
	public void paint(Graphics g) {
		max = record[0];
		Font font1 = new Font("Dialogue", Font.PLAIN, 20);
		g.setFont(font1);
		for( int i = 0 ; i <= 9 ; i++) {
			if (record[i] > max) {
	            max = record[i];
	        }
			unit = 380/max;
			g.setColor(Color.red);
			g.drawString(Integer.toString(i), 20, 70+40*i);
			g.setColor(Color.blue);
			g.drawString(Integer.toString(record[i]), 50, 70+40*i);
			g.fillRect(100, 50 + 40*i, unit*record[i], 30);
			System.out.println(record[i]);
		}
	}
		
	
	public void count_item() {
		String kb;
		
		try {
			FileReader isr = new FileReader("data200.txt");
			BufferedReader reader = new BufferedReader(isr);
			kb = reader.readLine();
			while (kb != null) {
				record[Integer.parseInt(kb)]++;
				kb = reader.readLine();
			}
			System.out.println("end of file loading");
			System.out.println("count = 200");
			System.out.println("");
			reader.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new Exercise22();

	}

}
