package data_structures.trees;

public class PersistentSegmentTree {

    class Node
    {
        Node left, right; int sum;

        Node(int x) { sum = x; }

        Node(Node left, Node right)
        {
            this.left = left;
            this.right = right;
            if(left != null)
                sum += left.sum;
            if(right != null)
                sum += right.sum;
        }
    }

    Node build(int[] a, int l, int r) // returns root of the initial version, a is a power of 2 and 0-based
    {
        if(l == r)
            return new Node(a[l - 1]);
        int mid = (l + r) >> 1;
        return new Node(build(a, l, mid), build(a, mid + 1, r));
    }

    int query(Node v, int l, int r, int b, int e)
    {
        if(e < l || r < b)
            return 0;
        if(b <= l && r <= e)
            return v.sum;
        int mid = (l + r) >> 1;
        return query(v.left, l, mid, b, e) + query(v.right, mid + 1, r, b, e);
    }

    Node update(Node v, int l, int r, int idx, int val) // returns root of new version, idx is 1-basd
    {
        if(l == r)
            return new Node(val);
        int mid = (l + r) >> 1;
        if(idx <= mid)
            return new Node(update(v.left, l, mid, idx, val), v.right);
        else
            return new Node(v.left, update(v.right, mid + 1, r, idx, val));
    }
}