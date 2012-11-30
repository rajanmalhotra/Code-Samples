#include <iostream>
#include <map>

using namespace std;

typedef struct node{
	char data;
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
		
		/* in middle */
		while(current->next!=NULL)
			current = current->next;
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

void remove_duplicates(node **head)
{
	node *current = *head;
	map<char, int> mymap;
	char letter;
	node *temp;
	mymap[current->data] = 1;

	while(current->next!=NULL)
	{
		letter = current->next->data;
		if(mymap.count(letter)==0){
			mymap[letter] = 1;			
			current = current->next;
		}
		else{
			temp = current->next;
			current->next = current->next->next;
			free(temp);
		}
	}
}

void remove_duplicates_nospace(node **head)
{
	int i=0;
	node *current = *head;
	node *ptr = *head;
	node *temp;
	
	while(current->next!=NULL){
		ptr = *head;
		while(ptr!=current->next){
			if(current->next->data == ptr->data)
			{
				temp = current->next;
				current->next = current->next->next;
				free(temp);
				break;
			}
			ptr = ptr->next;
		}
		if(ptr==current->next)
			current = current->next;		
	}
}

int main()
{
	int i=0, dim = 26;
	node *head = NULL;
	node *head2 = NULL;
	node *current = NULL;
	char arr[] = {'M', 'o', 'h', 'a','n','d','a','s',' ','K','a','r','a','m',
						'c','h','a','n','d',' ', 'G','a','n','d','h','i'};
	for(i=0; i < dim; i++)
	{
		insert(&head, arr[i]);
		insert(&head2, arr[i]);
	}
	printlist(&head);
	remove_duplicates(&head);
	remove_duplicates_nospace(&head2);
	printlist(&head);
	printlist(&head2);
	getchar();
	return 0;
}