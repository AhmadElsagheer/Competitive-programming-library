package strings;

public class PrefixAutomaton {

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

	//prefix Automaton
	static final int k = 26;					//alphabet size;

	static int[][] prefixAutomaton(char[] s)	//ends with a delimiter
	{
		int n = s.length;
		int[] pi = prefixFunction(s);
		int[][] aut = new int[k][n];		// aut[c][piOld] = piNew

		for(int c = 0; c < k; ++c)
			for(int i = 0; i < n; ++i)
				if(i > 0 && c != s[i] - 'a')
					aut[c][i] = aut[c][pi[i - 1]];
				else
					aut[c][i] = i + (c == s[i] - 'a' ? 1 : 0);
		return aut;
	}

}
