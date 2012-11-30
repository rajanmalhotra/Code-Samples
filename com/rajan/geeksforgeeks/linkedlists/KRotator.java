package com.rajan.geeksforgeeks.linkedlists;

/*
 * Problem 2:
 * Rotate a LinkedList
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes,
 * Where k is a given positive integer. For example, if the given linked list is 
 * 10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40. 
 * Assume that k is smaller than the count of nodes in linked list.
 */

public class KRotator extends LinkedList<Integer>{
	public void rotateByK(int k){

		Node<Integer> current = head;
		Node<Integer> ptrK = head;
		Node<Integer> previous = head;

		while(k!=0 && ptrK!=null){
			previous = ptrK;			
			ptrK = ptrK.next;
			k--;
		}

		if(ptrK==null){
			return;
		}
		previous.next = null;
		previous = ptrK;

		while(ptrK.next!=null){
			ptrK = ptrK.next;		
		}
		ptrK.next = current;
		head = previous;		
	}
	
	public static void main(String[] args){
		KRotator k = new KRotator();
		int arr[] = {10, 20, 30, 40, 50, 60};
		for(int val : arr){
			k.append(val);
		}
		k.print();
		k.rotateByK(4);
		k.print();
	}
}
