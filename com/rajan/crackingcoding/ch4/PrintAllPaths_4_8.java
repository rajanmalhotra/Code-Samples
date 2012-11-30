package com.rajan.crackingcoding.ch4;

public class PrintAllPaths_4_8{
	
	public static void main(String[] args){
		IntegerBST bst = new IntegerBST();
		int[] arr = {43, 12, 19, 74, 10, 8, 15, 90, 28, 13, 21, 30, 59, 49, 25};
		for(int i=0; i < arr.length; i++){
			bst.insert(arr[i]);		
		}
		System.out.println("Paths of this Tree are : ");
		bst.printAllPaths();
		System.out.println("Path with the sum = 225 is : ");
		bst.printAllRootPathsWithSum(225); 
		System.out.println("Path with the sum = 59 is : ");
		bst.findPathWithSum(59);
	}
}
