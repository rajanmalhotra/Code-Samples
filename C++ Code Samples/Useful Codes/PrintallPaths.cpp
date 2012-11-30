//Print all Root to Leaf Paths

#include <iostream>
#include <vector>

using namespace std;

struct node{
	int data;
	node* left;
	node* right;
};

class BinarySearchTree{
private:
	node *root;
	node *newnode(int);
	void printtree(node*);
	void printallpaths(node*, vector<int>);
	void haspathSum(node*, vector<int>, int, int);

public:
	BinarySearchTree();
        bool isEmpty();
        void printtree();
	void insert(int);
	void remove(int);
	void printallpaths();
	void haspathSum(int);
};

BinarySearchTree::BinarySearchTree(){
	root = NULL;
}

bool BinarySearchTree::isEmpty(){
	return root==NULL;
}

node* BinarySearchTree::newnode(int val){
	node* new_node = new node;
	new_node->data = val;
	new_node->left = NULL;
	new_node->right = NULL;
	return new_node;
}

void BinarySearchTree::insert(int val){
	node* new_node = newnode(val);

	node* current = root;
	node* previous = root;
	
	if(isEmpty())
		root = new_node;
	else{
		while(current){
			previous = current;
			if(new_node->data < current->data)
				current = current->left;
			else
				current = current->right;
		}

		if(new_node->data < previous->data)
			previous->left = new_node;
		else	
			previous->right = new_node;
	}
}

void BinarySearchTree::remove(int val){
	bool found = false;
	
	if(isEmpty()){
		cout<<"The tree is empty. Nothing to delete\n";
		return;
	}

	node* current = root;
	node* previous = NULL;	
	while(current){
		if(current->data == val){
			cout<<"Element found\n";
			found = true;
			break;
		}
		else{
			previous = current;
			if(val < current->data)
				current = current->left;
			else if(val > current->data)
				current = current->right;
		}		
	}
	if(!found){
		cout<<"Data not found\n";
		return;
	}

	/* Three cases :
	1. we're removing a node with 2 children
	2. We're removing a node with a single child
	3. We're removing a leaf node */

	/* Node with two children nodes */
	if(current->left && current->right){
		previous = current;
		node *succ = current->right;
				
		while(succ->left!=NULL){
			previous = succ;
			succ = succ->left;
		}
		
		current->data = succ->data;
		current = succ;
	}

	/* Node with no children nodes */
	if(current->left == NULL && current->right == NULL){
		if(previous==NULL)
			root = NULL;
		else{
			if(previous->left == current)
				previous->left = NULL;
			else
				previous->right = NULL;
		}
		delete current;
		return;
	}

	/* Node with single child */
	if(current->left && !current->right || !current->left  && current->right){
		/* scenario if root getting deleted */

		if(current->left){
			if(previous==NULL){
				root = current->left;
				delete current;
				return;
			}

			if(previous->left == current)
				previous->left = current->left;				
			else
				previous->right = current->left;
		}
		else{
			if(previous==NULL){
				root = current->right;
				delete current;
				return;
			}

			if(previous->left == current)
				previous->left = current->right;				
			else
				previous->right = current->right;
		}
		delete current;
	}
}

void BinarySearchTree::printtree(node* node){
	if(!node)
		return;
	cout<<node->data<<" ";
	printtree(node->left);
	printtree(node->right);
}

void BinarySearchTree::printtree(){
	cout<<"Tree is : ";
	if(isEmpty())
		return;
	printtree(root);
	cout<<endl;
}

void BinarySearchTree::haspathSum(node* current, vector<int> path, int sum, int N){
	
	if(current==NULL)
		return;
	
	path.push_back(current->data);
	sum += current->data;
	
	if(current->left==NULL && current->right==NULL){
	
		if(sum==N){
			/* print the path */
			cout<<"Path : ";
			for(int i=0; i < path.size(); i++){
				cout<<path.at(i)<<" ";
			}
			cout<<endl;
			return;
		}
	}
	
	
	haspathSum(current->left, path, sum, N);
	haspathSum(current->right, path, sum, N);		
}

void BinarySearchTree::haspathSum(int N){
	vector<int> path;
	haspathSum(root, path, 0, N);
}

void BinarySearchTree::printallpaths(node* current, vector<int> path){
	if(current==NULL)
		return;
	
	path.push_back(current->data);
	if(current->left==NULL && current->right==NULL){
		/* print the path */
		cout<<"Path : ";
		for(int i=0; i < path.size(); i++){
			cout<<path.at(i)<<" ";
		}
		cout<<endl;
		return;
	}
	
	printallpaths(current->left, path);
	printallpaths(current->right, path);
}

void BinarySearchTree::printallpaths(){
	vector<int> path;
	printallpaths(root, path);
}


void BinarySearchTree::findsum(node* current, int sum, vector<int> buffer, int level)
{
  if(current == NULL)
    return;
  int tmp = sum;
  buffer.push_back(current->data);

  for(int i = level; i > -1; i--){
    tmp -= buffer.at(i);
    if(tmp==0)
      print(buffer, i, level);
  }
  
  vector<int> c1;
  c1.insert(c1.end(), buffer.begin(), buffer.end());
  vector<int> c2;
  c2.insert(c2.end(), buffer.begin(), buffer.end());
  
  findSum(current->left, sum, c1, level+1);
  findSum(current->right, sum, c2, level+1);
    
}

int main(){
	int arr[] = {56, 45, 75, 23, 34, 67, 89, 60, 90, 92, 20, 41};
	int dim = 12;
	BinarySearchTree bt;
	for(int i=0; i < dim; i++)
		bt.insert(arr[i]);
	bt.printtree();
	bt.printallpaths();
	cout<<"Paths with Sum 199 =";
	bt.haspathSum(199);
	for(int i=0; i < dim; i++){
		bt.remove(arr[i]);
		if(!bt.isEmpty());
			bt.printtree();
	}	
	return 0;
}
