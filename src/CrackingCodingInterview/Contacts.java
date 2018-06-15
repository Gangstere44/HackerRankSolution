package CrackingCodingInterview;

import java.util.Scanner;

public class Contacts {

	static int ALPHABET_SIZE = 26;

	static class Node {
		Node[] nexts = new Node[ALPHABET_SIZE];
		int[] counts = new int[ALPHABET_SIZE];
	}

	static void addWord(Node no, char[] st, int idx) {

		if (idx < st.length) {
			int i = st[idx] - 'a';

			if (no.nexts[i] == null) {
				no.nexts[i] = new Node();
			}

			Node cur = no.nexts[i];
			no.counts[i]++;

			addWord(cur, st, idx + 1);
		}
	}

	static int getContact(Node no, char[] st, int idx) {

		if (no == null) {
			return 0;
		}

		int i = st[idx] - 'a';

		if (idx == st.length - 1) {
			return no.counts[i];
		}

		return getContact(no.nexts[i], st, idx + 1);
	}

	public static void main(String[] args) {
		Node root = new Node();

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			String op = sc.next();
			char[] w = sc.next().toCharArray();

			if (op.equals("add")) {
				addWord(root, w, 0);
			} else {
				sb.append(getContact(root, w, 0)).append("\n");
			}
		}
		
		sc.close();

		System.out.println(sb.toString());
	}

}
