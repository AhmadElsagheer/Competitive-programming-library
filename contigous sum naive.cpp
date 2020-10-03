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
	ll max=INT_MIN;
	for(ll i=0;i<n;i++)
	{
		ll temp=0;
		for(ll j=i;j<n;j++)
		{
			temp+=a[j];
			if(max<temp)
			{
				max=temp;
			}
		}
	}
cout<<"max="<<max;

	return 0;
}