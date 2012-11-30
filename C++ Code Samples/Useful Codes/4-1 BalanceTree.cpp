#include <iostream>

using namespace std;

// Step 1: declare a struct node for tree
typedef struct node{
	int data;
	node *left;
	node *right;
}node;

// Step 2: create a node for tree
node* createnode(int val)
{
	node* newnode = (node*)malloc(sizeof(node));
	newnode->data = val; 
	newnode->left = NULL;
	newnode->right = NULL;
	return newnode;
}

int maxdepth(node *root)
{
	return root==NULL ? 0 : 1 + max(maxdepth(root->left), maxdepth(root->right));
}

int mindepth(node *root)
{
	return root==NULL ? 0 : 1 + min(mindepth(root->left), mindepth(root->right));
}

// Step 3: call the required method
bool checkbalance(node *root)
{
	if(root == NULL)
		return true;
	int bal = maxdepth(root) - mindepth(root);
	return bal <=1 ? true : false;	
}

int main()
{
	bool flag;
	node* root = createnode(1);
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
	root->right->right->right->right = createnode(16);
	flag = checkbalance(root);
	cout<<"Balance of the tree is : "<<flag<<endl;
	getchar();
	return 0;
}