#include <iostream>

using namespace std;

typedef struct node{
	int data;
	node *left;
	node *right;
}node;

node *createnode(int val){
	node *newnode = (node*)malloc(sizeof(node));
	newnode->data = val;
	newnode->left = null;
	newnode->right = null;
	return newnode;
}

int find_common_ancestor(node *root, int val1, int val2){
	if(root==null)
		return 0;
	int val = 0;

	if(root->data == val1 || root->data == val2)
		val = 1;

	val+=find_common_ancestor(root->left, val1, val2);
	val+=find_common_ancestor(root->right, val1, val2);

	if(val==2)
	{
		cout<<root->data<<" is the first ancestor of both "<<val1<<" and "<<val2<<"."<<endl;
		return 0;
	}
	return val;
}

int main(){
	node *root = createnode(1);
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
	root->left->left->left->left = createnode(16);
	int val = find_common_ancestor(root, 11, 8);
	getchar();
	return 0;
}