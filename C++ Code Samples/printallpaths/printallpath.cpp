
#include <iostream>
#include <stack>
#include <cstring>

using namespace std;

struct node
{
	struct node* left;
	int data;
	struct node* right;
};

struct node * getNewNode(int data)
{
	struct node* toAdd = (struct node*)malloc(sizeof(struct node));
	toAdd->data = data;
	toAdd->left = toAdd->right = NULL;
	return toAdd;
}

void printarray(int path[], int len)
{
	for(int i=0; i<len; i++)
	{
		cout << path[i];
		if(i!=len-1)
			cout << "->";
	}
	cout<<endl;
}

void printallpath(struct node* root, int path[], int len)
{
	if(root == NULL)
		return;

	path[len] = root->data;
	if(root->left==NULL && root->right==NULL)
	{		
		printarray(path, len+1);
		return;
	}
	
	printallpath(root->left, path, len+1);
	printallpath(root->right, path, len+1);		
}

int main()
{
	int flag = 0;
	int path[100];
	struct node *root = getNewNode(1);
	root->left = getNewNode(2);
	root->right = getNewNode(3);
	root->left->left = getNewNode(4);
	root->left->right = getNewNode(5);
	root->right->left = getNewNode(6);
	root->right->right = getNewNode(7);
	root->left->left->left = getNewNode(8);
	root->left->left->right = getNewNode(9);
	root->left->right->left = getNewNode(10);
	root->left->right->right = getNewNode(11);
	root->right->left->left = getNewNode(12);
	root->right->left->right = getNewNode(13);
	root->right->right->left = getNewNode(14);
	root->right->right->right = getNewNode(15);

	printallpath(root, path, 0);
	getchar();
	return 0;
}
