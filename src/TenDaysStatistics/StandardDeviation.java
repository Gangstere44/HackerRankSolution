package TenDaysStatistics;

import java.util.Scanner;

public class StandardDeviation {

	static double squared(double x) {
		return x * x;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		
		double mean = 0.0;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			mean += arr[i];
		}
		mean /= arr.length;
		
		sc.close();
		
		double sum2 = 0.0;
		for(int i : arr) {
			sum2 += squared(i - mean);
		}
		
		System.out.println(String.format("%.1f", Math.sqrt(sum2 / arr.length)));
		
	}
}
