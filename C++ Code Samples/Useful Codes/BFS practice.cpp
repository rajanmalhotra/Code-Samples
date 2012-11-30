#include <iostream>
#include <queue>

using namespace std;

typedef struct node
{
	int data;
	node* left;
	node* right;
}node;

node* root = NULL;
queue<node*> myqueue;	

node* createnode(int data)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->data = data;
	new_node->left = NULL;
	new_node->right = NULL;
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
		temp = myqueue.front();		
		cout<<temp->data<<" ";		
		if(temp->left)
			myqueue.push(temp->left);	
		if(temp->right)
			myqueue.push(temp->right);	
		myqueue.pop();
		count--;
	}	
	BFS();
}

int main()
{
	root = createnode(1);
	root->left = createnode(2);
	root->right = createnode(3);
	root->left->left = createnode(4);
	root->left->right = createnode(5);
	root->right->left = createnode(6);
	root->right->right = createnode(7);
	root->left->left->left = createnode(8);
	root->left->left->right = createnode(9);
	root->left->right->left = createnode(10);
	root->left->right->right = createnode(11);
	root->right->left->left = createnode(12);
	root->right->left->right = createnode(13);
	root->right->right->left = createnode(14);
	root->right->right->right = createnode(15);
	myqueue.push(root);
	BFS();
	cout<<endl;	
	getchar();
	return 0;
}