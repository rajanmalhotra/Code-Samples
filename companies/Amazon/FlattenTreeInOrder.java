package companies.Amazon;

import com.rajan.geeksforgeeks.trees.*;

/*
 * Problem 85: 
 * Flattening the data: How to write a recursive function that returns a linked list of nodes, when given a binary tree of nodes? 
 * (The tree can be modified)
 */

class ResultNode{
	TreeNode<Integer> head;
	TreeNode<Integer> tail;
	
	public ResultNode(TreeNode<Integer> head, TreeNode<Integer> tail){
		this.head = head;
		this.tail = tail;
	}
}

public class FlattenTreeInOrder {
	
	public static ResultNode flattenTree(TreeNode<Integer> root){
		if(root==null){
			return new ResultNode(null, null);
		}
		
		ResultNode lResult = null;
		ResultNode rResult = null;
		
		if(root.left!=null){
			lResult = flattenTree(root.left);
			lResult.tail.next = root;
			lResult.tail = root;
		}
		
		if(root.right!=null){
			rResult = flattenTree(root.right);
			root.next = rResult.head;
		}
		
		if(lResult==null && rResult==null){
			return new ResultNode(root, root);
		}else{
			if(lResult==null){
				return new ResultNode(root, rResult.tail==null?root:rResult.tail);
			}else if(rResult==null){
				return new ResultNode(lResult.head==null?root:lResult.head, root);
			}else{
				return new ResultNode(lResult.head==null?root:lResult.head, rResult.tail==null?root:rResult.tail);
			}			
		}
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> btree = new BinaryTree<Integer>();
		Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};
		btree.createBinaryTree(arr);
		ResultNode result = flattenTree(btree.root);
		TreeNode<Integer> current = result.head;
		while(current!=null){
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}
}
