package com.rajan.geeksforgeeks.arrays;

/*
 * Problem 3:
 * Maximum Product Subarray
 * Given an array that contains both positive and negative integers, find the product of the 
 * maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.
 */

public class MaxProdSubArray {

	public int findMaxProdSubArray(int[] arr){
		int overallMax=0;
		int maxProd = 1;
		int minProd = 1;
		
		for(int i=0; i < arr.length; i++){
			if(arr[i] > 0){
				maxProd = maxProd*arr[i];
				minProd = minProd*arr[i];			
			} else if(arr[i] < 0){
				int temp = maxProd;
				maxProd = Math.max(minProd*arr[i], 1);
				minProd = temp*arr[i];
			} else {
				maxProd = 1;
				minProd = 1;
			}
			if(maxProd > overallMax){
				overallMax = maxProd;			
			}
		}
		return overallMax;
	}
	
	public static void main(String[] args){
		MaxProdSubArray m = new MaxProdSubArray();
		int arr[] = {-1, 3, -10, 0, 6, -2, 12, -4, -5, 20};
		System.out.println(m.findMaxProdSubArray(arr));
	}
}
