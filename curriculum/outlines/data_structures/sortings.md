# Sortings
---
## Outline
1. Counting Sort
	 1. When is it efficient ? (time and memory complexities).
	 2. Implementation.
	 3. The idea of the frequency array is commonly used.
	 
2. Merge Sort
	 1. Implementation.
	 2. Time complexity.
	 3. Computing the inversion index in an array with/without using Merge Sort.
	 	* Problem: [Inversion Count](http://www.spoj.com/problems/INVCNT/)
   	 4. Inner implementation of Arrays.sort()
	 	* Primitive vs Object arrays
		* How to get around QuickSort worst-case
   	 5. Inner implementation of Collections.sort()
	 	* Time complexity for sorting LinkedList

---
## Material Resources
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
|[Hackerearth](https://www.hackerearth.com/practice/algorithms/sorting/counting-sort/tutorial/)            | 1: Counting Sort           |
|[Hackerearth](https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/)            | 2: Merge Sort           |
|[G4G](https://www.geeksforgeeks.org/counting-inversions/)            | 2-ii:Counting Inversions using Merge Sort           |

---
## Problem Sets
### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----:|:--------:|
| [Larry's Array](https://www.hackerrank.com/contests/101hack35/challenges/larrys-array/problem)      |  Inversions   | Check the parity of the number of inversions    | [Link](https://ideone.com/Xalx7h) |
| [Train Swapping](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=235)      |  Inversions   | _   | [Link](https://ideone.com/rSeVOt) |
| [Bubbles and Buckets](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2490) | Inversions | _ | [Link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v114/BubblesAndBuckets_UVa11495.java) |
| [Age Sort](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2457)      | Counting Sort    | _   | [Link](https://ideone.com/XyNWLV) |
| [z-sort](http://codeforces.com/contest/652/problem/B)      |  Sortings    | _   | [Link](http://codeforces.com/contest/652/submission/34045843) |

### Problem Set #2
| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------:|
| [Enemy is weak](http://codeforces.com/problemset/problem/61/E) | inversions, counting, coordinate compression | count left/right inversions for each middle element in the triple | [Link](http://codeforces.com/contest/61/submission/33984110) |

