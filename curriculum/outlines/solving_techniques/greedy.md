# Greedy
---
## Outline
1. What is Greedy
    - Example: Activity-Selection problem
2. Greedy Properties
    - Greedy-choice property
    - Optimal Sub-structure
3. Classical Examples
    - Sortings: [Dragon of Loowater](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2267)
    - Interval Covering: [Watering Grass](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1323)
    - Huffman Coding: [Add All](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1895)
4. Greedy failure
    - Example: greedy coin change vs general coin change.

## Material Resources
| Resource                  | Points Covered                  |
|:------------------------- |:--------------------------------|
| CLRS 16.1, 16.2 | 1, 2: greedy concepts |
| CP Section 3.4 | 3: greedy failure |
| [ACP](https://www.youtube.com/watch?v=iXxP_liQklk&list=PLPt2dINI2MIbJYBTHmRuZuGLIP5PnkzMH) | extra |
| [Topcoder](https://www.topcoder.com/community/data-science/data-science-tutorials/greedy-is-good/) | extra |
---
## Problem Sets

### Problem Set #1

| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:--------|
| [All in All](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1281) | | greedy choice: for each char in _t_, match with leftmost valid char in _s_ | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v103/AllInAll_UVa10340.java) |
|[Boiled Eggs](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3051)|| gc: pick the lightest egg first |[link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v119/BoiledEggs_UVa11900.java)|
| [Scarecrow](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3836) | | gc: put scarecrows from left to right each covering an uncovered range without leaving cells empty | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v124/Scarecrow_UVa12405.java) |
| [Dragons](http://codeforces.com/contest/230/submission/11367857) | sortings | gc: kill weakest dragons first | [link](http://codeforces.com/contest/230/submission/11367857) |
| [Jeopardy!](http://codeforces.com/problemset/problem/413/C) | sortings | gc: answer regular questions first, then auction questions from larger to smaller | [link](http://codeforces.com/contest/413/submission/24717142) |
| [Gas Stations](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3743) | | interval covering | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/3d54f533edc19cce6bf4406ee6934a571c11fcaf/v123/GasStations_12321.java)|




### Problem Set #2
| Problem        | Tags          | Notes  | Solution |
|:------------- |:-------------|:-----|:-------|
| [Ants](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1655) | | change your point of view! | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v107/Ants_UVa10714.java) |
| [Fill the Square](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2515) | | gc: start with smallest char first | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v115/FillTheSquare_UVa11520.java) |
| [Short Story Competition](https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3926) | | gc: make each line as full as possible | [link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v124/ShortStoryCompetition_UVa12482.java) |
|[Shoemaker's Problem](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=967)|| greedy selection for only 2 items. For n items, sort using the pairwise selection! |[link](https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v100/ShoemakersProblem_UVa10026.java)|
| [Dynamic Frog](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2098) | | gc: skip the first small rock | [link](https://github.com/Diusrex/UVA-Solutions/blob/master/11157%20Dynamic%20Frog.cpp) |
