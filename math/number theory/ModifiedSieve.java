package math.number_theory;

public class ModifiedSieve {

	/*
	 * 1. Modified Sieve for number of prime factors
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
	 * 2. Modified Sieve for phi function
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

}
