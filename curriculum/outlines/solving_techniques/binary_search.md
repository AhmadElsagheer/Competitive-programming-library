# Binary Search
---
## Outline
1. Basic usage of binary search
	- Examples
		* finding an element in array of distinct values
		* Arrays with duplicates (finding first/last occurence)
		* lower and upper bounds
	- Complexity
	- Built-in methods (e.g. `Collections.binarySearch()`)
2. Binary search on uncommon data structures
	- Example: "My Ancestor" problem
3. Bisection method
	- `while` loop implementation with `EPS`
	- `for` loop implementation
4. Main theorem
	- variants in checker predicates (e.g. simulating using current guessed value)
5. Binary Seach the Answer (monotonic functions)
---

## Material Resources
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
|CP Section 3.3  | Most of outline points|
|[Topcoder Blog](https://www.topcoder.com/community/data-science/data-science-tutorials/binary-search/)|Monotonicity and Finding the answer|

---
## Problem Sets
### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
|[The Playboy Chimp](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1552)|Lower and Upper Bound||[link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v106/ThePlayboyChimp_UVa10611.java)|
|[Worms](http://codeforces.com/problemset/problem/474/B)|Upper Bound||[link](http://codeforces.com/contest/474/submission/18132202)|
|[Interesting drink]()|Lower Bound||[link](http://codeforces.com/contest/706/submission/19792492)|
|[Queries about less or equal elements](http://codeforces.com/contest/600/problem/B)|Lower Bound|Shuffle Before Sort to avoid TLE|[link](http://codeforces.com/contest/600/submission/16453821)|
|[Magic Powder - 2](http://codeforces.com/problemset/problem/670/D2)|Finding Answer||[link](http://codeforces.com/contest/670/submission/17824666)|

### Problem Set #2
| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
|[Sagheer and Nubian Market](http://codeforces.com/contest/812/problem/C)|Finding Answer||[link](http://codeforces.com/contest/812/submission/27728473)|
|[Enduring Exodus](http://codeforces.com/problemset/problem/645/C)|||[link](http://codeforces.com/contest/645/submission/16786811)|
|[Gukiz and Boxes](http://codeforces.com/problemset/problem/551/C)|||[link](http://codeforces.com/contest/551/submission/34331187)|
|[Battle Fury](http://codeforces.com/gym/100247/problem/F)|||[link](https://ideone.com/g9OmIP)|
|[String Game](http://codeforces.com/contest/779/problem/D)|||[link](http://codeforces.com/contest/779/submission/25077945)|

### Problem Set #3
| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
|[Chain Reaction](http://codeforces.com/problemset/problem/607/A)|Finding Answer||[link](http://codeforces.com/contest/607/submission/17546217)|
|[Hamburgers](http://codeforces.com/contest/371/problem/C)|Finding Answer||[link](http://codeforces.com/contest/371/submission/17824474)|
|[Energy Exchange](http://codeforces.com/problemset/problem/68/B)||Binary Search using Doubles|[link](http://codeforces.com/contest/68/submission/20514429)|
|[K-Dominant Character](http://codeforces.com/contest/888/problem/C)||Needs Prefix Sums|[link](http://codeforces.com/contest/888/submission/32166894)|
|[Exact Sum](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1998)|||[link](https://github.com/TheRealImaginary/CompetitiveProgramming/blob/master/UVA/UVA_11057_ExactSum.java)|
