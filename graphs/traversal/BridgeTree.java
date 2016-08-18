package graphs.traversal;

import java.util.ArrayList;
import java.util.Stack;

public class BridgeTree {

	static ArrayList<Integer>[] adjList, tree;
	static Stack<Integer> stack;
	static int[] dfs_low, dfs_num, bridgeComp;
	static int V, counter;
	
	static void bridgeTree()
	{
		counter = 0;
		dfs_low = new int[V];
		dfs_num = new int[V];
		bridgeComp = new int[V];
		stack = new Stack<Integer>();
		tree = new ArrayList[V];
		for(int i = 0; i < V; ++i)
			tree[i] = new ArrayList<Integer>();
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				dfs(i, -1);
		for(int u = 0; u < V; ++u)
			for(int v: adjList[u])
			{
				int x = bridgeComp[u], y = bridgeComp[v];  
				if(x != y)
					tree[x].add(y);
			}
	}
	
	static void dfs(int u, int p)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		for(int v: adjList[u])
			if(v != p)
				if(dfs_num[v] == 0)
				{
					dfs(v, u);
					dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
					if(dfs_low[v] > dfs_num[u])
						extract(v);
				}
				else
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
		if(p == -1)
			extract(u);
	}
	
	static void extract(int u) 
	{ 
		while(true)
		{
			int v = stack.pop();
			bridgeComp[v] = u;
			if(v == u)
				break;
		}	
	}
}
