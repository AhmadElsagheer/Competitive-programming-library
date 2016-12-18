package data_structures.trees;

import java.util.Scanner;

// Range Sum Query (with lazy propagation)

public class SegmentTree {		// 1-based DS, OOP
	
	int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	int[] array, sTree, lazy;
	
	SegmentTree(int[] in)		
	{
		array = in; N = in.length - 1;
		sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
		lazy = new int[N<<1];
		build(1,1,N);
	}
	
	void build(int node, int b, int e)	// O(n)
	{
		if(b == e)					
			sTree[node] = array[b];
		else						
		{
			int mid = b + e >> 1;
			build(node<<1,b,mid);
			build(node<<1|1,mid+1,e);
			sTree[node] = sTree[node<<1]+sTree[node<<1|1];
		}
	}
	
	
	void update_point(int index, int val)			// O(log n)
	{
		index += N - 1;				
		sTree[index] += val;			
		while(index>1)				
		{
			index >>= 1;
			sTree[index] = sTree[index<<1] + sTree[index<<1|1];		
		}
	}
	
	
	void update_range(int i, int j, int val)		// O(log n) 
	{
		update_range(1,1,N,i,j,val);
	}
	
	void update_range(int node, int b, int e, int i, int j, int val)
	{
		if(i > e || j < b)		
			return;
		if(b >= i && e <= j)		
		{
			sTree[node] += (e-b+1)*val;			
			lazy[node] += val;				
		}							
		else		
		{
			int mid = b + e >> 1;
			propagate(node, b, mid, e);
			update_range(node<<1,b,mid,i,j,val);
			update_range(node<<1|1,mid+1,e,i,j,val);
			sTree[node] = sTree[node<<1] + sTree[node<<1|1];		
		}
		
	}
	void propagate(int node, int b, int mid, int e)		
	{
		lazy[node<<1] += lazy[node];
		lazy[node<<1|1] += lazy[node];
		sTree[node<<1] += (mid-b+1)*lazy[node];		
		sTree[node<<1|1] += (e-mid)*lazy[node];		
		lazy[node] = 0;
	}
	
	int query(int i, int j)
	{
		return query(1,1,N,i,j);
	}
	
	int query(int node, int b, int e, int i, int j)	// O(log n)
	{
		if(i>e || j <b)
			return 0;		
		if(b>= i && e <= j)
			return sTree[node];
		int mid = b + e >> 1;
		propagate(node, b, mid, e);
		int q1 = query(node<<1,b,mid,i,j);
		int q2 = query(node<<1|1,mid+1,e,i,j);
		return q1 + q2;	
				
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int N = 1; while(N < n) N <<= 1; //padding
		
		int[] in = new int[N + 1];
		for(int i = 1; i <= n; i++)
			in[i] = sc.nextInt();
		
		sc.close();
	}
	
}
