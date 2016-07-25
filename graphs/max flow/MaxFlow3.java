package graphs.max_flow;

import java.util.LinkedList;
import java.util.Queue;

//Try to test the implementation with some input of your choice
public class MaxFlow3 {

	static final int INF = (int)1e9;
	static int V, s, t, c[][];			//input

	static int pushRelabel()			//O(V^3)
	{
		int[] h = new int[V], e = new int[V], f[] = new int[V][V];
		h[s] = V - 1;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(t);
		while(!q.isEmpty())
		{
			int u = q.remove();
			for(int v = 0; v < V; ++v)
				if(v != t && v != s && h[v] == 0)
				{
					h[v] = h[u] + 1;
					q.add(v);
				}
		}
		
		boolean[] isActive = new boolean[V];
		for(int i = 0; i < V; ++i)
		{
			f[i][s] = -(f[s][i] = e[i] = c[s][i]);
			if(i != s && i != t && e[i] > 0)
			{
				isActive[i] = true;
				q.add(i);
			}
		}

		while(!q.isEmpty())
		{
			int u = q.peek();
			boolean pushed = false;
			for(int v = 0; v < V && e[u] != 0; ++v)
				if(h[u] == h[v] + 1 &&  c[u][v] - f[u][v] > 0)
				{
					int df = Math.min(e[u], c[u][v] - f[u][v]);
					f[u][v] += df; f[v][u] -= df;
					e[u] -= df; e[v] += df;
					if(v != s && v != t && !isActive[v])
					{
						isActive[v] = true;
						q.add(v);
					}
					pushed = true;
				}

			if(e[u] == 0)
			{
				isActive[u] = false;
				q.remove();
			}

			if(!pushed)
			{
				h[u] = INF;
				for(int v = 0; v < V; ++v)
					if(h[v] + 1 < h[u] && c[u][v] - f[u][v] > 0)
						h[u] = h[v] + 1;
			}
		}

		return e[t];
	}

}
