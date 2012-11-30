package com.rajan.sorts;

public class InsertionSort {

	public static void main(String[] args){
		int[] arr = {8, 7, 6, 5, 4, 3, 2};
		int i, j;
		for(i=1; i < arr.length; i++){
			int key = arr[i];
			j = i;
			while(j > 0 && arr[j-1] > key){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = key;
		}
		for(int val : arr){
			System.out.println(val);
		}
	}
}
