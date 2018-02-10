# Brute Force
---
## Outline
1. Search Space
    - solutions, candidate solutions, generating solutions
2. Iterative brute force
    - UVa 725 - Division
    - UVa 441 - Lotto: Subsets of size x
    - UVa 11565 - Simple Equations: nested lopps & pruning
3. Recursive brute force (Backtracking)
    - Concepts: 
        * State and Transition
            - Search tree, base states, initial state
        * Objective function and Optimization
        * Constraints
    - Memoization
        * Example: Knapsack problem
    - More Examples:
        * Subsets generation [with `used` array, with bitmasks, with constraints]
        * Permutation generation [with `used` array, with bitmasks, with constraints]
        * N- Queen problem [with pruning, O(1) no-attack check using 3 `used` arrays for col, left_dia, right_dia]
4. Tips for writing efficient brute force solutions
---
## Material Resources
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
| CP 3.2 | All outline points |
| Book: Programming Challenges (Ch. 8) | Backtracking |
---
## Problem Sets

### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------:|
[Sales](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3701)|  Iterative | naive O(n^2) solution    | [link](https://gocodergo.wordpress.com/2016/07/03/uva-1260-sales/) |
| [Non-square Equation](http://codeforces.com/contest/233/problem/B) |  Iterative   |  choose the correct variable for search   | [link](http://codeforces.com/contest/233/submission/20012448) |
| [CD](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=565) |   Backtracking  |  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v006/CD_UVa624.java) |
| [Sum it up](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=515) | Backtracking    | generate and test, printing all solutions  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v005/SumItUp_UVa574.java) |
| [Water Gate Management](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3768) | Bactracking    | knapsack  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v123/WaterGateManagement_UVa12346.java) |
|  |     |   |  |
| [Rat Attack](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1301) | Iterative    | nested loops, backward thinking  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v103/RatAttack_UVa10360.java) |
| [23 out of 5](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1285) | Backtracking    | generating permutations  | [link](https://github.com/rezwan4029/UVA-CODES/blob/master/10344%20-%2023%20out%20of%205.cpp) |
| [The Sultan's Successors](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=103) | Backtracking    | 8-Queens  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v001/TheSultanSuccessors_UVa167.java) |
| [Prime Ring Problem](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=465) |  Backtracking |  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v005/PrimeRingProblem_UVa524.java) |
| [The dominoes solitaire](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1444) | Backtracking    | solvable with memoization (DP)  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v105/TheDominoesSolitaire_UVa10503.java) |
|  |     |   |  |
| [Repeated Substitution with Sed](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3692) | Backtracking    |   | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v012/RepeatedSubstitutionWithSed_UVa1251.java) |
| [The Golden Age](http://codeforces.com/problemset/problem/813/B) |  Iterative   |   calculate the correct Complexity | [link](http://codeforces.com/contest/813/submission/34472854) |
| [8 Queens Chess Problem](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=691) | Backtracking    | printing all solutions  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v007/QueensChessProblem_UVa750.java) |
| [Sagheer, the Hausmeister](http://codeforces.com/contest/812/problem/B) | Iterative  |   | [link](https://ideone.com/egb6Vr) |
| [The problem of the crazy linguist](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2142) | Backtracking    | preprocessing  | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v112/TheProblemOfTheCrazyLinguist_UVa11201.java) |

