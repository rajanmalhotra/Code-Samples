package com.rajan.geeksforgeeks.linkedlists;

/*
 * Problem 4:
 * Copy a linked list with next and arbit pointer
 * http://www.geeksforgeeks.org/archives/1155
 * http://www.careercup.com/question?id=11192758
 * You are given a Double Link List with one pointer of each node pointing to the next node 
 * just like in a single link list. The second pointer however CAN point to any node in the list 
 * and not just the previous node. Now write a program in O(n) time to duplicate this list. 
 * That is, write a program which will create a copy of this list.
 */

import java.util.Map;
import java.util.HashMap;

class RandomNode{
	public int data;
	public RandomNode next;
	public RandomNode random;

	public RandomNode(int data){
		this.data = data;
		next = null;
		random = null;	
	}
}

class RandPtrLinkedList{
	private RandomNode head;
	
	public void append(int data){
		RandomNode newNode = new RandomNode(data);
		if(head==null){
			head = newNode;
			Math.floor(1.1);
		}else{
			RandomNode current = head;
			while(current.next!=null){
				current = current.next;			
			}
			current.next = newNode;
		}
	}

	public RandomNode findNode(int data){
		RandomNode current = head;
		while(current!=null &&  current.data!=data){
			current = current.next;
		}
		return current;		
	}

	public void updateRandPtrs(int[] arr){
		int i = 0;		
		RandomNode current = head;
		while(current!=null){
			if(arr[i]==0){
				i++;
				current.random = null;			
			}else{
				RandomNode temp = findNode(arr[i++]);
				current.random = temp;
			}
			current = current.next;
		}
	}

	public void print(RandomNode head){
		if(head==null){
			return;
		}
		RandomNode random = head.random;
		System.out.println(head.data + " Random : " + (random!=null?
				head.random.data : "null"));
		print(head.next);
	}

	public void print(){
		System.out.println("The List is : ");	
		print(head);
	}

	public RandomNode cloneTheList(){
		RandomNode current = head;
		RandomNode newHead = null;
		RandomNode newCurrent = null;
		Map<RandomNode, RandomNode> nodeMap = new HashMap<RandomNode, RandomNode>();

		while(current!=null){
			RandomNode newNode = new RandomNode(current.data);
			if(newHead==null){
				newHead = newNode;
				newCurrent = newNode;
			}else{				
				newCurrent.next = newNode;
				newCurrent = newCurrent.next;
			}
			nodeMap.put(current, newNode);
			current = current.next;
		}
		nodeMap.put(null, null);

		current = head;
		newCurrent = newHead;
		while(current!=null){
			newCurrent.random = nodeMap.get(current.random);
			newCurrent = newCurrent.next;
			current = current.next;
		}
		return newHead;
	}
}

public class CloneListWithRandomPtr {

	public static void main(String[] args){
		RandPtrLinkedList ll = new RandPtrLinkedList();
		int[] arr = {1, 2, 3, 4, 5, 6};
		for(int val:arr){
			ll.append(val);		
		}		
		int[] ptr = {4, 3, 5, 6, 0, 2};
		ll.updateRandPtrs(ptr);
		ll.print();
		System.out.println("\nThe Cloned List is : ");
		RandomNode head = ll.cloneTheList();
		ll.print(head);
	}
}
