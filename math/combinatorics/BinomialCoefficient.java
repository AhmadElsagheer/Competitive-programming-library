package math.combinatorics;

public class BinomialCoefficient {

	/*
	 * 1. Pascal's Rule: recursive | Top-down approach
	 */
	static long[][] comb;			//may need BigInteger, if the numbers are large, use a treemap
	
	static long nCr1(int n , int k)
	{
		if(n < k)
			return 0;
		if(k == 0 || k == n)
			return 1;
		if(comb[n][k] != -1)
			return comb[n][k];
		if(n - k < k)
			return comb[n][k] = nCr1(n, n - k);
		return comb[n][k] = nCr1(n - 1, k - 1) + nCr1(n - 1, k);
	}
	
	/*
	 * 2. Pascal's Rule: iterative | Bottom-up approach
	 */
	static void nCr2(int N)		// O(N * N)
	{
		comb = new long[N][N];
		comb[0][0] = 1;
		for (int i = 1; i < N; i++)
		{
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++)
				comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]);		//may use mod
		}
	}
	
	/*
	 * 3. Multiplicative formula: recursive | Top-down approach
	 */
	static long nCr3(int n, int k)		// O(n * k)
	{
		if(n < k)					
			return 0;
		if(k == 0 || k == n)		//may add k == 1 as a base case for fast calculations
			return 1;
		if(comb[n][k] != -1)
			return comb[n][k];
		if(n - k < k)				
			return comb[n][k] = nCr3(n, n - k);		//reduce k to n - k
		return comb[n][k] = n * nCr3(n - 1, k - 1) / k;
	}
	

	/*
	 * 4. Multiplicative formula: iterative
	 */
	static int nCr4(int N, int K)		// O(K)
	{
		if(K > N)
			return 0;
		int res = 1;
		for(int i = 1; i <= K; ++i)
			res = (N - K + i) * res / i;
		return res;
	}
}
