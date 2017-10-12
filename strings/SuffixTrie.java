package strings;

public class SuffixTrie {

	static final int R = 26;				//Alphabet (lowercase etters in below implementation)
	
	static class Node { Node[] next = new Node[R]; int val = -1; }
	
	Node root = new Node();
	
	void put(char[] s, int idx)		// O(n) where n = |s|. Can be implemented recursively
	{
		Node cur = root;
		for(char c: s)
		{
			Node nxt = cur.next[c-'a'];
			if(nxt == null)
				nxt = cur.next[c - 'a'] = new Node();
			cur = nxt;
		}
		cur.val = idx;
	}
	
	int search(char[] s)
	{
		Node cur = root;
		for(char c: s)
		{
			Node nxt = cur.next[c-'a'];
			if(nxt == null)
				return -1;
			cur = nxt;
		}
		return cur.val;
	}
}
