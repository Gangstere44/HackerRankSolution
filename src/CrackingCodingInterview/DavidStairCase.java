package CrackingCodingInterview;

import java.util.Scanner;

public class DavidStairCase {

	static int recSt(int n) {
		if(n < 0) {
			return 0;
		} else if(n == 0) {
			return 1;
		} else {
			return recSt(n - 1) + recSt(n - 2) + recSt(n -3);
		}		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[] st = new int[37];
		st[1] = 1;
		st[2] = 2;
		st[3] = 4;
		for(int i = 4; i < st.length; i++) {
			st[i] = st[i - 1] + st[i - 2] + st[i - 3];
		}
		
		int te = sc.nextInt();

		for (int t = 0; t < te; t++) {
			System.out.println(st[sc.nextInt()]);
		}

		sc.close();
	}

}
