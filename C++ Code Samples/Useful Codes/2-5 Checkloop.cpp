#include <iostream>

using namespace std;

typedef struct node
{
	int data;
	node* next;
}node;

node* head=NULL;

node* createnode(int val)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->data = val;
	new_node->next = NULL;
	return new_node;
}

void printlist()
{
	int i =0;
	/* print the list */
	node* current = NULL;
	current = head;
	while(current!=NULL)
	{
		cout<<current->data<<" ";
		current = current->next;
		i++;
		if(i==40)
			break;
	}
	cout<<endl;
}

void insertAt(int val, int pos)
{
	int i=0;
	node* current = head;
	node* new_node = createnode(val);

	if(pos==0)
	{
		new_node->next = head;
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

void formloop(int pos)
{
	int i=0;
	node* current = head;
	node* temp = NULL;
	while(i<pos)
	{	
		if(current->next!=NULL)
			current=current->next;
		else
		{
			cout<<"Loop cannot be formed : incorrect position"<<endl;
			exit(0);
		}
		i++;
	}
	temp = current;
	while(current->next!=NULL)
		current = current->next;
	current->next = temp;
}

void detectloop(node* slow, node* fast)
{
	int i=0, loop;
	node* itr1 = head;
	node* itr2 = head;
	
	/* find the loop length */
	slow = slow->next;
	loop = 1;
	while(slow!=fast)
	{
		slow=slow->next;
		loop++;
	}
	cout<<"Loop length : "<<loop<<endl;
	
	/* itr1 reaches the loop steps ahead and then itr2 starts */
	while(i<loop)
	{
		itr1 = itr1->next;
		i++;
	}

	/* itr2 starts now and meets itr1 at the start of the loop */
	i = 0;
	while(itr1!=itr2)
	{
		i++;
		itr1 = itr1->next;
		itr2 = itr2->next;
	}

	cout<<"The value where the loop starts is : "<<itr1->data<<endl;
	cout<<"The index where the loop starts is : "<<i<<endl;
}

bool checkloop()
{
	int steps =0;
	node* slow = head;
	node* fast = head;
	
	while(slow!=NULL && fast!=NULL)
	{
		steps++;
		slow = slow->next;
		//Sometimes, fast can be NULL in no loop. Check it.
		fast = fast->next->next;	
		if(slow==fast)
		{
			cout<<"-----> Loop Exists in the list"<<endl;
			cout<<"No of steps : "<<steps<<endl;			
			detectloop(slow, fast);
			return true;
		}
	}	
	return false;
}

int main()
{
	bool flag = true;
	int i, len = 12;
	int arr[] = {51, 8, 1, 20, 41, 65, 7, 14, 36, 23, 50, 12};
	
	/* Insert */
	for(i=0; i<len; i++)
		insertAt(arr[i],i);
	insertAt(34, 7);
	insertAt(49, 5);
	insertAt(67, 0);
	insertAt(829, 8);
	insertAt(73, 7);
	insertAt(99, 13);
	insertAt(324, 12);
	insertAt(543, 18);

	cout<<"List after insertions :"<<endl;
	printlist();
	
	/* To form a loop, give the index of the postion */
	cout<<"Forming a loop in the list now"<<endl;
	formloop(10);
	printlist();
	cout<<"Checking loop now......"<<endl;
	if(!checkloop())
		cout<<"-----> Sorry No loop in the list"<<endl;
			
	getchar();
	return 0;
}