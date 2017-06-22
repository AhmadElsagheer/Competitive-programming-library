package graphs.trees;

//1. Calculate the height of the tree rooted at node u for all nodes 
//2. find the proper root of a given tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeDiameter {

	static ArrayList<Integer>[] adjList;
	static int N, dp_down[][], dp_up[];
	static boolean[] visited;

	//Part 1
	static void dfs1(int u)
	{
		visited[u] = true;
		for(int i = 0; i < adjList[u].size(); ++i)
		{
			int v = adjList[u].get(i);
			if(!visited[v])
			{
				dfs1(v);
				if(dp_down[v][0] + 1> dp_down[u][1])
					dp_down[u][1] = dp_down[v][0] + 1;
				if(dp_down[u][1] > dp_down[u][0])
					swap(u);
			}
		}
	}
	
	static void dfs2(int u, int h)
	{
		visited[u] = true;
		dp_up[u] = h;
		for(int i = 0; i < adjList[u].size(); ++i)
		{
			int v = adjList[u].get(i);
			if(!visited[v])
			{
				int h_nxt;
				if(dp_down[v][0] + 1 == dp_down[u][0])
					h_nxt = dp_down[u][1] + 1;
				else
					h_nxt = dp_down[u][0] + 1;
				dfs2(v, Math.max(h + 1, h_nxt));
			}
		}
	}
	
	static void swap(int u)
	{
		int x = dp_down[u][0], y = dp_down[u][1];
		dp_down[u][0] = y;	dp_down[u][1] = x;
	}
	
	static void go()
	{
		dp_down = new int[N][2];
		dp_up = new int[N];
		visited = new boolean[N];
		dfs1(0);
		visited = new boolean[N];
		dfs2(0, 0);
	}
	
	
	//Part 2
	static int findRoot()
	{
		int[] deg = new int[N];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; ++i)
			if((deg[i] = adjList[i].size()) == 1)
				q.add(i);
		int root = -1;
		while(!q.isEmpty())
		{
			root = q.remove();
			for(int i = 0; i < adjList[root].size(); ++i)
			{
				int v = adjList[root].get(i);
				if(--deg[v] == 1)
					q.add(v);
			}
		}
		return root;
		
	}
}
