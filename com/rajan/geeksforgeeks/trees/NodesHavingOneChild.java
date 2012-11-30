package com.rajan.geeksforgeeks.trees;

/* Check if each internal node of a BST has exactly one child 
 * Given Preorder traversal of a BST, check if each non-leaf node has only one child. 
 * Assume that the BST contains unique entries.
 */

public class NodesHavingOneChild extends BST<Integer>{
	
	/* Check if the structure of the tree is available */
	private boolean hasOnlyOneChild(TreeNode<Integer> root){
		if(root == null){
			return true;
		}

		if(root.left==null){
			return hasOnlyOneChild(root.right);		
		}else if(root.right==null){
			return hasOnlyOneChild(root.left);		
		}else{
			return false;		
		}
	}
	
	public boolean hasOnlyOneChild(){
		return hasOnlyOneChild(root);
	}	
	
	/* Check if the PreOrder Traversal of the tree is available */
	public boolean hasOnlyOneChildUsingPreOrder(int arr[]){
	    int nextDiff, lastDiff;
	    int size = arr.length;
	    for(int i=0; i<size-1; i++){
	        nextDiff = arr[i] - arr[i+1];
	        lastDiff = arr[i] - arr[size-1];
	        if(nextDiff*lastDiff < 0)
	            return false;;
	    }
	    
	    for( int i=0; i<size-1; i++ ){
	        if(arr[i] > arr[i+1] && arr[i] < arr[size-1] ){
	            return false;
	        }
	        if(arr[i] < arr[i+1] && arr[i] > arr[size-1] ){
	            return false;
	        }
	    }
	    return true;	    
	}
	
	public static void main(String[] args){
		NodesHavingOneChild n = new NodesHavingOneChild();
		int arr[] = {20, 18, 16, 11, 13, 12}; //{8, 3, 5, 7, 6};
		for(int val : arr){
			n.insert(val);
		}
		System.out.println("Each node of a BST has one child : " + n.hasOnlyOneChild());
		System.out.println("Each node of a BST has one child : " + n.hasOnlyOneChildUsingPreOrder(arr));
	}	
}
