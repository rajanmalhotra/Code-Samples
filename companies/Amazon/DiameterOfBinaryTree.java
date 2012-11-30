package companies.Amazon;

import com.rajan.geeksforgeeks.trees.*;

class Result{
	int max;
}

public class DiameterOfBinaryTree {
	
	public int findDiameter(TreeNode<Integer> node, Result res){
		if(node==null){
			return 0;
		}
		int left = findDiameter(node.left, res);
		int right = findDiameter(node.right, res);
		if(res==null){
			res = new Result();
			res.max = left + right + 1;
		}else if((left + right + 1) > res.max){
			res.max = left + right + 1;
		}		
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		bt.createBinaryTree(arr);
		DiameterOfBinaryTree d = new DiameterOfBinaryTree();
		Result res = new Result();
		BinaryTree<Integer> btree = new BinaryTree<Integer>();
		btree.root = new TreeNode<Integer>(1);
		btree.root.left = new TreeNode<Integer>(2);
		btree.root.right = new TreeNode<Integer>(3);
		btree.root.left.left = new TreeNode<Integer>(4);
		btree.root.left.right = new TreeNode<Integer>(5);
		btree.root.left.left.left = new TreeNode<Integer>(6);
		btree.root.left.left.right = new TreeNode<Integer>(7);
		btree.root.left.right.left = new TreeNode<Integer>(8);
		btree.root.left.right.left.right = new TreeNode<Integer>(9);
		btree.root.left.left.right.left = new TreeNode<Integer>(10);
		btree.root.left.left.right.right = new TreeNode<Integer>(11);
		d.findDiameter(btree.root, res);
		System.out.println("Diameter of the tree is : " + res.max);
	}
}
