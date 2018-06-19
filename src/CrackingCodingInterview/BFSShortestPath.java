package CrackingCodingInterview;

import java.util.LinkedList;
import java.util.Scanner;

public class BFSShortestPath {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int q = sc.nextInt();
		
		for(int t = 0; t < q; t++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			LinkedList<Integer>[] adj = new LinkedList[n];
			for(int i = 0; i < n; i++) {
				adj[i] = new LinkedList<Integer>();
			}
			
			for(int i = 0; i < m; i++) {
				adj[sc.nextInt() - 1].add(sc.nextInt() - 1);
			}
			
			int s = sc.nextInt() - 1;
			int[] res = new int[n];
			for(int i = 0; i < n; i++) {
				res[i] = -1;
			}
			
			LinkedList<Integer> toVisit = adj[s];
			
			int weight = 6;
			while(toVisit.size() > 0) {
				
				LinkedList<Integer> tmp = new LinkedList<Integer>();
				
				for(int i : toVisit) {
					res[i] = weight;
				}
				
				for(int i : toVisit) {
					for(int j : adj[i]) {
						if(res[j] == -1) {
							tmp.addAll(adj[j]);
						}
					}
				}
				
				toVisit = tmp;
				
				weight += 6;
			}
			
			for(int i = 0; i < n; i++) {
				if(i != s) {
					sb.append(res[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		sc.close();
		System.out.println(sb.toString());
	}

}
