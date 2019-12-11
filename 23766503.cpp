#include<iostream>
using namespace std;
#include<algorithm>
int main()
{
    int test;
	long long int i,N,A,B,K,sum,gcd,lcm;
	scanf("%d",&test);
	for(i=1;i<=test;i++)
	{   sum=0;
	    scanf("%lld ",&N);
	    scanf("%lld ",&A);
	    scanf("%lld ",&B);
	    scanf("%lld ",&K);
	    gcd=__gcd(A,B);
	    lcm=((A*B)/gcd);
	    sum=(N/A)+(N/B)-2*(N/lcm);
	    if(sum>=K)
	       printf("Win\n");
	    else
	       printf("Lose\n");
	}
	return 0;
}