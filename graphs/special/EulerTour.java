package graphs.special;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * Printing Euler Tour in an Eulerian Graph
 */
public class EulerTour {

	static class Edge
	{
		int node;
		boolean used;

		Edge(int x) { node = x; }
	}

	static ArrayList<Edge>[] adjList;
	static LinkedList<Integer> tour;

	static void eulerTour(ListIterator<Integer> itr, int u)
	{
		for(Edge nxt: adjList[u])
			if(!nxt.used)
			{
				nxt.used = true;
				for(Edge rev: adjList[nxt.node])
					if(rev.node == u && !rev.used)
					{
						rev.used = true;
						break;
					}
				itr.add(u);
				eulerTour(itr, nxt.node);
				itr.previous();
			}
	}

	static void addEdge(int u, int v)
	{
		adjList[u].add(new Edge(v));
		adjList[v].add(new Edge(u));
	}

	public static void main(String[] args) 
	{		
		adjList = new ArrayList[7];
		for(int i = 0; i < 7; ++i)
			adjList[i] = new ArrayList<Edge>();
		addEdge(6, 3); addEdge(3, 4); addEdge(4, 5); addEdge(5, 6);
		addEdge(6, 0); addEdge(0, 1); addEdge(1, 2); addEdge(2, 6);
		addEdge(0, 2); addEdge(0, 5); addEdge(2, 3); addEdge(5, 3);

		tour = new LinkedList<Integer>();
		eulerTour(tour.listIterator(), 6);		//the tour will start from vertex 6
		tour.add(6);

		System.out.println(tour);
	}
}