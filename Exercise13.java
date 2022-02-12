/*buttons press and text output
 * Nov 11, 2021
 * Tian Xiaoyang
 * 26009014581
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class Exercise13 extends JFrame{
	int count;
	JButton button1, button2;
	JTextField text_box;
	
	public Exercise13() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("buttons");
		
		button1 = new JButton("blue");
		button1.addActionListener(new Buttonlistener1());
		button2  = new JButton("red");
		button2.addActionListener(new Buttonlistener1());
		text_box = new JTextField("", 20);
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel.add(button1);
		panel.add(button2);
		panel1.add(text_box);
		
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(panel1, BorderLayout.CENTER);
		setVisible(true);
	}
	
	class Buttonlistener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button1) {
				text_box.setText("Blue button was pressed");
			}
			if(e.getSource() == button2) {
				text_box.setText("Red button was pressed");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Exercise13();

	}
	
	

}