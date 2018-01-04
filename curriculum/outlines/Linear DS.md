# Linear DS
---
## Outline
1. Static Array
	 1. Creating 1D, 2D, ND Static Arrays.
	 2. Accessing Time.
	 3. Traversing a static array with N dimensions.
	 4. 1D Array Manipulation
	 5. 2D Array Manipulation
	 	* Example: Rotating a matrix.
	 6. Pitfalls when creating a static array
	 	* Example: int[] a, b; a = b = new int[10]; will lead to a and b point to same array.
         7. Different sizes for different rows in a 2D static array.
	        * Example: int[][] a = new int[2][]; a[0] = new int[10]; a[1] = new int[12];
	 8. Algorithm used by Arrays.sort() on array of primitive types and on array of objects.
2. Dynamically-Resizable Array
	 1. Creating ArrayLists , Vectors
	 2. How this is achieved internally , Resizing complexity
	 3. ArrayLists vs Vectores , which is better
	 4. Important functions and their complexity
	 	* Example : add, get, remove
	 5. Using Static Arrays with Dynamically-Resizable Arrays
	        * ArrayList<Integer> a[];
	 6. Algorithm used by Collections.sort()
3. BitSet
	1. Important functions and their complexity
		* Example: reset, set, cardinality , flip, nextSetBit , and, xor
	2. Boolean Arrays vs Bitsets
	
4. Bitmasks
	1. Bit Manipulation
		* Example: Flipping i-th bit in an integer.
5. LinkedLists
	1. Important functions and their complexity
	2. Why it is usually avoided
		* Example: A linear scan is needed to find an element.
	3. Time complexity of sorting LinkedLists.
6. Stacks
	1. Important functions and their complexity
		* Example pop, push, peek, empty, search
	2. Applications on Stacks
7. Queues
	1. Important functions and their complexity
	2. Applications on Queues 
8. Dequeues
   	1. Important functions and their complexity
	
---
## Material Links
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
|CP section: 2.2            |Linear Data Structures           |
|[Link](https://www.geeksforgeeks.org/array-data-structure/)            |1D Array Manipulation           |
|CP pages: 36->38            |Bit Manipulation           |
|[Link](https://www.geeksforgeeks.org/stack-data-structure/)            |Applications on Stacks           |
|[Link](https://www.geeksforgeeks.org/queue-data-structure/)            |Applications on Queues           |

---
## Problem Sets
### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Boy or Girl](http://codeforces.com/problemset/problem/236/A)      |  1D Array manipulation   | use a boolean array to keep track whether a character is found or not.    | [Link](http://codeforces.com/contest/236/submission/33829251) |
| [Splitting Numbers](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=9)      |  Bit Manipulation   | basic bit manipulation but could be solved with strings + binary decimal conversion.   | [Link](https://ideone.com/VcuwoQ) |
| [Free Spots](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1644)      |  2D Array Manipulation    | use 2D boolean array of size 500 × 500   | [Link](https://github.com/fernandohbc/MyPCS/blob/master/uvaonlinejudge/src/volume_cvii/P10703_FreeSpots.java) |
| [Error Correction](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=482)      |  2D Array Manipulation    | count the number of '1's for each row/col, all of them must be even , if there is an error then check if it is on the same row and col   | [Link](https://github.com/izharishaksa/UVa-Solution/blob/master/src/datastructures/builtin/Problem541YES.java) |
| [Rails](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=455)      |  Stacks    | use a stack to simulate the process   | [Link](https://ideone.com/qetrPf) |

### Problem Set #2

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Throwing cards away I](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1876)      | Queues    | simulate the process using a queue   | [Link](https://ideone.com/RbaMDN) |
| [Broken Keyboard](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3139)      |  Dequeues , Linked lists    | think of a data structure that allow insertion from both sides   | [Link](https://ideone.com/tuKwEl) |
| [Machined Surfaces](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=355)      |  1D Array Manipulation    | count the number of 'X's in each row + keep track of their max   | [Link](https://ideone.com/VK956q) |
| [Transform the Expression](http://www.spoj.com/problems/ONP/)      |  Stacks    | tricky way to use a stack , not direct   | [Link](https://ideone.com/urywUI) |
| [The Most Potent Corner](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1205)      | Bitmasks    | Try to assign a number to every corner such that it is easy to find neighbours of a corner using bit manipulation   | [Link](https://ideone.com/QTrOoD) |

### Problem Set #3

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [Theatre Square](http://codeforces.com/problemset/problem/1/A)      | Math    | _   | [Link](http://codeforces.com/contest/1/submission/17282154) |
| [Watermelon](http://codeforces.com/problemset/problem/4/A)      |  Math    | _   | [Link](http://codeforces.com/contest/4/submission/8609715) |
| [Way Too Long Words](http://codeforces.com/problemset/problem/71/A)      |  Strings    | _   | [Link](http://codeforces.com/contest/71/submission/6517037) |
| [Next Round](http://codeforces.com/problemset/problem/158/A)      |  Implementation    | _   | [Link](http://codeforces.com/contest/158/submission/25087630) |
| [String Task](http://codeforces.com/problemset/problem/118/A)      | Implementation, Strings    | _   | [Link](http://codeforces.com/contest/118/submission/9439045) |

