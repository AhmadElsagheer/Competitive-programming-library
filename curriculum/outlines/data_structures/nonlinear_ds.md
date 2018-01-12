# Non-Linear DS
---
## Outline
1. Balanced Binary Search Tree (Java TreeMap/TreeSet)
	 1. Difference between a map and a set.
	 2. Creating TreeMaps and TreeSets.
	 3. Important functions and their complexities:
	 	* `add, remove, contains, get`
	 4. Core idea behind TreeMap/Set (BBST).
	 5. Traversing a TreeMap, TreeSet.
	 6. Creating a comparator for an object to be the key in a TreeMap/Set.
	 
2. Heap (Java PriorityQueue)
	 1. Creating PriorityQueues.
	 2. Important functions and their complexities:
	 	* `add, remove, peek`
	 3. Core idea behing PriorityQueues (Heap).
	 3. Creating a comparator for the objects inserted in PriorityQueue.
	 
3. Hash Table (Java HashMap/HashSet)
	1. Creating HashMaps and HashSets.
	2. Important functions and their complexities (same as TreeMaps/TreeSets).
	3. Traversing HashMap, HashSet.
	4. HashMap/Set vs TreeMap/Set.
	5. Creating Hash functions and avoiding collisions.
	
---
## Material Resources
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
|CP section: 2.3            | Most of the outline points           |
|[HE Heaps and Priority Queues](https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial/)            | 2        |
| [Article: TreeMaps vs HashMaps](https://dzone.com/articles/hashmap-vs-treemap-vs)| 1-vi, 3-iii |
|[HE Hashing basics](https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/tutorial/)            | 3-iv        |
| Book: Effective Java (item 9)| 3-iv: tricks for designing hash functions |
---
## Problem Sets
### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Andy's First Dictionary](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1756)      |  Hash/Treeset   | input parsing , sort output    | [Link](https://ideone.com/haO0a1) |
| [Add All](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1895)      |  Priority Queues   | better to add the smallest numbers first    | [Link](https://ideone.com/2aHcCe) |
| [Updating a Dictionary](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3948)      |  TreeMap   | _    | [Link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v125/UpdatingADictionary_UVa12504.java) |
| [Word Index](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=358)      |  TreeMaps, Queues   | generating all indices with queues and storing results in a map     | [Link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v004/WordIndex_UVa417.java) |
| [Argus](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3644)      |  Priority Queue   | -    | [Link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v012/Argus_UVa1203.java) |

### Problem Set #2

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Hay Points](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=631&page=show_problem&problem=1236)      |  TreeMap   | _    | [Link](https://ideone.com/w1Onpp) |
| [I Can Guess the Data Structure](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3146)      |  Queues,Stacks,Priority Queues   | simulate the operation using the required data structures   | [Link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v119/ICanGuessTheDataStructure_UVa11995.java) |
| [CD](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2949)      |  Hash/TreeSet   | _    | [Link](https://ideone.com/hJPndm) |
| [Andy's Second Dictionary](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2003)      |  TreeSet   | _    | [Link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v110/AndysSecondDicitionary_UVa11062.java) |
| [Conformity](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2261)      |  TreeMap   | _    | [Link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v112/Conformity_UVa11286.java) |
