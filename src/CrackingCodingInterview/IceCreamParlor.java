package CrackingCodingInterview;

import java.util.HashMap;
import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int te = sc.nextInt();
		
		for(int t = 0; t < te; t++) {
			
			int s = sc.nextInt();
			HashMap<Integer, Integer> fl = new HashMap<>();
			
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				
				int cur = sc.nextInt();

				if(fl.containsKey(s - cur)) {
					sb.append(fl.get(s - cur)).append(" ").append(i+1);
				} else {
					fl.put(cur, i + 1);
				}
			}
			
			sb.append("\n");
		}
		
		sc.close();
		System.out.println(sb.toString());
		
	}

}
