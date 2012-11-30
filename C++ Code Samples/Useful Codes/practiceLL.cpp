#include <iostream>

using namespace std;

class Node{
	Node::Node next = NULL;
	int data;
public:
	public Node::Node(int d)
	{
		data = d;
	}

	void Node::appendToTail(int d)
	{
		Node end = new Node(d);
		Node n = this;
		while(n.next != NULL){ 
			n = n.next; 
		}
		n.next = end;
	}

};

typedef struct node{
	int data;
	node *next;
}node;

node* newnode(int val)
{
	node *newnode = (node*)(malloc(sizeof(node)));
	newnode->data = val;
	newnode->next = NULL;
	return newnode;
}

void insert(node **head, int val)
{
	node *new_node = NULL;
	node *current = *head;
	new_node = newnode(val);
	
	if(*head == NULL)
		*head = new_node;
	else{
		/* at start */
		if(current->data > val){
			new_node->next = current;
			*head = new_node;
			return;
		}
		
		/* in middle */
		while(current->next!=NULL){
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

void delete_node(node **head, int val)
{
	node *current = *head;
	node *temp = current;
	if(current->data == val)
		*head = current->next;
	else{
		while(current->next!=NULL){
			if(current->next->data == val){
				temp = current->next;
				current->next = current->next->next;
				temp->next = NULL;
				free(current->next);
				break;
			}
			current = current->next;
		}
		if(current->next == NULL)
		{
			cout<<"The value is not present in the list."<<endl;
			return;
		}
	}
	free(temp);
}

int main()
{
	int i=0, dim = 10;
	node *head = NULL;
	node *current = NULL;
	int arr[] = {54, 32, 77, 3, 63, 21, 75, 33, 22, 11};
	for(i=0; i < dim; i++)
		insert(&head, arr[i]);
	printlist(&head);
	delete_node(&head, arr[7]);
	delete_node(&head, arr[3]);
	delete_node(&head, 20);
	printlist(&head);
	getchar();
	return 0;
}
