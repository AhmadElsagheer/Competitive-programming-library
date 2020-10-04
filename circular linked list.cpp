#include<bits/stdc++.h>
using namespace std;
struct Node {
  int data;
  Node* next;
};
Node* last;

//Node* create(Node* last , int d); 
void insertBeg( int d)
{
  if(last==NULL)
  {
    Node* temp = new Node();
    temp->data = d;
    last = temp;
    temp->next = last;
    
  }
  else
  {
    Node* temp = new Node();
    temp->data = d;
    temp->next = last->next;
    last->next = temp;
    
  }
}
Node* append(Node* last , int d)
{
  if(last ==NULL)
  {
    Node*temp = new Node();
    temp->data = d;
    last = temp;
    temp->next = last;
    return last;
  }
  else
  {
    Node* temp = new Node();
    temp->data = d;
    temp->next = last->next;
    last->next = temp;
    last = temp;
    return last;
  }
  
}
//Node* between(Node* last , int d , int item);
void del(int d)
{
  if(last == NULL)
  {
    cout<<"List is empty "<<endl;
    return;
  }
  Node* p = last->next;
  Node* temp;
    if(last-> next == last && last->data == d)
    {
      //only node
      temp = last;
      last = NULL;
      delete(temp);
      return;
    }
    if(last->next->data == d)
    {
      //first node
      temp = last->next;
      last->next = temp->next;
      delete(temp);
      return;
    }
    while(p->next != last)
    {
      //nth node
      if(p->next->data == d)
      {
        temp = p->next;
        p->next = temp->next;
        delete(temp);

      }
      p = p->next;
    }
    if(last->data == d)
    {
      //last node
      temp = last;
    }
  
}
void display()
{
  Node* temp = last;
  if(temp == NULL)
  {
    cout<<"List is empty "<<endl;
    return;
  }
  Node* p;
  p = temp->next;
  do
  {
    cout<<p->data<<" ";
    p = p->next;
  }
  while(p != temp->next);
  cout<<endl;
}

int main()
{
  last = NULL;
  int i,d,n;
  while(1)
  {
    cout<<"1.Enter the element in beginning "<<endl;
    cout<<"2.Enter the element at last "<<endl;
    cout<<"3.Exit "<<endl;
  
  int z;
  cin>>z;
  switch(z)
  {
    case 1:
      cout<<"Enter the no of elements to be entered "<<endl;
      cin>>n;
      cout<<"Enter the element of list "<<endl;
      for(i=0;i<n;i++)
    {
      cin>>d;
      insertBeg(d);
    }
      display();
      break;

  case 2:
      cout<<"Enter the no of elements to be entered "<<endl;
      cin>>n;
      cout<<"Enter the element of list "<<endl;
      for(i=0;i<n;i++)
    {
      cin>>d;
      last = append(last,d);
    }
      display();
      break;

  case 3:
      return 0;
      
  default:
      cout<<"Wrong choice";
  }
  }
  return 0;
}
