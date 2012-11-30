package com.rajan.careercup.trees;

import com.rajan.geeksforgeeks.trees.*;
import java.util.*;

public class PrintPathWithSums {
	
	public static void printPath(ArrayList<Integer> left, TreeNode<Integer> root, ArrayList<Integer> right){
		for(int val:left){
			System.out.print(val + " -> ");
		}
		System.out.print("Root : " + root.data + " -> ");
		for(int val:right){
			System.out.print(val + " -> ");
		}
		System.out.println();
	}
	
	public static int findSum(List<Integer> list){
		int sum = 0;
		for(int val:list){
			sum += val;
		}
		return sum;
	}
	
	public static ArrayList<ArrayList<Integer>> printAllPathsWithSum(TreeNode<Integer> root, int sum, ArrayList<Integer> list){
		if(root == null){
			return null;
		}
		
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> left = printAllPathsWithSum(root.left, sum, list);
		ArrayList<ArrayList<Integer>> right = printAllPathsWithSum(root.right, sum, list);
		if(left==null && right==null){
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(root.data);
			all.add(l);
		}else if(left==null || right==null){
			if(left==null){
				for(ArrayList<Integer> r : right){
					int rSum = findSum(r);
					if((rSum + root.data)==sum){
						printPath(null, root, r);
					}
				}
				int rightSize = right.size();
				for(int i=0; i < rightSize; i++){
					ArrayList<Integer> r = right.get(i);
					r.add(root.data);
					right.set(i, r);
				}
				all.addAll(right);
			}else{
				for(ArrayList<Integer> l : left){
					int lSum = findSum(l);
					if((lSum + root.data)==sum){
						printPath(null, root, l);
					}
				}
				int leftSize = left.size();
				for(int i=0; i < leftSize; i++){
					ArrayList<Integer> l = left.get(i);
					l.add(root.data);
					left.set(i, l);
				}
				all.addAll(left);
			}
		}else{
			for(ArrayList<Integer> l : left){
				int lSum = findSum(l);
				for(ArrayList<Integer> r : right){
					int rSum = findSum(r);
					if((lSum + rSum + root.data)==sum){
						printPath(l, root, r);
					}
				}
			}

			int leftSize = left.size();
			for(int i=0; i < leftSize; i++){
				ArrayList<Integer> l = left.get(i);
				l.add(root.data);
				left.set(i, l);
			}
			
			int rightSize = right.size();
			for(int i=0; i < rightSize; i++){
				ArrayList<Integer> r = right.get(i);
				r.add(root.data);
				right.set(i, r);
			}
			all.addAll(left);
			all.addAll(right);
		}
		return all;
	}
	
	public static ArrayList<Integer> printNodesWithSum(TreeNode<Integer> root, int sum, ArrayList<Integer> list){
		if(root == null){
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(0);
			return l;
		}
		ArrayList<Integer> left = printNodesWithSum(root.left, sum, list);
		ArrayList<Integer> right = printNodesWithSum(root.right, sum, list);
		for(int l : left){
			for(int r : right){
				if((l+r+root.data)==sum){
					System.out.println(root.data);
				}
			}
		}
		for(int i=0; i < left.size(); i++){
			left.set(i, left.get(i)+root.data);
		}
		for(int i=0; i < right.size(); i++){
			right.set(i, right.get(i)+root.data);
		}
		ArrayList<Integer> all = new ArrayList<Integer>();
		all.addAll(left);
		all.addAll(right);
		return all;
	}
	
	public static void printAllPathsWithSum(TreeNode<Integer> root, int sum){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//printNodesWithSum(root, sum, list);
		printAllPathsWithSum(root, sum, list);
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		Integer arr[] = {3, 2, 4, 5, 2, 5, 8, 7, 8, 9, 10, 1, 4, 5, 6, 7, 3, 4, 5, 3, 7, 8};
		tree.createBinaryTree(arr);
		//tree.printTree();
		printAllPathsWithSum(tree.root, 40);
	}
}
