package com.rajan.geeksforgeeks.trees;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeToBST {
	
	private void arrayFromInOrder(TreeNode<Integer> root, List<Integer> arr){
		if(root==null){
			return;
		}
		
		arrayFromInOrder(root.left, arr);
		arr.add(root.data);
		arrayFromInOrder(root.right, arr);
	}
	
	private void convertBinaryTreeToBST(TreeNode<Integer> root, ArrayList<Integer> list){
		if(root==null){
			return;
		}
		convertBinaryTreeToBST(root.left, list);
		root.data = list.get(0);
		list.remove(0);
		convertBinaryTreeToBST(root.right, list);
	}
	
	public void convertBinaryTreeToBST(TreeNode<Integer> root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		arrayFromInOrder(root, list);
		Collections.sort(list);
		convertBinaryTreeToBST(root, list);
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		Integer[] arr = {10, 2, 7, 8, 4};
		bt.createBinaryTree(arr);
		TreeNode<Integer> newNode = bt.root;
		
		System.out.println("Before Conversion");
		bt.printTree();
		bt.inOrder();
		BinaryTreeToBST bst = new BinaryTreeToBST();
		bst.convertBinaryTreeToBST(newNode);
		System.out.println("After Conversion");
		bt.printTree();
		bt.inOrder();	
	}
}