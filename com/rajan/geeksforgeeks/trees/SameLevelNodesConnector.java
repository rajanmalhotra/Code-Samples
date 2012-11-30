package com.rajan.geeksforgeeks.trees;

/*
 * Connect nodes at same level using constant extra space
 * Write a function to connect all the adjacent nodes at the same level in a binary tree.
 * http://www.geeksforgeeks.org/archives/16952
 */

public class SameLevelNodesConnector {
	
	/* Approach 1 - applies only to Complete Binary Trees */
	public void connectSameLevelNodes(TreeNode<Integer> node){
		if(node==null){
			return;
		}
		
		if(node.left!=null){
			node.left.next = node.right;
		}
		if(node.right!=null){
			node.right.next = (node.next!=null)? node.next.left : null;
		}
		connectSameLevelNodes(node.left);
		connectSameLevelNodes(node.right);
	}
	
	/* Approach 2 - applies to all Binary Trees */
	public void connectSameLevelNodesAllTrees(TreeNode<Integer> node){
		if(node==null){
			return;
		}
		
		if(node.next!=null){
			connectSameLevelNodesAllTrees(node.next);
		}
		
		if(node.left!=null){
			if(node.right!=null){
				node.left.next = node.right;
				node.right.next = getNextRight(node);
			}else{
				node.left.next = getNextRight(node);
			}
			connectSameLevelNodesAllTrees(node.left);
		} else if(node.right!=null){
			node.right.next = getNextRight(node);
			connectSameLevelNodesAllTrees(node.right);
		}
		/*else{
			TreeNode<Integer> temp = getNextRight(node);
			connectSameLevelNodesAllTrees(temp);
		}*/
	}
	
	public TreeNode<Integer> getNextRight(TreeNode<Integer> node){
		TreeNode<Integer> temp = node.next;
		while(temp!=null){
			if(temp.left!=null){
				return temp.left;
			}
			if(temp.right!=null){
				return temp.right;
			}
			temp = temp.next;
		}
		return null;
	}
	
	/* prints InOrder traversal */
	public void printInOrderWithNext(TreeNode<Integer> node){
		if(node==null){
			return;
		}
		printInOrderWithNext(node.left);
		System.out.println(node.data + "->" + ((node.next!=null)? node.next.data:"null"));
		printInOrderWithNext(node.right);
	}

	public static void main(String[] args){
		SameLevelNodesConnector same = new SameLevelNodesConnector();
		Integer[] arr = {1, 2, 3, 4, 5, 8, 9, 12, 13, 14, 15};
		BinaryTree<Integer> btree = new BinaryTree<Integer>();
		btree.createBinaryTree(arr);
		same.connectSameLevelNodesAllTrees(btree.root);
		System.out.println("Printing the BinaryTree with Next Pointers : ");
		same.printInOrderWithNext(btree.root);
		
		int[] arr1 = {25, 20, 28, 18, 10, 32, 42, 16, 3, 19, 24, 22};
		BST<Integer> bst = new BST<Integer>();		
		for(int val:arr1){
			bst.insert(val);
		}
		same.connectSameLevelNodesAllTrees(bst.root);
		System.out.println("Printing the Binary Search Tree with Next Pointers : ");
		same.printInOrderWithNext(bst.root);
	}
}
