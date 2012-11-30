#include <iostream>
#include <stack>
#include <cstring>
#include "commonancestor.h"

using namespace std;

struct node
{
	struct node* left;
	int data;
	struct node* right;
};

int searchEle1 = 12, searchEle2 = 15;
int path1[100];
int path2[100];

struct node * getNewNode(int data)
{
	struct node* toAdd = (struct node*)malloc(sizeof(struct node));
	toAdd->data = data;
	toAdd->left = toAdd->right = NULL;
	return toAdd;
}

int contains(struct node* root)
{
	int val;
	if(root == NULL)
		return 0;	
	val = contains(root->left) + contains(root->right);	
	if(root->data == searchEle1 || root->data == searchEle2)
		val++;
	if(val == 2)
		cout<<"I am the common ancestor : "<<root->data<<endl;	
	return val;
}

void printPath(struct node*root, int path[], int len)
{
	if(root == NULL)
		return;

	if(root->data == searchEle1)
	{
		for(int i=0;i<len;i++)
			path1[i]=path[i];
	}

	if(root->data == searchEle2)
	{
		for(int i=0;i<len;i++)
			path2[i]=path[i];
	}

	path[len++] = root->data;

	//If we have reached the leaf node then print the path array.
	if(root->left == NULL && root->right == NULL)
	{
		for(int i=0;i<len;i++)
			cout<<path[i]<<" ";

		cout<<endl;
	}

	else
	{
		printPath(root->left,path,len);
		printPath(root->right,path,len);
	}
}

int main()
{
    cout<<"Finding Common Ancestor for : "<<searchEle1<<" and "<<searchEle2<<endl;
	int flag = 0;
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

/*
	int path[100];
	printPath(root,path,0); 
	int i=0;
	for(i=0;i<100;i++)
	{
		if(path1[i]==path2[i] &&  path1[i] !=0)
			continue;
		else
			break;
	}

	cout<<"\nCommon Ancestor is: "<<path1[i-1]<<endl;
	*/

	flag = contains(root);

}
