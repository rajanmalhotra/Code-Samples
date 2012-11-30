package com.rajan.DynamicProgramming;

public class LongestIncreasingSubSequence {

	/*
	 * LIS[i] = length of Longest Increasing SubSequence ending at position i.
	 * LIS[i] = { LIS[j] } + 1, maximum of all j, where j < i and arr[j] <= arr[i]
	 * Complexity : O(n^2), O(n log n) algorithm also exists
	 */
	
	public static int longestIncreasingSubSequence(int arr[]){
		int value = 0;
		int LIS[] = new int[arr.length];
		for(int i=0; i < LIS.length; i++){
			LIS[i] = 1;
		}
		
		LIS[0] = 1;
		for(int i=1; i < arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i] >= arr[j]){
					value = LIS[j] + 1;
				}
				if(value > LIS[i]){
					LIS[i] = value;
				}
			}
		}
		value = 0;
		for(int i=0; i < LIS.length; i++){
			if(LIS[i] > value){
				value = LIS[i];
			}
		}
		return value;
	}
	
	public static void main(String[] args){
		int arr[] = {22, 8, 19, 40, 32, 38, 46, 42, 60, 56, 40, 18};
		System.out.println(longestIncreasingSubSequence(arr));
	}
}
