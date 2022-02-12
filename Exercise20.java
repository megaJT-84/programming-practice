/*Tian Xiaoyang
 * 26001904581
 * detect user input, only positive integers are taken
 * Nov 30, 2021
 */

import java.io.*;

public class Exercise20 {
	BufferedReader reader;
	
	public Exercise20() {
		int user_input;
		InputStreamReader isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);
		
		do {
			user_input = getData();
			if(user_input > 0) {
				System.out.println(user_input);
				file(user_input);
				
			}else {
				System.out.println("not integer or negative number");
			}
		} while (user_input >= 0);
		System.out.println("system terminated");
		
		
		
	}
	public void file(int input) {
		try {
			FileWriter fw = new FileWriter("/Users/wcwe/desktop/numbers.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			if(input>=0) {
			bw.write(Integer.toString(input));
			bw.newLine();
			}
			bw.close();
			
			
		}catch (IOException e) {
			System.out.println(e);
		}	
		
	}
	public int getData() {
		String KB;
		int usr_in;
		try {
			System.out.print("Input: ");
			KB = reader.readLine();
			usr_in = Integer.parseInt(KB);
			return usr_in;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}

	public static void main(String[] args) {
		new Exercise20();
	}

}
