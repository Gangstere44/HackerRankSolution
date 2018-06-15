package DataStructures.Stacks;

import java.util.Scanner;


/*
 * For each int i in the array A
    while stack is nonempty
        yield (i, top of stack)
        if i is less than the top of the stack, pop the stack
        otherwise break the while loop
    push i onto stack
 * 
 */

public class AndXorOr {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] st = new int[n];
		int idx = 0;
		int max = 0;
		
		st[idx] = sc.nextInt();
		idx++;
		
		for(int i = 1; i < n; i++) {
			
			int cur = sc.nextInt();
			
			max = Math.max(max, cur ^ st[idx - 1]);
			
			while(idx > 0) {
				int top = st[idx - 1];
				if(top > cur) {
					idx--;
					max = Math.max(max, cur ^ top);
				} else {
					max = Math.max(max, cur ^ top);

					break;
				}
			}
			
			st[idx] = cur;
			idx++;
			
		}
		sc.close();
		
		System.out.println(max);
	}

}
