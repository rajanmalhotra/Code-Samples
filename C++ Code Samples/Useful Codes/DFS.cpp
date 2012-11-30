#include <iostream>
#include <stack>

using namespace std;

typedef struct node
{
	int data;
	node* left;
	node* right;
}node;

stack<node*> mystack;

node* createnode(int val)
{
	node *new_node = (node*)malloc(sizeof(node));
	new_node->data = val;
	new_node->left = NULL;
	new_node->right = NULL;
	return new_node;
}

void insert(int val, node** root)
{
	node* new_node = createnode(val);
	node* temp = *root;
	node* parent = NULL;
	char flag;
	if(*root == NULL)
		*root = new_node;
	else
	{		
		while(temp!=NULL)
		{
			parent = temp;
			if(val > temp->data)
			{
				temp = temp->right;
				flag = 'r';
			}
		else
			{	
				temp = temp->left;
				flag = 'l';
			}
		}
		if(flag =='r')
			parent->right = new_node;
		else 
			parent->left = new_node;
	}
}


void DFS(node* root)
{
	node* temp = root;
	mystack.push(root);	
	cout<<temp->data;

	while(!mystack.empty())
	{		
		temp = mystack.top();		
		
		if(temp->left)
		{
			mystack.push(temp->left);
			temp = temp->left;
			cout<<temp->data<<" ";
		}
		else if(temp->right)
		{
			mystack.push(temp->right);
			temp = temp->right;
			cout<<temp->data;
		}
		else
			mystack.pop();		
	}	
}

int main()
{
	int arr[] = {43, 23, 34, 45, 24, 57, 75, 12, 2, 4, 69};
	int len = 11;
	int i = 0;
	node* root = NULL;
	for(i=0; i < len; i++)
		insert(arr[i], &root);
	mystack.push(root);
	DFS(root);
	getchar();
	return 0;
}