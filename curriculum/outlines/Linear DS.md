# Linear DS
---
## Outline
1. Static Arrays
	 1. Creating 1D, 2D, ND Static Arrays.
	 2. Accessing Time.
	 3. Traversing a Static Array with N dimensions.
	 4. 1D Array Manipulation
	 	* Example: Shuffle an Array [Link to some examples](https://www.geeksforgeeks.org/array-data-structure/)
	 4. 2D Array Manipulation
	 	* Rotating a matrix.
	 5. Pitfalls when creating a static array
       		* Example: int[] a, b; a = b = new int[10]; will lead to a and b point to same array.
2. Dynamically-Resizeable Array
	 1.
3. BitSet
4. Bitmasks (Basic bit manipulation)
	  * Example: Flipping i-th bit in an integer.
5. LinkedLists
6. Stacks
7. Queues
8. Dequeues
    
---
## Problem Sets

### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Boy or Girl](http://codeforces.com/problemset/problem/236/A)      |  1D Array manipulation   | use a boolean array to keep track whether a character is found or not.    | [Link](http://codeforces.com/contest/236/submission/33829251) |
| [Splitting Numbers](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=9)      |  Bit Manipulation   | basic bit manipulation but could be solved with strings + binary decimal conversion.   | [Link](https://ideone.com/VcuwoQ) |
| [Free Spots](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1644)      |  2D Array Manipulation    | use 2D boolean array of size 500 × 500)   | [Link](https://github.com/fernandohbc/MyPCS/blob/master/uvaonlinejudge/src/volume_cvii/P10703_FreeSpots.java) |
| [Error Correction](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=482)      |  2D Array Manipulation    | count the number of '1's for each row/col, all of them must be even , if there is an error then check if it is on the same row and col   | [Link](https://github.com/izharishaksa/UVa-Solution/blob/master/src/datastructures/builtin/Problem541YES.java) |
| [Rails](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=455)      |  Stacks    | use a stack to simulate the process   | [Link](https://ideone.com/qetrPf) |

### Problem Set #2

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Throwing cards away I](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1876)      | Queues    | simulate the process using a queue   | [Link](https://ideone.com/RbaMDN) |
| [Broken Keyboard](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3139)      |  Dequeues , Linked lists    | think of a data structure that allow insertion from both sides   | [Link](https://ideone.com/tuKwEl) |
| [Machined Surfaces](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=355)      |  1D Array Manipulation    | count the number of 'X's in each row + keep track of their max   | [Link](https://ideone.com/VK956q) |
| [Transform the Expression](http://www.spoj.com/problems/ONP/)      |  Stacks    | tricky way to use a stack , not direct   | [Link](https://ideone.com/urywUI) |
| [The Most Potent Corner](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1205)      | Bitmasks    | _   | [Link](https://ideone.com/QTrOoD) |

