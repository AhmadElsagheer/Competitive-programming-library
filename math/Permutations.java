package math;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {

	/*
	 * 1. Compute Next Permutation
	 */
	static boolean nextPermutation(char[] c) 
	{
		// 1. finds the largest k, that c[k] < c[k+1]
		int first = getFirst(c);
		if(first == -1)
			return false;

		// 2. find last index toSwap, that c[k] < c[toSwap]
		int toSwap = c.length - 1;
		while (c[first] >= c[toSwap])
			--toSwap;

		// 3. swap elements with indexes first and last
		swap(c, first++, toSwap);

		// 4. reverse sequence from k+1 to n (inclusive) 
		toSwap = c.length - 1;
		while(first < toSwap)
			swap(c, first++, toSwap--);
		return true;
	}

	// finds the largest k, that c[k] < c[k+1]
	// if no such k exists (there is not greater permutation), return -1
	static int getFirst(char[] c) 
	{
		for ( int i = c.length - 2; i >= 0; i--)
			if (c[i] < c[i + 1])
				return i;
		return -1;
	}


	static void swap(char[] c,int i, int j) 
	{
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}


	/*
	 * 2. Find Kth permutation (0-based, lexiographically, no duplicates)
	 */
	static char[] kthPermutation1(char[] s, int k)		//O(n^2) where n = s.length
	{
		ArrayList<Character> rem = new ArrayList<Character>();
		for(char c: s)
			rem.add(c);
		Collections.sort(rem);
		int[] facNum = new int[s.length];
		for(int i = 1; i <= s.length; k /= i++)
			facNum[s.length - i] = k % i;

		char[] ret = new char[s.length];
		for(int i = 0; i < s.length; ++i)
		{
			ret[i] = rem.get(facNum[i]);
			rem.remove(facNum[i]);
		}
		return ret;
	}

	/*
	 * 3. Find Kth permutation (0-based, lexiographically, duplicates handled)
	 */
	static char[] kthPermutation2(char[] s, int k)		//O(n * m) where n = s.length, m = alphabet size
	{
		int n = s.length;
		int[] f = new int[26];
		for(char c: s)
			f[c-'a']++;

		int[] facNum = new int[n];
		for(int i = 1; i <= n; k /= i++)
			facNum[n - i] = k % i;

		char[] ret = new char[n];
		for(int i = 0; i < n; ++i)
		{
			int z = facNum[i];
			for(int j = 0; j < 26; ++j)
				if(f[j] > z)
				{
					ret[i] = (char) (j + 'a');
					f[j]--;
					break;
				}
				else
					z -= f[j];
		}
		return ret;
	}
}
