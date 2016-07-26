package strings;

import java.util.Arrays;

public class KMP {

	static char[] T, P;
	static int n, m, f[];
	
	static void preprocess()
	{
		int i = 0, j = -1;
		f[0] = -1;
		while(i < m)
		{	
			while(j >= 0 && P[i] != P[j]) j = f[j];
			f[++i] = ++j;
		}
	}
	
	static void search()
	{
		int i = 0, j = 0;
		while(i < n)
		{
			while(j >= 0 && T[i] != P[j]) j = f[j];
			i++; j++;
			if(j == m)
			{
				System.out.printf("P is found at index %d in T\n", i - j);
				j = f[j];
			}
		}
		
	}
	
	
	//Prefix Function: pi[k] = length of longest proper prefix matching a suffix ending at k 
	static int[] prefixFunction(char[] s)		// O(n)
	{
		int n = s.length, pi[] = new int[n];
		for(int i = 1, j = 0; i < n; ++i)		//j = pi[i-1] at the beginning of every iteration
		{
			while(j > 0 && s[i] != s[j])
				j = pi[j-1];
			if(s[i] == s[j])
				++j;
			pi[i] = j;
		}
		return pi;
	}
	
}
