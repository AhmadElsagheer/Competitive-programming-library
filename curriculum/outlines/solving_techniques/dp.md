# Dynamic Programming
---
## Outline
1. Comparison between solving paradigms: how the search space is manipulated.
	- greedy vs D&C vs brute force vs DP
2. Dynamic programming concepts
	1. state, transition, optimization of objective function
	2. memoization
3. Top-down approach vs Bottom-up approach
	1. way of thinking
	2. implementation
	3. pros and cons
4. Printing the optimal solution
5. Tricks
	1. DP with bitmasks
   		- Example: [Forming Quiz Teams](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1852)
	2. Offset Technique: Handling Negative Parameter Values
   		- Example: [Free Parentheses](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3679)
	3. Parameter Drop (MLE/TLE avoidance)
		- Example: [Star Adventure](https://community.topcoder.com/stat?c=problem_statement&pm=2940&rd=5854)
	4. Using a Map as a memo table (MLE avoidance | Top-down)
	5. Dimension Compression (MLE avoidance | Bottom-up)
6. Classical Examples
	1. 0-1 Knapsack (Subset Sum)
	2. Edit Distance
	3. Longest Common Subsequence
	4. Longest Increasing Subsequence (LIS)
	5. Max 1D Range Sum
	6. Max 2D Range Sum
	7. Traveling Salesman Problem (TSP)
	8. Bitonic Traveling Salesman Problem	
---
## Material Resources
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
|CP section 3.5, 9.3        | 3, 4, 6           |
|CP section 8.3            | 5: Tricks 1-4     |
|[G4G: Basic Concepts section](https://www.geeksforgeeks.org/dynamic-programming/#concepts)            | 2, 3 |
| CLRS Chapter 15 | DP concepts |

---
## Problem Sets
### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
|[SuperSale](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1071)|  |direct 0-1 knapsack|[link](https://ideone.com/NfpxhW)|
| [Chest of Drawers](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2415) | | BigInteger | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v114/ChestOfDrawers_UVa11420.java) |
|[Team Strategy](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2316)|  | direct 0-1 knapsack|[link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v113/TermStrategy_UVa11341.java)|
|[Pay the Price](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1254)|  | modified coin change + 1D range sum |[link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v103/PayThePrice_UVa10313.java)|
|[Divisibility](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=977)| math | modular arithmetic |[link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v100/Divisibility_UVa10036.java)|
| | | |  |
|[Diving for Gold](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=652&page=show_problem&problem=931)|  | 0-1 knapsack + printing the solution | [link](https://github.com/omaryasser/Competitive-Programming/blob/master/Solutions/UVA%20Solutions/990%20-%20Diving%20for%20Gold.java) |
| [Largest Block](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1608) | | Max 2D range sum | [link](https://github.com/omaryasser/Competitive-Programming/blob/master/Solutions/UVA%20Solutions/10667%20-%20Largest%20Block.java) |
| [Wavio Sequence](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1475) | | LIS in O(n log n) | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v105/WavioSequence_UVa10534.java) |
| [Shopping Trip](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2259) | | TSP | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v112/ShoppingTrip_UVa11284.java) |
| [Changing a String](http://codeforces.com/problemset/problem/56/D) | | edit distance, print the solution | [link](http://codeforces.com/contest/56/submission/20707271) |
| | | |  |
| [The Islands](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3537) | | bitonic TSP | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v010/TheIslands_UVa1096.java) |
| [Optimal Array Multiplication Sequence](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=284) | | matrix chain multiplication | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v003/OptimalArrayMultiplication_UVa348.java) |
| [Buying Coke](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1567) | | dimension compression, parameter drop | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v106/BuyingCoke_UVa10626.java) |
| [Antimatter](http://codeforces.com/problemset/problem/383/D) | | offset techinque, counting, nice technique: has D&C + DP solution, check editorial | [link](http://codeforces.com/contest/383/submission/24622355) |
| [Kefa and Dishes](http://codeforces.com/problemset/problem/580/D) | | bitmasks | [link](http://codeforces.com/contest/580/submission/19468135) |
| [Nested dolls](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2353) | | LIS |  [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v113/NestedDolls_UVa11368.java) |
| | | |  |
| [Longest Common Subsequence](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1346) | | LCS | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v104/LongestCommonSubsequence_UVa10405.java) |
| [The Mailbox Manufacturers Problem](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=823) | | | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v008/TheMailboxManufacturersProblem_UVa882.java) |
| [Wonderful Randomized Sum](http://codeforces.com/problemset/problem/33/C) | | prefixes and suffixes | [link](http://codeforces.com/contest/33/submission/20330347) |
| [Palindromes](http://codeforces.com/problemset/problem/137/D)  | | palindromes, two pointers, printing the solution | [link](http://codeforces.com/contest/137/submission/23677640) |
| [Big Maximum Sum](http://codeforces.com/problemset/problem/75/D) |  | 1D max range sum, prefix/suffix processing | [link](http://codeforces.com/contest/75/submission/20540466) |
