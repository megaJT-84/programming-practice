/*Tian Xiaoyang
 * 26001904581
 * read the content of a txt file, print the number of items and calculate average
 * Nov 30, 2021
 */
import java.io.*;

public class Exercise21 {
	
	public Exercise21() {
		String read_in;
		float avg_cal = 0;
		float total = 0;
		float avg = 0;
		try {
			FileReader reader = new FileReader("data11.txt");
			BufferedReader buff_read = new BufferedReader(reader);
			read_in = buff_read.readLine();
			while (read_in != null) {
				System.out.println(read_in);
				avg_cal = Integer.parseInt(read_in);
				total = total + avg_cal;
				read_in = buff_read.readLine();
			}
			avg = total/11;
			
			System.out.println("end of file loading");
			buff_read.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("average of data is " + avg);
		System.out.println("number of data is 11");
		
	}

	public static void main(String[] args) {
		new Exercise21();

	}

}
