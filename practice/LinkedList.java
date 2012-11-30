package practice;

class Node{
	int data;
	Node next;
	
	public Node(){
		this(0);
	}

	public Node(int data){
		this.data = data;	
		next = null;
	}
}

public class LinkedList{

	Node head;

	public LinkedList(){
		head = null;
	}

	public void insert(int data){
		Node newNode = new Node(data);
		if(head==null){
			head = newNode;	
		}else{
			newNode.next = head;
			head = newNode;		
		}
	}

	public void append(int data){
		Node newNode = new Node(data);
		if(head==null){
			head = newNode;		
		}else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;			
			}
			temp.next = newNode;
		}
	}

	public void remove(int val){
		Node temp = head;
		Node prev = head;
		while(temp!=null && temp.data!=val){
	 		prev = temp;
			temp = temp.next;
		}
		if(temp==null){
			System.out.println("Not found");
 		}else{
			prev.next = temp.next;		
			System.out.println("Removed");
		}
	}

	public void removeDuplicates(){
		Node current = head;
		Node previous = head;
		Node runner;
		while(current!=null){
			runner = head;
			while(runner!=current){
				if(runner.data==current.data){
					previous.next = current.next;
					current = current.next;
					break;
				}
				runner = runner.next;	
			}
			if(runner==current){
				previous = current;
				current = current.next;		
			}
		}		
	}

	public void print(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;		
		}
		System.out.println();	
	}

	public void print(){
		print(this.head);
	}

	public Node addLists(Node first, Node second, int carry){
		int val = carry;
		if(first!=null){
			val += first.data;
		}
		if(second!=null){
			val += second.data;		
		}

		if(val > 9){
			carry = 1;
			val = val % 10;
		}else{
			carry = 0;		
		}
		Node result = new Node();
		result.data = val;

		if(first!=null || second!=null || carry>0){
			result.next = addLists(first!=null? first.next : null, 
						   second!=null? second.next : null,
						   carry);
		}
		return result;
	}

	public Node detectAndFindLoop(Node head){
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast){
				break;			
			}
		}

		if(slow==fast){
			slow = head;
			while(slow!=fast){
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}else{
			System.out.println("List does not contain a loop");
			return null;
		}				
	}

	public void createLoop(Node head, int val){	
		Node temp = head;
		Node end = head;
		while(temp.data!=val){
			temp = temp.next;
		}

		while(end.next!=null){
			end = end.next;
		}
		end.next = temp;

		System.out.println("Loop created in the list at : " + temp.data);
	}

	public static void main(String[] args){
		LinkedList l = new LinkedList();
		int[] arr = {1, 2, 3, 3, 3, 4, 3, 6, 2, 4, 9, 0};
		for(int val : arr){
			l.insert(val);		
		}
		l.append(11);
		l.append(12);
		l.remove(8);
		l.remove(7);
		l.remove(10);
		l.remove(12);
		l.print();

		/* Problem 2-1 */
		l.removeDuplicates();
		System.out.println("After removing duplicates");
		l.print();

		LinkedList first = new LinkedList();
		first.insert(5);
		first.append(9);
		first.append(5);
		LinkedList second = new LinkedList();
		second.insert(5);
		second.append(9);
		second.append(5);
		Node result = l.addLists(first.head, second.head, 0);
		System.out.println("Result of adding 2 lists");
		l.print(result);

		System.out.println();
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		LinkedList ll = new LinkedList();
		for(int val:arr1){
			ll.append(val);		
		}
		ll.print();
		ll.createLoop(ll.head, 4);
		System.out.println("Detected a loop in the list at : " + (ll.detectAndFindLoop(ll.head)).data);
	}
}
