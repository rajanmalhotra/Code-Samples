package com.rajan.crackingcoding.ch4;

public class SubTreeChecker_4_7{

	public static void main(String[] args){
		BST<Integer> T1 = new BST<Integer>();
		int[] arr1 = {43, 12, 19, 74, 10, 8, 15, 90, 29, 13, 21, 30, 59, 46, 25};
		for(int i=0; i < arr1.length; i++){
			T1.insert(arr1[i]);	
		}
		System.out.println("Tree T1 : ");
		T1.inorder();

		BST<Integer> T2 = new BST<Integer>();
		int[] arr2 = {12, 10, 19, 29, 15, 21};
		for(int i=0; i < arr2.length; i++){
			T2.insert(arr2[i]);	
		}
		System.out.println("Tree T2 : ");
		T2.inorder();

		boolean result = T1.containsSubTree(T2);
		System.out.println("Tree T1 contains Tree T2 : " + result);
	}
}
