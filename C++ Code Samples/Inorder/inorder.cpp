#include <iostream>
#include <stack>

using namespace std;

typedef struct node
{
	struct node* left;
	int data;
	struct node* right;
}node;

struct node * getNewNode(int data)
{
	struct node* toAdd = (struct node*)malloc(sizeof(struct node));
	toAdd->data = data;
	toAdd->left = toAdd->right = NULL;
	return toAdd;
}

void inorderrec(node* root)
{
	if(root==NULL)
		return;
	inorderrec(root->left);
	cout<<" "<<root->data;
	inorderrec(root->right);
}

/* Implemenation without Recursion but with Stack */
void inordernotrec(node* root)
{
	stack<node*> myStack;
	if(!root)
		return;
		
	node* current = root;

	do
	{
		if(current==NULL && !myStack.empty())
		{
			current = myStack.top();
			cout<<" "<<current->data;			
			myStack.pop();
			current = current->right;
		}
		else
		{
			myStack.push(current);
			current = current->left;			
		}
		if(myStack.empty() && current == NULL)
			break;
	}while(1);
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
	
	cout<<"Inorder with recursion:"<<endl;
	inorderrec(root);
	cout<<"\nInorder without recursion:"<<endl;
	inordernotrec(root);
	getchar();
	return 0;
}
