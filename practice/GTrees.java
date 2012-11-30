package practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	
	public TreeNode(int val){
		data = val;
		left = null;
		right = null;
		next = null;	
	}
}

public class GTrees{

	public int sumOfPath(List<Integer> path){
		int sum=0;
		for(int i=0; i < path.size(); i++){
			sum += path.get(i);	
		}
		return sum;
	}

	public static int max=0;
	public static List<Integer> result = new ArrayList<Integer>();
	public void maxSumLeafRootPath(TreeNode root, List<Integer> path){
		if(root==null){
			return;
		}
		path.add(root.data);
		if(root.left==null && root.right==null){
			int sum = sumOfPath(path);
			if(sum > max){
				max = sum;
				result.clear();
				result.addAll(path);
			}
		}
		maxSumLeafRootPath(root.left, path);
		maxSumLeafRootPath(root.right, path);
		path.remove(root.data);
	}
	
	public void inOrder(TreeNode root, List<Integer> order){
		if(root==null){
			return;
		}
		inOrder(root.left, order);
		order.add(root.data);
		inOrder(root.right, order);
	}

	public void inOrderForBST(TreeNode root, List<Integer> order){
		if(root==null){
			return;		
		}
		inOrderForBST(root.left, order);
		root.data = order.get(0);
		order.remove(0);
		inOrderForBST(root.right, order);
	}

	public void binaryToBST(TreeNode root){
		List<Integer> order = new ArrayList<Integer>();
		inOrder(root, order);
		Collections.sort(order);
		inOrderForBST(root, order);		
	}
	
	public static TreeNode next = null;
	public void populateInOrderSuccessor(TreeNode root){
		if(root==null){
			return;		
		}
		populateInOrderSuccessor(root.right);
		root.next = next;
		next = root;
		populateInOrderSuccessor(root.right);
	}

	public static void main(String[] args){
	
	}
}
