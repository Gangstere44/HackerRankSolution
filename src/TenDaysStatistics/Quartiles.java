package TenDaysStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {

	static int computeQ(int[] arr, int l, int r) {
		int s = r - l + 1;
		int m = (r+l) / 2;
		if(s % 2 == 0) {
			return (arr[m] + arr[m + 1]) / 2;
		} else {
			return arr[m];
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(arr);
		
		System.out.println(computeQ(arr, 0, arr.length / 2 - 1));
		System.out.println(computeQ(arr, 0, arr.length - 1));
		System.out.println(computeQ(arr, (arr.length+1) / 2 , arr.length - 1));
	}
}
