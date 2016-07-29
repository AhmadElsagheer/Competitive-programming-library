package math.game_theory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Algorithm for finding winning, losing and draw positions in games
 * that can represented by a directed graph (possibly with cycles)
 */
public class GamesOnGeneralGraphs {

	static boolean[] win, lose, vis;
	static int[] deg;							//out degree for all nodes in original graph
	static ArrayList<Integer>[] adjList;		//reverse of original graph
	static int V;

	static void go()	// O(V + E)
	{
		vis = new boolean[V];
		win = new boolean[V];
		lose = new boolean[V];
		Queue<Integer> q = new LinkedList<Integer>();
		/*
		 * Initially insert in the queue all nodes known to be winning or losing
		 * and mark them in vis and either in win or lose.
		 */
		while(!q.isEmpty())
		{
			int v = q.remove();
			for(int u: adjList[v])
				if(!vis[u])
				{
					if(lose[v])
						win[u] = true;
					else if(--deg[u] == 0)
						lose[u] = true;
					else
						continue;
					vis[u] = true;
					q.add(u);
				}
		}

		// !win[u] & !lose[u] -> draw[u]
	}
}
