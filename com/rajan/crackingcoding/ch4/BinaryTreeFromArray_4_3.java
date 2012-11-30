package com.rajan.crackingcoding.ch4;

//import

public class BinaryTreeFromArray_4_3{

	private static int stat = 1;

	public BinaryTreeFromArray_4_3(){
	}

	public void inorder(TreeNode<Integer> node){
		if(node!=null){
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}

	public TreeNode<Integer> createTreeFromArray(int[] arr, int start, int end){
		int size = end - start + 1;
		if(size > 0){
			stat++;
			int mid = start + size/2;
			System.out.println(stat + " " + arr[mid]);
			TreeNode<Integer> tnode = new TreeNode<Integer>(arr[mid]);
			tnode.left = createTreeFromArray(arr, start, mid-1);
			tnode.right = createTreeFromArray(arr, mid+1, end);
			return tnode;
		}
		return null;
	}
	
	public static void main(String[] args){
		int[] arr = {2, 4, 5, 8, 12, 14, 19, 24, 29, 41, 48, 50, 62, 70};
		BinaryTreeFromArray_4_3 bt = new BinaryTreeFromArray_4_3();
		TreeNode<Integer> root = bt.createTreeFromArray(arr, 0, arr.length-1);
		bt.inorder(root);
	}
}
