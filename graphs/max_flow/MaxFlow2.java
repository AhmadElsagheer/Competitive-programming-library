package graphs.max_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//Try to test the implementation with some input of your choice
public class MaxFlow2 {

	static final int INF = (int)1e9;
	static int V, s, t, res[][];			//input
	static ArrayList<Integer>[] adjList;	//input
	static int[] ptr, dist;
	
	static int dinic()						//O(V^2E)
	{
		int mf = 0;
		while(bfs())
		{
			ptr = new int[V];
			int f;
			while((f = dfs(s, INF)) != 0)
				mf += f;
		}
		return mf;
	}
	
	
	static boolean bfs()
	{
		dist = new int[V];
		Arrays.fill(dist, -1);
		dist[s] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty())
		{
			int u = q.remove();
			if(u == t)
				return true;
			for(int v: adjList[u])
				if(dist[v] == -1 && res[u][v] > 0)
				{
					dist[v] = dist[u] + 1;
					q.add(v);
				}
		}
		return false;
	}
	
	static int dfs(int u, int flow)
	{
		if(u == t)
			return flow;
		for(int i = ptr[u]; i < adjList[u].size(); i = ++ptr[u])
		{
			int v = adjList[u].get(i);
			if(dist[v] == dist[u] + 1 && res[u][v] > 0)
			{
				int f = dfs(v, Math.min(flow, res[u][v]));
				if(f > 0)
				{
					res[u][v] -= f;
					res[v][u] += f;
					return f;
				}
			}
		}
		return 0;
		
	}
}
