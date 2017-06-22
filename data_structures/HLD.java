package data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HLD {

	//1.Take input and processing(precomputation + query)
	static int N, nodeVal[];				//input
	static ArrayList<Integer>[] adjList;	//input
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		nodeVal = new int[N];
		for(int i = 0; i < N; ++i)
			nodeVal[i] = sc.nextInt();
		adjList = new ArrayList[N];
		for(int i = 0; i < N; ++i)
			adjList[i] = new ArrayList<Integer>();
		while(E-->0)
		{
			int u = sc.nextInt(), v = sc.nextInt();
			adjList[u].add(v);
			adjList[v].add(u);
		}
		go(0);
		int q = sc.nextInt();
		while(q-->0)
		{
			int comm = sc.nextInt();
			if(comm == 1)
			{
				int node = sc.nextInt(), val = sc.nextInt();
				update(node, val);
			}
			else		//comm == 2
			{
				int a = sc.nextInt(), b = sc.nextInt();
				System.out.println(query(a, b));
			}
						
		}
		
		sc.close();
	}
	
	//3.Query
	static void update(int node, int val)
	{
		st.update_point(segIdx[node], val);
		nodeVal[node] = val;
	}
	
	static int query(int u, int v)
	{
		int lca = lca_query(u, v);
		return query_up(u, lca) + query_up(v, lca) - nodeVal[lca];
	}
	
	static int query_up(int v, int u)
	{
		int uChain = chainIdx[u], vChain = chainIdx[v], ans = 0;
		
		while(uChain != vChain)
		{
			ans += st.query(segIdx[chainHead[vChain]], segIdx[v]);
			v = P[chainHead[vChain]][0];
			vChain = chainIdx[v];
		}
		ans += st.query(segIdx[u], segIdx[v]);
		return ans;
	}
	
	//1.Precomputation
	static SegmentTree st;
	static void go(int root)	
	{
		//prepare for LCA (part 1)
		int k = (int)(Math.floor(Math.log(N)/Math.log(2))) + 1;
		P = new int[N][k];
		for(int i = 0; i < N; i++)
			Arrays.fill(P[i], -1);
		
		//BuildTree: assign depth, parent, subtree size
		subSize = new int[N];
		level = new int[N];
		P[root][0] = -1;
		dfs(root, -1, 0);	
		
		//prepare for LCA (part 2)
		for(int j = 1; j < k; j++)			
			for(int i = 1; i < N; i++)
				if(P[i][j-1] != -1)
					P[i][j] = P[P[i][j-1]][j-1];
		
		//HL decompose
		chainNo = 0; sIdx = 0;
		chainHead = new int[N];
		chainPos = new int[N];
		chainIdx = new int[N];
		chainSize = new int[N];
		segIdx = new int[N];
		Arrays.fill(chainHead, -1);
		hld(root);
		
		//create segment tree
		int n = (int) Math.pow(2, Math.ceil(Math.log(N)/Math.log(2)));
		int[] in = new int[n+1];
		for(int i = 0; i < N; i++)
			in[segIdx[i]] = nodeVal[i];
		
		st = new SegmentTree(in);
	}
	
	static int[][] P;
	static int[] subSize, level;
	static void dfs(int u, int parent, int depth)
	{
		level[u] = depth;
		subSize[u] = 1;
		for(int v : adjList[u])
			if(v != parent)
			{
				P[v][0] = u;
				dfs(v, u, depth + 1);
				subSize[u] += subSize[v];
			}
	}
		
	static int chainNo, sIdx;
	static int[] chainHead, chainPos, chainIdx, chainSize, segIdx;
	static void hld(int cur)
	{
		if(chainHead[chainNo] == -1)
			chainHead[chainNo] = cur;
		chainIdx[cur] = chainNo;
		chainPos[cur] = chainSize[chainNo]++;
		segIdx[cur] = ++sIdx;
		
		int nxt = -1, maxSize = -1;
		for(int v : adjList[cur])
			if(P[cur][0] != v && subSize[v] > maxSize)
			{
				maxSize = subSize[v];
				nxt = v;
			}
		if(nxt != -1)
			hld(nxt);
		for(int v : adjList[cur])
			if(P[cur][0] != v && v != nxt)
			{
				chainNo++;
				hld(v);
			}
	}
	
	 static int lca_query(int p, int q)
	 {
		 int tmp, log, i;
		 
		 //if p is situated on a higher level than q then we swap them
		 if (level[p] < level[q])
		 {
			 tmp = p; p = q; q = tmp;
		 }
		 
		 //we compute the value of [log(level[p)]
		 for (log = 1; 1 << log <= level[p]; log++);
		 log--;
		 
		 //we find the ancestor of node p situated on the same level
		 //with q using the values in P
		 for (i = log; i >= 0; i--)
			 if (level[p] - (1 << i) >= level[q])
				 p = P[p][i];
		 
		 if (p == q)
			 return p;
		 
		 //we compute LCA(p, q) using the values in P
		 for (i = log; i >= 0; i--)
			 if (P[p][i] != -1 && P[p][i] != P[q][i])
			 {
				 p = P[p][i]; q = P[q][i];
			 }
		 
		 return P[p][0];
	 }
	
	static class SegmentTree {
		
		int N;
		int[] array, sTree;
		
		SegmentTree(int[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new int[N<<1];
			build(1,1,N);
		}
		
		void build(int node, int b, int e)
		{
			if(b == e)					
				sTree[node] = array[b];
			else						
			{
				build(node<<1,b,(b+e)/2);
				build((node<<1)+1,(b+e)/2+1,e);
				sTree[node] = sTree[node<<1]+sTree[(node<<1)+1];
			}
		}
		
		
		void update_point(int index, int val)
		{
			index += N - 1;				
			sTree[index] = val;			
			while(index>1)				
			{
				index >>= 1;
				sTree[index] = sTree[index<<1] + sTree[(index<<1) + 1];		
			}
		}
		
		
		int query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		int query(int node, int b, int e, int i, int j)
		{
			if(i>e || j <b)
				return 0;		
			if(b>= i && e <= j)
				return sTree[node];
			return query(node<<1,b,(b+e)/2,i,j) + query((node<<1)+1,(b+e)/2+1,e,i,j);	
					
		}
		
	}

}
