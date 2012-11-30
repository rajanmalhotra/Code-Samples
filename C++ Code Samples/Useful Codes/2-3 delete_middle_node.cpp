#include <iostream>

using namespace std;

typedef struct node{
	int data;
	node *next;
}node;

node* newnode(int val)
{
	node *new_node = (node*)malloc(sizeof(node));
	new_node->data = val;
	new_node->next = NULL;
	return new_node;
}

void insert(node **head, int val)
{
	node *current = *head;
	node *new_node = newnode(val);

	if(*head == NULL)
		*head = new_node;
	else{
		
		/* start */
		if(current->data > val){
			new_node->next = current;
			*head = new_node;
			return;
		}
		
		/* middle */
		while(current->next != NULL){
			if(current->next->data > val){
				new_node->next = current->next;
				current->next = new_node;
				return;
			}
			current = current->next;
		}
		
		/* last */
		current->next = new_node;
	}
}

void find(node **head, node **node_to_delete, int val)
{
	int i=0;
	node *current = *head;
	while(current!=NULL){
		if(current->data == val){
			*node_to_delete = current;
			return;
		}
		current = current->next;
	}
	cout<<endl<<"Element not found."<<endl;
}

void delete_node(node **node_to_delete)
{
	node *current = *node_to_delete;
	node *temp = NULL;
	current->data = current->next->data;
	temp = current->next;
	current->next = current->next->next;
	cout<<"Element deleted"<<endl;
	free(temp);	
}

void printlist(node **head)
{
	/* print the list */
	node* current = NULL;
	current = *head;
	cout<<"List is : ";
	while(current!=NULL)
	{
		cout<<current->data<<" ";
		current = current->next;
	}
	cout<<endl;
}

int main()
{	
	int i, dim = 10;
	//node *head = NULL;
	node *node_to_delete = NULL;
	int arr[] = {54, 32, 77, 3, 63, 21, 75, 33, 22, 11};
	for(i=0; i < dim; i++)
		insert(&head, arr[i]);
	printlist(&head);
	find(&head, &node_to_delete, arr[5]);
	if(node_to_delete!=NULL){
		cout<<"Value to delete is : "<<node_to_delete->data<<endl;
		delete_node(&node_to_delete);
	}
	printlist(&head);
	getchar();
	return 0;

}