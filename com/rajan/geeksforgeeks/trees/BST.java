package com.rajan.geeksforgeeks.trees;

import java.lang.Math;
import com.rajan.geeksforgeeks.stacks.Stack;

public class BST<T extends Comparable<T>>{
	public TreeNode<T> root;
	static int stat=1;
	public BST(){
		root = null;
	}

	public void insert(T val){
		TreeNode<T> tnode = new TreeNode<T>(val);
		if(root==null){
			root = tnode;
			return;
		}
		boolean flag = true;
		TreeNode<T> temp = root;
		while(temp!=null && flag){
			if(temp.data.compareTo(tnode.data)>0){
				if(temp.left!=null){				
					temp = temp.left;
				} else{
					temp.left = tnode;
					flag = false;
				}
			} else {
				if(temp.right!=null){
					temp = temp.right;			
				} else{
					temp.right = tnode;
					flag = false;
				}
			}
		}
	}

	private void inorder(TreeNode<T> node){
		if(node!=null){
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}

	public void inorder(){
		inorder(root);
	}

	public void preorder(TreeNode<T> node){
		if(node!=null){
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void postorder(TreeNode<T> node){
		if(node!=null){
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);		
		}	
	}

	// DFS will use stack 
	public void depthFirstSearch(){
		Stack<TreeNode<T>> nodeStack = new Stack<TreeNode<T>>();

		if(root!=null){
			nodeStack.push(root);
			System.out.println(root.data);
			TreeNode<T> topNode = root;
			while(!nodeStack.isEmpty()){
				if(topNode.left!=null){
					nodeStack.push(topNode.left);					
					System.out.println(topNode.data);
					topNode = topNode.left;
				} else if(topNode.right!=null){
					nodeStack.push(topNode.right);
					System.out.println(topNode.data);
					topNode = topNode.right;
				} else{
					try{
						nodeStack.pop();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		}
	}

	private int getHeight(TreeNode<T> node){
		if(node!=null){
			return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		}
		return 0;
	}

	public int getHeight(){
		return getHeight(root);
	}
	
	public void printWithInOrderSuccessor(TreeNode<T> node){
		if(node==null){
			return;
		}
		printWithInOrderSuccessor(node.left);
		System.out.print(node.data + " - InOrder Successor : ");
		if(node.next!=null){
			System.out.println(node.next.data);
		}else{
			System.out.println("null");
		}
		printWithInOrderSuccessor(node.right);
	}
	
	public void printWithInOrderSuccessor(){
		System.out.println("The Tree with InOrderSuccessor is : ");
		printWithInOrderSuccessor(this.root);
	}
}

