package CrackingCodingInterview;

import java.util.Scanner;

public class ArrayLeftRotation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb  = new StringBuilder();
		
		int n = sc.nextInt();
		int d = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = n-d; i < n + (n-d); i++) {
			arr[i % n] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i: arr) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
