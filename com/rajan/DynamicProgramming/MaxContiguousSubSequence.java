package com.rajan.DynamicProgramming;

public class MaxContiguousSubSequence {
	
	public static int maxContiguousSum(int arr[]){
		int sum = 0;
		int max = 0;
		for(int i=0; i < arr.length; i++){
			sum = Math.max(sum + arr[i], arr[i]);
			if(sum > max){
				max = sum;
			}
		}
		return max;
	}
	
	public static int maxContiguousSum2(int arr[]){

		int sum[] = new int[arr.length];
		sum[0] = arr[0];
		for(int i=1; i < arr.length; i++){
			sum[i] = Math.max(sum[i-1] + arr[i], arr[i]);
		}
		int max=0;
		for(int i=0; i<sum.length; i++){
			if(sum[i] > max){
				max = sum[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int arr[] = {9, -2, 6, -12, 4, -8, 6, 18, -20, 10, -4, 9, -4};
		System.out.println("Max Sum is : " + maxContiguousSum(arr));
		System.out.println("Max Sum is : " + maxContiguousSum2(arr));
	}
}
