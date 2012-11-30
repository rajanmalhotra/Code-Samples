package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	TreeNode parent;
	
	public TreeNode(){
		this(0);
	}

	public TreeNode(int data){
		this.data = data;
		left = null;
		right = null;
		next = null;
		parent = null;
	}
}

public class Tree{

	public int getMaxHeight(TreeNode node){
		if(node==null){
			return 0;
		}
		return 1 + Math.max(getMaxHeight(node.left), getMaxHeight(node.right));
	}

	public int getMinHeight(TreeNode node){
		if(node==null){
			return 0;
		}
		return 1 + Math.min(getMinHeight(node.left), getMinHeight(node.right));
	}

	public boolean isBalanced(TreeNode node){
		return (getMaxHeight(node) - getMinHeight(node) <= 1);
	}

	public TreeNode createBinaryTreeWithMinimalHeight(int[] arr, int start, int end){
		if(start > end){
			return null;		
		}
		int mid = (start+end)/2;
		TreeNode newNode = new TreeNode(arr[mid]);
		newNode.left = createBinaryTreeWithMinimalHeight(arr, start, mid-1);
		newNode.right = createBinaryTreeWithMinimalHeight(arr, mid+1, end);
		return newNode;
	}

	public void createDLinkedLists(TreeNode root, int level, ArrayList<LinkedList<Integer>> lists){
		if(root==null){
			return;		
		}
		LinkedList<Integer> list;
		if(level >= lists.size()){
			list = new LinkedList<Integer>();
		}else{
			list = lists.get(level);		
		}
		list.add(root.data);
		lists.add(level, list);

		createDLinkedLists(root.left, level+1, lists);
		createDLinkedLists(root.right, level+1, lists);
	}

	public ArrayList<LinkedList<TreeNode>> createDLinkedListsItr(TreeNode root){
		if(root==null){
			return null;		
		}
		
		int level=0;
		ArrayList<LinkedList<TreeNode>> allLists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		allLists.add(level, list);

		while(true){
			list = allLists.get(level);
			LinkedList<TreeNode> newList = new LinkedList<TreeNode>();			
			for(int i=0; i < list.size(); i++){
				TreeNode node = list.get(i);
				if(node.left!=null){
					newList.add(node.left);
				}
				if(node.right!=null){
					newList.add(node.right);
				}
			}
			if(newList.size()==0){
				break;			
			}
			allLists.add(newList);
			level++;
		}
		return allLists;
	}

	public TreeNode findInOrderSuccessor(TreeNode root){
		if(root==null){
			return null;		
		}

		TreeNode temp = root;
		if(temp.right!=null){
			TreeNode current = temp.right;
			while(current.left!=null){
				current = current.left;			
			}
			return current;
		}else if(temp.parent!=null){
			while(temp.parent!=null){
				if(temp.parent.left!=temp){
					break;				
				}
				temp = temp.parent;			
			}
			return temp.parent;		
		}else{
			return null;		
		}
	}

	public int lowestCommonAncestor(TreeNode root, int a, int b){
		if(root==null){
			return 0;
		}
		
		int result = 0;
		if(root.data==a || root.data==b){
			result = 1 + lowestCommonAncestor(root.left, a, b) + lowestCommonAncestor(root.right, a, b);		
		}else{
			result = lowestCommonAncestor(root.left, a, b) + lowestCommonAncestor(root.right, a, b);
		}
		if(result == 2){
			System.out.println("Node with value " + root.data + 
						" is the lowest common Ancestor of " + a + " and " + b);
		}
		return result;		
	}

	public boolean matchTree(TreeNode bigTree, TreeNode smallTree){
		if(smallTree==null){
			return true;		
		}else if(bigTree==null && smallTree!=null){
			return false;		
		}
		if(bigTree.data==smallTree.data){
			return matchTree(bigTree.left, smallTree.left) &&
				matchTree(bigTree.right, smallTree.right);		
		}
		return false;
	}

	public boolean containsTree(TreeNode bigTree, TreeNode smallTree){
		if(smallTree == null){
			return true;		
		}else if(bigTree==null && smallTree!=null){
			return false;
		}
		boolean result=false;
		if(bigTree.data==smallTree.data){
			result = matchTree(bigTree, smallTree);
		}
		return result || containsTree(bigTree.left, smallTree) ||
					containsTree(bigTree.right, smallTree);
	}

	public void printPath(List<Integer> path, int index){
		for(int i=index; i < path.size(); i++){
			System.out.print(path.get(i) + " ");		
		}
		System.out.println();
	}

	public void printPathwithSum(List<Integer> path, int sum){
		if(path.size()==0){
			return;
		}
		
		for(int i=path.size()-1; i >= 0; i--){
			sum -= path.get(i);
			if(sum==0){
				printPath(path, i);
			}
		}
	}	

	public void sumOfAllPaths(TreeNode root, List<Integer> path, int sum){
		if(root==null){
			return;		
		}
	
		path.add(root.data);
		printPathwithSum(path, sum);
		sumOfAllPaths(root.left, path, sum);
		sumOfAllPaths(root.right, path, sum);	
		path.remove(root.data);	
	}

	public void sumOfAllPaths(TreeNode root, int sum){
		List<Integer> path = new ArrayList<Integer>();
		sumOfAllPaths(root, path, sum);
	}

	public static void main(String[] args){
	}
}

/*
	Import Statements
	Null Checks / Initializations
	Increments of Counters
	Return values	
 */
