#include<bits/stdc++.h>
using namespace std;

vector<int>graph[100];

void DFS(int u)
{
	cout<<u<<" ";
	for(auto x:graph[u])
	{
		if(x!=u)
			DFS(x);
	}
}
int main()
{
	int number_of_nodes, number_of_edges;
	cin>>number_of_nodes>>number_of_nodes;

	int u,v;
	for(int i=0;i<number_of_nodes;i++)
	{
		cin>>u>>v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	// Here we have pass the 0 as we can assume for time-being that 0 is the root..
	DFS(0);

}