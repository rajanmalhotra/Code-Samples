package com.rajan.geeksforgeeks.trees;

/*
 * Construct Special Binary Tree from given Inorder traversal
 * http://www.geeksforgeeks.org/archives/21781
 * Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys 
 * in left and right children, construct the Binary Tree and return root.
 */

public class TreeConstructorUsingInOrder {

	public TreeNode<Integer> constructTree(int[] inOrder, int start, int end){
		if(start>end){
			return null;
		}
		
		int index = searchMax(inOrder, start, end);
		TreeNode<Integer> newNode = new TreeNode<Integer>(inOrder[index]);
		if(start==end){
			return newNode;
		}

		newNode.left = constructTree(inOrder, start, index-1);
		newNode.right = constructTree(inOrder, index+1, end);
		return newNode;
	}
	
	public int searchMax(int[] inOrder, int start, int end){
		int max=-1;
		int maxi=0;
		for(int i=start; i<=end; i++){
			if(inOrder[i] > max){
				max = inOrder[i];
				maxi = i;
			}
		}
		return maxi;
	}
	
	public static void main(String[] args){
		TreeConstructorUsingInOrder t = new TreeConstructorUsingInOrder();
		int[] inOrder = {1, 5, 10, 40, 30, 15, 28, 20};
		BinaryTree<Integer> bst = new BinaryTree<Integer>();
		TreeNode<Integer> root = t.constructTree(inOrder, 0, inOrder.length-1); 
		bst.printTree(root);
	}
}
