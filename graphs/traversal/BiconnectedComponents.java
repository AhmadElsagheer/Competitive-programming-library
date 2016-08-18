package graphs.traversal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * Biconnected Components
 */
public class BiconnectedComponents {

	static ArrayList<Integer>[] adjList, inBiComp;
	static int[] dfs_low, dfs_num;
	static int V, counter, biCompIdx;
	static Stack<Integer> stack;
	static ArrayList<ArrayList<Integer>> biconnectedComponents;

	static void biConnectedComponents()	//O(V + E)
	{
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				dfs(i, -1);
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
					dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
					if(dfs_low[v] >= dfs_num[u])
					{
						ArrayList<Integer> component = new ArrayList<Integer>();
						while(true)
						{
							int w = stack.pop();
							component.add(w);
							inBiComp[w].add(biCompIdx);
							if(w == v)
								break;
						}
						component.add(u);
						inBiComp[u].add(biCompIdx);
						biconnectedComponents.add(component);
						++biCompIdx;
					}
				}
				else
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}	
	
	static void go()
	{
		dfs_low = new int[V]; 
		dfs_num = new int[V];
		stack = new Stack<Integer>();
		biconnectedComponents = new ArrayList<ArrayList<Integer>>();
		inBiComp = new ArrayList[V];
		for(int i = 0; i < V; ++i)
			inBiComp[i] = new ArrayList<Integer>();
		
		biConnectedComponents();

		for(ArrayList<Integer> x : biconnectedComponents)
			System.out.println(x);
	}
	
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		adjList = new ArrayList[V];
		for(int i = 0; i < V; ++i)
			adjList[i] = new ArrayList<Integer>();
		int m = sc.nextInt();
		while(m-->0)
		{
			int u = sc.nextInt(), v = sc.nextInt();
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		go();
	}
}
