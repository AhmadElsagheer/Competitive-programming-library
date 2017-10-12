package graphs.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

	static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited, adjMat[];
	static int V;
	
	public void preTraversal() 
	{
		for(int i = 0; i < V; ++i)		//for non-connected graphs, Spanning Forest
			if(!visited[i])
				dfs(i);					//or bfs(i)
	}
	
	/*
	 * 1.Depth-First Search (DFS)
	 */
	static void dfs(int u)				//O(V + E) adjList, O(V^2) adjMat	
	{
		visited[u] = true;

		//for adjacency list
		for(int v: adjList[u])
			if(!visited[v])
				dfs(v);

		//for adjacency matrix
		for(int i = 0; i < V; ++i)
			if(adjMat[u][i] && !visited[i])
				dfs(i);
	}
	
	/*
	 * 2.Breadth-First Search (BFS)
	 */
	static void bfs(int s, int t)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty())
		{
			int u = q.remove();
	
			for(int v: adjList[u])
				if(!visited[v])
				{
					visited[v] = true;
					q.add(v);
				}
		}
	}

	/*
	 * 3.Types of Edges
	 */
	static int[] parent, status;
	static void edgeType(int u)
	{
		status[u] = EXPLORED;
		for(int v: adjList[u])
			if(status[v] == UNVISITED)
			{
				System.out.printf("Edge from %d to %d is %s%n", u, v, "tree edge");
				parent[v] = u;
				dfs(v);
			}
			else
				if(status[v] == VISITED)	//cross edges only occur in directed graph
					System.out.printf("Edge from %d to %d is %s%n", u, v, "forwad/cross edge");
				else
					if(parent[u] == v)
						System.out.printf("Edge from %d to %d is %s%n", u, v, "bidirectional edge");
					else
					{
						System.out.printf("Edge from %d to %d is %s%n", u, v, "back edge");
						System.out.println("Cycle!");
					}
		status[u] = VISITED;
	}

	/*
	 * 4.Bipartite Graph Check
	 */
	static int[] color;
	static boolean bipartitieCheck(int u)
	{
		for(int v: adjList[u])
			if(color[v] == -1)
			{
				color[v] = 1 ^ color[u];
				if(!bipartitieCheck(v))
					return false;
			}
			else
				if(color[v] == color[u])
					return false;
		return true;
	}
	
	/*
	 * 5.Flood Fill in Grids - Maze Problem (Reach (R-1, C-1) from (0, 0) using empty cells '.' only)
	 */
	static char[][] grid;
	static int R, C;
	static int[] dx = new int[]{-1, 1, 0, 0};
	static int[] dy = new int[]{0, 0, -1, 1};

	static boolean valid(int i, int j)
	{
		return i != -1 && j != -1 && i != R && j != C && grid[i][j] == '.';
	}

	static void dfs2(int i, int j)
	{
		grid[i][j] = 'X';						//mark as visited
		for(int k = 0; k < 4; ++k)
		{
			int x = i + dx[k], y = j + dy[k];
			if(valid(x, y) && grid[x][y] != 'X')
				dfs2(x, y);
		}
	}

	/*
	 * 6.Topological Sort
	 */
	static Stack<Integer> stack = new Stack<Integer>();
	static void toposortDFS(int u)	//don't forget preTraversal	
	{
		visited[u] = true;

		for(int v: adjList[u])
			if(!visited[v])			//if v is explored -> failure, not a DAG!
				dfs(v);
		stack.push(u);
	}
	
	static ArrayList<Integer> sortedArray;
	static void toposortBFS()
	{
		int[] p = new int[V];
		sortedArray = new ArrayList<Integer>(V);
		for(int i = 0; i < V; ++i)
			for(int v: adjList[i])
				++p[v];
		Queue<Integer> roots = new LinkedList<Integer>();	//PriorityQueue for smallest lexiographical sorting

		for(int i = 0; i < V; ++i)
			if(p[i] == 0)
				roots.add(i);
		while(!roots.isEmpty())
		{
			int u = roots.remove();
			sortedArray.add(u);
			for(int v: adjList[u])
				if(--p[v] == 0)
					roots.add(v);
		}
		
		//if p contains non-zero values -> failure, not a DAG!
	}
}
