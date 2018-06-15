# Linear DS: Supplementary Material
---
### Static Arrays
- Accessing time of an array is O(1). However, the constant factor is a little bit higher than basic operations (such as addition or multiplication).
- [Trick] Array dimensions initialization: You can make different sizes for different rows in a 2D static array.
	        * Example: `int[][] a = new int[2][]; a[0] = new int[10]; a[1] = new int[15];`
- [Pitfall] Static Arrays are objects: `int[] a, b; a = b = new int[10];`. a and b point to same array (any change in a will be reflected in b).

### BitSets
- Core idea behind BitSets: BitSets are actually an array of bitmasks. That is, it is an array of integers where each integer represents an array of booleans. This makes BitSets better than boolean arrays from a memory complexity perspective. However, BitSets may perform worse in practice due to the overhead of calling functions (we call `get(x)` to do some stuff that finally gets a specific bit in an internal array of integers) instead of accessing a single boolean array cell.
