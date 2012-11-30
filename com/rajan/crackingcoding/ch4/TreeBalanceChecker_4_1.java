package com.rajan.crackingcoding.ch4;

public class TreeBalanceChecker_4_1{
	public static void main(String[] args){
			BST<Integer> t = new BST<Integer>();
			int[] arr = {20, 30, 10, 8, 16, 24, 26, 48, 22};
			for(int i=0; i < arr.length; i++){
				t.insert(arr[i]);		
			}
			t.inorder();
			System.out.println("Is this tree balanced? : " + t.isBalanced());
	}
}
