package CrackingCodingInterview;

import java.util.Scanner;

public class Primality {

	static boolean isPrimeNaive(int n) {

		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (long i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int te = sc.nextInt();
		
		for(int t = 0; t < te; t++) {
		
			if(isPrimeNaive(sc.nextInt())) {
				sb.append("Prime");
			} else {
				sb.append("Not prime");
			}
			
			sb.append("\n");
			
		}
		
		sc.close();
		System.out.println(sb.toString());
	}

}
