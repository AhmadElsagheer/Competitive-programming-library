package data_structures;

import java.util.Random;

//0- based indexable skip list.
public class IndexableSkipList <E extends Comparable<E>> {	

	class Node 
	{
		E value;
		int level;
		int length;
		Node next;
		Node down;

		public Node(E val, int lvl, int ps, Node nxt, Node dwn) 
		{
			value = val;
			level = lvl;
			length = ps;
			next = nxt;
			down = dwn;
		}
	}

	final static double p = 0.5;
	
	Node head;
	Random rand;
	int size;

	public IndexableSkipList() 
	{
		head = new Node(null, 0, -1, null, null);
		rand = new Random();
		size = 0;
	}

	public int randomizeLevel() 
	{
		int level = 0;
		while (level <= head.level && rand.nextDouble() < p)
			++level;
		return level;
	}
	
	public E remove(int index)
	{
		if (index < 0 || index >= size)
			return null;
		E removed = null;
		int cur_pos = -1;
		Node cur = head;	
		while (cur != null)
		{
			if (cur.next != null && cur_pos + cur.length < index) 
			{
				cur_pos += cur.length;
				cur = cur.next;
			}
			else
			{
				cur.length--;
				if(cur_pos + cur.length + 1 == index && cur.next != null)
				{
					removed = cur.next.value;
					cur.length += (cur.next.length == -1 ? 0 : cur.next.length);
					cur.next = cur.next.next;	
				}
				cur = cur.down;
			}
		}
		--size;
		if(size == 0){			
			head = new Node(null, 0, -1, null, null);
		}
		return removed;
	}

	public boolean add(E val, int index) 
	{
		if (index < 0 || index > size)
			return false;
		
		int level = randomizeLevel();
		if (level > head.level)
			head = new Node(null, level, index, null, head);
		
		int cur_pos = -1;
		Node cur = head, last = null;
		while(cur != null)
		{
			if (cur.next != null && cur_pos + cur.length < index) 
			{
				cur_pos += cur.length;
				cur = cur.next;
			} 
			else 
			{
				cur.length++;
				if (cur.level <= level) 
				{
					Node toAdd = new Node(val, cur.level, 0, cur.next, null);
					
					toAdd.length = cur.length - (index - cur_pos);
					cur.length = index - cur_pos;
					
					if(last != null)
						last.down = toAdd;
					cur.next = toAdd;
					last = toAdd;
				}
				cur = cur.down;
			}
		}
		++size;
		return true;
	}

	// for sorted DS
	public boolean add(E val) 
	{
		int index = getIndex(val);
		if (index < 0 || index > size)
			return false;
		
		int level = randomizeLevel();
		if (level > head.level)
			head = new Node(null, level, index, null, head);
		
		int cur_pos = -1;
		Node cur = head, last = null;
		while(cur != null)
		{
			if (cur.next != null && cur_pos + cur.length < index) 
			{
				cur_pos += cur.length;
				cur = cur.next;
			} 
			else 
			{
				cur.length++;
				if (cur.level <= level) 
				{
					Node toAdd = new Node(val, cur.level, 0, cur.next, null);
					
					toAdd.length = cur.length - (index - cur_pos);
					cur.length = index - cur_pos;
					
					if(last != null)
						last.down = toAdd;
					cur.next = toAdd;
					last = toAdd;
				}
				cur = cur.down;
			}
		}
		++size;
		return true;
	}

	public int getIndex(E val)
	{
		Node cur = head;int cur_pos = -1;
	    while(cur != null) 
	    {
	      Node next = cur.next;
	      if (next == null || next.value.compareTo(val) > 0)
	    	  cur = cur.down;
	  
	      else 
	      {
	    	  cur_pos += cur.length;
	    	  cur = cur.next;
	      }
	    }
	    return cur_pos + 1;
	}
	
	public E get(int index) 
	{
		if (index < 0 || index >= size)
			return null;
		Node cur = head;
		int cur_pos = -1;
		while (cur != null) 
		{
			if (cur_pos == index)
				return cur.value;
			if (cur.next == null || cur_pos + cur.length > index) 
				cur = cur.down;
			else 
			{
				cur_pos += cur.length;
				cur = cur.next;
			}
		}
		return null;
	}

	public void print() 
	{
		
		Node first = head;
		while (first != null) 
		{
			Node cur = first;
			System.out.print(first.level + " ");
			while (cur != null) 
			{
				System.out.print("[" + cur.value + " " + cur.length + "] ");
				cur = cur.next;
			}
			System.out.println();
			first = first.down;
		}
	}
}