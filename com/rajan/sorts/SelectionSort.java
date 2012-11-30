package com.rajan.sorts;

public class SelectionSort {
	public void selectionSort(int[] arr){
		for(int i=0; i < arr.length-1; i++){
			int iSmallest = i;
			for(int j=i+1; j < arr.length; j++){
				if(arr[j] < arr[iSmallest]){
					iSmallest = j;
				}
			}
			if(i!=iSmallest){
				arr[i] = arr[i] + arr[iSmallest];
				arr[iSmallest] = arr[i] - arr[iSmallest];
				arr[i] = arr[i] - arr[iSmallest];
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {18, 47, 12, 17, 24, 35, 29, 30};
		SelectionSort sort = new SelectionSort();
		sort.selectionSort(arr);
		for(int val : arr){
			System.out.println(val);
		}
	}
}
