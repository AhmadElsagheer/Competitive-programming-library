package math.number_theory;

import java.util.ArrayList;

public class PrimeNumbers {

	/*
	 * 1. Sieve of Eratosthenes: generate all primes in [2, N]
	 */
	static ArrayList<Integer> primes;
	static int[] isComposite;

	static void sieve(int N)	// O(N log log N) 
	{
		isComposite = new int[N+1];					
		isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
		primes = new ArrayList<Integer>();

		for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
			if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
			{
				primes.add(i);
				if(1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
						isComposite[j] = 1;
			}   
	}

	/*
	 * 2. Primality Test
	 * 
	 *  Preprocessing: call sieve with sqrt(N), O(sqrt(N) log log sqrt(N))
	 *  Query: best case O(1), worst case O(sqrt(N) / log sqrt(N))
	 */
	static boolean isPrime(int N)
	{
		if(N < isComposite.length)
			return isComposite[N] == 0;
		for(int p: primes)					//may stop if p * p > N
			if(N%p==0)
				return false;
		return true;
	}
	
	/*
	 * 3. Sieve of Eratostheses in linear time
	 */
	static void sieveLinear(int N)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int[] lp = new int[N + 1];								//lp[i] = least prime divisor of i
		for(int i = 2; i <= N; ++i)
		{
			if(lp[i] == 0)
			{
				primes.add(i);
				lp[i] = i;
			}
			int curLP = lp[i];
			for(int p: primes)
				if(p > curLP || p * i > N)
					break;
				else
					lp[p * i] = i;
		}
	}
}
