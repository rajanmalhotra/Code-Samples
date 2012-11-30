/*Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in
   a binary search tree where each node has a link to its parent. */

package com.rajan.crackingcoding.ch4;

import java.lang.Math;

class ParentNode<T>{
	T data;
	ParentNode<T> left;
	ParentNode<T> right;
	ParentNode<T> parent;

	public ParentNode(T val){
		data = val;
		left = null;
		right = null;
		parent = null;
	}
}

class ParentTree<T extends Comparable<T>>{
	ParentNode<T> root;
	
	public ParentTree(){
		root = null;	
	}

	public void insert(T val){
		ParentNode<T> node = new ParentNode<T>(val);
		if(root==null){
			root = node;
			return;
		}
		boolean flag = true;
		ParentNode<T> temp = root;		
		while(flag){
			if(temp.data.compareTo(node.data)>0){
				if(temp.left!=null){		
					temp = temp.left;
				} else{
					temp.left = node;
					node.parent = temp;
					flag = false;
				}
			}else{
				if(temp.right!=null){
					temp = temp.right;
				} else{
					temp.right = node;
					node.parent = temp;
					flag = false;
				}
			}
		}
	}

	public ParentNode<T> findInOrderSuccessor(ParentNode<T> node){
		if(node == null){
			return null;
		}		
		
		ParentNode<T> temp = node;		
		if(temp.right!=null){
			// successor is on the right side. LeftMostChild
			temp = temp.right;			
			while(temp.left!=null){
				temp = temp.left;
			}
			return temp;
		}else{
			// Parent is the inorder successor, such that child is in left subtree
			while(temp.parent != null && temp.parent.left!=temp){
				temp = temp.parent;
			}
			return temp.parent;		
		}		
	}

	private void inorder(ParentNode<T> node){
		if(node!=null){
			inorder(node.left);
			System.out.print(node.data);
			if(node!=root){
				System.out.println(" -> " + node.parent.data);
			} else{
				System.out.println();
			}
			inorder(node.right);
			}
	}

	public void inorder(){
		inorder(root);	
	}

	public ParentNode<T> pickRandomNode(){
		ParentNode<T> temp = root;
		ParentNode<T> prev = null;
		double d=0.0;
		
		while(temp!=null){
			prev = temp;
			d = Math.random();
			if(d > 0.5){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		return prev;
	}
}

public class InOrderSuccessorFinder_4_5{	
	public static void main(String[] args){
		ParentTree<Integer> pt = new ParentTree<Integer>();
		int[] arr = {3, 5, 90, 43, 29, 9, 78, 21, 30, 59};
		for(int i=0; i < arr.length; i++){
			pt.insert(arr[i]);	
		}
		pt.inorder();
		ParentNode<Integer> node = pt.pickRandomNode();
		System.out.println("The node is : " + node.data);
		ParentNode<Integer> succ = pt.findInOrderSuccessor(node);
		if(succ!=null){			
			System.out.println("The Inorder Successor is : " + succ.data);
		}else{
			System.out.println("No Inorder Successor");
		}
	}
}

