package com.rajan.geeksforgeeks.trees;

import java.util.*;

public class LevelOrdersToTree {

	public ArrayList<ArrayList<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root){
		ArrayList<TreeNode<Integer>> current = new ArrayList<TreeNode<Integer>>();
		ArrayList<ArrayList<TreeNode<Integer>>> all = new ArrayList<ArrayList<TreeNode<Integer>>>();
		all.add(current);
		current.add(root);
		while(!current.isEmpty()){
			ArrayList<TreeNode<Integer>> newList = new ArrayList<TreeNode<Integer>>();
 			for(TreeNode<Integer> node : current){
				if(node.left!=null){
					newList.add(node.left);
				}
				if(node.right!=null){
					newList.add(node.right);
				}
			}
 			for(TreeNode<Integer> node : current){
 				System.out.print(node.data + " ");
 			}
 			System.out.println();
 			current = newList;
 			all.add(newList);
		}
		return all;
	}
	
	/* for a completely balanced binary tree */
	public TreeNode<Integer> createTreefromLevelOrders(ArrayList<ArrayList<TreeNode<Integer>>> lists){
		for(int i=lists.size()-1; i > 0 ; i--){
			ArrayList<TreeNode<Integer>> parent = lists.get(i-1);
			ArrayList<TreeNode<Integer>> children = lists.get(i);
			for(int j=0; j < parent.size(); j++){
				if((2*j) < children.size()){
					parent.get(j).left = children.get(2*j);
				}else{
					parent.get(j).left = null;
				}
				if((2*j+1) < children.size()){
					parent.get(j).right = children.get(2*j+1);
				}else{
					parent.get(j).right = null;
				}
			}
		}
		return lists.get(0).get(0);
	}
	
	public static void main(String[] args){
		BST<Integer> tree = new BST<Integer>();
		int arr[] = {28, 19, 32, 36, 23, 40, 12, 8, 13, 46, 44, 5};
		for(int val:arr){
			tree.insert(val);
		}
		LevelOrdersToTree l = new LevelOrdersToTree();
		ArrayList<ArrayList<TreeNode<Integer>>> lists = l.levelOrderTraversal(tree.root);
		tree.root = l.createTreefromLevelOrders(lists);	
		System.out.println("Tree in PreOrder is : ");
		tree.printWithInOrderSuccessor(tree.root);
		System.out.println("Tree in PreOrder is : ");
		tree.preorder(tree.root);
	}
}
