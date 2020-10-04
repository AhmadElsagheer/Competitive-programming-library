#include<bits/stdc++.h>
using namespace std;
#define ll long long

class t2stack
{
ll *a;
ll size,top1,top2;
public:
	t2stack(ll n)
	{
		size=n;
		a=new ll[n];
		top1=-1;
		top2=size;
	}

	void push1(ll n)
	{
		if(top1+1<top2)
		{
			top1++;
			a[top1]=n;
		}
		else{
			cout<<"STACK OVERFLOW"<<endl;
		}
	}
	void push2(ll n)
	{
		if(top1+1<top2)
		{
			top2--;
			a[top2]=n;
		}
		else
		{
			cout<<"STACK OVERFLOW"<<endl;
		}
	}
	void pop1()
	{
		if(top1>=0)
		{
			cout<<a[top1]<<endl;
			top1--;
		}
		else
		{
			cout<<"STACK UNDERFLOW"<<endl;
		}
	}
	void pop2()
	{
		if(top2<=size-1)
		{
			cout<<a[top2]<<endl;
			top2++;
		}
		else
		{
			cout<<"STACK UNDERFLOW"<<endl;
		}
	}

};

int main(){
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif
	
    t2stack pr(4);
    pr.push1(2);
    pr.push2(3);
    pr.push1(3);
    pr.push2(5);
    pr.pop1();
    pr.pop2();

  	

	return 0;
}