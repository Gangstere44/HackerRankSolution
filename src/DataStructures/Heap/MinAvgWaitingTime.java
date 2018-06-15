package DataStructures.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinAvgWaitingTime {

	static class Cust {
		long timeStart;
		long pizzaTime;

		long total;

		long end;

		Cust(long t, long p) {
			timeStart = t;
			total = p;
			pizzaTime = p;
			end = t + p;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Cust[] arr = new Cust[n];

		for (int i = 0; i < n; i++) {

			long t = sc.nextLong();
			long p = sc.nextLong();

			arr[i] = new Cust(t, p);
		}
		sc.close();

		Arrays.sort(arr, new Comparator<Cust>() {

			@Override
			public int compare(Cust o1, Cust o2) {
				if (o1.timeStart > o2.timeStart)
					return 1;
				else if (o1.timeStart < o2.timeStart)
					return -1;
				else
					return 0;
			}

		});
		
		PriorityQueue<Cust> q = new PriorityQueue<>(n, new Comparator<Cust>() {

			@Override
			public int compare(Cust o1, Cust o2) {
				if(o1.pizzaTime > o2.pizzaTime)
					return 1;
				else if(o1.pizzaTime < o2.pizzaTime)
					return -1;
				else 
					return 0;	
			}
		});

		int idx = 0;
		long currentTime = 0;
		long tot = 0;
		while (idx < arr.length || !q.isEmpty()) {
			while (idx < arr.length && currentTime >= arr[idx].timeStart) {
				q.add(arr[idx]);
				idx++;
			}
			if(!q.isEmpty()) {
				Cust cur = q.poll();

				currentTime += cur.pizzaTime;
				tot += currentTime - cur.timeStart;
			} else if(idx < arr.length){
				q.add(arr[idx]);
				idx++;
				currentTime = arr[idx].timeStart;
			}
		}

		System.out.println(tot / n);
	}

}
