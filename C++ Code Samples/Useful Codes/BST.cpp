#include <iostream>

using namespace std;

typedef struct node
{
	int data;
	node* left;
	node* right;
}node;

node* root = null;

node* createnode(int data)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->data = data;
	new_node->left = null;
	new_node->right = null;
	return new_node;
}

bool search(node* current, int val)
{	
	if(current==null)
		return false;
	if(val == current->data)
		return true;
	else if(val > current->data)
		return search(current->right, val);
	else if(val < current->data)
		return search(current->left, val);
}

void insert(int val)
{
	node* new_node = createnode(val);
	node* temp = root;
	node* parent = null;
	char flag;
	if(root == null)
		root = new_node;
	else
	{		
		while(temp!=null)
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

void printtree(node* temp)
{
	if(!temp)
		return;
	cout<<temp->data<<" ";
	printtree(temp->left);
	printtree(temp->right);
}
int main()
{
	int arr[] = {43, 23, 34, 45, 24, 57, 75, 12, 2, 4, 69};
	int len = 11;
	bool flag;
	/* insert in bst */
	for(int i=0; i < len; i++)
		insert(arr[i]);
	printtree(root);
	

	/* search in bst */
	int arr_test[] = {57, 29, 56, 75, 8, 12, 2, 4};
	len = 8;
	cout<<"\n searching nodes in bst"<<endl;
	for(int i=0; i<8; i++)
	{
		flag = search(root, arr_test[i]);
		if(flag)
			cout<<arr_test[i]<<" is present in tree"<<endl;
	}
	getchar();
	return 0;
}