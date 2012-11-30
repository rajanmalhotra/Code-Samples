package com.rajan.DynamicProgramming;

public class ZigZagSequence {

		public static int longestZigZag(int[] arr){
			int value = 0;
			int len[] = new int[arr.length];
			for(int i=0; i < len.length; i++){
				len[i] = 1;
			}
			
			len[0] = 1;
			for(int i=1; i < arr.length; i++){
				for(int j=0; j<i; j++){
					if(arr[i] >= arr[j]){
						value = len[j] + 1;
					}
					if(value > len[i]){
						len[i] = value;
					}
				}
			}
			value = 0;
			for(int i=0; i < len.length; i++){
				if(len[i] > value){
					value = len[i];
				}
			}
			return value;
		}
		
		public static void main(String[] args){
			int arr[] = {22, 8, 19, 40, 32, 38, 46, 42, 60, 56, 40, 18};
			System.out.println(longestZigZag(arr));
		}
	}
