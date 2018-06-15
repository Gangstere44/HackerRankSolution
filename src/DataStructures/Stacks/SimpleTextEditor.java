package DataStructures.Stacks;

import java.util.Scanner;

public class SimpleTextEditor {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		char[] arr = new char[1000000];
		int[] ops = new int[n];
		char[][] vals = new char[n][];

		int idxArr = 0;
		int idxOp = 0;

		for (int i = 0; i < n; i++) {

			
			int q = sc.nextInt();

			if (q == 1) {

				char[] cc = sc.next().toCharArray();
				
				ops[idxOp] = q;
				vals[idxOp] = cc;
				idxOp++;
					
				for(char c: cc) {
					arr[idxArr] = c;
					idxArr++;
				}

			} else if (q == 2) {
				
				int d = sc.nextInt();
				char[] tmp = new char[d];
				
				for(int j = d - 1; j >= 0 && idxArr > 0; j--) {
					idxArr--;
					tmp[j] = arr[idxArr];
				}
								
				ops[idxOp] = q;
				vals[idxOp] = tmp;
				idxOp++;
				
			} else if (q == 3) {

				sb.append(arr[sc.nextInt() - 1]).append("\n");

			} else {

				if(idxOp > 0) {
					idxOp--;
					int op = ops[idxOp];
					char[] val = vals[idxOp];
					
					if(op == 1) {
						idxArr -= val.length;
						idxArr = idxArr < 0 ? 0 : idxArr;
					} else {
						for (char c: val) {
							arr[idxArr] = c;
							idxArr++;
						}
					}
				}	
			}
		}
		sc.close();

		System.out.println(sb.toString());
	}
	

}
