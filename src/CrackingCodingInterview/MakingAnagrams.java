package CrackingCodingInterview;

import java.util.Scanner;

public class MakingAnagrams {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] freq = new int[26];
		
		for(char c : sc.next().toCharArray()) {
			freq[c - 'a']++;
		}
		
		int sum = 0;
		for(char c: sc.next().toCharArray()) {
			if(freq[c - 'a'] > 0) {
				freq[c - 'a']--;
			} else {
				sum++;
			}
		}
		
		for(int i : freq) {
			sum += i;
		}
		
		sc.close();
		
		System.out.println(sum);
		
	}

}
