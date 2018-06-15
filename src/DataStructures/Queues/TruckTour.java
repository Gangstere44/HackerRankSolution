package DataStructures.Queues;

import java.util.Scanner;

public class TruckTour {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] p = new int[n][2];
		
		for(int i = 0; i < n ; i++) {
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}
		sc.close();
		
		int start = 0;
		boolean flag = true;
		
		while(flag) {
			
			int tank = p[start][0];
			int dist = p[start][1];
			int cur = start;
		    flag = false;
			
			do {
				
				cur = cur + 1 == n ? 0 : cur + 1;
				
				tank -= dist;
				if(tank >= 0) {
					tank += p[cur][0];
					dist = p[cur][1];
				} else {
					start = cur;
					flag = true;
				}
				
			} while(cur != start && !flag);
		}
		
		System.out.println(start);
		
	}

}
