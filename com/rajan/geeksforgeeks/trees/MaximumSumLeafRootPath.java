package com.rajan.geeksforgeeks.trees;

import java.util.ArrayList;
import java.util.List;


/*
 * Find the maximum sum leaf to root path in a Binary Tree
 * http://www.geeksforgeeks.org/archives/18722
 * Given a Binary Tree, find the maximum sum path from a leaf to root. For example, there are three leaf
 * to root paths 8->-2->10, -4->-2->10 and 7->10. The sums of these three paths are 16, 8 and 17 respectively. 
 * The maximum of them is 17 and the path for maximum is 7->10. 
 */

public class MaximumSumLeafRootPath {
	private void printPath(List<Integer> path, int start){
		for(int i=start; i < path.size(); i++){
			System.out.print(path.get(i) + " -> ");
		}
		System.out.println();
	}

	private int findSumOfPath(List<Integer> path){
		int sum = 0;
		for(int i=0; i < path.size(); i++){
			sum += path.get(i);	
		}
		return sum;
	}

	private static int maxSum=-1;
	private static List<Integer> result = new ArrayList<Integer>();
	
	private void printRootPathWithMaxSum(TreeNode<Integer> node, List<Integer> path){
		if(node!=null){
			path.add(node.data);
		}else{
			return;
		}
		if(node.left==null && node.right==null){
			int sum = findSumOfPath(path);
			if(sum > maxSum){
				maxSum = sum; 
				result.clear();
				result.addAll(path);	
			}
		}
		printRootPathWithMaxSum(node.left, path);
		printRootPathWithMaxSum(node.right, path);
		path.remove(node.data);
	}
	
	public void printRootPathWithMaxSum(TreeNode<Integer> root){
		List<Integer> path = new ArrayList<Integer>();
		printRootPathWithMaxSum(root, path);
		System.out.println("MaxSum of the Path is : "+maxSum);
		System.out.println("The Path is : ");
		printPath(result, 0);
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> btree = new BinaryTree<Integer>();
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		btree.createBinaryTree(arr);	
		MaximumSumLeafRootPath maxSum = new MaximumSumLeafRootPath();
		maxSum.printRootPathWithMaxSum(btree.root);
	}
}
