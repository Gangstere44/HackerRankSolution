package DataStructures.Stacks;

import java.util.Scanner;

public class LargestRectangle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long max = 0;
		
		int[] arr = new int[n];
		int[] lastIdx = new int[n];
		int idx = -1;
		for(int i = 0; i < n; i++) {
			int cur = sc.nextInt();
			
			if(idx == -1) {
				idx++;
				arr[idx] = cur;
				lastIdx[idx] = i;
			} else if(cur > arr[idx]) {
				idx++;
				arr[idx] = cur;
				lastIdx[idx] = i;
			} else if(cur < arr[idx]) {
				while(idx >= 0 && cur < arr[idx]) {
					max = Math.max(max, arr[idx] * (i - lastIdx[idx]));
					idx--;
				}
			}
		}
		
		//System.out.println(Arrays.toString(arr));
		//System.out.println(Arrays.toString(lastIdx));

		sc.close();
		
		for(int i = idx; i >= 0; i--) {
			max = Math.max(max, arr[i] * (n - lastIdx[i]));
		}
			
		System.out.println(max);	
	}

}
