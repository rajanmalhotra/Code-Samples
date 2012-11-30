package com.rajan.crackingcoding.ch2;

import com.rajan.crackingcoding.ch2.Node;

public class IntegerLinkedList extends LinkedList<Integer> {
		
	public IntegerLinkedList(){
		
	}
	
	private Node<Integer> AddListAsNumber(Node<Integer> l1, Node<Integer> l2, int rem){
		Node<Integer> result = new Node<Integer>(rem);
		int value = rem;
		if(l1!=null){
			value += l1.data;
		}
		if(l2!=null){
			value += l2.data;
		}
		
		System.out.println(value);
		result.data = value%10;
		
		if(l1!=null || l2!=null || value >=10){
			if(l1!=null){
				l1 = l1.next;
			}
			if(l2!=null){
				l2 = l2.next;
			}
			if(value>=10){
				rem = 1;
			}else{
				rem = 0;
			}
			Node<Integer> newNode = AddListAsNumber(l1, l2, rem);
			result.next = newNode;
		}
		return result;
	}
	
	public void AddListAsNumber(IntegerLinkedList l1, IntegerLinkedList l2){
		head = AddListAsNumber(l1.head, l2.head, 0);
		Node<Integer> temp = head;
		while(temp!=null){
			this.append(temp.data);
			temp = temp.next;
		}
	}
}
