package graphs.mst;

import java.util.Arrays;

public class MST_Kruskal {

	static Edge[] edgeList;
	static int V;

	static int kruskal()		//O(E log E)
	{
		int mst = 0;
		Arrays.sort(edgeList);
		UnionFind uf = new UnionFind(V);

		for(Edge e: edgeList)
			if(uf.union(e.u, e.v))
				mst += e.w;
		return mst;
	}

	static class Edge implements Comparable<Edge>
	{
		int u, v, w;

		Edge(int a, int b, int c) {	u = a; v = b; w = c; }

		public int compareTo(Edge e) { return w - e.w; }
	}

	static class UnionFind {                                              
		int[] p, rank;

		UnionFind(int N) 
		{
			p = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) 
				p[i] = i;
		}

		int findSet(int x) { return p[x] == x ? x : (p[x] = findSet(p[x])); }

		boolean union(int x, int y) 
		{ 
			x = findSet(x);
			y = findSet(y);
			if(x == y)
				return false;

			if (rank[x] > rank[y]) 
				p[y] = x;
			else
			{	
				p[x] = y;
				if(rank[x] == rank[y])
					++rank[y]; 
			} 
			return true;
		}
	}
}
