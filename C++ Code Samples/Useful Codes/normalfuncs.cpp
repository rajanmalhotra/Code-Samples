#include <iostream>

using namespace std;

typedef struct node
{
	int data;
	node* next;
}node;

node* head = NULL;

node* createnode(int val)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->data = val;
	new_node->next = NULL;
	return new_node;
}

void insert(int val)
{
	node* current=NULL;
	node* new_node = createnode(val);
	if(head==NULL)
		head = new_node;
	else
	{
		current = head;		
		
		/* Add to the start */
		if(current->data > val)
		{
			new_node->next = current;
			head = new_node;
			return;
		}

		/* Add in the middle of the list */
		while(current->next!=NULL)
		{
			if(new_node->data > current->next->data)
				current = current->next;
			else
			{
				new_node->next = current->next;
				current->next = new_node;
				break;
			}
		}

		/* Add to the end of the list */
		if(current->next==NULL)		
		{
			current->next = new_node;		
		}
	}	
}

void printlist()
{
	/* print the list */
	node* current = NULL;
	current = head;
	while(current!=NULL)
	{
		cout<<current->data<<" ";
		current = current->next;
	}
	cout<<endl;
}

void delete_node(int val)
{
	node* current = head;
	node* temp = NULL;
	if(current->data == val)
	{
		head = current->next;
		free(current);	
		return;
	}

	while(current->next!=NULL)
	{	
		if(current->next->data == val)
		{
			temp = current->next;			
			current->next = current->next->next;			
			free(temp);
			return;
		}
		current = current->next;
	}
	cout<<"Value to be deleted is not in the list"<<endl;
}

void insertAt(int val, int pos)
{
	/* insertion is on the basis of index */
	int i=0;
	node* current = head;
	node* new_node = createnode(val);
	
	if(pos == 0)
	{
		new_node->next = head->next;
		head = new_node;		
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

int main()
{
	int i, len = 13;
	int arr[] = {51, 8, 32, 1, 20, 41, 65, 42, 7, 8, 14, 36, 6};
	
	/* Insert */
	for(i=0; i<len; i++)
		insert(arr[i]);
	cout<<"List after insertions :"<<endl;
	printlist();

	/* deletion from the list */
	delete_node(arr[3]);
	delete_node(arr[5]);
	delete_node(arr[8]);
	delete_node(arr[10]);
	delete_node(arr[9]);
	delete_node(arr[9]);
	cout<<"List after deletions :"<<endl;
	printlist();

	cout<<"List after insert at positions :"<<endl;

	insertAt(34, 7);
	insertAt(49, 5);
	insertAt(67, 0);
	insertAt(829, 8);
	insertAt(73, 7);
	insertAt(99, 13);
	printlist();

	getchar();
	return 0;
}