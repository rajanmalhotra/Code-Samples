/*
You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
Create an algorithm to decide if T2 is a subtree of T1.
http://www.geeksforgeeks.org/archives/13942
*/
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
	newnode->left = NULL;
	newnode->right = NULL;
	return newnode;
}

/* // Previous Code
bool check_subtree(node* T1, node* T2){
	if(T1==NULL && T2==NULL)
		return true;
	// Modify below logic if you want T2's null children to match too
	else if(T2==NULL)
		return true;
	else if(T1==NULL)
		return false;

	if(T1->data == T2->data){
		return check_subtree(T1->left, T2->left) &&	check_subtree(T1->right, T2->right);
	}
	else{
		return check_subtree(T1->left, T2) || check_subtree(T1->right, T2);
	}

}
*/

bool matchtree(node* T1, node* T2){
	if(T1==NULL && T2==NULL)
		return true;
	if(T1==NULL || T2==NULL)
		return false;

	if(T1->data == T2->data)
		return matchtree(T1->left, T2->left) && matchtree(T1->right, T2->right);
	else 
		return false;
}

bool check_subtree(node* T1, node* T2){
	if(T2==NULL)
		return true;
	if(T1==NULL)
		return false;

	if(matchtree(T1, T2))
		return true;

	return check_subtree(T1->left, T2) || check_subtree(T1->right, T2);
}

int main(){
	node *T1 = createnode(1);
	T1->left = createnode(2);
	T1->right = createnode(3);
	T1->left->left = createnode(4);
	T1->left->right = createnode(5);
	T1->right->left = createnode(6);
	T1->right->right = createnode(7);
	T1->left->left->left = createnode(8);
	T1->left->left->right = createnode(9);
	T1->left->right->left = createnode(10);
	T1->left->right->right = createnode(11);
	T1->right->left->left = createnode(12);
	T1->right->left->right = createnode(13);
	T1->right->right->left = createnode(14);
	T1->right->right->right = createnode(15);
	T1->left->left->left->left = createnode(16);

	node *T2 = createnode(7);
	T2->left = createnode(14);
	T2->right = createnode(15);

	bool val = check_subtree(T1, T2);
	if(val)
		cout<<"T2 is a subtree of T1";
	else
		cout<<"T2 is not a subtree of T1";
	getchar();
	return 0;
}