Build and Combine for Segment trees with nodes carrying more than one variable. The example below is on a segment tree that can find maximum and its frequency in a given interval [L, R]

```java
	static class Node
	{
		int max, freq;
		
		Node(int a, int b)
		{
			max = a;
			freq = b;
		}
	}
	
	
	Node[] sTree;
	int[] array;
	
	void build(int node, int b, int e)
	{
		if(b == e)
		{
			sTree[node] = new Node(array[b], 1);
			return;
		}
		int mid = b + e >> 1;
		build(node<<1, b, mid);
		build((node<<1) + 1, mid + 1, e);
		sTree[node] = combine(sTree[node<<1], sTree[(node<<1) + 1]);
	}
	
	
	Node combine(Node a, Node b)
	{
		if(a.max > b.max)
			return new Node(a.max, a.freq);
		else if(a.max < b.max)
			return new Node(b.max, b.freq);
		return new Node(a.max, a.freq + b.freq);
	}
```
