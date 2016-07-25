package graphs.trees;

import java.util.Arrays;

/*
 * Lowest Common Ancestor in a Rooted Tree
 * 
 * Algorithm 1: Parent Sparse Table
 * Algorithm 2: Euler Walk + RMQ
 */
public class LCA {

	/*
	 * Algorithm 1: Parent Sparse Table
	 */
	static int N, L[], P[][];			// P[i][j] --> the 2^j th ancestor of node i
	
	static void preprocessParents(int root, int[] T)	// O(n log n)
	{
		int k = 0; while(1<<k+1 < N) ++k;		// max parent = floor(log2(N - 1))
		
		P = new int[N][k + 1];
		
		for(int i = 0; i < N; i++)
			Arrays.fill(P[i], -1);
		
		// base case: direct parents
		for(int i = 0; i < N; ++i)
			P[i][0] = T[i];					// T[root] = -1				
		
		for(int j = 1; j <= k; j++)			
			for(int i = 0; i < N; i++)
				if(P[i][j-1] != -1)
					P[i][j] = P[P[i][j-1]][j-1];
	}
	
	 static int query(int p, int q)		// O(log n)
	 {
		  //if p is situated on a higher level than q, swap them
		 if (L[p] < L[q]) { p ^= q; q ^= p; p ^= q; }
		 
		 //find largest k such that 2^k is a parent of p
		 int k = 0;
		 while(1<<k+1 <= L[p])
			 ++k;
		 
		 //find the ancestor of p situated on the same level with q
		 for (int i = k; i >= 0; --i)
			 if (L[p] - (1<<i) >= L[q])
				 p = P[p][i];
		 
		 if (p == q)
			 return p;
		 
		 //go up to lowest (non-common) ancestors for p and q
		 for (int i = k; i >= 0; --i)
			 if (P[p][i] != -1 && P[p][i] != P[q][i])
			 {
				 p = P[p][i]; q = P[q][i];
			 }
		 
		 return P[p][0];
	 }	
	
	 /*
	  * Algorithm 2: Euler Walk + RMQ
	  * =============================
	  * 
	  * LCA(u, v) = E[rmq on L (tin[u], tin[v])]
	  */
}
