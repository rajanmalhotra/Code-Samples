package com.rajan.crackingcoding.ch4;

public class TreeNode<T>{
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T data;

	public TreeNode(T val){
		data = val;
		left = null;
		right = null;
	}
}
