package DataStructures.Queues;

import java.util.Scanner;

public class QueriesWithFixedLength {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < q; i++) {
			int d = sc.nextInt();
			int[] queue = new int[d];
			int idx = 0;
			
			int currentMax = 0;
			for(int j = 0; j < d; j++) {
				queue[j] = arr[j];
				if(currentMax < arr[j]) {
					currentMax = arr[j];
				}
			}
			
			int currentMin = currentMax;
			
			for(int j = d; j < n; j++) {
				
				int last = queue[idx];
				queue[idx] = arr[j];
				
				if(last == currentMax) {
					currentMax = 0;
					for(int nn : queue) {
						if(currentMax < nn)
							currentMax = nn;
					}
					
					if(currentMax < currentMin) {
						currentMin = currentMax;
					}
				}
				
				idx = idx + 1 == d ? 0 : idx + 1;
			}
			
			sb.append(currentMin).append("\n");
		}
		
		sc.close();
		
		System.out.println(sb.toString());
	}

}
