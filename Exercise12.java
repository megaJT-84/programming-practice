/*buttons with notes
 * Nov 11, 2021
 * Tian Xiaoyang
 * 26009014581
 */

import java.awt.*;
import javax.swing.*;

public class Exercise12 extends JFrame{
	
	JButton button1, button2;
	JTextField text_box;
	
	public Exercise12() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("buttons");
		
		button1 = new JButton("blue");
		button2  = new JButton("red");
		JPanel panel = new JPanel();
		panel.add(button1);
		panel.add(button2);
		
		text_box = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(text_box);
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(panel1, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Exercise12();

	}

}
