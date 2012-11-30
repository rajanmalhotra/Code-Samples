#include <iostream>
#include <queue>

using namespace std;

typedef struct node
{
	int data;
	node* children[10];
}node;

node* root = NULL;
queue<node*> myqueue;	

node* createnode(int data)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->data = data;
	for(int i=0; i <10; i++)
		new_node->children[i] = NULL;
	return new_node;
}

void BFS()
{
	int i=0, count = 0;
	node* temp = NULL;
	count = myqueue.size();
	if(count==0)
		return;
	cout<<"\n Next Level : ";
	while(count)
	{
		i = 0;
		temp = myqueue.front();		
		cout<<temp->data<<" ";		
		while(temp->children[i]!=NULL)
			myqueue.push(temp->children[i++]);	
		myqueue.pop();		
		count--;
	}	
	
	BFS();
}

int main()
{
	root = createnode(1);
	root->children[0] = createnode(2);
	root->children[1] = createnode(3);
	root->children[2] = createnode(4);
	root->children[0]->children[0] = createnode(5);
	root->children[0]->children[1] = createnode(6);
	root->children[1]->children[0] = createnode(7);
	root->children[2]->children[0] = createnode(8);
	root->children[2]->children[1] = createnode(9);
	myqueue.push(root);
	BFS();
	cout<<endl;	
	getchar();
	return 0;
}