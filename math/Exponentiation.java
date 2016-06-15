
public class Exponentiation {

	/*
	 * 1. Binary Exponentiation
	 */
	static int pow(int a, int e)	// O(log e)
	{
		int res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res *= a;
			a *= a;
			e >>= 1;
		}
		return res;
	}
	
}
