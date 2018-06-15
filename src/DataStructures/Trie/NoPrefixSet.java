package DataStructures.Trie;

import java.util.Scanner;

public class NoPrefixSet {

	static int ALPHABET_SIZE = 'j' - 'a' + 1;

	static class Node {

		Node[] nexts = new Node[ALPHABET_SIZE];

		boolean end = false;
	}

	static boolean addWord(Node no, char[] st, int idx) {

		if (idx < st.length) {
			int i = st[idx] - 'a';

			if(no.nexts[i] != null && idx == st.length - 1) {
				return false;
			}
			
			if (no.nexts[i] == null) {
				no.nexts[i] = new Node();
			}

			Node cur = no.nexts[i];

			if (cur.end) {
				return false;
			} else
				return addWord(cur, st, idx + 1);
		} else {
			no.end = true;
			
			return true;
		}

	}


	public static void main(String[] args) {

		Node root = new Node();

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		boolean flag = true;
		String current = "";
		for (int i = 0; i < n && flag; i++) {
			
			current = sc.next();
			char[] w = current.toCharArray();

			flag = addWord(root, w, 0);
		}
		
		sc.close();
		
		if(flag)
			System.out.println("GOOD SET");
		else {
			System.out.println("BAD SET");
			System.out.println(current);
		}
	}
}
