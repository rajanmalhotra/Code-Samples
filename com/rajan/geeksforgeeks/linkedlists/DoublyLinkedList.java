package com.rajan.geeksforgeeks.linkedlists;

public class DoublyLinkedList<T> {

	protected DoublyLinkedNode<T> head;
	private static int nodesCount=0;
	
	public DoublyLinkedList(){
		head = null;
	}
	
	public DoublyLinkedList(DoublyLinkedNode<T> val){
		head = null;
	}
	
	public void append(T data){
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(data);
		DoublyLinkedNode<T> current = head;
		
		/* insert at beginning */
		if(current==null){
			head = newNode;
			return;
		}

		/* insert at the end */
		while(current.next!=null){
			current = current.next;		
		}

		current.next = newNode;
		newNode.previous = current;
		return;
	}
	
	public void print(){
		DoublyLinkedNode<T> n = head;
		System.out.println("The List is : ");
		while(n!=null){				
			System.out.print(n.data);			
			n = n.next;
			if(n!=null){			
				System.out.print(" <-> ");
			}
		}
		System.out.println();			
	}
	
	private void countNodesAsBST(DoublyLinkedNode<T> head){
		if(head==null){
			return;
		}					
		nodesCount++;
		countNodesAsBST(head.previous);
		countNodesAsBST(head.next);	
	}
	
	private void printAsBST(DoublyLinkedNode<T> head){
		if(head==null){
			return;
		}
		System.out.println(head.data);		
		printAsBST(head.previous);
		printAsBST(head.next);			
	}
	
	public void printAsBST(){
		System.out.println("The Tree is : ");
		countNodesAsBST(head);
		printAsBST(head);
	}
}
