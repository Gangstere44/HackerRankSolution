package TenDaysStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class MeanMedianMode {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		double mean = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			mean += arr[i];
		}
		mean /= arr.length;
		
		sc.close();
		
		Arrays.sort(arr);
		
		double median = arr.length % 2 == 0 ? (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0 : arr[arr.length / 2 - 1];
		int mode = 0;
		int modeAmount = 0;
		int curNum = 0;
		int curAmount = 0;
		for(int i : arr) {
			if(curNum != i) {
				mode = modeAmount < curAmount ? curNum: mode;
				modeAmount = Math.max(modeAmount, curAmount);
				
				curNum = i;
				curAmount = 1;
			} else {
				curAmount++;
			}
		}
		
		System.out.println(String.format("%.1f\n%.1f\n%d", mean, median, mode));
	}
}
