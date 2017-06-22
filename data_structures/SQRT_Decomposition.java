package data_structures;

public class SQRT_Decomposition {

	// Query Type: find sum of subarray [L, R]
	
	static int[] preprocess(int[] a, int n)
	{
		int s = (int) Math.sqrt(n) + 1;
		int[] b = new int[(n + s - 1)/ s];
		for(int i = 0; i < n; ++i)
			b[i / s] += a[i];
		return b;
	}
	
	static int query(int[] a, int[] b, int s, int l, int r)
	{
		int sum = 0, block_l = l / s, block_r = r / s;
		
		if(block_l == block_r)
			for(int i = l; i <= r; ++i)
				sum += a[i];
		else
		{
			for(int i = l, end = (block_l+1) * s - 1; i <= end; ++i)
				sum += a[i];
			for(int i = block_l + 1; i <= block_r - 1; ++i)
				sum += b[i];
			for(int i = block_r * s; i <= r; ++i)
				sum += a[i];
		}
		
		return sum;
	}
	
	
}

