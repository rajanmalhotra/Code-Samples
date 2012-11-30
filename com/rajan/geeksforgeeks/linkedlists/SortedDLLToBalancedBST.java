package com.rajan.geeksforgeeks.linkedlists;

/*
 * Problem 3:
 * In-place conversion of Sorted DLL to Balanced BST
 * Given a Doubly Linked List which has data members sorted in ascending order. 
 * Construct a Balanced Binary Search Tree which has same data members as the given Doubly Linked List.
 * The tree must be constructed in-place (No new DoublyLinkedNode should be allocated for tree conversion)
 */

public class SortedDLLToBalancedBST extends DoublyLinkedList<Integer> {
	
	private DoublyLinkedNode<Integer> formBalancedBST(DoublyLinkedNode<Integer> head, int len){
		if(len==0){
			return null;
		} else if(len==1){
			head.next = null;
			head.previous = null;
		}

		int i=1;
		DoublyLinkedNode<Integer> current = head;
		while(i <= len/2){
			current = current.next;
			i++;
		}
		
		current.previous = formBalancedBST(head, i-1);
		current.next = formBalancedBST(current.next, len-i);
		return current;
	}

	public void formBalancedBST(){
		DoublyLinkedNode<Integer> current = head;
		int len=0;
		while(current!=null){
			current = current.next;		
			len++;
		}
		head = formBalancedBST(head, len);
	}
	
	public static void main(String[] args){
		SortedDLLToBalancedBST ll = new SortedDLLToBalancedBST();
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		for(int val : arr){
			ll.append(val);
		}
		ll.print();
		ll.formBalancedBST();
		ll.printAsBST();
	}
}
