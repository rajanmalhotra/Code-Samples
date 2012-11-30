#include <iostream>

using namespace std;

typedef struct node{
	int data;
	node *left;
	node *right;
}node;

node* createnode(int val){
	node *new_node = (node*)(malloc(sizeof(node)));
	new_node->data = val;
	new_node->left = NULL;
	new_node->right = NULL;
	return new_node;
}

void makeBST(node **root, int arr[], int start, int end){
	
	int size = end-start+1;
	if(start <= end)
		*root = createnode(arr[start + size/2]);
	else
		return;

	makeBST(&(*root)->left, arr, start, start + size/2 - 1);
	makeBST(&(*root)->right, arr, start + size/2 + 1, end);
}

void printtree(node *root){
	if(root==NULL)
		return;
	cout<<root->data<<" ";
	printtree(root->left);
	printtree(root->right);
}

int main()
{
	int arr[] = {2, 4, 5, 7, 23, 32, 36, 46, 57, 59, 61, 63, 69, 78, 89};
	node* root = NULL;
	makeBST(&root, arr, 0, 14);
	printtree(root);
	getchar();
	return 0;
}