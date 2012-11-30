package com.rajan.geeksforgeeks.linkedlists;

/* 
 * Problem 1:
 * Reverse a Given Linked List
 */

public class Reverser extends LinkedList<Integer>{
	
	public void reverse(){
		Node<Integer> current = head;
		Node<Integer> previous = null;
		Node<Integer> next;

		if(current==null){
			return;
		}

		while(current!=null){			
			next = current.next;		
			current.next = previous;	
			previous = current;			
			current = next;
		}
		head = previous;
	}

	private void reverseRecursively(Node<Integer> current, Node<Integer> previous){
		if(current==null){
			head = previous;
			return;		
		}

		Node<Integer> next = current.next;
		current.next = previous;
		previous = current;
		current = next;
		reverseRecursively(current, previous);
		return;
	}

	public void reverseRecursively(){
		reverseRecursively(head, null);
	}
	
	public static void main(String[] args){
		Reverser r = new Reverser();
		int arr[] = {4, 19, 22, 14, 58, 43, 32};
		for(int val : arr){
			r.append(val);		
		}
		r.print();
		r.reverse();
		r.print();
		r.reverseRecursively();
		r.print();
	}
}
