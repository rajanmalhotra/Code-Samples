package practice;

class Node{
	int data;
	int min;
	Node next;
	
	public Node(){
		this(0);
	}

	public Node(int data){
		this.data = data;
		this.min = 0;	
		next = null;
	}
}

public class Stack{

	Node top;

	public Stack(){
		top = null;	
	}

	public boolean push(int data){
		Node newNode = new Node(data);
		newNode.next = top;
		if(top!=null && top.min <= data){
			newNode.min = top.min;		
		}else{
			newNode.min = data;
		}
		top = newNode;
		return true;
	}

	public int pop(){
		int val = peek();
		if(val==-1){
			return -1;		
		}
		top = top.next;
		return val;
	}

	public int peek(){
		if(top==null){
			return -1;		
		}
		return top.data;	
	}
	
	public void moveTop(Stack src, Stack dest){
		int val = src.pop();
		dest.push(val);
/*		System.out.println(moves + " : Pushing disk from " + 
					(src.top!=null? src.top.data : null) + " to " + 
					(dest.top!=null? dest.top.data : null));
*/		return;	
	}

	private static int moves = 0;
	public void moveDisks(int n, Stack source, Stack buffer, Stack destination){
		if(n==0){
			return;		
		}
		moves++;
		printTowers(source, buffer, destination);
		moveDisks(n-1, source, destination, buffer);
		moveTop(source, destination);
		moveDisks(n-1, buffer, source, destination);
	}

	public void printStack(){
		Node temp = top;		
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;		
		}
		System.out.println();
	}

	public void printTowers(Stack A, Stack B, Stack C){
		System.out.print("A : "); A.printStack();
		System.out.println();
		System.out.print("B : "); B.printStack();
		System.out.println();
		System.out.print("C : "); C.printStack();	
		System.out.println();
	}

	public static void main(String[] args){
		Stack s = new Stack();
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		for(int val : arr){
			s.push(val);
		}
		System.out.println("Popped Item is : " + s.pop());
		System.out.println("Popped Item is : " + s.pop());
		System.out.println("Popped Item is : " + s.pop());
		System.out.println("Popped Item is : " + s.pop());

		/* Tower of Hanoi */
		Stack A_towerOfHanoi = new Stack();
		int arr1[] = {4, 3, 2, 1};
		for(int val: arr1){	
			A_towerOfHanoi.push(val);
		}
		Stack B_towerOfHanoi = new Stack();
		Stack C_towerOfHanoi = new Stack();
		System.out.println("Printing Towers from A to C");
		System.out.println("Moving Disks from A to C");
		A_towerOfHanoi.moveDisks(4, A_towerOfHanoi, B_towerOfHanoi, C_towerOfHanoi);
		A_towerOfHanoi.printTowers(A_towerOfHanoi, B_towerOfHanoi, C_towerOfHanoi);
		System.out.println("Total Moves taken : " + moves);
	}
}
