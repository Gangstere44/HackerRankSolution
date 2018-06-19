package CrackingCodingInterview;

import java.util.Scanner;

public class MergeSortCountingInversion {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int d = sc.nextInt();
		
		for(int t = 0; t < d; t++) {

			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if(arr[j] > arr[j + 1]) {
						int tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
						sum++;
					}
					
				}
			}
			
			System.out.println(sum);
		}
		
		sc.close();
	}
}
