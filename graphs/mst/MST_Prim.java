package graphs.mst;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_Prim {

	static ArrayList<Edge>[] adjList;
	static int V;
	
	static int prim()		//O(E log E)
	{
		int mst = 0;
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(visited[cur.node])
				continue;
			visited[cur.node] = true;
			mst += cur.cost;
			for(Edge nxt: adjList[cur.node])
				if(!visited[nxt.node])
					pq.add(nxt);
		}	
		return mst;
	}
	
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		
		Edge(int a, int b) { node = a; cost = b; }
		
		public int compareTo(Edge e) { return cost - e.cost; }
		
	}
	
}

