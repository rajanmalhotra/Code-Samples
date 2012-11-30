*
Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
(eg, if you have a tree with depth D, you�ll have D linked lists).
*/

#include <iostream>
#include <vector>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

typedef struct node{
	int data;
	node *left;
	node *right;
}node;

typedef struct llnode{
	int data;
	llnode *next;
}llnode;

node* createnode(int val){
	node* newnode = (node*)malloc(sizeof(node));
	newnode->data = val; 
	newnode->left = NULL;
	newnode->right = NULL;
	return newnode;
}

llnode* createllnode(int val){
	llnode* newnode = (llnode*)malloc(sizeof(llnode));
	newnode->data = val; 
	newnode->next = NULL;
	return newnode;
}

void makenodes_to_linkedlist(node *root, vector<llnode*> &myvector, int level){	
	if(root==NULL)
		return;
	llnode *temp = createllnode(root->data);
	
	if(myvector.size()==level)
		myvector.push_back(temp);
	else{
		llnode *current_ll = myvector[level];
		while(current_ll->next!=NULL)
			current_ll = current_ll->next;
		current_ll->next = temp;
	}
	
	node *current = root;
	if(current->left)
			makenodes_to_linkedlist(current->left, myvector, level+1);
	if(current->right)
			makenodes_to_linkedlist(current->right, myvector, level+1);	
}

void printlists(vector<llnode*> myvector){
	for(int i=0; i < myvector.size(); i++){
		llnode *current = myvector[i]; 
		cout<<"Level "<<i+1<<" : "; 
		while(current!=NULL){
			cout<<current->data<<" ";
			current = current->next;
		}	
		cout<<endl;
	}
}

int main()
{
    	vector<llnode*> myvector;
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
	makenodes_to_linkedlist(root, myvector, 0);
	printlists(myvector);
	getchar();
	return 0;
}
