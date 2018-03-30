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
 * Can be trapped in overflow
 */
public class ConvexHullOptimization1 {

	long[] A, B; 			//initialized with size n
	int ptr, len;
	
	void addLine(long a, long b)		// O(n) with amortized complexity
	{
		while(len >= 2 && 
			 (A[len - 2] - A[len - 1]) * (b - B[len - 1]) <= (A[len - 1] - a) * (B[len - 1] - B[len - 2]))
			--len;
		A[len] = a;
		B[len] = b;
		++len;
	}
	
	long queryPointer(long x)	// O(n), queries must be performed in increasing order
	{
		ptr = Math.min(ptr, len - 1);
		while(ptr < len - 1 && A[ptr + 1] * x + B[ptr + 1] <= A[ptr] * x + B[ptr])
			++ptr;
		return A[ptr] * x + B[ptr];
	}
	
	long queryBS(long x)			// O(n log n)		-- TODO needs testing
	{
		int ans = 0;
		int lo = 1, hi = len - 1;
		while(lo <= hi)
		{
			int mid = lo + hi >> 1;
			// if intersect_x(mid, mid - 1) <= x, then ans = mid & search for higher
			if(B[mid] - B[mid - 1] <= x * (A[mid - 1] - A[mid]))
			{
				ans = cur;
				lo = mid + 1;
			}
			else
				hi = mid - 1;
		}
		return A[ans] * x + B[ans];
	}
}
