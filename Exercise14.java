/*buttons press and user text input
 * Nov 11, 2021
 * Tian Xiaoyang
 * 26009014581
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class Exercise14 extends JFrame{
	int count;
	JButton button1, button2;
	JTextField text_box;
	
	public Exercise14() {
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
	
	
	public static void main(String[] args) {
		new Exercise14();

	}
	
	class Buttonlistener1 implements ActionListener {
		String str;
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button1) {
			str = text_box.getText();
			Graphics g = getGraphics();
			g.clearRect(0, 70, 400, 100);
			Font font1 = new Font("Rockwell", Font.PLAIN, 50);
			g.setColor(Color.BLUE);
			g.drawString(str, 50, 150);
		}
			if(e.getSource() == button2) {
			str = text_box.getText();
			Graphics g = getGraphics();
			g.clearRect(0, 70, 400, 100);
			Font font1 = new Font("Georgia", Font.PLAIN, 50);
			g.setColor(Color.RED);
			g.drawString(str, 50, 200);
		}
		
	}

}
}