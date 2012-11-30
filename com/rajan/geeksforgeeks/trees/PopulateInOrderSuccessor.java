package com.rajan.geeksforgeeks.trees;

/*
 * Populate InOrder Successor for all nodes
 * Given a Binary Tree, write a function to populate next pointer for all nodes. 
 * The next pointer for every node should be set to point to InOrder successor.
 */

public class PopulateInOrderSuccessor {

	/* Approach 1 - Do by reverse InOrder */
	public static TreeNode<Integer> next = null;
	public void populateInOrderSuccessor(TreeNode<Integer> node){
		if(node==null){
			return;
		}
		
		populateInOrderSuccessor(node.right);
		node.next = next;
		next = node;
		populateInOrderSuccessor(node.left);
	}

	/* Approach 2 - Do by Passing the ancestor along */
	public void populateInOrderSuccessor(TreeNode<Integer> node, TreeNode<Integer> ancestor){
		if(node==null){
			return;
		}
		if(node.right!=null){
			TreeNode<Integer> current = node.right;
			while(current.left!=null){
				current = current.left;
			}
			node.next = current;
		}else{
			node.next = ancestor;
		}
		populateInOrderSuccessor(node.left, node);
		populateInOrderSuccessor(node.right, ancestor);
	}

	public String toString(){
		return "I am PopulateInOrderSuccessor Object and I fill all the " +
				"nodes of a tree with their InOrder Successor";
	}
		
	public static void main(String[] args){
		PopulateInOrderSuccessor p = new PopulateInOrderSuccessor();
		Integer[] arr = {24, 18, 7, 33, 22, 100, 50, 40, 34, 2, 26, 11, 5};
		BST<Integer> bst = new BST<Integer>();
		for(int val : arr){		
			bst.insert(val);
		}
		p.populateInOrderSuccessor(bst.root);
		bst.printWithInOrderSuccessor();
		p.populateInOrderSuccessor(bst.root, null);
		bst.printWithInOrderSuccessor();
		System.out.println(p.toString());
	}
}
