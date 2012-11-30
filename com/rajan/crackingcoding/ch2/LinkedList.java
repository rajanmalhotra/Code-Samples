package com.rajan.crackingcoding.ch2;

import java.util.HashSet;
import com.rajan.crackingcoding.ch2.Node;

public class LinkedList<T>{

	protected Node<T> head;
	
	public LinkedList(){
		head = null;
	}

	public int getLength(){
		int count = 0;
		if(head!=null){
			Node<T> n = head;
			count = 1;
			while(n.next!=null){
				n = n.next;
				count++;
			}
		}
		return count;
	}

	public void print(){
		Node<T> n = head;	
		while(n!=null){				
			System.out.print(n.data);			
			n = n.next;
			if(n!=null){			
				System.out.print(" -> ");
			}
		}
		System.out.println();			
	}
	
	public void append(T val){
		Node<T> n = head;
		Node<T> endNode = new Node<T>(val);	

		if(n==null){
			head = endNode;
		} else {
			while(n.next != null){
				n = n.next;					
			}
			n.next = endNode;
		}
	}

	public void deleteNode(T val){
		Node<T> n = head;
		if(n!=null){
			if(n.data==val){
				head = head.next;
				return;		
			}			
			while(n.next!=null){
				if(n.next.data==val){
					n.next = n.next.next;
					return;
				}
				n = n.next;
			}
			System.out.println("Element not found");			
		}else{
			System.out.println("Linked List is Empty");		
		}
	}

	// remove duplicates using another buffer
	public void removeDuplicates(){
		Node<T> ptr = head;
		Node<T> prev = null;
		if(head==null){
			return;
		}
	
		HashSet<T> set = new HashSet<T>();

		while(ptr!=null){
			if(set.contains(ptr.data)){
				prev.next = ptr.next;
			} else{
				set.add(ptr.next.data);		
				prev = ptr;
			}
			ptr = ptr.next;
		}
	}

	// remove duplicates without using another buffer
	public void removeDups2(){
		if(head==null){
			return;		
		}

		Node<T> current = head.next;
		Node<T> previous = head;
		
		while(current!=null){
			Node<T> runner = head;
			while(runner!=current){
				if(current.data == runner.data){
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

	public Node<T> getNthElement(int pos){
		Node<T> n = head;
		if(pos<0){
			return null;
		}
		while(n!=null && pos>0){
			n = n.next;
			pos--;
		}
		if(pos>0){
			return null;
		}
		return n;
	}
	
	public Node<T> nthToLast(int n){
		Node<T> ptr = head;
		Node<T> ptrN = head;
		
		for(int i = 0; i < n; i++){
			if(ptr.next!=null){
				ptr = ptr.next;
			}else{
				return null;
			}
		}		
		
		while(ptr.next!=null){
			ptr = ptr.next;
			ptrN = ptrN.next;		
		}
		return ptrN;
	}

	public boolean deletePtrNode(Node<T> element){
		if(element == null){
			return false;		
		}
		Node<T> ptr = head;
		if(ptr==element){
			head = ptr.next;
			return true;
		}
		while(ptr.next!=null && ptr.next!=element){
			ptr = ptr.next;
		}
		if(ptr.next==element){
			ptr.next = ptr.next.next;
			return true;
		}
		return false;
	}
}
