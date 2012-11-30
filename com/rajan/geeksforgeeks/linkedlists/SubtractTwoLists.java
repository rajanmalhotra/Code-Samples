package com.rajan.geeksforgeeks.linkedlists;

public class SubtractTwoLists {
	public static Node<Integer> subtractList(Node<Integer> first, Node<Integer> second, int borrow){
	    if(first==null && second==null){
	        return null;
	    }
	    int value = 0;
	    Node<Integer> result = new Node<Integer>();
	    if(first!=null){
	    	value = first.data - borrow;
	    }
	    if(second!=null){
	    	value = value - second.data;
	    }
	    if(value < 0){
	    	value = value+10;
	    	borrow = 1;
	    }else{
	    	borrow = 0;
	    }
	    result.data = value;
	    if(first!=null || second!=null || borrow>0){
	    	result.next = subtractList(first.next, second.next, borrow);
	    }
	    return result;
	}
	
	public static void printList(Node<Integer> head){
		Node<Integer> temp = head;
		while(temp!=null){
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		LinkedList<Integer> first = new LinkedList<Integer>();
		LinkedList<Integer> second = new LinkedList<Integer>();
		int[] arr = {8, 5, 7, 6};
		int[] arr1 = {7, 3, 9, 3};
		for(int val:arr){
			first.append(val);
		}
		for(int val:arr1){
			second.append(val);
		}
		printList(first.head);
		printList(second.head);
		Node<Integer> result = subtractList(first.head, second.head, 0);
		printList(result);
	}
}
