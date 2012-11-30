package com.rajan.geeksforgeeks.trees;

import com.rajan.geeksforgeeks.stacks.Stack;

/*
 * Merge Two BSTs
 * http://www.geeksforgeeks.org/archives/19422
 * Solution from one of the comments below.
 */

public class MergeTwoBSTs {
	
	public TreeNode<Integer> getNextInOrderSuccessor(TreeNode<Integer> root){
		return root.right;
	}
	
	public void mergeTwoBSTs(TreeNode<Integer> first,TreeNode<Integer> second){
		Stack<TreeNode<Integer>> s1 = new Stack<TreeNode<Integer>>();
		Stack<TreeNode<Integer>> s2 = new Stack<TreeNode<Integer>>();
		TreeNode<Integer> one, two;
		
		while(!s1.isEmpty()||!s2.isEmpty()||first!=null||second!=null){
			while(first!=null){
				s1.push(first);
				first=first.left;
			}
			while(second!=null){
				s2.push(second);
				second=second.left;
			} 
			try{
				if(!s1.isEmpty() && s2.isEmpty()){
					one=s1.pop();
					System.out.println(one.data);
					first=one.right;
				}else if(s1.isEmpty() && !s2.isEmpty()){
					two=s2.pop();
					System.out.println(two.data);
					//s2.pop();
					second=two.right;
				}else{
					one=s1.peek();
					two=s2.peek();
					if(one.data<=two.data){
						System.out.println(one.data);
						s1.pop();
						first=one.right;
					}else{
						System.out.println(two.data);
						s2.pop();
						second=two.right;
					}
				}
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		BST<Integer> bst1 = new BST<Integer>();
		int[] arr = {10, 4, 5, 7};
		for(int val:arr){
			bst1.insert(val);
		}
		
		BST<Integer> bst2 = new BST<Integer>();
		int[] arr1 = {9, 3, 1, 13};
		for(int val:arr1){
			bst2.insert(val);
		}		
		
		MergeTwoBSTs merge = new MergeTwoBSTs();
		merge.mergeTwoBSTs(bst1.root, bst2.root);
	}
}
