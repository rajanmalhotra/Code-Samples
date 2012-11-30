package com.rajan.crackingcoding.ch2;

public class RemoveDuplicates_2_1{

	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int[] arr = {2, 4, 5, 4, 8, 10, 12, 34, 23, 12, 23, 67, 8, 8, 8, 34, 100, 86};
		for(int i=0; i < arr.length; i++){
			ll.append(arr[i]);		
		}
		System.out.println("Before removing Duplicates :");
		ll.print();
		ll.removeDups2();
		System.out.println("After removing Duplicates :");
		ll.print();
	}
}
