package com.rajan.crackingcoding.ch4;

//import src.com.rajan.crackingcoding.ch2.Node;

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

	public void push(T val){
		Node<T> newNode = new Node<T>(val);
		newNode.next = top;
		top = newNode;
	}

	public T pop(){
		if(top!=null){
			T val = top.data;
			top = top.next;
			return val;
		}
		return null;
	}

	public T peek(){
		return top.data;
	}
}
