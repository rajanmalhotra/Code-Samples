package com.rajan.crackingcoding.ch17;

import com.rajan.crackingcoding.ch4.BST;
import com.rajan.crackingcoding.ch4.TreeNode;
import java.util.*;
public class BSTtoSortedDLL_17_13{

	public TreeNode<Integer> convertBSTtoDLL(TreeNode<Integer> root){
		if(root==null){
			return null;		
		}
		
		TreeNode<Integer> left = convertBSTtoDLL(root.left);
		TreeNode<Integer> right = convertBSTtoDLL(root.right);
		List<Pair<String, String>> input = null;
				
		if(left==null && right==null){
			root.left = root;
			root.right = root;
			return root;
			Map.Entry e;
			e.get
		}

		TreeNode<Integer> tail = null;
		if(left!=null){
			concat(left.left, root);
			left.left = null;
		}
		if(right!=null){
			tail = right.left;
			tail.right = null;
			concat(root, right);
		}
		
		if(tail!=null){
			concat(tail, left);
		}else if(left!=null){
			concat(root, left);
		}else if(right!=null){
			concat(right, root);
		}
		return left;
	}

	public void concat(TreeNode<Integer> x, TreeNode<Integer> y){
		x.right = y;
		y.left = x;
	}

	public void printList(TreeNode<Integer> root){
		TreeNode<Integer> temp = root;
		while(temp!=null){
			System.out.print(temp.data + " <-> ");
			temp = temp.right;
		}
	}
	
	public static void main(String[] args){
		BSTtoSortedDLL_17_13 bstDLL = new BSTtoSortedDLL_17_13();
		BST<Integer> bst = new BST<Integer>();
		int[] arr = {8, 6, 7, 4, 2, 5, 10, 9, 12};;
		for(int val : arr){
			bst.insert(val);		
		}
		TreeNode<Integer> head = bstDLL.convertBSTtoDLL(bst.root);
		head.left.right = null;
		head.left = null;
		bstDLL.printList(head);
	}
}
