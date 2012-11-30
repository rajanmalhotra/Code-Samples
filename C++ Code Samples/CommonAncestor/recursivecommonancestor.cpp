#include <iostream>
#include <stack>

using namespace std;

typedef struct node
{
	node* left;
	node* right;
	int data;
}node;

node* createnewnode(int val)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->left = NULL;
	new_node->right = NULL;
	new_node->data = val;
	return new_node;
}

node* createbinarytree(node* binarytree, int *arr, int size)
{
	int parent = 0;		
	node* new_node = NULL;
	binarytree = createnewnode(arr[0]);
		
	for(int i=1; i<size; i++)
	{	
		new_node = createnewnode(arr[i]);
		binarytree[i] = *new_node;
		parent = (i-1)/2;
		if(i%2 == 0)
			binarytree[parent].right = new_node;
		else
			binarytree[parent].left = new_node;
	}
	return binarytree;
}
int main()
{
	int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	int size = sizeof(arr)/sizeof(arr[0]);
	node binarytree[sizeof(arr)/sizeof(arr[0])];
	node* root = createbinarytree(binarytree, arr, size);

	for(int i = 0; i<size; i++)
	{
		cout<<root[i].data<<endl;
		cout<<root[i].left->data<<endl;
		cout<<root[i].right->data<<endl;
	}
}































