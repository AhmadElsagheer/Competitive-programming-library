package other_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * Longest Increasing Subsequence - O(n log n) solution
 */
class LIS {		
	
	static Stack<Integer> stack;	//contains the last solution in increasing order
	
	static int lis(int[] A, int n)		// Can be implemented with TreeSet (lower, remove, add)
	{
		ArrayList<Integer> L = new ArrayList<Integer>();
		int[] P = new int[n];
		int[] L_id = new int[n];
		
		int lis = 0, lis_end = -1;
		for(int i = 0; i < n; ++i) 
		{
			int pos = Collections.binarySearch(L, A[i]);
			if (pos < 0) pos = -(pos + 1);
			//			 else	pos++;		non-decreasing

			if(pos >= L.size()) L.add(A[i]);
			else                 L.set(pos, A[i]);

			if(pos + 1 > lis)
			{
				lis = pos + 1;
				lis_end = i;
			}
			
			//lis_end and the following part for printing the solution
			L_id[pos] = i;
			P[i] = pos > 0 ? L_id[pos-1] : -1;
		}
		
		stack = new Stack<Integer>();
		while(lis_end != -1)
		{
			stack.push(A[lis_end]);
			lis_end = P[lis_end];
		}
		return lis;
	}
}

