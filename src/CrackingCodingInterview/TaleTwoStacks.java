package CrackingCodingInterview;

import java.util.Scanner;

public class TaleTwoStacks {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		int[] queue = new int[n];
		int head = 0;
		int tail = 0;

		for (int i = 0; i < n; i++) {

			int q = sc.nextInt();

			if (q == 1) {
				queue[tail++] = sc.nextInt();
			} else if (q == 2) {
				head++;
			} else {
				sb.append(queue[head]).append("\n");
			}
		}

		sc.close();
		System.out.println(sb.toString());
	}
}
