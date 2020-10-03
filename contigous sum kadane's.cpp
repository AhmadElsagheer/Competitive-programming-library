#include<bits/stdc++.h>
using namespace std;
#define ll long long
int main(){
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif
	
	//using KADANE'S ALGO
	//Initialise two variable.
	ll overall_max=INT_MIN;
	ll current_max=0;
	ll n; cin>>n;
	ll a[n];
	for(ll i=0;i<n;i++)
	{
		cin>>a[i];
	}
	for(ll i=0;i<n;i++)
	{
		current_max+=a[i];
		if(current_max>overall_max)
		{
			overall_max=current_max;
		}
		if(current_max<0)
		{
			current_max=0;
		}
	}
	cout<<overall_max;
	return 0;
}