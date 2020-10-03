#include<bits/stdc++.h>
using namespace std;
#define ll long long
void add(vector<ll> l[],int u,int v)
{
	l[u].push_back(v);
	l[v].push_back(u);
}
void printgraph(vector<ll> l[],int n)
{
	for(int i=0;i<n;i++)
	{
		cout<<i<<endl;
		for(auto x:l[i])
		{
			cout<<"->"<<x;
		}
		cout<<endl;
	}
}


int main(){
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif
	int V = 5; 
    vector<ll> l[V]; 
    add(l,0,1); 
    add(l,0,4); 
    add(l,1,2); 
    add(l,1,3); 
    add(l,1,4); 
    add(l,2,3); 
    add(l,3,4); 
    printgraph(l, V); 
	

	return 0;
}