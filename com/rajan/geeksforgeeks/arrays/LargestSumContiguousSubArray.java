package com.rajan.geeksforgeeks.arrays;

/*
 * Problem 4:
 * Find the Largest sum of the contiguous subarray in an array
 */
class LargestSumContiguousSubArray {

	public int findLargestSumSubArray(int[] arr){
	
		int maxSum = 0;
		int overallMax = 0;
		
		for(int i=0; i < arr.length; i++){
			maxSum = Math.max(maxSum+arr[i], arr[i]);
			if(maxSum > overallMax){
				overallMax = maxSum;
			}
		}
		return overallMax;
	}
	
	public static void main(String[] args){
		LargestSumContiguousSubArray sum = new LargestSumContiguousSubArray();
		int arr[] = {-1, 3, -10, 0, 6, -2, 12, -4, 8, -2};
		System.out.println(sum.findLargestSumSubArray(arr));		
	}
}
