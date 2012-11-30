package com.rajan.crackingcoding.ch2;

import com.rajan.crackingcoding.ch4.Node;

public class Queue<T>{
	private Node<T> front;
	private Node<T> last;

	public Queue(){
		front = null;
		last = null;	
	}

	public boolean isEmpty(){
		if(front == null){
			return true;		
		}
		return false;
	}

	public void add(T val){
		Node<T> node = new Node<T>(val);
		if(last==null){
			last = node;
			front = last;		
		}
		last.next = node;
		last = node;	
	}

	public T remove(){
		Node<T> val = front;
		if(front==null){
			return null;		
		}else if(front==last){
			last = null;	
		}			
		front = front.next;
		return val.data;
	}
	
	public void print(){
		Node<T> temp = front;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;		
		}
	}

	public static void main(String[] args){
		Queue<Integer> q = new Queue<Integer>();
		int[] arr = {20, 30, 10, 8, 16, 24, 26, 48, 22};
		for(int i=0; i < arr.length; i++){
			q.add(arr[i]);		
		}
		q.print();
		q.remove();
		q.remove();
		q.print();
	}
}
