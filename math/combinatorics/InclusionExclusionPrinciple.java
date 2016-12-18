package math.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;

public class InclusionExclusionPrinciple {

	/*
	 * 1. Count the number of numbers in the range [1, r] that are coprime with n 
	 */
	static int countCoprime(int n, int r)		//  O(sqrt(n))
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = 2; i * i <= n; ++i)
			if(n%i == 0)
			{
				primes.add(i);
				while(n%i == 0) n /= i;
			}
		if(n > 1)
			primes.add(n);
		int sum = 0, size = primes.size();
		for(int msk = 1, end = 1<<size; msk < end; ++msk)
		{
			int mult = 1, bits = 0;
			for(int i = 0; i < size; ++i)
				if((msk & 1<<i) != 0)
				{
					++bits;
					mult *= primes.get(i);
				}
			if(bits%2 == 1)
				sum += r / mult;
			else
				sum -= r / mult;
		}

		return r - sum;
	}

	/*
	 * 2. Count the number of harmonic triples (a, b, c) 2 <= a < b < c <= n
	 */
	static int countHarmonic(int n)
	{
		boolean[] divisor = new boolean[n + 1];		//for inclusion-exclusion
		Arrays.fill(divisor, true);

		int[] cnt = new int[n + 1];					//cnt[i] = # of x where gcd(x, i) > 1
		int[] deg = new int[n + 1];					//deg[i] = # of primes comprising i

		int bad = 0;
		for(int i = 2; i <= n; ++i)
		{
			if(divisor[i])
			{
				if(deg[i] == 0)
					deg[i] = 1;
				for(int j = 1; j * i <= n; ++j)
				{
					if(j > 1 && deg[i] == 1)
						if(j % i == 0)
							divisor[i*j] = false;		//cross out multiples of squares of primes
						else
							++deg[i*j];
					cnt[i*j] += n / i * (deg[i]%2 == 1 ? 1 : -1);
				}
			}
			bad += (cnt[i] - 1) * (n - 1 - cnt[i]);
		}

		return (n - 1) * (n - 2) * (n - 3) / 6 - bad / 2;
	}
}
