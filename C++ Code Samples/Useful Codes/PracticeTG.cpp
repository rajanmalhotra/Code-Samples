#include <iostream>

using namespace std;

typedef struct node{
	node *left;
	node *right;
	int data;
}node;

node *createnode(int val)
{
	node *newnode = (node*)malloc(sizeof(node));
	newnode->left = NULL;
	newnode->right = NULL;
	newnode->data = val;
	return newnode;
}

void insert(node **head, int val)
{
	node *newnode = createnode(val);
	node *current = *head;
	node *previous = current;

	if(*head == NULL)
		*head = newnode;
	else{
		while(current!=NULL){
			previous = current;
			if(current->data > val)
				current = current->left;
			else
				current = current->right;
		}
		if(previous->data > val)
			previous->left = newnode;
		else
			previous->right = newnode;
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

void inorder(node *head)
{
	if(head==NULL)
		return;
	inorder(head->left);
	cout<<head->data<<" ";
	inorder(head->right);
}

void preorder(node *head)
{	
	if(head==NULL)
		return;
	cout<<head->data<<" ";
	preorder(head->left);	
	preorder(head->right);	
}

void postorder(node *head)
{
	if(head==NULL)
		return;
	postorder(head->left);	
	postorder(head->right);	
	cout<<head->data<<" ";
}

int main()
{
	int i=0, dim=10;
	int arr[] = {3, 45, 22, 23, 2, 5, 34, 76, 64, 13};
	node *head = NULL;
	for(i=0; i < dim; i++)
		insert(&head, arr[i]);
	cout<<"Regular Printing of tree : ";
	printtree(head);
	cout<<endl;
	cout<<"Inorder Printing of tree : ";	
	inorder(head);
	cout<<endl;
	cout<<"Preorder Printing of tree : ";	
	preorder(head);
	cout<<endl;
	cout<<"Postorder Printing of tree : ";	
	postorder(head);
	cout<<endl;
	getchar();
	return 0;
}