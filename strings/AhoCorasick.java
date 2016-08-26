package strings;

import java.util.Arrays;

public class AhoCorasick {

	static final int k = 26;
	
	static class Node
	{
		int p, c, link = -1;
		boolean leaf;
		
		Node(int a, int b) { p = a; c = b; }
		
		int[] next = new int[26], go = new int[26];
		{
			Arrays.fill(next, -1);
			Arrays.fill(go, -1);
		}
	}
	
	Node[] nodes;
	int nodeCount;
	
	AhoCorasick(int maxNodes)
	{
		nodes = new Node[maxNodes];
		nodes[nodeCount++] = new Node(0, -1);
	}
	
	void addString(char[] s)
	{
		int cur = 0;
		for(char ch: s)
		{
			int c = ch - 'a';
			if(nodes[cur].next[c] == -1)
			{
				nodes[nodeCount] = new Node(cur, c);
				nodes[cur].next[c] = nodeCount++;
			}
			cur = nodes[cur].next[c];
		}
		nodes[cur].leaf = true;
	}
	
	int link(int vIdx)
	{
		Node v = nodes[vIdx];
		if(v.link == -1)
			v.link = v.p == 0 ? 0 : go(link(v.p), v.c);
		return v.link;
	}
	
	int go(int vIdx, int c)
	{
		Node v = nodes[vIdx];
		if(v.go[c] == -1)
			v.go[c] = v.next[c] != -1 ? v.next[c] : vIdx == 0 ? 0 : go(link(vIdx), c);
		return v.go[c];
	}
}
