package com.rajan.geeksforgeeks.trees;

import java.util.ArrayList;

public class VisibleTree {

	public static void findVisible(TreeNode<Integer> node, int max, ArrayList<Integer> list){
		if(node==null){
			return;
		}

		if(node.data > max){
			list.add(node.data);
			findVisible(node.left, node.data, list);
			findVisible(node.right, node.data, list);
		}else{
			findVisible(node.left, max, list);
			findVisible(node.right, max, list);			
		}
	}

	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		Integer arr[] = {45, 23, 80, 37, 53, 34, 67, 28, 78, 76, 25, 64};
		bt.createBinaryTree(arr);
		ArrayList<Integer> list = new ArrayList<Integer>();
		findVisible(bt.root, Integer.MIN_VALUE, list);
		System.out.println(list);
	}
}
