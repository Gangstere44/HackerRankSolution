package DataStructures.DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SuperMaximumCostQuery {

	static class Edge {
		int v1, v2, w;

		Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public String toString() {
			return v1 + " - " + v2 + " : " + w;
		}
	}

	static int find(int[] subsets, int i) {
		if (subsets[i] != i) {
			subsets[i] = find(subsets, subsets[i]);
		}

		return subsets[i];
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();

		Edge[] arr = new Edge[n - 1];

		// get edge and sort length
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
		}

		Arrays.sort(arr, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				if (o1.w > o2.w)
					return 1;
				else if (o1.w < o2.w)
					return -1;
				return 0;
			}

		});

		// get size per length
		int[] u = new int[n];
		long[] cu = new long[n];
		for (int i = 0; i < u.length; i++) {
			u[i] = i;
			cu[i] = 1;
		}

		ArrayList<Integer> len = new ArrayList<>();
		ArrayList<Long> si = new ArrayList<>();

		len.add(0);
		si.add(0L);
		for (int i = 0; i < arr.length; i++) {
			Edge cur = arr[i];

			int p1 = find(u, cur.v1);
			int p2 = find(u, cur.v2);

			u[p1] = p2;
			
			long tot = si.get(si.size() - 1);
			
			if(len.get(len.size() - 1) != cur.w) {
				len.add(cur.w);
				si.add(tot + cu[p1] * cu[p2]);
			} else  {
				si.set(si.size() - 1, si.get(si.size() - 1) + cu[p1] * cu[p2]);
			}

			
			cu[p2] += cu[p1];

		}
		
		StringBuilder sb = new StringBuilder();
		// query
		for (int i = 0; i < q; i++) {
			int L = sc.nextInt();
			int R = sc.nextInt();

			if(L > len.get(len.size() - 1) || R < len.get(1)) 
				sb.append("0\n");
			 else {
				 int i1 = Collections.binarySearch(len, L - 1);
				 int i2 = Collections.binarySearch(len, R);
				 i1 = i1 < 0 ? -i1 - 2 : i1;
				 i2 = i2 < 0 ? -i2 - 2 : i2;
				 sb.append(si.get(i2) - si.get(i1)).append("\n");
			 }
		}
		
		sc.close();
		System.out.println(sb.toString());
		
	}

}
