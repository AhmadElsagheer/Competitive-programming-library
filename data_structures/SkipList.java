package data_structures;

import java.util.*;

public class SkipList  <T extends Comparable<T>>
{
	
  class Node 
  { 
	Node next, down;
    int level;
    T value;

    public Node(T v, int l, Node n, Node d) 
    {
      value = v;
      level = l;
      next = n;
      down = d;
    }
  }
  
  Node head;
  Random rand;

  final static double p = 0.5;

  public SkipList() 
  {
    head = new Node(null, 0, null, null);
    rand = new Random();
  }

  public int getRandomLevel() 
  {
    int level = 0;
    while(level <= head.level && rand.nextDouble() < 0.5) 
      level++;
    return level;
  }

  public boolean add(T v) 
  {
    if (search(v))
      return false;
    
    int lev = getRandomLevel();
    if (lev > head.level)
    	head = new Node(null, lev, null, head);
    
    Node cur = head, bottom = null;
    while(cur != null) 
    {
      Node next = cur.next;
      if (next == null || next.value.compareTo(v) > 0) 
      {
        if (cur.level <= lev) 
        {
          Node nn = new Node(v, cur.level, next, null);
          cur.next = nn;
          if (bottom != null)
            bottom.down = nn;
          bottom = nn;
        }
        cur = cur.down;
      } 
      else
        cur = cur.next;
      
    }
    return true;
  }

  public boolean search(T key) 
  {
    Node cur = head;
    while(cur != null) 
    {
      if (cur.value != null && cur.value.compareTo(key) == 0)
        return true;
      
      Node next = cur.next;
      if (next == null || next.value.compareTo(key) > 0)
        cur = cur.down;
      else 
        cur = cur.next;
    }
    return false;
  }

  public void print() 
  {
	  Node h = head;
	  while(h != null) 
	  {
	     Node c = h;
	     while(c != null) {System.out.print(c.value + ", ");c = c.next;}
	     System.out.println();
	     h = h.down;
	  }
  }
  
}

