package com.rajan.sorts;

public class QuickSort {

	public void partition(int[] arr, int start, int end){
		if(start>=end){
			return;
		}
		int i = start;
		int j = end;
		int pivot = arr[end];
		while(i<j){
			while(arr[i] < pivot){
				i++;
			}
			while(arr[j] > pivot){
				j--;
			}
			if(i!=j){
				arr[i] = arr[i] + arr[j];
				arr[j] = arr[i] - arr[j];
				arr[i] = arr[i] - arr[j];
			}
		}
		partition(arr, start, i-1);
		partition(arr, i+1, end);
	}
	
	public static void main(String[] args){
		int[] arr = {18, 47, 12, 100, 28, 58, 45, 22, 87, 17, 24, 35, 29, 30};
		QuickSort q = new QuickSort();
		q.partition(arr, 0, arr.length-1);
		for(int val : arr){
			System.out.print(val + " ");
		}
	}
}
