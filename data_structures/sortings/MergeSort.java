/* Merge Sort Iterative Implementation In C++

  complexity : O(n)

*/
#include<bits/stdc++.h>
using namespace std;
#define M 10
void input(int *a)
{
    cout<<"\nArray : ";
    for(int i=0;i<M;i++)
        cin >> a[i];
}
void merge(int *a)
{
    int tmp[M],i,j,k,size=1;
    int l1,u1,l2,u2;
    while(size<M)
    {
        k=0;
        l1=0;
        while(l1+size<M)
        {
            l2=l1+size;
            u1=l2-1;
            if(l2+size<M)
                u2=l2+size-1;
            else
                u2=M-1;

            //Comparisions
            for(i=l1,j=l2;i<=u1&&j<=u2;k++)
            {
                if(a[i]<a[j])
                    tmp[k]=a[i++];
                else
                    tmp[k]=a[j++];
            }

            //Remaining Elements
            for(;i<=u1;i++)
                tmp[k++]=a[i];
            for(;j<=u2;j++)
                tmp[k++]=a[j];

            l1=u2+1;

        }
        for(int i=l1;i<M;i++)
            tmp[k++]=a[i];
        for(int i=0;i<M;i++)
            a[i]=tmp[i];

        //doubling Size
        size*=2;

    }
}
void display(int *a)
{
    cout<<"\nArray : ";
    for(int i=0;i<M;i++)
        cout<<a[i]<<' ';
}
int main()
{
    //Sample size M = 10
    //Array of size 10
    int x[M];
    input(x);
    cout<<"\nBefore sorting : ";
    display(x);
    cout<<"\nAfter sorting : ";
    merge(x);
    display(x);
}
