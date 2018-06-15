package CrackingCodingInterview;

import java.util.Scanner;

public class BalancedBracket {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		char[] stack = new char[10];
		int idx = 0;
		
		for(int t = 0; t < n; t++) {
			
			idx = 0;
			char[] br = sc.next().toCharArray();
			String res = "YES";
			for(char c: br) {
				if(c == '(' || c == '{' || c == '[') {
					stack[idx] = c;
					idx++;
				} else if(c == ')') {
					if(idx > 0 && stack[idx - 1] == '(') {
						idx--;
					} else {
						res = "NO";
						break;
					}
				} else if(c == '}') {
					if(idx > 0 && stack[idx - 1] == '{') {
						idx--;
					} else {
						res = "NO";
						break;
					}
				} else {
					if(idx > 0 && stack[idx - 1] == '[') {
						idx--;
					} else {
						res = "NO";
						break;
					}
				}
			}
			
			if(idx != 0) {
				res = "NO";
			}
			
			sb.append(res).append("\n");
		}
		
		sc.close();
		System.out.println(sb.toString());
	}

}
