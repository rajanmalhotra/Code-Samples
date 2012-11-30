package com.rajan.crackingcoding.ch2;

public class AddTwoLinkedLists_2_4 {
	
	public static void main(String[] args){
		IntegerLinkedList ll1 = new IntegerLinkedList();
		IntegerLinkedList ll2 = new IntegerLinkedList();
		int[] arr1 = {2, 4, 5, 4};
		for(int i=0; i < arr1.length; i++){
			ll1.append(arr1[i]);		
		}
		int[] arr2 = {1, 8, 9, 3};
		for(int i=0; i < arr2.length; i++){
			ll2.append(arr2[i]);		
		}		
		ll1.print();
		ll2.print();		
		System.out.println("The result after adding is : ");
		IntegerLinkedList ll3 = new IntegerLinkedList();
		ll3.AddListAsNumber(ll1, ll2);
		ll3.print();
	}
}
