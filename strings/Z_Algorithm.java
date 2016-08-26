package strings;

public class Z_Algorithm {

	static int[] zAlgo(char[] s)
	{
		int n = s.length;
		int[] z = new int[n];
		for(int i = 1, l = 0, r = 0; i < n; ++i)
		{
			if(i <= r)
				z[i] = Math.min(r - i + 1, z[i - l]);
			while(i + z[i] < n && s[z[i]] == s[i + z[i]])
				++z[i];
			if(i + z[i] - 1 > r)
				r = i + z[l = i] - 1;
		}
		return z;
	}
}
