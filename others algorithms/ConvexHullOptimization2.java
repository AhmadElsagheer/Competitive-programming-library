package other_algorithms;

/*
 * Convex Hull Optimization
 * dp[i] = min(j < i){ dp[j] + a[i] * b[j] } where b[j] >= b[j + 1]
 * 
 * Original Complexity: O(n^2)
 * Optimized Complexity: O(n log n) or O(n) if a[i] <= a[i + 1]
 * 
 * Following operations are used within the DP function
 * 
 * Overflow avoided assuming integer x coordinates required for queries (slower due to divisions)
 */
public class ConvexHullOptimization2 {

	long[] A, B, lst; 			//initialized with size n
	int head, end;
	
	void addLine(long a, long b)		// O(n) with amortized complexity
	{
		while(end - head > 0)
		{
			lst[end - 1] = Math.floorDiv(b - B[end - 1], A[end - 1] - a);
			if(end - head == 1 || lst[end - 1] > lst[end - 2])
				break;
			--end;
		}
		A[end] = a;
		B[end] = b;
		lst[end] = Long.MAX_VALUE;
		++end;
	}
	
	long queryPointer(long x)	// O(n), queries must be performed in increasing order
	{
		while(lst[head] < x)
			++head;
		return A[head] * x + B[head];
	}
}
