package com.rajan.geeksforgeeks.trees;

public class TreeNode<T>{
	public TreeNode<T> left;
	public TreeNode<T> right;
	/* 
	 * keeping this pointer for solving specific problems 
	 * like InOrder Successor
	 */
	public TreeNode<T> next;
	public T data;

	public TreeNode(T val){
		data = val;
		left = null;
		right = null;
		next = null;
	}
}
