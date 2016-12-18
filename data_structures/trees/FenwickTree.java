package data_structures.trees;

public class FenwickTree { // one-based DS

	int n;
	int[] ft;
	
	FenwickTree(int size) { n = size; ft = new int[n+1]; }
	
	int rsq(int b) //O(log n)
	{
		int sum = 0;
		while(b > 0) { sum += ft[b]; b -= b & -b;}		//min?
		return sum;
	}
	
	int rsq(int a, int b) { return rsq(b) - rsq(a-1); }	
	
	void point_update(int k, int val)	//O(log n), update = increment
	{
		while(k <= n) { ft[k] += val; k += k & -k; }		//min?
	}

	int point_query(int idx)	// c * O(log n), c < 1
	{
		int sum = ft[idx];
		if(idx > 0)
		{
			int z = idx ^ (idx & -idx);
			--idx;
			while(idx != z)
			{
				sum -= ft[idx];
				idx ^= idx & -idx;
			}
		}
		return sum;
	}
	
	void scale(int c) {	for(int i = 1; i <= n; ++i)	ft[i] *= c;	}
	
	int findIndex(int cumFreq)
	{
		int msk = n;
		while((msk & (msk - 1)) != 0)
				msk ^= msk & -msk;			//msk will contain the MSB of n
		
		int idx = 0;
		while(msk != 0)
		{
			int tIdx = idx + msk;
			if(tIdx <= n && cumFreq >= ft[tIdx])
			{
				idx = tIdx;
				cumFreq -= ft[tIdx];
			}
			msk >>= 1;
		}
		if(cumFreq != 0)
			return -1;
		return idx;
	}
}
