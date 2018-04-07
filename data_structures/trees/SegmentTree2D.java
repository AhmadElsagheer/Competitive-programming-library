package data_structures.trees;

public class SegmentTree2D {    // subrectangle sum, point update

    int[][] matrix;
    int[][] tree;
    int N, M;

    SegmentTree2D(int[][] a)
    {
        matrix =  a;
        N = 1; while(N < a.length) N <<= 1;
        M = 1; while(M < a[0].length) M <<= 1;
        buildX(1, 1, N);
    }

    void buildX(int vx, int lx, int rx)
    {
        if(lx != rx)
        {
            int mid = (lx + rx) >> 1;
            buildX(vx << 1, lx, mid);
            buildX(vx << 1 | 1, mid + 1, rx);
        }
        buildY(vx, lx, rx, 1, 1, M);
    }

    void buildY(int vx, int lx, int rx, int vy, int ly, int ry)
    {
        if(ly == ry) {
            if(lx == rx)
            {
                if(lx <= matrix.length && ly <= matrix[0].length)
                    tree[vx][vy] = matrix[lx - 1][ly - 1];
                
            }
            else
                tree[vx][vy] = tree[vx << 1][vy] + tree[vx << 1 | 1][vy];
            return;
        }
        
        int mid = (ly + ry) >> 1;
        buildY(vx, lx, rx, vy << 1, ly, mid);
        buildY(vx, lx, rx, vy << 1 | 1, mid + 1, ry);
        tree[vx][vy] = tree[vx][vy << 1] + tree[vx][vy << 1 | 1];
    }

    int sum(int bx, int ex, int by, int ey) { return sumX(1, 1, N, bx, ex, by, ey); }

    int sumX(int vx, int lx, int rx, int bx, int ex, int by, int ey)
    {
        if(lx > rx)
            return 0;
        if(bx == lx && rx == ex)
            return sumY(vx, 1, 1, M, by, ey);
        int mid = (lx + rx) >> 1;
        int q1 = sumX(vx << 1, lx, mid, bx, Math.min(rx, mid), by, ey);
        int q2 = sumX(vx << 1 | 1, mid + 1, rx, Math.max(mid + 1, bx), ex, by, ey);
        return q1 + q2;
    }

    int sumY(int vx, int vy, int ly, int ry, int by, int ey)
    {
        if(ry > ly)
            return 0;
        if(by == ly && ry == ey)
            return tree[vx][vy];
        int mid = (ly + ry) >> 1;
        int q1 = sumY(vx, vy << 1, ly, mid, by, Math.min(ey, mid));
        int q2 = sumY(vx, vy << 1 | 1, mid + 1, ry, Math.max(mid + 1, by), ey);
        return q1 + q2;
    }

    void update(int i, int j, int val) {  updateX(1, 1, N, i, j, val); }

    void updateX(int vx, int lx, int rx, int i, int j, int val)
    {
        if(lx != rx)
        {
            int mid = (lx + rx) >> 1;
            if(i <= mid)
                updateX(vx << 1, lx, mid, i, j, val);
            else
                updateX(vx << 1 | 1, mid + 1, rx, i, j, val);
        }
        updateY(vx, lx, rx, 1, 1, M, j, val);
    }

    void updateY(int vx, int lx, int rx, int vy, int ly, int ry, int j, int val)
    {
        if(ly == ry)
            if(lx == rx)
                tree[vx][vy] = val;
            else
                tree[vx][vy] = tree[vx << 1][vy] + tree[vx << 1 | 1][vy];
        else
        {
            int mid = (ly + ry) >> 1;
            if(j <= mid)
                updateY(vx, lx, rx, vy << 1, ly, mid, j, val);
            else
                updateY(vx, lx, rx, vy << 1 | 1, mid + 1, ry, j, val);
            tree[vx][vy] = tree[vx][vy << 1] + tree[vx][vy << 1 | 1];
        }

    }
}
