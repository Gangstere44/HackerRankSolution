package CrackingCodingInterview;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		sc.nextInt();
		sc.nextInt();
		sc.nextLine();
		
		HashMap<String, Integer> freqs = new HashMap<>();
		
		for(String s: sc.nextLine().split(" ")) {
			if(freqs.containsKey(s)) {
				freqs.put(s, freqs.get(s) + 1);
			} else {
				freqs.put(s, 1);
			}
		}
		
		String res = "Yes";
		for(String s: sc.nextLine().split(" ")) {
			if(freqs.containsKey(s)) {
				if(freqs.get(s) == 1) {
					freqs.remove(s);
				} else {
					freqs.put(s, freqs.get(s) - 1);
				}
			} else {
				res = "No";
				break;
			}
		}
		
		sc.close();
		System.out.println(res);
	}
}
