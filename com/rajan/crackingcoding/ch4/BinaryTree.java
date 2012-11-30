package com.rajan.crackingcoding.ch4;

public class BinaryTree{

	protected TreeNode<Integer> root;

	public BinaryTree(){
		root = null;
	}

	private TreeNode<Integer> createBinaryTree(int[] arr, int index){
		int size = arr.length;
		TreeNode<Integer> t = null;	
		if(index < size){			
			t = new TreeNode<Integer>(arr[index]);
			t.left = createBinaryTree(arr, 2*index+1);
			t.right = createBinaryTree(arr, 2*index+2);
		}
		return t;
	}

	public void createBinaryTree(int[] arr){
		root = createBinaryTree(arr, 0);	
	}

	private void printTree(TreeNode<Integer> node){
		if(node!=null){
			printTree(node.left);
			System.out.println(node.data);
			printTree(node.right);
		}
	}
	
	public void printTree(){
		printTree(root);
	}

	/* Still working on the solution of findLargestBST */
	private boolean findLargestBST(TreeNode<Integer> node){
		if(node.left!=null && node.data < node.left.data){
			return false;
		}
		if(node.right!=null && node.data > node.right.data){
			return false;
		}
		return findLargestBST(node.left);
	}

	public TreeNode<Integer> findLargestBST(){
		findLargestBST(root);
		return root;
	}

	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		int[] arr = {45, 20, 23, 6, 28, 87, 56, 78, 48, 12, 1, 8, 34, 89, 19};
		bt.createBinaryTree(arr);
		bt.printTree();
		TreeNode<Integer> tree = bt.findLargestBST();
		System.out.println("Largest BST is at : " + tree.data);
	}
}
