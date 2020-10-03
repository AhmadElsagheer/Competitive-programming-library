#include<bits/stdc++.h>
using namespace std;

struct Node{
	int data;
	Node *left;
	Node *right;
	int height;
}*Root = NULL;

Node* new_Node(int DATA)  
{  
    Node* node = new Node(); 
    node->data = DATA;  
    node->left = NULL;  
    node->right = NULL;  
    node->height = 1; 
    return(node);  
}

int height(Node *a)
{
    if(a==NULL)
    return 0;
    return a->height;
}
int balance(Node *a)
{
    if(a==NULL)
    return 0;
    int lh = height(a->left);
    int rh = height(a->right);
    return (lh-rh);
}
Node *RR(Node *y)  
{  
    Node *x = y->left;  
    Node *T2 = x->right;  
    x->right = y;  
    y->left = T2;  
    y->height = max(height(y->left), 
                    height(y->right)) + 1;  
    x->height = max(height(x->left), 
                    height(x->right)) + 1;  
    return x;  
}  

Node *LL(Node *x)  
{  
    Node *y = x->right;  
    Node *T2 = y->left;  
    y->left = x;  
    x->right = T2; 
    x->height = max(height(x->left),     
                    height(x->right)) + 1;  
    y->height = max(height(y->left),  
                    height(y->right)) + 1;
    return y;  
}
Node* insertToAVL(Node* root, int data)
{
    if(root==NULL)
    {
        Node* Nodes = new_Node(data);
        return(Nodes);
    }
    if(root->data>data)
    {
        root->left = insertToAVL(root->left,data);
    }
    else if(root->data<data)
    {
        root->right = insertToAVL(root->right,data);
    }
    else
    return root;
    
    root->height = max(height(root->left),height(root->right)) + 1;
    
    int factor = balance(root);
    
    if(factor > 1 && root->left->data > data)
    {
        return RR(root);
    }
    if(factor < -1 && root->right->data < data)
    {
        return LL(root);
    }
    if (factor > 1 && data > root->left->data)  
    {  
        root->left = LL(root->left);  
        return RR(root);  
    }  
    if (factor < -1 && data < root->right->data)  
    {  
        root->right = RR(root->right);  
        return LL(root);  
    }  
    return root;
}
void inorder(Node* root) 
{
    if(root != NULL) 
    {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}
int main()
{
    int size;
    cout << "\nEnter num of node :- "; 
    cin >> size;
    vector<int> vec;
    cout << "\nEnter values :- ";
    for(int i = 0; i < size; i++) 
    {
        int x; 
        cin >> x;
        vec.push_back(x);
    }
    Root = insertToAVL(Root, vec[0]);
    for(int i = 1; i < size; i++) {
        Root = insertToAVL(Root, vec[i]);
    }
    cout << "\nInOrder Traversal is:- \n";
    inorder(Root);
    cout<< "\nRoot Node is:- \n";
    cout<<Root->data<<"\n";
    return 0;
}
