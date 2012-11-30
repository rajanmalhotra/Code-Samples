/*
How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
Push, pop and min should all operate in O(1) time.
*/

#include <iostream>
#include <stack>

using namespace std;

typedef struct node{
	int val;
	int min;
	node *next;
}node;

node *createnode(int val, int min){
	node *newnode = (node*)(malloc(sizeof(node)));
	newnode->val = val;
	newnode->min = min;
	newnode->next = NULL;
	return newnode;
}

class StackWithMin{
public:	
	node *top;
	void push(int val){
		int _min = min();
		if(val < _min)
			_min = val;
		node *newnode = createnode(val, _min);
		newnode->next = top;
		top = newnode;
	}

	int pop(){
		int item = top->val;
		top = top->next;
		return item;
	}

	node *peek(){
		if(top==NULL)
			return NULL;
		else 
			return top;
	}

	int min(){
		if(peek())
			return peek()->min;
		return 10000;
	}
};

void printstack(node *top){
	node *current = top;
	while(current!=NULL){
		cout<<"( val: "<<current->val<<" min: "<<current->min<<") "<<endl;
		current = current->next;
	}
}

int main(){
	StackWithMin *mystack = new StackWithMin();
	int arr[] = {34, 13, 90, 43, 32, 46, 64, 23, 12, 10, 7};
	int dim = 11;
	for(int i =0; i < dim;  i++)
		mystack->push(arr[i]);
	printstack(mystack->top);
	//printstack(mystack->top);
	getchar();
	return 0;
}