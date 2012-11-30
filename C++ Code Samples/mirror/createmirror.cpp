#include <iostream>
#include <stack>

using namespace std;

struct node
{
	struct node* left;
	int data;
	struct node* right;
};

int searchEle1 = 5, searchEle2 = 4;
int path1[100];
int path2[100];

struct node * getNewNode(int data)
{
       cout<<"Creating a node : "<<endl;
	struct node* toAdd = (struct node*)malloc(sizeof(struct node));
	toAdd->data = data;
	toAdd->left = toAdd->right = NULL;
	return toAdd;
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

void create_mirror(struct node* root)
{
     if(root == NULL)
             return;
     struct node* temp;
     temp = root->left;
     root->left = root->right;
     root->right = temp;
     create_mirror(root->left);
     create_mirror(root->right);
}

void print(struct node* root)
{
     if(root == NULL)
             return;
     cout<<root->data<<endl;
     print(root->left);
     print(root->right);
}

bool check_mirror(struct node* root1, struct node* root2)
{
     if(root1 == NULL && root2 == NULL)
              return true;
     if(root1 == NULL || root2 == NULL)
              return false;
     if((root1->data == root2->data) && check_mirror(root1->left->left, root2->right->right) && 
                           check_mirror(root1->left->right, root2->right->left))
        return true;
     return false;
}

int main()
{
    bool flag;
    flag = false;
    cout<<"Creating a Mirror : ";
	struct node *root = getNewNode(1);
	root->left = getNewNode(3);
	root->right = getNewNode(3);
	root->left->left = getNewNode(4);
	root->left->right = getNewNode(5);
	root->right->left = getNewNode(5);
	root->right->right = getNewNode(4);
	create_mirror(root);
	print(root); 
    flag = check_mirror(root->left, root->right);
    cout<<" Is Tree a mirror : "<<flag;
}
