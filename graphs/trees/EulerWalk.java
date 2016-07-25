package graphs.trees;

import java.util.*;

class EulerWalk {		// Euler walk on a rooted tree

	static ArrayList<Integer>[] children;
	static int[] E, L, tin, tout;
	static int N, t;

	static void dfs(int u, int depth) 
	{
		tin[u] = t;
		E[t] = u;
		L[t++] = depth;
		for(int v: children[u])
		{
			dfs(v, depth + 1);
			E[t] = u;                
			L[t++] = depth;
		}
		tout[u] = t - 1;
	}

	static void eulerWalk(int root) 
	{
		t = 0;
		E = new int[N<<1]; 				// E[i] = node visited at t = i
		L = new int[N<<1]; 				// L[i] = level of E[i]
		tin = new int[N];				// tin[u] = earliest time node i is visited
		tout = new int[N];				// tout[u] = last time node i is visited
		Arrays.fill(tin, -1);
		Arrays.fill(tout, -1);
		dfs(root, 0);
	}
}
