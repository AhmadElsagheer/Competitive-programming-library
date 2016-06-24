package graphs.special;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//	Maximum Cardinality Bipartite Matching
//		1.Augmenting Path Algorithm
//		2.Hopcroft Karp's Algorithm
//		3.Max Flow based Solution
public class MCBM {

//	1.Augmenting Path Algorithm O(VE)
	static int V, n, m, match[];	//n(left) + m(right) = V
	static ArrayList<Integer>[] adjList;	//size = n, idx = [0, n-1], val = [0, m-1]
	static boolean[] vis;
	static int go()
	{
		//build unweighted bipartite graph with directed edges left->right set
		int matches = 0;
		match = new int[m];
		Arrays.fill(match, -1);
		for(int i = 0; i < n; ++i)
		{
			vis = new boolean[n];
			matches += aug(i);
		}
		return matches;
	}
	
	static int aug(int u)	//returns 1 if an augment path is found
	{
		vis[u] = true;
		for(int v : adjList[u])
			if(match[v] == -1 || !vis[match[v]] && aug(match[v]) == 1)
			{
				match[v] = u;
				return 1;
			}
		return 0;
	}
	
//	2.Hopcroft Karp's Algorithm O(sqrt(V)E)
//	NOTE: vertices of left/right set start from 1 (u, v > 0)
	static int[] pair_U, pair_V, dist;
	static final int NIL = 0, INF = (int)1e9;
	static int hopcroftKarp()
	{
		pair_U = new int[n + 1];	//filled with NIL
		pair_V = new int[m + 1];	//filled with NIL
		dist = new int[n + 1];
		
		int matching = 0;
		while(bfs())
			for(int u = 1; u <= n; ++u)
				if(pair_U[u] == NIL && dfs(u))
					++matching;
		return matching;
	}	
	static boolean bfs()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		for(int u = 1; u <= n; ++u)
			if(pair_U[u] == NIL)
			{
				dist[u] = 0;
				q.add(u);
			}
			else
				dist[u] = INF;
		dist[NIL] = INF;
		while(!q.isEmpty())
		{
			int u = q.remove();
			if(dist[u] < dist[NIL])
				for(int v : adjList[u])
					if(dist[pair_V[v]] == INF)
					{
						dist[pair_V[v]] = dist[u] + 1;
						q.add(pair_V[v]);
					}
		}
		return dist[NIL] != INF;
	}
	
	static boolean dfs(int u)
	{
		if(u == NIL)
			return true;
		
		for(int v : adjList[u])
			if(dist[pair_V[v]] == dist[u] + 1 && dfs(pair_V[v]))
			{
				pair_U[u] = v;
				pair_V[v] = u;
				return true;
			}
		dist[u] = INF;
		return false;
		
					
	}
	
	
	
//	3.Max Flow based Solution
	/*
	 * ->	add two virtual vertices s and t
	 * ->	make the graph directed from left to right
	 * ->	make the capacity of all edges = 1
	 * ->	max flow = MCBM
	 */
}
