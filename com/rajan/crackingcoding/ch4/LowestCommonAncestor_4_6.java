/*Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.*/

package com.rajan.crackingcoding.ch4;

public class LowestCommonAncestor_4_6{
		 
	public static void main(String[] args){
		BST<Integer> t = new BST<Integer>();
		int[] arr = {43, 12, 19, 74, 10, 8, 90, 29, 21, 30, 59, 46};
		for(int i=0; i < arr.length; i++){
			t.insert(arr[i]);	
		}
		t.inorder();
		t.findLowestCommonAncestor(21, 74);
	}
}
