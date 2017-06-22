package math;

public class Exponentiation {
	
	/*
	 * 1. Binary Exponentiation
	 */
	static int pow(int a, int e)	// O(log e)
	{
		int res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res *= a;
			a *= a;
			e >>= 1;
		}
		return res;
	}
	
	/*
	 * 2. Fast Exponentiation
	 */
	static int modPow(int a, int e, int mod)	// O(log e)
	{
		a %= mod;
		int res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			e >>= 1;
		}
		return res;
	}
	
	/*
	 * 3. Matrix Multiplication
	 */
	static int[][] matMul(int[][] A, int[][] B, int p, int q, int r)	//C(p x r) = A(p x q) x (q x r) -- O(p x q x r)
	{
		int[][] C = new int[p][r];
		for(int i = 0; i < p; ++i)
			for(int j = 0; j < r; ++j)
				for(int k = 0; k < q; ++k)
					C[i][j] += A[i][k] * B[k][j];
		return C;
	}
	
	/*
	 * 4. Square Matrix Exponentiation
	 */
	static int[][] matPow(int[][] base, int p)
	{
		int n = base.length;
		int[][] ans = new int[n][n];
		for(int i = 0; i < n; i++)
			ans[i][i] = 1;
		while(p != 0)
		{
			if((p & 1) == 1)
				ans = matMul(ans, base, n, n, n);
			base = matMul(base, base, n, n, n);
			p >>= 1;
		}
		
		return ans;
	}
	
	// 5. Power of big numbers
	static String powBig(int a, int b)
	{
		int[] ret = new int[5000];
		ret[4999] = 1;
		while(b-->0)
		{
			int c = 0;
			for(int j = 4999; j >= 0; --j)
			{
				int p = c + a * ret[j];
				c = p/10;
				ret[j] = p%10;
				
			}
		}
		String s = "";
		for(int i = 0; i < ret.length; ++i)
			if(!s.isEmpty() || ret[i] != 0)
				s += ret[i];
		return s;
	}
}
