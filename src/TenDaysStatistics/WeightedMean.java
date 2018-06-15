package TenDaysStatistics;

import java.util.Scanner;

public class WeightedMean {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int sum = 0;
		int weightSum = 0;
		for(int i = 0; i < n; i++) {
			int w = sc.nextInt();
			weightSum += w;
			sum += w * arr[i];
		}
		
		System.out.println(String.format("%.1f", sum / (double) weightSum));
	}
}
