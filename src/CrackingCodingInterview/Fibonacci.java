package CrackingCodingInterview;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int[] mem = new int[n + 1];
		mem[0] = 0;
		mem[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			mem[i] = mem[i - 1] + mem[i - 2];
		}
		
		System.out.println(mem[n]);
	}
}
