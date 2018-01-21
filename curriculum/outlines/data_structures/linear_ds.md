# Linear DS
---
## Outline
1. Static Arrays
	 1. Creating 1D, 2D, ND Static Arrays.
	 2. Accessing Time.
	 3. Traversing a static array with N dimensions.
	 4. 1D Array Manipulation.
	 5. 2D Array Manipulation.
	 	* Example: Rotating a matrix.
	 6. Tricks and Pitfalls.
	 
2. Dynamically-Resizable Arrays
	 1. Creating ArrayLists.
	 2. Important functions and their complexities:
	 	* `add, get, set, set, indexOf, size`
	 2. How resizing is done internally + resizing complexity.
	 5. Using Static Arrays with Dynamically-Resizable Arrays.
	 	* `ArrayList<Integer> a[]`
		
3. Bitmasks
	1. Bits as a data structure.
	2. Bit Manipulation.	
	
4. BitSets
	1. Important functions and their complexities:
		* `reset, set, cardinality, flip, nextSetBit, xor`
	2. Core idea behind BitSets.
	
5. LinkedLists
	1. Important functions and their complexities:
		* `get, add, remove`
		
6. Stacks
	1. Important functions and their complexities.
		* `pop, push, peek, isEmpty`
	2. Applications on Stacks.
	
7. Queues
	1. Important functions and their complexities.
	2. Applications on Queues.
	
8. Dequeues
	
---
## Material Resources
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
|CP section: 2.2            | Most of the outline points           |
|[G4G Apps on Arrays](https://www.geeksforgeeks.org/array-data-structure/)            | 1-iv 1D Array Manipulation           |
|[G4G Apps on Stacks](https://www.geeksforgeeks.org/stack-data-structure/)            | 6-ii Applications on Stacks           |
|[G4G Apps on Queues](https://www.geeksforgeeks.org/queue-data-structure/)            | 7-ii Applications on Queues           |
|[Supp Material](https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/curriculum/outlines/data_structures/linear_ds_supps.md)| 1-ii, 1-vi, 4-ii |

---
## Problem Sets
### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Boy or Girl](http://codeforces.com/problemset/problem/236/A)      |  1D Array manipulation   | use a boolean array to keep track whether a character is found or not.    | [Link](http://codeforces.com/contest/236/submission/33829251) |
| [Splitting Numbers](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3084)      |  Bit Manipulation   | basic bit manipulation but could be solved with strings + binary decimal conversion.   | [Link](https://ideone.com/VcuwoQ) |
| [Error Correction](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=482)      |  2D Array Manipulation    | count the number of '1's for each row/col, all of them must be even , if there is an error then check if it is on the same row and col   | [Link](https://github.com/izharishaksa/UVa-Solution/blob/master/src/datastructures/builtin/Problem541YES.java) |
| [Rails](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=455)      |  Stacks    | use a stack to simulate the process   | [Link](https://ideone.com/qetrPf) |
| [Throwing cards away I](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1876)      | Queues    | simulate the process using a queue   | [Link](https://ideone.com/RbaMDN) |
| [Broken Keyboard](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3139)      |  Deques, Linked lists    | think of a data structure that allow insertion from both sides   | [Link](https://ideone.com/tuKwEl) |

### Problem Set #2

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Machined Surfaces](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=355)      |  1D Array Manipulation    | count the number of 'X's in each row + keep track of their max   | [Link](https://ideone.com/VK956q) |
| [Transform the Expression](http://www.spoj.com/problems/ONP/)      |  Stacks    | tricky way to use a stack , not direct   | [Link](https://ideone.com/urywUI) |
| [The Most Potent Corner](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1205)      | Bitmasks    | Try to assign a number to every corner such that it is easy to find neighbours of a corner using bit manipulation   | [Link](https://ideone.com/QTrOoD) |
| [Free Spots](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1644)      |  2D Array Manipulation    | use 2D boolean array of size 500 × 500   | [Link](https://github.com/fernandohbc/MyPCS/blob/master/uvaonlinejudge/src/volume_cvii/P10703_FreeSpots.java) |
| [Raising Bacteria](http://codeforces.com/problemset/problem/579/A)      |  Bit Manipulation    | number of ones in binary form   | [Link](http://codeforces.com/contest/579/submission/34000657) |
