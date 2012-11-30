package com.rajan.geeksforgeeks.trees;

import java.util.Stack;

public class BinaryTree<T>{

	public TreeNode<T> root;

	public BinaryTree(){
		root = null;
	}

	private TreeNode<T> createBinaryTree(T[] arr, int index){
		int size = arr.length;
		TreeNode<T> t = null;	
		if(index < size){			
			t = new TreeNode<T>(arr[index]);
			t.left = createBinaryTree(arr, 2*index+1);
			t.right = createBinaryTree(arr, 2*index+2);
		}
		return t;
	}

	public void createBinaryTree(T[] arr){
		root = createBinaryTree(arr, 0);	
	}
	
	public void printTree(TreeNode<T> node){
		/* PreOrder For Printing the Tree */
		if(node!=null){			
			System.out.println(node.data);
			printTree(node.left);
			printTree(node.right);
		}
	}
	
	public void printTree(){
		System.out.println("Printing tree as PreOrder Traversal : ");
		printTree(root);
	}

	public void preOrder(TreeNode<T> node){
		/* preOrder For Printing the Tree */
		if(node!=null){			
			System.out.print(node.data + " -> ");
			preOrder(node.left);			
			preOrder(node.right);
		}
	}

	public void preOrder(){
		System.out.println("The preOrder Traversal of the Tree is : ");
		preOrder(root);
	}

	public void inOrder(TreeNode<T> node){
		/* inOrder For Printing the Tree */
		if(node!=null){			
			inOrder(node.left);
			System.out.print(node.data + " -> ");
			inOrder(node.right);
		}
	}
	
	public void inOrder(){
		System.out.println("The InOrder Traversal of the Tree is : ");
		inOrder(root);
	}

	public void postOrder(TreeNode<T> node){
		/* postOrder For Printing the Tree */
		if(node!=null){			
			postOrder(node.left);			
			postOrder(node.right);
			System.out.print(node.data + " -> ");
		}
	}
	
	public void postOrder(){
		System.out.println("The PostOrder Traversal of the Tree is : ");
		postOrder(root);
	}

	public void inOrderIter(){
		TreeNode<T> current = root;
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		System.out.println("\nThe InOrderIter Traversal of the Tree is : ");
		
		while(true){
			if(current!=null){
				s.push(current);
				current = current.left;
			}else{
				if(s.isEmpty()){
					break; //done
				}else{
					current = s.pop();
					System.out.print(current.data + " -> ");
					current = current.right;
				}
			}
		}
	}
	
	public void preOrderIter(){
		TreeNode<T> current = root;
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		System.out.println("\nThe preOrderIter Traversal of the Tree is : ");
		s.push(current);
		
		while(!s.isEmpty()){
			current = s.pop();
			System.out.print(current.data + " -> ");
			if(current.right!=null){
				s.push(current.right);
			}
			if(current.left!=null){
				s.push(current.left);
			}
		}
	}
	
	public void postOrderIter(){
		TreeNode<T> current = root;
		TreeNode<T> prev = null;
		Stack<TreeNode<T>> s = new Stack<TreeNode<T>>();
		s.push(current);
		System.out.println("\nThe PostOrderIter Traversal of the Tree is :");
		
		while(!s.isEmpty()){
			current = s.peek();	
			// going down
			if(prev==null || prev.left==current || prev.right==current){
				if(current.left!=null){
					s.push(current.left);
				}else if(current.right!=null){
					s.push(current.right);
				}else{
					System.out.print(current.data + " -> ");
					s.pop();
				}
			}
			// going up
			else if(current.left==prev){
				if(current.right!=null){
					s.push(current.right);
				}else{
					System.out.print(current.data + " -> ");
					s.pop();
				}
			}
			else if(current.right==prev){
				System.out.print(current.data + " -> ");
				s.pop();
			}
			prev = current;
		}
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		Integer[] arr = {20, 18, 24, 12, 19, 22, 26, 21, 23};
		bt.createBinaryTree(arr);
		bt.postOrder();
		bt.postOrderIter();
	}
}
