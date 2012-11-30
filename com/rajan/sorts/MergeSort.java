package com.rajan.sorts;

public class MergeSort {
	public void merge(int[] arr, int start, int mid, int end){		
		int i=start;
		int j=mid+1;
		int k=0;
		int[] result = new int[end-start+1];
		while(i <= mid && j <= end){
			if(arr[i] < arr[j]){
				result[k++] = arr[i++];
			}else{
				result[k++] = arr[j++];
			}
		}
		while(i <= mid){
			result[k++] = arr[i++];
		}
		while(j <= end){
			result[k++] = arr[j++];
		}
		for(i=0; i < result.length; i++){
            arr[i+start] = result[i];
		}
	}
	
	public void mergeSort(int[] arr, int start, int end){
		if(end-start < 1){
			return;
		}
		int mid = (start+end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr, start, mid, end);
	}
	
	public static void main(String[] args){
		int[] arr = {10, 8, 12, 18, 29, 13, 17, 25, 45, 34};
		MergeSort sort = new MergeSort();
		sort.mergeSort(arr, 0, arr.length-1);
		for(int val : arr){
			System.out.println(val);
		}
	}
}
