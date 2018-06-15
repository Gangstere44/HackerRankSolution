package TenDaysStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class InterquartileRange {

	static double computeQ(int[] arr, int l, int r) {
		int s = r - l + 1;
		int m = (r+l) / 2;
		if(s % 2 == 0) {
			return (arr[m] + arr[m + 1]) / 2.0;
		} else {
			return arr[m];
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] elem = new int[n*2];
		int sum = 0;
		for(int i = 0; i < 2*n; i++) {
			elem[i] = sc.nextInt();
			if(i >= n) 
				sum += elem[i];
		}
		
		sc.close();
		
		int[] arr = new int[sum];
		int idx = 0;
		for(int i = 0; i < n; i++) {
			int el = elem[i];
			for(int j = 0; j < elem[n + i]; j++) {
				arr[idx] = el;
				idx++;
			}
		}
		
		Arrays.sort(arr);
		
		double res = computeQ(arr, (arr.length+1) / 2 , arr.length - 1) - computeQ(arr, 0, arr.length / 2 - 1);
		System.out.println(String.format("%.1f", res));
	}
}
