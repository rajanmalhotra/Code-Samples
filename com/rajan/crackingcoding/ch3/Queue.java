package com.rajan.crackingcoding.ch3;

import com.rajan.crackingcoding.ch4.Node;

public class Queue<T>{
	
	private Node<T> front;
	private Node<T> last;	
	
	public Queue(){
		front = null;
		last = null;	
	}

	public boolean isEmpty(){
		if(front==null){
			return true;
		}
		return false;
	}
	
	public void add(T val){
		Node<T> newNode = new Node<T>(val);
		if(front==null){
			front = newNode;
			last = newNode;		
		} else {
			last.next = newNode;
			last = newNode;
		}
	}

	public T remove(){
		if(front!=null){
			T val = front.data;
			if(front==last){
				front = null;
				last = null;
			} else {
				front = front.next;		
			}
			return val;
		}
		return null;
	}
	
	public T peek(){
		if(isEmpty()){
			return null;
		}else{
			return front.data;
		}
	}
}
