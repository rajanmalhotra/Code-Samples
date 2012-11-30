package com.rajan.geeksforgeeks.stacks;

import com.rajan.crackingcoding.ch4.Node;

public class Stack<T>{

	private Node<T> top;
		
	public Stack(){
		top = null;	
	}

	public boolean isEmpty(){
		if(top!=null){
			return false;
		} else {
			return true;
		}
	}

	public boolean push(T val){
		Node<T> newNode = new Node<T>(val);
		newNode.next = top;
		top = newNode;
		return true;
	}

	public T pop() throws StackEmptyException{
		if(top!=null){
			T val = top.data;
			top = top.next;
			return val;	
		}
		throw new StackEmptyException("Stack is Empty");
	}
	
	public T peek() throws StackEmptyException{
		if(top!=null){
			T val = top.data;
			return val;
		}
		throw new StackEmptyException("Stack is Empty");
	}
}

class StackEmptyException extends Exception{
	
	/*
	 * The serialization runtime associates with each serializable class a version number, 
	 * called a serialVersionUID, which is used during deserialization to verify that the sender 
	 * and receiver of a serialized object have loaded classes for that object that are compatible 
	 * with respect to serialization. If the receiver has loaded a class for the object that has a different 
	 * serialVersionUID than that of the corresponding sender's class, then deserialization will result in an 
	 * InvalidClassException. A serializable class can declare its own serialVersionUID explicitly by 
	 * declaring a field named "serialVersionUID" that must be static, final, and of type long
	 */
	
	private static final long serialVersionUID = 9221;
	private String message;
	
	public StackEmptyException(){
		super();		
		message = null;
	}
	
	public StackEmptyException(String msg){
		super(msg);
		message = msg;
	}
	
	public String getMessage(){
		return message;
	}
}