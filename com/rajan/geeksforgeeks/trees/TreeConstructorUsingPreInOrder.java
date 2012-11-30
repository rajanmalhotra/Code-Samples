package com.rajan.geeksforgeeks.trees;

/*
 * Construct Tree from given Inorder and Preorder traversals
 * Let us consider the below traversals:
 * Inorder sequence: D B E A F C
 * Preorder sequence: A B D E C F
 * In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences. 
 * By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and 
 * elements on right are in right subtree.
 */

public class TreeConstructorUsingPreInOrder {
	public static int preIndex=0;
	public TreeNode<Character> constructTree(char[] inOrder, char[] preOrder, int inStrt, int inEnd){
		if(inStrt > inEnd){
			return null;
		}
		
		TreeNode<Character> newNode = new TreeNode<Character>(preOrder[preIndex++]);
		if(inStrt==inEnd){
			return newNode;
		}
		
		int inIndex = search(inOrder, inStrt, inEnd, newNode.data);
		newNode.left = constructTree(inOrder, preOrder, inStrt, inIndex-1);
		newNode.right = constructTree(inOrder, preOrder, inIndex+1, inEnd);
		return newNode;
	}
	
	public int search(char[] inOrder, int start, int end, char value){
		for(int i=start; i <=end; i++){
			if(inOrder[i]==value){
				return i;
			}
		}
		return 0;
	}
	
	public static void main(String[] args){
		TreeConstructorUsingPreInOrder t = new TreeConstructorUsingPreInOrder();
		char[] inOrder = {'D', 'B', 'E', 'A', 'F', 'C'};
		char[] preOrder = {'A', 'B', 'D', 'E', 'C', 'F'};
		TreeNode<Character> root = t.constructTree(inOrder, preOrder, 0, inOrder.length-1);
		BinaryTree<Character> bst = new BinaryTree<Character>();
		bst.printTree(root);
	}
}
