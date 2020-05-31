  
// https://www.spoj.com/problems/FIBOSUM/
// sum=fibo(m+2)-fibo(n+1), here answer can be negative, so be careful.
// https://codegeeksblog.wordpress.com/2013/06/02/spoj-fibosum/

// To find nth fibonacci number in log(n) time please see below concepts.
// See this link https://cp-algorithms.com/algebra/binary-exp.html
// https://cp-algorithms.com/algebra/fibonacci-numbers.html
// Video https://www.youtube.com/watch?v=EEb6JP3NXBI
#include <bits/stdc++.h>
using namespace std;
long long MAX = 1000000007;
void multiply(long long F[2][2], long long M[2][2])
{
    long long w = ((F[0][0] * M[0][0]) % MAX + (F[0][1] * M[1][0]) % MAX) % MAX;
    long long x = ((F[0][0] * M[0][1]) % MAX + (F[0][1] * M[1][1]) % MAX) % MAX;
    long long y = ((F[1][0] * M[0][0]) % MAX + (F[1][1] * M[1][0]) % MAX) % MAX;
    long long z = ((F[1][0] * M[0][1]) % MAX + (F[1][1] * M[1][1]) % MAX) % MAX;
    F[0][0] = w;
    F[0][1] = x;
    F[1][0] = y;
    F[1][1] = z;
}
void power(long long F[2][2], long long n)
{
    if (n == 0 || n == 1)
        return;
    long long M[2][2] = {{1, 1}, {1, 0}};
    power(F, n / 2);
    multiply(F, F);
    if (n & 1)
        multiply(F, M);
}
long long fibo(long long n)
{
    long long F[2][2] = {{1, 1}, {1, 0}};
    if (n == 0)
        return 0;
    power(F, n - 1);
    return F[0][0];
}
int main()
{
    long long t, n, m;
    cin >> t;
    while (t--)
    {
        cin >> m >> n;
        // Here added MAX because to remove negative sign.
        cout << (fibo(n + 2) - fibo((m - 1) + 2) + MAX) % MAX << endl;
    }
    return 0;
}
