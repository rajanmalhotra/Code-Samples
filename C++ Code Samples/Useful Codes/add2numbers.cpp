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

void insertAt(node** head, int val, int pos)
{
	int i=0;
	node* current = *head;
	node* new_node = createnode(val);

	if(pos==0)
	{
		new_node->next = *head;
		*head = new_node;		
		return;
	}
	else if(pos>0)
	{
		while(current->next!=NULL)
		{
			i++;
			if(i==pos)
			{
				new_node->next = current->next;
				current->next = new_node;
				return;
			}
			current = current->next;
		}
		if(current->next==NULL)
			if(i==pos-1)
				current->next = new_node;
			else
				cout<<"There is no such position currently : "<<pos<<endl;
	}
	
}

int compute_rem(int num1, int num2, int* rem)
{
	int val=0;
	val = num1 + num2 + *rem;
	if(val>=10)
	{
		*rem = 1;
		val = val-10;
	}
	else
		*rem = 0;	

	return val;
}

void addlists(node** head1, node** head2, node** head3)
{
	int pos, val ,rem;
	pos = val = rem = 0;
	node* list1 = *head1;
	node* list2 = *head2;
	
	while(list1!=NULL && list2!=NULL)
	{
		val = compute_rem(list1->data, list2->data, &rem);
		
		insertAt(head3, val, pos);		
		/* Increment pointers */
		list1 = list1->next;
		list2 = list2->next;
		
		pos++;
	}

	if(list1!=NULL && list2==NULL)
	{		
		while(list1!=NULL)
		{
			val = compute_rem(list1->data, 0, &rem);		
			insertAt(head3, val, pos);			
			list1 = list1->next;
			pos++;
		}
	}

	if(list2!=NULL && list1==NULL)
	{	
		while(list2!=NULL)
		{
			val = compute_rem(list2->data, 0, &rem);		
			insertAt(head3, val, pos);			
			list2 = list2->next;
			pos++;
		}
	}
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
	insertAt(&head1, 8, 0);
	insertAt(&head1, 9, 1);
	insertAt(&head1, 7, 2);
	insertAt(&head1, 6, 3);
	insertAt(&head1, 5, 4);
	insertAt(&head1, 4, 5);
	insertAt(&head1, 3, 6);	
	printlist(&head1);
	
	insertAt(&head2, 9, 0);
	insertAt(&head2, 2, 1);
	insertAt(&head2, 3, 2);
	insertAt(&head2, 1, 3);
	insertAt(&head2, 6, 4);
	insertAt(&head2, 5, 5);
	insertAt(&head2, 8, 6);	
	insertAt(&head2, 9, 7);	
	insertAt(&head2, 7, 8);	
	printlist(&head2);
	
	addlists(&head1, &head2, &head3);

	cout<<"List after addition :"<<endl;
	printlist(&head3);
				
	getchar();
	return 0;
}
