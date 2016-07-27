package graphs.traversal;

import java.util.ArrayList;
import java.util.Stack;

// Kosaraju's Algorithm: Finding Strongly Connected Components of a directed graph

public class KosarajuAlgorithm {
	
	static int N;
	static ArrayList<Integer>[] adjList, adjListR, graph;
	static Stack<Integer> stack;
	static boolean[] visited;
	static int SCC;
	
	
	public static int SCC()
	{
		stack = new Stack<Integer>();
		visited = new boolean[N];
		graph = adjList;
		for(int i = 0; i < N; ++i)
			if(!visited[i])
				dfs(i, true);
		
		visited = new boolean[N];
		graph = adjListR;
		SCC = 0;
		while(!stack.isEmpty())
		{		
			int u = stack.pop();
			if(!visited[u])
			{
				SCC++;
				dfs(u, false);
			}
			//if visited then this vertex belongs to the SCC of the vertex which visited it		
		}
		
		return SCC;
	}
	
	public static void dfs(int u, boolean fillingStack)
	{
		visited[u] = true;
		for(int v: graph[u])
			if(!visited[v])
				dfs(v, fillingStack);
		if(fillingStack)
			stack.push(u);
	}
}
