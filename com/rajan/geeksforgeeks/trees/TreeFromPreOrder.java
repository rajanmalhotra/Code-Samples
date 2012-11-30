package com.rajan.geeksforgeeks.trees;

/* 
 * Construct a special tree from given preorder traversal
 * Given an array ‘pre[]‘ that represents Preorder traversal of a special binary tree
 * where every node has either 0 or 2 children. One more array ‘preLN[]‘ is given which
 * has only two possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]‘ indicates that 
 * the corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the 
 * corresponding node is non-leaf node. Write a function to construct the tree from the 
 * given two arrays.
 */
import java.util.ArrayList;
import java.util.List;

public class TreeFromPreOrder extends BinaryTree<Integer>{
	
	public TreeNode<Integer> formTreeFromPreOrder(Integer[] pre, char[] preLN, int index){
		
		if(index==pre.length){
			return null;
		}
		
		TreeNode<Integer> current = new TreeNode<Integer>(pre[index]);		
		if(preLN[index]=='N' && preLN[index+1]=='N'){					
			current.left = formTreeFromPreOrder(pre, preLN, index+1);			
		}else{
			if(preLN[index+1]=='L' && preLN[index+2]=='L'){
				current.left = new TreeNode<Integer>(pre[index+1]);
				current.right = new TreeNode<Integer>(pre[index+2]);
			}			
		}		

		return current;
	}
		
	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		Integer[] arr = {20, 18, 24, 12, 19, 22, 26, 21, 23};
		bt.createBinaryTree(arr);
		//bt.printTree();
		
		Integer[] pre = {20, 18, 12, 21, 23, 19, 24, 22, 26};
		char[] preLN = {'N', 'N', 'N', 'L', 'L', 'L', 'N', 'L', 'L'};
		TreeFromPreOrder treeFromPreOrder = new TreeFromPreOrder();
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		TreeNode<Integer> root = treeFromPreOrder.formTreeFromPreOrder(pre, preLN, 0);
		treeFromPreOrder.printTree(root);
	}
}
