package DataStructures.SelfBalancedTree;

import java.util.Scanner;

public class BalancedForest {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int[] c = new int[n];
			for (int c_i = 0; c_i < n; c_i++) {
				c[c_i] = in.nextInt();
			}
			
			int[][] mtx = new int[n - 1][2];
			for (int a1 = 0; a1 < n - 1; a1++) {
				int x = in.nextInt();
				int y = in.nextInt();
				
				mtx[a1][0] = x;
				mtx[a1][1] = y;
			}
			
			
		}
		in.close();
	}
}
