#include<bits/stdc++.h>

#define ll long long int
#define llu unsigned long long int
#define f(n) for(ll i=0;i<n;i++)
#define fr(n) for(ll i=n-1;i>=0;i--)
#define endl "\n"
#define mod 1000000007

using namespace std;

class node 
{ 
public: 
	ll data; 
	node* left; 
	node* right; 
	
	node(ll data) 
	{ 
		this->data = data; 
		this->left = NULL; 
		this->right = NULL; 
	} 
}; 

ll isThisBST(node* node, ll min, ll max) 
{ 
	if (node==NULL) 
		return 1; 

	if (node->data < min || node->data > max) 
		return 0; 

	return isThisBST(node->left, min, node->data-1) && isThisBST(node->right, node->data+1, max);
} 

int main()
{
	node *root = new node(4); 
	root->left = new node(2); 
	root->right = new node(5); 
	root->left->left = new node(1); 
	root->left->right = new node(3); 
	
	if(isThisBST(root,INT_MIN,INT_MAX)) 
		cout<<"Is BST"; 
	else
		cout<<"Not a BST"; 
	
	return 0;
}
