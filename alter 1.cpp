#include<bits/stdc++.h>
using namespace std;
#define ll long long
int main(){
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif
	ll n;
	cin>>n;
	ll a[n];
	for(ll i=0;i<n;i++)
	{
		cin>>a[i];
	}
	for(ll i=0;i<n;i++) //setting the flag bit
	{
		if(a[i]>=0)
		{
			a[i]=1;
		}
		else
		{
			a[i]=-1;
		}
	}
	bool flag=0;
	ll sum=0;
	for(ll i=0;i<n-1;i++)
	{
		if(a[i]==a[i+1])
		{
			flag=1;
			break;
		}


	}
	if(flag==0)
	{
		cout<<"ALTER ARRAY";
	}
	else{
		cout<<"NOT AN ALTER ARRAY";
	}


	return 0;
}