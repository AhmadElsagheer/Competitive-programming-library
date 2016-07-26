package strings;

public class SuffixArray {

	int[] SA;
	
	SuffixArray(char[] s)					//has a terminating character (e.g. '$')
	{
		int n = s.length, RA[] = new int[n];
		SA = new int[n];
		
		for(int i = 0; i < n; ++i) { RA[i] = s[i]; SA[i] = i; }
		
		for(int k = 1; k < n; k <<= 1)
		{
			sort(SA, RA, n, k);
			sort(SA, RA, n, 0);
			int[] tmp = new int[n];

			for(int i = 1, r = 0, s1 = SA[0], s2; i < n; ++i)
			{
				s2 = SA[i];
				tmp[s2] = RA[s1] == RA[s2] && RA[s1 + k] == RA[s2 + k] ? r : ++r;
				s1 = s2;
			}
			for(int i = 0; i < n; ++i)
				RA[i] = tmp[i];
			
			if(RA[SA[n-1]] == n - 1)
				break;
		}
	}
	
	void sort(int[] SA, int[] RA, int n, int k)
	{
		int maxi = Math.max(256, n), c[] = new int[maxi];  
		for(int i = 0; i < n; ++i)
			c[i + k < n ? RA[i + k] : 0]++;
		for(int i = 0, sum = 0; i < maxi; ++i)
		{
			int t = c[i];
			c[i] = sum;
			sum += t;
		}
		int[] tmp = new int[n];
		for(int i = 0; i < n; ++i)
		{
			int j = SA[i] + k;
			tmp[c[j < n ? RA[j] : 0]++] = SA[i];
		}
		
		for(int i = 0; i < n; ++i)
			SA[i] = tmp[i];
	}
}
