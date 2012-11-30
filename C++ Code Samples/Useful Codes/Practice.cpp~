#include <iostream>

using namespace std;

typedef struct Node
{
	int data;
	Node *next;
}Node;

Node *createnode(int val)
{
	Node *newnode = (Node*)(malloc(sizeof(Node)));
	newnode->data = val;
	newnode->next = NULL;
	return newnode;
}

class Stack
{
public:
	Node *top;
	int pop(){
		if(top!=NULL){
			int item = top->data;
			top = top->next;
			return item;
		}
		return NULL;
	}

	void push(int val){
		Node *newnode = createnode(val);
		newnode->next = top;
		top = newnode;
	}
};

class Queue
{
public:
	Node *first;
	Node *last;
	
	Queue(){
		first = NULL;
		last = NULL;
	}

	void enqueue(int val){
		Node *newnode = createnode(val);
		if(!first){
			first = newnode;
			last = newnode;
		}
		else{		
			last->next = newnode;
			last = newnode;
		}
	}

	int dequeue(){
		int item;
		if(first!=NULL){
			item = first->data;
			first = first->next;
			return item;
		}
	}

	bool isEmpty(){
		if(first==NULL)
			return true;
		else
			return false;
	}
};

void printlist(Node **head, int dim){
	Node *current = *head;
	cout<<"List is : ";
	for(int i=0; i < dim; i++){
		cout<<current->data<<" ";
		current = current->next;
	}
	cout<<endl;
}
int main()
{
	int i=0, dim=10;
	int arr[] = {3, 45, 22, 23, 2, 5, 34, 76, 64, 13};
	
	Stack *stk = new Stack();
	cout<<"STACK"<<endl;
	for(i=0; i < dim; i++)
	{
		stk->push(arr[i]);
	}
	printlist(&stk->top, 10);

	Queue *queue = new Queue();
	cout<<"QUEUE"<<endl;
	for(i=0; i < dim; i++)
	{
		queue->enqueue(arr[i]);
	}
	printlist(&queue->first, 10);

	getchar();
	return 0;
}
