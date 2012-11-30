package com.rajan.crackingcoding.ch4;

import java.util.List;
import java.util.ArrayList;

public class IntegerBST extends BST<Integer>{
	
	private void printAllPaths(TreeNode<Integer> node, List<Integer> path){
		if(node==null){
			return;			
		}
		path.add(node.data);
		if(node.left==null && node.right==null){
			printPath(path, 0);
		} else{
			printAllPaths(node.left, path);
			printAllPaths(node.right, path);
		}
		path.remove(node.data);
	}
	
	public void printAllPaths(){
		List<Integer> path = new ArrayList<Integer>();
		printAllPaths(this.root, path);
	}

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

	private void printAllRootPathsWithSum(TreeNode<Integer> node, int sum, List<Integer> path){
		if(node==null){
			return;		
		}
		path.add(node.data);
		if(sum == findSumOfPath(path)){
			printPath(path, 0);
		}
		printAllRootPathsWithSum(node.left, sum, path);
		printAllRootPathsWithSum(node.right, sum, path);
		path.remove(node.data);
	}
	
	public void printAllRootPathsWithSum(int sum){
		List<Integer> path = new ArrayList<Integer>();
		printAllRootPathsWithSum(this.root, sum, path);
	}

	private void findPathWithSum(TreeNode<Integer> node, int sum, List<Integer> path){
		if(node==null){
			return;		
		}		
		path.add(node.data);		
		for(int i=path.size()-1 ; i>=0 ; i--){
		int sumPath = sum;
			sumPath -= path.get(i);
			if(sumPath==0){
				printPath(path, i);
			}
		}
		findPathWithSum(node.left, sum, path);
		findPathWithSum(node.right, sum, path);
		path.remove(node.data);		
	}

	public void findPathWithSum(int sum){
		List<Integer> path = new ArrayList<Integer>();		
		findPathWithSum(this.root, sum, path);
	}
}
