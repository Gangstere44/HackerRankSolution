package CrackingCodingInterview;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindRunningMedian {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {

			int cur = sc.nextInt();

			if (maxHeap.isEmpty() || cur <= maxHeap.peek()) {
				if (maxHeap.size() > minHeap.size()) {
					minHeap.add(maxHeap.poll());
				}
				maxHeap.add(cur);
			} else if (minHeap.isEmpty() || cur >= minHeap.peek()) {
				if (minHeap.size() > maxHeap.size()) {
					maxHeap.add(minHeap.poll());
				}
				minHeap.add(cur);
			} else {
				if (minHeap.size() > maxHeap.size()) {
					maxHeap.add(cur);
				} else if (minHeap.size() < maxHeap.size()) {
					minHeap.add(cur);
				} else {
					minHeap.add(cur);
				}
			}

			if (maxHeap.size() > minHeap.size()) {
				sb.append((double) maxHeap.peek()).append("\n");
			} else if (maxHeap.size() < minHeap.size()) {
				sb.append((double) minHeap.peek()).append("\n");
			} else {
				sb.append((double) (maxHeap.peek() + minHeap.peek()) / 2).append("\n");
			}
		}

		sc.close();
		System.out.println(sb.toString());
	}

}
