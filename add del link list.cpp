#include<bits/stdc++.h>
using namespace std;
#define ll long long

class node  
{  
    public: 
    int data;  
    node *next;  
};

void add_node(node ** head,int n)  //inserts at the front
{
	node *temp=new node;
	temp->data=n;
	temp->next=*head;
	*head=temp;
}
void add(node ** head,int n)
{
	node *temp=new node();
	node *l=*head;
	temp->data=n;
	temp->next=NULL;
	if(*head==NULL)
	{
		*head=temp;
	}
	else
	{
		while(l->next!=NULL)
      {
	   l=l->next;
      }	
      l->next=temp;
	}
}
void display(node ** k)
{
	while((*k)!=NULL)
	{
		cout<<(*k)->data<<" ";
		(*k)=(*k)->next;
	}
}
void delfront(node **head)
{
	if(*head==NULL)
		cout<<"Nothing to delete \n";
	else
		(*head) = (*head)->next;
}
void delend(node **head)
{
	if(*head==NULL)
		cout<<"Nothing to delete\n";
	else
	{
		if((*head)->next==NULL)
			delete(*head);
		node *second = *head;
		while(second->next->next!=NULL)
		{
			second = second->next;
		}
		delete(second->next);
		second->next = NULL;
	}
}
int main()
{
	node *head=NULL;
	int i,n;
	cin>>n;	
	for(i=0;i<n;i++)
	{
		int x,y;
		cout<<"Enter the option"<<endl;
		cin>>y;
		if(y==1 || y==2)
		{
			cout<<"Enter the number to be inserted"<<endl;
			cin>>x;
			if(y==1)
			{
				add_node(&head,x); //insertion from front
			}
			
			else if(y==2) //insertion from end
			{
				add(&head, x);      
			}
		}
		else
		{
			if(y==3)  //deletion from front
			{
				delfront(&head);
			}
			else if(y==4)  //deletion from end
			{
				delend(&head);
			}
		}
	}
	cout<<"The final linked list is"<<endl;
	display(&head);
}
