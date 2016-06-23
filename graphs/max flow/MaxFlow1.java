package graphs.max_flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Max Flow: Edmonds Karp's Algorithm
 */
public class MaxFlow1 {

	static final int INF = (int)1e9;
	static int V, s, t;			//s != t
	static ArrayList<Integer>[] adjList;
	static int[][] res;			//instead of res, you can use c[][], f[][] so as not to destroy the graph
	static int[] p;				//res (residual) = c (capacity) - f (flow)
	
	static int edmondsKarp()	//O(min(VE^2, flow * E)) for adjList, O(V^3E)
	{
		int mf = 0;
		while(true)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			p = new int[V];
			Arrays.fill(p, -1);
			q.add(s);
			p[s] = s;
			while(!q.isEmpty())
			{
				int u = q.remove();
				if(u == t)
					break;
				for(int v: adjList[u])
					if(res[u][v] > 0 && p[v] == -1)
					{
						p[v] = u;
						q.add(v);
					}
			}
			
			if(p[t] == -1)
				break;
			mf += augment(t, INF);	
		}
		return mf;
	}
	
	static int augment(int v, int flow)
	{
		if(v == s)
			return flow;
		flow =  augment(p[v], Math.min(flow, res[p[v]][v]));
		res[p[v]][v] -= flow;
		res[v][p[v]] += flow;
		
		return flow;
	}
}






