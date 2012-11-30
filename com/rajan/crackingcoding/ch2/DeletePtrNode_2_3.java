package com.rajan.crackingcoding.ch2;

import com.rajan.crackingcoding.ch2.Node;

public class DeletePtrNode_2_3{
	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int[] arr = {78, 2, 32, 89, 21, 43, 22, 89, 22, 78, 32, 90, 37};
		for(int num : arr){
			ll.append(num);		
		}
		ll.print(); 
		Node<Integer> element = ll.nthToLast(12);
		ll.deletePtrNode(element);
		ll.print(); 
		ll.deleteNode(37);
		ll.print(); 
		ll.deleteNode(78);
		ll.print();
		ll.getNthElement(7);		
	}
}
