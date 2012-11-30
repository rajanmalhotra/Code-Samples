#include <iostream>

using namespace std;

typedef struct node
{
	int data;
	node* next;
}node;

node* createnode(int val)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->data = val;
	new_node->next = NULL;
	return new_node;
}

void printlist(node** head)
{
	int i =0;
	/* print the list */
	node* current = NULL;
	current = *head;
	while(current!=NULL)
	{
		cout<<current->data<<" ";
		current = current->next;
		i++;
		if(i==80)
			break;
	}
	cout<<endl;
}

void insert(node** head, int val)
{
	int i=0;
	node* current = *head;
	node* new_node = createnode(val);

	if(*head == NULL){		
		*head = new_node;		
		return;
	}
	else{
		while(current->next!=NULL)
			current = current->next;
		current->next = new_node;
	}
}

node* add2numbers(node *head1, node *head2, int rem)
{
	if(head1==NULL && head2==NULL)
	{		
		if(rem){
			node *new_node = createnode(rem);
			return new_node;
		}
		return NULL;
	}

	int val = rem;
	rem = 0;

	if(head1 != NULL)
		val += head1->data;		
	if(head2 != NULL)
		val += head2->data;
	if(val >= 10){
		val = val-10;
		rem = 1;
	}
	
	node *new_node = createnode(val);
	new_node->data = val;
	new_node->next = add2numbers(head1==NULL? NULL : head1->next,
								head2==NULL? NULL : head2->next, rem);
	return new_node;
}

int main()
{
	bool flag = true;
	int len = 12;
	node* head1 = NULL;
	node* head2 = NULL;
	node* head3 = NULL;
	//int arr[] = {51, 8, 1, 20, 41, 65, 7, 14, 36, 23, 50, 12};
	
	/* Insert */
	insert(&head1, 8);
	insert(&head1, 9);
	insert(&head1, 7);
	insert(&head1, 6);
	insert(&head1, 5);
	insert(&head1, 4);
	insert(&head1, 3);	
	printlist(&head1);
	
	insert(&head2, 9);
	insert(&head2, 2);
	insert(&head2, 3);
	insert(&head2, 1);
	insert(&head2, 6);
	insert(&head2, 5);
	insert(&head2, 8);	
	//insert(&head2, 9);	
	//insert(&head2, 7);	
	printlist(&head2);
	
	head3 = add2numbers(head1, head2, 0);

	cout<<"List after addition :"<<endl;
	printlist(&head3);
				
	getchar();
	return 0;
}
