package com.rajan.DynamicProgramming;

/*
 * Building Bridges. Consider a 2-D map with a horizontal river passing through its center. 
 * There are n cities on the southern bank with x-coordinates a(1) ... a(n) and n cities on the northern bank 
 * with x-coordinates b(1) ... b(n). You want to connect as many north-south pairs of cities as possible 
 * with bridges such that no two bridges cross. When connecting cities, you can only connect city i on the 
 * northern bank to city i on the southern bank.
 * 
 * Solution: This problem looks similar to Longest Common SubSequence problem.
 * or similar to Longest Increasing SubSequence problem.
 */

public class BridgesBuilder {
	
	public static int buildBridges(int[] arr1, int[] arr2){
		
		int[][] LCS = new int[arr1.length+1][arr2.length+1];
		for(int i=0; i <= arr1.length; i++){
			LCS[i][0] = 0;
		}
		for(int i=0; i <= arr2.length; i++){
			LCS[0][i] = 0;
		}
		for(int i=0; i < arr1.length; i++){
			for(int j=0; j<arr2.length; j++){
				if(arr1[i]==arr2[j]){
					LCS[i+1][j+1] = LCS[i][j] + 1;
				}else{
					LCS[i+1][j+1] = Math.max(LCS[i][j+1], LCS[i+1][j]);
				}
			}
		}
		return LCS[arr1.length][arr2.length];
	}
	
	public static void main(String[] args){
		int arr1[] = { 1, 3, 6, 2, 5, 4, 7};
		int arr2[] = { 7, 1, 3, 2, 6, 4, 5};
		System.out.println(buildBridges(arr1, arr2));
	}
}
