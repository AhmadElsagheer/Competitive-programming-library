#include<bits/stdc++.h>
using namespace std;
#define ll long long
class graph
{
	int V;
	list<int> *adj;
public:
	graph(int V);
	void add(int u,int v);
	void BFS(int v);
};

graph::graph(int V)
{
	this->V=V;
	adj=new list<int>[V];
}

void graph::add(int u,int v)
{
	adj[u].push_back(v);
}
void graph::BFS(int s)
{
	bool *visited=new bool[V];
	for(int i=0;i<V;i++)
	{
		visited[i]=false;
	}
	list<int> queue;

	visited[s]=true;
	queue.push_back(s);


	list<int>::iterator i;


	while(!queue.empty())
	{
		s=queue.front();
		cout<<s<<" ";
		queue.pop_front();


		for(i=adj[s].begin();i!=adj[s].end();i++)
		{
			if(!visited[*i])
			{
				visited[*i]=true;
				queue.push_back(*i);
			}
		}
	}
}

int main(){
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif
	 graph g(4); 
    g.add(0, 1); 
    g.add(0, 2); 
    g.add(1, 2); 
    g.add(2, 0); 
    g.add(2, 3); 
    g.add(3, 3); 
  
    cout << "Following is Breadth First Traversal "
         << "(starting from vertex 2) \n"; 
    g.BFS(2); 

	return 0;
}