package com.rajan.crackingcoding.ch4;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import com.rajan.crackingcoding.ch2.*;

public class BST<T extends Comparable<T>>{
	public TreeNode<T> root;
	static int stat=1;
	public BST(){
		root = null;
	}

	public void insert(T val){
		int hashCode = val.hashCode();
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
					nodeStack.pop();				
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

	private boolean isBalanced(TreeNode<T> node){
		if(node!=null){
			if(Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1){
				return true;
			} else {
				return false;			
			}
		}
		return true;
	}

	public boolean isBalanced(){
		return isBalanced(root);
	}

	private void createLinkedLists(TreeNode<T> node, int level, List<LinkedList<T>> allLists){

		if(node==null){
			return;		
		}

		if(allLists.size() <= level){
			LinkedList<T> ll = new LinkedList<T>();
			ll.append(node.data);
			allLists.add(ll);
		}else{
			allLists.get(level).append(node.data);
		}

		createLinkedLists(node.left, level+1, allLists);
		createLinkedLists(node.right, level+1, allLists);
	}

	public List<LinkedList<T>> createLinkedLists(){
		List<LinkedList<T>> allLists  = new ArrayList<LinkedList<T>>();
		createLinkedLists(root, 0, allLists);
		return allLists;
	}

	private int findLowestCommonAncestor(TreeNode<T> node, T val1, T val2){
		if(node==null){
			return 0;		
		}

		int result;
		if(node.data==val1 || node.data==val2){
			result = 1 + findLowestCommonAncestor(node.left, val1, val2) + findLowestCommonAncestor(node.right, val1, val2);		
		}else{
			result = 0 + findLowestCommonAncestor(node.left, val1, val2) + findLowestCommonAncestor(node.right, val1, val2);	
		}
		if(result==2){
			System.out.println("Node with value " + node.data + " is the lowest common Ancestor of " + val1 + " and " + val2);
			return 0;
		}
		return result;
	}

	public void findLowestCommonAncestor(T val1, T val2){
		findLowestCommonAncestor(root, val1, val2);
	}

	private boolean matchSubTree(TreeNode<T> node1, TreeNode<T> node2){
		if(node2==null){
			return true;	
		}else if(node1==null && node2!=null){
			return false;
		}else if(node1.data==node2.data){
			return matchSubTree(node1.left, node2.left) && 
			matchSubTree(node1.right, node2.right);
		}
		return false;
	}

	private boolean containsSubTree(TreeNode<T> node1, TreeNode<T> node2){
		if(node2==null){
			return true;	
		}else if(node1==null && node2!=null){
			return false;
		}

		if(node1.data==node2.data){
			if(matchSubTree(node1, node2)){
				return true;
			}
		}
		return containsSubTree(node1.left, node2) || containsSubTree(node1.right, node2);		
	}

	public boolean containsSubTree(BST<T> T2){
		return containsSubTree(this.root, T2.root);
	}
}

