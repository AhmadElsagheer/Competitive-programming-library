#include<bits/stdc++.h>
using namespace std;
#define ll long long
int adj[5][5];
void add(int u,int v)
{
	adj[u][v]=1;
	adj[v][u]=1;
}
void display(int n)
{
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cout<<adj[i][j]<<" ";
		}
		cout<<endl;
	}
}
int main(){
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif
	int n=5;
	add(1,2);
	add(0,2);
	add(0,1);
	add(2,4);
	add(1,3);
	add(4,3);
	add(2,3);
	display(5);
	
	return 0;
}