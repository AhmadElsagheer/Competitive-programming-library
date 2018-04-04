### Articulation Points and Bridges

(Supplement Material for CP3 section 4.2.8)

To understand why the algorithm for articulation points and bridges work, you must get 3 concepts clearly.

##### DFS Spanning Tree

Any graph can be converted to a DFS spanning tree which is a tree with two types of directed edges:

1. Tree edges: edges from _u_ to one of its children _v_. _u_ is visited before _v_ and _u_ is the direct parent of _v_.
2. Back edges: edges from _u_ to one of its ancestors _v_. _v_ is visited before _u_.

A graph may have many different DFS spanning trees. To construct any of them, pick an arbitrary node and visit
all the nodes one by one:

- When the edge leads from EXPLORED node to UNVISITED node, then this edge is a tree edge.
- When the edge leads from EXPLORED node to EXPLORED node, then this edge is a back edge.

We only take tree edges while building the tree. Back edges are not taken.

##### DFS Num
Every time we visit a node for the first time, we will assign to it a number _dfsNum_ which is the time at which we
visited this node. Values for _dfsNum_ will range from 1 to _N_. We can use value 0 for initialization to represent
unvisited nodes.

Note that for each node, all its descendants have larger values for _dfsNum_ while all its anscestors has smaller values.

##### DFS Low
For each node _u_, we want to know what is node with the lowest time this node can reach either through:

- back edges from _u_.
- any node in the subtree of _u_. If _v_ is in the subtree of _u_, then all nodes reachable from _v_ are also reachable from _u_.

Let's call this lowest time for _u_ as _dfsLow[u]_ and it is initially equal to _dfsNum[u]_. Then it can be minimized using two ways:

- For a back edge from _u_ to _v_, then it is minimized using _dfsNum[v]_. 
- For a tree edge from _u_ to _v_, then it is minimized using _dfsLow[v]_. 

### How to find articulation points ?
For node _u_, if there exists a child _v_ such that _dfsNum[u] <= dfsLow[v]_, then _v_ cannot visit nodes with time less than
_dfsNum[u]_ if _u_ is removed from the graph. In this case, _u_ is an articulation point.

Note that there is a special case when _u_ is the root of the tree.

### How to find bridges ?
For node _u_, if there exists a child _v_ such that _dfsNum[u] < dfsLow[v]_, then _v_ cannot visit _u_ if the edge from
_u_ -> _v_ is removed from the graph. In this case, edge _u_ -> _v_ is a bridge.

