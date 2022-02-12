
public class TotalAverage {
	double[] data = { 12.03, 7.34, 23.42, 94.85, 7.83, 3.19, 43.23 };

	public TotalAverage() {
		double total = 0.0;
		double average = 0.0;
		for (int i = 0; i <= 6; i++) {
			total = total + data[i];
		}
		average = total / 7;
		System.out.println("The total is " + total);
		System.out.println("The average is " + average);
	}

	public static void main(String[] args) {
		new TotalAverage();
	}
}
