package other_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * Longest Increasing Subsequence - O(n log n) solution
 * 
 * Main Variables
 * ==============
 * - A is the original array containing elements for which we need to find LIS
 * - L is built incrementaly, L[i] contains the smallest value (A[j] for some j) 
 * that is an end for an increasing subsequence of length i + 1
 * - lis is the answer (length of the longest increasing subsequence in A)
 * 
 * Printing the Solution Variables
 * ===============================
 * - lis_end is the index of an element in A which is the last element in LIS
 * i.e. LIS = { X1, X2, X3, ...., A[lis_end] }
 * 
 * - P contains parents of every element in A for the LIS ending at that element
 * i.e. LIS_ending_at_x = { ........, A[P[P[x]]], A[P[x]], A[x] }
 * 
 * - L_id maps every value in L to its index in A
 * i.e. L_id[3] = index in A which is at index 3 in L 
 * Consequently, it is the index in A of the last element of an increasing subsequence of length 4
 *  
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

