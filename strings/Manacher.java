package strings;

public class Manacher {

	static int[][] manacher(char[] s)
	{
		int n = s.length, d1[] = new int[n], d2[] = new int[n];

		//Calculation of odd-length palindromes
		for(int i = 0, l = 0, r = -1; i < n; ++i)
		{
			int k = i > r ? 1 : Math.min(r - i + 1, d1[l + r - i]);
			while(i + k < n && i - k >= 0 && s[i + k] == s[i - k])
				++k;
			d1[i] = k--;
			if(i + k > r) { l = i - k; r = i + k; }
		}
		
		//Calculation of even-length palindromes
		//you may insert # between characters of s to get rid of the following part
		for(int i = 0, l = 0, r = -1; i < n; ++i)
		{
			int k = i > r ? 0 : Math.min(r - i + 1, d2[l + r - i + 1]);
			while(i + k < n && i - k - 1 >= 0 && s[i + k] == s[i - k - 1])
				++k;
			d2[i] = k--;
			if(i + k > r) { l = i - k - 1; r = i + k; }
		}
		
		return new int[][] { d1, d2 };
	}
}
