package graphs.traversal;

import java.util.ArrayList;

/*
 * Articulation Points and Bridges in Undirected Graphs - Tarjan's Algorithm (DFS Variant)
 */
public class ArticulationPointsAndBridges {

	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int V, counter, root, rootChildren;
	static boolean[] artPoints;

	static void findArtPointsAndBridges()	//O(V + E)
	{
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
			{
				root = i;
				rootChildren = 0;
				dfs(i);
				if(rootChildren <= 1)		//special case
					artPoints[i] = false;
			}
	}
	
	static void dfs(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		for(int v: adjList[u])
			if(dfs_num[v] == 0)
			{
				parent[v] = u;
				if(u == root)
					++rootChildren;
				dfs(v);
				if(dfs_low[v] >= dfs_num[u])
					artPoints[u] = true;
				if(dfs_low[v] > dfs_num[u])
					System.out.printf("Bridge between %d %d%n", u, v);
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			}
			else
				if(parent[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}

	
}
