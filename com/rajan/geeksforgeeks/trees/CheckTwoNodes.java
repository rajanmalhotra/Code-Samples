package com.rajan.geeksforgeeks.trees;

public class CheckTwoNodes {
	public static int checkNodes(TreeNode<Integer> root, int val1, int val2){
	    if(root==null){
	        return 0;
	    }

	    if(root.data==val1 || root.data==val2){
	    	return 1 + checkNodes(root.left, val1, val2) + checkNodes(root.right, val1, val2);
	    }else{
	    	return checkNodes(root.left, val1, val2) + checkNodes(root.right, val1, val2);
	    }
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		Integer[] arr = {20, 45, 23, 12, 67, 14, 6, 7, 9, 34, 54};
		tree.createBinaryTree(arr);
		if(checkNodes(tree.root, 67, 54)==2){
			System.out.println("Both the Nodes are from same tree");
		}else{
			System.out.println("Both the Nodes are not from same tree");
		}
	}
}
