package CrackingCodingInterview;

import java.util.HashSet;
import java.util.Scanner;

public class DFSConnectedCellGrid {

	static int dfs(int[][] mtx, int i, int j, HashSet<String> visited) {
		if(i < 0 || j < 0 || i >= mtx.length || j >= mtx[0].length || mtx[i][j] == 0) {
			return 0;
		}
		
		if(visited.contains(i + " " +j)) {
			return 0;
		} 
		
		visited.add(i + " " + j);
		return 1 
				+ dfs(mtx, i + 1, j, visited)
				+ dfs(mtx, i - 1, j, visited)
				+ dfs(mtx, i, j + 1, visited)
				+ dfs(mtx, i, j - 1, visited)
				+ dfs(mtx, i + 1, j + 1, visited)
				+ dfs(mtx, i - 1, j - 1, visited)
				+ dfs(mtx, i + 1, j - 1, visited)
				+ dfs(mtx, i - 1, j + 1, visited);
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] mtx = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				mtx[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		HashSet<String> visited = new HashSet<String>();
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				max = Math.max(max, dfs(mtx, i, j, visited));
				visited.add(i + " " + j);
			}
		}
		
		System.out.println(max);
	}

}
