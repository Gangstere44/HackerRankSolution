package Algorithmes.GameTheory;

import java.util.Scanner;

public class GameOfStones {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++) {
			int r = sc.nextInt();
			sb.append(r % 7 == 0 || r % 7 == 1 ? "Second" : "First").append("\n");
		}
		
		sc.close();
		System.out.println(sb.toString());
	}

}
