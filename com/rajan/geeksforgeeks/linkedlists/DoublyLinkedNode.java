package com.rajan.geeksforgeeks.linkedlists;

public class DoublyLinkedNode<T>{
	public DoublyLinkedNode<T> next;
	public DoublyLinkedNode<T> previous;
	public T data;
	
	public DoublyLinkedNode(T val){
		data = val;
		next = null;
		previous = null;
	}
}
