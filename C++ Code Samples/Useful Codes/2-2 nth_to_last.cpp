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
		if(current->data > val)
		{
			new_node->next = current;
			*head = new_node;
			return;
		}

		/* middle */
		while(current->next!=NULL)
		{
			if(current->next->data > val)
			{
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

void nth_to_last(node **head, int n_last)
{
	node *current = *head;
	node *nth_last = NULL;
	int i=0;
	while(i <= n_last){
		current = current->next;
		i++;
	}
	
	nth_last = *head;
	while(current!=NULL){
		nth_last = nth_last->next;
		current = current->next;
	}

	cout<<"Nth last element is : "<<nth_last->data<<endl;

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
	node *head = NULL;
	node *current = NULL;
	int arr[] = {54, 32, 77, 3, 63, 21, 75, 33, 22, 11};
	for(i=0; i < dim; i++)
		insert(&head, arr[i]);
	printlist(&head);
	nth_to_last(&head, 3);	
	getchar();
	return 0;

}