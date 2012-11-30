package com.rajan.crackingcoding.ch2;

public class NthLast_2_2{
	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int[] arr = {78, 2, 32, 89, 21, 43, 22, 89, 22, 78, 32, 90, 37};
		for(int num : arr){
			ll.append(num);		
		}
		System.out.println("The List is : ");
		ll.print();
		System.out.println("Nth Element is : " + ll.nthToLast(1).data);		
	}
}


