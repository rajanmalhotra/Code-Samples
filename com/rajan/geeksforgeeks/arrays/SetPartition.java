package com.rajan.geeksforgeeks.arrays;


/*
 * Problem 5:
 * Dynamic Programming | Set 18 (Partition problem)
 * http://www.geeksforgeeks.org/archives/21579
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 * such that the sum of elements in both subsets is same. 
 */

public class SetPartition {

	/* Recursive Solution */
	public boolean isSubsetSum(int[] arr, int n, int sum){
		if(sum==0){
			return true;
		}
		if(n==0 && sum!=0){
			return false;
		}
		
		return isSubsetSum(arr, n-1, sum) || isSubsetSum(arr, n-1, sum-arr[n-1]);		
	}
	
	public boolean findPartition(int[] arr){
		int sum = 0;
		for(int val:arr){
			sum += val;
		}
		
		if(sum%2!=0){
			return false;
		}
		
		return isSubsetSum(arr, arr.length, sum/2);
	}
	
	/* Iterative Solution - works only for all +ve integers */
	public boolean findPartitionIter(int[] arr){
		int sum = 0;
		int len = arr.length;
		for(int val:arr){
			sum += val;
		}		
		if(sum%2!=0){
		 	return false;
		}
		
		/* create an array of Sum/2+1 x len+1 */
		boolean[][] sumTable = new boolean[sum/2 + 1][len+1];
		
		/* initializations */
		for(int i=0; i<=len; i++){
			sumTable[0][i] = true;
		}
		for(int i=1; i<=sum/2; i++){
			sumTable[i][0] = false;
		}
		
		/* Fill the table */
		for(int i=1; i<=sum/2; i++){
			for(int j=1; j <=len; j++){
				sumTable[i][j] = sumTable[i][j-1];
				if(i >= arr[j-1]){
					sumTable[i][j] = sumTable[i][j] || sumTable[i - arr[j-1]][j-1];
				}
			}
		}
		
		return sumTable[sum/2][len];
	}
	
	public static void main(String[] args){
		int arr[] = {-1, 3, -10, 6, -2, 12, -4, 8, 10};
		int arr1[] = {1, 3, 10, 6, 2, 12, 4, 8, 10};
		SetPartition set = new SetPartition();
		System.out.println(set.findPartition(arr));
		System.out.println(set.findPartitionIter(arr1));
	}
}
