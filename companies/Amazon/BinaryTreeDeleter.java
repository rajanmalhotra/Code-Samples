package companies.Amazon;

import com.rajan.geeksforgeeks.trees.*;

public class BinaryTreeDeleter{
	public void deleteBinaryTree(TreeNode<Integer> root){
		if(root==null){
			return;
		}
		deleteBinaryTree(root.left);
		if(root.left!=null){
			System.out.print(root.left.data + " -> ");
		}
		root.left = null;
		deleteBinaryTree(root.right);
		if(root.right!=null){
			System.out.print(root.right.data + " -> ");
		}
		root.right = null;
	}

	public static void main(String[] args){
		BinaryTreeDeleter btd = new BinaryTreeDeleter();
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		bt.createBinaryTree(arr);
		bt.postOrder();
		System.out.println("\nDeleting the Tree");
		btd.deleteBinaryTree(bt.root);
	}
}

