package math;

import java.math.BigInteger;

public class NewtonMethod {

	/*
	 * Newton's Method: Xn+1 = Xn - f(Xn) / f'(Xn)
	 * Purpose: Find roots of a real-valued function, i.e. solve f(x) = 0
	 */
		
	static final double EPS = 1e-15;
	
	/*
	 * 1. Find square root of n
	 */
	static double sqrt(double n)
	{
		double x = 1;
		while(true)
		{
			double nx = (x + n / x) / 2;
			if(Math.abs(nx - x) < EPS)
				break;
			x = nx;
		}
		return x;
	}
	
	/*
	 * 2. Find largest integer x where x^2 <= n
	 */
	static int nearestInteger(int n)
	{
		int x = 1;
		boolean dec = false;
		while(true)
		{
			int nx = x + n / x >> 1;
			if(x == nx || nx > x && dec)
				break;
			dec = nx < x;
			x = nx;
		}
		return x;
	}
	
	/*
	 * 3. Find largest integer x where x^2 <= n, better initial approximation for long arithmetic
	 */
	static BigInteger nearestInteger(BigInteger n)
	{
		BigInteger x = BigInteger.ONE.shiftLeft(n.bitLength() >> 1);
		boolean dec = false;
		while(true)
		{
			BigInteger nx = x.add(n.divide(x)).shiftRight(1);
			int cmp = nx.compareTo(x);
			if(cmp == 0 || cmp > 0 && dec)
				break;
			dec = cmp < 0;
			x = nx;
		}
		return x;
	}
}
