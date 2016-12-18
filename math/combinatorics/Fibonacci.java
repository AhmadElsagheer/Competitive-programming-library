package math.combinatorics;

public class Fibonacci {

	static int fib[];
	
	static int fibonacci(int n) 		//O(log n)
	{
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;
		if (fib[n] != -1)
			return fib[n];
		
		int k = n >> 1;
		int a = fibonacci(k), b = fibonacci(k+1);
		
		if (n%2 == 0)
			return fib[n] = a * (2 * b - a);
		return  fib[n] = b * b + a * a;
	}	
}
