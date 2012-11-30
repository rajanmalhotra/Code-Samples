/*
Given 2 linked lists sorted in ascending order, write a function that will merge these lists into a single sorted list without copying the list contents. You can assume a node structure of the form:
 
struct Node {
	int value;
	Node *next;
};
*/

#include<iostream>

using namespace std;

struct Node {
	int value;
	Node *next;
};

class LinkedList{
	private:
	Node* head;
	Node* createNewNode(int val);

	public:
	LinkedList();
	Node* getHead();
	void append(int val);
	void printList();
	void mergeList(Node* second);
};

LinkedList::LinkedList(){
	head = NULL;
}

/* creates new Node */
Node* LinkedList::createNewNode(int val){
	Node *newNode = new Node();
	newNode->value = val;
	newNode->next = NULL;
	return newNode;
}

/* retrieves the pointer to the start of the list */
Node* LinkedList::getHead(){
	Node* ptr = head;	
	return ptr;
}

/* insert element to the list in sorted manner */
void LinkedList::append(int val){
	Node *newNode = createNewNode(val);
	Node *current = head;
	
	if(head == NULL)
		head = newNode;
	else{
		/* at start */
		if(current->value > val){
			newNode->next = current;
			head = newNode;
			return;
		}
		
		/* in middle */
		while(current->next!=NULL){
			if(current->next->value > val){
				newNode->next = current->next;
				current->next = newNode;
				return;
			}
			current = current->next;
		}
		
		/* at last */
		current->next = newNode;
	}
}

/* print the list */
void LinkedList::printList()
{
	Node* current = NULL;
	current = head;
	cout<<"List is : ";
	while(current!=NULL)
	{
		cout<<current->value<<" ";
		current = current->next;
	}
	cout<<endl;
}

/* Merging of second list into the first */
void LinkedList::mergeList(Node* second){
	Node* tempFirst = head;
	Node* tempSecond = second;
	Node* current = NULL;

	if(second==NULL){
		return;
	}
	if(head==NULL){
		head = second;
		return;	
	}
	head = NULL;

	while(tempFirst!=NULL && tempSecond!=NULL){
		if(tempFirst->value < tempSecond->value){
			if(head==NULL){
				head = tempFirst;
				current = head;
			}else{
				current->next = tempFirst;
				current = current->next;
			}
			tempFirst = tempFirst->next;
			current->next = NULL;
		}else{
			if(head==NULL){
				head = tempSecond;
				current = head;
			}else{
				current->next = tempSecond;
				current = current->next;
			}
			tempSecond = tempSecond->next;
			current->next = NULL;
		}
	}

	if(tempSecond==NULL){
		current->next = tempFirst;
	}
	if(tempFirst==NULL){
		current->next = tempSecond;
	}
}

/* main function */
int main(int argc, char** argv){
	LinkedList* firstList = new LinkedList();
	LinkedList* secondList = new LinkedList();
	int first[] = {8, 10, 32, 45, 60};
	int second[] = {4, 14, 29, 33, 39, 47};
	int lenFirst = sizeof(first)/sizeof(int);
	int lenSecond = sizeof(second)/sizeof(int);

	/* creates the lists by appending elements */
	if(lenFirst > 0){ 	
		for(int i=0; i < lenFirst; i++){
			firstList->append(first[i]);
		}
	}
	if(lenSecond > 0){
		for(int i=0; i < lenSecond; i++){
			secondList->append(second[i]);
		}
	}

	/* prints the lists */
	cout << "First  ";
	firstList->printList();
	cout << "Second ";
	secondList->printList();

	/* merges the second list into first */
	firstList->mergeList(secondList->getHead());
	cout << "Merged ";
	firstList->printList();
	delete firstList;
	delete secondList;
	return 0;
}
