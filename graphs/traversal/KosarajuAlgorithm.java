package graphs.traversal;

import java.util.ArrayList;
import java.util.Stack;

// Strongly Connected Components of a directed graph

public class KosarajuAlgorithm {
	
	static int N;
	static ArrayList<Integer>[] adjList, adjListTranspose;
	static Stack<Integer> stack;
	static boolean[] visited;
	static int SCC;
	
	
	public static int SCC()
	{
		stack = new Stack<Integer>();
		visited = new boolean[N];
		for(int i = 0; i < N; ++i)
			if(!visited[i])
				dfs(i, adjList, true);
		
		reverse();
		
		visited = new boolean[N];
		SCC = 0;
		while(!stack.isEmpty())
		{
			
			int u = stack.pop();
			if(!visited[u])
			{
				SCC++;
				dfs(u,adjListTranspose,false);
			}
			//if visited then this vertex belongs to the last discovered SCC
			
		}
		
		return SCC;
	}
	
	public static void dfs(int u,ArrayList<Integer>[] graph ,boolean fillingStack)
	{
		
		visited[u] = true;
		for(int i = 0; i < graph[u].size(); i++)
		{
			int v = graph[u].get(i);
			if(!visited[v])
				dfs(v, graph, fillingStack);
		}
		if(fillingStack)
			stack.push(u);
	}
	
	
	
	
	public static void reverse()
	{
		adjListTranspose = new ArrayList[N];
		for(int i = 0; i < N; i++)
			adjListTranspose[i] = new ArrayList<Integer>();
		for(int i = 0; i < N; i++)
			for(int j = 0; j <adjList[i].size(); j++)
				adjListTranspose[adjList[i].get(j)].add(i);
		
	}
	
	
	
}
