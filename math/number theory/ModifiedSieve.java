package math.number_theory;

import java.util.Arrays;

public class ModifiedSieve {

	/*
	 * 1. Modified sieve for number of prime factors
	 */
	static void numPF(int N)
	{
		int[] pf = new int[N];
		for(int i = 2; i < N; ++i)
			if(pf[i] == 0)
				for(int j = i; j < N; j += i)
				{
					int p = 0, k = j;
					while(k % i == 0)
					{
						k /= i;
						++p;
					}
					pf[j] += p;
				}
	}
	
	/*
	 * 2. Modified sieve for phi function
	 */
	static void phi(int N)
	{
		int[] phi = new int[N];
		for(int i = 1; i < N; ++i)
			phi[i] = i;
		
		for(int i = 2; i < N; ++i)
			if(phi[i] == i)
				for(int j = i; j < N; j += i)
					phi[j] -= phi[j] / i;
	}
	
	/*
	 * 3. Modified sieve for square-free numbers (prime factorization doesn't include a factor with power > 1)
	 * 	  Useful in inclusion-exclusion problems that need divisibility counting
	 */
	static void squareFree(int N)
	{
		boolean[] prime = new boolean[N];
		Arrays.fill(prime, true);

		boolean[] squareFree = new boolean[N];	
		Arrays.fill(squareFree, true);

		for(int i = 2; i <= N; ++i)
			if(prime[i])
				for(int j = 2; i * j <= N; ++j)
				{
					prime[i*j] = false;
					if(j % i == 0)
						squareFree[i*j] = false;
				}
	}
}
