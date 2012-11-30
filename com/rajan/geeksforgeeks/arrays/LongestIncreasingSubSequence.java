package com.rajan.geeksforgeeks.arrays;

/*
 * Problem 1:
 * Dynamic Programming | Set 3 (Longest Increasing Subsequence)
 * http://www.geeksforgeeks.org/archives/12832
 * We have discussed Overlapping Subproblems and Optimal Substructure properties in Set 1 and Set 2 
 * respectively. Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that 
 * can be solved using Dynamic Programming. The longest Increasing Subsequence (LIS) problem is to find 
 * the length of the longest subsequence of a given sequence such that all elements of the subsequence 
 * are sorted in increasing order. For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } 
 * is 6 and LIS is {10, 22, 33, 50, 60, 80}. 
 */

public class LongestIncreasingSubSequence {
	public int longestIncreasingSubSequence(int[] arr){
		int[] LIS = new int[arr.length];
		int maxn=0;
		LIS[0] = 1;
		for(int i=1; i < arr.length; i++){
			maxn=0;
			for(int j=0; j<i ; j++){
				if(arr[j] < arr[i] && LIS[j]>maxn){
					maxn = LIS[j];				
				}
			}
			LIS[i] = maxn+1;
		}
		int maxi=0;
		for(int i=0; i < arr.length; i++){
			if(LIS[i]>maxi){
				maxi = LIS[i];			
			}
		}
		return maxi;
	}
	
	public static void main(String[] args){
		LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
		int[] arr = {10, 30, 12, 18, 22, 98, 67, 53, 39};
		System.out.println(lis.longestIncreasingSubSequence(arr));
	}
}
